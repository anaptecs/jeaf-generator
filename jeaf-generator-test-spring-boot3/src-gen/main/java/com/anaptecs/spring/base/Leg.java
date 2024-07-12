/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Leg {
  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  /**
   * Constant for the name of attribute "stop".
   */
  public static final String STOP = "stop";

  /**
   * Constant for the name of attribute "stopovers".
   */
  public static final String STOPOVERS = "stopovers";

  private PlaceRef start;

  private PlaceRef stop;

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
   * @return {@link com.anaptecs.spring.base.Leg}
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
    public Builder setStart( PlaceRef pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets association {@link #stop}.<br/>
     *
     * @param pStop Value to which {@link #stop} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStop( PlaceRef pStop ) {
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
  }

  /**
   * Method returns association {@link #start}.<br/>
   *
   * @return {@link PlaceRef} Value to which {@link #start} is set.
   */
  public PlaceRef getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   *
   * @param pStart Value to which {@link #start} should be set.
   */
  public void setStart( PlaceRef pStart ) {
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
  public PlaceRef getStop( ) {
    return stop;
  }

  /**
   * Method sets association {@link #stop}.<br/>
   *
   * @param pStop Value to which {@link #stop} should be set.
   */
  public void setStop( PlaceRef pStop ) {
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
   * returned collection is unmodifiable.
   */
  public List<PlaceRef> getStopovers( ) {
    // Return all PlaceRef objects as unmodifiable collection.
    return Collections.unmodifiableList(stopovers);
  }

  /**
   * Method adds the passed object to {@link #stopovers}.
   *
   * @param pStopovers Object that should be added to {@link #stopovers}. The parameter must not be null.
   */
  public void addToStopovers( PlaceRef pStopovers ) {
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(start);
    lResult = lPrime * lResult + Objects.hashCode(stop);
    lResult = lPrime * lResult + Objects.hashCode(stopovers);
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
      Leg lOther = (Leg) pObject;
      lEquals = Objects.equals(start, lOther.start) && Objects.equals(stop, lOther.stop)
          && Objects.equals(stopovers, lOther.stopovers);
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