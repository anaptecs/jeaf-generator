/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;

import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AbstractPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    abtractAttr = pBuilder.abtractAttr;
  }

  /**
   * Class implements builder to create a new instance of class <code>AbstractPOJO</code>.
   */
  public static abstract class Builder {
    private String abtractAttr;

    /**
     * Use {@link AbstractPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AbstractPOJO#builder(AbstractPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( AbstractPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        abtractAttr = pObject.abtractAttr;
      }
    }

    /**
     * Method sets attribute {@link #abtractAttr}.<br/>
     *
     * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAbtractAttr( String pAbtractAttr ) {
      // Assign value to attribute
      abtractAttr = pAbtractAttr;
      return this;
    }
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
