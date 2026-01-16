/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.custom.serializers;

import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class DataTypeCustomSerialization.
 */
public class DataTypeCustomSerializationSerializer extends ValueSerializer<DataTypeCustomSerialization> {
  @Override
  public void serialize( DataTypeCustomSerialization pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    pGenerator.writeString(pObject.getMagic());
  }
}