/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class MockServer {
  public static final int MOCK_PORT = 8099;

  public static void main( String[] pArguments ) {
    try {
      // Disable logging of mock server
      System.setProperty("mockserver.logLevel", "ERROR");

      MockServer.createMockServer();

      while (true) {
        Thread.sleep(10000);
      }
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ClientAndServer createMockServer( ) throws IOException {
    ClientAndServer lMockServer = ClientAndServer.startClientAndServer(MOCK_PORT);
    assertEquals(true, lMockServer.isRunning());

    // Add mock responses
    MockServer.addMockResponse("/rest-products",
        "[{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}]", 1);
    // MockServer.addMockResponse("/rest-products", "" + "", 1);
    MockServer.addMockResponse("/rest-products/12345",
        "{\"name\":\"Cool Product\",\"uri\":\"https://products.anaptecs.de/123456789\"}", 1);
    MockServer.addMockResponse("/rest-products/4711", "", 1);
    MockServer.addMockResponse("/rest-products/currencies/0815", null, MOCK_PORT);

    return lMockServer;
  }

  private static void addMockResponse( String pRequestURI, String pResponseBody, int pDelay ) throws IOException {
    @SuppressWarnings("resource")
    MockServerClient lClient = new MockServerClient("localhost", MOCK_PORT);
    HttpRequest lMockRequest = HttpRequest.request().withPath(pRequestURI);
    HttpResponse lMockResponse =
        HttpResponse.response().withDelay(TimeUnit.MILLISECONDS, pDelay).withStatusCode(200).withBody(pResponseBody);
    lClient.when(lMockRequest).respond(lMockResponse);
  }
}
