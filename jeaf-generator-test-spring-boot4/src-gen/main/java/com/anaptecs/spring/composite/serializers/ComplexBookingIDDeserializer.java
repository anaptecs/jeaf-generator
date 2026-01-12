/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite.serializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.InventoryType;
import com.anaptecs.spring.composite.ComplexBookingID;
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
    List<Class<?>> lClasses = Arrays.asList(ComplexBookingID.class, ArrayList.class, BookingID.class,
        InventoryType.class, BookingCode.class, ComplexBookingType.class, String[].class);
    SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * Deserializer is used to convert a String representation of composite data type ComplexBookingID back into an real
   * object.
   */
  private final CompositeTypeConverter deserializer;

  /**
   * Initialize object.
   *
   * @param pDeserializer Implementation of {@link CompositeTypeConverter} that should be used to create a
   * ComplexBookingID object from its String representation. The parameter must not be null.
   */
  public ComplexBookingIDDeserializer( CompositeTypeConverter pDeserializer ) {
    deserializer = pDeserializer;
  }

  @Override
  public ComplexBookingID deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    if (lNode instanceof TextNode) {
      // Convert public string representation of ComplexBookingID into real object.
      return deserializer.deserializeObject(lNode.asText(), ComplexBookingID.class, SERIALIZED_CLASSES);
    }
    // Node is not of expected type.
    else {
      throw new IOException(
          "Unable to deserialize object of type ComplexBookingID. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}