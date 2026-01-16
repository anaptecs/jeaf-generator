/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.base.CharacterCodeType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class CharacterCodeType.
 */
public class CharacterCodeTypeSerializerV3 extends ValueSerializer<CharacterCodeType> {
  @Override
  public void serialize( CharacterCodeType pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeString(Character.toString(pObject.getCode()));
  }
}