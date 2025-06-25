/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class TechOnlyBeanParam implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechOnlyBeanParam( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechOnlyBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class TechOnlyBeanParam.
   *
   *
   * @return {@link com.anaptecs.spring.service.TechOnlyBeanParam}
   */
  public static TechOnlyBeanParam of( ) {
    var lBuilder = TechOnlyBeanParam.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechOnlyBeanParam</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * Use {@link TechOnlyBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechOnlyBeanParam#builder(TechOnlyBeanParam)} instead of private constructor to create new builder.
     */
    protected Builder( TechOnlyBeanParam pObject ) {
    }

    /**
     * Method creates a new instance of class TechOnlyBeanParam. The object will be initialized with the values of the
     * builder.
     *
     * @return TechOnlyBeanParam Created object. The method never returns null.
     */
    public TechOnlyBeanParam build( ) {
      return new TechOnlyBeanParam(this);
    }

    /**
     * Method creates a new validated instance of class TechOnlyBeanParam. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return TechOnlyBeanParam Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TechOnlyBeanParam buildValidated( ) throws ConstraintViolationException {
      TechOnlyBeanParam lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
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
   * @return {@link Builder} New builder that can be used to create new TechOnlyBeanParam objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}