/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v2;

import java.io.IOException;

import com.anaptecs.spring.base.MyType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class MyType.
 */
public class MyTypeSerializer extends JsonSerializer<MyType> {
  @Override
  public void serialize( MyType pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    String lLiteralName;
    switch (pObject) {
      case FOO_BAR:
        lLiteralName = "FOO-BAR";
        break;
      default:
        lLiteralName = pObject.name();
    }
    pGenerator.writeString(lLiteralName);
  }
}