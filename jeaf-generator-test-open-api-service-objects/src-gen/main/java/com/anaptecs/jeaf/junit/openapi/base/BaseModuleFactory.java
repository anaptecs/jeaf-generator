/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingIDDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingIDSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingIDDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingIDSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataUnitDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataUnitSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.EntityDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.EntitySerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IBANDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IBANSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeTypeDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeTypeSerializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.VersionedObjectSoftLinkDeserializer;
import com.anaptecs.jeaf.junit.openapi.base.serializers.VersionedObjectSoftLinkSerializer;
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
    lModule.addSerializer(IBAN.class, new IBANSerializer());
    lModule.addDeserializer(IBAN.class, new IBANDeserializer());
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
    lModule.addSerializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkSerializer());
    lModule.addDeserializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkDeserializer());
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