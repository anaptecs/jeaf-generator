/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeSerializer;
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
    lModule.addSerializer(BooleanCode.class, new BooleanCodeSerializer());
    lModule.addDeserializer(BooleanCode.class, new BooleanCodeDeserializer());
    lModule.addSerializer(StringCode.class, new StringCodeSerializer());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializer());
    lModule.addSerializer(ByteCode.class, new ByteCodeSerializer());
    lModule.addDeserializer(ByteCode.class, new ByteCodeDeserializer());
    lModule.addSerializer(ShortCode.class, new ShortCodeSerializer());
    lModule.addDeserializer(ShortCode.class, new ShortCodeDeserializer());
    lModule.addSerializer(IntegerCode.class, new IntegerCodeSerializer());
    lModule.addDeserializer(IntegerCode.class, new IntegerCodeDeserializer());
    lModule.addSerializer(LongCode.class, new LongCodeSerializer());
    lModule.addDeserializer(LongCode.class, new LongCodeDeserializer());
    lModule.addSerializer(FloatCode.class, new FloatCodeSerializer());
    lModule.addDeserializer(FloatCode.class, new FloatCodeDeserializer());
    lModule.addSerializer(DoubleCode.class, new DoubleCodeSerializer());
    lModule.addDeserializer(DoubleCode.class, new DoubleCodeDeserializer());
    lModule.addSerializer(ExtensibleEnum.class, new ExtensibleEnumSerializer());
    lModule.addDeserializer(ExtensibleEnum.class, new ExtensibleEnumDeserializer());
    // Return created module.
    return lModule;
  }
}