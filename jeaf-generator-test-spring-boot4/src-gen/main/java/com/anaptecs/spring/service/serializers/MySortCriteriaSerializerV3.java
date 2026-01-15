/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.serializers;

import com.anaptecs.spring.service.MySortCriteria;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class MySortCriteria.
 */
public class MySortCriteriaSerializerV3 extends ValueSerializer<MySortCriteria> {
  @Override
  public void serialize( MySortCriteria pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Convert MySortCriteria into an public string only representation.
    pGenerator.writeString(pObject.serialize());
  }
}