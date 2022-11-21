/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.ByteCode;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NumericNode;

/**
 * Class implements a JSON / Jackson deserializer for class ByteCode.
 */
public class ByteCodeDeserializer extends JsonDeserializer<ByteCode> {
  @Override
  public ByteCode deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that data types are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof NumericNode) {
      NumericNode lNumericNode = (NumericNode) lNode;
      return ByteCode.builder().setCode((byte) lNumericNode.intValue()).build();
    }
    // Node is not a TextNode
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, ByteCode.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}
