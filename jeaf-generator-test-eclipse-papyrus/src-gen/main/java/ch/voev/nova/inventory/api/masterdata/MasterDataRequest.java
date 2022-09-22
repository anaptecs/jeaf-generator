/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.time.OffsetDateTime;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class MasterDataRequest {
  /**
   * Constant for the name of attribute "operatorRef".
   */
  public static final String OPERATORREF = "operatorRef";

  /**
   * Constant for the name of attribute "uicCountryCode".
   */
  public static final String UICCOUNTRYCODE = "uicCountryCode";

  /**
   * Constant for the name of attribute "lastModified".
   */
  public static final String LASTMODIFIED = "lastModified";

  /**
   * If not set, all vehicles of all operators are returned <br/>
   * <b>Example:</b> <code>11</code>
   */
  private String operatorRef;

  /**
   * <br/>
   * <b>Example:</b> <code>85</code>
   */
  private String uicCountryCode;

  /**
   * 
   */
  private OffsetDateTime lastModified;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public MasterDataRequest( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterDataRequest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    operatorRef = pBuilder.operatorRef;
    uicCountryCode = pBuilder.uicCountryCode;
    lastModified = pBuilder.lastModified;
  }

  /**
   * Class implements builder to create a new instance of class MasterDataRequest. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * If not set, all vehicles of all operators are returned
     */
    private String operatorRef;

    /**
     * 
     */
    private String uicCountryCode;

    /**
     * 
     */
    private OffsetDateTime lastModified;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(MasterDataRequest)} instead of private constructor to create new builder.
     */
    protected Builder( MasterDataRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        operatorRef = pObject.operatorRef;
        uicCountryCode = pObject.uicCountryCode;
        lastModified = pObject.lastModified;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new MasterDataRequest objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new MasterDataRequest objects. The method never
     * returns null.
     */
    public static Builder newBuilder( MasterDataRequest pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "operatorRef". If not set, all vehicles of all operators are returned
     * 
     * @param pOperatorRef Value to which the attribute "operatorRef" should be set.
     */
    public Builder setOperatorRef( String pOperatorRef ) {
      // Assign value to attribute
      operatorRef = pOperatorRef;
      return this;
    }

    /**
     * Method sets the attribute "uicCountryCode".
     * 
     * @param pUicCountryCode Value to which the attribute "uicCountryCode" should be set.
     */
    public Builder setUicCountryCode( String pUicCountryCode ) {
      // Assign value to attribute
      uicCountryCode = pUicCountryCode;
      return this;
    }

    /**
     * Method sets the attribute "lastModified".
     * 
     * @param pLastModified Value to which the attribute "lastModified" should be set.
     */
    public Builder setLastModified( OffsetDateTime pLastModified ) {
      // Assign value to attribute
      lastModified = pLastModified;
      return this;
    }

    /**
     * Method creates a new instance of class MasterDataRequest. The object will be initialized with the values of the
     * builder.
     * 
     * @return MasterDataRequest Created object. The method never returns null.
     */
    public MasterDataRequest build( ) {
      return new MasterDataRequest(this);
    }

    /**
     * Method creates a new validated instance of class MasterDataRequest. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return MasterDataRequest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MasterDataRequest buildValidated( ) throws ConstraintViolationException {
      MasterDataRequest lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "operatorRef". If not set, all vehicles of all operators are returned
   * 
   * @return String Value to which the attribute "operatorRef" is set.
   */
  public String getOperatorRef( ) {
    return operatorRef;
  }

  /**
   * Method sets the attribute "operatorRef". If not set, all vehicles of all operators are returned
   * 
   * @param pOperatorRef Value to which the attribute "operatorRef" should be set.
   */
  public void setOperatorRef( String pOperatorRef ) {
    // Assign value to attribute
    operatorRef = pOperatorRef;
  }

  /**
   * Method returns the attribute "uicCountryCode".
   * 
   * 
   * @return String Value to which the attribute "uicCountryCode" is set.
   */
  public String getUicCountryCode( ) {
    return uicCountryCode;
  }

  /**
   * Method sets the attribute "uicCountryCode".
   * 
   * 
   * @param pUicCountryCode Value to which the attribute "uicCountryCode" should be set.
   */
  public void setUicCountryCode( String pUicCountryCode ) {
    // Assign value to attribute
    uicCountryCode = pUicCountryCode;
  }

  /**
   * Method returns the attribute "lastModified".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "lastModified" is set.
   */
  public OffsetDateTime getLastModified( ) {
    return lastModified;
  }

  /**
   * Method sets the attribute "lastModified".
   * 
   * 
   * @param pLastModified Value to which the attribute "lastModified" should be set.
   */
  public void setLastModified( OffsetDateTime pLastModified ) {
    // Assign value to attribute
    lastModified = pLastModified;
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
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "operatorRef", "" + operatorRef));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "uicCountryCode", "" + uicCountryCode));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "lastModified", "" + lastModified));
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
