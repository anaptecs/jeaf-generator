/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Locale;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
@Deprecated
public class DeprecatedContext implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @HeaderParam("token")
  @NotEmpty
  private String accessToken;

  /**
   * <br/>
   * <b>Example:</b> <code>en</code>
   */
  @HeaderParam("lang")
  @NotNull
  private Locale language;

  @CookieParam("reseller")
  private long resellerID;

  @QueryParam("q1")
  @NotNull
  private String queryParam;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DeprecatedContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedContext( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
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
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DeprecatedContext objects. The method never
   * returns null.
   */
  public static Builder builder( DeprecatedContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pAccessToken, Locale pLanguage, long pResellerID, String pQueryParam ) {
    Builder lBuilder = builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setQueryParam(pQueryParam);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedContext</code>.
   */
  @Deprecated
  public static class Builder {
    @NotEmpty
    private String accessToken;

    /**
     * <br/>
     * <b>Example:</b> <code>en</code>
     */
    private Locale language;

    private long resellerID;

    private String queryParam;

    /**
     * Use {@link DeprecatedContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DeprecatedContext#builder(DeprecatedContext)} instead of private constructor to create new builder.
     */
    protected Builder( DeprecatedContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        accessToken = pObject.accessToken;
        language = pObject.language;
        resellerID = pObject.resellerID;
        queryParam = pObject.queryParam;
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
     * Method creates a new instance of class DeprecatedContext. The object will be initialized with the values of the
     * builder.
     * 
     * @return DeprecatedContext Created object. The method never returns null.
     */
    public DeprecatedContext build( ) {
      return new DeprecatedContext(this);
    }

    /**
     * Method creates a new validated instance of class DeprecatedContext. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return DeprecatedContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DeprecatedContext buildValidated( ) throws ConstraintViolationException {
      DeprecatedContext lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
}
