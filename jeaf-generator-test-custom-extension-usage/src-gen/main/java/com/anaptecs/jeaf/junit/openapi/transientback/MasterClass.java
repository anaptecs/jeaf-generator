/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class MasterClass extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "clients".
   */
  public static final String CLIENTS = "clients";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "singleClient".
   */
  public static final String SINGLECLIENT = "singleClient";

  // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
  @ClassPropertyDeclaration
  private List<ClientClass> clients;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean clientsBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
  private int clientsXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String name;

  // "String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
  @ClassPropertyDeclaration
  private ClientClass singleClient;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean singleClientBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
  private int singleClientXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MasterClass( ) {
    clients = new ArrayList<ClientClass>();
    // Bidirectional back reference is not yet set up correctly
    clientsBackReferenceInitialized = false;
    // Bidirectional back reference is not yet set up correctly
    singleClientBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.clients != null) {
      clients = pBuilder.clients;
      // As association is bidirectional we also have to set it in the other direction.
      for (ClientClass lNext : clients) {
        lNext.setTransientMaster((MasterClass) this);
      }
    }
    else {
      clients = new ArrayList<ClientClass>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    clientsBackReferenceInitialized = true;
    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    clientsXYZ = pBuilder.clientsXYZ;
    name = pBuilder.name;
    // "String"
    nameXYZ = pBuilder.nameXYZ;
    singleClient = pBuilder.singleClient;
    if (singleClient != null) {
      // As association is bidirectional we also have to set it in the other direction.
      singleClient.addToManyMasters((MasterClass) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    singleClientBackReferenceInitialized = true;
    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    singleClientXYZ = pBuilder.singleClientXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MasterClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>MasterClass</code>.
   */
  public static class Builder {
    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    @BuilderPropertyDeclaration
    private List<ClientClass> clients;

    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    private int clientsXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String name;

    // "String"
    private int nameXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    @BuilderPropertyDeclaration
    private ClientClass singleClient;

    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    private int singleClientXYZ = 0;

    /**
     * Use {@link MasterClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MasterClass#builder(MasterClass)} instead of private constructor to create new builder.
     */
    protected Builder( MasterClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setClients(pObject.clients);
        this.setName(pObject.name);
        this.setSingleClient(pObject.singleClient);
      }
    }

    /**
     * Method sets association {@link #clients}.<br/>
     *
     * @param pClients Collection to which {@link #clients} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setClients( List<ClientClass> pClients ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pClients != null) {
        clients = new ArrayList<ClientClass>(pClients);
      }
      else {
        clients = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #clients}.<br/>
     *
     * @param pClients Array of objects that should be added to {@link #clients}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToClients( ClientClass... pClients ) {
      if (pClients != null) {
        if (clients == null) {
          clients = new ArrayList<ClientClass>();
        }
        clients.addAll(Arrays.asList(pClients));
      }
      return this;
    }

    public Builder setClientsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
      clientsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public Builder setNameXYZ( int value ) {
      // "String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #singleClient}.<br/>
     *
     * @param pSingleClient Value to which {@link #singleClient} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSingleClient( ClientClass pSingleClient ) {
      singleClient = pSingleClient;
      return this;
    }

    public Builder setSingleClientXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
      singleClientXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class MasterClass. The object will be initialized with the values of the
     * builder.
     *
     * @return MasterClass Created object. The method never returns null.
     */
    public MasterClass build( ) {
      return new MasterClass(this);
    }

    /**
     * Method creates a new validated instance of class MasterClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return MasterClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MasterClass buildValidated( ) throws ConstraintViolationException {
      MasterClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #clients}.<br/>
   *
   * @return {@link List<ClientClass>} Value to which {@link #clients} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<ClientClass> getClients( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (clientsBackReferenceInitialized == false) {
      clientsBackReferenceInitialized = true;
      for (ClientClass lNext : clients) {
        lNext.setTransientMaster((MasterClass) this);
      }
    }
    // Return all ClientClass objects as unmodifiable collection.
    return Collections.unmodifiableList(clients);
  }

  /**
   * Method adds the passed object to {@link #clients}.
   *
   * @param pClients Object that should be added to {@link #clients}. The parameter must not be null.
   */
  public void addToClients( ClientClass pClients ) {
    // Check parameter "pClients" for invalid value null.
    Check.checkInvalidParameterNull(pClients, "pClients");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pClients.unsetTransientMaster();
    // Add passed object to collection of associated ClientClass objects.
    clients.add(pClients);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pClients != null && this.equals(pClients.getTransientMaster()) == false) {
      pClients.setTransientMaster((MasterClass) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #clients}.
   *
   * @param pClients Collection with all objects that should be added to {@link #clients}. The parameter must not be
   * null.
   */
  public void addToClients( Collection<ClientClass> pClients ) {
    // Check parameter "pClients" for invalid value null.
    Check.checkInvalidParameterNull(pClients, "pClients");
    // Add all passed objects.
    for (ClientClass lNextObject : pClients) {
      this.addToClients(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #clients}.<br/>
   *
   * @param pClients Object that should be removed from {@link #clients}. The parameter must not be null.
   */
  public void removeFromClients( ClientClass pClients ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pClients, "pClients");
    // Remove passed object from collection of associated ClientClass objects.
    clients.remove(pClients);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pClients.getTransientMaster()) == true) {
      pClients.unsetTransientMaster();
    }
  }

  /**
   * Method removes all objects from {@link #clients}.
   */
  public void clearClients( ) {
    // Remove all objects from association "clients".
    Collection<ClientClass> lClients = new HashSet<ClientClass>(clients);
    Iterator<ClientClass> lIterator = lClients.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromClients(lIterator.next());
    }
  }

  public int getClientsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    return clientsXYZ;
  }

  public void setClientsXYZ( int value ) {
    clientsXYZ = value;
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  public int getNameXYZ( ) {
    // "String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns association {@link #singleClient}.<br/>
   *
   * @return {@link ClientClass} Value to which {@link #singleClient} is set.
   */
  public ClientClass getSingleClient( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (singleClientBackReferenceInitialized == false) {
      singleClientBackReferenceInitialized = true;
      singleClient.addToManyMasters((MasterClass) this);
    }
    return singleClient;
  }

  /**
   * Method sets association {@link #singleClient}.<br/>
   *
   * @param pSingleClient Value to which {@link #singleClient} should be set.
   */
  public void setSingleClient( ClientClass pSingleClient ) {
    // Release already referenced object before setting a new association.
    if (singleClient != null) {
      singleClient.removeFromManyMasters((MasterClass) this);
    }
    singleClient = pSingleClient;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pSingleClient != null && pSingleClient.getManyMasters().contains(this) == false) {
      pSingleClient.addToManyMasters((MasterClass) this);
    }
  }

  /**
   * Method unsets {@link #singleClient}.
   */
  public final void unsetSingleClient( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    ClientClass lClientClass = singleClient;
    singleClient = null;
    if (lClientClass != null && lClientClass.getManyMasters().contains(this) == true) {
      lClientClass.removeFromManyMasters((MasterClass) this);
    }
  }

  public int getSingleClientXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.ClientClass"
    return singleClientXYZ;
  }

  public void setSingleClientXYZ( int value ) {
    singleClientXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new MasterClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
