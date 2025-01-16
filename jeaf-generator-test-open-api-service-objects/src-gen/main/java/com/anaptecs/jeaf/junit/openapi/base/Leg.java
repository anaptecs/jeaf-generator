/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class Leg implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private PlaceRef start;

  @NotNull
  private PlaceRef stop;

  @JsonSetter(nulls = Nulls.SKIP)
  private List<PlaceRef> stopovers;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Leg( ) {
    stopovers = new ArrayList<PlaceRef>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Leg( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    start = pBuilder.start;
    stop = pBuilder.stop;
    if (pBuilder.stopovers != null) {
      stopovers = pBuilder.stopovers;
    }
    else {
      stopovers = new ArrayList<PlaceRef>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Leg objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Leg.
   *
   *
   * @param pStart Value to which {@link #start} should be set.
   *
   * @param pStop Value to which {@link #stop} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.Leg}
   */
  public static Leg of( PlaceRef pStart, PlaceRef pStop ) {
    Leg.Builder lBuilder = Leg.builder();
    lBuilder.setStart(pStart);
    lBuilder.setStop(pStop);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Leg</code>.
   */
  public static class Builder {
    private PlaceRef start;

    private PlaceRef stop;

    private List<PlaceRef> stopovers;

    /**
     * Use {@link Leg#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Leg#builder(Leg)} instead of private constructor to create new builder.
     */
    protected Builder( Leg pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStart(pObject.start);
        this.setStop(pObject.stop);
        this.setStopovers(pObject.stopovers);
      }
    }

    /**
     * Method sets association {@link #start}.<br/>
     *
     * @param pStart Value to which {@link #start} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStart( @MyNotNullProperty PlaceRef pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets association {@link #stop}.<br/>
     *
     * @param pStop Value to which {@link #stop} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStop( @MyNotNullProperty PlaceRef pStop ) {
      stop = pStop;
      return this;
    }

    /**
     * Method sets association {@link #stopovers}.<br/>
     *
     * @param pStopovers Collection to which {@link #stopovers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStopovers( List<PlaceRef> pStopovers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStopovers != null) {
        stopovers = new ArrayList<PlaceRef>(pStopovers);
      }
      else {
        stopovers = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #stopovers}.<br/>
     *
     * @param pStopovers Array of objects that should be added to {@link #stopovers}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToStopovers( PlaceRef... pStopovers ) {
      if (pStopovers != null) {
        if (stopovers == null) {
          stopovers = new ArrayList<PlaceRef>();
        }
        stopovers.addAll(Arrays.asList(pStopovers));
      }
      return this;
    }

    /**
     * Method creates a new instance of class Leg. The object will be initialized with the values of the builder.
     *
     * @return Leg Created object. The method never returns null.
     */
    public Leg build( ) {
      return new Leg(this);
    }

    /**
     * Method creates a new validated instance of class Leg. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Leg Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Leg buildValidated( ) throws ConstraintViolationException {
      Leg lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #start}.<br/>
   *
   * @return {@link PlaceRef} Value to which {@link #start} is set.
   */
  @MyNotNullProperty
  public PlaceRef getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   *
   * @param pStart Value to which {@link #start} should be set.
   */
  public void setStart( @MyNotNullProperty PlaceRef pStart ) {
    start = pStart;
  }

  /**
   * Method unsets {@link #start}.
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns association {@link #stop}.<br/>
   *
   * @return {@link PlaceRef} Value to which {@link #stop} is set.
   */
  @MyNotNullProperty
  public PlaceRef getStop( ) {
    return stop;
  }

  /**
   * Method sets association {@link #stop}.<br/>
   *
   * @param pStop Value to which {@link #stop} should be set.
   */
  public void setStop( @MyNotNullProperty PlaceRef pStop ) {
    stop = pStop;
  }

  /**
   * Method unsets {@link #stop}.
   */
  public final void unsetStop( ) {
    stop = null;
  }

  /**
   * Method returns association {@link #stopovers}.<br/>
   *
   * @return {@link List<PlaceRef>} Value to which {@link #stopovers} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public List<PlaceRef> getStopovers( ) {
    // Return all PlaceRef objects directly without any protection against modification.
    return stopovers;
  }

  /**
   * Method adds the passed object to {@link #stopovers}.
   *
   * @param pStopovers Object that should be added to {@link #stopovers}. The parameter must not be null.
   */
  public void addToStopovers( PlaceRef pStopovers ) {
    // Check parameter "pStopovers" for invalid value null.
    Check.checkInvalidParameterNull(pStopovers, "pStopovers");
    // Add passed object to collection of associated PlaceRef objects.
    stopovers.add(pStopovers);
  }

  /**
   * Method adds all passed objects to {@link #stopovers}.
   *
   * @param pStopovers Collection with all objects that should be added to {@link #stopovers}. The parameter must not be
   * null.
   */
  public void addToStopovers( Collection<PlaceRef> pStopovers ) {
    // Check parameter "pStopovers" for invalid value null.
    Check.checkInvalidParameterNull(pStopovers, "pStopovers");
    // Add all passed objects.
    for (PlaceRef lNextObject : pStopovers) {
      this.addToStopovers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #stopovers}.<br/>
   *
   * @param pStopovers Object that should be removed from {@link #stopovers}. The parameter must not be null.
   */
  public void removeFromStopovers( PlaceRef pStopovers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStopovers, "pStopovers");
    // Remove passed object from collection of associated PlaceRef objects.
    stopovers.remove(pStopovers);
  }

  /**
   * Method removes all objects from {@link #stopovers}.
   */
  public void clearStopovers( ) {
    // Remove all objects from association "stopovers".
    stopovers.clear();
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
    lBuilder.append("start: ");
    if (start != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(start.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("stop: ");
    if (stop != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(stop.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("stopovers: ");
    if (stopovers != null) {
      lBuilder.append(stopovers.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (stopovers != null) {
      for (PlaceRef lNext : stopovers) {
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
   * @return {@link Builder} New builder that can be used to create new Leg objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}