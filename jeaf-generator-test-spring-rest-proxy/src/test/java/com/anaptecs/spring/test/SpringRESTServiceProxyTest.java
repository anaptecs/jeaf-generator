/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
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

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.service.AdvancedHeader;
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
}
