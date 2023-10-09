package com.anaptecs.jeaf.fwk.generator.test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.fwk.generator.util.OpenAPIHelper;

public class PathSplitTest {
  @Test
  void testPathSplit( ) {
    String[] lParts = OpenAPIHelper.splitRESTPath("{id}sortiment/{id}/something/{productID}/more", "id", "productID");
    TestCase.assertEquals("{id}", lParts[0]);
    TestCase.assertEquals("sortiment/", lParts[1]);
    TestCase.assertEquals("{id}", lParts[2]);
    TestCase.assertEquals("/something/", lParts[3]);
    TestCase.assertEquals("{productID}", lParts[4]);
    TestCase.assertEquals("/more", lParts[5]);
    TestCase.assertEquals(6, lParts.length);

    lParts = OpenAPIHelper.splitRESTPath("hello/{customerID}-{orderID}/list", "customerID", "orderID");
    TestCase.assertEquals("hello/", lParts[0]);
    TestCase.assertEquals("{customerID}", lParts[1]);
    TestCase.assertEquals("-", lParts[2]);
    TestCase.assertEquals("{orderID}", lParts[3]);
    TestCase.assertEquals("/list", lParts[4]);
    TestCase.assertEquals(5, lParts.length);
  }

  @Test
  void testListBasedSplit( ) {
    List<String> lParamNames = java.util.Arrays.asList(new String[] { "id", "productID" });
    List<String> lVariableNames = java.util.Arrays.asList(new String[] { "pTheID", "pProductID" });
    List<String> lParts =
        OpenAPIHelper.splitRESTPath("{id}sortiment/{id}/something/{productID}/more", lParamNames, lVariableNames);
    System.out.println(lParts);
    TestCase.assertEquals("pTheID", lParts.get(0));
    TestCase.assertEquals("\"sortiment/\"", lParts.get(1));
    TestCase.assertEquals("pTheID", lParts.get(2));
    TestCase.assertEquals("\"/something/\"", lParts.get(3));
    TestCase.assertEquals("pProductID", lParts.get(4));
    TestCase.assertEquals("\"/more\"", lParts.get(5));
    TestCase.assertEquals(6, lParts.size());
  }

  @Test
  void testRESTPathParamsDetection( ) {
    String lTest = "/path/{abc_123}/{xyz}-hello/{abc-2}";
    List<String> lParamNames = OpenAPIHelper.extractRESTParamsFromPath(lTest);
    TestCase.assertEquals(3, lParamNames.size());
    TestCase.assertEquals("abc_123", lParamNames.get(0));
    TestCase.assertEquals("xyz", lParamNames.get(1));
    TestCase.assertEquals("abc-2", lParamNames.get(2));
  }

  @Test
  void testDetectMissingRESTParams( ) {
    java.util.List<String> lMissingPathParams =
        OpenAPIHelper.detectMissingRESTPathParams("/path/{abc_123}/{xyz}-hello/{abc-2}", java.util.Arrays
            .asList("abc_123"));
    TestCase.assertEquals(2, lMissingPathParams.size());
    TestCase.assertEquals("xyz", lMissingPathParams.get(0));
    TestCase.assertEquals("abc-2", lMissingPathParams.get(1));
  }

  @Test
  void testDetectDeadRESTParams( ) {
    java.util.List<String> lMissingPathParams =
        OpenAPIHelper.detectDeadRESTPathParams("/path/{abc_123}/{xyz}-hello/{abc-2}", java.util.Arrays
            .asList(new String[] { "abc_12", "abc_123", "xyz" }));
    TestCase.assertEquals(1, lMissingPathParams.size());
    TestCase.assertEquals("abc_12", lMissingPathParams.get(0));
  }

}
