/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;

import com.anaptecs.spring.base.DataUnit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class DataUnit.
 */
public class DataUnitDeserializer extends JsonDeserializer<DataUnit> {
  @Override
  public DataUnit deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that objectIDs are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      String lLiteralName = lNode.asText();
      return DataUnit.valueOf(lLiteralName);
    }
    // Node is not a TextNode
    else {
      throw new IOException(
          "Unable to deserialize object of type ''DataUnit''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}
