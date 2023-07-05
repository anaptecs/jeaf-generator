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

  private String header1;

  /**
   * @deprecated this header param is no longer supported. Please use "xxx" instead. (<b>since:</b> 1.2.3, <b>removed
   * with:</b> PI.2.3)
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
   * Class implements builder to create a new instance of class <code>BeanParamWithDeprecations</code>.
   */
  public static class Builder {
    private String header1;

    /**
     * @deprecated this header param is no longer supported. Please use "xxx" instead. (<b>since:</b> 1.2.3, <b>removed
     * with:</b> PI.2.3)
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
     * Method sets attribute {@link #header1}.<br/>
     *
     * @param pHeader1 Value to which {@link #header1} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHeader1( String pHeader1 ) {
      // Assign value to attribute
      header1 = pHeader1;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedHeader}.<br/>
     *
     * @param pDeprecatedHeader Value to which {@link #deprecatedHeader} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated this header param is no longer supported. Please use "xxx" instead. (<b>since:</b> 1.2.3, <b>removed
     * with:</b> PI.2.3)
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
      BeanParamWithDeprecations lObject = new BeanParamWithDeprecations(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class BeanParamWithDeprecations. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return BeanParamWithDeprecations Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BeanParamWithDeprecations buildValidated( ) throws ConstraintViolationException {
      BeanParamWithDeprecations lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #header1}.<br/>
   *
   * @return {@link String} Value to which {@link #header1} is set.
   */
  public String getHeader1( ) {
    return header1;
  }

  /**
   * Method sets attribute {@link #header1}.<br/>
   *
   * @param pHeader1 Value to which {@link #header1} should be set.
   */
  public void setHeader1( String pHeader1 ) {
    // Assign value to attribute
    header1 = pHeader1;
  }

  /**
   * Method returns attribute {@link #deprecatedHeader}.<br/>
   *
   * @return {@link String} Value to which {@link #deprecatedHeader} is set.
   * @deprecated this header param is no longer supported. Please use "xxx" instead. (<b>since:</b> 1.2.3, <b>removed
   * with:</b> PI.2.3)
   */
  @Deprecated
  public String getDeprecatedHeader( ) {
    return deprecatedHeader;
  }

  /**
   * Method sets attribute {@link #deprecatedHeader}.<br/>
   *
   * @param pDeprecatedHeader Value to which {@link #deprecatedHeader} should be set.
   * @deprecated this header param is no longer supported. Please use "xxx" instead. (<b>since:</b> 1.2.3, <b>removed
   * with:</b> PI.2.3)
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
