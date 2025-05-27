/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;

import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ImmutablePOJOParent.class, name = "ImmutablePOJOParent"),
  @JsonSubTypes.Type(value = ImmutableChildPOJO.class, name = "ImmutableChildPOJO"),
  @JsonSubTypes.Type(value = MutableChildPOJO.class, name = "MutableChildPOJO") })
public abstract class AbstractPOJO {
  /**
   * Constant for the name of attribute "abtractAttr".
   */
  public static final String ABTRACTATTR = "abtractAttr";

  private String abtractAttr;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractPOJO( AbstractPOJOBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    abtractAttr = pBuilder.abtractAttr;
  }

  /**
   * Class implements builder to create a new instance of class <code>AbstractPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class AbstractPOJOBuilder<T extends AbstractPOJO, B extends AbstractPOJOBuilder<T, B>> {
    private String abtractAttr;

    /**
     * Use {@link AbstractPOJOBuilder#builder()} instead of private constructor to create new builder.
     */
    protected AbstractPOJOBuilder( ) {
    }

    /**
     * Use {@link AbstractPOJOBuilder#builder(AbstractPOJO)} instead of private constructor to create new builder.
     */
    protected AbstractPOJOBuilder( AbstractPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAbtractAttr(pObject.abtractAttr);
      }
    }

    /**
     * Method sets attribute {@link #abtractAttr}.<br/>
     *
     * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAbtractAttr( String pAbtractAttr ) {
      // Assign value to attribute
      abtractAttr = pAbtractAttr;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );
  }

  /**
   * Method returns attribute {@link #abtractAttr}.<br/>
   *
   * @return {@link String} Value to which {@link #abtractAttr} is set.
   */
  public String getAbtractAttr( ) {
    return abtractAttr;
  }

  /**
   * Method sets attribute {@link #abtractAttr}.<br/>
   *
   * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
   */
  public void setAbtractAttr( String pAbtractAttr ) {
    // Assign value to attribute
    abtractAttr = pAbtractAttr;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(abtractAttr);
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
      AbstractPOJO lOther = (AbstractPOJO) pObject;
      lEquals = Objects.equals(abtractAttr, lOther.abtractAttr);
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
    lBuilder.append("abtractAttr: ");
    lBuilder.append(abtractAttr);
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