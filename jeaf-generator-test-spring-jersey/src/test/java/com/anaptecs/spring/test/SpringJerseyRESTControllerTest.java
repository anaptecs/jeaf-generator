/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.impl.SpringTestApplication;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJerseyRESTControllerTest {
  @Inject
  private TestRestTemplate template;

  @Inject
  // private RESTProductService restProductService;

  private static ClientAndServer mockServer;

  public static final int MOCK_PORT = 8099;

  @BeforeAll
  static void startMockServer( ) throws IOException {
    mockServer = ClientAndServer.startClientAndServer(MOCK_PORT);
    assertEquals(true, mockServer.isRunning());

    // Add mock responses
    @SuppressWarnings("resource")
    MockServerClient lClient = new MockServerClient("localhost", MOCK_PORT);

    lClient.when(mockRequest("/rest-products", "GET"))
        .respond(mockResponse("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]"));

    lClient.when(mockRequest("/rest-products", "POST")).respond(mockResponse("true"));

    lClient.when(mockRequest("/rest-products/4711")).respond(mockResponse(null));

    lClient.when(mockRequest("/rest-products/12345"))
        .respond(mockResponse("{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}"));

    HttpRequest lRequest = mockRequest("/rest-products/sortiment/4711").withQueryStringParameter("q1", "QUERY_ME")
        .withHeader("token", "12345").withHeader("lang", "de").withCookie("reseller", "47110815");
    lClient.when(lRequest).respond(mockResponse(null));

    lClient.when(mockRequest("/rest-products/currencies/0815")).respond(mockResponse("[\"EUR\", \"CHF\"]"));

    lClient.when(mockRequest("/rest-products/async-currencies/0815"))
        .respond(mockResponse("[\"EUR\", \"CHF\", \"USD\"]", 200, 1));

    lClient.when(mockRequest("/rest-products/test-init")).respond(mockResponse(null));

    lClient.when(mockRequest("/rest-products/ChannelCode", "POST").withBody("\"MyMobile\""))
        .respond(mockResponse("\"MyMobile\""));

    lClient
        .when(mockRequest("/rest-products/test-params").withQueryStringParameter("locale", "de_DE")
            .withCookie("giveMeMoreCookies", "9999").withHeader("Big-Header", "3.1423"))
        .respond(mockResponse("\"Hello World of REST!\""));

    lClient.when(mockRequest("/rest-products/666")).respond(mockResponse("Invalid product number", 404, 0));

    lClient.when(mockRequest("/rest-products/777"))
        .respond(
            mockResponse(
                "{\r\n" + "  \"type\": \"https://example.org/out-of-stock\",\r\n" + "  \"title\": \"Out of Stock\",\r\n"
                    + "  \"status\": 400,\r\n" + "  \"detail\": \"Item B00027Y5QG is no longer available\"\r\n}",
                400, 0).withContentType(MediaType.parse("application/problem+json")));

    lClient.when(mockRequest("/rest-products/json-problem")).respond(
        mockResponse("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]", 200, 0));

    lClient.when(mockRequest("/rest-products/timeout")).respond(mockResponse(null, 200, 500));

    lClient.when(mockRequest("/rest-products/test-enum-params/COUNTER").withQueryStringParameter("timeUnit", "MINUTE")
        .withQueryStringParameter("extensibleEnum", "BLUE")).respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-enum-params/COUNTER").withQueryStringParameter("timeUnit", "MINUTE")
        .withQueryStringParameter("extensibleEnum", "VERY PINK")).respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-enum-params/MOBILE").withQueryStringParameter("extensibleEnum"))
        .respond(mockResponse("Hello", 500, 0));

    lClient.when(mockRequest("/rest-products/test-enum-params/MOBILE")).respond(mockResponse("Hello", 200, 0));

    lClient
        .when(mockRequest("/rest-products/test-enum-header-params").withHeader("Channel-Type", "COUNTER")
            .withHeader("Time-Unit", "MINUTE").withHeader("Extensible-Enum", "BLUE"))
        .respond(mockResponse(null, 200, 0));

    lClient
        .when(mockRequest("/rest-products/test-enum-header-params").withHeader("Channel-Type", "COUNTER")
            .withHeader("Time-Unit", "MINUTE").withHeader("Extensible-Enum", "VERY PINK"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-enum-header-params").withHeader("Channel-Type", "MOBILE")
        .withHeader("Time-Unit", "").withHeader("Extensible-Enum", "")).respond(mockResponse(null, 200, 0));

    // test-date-query-params
    lClient.when(mockRequest("/rest-products/test-date-query-params/1")
        .withQueryStringParameter("startTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("startTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localStartTimestamp", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localStartTime", "13:22:12.453")
        .withQueryStringParameter("localStartDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params/2")
        .withQueryStringParameter("startTimestamp", "2022-03-17T13:22:12+01:00")
        .withQueryStringParameter("startTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localStartTimestamp", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localStartTime", "13:22:12.453")
        .withQueryStringParameter("localStartDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params/3")
        .withQueryStringParameter("startTimestamp", "2022-03-17T13:22:00+01:00")
        .withQueryStringParameter("startTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localStartTimestamp", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localStartTime", "13:22:12.453")
        .withQueryStringParameter("localStartDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params/4")).respond(mockResponse(null, 200, 0));

    // test-date-query-params-beans
    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/1")
        .withQueryStringParameter("offsetDateTime", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("offsetTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localDateTime", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localTime", "13:22:12.453")
        .withQueryStringParameter("localDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/2")
        .withQueryStringParameter("offsetDateTime", "2022-03-17T13:22:12+01:00")
        .withQueryStringParameter("offsetTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localDateTime", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localTime", "13:22:12.453")
        .withQueryStringParameter("localDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/3")
        .withQueryStringParameter("offsetDateTime", "2022-03-17T13:22:00+01:00")
        .withQueryStringParameter("offsetTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localDateTime", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localTime", "13:22:12.453")
        .withQueryStringParameter("localDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00")
        .withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/4")).respond(mockResponse(null, 200, 0));

    // test-date-header-params
    lClient.when(mockRequest("/rest-products/test-date-header-params/1")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params/2")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params/3")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:00+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params/4")).respond(mockResponse(null, 200, 0));

    // test-date-header-params-beans
    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/1")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/2")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/3")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:00+01:00")
        .withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453")
        .withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17")
        .withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/4")).respond(mockResponse(null, 200, 0));
  }

  @AfterAll
  static void stopMockServer( ) {
    if (mockServer != null) {
      mockServer.stop();
    }
  }

  private static HttpRequest mockRequest( String pRequestURI, String pMethod ) {
    return HttpRequest.request().withPath(pRequestURI).withMethod(pMethod);
  }

  private static HttpRequest mockRequest( String pRequestURI ) {
    return HttpRequest.request().withPath(pRequestURI);
  }

  private static HttpResponse mockResponse( String pResponseBody ) {
    return HttpResponse.response().withDelay(TimeUnit.MILLISECONDS, 0).withStatusCode(200).withBody(pResponseBody);
  }

  private static HttpResponse mockResponse( String pResponseBody, int pStatusCode, int pDelay ) {
    return HttpResponse.response().withDelay(TimeUnit.MILLISECONDS, pDelay).withStatusCode(pStatusCode)
        .withBody(pResponseBody);
  }

  @Test
  void testRESTControllerAccess( ) throws IOException {
    ResponseEntity<String> lResponse = template.getForEntity("/rest-products", String.class);
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        lResponse.getBody());
  }

  @Test
  void testAdvancedRESTControllerFeatures( ) throws Exception {
    // Execute simple request using Apache HTTP client
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();

    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    // Execute advanced request

    //
    // getProduct(...)
    //
    ClassicRequestBuilder lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/rest-products/17");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(500, lResponse.getCode());

    //
    // getProduct(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/rest-products/4711");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    //
    // getSortiment(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/rest-products/sortiment/4711");
    lBuilder.addHeader("token", "12345");
    lBuilder.addHeader("lang", "DE");
    lBuilder.addParameter("q1", "QUERY_ME");
    lRequest = lBuilder.build();

    // Set request specific cookies
    BasicClientCookie lCookie = new BasicClientCookie("reseller", "47110815");
    lCookie.setDomain("localhost");
    lCookie.setPath("/");
    BasicCookieStore lCookieStore = new BasicCookieStore();
    lCookieStore.addCookie(lCookie);
    HttpContext lLocalContext = new BasicHttpContext();
    lLocalContext.setAttribute(HttpClientContext.COOKIE_STORE, lCookieStore);

    lResponse = lHttpClient.execute(lRequest, lLocalContext);
    assertEquals("", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testPOSTRequests( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.post(template.getRootUri() + "/rest-products");

    //
    // createProduct(...)
    //

    // InputStreamEntity lBodyStream = new InputStreamEntity(null, ContentType.APPLICATION_JSON);
    StringEntity lBody =
        new StringEntity("{\"name\":\"My First Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}",
            ContentType.APPLICATION_JSON);
    lRequest.setEntity(lBody);
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("true", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());

    //
    // createChannelCode
    //
    lRequest = ClassicRequestBuilder.post(template.getRootUri() + "/rest-products/ChannelCode");
    lBody = new StringEntity("MyMobile", ContentType.APPLICATION_JSON);
    lRequest.setEntity(lBody);
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("\"MyMobile\"", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testServiceProxyInit( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products/test-init");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());

    assertEquals(204, lResponse.getCode());
  }

  @Test
  void testSimpleRESTCallThroughProxy( ) throws Exception {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);

    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products/12345").build();
    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products/currencies/0815").build();
    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[\"EUR\",\"CHF\"]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products/async-currencies/0815").build();
    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[\"EUR\",\"CHF\",\"USD\"]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
  }

  @Test
  void testApacheHttpClientBehavior( ) throws ProtocolException {
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    lRequestBuilder.setUri("http://localhost:8099/rest-products/666");
    lRequestBuilder.addParameter("timeUnit", "MINUTE");
    lRequestBuilder.addParameter("extensibleEnum", ExtensibleEnum.valueOf("VERY PINK").toString());
    lRequestBuilder.addParameter("nullParam", null);
    lRequestBuilder.addHeader("nullHeader", null);
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    assertEquals(null, lRequest.getHeader("nullHeader").getValue());
    assertEquals(true, lRequest.getRequestUri().endsWith("&nullParam"));
    XFun.getTrace().info(lRequest.toString());
  }

  @Test
  void testCompositeDataTypeAsPathParam( ) throws IOException {
    String lComplexBookingIDAsString =
        "AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgKq03nVSRUYtMTKzAA==";

    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/rest-products/complex/"
        + lComplexBookingIDAsString);
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("true", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testPathlessRESTController( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/doSomething");

    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("Something", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMulitvaluedDataTypeAsBeanQueryParam( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/testMulitvaluedDataTypeAsBeanQueryParam");
    lRequest.addParameter("codes", "1");
    lRequest.addParameter("codes", "4");
    lRequest.addParameter("codes", "2");
    lRequest.addParameter("longCodes", String.valueOf(Long.MAX_VALUE));
    lRequest.addParameter("doubleCodes", "3.1415");
    lRequest.addParameter("doubleCodes", "47.11");
    lRequest.addParameter("offsetDateTime", "2022-03-17T13:22:12.453+01:00");
    lRequest.addParameter("offsetTime", "13:22:12.453+01:00");
    lRequest.addParameter("localDateTime", "2022-03-17T13:22:12.453");
    lRequest.addParameter("localTime", "13:22:12.453");
    lRequest.addParameter("timestamps", "2022-03-17T13:22:12.453");
    lRequest.addParameter("timestamps", "2022-03-17T14:22:12.453");
    lRequest.addParameter("times", "13:22:12.453+01:00");
    lRequest.addParameter("times", "14:22:12.453+01:00");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(200, lResponse.getCode());
    assertEquals(
        "1.4.2.9223372036854775807_3.1415_47.11_2022-03-17T13:22:12.453+01:00_2022-03-17T13:22:12.453_13:22:12.453_13:22:12.453+01:00_[14:22:12.453+01:00, 13:22:12.453+01:00]",
        Tools.getStreamTools().getStreamContentAsString(lResponse
            .getEntity()
            .getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMultiValuedHeaderFieldsInBeanParam( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/testMultiValuedHeaderFieldsInBeanParam");
    lRequest.addHeader("names", "Hello");
    lRequest.addHeader("names", "World!");

    lRequest.addHeader("ints", "5");
    lRequest.addHeader("ints", "2");
    lRequest.addHeader("ints", "3");
    lRequest.addHeader("ints", "4");
    lRequest.addHeader("ints", "1");

    lRequest.addHeader("doubles", "3.1415");
    lRequest.addHeader("doubles", "47.11");

    lRequest.addHeader("codes", "StringCode1");
    lRequest.addHeader("codes", "StringCode2");

    lRequest.addHeader("stringCodeList", "StringCode3");
    lRequest.addHeader("stringCodeList", "StringCode4");

    lRequest.addHeader("startDate", DateTimeFormatter.ISO_DATE.format(LocalDate.of(2022, 12, 24)));

    lRequest.addHeader("dates", DateTimeFormatter.ISO_DATE.format(LocalDate.of(2022, 12, 24)));
    lRequest.addHeader("dates", DateTimeFormatter.ISO_DATE.format(LocalDate.of(2022, 12, 31)));

    lRequest.addHeader("timestamps", "2022-03-17T13:22:12.453");
    lRequest.addHeader("times", "13:22:12.453+01:00");
    lRequest.addHeader("times", "14:22:12.453+01:00");

    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(
        "[Hello, World!]_[5, 2, 3, 4, 1]_[3.1415, 47.11]_-StringCode1-StringCode2_-StringCode3-StringCode4_2022-12-24_2022-12-24,2022-12-31,",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMultiValuedHeaderFields( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/testMultiValuedHeaderFields");
    lRequest.addHeader("names", "Hello");
    lRequest.addHeader("names", "World!");
    lRequest.addHeader("ints", "1");
    lRequest.addHeader("ints", "2");
    lRequest.addHeader("ints", "3");
    lRequest.addHeader("ints", "4");
    lRequest.addHeader("ints", "5");
    lRequest.addHeader("doubles", "3.1415");
    lRequest.addHeader("doubles", "47.11");
    lRequest.addHeader("codes", "StringCode1");
    lRequest.addHeader("codes", "StringCode2");
    lRequest.addHeader("stringCodeList", "StringCode3");
    lRequest.addHeader("stringCodeList", "StringCode4");
    lRequest.addHeader("timestamps", "2022-03-17T13:22:12.453+01:00");
    lRequest.addHeader("times", "13:22:12.453+01:00");
    lRequest.addHeader("times", "14:22:12.453+01:00");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(200, lResponse.getCode());
    assertEquals(
        "[Hello, World!]_[1, 2, 3, 4, 5]_[47.11, 3.1415]_-StringCode1-StringCode2_[2022-03-17T13:22:12.453+01:00]_[14:22:12.453+01:00, 13:22:12.453+01:00]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
  }

  @Test
  void testDateQueryParams( ) throws IOException, ParseException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/test-date-query-params/2");
    lRequest.addParameter("startTimestamp", "2022-03-17T13:22:12.453+01:00");
    lRequest.addParameter("startTime", "13:22:12.453+01:00");
    lRequest.addParameter("localStartTimestamp", "2022-03-17T13:22:12.453");
    lRequest.addParameter("localStartTime", "13:22:12.453");
    lRequest.addParameter("localStartDate", "2022-03-17");
    lRequest.addParameter("calendar", "2022-03-17T13:22:12.453+01:00");
    lRequest.addParameter("sqlTimestamp", "2022-03-17 13:22:12.453");
    lRequest.addParameter("sqlTime", "13:22:12");
    lRequest.addParameter("sqlDate", "2022-03-17");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(204, lResponse.getCode());
  }

  @Test
  void testDateQueryParamsBean( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/test-date-query-params-beans/1");
    lRequest.addParameter("offsetDateTime", "2022-03-17T13:22:12.453+01:00");
    lRequest.addParameter("offsetTime", "13:22:12.453+01:00");
    lRequest.addParameter("localDateTime", "2022-03-17T13:22:12.453");
    lRequest.addParameter("localTime", "13:22:12.453");
    lRequest.addParameter("localDate", "2022-03-17");
    lRequest.addParameter("calendar", "2022-03-17T13:22:12.453+01:00");
    // lRequest.addParameter("utilDate", "2022-03-17T13:22:12.453+01:00");
    lRequest.addParameter("sqlTimestamp", "2022-03-17 13:22:12.453");
    lRequest.addParameter("sqlTime", "13:22:12");
    lRequest.addParameter("sqlDate", "2022-03-17");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(204, lResponse.getCode());
  }

  @Test
  void testDateHeaderParamsBean( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri()
        + "/rest-products/test-date-header-params-beans/1");
    lRequest.addHeader("Offset-Date-Time", "2022-03-17T13:22:12.453+01:00");
    lRequest.addHeader("Offset-Time", "13:22:12.453+01:00");
    lRequest.addHeader("Local-Date-Time", "2022-03-17T13:22:12.453");
    lRequest.addHeader("Local-Time", "13:22:12.453");
    lRequest.addHeader("Local-Date", "2022-03-17");
    lRequest.addHeader("Calendar", "2022-03-17T13:22:12.453+01:00");
    lRequest.addHeader("SQL-Timestamp", "2022-03-17 13:22:12.453");
    lRequest.addHeader("SQL-Time", "13:22:12");
    lRequest.addHeader("SQL-Date", "2022-03-17");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals(204, lResponse.getCode());
  }

}
