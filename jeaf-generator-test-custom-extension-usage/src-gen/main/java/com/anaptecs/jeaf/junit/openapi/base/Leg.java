/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Leg extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "start".
   */
  @JEAFCustomAnnotationTest
  public static final String START = "start";

  /**
   * Constant for the name of attribute "stop".
   */
  @JEAFCustomAnnotationTest
  public static final String STOP = "stop";

  /**
   * Constant for the name of attribute "stopovers".
   */
  @JEAFCustomAnnotationTest
  public static final String STOPOVERS = "stopovers";

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private PlaceRef start;

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  private int startXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private PlaceRef stop;

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  private int stopXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private List<PlaceRef> stopovers;

  // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
  private int stopoversXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Leg( ) {
    stopovers = new ArrayList<>();
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
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    startXYZ = pBuilder.startXYZ;
    stop = pBuilder.stop;
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    stopXYZ = pBuilder.stopXYZ;
    if (pBuilder.stopovers != null) {
      stopovers = pBuilder.stopovers;
    }
    else {
      stopovers = new ArrayList<>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    stopoversXYZ = pBuilder.stopoversXYZ;
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
   * Class implements builder to create a new instance of class <code>Leg</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private PlaceRef start;

    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    private int startXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private PlaceRef stop;

    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    private int stopXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<PlaceRef> stopovers;

    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    private int stopoversXYZ = 0;

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
    @JEAFCustomAnnotationTest
    public Builder setStart( PlaceRef pStart ) {
      start = pStart;
      return this;
    }

    public Builder setStartXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
      startXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #stop}.<br/>
     *
     * @param pStop Value to which {@link #stop} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setStop( PlaceRef pStop ) {
      stop = pStop;
      return this;
    }

    public Builder setStopXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
      stopXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #stopovers}.<br/>
     *
     * @param pStopovers Collection to which {@link #stopovers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
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
    @JEAFCustomAnnotationTest
    public Builder addToStopovers( PlaceRef... pStopovers ) {
      if (pStopovers != null) {
        if (stopovers == null) {
          stopovers = new ArrayList<PlaceRef>();
        }
        stopovers.addAll(Arrays.asList(pStopovers));
      }
      return this;
    }

    public Builder setStopoversXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
      stopoversXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
  public PlaceRef getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   *
   * @param pStart Value to which {@link #start} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setStart( PlaceRef pStart ) {
    start = pStart;
  }

  /**
   * Method unsets {@link #start}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetStart( ) {
    start = null;
  }

  public int getStartXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    return startXYZ;
  }

  public void setStartXYZ( int value ) {
    startXYZ = value;
  }

  /**
   * Method returns association {@link #stop}.<br/>
   *
   * @return {@link PlaceRef} Value to which {@link #stop} is set.
   */
  @JEAFCustomAnnotationTest
  public PlaceRef getStop( ) {
    return stop;
  }

  /**
   * Method sets association {@link #stop}.<br/>
   *
   * @param pStop Value to which {@link #stop} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setStop( PlaceRef pStop ) {
    stop = pStop;
  }

  /**
   * Method unsets {@link #stop}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetStop( ) {
    stop = null;
  }

  public int getStopXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    return stopXYZ;
  }

  public void setStopXYZ( int value ) {
    stopXYZ = value;
  }

  /**
   * Method returns association {@link #stopovers}.<br/>
   *
   * @return {@link List<PlaceRef>} Value to which {@link #stopovers} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<PlaceRef> getStopovers( ) {
    // Return all PlaceRef objects as unmodifiable collection.
    return Collections.unmodifiableList(stopovers);
  }

  /**
   * Method adds the passed object to {@link #stopovers}.
   *
   * @param pStopovers Object that should be added to {@link #stopovers}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
  public void removeFromStopovers( PlaceRef pStopovers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStopovers, "pStopovers");
    // Remove passed object from collection of associated PlaceRef objects.
    stopovers.remove(pStopovers);
  }

  /**
   * Method removes all objects from {@link #stopovers}.
   */
  @JEAFCustomAnnotationTest
  public void clearStopovers( ) {
    // Remove all objects from association "stopovers".
    stopovers.clear();
  }

  public int getStopoversXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.PlaceRef"
    return stopoversXYZ;
  }

  public void setStopoversXYZ( int value ) {
    stopoversXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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