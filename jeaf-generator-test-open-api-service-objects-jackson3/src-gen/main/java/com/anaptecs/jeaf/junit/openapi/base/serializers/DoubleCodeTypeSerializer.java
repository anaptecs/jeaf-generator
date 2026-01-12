/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.junit.openapi.base.DoubleCodeType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class DoubleCodeType.
 */
public class DoubleCodeTypeSerializer extends JsonSerializer<DoubleCodeType> {
  @Override
  public void serialize( DoubleCodeType pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeNumber(pObject.getCode());
  }
}