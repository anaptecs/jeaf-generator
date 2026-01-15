/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.SoftLink;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class SoftLink.
 */
public class SoftLinkSerializerV3 extends ValueSerializer<SoftLink> {
  @Override
  public void serialize( SoftLink pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Convert SoftLink into an public string only representation.
    pGenerator.writeString(pObject.serialize());
  }
}