/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Leg objects. The method never returns null.
   */
  public static Builder builder( Leg pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Leg. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private PlaceRef start;

    /**
     * 
     */
    private PlaceRef stop;

    /**
     * 
     */
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
        start = pObject.start;
        stop = pObject.stop;
        stopovers = pObject.stopovers;
      }
    }

    /**
     * Method sets the association "start".
     * 
     * @param pStart PlaceRef to which the association "start" should be set.
     */
    public Builder setStart( PlaceRef pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets the association "stop".
     * 
     * @param pStop PlaceRef to which the association "stop" should be set.
     */
    public Builder setStop( PlaceRef pStop ) {
      stop = pStop;
      return this;
    }

    /**
     * Method sets the association "stopovers".
     * 
     * @param pStopovers Collection with objects to which the association should be set.
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
   * Method adds all passed objects to the association "stopovers".
   * 
   * 
   * @param pStopovers Collection with all objects that should be added to the association "stopovers". The parameter
   * must not be null.
   */
  public void addToStopovers( Collection<PlaceRef> pStopovers ) {
    // Add all passed objects.
    for (PlaceRef lNextObject : pStopovers) {
      this.addToStopovers(lNextObject);
    }
  }

  /**
   * Method removes the passed PlaceRef object from the association "stopovers".
   * 
   * 
   * @param pStopovers Object that should be removed from the association "stopovers". The parameter must not be null.
   */
  public void removeFromStopovers( PlaceRef pStopovers ) {
    // Remove passed object from collection of associated PlaceRef objects.
    stopovers.remove(pStopovers);
  }

  /**
   * Method removes all objects from the association "stopovers".
   * 
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
}
