/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChildAA;
import com.anaptecs.spring.base.ProductCode;

public class BuilderTest {
  @Test
  void testGeneratedBuilderVariants( ) {
    // Test builder in case of inheritance
    String lParentAttribute = "pParentAttribute";
    int lChildAAttribute = 1;
    byte lChildAAAttribute = 2;
    ChildAA lChildAA = ChildAA.builder(lParentAttribute, lChildAAttribute, lChildAAAttribute).build();
    assertEquals(lParentAttribute, lChildAA.getParentAttribute());
    assertEquals(lChildAAttribute, lChildAA.getChildAAttribute());
    assertEquals(lChildAAttribute, lChildAA.getChildAAttribute());

    // Test internal view of composite data type
    String lPublicBookingID = "ABC-123-SBB";
    BookingID lBookingID = BookingID.builder(lPublicBookingID).build();
    assertEquals(lPublicBookingID, lBookingID.getBookingID());

    // Test standard POJO
    ProductCode lProductCode = ProductCode.builder(125).build();
    assertEquals(125, lProductCode.getCode());
  }
}
