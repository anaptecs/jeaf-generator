/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Type with default comment.
 * <p/>
 * Default Comment
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Context implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

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

  @HeaderParam("token")
  @NotEmpty
  private String accessToken;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>en</code></li>
   * </ul>
   */
  @HeaderParam("lang")
  private Locale language;

  @CookieParam("reseller")
  private long resellerID;

  @PathParam("id")
  private long pathParam;

  @QueryParam("q1")
  private String queryParam;

  private String lang;

  @HeaderParam("intCode")
  private IntegerCodeType intCode;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public Context( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Context( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    language = pBuilder.language;
    resellerID = pBuilder.resellerID;
    pathParam = pBuilder.pathParam;
    queryParam = pBuilder.queryParam;
    lang = pBuilder.lang;
    intCode = pBuilder.intCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Context objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pLang, IntegerCodeType pIntCode ) {
    Builder lBuilder = builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    lBuilder.setLang(pLang);
    lBuilder.setIntCode(pIntCode);
    return lBuilder;
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
   * @return {@link com.anaptecs.spring.base.Context}
   */
  public static Context of( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pLang, IntegerCodeType pIntCode ) {
    Context.Builder lBuilder = Context.builder();
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
  public static class Builder {
    @NotEmpty
    private String accessToken;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>en</code></li>
     * </ul>
     */
    private Locale language;

    private long resellerID;

    private long pathParam;

    private String queryParam;

    private String lang;

    private IntegerCodeType intCode;

    /**
     * Use {@link Context#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Context#builder(Context)} instead of private constructor to create new builder.
     */
    protected Builder( Context pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAccessToken(pObject.accessToken);
        this.setLanguage(pObject.language);
        this.setResellerID(pObject.resellerID);
        this.setPathParam(pObject.pathParam);
        this.setQueryParam(pObject.queryParam);
        this.setLang(pObject.lang);
        this.setIntCode(pObject.intCode);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAccessToken( String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method sets attribute {@link #resellerID}.<br/>
     *
     * @param pResellerID Value to which {@link #resellerID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setResellerID( long pResellerID ) {
      // Assign value to attribute
      resellerID = pResellerID;
      return this;
    }

    /**
     * Method sets attribute {@link #pathParam}.<br/>
     *
     * @param pPathParam Value to which {@link #pathParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPathParam( long pPathParam ) {
      // Assign value to attribute
      pathParam = pPathParam;
      return this;
    }

    /**
     * Method sets attribute {@link #queryParam}.<br/>
     *
     * @param pQueryParam Value to which {@link #queryParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setQueryParam( String pQueryParam ) {
      // Assign value to attribute
      queryParam = pQueryParam;
      return this;
    }

    /**
     * Method sets attribute {@link #lang}.<br/>
     *
     * @param pLang Value to which {@link #lang} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLang( String pLang ) {
      // Assign value to attribute
      lang = pLang;
      return this;
    }

    /**
     * Method sets attribute {@link #intCode}.<br/>
     *
     * @param pIntCode Value to which {@link #intCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntCode( IntegerCodeType pIntCode ) {
      // Assign value to attribute
      intCode = pIntCode;
      return this;
    }

    /**
     * Method creates a new instance of class Context. The object will be initialized with the values of the builder.
     *
     * @return Context Created object. The method never returns null.
     */
    public Context build( ) {
      return new Context(this);
    }

    /**
     * Method creates a new validated instance of class Context. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Context Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Context buildValidated( ) throws ConstraintViolationException {
      Context lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #accessToken}.<br/>
   *
   * @return {@link String} Value to which {@link #accessToken} is set.
   */
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets attribute {@link #accessToken}.<br/>
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   */
  public void setAccessToken( String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  public void setLanguage( Locale pLanguage ) {
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
  public String getQueryParam( ) {
    return queryParam;
  }

  /**
   * Method sets attribute {@link #queryParam}.<br/>
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   */
  public void setQueryParam( String pQueryParam ) {
    // Assign value to attribute
    queryParam = pQueryParam;
  }

  /**
   * Method returns attribute {@link #lang}.<br/>
   *
   * @return {@link String} Value to which {@link #lang} is set.
   */
  public String getLang( ) {
    return lang;
  }

  /**
   * Method sets attribute {@link #lang}.<br/>
   *
   * @param pLang Value to which {@link #lang} should be set.
   */
  public void setLang( String pLang ) {
    // Assign value to attribute
    lang = pLang;
  }

  /**
   * Method returns attribute {@link #intCode}.<br/>
   *
   * @return {@link IntegerCodeType} Value to which {@link #intCode} is set.
   */
  public IntegerCodeType getIntCode( ) {
    return intCode;
  }

  /**
   * Method sets attribute {@link #intCode}.<br/>
   *
   * @param pIntCode Value to which {@link #intCode} should be set.
   */
  public void setIntCode( IntegerCodeType pIntCode ) {
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
   * @return {@link Builder} New builder that can be used to create new Context objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}