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
import com.anaptecs.spring.impl.SpringTestApplication;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRESTControllerTest {
  @Inject
  private TestRestTemplate template;

  @Test
  void testRESTControllerAccess( ) {
    ResponseEntity<String> lResponse = template.getForEntity("/products", String.class);
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        lResponse.getBody());
  }

  @Test
  void testAdvancedRESTControllerFeatures( ) throws Exception {
    // Execute simple request using Apache HTTP client
    CloseableHttpClient lHttpClient = HttpClientBuilder.create().build();

    ClassicHttpRequest lRequest = ClassicRequestBuilder.get(template.getRootUri() + "/products").build();
    CloseableHttpResponse lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]",
        Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    // Execute advanced request

    //
    // getProduct(...)
    //
    ClassicRequestBuilder lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/products/17");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(500, lResponse.getCode());

    //
    // getProduct(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/products/12345");
    lRequest = lBuilder.build();

    lResponse = lHttpClient.execute(lRequest);
    assertEquals(200, lResponse.getCode());
    assertEquals("", Tools.getStreamTools().getStreamContentAsString(lResponse.getEntity().getContent()));

    //
    // getSortiment(...)
    //
    lBuilder = ClassicRequestBuilder.create("GET");
    lBuilder.setUri(template.getRootUri() + "/products/sortiment/4711");
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
    ClassicRequestBuilder lRequest = ClassicRequestBuilder.post(template.getRootUri() + "/products");

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
    lRequest = ClassicRequestBuilder.post(template.getRootUri() + "/products/ChannelCode");
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
}
