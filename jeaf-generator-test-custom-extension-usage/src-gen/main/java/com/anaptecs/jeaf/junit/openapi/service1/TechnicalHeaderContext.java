/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
public class TechnicalHeaderContext extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "reseller".
   */
  public static final String RESELLER = "reseller";

  /**
   * Constant for the name of attribute "authenticationToken".
   */
  public static final String AUTHENTICATIONTOKEN = "authenticationToken";

  // "String"
  @ClassPropertyDeclaration
  private String reseller;

  // "String"
  private int resellerXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String authenticationToken;

  // "String"
  private int authenticationTokenXYZ = 0;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TechnicalHeaderContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechnicalHeaderContext( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    reseller = pBuilder.reseller;
    // "String"
    resellerXYZ = pBuilder.resellerXYZ;
    authenticationToken = pBuilder.authenticationToken;
    // "String"
    authenticationTokenXYZ = pBuilder.authenticationTokenXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechnicalHeaderContext</code>.
   */
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String reseller;

    // "String"
    private int resellerXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String authenticationToken;

    // "String"
    private int authenticationTokenXYZ = 0;

    /**
     * Use {@link TechnicalHeaderContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechnicalHeaderContext#builder(TechnicalHeaderContext)} instead of private constructor to create new
     * builder.
     */
    protected Builder( TechnicalHeaderContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setReseller(pObject.reseller);
        this.setAuthenticationToken(pObject.authenticationToken);
      }
    }

    /**
     * Method sets attribute {@link #reseller}.<br/>
     *
     * @param pReseller Value to which {@link #reseller} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReseller( String pReseller ) {
      // Assign value to attribute
      reseller = pReseller;
      return this;
    }

    public Builder setResellerXYZ( int value ) {
      // "String"
      resellerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #authenticationToken}.<br/>
     *
     * @param pAuthenticationToken Value to which {@link #authenticationToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAuthenticationToken( String pAuthenticationToken ) {
      // Assign value to attribute
      authenticationToken = pAuthenticationToken;
      return this;
    }

    public Builder setAuthenticationTokenXYZ( int value ) {
      // "String"
      authenticationTokenXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class TechnicalHeaderContext. The object will be initialized with the values of
     * the builder.
     *
     * @return TechnicalHeaderContext Created object. The method never returns null.
     */
    public TechnicalHeaderContext build( ) {
      return new TechnicalHeaderContext(this);
    }

    /**
     * Method creates a new validated instance of class TechnicalHeaderContext. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return TechnicalHeaderContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TechnicalHeaderContext buildValidated( ) throws ConstraintViolationException {
      TechnicalHeaderContext lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #reseller}.<br/>
   *
   * @return {@link String} Value to which {@link #reseller} is set.
   */
  public String getReseller( ) {
    return reseller;
  }

  /**
   * Method sets attribute {@link #reseller}.<br/>
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   */
  public void setReseller( String pReseller ) {
    // Assign value to attribute
    reseller = pReseller;
  }

  public int getResellerXYZ( ) {
    // "String"
    return resellerXYZ;
  }

  public void setResellerXYZ( int value ) {
    resellerXYZ = value;
  }

  /**
   * Method returns attribute {@link #authenticationToken}.<br/>
   *
   * @return {@link String} Value to which {@link #authenticationToken} is set.
   */
  public String getAuthenticationToken( ) {
    return authenticationToken;
  }

  /**
   * Method sets attribute {@link #authenticationToken}.<br/>
   *
   * @param pAuthenticationToken Value to which {@link #authenticationToken} should be set.
   */
  public void setAuthenticationToken( String pAuthenticationToken ) {
    // Assign value to attribute
    authenticationToken = pAuthenticationToken;
  }

  public int getAuthenticationTokenXYZ( ) {
    // "String"
    return authenticationTokenXYZ;
  }

  public void setAuthenticationTokenXYZ( int value ) {
    authenticationTokenXYZ = value;
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
    lBuilder.append("reseller: ");
    lBuilder.append(reseller);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("authenticationToken: ");
    lBuilder.append(authenticationToken);
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}