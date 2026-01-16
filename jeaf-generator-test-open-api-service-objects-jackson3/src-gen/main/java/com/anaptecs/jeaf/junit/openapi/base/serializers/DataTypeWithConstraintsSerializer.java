/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import com.anaptecs.jeaf.junit.openapi.base.DataTypeWithConstraints;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class DataTypeWithConstraints.
 */
public class DataTypeWithConstraintsSerializer extends ValueSerializer<DataTypeWithConstraints> {
  @Override
  public void serialize( DataTypeWithConstraints pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeNumber(pObject.getIntValue());
  }
}