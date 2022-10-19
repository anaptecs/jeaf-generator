/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.BooleanCode;
import com.anaptecs.spring.base.BooleanCodeType;
import com.anaptecs.spring.base.ByteCode;
import com.anaptecs.spring.base.ByteCodeType;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DataUnit;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.DoubleCodeType;
import com.anaptecs.spring.base.Entity;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.FloatCode;
import com.anaptecs.spring.base.FloatCodeType;
import com.anaptecs.spring.base.IntegerCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.LongCodeType;
import com.anaptecs.spring.base.ProductCode;
import com.anaptecs.spring.base.ShortCode;
import com.anaptecs.spring.base.ShortCodeType;
import com.anaptecs.spring.base.SoftLink;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.StringCodeType;
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
    lModule.addSerializer(BookingCode.class, new BookingCodeSerializer());
    lModule.addDeserializer(BookingCode.class, new BookingCodeDeserializer());
    lModule.addSerializer(BookingID.class, new BookingIDSerializer());
    lModule.addDeserializer(BookingID.class, new BookingIDDeserializer());
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
    lModule.addSerializer(ComplexBookingID.class, new ComplexBookingIDSerializer());
    lModule.addDeserializer(ComplexBookingID.class, new ComplexBookingIDDeserializer());
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
    lModule.addSerializer(SoftLink.class, new SoftLinkSerializer());
    lModule.addDeserializer(SoftLink.class, new SoftLinkDeserializer());
    lModule.addSerializer(StringCode.class, new StringCodeSerializer());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializer());
    lModule.addSerializer(StringCodeType.class, new StringCodeTypeSerializer());
    lModule.addDeserializer(StringCodeType.class, new StringCodeTypeDeserializer());
    // Add serializers and deserializers for enumerations
    lModule.addSerializer(ComplexBookingType.class, new ComplexBookingTypeSerializer());
    lModule.addDeserializer(ComplexBookingType.class, new ComplexBookingTypeDeserializer());
    lModule.addSerializer(DataUnit.class, new DataUnitSerializer());
    lModule.addDeserializer(DataUnit.class, new DataUnitDeserializer());
    lModule.addSerializer(Entity.class, new EntitySerializer());
    lModule.addDeserializer(Entity.class, new EntityDeserializer());
    lModule.addSerializer(ExtensibleEnum.class, new ExtensibleEnumSerializer());
    lModule.addDeserializer(ExtensibleEnum.class, new ExtensibleEnumDeserializer());
    // Return created module.
    return lModule;
  }
}