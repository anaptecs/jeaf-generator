/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
@JsonIgnoreProperties(value = "objectType")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = WeirdBooking.class, name = "WeirdBooking") })
public class WeirdParent implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String someProperty;

  @Valid
  @NotNull
  private ComplexBookingID complexBooking;

  @Valid
  @JsonSetter(nulls = Nulls.SKIP)
  @Size(min = 1)
  @NotNull
  private Set<ComplexBookingID> complexBookings;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WeirdParent( ) {
    complexBookings = new HashSet<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WeirdParent( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    someProperty = pBuilder.someProperty;
    complexBooking = pBuilder.complexBooking;
    if (pBuilder.complexBookings != null) {
      complexBookings = pBuilder.complexBookings;
    }
    else {
      complexBookings = new HashSet<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WeirdParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pSomeProperty, ComplexBookingID pComplexBooking ) {
    Builder lBuilder = builder();
    lBuilder.setSomeProperty(pSomeProperty);
    lBuilder.setComplexBooking(pComplexBooking);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class WeirdParent.
   *
   *
   * @param pSomeProperty Value to which {@link #someProperty} should be set.
   *
   * @param pComplexBooking Value to which {@link #complexBooking} should be set.
   *
   * @param pComplexBookings Value to which {@link #complexBookings} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.WeirdParent}
   */
  public static WeirdParent of( String pSomeProperty, ComplexBookingID pComplexBooking,
      Set<ComplexBookingID> pComplexBookings ) {
    var lBuilder = WeirdParent.builder();
    lBuilder.setSomeProperty(pSomeProperty);
    lBuilder.setComplexBooking(pComplexBooking);
    lBuilder.setComplexBookings(pComplexBookings);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>WeirdParent</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String someProperty;

    private ComplexBookingID complexBooking;

    private Set<ComplexBookingID> complexBookings;

    /**
     * Use {@link WeirdParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WeirdParent#builder(WeirdParent)} instead of private constructor to create new builder.
     */
    protected Builder( WeirdParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSomeProperty(pObject.someProperty);
        this.setComplexBooking(pObject.complexBooking);
        this.setComplexBookings(pObject.complexBookings);
      }
    }

    /**
     * Method sets attribute {@link #someProperty}.<br/>
     *
     * @param pSomeProperty Value to which {@link #someProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSomeProperty( String pSomeProperty ) {
      // Assign value to attribute
      someProperty = pSomeProperty;
      return this;
    }

    /**
     * Method sets association {@link #complexBooking}.<br/>
     *
     * @param pComplexBooking Value to which {@link #complexBooking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setComplexBooking( ComplexBookingID pComplexBooking ) {
      complexBooking = pComplexBooking;
      return this;
    }

    /**
     * Method sets association {@link #complexBookings}.<br/>
     *
     * @param pComplexBookings Collection to which {@link #complexBookings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setComplexBookings( Set<ComplexBookingID> pComplexBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pComplexBookings != null) {
        complexBookings = new HashSet<ComplexBookingID>(pComplexBookings);
      }
      else {
        complexBookings = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #complexBookings}.<br/>
     *
     * @param pComplexBookings Array of objects that should be added to {@link #complexBookings}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToComplexBookings( ComplexBookingID... pComplexBookings ) {
      if (pComplexBookings != null) {
        if (complexBookings == null) {
          complexBookings = new HashSet<ComplexBookingID>();
        }
        complexBookings.addAll(Arrays.asList(pComplexBookings));
      }
      return this;
    }

    /**
     * Method creates a new instance of class WeirdParent. The object will be initialized with the values of the
     * builder.
     *
     * @return WeirdParent Created object. The method never returns null.
     */
    public WeirdParent build( ) {
      return new WeirdParent(this);
    }

    /**
     * Method creates a new validated instance of class WeirdParent. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return WeirdParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WeirdParent buildValidated( ) throws ConstraintViolationException {
      WeirdParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #someProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #someProperty} is set.
   */
  public String getSomeProperty( ) {
    return someProperty;
  }

  /**
   * Method sets attribute {@link #someProperty}.<br/>
   *
   * @param pSomeProperty Value to which {@link #someProperty} should be set.
   */
  public void setSomeProperty( String pSomeProperty ) {
    // Assign value to attribute
    someProperty = pSomeProperty;
  }

  /**
   * Method returns association {@link #complexBooking}.<br/>
   *
   * @return {@link ComplexBookingID} Value to which {@link #complexBooking} is set.
   */
  public ComplexBookingID getComplexBooking( ) {
    return complexBooking;
  }

  /**
   * Method sets association {@link #complexBooking}.<br/>
   *
   * @param pComplexBooking Value to which {@link #complexBooking} should be set.
   */
  public void setComplexBooking( ComplexBookingID pComplexBooking ) {
    complexBooking = pComplexBooking;
  }

  /**
   * Method unsets {@link #complexBooking}.
   */
  public final void unsetComplexBooking( ) {
    complexBooking = null;
  }

  /**
   * Method returns association {@link #complexBookings}.<br/>
   *
   * @return {@link Set<ComplexBookingID>} Value to which {@link #complexBookings} is set. The method never returns null
   * and the returned collection is modifiable.
   */
  public Set<ComplexBookingID> getComplexBookings( ) {
    // Return all ComplexBookingID objects directly without any protection against modification.
    return complexBookings;
  }

  /**
   * Method adds the passed object to {@link #complexBookings}.
   *
   * @param pComplexBookings Object that should be added to {@link #complexBookings}. The parameter must not be null.
   */
  public void addToComplexBookings( ComplexBookingID pComplexBookings ) {
    // Check parameter "pComplexBookings" for invalid value null.
    Check.checkInvalidParameterNull(pComplexBookings, "pComplexBookings");
    // Add passed object to collection of associated ComplexBookingID objects.
    complexBookings.add(pComplexBookings);
  }

  /**
   * Method adds all passed objects to {@link #complexBookings}.
   *
   * @param pComplexBookings Collection with all objects that should be added to {@link #complexBookings}. The parameter
   * must not be null.
   */
  public void addToComplexBookings( Collection<ComplexBookingID> pComplexBookings ) {
    // Check parameter "pComplexBookings" for invalid value null.
    Check.checkInvalidParameterNull(pComplexBookings, "pComplexBookings");
    // Add all passed objects.
    for (ComplexBookingID lNextObject : pComplexBookings) {
      this.addToComplexBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #complexBookings}.<br/>
   *
   * @param pComplexBookings Object that should be removed from {@link #complexBookings}. The parameter must not be
   * null.
   */
  public void removeFromComplexBookings( ComplexBookingID pComplexBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pComplexBookings, "pComplexBookings");
    // Remove passed object from collection of associated ComplexBookingID objects.
    complexBookings.remove(pComplexBookings);
  }

  /**
   * Method removes all objects from {@link #complexBookings}.
   */
  public void clearComplexBookings( ) {
    // Remove all objects from association "complexBookings".
    complexBookings.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(someProperty);
    lResult = lPrime * lResult + Objects.hashCode(complexBooking);
    lResult = lPrime * lResult + Objects.hashCode(complexBookings);
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
      WeirdParent lOther = (WeirdParent) pObject;
      lEquals =
          Objects.equals(someProperty, lOther.someProperty) && Objects.equals(complexBooking, lOther.complexBooking)
              && Objects.equals(complexBookings, lOther.complexBookings);
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
    lBuilder.append("someProperty: ");
    lBuilder.append(someProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("complexBooking: ");
    if (complexBooking != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(complexBooking.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("complexBookings: ");
    if (complexBookings != null) {
      lBuilder.append(complexBookings.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (complexBookings != null) {
      for (ComplexBookingID lNext : complexBookings) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new WeirdParent objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}