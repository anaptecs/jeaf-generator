/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Context extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "accessToken".
   */
  @JEAFCustomAnnotationTest
  public static final String ACCESSTOKEN = "accessToken";

  /**
   * Constant for the name of attribute "language".
   */
  @JEAFCustomAnnotationTest
  public static final String LANGUAGE = "language";

  /**
   * Constant for the name of attribute "resellerID".
   */
  @JEAFCustomAnnotationTest
  public static final String RESELLERID = "resellerID";

  /**
   * Constant for the name of attribute "pathParam".
   */
  @JEAFCustomAnnotationTest
  public static final String PATHPARAM = "pathParam";

  /**
   * Constant for the name of attribute "queryParam".
   */
  @JEAFCustomAnnotationTest
  public static final String QUERYPARAM = "queryParam";

  /**
   * Constant for the name of attribute "intCode".
   */
  @JEAFCustomAnnotationTest
  public static final String INTCODE = "intCode";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @NotEmpty
  private String accessToken;

  // "java.lang.String"
  private int accessTokenXYZ = 0;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>en</code></li>
   * </ul>
   */
  // "java.util.Locale"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Locale language;

  // "java.util.Locale"
  private int languageXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private long resellerID;

  // "long"
  private int resellerIDXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private long pathParam;

  // "long"
  private int pathParamXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String queryParam;

  // "java.lang.String"
  private int queryParamXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private IntegerCodeType intCode;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
  private int intCodeXYZ = 0;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Context( ) {
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
    // "java.lang.String"
    accessTokenXYZ = pBuilder.accessTokenXYZ;
    language = pBuilder.language;
    // "java.util.Locale"
    languageXYZ = pBuilder.languageXYZ;
    resellerID = pBuilder.resellerID;
    // "long"
    resellerIDXYZ = pBuilder.resellerIDXYZ;
    pathParam = pBuilder.pathParam;
    // "long"
    pathParamXYZ = pBuilder.pathParamXYZ;
    queryParam = pBuilder.queryParam;
    // "java.lang.String"
    queryParamXYZ = pBuilder.queryParamXYZ;
    intCode = pBuilder.intCode;
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    intCodeXYZ = pBuilder.intCodeXYZ;
    // Add request headers.
    customHeaders = pBuilder.customHeaders;
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
   * Class implements builder to create a new instance of class <code>Context</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @NotEmpty
    private String accessToken;

    // "java.lang.String"
    private int accessTokenXYZ = 0;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>en</code></li>
     * </ul>
     */
    // "java.util.Locale"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Locale language;

    // "java.util.Locale"
    private int languageXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private long resellerID;

    // "long"
    private int resellerIDXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private long pathParam;

    // "long"
    private int pathParamXYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String queryParam;

    // "java.lang.String"
    private int queryParamXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private IntegerCodeType intCode;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    private int intCodeXYZ = 0;

    /**
     * Map contains all custom headers that were set on the object.
     */
    private Map<String, String> customHeaders = new HashMap<String, String>();

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
        this.setIntCode(pObject.intCode);
        customHeaders = new HashMap<String, String>(pObject.customHeaders);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAccessToken( String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    public Builder setAccessTokenXYZ( int value ) {
      // "java.lang.String"
      accessTokenXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    public Builder setLanguageXYZ( int value ) {
      // "java.util.Locale"
      languageXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #resellerID}.<br/>
     *
     * @param pResellerID Value to which {@link #resellerID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setResellerID( long pResellerID ) {
      // Assign value to attribute
      resellerID = pResellerID;
      return this;
    }

    public Builder setResellerIDXYZ( int value ) {
      // "long"
      resellerIDXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #pathParam}.<br/>
     *
     * @param pPathParam Value to which {@link #pathParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setPathParam( long pPathParam ) {
      // Assign value to attribute
      pathParam = pPathParam;
      return this;
    }

    public Builder setPathParamXYZ( int value ) {
      // "long"
      pathParamXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #queryParam}.<br/>
     *
     * @param pQueryParam Value to which {@link #queryParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setQueryParam( String pQueryParam ) {
      // Assign value to attribute
      queryParam = pQueryParam;
      return this;
    }

    public Builder setQueryParamXYZ( int value ) {
      // "java.lang.String"
      queryParamXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #intCode}.<br/>
     *
     * @param pIntCode Value to which {@link #intCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setIntCode( IntegerCodeType pIntCode ) {
      // Assign value to attribute
      intCode = pIntCode;
      return this;
    }

    public Builder setIntCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
      intCodeXYZ = value;
      return this;
    }

    /**
     * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
     * with guidelines about http headers.
     *
     * @param pHeaderName Name of the HTTP header. The parameter must not be null,
     * @param pHeaderValue Value of the http header the parameter may be null.
     */
    public Builder addCustomHeader( String pHeaderName, String pHeaderValue ) {
      if (pHeaderName != null) {
        customHeaders.put(pHeaderName, pHeaderValue);
        return this;
      }
      else {
        throw new IllegalArgumentException("Parameter 'pHeaderName' must not be null.");
      }
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets attribute {@link #accessToken}.<br/>
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAccessToken( String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  public int getAccessTokenXYZ( ) {
    // "java.lang.String"
    return accessTokenXYZ;
  }

  public void setAccessTokenXYZ( int value ) {
    accessTokenXYZ = value;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @JEAFCustomAnnotationTest
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  public int getLanguageXYZ( ) {
    // "java.util.Locale"
    return languageXYZ;
  }

  public void setLanguageXYZ( int value ) {
    languageXYZ = value;
  }

  /**
   * Method returns attribute {@link #resellerID}.<br/>
   *
   * @return long Value to which {@link #resellerID} is set.
   */
  @JEAFCustomAnnotationTest
  public long getResellerID( ) {
    return resellerID;
  }

  /**
   * Method sets attribute {@link #resellerID}.<br/>
   *
   * @param pResellerID Value to which {@link #resellerID} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setResellerID( long pResellerID ) {
    // Assign value to attribute
    resellerID = pResellerID;
  }

  public int getResellerIDXYZ( ) {
    // "long"
    return resellerIDXYZ;
  }

  public void setResellerIDXYZ( int value ) {
    resellerIDXYZ = value;
  }

  /**
   * Method returns attribute {@link #pathParam}.<br/>
   *
   * @return long Value to which {@link #pathParam} is set.
   */
  @JEAFCustomAnnotationTest
  public long getPathParam( ) {
    return pathParam;
  }

  /**
   * Method sets attribute {@link #pathParam}.<br/>
   *
   * @param pPathParam Value to which {@link #pathParam} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setPathParam( long pPathParam ) {
    // Assign value to attribute
    pathParam = pPathParam;
  }

  public int getPathParamXYZ( ) {
    // "long"
    return pathParamXYZ;
  }

  public void setPathParamXYZ( int value ) {
    pathParamXYZ = value;
  }

  /**
   * Method returns attribute {@link #queryParam}.<br/>
   *
   * @return {@link String} Value to which {@link #queryParam} is set.
   */
  @JEAFCustomAnnotationTest
  public String getQueryParam( ) {
    return queryParam;
  }

  /**
   * Method sets attribute {@link #queryParam}.<br/>
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setQueryParam( String pQueryParam ) {
    // Assign value to attribute
    queryParam = pQueryParam;
  }

  public int getQueryParamXYZ( ) {
    // "java.lang.String"
    return queryParamXYZ;
  }

  public void setQueryParamXYZ( int value ) {
    queryParamXYZ = value;
  }

  /**
   * Method returns attribute {@link #intCode}.<br/>
   *
   * @return {@link IntegerCodeType} Value to which {@link #intCode} is set.
   */
  @JEAFCustomAnnotationTest
  public IntegerCodeType getIntCode( ) {
    return intCode;
  }

  /**
   * Method sets attribute {@link #intCode}.<br/>
   *
   * @param pIntCode Value to which {@link #intCode} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setIntCode( IntegerCodeType pIntCode ) {
    // Assign value to attribute
    intCode = pIntCode;
  }

  public int getIntCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    return intCodeXYZ;
  }

  public void setIntCodeXYZ( int value ) {
    intCodeXYZ = value;
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

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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