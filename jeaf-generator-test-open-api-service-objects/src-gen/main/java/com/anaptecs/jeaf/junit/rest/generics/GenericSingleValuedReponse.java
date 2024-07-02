/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@Valid
public class GenericSingleValuedReponse<T> extends AbstractResponse<T> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private T value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GenericSingleValuedReponse( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GenericSingleValuedReponse( Builder<T> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new GenericSingleValuedReponse objects.
   */
  public static <T> Builder<T> builder( ) {
    return new Builder<T>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new GenericSingleValuedReponse objects.
   */
  public static <T> Builder<T> builder( Class<T> pClass ) {
    return new Builder<T>();
  }

  /**
   * Class implements builder to create a new instance of class <code>GenericSingleValuedReponse</code>.
   */
  public static class Builder<T> extends AbstractResponse.Builder<T> {
    private T value;

    /**
     * Use {@link GenericSingleValuedReponse#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link GenericSingleValuedReponse#builder(GenericSingleValuedReponse)} instead of private constructor to
     * create new builder.
     */
    protected Builder( GenericSingleValuedReponse<T> pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setValue(pObject.value);
      }
    }

    /**
     * Method sets association {@link #errors}.<br/>
     *
     * @param pErrors Collection to which {@link #errors} should be set.
     * @return {@link Builder<T>} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder<T> setErrors( List<Message> pErrors ) {
      // Call super class implementation.
      super.setErrors(pErrors);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #errors}.<br/>
     *
     * @param pErrors Array of objects that should be added to {@link #errors}. The parameter may be null.
     * @return {@link Builder<T>} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder<T> addToErrors( Message... pErrors ) {
      // Call super class implementation.
      super.addToErrors(pErrors);
      return this;
    }

    /**
     * Method sets association {@link #warnings}.<br/>
     *
     * @param pWarnings Collection to which {@link #warnings} should be set.
     * @return {@link Builder<T>} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder<T> setWarnings( List<Message> pWarnings ) {
      // Call super class implementation.
      super.setWarnings(pWarnings);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #warnings}.<br/>
     *
     * @param pWarnings Array of objects that should be added to {@link #warnings}. The parameter may be null.
     * @return {@link Builder<T>} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder<T> addToWarnings( Message... pWarnings ) {
      // Call super class implementation.
      super.addToWarnings(pWarnings);
      return this;
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T> setValue( T pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class GenericSingleValuedReponse. The object will be initialized with the values
     * of the builder.
     *
     * @return GenericSingleValuedReponse Created object. The method never returns null.
     */
    public GenericSingleValuedReponse<T> build( ) {
      return new GenericSingleValuedReponse<T>(this);
    }

    /**
     * Method creates a new validated instance of class GenericSingleValuedReponse. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return GenericSingleValuedReponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public GenericSingleValuedReponse<T> buildValidated( ) throws ConstraintViolationException {
      GenericSingleValuedReponse<T> lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return {@link T} Value to which {@link #value} is set.
   */
  @MyNotNull
  public T getValue( ) {
    return value;
  }

  /**
   * Method sets attribute {@link #value}.<br/>
   *
   * @param pValue Value to which {@link #value} should be set.
   */
  public void setValue( T pValue ) {
    // Assign value to attribute
    value = pValue;
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
    lBuilder.append("value: ");
    lBuilder.append(value);
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
   * @return {@link Builder} New builder that can be used to create new GenericSingleValuedReponse objects. The method
   * never returns null.
   */
  public Builder<T> toBuilder( ) {
    return new Builder<T>(this);
  }
}
