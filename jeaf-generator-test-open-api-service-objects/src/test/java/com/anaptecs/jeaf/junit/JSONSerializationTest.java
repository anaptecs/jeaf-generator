/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.ChildAA;
import com.anaptecs.jeaf.junit.openapi.base.ChildBB;
import com.anaptecs.jeaf.junit.openapi.base.Company;
import com.anaptecs.jeaf.junit.openapi.base.ParentClass;
import com.anaptecs.jeaf.junit.openapi.base.Partner;
import com.anaptecs.jeaf.junit.openapi.base.PartnerContainer;
import com.anaptecs.jeaf.junit.openapi.base.Person;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Product.Builder;
import com.anaptecs.jeaf.junit.openapi.base.Reseller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JSONSerializationTest {

  @Test
  public void testSimpleJSONSerialization( ) throws JsonProcessingException {
    ChannelCode lChannelCode = ChannelCode.Builder.newBuilder().setCode("POS").build();
    JSONTools lTools = JSON.getJSONTools();
    String lJSONString = lTools.writeObjectToString(lChannelCode);
    assertEquals("{\"code\":\"POS\"}", lJSONString);

    ChannelCode lDeserializedChannelCode = lTools.read(lJSONString, ChannelCode.class);
    assertEquals("POS", lDeserializedChannelCode.getCode());

    Channel lChannel = Channel.Builder.newBuilder().setChannelCode(lChannelCode).setChannelType(ChannelType.COUNTER)
        .setCode(47).setSelfServiceChannel(false).build();

    lJSONString = lTools.writeObjectToString(lChannel);
    assertEquals(
        "{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"},\"code\":47,\"selfServiceChannel\":false}",
        lJSONString);

    Channel lDeserilaizedChannel = lTools.read(lJSONString, Channel.class);
    assertEquals("POS", lDeserilaizedChannel.getChannelCode().getCode());
    assertEquals(ChannelType.COUNTER, lDeserilaizedChannel.getChannelType());

    Channel lChannel2 =
        Channel.Builder.newBuilder().setChannelCode(ChannelCode.Builder.newBuilder().setCode("MOBILE_APP").build())
            .setChannelType(ChannelType.MOBILE).setCode(42).setSelfServiceChannel(true).build();
    List<Channel> lChannels = new ArrayList<>();
    lChannels.add(lChannel);
    lChannels.add(lChannel2);
    Reseller lReseller =
        Reseller.Builder.newBuilder().setName("Reseller 1").setLanguage(Locale.GERMAN).setChannels(lChannels).build();
    lJSONString = lTools.writeObjectToString(lReseller);
    assertEquals(
        "{\"objectID\":null,\"channels\":[{\"channelType\":\"COUNTER\",\"channelCode\":{\"code\":\"POS\"},\"code\":47,\"selfServiceChannel\":false},{\"channelType\":\"MOBILE\",\"channelCode\":{\"code\":\"MOBILE_APP\"},\"code\":42,\"selfServiceChannel\":true}],\"name\":\"Reseller 1\",\"language\":\"de\"}",
        lJSONString);

    // Test deserialization
    Reseller lDeserializedReseller = lTools.read(lJSONString, Reseller.class);
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

    ParentClass lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assertEquals("parent", lParentClass.getParentAttribute());

    ChildBB lChildBB = ChildBB.Builder.newBuilder().setChildBBAttribute(123456789l).build();
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals(
        "{\"objectType\":\"ChildBB\",\"parentAttribute\":null,\"childBAttribute\":false,\"composition\":[],\"childBBAttribute\":123456789,\"deprecatedAttribute\":0,\"deprecatedBs\":[],\"deprecatedParent\":null,\"deprecatedArray\":null}",
        lValue);

    lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assert (lDeserializedParent instanceof ChildBB);

    ChildAA lChildAA = ChildAA.Builder.newBuilder().setChildAAttribute(4711).build();
    lChildBB.addToComposition(lChildAA);
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals(
        "{\"objectType\":\"ChildBB\",\"parentAttribute\":null,\"childBAttribute\":false,\"composition\":[{\"objectType\":\"ChildAA\",\"parentAttribute\":null,\"childAAttribute\":4711,\"childAAAttribute\":0}],\"childBBAttribute\":123456789,\"deprecatedAttribute\":0,\"deprecatedBs\":[],\"deprecatedParent\":null,\"deprecatedArray\":null}",
        lValue);

    lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assert (lDeserializedParent instanceof ChildBB);
    ChildBB lDesserializedBB = (ChildBB) lDeserializedParent;

    assertEquals(1, lDesserializedBB.getComposition().size());
    ParentClass lNext = lDesserializedBB.getComposition().iterator().next();
    assertTrue(lNext instanceof ChildAA);
    assertEquals(4711, ((ChildAA) lNext).getChildAAttribute());

  }

  @Test
  void testOptimizedObjectIDSerialization( ) {
    ServiceObjectID lProductID1 = new ServiceObjectID("12", 0);
    ServiceObjectID lProductID2 = new ServiceObjectID("4", 1);
    ServiceObjectID lResellerID = new ServiceObjectID("1234", 5);
    Reseller lReseller =
        Reseller.Builder.newBuilder().setID(lResellerID).setName("Good Guys Inc.").setLanguage(Locale.GERMAN).build();

    // Create 1st product
    Builder lProductBuilder = Product.Builder.newBuilder();
    lProductBuilder.setID(lProductID1);
    lProductBuilder.setName("Fancy Thing");
    lProductBuilder.setProductID(UUID.fromString("c513b71f-433d-4118-be8b-7190226eb155"));
    Product lProduct1 = lProductBuilder.build();
    lProduct1.addToResellers(lReseller);

    lProductBuilder = Product.Builder.newBuilder();
    lProductBuilder.setID(lProductID2);
    lProductBuilder.setName("Standard Thing");
    lProductBuilder.setProductID(UUID.fromString("c513b71f-433d-4118-be8b-7190226eb123"));
    Product lProduct2 = lProductBuilder.build();
    lProduct2.addToResellers(lReseller);

    List<Product> lProducts = new ArrayList<>();
    lProducts.add(lProduct1);
    lProducts.add(lProduct2);

    // Test serialization. Reseller should only be present with full data the first time it occurs.
    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(lProducts);
    String lExpected =
        "[{\"objectID\":\"12|0\",\"resellers\":[{\"objectID\":\"1234|5\",\"channels\":[],\"name\":\"Good Guys Inc.\",\"language\":\"de\"}],\"name\":\"Fancy Thing\",\"image\":null,\"link\":null,\"productID\":\"c513b71f-433d-4118-be8b-7190226eb155\",\"supportedCurrencies\":[],\"productCodes\":[]},{\"objectID\":\"4|1\",\"resellers\":[\"1234|5\"],\"name\":\"Standard Thing\",\"image\":null,\"link\":null,\"productID\":\"c513b71f-433d-4118-be8b-7190226eb123\",\"supportedCurrencies\":[],\"productCodes\":[]}]";
    assertEquals(lExpected, lJSON);
  }

  @Test
  void testOptimizedObjectIDDeserialization( ) throws IOException {
    String lJSON =
        "[{\"objectID\":null,\"resellers\":[{\"objectID\":\"1234|5\",\"channels\":[],\"name\":\"Good Guys Inc.\",\"language\":\"de\"}],\"name\":\"Fancy Thing\",\"image\":null,\"link\":null,\"productID\":\"c513b71f-433d-4118-be8b-7190226eb155\"},{\"objectID\":null,\"resellers\":[\"1234|5\"],\"name\":\"Standard Thing\",\"image\":null,\"link\":null,\"productID\":\"c513b71f-433d-4118-be8b-7190226eb123\"}]";

    // Test deserialization. Reseller should have reference to both products but we expect only 1 product.
    JSONTools lTools = JSON.getJSONTools();

    ObjectMapper lObjectMapper = lTools.getDefaultObjectMapper();
    CollectionType lType = lObjectMapper.getTypeFactory().constructCollectionType(List.class, Product.class);

    List<Product> lProducts = lObjectMapper.readValue(lJSON, lType);

    Product lProduct1 = lProducts.get(0);
    Reseller lReseller1 = lProduct1.getResellers().iterator().next();

    assertEquals("Fancy Thing", lProduct1.getName());
    assertEquals("c513b71f-433d-4118-be8b-7190226eb155", lProduct1.getProductID().toString());
    assertEquals(1, lProduct1.getResellers().size());
    assertEquals("Good Guys Inc.", lReseller1.getName());
    assertEquals("1234", lReseller1.getID().getObjectID());
    assertEquals(5, lReseller1.getID().getVersionLabel());

    Product lProduct2 = lProducts.get(1);
    Reseller lReseller2 = lProduct2.getResellers().iterator().next();

    assertEquals("Standard Thing", lProduct2.getName());
    assertEquals("c513b71f-433d-4118-be8b-7190226eb123", lProduct2.getProductID().toString());
    assertEquals(1, lProduct2.getResellers().size());
    assertEquals("Good Guys Inc.", lReseller2.getName());
    assertEquals("1234", lReseller2.getID().getObjectID());
    assertEquals(5, lReseller2.getID().getVersionLabel());
    assertEquals(lReseller1, lReseller2);
    assertTrue(lReseller1 == lReseller2);
  }

  @Test
  void testInheritance( ) throws JsonProcessingException {
    JSONTools lTools = JSON.getJSONTools();
    Company lCompany =
        Company.Builder.newBuilder().setID(new ServiceObjectID("123456", 2)).setName("anaptecs GmbH").build();
    String lJSON = lTools.writeObjectToString(lCompany);
    assertEquals(
        "{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"postalAddresses\":[],\"name\":\"anaptecs GmbH\"}",
        lJSON);

    Person lDonald = Person.Builder.newBuilder().setID(new ServiceObjectID("9876", 5)).setFirstName("Donald")
        .setSurname("Duck").build();

    Partner lPartner = Partner.Builder.newBuilder().setID(new ServiceObjectID("4711", 0)).build();

    List<Partner> lPartners = new ArrayList<>();
    lPartners.add(lDonald);
    lPartners.add(lCompany);
    lPartners.add(lPartner);

    Partner[] lArray = lPartners.toArray(new Partner[0]);
    lJSON = lTools.writeObjectToString(lArray);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"postalAddresses\":[],\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"postalAddresses\":[],\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\",\"postalAddresses\":[]}]",
        lJSON);

    ObjectMapper lObjectMapper = lTools.getDefaultObjectMapper();
    CollectionType lType = lObjectMapper.getTypeFactory().constructCollectionType(lPartners.getClass(), Partner.class);
    ObjectWriter lWriter = lObjectMapper.writerFor(lType);
    lJSON = lWriter.writeValueAsString(lPartners);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"postalAddresses\":[],\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"postalAddresses\":[],\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\",\"postalAddresses\":[]}]",
        lJSON);

    lJSON = lTools.writeObjectsToString(lPartners, Partner.class);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"postalAddresses\":[],\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"postalAddresses\":[],\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\",\"postalAddresses\":[]}]",
        lJSON);

    PartnerContainer lContainer = PartnerContainer.Builder.newBuilder().build();
    lContainer.addToPartners(lDonald);
    lContainer.addToPartners(lCompany);
    lContainer.addToPartners(lPartner);

    lJSON = lTools.writeObjectToString(lContainer);
    assertEquals(
        "{\"partners\":[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"postalAddresses\":[],\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"postalAddresses\":[],\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\",\"postalAddresses\":[]}]}",
        lJSON);
  }

}
