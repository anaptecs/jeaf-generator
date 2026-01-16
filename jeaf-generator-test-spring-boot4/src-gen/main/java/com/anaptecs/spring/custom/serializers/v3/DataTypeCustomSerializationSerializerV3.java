/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom.serializers.v3;

import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class DataTypeCustomSerialization.
 */
public class DataTypeCustomSerializationSerializerV3 extends ValueSerializer<DataTypeCustomSerialization> {
  @Override
  public void serialize( DataTypeCustomSerialization pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    // Convert DataTypeCustomSerialization into an public string only representation.
    pGenerator.writeString(pObject.serialize());
  }
}