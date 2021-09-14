/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.core.api.ObjectMapper.MappingType;
import com.anaptecs.jeaf.junit.core.mapper.PlainPOJOToClassAConverter;
import com.anaptecs.jeaf.junit.pojo.mapper.ChildPOJOToBChildPOJOConverter;

public class POJOMapperTest {

  public void testPOJOMApper( ) {
    PlainPOJO lSourceObject = PlainPOJOToClassAConverter.createNewSourceObject(null);
    lSourceObject.toString();

    ChildPOJO lNewSourceObject = ChildPOJOToBChildPOJOConverter.createNewSourceObject(null);
    BChildPOJO lNewTargetObject = ChildPOJOToBChildPOJOConverter.createNewTargetObject(lNewSourceObject);
    ChildPOJOToBChildPOJOConverter lObjectMapper = ChildPOJOToBChildPOJOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, lNewTargetObject, MappingType.UPDATE);
  }
}
