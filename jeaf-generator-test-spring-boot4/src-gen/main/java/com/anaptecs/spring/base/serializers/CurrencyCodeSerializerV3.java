/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.CurrencyCode;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class CurrencyCode.
 */
public class CurrencyCodeSerializerV3 extends ValueSerializer<CurrencyCode> {
  @Override
  public void serialize( CurrencyCode pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeString(pObject.getCode());
  }
}