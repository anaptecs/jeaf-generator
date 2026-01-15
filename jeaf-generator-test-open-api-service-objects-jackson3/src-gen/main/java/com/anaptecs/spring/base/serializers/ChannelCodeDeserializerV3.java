/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.ChannelCode;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class ChannelCode.
 */
public class ChannelCodeDeserializerV3 extends ValueDeserializer<ChannelCode> {
  @Override
  public ChannelCode deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof StringNode) {
      return ChannelCode.builder().setCode(lNode.asString()).build();
    }
    // Node is not of expected type.
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, ChannelCode.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}