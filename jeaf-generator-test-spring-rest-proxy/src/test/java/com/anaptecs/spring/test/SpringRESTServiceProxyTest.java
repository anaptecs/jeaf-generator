/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.DoubleCodeType;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TechnicalHeaderContext;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.ProductService;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zalando.problem.ThrowableProblem;

@Disabled
@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRESTServiceProxyTest {
  private static ClientAndServer mockServer;

  public static final int MOCK_PORT = 8099;

  public static final String ROOT_URI = "http://localhost:8090/rest";

  public static final String BOOKING_ID_STRING = "DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==";

  public static final BookingCode BOOKING_CODE = BookingCode.builder().setCode("4711-0815").build();

  public static final DoubleCodeType DOUBLE_CODE = DoubleCodeType.builder().setCode(3.14159).build();

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

    lClient
        .when(mockRequest("/rest-products/dataTypesInHeader", "GET").withHeader("bookingID", BOOKING_ID_STRING)
            .withHeader("bookingCode", BOOKING_CODE.getCode())
            .withHeader("DoubleCode", Double.toString(DOUBLE_CODE.getCode())))
        .respond(mockResponse("\"" + DATA_TYPE_RESPONSE + "\""));

    lClient
        .when(mockRequest("/rest-products/dataTypesInBeanHeader", "GET").withHeader("bookingID", BOOKING_ID_STRING)
            .withHeader("bookingCode", BOOKING_CODE.getCode())
            .withHeader("DoubleCode", Double.toString(DOUBLE_CODE.getCode())))
        .respond(mockResponse("\"" + DATA_TYPE_RESPONSE + "\""));

    lClient.when(mockRequest("/products/technicalHeaderBeanParam", "GET").withHeader("Custom-Header", "XYZ"))
        .respond(mockResponse(""));

    lClient.when(mockRequest("/rest-products/testDataTypeAsQueryParam", "GET").withQueryStringParameter("bookingCode",
        "4711-0815")).respond(mockResponse("\"OK\""));

    lClient.when(mockRequest("/rest-products/testDataTypeAsBeanQueryParam", "GET")
        .withQueryStringParameter("bookingCode", "4711-0815")).respond(mockResponse("\"4711-0815\""));

    lClient.when(mockRequest("/rest-products/testPrimitiveArrayAsQueryParam", "GET")
        .withQueryStringParameter("intValues", "1", "2", "47", "13")).respond(mockResponse("\"1+2+47+13\""));

    lClient.when(mockRequest("/rest-products/testSimpleTypesAsQueryParams", "GET").withQueryStringParameter("strings",
        "Hello", "World")).respond(mockResponse("\"Hello_World_!\""));

    lClient.when(mockRequest("/rest-products/testPrimitiveWrapperArrayAsQueryParam", "GET")
        .withQueryStringParameter("integers", "1", "2", "13", "47")).respond(mockResponse("\"1-2-47-13\""));

    lClient.when(mockRequest("/rest-products/testMulitvaluedDataTypeAsQueryParam", "GET")
        .withQueryStringParameter("codes", "47", "11")
        .withQueryStringParameter("longCodes", "4710815123", "47110815999")).respond(mockResponse("\"47-11\""));

    lClient.when(mockRequest("/rest-products/testMulitvaluedDataTypeAsBeanQueryParam", "GET")
        .withQueryStringParameter("codes", "123456")
        .withQueryStringParameter("longCodes", "99998888775566211", "-123456789")
        .withQueryStringParameter("doubleCodes", "3.1415", "47.11")).respond(mockResponse("\"47-11-123456\""));

    lClient
        .when(mockRequest("/rest-products/testMultiValuedHeaderFieldsInBeanParam", "GET")
            .withHeader("names", "JEAF", "Development", "Team").withHeader("ints", "1", "2", "3", "4")
            .withHeader("doubles", "3.1415", "47.11").withHeader("codes", "CODE_1", "CODE_2")
            .withHeader("stringCodeList", "CODE_4", "CODE_7").withHeader("dates", "2022-01-17", "2023-01-17"))
        .respond(mockResponse("\"Yeah!\""));

    lClient
        .when(mockRequest("/rest-products/testMultiValuedHeaderFields", "GET")
            .withHeader("names", "JEAF", "Development", "Team").withHeader("ints", "1", "2", "3", "4")
            .withHeader("doubles", "3.1415", "47.11").withHeader("codes", "CODE_1", "CODE_2")
            .withHeader("timestamps", "2022-03-17T13:22:12.453+01:00", "2022-03-17T13:22:12.453+07:00"))
        .respond(mockResponse("\"Yeah, yeah!\""));

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
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00").withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params/4")).respond(mockResponse(null, 200, 0));

    // test-date-query-params-beans
    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/1")
        .withQueryStringParameter("offsetDateTime", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("offsetTime", "13:22:12.453+01:00")
        .withQueryStringParameter("localDateTime", "2022-03-17T13:22:12.453")
        .withQueryStringParameter("localTime", "13:22:12.453").withQueryStringParameter("localDate", "2022-03-17")
        .withQueryStringParameter("calendar", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("utilDate", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTimestamp", "2022-03-17T13:22:12.453+01:00")
        .withQueryStringParameter("sqlTime", "13:22:12.453+01:00").withQueryStringParameter("sqlDate", "2022-03-17"))
        .respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-query-params-beans/4")).respond(mockResponse(null, 200, 0));

    // test-date-header-params
    lClient.when(mockRequest("/rest-products/test-date-header-params/1")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12.453+01:00").withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453").withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17").withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00").withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17")).respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params/4")).respond(mockResponse(null, 200, 0));

    // test-date-header-params-beans
    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/1")
        .withHeader("Offset-Date-Time", "2022-03-17T13:22:12.453+01:00").withHeader("Offset-Time", "13:22:12.453+01:00")
        .withHeader("Local-Date-Time", "2022-03-17T13:22:12.453").withHeader("Local-Time", "13:22:12.453")
        .withHeader("Local-Date", "2022-03-17").withHeader("Calendar", "2022-03-17T13:22:12.453+01:00")
        .withHeader("Util-Date", "2022-03-17T13:22:12.453+01:00")
        .withHeader("SQL-Timestamp", "2022-03-17T13:22:12.453+01:00").withHeader("SQL-Time", "13:22:12.453+01:00")
        .withHeader("SQL-Date", "2022-03-17")).respond(mockResponse(null, 200, 0));

    lClient.when(mockRequest("/rest-products/test-date-header-params-beans/4")).respond(mockResponse(null, 200, 0));
  }

  @AfterAll
  static void stopMockServer( ) {
    if (mockServer != null) {
      mockServer.stop();
    }
  }

  private static HttpRequest mockRequest(String pRequestURI, String pMethod) {
    return HttpRequest.request().withPath(pRequestURI).withMethod(pMethod);
  }

  private static HttpRequest mockRequest(String pRequestURI) {
    return HttpRequest.request().withPath(pRequestURI);
  }

  private static HttpResponse mockResponse(String pResponseBody) {
    return HttpResponse.response().withDelay(TimeUnit.MILLISECONDS, 0).withStatusCode(200).withBody(pResponseBody);
  }

  private static HttpResponse mockResponse(String pResponseBody, int pStatusCode, int pDelay) {
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
    String lResponse = productService.testDataTypesAsHeaderParam(lBookingID, BOOKING_CODE, DOUBLE_CODE);
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

    lResult =
        productService.testDataTypeAsBeanQueryParam(QueryBeanParam.builder().setBookingCode(BOOKING_CODE).build());
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
    String lResult = productService.testMulitvaluedDataTypeAsQueryParam(
        Arrays.asList(IntegerCodeType.builder().setCode(47).build(), IntegerCodeType.builder().setCode(11).build()),
        lLongCodes, null, null, null);
    assertEquals("47-11", lResult);
  }

  @Test
  void testMulitvaluedDataTypeAsBeanQueryParam( ) {
    IntegerCodeType[] lCodes = new IntegerCodeType[] { IntegerCodeType.builder().setCode(123456).build() };
    LongCode[] lLongCodes = new LongCode[] { LongCode.builder().setCode(99998888775566211L).build(),
      LongCode.builder().setCode(-123456789L).build() };
    Set<DoubleCode> lDoubleCodes = new HashSet<>(Arrays.asList(new DoubleCode[] {
      DoubleCode.builder().setCode(3.1415).build(), DoubleCode.builder().setCode(47.11).build() }));
    DataTypesQueryBean lQueryBean =
        DataTypesQueryBean.builder().setCodes(lCodes).setLongCodes(lLongCodes).setDoubleCodes(lDoubleCodes).build();
    String lResult = productService.testMulitvaluedDataTypeAsBeanQueryParam(lQueryBean);
    assertEquals("47-11-123456", lResult);
  }

  @Test
  void testMultiValuedHeaderFieldsInBeanParam( ) {

    MultiValuedHeaderBeanParam lBeanParam =
        MultiValuedHeaderBeanParam.builder().setNames(new String[] { "JEAF", "Development", "Team" })
            .setInts(new int[] { 1, 2, 3, 4 }).setDoubles(new Double[] { 3.1415, 47.11 })
            .setCodes(new StringCode[] { StringCode.builder().setCode("CODE_1").build(),
              StringCode.builder().setCode("CODE_2").build() })
            .setStringCodeList(new HashSet<>(Arrays.asList(StringCode.builder().setCode("CODE_4").build(),
                StringCode.builder().setCode("CODE_7").build())))
            .setDates(new LocalDate[] { LocalDate.of(2022, 01, 17), LocalDate.of(2023, 01, 17) }).build();
    String lResult = productService.testMultiValuedHeaderFieldsInBeanParam(lBeanParam);
    assertEquals("Yeah!", lResult);
  }

  @Test
  void testMultiValuedHeaderFields( ) {
    Set<String> lNames = new HashSet<>(Arrays.asList("JEAF", "Development", "Team"));
    int[] lInts = new int[] { 1, 2, 3, 4 };
    Set<Double> lDoubles = new HashSet<>(Arrays.asList(3.1415, 47.11));
    Set<StringCode> lCodes = new HashSet<>(
        Arrays.asList(StringCode.builder().setCode("CODE_1").build(), StringCode.builder().setCode("CODE_2").build()));
    Set<OffsetDateTime> lTimestamps = new HashSet<>(Arrays.asList(OffsetDateTime.parse("2022-03-17T13:22:12.453+07:00"),
        OffsetDateTime.parse("2022-03-17T13:22:12.453+01:00")));
    String lResult =
        productService.testMultiValuedHeaderFields(lNames, lInts, lDoubles, lCodes, null, lTimestamps, null, null);
    assertEquals("Yeah, yeah!", lResult);
  }
}
