/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.composite.serializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.junit.openapi.base.BookingCode;
import com.anaptecs.jeaf.junit.openapi.base.BookingID;
import com.anaptecs.jeaf.junit.openapi.base.ComplexBookingType;
import com.anaptecs.jeaf.junit.openapi.base.InventoryType;
import com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID;
import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.api.jeaf.CompositeTypeConverterServiceProvider;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class ComplexBookingID.
 */
public class ComplexBookingIDDeserializer extends JsonDeserializer<ComplexBookingID> {
  /**
   * List contains all classes that are involved in the serialization process. This information is required by some
   * serialization mechanisms for efficiency and security reasons.
   */
  private static final List<Class<?>> SERIALIZED_CLASSES;
  static {
    List<Class<?>> lClasses =
        Arrays.asList(ComplexBookingID.class, ArrayList.class, BookingID.class, InventoryType.class, BookingCode.class,
            ComplexBookingType.class, ComplexBookingType.ComplexBookingTypeType.class);
    SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * Deserializer is used to convert a String representation of composite data type ComplexBookingID back into an real
   * object.
   */
  private CompositeTypeConverter deserializer;

  @Override
  public ComplexBookingID deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    if (lNode instanceof TextNode) {
      // Convert public string representation of ComplexBookingID into real object.
      return this.getDeserializer().deserializeObject(lNode.asText(), ComplexBookingID.class, SERIALIZED_CLASSES);
    }
    // Node is not of expected type.
    else {
      throw new JEAFSystemException(JSONMessages.UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION,
          ComplexBookingID.class.getName(), lNode.toString(), lNode.getClass().getName());
    }
  }

  /**
   * Method returns the {@link CompositeTypeConverter} that should be used to serialize objects.
   *
   * @return {@link CompositeTypeConverter} Deserializer that should be used. The method never returns null.
   */
  private CompositeTypeConverter getDeserializer( ) {
    if (deserializer == null) {
      deserializer = JEAF.getServiceProvider(CompositeTypeConverterServiceProvider.class);
    }
    return deserializer;
  }
}