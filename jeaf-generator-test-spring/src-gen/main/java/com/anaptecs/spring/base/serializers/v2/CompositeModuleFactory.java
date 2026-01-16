/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v2;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.composite.ComplexBookingID;
import com.anaptecs.spring.composite.serializers.v2.ComplexBookingIDDeserializer;
import com.anaptecs.spring.composite.serializers.v2.ComplexBookingIDSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class CompositeModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static Module createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for data types
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for composite data types.
   */
  public static Module createCompositeDataTypeSerializerModule( CompositeTypeConverter pCompositeTypeConverter ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule =
        new SimpleModule("CompositeDataTypeSerializerModule." + CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for composite data types
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializer(pCompositeTypeConverter));
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializer(pCompositeTypeConverter));
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static Module createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}