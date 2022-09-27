/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.junit.pojo.POJOWithIDnMethod.Builder;
import com.anaptecs.jeaf.xfun.api.common.ObjectID;

public class BuilderTest {
  public void testBuilder( ) {
    ImmutablePOJO.Builder lBuilder = ImmutablePOJO.builder();
    ImmutablePOJO lPOJO = lBuilder.setName("Hello").setSomething(4711).build();
    lPOJO = lBuilder.setName("Hello").setSomething(4711).buildValidated();

    lBuilder = ImmutablePOJO.builder(lPOJO);

    Builder lNewBuilder = POJOWithIDnMethod.builder();
    POJOWithIDnMethod lPOJOwithIDnMethod = lNewBuilder.setID(null).build();
    ObjectID lObjectID = lPOJOwithIDnMethod.getID();
    lObjectID.toString();
    lObjectID = lPOJOwithIDnMethod.getUnversionedID();
  }
}
