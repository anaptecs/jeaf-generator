/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.ChildAA;
import com.anaptecs.jeaf.junit.openapi.base.ChildBB;
import com.anaptecs.jeaf.junit.openapi.base.ParentClass;
import com.anaptecs.jeaf.junit.openapi.base.Reseller;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONSerializationTest {

  @Test
  public void testSimpleJSONSerialization( ) throws JsonProcessingException {
    ChannelCode lChannelCode = ChannelCode.Builder.newBuilder().setCode("POS").build();
    JSONTools lTools = JSON.getJSONTools();
    String lJSONString = lTools.writeObjectToString(lChannelCode);
    assertEquals("{\"code\":\"POS\"}", lJSONString);

    ChannelCode lDeserializedChannelCode = lTools.readJSON(lJSONString, ChannelCode.class);
    assertEquals("POS", lDeserializedChannelCode.getCode());

    Channel lChannel =
        Channel.Builder.newBuilder().setChannelCode(lChannelCode).setChannelType(ChannelType.COUNTER).build();

    lJSONString = lTools.writeObjectToString(lChannel);
    assertEquals("{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"}}", lJSONString);

    Channel lDeserilaizedChannel = lTools.readJSON(lJSONString, Channel.class);
    assertEquals("POS", lDeserilaizedChannel.getChannelCode().getCode());
    assertEquals(ChannelType.COUNTER, lDeserilaizedChannel.getChannelType());

    Channel lChannel2 =
        Channel.Builder.newBuilder().setChannelCode(ChannelCode.Builder.newBuilder().setCode("MOBILE_APP").build())
            .setChannelType(ChannelType.MOBILE).build();
    List<Channel> lChannels = new ArrayList<>();
    lChannels.add(lChannel);
    lChannels.add(lChannel2);
    Reseller lReseller = Reseller.Builder.newBuilder().setLanguage(Locale.GERMAN).setChannels(lChannels).build();
    lJSONString = lTools.writeObjectToString(lReseller);
    assertEquals(
        "{\"objectID\":null,\"channels\":[{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"}},{\"channelType\":\"MOBILE\",\"channelCode\":{\"code\":\"MOBILE_APP\"}}],\"products\":[],\"language\":\"de\"}",
        lJSONString);

    // Test deserialization
    Reseller lDeserializedReseller = lTools.readJSON(lJSONString, Reseller.class);
    assertEquals(ChannelType.COUNTER, lDeserializedReseller.getChannels().get(0).getChannelType());
    assertEquals("POS", lDeserializedReseller.getChannels().get(0).getChannelCode().getCode());
    assertEquals(ChannelType.MOBILE, lDeserializedReseller.getChannels().get(1).getChannelType());
    assertEquals("MOBILE_APP", lDeserializedReseller.getChannels().get(1).getChannelCode().getCode());
    assertEquals(2, lDeserializedReseller.getChannels().size());
  }

  @Test
  public void testInheritanceSerialization( ) throws JsonProcessingException {
    ParentClass lParentClass = ParentClass.Builder.newBuilder().setParentAttribute("parent").build();
    JSONTools lTools = JSON.getJSONTools();
    String lValue = lTools.writeObjectToString(lParentClass);
    assertEquals("{\"objectType\":\"ParentClass\",\"parentAttribute\":\"parent\"}", lValue);

    ParentClass lDeserializedParent = lTools.readJSON(lValue, ParentClass.class);
    assertEquals("parent", lParentClass.getParentAttribute());

    ChildBB lChildBB = ChildBB.Builder.newBuilder().setChildBBAttribute(123456789l).build();
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals(
        "{\"objectType\":\"ChildBB\",\"parentAttribute\":null,\"childBAttribute\":false,\"composition\":[],\"childBBAttribute\":123456789,\"deprecatedAttribute\":0,\"deprecatedBs\":[],\"deprecatedParent\":null,\"deprecatedArray\":null}",
        lValue);

    lDeserializedParent = lTools.readJSON(lValue, ParentClass.class);
    assert (lDeserializedParent instanceof ChildBB);

    ChildAA lChildAA = ChildAA.Builder.newBuilder().setChildAAttribute(4711).build();
    lChildBB.addToComposition(lChildAA);
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals(
        "{\"objectType\":\"ChildBB\",\"parentAttribute\":null,\"childBAttribute\":false,\"composition\":[{\"objectType\":\"ChildAA\",\"parentAttribute\":null,\"childAAttribute\":4711,\"childAAAttribute\":0}],\"childBBAttribute\":123456789,\"deprecatedAttribute\":0,\"deprecatedBs\":[],\"deprecatedParent\":null,\"deprecatedArray\":null}",
        lValue);

    lDeserializedParent = lTools.readJSON(lValue, ParentClass.class);
    assert (lDeserializedParent instanceof ChildBB);
    ChildBB lDesserializedBB = (ChildBB) lDeserializedParent;

    assertEquals(1, lDesserializedBB.getComposition().size());
    ParentClass lNext = lDesserializedBB.getComposition().iterator().next();
    assertTrue(lNext instanceof ChildAA);
    assertEquals(4711, ((ChildAA) lNext).getChildAAttribute());

  }
}
