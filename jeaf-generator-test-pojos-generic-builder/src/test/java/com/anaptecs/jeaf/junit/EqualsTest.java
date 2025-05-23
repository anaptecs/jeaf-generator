package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.pojo.AdvancedPOJO;
import com.anaptecs.jeaf.junit.pojo.ChildPOJO;
import com.anaptecs.jeaf.junit.pojo.ComplextTypeArrayPOJO;
import com.anaptecs.jeaf.junit.pojo.CustomPrimitiveArraysObjectWithRestrictions;
import com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO;
import com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent;
import com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner;
import com.anaptecs.jeaf.junit.pojo.transientback.ClientClass;
import com.anaptecs.jeaf.junit.pojo.transientback.MasterClass;

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

  void testEqualsForTransientBackReferences( ) {
    ClientClass lClient1 = ClientClass.builder().setName("Client 1").build();
    ClientClass lClient2 = ClientClass.builder().setName("Client 2").build();
    MasterClass lMaster1 = MasterClass.builder().setName("Master 1").build();
    lMaster1.addToClients(lClient1);
    lMaster1.addToClients(lClient2);

    MasterClass lMaster2 = MasterClass.builder()
        .setName("Master 1")
        .addToClients(
            ClientClass.of("Client 1"),
            ClientClass.of("Client 2"))
        .build();

    assertNotEquals(lClient1, lClient2);

    assertEquals(lMaster1, lMaster1);
    assertEquals(lMaster1, lMaster2);
    assertEquals(ClientClass.of("Another Client"), ClientClass.of("Another Client"));
  }
}
