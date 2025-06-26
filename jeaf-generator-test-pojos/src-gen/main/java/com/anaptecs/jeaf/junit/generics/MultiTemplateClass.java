/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiTemplateClass<T, E> {
  /**
   * Constant for the name of attribute "object".
   */
  public static final String OBJECT = "object";

  /**
   * Constant for the name of attribute "previousState".
   */
  public static final String PREVIOUSSTATE = "previousState";

  /**
   * Constant for the name of attribute "newState".
   */
  public static final String NEWSTATE = "newState";

  private T object;

  private E previousState;

  private E newState;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MultiTemplateClass( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultiTemplateClass( Builder<T, E> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    object = pBuilder.object;
    previousState = pBuilder.previousState;
    newState = pBuilder.newState;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MultiTemplateClass objects.
   */
  public static <T, E> Builder<T, E> builder( ) {
    return new Builder<T, E>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MultiTemplateClass objects.
   */
  public static <T, E> Builder<T, E> builder( Class<T> pClassT, Class<E> pClassE ) {
    return new Builder<T, E>();
  }

  /**
   * Convenience method to create new instance of class MultiTemplateClass.
   *
   *
   * @param pObject Value to which {@link #object} should be set.
   *
   * @param pNewState Value to which {@link #newState} should be set.
   *
   * @return {@link MultiTemplateClass<T, E>}
   */
  @SuppressWarnings("unchecked")
  public static <T, E> MultiTemplateClass<T, E> of( T pObject, E pNewState ) {
    var lBuilder = MultiTemplateClass.builder();
    lBuilder.setObject(pObject);
    lBuilder.setNewState(pNewState);
    return (MultiTemplateClass<T, E>) lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MultiTemplateClass</code>.
   */
  public static class Builder<T, E> {
    private T object;

    private E previousState;

    private E newState;

    /**
     * Use {@link MultiTemplateClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultiTemplateClass#builder(MultiTemplateClass)} instead of private constructor to create new builder.
     */
    protected Builder( MultiTemplateClass<T, E> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setObject(pObject.object);
        this.setPreviousState(pObject.previousState);
        this.setNewState(pObject.newState);
      }
    }

    /**
     * Method sets association {@link #object}.<br/>
     *
     * @param pObject Value to which {@link #object} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T, E> setObject( T pObject ) {
      object = pObject;
      return this;
    }

    /**
     * Method sets association {@link #previousState}.<br/>
     *
     * @param pPreviousState Value to which {@link #previousState} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T, E> setPreviousState( E pPreviousState ) {
      previousState = pPreviousState;
      return this;
    }

    /**
     * Method sets association {@link #newState}.<br/>
     *
     * @param pNewState Value to which {@link #newState} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T, E> setNewState( E pNewState ) {
      newState = pNewState;
      return this;
    }

    /**
     * Method creates a new instance of class MultiTemplateClass. The object will be initialized with the values of the
     * builder.
     *
     * @return MultiTemplateClass Created object. The method never returns null.
     */
    public MultiTemplateClass<T, E> build( ) {
      return new MultiTemplateClass<T, E>(this);
    }

    /**
     * Method creates a new validated instance of class MultiTemplateClass. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return MultiTemplateClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MultiTemplateClass<T, E> buildValidated( ) throws ConstraintViolationException {
      MultiTemplateClass<T, E> lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #object}.<br/>
   *
   * @return {@link T} Value to which {@link #object} is set.
   */
  public T getObject( ) {
    return object;
  }

  /**
   * Method sets association {@link #object}.<br/>
   *
   * @param pObject Value to which {@link #object} should be set.
   */
  public void setObject( T pObject ) {
    object = pObject;
  }

  /**
   * Method unsets {@link #object}.
   */
  public final void unsetObject( ) {
    object = null;
  }

  /**
   * Method returns association {@link #previousState}.<br/>
   *
   * @return {@link E} Value to which {@link #previousState} is set.
   */
  public E getPreviousState( ) {
    return previousState;
  }

  /**
   * Method sets association {@link #previousState}.<br/>
   *
   * @param pPreviousState Value to which {@link #previousState} should be set.
   */
  public void setPreviousState( E pPreviousState ) {
    previousState = pPreviousState;
  }

  /**
   * Method unsets {@link #previousState}.
   */
  public final void unsetPreviousState( ) {
    previousState = null;
  }

  /**
   * Method returns association {@link #newState}.<br/>
   *
   * @return {@link E} Value to which {@link #newState} is set.
   */
  public E getNewState( ) {
    return newState;
  }

  /**
   * Method sets association {@link #newState}.<br/>
   *
   * @param pNewState Value to which {@link #newState} should be set.
   */
  public void setNewState( E pNewState ) {
    newState = pNewState;
  }

  /**
   * Method unsets {@link #newState}.
   */
  public final void unsetNewState( ) {
    newState = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(object);
    lResult = lPrime * lResult + Objects.hashCode(previousState);
    lResult = lPrime * lResult + Objects.hashCode(newState);
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
      @SuppressWarnings("unchecked")
      MultiTemplateClass<T, E> lOther = (MultiTemplateClass<T, E>) pObject;
      lEquals = Objects.equals(object, lOther.object) && Objects.equals(previousState, lOther.previousState)
          && Objects.equals(newState, lOther.newState);
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
    lBuilder.append("object: ");
    lBuilder.append(object);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("previousState: ");
    lBuilder.append(previousState);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("newState: ");
    lBuilder.append(newState);
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
   * @return {@link Builder} New builder that can be used to create new MultiTemplateClass objects. The method never
   * returns null.
   */
  public Builder<T, E> toBuilder( ) {
    return new Builder<T, E>(this);
  }
}