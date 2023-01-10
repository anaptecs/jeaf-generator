/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.CurrencyCode;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class CurrencyCode.
 */
public class CurrencyCodeDeserializer extends JsonDeserializer<CurrencyCode> {
  @Override
  public CurrencyCode deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    if (lNode instanceof TextNode) {
      return CurrencyCode.builder().setCode(lNode.asText()).build();
    }
    // Node is not of expected type.
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, CurrencyCode.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}
