package com.anaptecs.jeaf.junit;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.pojo.AdvancedPOJO;
import com.anaptecs.jeaf.junit.pojo.ChildPOJO;
import com.anaptecs.jeaf.junit.pojo.ComplextTypeArrayPOJO;
import com.anaptecs.jeaf.junit.pojo.CustomPrimitiveArraysObjectWithRestrictions;
import com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO;
import com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent;
import com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EqualsTest {
  @Test
  void testEqualsForPOJO( ) {
    EqualsVerifier.simple()
        .forClasses(ChildPOJO.class, AdvancedPOJO.class, ComplextTypeArrayPOJO.class,
            CustomPrimitiveArraysObjectWithRestrictions.class, SoftLinkParent.class, SoftLinkPartner.class,
            ImmutableAssociationPOJO.class)
        .verify();
  }
}
