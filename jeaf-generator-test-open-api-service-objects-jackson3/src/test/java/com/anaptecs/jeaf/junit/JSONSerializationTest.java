/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.openapi.base.BidirectA;
import com.anaptecs.jeaf.junit.openapi.base.BidirectB;
import com.anaptecs.jeaf.junit.openapi.base.CHStopPlace;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.ChildAA;
import com.anaptecs.jeaf.junit.openapi.base.ChildBB;
import com.anaptecs.jeaf.junit.openapi.base.Company;
import com.anaptecs.jeaf.junit.openapi.base.GeoPosition;
import com.anaptecs.jeaf.junit.openapi.base.Leg;
import com.anaptecs.jeaf.junit.openapi.base.ParentClass;
import com.anaptecs.jeaf.junit.openapi.base.Partner;
import com.anaptecs.jeaf.junit.openapi.base.PartnerContainer;
import com.anaptecs.jeaf.junit.openapi.base.Person;
import com.anaptecs.jeaf.junit.openapi.base.PlaceRef;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Product.Builder;
import com.anaptecs.jeaf.junit.openapi.base.Reseller;
import com.anaptecs.jeaf.junit.openapi.base.SwissGeoPosition;
import com.anaptecs.jeaf.junit.openapi.base.TopoRef;
import com.anaptecs.jeaf.junit.openapi.base.UICStopPlace;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.type.CollectionType;

public class JSONSerializationTest {

