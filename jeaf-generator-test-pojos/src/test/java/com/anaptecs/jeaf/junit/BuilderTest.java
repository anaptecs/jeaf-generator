/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.Currency;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;
import com.anaptecs.jeaf.junit.generics.GenericResponsePOJO;
import com.anaptecs.jeaf.junit.generics.GenericResponsePOJO.Builder;
import com.anaptecs.jeaf.junit.generics.MultiTemplateClass;
import com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO;
import org.junit.jupiter.api.Test;

class BuilderTest {
  @Test
  void testBuilderForPOJOsWithCustomImplementation( ) {
    Account lAccount01 = Account.builder()
        .setCurrency(Currency.getInstance("CHF")).build();
    Customer lDonald = Customer.builder()
        .setFirstName("Donald")
        .setName("Duck")
        .addToAccounts(lAccount01)
        .build();

    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(1, lDonald.getAccounts().size());

    Account lAccount02 = Account.builder().setCurrency(Currency.getInstance("EUR")).build();
    lDonald.addToAccounts(lAccount02);
    assertEquals(true, lDonald.getAccounts().contains(lAccount01));
    assertEquals(true, lDonald.getAccounts().contains(lAccount02));
    assertEquals(2, lDonald.getAccounts().size());

    // Transfer Account to Daisy.
    Customer lDaisy = Customer.builder().setFirstName("Daisy").setName("Duck").build();
    assertFalse(lDaisy.getAccounts().contains(lAccount01));

    assertEquals(2, lDonald.getAccounts().size());
    assertEquals(0, lDaisy.getAccounts().size());
  }

  @Test
  void testBuilderForPOJOsWithoutCustomImplementation( ) {
    ImmutableAssociationPOJO lPojo = ImmutableAssociationPOJO.builder().setYetAnotherAttribute(true).build();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(true, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

    ImmutableAssociationPOJO.builder().setYetAnotherAttribute(true).setDeprecatedRefs(Collections.emptySet())
        .setReadonlyAssociation(Collections.emptySortedSet()).build();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(true, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

    // Test empty object
    lPojo = ImmutableAssociationPOJO.builder().build();
    assertNotNull(lPojo.getDeprecatedRefs());
    assertNotNull(lPojo.getReadonlyAssociation());
    assertEquals(false, lPojo.getYetAnotherAttribute());
    assertNull(lPojo.getImmutableChildPOJO());

  }

  @Test
  void testBuilderForGenerics( ) {
    Builder<String> lBuilder = GenericResponsePOJO.builder();
    lBuilder.setValue("");
    GenericResponsePOJO<String> genericResponsePOJO = lBuilder.build();
    genericResponsePOJO.toString();

    MultiTemplateClass.Builder<String, Integer> builder = MultiTemplateClass
        .builder(String.class, Integer.class);
    MultiTemplateClass<String, Integer> multiTemplateClass = builder.build();
    builder = multiTemplateClass.toBuilder();
  }
}
