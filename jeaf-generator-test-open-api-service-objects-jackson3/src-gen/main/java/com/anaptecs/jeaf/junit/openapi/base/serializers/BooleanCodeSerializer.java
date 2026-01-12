/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.junit.openapi.base.BooleanCode;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class BooleanCode.
 */
public class BooleanCodeSerializer extends JsonSerializer<BooleanCode> {
  @Override
  public void serialize( BooleanCode pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeBoolean(pObject.getCode());
  }
}