/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Locale;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Deprecated
public class DeprecatedContext {
  /**
   * Constant for the name of attribute "accessToken".
   */
  public static final String ACCESSTOKEN = "accessToken";

  /**
   * Constant for the name of attribute "language".
   */
  public static final String LANGUAGE = "language";

  /**
   * Constant for the name of attribute "resellerID".
   */
  public static final String RESELLERID = "resellerID";

  /**
   * Constant for the name of attribute "queryParam".
   */
  public static final String QUERYPARAM = "queryParam";

  @NotEmpty
  private String accessToken;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>en</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> <code>lang</code>
   */
  private Locale language;

  private long resellerID;

  private String queryParam;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedContext( DeprecatedContextBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    language = pBuilder.language;
    resellerID = pBuilder.resellerID;
    queryParam = pBuilder.queryParam;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DeprecatedContext objects.
   */
  public static DeprecatedContextBuilder<?, ?> builder( ) {
    return new DeprecatedContextBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class DeprecatedContext.
   *
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   *
   * @param pLanguage Value to which {@link #language} should be set.
   *
   * @param pResellerID Value to which {@link #resellerID} should be set.
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   *
   * @return {@link DeprecatedContext}
   */
  public static DeprecatedContext of( String pAccessToken, Locale pLanguage, long pResellerID, String pQueryParam ) {
    var lBuilder = DeprecatedContext.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setQueryParam(pQueryParam);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedContext</code>.
   */
  @Deprecated
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DeprecatedContextBuilder<T extends DeprecatedContext, B extends DeprecatedContextBuilder<T, B>> {
    @NotEmpty
    private String accessToken;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>en</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> <code>lang</code>
     */
    private Locale language;

    private long resellerID;

    private String queryParam;

    /**
     * Use {@link DeprecatedContextBuilder#builder()} instead of private constructor to create new builder.
     */
    protected DeprecatedContextBuilder( ) {
    }

    /**
     * Use {@link DeprecatedContextBuilder#builder(DeprecatedContext)} instead of private constructor to create new
     * builder.
     */
    protected DeprecatedContextBuilder( DeprecatedContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAccessToken(pObject.accessToken);
        this.setLanguage(pObject.language);
        this.setResellerID(pObject.resellerID);
        this.setQueryParam(pObject.queryParam);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAccessToken( @MyNotNullProperty String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this.self();
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLanguage( @MyNotNullProperty Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this.self();
    }

    /**
     * Method sets attribute {@link #resellerID}.<br/>
     *
     * @param pResellerID Value to which {@link #resellerID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setResellerID( long pResellerID ) {
      // Assign value to attribute
      resellerID = pResellerID;
      return this.self();
    }

    /**
     * Method sets attribute {@link #queryParam}.<br/>
     *
     * @param pQueryParam Value to which {@link #queryParam} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setQueryParam( @MyNotNullProperty String pQueryParam ) {
      // Assign value to attribute
      queryParam = pQueryParam;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class DeprecatedContext. The object will be initialized with the values of the
     * builder.
     *
     * @return DeprecatedContext Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DeprecatedContextBuilderImpl
      extends DeprecatedContextBuilder<DeprecatedContext, DeprecatedContextBuilderImpl> {
    protected DeprecatedContextBuilderImpl( ) {
    }

    protected DeprecatedContextBuilderImpl( DeprecatedContext pObject ) {
      super(pObject);
    }

    @Override
    protected DeprecatedContextBuilderImpl self( ) {
      return this;
    }

    @Override
    public DeprecatedContext build( ) {
      DeprecatedContext lObject = new DeprecatedContext(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #accessToken}.<br/>
   *
   * @return {@link String} Value to which {@link #accessToken} is set.
   */
  @MyNotNullProperty
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets attribute {@link #accessToken}.<br/>
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   */
  public void setAccessToken( @MyNotNullProperty String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @MyNotNullProperty
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  public void setLanguage( @MyNotNullProperty Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns attribute {@link #resellerID}.<br/>
   *
   * @return long Value to which {@link #resellerID} is set.
   */
  public long getResellerID( ) {
    return resellerID;
  }

  /**
   * Method sets attribute {@link #resellerID}.<br/>
   *
   * @param pResellerID Value to which {@link #resellerID} should be set.
   */
  public void setResellerID( long pResellerID ) {
    // Assign value to attribute
    resellerID = pResellerID;
  }

  /**
   * Method returns attribute {@link #queryParam}.<br/>
   *
   * @return {@link String} Value to which {@link #queryParam} is set.
   */
  @MyNotNullProperty
  public String getQueryParam( ) {
    return queryParam;
  }

  /**
   * Method sets attribute {@link #queryParam}.<br/>
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   */
  public void setQueryParam( @MyNotNullProperty String pQueryParam ) {
    // Assign value to attribute
    queryParam = pQueryParam;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(accessToken);
    lResult = lPrime * lResult + Objects.hashCode(language);
    lResult = lPrime * lResult + Long.hashCode(resellerID);
    lResult = lPrime * lResult + Objects.hashCode(queryParam);
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
      DeprecatedContext lOther = (DeprecatedContext) pObject;
      lEquals = Objects.equals(accessToken, lOther.accessToken) && Objects.equals(language, lOther.language)
          && resellerID == lOther.resellerID && Objects.equals(queryParam, lOther.queryParam);
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
    lBuilder.append("accessToken: ");
    lBuilder.append(accessToken);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("language: ");
    lBuilder.append(language);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("resellerID: ");
    lBuilder.append(resellerID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("queryParam: ");
    lBuilder.append(queryParam);
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
   * @return {@link Builder} New builder that can be used to create new DeprecatedContext objects. The method never
   * returns null.
   */
  public DeprecatedContextBuilder<?, ?> toBuilder( ) {
    return new DeprecatedContextBuilderImpl(this);
  }
}