/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.spring.base.serializers.BooleanCodeDeserializer;
import com.anaptecs.spring.base.serializers.BooleanCodeSerializer;
import com.anaptecs.spring.base.serializers.BooleanCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.BooleanCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.ByteCodeDeserializer;
import com.anaptecs.spring.base.serializers.ByteCodeSerializer;
import com.anaptecs.spring.base.serializers.ByteCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.ByteCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.ChannelCodeDeserializer;
import com.anaptecs.spring.base.serializers.ChannelCodeSerializer;
import com.anaptecs.spring.base.serializers.CurrencyCodeDeserializer;
import com.anaptecs.spring.base.serializers.CurrencyCodeSerializer;
import com.anaptecs.spring.base.serializers.DoubleCodeDeserializer;
import com.anaptecs.spring.base.serializers.DoubleCodeSerializer;
import com.anaptecs.spring.base.serializers.DoubleCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.DoubleCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.ExtensibleEnumDeserializer;
import com.anaptecs.spring.base.serializers.ExtensibleEnumSerializer;
import com.anaptecs.spring.base.serializers.FloatCodeDeserializer;
import com.anaptecs.spring.base.serializers.FloatCodeSerializer;
import com.anaptecs.spring.base.serializers.FloatCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.FloatCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.IntegerCodeDeserializer;
import com.anaptecs.spring.base.serializers.IntegerCodeSerializer;
import com.anaptecs.spring.base.serializers.IntegerCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.IntegerCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.LongCodeDeserializer;
import com.anaptecs.spring.base.serializers.LongCodeSerializer;
import com.anaptecs.spring.base.serializers.LongCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.LongCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.ProductCodeDeserializer;
import com.anaptecs.spring.base.serializers.ProductCodeSerializer;
import com.anaptecs.spring.base.serializers.ShortCodeDeserializer;
import com.anaptecs.spring.base.serializers.ShortCodeSerializer;
import com.anaptecs.spring.base.serializers.ShortCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.ShortCodeTypeSerializer;
import com.anaptecs.spring.base.serializers.StringCodeDeserializer;
import com.anaptecs.spring.base.serializers.StringCodeSerializer;
import com.anaptecs.spring.base.serializers.StringCodeTypeDeserializer;
import com.anaptecs.spring.base.serializers.StringCodeTypeSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class BaseModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  public Module createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(this.getClass().getName());
    // Add serializers and deserializers for datatypes
    lModule.addSerializer(BooleanCode.class, new BooleanCodeSerializer());
    lModule.addDeserializer(BooleanCode.class, new BooleanCodeDeserializer());
    lModule.addSerializer(BooleanCodeType.class, new BooleanCodeTypeSerializer());
    lModule.addDeserializer(BooleanCodeType.class, new BooleanCodeTypeDeserializer());
    lModule.addSerializer(ByteCode.class, new ByteCodeSerializer());
    lModule.addDeserializer(ByteCode.class, new ByteCodeDeserializer());
    lModule.addSerializer(ByteCodeType.class, new ByteCodeTypeSerializer());
    lModule.addDeserializer(ByteCodeType.class, new ByteCodeTypeDeserializer());
    lModule.addSerializer(ChannelCode.class, new ChannelCodeSerializer());
    lModule.addDeserializer(ChannelCode.class, new ChannelCodeDeserializer());
    lModule.addSerializer(CurrencyCode.class, new CurrencyCodeSerializer());
    lModule.addDeserializer(CurrencyCode.class, new CurrencyCodeDeserializer());
    lModule.addSerializer(DoubleCode.class, new DoubleCodeSerializer());
    lModule.addDeserializer(DoubleCode.class, new DoubleCodeDeserializer());
    lModule.addSerializer(DoubleCodeType.class, new DoubleCodeTypeSerializer());
    lModule.addDeserializer(DoubleCodeType.class, new DoubleCodeTypeDeserializer());
    lModule.addSerializer(FloatCode.class, new FloatCodeSerializer());
    lModule.addDeserializer(FloatCode.class, new FloatCodeDeserializer());
    lModule.addSerializer(FloatCodeType.class, new FloatCodeTypeSerializer());
    lModule.addDeserializer(FloatCodeType.class, new FloatCodeTypeDeserializer());
    lModule.addSerializer(IntegerCode.class, new IntegerCodeSerializer());
    lModule.addDeserializer(IntegerCode.class, new IntegerCodeDeserializer());
    lModule.addSerializer(IntegerCodeType.class, new IntegerCodeTypeSerializer());
    lModule.addDeserializer(IntegerCodeType.class, new IntegerCodeTypeDeserializer());
    lModule.addSerializer(LongCode.class, new LongCodeSerializer());
    lModule.addDeserializer(LongCode.class, new LongCodeDeserializer());
    lModule.addSerializer(LongCodeType.class, new LongCodeTypeSerializer());
    lModule.addDeserializer(LongCodeType.class, new LongCodeTypeDeserializer());
    lModule.addSerializer(ProductCode.class, new ProductCodeSerializer());
    lModule.addDeserializer(ProductCode.class, new ProductCodeDeserializer());
    lModule.addSerializer(ShortCode.class, new ShortCodeSerializer());
    lModule.addDeserializer(ShortCode.class, new ShortCodeDeserializer());
    lModule.addSerializer(ShortCodeType.class, new ShortCodeTypeSerializer());
    lModule.addDeserializer(ShortCodeType.class, new ShortCodeTypeDeserializer());
    lModule.addSerializer(StringCode.class, new StringCodeSerializer());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializer());
    lModule.addSerializer(StringCodeType.class, new StringCodeTypeSerializer());
    lModule.addDeserializer(StringCodeType.class, new StringCodeTypeDeserializer());
    // Add serializers and deserializers for enumerations
    lModule.addSerializer(ExtensibleEnum.class, new ExtensibleEnumSerializer());
    lModule.addDeserializer(ExtensibleEnum.class, new ExtensibleEnumDeserializer());
    // Return created module.
    return lModule;
  }
}