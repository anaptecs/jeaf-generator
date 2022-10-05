/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
import org.mockserver.model.MediaType;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.fastlane.impl.FastLaneServer;
import com.anaptecs.jeaf.fastlane.impl.WebContainerState;
import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.problem.Problem;
import com.anaptecs.jeaf.json.problem.RESTProblemException;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.service.RESTProductService;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

public class JEAFRestControllerTest {
  private static FastLaneServer server;

  private static ClientAndServer mockServer;

  public static final int MOCK_PORT = 8099;

  public static final String ROOT_URI = "http://localhost:8090/rest";

  private static RESTProductService restProductService;

  @BeforeAll
  static void startWebContainer( ) {
    server = new FastLaneServer();
    server.start();
    assertEquals(WebContainerState.RUNNING, server.getState());
  }

  @AfterAll
  static void stopWebContainer( ) {
    if (server != null) {
      server.shutdown(0);
    }
  }

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

  @BeforeAll
  static void loadServices( ) {
    try {
      restProductService = JEAF.getService(RESTProductService.class);
    }
    catch (Throwable e) {
      if (e.getCause().getCause() instanceof ExceptionInInitializerError) {
        System.out.println("XXXXX");
        System.out.println("ExceptionInInitializerError");
        System.out.println("XXXXX");
        ExceptionInInitializerError lError = (ExceptionInInitializerError) e.getCause().getCause();
        lError.getException().printStackTrace();
      }
    }
  }

  @Test
  void testRESTControllerAccess( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
  }

  @Test
  void testAdvancedRESTControllerFeatures( ) throws Exception {
    // Execute simple request using Apache HTTP client
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();

    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    // Execute advanced request

    //
    // getProduct(...)
    //
    ClassicRequestBuilder lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(ROOT_URI + "/rest-products/17");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(500, lResponse.getCode());

    //
    // getProduct(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(ROOT_URI + "/rest-products/4711");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    //
    // getSortiment(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(ROOT_URI + "/rest-products/sortiment/4711");
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
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.post(ROOT_URI + "/rest-products");

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
    lRequest = ClassicRequestBuilder.post(ROOT_URI + "/rest-products/ChannelCode");
    lBody = new StringEntity("MyMobile", ContentType.APPLICATION_JSON);
    lRequest.setEntity(lBody);
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("\"MyMobile\"", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testServiceProxyInit( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products/test-init");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());

    assertEquals(0, lResponse.getEntity().getContentLength());
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testSimpleRESTCallThroughProxy( ) throws Exception {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);

    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products/12345").build();
    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products/currencies/0815").build();
    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[\"EUR\",\"CHF\"]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    lRequest = ClassicRequestBuilder.get(ROOT_URI + "/rest-products/async-currencies/0815").build();
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

    ChannelCode lChannelCode = ChannelCode.builder().setCode("0815").build();
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

  @Test
  void testExceptionHandling( ) {
    // Test exception handling in case that no problem JSON will be returned from the server
    try {
      restProductService.getProduct("666");
      fail("Exception expected.");
    }
    catch (RESTProblemException e) {
      assertEquals(JSONMessages.RECEIVED_REST_PROBLEM_JSON, e.getErrorCode());
      assertNull(e.getCause());
      assertTrue(e.getMessage().endsWith("1804] REST call returned problem JSON (http status code: 404)"));
      Problem lProblem = e.getProblem();
      assertEquals("http://localhost:8099/rest-products/666", lProblem.getType());
      assertEquals("Not Found", lProblem.getTitle());
      assertEquals(404, lProblem.getStatus());
      assertEquals("Invalid product number", lProblem.getDetail());
    }

    // Test processing of problem JSON if it is returned from a REST resource
    try {
      restProductService.getProduct("777");
      fail("Exception expected.");
    }
    catch (RESTProblemException e) {
      assertEquals(JSONMessages.RECEIVED_REST_PROBLEM_JSON, e.getErrorCode());
      assertTrue(e.getMessage().endsWith("1804] REST call returned problem JSON (http status code: 400)"));
      assertNull(e.getCause());
      Problem lProblem = e.getProblem();
      assertEquals("https://example.org/out-of-stock", lProblem.getType());
      assertEquals("Out of Stock", lProblem.getTitle());
      assertEquals(400, lProblem.getStatus());
      assertEquals("Item B00027Y5QG is no longer available", lProblem.getDetail());
    }

    // Test JSON parsing problems
    try {
      restProductService.getProduct("json-problem");
      fail("Exception expected.");
    }
    catch (RESTProblemException e) {
      assertEquals(JSONMessages.RECEIVED_REST_PROBLEM_JSON, e.getErrorCode());
      assertTrue(e.getMessage().endsWith("1804] REST call returned problem JSON (http status code: 500)"));
      assertEquals(MismatchedInputException.class, e.getCause().getClass());
      Problem lProblem = e.getProblem();
      assertEquals("http://localhost:8099/rest-products/json-problem", lProblem.getType());
      assertEquals("Internal Server Error", lProblem.getTitle());
      assertEquals(500, lProblem.getStatus());
      assertTrue(lProblem.getDetail().startsWith(
          "Cannot deserialize value of type `com.anaptecs.spring.base.Product` from Array value (token `JsonToken.START_ARRAY`)"));
    }

    // Test timeout problems
    try {
      restProductService.getProduct("timeout");
      fail("Exception expected.");
    }
    catch (RESTProblemException e) {
      assertEquals(JSONMessages.RECEIVED_REST_PROBLEM_JSON, e.getErrorCode());
      assertTrue(e.getMessage().endsWith("1804] REST call returned problem JSON (http status code: 500)"));
      assertEquals(SocketTimeoutException.class, e.getCause().getClass());
      Problem lProblem = e.getProblem();
      assertEquals("http://localhost:8099/rest-products/timeout", lProblem.getType());
      assertEquals("Internal Server Error", lProblem.getTitle());
      assertEquals(500, lProblem.getStatus());
      assertEquals("Read timed out", lProblem.getDetail());
    }
  }
}
