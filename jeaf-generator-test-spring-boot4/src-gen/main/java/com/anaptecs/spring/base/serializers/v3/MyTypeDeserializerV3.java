/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.base.MyType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class MyType.
 */
public class MyTypeDeserializerV3 extends ValueDeserializer<MyType> {
  @Override
  public MyType deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof StringNode) {
      MyType lLiteral;
      try {
        String lLiteralName = lNode.asString();
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
        throw DatabindException.from(pContext, "Unable to deserialize object of type 'MyType'. Literal name '"
            + lNode.asString() + "' does not match to expected vales of enum 'MyType'.");
      }
      return lLiteral;
    }
    // Node is not a TextNode
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type ''MyType''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}