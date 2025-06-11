/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.transientback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = MasterClass.MasterClassBuilderImpl.class)
public class MasterClass {
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

  private final List<ClientClass> clients;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean clientsBackReferenceInitialized;

  private final String name;

  private final ClientClass singleClient;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean singleClientBackReferenceInitialized;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterClass( MasterClassBuilder<?, ?> pBuilder ) {
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
      clients = new ArrayList<>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    clientsBackReferenceInitialized = true;
    name = pBuilder.name;
    singleClient = pBuilder.singleClient;
    if (singleClient != null) {
      // As association is bidirectional we also have to set it in the other direction.
      singleClient.addToManyMasters((MasterClass) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    singleClientBackReferenceInitialized = true;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MasterClass objects.
   */
  public static MasterClassBuilder<?, ?> builder( ) {
    return new MasterClassBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class MasterClass.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link MasterClass}
   */
  public static MasterClass of( String pName ) {
    MasterClassBuilder<?, ?> lBuilder = MasterClass.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MasterClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class MasterClassBuilder<T extends MasterClass, B extends MasterClassBuilder<T, B>> {
    private List<ClientClass> clients;

    private String name;

    private ClientClass singleClient;

    /**
     * Use {@link MasterClassBuilder#builder()} instead of private constructor to create new builder.
     */
    protected MasterClassBuilder( ) {
    }

    /**
     * Use {@link MasterClassBuilder#builder(MasterClass)} instead of private constructor to create new builder.
     */
    protected MasterClassBuilder( MasterClass pObject ) {
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setClients( List<ClientClass> pClients ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pClients != null) {
        clients = new ArrayList<ClientClass>(pClients);
      }
      else {
        clients = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #clients}.<br/>
     *
     * @param pClients Array of objects that should be added to {@link #clients}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToClients( ClientClass... pClients ) {
      if (pClients != null) {
        if (clients == null) {
          clients = new ArrayList<ClientClass>();
        }
        clients.addAll(Arrays.asList(pClients));
      }
      return this.self();
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this.self();
    }

    /**
     * Method sets association {@link #singleClient}.<br/>
     *
     * @param pSingleClient Value to which {@link #singleClient} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSingleClient( ClientClass pSingleClient ) {
      singleClient = pSingleClient;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class MasterClass. The object will be initialized with the values of the
     * builder.
     *
     * @return MasterClass Created object. The method never returns null.
     */
    public abstract T build( );

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

  static final class MasterClassBuilderImpl extends MasterClassBuilder<MasterClass, MasterClassBuilderImpl> {
    protected MasterClassBuilderImpl( ) {
    }

    protected MasterClassBuilderImpl( MasterClass pObject ) {
      super(pObject);
    }

    @Override
    protected MasterClassBuilderImpl self( ) {
      return this;
    }

    @Override
    public MasterClass build( ) {
      return new MasterClass(this);
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
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(clients);
    lResult = lPrime * lResult + Objects.hashCode(name);
    lResult = lPrime * lResult + Objects.hashCode(singleClient);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      MasterClass lOther = (MasterClass) pObject;
      lEquals = Objects.equals(clients, lOther.clients) && Objects.equals(name, lOther.name)
          && Objects.equals(singleClient, lOther.singleClient);
    }
    return lEquals;
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
    lBuilder.append("clients: ");
    if (clients != null) {
      lBuilder.append(clients.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (clients != null) {
      for (ClientClass lNext : clients) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("singleClient: ");
    if (singleClient != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(singleClient.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
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
  public MasterClassBuilder<?, ?> toBuilder( ) {
    return new MasterClassBuilderImpl(this);
  }
}