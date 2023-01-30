/**
 * Copyright 2004 - 2023 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

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
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestInheritance {
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testTechnicalBaseClasses( ) throws IOException {
    BusinessParent lBusinessParent = BusinessParent.builder().setTechAttribute("TechStuff").setParentAttribute(
        123456789).build();

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

}
