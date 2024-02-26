package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.pojo.transientback.ClientClass;
import com.anaptecs.jeaf.junit.pojo.transientback.MasterClass;
import com.anaptecs.jeaf.junit.pojo.transientback.ReadOnlyClient;
import com.anaptecs.jeaf.junit.pojo.transientback.ReadOnlyMaster;

public class TransientBackReferenceTest {
  @Test
  void testTransientBackReferences( ) {
    final JSONTools lJSONTools = JSON.getJSONTools();

    ClientClass lClient1 = ClientClass.builder().setName("Client 1").build();
    ClientClass lClient2 = ClientClass.builder().setName("Client 2").build();
    List<ClientClass> lClients = List.of(lClient1, lClient2);
    MasterClass lMaster = MasterClass.builder().setName("Master 1").build();

    lMaster.addToClients(lClient1);
    lMaster.addToClients(lClient2);
    assertEquals(lMaster, lClient1.getTransientMaster());
    assertEquals(lMaster, lClient2.getTransientMaster());

    String lAsString = lMaster.toString().trim();
    assertEquals("com.anaptecs.jeaf.junit.pojo.transientback.MasterClass" + System.lineSeparator()
        + "clients: 2 element(s)" + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass" + System.lineSeparator() + "    name: Client 1"
        + System.lineSeparator() + System.lineSeparator() + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass"
        + System.lineSeparator() + "    name: Client 2" + System.lineSeparator() + System.lineSeparator()
        + "name: Master 1" + System.lineSeparator() + "singleClient:  null", lAsString);

    String lJSON = lJSONTools.writeObjectToString(lMaster);
    assertEquals("{\"clients\":[{\"name\":\"Client 1\"},{\"name\":\"Client 2\"}],\"name\":\"Master 1\"}", lJSON);

    lMaster = MasterClass.builder().build();
    lMaster.addToClients(lClients);
    assertEquals(lMaster, lClient1.getTransientMaster());
    assertEquals(lMaster, lClient2.getTransientMaster());

    lAsString = lMaster.toString().trim();
    assertEquals("com.anaptecs.jeaf.junit.pojo.transientback.MasterClass" + System.lineSeparator()
        + "clients: 2 element(s)" + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass" + System.lineSeparator() + "    name: Client 1"
        + System.lineSeparator() + System.lineSeparator() + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass"
        + System.lineSeparator() + "    name: Client 2" + System.lineSeparator() + System.lineSeparator() + "name: null"
        + System.lineSeparator() + "singleClient:  null", lAsString);

    lJSON = lJSONTools.writeObjectToString(lMaster);
    assertEquals("{\"clients\":[{\"name\":\"Client 1\"},{\"name\":\"Client 2\"}]}", lJSON);

    lMaster.removeFromClients(lClient2);
    assertNull(lClient2.getTransientMaster());

    // Test that back references are also set in builder.
    lMaster.clearClients();
    assertNull(lClient1.getTransientMaster());
    assertNull(lClient2.getTransientMaster());

    lMaster = MasterClass.builder().setName("Master 1").addToClients(lClient1, lClient2).build();
    assertEquals(lMaster, lClient1.getTransientMaster());
    assertEquals(lMaster, lClient2.getTransientMaster());

    lClient1 = ClientClass.builder().setName("Client 1").build();
    lClient2 = ClientClass.builder().setName("Client 2").build();
    lMaster =
        MasterClass.builder().setName("Master 1").addToClients(lClient1, lClient2).setSingleClient(lClient1).build();

    ClientClass lSingleClient = lMaster.getSingleClient();
    assertEquals(lClient1, lSingleClient);
    assertEquals(lMaster, lClient1.getTransientMaster());
    assertEquals(lMaster, lClient2.getTransientMaster());
    assertEquals(lMaster, lClient1.getManyMasters().get(0));
    assertEquals(0, lClient2.getManyMasters().size());

    lAsString = lMaster.toString().trim();
    assertEquals("com.anaptecs.jeaf.junit.pojo.transientback.MasterClass" + System.lineSeparator()
        + "clients: 2 element(s)" + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass" + System.lineSeparator() + "    name: Client 1"
        + System.lineSeparator() + System.lineSeparator() + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass"
        + System.lineSeparator() + "    name: Client 2" + System.lineSeparator() + System.lineSeparator()
        + "name: Master 1" + System.lineSeparator() + "singleClient: " + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ClientClass" + System.lineSeparator() + "    name: Client 1",
        lAsString);

    lJSON = lJSONTools.writeObjectToString(lMaster);
    assertEquals(
        "{\"clients\":[{\"name\":\"Client 1\"},{\"name\":\"Client 2\"}],\"name\":\"Master 1\",\"singleClient\":{\"name\":\"Client 1\"}}",
        lJSON);

    // Deserialize object and check back references
    MasterClass lReadMaster = lJSONTools.read(lJSON, MasterClass.class);
    assertEquals("Master 1", lReadMaster.getName());
    assertEquals("Client 1", lReadMaster.getClients().get(0).getName());
    assertEquals(lReadMaster, lReadMaster.getClients().get(0).getTransientMaster());
    assertEquals("Client 2", lReadMaster.getClients().get(1).getName());
    assertEquals(lReadMaster, lReadMaster.getClients().get(1).getTransientMaster());

  }

  @Test
  void testTransientBackReferenceForReadonlyClasses( ) {
    final JSONTools lJSONTools = JSON.getJSONTools();

    ReadOnlyClient lClient1 = ReadOnlyClient.builder().setName("Client 1").build();
    ReadOnlyClient lClient2 = ReadOnlyClient.builder().setName("Client 2").build();
    ReadOnlyMaster lMaster = ReadOnlyMaster.builder().setName("Master 1").addToClients(lClient1, lClient2).build();

    assertEquals(lClient1, lMaster.getClients().get(0));
    assertEquals(lClient2, lMaster.getClients().get(1));
    assertEquals(lMaster, lClient1.getTransientMaster());
    assertEquals(lMaster, lClient2.getTransientMaster());

    String lAsString = lMaster.toString().trim();
    assertEquals("com.anaptecs.jeaf.junit.pojo.transientback.ReadOnlyMaster" + System.lineSeparator() + "name: Master 1"
        + System.lineSeparator() + "clients: 2 element(s)" + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ReadOnlyClient" + System.lineSeparator()
        + "    name: Client 1" + System.lineSeparator() + System.lineSeparator()
        + "    com.anaptecs.jeaf.junit.pojo.transientback.ReadOnlyClient" + System.lineSeparator()
        + "    name: Client 2", lAsString);

    String lJSON = lJSONTools.writeObjectToString(lMaster);
    assertEquals("{\"name\":\"Master 1\",\"clients\":[{\"name\":\"Client 1\"},{\"name\":\"Client 2\"}]}", lJSON);

    ReadOnlyMaster lReadObject = lJSONTools.read(lJSON, ReadOnlyMaster.class);
    assertEquals("Master 1", lReadObject.getName());
    assertEquals("Client 1", lReadObject.getClients().get(0).getName());
    assertEquals(lReadObject, lReadObject.getClients().get(0).getTransientMaster());
    assertEquals("Client 2", lReadObject.getClients().get(1).getName());
    assertEquals(lReadObject, lReadObject.getClients().get(1).getTransientMaster());
  }
}
