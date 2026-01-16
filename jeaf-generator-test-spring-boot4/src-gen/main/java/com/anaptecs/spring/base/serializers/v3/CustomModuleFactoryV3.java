/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.spring.custom.DataTypeCustomSerialization;
import com.anaptecs.spring.custom.serializers.v3.DataTypeCustomSerializationDeserializerV3;
import com.anaptecs.spring.custom.serializers.v3.DataTypeCustomSerializationSerializerV3;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class CustomModuleFactoryV3 {
  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CustomModuleFactoryV3.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationSerializerV3());
    lModule.addDeserializer(DataTypeCustomSerialization.class, new DataTypeCustomSerializationDeserializerV3());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static JacksonModule createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + CustomModuleFactoryV3.class.getName());
    // Add serializers and deserializers for enumerations
    // Return created module.
    return lModule;
  }
}