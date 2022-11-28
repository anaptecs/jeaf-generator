/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.junit.openapi.base.Booking;
import com.anaptecs.jeaf.junit.openapi.base.BookingCode;
import com.anaptecs.jeaf.junit.openapi.base.BookingID;
import com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID;
import com.anaptecs.jeaf.junit.openapi.base.ComplexBookingType;
import com.anaptecs.jeaf.junit.openapi.base.InventoryType;
import com.anaptecs.jeaf.junit.openapi.base.WeirdBooking;
import com.anaptecs.jeaf.xfun.api.XFun;

public class InternalViewCompositeDataTypeTest {
  @Test
  void testCompositeDataType( ) {
    BookingCode lBookingCode = BookingCode.builder().setCode("BOOKING_CODE").build();
    BookingID lBookingID = BookingID.builder().setBookingCode(lBookingCode).setInventory(InventoryType.SBB)
        .setReferenceID("123456").setExternalRefID("EXT-0987654321").build();
    Booking lBooking = Booking.builder().setBookingID(lBookingID).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lBooking);
    assertEquals("{\"bookingID\":\"DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==\"}", lJSON);

    Booking lReadBooking = JSON.getJSONTools().read(lJSON, Booking.class);
    assertEquals("123456", lReadBooking.getBookingID().getReferenceID());
    assertEquals("EXT-0987654321", lReadBooking.getBookingID().getExternalRefID());
    assertEquals(InventoryType.SBB, lReadBooking.getBookingID().getInventory());
    assertEquals("BOOKING_CODE", lReadBooking.getBookingID().getBookingCode().getCode());

