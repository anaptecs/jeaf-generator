/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.otherpackage;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

public class InputSubclass extends Input {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new InputSubclass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new InputSubclass objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( InputSubclass pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class InputSubclass.
   *
   *
   * @return {@link InputSubclass}
   */
  public static InputSubclass of( ) {
    InputSubclass.Builder lBuilder = InputSubclass.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>InputSubclass</code>.
   */
  public static class Builder extends Input.Builder {
    /**
     * Use {@link InputSubclass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link InputSubclass#builder(InputSubclass)} instead of private constructor to create new builder.
     */
    protected Builder( InputSubclass pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class InputSubclass. The object will be initialized with the values of the
     * builder.
     *
     * @return InputSubclass Created object. The method never returns null.
     */
    public InputSubclass build( ) {
      InputSubclass lObject = new InputSubclass(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class InputSubclass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return InputSubclass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public InputSubclass buildValidated( ) throws ConstraintViolationException {
      InputSubclass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new InputSubclass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
