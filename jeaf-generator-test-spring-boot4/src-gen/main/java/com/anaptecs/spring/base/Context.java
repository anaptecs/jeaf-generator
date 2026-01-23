/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Type with default comment.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Context {
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
   * Constant for the name of attribute "pathParam".
   */
  public static final String PATHPARAM = "pathParam";

  /**
   * Constant for the name of attribute "queryParam".
   */
  public static final String QUERYPARAM = "queryParam";

  /**
   * Constant for the name of attribute "lang".
   */
  public static final String LANG = "lang";

  /**
   * Constant for the name of attribute "intCode".
   */
  public static final String INTCODE = "intCode";

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

  private long pathParam;

  private String queryParam;

  private String lang;

  private IntegerCodeType intCode;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Context( ContextBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    language = pBuilder.language;
    resellerID = pBuilder.resellerID;
    pathParam = pBuilder.pathParam;
    queryParam = pBuilder.queryParam;
    lang = pBuilder.lang;
    intCode = pBuilder.intCode;
    // Add request headers.
    customHeaders = pBuilder.customHeaders;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ContextBuilder} New builder that can be used to create new Context objects.
   */
  public static ContextBuilder<?, ?> builder( ) {
    return new ContextBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Context.
   *
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   *
   * @param pLanguage Value to which {@link #language} should be set.
   *
   * @param pResellerID Value to which {@link #resellerID} should be set.
   *
   * @param pPathParam Value to which {@link #pathParam} should be set.
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   *
   * @param pLang Value to which {@link #lang} should be set.
   *
   * @param pIntCode Value to which {@link #intCode} should be set.
   *
   * @return {@link Context}
   */
  public static Context of( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pLang, IntegerCodeType pIntCode ) {
    var lBuilder = Context.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    lBuilder.setLang(pLang);
    lBuilder.setIntCode(pIntCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Context</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ContextBuilder<T extends Context, B extends ContextBuilder<T, B>> {
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

    private long pathParam;

    private String queryParam;

    private String lang;

    private IntegerCodeType intCode;

    /**
     * Map contains all custom headers that were set on the object.
     */
    private Map<String, String> customHeaders = new HashMap<String, String>();

    /**
     * Use {@link Context#builder()} instead of private constructor to create new builder.
     */
    protected ContextBuilder( ) {
    }

    /**
     * Use {@link Context#builder(Context)} instead of private constructor to create new builder.
     */
    protected ContextBuilder( Context pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAccessToken(pObject.accessToken);
        this.setLanguage(pObject.language);
        this.setResellerID(pObject.resellerID);
        this.setPathParam(pObject.pathParam);
        this.setQueryParam(pObject.queryParam);
        this.setLang(pObject.lang);
        this.setIntCode(pObject.intCode);
        customHeaders = new HashMap<String, String>(pObject.customHeaders);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
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
    @JsonSetter(nulls = Nulls.SKIP)
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
    @JsonSetter(nulls = Nulls.SKIP)
    public B setResellerID( long pResellerID ) {
      // Assign value to attribute
      resellerID = pResellerID;
      return this.self();
    }

    /**
     * Method sets attribute {@link #pathParam}.<br/>
     *
     * @param pPathParam Value to which {@link #pathParam} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setPathParam( long pPathParam ) {
      // Assign value to attribute
      pathParam = pPathParam;
      return this.self();
    }

    /**
     * Method sets attribute {@link #queryParam}.<br/>
     *
     * @param pQueryParam Value to which {@link #queryParam} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setQueryParam( @MyNotNullProperty String pQueryParam ) {
      // Assign value to attribute
      queryParam = pQueryParam;
      return this.self();
    }

    /**
     * Method sets attribute {@link #lang}.<br/>
     *
     * @param pLang Value to which {@link #lang} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setLang( @MyNotNullProperty String pLang ) {
      // Assign value to attribute
      lang = pLang;
      return this.self();
    }

    /**
     * Method sets attribute {@link #intCode}.<br/>
     *
     * @param pIntCode Value to which {@link #intCode} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setIntCode( @MyNotNullProperty IntegerCodeType pIntCode ) {
      // Assign value to attribute
      intCode = pIntCode;
      return this.self();
    }

    /**
     * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
     * with guidelines about http headers.
     *
     * @param pHeaderName Name of the HTTP header. The parameter must not be null,
     * @param pHeaderValue Value of the http header the parameter may be null.
     */
    public B addCustomHeader( String pHeaderName, String pHeaderValue ) {
      if (pHeaderName != null) {
        customHeaders.put(pHeaderName, pHeaderValue);
        return this.self();
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
     * Method creates a new instance of class Context. The object will be initialized with the values of the builder.
     *
     * @return Context Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ContextBuilderImpl extends ContextBuilder<Context, ContextBuilderImpl> {
    protected ContextBuilderImpl( ) {
    }

    protected ContextBuilderImpl( Context pObject ) {
      super(pObject);
    }

    @Override
    protected ContextBuilderImpl self( ) {
      return this;
    }

    @Override
    public Context build( ) {
      Context lObject = new Context(this);
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
   * Method returns attribute {@link #pathParam}.<br/>
   *
   * @return long Value to which {@link #pathParam} is set.
   */
  public long getPathParam( ) {
    return pathParam;
  }

  /**
   * Method sets attribute {@link #pathParam}.<br/>
   *
   * @param pPathParam Value to which {@link #pathParam} should be set.
   */
  public void setPathParam( long pPathParam ) {
    // Assign value to attribute
    pathParam = pPathParam;
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

  /**
   * Method returns attribute {@link #lang}.<br/>
   *
   * @return {@link String} Value to which {@link #lang} is set.
   */
  @MyNotNullProperty
  public String getLang( ) {
    return lang;
  }

  /**
   * Method sets attribute {@link #lang}.<br/>
   *
   * @param pLang Value to which {@link #lang} should be set.
   */
  public void setLang( @MyNotNullProperty String pLang ) {
    // Assign value to attribute
    lang = pLang;
  }

  /**
   * Method returns attribute {@link #intCode}.<br/>
   *
   * @return {@link IntegerCodeType} Value to which {@link #intCode} is set.
   */
  @MyNotNullProperty
  public IntegerCodeType getIntCode( ) {
    return intCode;
  }

  /**
   * Method sets attribute {@link #intCode}.<br/>
   *
   * @param pIntCode Value to which {@link #intCode} should be set.
   */
  public void setIntCode( @MyNotNullProperty IntegerCodeType pIntCode ) {
    // Assign value to attribute
    intCode = pIntCode;
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
    lResult = lPrime * lResult + Objects.hashCode(accessToken);
    lResult = lPrime * lResult + Objects.hashCode(language);
    lResult = lPrime * lResult + Long.hashCode(resellerID);
    lResult = lPrime * lResult + Long.hashCode(pathParam);
    lResult = lPrime * lResult + Objects.hashCode(queryParam);
    lResult = lPrime * lResult + Objects.hashCode(lang);
    lResult = lPrime * lResult + Objects.hashCode(intCode);
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
      Context lOther = (Context) pObject;
      lEquals = Objects.equals(accessToken, lOther.accessToken) && Objects.equals(language, lOther.language)
          && resellerID == lOther.resellerID && pathParam == lOther.pathParam
          && Objects.equals(queryParam, lOther.queryParam) && Objects.equals(lang, lOther.lang)
          && Objects.equals(intCode, lOther.intCode) && Objects.equals(customHeaders, lOther.customHeaders);
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
    lBuilder.append("pathParam: ");
    lBuilder.append(pathParam);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("queryParam: ");
    lBuilder.append(queryParam);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("lang: ");
    lBuilder.append(lang);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("intCode: ");
    lBuilder.append(intCode);
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
   * @return {@link ContextBuilder} New builder that can be used to create new Context objects. The method never returns
   * null.
   */
  public ContextBuilder<?, ?> toBuilder( ) {
    return new ContextBuilderImpl(this);
  }
}