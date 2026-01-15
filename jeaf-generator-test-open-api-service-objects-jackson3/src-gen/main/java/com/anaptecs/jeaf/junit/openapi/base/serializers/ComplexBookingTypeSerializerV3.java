/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import com.anaptecs.jeaf.junit.openapi.base.ComplexBookingType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class ComplexBookingType.
 */
public class ComplexBookingTypeSerializerV3 extends ValueSerializer<ComplexBookingType> {
  @Override
  public void serialize( ComplexBookingType pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures. Existing toString() operation is exactly what
    // we need.
    pGenerator.writeString(pObject.toString());
  }
}