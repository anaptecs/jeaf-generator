/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class GenericResponsePOJOBase<T> {
  /**
   * Constant for the name of attribute "errors".
   */
  public static final String ERRORS = "errors";

  /**
   * Constant for the name of attribute "warnings".
   */
  public static final String WARNINGS = "warnings";

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  @JsonSetter(nulls = Nulls.SKIP)
  private List<Message> errors;

  @JsonSetter(nulls = Nulls.SKIP)
  private List<Message> warnings;

  private T value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GenericResponsePOJOBase( ) {
    errors = new ArrayList<Message>();
    warnings = new ArrayList<Message>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GenericResponsePOJOBase( BuilderBase<T> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.errors != null) {
      errors = pBuilder.errors;
    }
    else {
      errors = new ArrayList<Message>();
    }
    if (pBuilder.warnings != null) {
      warnings = pBuilder.warnings;
    }
    else {
      warnings = new ArrayList<Message>();
    }
    value = pBuilder.value;
  }

  /**
   * Class implements builder to create a new instance of class GenericResponsePOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase<T> {
    private List<Message> errors;

    private List<Message> warnings;

    private T value;

    /**
     * Use {@link GenericResponsePOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link GenericResponsePOJO.builder(GenericResponsePOJO)} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( GenericResponsePOJOBase<T> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        errors = pObject.errors;
        warnings = pObject.warnings;
        value = pObject.value;
      }
    }

    /**
     * Method sets association {@link #errors}.<br/>
     *
     * @param pErrors Collection to which {@link #errors} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase<T> setErrors( List<Message> pErrors ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pErrors != null) {
        errors = new ArrayList<Message>(pErrors);
      }
      else {
        errors = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #warnings}.<br/>
     *
     * @param pWarnings Collection to which {@link #warnings} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase<T> setWarnings( List<Message> pWarnings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pWarnings != null) {
        warnings = new ArrayList<Message>(pWarnings);
      }
      else {
        warnings = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase<T> setValue( T pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class GenericResponsePOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return GenericResponsePOJO Created object. The method never returns null.
     */
    public GenericResponsePOJO<T> build( ) {
      return new GenericResponsePOJO<T>(this);
    }

    /**
     * Method creates a new validated instance of class GenericResponsePOJO. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return GenericResponsePOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public GenericResponsePOJO<T> buildValidated( ) throws ConstraintViolationException {
      GenericResponsePOJO<T> lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #errors}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #errors} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<Message> getErrors( ) {
    // Return all Message objects as unmodifiable collection.
    return Collections.unmodifiableList(errors);
  }

  /**
   * Method adds the passed object to {@link #errors}.
   *
   * @param pErrors Object that should be added to {@link #errors}. The parameter must not be null.
   */
  public void addToErrors( Message pErrors ) {
    // Check parameter "pErrors" for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Add passed object to collection of associated Message objects.
    errors.add(pErrors);
  }

  /**
   * Method adds all passed objects to {@link #errors}.
   *
   * @param pErrors Collection with all objects that should be added to {@link #errors}. The parameter must not be null.
   */
  public void addToErrors( Collection<Message> pErrors ) {
    // Check parameter "pErrors" for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Add all passed objects.
    for (Message lNextObject : pErrors) {
      this.addToErrors(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #errors}.<br/>
   *
   * @param pErrors Object that should be removed from {@link #errors}. The parameter must not be null.
   */
  public void removeFromErrors( Message pErrors ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Remove passed object from collection of associated Message objects.
    errors.remove(pErrors);
  }

  /**
   * Method removes all objects from {@link #errors}.
   */
  public void clearErrors( ) {
    // Remove all objects from association "errors".
    errors.clear();
  }

  /**
   * Method returns association {@link #warnings}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #warnings} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Message> getWarnings( ) {
    // Return all Message objects as unmodifiable collection.
    return Collections.unmodifiableList(warnings);
  }

  /**
   * Method adds the passed object to {@link #warnings}.
   *
   * @param pWarnings Object that should be added to {@link #warnings}. The parameter must not be null.
   */
  public void addToWarnings( Message pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add passed object to collection of associated Message objects.
    warnings.add(pWarnings);
  }

  /**
   * Method adds all passed objects to {@link #warnings}.
   *
   * @param pWarnings Collection with all objects that should be added to {@link #warnings}. The parameter must not be
   * null.
   */
  public void addToWarnings( Collection<Message> pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add all passed objects.
    for (Message lNextObject : pWarnings) {
      this.addToWarnings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #warnings}.<br/>
   *
   * @param pWarnings Object that should be removed from {@link #warnings}. The parameter must not be null.
   */
  public void removeFromWarnings( Message pWarnings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Remove passed object from collection of associated Message objects.
    warnings.remove(pWarnings);
  }

  /**
   * Method removes all objects from {@link #warnings}.
   */
  public void clearWarnings( ) {
    // Remove all objects from association "warnings".
    warnings.clear();
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return {@link T} Value to which {@link #value} is set.
   */
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(errors);
    lResult = lPrime * lResult + Objects.hashCode(warnings);
    lResult = lPrime * lResult + Objects.hashCode(value);
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
      GenericResponsePOJOBase<?> lOther = (GenericResponsePOJOBase<?>) pObject;
      lEquals = Objects.equals(errors, lOther.errors) && Objects.equals(warnings, lOther.warnings)
          && Objects.equals(value, lOther.value);
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
}
