/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class SubclassWithID extends IdentifiableServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "attr".
   */
  public static final String ATTR = "attr";

  private boolean attr;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SubclassWithID( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SubclassWithID( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    attr = pBuilder.attr;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SubclassWithID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SubclassWithID objects. The method never returns
   * null.
   */
  public static Builder builder( SubclassWithID pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>SubclassWithID</code>.
   */
  public static class Builder extends IdentifiableServiceObject.Builder {
    private boolean attr;

    /**
     * Use {@link SubclassWithID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SubclassWithID#builder(SubclassWithID)} instead of private constructor to create new builder.
     */
    protected Builder( SubclassWithID pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        attr = pObject.attr;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets attribute {@link #hello}.<br/>
     *
     * @param pHello Value to which {@link #hello} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setHello( Integer pHello ) {
      // Call super class implementation.
      super.setHello(pHello);
      return this;
    }

    /**
     * Method sets attribute {@link #country}.<br/>
     *
     * @param pCountry Value to which {@link #country} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setCountry( String pCountry ) {
      // Call super class implementation.
      super.setCountry(pCountry);
      return this;
    }

    /**
     * Method sets attribute {@link #attr}.<br/>
     *
     * @param pAttr Value to which {@link #attr} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAttr( boolean pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    /**
     * Method creates a new instance of class SubclassWithID. The object will be initialized with the values of the
     * builder.
     *
     * @return SubclassWithID Created object. The method never returns null.
     */
    public SubclassWithID build( ) {
      SubclassWithID lObject = new SubclassWithID(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class SubclassWithID. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SubclassWithID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SubclassWithID buildValidated( ) throws ConstraintViolationException {
      SubclassWithID lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #attr}.<br/>
   *
   * @return boolean Value to which {@link #attr} is set.
   */
  public boolean getAttr( ) {
    return attr;
  }

  /**
   * Method sets attribute {@link #attr}.<br/>
   *
   * @param pAttr Value to which {@link #attr} should be set.
   */
  public void setAttr( boolean pAttr ) {
    // Assign value to attribute
    attr = pAttr;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("attr: ");
    lBuilder.append(attr);
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
}
