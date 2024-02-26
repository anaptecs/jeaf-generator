/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class TransientModuleFactory implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public Module createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(TransientModuleFactory.class.getName());
    // Add serializers and deserializers for datatypes
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static Module createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + TransientModuleFactory.class.getName());
    // Add serializers and deserializers for data types
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static Module createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + TransientModuleFactory.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}