/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.junit.openapi.base.Booking;
import com.anaptecs.jeaf.junit.openapi.base.BookingID;
import com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID;
import com.anaptecs.jeaf.junit.openapi.base.WeirdBooking;
import com.anaptecs.jeaf.xfun.api.XFun;

public class PublicViewCompositeDataTypeTest {
  @Test
  void testCompositeDataType( ) {
    BookingID lBookingID = BookingID.builder().setBookingID("123456").build();
    Booking lBooking = Booking.builder().setBookingID(lBookingID).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lBooking);
    assertEquals("{\"bookingID\":\"123456\"}", lJSON);

    Booking lReadBooking = JSON.getJSONTools().read(lJSON, Booking.class);
    assertEquals("123456", lReadBooking.getBookingID().getBookingID());

    XFun.getTrace().info("\n" + lBooking.toString());
    assertEquals("com.anaptecs.jeaf.junit.openapi.base.Booking" + System.lineSeparator() +
        "bookingID: " + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.BookingID" + System.lineSeparator() +
        "    bookingID: 123456" + System.lineSeparator(), lBooking.toString());
  }

  @Test
  void testComplexCompositeDataType( ) {
    ComplexBookingID lBookingID = ComplexBookingID.builder().setBookingID("XYZ-1234567").build();
    WeirdBooking lWeirdBooking = WeirdBooking.builder().setBooking(lBookingID).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lWeirdBooking);
    assertEquals("{\"objectType\":\"WeirdBooking\",\"booking\":\"XYZ-1234567\",\"childProperty\":0}", lJSON);

    ComplexBookingID lAdditionalBooking1 = ComplexBookingID.builder().setBookingID("ADD-123-1").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking1);
    ComplexBookingID lAdditionalBooking2 = ComplexBookingID.builder().setBookingID("ADD-123-2").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking2);

    lJSON = JSON.getJSONTools().writeObjectToString(lWeirdBooking);
    assertEquals(
        "{\"objectType\":\"WeirdBooking\",\"booking\":\"XYZ-1234567\",\"additionalBookings\":[\"ADD-123-1\",\"ADD-123-2\"],\"childProperty\":0}",
        lJSON);

    XFun.getTrace().info(lWeirdBooking.toString());
    assertEquals("com.anaptecs.jeaf.junit.openapi.base.WeirdBooking" + System.lineSeparator() +
        "someProperty: null" + System.lineSeparator() +
        "complexBooking:  null" + System.lineSeparator() +
        "complexBookings: 0 element(s)" + System.lineSeparator() +
        "booking: " + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    bookingID: XYZ-1234567" + System.lineSeparator() +
        "additionalBookings: 2 element(s)" + System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    bookingID: ADD-123-1" + System.lineSeparator() +
        System.lineSeparator() +
        "    com.anaptecs.jeaf.junit.openapi.base.ComplexBookingID" + System.lineSeparator() +
        "    bookingID: ADD-123-2" + System.lineSeparator() +
        System.lineSeparator() +
        "versionedObjectSoftLink:  null" + System.lineSeparator() +
        "childProperty: 0" + System.lineSeparator() +
        "realBooking:  null" + System.lineSeparator() +
        "inventories: 0 element(s)" + System.lineSeparator(), lWeirdBooking.toString());

  }
}
