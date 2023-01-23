/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.spring.base.Booking;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.InventoryType;
import com.anaptecs.spring.base.WeirdBooking;
import com.anaptecs.spring.impl.SpringTestApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InternalViewCompositeDataTypeTest {
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testCompositeDataType( ) throws JsonProcessingException {
    BookingCode lBookingCode = BookingCode.builder().setCode("BOOKING_CODE").build();
    BookingID lBookingID = BookingID.builder().setBookingCode(lBookingCode).setInventory(InventoryType.SBB)
        .setReferenceID("123456").setExternalRefID("EXT-0987654321").build();
    Booking lBooking = Booking.builder().setCustomerName("Daisy Duck").setBookingID(lBookingID).build();

    XFun.getTrace().info("\n" + lBooking);
    assertEquals("com.anaptecs.spring.base.Booking" + System.lineSeparator() +
        "bookingID: " + System.lineSeparator() +
        "    com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "    publicBookingID: null" + System.lineSeparator() +
        "    referenceID: 123456" + System.lineSeparator() +
        "    externalRefID: EXT-0987654321" + System.lineSeparator() +
        "    inventory: SBB" + System.lineSeparator() +
        "    bookingCode: " + System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "        code: BOOKING_CODE" + System.lineSeparator() +
        "customerName: Daisy Duck" + System.lineSeparator() +
        "inventories: 0 element(s)" + System.lineSeparator(), lBooking.toString());

    String lJSON = objectMapper.writeValueAsString(lBooking);
    assertEquals("{\"bookingID\":\"DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==\",\"customerName\":\"Daisy Duck\"}",
        lJSON);

    Booking lReadBooking = objectMapper.readValue(lJSON, Booking.class);
    assertEquals("123456", lReadBooking.getBookingID().getReferenceID());
    assertEquals("EXT-0987654321", lReadBooking.getBookingID().getExternalRefID());
    assertEquals(InventoryType.SBB, lReadBooking.getBookingID().getInventory());
    assertEquals("BOOKING_CODE", lReadBooking.getBookingID().getBookingCode().getCode());
    assertEquals("DUJPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tg==", lReadBooking.getBookingID().getPublicBookingID());

    lBooking = Booking.builder().build();
    XFun.getTrace().info("\n" + lBooking);
    assertEquals("com.anaptecs.spring.base.Booking" + System.lineSeparator() +
        "bookingID:  null" + System.lineSeparator() +
        "customerName: null" + System.lineSeparator() + "inventories: 0 element(s)" + System.lineSeparator(), lBooking
            .toString());
  }

  @Test
  void testComplexCompositeDataType( ) throws JsonProcessingException {
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
            "REF-123-1").setStrings(new String[] { "Hello", "World!" }).build();
    ComplexBookingID lAdditionalBookingID2 = ComplexBookingID.builder().setBookingIDs(Arrays.asList(lBookingID2))
        .setComplexBookingType(ComplexBookingType.COMPLEX).setInternalID(123456789).setReferenceID(
            "REF-123-2").build();

    WeirdBooking lWeirdBooking = WeirdBooking.builder().setBooking(lComplexBookingID).setAdditionalBookings(Arrays
        .asList(lAdditionalBookingID1,
            lAdditionalBookingID2)).build();

    XFun.getTrace().info("\n" + lWeirdBooking);
    assertEquals("com.anaptecs.spring.base.WeirdBooking" + System.lineSeparator() +
        "booking: " + System.lineSeparator() +
        "    com.anaptecs.spring.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 123456789" + System.lineSeparator() +
        "    referenceID: REF-123" + System.lineSeparator() +
        "    bookingIDs: 2 element(s)" + System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "        publicBookingID: null" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "        publicBookingID: null" + System.lineSeparator() +
        "        referenceID: 123456" + System.lineSeparator() +
        "        externalRefID: EXT-0987654321" + System.lineSeparator() +
        "        inventory: SBB" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "            code: BOOKING_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: VERY_COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        "    strings:  null" + System.lineSeparator() +
        "additionalBookings: 2 element(s)" + System.lineSeparator() +
        "    com.anaptecs.spring.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 9991234" + System.lineSeparator() +
        "    referenceID: REF-123-1" + System.lineSeparator() +
        "    bookingIDs: 2 element(s)" + System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "        publicBookingID: null" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "        publicBookingID: null" + System.lineSeparator() +
        "        referenceID: 123456" + System.lineSeparator() +
        "        externalRefID: EXT-0987654321" + System.lineSeparator() +
        "        inventory: SBB" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "            code: BOOKING_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: VERY_COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        "    strings: [Hello, World!]" + System.lineSeparator() +
        System.lineSeparator() +
        "    com.anaptecs.spring.base.ComplexBookingID" + System.lineSeparator() +
        "    internalID: 123456789" + System.lineSeparator() +
        "    referenceID: REF-123-2" + System.lineSeparator() +
        "    bookingIDs: 1 element(s)" + System.lineSeparator() +
        "        com.anaptecs.spring.base.BookingID" + System.lineSeparator() +
        "        publicBookingID: null" + System.lineSeparator() +
        "        referenceID: XXYYZZ" + System.lineSeparator() +
        "        externalRefID: EXT_#äöß?\"§$§\"$\"%$" + System.lineSeparator() +
        "        inventory: SNCF" + System.lineSeparator() +
        "        bookingCode: " + System.lineSeparator() +
        "            com.anaptecs.spring.base.BookingCode" + System.lineSeparator() +
        "            code: REFUND_CODE" + System.lineSeparator() +
        System.lineSeparator() +
        "    complexBookingType: COMPLEX" + System.lineSeparator() +
        "    anotherID: null" + System.lineSeparator() +
        "    strings:  null" + System.lineSeparator() +
        System.lineSeparator(), lWeirdBooking.toString());

    String lJSON = objectMapper.writeValueAsString(lWeirdBooking);
    assertEquals(
        "{\"booking\":\"AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgKq03nVSRUYtMTKzAA==\",\"additionalBookings\":[\"AAyDDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraD0JPT0tJTkdfQ09ExUVYVC0wOTg3NjU0MzKxATEyMzQ1tgECgITRwwlSRUYtMTIzLbEDSGVsbO9Xb3JsZKE=\",\"AAyCDQAPUkVGVU5EX0NPRMWTRVhUXyPDpMO2w58_IsKnJMKnIiQiJSQCWFhZWVraAQGAqrTedVJFRi0xMjMtsgA=\"]}",
        lJSON);

    WeirdBooking lReadBooking = objectMapper.readValue(lJSON, WeirdBooking.class);
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
    assertEquals("Hello", lReadBooking.getAdditionalBookings().get(0).getStrings()[0]);
    assertEquals("World!", lReadBooking.getAdditionalBookings().get(0).getStrings()[1]);

    assertEquals(123456789, lReadBooking.getAdditionalBookings().get(1).getInternalID());
    assertEquals("REF-123-2", lReadBooking.getAdditionalBookings().get(1).getReferenceID());
    assertEquals(ComplexBookingType.COMPLEX, lReadBooking.getAdditionalBookings().get(1).getComplexBookingType());
    assertEquals(1, lReadBooking.getAdditionalBookings().get(1).getBookingIDs().size());
    assertEquals(null, lReadBooking.getAdditionalBookings().get(1).getStrings());
  }

  @Test
  void testEqualsHashCodeForDataType( ) {
    double lAlmostPI = 3.1415;
    DoubleCode lDoubleCode1 = DoubleCode.builder().setCode(lAlmostPI).build();
    DoubleCode lDoubleCode2 = DoubleCode.builder().setCode(3.1415).build();
    DoubleCode lDoubleCodeOther = DoubleCode.builder().setCode(3.1).build();

    assertEquals(lDoubleCode1, lDoubleCode2);
    assertEquals(lDoubleCode1.hashCode(), lDoubleCode2.hashCode());

    assertEquals(lDoubleCode1, lDoubleCode1);

    assertNotEquals(lDoubleCode1, lDoubleCodeOther);
    assertNotEquals("Hello", lDoubleCode1);
  }
}
