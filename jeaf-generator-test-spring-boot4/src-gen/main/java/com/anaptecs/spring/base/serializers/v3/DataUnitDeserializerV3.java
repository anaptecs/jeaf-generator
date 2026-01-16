/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.base.DataUnit;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class DataUnit.
 */
public class DataUnitDeserializerV3 extends ValueDeserializer<DataUnit> {
  @Override
  public DataUnit deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof StringNode) {
      DataUnit lLiteral;
      try {
        String lLiteralName = lNode.asString();
        lLiteral = DataUnit.valueOf(lLiteralName);
      }
      // Literal is unknown.
      catch (IllegalArgumentException e) {
        lLiteral = DataUnit.UNKNOWN;
      }
      return lLiteral;
    }
    // Node is not a TextNode
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type ''DataUnit''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}