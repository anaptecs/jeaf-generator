/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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
import org.zalando.problem.ThrowableProblem;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.date.DateTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.impl.SpringTestApplication;
import com.anaptecs.spring.service.RESTProductService;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRESTControllerTest {
  @Inject
  private TestRestTemplate template;

  @Inject
  private RESTProductService restProductService;

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
    lClient.when(mockRequest("/rest-products/test-date-query-params")).respond(mockResponse(null, 200, 0));
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

    assertEquals(0, lResponse.getEntity().getContentLength());
    assertEquals(200, lResponse.getCode());
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
  void testRESTProductService( ) throws Exception {
    // Test getProducts
    List<Product> lProducts = restProductService.getProducts(500);
    assertEquals(1, lProducts.size());

    Product lProduct = restProductService.getProduct("4711");
    assertEquals(null, lProduct);

    lProduct = restProductService.getProduct("12345");
    assertEquals("Cool Product", lProduct.getName());
    assertEquals("https://products.anaptecs.de/123456789", lProduct.getUri());
    assertEquals(null, lProduct.getDescription());

    ChannelCode lChannelCode = ChannelCode.Builder.newBuilder().setCode("0815").build();
    List<CurrencyCode> lSupportedCurrencies = restProductService.getSupportedCurrencies(lChannelCode);
    assertNotNull(lSupportedCurrencies);
    assertEquals("EUR", lSupportedCurrencies.get(0).getCode());
    assertEquals("CHF", lSupportedCurrencies.get(1).getCode());
    assertEquals(2, lSupportedCurrencies.size());

    lSupportedCurrencies = restProductService.getSupportedCurrenciesAsync(lChannelCode);
    assertNotNull(lSupportedCurrencies);
    assertEquals("EUR", lSupportedCurrencies.get(0).getCode());
    assertEquals("CHF", lSupportedCurrencies.get(1).getCode());
    assertEquals("USD", lSupportedCurrencies.get(2).getCode());
    assertEquals(3, lSupportedCurrencies.size());

    String lResult = restProductService.testParams(BigDecimal.valueOf(3.1423), 9999, Locale.GERMANY);
    assertEquals("Hello World of REST!", lResult);

    try {
      restProductService.testParams(BigDecimal.valueOf(3.1423), 9999, Locale.GERMAN);
      fail("Expecting exception");
    }
    catch (ThrowableProblem e) {
      assertEquals(404, e.getStatus().getStatusCode());
      assertEquals("Not Found", e.getTitle());
      assertEquals("http://localhost:8099/rest-products/test-params?locale=de", e.getType().toString());
      assertEquals(null, e.getDetail());
    }
  }

  @Test
  void testEnumParamHandling( ) {
    restProductService.testEnumParams(ChannelType.COUNTER, com.anaptecs.spring.base.TimeUnit.MINUTE,
        ExtensibleEnum.BLUE);

    restProductService.testEnumParams(ChannelType.COUNTER, com.anaptecs.spring.base.TimeUnit.MINUTE,
        ExtensibleEnum.valueOf("VERY PINK"));

    // Test handling of null params
    restProductService.testEnumParams(ChannelType.MOBILE, null, null);

  }

  @Test
  void testEnumHeaderParamHandling( ) {
    restProductService.testEnumHeaderParams(ChannelType.COUNTER, com.anaptecs.spring.base.TimeUnit.MINUTE,
        ExtensibleEnum.BLUE);

    restProductService.testEnumHeaderParams(ChannelType.COUNTER, com.anaptecs.spring.base.TimeUnit.MINUTE,
        ExtensibleEnum.valueOf("VERY PINK"));

    restProductService.testEnumHeaderParams(ChannelType.MOBILE, null, null);
  }

  @Test
  void testExceptionHandling( ) {
    // Test exception handling in case that no problem JSON will be returned from the server
    try {
      restProductService.getProduct("666");
      fail("Exception expected.");
    }
    catch (ThrowableProblem e) {
      assertEquals("http://localhost:8099/rest-products/666", e.getType().toString());
      assertEquals("Not Found", e.getTitle());
      assertEquals(404, e.getStatus().getStatusCode());
      assertEquals("Invalid product number", e.getDetail());
    }

    // Test processing of problem JSON if it is returned from a REST resource
    try {
      restProductService.getProduct("777");
      fail("Exception expected.");
    }
    catch (ThrowableProblem e) {
      assertEquals("https://example.org/out-of-stock", e.getType().toString());
      assertEquals("Out of Stock", e.getTitle());
      assertEquals(400, e.getStatus().getStatusCode());
      assertEquals("Item B00027Y5QG is no longer available", e.getDetail());
    }

    // Test JSON parsing problems
    try {
      restProductService.getProduct("json-problem");
      fail("Exception expected.");
    }
    catch (ThrowableProblem e) {
      assertEquals("http://localhost:8099/rest-products/json-problem", e.getType().toString());
      assertEquals("Internal Server Error", e.getTitle());
      assertEquals(500, e.getStatus().getStatusCode());
      assertTrue(e.getDetail().startsWith(
          "Cannot deserialize value of type `com.anaptecs.spring.base.Product` from Array value (token `JsonToken.START_ARRAY`)"));
    }

    // Test timeout problems
    try {
      restProductService.getProduct("timeout");
      fail("Exception expected.");
    }
    catch (ThrowableProblem e) {
      assertEquals("http://localhost:8099/rest-products/timeout", e.getType().toString());
      assertEquals("Internal Server Error", e.getTitle());
      assertEquals(500, e.getStatus().getStatusCode());
      assertEquals("Read timed out", e.getDetail());
    }
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
  void testDateConversions( ) {
    // Date and Calendar to String
    Calendar lCalendar = DateTools.getDateTools().toCalendar("2022-03-17 13:22:12.453");
    lCalendar.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
    Date lUtilDate = DateTools.getDateTools().toDate(lCalendar);

    SimpleDateFormat lDateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    SimpleDateFormat lDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat lTimeFormatter = new SimpleDateFormat("HH:mm:ss.SSSXXX");
    assertEquals("2022-03-17T13:22:12.453+01:00", lDateTimeFormatter.format(lUtilDate));
    assertEquals("2022-03-17T13:22:12.453+01:00", lDateTimeFormatter.format(lCalendar.getTime()));

    // Test java.sql classes
    java.sql.Date lSQLDate = new java.sql.Date(lUtilDate.getTime());
    assertEquals("2022-03-17T13:22:12.453+01:00", lDateTimeFormatter.format(lSQLDate));
    assertEquals("2022-03-17", lDateFormatter.format(lSQLDate));
    assertEquals("2022-03-17", lSQLDate.toString());
    Time lSQLTime = new Time(lUtilDate.getTime());
    assertEquals("2022-03-17T13:22:12.453+01:00", lDateTimeFormatter.format(lSQLTime));
    assertEquals("13:22:12.453+01:00", lTimeFormatter.format(lSQLTime));
    assertEquals("13:22:12", lSQLTime.toString());
    Timestamp lSQLTimestamp = new Timestamp(lUtilDate.getTime());
    assertEquals("2022-03-17T13:22:12.453+01:00", lDateTimeFormatter.format(lSQLTimestamp));
    assertEquals("2022-03-17 13:22:12.453", lSQLTimestamp.toString());

    // XFun.getTrace().info(String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS.%1$tL%1$tz", new Date()));

    // Test java.time offset aware classes
    OffsetDateTime lOffsetDateTime = OffsetDateTime.parse("2022-03-17T13:22:12.453+01:00");
    assertEquals("2022-03-17T13:22:12.453+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lOffsetDateTime));
    assertEquals("2022-03-17T13:22:12.453+01:00", lOffsetDateTime.toString());

    lOffsetDateTime = OffsetDateTime.parse("2022-03-17T13:22:12+01:00");
    assertEquals("2022-03-17T13:22:12+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lOffsetDateTime));
    assertEquals("2022-03-17T13:22:12+01:00", lOffsetDateTime.toString());

    lOffsetDateTime = OffsetDateTime.parse("2022-03-17T13:22+01:00");
    assertEquals("2022-03-17T13:22:00+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lOffsetDateTime));
    assertEquals("2022-03-17T13:22+01:00", lOffsetDateTime.toString());

    OffsetTime lOffsetTime = OffsetTime.parse("13:22:12.453+01:00");
    assertEquals("13:22:12.453+01:00", DateTimeFormatter.ISO_OFFSET_TIME.format(lOffsetTime));
    assertEquals("13:22:12.453+01:00", lOffsetTime.toString());

    // Test java.time local classes
    LocalDateTime lLocalDateTime = LocalDateTime.parse("2022-03-17T13:22:12.453");
    assertEquals("2022-03-17T13:22:12.453", DateTimeFormatter.ISO_DATE_TIME.format(lLocalDateTime));
    assertEquals("2022-03-17T13:22:12.453", lLocalDateTime.toString());

    LocalDate lLocalDate = LocalDate.parse("2022-03-17");
    assertEquals("2022-03-17", DateTimeFormatter.ISO_DATE.format(lLocalDate));
    assertEquals("2022-03-17", lLocalDate.toString());

    LocalTime lLocalTime = LocalTime.parse("13:22:12.453");
    assertEquals("13:22:12.453", DateTimeFormatter.ISO_TIME.format(lLocalTime));
    assertEquals("13:22:12.453", lLocalTime.toString());

    // TODO Generate warning in case of OpenAPI incompatible date types.

    restProductService.testDateQueryParams(lLocalDateTime, lOffsetDateTime, lLocalTime, lOffsetTime, lCalendar,
        lUtilDate, lSQLDate, lSQLTime, lSQLTimestamp);
  }
}