  @Test
  public void testSimpleJSONSerialization( ) {
    ChannelCode lChannelCode = ChannelCode.builder().setCode("POS").build();
    JSONTools lTools = JSON.getJSONTools();
    String lJSONString = lTools.writeObjectToString(lChannelCode);
    assertEquals("\"POS\"", lJSONString);

    ChannelCode lDeserializedChannelCode = lTools.read(lJSONString, ChannelCode.class);
    assertEquals("POS", lDeserializedChannelCode.getCode());

    Channel lChannel = Channel.builder().setChannelCode(lChannelCode).setChannelType(ChannelType.COUNTER).setCode(47)
        .setSelfServiceChannel(false).build();

    lJSONString = lTools.writeObjectToString(lChannel);
    assertEquals("{\"channelType\":\"COUNTER\",\"channelCode\":\"POS\",\"code\":47,\"selfServiceChannel\":false}",
        lJSONString);

    Channel lDeserilaizedChannel = lTools.read(lJSONString, Channel.class);
    assertEquals("POS", lDeserilaizedChannel.getChannelCode().getCode());
    assertEquals(ChannelType.COUNTER, lDeserilaizedChannel.getChannelType());

    Channel lChannel2 = Channel.builder().setChannelCode(ChannelCode.builder().setCode("MOBILE_APP").build())
        .setChannelType(ChannelType.MOBILE).setCode(42).setSelfServiceChannel(true).build();
    List<Channel> lChannels = new ArrayList<>();
    lChannels.add(lChannel);
    lChannels.add(lChannel2);
    Reseller lReseller =
        Reseller.builder().setName("Reseller 1").setLanguage(Locale.GERMAN).setChannels(lChannels).build();
    lJSONString = lTools.writeObjectToString(lReseller);
    assertEquals(
        "{\"channels\":[{\"channelType\":\"COUNTER\",\"channelCode\":\"POS\",\"code\":47,\"selfServiceChannel\":false},{\"channelType\":\"MOBILE\",\"channelCode\":\"MOBILE_APP\",\"code\":42,\"selfServiceChannel\":true}],\"name\":\"Reseller 1\",\"language\":\"de\"}",
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
  public void testInheritanceSerialization( ) {
    ParentClass lParentClass = ParentClass.builder().setParentAttribute("parent").build();
    JSONTools lTools = JSON.getJSONTools();
    String lValue = lTools.writeObjectToString(lParentClass);
    assertEquals("{\"objectType\":\"ParentClass\",\"parentAttribute\":\"parent\"}", lValue);

    ParentClass lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assertEquals("parent", lParentClass.getParentAttribute());

    ChildBB lChildBB = ChildBB.builder().setChildBBAttribute(123456789l).build();
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals("{\"objectType\":\"ChildBB\",\"childBBAttribute\":123456789,\"deprecatedAttribute\":0}", lValue);

    lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assert lDeserializedParent instanceof ChildBB;

    ChildAA lChildAA = ChildAA.builder().setChildAAttribute(4711).build();
    lChildBB.addToComposition(lChildAA);
    lValue = lTools.writeObjectToString(lChildBB);
    assertEquals(
        "{\"objectType\":\"ChildBB\",\"composition\":[{\"objectType\":\"ChildAA\",\"childAAttribute\":4711,\"childAAAttribute\":0}],\"childBBAttribute\":123456789,\"deprecatedAttribute\":0}",
        lValue);

    lDeserializedParent = lTools.read(lValue, ParentClass.class);
    assert lDeserializedParent instanceof ChildBB;
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
        Reseller.builder().setID(lResellerID).setName("Good Guys Inc.").setLanguage(Locale.GERMAN).build();

    // Create 1st product
    Builder lProductBuilder = Product.builder();
    lProductBuilder.setID(lProductID1);
    lProductBuilder.setName("Fancy Thing");
    lProductBuilder.setProductID(UUID.fromString("c513b71f-433d-4118-be8b-7190226eb155"));
    Product lProduct1 = lProductBuilder.build();
    lProduct1.addToResellers(lReseller);

    lProductBuilder = Product.builder();
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
        "[{\"objectID\":\"12|0\",\"resellers\":[{\"objectID\":\"1234|5\",\"name\":\"Good Guys Inc.\",\"language\":\"de\"}],\"name\":\"Fancy Thing\",\"productID\":\"c513b71f-433d-4118-be8b-7190226eb155\",\"uri\":\"https://products.anaptecs.de/123456789\"},{\"objectID\":\"4|1\",\"resellers\":[\"1234|5\"],\"name\":\"Standard Thing\",\"productID\":\"c513b71f-433d-4118-be8b-7190226eb123\",\"uri\":\"https://products.anaptecs.de/123456789\"}]";
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
  void testInheritance( ) {
    JSONTools lTools = JSON.getJSONTools();
    Company lCompany = Company.builder().setID(new ServiceObjectID("123456", 2)).setName("anaptecs GmbH").build();
    String lJSON = lTools.writeObjectToString(lCompany);
    assertEquals("{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"name\":\"anaptecs GmbH\"}", lJSON);

    Person lDonald =
        Person.builder().setID(new ServiceObjectID("9876", 5)).setFirstName("Donald").setSurname("Duck").build();

    Partner lPartner = Partner.builder().setID(new ServiceObjectID("4711", 0)).build();

    List<Partner> lPartners = new ArrayList<>();
    lPartners.add(lDonald);
    lPartners.add(lCompany);
    lPartners.add(lPartner);

    Partner[] lArray = lPartners.toArray(new Partner[0]);
    lJSON = lTools.writeObjectToString(lArray);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\"}]",
        lJSON);

    ObjectMapper lObjectMapper = lTools.getDefaultObjectMapper();
    CollectionType lType = lObjectMapper.getTypeFactory().constructCollectionType(lPartners.getClass(), Partner.class);
    ObjectWriter lWriter = lObjectMapper.writerFor(lType);
    lJSON = lWriter.writeValueAsString(lPartners);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\"}]",
        lJSON);

    lJSON = lTools.writeObjectsToString(lPartners, Partner.class);
    assertEquals(
        "[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\"}]",
        lJSON);

    PartnerContainer lContainer = PartnerContainer.builder().build();
    lContainer.addToPartners(lDonald);
    lContainer.addToPartners(lCompany);
    lContainer.addToPartners(lPartner);

    lJSON = lTools.writeObjectToString(lContainer);
    assertEquals(
        "{\"partners\":[{\"objectType\":\"Person\",\"objectID\":\"9876|5\",\"surname\":\"Duck\",\"firstName\":\"Donald\"},{\"objectType\":\"Company\",\"objectID\":\"123456|2\",\"name\":\"anaptecs GmbH\"},{\"objectType\":\"Partner\",\"objectID\":\"4711|0\"}]}",
        lJSON);
  }

  @Test
  void testBidirectionalAssociations( ) {
    ServiceObjectID lProductID1 = new ServiceObjectID("12", 0);
    ServiceObjectID lProductID2 = new ServiceObjectID("4", 1);
    ServiceObjectID lResellerID = new ServiceObjectID("1234", 5);
    Reseller lReseller =
        Reseller.builder().setID(lResellerID).setName("Good Guys Inc.").setLanguage(Locale.GERMAN).build();

    // Create 1st product
    Builder lProductBuilder = Product.builder();
    lProductBuilder.setID(lProductID1);
    lProductBuilder.setName("Fancy Thing");
    lProductBuilder.setProductID(UUID.fromString("c513b71f-433d-4118-be8b-7190226eb155"));
    Product lProduct1 = lProductBuilder.build();
    lProduct1.addToResellers(lReseller);

    lProductBuilder = Product.builder();
    lProductBuilder.setID(lProductID2);
    lProductBuilder.setName("Standard Thing");
    lProductBuilder.setProductID(UUID.fromString("c513b71f-433d-4118-be8b-7190226eb123"));
    Product lProduct2 = lProductBuilder.build();
    lProduct2.addToResellers(lReseller);

    assertEquals(lReseller.getName(), lProduct1.getResellers().iterator().next().getName());

    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(lReseller);
    assertEquals("{\"objectID\":\"1234|5\",\"name\":\"Good Guys Inc.\",\"language\":\"de\"}", lJSON);

    lJSON = lTools.writeObjectToString(lProduct1);
    String lProductJSON =
        "{\"objectID\":\"12|0\",\"resellers\":[{\"objectID\":\"1234|5\",\"name\":\"Good Guys Inc.\",\"language\":\"de\"}],\"name\":\"Fancy Thing\",\"productID\":\"c513b71f-433d-4118-be8b-7190226eb155\",\"uri\":\"https://products.anaptecs.de/123456789\"}";
    assertEquals(lProductJSON, lJSON);

    Product lDeserializedProduct = lTools.read(lProductJSON, Product.class);
    assertEquals(lProduct1.getName(), lDeserializedProduct.getName());
    assertEquals(lProduct1.getID(), lDeserializedProduct.getID());
    Reseller lDeserializedReseller = lDeserializedProduct.getResellers().iterator().next();
    assertEquals(lReseller.getName(), lDeserializedReseller.getName());
    assertEquals(lProduct1.getName(), lDeserializedReseller.getProducts().iterator().next().getName());
  }

  @Test
  void testBidirectionalAssociationsforServiceObjects( ) {
    BidirectA lBidirectA = BidirectA.builder().build();
    BidirectA lChild = BidirectA.builder().build();
    BidirectB lBidirectB = BidirectB.builder().build();

    lBidirectB.setA(lBidirectA);
    lChild.setParent(lBidirectA);

    assertEquals(lBidirectA, lChild.getParent());
    String lJSON = JSON.getJSONTools().writeObjectToString(lBidirectA);
    assertEquals("{}", lJSON);
    lJSON = JSON.getJSONTools().writeObjectToString(lChild);
    assertEquals("{\"parent\":{}}", lJSON);

    BidirectA lDeserializedA = JSONTools.getJSONTools().read(lJSON, BidirectA.class);
    BidirectA lParent = lDeserializedA.getParent();
    assertNotNull(lParent);
    assertEquals(lDeserializedA, lParent.getTransientChild());

    lJSON = JSON.getJSONTools().writeObjectToString(lBidirectB);
    assertEquals("{\"a\":{}}", lJSON);

    BidirectB lDeserializedB = JSONTools.getJSONTools().read(lJSON, BidirectB.class);
    BidirectA lA = lDeserializedB.getA();
    assertNotNull(lA);
    assertEquals(lDeserializedB, lA.getTransientBs().iterator().next());

  }

  @Test
  void testPolymorphAssociations( ) {
    JSONTools lTools = JSON.getJSONTools();

    UICStopPlace.Builder lStartBuilder = UICStopPlace.builder();
    lStartBuilder.setName("Bern");
    UICStopPlace lBern = lStartBuilder.build();

    String lJSON = lTools.writeObjectToString(lBern);
    assertEquals("{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"}", lJSON);
    PlaceRef lReadPlaceRef = lTools.read(lJSON, PlaceRef.class);
    assertEquals(UICStopPlace.class, lReadPlaceRef.getClass());
    UICStopPlace lUICStopPlace = (UICStopPlace) lReadPlaceRef;
    assertEquals("Bern", lUICStopPlace.getName());

    CHStopPlace.Builder lStopBuilder = CHStopPlace.builder();
    lStopBuilder.setName("Zürich");
    CHStopPlace lZurich = lStopBuilder.build();
    lJSON = lTools.writeObjectToString(lZurich);
    assertEquals("{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"}", lJSON);
    lReadPlaceRef = lTools.read(lJSON, PlaceRef.class);
    assertEquals(CHStopPlace.class, lReadPlaceRef.getClass());
    CHStopPlace lCHStopPlace = (CHStopPlace) lReadPlaceRef;
    assertEquals("Zürich", lCHStopPlace.getName());

    SwissGeoPosition.Builder lSwissGeoPositionBuilder = SwissGeoPosition.builder();
    lSwissGeoPositionBuilder.setLongitude(0).setLatitude(0).setName("Uni Bern");
    SwissGeoPosition lUniBern = lSwissGeoPositionBuilder.build();

    TopoRef.Builder lTopRefBuilder = TopoRef.builder();
    lTopRefBuilder.setName("Olten");
    TopoRef lOlten = lTopRefBuilder.build();

    GeoPosition.Builder lGeoPositionBuilder = GeoPosition.builder();
    lGeoPositionBuilder.setLongitude(47).setLatitude(11).setName("What do I know ;-)");
    GeoPosition lSomewhere = lGeoPositionBuilder.build();

    List<PlaceRef> lStops = new ArrayList<>();
    lStops.add(lBern);
    lStops.add(lUniBern);
    lStops.add(lOlten);
    lStops.add(lZurich);

    lJSON = lTools.writeObjectsToString(lStops, PlaceRef.class);
    assertEquals(
        "[{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"},{\"objectType\":\"SwissGeoPosition\",\"name\":\"Uni Bern\",\"longitude\":0,\"latitude\":0},{\"objectType\":\"TopoRef\",\"name\":\"Olten\"},{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"}]",
        lJSON);

