/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zalando.problem.ThrowableProblem;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.TechnicalHeaderContext;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.ProductService;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRESTServiceProxyTest {
  private static ClientAndServer mockServer;

  public static final int MOCK_PORT = 8099;

  public static final String ROOT_URI = "http://localhost:8090/rest";

  public static final String BOOKING_ID_STRING = "DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==";

  public static final BookingCode BOOKING_CODE = BookingCode.builder().setCode("4711-0815").build();

  public static final DoubleCode DOUBLE_CODE = DoubleCode.builder().setCode(3.14159).build();

  public static final String DATA_TYPE_RESPONSE = "123456_EXT-0987654321_4711-0815_3.14159";

  @Autowired
  private RESTProductService productService;

  @Autowired
  private ProductService theRealProductService;

  @BeforeAll
  static void startMockServer( ) throws IOException {
    mockServer = ClientAndServer.startClientAndServer(MOCK_PORT);
    assertEquals(true, mockServer.isRunning());

    // Add mock responses
    @SuppressWarnings("resource")
    MockServerClient lClient = new MockServerClient("localhost", MOCK_PORT);

    lClient.when(mockRequest("/rest-products/4711")).respond(mockResponse(null));

    lClient.when(mockRequest("/rest-products/12345"))
        .respond(mockResponse("{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}"));

    lClient.when(mockRequest("/rest-products/dataTypesInHeader", "GET").withHeader("bookingID", BOOKING_ID_STRING)
        .withHeader("bookingCode", BOOKING_CODE.getCode()).withHeader("DoubleCode", Double.toString(DOUBLE_CODE
            .getCode()))).respond(mockResponse("\"" + DATA_TYPE_RESPONSE + "\""));

    lClient.when(mockRequest("/rest-products/dataTypesInBeanHeader", "GET").withHeader("bookingID", BOOKING_ID_STRING)
        .withHeader("bookingCode", BOOKING_CODE.getCode()).withHeader("DoubleCode", Double.toString(DOUBLE_CODE
            .getCode()))).respond(mockResponse("\"" + DATA_TYPE_RESPONSE + "\""));

    lClient.when(mockRequest("/products/technicalHeaderBeanParam", "GET").withHeader("Custom-Header", "XYZ"))
        .respond(mockResponse(""));

    lClient.when(mockRequest("/rest-products/testDataTypeAsQueryParam", "GET").withQueryStringParameter("bookingCode",
        "4711-0815")).respond(mockResponse("\"OK\""));

    lClient.when(mockRequest("/rest-products/testDataTypeAsBeanQueryParam", "GET").withQueryStringParameter(
        "bookingCode",
        "4711-0815")).respond(mockResponse("\"4711-0815\""));

    lClient.when(mockRequest("/rest-products/testPrimitiveArrayAsQueryParam", "GET").withQueryStringParameter(
        "intValues", "1", "2", "47", "13")).respond(mockResponse("\"1+2+47+13\""));

    lClient.when(mockRequest("/rest-products/testSimpleTypesAsQueryParams", "GET").withQueryStringParameter(
        "strings", "Hello", "World")).respond(mockResponse("\"Hello_World_!\""));

    lClient.when(mockRequest("/rest-products/testPrimitiveWrapperArrayAsQueryParam", "GET").withQueryStringParameter(
        "integers", "1", "2", "13", "47")).respond(mockResponse("\"1-2-47-13\""));

    lClient.when(mockRequest("/rest-products/testMulitvaluedDataTypeAsQueryParam", "GET").withQueryStringParameter(
        "codes", "47", "11").withQueryStringParameter("longCodes", "4710815123", "47110815999")).respond(mockResponse(
            "\"47-11\""));

    lClient.when(mockRequest("/rest-products/testMulitvaluedDataTypeAsBeanQueryParam", "GET").withQueryStringParameter(
        "codes", "123456").withQueryStringParameter("longCodes", "99998888775566211", "-123456789")
        .withQueryStringParameter("doubleCodes", "3.1415", "47.11")).respond(mockResponse(
            "\"47-11-123456\""));
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
  void testRESTServiceProxy( ) {
    assertNotNull(productService);

    Product lProduct = productService.getProduct("4711");
    assertNull(lProduct);

    // Test simple things
    lProduct = productService.getProduct("12345");
    assertEquals("Cool Product", lProduct.getName());
    assertEquals(null, lProduct.getDescription());
    assertEquals("https://products.anaptecs.de/123456789", lProduct.getUri());

    // Data types as headers.
    BookingID lBookingID = BookingID.builder(BOOKING_ID_STRING).build();
    String lResponse = productService.testDataTypesAsHeaderParam(lBookingID,
        BOOKING_CODE, DOUBLE_CODE);
    assertEquals(DATA_TYPE_RESPONSE, lResponse);

    AdvancedHeader lAdvancedHeader = AdvancedHeader.builder().setBookingID(lBookingID).setBookingCode(BOOKING_CODE)
        .setDoubleCode(DOUBLE_CODE).build();
    lResponse = productService.testDataTypesAsHeaderBeanParam(lAdvancedHeader);
    assertEquals(DATA_TYPE_RESPONSE, lResponse);
  }

  @Test
  void testTechnicalHeaders( ) {
    TechnicalHeaderContext lContext = TechnicalHeaderContext.builder().build();
    lContext.addCustomHeader("Custom-Header", "XYZ");
    String lResult = theRealProductService.testTechnicalHeaderBean(lContext);
    assertEquals(null, lResult);

    try {
      lContext.addCustomHeader("Custom-Header", "XYZ1");
      theRealProductService.testTechnicalHeaderBean(lContext);
      fail();
    }
    catch (ThrowableProblem e) {
      assertEquals(404, e.getStatus().getStatusCode());
    }
  }

  @Test
  void testDataTypesAsQueryParams( ) {
    String lResult = productService.testDataTypeAsQueryParam(BOOKING_CODE);
    assertEquals("OK", lResult);

    lResult = productService.testDataTypeAsBeanQueryParam(QueryBeanParam.builder().setBookingCode(BOOKING_CODE)
        .build());
    assertEquals("4711-0815", lResult);
  }

  @Test
  void testMultivaluedQueryParams( ) {
    String lResult = productService.testPrimitiveArrayAsQueryParam(new int[] { 1, 2, 47, 13 });
    assertEquals("1+2+47+13", lResult);

    lResult = productService.testSimpleTypesAsQueryParams(Arrays.asList("Hello", "World"));
    assertEquals("Hello_World_!", lResult);

    SortedSet<Integer> lSortedSet = new TreeSet<>();
    lSortedSet.add(1);
    lSortedSet.add(2);
    lSortedSet.add(47);
    lSortedSet.add(13);
    lResult = productService.testPrimitiveWrapperArrayAsQueryParam(lSortedSet);
    assertEquals("1-2-47-13", lResult);
  }

  @Test
  void testMulitvaluedDataTypeAsQueryParam( ) {
    Set<LongCode> lLongCodes = new HashSet<>();
    lLongCodes.add(LongCode.builder().setCode(4710815123L).build());
    lLongCodes.add(LongCode.builder().setCode(47110815999L).build());
    String lResult = productService.testMulitvaluedDataTypeAsQueryParam(Arrays.asList(IntegerCodeType.builder().setCode(
        47).build(), IntegerCodeType.builder().setCode(11).build()), lLongCodes);
    assertEquals("47-11", lResult);
  }

  @Test
  void testMulitvaluedDataTypeAsBeanQueryParam( ) {
    IntegerCodeType[] lCodes = new IntegerCodeType[] { IntegerCodeType.builder().setCode(123456).build() };
    LongCode[] lLongCodes = new LongCode[] { LongCode.builder().setCode(99998888775566211L).build(), LongCode.builder()
        .setCode(-123456789L).build() };
    Set<DoubleCode> lDoubleCodes = new HashSet<>(Arrays.asList(new DoubleCode[] { DoubleCode.builder().setCode(3.1415)
        .build(), DoubleCode.builder().setCode(47.11).build() }));
    DataTypesQueryBean lQueryBean = DataTypesQueryBean.builder().setCodes(lCodes).setLongCodes(lLongCodes)
        .setDoubleCodes(lDoubleCodes).build();
    String lResult = productService.testMulitvaluedDataTypeAsBeanQueryParam(lQueryBean);
    assertEquals("47-11-123456", lResult);
  }
}
