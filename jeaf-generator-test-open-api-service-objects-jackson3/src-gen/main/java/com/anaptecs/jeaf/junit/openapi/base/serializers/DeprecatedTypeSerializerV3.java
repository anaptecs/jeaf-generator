/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import com.anaptecs.jeaf.junit.openapi.base.DeprecatedType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

@Deprecated
/**
 * Class implements a JSON / Jackson serializer for class DeprecatedType.
 */
public class DeprecatedTypeSerializerV3 extends ValueSerializer<DeprecatedType> {
  @Override
  public void serialize( DeprecatedType pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeNumber(pObject.getCode());
  }
}