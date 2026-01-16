/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.base.CharacterCode;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class CharacterCode.
 */
public class CharacterCodeSerializerV3 extends ValueSerializer<CharacterCode> {
  @Override
  public void serialize( CharacterCode pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeString(pObject.getCode().toString());
  }
}