/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class CompositeID implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * String representation of this object.
   */
  private final String hello;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CompositeID( ) {
    hello = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CompositeID( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    hello = pBuilder.hello;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CompositeID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new CompositeID objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( CompositeID pObject ) {
    return new Builder(pObject);
  }

  public static Builder builder( String pHello ) {
    Builder lBuilder = builder();
    lBuilder.setHello(pHello);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>CompositeID</code>.
   */
  public static class Builder {
    /**
     * String representation of this object.
     */
    private String hello;

    /**
     * Use {@link CompositeID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CompositeID#builder(CompositeID)} instead of private constructor to create new builder.
     */
    protected Builder( CompositeID pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setHello(pObject.hello);
      }
    }

    /**
     * Method returns the String representation of this object.
     *
     * @return String String representation of this object.
     */
    public Builder setHello( String pHello ) {
      hello = pHello;
      return this;
    }

    /**
     * Method creates a new instance of class CompositeID. The object will be initialized with the values of the
     * builder.
     *
     * @return CompositeID Created object. The method never returns null.
     */
    public CompositeID build( ) {
      return new CompositeID(this);
    }

    /**
     * Method creates a new validated instance of class CompositeID. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return CompositeID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CompositeID buildValidated( ) throws ConstraintViolationException {
      CompositeID lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the String representation of this object.
   *
   * @return String String representation of this object.
   */
  public String getHello( ) {
    return hello;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(hello);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof CompositeID == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(hello, ((CompositeID) pOtherObject).getHello());
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
    lBuilder.append("hello: ");
    lBuilder.append(hello);
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
   * @return {@link Builder} New builder that can be used to create new CompositeID objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
