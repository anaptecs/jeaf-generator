/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite.serializers.v3;

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
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class ComplexBookingID.
 */
public class ComplexBookingIDSerializerV3 extends ValueSerializer<ComplexBookingID> {
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
   * Serializer is used to convert composite data type ComplexBookingID into a String representation.
   */
  private final CompositeTypeConverter serializer;

  /**
   * Initialize object.
   *
   * @param pSerializer Implementation of {@link CompositeTypeConverter} that should be used to create a String
   * representation of ComplexBookingID. The parameter must not be null.
   */
  public ComplexBookingIDSerializerV3( CompositeTypeConverter pSerializer ) {
    serializer = pSerializer;
  }

  @Override
  public void serialize( ComplexBookingID pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Convert ComplexBookingID into an public string only representation.
    pGenerator.writeString(serializer.serializeObject(pObject, SERIALIZED_CLASSES));
  }
}