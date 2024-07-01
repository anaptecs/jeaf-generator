/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class AbstractWithCustomImplBase {
  /**
   * Constant for the name of attribute "justAProperty".
   */
  public static final String JUSTAPROPERTY = "justAProperty";

  private int justAProperty;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AbstractWithCustomImplBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractWithCustomImplBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    justAProperty = pBuilder.justAProperty;
  }

  /**
   * Class implements builder to create a new instance of class AbstractWithCustomImpl. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private int justAProperty;

    /**
     * Use {@link AbstractWithCustomImpl.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AbstractWithCustomImpl.builder(AbstractWithCustomImpl)} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( AbstractWithCustomImplBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setJustAProperty(pObject.justAProperty);
      }
    }

    /**
     * Method sets attribute {@link #justAProperty}.<br/>
     *
     * @param pJustAProperty Value to which {@link #justAProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setJustAProperty( int pJustAProperty ) {
      // Assign value to attribute
      justAProperty = pJustAProperty;
      return this;
    }
  }

  /**
   * Method returns attribute {@link #justAProperty}.<br/>
   *
   * @return int Value to which {@link #justAProperty} is set.
   */
  public int getJustAProperty( ) {
    return justAProperty;
  }

  /**
   * Method sets attribute {@link #justAProperty}.<br/>
   *
   * @param pJustAProperty Value to which {@link #justAProperty} should be set.
   */
  public void setJustAProperty( int pJustAProperty ) {
    // Assign value to attribute
    justAProperty = pJustAProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + justAProperty;
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
      AbstractWithCustomImplBase lOther = (AbstractWithCustomImplBase) pObject;
      lEquals = justAProperty == lOther.justAProperty;
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
    lBuilder.append("justAProperty: ");
    lBuilder.append(justAProperty);
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
