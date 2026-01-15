/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.BooleanCode;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class BooleanCode.
 */
public class BooleanCodeSerializerV3 extends ValueSerializer<BooleanCode> {
  @Override
  public void serialize( BooleanCode pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeBoolean(pObject.getCode());
  }
}