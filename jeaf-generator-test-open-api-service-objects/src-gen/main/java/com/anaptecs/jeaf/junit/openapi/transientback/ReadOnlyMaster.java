/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class ReadOnlyMaster implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private final String name;

  @JsonSetter(nulls = Nulls.SKIP)
  private final List<ReadOnlyClient> clients;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean clientsBackReferenceInitialized;

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
    if (pBuilder.clients != null) {
      clients = pBuilder.clients;
      // As association is bidirectional we also have to set it in the other direction.
      for (ReadOnlyClient lNext : clients) {
        lNext.setTransientMaster((ReadOnlyMaster) this);
      }
    }
    else {
      clients = new ArrayList<>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    clientsBackReferenceInitialized = true;
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
   * Convenience method to create new instance of class ReadOnlyMaster.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link ReadOnlyMaster}
   */
  public static ReadOnlyMaster of( String pName ) {
    ReadOnlyMaster.Builder lBuilder = ReadOnlyMaster.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ReadOnlyMaster</code>.
   */
  public static class Builder {
    private String name;

    private List<ReadOnlyClient> clients;

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
    public Builder setName( @MyNotNullProperty String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets association {@link #clients}.<br/>
     *
     * @param pClients Collection to which {@link #clients} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
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
    public Builder addToClients( ReadOnlyClient... pClients ) {
      if (pClients != null) {
        if (clients == null) {
          clients = new ArrayList<ReadOnlyClient>();
        }
        clients.addAll(Arrays.asList(pClients));
      }
      return this;
    }

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
  @MyNotNullProperty
  public String getName( ) {
    return name;
  }

  /**
   * Method returns association {@link #clients}.<br/>
   *
   * @return {@link List<ReadOnlyClient>} Value to which {@link #clients} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public List<ReadOnlyClient> getClients( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (clientsBackReferenceInitialized == false) {
      clientsBackReferenceInitialized = true;
      for (ReadOnlyClient lNext : clients) {
        lNext.setTransientMaster((ReadOnlyMaster) this);
      }
    }
    // Return all ReadOnlyClient objects directly without any protection against modification.
    return clients;
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
      for (ReadOnlyClient lNext : clients) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
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
   * @return {@link Builder} New builder that can be used to create new ReadOnlyMaster objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}