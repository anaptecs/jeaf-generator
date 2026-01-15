/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
public abstract class AbtractWithDerivedPropertyAndCustomImplBase {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbtractWithDerivedPropertyAndCustomImplBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
  }

  /**
   * Class implements builder to create a new instance of class AbtractWithDerivedPropertyAndCustomImpl. As the class
   * has read only attributes or associations instances can not be created directly. Instead this builder class has to
   * be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    /**
     * Use {@link AbtractWithDerivedPropertyAndCustomImpl.builder()} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AbtractWithDerivedPropertyAndCustomImpl.builder(AbtractWithDerivedPropertyAndCustomImpl)} instead of
     * protected constructor to create new builder.
     */
    protected BuilderBase( AbtractWithDerivedPropertyAndCustomImplBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  public abstract String getDerivedProperty( );

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
}