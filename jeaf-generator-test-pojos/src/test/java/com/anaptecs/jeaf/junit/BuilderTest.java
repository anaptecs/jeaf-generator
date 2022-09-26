/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Currency;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;
import com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO;

class BuilderTest {
  @Test
  void testBuilderForPOJOsWithCustomImplementation( ) {
    Customer lDonald = Customer.builder().setFirstName("Donald").setName("Duck").build();
    Account lAccount01 = Account.builder().setCurrency(Currency.getInstance("CHF")).build();

    lAccount01.setOwner(lDonald);
    assertEquals(lDonald, lAccount01.getOwner());
    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(1, lDonald.getAccounts().size());

    Account lAccount02 = Account.builder().setCurrency(Currency.getInstance("EUR")).build();
    lDonald.addToAccounts(lAccount02);
    assertEquals(lDonald, lAccount02.getOwner());
    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(true, lDonald.getAccounts().contains(lAccount02));
    assertEquals(2, lDonald.getAccounts().size());

    // Transfer Account to Daisy.
    Customer lDaisy = Customer.builder().setFirstName("Daisy").setName("Duck").build();
    lAccount01.setOwner(lDaisy);
    assertEquals(lDaisy, lAccount01.getOwner());
    assertFalse(lDonald.getAccounts().contains(lAccount01));
    assertTrue(lDaisy.getAccounts().contains(lAccount01));

    // Test null handling
    lAccount02.setOwner(null);
    assertEquals(null, lAccount02.getOwner());

    lAccount01.unsetOwner();
    assertEquals(null, lAccount01.getOwner());

    assertEquals(0, lDonald.getAccounts().size());
    assertEquals(0, lDaisy.getAccounts().size());
  }

  @Test
  void testBuilderForPOJOsWithoutCustomImplementation( ) {
    ImmutableAssociationPOJO lPojo = ImmutableAssociationPOJO.builder().setYetAnotherAttribute(true).build();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(true, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

    ImmutableAssociationPOJO.Builder.newBuilder()
        .setYetAnotherAttribute(true).setDeprecatedRefs(Collections.emptySet()).setReadonlyAssociation(Collections
            .emptySortedSet()).build();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(true, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

    // Test empty constructor
    lPojo = new MyImmutableAssociationPOJO();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(false, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

  }
}

class MyImmutableAssociationPOJO extends ImmutableAssociationPOJO {

  MyImmutableAssociationPOJO( ) {
  }

}
