/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.serializers;

import com.anaptecs.spring.service.MySortCriteria;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class MySortCriteria.
 */
public class MySortCriteriaDeserializerV3 extends ValueDeserializer<MySortCriteria> {
  @Override
  public MySortCriteria deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof StringNode) {
      // Convert public string representation of MySortCriteria into real object.
      return MySortCriteria.deserialize(lNode.asString());
    }
    // Node is not of expected type.
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type MySortCriteria. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}