/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class ReadOnlyMaster extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "clients".
   */
  @JEAFCustomAnnotationTest
  public static final String CLIENTS = "clients";

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private final String name;

  // "String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private final List<ReadOnlyClient> clients;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean clientsBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
  private int clientsXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadOnlyMaster( ) {
    name = null;
    clients = new ArrayList<>();
    // Bidirectional back reference is not yet set up correctly
    clientsBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadOnlyMaster( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    // "String"
    nameXYZ = pBuilder.nameXYZ;
    clients = (pBuilder.clients == null) ? List.of() : List.copyOf(pBuilder.clients);
    // As association is bidirectional we also have to set it in the other direction.
    for (ReadOnlyClient lNext : clients) {
      lNext.setTransientMaster((ReadOnlyMaster) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    clientsBackReferenceInitialized = true;
    // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
    clientsXYZ = pBuilder.clientsXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ReadOnlyMaster objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ReadOnlyMaster</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String name;

    // "String"
    private int nameXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<ReadOnlyClient> clients;

    // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
    private int clientsXYZ = 0;

    /**
     * Use {@link ReadOnlyMaster#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReadOnlyMaster#builder(ReadOnlyMaster)} instead of private constructor to create new builder.
     */
    protected Builder( ReadOnlyMaster pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setClients(pObject.clients);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
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
     * Method sets association {@link #clients}.<br/>
     *
     * @param pClients Collection to which {@link #clients} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setClients( List<ReadOnlyClient> pClients ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pClients != null) {
        clients = new ArrayList<ReadOnlyClient>(pClients);
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
    @JEAFCustomAnnotationTest
    public Builder addToClients( ReadOnlyClient... pClients ) {
      if (pClients != null) {
        if (clients == null) {
          clients = new ArrayList<ReadOnlyClient>();
        }
        clients.addAll(Arrays.asList(pClients));
      }
      return this;
    }

    public Builder setClientsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
      clientsXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ReadOnlyMaster. The object will be initialized with the values of the
     * builder.
     *
     * @return ReadOnlyMaster Created object. The method never returns null.
     */
    public ReadOnlyMaster build( ) {
      return new ReadOnlyMaster(this);
    }

    /**
     * Method creates a new validated instance of class ReadOnlyMaster. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return ReadOnlyMaster Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadOnlyMaster buildValidated( ) throws ConstraintViolationException {
      ReadOnlyMaster lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @JEAFCustomAnnotationTest
  public String getName( ) {
    return name;
  }

  public int getNameXYZ( ) {
    // "String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns association {@link #clients}.<br/>
   *
   * @return {@link List<ReadOnlyClient>} Value to which {@link #clients} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<ReadOnlyClient> getClients( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (clientsBackReferenceInitialized == false) {
      clientsBackReferenceInitialized = true;
      for (ReadOnlyClient lNext : clients) {
        lNext.setTransientMaster((ReadOnlyMaster) this);
      }
    }
    return clients;
  }

  public int getClientsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient"
    return clientsXYZ;
  }

  public void setClientsXYZ( int value ) {
    clientsXYZ = value;
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
   * @return {@link Builder} New builder that can be used to create new ReadOnlyMaster objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}