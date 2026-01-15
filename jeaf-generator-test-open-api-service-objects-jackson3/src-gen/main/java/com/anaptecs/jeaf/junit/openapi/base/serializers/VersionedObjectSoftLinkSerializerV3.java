/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class VersionedObjectSoftLink.
 */
public class VersionedObjectSoftLinkSerializerV3 extends ValueSerializer<VersionedObjectSoftLink> {
  @Override
  public void serialize( VersionedObjectSoftLink pObject, JsonGenerator pGenerator,
      SerializationContext pSerializers ) {
    pGenerator.writeString(pObject.getObjectID());
  }
}