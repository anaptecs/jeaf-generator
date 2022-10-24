/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.spring.base.Booking;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.WeirdBooking;
import com.anaptecs.spring.impl.SpringTestApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PublicViewCompositeDataTypeTest {
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testCompositeDataType( ) throws JsonProcessingException {
    BookingID lBookingID = BookingID.builder().setBookingID("123456").build();
    Booking lBooking = Booking.builder().setCustomerName("Donald Duck").setBookingID(lBookingID).build();

    XFun.getTrace().info("\n" + lBooking.toString());

    String lJSON = objectMapper.writeValueAsString(lBooking);
    assertEquals("{\"bookingID\":\"123456\"}", lJSON);

    Booking lReadBooking = objectMapper.readValue(lJSON, Booking.class);
    assertEquals("123456", lReadBooking.getBookingID().getBookingID());
  }

  @Test
  void testComplexCompositeDataType( ) throws JsonProcessingException {
    ComplexBookingID lBookingID = ComplexBookingID.builder().setBookingID("XYZ-1234567").build();
    WeirdBooking lWeirdBooking = WeirdBooking.builder().setBooking(lBookingID).build();

    assertEquals("", lWeirdBooking.toString());

    String lJSON = objectMapper.writeValueAsString(lWeirdBooking);
    assertEquals("{\"booking\":\"XYZ-1234567\"}", lJSON);

    ComplexBookingID lAdditionalBooking1 = ComplexBookingID.builder().setBookingID("ADD-123-1").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking1);
    ComplexBookingID lAdditionalBooking2 = ComplexBookingID.builder().setBookingID("ADD-123-2").build();
    lWeirdBooking.addToAdditionalBookings(lAdditionalBooking2);

    lJSON = objectMapper.writeValueAsString(lWeirdBooking);
    assertEquals("{\"booking\":\"XYZ-1234567\",\"additionalBookings\":[\"ADD-123-1\",\"ADD-123-2\"]}", lJSON);
  }
}
