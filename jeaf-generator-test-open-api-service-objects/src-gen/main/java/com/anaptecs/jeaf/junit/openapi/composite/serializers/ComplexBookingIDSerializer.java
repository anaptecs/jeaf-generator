/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.composite.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class ComplexBookingID.
 */
public class ComplexBookingIDSerializer extends JsonSerializer<ComplexBookingID> {
  @Override
  public void serialize( ComplexBookingID pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    pGenerator.writeString(pObject.getBookingID());
  }
}
