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

import javax.validation.constraints.NotEmpty;

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
   * 
   */
  @NotEmpty
  private String accessToken;

  /**
   * <br/>
   * <b>Example:</b> <code>en</code>
   */
  private Locale language;

  /**
   * 
   */
  private long resellerID;

  /**
   * 
   */
  private long pathParam;

  /**
   * 
   */
  private String queryParam;

  /**
   * 
   */
  private String lang;

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
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    language = pBuilder.language;
    resellerID = pBuilder.resellerID;
    pathParam = pBuilder.pathParam;
    queryParam = pBuilder.queryParam;
    lang = pBuilder.lang;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Context objects. The method never returns null.
   */
  public static Builder builder( Context pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Context. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotEmpty
    private String accessToken;

    /**
     * 
     */
    private Locale language;

    /**
     * 
     */
    private long resellerID;

    /**
     * 
     */
    private long pathParam;

    /**
     * 
     */
    private String queryParam;

    /**
     * 
     */
    private String lang;

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
        accessToken = pObject.accessToken;
        language = pObject.language;
        resellerID = pObject.resellerID;
        pathParam = pObject.pathParam;
        queryParam = pObject.queryParam;
        lang = pObject.lang;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Context objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Context objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Context pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "accessToken".
     * 
     * @param pAccessToken Value to which the attribute "accessToken" should be set.
     */
    public Builder setAccessToken( String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method sets the attribute "resellerID".
     * 
     * @param pResellerID Value to which the attribute "resellerID" should be set.
     */
    public Builder setResellerID( long pResellerID ) {
      // Assign value to attribute
      resellerID = pResellerID;
      return this;
    }

    /**
     * Method sets the attribute "pathParam".
     * 
     * @param pPathParam Value to which the attribute "pathParam" should be set.
     */
    public Builder setPathParam( long pPathParam ) {
      // Assign value to attribute
      pathParam = pPathParam;
      return this;
    }

    /**
     * Method sets the attribute "queryParam".
     * 
     * @param pQueryParam Value to which the attribute "queryParam" should be set.
     */
    public Builder setQueryParam( String pQueryParam ) {
      // Assign value to attribute
      queryParam = pQueryParam;
      return this;
    }

    /**
     * Method sets the attribute "lang".
     * 
     * @param pLang Value to which the attribute "lang" should be set.
     */
    public Builder setLang( String pLang ) {
      // Assign value to attribute
      lang = pLang;
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
  }

  /**
   * Method returns the attribute "accessToken".
   * 
   * 
   * @return String Value to which the attribute "accessToken" is set.
   */
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets the attribute "accessToken".
   * 
   * 
   * @param pAccessToken Value to which the attribute "accessToken" should be set.
   */
  public void setAccessToken( String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  /**
   * Method returns the attribute "language".
   * 
   * 
   * @return Locale Value to which the attribute "language" is set.
   */
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets the attribute "language".
   * 
   * 
   * @param pLanguage Value to which the attribute "language" should be set.
   */
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns the attribute "resellerID".
   * 
   * 
   * @return long Value to which the attribute "resellerID" is set.
   */
  public long getResellerID( ) {
    return resellerID;
  }

  /**
   * Method sets the attribute "resellerID".
   * 
   * 
   * @param pResellerID Value to which the attribute "resellerID" should be set.
   */
  public void setResellerID( long pResellerID ) {
    // Assign value to attribute
    resellerID = pResellerID;
  }

  /**
   * Method returns the attribute "pathParam".
   * 
   * 
   * @return long Value to which the attribute "pathParam" is set.
   */
  public long getPathParam( ) {
    return pathParam;
  }

  /**
   * Method sets the attribute "pathParam".
   * 
   * 
   * @param pPathParam Value to which the attribute "pathParam" should be set.
   */
  public void setPathParam( long pPathParam ) {
    // Assign value to attribute
    pathParam = pPathParam;
  }

  /**
   * Method returns the attribute "queryParam".
   * 
   * 
   * @return String Value to which the attribute "queryParam" is set.
   */
  public String getQueryParam( ) {
    return queryParam;
  }

  /**
   * Method sets the attribute "queryParam".
   * 
   * 
   * @param pQueryParam Value to which the attribute "queryParam" should be set.
   */
  public void setQueryParam( String pQueryParam ) {
    // Assign value to attribute
    queryParam = pQueryParam;
  }

  /**
   * Method returns the attribute "lang".
   * 
   * 
   * @return String Value to which the attribute "lang" is set.
   */
  public String getLang( ) {
    return lang;
  }

  /**
   * Method sets the attribute "lang".
   * 
   * 
   * @param pLang Value to which the attribute "lang" should be set.
   */
  public void setLang( String pLang ) {
    // Assign value to attribute
    lang = pLang;
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
