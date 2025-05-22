/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class GenericPageableResponseBase<T> extends AbstractResponse<T> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "values".
   */
  public static final String VALUES = "values";

  private List<T> values;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GenericPageableResponseBase( ) {
    values = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GenericPageableResponseBase( BuilderBase<T> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    if (pBuilder.values != null) {
      values = pBuilder.values;
    }
    else {
      values = new ArrayList<>();
    }
  }

  /**
   * Class implements builder to create a new instance of class GenericPageableResponse. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase<T> extends AbstractResponse.Builder<T> {
    private List<T> values;

    /**
     * Use {@link GenericPageableResponse.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link GenericPageableResponse.builder(GenericPageableResponse)} instead of protected constructor to create
     * new builder.
     */
    protected BuilderBase( GenericPageableResponseBase<T> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setValues(pObject.values);
      }
    }

    /**
     * Method sets association {@link #errors}.<br/>
     *
     * @param pErrors Collection to which {@link #errors} should be set.
     * @return {@link BuilderBase<T>} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public BuilderBase<T> setErrors( List<Message> pErrors ) {
      // Call super class implementation.
      super.setErrors(pErrors);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #errors}.<br/>
     *
     * @param pErrors Array of objects that should be added to {@link #errors}. The parameter may be null.
     * @return {@link BuilderBase<T>} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase<T> addToErrors( Message... pErrors ) {
      // Call super class implementation.
      super.addToErrors(pErrors);
      return this;
    }

    /**
     * Method sets association {@link #warnings}.<br/>
     *
     * @param pWarnings Collection to which {@link #warnings} should be set.
     * @return {@link BuilderBase<T>} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public BuilderBase<T> setWarnings( List<Message> pWarnings ) {
      // Call super class implementation.
      super.setWarnings(pWarnings);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #warnings}.<br/>
     *
     * @param pWarnings Array of objects that should be added to {@link #warnings}. The parameter may be null.
     * @return {@link BuilderBase<T>} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase<T> addToWarnings( Message... pWarnings ) {
      // Call super class implementation.
      super.addToWarnings(pWarnings);
      return this;
    }

    /**
     * Method sets association {@link #values}.<br/>
     *
     * @param pValues Collection to which {@link #values} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase<T> setValues( List<T> pValues ) {
      values = pValues;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #values}.<br/>
     *
     * @param pValues Array of objects that should be added to {@link #values}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase<T> addToValues( @SuppressWarnings("unchecked") T... pValues ) {
      if (pValues != null) {
        if (values == null) {
          values = new ArrayList<T>();
        }
        values.addAll(Arrays.asList(pValues));
      }
      return this;
    }

    /**
     * Method creates a new instance of class GenericPageableResponse. The object will be initialized with the values of
     * the builder.
     *
     * @return GenericPageableResponse Created object. The method never returns null.
     */
    public GenericPageableResponse<T> build( ) {
      GenericPageableResponse<T> lObject = new GenericPageableResponse<T>(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class GenericPageableResponse. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return GenericPageableResponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public GenericPageableResponse<T> buildValidated( ) throws ConstraintViolationException {
      GenericPageableResponse<T> lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #values}.<br/>
   *
   * @return {@link List<T>} Value to which {@link #values} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<T> getValues( ) {
    // Return all T objects as unmodifiable collection.
    return Collections.unmodifiableList(values);
  }

  /**
   * Method adds the passed object to {@link #values}.
   *
   * @param pValues Object that should be added to {@link #values}. The parameter must not be null.
   */
  public void addToValues( T pValues ) {
    // Check parameter "pValues" for invalid value null.
    Check.checkInvalidParameterNull(pValues, "pValues");
    // Add passed object to collection of associated T objects.
    values.add(pValues);
  }

  /**
   * Method adds all passed objects to {@link #values}.
   *
   * @param pValues Collection with all objects that should be added to {@link #values}. The parameter must not be null.
   */
  public void addToValues( Collection<T> pValues ) {
    // Check parameter "pValues" for invalid value null.
    Check.checkInvalidParameterNull(pValues, "pValues");
    // Add all passed objects.
    for (T lNextObject : pValues) {
      this.addToValues(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #values}.<br/>
   *
   * @param pValues Object that should be removed from {@link #values}. The parameter must not be null.
   */
  public void removeFromValues( T pValues ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pValues, "pValues");
    // Remove passed object from collection of associated T objects.
    values.remove(pValues);
  }

  /**
   * Method removes all objects from {@link #values}.
   */
  public void clearValues( ) {
    // Remove all objects from association "values".
    values.clear();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new GenericPageableResponse objects. The method
   * never returns null.
   */
  public GenericPageableResponse.Builder<T> toBuilder( ) {
    return new GenericPageableResponse.Builder<T>((GenericPageableResponse<T>) this);
  }
}