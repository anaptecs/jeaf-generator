/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.DataTypeWithDerivedProperty;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class DataTypeWithDerivedProperty.
 */
public class DataTypeWithDerivedPropertySerializerV3 extends ValueSerializer<DataTypeWithDerivedProperty> {
  @Override
  public void serialize( DataTypeWithDerivedProperty pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeNumber(pObject.getProperty());
  }
}