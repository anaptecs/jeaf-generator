/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BigDecimalCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BigDecimalCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BigIntegerCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BigIntegerCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingIDDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BookingIDSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.BooleanCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ByteCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ChannelCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ComplexBookingTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.CurrencyCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataTypeWithConstraintsDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataTypeWithConstraintsSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataUnitDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DataUnitSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DeprecatedTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DeprecatedTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DoubleCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DynamicExtensibleEnumDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.DynamicExtensibleEnumSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.EntityDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.EntitySerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ExtensibleEnumSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.FloatCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IBANDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IBANSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.InlineSortimentTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.InlineSortimentTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.IntegerCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.LongCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ProductCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.ShortCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeTypeDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.StringCodeTypeSerializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.VersionedObjectSoftLinkDeserializerV3;
import com.anaptecs.jeaf.junit.openapi.base.serializers.VersionedObjectSoftLinkSerializerV3;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
@ModuleFactory
public class BaseModuleFactoryV3 implements ObjectMapperModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers of the current package.
   */
  @Override
  public JacksonModule createModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule(BaseModuleFactoryV3.class.getName());
    // Add serializers and deserializers for datatypes
    lModule.addSerializer(BigDecimalCode.class, new BigDecimalCodeSerializerV3());
    lModule.addDeserializer(BigDecimalCode.class, new BigDecimalCodeDeserializerV3());
    lModule.addSerializer(BigIntegerCode.class, new BigIntegerCodeSerializerV3());
    lModule.addDeserializer(BigIntegerCode.class, new BigIntegerCodeDeserializerV3());
    lModule.addSerializer(BookingCode.class, new BookingCodeSerializerV3());
    lModule.addDeserializer(BookingCode.class, new BookingCodeDeserializerV3());
    lModule.addSerializer(BookingID.class, new BookingIDSerializerV3());
    lModule.addDeserializer(BookingID.class, new BookingIDDeserializerV3());
    lModule.addSerializer(BooleanCode.class, new BooleanCodeSerializerV3());
    lModule.addDeserializer(BooleanCode.class, new BooleanCodeDeserializerV3());
    lModule.addSerializer(BooleanCodeType.class, new BooleanCodeTypeSerializerV3());
    lModule.addDeserializer(BooleanCodeType.class, new BooleanCodeTypeDeserializerV3());
    lModule.addSerializer(ByteCode.class, new ByteCodeSerializerV3());
    lModule.addDeserializer(ByteCode.class, new ByteCodeDeserializerV3());
    lModule.addSerializer(ByteCodeType.class, new ByteCodeTypeSerializerV3());
    lModule.addDeserializer(ByteCodeType.class, new ByteCodeTypeDeserializerV3());
    lModule.addSerializer(ChannelCode.class, new ChannelCodeSerializerV3());
    lModule.addDeserializer(ChannelCode.class, new ChannelCodeDeserializerV3());
    lModule.addSerializer(CurrencyCode.class, new CurrencyCodeSerializerV3());
    lModule.addDeserializer(CurrencyCode.class, new CurrencyCodeDeserializerV3());
    lModule.addSerializer(DataTypeWithConstraints.class, new DataTypeWithConstraintsSerializerV3());
    lModule.addDeserializer(DataTypeWithConstraints.class, new DataTypeWithConstraintsDeserializerV3());
    lModule.addSerializer(DeprecatedType.class, new DeprecatedTypeSerializerV3());
    lModule.addDeserializer(DeprecatedType.class, new DeprecatedTypeDeserializerV3());
    lModule.addSerializer(DoubleCode.class, new DoubleCodeSerializerV3());
    lModule.addDeserializer(DoubleCode.class, new DoubleCodeDeserializerV3());
    lModule.addSerializer(DoubleCodeType.class, new DoubleCodeTypeSerializerV3());
    lModule.addDeserializer(DoubleCodeType.class, new DoubleCodeTypeDeserializerV3());
    lModule.addSerializer(FloatCode.class, new FloatCodeSerializerV3());
    lModule.addDeserializer(FloatCode.class, new FloatCodeDeserializerV3());
    lModule.addSerializer(FloatCodeType.class, new FloatCodeTypeSerializerV3());
    lModule.addDeserializer(FloatCodeType.class, new FloatCodeTypeDeserializerV3());
    lModule.addSerializer(IBAN.class, new IBANSerializerV3());
    lModule.addDeserializer(IBAN.class, new IBANDeserializerV3());
    lModule.addSerializer(IntegerCode.class, new IntegerCodeSerializerV3());
    lModule.addDeserializer(IntegerCode.class, new IntegerCodeDeserializerV3());
    lModule.addSerializer(IntegerCodeType.class, new IntegerCodeTypeSerializerV3());
    lModule.addDeserializer(IntegerCodeType.class, new IntegerCodeTypeDeserializerV3());
    lModule.addSerializer(LongCode.class, new LongCodeSerializerV3());
    lModule.addDeserializer(LongCode.class, new LongCodeDeserializerV3());
    lModule.addSerializer(LongCodeType.class, new LongCodeTypeSerializerV3());
    lModule.addDeserializer(LongCodeType.class, new LongCodeTypeDeserializerV3());
    lModule.addSerializer(ProductCode.class, new ProductCodeSerializerV3());
    lModule.addDeserializer(ProductCode.class, new ProductCodeDeserializerV3());
    lModule.addSerializer(ShortCode.class, new ShortCodeSerializerV3());
    lModule.addDeserializer(ShortCode.class, new ShortCodeDeserializerV3());
    lModule.addSerializer(ShortCodeType.class, new ShortCodeTypeSerializerV3());
    lModule.addDeserializer(ShortCodeType.class, new ShortCodeTypeDeserializerV3());
    lModule.addSerializer(StringCode.class, new StringCodeSerializerV3());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializerV3());
    lModule.addSerializer(StringCodeType.class, new StringCodeTypeSerializerV3());
    lModule.addDeserializer(StringCodeType.class, new StringCodeTypeDeserializerV3());
    lModule.addSerializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkSerializerV3());
    lModule.addDeserializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkDeserializerV3());
    // Add serializers and deserializers for enumerations
    lModule.addSerializer(ComplexBookingType.class, new ComplexBookingTypeSerializerV3());
    lModule.addDeserializer(ComplexBookingType.class, new ComplexBookingTypeDeserializerV3());
    lModule.addSerializer(DataUnit.class, new DataUnitSerializerV3());
    lModule.addDeserializer(DataUnit.class, new DataUnitDeserializerV3());
    lModule.addSerializer(DynamicExtensibleEnum.class, new DynamicExtensibleEnumSerializerV3());
    lModule.addDeserializer(DynamicExtensibleEnum.class, new DynamicExtensibleEnumDeserializerV3());
    lModule.addSerializer(Entity.class, new EntitySerializerV3());
    lModule.addDeserializer(Entity.class, new EntityDeserializerV3());
    lModule.addSerializer(ExtensibleEnum.class, new ExtensibleEnumSerializerV3());
    lModule.addDeserializer(ExtensibleEnum.class, new ExtensibleEnumDeserializerV3());
    lModule.addSerializer(InlineSortimentType.class, new InlineSortimentTypeSerializerV3());
    lModule.addDeserializer(InlineSortimentType.class, new InlineSortimentTypeDeserializerV3());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + BaseModuleFactoryV3.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(BigDecimalCode.class, new BigDecimalCodeSerializerV3());
    lModule.addDeserializer(BigDecimalCode.class, new BigDecimalCodeDeserializerV3());
    lModule.addSerializer(BigIntegerCode.class, new BigIntegerCodeSerializerV3());
    lModule.addDeserializer(BigIntegerCode.class, new BigIntegerCodeDeserializerV3());
    lModule.addSerializer(BookingCode.class, new BookingCodeSerializerV3());
    lModule.addDeserializer(BookingCode.class, new BookingCodeDeserializerV3());
    lModule.addSerializer(BookingID.class, new BookingIDSerializerV3());
    lModule.addDeserializer(BookingID.class, new BookingIDDeserializerV3());
    lModule.addSerializer(BooleanCode.class, new BooleanCodeSerializerV3());
    lModule.addDeserializer(BooleanCode.class, new BooleanCodeDeserializerV3());
    lModule.addSerializer(BooleanCodeType.class, new BooleanCodeTypeSerializerV3());
    lModule.addDeserializer(BooleanCodeType.class, new BooleanCodeTypeDeserializerV3());
    lModule.addSerializer(ByteCode.class, new ByteCodeSerializerV3());
    lModule.addDeserializer(ByteCode.class, new ByteCodeDeserializerV3());
    lModule.addSerializer(ByteCodeType.class, new ByteCodeTypeSerializerV3());
    lModule.addDeserializer(ByteCodeType.class, new ByteCodeTypeDeserializerV3());
    lModule.addSerializer(ChannelCode.class, new ChannelCodeSerializerV3());
    lModule.addDeserializer(ChannelCode.class, new ChannelCodeDeserializerV3());
    lModule.addSerializer(CurrencyCode.class, new CurrencyCodeSerializerV3());
    lModule.addDeserializer(CurrencyCode.class, new CurrencyCodeDeserializerV3());
    lModule.addSerializer(DataTypeWithConstraints.class, new DataTypeWithConstraintsSerializerV3());
    lModule.addDeserializer(DataTypeWithConstraints.class, new DataTypeWithConstraintsDeserializerV3());
    lModule.addSerializer(DeprecatedType.class, new DeprecatedTypeSerializerV3());
    lModule.addDeserializer(DeprecatedType.class, new DeprecatedTypeDeserializerV3());
    lModule.addSerializer(DoubleCode.class, new DoubleCodeSerializerV3());
    lModule.addDeserializer(DoubleCode.class, new DoubleCodeDeserializerV3());
    lModule.addSerializer(DoubleCodeType.class, new DoubleCodeTypeSerializerV3());
    lModule.addDeserializer(DoubleCodeType.class, new DoubleCodeTypeDeserializerV3());
    lModule.addSerializer(FloatCode.class, new FloatCodeSerializerV3());
    lModule.addDeserializer(FloatCode.class, new FloatCodeDeserializerV3());
    lModule.addSerializer(FloatCodeType.class, new FloatCodeTypeSerializerV3());
    lModule.addDeserializer(FloatCodeType.class, new FloatCodeTypeDeserializerV3());
    lModule.addSerializer(IBAN.class, new IBANSerializerV3());
    lModule.addDeserializer(IBAN.class, new IBANDeserializerV3());
    lModule.addSerializer(IntegerCode.class, new IntegerCodeSerializerV3());
    lModule.addDeserializer(IntegerCode.class, new IntegerCodeDeserializerV3());
    lModule.addSerializer(IntegerCodeType.class, new IntegerCodeTypeSerializerV3());
    lModule.addDeserializer(IntegerCodeType.class, new IntegerCodeTypeDeserializerV3());
    lModule.addSerializer(LongCode.class, new LongCodeSerializerV3());
    lModule.addDeserializer(LongCode.class, new LongCodeDeserializerV3());
    lModule.addSerializer(LongCodeType.class, new LongCodeTypeSerializerV3());
    lModule.addDeserializer(LongCodeType.class, new LongCodeTypeDeserializerV3());
    lModule.addSerializer(ProductCode.class, new ProductCodeSerializerV3());
    lModule.addDeserializer(ProductCode.class, new ProductCodeDeserializerV3());
    lModule.addSerializer(ShortCode.class, new ShortCodeSerializerV3());
    lModule.addDeserializer(ShortCode.class, new ShortCodeDeserializerV3());
    lModule.addSerializer(ShortCodeType.class, new ShortCodeTypeSerializerV3());
    lModule.addDeserializer(ShortCodeType.class, new ShortCodeTypeDeserializerV3());
    lModule.addSerializer(StringCode.class, new StringCodeSerializerV3());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializerV3());
    lModule.addSerializer(StringCodeType.class, new StringCodeTypeSerializerV3());
    lModule.addDeserializer(StringCodeType.class, new StringCodeTypeDeserializerV3());
    lModule.addSerializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkSerializerV3());
    lModule.addDeserializer(VersionedObjectSoftLink.class, new VersionedObjectSoftLinkDeserializerV3());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static JacksonModule createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + BaseModuleFactoryV3.class.getName());
    // Add serializers and deserializers for enumerations
    lModule.addSerializer(ComplexBookingType.class, new ComplexBookingTypeSerializerV3());
    lModule.addDeserializer(ComplexBookingType.class, new ComplexBookingTypeDeserializerV3());
    lModule.addSerializer(DataUnit.class, new DataUnitSerializerV3());
    lModule.addDeserializer(DataUnit.class, new DataUnitDeserializerV3());
    lModule.addSerializer(DynamicExtensibleEnum.class, new DynamicExtensibleEnumSerializerV3());
    lModule.addDeserializer(DynamicExtensibleEnum.class, new DynamicExtensibleEnumDeserializerV3());
    lModule.addSerializer(Entity.class, new EntitySerializerV3());
    lModule.addDeserializer(Entity.class, new EntityDeserializerV3());
    lModule.addSerializer(ExtensibleEnum.class, new ExtensibleEnumSerializerV3());
    lModule.addDeserializer(ExtensibleEnum.class, new ExtensibleEnumDeserializerV3());
    lModule.addSerializer(InlineSortimentType.class, new InlineSortimentTypeSerializerV3());
    lModule.addDeserializer(InlineSortimentType.class, new InlineSortimentTypeDeserializerV3());
    // Return created module.
    return lModule;
  }
}