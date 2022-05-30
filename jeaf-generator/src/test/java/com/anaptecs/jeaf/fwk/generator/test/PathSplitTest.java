package com.anaptecs.jeaf.fwk.generator.test;

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
}
