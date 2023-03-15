/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.spring.base.ComplexBookingType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class ComplexBookingType.
 */
public class ComplexBookingTypeDeserializer extends JsonDeserializer<ComplexBookingType> {
  @Override
  public ComplexBookingType deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      ComplexBookingType lLiteral;
      try {
        String lLiteralName = lNode.asText();
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
      throw new IOException(
          "Unable to deserialize object of type ''ComplexBookingType''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}
