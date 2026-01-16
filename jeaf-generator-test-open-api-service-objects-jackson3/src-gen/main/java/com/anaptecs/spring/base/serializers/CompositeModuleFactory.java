/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.spring.composite.ComplexBookingID;
import com.anaptecs.spring.composite.serializers.ComplexBookingIDDeserializer;
import com.anaptecs.spring.composite.serializers.ComplexBookingIDSerializer;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class CompositeModuleFactory implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public JacksonModule createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for datatypes
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializer());
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializer());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializer());
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializer());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static JacksonModule createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + CompositeModuleFactory.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}