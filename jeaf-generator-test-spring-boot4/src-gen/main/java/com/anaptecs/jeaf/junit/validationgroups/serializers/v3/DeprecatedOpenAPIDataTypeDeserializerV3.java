/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups.serializers.v3;

import com.anaptecs.jeaf.junit.validationgroups.DeprecatedOpenAPIDataType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

@Deprecated
/**
 * Class implements a JSON / Jackson deserializer for class DeprecatedOpenAPIDataType.
 */
public class DeprecatedOpenAPIDataTypeDeserializerV3 extends ValueDeserializer<DeprecatedOpenAPIDataType> {
  @Override
  public DeprecatedOpenAPIDataType deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pContext.readTree(pParser);
    if (lNode instanceof StringNode) {
      return DeprecatedOpenAPIDataType.of(lNode.asString());
    }
    // Node is not of expected type.
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type DeprecatedOpenAPIDataType. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}