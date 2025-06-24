/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
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

  private String localKey;

  private String localID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LocalBeanParamType( LocalBeanParamTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    localKey = pBuilder.localKey;
    localID = pBuilder.localID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects.
   */
  public static LocalBeanParamTypeBuilder<?, ?> builder( ) {
    return new LocalBeanParamTypeBuilderImpl();
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
  public static abstract class LocalBeanParamTypeBuilder<T extends LocalBeanParamType, B extends LocalBeanParamTypeBuilder<T, B>> {
    private String localKey;

    private String localID;

    /**
     * Use {@link LocalBeanParamTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected LocalBeanParamTypeBuilder( ) {
    }

    /**
     * Use {@link LocalBeanParamTypeBuilder#builder(LocalBeanParamType)} instead of private constructor to create new
     * builder.
     */
    protected LocalBeanParamTypeBuilder( LocalBeanParamType pObject ) {
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLocalKey( @MyNotNullProperty String pLocalKey ) {
      // Assign value to attribute
      localKey = pLocalKey;
      return this.self();
    }

    /**
     * Method sets attribute {@link #localID}.<br/>
     *
     * @param pLocalID Value to which {@link #localID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLocalID( @MyNotNullProperty String pLocalID ) {
      // Assign value to attribute
      localID = pLocalID;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class LocalBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return LocalBeanParamType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class LocalBeanParamTypeBuilderImpl
      extends LocalBeanParamTypeBuilder<LocalBeanParamType, LocalBeanParamTypeBuilderImpl> {
    protected LocalBeanParamTypeBuilderImpl( ) {
    }

    protected LocalBeanParamTypeBuilderImpl( LocalBeanParamType pObject ) {
      super(pObject);
    }

    @Override
    protected LocalBeanParamTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public LocalBeanParamType build( ) {
      LocalBeanParamType lObject = new LocalBeanParamType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #localKey}.<br/>
   *
   * @return {@link String} Value to which {@link #localKey} is set.
   */
  @MyNotNullProperty
  public String getLocalKey( ) {
    return localKey;
  }

  /**
   * Method sets attribute {@link #localKey}.<br/>
   *
   * @param pLocalKey Value to which {@link #localKey} should be set.
   */
  public void setLocalKey( @MyNotNullProperty String pLocalKey ) {
    // Assign value to attribute
    localKey = pLocalKey;
  }

  /**
   * Method returns attribute {@link #localID}.<br/>
   *
   * @return {@link String} Value to which {@link #localID} is set.
   */
  @MyNotNullProperty
  public String getLocalID( ) {
    return localID;
  }

  /**
   * Method sets attribute {@link #localID}.<br/>
   *
   * @param pLocalID Value to which {@link #localID} should be set.
   */
  public void setLocalID( @MyNotNullProperty String pLocalID ) {
    // Assign value to attribute
    localID = pLocalID;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(localKey);
    lResult = lPrime * lResult + Objects.hashCode(localID);
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
      LocalBeanParamType lOther = (LocalBeanParamType) pObject;
      lEquals = Objects.equals(localKey, lOther.localKey) && Objects.equals(localID, lOther.localID);
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
  public LocalBeanParamTypeBuilder<?, ?> toBuilder( ) {
    return new LocalBeanParamTypeBuilderImpl(this);
  }
}