package com.anaptecs.jeaf.fwk.generator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.anaptecs.jeaf.fwk.generator.util.OpenAPIHelper;
import org.junit.jupiter.api.Test;

public class PathSplitTest {
  @Test
  void testPathSplit( ) {
    String[] lParts = OpenAPIHelper.splitRESTPath("{id}sortiment/{id}/something/{productID}/more", "id", "productID");
    assertEquals("{id}", lParts[0]);
    assertEquals("sortiment/", lParts[1]);
    assertEquals("{id}", lParts[2]);
    assertEquals("/something/", lParts[3]);
    assertEquals("{productID}", lParts[4]);
    assertEquals("/more", lParts[5]);
    assertEquals(6, lParts.length);

    lParts = OpenAPIHelper.splitRESTPath("hello/{customerID}-{orderID}/list", "customerID", "orderID");
    assertEquals("hello/", lParts[0]);
    assertEquals("{customerID}", lParts[1]);
    assertEquals("-", lParts[2]);
    assertEquals("{orderID}", lParts[3]);
    assertEquals("/list", lParts[4]);
    assertEquals(5, lParts.length);
  }

  @Test
  void testListBasedSplit( ) {
    List<String> lParamNames = java.util.Arrays.asList(new String[] { "id", "productID" });
    List<String> lVariableNames = java.util.Arrays.asList(new String[] { "pTheID", "pProductID" });
    List<String> lParts =
        OpenAPIHelper.splitRESTPath("{id}sortiment/{id}/something/{productID}/more", lParamNames, lVariableNames);
    System.out.println(lParts);
    assertEquals("pTheID", lParts.get(0));
    assertEquals("\"sortiment/\"", lParts.get(1));
    assertEquals("pTheID", lParts.get(2));
    assertEquals("\"/something/\"", lParts.get(3));
    assertEquals("pProductID", lParts.get(4));
    assertEquals("\"/more\"", lParts.get(5));
    assertEquals(6, lParts.size());
  }

  @Test
  void testRESTPathParamsDetection( ) {
    String lTest = "/path/{abc_123}/{xyz}-hello/{abc-2}";
    List<String> lParamNames = OpenAPIHelper.extractRESTParamsFromPath(lTest);
    assertEquals(3, lParamNames.size());
    assertEquals("abc_123", lParamNames.get(0));
    assertEquals("xyz", lParamNames.get(1));
    assertEquals("abc-2", lParamNames.get(2));
  }

  @Test
  void testDetectMissingRESTParams( ) {
    java.util.List<String> lMissingPathParams =
        OpenAPIHelper.detectMissingRESTPathParams("/path/{abc_123}/{xyz}-hello/{abc-2}", java.util.Arrays
            .asList("abc_123"));
    assertEquals(2, lMissingPathParams.size());
    assertEquals("xyz", lMissingPathParams.get(0));
    assertEquals("abc-2", lMissingPathParams.get(1));
  }

  @Test
  void testDetectDeadRESTParams( ) {
    java.util.List<String> lMissingPathParams =
        OpenAPIHelper.detectDeadRESTPathParams("/path/{abc_123}/{xyz}-hello/{abc-2}", java.util.Arrays
            .asList(new String[] { "abc_12", "abc_123", "xyz" }));
    assertEquals(1, lMissingPathParams.size());
    assertEquals("abc_12", lMissingPathParams.get(0));
  }

}