    lJSON = lTools.writeObjectToString(lStops);
    assertEquals(
        "[{\"name\":\"Bern\"},{\"name\":\"Uni Bern\",\"longitude\":0,\"latitude\":0},{\"name\":\"Olten\"},{\"name\":\"Zürich\"}]",
        lJSON);

    Leg lLeg = Leg.builder().build();
    lLeg.setStart(lBern);
    lLeg.setStop(lZurich);

    lLeg.addToStopovers(lUniBern);
    lLeg.addToStopovers(lOlten);
    lLeg.addToStopovers(lSomewhere);

    lJSON = lTools.writeObjectToString(lLeg);
    assertEquals(
        "{\"start\":{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"},\"stop\":{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"},\"stopovers\":[{\"objectType\":\"SwissGeoPosition\",\"name\":\"Uni Bern\",\"longitude\":0,\"latitude\":0},{\"objectType\":\"TopoRef\",\"name\":\"Olten\"},{\"objectType\":\"GeoPosition\",\"name\":\"What do I know ;-)\",\"longitude\":47,\"latitude\":11}]}",
        lJSON);

    Leg lDeserializedLeg = lTools.read(lJSON, Leg.class);
    assertEquals(UICStopPlace.class, lDeserializedLeg.getStart().getClass());
    assertEquals("Bern", lDeserializedLeg.getStart().getName());
    assertEquals(CHStopPlace.class, lDeserializedLeg.getStop().getClass());
    assertEquals("Zürich", lDeserializedLeg.getStop().getName());

    List<PlaceRef> lStopovers = lDeserializedLeg.getStopovers();
    assertEquals(SwissGeoPosition.class, lStopovers.get(0).getClass());
    assertEquals("Uni Bern", lStopovers.get(0).getName());
    assertEquals(TopoRef.class, lStopovers.get(1).getClass());
    assertEquals("Olten", lStopovers.get(1).getName());
    assertEquals(GeoPosition.class, lStopovers.get(2).getClass());
    assertEquals("What do I know ;-)", lStopovers.get(2).getName());
    assertEquals(3, lStopovers.size());
  }
}
