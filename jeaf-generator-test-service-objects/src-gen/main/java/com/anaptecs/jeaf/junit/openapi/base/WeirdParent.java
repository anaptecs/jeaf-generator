/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class WeirdParent implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "someProperty".
   */
  public static final String SOMEPROPERTY = "someProperty";

  /**
   * Constant for the name of attribute "complexBooking".
   */
  public static final String COMPLEXBOOKING = "complexBooking";

  /**
   * Constant for the name of attribute "complexBookings".
   */
  public static final String COMPLEXBOOKINGS = "complexBookings";

  /**
   * 
   */
  private String someProperty;

  /**
   * 
   */
  private ComplexBookingID complexBooking;

  /**
   * 
   */
  private Set<ComplexBookingID> complexBookings;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected WeirdParent( ) {
    complexBookings = new HashSet<ComplexBookingID>();
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
      complexBookings = new HashSet<ComplexBookingID>();
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new WeirdParent objects. The method never returns
   * null.
   */
  public static Builder builder( WeirdParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pSomeProperty ) {
    Builder lBuilder = builder();
    lBuilder.setSomeProperty(pSomeProperty);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class WeirdParent. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String someProperty;

    /**
     * 
     */
    private ComplexBookingID complexBooking;

    /**
     * 
     */
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
        someProperty = pObject.someProperty;
        complexBooking = pObject.complexBooking;
        complexBookings = pObject.complexBookings;
      }
    }

    /**
     * Method sets the attribute "someProperty".
     * 
     * @param pSomeProperty Value to which the attribute "someProperty" should be set.
     */
    public Builder setSomeProperty( String pSomeProperty ) {
      // Assign value to attribute
      someProperty = pSomeProperty;
      return this;
    }

    /**
     * Method sets the association "complexBooking".
     * 
     * @param pComplexBooking ComplexBookingID to which the association "complexBooking" should be set.
     */
    public Builder setComplexBooking( ComplexBookingID pComplexBooking ) {
      complexBooking = pComplexBooking;
      return this;
    }

    /**
     * Method sets the association "complexBookings".
     * 
     * @param pComplexBookings Collection with objects to which the association should be set.
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
      WeirdParent lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "someProperty".
   * 
   * 
   * @return String Value to which the attribute "someProperty" is set.
   */
  public String getSomeProperty( ) {
    return someProperty;
  }

  /**
   * Method sets the attribute "someProperty".
   * 
   * 
   * @param pSomeProperty Value to which the attribute "someProperty" should be set.
   */
  public void setSomeProperty( String pSomeProperty ) {
    // Assign value to attribute
    someProperty = pSomeProperty;
  }

  /**
   * Method returns the association "complexBooking".
   * 
   *
   * @return ComplexBookingID ComplexBookingID to which the association "complexBooking" is set.
   */
  public ComplexBookingID getComplexBooking( ) {
    return complexBooking;
  }

  /**
   * Method sets the association "complexBooking".
   * 
   * 
   * @param pComplexBooking ComplexBookingID to which the association "complexBooking" should be set.
   */
  public void setComplexBooking( ComplexBookingID pComplexBooking ) {
    complexBooking = pComplexBooking;
  }

  /**
   * Method unsets the association "complexBooking".
   * 
   */
  public final void unsetComplexBooking( ) {
    complexBooking = null;
  }

  /**
   * Method returns the association "complexBookings".
   * 
   *
   * @return Collection All ComplexBookingID objects that belong to the association "complexBookings". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<ComplexBookingID> getComplexBookings( ) {
    // Return all ComplexBookingID objects as unmodifiable collection.
    return Collections.unmodifiableSet(complexBookings);
  }

  /**
   * Method adds the passed ComplexBookingID object to the association "complexBookings".
   * 
   * 
   * @param pComplexBookings Object that should be added to the association "complexBookings". The parameter must not be
   * null.
   */
  public void addToComplexBookings( ComplexBookingID pComplexBookings ) {
    // Check parameter "pComplexBookings" for invalid value null.
    Check.checkInvalidParameterNull(pComplexBookings, "pComplexBookings");
    // Add passed object to collection of associated ComplexBookingID objects.
    complexBookings.add(pComplexBookings);
  }

  /**
   * Method adds all passed objects to the association "complexBookings".
   * 
   * 
   * @param pComplexBookings Collection with all objects that should be added to the association "complexBookings". The
   * parameter must not be null.
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
   * Method removes the passed ComplexBookingID object from the association "complexBookings".
   * 
   * 
   * @param pComplexBookings Object that should be removed from the association "complexBookings". The parameter must
   * not be null.
   */
  public void removeFromComplexBookings( ComplexBookingID pComplexBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pComplexBookings, "pComplexBookings");
    // Remove passed object from collection of associated ComplexBookingID objects.
    complexBookings.remove(pComplexBookings);
  }

  /**
   * Method removes all objects from the association "complexBookings".
   * 
   */
  public void clearComplexBookings( ) {
    // Remove all objects from association "complexBookings".
    complexBookings.clear();
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
