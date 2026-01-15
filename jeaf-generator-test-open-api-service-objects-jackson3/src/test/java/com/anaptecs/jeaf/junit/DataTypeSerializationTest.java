/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.anaptecs.jeaf.json.annotations.ObjectMapperConfig;
import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode;
import com.anaptecs.jeaf.junit.openapi.base.BooleanCode;
import com.anaptecs.jeaf.junit.openapi.base.ByteCode;
import com.anaptecs.jeaf.junit.openapi.base.DoubleCode;
import com.anaptecs.jeaf.junit.openapi.base.FloatCode;
import com.anaptecs.jeaf.junit.openapi.base.HeavyDataTypeUser;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCode;
import com.anaptecs.jeaf.junit.openapi.base.ShortCode;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;

@ObjectMapperConfig(
    enabledDeserializationFeatures = { DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,
      DeserializationFeature.USE_BIG_INTEGER_FOR_INTS })
public class DataTypeSerializationTest {

  @Test
  void testDataTypeSerialization( ) {
    HeavyDataTypeUser lHeavyDataTypeUser = HeavyDataTypeUser.builder().setBooleanCode(BooleanCode.builder().setCode(
        true).build()).setByteCode(ByteCode
            .builder().setCode((byte) 127).build())
        .setShortCode(ShortCode.builder().setCode((short) 1024).build())
        .setIntegerCode(IntegerCode.builder().setCode(324567).build()).setFloatCode(FloatCode.builder().setCode(
            (float) 1.2345).build())
        .setDoubleCode(DoubleCode.builder().setCode(3.123456789).build()).setBigInegerCode(
            BigIntegerCode.builder().setCode(new BigInteger("1234567890987654321")).build())
        .setBigDecimalCode(
            BigDecimalCode.builder().setCode(new BigDecimal("3.1234567890987654321")).build())
        .build();

    JSONTools lTools = JSON.getJSONTools();
    String lJSONString = lTools.writeObjectToString(lHeavyDataTypeUser);
    assertEquals(
        "{\"booleanCode\":true,\"byteCode\":127,\"shortCode\":1024,\"integerCode\":324567,\"floatCode\":1.2345,\"doubleCode\":3.123456789,\"bigInegerCode\":1234567890987654321,\"bigDecimalCode\":3.1234567890987654321}",
        lJSONString);

    // Test deserialization
    HeavyDataTypeUser lReadObject = lTools.read(lJSONString, HeavyDataTypeUser.class);
    assertEquals(true, lReadObject.getBooleanCode().getCode());
    assertEquals((byte) 127, lReadObject.getByteCode().getCode());
    assertEquals((short) 1024, lReadObject.getShortCode().getCode());
    assertEquals(324567, lReadObject.getIntegerCode().getCode());
    assertEquals((float) 1.2345, lReadObject.getFloatCode().getCode());
    assertEquals(3.123456789, lReadObject.getDoubleCode().getCode());
    assertEquals(new BigInteger("1234567890987654321"), lReadObject.getBigInegerCode().getCode());
    assertEquals(new BigDecimal("3.1234567890987654321"), lReadObject.getBigDecimalCode().getCode());
  }
}
