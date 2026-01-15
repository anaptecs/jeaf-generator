/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.composite.serializers;

import com.anaptecs.spring.composite.ComplexBookingID;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class ComplexBookingID.
 */
public class ComplexBookingIDSerializerV3 extends ValueSerializer<ComplexBookingID> {
  @Override
  public void serialize( ComplexBookingID pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    pGenerator.writeString(pObject.getBookingID());
  }
}