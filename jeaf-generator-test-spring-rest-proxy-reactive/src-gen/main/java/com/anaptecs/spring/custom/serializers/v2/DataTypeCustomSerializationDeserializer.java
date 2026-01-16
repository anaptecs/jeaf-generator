/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom.serializers.v2;

import java.io.IOException;

import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class DataTypeCustomSerialization.
 */
public class DataTypeCustomSerializationDeserializer extends JsonDeserializer<DataTypeCustomSerialization> {
  @Override
  public DataTypeCustomSerialization deserialize( JsonParser pParser, DeserializationContext pContext )
    throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    if (lNode instanceof TextNode) {
      return DataTypeCustomSerialization.builder().setMagic(lNode.asText()).build();
    }
    // Node is not of expected type.
    else {
      throw new IOException(
          "Unable to deserialize object of type DataTypeCustomSerialization. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}