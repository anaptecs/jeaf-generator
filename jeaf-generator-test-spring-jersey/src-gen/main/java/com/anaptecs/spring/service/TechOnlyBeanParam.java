/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class TechOnlyBeanParam {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechOnlyBeanParam( Builder pBuilder ) {
    // Read attribute values from builder.
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechOnlyBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class TechOnlyBeanParam.
   *
   *
   * @return {@link TechOnlyBeanParam}
   */
  public static TechOnlyBeanParam of( ) {
    var lBuilder = TechOnlyBeanParam.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechOnlyBeanParam</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * Use {@link TechOnlyBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechOnlyBeanParam#builder(TechOnlyBeanParam)} instead of private constructor to create new builder.
     */
    protected Builder( TechOnlyBeanParam pObject ) {
    }

    /**
     * Method creates a new instance of class TechOnlyBeanParam. The object will be initialized with the values of the
     * builder.
     *
     * @return TechOnlyBeanParam Created object. The method never returns null.
     */
    public TechOnlyBeanParam build( ) {
      return new TechOnlyBeanParam(this);
    }
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
   * @return {@link Builder} New builder that can be used to create new TechOnlyBeanParam objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}