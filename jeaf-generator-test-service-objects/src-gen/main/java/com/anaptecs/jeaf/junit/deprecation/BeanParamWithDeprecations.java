/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class BeanParamWithDeprecations implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "header1".
   */
  public static final String HEADER1 = "header1";

  /**
   * Constant for the name of attribute "deprecatedHeader".
   */
  @Deprecated
  public static final String DEPRECATEDHEADER = "deprecatedHeader";

  /**
   * 
   */
  private String header1;

  /**
   * 
   */
  @Deprecated
  private String deprecatedHeader;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BeanParamWithDeprecations( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BeanParamWithDeprecations( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    header1 = pBuilder.header1;
    deprecatedHeader = pBuilder.deprecatedHeader;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new BeanParamWithDeprecations objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BeanParamWithDeprecations objects. The method
   * never returns null.
   */
  public static Builder builder( BeanParamWithDeprecations pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class BeanParamWithDeprecations. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String header1;

    /**
     * 
     */
    @Deprecated
    private String deprecatedHeader;

    /**
     * Use {@link BeanParamWithDeprecations#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BeanParamWithDeprecations#builder(BeanParamWithDeprecations)} instead of private constructor to create
     * new builder.
     */
    protected Builder( BeanParamWithDeprecations pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        header1 = pObject.header1;
        deprecatedHeader = pObject.deprecatedHeader;
      }
    }

    /**
     * Method sets the attribute "header1".
     * 
     * @param pHeader1 Value to which the attribute "header1" should be set.
     */
    public Builder setHeader1( String pHeader1 ) {
      // Assign value to attribute
      header1 = pHeader1;
      return this;
    }

    /**
     * Method sets the attribute "deprecatedHeader".
     * 
     * @param pDeprecatedHeader Value to which the attribute "deprecatedHeader" should be set.
     */
    @Deprecated
    public Builder setDeprecatedHeader( String pDeprecatedHeader ) {
      // Assign value to attribute
      deprecatedHeader = pDeprecatedHeader;
      return this;
    }

    /**
     * Method creates a new instance of class BeanParamWithDeprecations. The object will be initialized with the values
     * of the builder.
     * 
     * @return BeanParamWithDeprecations Created object. The method never returns null.
     */
    public BeanParamWithDeprecations build( ) {
      return new BeanParamWithDeprecations(this);
    }

    /**
     * Method creates a new validated instance of class BeanParamWithDeprecations. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return BeanParamWithDeprecations Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BeanParamWithDeprecations buildValidated( ) throws ConstraintViolationException {
      BeanParamWithDeprecations lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "header1".
   * 
   * 
   * @return String Value to which the attribute "header1" is set.
   */
  public String getHeader1( ) {
    return header1;
  }

  /**
   * Method sets the attribute "header1".
   * 
   * 
   * @param pHeader1 Value to which the attribute "header1" should be set.
   */
  public void setHeader1( String pHeader1 ) {
    // Assign value to attribute
    header1 = pHeader1;
  }

  /**
   * Method returns the attribute "deprecatedHeader".
   * 
   * 
   * @return String Value to which the attribute "deprecatedHeader" is set.
   */
  @Deprecated
  public String getDeprecatedHeader( ) {
    return deprecatedHeader;
  }

  /**
   * Method sets the attribute "deprecatedHeader".
   * 
   * 
   * @param pDeprecatedHeader Value to which the attribute "deprecatedHeader" should be set.
   */
  @Deprecated
  public void setDeprecatedHeader( String pDeprecatedHeader ) {
    // Assign value to attribute
    deprecatedHeader = pDeprecatedHeader;
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
    lBuilder.append("header1: ");
    lBuilder.append(header1);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedHeader: ");
    lBuilder.append(deprecatedHeader);
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