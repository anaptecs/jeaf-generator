/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Currency;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;

class BuilderTest {
  @Test
  void testPOJOBuilder( ) {
    Customer lDonald = Customer.Builder.newBuilder().setFirstName("Donald").setName("Duck").build();
    Account lAccount01 = Account.Builder.newBuilder().setCurrency(Currency.getInstance("CHF")).build();

    lAccount01.setOwner(lDonald);
    assertEquals(lDonald, lAccount01.getOwner());
    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(1, lDonald.getAccounts().size());

    Account lAccount02 = Account.Builder.newBuilder().setCurrency(Currency.getInstance("EUR")).build();
    lDonald.addToAccounts(lAccount02);
    assertEquals(lDonald, lAccount02.getOwner());
    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(true, lDonald.getAccounts().contains(lAccount02));
    assertEquals(2, lDonald.getAccounts().size());

    // Transfer Account to Daisy.
    Customer lDaisy = Customer.Builder.newBuilder().setFirstName("Daisy").setName("Duck").build();
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
}
