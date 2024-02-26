/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom.serializers;

import java.io.IOException;

import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class DataTypeCustomSerialization.
 */
public class DataTypeCustomSerializationSerializer extends JsonSerializer<DataTypeCustomSerialization> {
  @Override
  public void serialize( DataTypeCustomSerialization pObject, JsonGenerator pGenerator,
      SerializerProvider pSerializers )
    throws IOException {
    pGenerator.writeString(pObject.getMagic());
  }
}
