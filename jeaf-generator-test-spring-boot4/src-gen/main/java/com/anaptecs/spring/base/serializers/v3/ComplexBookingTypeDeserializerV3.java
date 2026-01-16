/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.base.ComplexBookingType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class ComplexBookingType.
 */
public class ComplexBookingTypeDeserializerV3 extends ValueDeserializer<ComplexBookingType> {
  @Override
  public ComplexBookingType deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof StringNode) {
      ComplexBookingType lLiteral;
      try {
        String lLiteralName = lNode.asString();
        lLiteral = ComplexBookingType.valueOf(lLiteralName);
      }
      // Literal is unknown.
      catch (IllegalArgumentException e) {
        lLiteral = ComplexBookingType.UNKNOWN;
      }
      return lLiteral;
    }
    // Node is not a TextNode
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type ''ComplexBookingType''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}