/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.openapi.base.BookingCode;
import com.anaptecs.jeaf.junit.openapi.base.BookingID;
import com.anaptecs.jeaf.junit.openapi.base.ChildAA;
import com.anaptecs.jeaf.junit.openapi.base.InventoryType;
import com.anaptecs.jeaf.junit.openapi.base.ProductCode;

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
    String lReferenceID = "pReferenceID";
    String lExternalRefID = "pExternalRefID";
    InventoryType lInventory = InventoryType.SBB;
    BookingCode lBookingCode = BookingCode.builder("My-Booking-1234").build();
    BookingID lBookingID = BookingID.builder(lReferenceID, lExternalRefID, lInventory, lBookingCode).build();
    assertEquals(lReferenceID, lBookingID.getReferenceID());
    assertEquals(lExternalRefID, lBookingID.getExternalRefID());
    assertEquals(lInventory, lBookingID.getInventory());

    // Test standard POJO
    ProductCode lProductCode = ProductCode.builder(125).build();
    assertEquals(125, lProductCode.getCode());
  }
}
