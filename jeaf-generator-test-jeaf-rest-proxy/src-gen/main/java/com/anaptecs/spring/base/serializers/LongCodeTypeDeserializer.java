/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.LongCodeType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class LongCodeType.
 */
public class LongCodeTypeDeserializer extends JsonDeserializer<LongCodeType> {
  @Override
  public LongCodeType deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that objectIDs are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      return LongCodeType.Builder.newBuilder().setCode(lNode.asLong()).build();
    }
    // Node is not a TextNode
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, LongCodeType.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}
