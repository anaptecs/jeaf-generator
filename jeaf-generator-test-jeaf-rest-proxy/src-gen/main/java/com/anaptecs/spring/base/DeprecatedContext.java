/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.Locale;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Deprecated
public class DeprecatedContext implements Serializable {
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
   * Constant for the name of attribute "queryParam".
   */
  public static final String QUERYPARAM = "queryParam";

  /**
   * 
   */
  @HeaderParam("token")
  @NotEmpty
  private String accessToken;

  /**
   * <br/>
   * <b>Example:</b> <code>en</code>
   */
  @HeaderParam("lang")
  private Locale language;

  /**
   * 
   */
  @CookieParam("reseller")
  private long resellerID;

  /**
   * 
   */
  @QueryParam("q1")
  private String queryParam;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public DeprecatedContext( ) {
    // Nothing to do.
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
   * Class implements builder to create a new instance of class DeprecatedContext. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  @Deprecated
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
    private String queryParam;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(DeprecatedContext)} instead of private constructor to create new builder.
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new DeprecatedContext objects. The method never
     * returns null.
     */
    public static Builder newBuilder( DeprecatedContext pObject ) {
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
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "accessToken", "" + accessToken));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "language", "" + language));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "resellerID", "" + resellerID));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "queryParam", "" + queryParam));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
