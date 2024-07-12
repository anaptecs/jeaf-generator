/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.junit.openapi.base.BookingID;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class BookingID.
 */
public class BookingIDSerializer extends JsonSerializer<BookingID> {
  @Override
  public void serialize( BookingID pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    pGenerator.writeString(pObject.getBookingID());
  }
}