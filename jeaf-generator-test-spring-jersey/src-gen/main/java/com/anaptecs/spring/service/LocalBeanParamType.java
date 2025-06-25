/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import javax.ws.rs.HeaderParam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class LocalBeanParamType {
  /**
   * Constant for the name of attribute "localKey".
   */
  public static final String LOCALKEY = "localKey";

  /**
   * Constant for the name of attribute "localID".
   */
  public static final String LOCALID = "localID";

  @HeaderParam("localKey")
  private String localKey;

  @HeaderParam("localID")
  private String localID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LocalBeanParamType( Builder pBuilder ) {
    // Read attribute values from builder.
    localKey = pBuilder.localKey;
    localID = pBuilder.localID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class LocalBeanParamType.
   *
   *
   * @param pLocalKey Value to which {@link #localKey} should be set.
   *
   * @param pLocalID Value to which {@link #localID} should be set.
   *
   * @return {@link com.anaptecs.spring.service.LocalBeanParamType}
   */
  public static LocalBeanParamType of( String pLocalKey, String pLocalID ) {
    var lBuilder = LocalBeanParamType.builder();
    lBuilder.setLocalKey(pLocalKey);
    lBuilder.setLocalID(pLocalID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>LocalBeanParamType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String localKey;

    private String localID;

    /**
     * Use {@link LocalBeanParamType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link LocalBeanParamType#builder(LocalBeanParamType)} instead of private constructor to create new builder.
     */
    protected Builder( LocalBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setLocalKey(pObject.localKey);
        this.setLocalID(pObject.localID);
      }
    }

    /**
     * Method sets attribute {@link #localKey}.<br/>
     *
     * @param pLocalKey Value to which {@link #localKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalKey( String pLocalKey ) {
      // Assign value to attribute
      localKey = pLocalKey;
      return this;
    }

    /**
     * Method sets attribute {@link #localID}.<br/>
     *
     * @param pLocalID Value to which {@link #localID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalID( String pLocalID ) {
      // Assign value to attribute
      localID = pLocalID;
      return this;
    }

    /**
     * Method creates a new instance of class LocalBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return LocalBeanParamType Created object. The method never returns null.
     */
    public LocalBeanParamType build( ) {
      return new LocalBeanParamType(this);
    }
  }

  /**
   * Method returns attribute {@link #localKey}.<br/>
   *
   * @return {@link String} Value to which {@link #localKey} is set.
   */
  public String getLocalKey( ) {
    return localKey;
  }

  /**
   * Method sets attribute {@link #localKey}.<br/>
   *
   * @param pLocalKey Value to which {@link #localKey} should be set.
   */
  public void setLocalKey( String pLocalKey ) {
    // Assign value to attribute
    localKey = pLocalKey;
  }

  /**
   * Method returns attribute {@link #localID}.<br/>
   *
   * @return {@link String} Value to which {@link #localID} is set.
   */
  public String getLocalID( ) {
    return localID;
  }

  /**
   * Method sets attribute {@link #localID}.<br/>
   *
   * @param pLocalID Value to which {@link #localID} should be set.
   */
  public void setLocalID( String pLocalID ) {
    // Assign value to attribute
    localID = pLocalID;
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
    lBuilder.append("localKey: ");
    lBuilder.append(localKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localID: ");
    lBuilder.append(localID);
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
   * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}