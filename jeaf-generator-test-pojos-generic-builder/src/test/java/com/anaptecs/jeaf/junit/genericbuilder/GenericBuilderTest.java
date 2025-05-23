package com.anaptecs.jeaf.junit.genericbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import org.junit.jupiter.api.Test;

public class GenericBuilderTest {

  @Test
  void testGenericBuilderSerializationUsage( ) {
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
