/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.composite.serializers;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class ComplexBookingID.
 */
public class ComplexBookingIDDeserializerV3 extends ValueDeserializer<ComplexBookingID> {
  @Override
  public ComplexBookingID deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof StringNode) {
      return ComplexBookingID.builder().setBookingID(lNode.asString()).build();
    }
    // Node is not of expected type.
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION,
          ComplexBookingID.class.getName(), lNode.toString(), lNode.getClass().getName());
    }
  }
}