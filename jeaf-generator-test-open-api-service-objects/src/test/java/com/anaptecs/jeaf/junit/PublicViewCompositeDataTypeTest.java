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

public class PublicViewCompositeDataTypeTest {
  @Test
  void testCompositeDataType( ) {
    BookingID lBookingID = BookingID.builder().setBookingID("123456").build();
    Booking lBooking = Booking.builder().setBookingID(lBookingID).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lBooking);
    assertEquals("{\"bookingID\":\"123456\"}", lJSON);

    Booking lReadBooking = JSON.getJSONTools().read(lJSON, Booking.class);
    assertEquals("123456", lReadBooking.getBookingID().getBookingID());
  }

  @Test
  void testComplexCompositeDataType( ) {
    ComplexBookingID lBookingID = ComplexBookingID.builder().setBookingID("XYZ-1234567").build();
    WeirdBooking lWeirdBooking = WeirdBooking.builder().setBooking(lBookingID).build();

    String lJSON = JSON.getJSONTools().writeObjectToString(lWeirdBooking);
    assertEquals("{\"booking\":\"XYZ-1234567\"}", lJSON);

    ComplexBookingID lAdditionalBooking1 = ComplexBookingID.builder().setBookingID("ADD-123-1").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking1);
    ComplexBookingID lAdditionalBooking2 = ComplexBookingID.builder().setBookingID("ADD-123-2").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking2);

    lJSON = JSON.getJSONTools().writeObjectToString(lWeirdBooking);
    assertEquals("{\"booking\":\"XYZ-1234567\",\"additionalBookings\":[\"ADD-123-1\",\"ADD-123-2\"]}", lJSON);
  }
}
