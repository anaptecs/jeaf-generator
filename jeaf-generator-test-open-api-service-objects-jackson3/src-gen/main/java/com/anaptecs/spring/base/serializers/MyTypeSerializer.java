/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.MyType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class MyType.
 */
public class MyTypeSerializer extends ValueSerializer<MyType> {
  @Override
  public void serialize( MyType pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
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