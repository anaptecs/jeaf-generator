/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Reseller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSerializationTest {

  @Test
  public void testSimpleJSONSerialization( ) throws JsonProcessingException {
    ChannelCode lChannelCode = ChannelCode.Builder.newBuilder().setCode("POS").build();
    ObjectMapper lObjectMapper = new ObjectMapper();
    String lJSONString = lObjectMapper.writeValueAsString(lChannelCode);
    assertEquals("{\"code\":\"POS\"}", lJSONString);

    ChannelCode lDeserializedChannelCode = lObjectMapper.readValue(lJSONString, ChannelCode.class);
    assertEquals("POS", lDeserializedChannelCode.getCode());

    Channel lChannel =
        Channel.Builder.newBuilder().setChannelCode(lChannelCode).setChannelType(ChannelType.COUNTER).build();

    lJSONString = lObjectMapper.writeValueAsString(lChannel);
    assertEquals("{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"}}", lJSONString);

    Channel lDeserilaizedChannel = lObjectMapper.readValue(lJSONString, Channel.class);
    assertEquals("POS", lDeserilaizedChannel.getChannelCode().getCode());
    assertEquals(ChannelType.COUNTER, lDeserilaizedChannel.getChannelType());

    Channel lChannel2 =
        Channel.Builder.newBuilder().setChannelCode(ChannelCode.Builder.newBuilder().setCode("MOBILE_APP").build())
            .setChannelType(ChannelType.MOBILE).build();
    List<Channel> lChannels = new ArrayList<>();
    lChannels.add(lChannel);
    lChannels.add(lChannel2);
    Reseller lReseller = Reseller.Builder.newBuilder().setLanguage(Locale.GERMAN).setChannels(lChannels).build();
    lJSONString = lObjectMapper.writeValueAsString(lReseller);
    assertEquals(
        "{\"channels\":[{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"}},{\"channelType\":\"MOBILE\",\"channelCode\":{\"code\":\"MOBILE_APP\"}}],\"products\":[],\"language\":\"de\"}",
        lJSONString);

    // Test deserialization
    Reseller lDeserializedReseller = lObjectMapper.readValue(lJSONString, Reseller.class);
    assertEquals(ChannelType.COUNTER, lDeserializedReseller.getChannels().get(0).getChannelType());
    assertEquals("POS", lDeserializedReseller.getChannels().get(0).getChannelCode().getCode());
    assertEquals(ChannelType.MOBILE, lDeserializedReseller.getChannels().get(1).getChannelType());
    assertEquals("MOBILE_APP", lDeserializedReseller.getChannels().get(1).getChannelCode().getCode());
    assertEquals(2, lDeserializedReseller.getChannels().size());
  }

  @Test
  public void testInheritanceSerialization( ) {
    // fail("Not yet implemented.");
  }
}
