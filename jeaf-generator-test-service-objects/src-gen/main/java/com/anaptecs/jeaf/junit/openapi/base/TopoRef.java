/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

public class TopoRef extends PlaceRef {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TopoRef( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TopoRef( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TopoRef objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TopoRef objects. The method never returns null.
   */
  public static Builder builder( TopoRef pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TopoRef. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * Use {@link TopoRef#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link TopoRef#builder(TopoRef)} instead of private constructor to create new builder.
     */
    protected Builder( TopoRef pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method creates a new instance of class TopoRef. The object will be initialized with the values of the builder.
     * 
     * @return TopoRef Created object. The method never returns null.
     */
    public TopoRef build( ) {
      return new TopoRef(this);
    }

    /**
     * Method creates a new validated instance of class TopoRef. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return TopoRef Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TopoRef buildValidated( ) throws ConstraintViolationException {
      TopoRef lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
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
