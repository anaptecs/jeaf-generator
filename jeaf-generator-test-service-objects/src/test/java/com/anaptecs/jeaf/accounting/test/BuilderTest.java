/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.accounting.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.accounting.Account;
import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.accounting.Person;

public class BuilderTest {

  @Test
  void testServiceObjectBuilder( ) {
    Person lPerson = Person.Builder.newBuilder().build();
    Set<Person> lPersons = new HashSet<>();
    lPersons.add(lPerson);

    Booking lBooking = Booking.Builder.newBuilder().setRemitters(lPersons).build();

    Account lAccount01 = Account.Builder.newBuilder().setAuthorizedPersons(lPersons).build();

  }
}
