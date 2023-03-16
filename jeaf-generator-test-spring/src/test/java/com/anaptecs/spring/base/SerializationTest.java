/**
 * Copyright 2004 - 2023 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anaptecs.spring.base.techbase.BusinessA;
import com.anaptecs.spring.base.techbase.BusinessChild;
import com.anaptecs.spring.base.techbase.BusinessParent;
import com.anaptecs.spring.base.techbase.TechParent;
import com.anaptecs.spring.impl.SpringTestApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SerializationTest {
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testTechnicalBaseClasses( ) throws IOException {
    BusinessParent lBusinessParent =
        BusinessParent.builder().setTechAttribute("TechStuff").setParentAttribute(123456789).build();

    String lJSON = objectMapper.writeValueAsString(lBusinessParent);
    assertEquals("{\"objectType\":\"BusinessParent\",\"techAttribute\":\"TechStuff\",\"parentAttribute\":123456789}",
        lJSON);

    BusinessParent lReadObject = objectMapper.readValue(lJSON, BusinessParent.class);
    assertEquals("TechStuff", lReadObject.getTechAttribute());
    assertEquals(123456789, lReadObject.getParentAttribute());

    lBusinessParent = BusinessChild.builder().setChildAttribute("Child").setTechAttribute("TechStuff2")
        .setParentAttribute(4711).build();
    lJSON = objectMapper.writeValueAsString(lBusinessParent);
    assertEquals(
        "{\"objectType\":\"BusinessChild\",\"techAttribute\":\"TechStuff2\",\"parentAttribute\":4711,\"childAttribute\":\"Child\"}",
        lJSON);

    lReadObject = objectMapper.readValue(lJSON, BusinessParent.class);
    assertEquals(BusinessChild.class, lReadObject.getClass());
    assertEquals("TechStuff2", lReadObject.getTechAttribute());
    assertEquals(4711, lReadObject.getParentAttribute());
    assertEquals("Child", ((BusinessChild) lReadObject).getChildAttribute());

    TechParent lTechParent = objectMapper.readValue(lJSON, TechParent.class);
    assertEquals(TechParent.class, lTechParent.getClass());
    assertEquals("TechStuff2", lTechParent.getTechAttribute());

    BusinessA lBusinessA = BusinessA.builder().setTechAttribute("TECH_1234").setBusinessAttribute(47110815).build();
    lJSON = objectMapper.writeValueAsString(lBusinessA);
    assertEquals("{\"techAttribute\":\"TECH_1234\",\"businessAttribute\":47110815}", lJSON);

    lBusinessA = objectMapper.readValue(lJSON, BusinessA.class);
    assertEquals(BusinessA.class, lBusinessA.getClass());
    assertEquals("TECH_1234", lBusinessA.getTechAttribute());
    assertEquals(47110815, lBusinessA.getBusinessAttribute());

    lTechParent = objectMapper.readValue(lJSON, TechParent.class);
    assertEquals(TechParent.class, lTechParent.getClass());
    assertEquals("TECH_1234", lTechParent.getTechAttribute());
  }

  @Test
  void testExtensibleEnumSerialization( ) throws JsonProcessingException {
    MasterDataObject lMasterDataObject = MasterDataObject.builder().setDataUnits(DataUnit.COUPON)
        .setEntity(Entity.DISCOUNT_CAMPAIGN).setObjectID("47110815").build();

    String lJSON = objectMapper.writeValueAsString(lMasterDataObject);
    assertEquals("{\"dataUnits\":[\"COUPON\"],\"entity\":\"DISCOUNT_CAMPAIGN\",\"objectID\":\"47110815\"}", lJSON);

    // Deserialize unknown data unit
    MasterDataObject lReadObject = objectMapper.readValue(
        "{\"dataUnits\":[\"PRODUCT\"],\"entity\":\"DISCOUNT_CAMPAIGN\",\"objectID\":\"47110815\"}",
        MasterDataObject.class);
    assertEquals("47110815", lReadObject.getObjectID());
    assertEquals(Entity.DISCOUNT_CAMPAIGN, lReadObject.getEntity());
    assertEquals(DataUnit.UNKNOWN, lReadObject.getDataUnits().get(0));
  }

}
