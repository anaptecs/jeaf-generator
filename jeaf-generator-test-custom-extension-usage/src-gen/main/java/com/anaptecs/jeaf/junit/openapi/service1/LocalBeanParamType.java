/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class LocalBeanParamType extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "localKey".
   */
  public static final String LOCALKEY = "localKey";

  /**
   * Constant for the name of attribute "localID".
   */
  public static final String LOCALID = "localID";

  /**
   * Constant for the name of attribute "authorization".
   */
  public static final String AUTHORIZATION = "authorization";

  // "String"
  @ClassPropertyDeclaration
  private String localKey;

  // "String"
  private int localKeyXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String localID;

  // "String"
  private int localIDXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String authorization;

  // "String"
  private int authorizationXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected LocalBeanParamType( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LocalBeanParamType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    localKey = pBuilder.localKey;
    // "String"
    localKeyXYZ = pBuilder.localKeyXYZ;
    localID = pBuilder.localID;
    // "String"
    localIDXYZ = pBuilder.localIDXYZ;
    authorization = pBuilder.authorization;
    // "String"
    authorizationXYZ = pBuilder.authorizationXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>LocalBeanParamType</code>.
   */
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String localKey;

    // "String"
    private int localKeyXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String localID;

    // "String"
    private int localIDXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String authorization;

    // "String"
    private int authorizationXYZ = 0;

    /**
     * Use {@link LocalBeanParamType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link LocalBeanParamType#builder(LocalBeanParamType)} instead of private constructor to create new builder.
     */
    protected Builder( LocalBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setLocalKey(pObject.localKey);
        this.setLocalID(pObject.localID);
        this.setAuthorization(pObject.authorization);
      }
    }

    /**
     * Method sets attribute {@link #localKey}.<br/>
     *
     * @param pLocalKey Value to which {@link #localKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalKey( String pLocalKey ) {
      // Assign value to attribute
      localKey = pLocalKey;
      return this;
    }

    public Builder setLocalKeyXYZ( int value ) {
      // "String"
      localKeyXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #localID}.<br/>
     *
     * @param pLocalID Value to which {@link #localID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalID( String pLocalID ) {
      // Assign value to attribute
      localID = pLocalID;
      return this;
    }

    public Builder setLocalIDXYZ( int value ) {
      // "String"
      localIDXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #authorization}.<br/>
     *
     * @param pAuthorization Value to which {@link #authorization} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAuthorization( String pAuthorization ) {
      // Assign value to attribute
      authorization = pAuthorization;
      return this;
    }

    public Builder setAuthorizationXYZ( int value ) {
      // "String"
      authorizationXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class LocalBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return LocalBeanParamType Created object. The method never returns null.
     */
    public LocalBeanParamType build( ) {
      return new LocalBeanParamType(this);
    }

    /**
     * Method creates a new validated instance of class LocalBeanParamType. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return LocalBeanParamType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public LocalBeanParamType buildValidated( ) throws ConstraintViolationException {
      LocalBeanParamType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #localKey}.<br/>
   *
   * @return {@link String} Value to which {@link #localKey} is set.
   */
  public String getLocalKey( ) {
    return localKey;
  }

  /**
   * Method sets attribute {@link #localKey}.<br/>
   *
   * @param pLocalKey Value to which {@link #localKey} should be set.
   */
  public void setLocalKey( String pLocalKey ) {
    // Assign value to attribute
    localKey = pLocalKey;
  }

  public int getLocalKeyXYZ( ) {
    // "String"
    return localKeyXYZ;
  }

  public void setLocalKeyXYZ( int value ) {
    localKeyXYZ = value;
  }

  /**
   * Method returns attribute {@link #localID}.<br/>
   *
   * @return {@link String} Value to which {@link #localID} is set.
   */
  public String getLocalID( ) {
    return localID;
  }

  /**
   * Method sets attribute {@link #localID}.<br/>
   *
   * @param pLocalID Value to which {@link #localID} should be set.
   */
  public void setLocalID( String pLocalID ) {
    // Assign value to attribute
    localID = pLocalID;
  }

  public int getLocalIDXYZ( ) {
    // "String"
    return localIDXYZ;
  }

  public void setLocalIDXYZ( int value ) {
    localIDXYZ = value;
  }

  /**
   * Method returns attribute {@link #authorization}.<br/>
   *
   * @return {@link String} Value to which {@link #authorization} is set.
   */
  public String getAuthorization( ) {
    return authorization;
  }

  /**
   * Method sets attribute {@link #authorization}.<br/>
   *
   * @param pAuthorization Value to which {@link #authorization} should be set.
   */
  public void setAuthorization( String pAuthorization ) {
    // Assign value to attribute
    authorization = pAuthorization;
  }

  public int getAuthorizationXYZ( ) {
    // "String"
    return authorizationXYZ;
  }

  public void setAuthorizationXYZ( int value ) {
    authorizationXYZ = value;
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
    lBuilder.append("localKey: ");
    lBuilder.append(localKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localID: ");
    lBuilder.append(localID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("authorization: ");
    lBuilder.append(authorization);
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
