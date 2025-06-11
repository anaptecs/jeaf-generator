/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class TechnicalHeaderContext {
  /**
   * Constant for the name of attribute "reseller".
   */
  public static final String RESELLER = "reseller";

  private String reseller;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechnicalHeaderContext( TechnicalHeaderContextBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    reseller = pBuilder.reseller;
    // Add request headers.
    customHeaders = pBuilder.customHeaders;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects.
   */
  public static TechnicalHeaderContextBuilder<?, ?> builder( ) {
    return new TechnicalHeaderContextBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class TechnicalHeaderContext.
   *
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   *
   * @return {@link com.anaptecs.spring.base.TechnicalHeaderContext}
   */
  public static TechnicalHeaderContext of( String pReseller ) {
    TechnicalHeaderContextBuilder<?, ?> lBuilder = TechnicalHeaderContext.builder();
    lBuilder.setReseller(pReseller);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechnicalHeaderContext</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class TechnicalHeaderContextBuilder<T extends TechnicalHeaderContext, B extends TechnicalHeaderContextBuilder<T, B>> {
    private String reseller;

    /**
     * Map contains all custom headers that were set on the object.
     */
    private Map<String, String> customHeaders = new HashMap<String, String>();

    /**
     * Use {@link TechnicalHeaderContextBuilder#builder()} instead of private constructor to create new builder.
     */
    protected TechnicalHeaderContextBuilder( ) {
    }

    /**
     * Use {@link TechnicalHeaderContextBuilder#builder(TechnicalHeaderContext)} instead of private constructor to
     * create new builder.
     */
    protected TechnicalHeaderContextBuilder( TechnicalHeaderContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setReseller(pObject.reseller);
        customHeaders = new HashMap<String, String>(pObject.customHeaders);
      }
    }

    /**
     * Method sets attribute {@link #reseller}.<br/>
     *
     * @param pReseller Value to which {@link #reseller} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setReseller( @MyNotNullProperty String pReseller ) {
      // Assign value to attribute
      reseller = pReseller;
      return this.self();
    }

    /**
     * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
     * with guidelines about http headers.
     *
     * @param pHeaderName Name of the HTTP header. The parameter must not be null,
     * @param pHeaderValue Value of the http header the parameter may be null.
     */
    public TechnicalHeaderContextBuilder addCustomHeader( String pHeaderName, String pHeaderValue ) {
      if (pHeaderName != null) {
        customHeaders.put(pHeaderName, pHeaderValue);
        return this;
      }
      else {
        throw new IllegalArgumentException("Parameter 'pHeaderName' must not be null.");
      }
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class TechnicalHeaderContext. The object will be initialized with the values of
     * the builder.
     *
     * @return TechnicalHeaderContext Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class TechnicalHeaderContextBuilderImpl
      extends TechnicalHeaderContextBuilder<TechnicalHeaderContext, TechnicalHeaderContextBuilderImpl> {
    protected TechnicalHeaderContextBuilderImpl( ) {
    }

    protected TechnicalHeaderContextBuilderImpl( TechnicalHeaderContext pObject ) {
      super(pObject);
    }

    @Override
    protected TechnicalHeaderContextBuilderImpl self( ) {
      return this;
    }

    @Override
    public TechnicalHeaderContext build( ) {
      TechnicalHeaderContext lObject = new TechnicalHeaderContext(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #reseller}.<br/>
   *
   * @return {@link String} Value to which {@link #reseller} is set.
   */
  @MyNotNullProperty
  public String getReseller( ) {
    return reseller;
  }

  /**
   * Method sets attribute {@link #reseller}.<br/>
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   */
  public void setReseller( @MyNotNullProperty String pReseller ) {
    // Assign value to attribute
    reseller = pReseller;
  }

  /**
   * Method returns map with all custom headers that were added
   *
   * @return {@link Map} Map with all custom headers. The method never returns null. The returned map is unmodifiable.
   */
  public Map<String, String> getCustomHeaders( ) {
    return Collections.unmodifiableMap(customHeaders);
  }

  /**
   * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
   * with guidelines about http headers.
   *
   * @param pHeaderName Name of the HTTP header. The parameter must not be null,
   * @param pHeaderValue Value of the http header the parameter may be null.
   */
  public void addCustomHeader( String pHeaderName, String pHeaderValue ) {
    if (pHeaderName != null) {
      customHeaders.put(pHeaderName, pHeaderValue);
    }
    else {
      throw new IllegalArgumentException("Parameter 'pHeaderName' must not be null.");
    }
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(reseller);
    lResult = lPrime * lResult + Objects.hashCode(customHeaders);
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
      TechnicalHeaderContext lOther = (TechnicalHeaderContext) pObject;
      lEquals = Objects.equals(reseller, lOther.reseller) && Objects.equals(customHeaders, lOther.customHeaders);
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
    lBuilder.append("reseller: ");
    lBuilder.append(reseller);
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
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects. The method never
   * returns null.
   */
  public TechnicalHeaderContextBuilder<?, ?> toBuilder( ) {
    return new TechnicalHeaderContextBuilderImpl(this);
  }
}