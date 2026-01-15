/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.composite;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.jeaf.junit.openapi.composite.serializers.ComplexBookingIDDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.composite.serializers.ComplexBookingIDSerializerV3;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class CompositeModuleFactoryV3 implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public JacksonModule createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(CompositeModuleFactoryV3.class.getName());
    // Add serializers and deserializers for datatypes
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializerV3());
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializerV3());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CompositeModuleFactoryV3.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializerV3());
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializerV3());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static JacksonModule createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + CompositeModuleFactoryV3.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}