    XFun.getTrace().info(lBooking.toString());
    assertEquals("com.anaptecs.jeaf.junit.openapi.base.Booking" + System.lineSeparator() +
        "bookingID: " + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "    referenceID: 123456" + System.lineSeparator() +
        "    externalRefID: EXT-0987654321" + System.lineSeparator() +
        "    inventory: SBB" + System.lineSeparator() +
        "    bookingCode: " + System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "        code: BOOKING_CODE" + System.lineSeparator(), lBooking.toString());
  }

  @Test
  void testComplexCompositeDataType( ) {
    // Test serialization
    BookingCode lBookingCode1 = BookingCode.builder().setCode("BOOKING_CODE").build();
    BookingID lBookingID1 = BookingID.builder().setBookingCode(lBookingCode1).setInventory(InventoryType.SBB)
        .setReferenceID("123456").setExternalRefID("EXT-0987654321").build();

    BookingCode lBookingCode2 = BookingCode.builder().setCode("REFUND_CODE").build();
    BookingID lBookingID2 = BookingID.builder().setBookingCode(lBookingCode2).setInventory(InventoryType.SNCF)
        .setReferenceID("XXYYZZ").setExternalRefID("EXT_#äöß?\"§$§\"$\"%$").build();

    ComplexBookingID lComplexBookingID = ComplexBookingID.builder().setBookingIDs(Arrays.asList(lBookingID2,
        lBookingID1)).setComplexBookingType(ComplexBookingType.VERY_COMPLEX).setInternalID(123456789).setReferenceID(
            "REF-123").build();

    ComplexBookingID lAdditionalBookingID1 = ComplexBookingID.builder().setBookingIDs(Arrays.asList(lBookingID2,
        lBookingID1)).setComplexBookingType(ComplexBookingType.VERY_COMPLEX).setInternalID(9991234).setReferenceID(
            "REF-123-1").build();
    ComplexBookingID lAdditionalBookingID2 = ComplexBookingID.builder().setBookingIDs(Arrays.asList(lBookingID2))
        .setComplexBookingType(ComplexBookingType.COMPLEX).setInternalID(123456789).setReferenceID(
            "REF-123-2").build();

    WeirdBooking lWeirdBooking = WeirdBooking.builder().setBooking(lComplexBookingID).setAdditionalBookings(Arrays
        .asList(lAdditionalBookingID1,
            lAdditionalBookingID2)).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lWeirdBooking);
    assertEquals(
        "{\"objectType\":\"WeirdBooking\",\"booking\":\"AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgKq03nVSRUYtMTKz\",\"additionalBookings\":[\"AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgITRwwlSRUYtMTIzLbE=\",\"AAyCDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraAQGAqrTedVJFRi0xMjMtsg==\"],\"childProperty\":0}",
        lJSON);

    WeirdBooking lReadBooking = JSON.getJSONTools().read(lJSON, WeirdBooking.class);
    assertEquals(123456789, lReadBooking.getBooking().getInternalID());
    assertEquals("REF-123", lReadBooking.getBooking().getReferenceID());
    assertEquals(ComplexBookingType.VERY_COMPLEX, lReadBooking.getBooking().getComplexBookingType());

    // Test BookingIDs
    assertEquals("XXYYZZ", lReadBooking.getBooking().getBookingIDs().get(0).getReferenceID());
    assertEquals("EXT_#äöß?\"§$§\"$\"%$", lReadBooking.getBooking().getBookingIDs().get(0).getExternalRefID());
    assertEquals("REFUND_CODE", lReadBooking.getBooking().getBookingIDs().get(0).getBookingCode().getCode());
    assertEquals(InventoryType.SNCF, lReadBooking.getBooking().getBookingIDs().get(0).getInventory());

    assertEquals("123456", lReadBooking.getBooking().getBookingIDs().get(1).getReferenceID());
    assertEquals("EXT-0987654321", lReadBooking.getBooking().getBookingIDs().get(1).getExternalRefID());
    assertEquals("BOOKING_CODE", lReadBooking.getBooking().getBookingIDs().get(1).getBookingCode().getCode());
    assertEquals(InventoryType.SBB, lReadBooking.getBooking().getBookingIDs().get(1).getInventory());

    // Test additional bookings
    assertEquals(2, lReadBooking.getAdditionalBookings().size());
    assertEquals(9991234, lReadBooking.getAdditionalBookings().get(0).getInternalID());
    assertEquals("REF-123-1", lReadBooking.getAdditionalBookings().get(0).getReferenceID());
    assertEquals(ComplexBookingType.VERY_COMPLEX, lReadBooking.getAdditionalBookings().get(0).getComplexBookingType());
    assertEquals(2, lReadBooking.getAdditionalBookings().get(0).getBookingIDs().size());

    assertEquals(123456789, lReadBooking.getAdditionalBookings().get(1).getInternalID());
    assertEquals("REF-123-2", lReadBooking.getAdditionalBookings().get(1).getReferenceID());
    assertEquals(ComplexBookingType.COMPLEX, lReadBooking.getAdditionalBookings().get(1).getComplexBookingType());
    assertEquals(1, lReadBooking.getAdditionalBookings().get(1).getBookingIDs().size());

    XFun.getTrace().info(lWeirdBooking.toString());
    assertEquals("com.anaptecs.jeaf.junit.openapi.base.WeirdBooking" + System.lineSeparator() +
        "someProperty: null" + System.lineSeparator() +
        "complexBooking:  null" + System.lineSeparator() +
        "complexBookings: 0 element(s)" + System.lineSeparator() +
        "booking: " + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 123456789" + System.lineSeparator() +
        "    referenceID: REF-123" + System.lineSeparator() +
        "    bookingIDs: 2 element(s)" + System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "        referenceID: 123456" + System.lineSeparator() +
        "        externalRefID: EXT-0987654321" + System.lineSeparator() +
        "        inventory: SBB" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "            code: BOOKING_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: VERY_COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        "additionalBookings: 2 element(s)" + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 9991234" + System.lineSeparator() +
        "    referenceID: REF-123-1" + System.lineSeparator() +
        "    bookingIDs: 2 element(s)" + System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "        referenceID: 123456" + System.lineSeparator() +
        "        externalRefID: EXT-0987654321" + System.lineSeparator() +
        "        inventory: SBB" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "            code: BOOKING_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: VERY_COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 123456789" + System.lineSeparator() +
        "    referenceID: REF-123-2" + System.lineSeparator() +
        "    bookingIDs: 1 element(s)" + System.lineSeparator() +
        "        com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.jeaf.junit.openapi.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        System.lineSeparator() +
        "versionedObjectSoftLink:  null" + System.lineSeparator() +
        "childProperty: 0" + System.lineSeparator() +
        "realBooking:  null" + System.lineSeparator() +
        "inventories: 0 element(s)" + System.lineSeparator(), lWeirdBooking.toString());

  }
}
