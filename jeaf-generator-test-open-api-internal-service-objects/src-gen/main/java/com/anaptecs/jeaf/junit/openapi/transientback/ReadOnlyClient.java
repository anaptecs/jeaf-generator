/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class ReadOnlyClient implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private final String name;

  @Valid
  private transient ReadOnlyMaster transientMaster;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadOnlyClient( ) {
    name = null;
    transientMaster = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadOnlyClient( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ReadOnlyClient objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class ReadOnlyClient.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyClient}
   */
  public static ReadOnlyClient of( String pName ) {
    ReadOnlyClient.Builder lBuilder = ReadOnlyClient.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ReadOnlyClient</code>.
   */
  public static class Builder {
    private String name;

    /**
     * Use {@link ReadOnlyClient#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReadOnlyClient#builder(ReadOnlyClient)} instead of private constructor to create new builder.
     */
    protected Builder( ReadOnlyClient pObject ) {
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
     * Method creates a new instance of class ReadOnlyClient. The object will be initialized with the values of the
     * builder.
     *
     * @return ReadOnlyClient Created object. The method never returns null.
     */
    public ReadOnlyClient build( ) {
      return new ReadOnlyClient(this);
    }

    /**
     * Method creates a new validated instance of class ReadOnlyClient. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return ReadOnlyClient Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadOnlyClient buildValidated( ) throws ConstraintViolationException {
      ReadOnlyClient lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
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
   * Method returns association {@link #transientMaster}.<br/>
   *
   * @return {@link ReadOnlyMaster} Value to which {@link #transientMaster} is set.
   */
  public ReadOnlyMaster getTransientMaster( ) {
    return transientMaster;
  }

  /**
   * Method sets association {@link #transientMaster}.<br/>
   *
   * @param pTransientMaster Value to which {@link #transientMaster} should be set.
   */
  void setTransientMaster( ReadOnlyMaster pTransientMaster ) {
    transientMaster = pTransientMaster;
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
   * @return {@link Builder} New builder that can be used to create new ReadOnlyClient objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
