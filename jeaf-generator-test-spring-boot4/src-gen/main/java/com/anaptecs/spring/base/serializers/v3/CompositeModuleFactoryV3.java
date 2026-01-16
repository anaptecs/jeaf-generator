/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.composite.ComplexBookingID;
import com.anaptecs.spring.composite.serializers.v3.ComplexBookingIDDeserializerV3;
import com.anaptecs.spring.composite.serializers.v3.ComplexBookingIDSerializerV3;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class CompositeModuleFactoryV3 {
  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + CompositeModuleFactoryV3.class.getName());
    // Add serializers and deserializers for data types
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for composite data types.
   */
  public static JacksonModule createCompositeDataTypeSerializerModule(
      CompositeTypeConverter pCompositeTypeConverter ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule =
        new SimpleModule("CompositeDataTypeSerializerModule." + CompositeModuleFactoryV3.class.getName());
    // Add serializers and deserializers for composite data types
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializerV3(pCompositeTypeConverter));
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializerV3(pCompositeTypeConverter));
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