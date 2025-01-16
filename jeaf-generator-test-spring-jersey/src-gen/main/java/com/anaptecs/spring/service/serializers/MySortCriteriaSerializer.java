/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.serializers;

import java.io.IOException;

import com.anaptecs.spring.service.MySortCriteria;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class MySortCriteria.
 */
public class MySortCriteriaSerializer extends JsonSerializer<MySortCriteria> {
  @Override
  public void serialize( MySortCriteria pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    // Convert MySortCriteria into an public string only representation.
    pGenerator.writeString(pObject.serialize());
  }
}