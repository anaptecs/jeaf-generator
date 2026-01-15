/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.InventoryType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class BookingID.
 */
public class BookingIDDeserializerV3 extends ValueDeserializer<BookingID> {
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
  public BookingIDDeserializerV3( CompositeTypeConverter pDeserializer ) {
    deserializer = pDeserializer;
  }

  @Override
  public BookingID deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof StringNode) {
      // Convert public string representation of BookingID into real object.
      BookingID lDeserializedObject =
          deserializer.deserializeObject(lNode.asString(), BookingID.class, SERIALIZED_CLASSES);
      BookingID.Builder lBuilder;
      if (lDeserializedObject != null) {
        lBuilder = lDeserializedObject.toBuilder();
      }
      else {
        lBuilder = BookingID.builder();
      }
      lBuilder.setPublicBookingID(lNode.asString());
      return lBuilder.build();
    }
    // Node is not of expected type.
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type BookingID. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}