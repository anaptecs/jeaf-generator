/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.spring.base.ExtensibleEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class ExtensibleEnum.
 */
public class ExtensibleEnumSerializer extends JsonSerializer<ExtensibleEnum> {
  @Override
  public void serialize( ExtensibleEnum pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    // Resolve name of enum literal
    String lLiteralName;
    if (pObject.isUnknownLiteral() == false) {
      lLiteralName = pObject.getLiteral().name();
    }
    // Object represent unknown literal.
    else {
      String lUnknownLiteralName = pObject.getUnknownLiteralName();
      if (lUnknownLiteralName != null) {
        lLiteralName = lUnknownLiteralName;
      }
      else {
        lLiteralName = pObject.getLiteral().name();
      }
    }
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeString(lLiteralName);
  }
}
