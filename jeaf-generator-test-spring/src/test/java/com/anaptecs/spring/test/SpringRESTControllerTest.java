/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.impl.SpringTestApplication;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRESTControllerTest {
  @Inject
  private TestRestTemplate template;

  private static final String PREFIX = "/nova/prefix";

  @Test
  void testRESTControllerAccess( ) {
    ResponseEntity<String> lResponse = template.getForEntity(PREFIX + "/products", String.class);
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        lResponse.getBody());
  }

  @Test
  void testAdvancedRESTControllerFeatures( ) throws Exception {
    // Execute simple request using Apache HTTP client
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();

    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX + "/products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    // Execute advanced request

    //
    // getProduct(...)
    //
    ClassicRequestBuilder lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + PREFIX + "/products/17");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(500, lResponse.getCode());

    //
    // getProduct(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + PREFIX + "/products/12345");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    //
    // getSortiment(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + PREFIX + "/products/sortiment/4711");
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
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.post(template.getRootUri() + PREFIX + "/products");

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
    lRequest = ClassicRequestBuilder.post(template.getRootUri() + PREFIX + "/products/ChannelCode");
    lBody = new StringEntity("MyMobile", ContentType.APPLICATION_JSON);
    lRequest.setEntity(lBody);
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("\"MyMobile\"", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testCompositeDataTypeAsPathParam( ) throws IOException {
    String lComplexBookingIDAsString =
        "AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgKq03nVSRUYtMTKzAA==";

    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/complex/" + lComplexBookingIDAsString);
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("true", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testDataTypesAsHeaderParams( ) throws IOException {
    String lBookingIDString = "DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==";
    BookingCode lBookingCode = BookingCode.builder().setCode("4711-0815").build();
    DoubleCode lDoubleCode = DoubleCode.builder().setCode(3.14159).build();

    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/dataTypesInHeader");
    lRequest.addHeader("bookingID", lBookingIDString);
    lRequest.addHeader("bookingCode", lBookingCode.getCode());
    lRequest.addHeader("DoubleCode", Double.toString(lDoubleCode.getCode()));
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("123456_EXT-0987654321_4711-0815_3.14159", Tools.getStreamTools().getStreamContentAsString(lResponse
        .getEntity().getContent()));
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/dataTypesInBeanHeader");
    lRequest.addHeader("bookingID", lBookingIDString);
    lRequest.addHeader("bookingCode", lBookingCode.getCode());
    lRequest.addHeader("DoubleCode", Double.toString(lDoubleCode.getCode()));
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("Bean-Header: 123456_EXT-0987654321_4711-0815_3.14159", Tools.getStreamTools()
        .getStreamContentAsString(lResponse
            .getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testPathlessRESTController( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/doSomething");

    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("Something", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testCustomHeaders( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/products/technicalHeaderBeanParam");

    lRequest.addHeader("Reseller", "Fancy Company");
    lRequest.addHeader("Custom-Header", "MyCustomHeaderValue");

    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("MyCustomHeaderValue", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testDataTypesAsQueryParams( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testDataTypeAsQueryParam");
    lRequest.addParameter("bookingCode", "Just-a-Booking-Code");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("Just-a-Booking-Code", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testDataTypeAsBeanQueryParam");
    lRequest.addParameter("bookingCode", "Just-a-Booking-Code");
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("Bean: Just-a-Booking-Code", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMultivaluedQueryParams( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testPrimitiveArrayAsQueryParam");
    lRequest.addParameter("intValues", "1,2,4711,9");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("[1, 2, 4711, 9]", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testSimpleTypesAsQueryParams");
    lRequest.addParameter("strings", "Hello,World,!,XYZ ");
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("[XYZ, !, World, Hello]", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());

    lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testPrimitiveWrapperArrayAsQueryParam");
    lRequest.addParameter("integers", "1, 3, 2, 47,-21");
    lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("[-21, 1, 2, 3, 47]", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity()
        .getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMultivaluedQueryParamsBean( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testMultivaluedQueryParamsBean");
    lRequest.addParameter("intArray", "1,4,2");
    lRequest.addParameter("integers", "10 , 40 ,  20 ");
    lRequest.addParameter("strings", " Hello , World ,  of REST ");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("[1, 4, 2]_[10, 40, 20]_[Hello, World, of REST]", Tools.getStreamTools().getStreamContentAsString(
        lResponse.getEntity()
            .getContent()));
    assertEquals(200, lResponse.getCode());
  }

  @Test
  void testMulitvaluedDataTypeAsQueryParam( ) throws IOException {
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.get(template.getRootUri() + PREFIX
        + "/rest-products/testMulitvaluedDataTypeAsQueryParam");
    lRequest.addParameter("codes", "1,4,2");
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest.build());
    assertEquals("1.4.2.", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));
    assertEquals(200, lResponse.getCode());
  }

}
