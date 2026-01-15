/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.ComplexBookingType;
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