/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.spring.base.MyType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class MyType.
 */
public class MyTypeDeserializer extends JsonDeserializer<MyType> {
  @Override
  public MyType deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      MyType lLiteral;
      try {
        String lLiteralName = lNode.asText();
        switch (lLiteralName) {
          case "FOO-BAR":
            lLiteral = MyType.FOO_BAR;
            break;
          default:
            lLiteral = MyType.valueOf(lLiteralName);
        }
      }
      // Literal is unknown.
      catch (IllegalArgumentException e) {
        throw new IOException("Unable to deserialize object of type 'MyType'. Literal name '" + lNode.asText()
            + "' does not match to expected vales of enum 'MyType'.");
      }
      return lLiteral;
    }
    // Node is not a TextNode
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION, MyType.class.getName(),
          lNode.toString(), lNode.getClass().getName());
    }
  }
}