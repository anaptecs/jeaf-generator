package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.generics.GenericResponsePOJO;
import com.anaptecs.jeaf.junit.generics.GenericResponsePOJO.Builder;
import com.anaptecs.jeaf.junit.generics.MyBusinessObject;

public class GenericsTest {
  @Test
  void testGenericBuilders( ) {
    Builder<MyBusinessObject> lBuilder = GenericResponsePOJO.builder();
    lBuilder.setValue(MyBusinessObject.builder().build());
    GenericResponsePOJO<MyBusinessObject> lObject = lBuilder.build();
    assertNotNull(lObject);
  }
}
