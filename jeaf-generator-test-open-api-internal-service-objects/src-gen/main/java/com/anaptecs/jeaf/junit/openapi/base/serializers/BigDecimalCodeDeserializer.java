/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NumericNode;

/**
 * Class implements a JSON / Jackson deserializer for class BigDecimalCode.
 */
public class BigDecimalCodeDeserializer extends JsonDeserializer<BigDecimalCode> {
  @Override
  public BigDecimalCode deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that data types are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof NumericNode) {
      NumericNode lNumericNode = (NumericNode) lNode;
      return BigDecimalCode.builder().setCode(lNumericNode.decimalValue()).build();
    }
    // Node is not a TextNode
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION,
          BigDecimalCode.class.getName(), lNode.toString(), lNode.getClass().getName());
    }
  }
}