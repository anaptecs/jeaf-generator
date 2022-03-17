/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class BaseModuleFactory implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public Module createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(this.getClass().getName());
    // Add serializers and deserializers
    lModule.addSerializer(ChannelCode.class, new ChannelCodeSerializer());
    lModule.addDeserializer(ChannelCode.class, new ChannelCodeDeserializer());
    lModule.addSerializer(ProductCode.class, new ProductCodeSerializer());
    lModule.addDeserializer(ProductCode.class, new ProductCodeDeserializer());
    lModule.addSerializer(CurrencyCode.class, new CurrencyCodeSerializer());
    lModule.addDeserializer(CurrencyCode.class, new CurrencyCodeDeserializer());
    // Return created module.
    return lModule;
  }
}