/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.spring.base.SoftLink;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class SoftLink.
 */
public class SoftLinkSerializer extends JsonSerializer<SoftLink> {
  @Override
  public void serialize( SoftLink pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    pGenerator.writeString(pObject.getOpenID());
  }
}