/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.otherpackage;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class InputSubclass extends Input {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected InputSubclass( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected InputSubclass( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class InputSubclass. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Input.Builder {
    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(InputSubclass)} instead of private constructor to create new builder.
     */
    protected Builder( InputSubclass pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new InputSubclass objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new InputSubclass objects. The method never
     * returns null.
     */
    public static Builder newBuilder( InputSubclass pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method creates a new instance of class InputSubclass. The object will be initialized with the values of the
     * builder.
     * 
     * @return InputSubclass Created object. The method never returns null.
     */
    public InputSubclass build( ) {
      return new InputSubclass(this);
    }

    /**
     * Method creates a new validated instance of class InputSubclass. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return InputSubclass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public InputSubclass buildValidated( ) throws ConstraintViolationException {
      InputSubclass lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
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
    return this.toStringBuilder().toString();
  }
}
