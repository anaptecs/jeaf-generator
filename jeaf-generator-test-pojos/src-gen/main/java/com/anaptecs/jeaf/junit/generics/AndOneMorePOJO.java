/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
public class AndOneMorePOJO {
  /**
   * Constant for the name of attribute "genericProperty".
   */
  public static final String GENERICPROPERTY = "genericProperty";

  /**
   * Constant for the name of attribute "genericResponses".
   */
  public static final String GENERICRESPONSES = "genericResponses";

  private GenericResponsePOJO<MyBusinessObject> genericProperty;

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<GenericResponsePOJO<MyBusinessObject>> genericResponses;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AndOneMorePOJO( ) {
    genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AndOneMorePOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    genericProperty = pBuilder.genericProperty;
    if (pBuilder.genericResponses != null) {
      genericResponses = pBuilder.genericResponses;
    }
    else {
      genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( AndOneMorePOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class AndOneMorePOJO.
   *
   *
   * @param pGenericProperty Value to which {@link #genericProperty} should be set.
   *
   * @return {@link AndOneMorePOJO}
   */
  public static AndOneMorePOJO of( GenericResponsePOJO<MyBusinessObject> pGenericProperty ) {
    AndOneMorePOJO.Builder lBuilder = AndOneMorePOJO.builder();
    lBuilder.setGenericProperty(pGenericProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>AndOneMorePOJO</code>.
   */
  public static class Builder {
    private GenericResponsePOJO<MyBusinessObject> genericProperty;

    private Set<GenericResponsePOJO<MyBusinessObject>> genericResponses;

    /**
     * Use {@link AndOneMorePOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AndOneMorePOJO#builder(AndOneMorePOJO)} instead of private constructor to create new builder.
     */
    protected Builder( AndOneMorePOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setGenericProperty(pObject.genericProperty);
        this.setGenericResponses(pObject.genericResponses);
      }
    }

    /**
     * Method sets attribute {@link #genericProperty}.<br/>
     *
     * @param pGenericProperty Value to which {@link #genericProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setGenericProperty( GenericResponsePOJO<MyBusinessObject> pGenericProperty ) {
      // Assign value to attribute
      genericProperty = pGenericProperty;
      return this;
    }

    /**
     * Method sets association {@link #genericResponses}.<br/>
     *
     * @param pGenericResponses Collection to which {@link #genericResponses} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setGenericResponses( Set<GenericResponsePOJO<MyBusinessObject>> pGenericResponses ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pGenericResponses != null) {
        genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>(pGenericResponses);
      }
      else {
        genericResponses = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #genericResponses}.<br/>
     *
     * @param pGenericResponses Array of objects that should be added to {@link #genericResponses}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToGenericResponses( GenericResponsePOJO<MyBusinessObject>... pGenericResponses ) {
      if (pGenericResponses != null) {
        if (genericResponses == null) {
          genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>();
        }
        genericResponses.addAll(Arrays.asList(pGenericResponses));
      }
      return this;
    }

    /**
     * Method creates a new instance of class AndOneMorePOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return AndOneMorePOJO Created object. The method never returns null.
     */
    public AndOneMorePOJO build( ) {
      return new AndOneMorePOJO(this);
    }

    /**
     * Method creates a new validated instance of class AndOneMorePOJO. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return AndOneMorePOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public AndOneMorePOJO buildValidated( ) throws ConstraintViolationException {
      AndOneMorePOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #genericProperty}.<br/>
   *
   * @return {@link GenericResponsePOJO<MyBusinessObject>} Value to which {@link #genericProperty} is set.
   */
  public GenericResponsePOJO<MyBusinessObject> getGenericProperty( ) {
    return genericProperty;
  }

  /**
   * Method sets attribute {@link #genericProperty}.<br/>
   *
   * @param pGenericProperty Value to which {@link #genericProperty} should be set.
   */
  public void setGenericProperty( GenericResponsePOJO<MyBusinessObject> pGenericProperty ) {
    // Assign value to attribute
    genericProperty = pGenericProperty;
  }

  /**
   * Method returns association {@link #genericResponses}.<br/>
   *
   * @return {@link Set<GenericResponsePOJO<MyBusinessObject>>} Value to which {@link #genericResponses} is set. The
   * method never returns null and the returned collection is unmodifiable.
   */
  public Set<GenericResponsePOJO<MyBusinessObject>> getGenericResponses( ) {
    // Return all DoSomethingResponse objects as unmodifiable collection.
    return Collections.unmodifiableSet(genericResponses);
  }

  /**
   * Method adds the passed object to {@link #genericResponses}.
   *
   * @param pGenericResponses Object that should be added to {@link #genericResponses}. The parameter must not be null.
   */
  public void addToGenericResponses( GenericResponsePOJO<MyBusinessObject> pGenericResponses ) {
    // Check parameter "pGenericResponses" for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Add passed object to collection of associated DoSomethingResponse objects.
    genericResponses.add(pGenericResponses);
  }

  /**
   * Method adds all passed objects to {@link #genericResponses}.
   *
   * @param pGenericResponses Collection with all objects that should be added to {@link #genericResponses}. The
   * parameter must not be null.
   */
  public void addToGenericResponses( Collection<GenericResponsePOJO<MyBusinessObject>> pGenericResponses ) {
    // Check parameter "pGenericResponses" for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Add all passed objects.
    for (GenericResponsePOJO<MyBusinessObject> lNextObject : pGenericResponses) {
      this.addToGenericResponses(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #genericResponses}.<br/>
   *
   * @param pGenericResponses Object that should be removed from {@link #genericResponses}. The parameter must not be
   * null.
   */
  public void removeFromGenericResponses( GenericResponsePOJO<MyBusinessObject> pGenericResponses ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Remove passed object from collection of associated DoSomethingResponse objects.
    genericResponses.remove(pGenericResponses);
  }

  /**
   * Method removes all objects from {@link #genericResponses}.
   */
  public void clearGenericResponses( ) {
    // Remove all objects from association "genericResponses".
    genericResponses.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(genericProperty);
    lResult = lPrime * lResult + Objects.hashCode(genericResponses);
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
      AndOneMorePOJO lOther = (AndOneMorePOJO) pObject;
      lEquals = Objects.equals(genericProperty, lOther.genericProperty)
          && Objects.equals(genericResponses, lOther.genericResponses);
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
    lBuilder.append("genericProperty: ");
    lBuilder.append(genericProperty);
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
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
