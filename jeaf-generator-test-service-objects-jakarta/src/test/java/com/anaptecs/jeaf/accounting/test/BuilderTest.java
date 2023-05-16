/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.accounting.test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.accounting.Person;

public class BuilderTest {

  @Test
  void testServiceObjectBuilder( ) {
    Calendar lDateOfBirth = Calendar.getInstance();
    lDateOfBirth.set(Calendar.YEAR, 1999);
    Person lPerson = Person.builder().setFirstName("Donald").setName("Duck").setDateOfBirth(lDateOfBirth).setAge(32)
        .setDisplayName("Donald Duck").build();
    Set<Person> lPersons = new HashSet<>();
    lPersons.add(lPerson);

  }
}
