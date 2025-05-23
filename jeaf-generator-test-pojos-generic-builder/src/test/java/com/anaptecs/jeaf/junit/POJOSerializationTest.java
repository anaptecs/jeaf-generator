package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.genericbuilder.Child;
import com.anaptecs.jeaf.junit.genericbuilder.Parent;
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

  @Test
  void testGenericBuilderUsage( ) {
    Parent lParent = Parent.builder()
        .setPropertyA("A")
        .build();

    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(lParent);
    assertEquals("{\"propertyA\":\"A\"}", lJSON);

    Parent lReadParent = lTools.read(lJSON, Parent.class);
    assertEquals(lParent.getPropertyA(), lReadParent.getPropertyA());

    Child lChild = Child.builder()
        .setPropertyA("A*")
        .setPropertyB(4711)
        .build();

    lJSON = lTools.writeObjectToString(lChild);
    assertEquals("{\"propertyA\":\"A*\",\"propertyB\":4711}", lJSON);

    Child lReadChild = lTools.read(lJSON, Child.class);
    assertEquals(lChild.getPropertyA(), lReadChild.getPropertyA());
    assertEquals(lChild.getPropertyB(), lReadChild.getPropertyB());
  }

}
