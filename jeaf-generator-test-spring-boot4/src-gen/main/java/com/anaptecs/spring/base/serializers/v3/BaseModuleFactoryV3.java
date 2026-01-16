/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers.v3;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.base.AnotherDataType;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.BooleanCode;
import com.anaptecs.spring.base.BooleanCodeType;
import com.anaptecs.spring.base.ByteCode;
import com.anaptecs.spring.base.ByteCodeType;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.CharacterCode;
import com.anaptecs.spring.base.CharacterCodeType;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DataTypeWithDerivedProperty;
import com.anaptecs.spring.base.DataUnit;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.DoubleCodeType;
import com.anaptecs.spring.base.DynamicExtensibleEnum;
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
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class BaseModuleFactoryV3 {
  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + BaseModuleFactoryV3.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(AnotherDataType.class, new AnotherDataTypeSerializerV3());
    lModule.addDeserializer(AnotherDataType.class, new AnotherDataTypeDeserializerV3());
    lModule.addSerializer(BookingCode.class, new BookingCodeSerializerV3());
    lModule.addDeserializer(BookingCode.class, new BookingCodeDeserializerV3());
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
    lModule.addSerializer(CharacterCode.class, new CharacterCodeSerializerV3());
    lModule.addDeserializer(CharacterCode.class, new CharacterCodeDeserializerV3());
    lModule.addSerializer(CharacterCodeType.class, new CharacterCodeTypeSerializerV3());
    lModule.addDeserializer(CharacterCodeType.class, new CharacterCodeTypeDeserializerV3());
    lModule.addSerializer(CurrencyCode.class, new CurrencyCodeSerializerV3());
    lModule.addDeserializer(CurrencyCode.class, new CurrencyCodeDeserializerV3());
    lModule.addSerializer(DataTypeWithDerivedProperty.class, new DataTypeWithDerivedPropertySerializerV3());
    lModule.addDeserializer(DataTypeWithDerivedProperty.class, new DataTypeWithDerivedPropertyDeserializerV3());
    lModule.addSerializer(DoubleCode.class, new DoubleCodeSerializerV3());
    lModule.addDeserializer(DoubleCode.class, new DoubleCodeDeserializerV3());
    lModule.addSerializer(DoubleCodeType.class, new DoubleCodeTypeSerializerV3());
    lModule.addDeserializer(DoubleCodeType.class, new DoubleCodeTypeDeserializerV3());
    lModule.addSerializer(FloatCode.class, new FloatCodeSerializerV3());
    lModule.addDeserializer(FloatCode.class, new FloatCodeDeserializerV3());
    lModule.addSerializer(FloatCodeType.class, new FloatCodeTypeSerializerV3());
    lModule.addDeserializer(FloatCodeType.class, new FloatCodeTypeDeserializerV3());
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
    lModule.addSerializer(SoftLink.class, new SoftLinkSerializerV3());
    lModule.addDeserializer(SoftLink.class, new SoftLinkDeserializerV3());
    lModule.addSerializer(StringCode.class, new StringCodeSerializerV3());
    lModule.addDeserializer(StringCode.class, new StringCodeDeserializerV3());
    lModule.addSerializer(StringCodeType.class, new StringCodeTypeSerializerV3());
    lModule.addDeserializer(StringCodeType.class, new StringCodeTypeDeserializerV3());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for composite data types.
   */
  public static JacksonModule createCompositeDataTypeSerializerModule(
      CompositeTypeConverter pCompositeTypeConverter ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("CompositeDataTypeSerializerModule." + BaseModuleFactoryV3.class.getName());
    // Add serializers and deserializers for composite data types
    lModule.addSerializer(BookingID.class, new BookingIDSerializerV3(pCompositeTypeConverter));
    lModule.addDeserializer(BookingID.class, new BookingIDDeserializerV3(pCompositeTypeConverter));
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
    // Return created module.
    return lModule;
  }
}