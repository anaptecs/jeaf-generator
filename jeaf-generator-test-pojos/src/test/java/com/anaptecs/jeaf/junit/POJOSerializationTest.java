package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.pojo.BidirectionalA;
import com.anaptecs.jeaf.junit.pojo.BidirectionalB;

public class POJOSerializationTest {

  @Test
  void testBidirectionalAssociationsforPOJOs( ) {
    BidirectionalA lBidirectA = BidirectionalA.Builder.newBuilder().build();
    BidirectionalA lChild = BidirectionalA.Builder.newBuilder().build();
    BidirectionalB lBidirectB = BidirectionalB.Builder.newBuilder().build();

    lBidirectA.setTransientB(lBidirectB);
    assertEquals(lBidirectA, lBidirectB.getAs().iterator().next());

    lBidirectA.addToTransientBs(lBidirectB);
    assertEquals(lBidirectA, lBidirectB.getTheAs().iterator().next());

    lBidirectA.setChild(lChild);
    assertEquals(lBidirectA, lChild.getTransientParent());

    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(lBidirectB);
    assertEquals("{\"as\":[{\"child\":{}}],\"theAs\":[{\"child\":{}}]}", lJSON);

    BidirectionalB lDeserializedB = lTools.read(lJSON, BidirectionalB.class);
    BidirectionalA lA = lDeserializedB.getAs().iterator().next();
    assertNotNull(lA);
  }

}
