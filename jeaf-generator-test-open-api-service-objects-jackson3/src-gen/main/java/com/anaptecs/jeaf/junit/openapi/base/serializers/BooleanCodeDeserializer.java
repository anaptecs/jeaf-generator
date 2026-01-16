/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.junit.openapi.base.BooleanCode;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.BooleanNode;

/**
 * Class implements a JSON / Jackson deserializer for class BooleanCode.
 */
public class BooleanCodeDeserializer extends ValueDeserializer<BooleanCode> {
  @Override
  public BooleanCode deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof BooleanNode) {
      return BooleanCode.builder().setCode(lNode.asBoolean()).build();
    }
    // Node is not of expected type.
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, BooleanCode.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}