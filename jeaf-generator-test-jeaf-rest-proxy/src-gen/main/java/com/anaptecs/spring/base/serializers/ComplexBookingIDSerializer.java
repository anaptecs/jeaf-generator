/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.api.jeaf.CompositeTypeConverterServiceProvider;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.InventoryType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Class implements a JSON / Jackson serializer for class ComplexBookingID.
 */
public class ComplexBookingIDSerializer extends JsonSerializer<ComplexBookingID> {
  /**
   * List contains all classes that are involved in the serialization process. This information is required by some
   * serialization mechanisms for efficiency and security reasons.
   */
  private static final List<Class<?>> SERIALIZED_CLASSES;
  static {
    List<Class<?>> lClasses =
        Arrays.asList(ComplexBookingID.class, ArrayList.class, BookingID.class, InventoryType.class, BookingCode.class,
            ComplexBookingType.class, ComplexBookingType.ComplexBookingTypeType.class, String[].class);
    SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * Serializer is used to convert composite data type ComplexBookingID into a String representation.
   */
  private CompositeTypeConverter serializer;

  @Override
  public void serialize( ComplexBookingID pObject, JsonGenerator pGenerator, SerializerProvider pSerializers )
    throws IOException {
    // Convert ComplexBookingID into an public string only representation.
    pGenerator.writeString(this.getSerializer().serializeObject(pObject, SERIALIZED_CLASSES));
  }

  /**
   * Method returns the {@link CompositeTypeConverter} that should be used to serialize objects.
   * 
   * @return {@link CompositeTypeConverter} Serializer that should be used. The method never returns null.
   */
  private CompositeTypeConverter getSerializer( ) {
    if (serializer == null) {
      serializer = JEAF.getServiceProvider(CompositeTypeConverterServiceProvider.class);
    }
    return serializer;
  }
}
