/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.junit.openapi.base.ByteCode;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class ByteCode.
 */
public class ByteCodeDeserializer extends JsonDeserializer<ByteCode> {
  @Override
  public ByteCode deserialize( JsonParser pParser, DeserializationContext pContext )
    throws IOException, JacksonException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that objectIDs are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      return ByteCode.Builder.newBuilder().setCode((byte) lNode.asInt()).build();
    }
    // Node is not a TextNode
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_OBJECT_ID_DESERIAL, lNode.toString(),
          lNode.getClass().getName());
    }
  }
}
