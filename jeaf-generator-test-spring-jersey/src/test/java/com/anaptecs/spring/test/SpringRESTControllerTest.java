/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.CurrencyCode;
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
    catch (JEAFSystemException e) {
      assertEquals(JSONMessages.RECEIVED_REST_PROBLEM_JSON, e.getErrorCode());
    }
  }
}
