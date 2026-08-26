/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups.serializers.v3;

import com.anaptecs.jeaf.junit.validationgroups.DeprecatedOpenAPIDataType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

@Deprecated
/**
 * Class implements a JSON / Jackson serializer for class DeprecatedOpenAPIDataType.
 */
public class DeprecatedOpenAPIDataTypeSerializerV3 extends ValueSerializer<DeprecatedOpenAPIDataType> {
  @Override
  public void serialize( DeprecatedOpenAPIDataType pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures
    pGenerator.writeString(pObject.getTheOneAndOnlyProperty());
  }
}