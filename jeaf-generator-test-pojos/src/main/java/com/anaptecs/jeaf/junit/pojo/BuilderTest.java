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
    ImmutablePOJO.Builder lBuilder = ImmutablePOJO.Builder.newBuilder();
    ImmutablePOJO lPOJO = lBuilder.setName("Hello").setSomething(4711).build();
    lPOJO = lBuilder.setName("Hello").setSomething(4711).build(true);

    lBuilder = ImmutablePOJO.Builder.newBuilder(lPOJO);

    Builder lNewBuilder = POJOWithIDnMethod.Builder.newBuilder();
    POJOWithIDnMethod lPOJOwithIDnMethod = lNewBuilder.setID(null).build();
    ObjectID lObjectID = lPOJOwithIDnMethod.getID();
    lObjectID.toString();
    lObjectID = lPOJOwithIDnMethod.getUnversionedID();
  }
}
