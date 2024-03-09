/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import com.anaptecs.spring.custom.serializers.DataTypeCustomSerializationDeserializer;
import com.anaptecs.spring.custom.serializers.DataTypeCustomSerializationSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class CustomModuleFactory implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public Module createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(CustomModuleFactory.class.getName());
    // Add serializers and deserializers for datatypes
    lModule.addSerializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationSerializer());
    lModule.addDeserializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationDeserializer());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static Module createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CustomModuleFactory.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationSerializer());
    lModule.addDeserializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationDeserializer());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static Module createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + CustomModuleFactory.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}