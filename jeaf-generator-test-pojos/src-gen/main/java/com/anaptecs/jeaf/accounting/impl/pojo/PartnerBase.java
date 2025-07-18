/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

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
@JsonSubTypes({ @JsonSubTypes.Type(value = Customer.class, name = "Customer") })
public abstract class PartnerBase {
  /**
   * Constant for the name of attribute "tags".
   */
  public static final String TAGS = "tags";

  private String tags;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartnerBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    tags = pBuilder.tags;
  }

  /**
   * Class implements builder to create a new instance of class Partner. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private String tags;

    /**
     * Use {@link Partner.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Partner.builder(Partner)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( PartnerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTags(pObject.tags);
      }
    }

    /**
     * Method sets attribute {@link #tags}.<br/>
     *
     * @param pTags Value to which {@link #tags} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setTags( String pTags ) {
      // Assign value to attribute
      tags = pTags;
      return this;
    }
  }

  /**
   * Method returns attribute {@link #tags}.<br/>
   *
   * @return {@link String} Value to which {@link #tags} is set.
   */
  public String getTags( ) {
    return tags;
  }

  /**
   * Method sets attribute {@link #tags}.<br/>
   *
   * @param pTags Value to which {@link #tags} should be set.
   */
  public void setTags( String pTags ) {
    // Assign value to attribute
    tags = pTags;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(tags);
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
      PartnerBase lOther = (PartnerBase) pObject;
      lEquals = Objects.equals(tags, lOther.tags);
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
    lBuilder.append("tags: ");
    lBuilder.append(tags);
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