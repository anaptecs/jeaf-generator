/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.DoubleCodeType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.NumericNode;

/**
 * Class implements a JSON / Jackson deserializer for class DoubleCodeType.
 */
public class DoubleCodeTypeDeserializerV3 extends ValueDeserializer<DoubleCodeType> {
  @Override
  public DoubleCodeType deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof NumericNode) {
      NumericNode lNumericNode = (NumericNode) lNode;
      return DoubleCodeType.of(lNumericNode.doubleValue());
    }
    // Node is not of expected type.
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type DoubleCodeType. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}