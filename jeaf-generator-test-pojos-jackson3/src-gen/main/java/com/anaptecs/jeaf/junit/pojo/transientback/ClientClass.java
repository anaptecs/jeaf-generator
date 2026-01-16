/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.transientback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = ClientClass.Builder.class)
public class ClientClass {
  /**
   * Constant for the name of attribute "transientMaster".
   */
  public static final String TRANSIENTMASTER = "transientMaster";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "manyMasters".
   */
  public static final String MANYMASTERS = "manyMasters";

  private transient MasterClass transientMaster;

  private final String name;

  private final transient List<MasterClass> manyMasters;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ClientClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    manyMasters = new ArrayList<>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ClientClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ClientClass.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link ClientClass}
   */
  public static ClientClass of( String pName ) {
    var lBuilder = ClientClass.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ClientClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String name;

    /**
     * Use {@link ClientClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ClientClass#builder(ClientClass)} instead of private constructor to create new builder.
     */
    protected Builder( ClientClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
      }
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

    /**
     * Method creates a new instance of class ClientClass. The object will be initialized with the values of the
     * builder.
     *
     * @return ClientClass Created object. The method never returns null.
     */
    public ClientClass build( ) {
      return new ClientClass(this);
    }

    /**
     * Method creates a new validated instance of class ClientClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ClientClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ClientClass buildValidated( ) throws ConstraintViolationException {
      ClientClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #transientMaster}.<br/>
   *
   * @return {@link MasterClass} Value to which {@link #transientMaster} is set.
   */
  public MasterClass getTransientMaster( ) {
    return transientMaster;
  }

  /**
   * Method sets association {@link #transientMaster}.<br/>
   *
   * @param pTransientMaster Value to which {@link #transientMaster} should be set.
   */
  void setTransientMaster( MasterClass pTransientMaster ) {
    transientMaster = pTransientMaster;
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
   * Method returns association {@link #manyMasters}.<br/>
   *
   * @return {@link List<MasterClass>} Value to which {@link #manyMasters} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<MasterClass> getManyMasters( ) {
    // Return all MasterClass objects as unmodifiable collection.
    return Collections.unmodifiableList(manyMasters);
  }

  /**
   * Method adds the passed object to {@link #manyMasters}.
   *
   * @param pManyMasters Object that should be added to {@link #manyMasters}. The parameter must not be null.
   */
  void addToManyMasters( MasterClass pManyMasters ) {
    // Check parameter "pManyMasters" for invalid value null.
    Check.checkInvalidParameterNull(pManyMasters, "pManyMasters");
    // Add passed object to collection of associated MasterClass objects.
    manyMasters.add(pManyMasters);
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(name);
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
      ClientClass lOther = (ClientClass) pObject;
      lEquals = Objects.equals(name, lOther.name);
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
   * @return {@link Builder} New builder that can be used to create new ClientClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}