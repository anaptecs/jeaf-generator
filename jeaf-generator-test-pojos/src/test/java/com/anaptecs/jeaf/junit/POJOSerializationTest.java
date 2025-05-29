package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.pojo.BidirectionalA;
import com.anaptecs.jeaf.junit.pojo.BidirectionalB;
import org.junit.jupiter.api.Test;

public class POJOSerializationTest {

  @Test
  void testBidirectionalAssociationsforPOJOs( ) {
    BidirectionalA lBidirectA = BidirectionalA.builder().build();
    BidirectionalA lChild = BidirectionalA.builder().build();
    BidirectionalB lBidirectB = BidirectionalB.builder().build();

    lBidirectB.addToAs(lBidirectA);
    assertEquals(lBidirectB, lBidirectA.getTransientB());

    lBidirectB.addToTheAs(lBidirectA);
    assertEquals(lBidirectB, lBidirectA.getTransientBs().iterator().next());

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
