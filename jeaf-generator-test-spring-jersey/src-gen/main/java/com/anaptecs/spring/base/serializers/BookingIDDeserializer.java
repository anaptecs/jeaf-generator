/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.InventoryType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * Class implements a JSON / Jackson deserializer for class BookingID.
 */
public class BookingIDDeserializer extends JsonDeserializer<BookingID> {
  /**
   * List contains all classes that are involved in the serialization process. This information is required by some
   * serialization mechanisms for efficiency and security reasons.
   */
  private static final List<Class<?>> SERIALIZED_CLASSES;
  static {
    List<Class<?>> lClasses = Arrays.asList(BookingID.class, InventoryType.class, BookingCode.class);
    SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * Deserializer is used to convert a String representation of composite data type BookingID back into an real object.
   */
  private final CompositeTypeConverter deserializer;

  /**
   * Initialize object.
   * 
   * @param pDeserializer Implementation of {@link CompositeTypeConverter} that should be used to create a BookingID
   * object from its String representation. The parameter must not be null.
   */
  public BookingIDDeserializer( CompositeTypeConverter pDeserializer ) {
    deserializer = pDeserializer;
  }

  @Override
  public BookingID deserialize( JsonParser pParser, DeserializationContext pContext ) throws IOException {
    // Parse JSON content.
    JsonNode lNode = pParser.getCodec().readTree(pParser);
    // We expect that data types are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof TextNode) {
      // Convert public string representation of BookingID into real object.
      return deserializer.deserializeObject(lNode.asText(), BookingID.class, SERIALIZED_CLASSES);
    }
    // Node is not a TextNode
    else {
      throw new IOException(
          "Unable to deserialize object of type BookingID. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}
