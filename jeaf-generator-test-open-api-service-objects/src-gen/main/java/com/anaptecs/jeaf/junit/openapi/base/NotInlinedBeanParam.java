/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class NotInlinedBeanParam implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @HeaderParam("header")
  @NotNull
  private String header;

  /**
   * 
   */
  @HeaderParam("doubleCode")
  @NotNull
  private DoubleCode doubleCode;

  /**
   * 
   */
  @HeaderParam("extensibleEnum")
  @NotNull
  private ExtensibleEnum extensibleEnum;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected NotInlinedBeanParam( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected NotInlinedBeanParam( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    header = pBuilder.header;
    doubleCode = pBuilder.doubleCode;
    extensibleEnum = pBuilder.extensibleEnum;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new NotInlinedBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new NotInlinedBeanParam objects. The method never
   * returns null.
   */
  public static Builder builder( NotInlinedBeanParam pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class NotInlinedBeanParam. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String header;

    /**
     * 
     */
    private DoubleCode doubleCode;

    /**
     * 
     */
    private ExtensibleEnum extensibleEnum;

    /**
     * Use {@link NotInlinedBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link NotInlinedBeanParam#builder(NotInlinedBeanParam)} instead of private constructor to create new
     * builder.
     */
    protected Builder( NotInlinedBeanParam pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        header = pObject.header;
        doubleCode = pObject.doubleCode;
        extensibleEnum = pObject.extensibleEnum;
      }
    }

    /**
     * Method sets the attribute "header".
     * 
     * @param pHeader Value to which the attribute "header" should be set.
     */
    public Builder setHeader( String pHeader ) {
      // Assign value to attribute
      header = pHeader;
      return this;
    }

    /**
     * Method sets the attribute "doubleCode".
     * 
     * @param pDoubleCode Value to which the attribute "doubleCode" should be set.
     */
    public Builder setDoubleCode( DoubleCode pDoubleCode ) {
      // Assign value to attribute
      doubleCode = pDoubleCode;
      return this;
    }

    /**
     * Method sets the attribute "extensibleEnum".
     * 
     * @param pExtensibleEnum Value to which the attribute "extensibleEnum" should be set.
     */
    public Builder setExtensibleEnum( ExtensibleEnum pExtensibleEnum ) {
      // Assign value to attribute
      extensibleEnum = pExtensibleEnum;
      return this;
    }

    /**
     * Method creates a new instance of class NotInlinedBeanParam. The object will be initialized with the values of the
     * builder.
     * 
     * @return NotInlinedBeanParam Created object. The method never returns null.
     */
    public NotInlinedBeanParam build( ) {
      return new NotInlinedBeanParam(this);
    }

    /**
     * Method creates a new validated instance of class NotInlinedBeanParam. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return NotInlinedBeanParam Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public NotInlinedBeanParam buildValidated( ) throws ConstraintViolationException {
      NotInlinedBeanParam lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "header".
   * 
   * 
   * @return String Value to which the attribute "header" is set.
   */
  public String getHeader( ) {
    return header;
  }

  /**
   * Method sets the attribute "header".
   * 
   * 
   * @param pHeader Value to which the attribute "header" should be set.
   */
  public void setHeader( String pHeader ) {
    // Assign value to attribute
    header = pHeader;
  }

  /**
   * Method returns the attribute "doubleCode".
   * 
   * 
   * @return DoubleCode Value to which the attribute "doubleCode" is set.
   */
  public DoubleCode getDoubleCode( ) {
    return doubleCode;
  }

  /**
   * Method sets the attribute "doubleCode".
   * 
   * 
   * @param pDoubleCode Value to which the attribute "doubleCode" should be set.
   */
  public void setDoubleCode( DoubleCode pDoubleCode ) {
    // Assign value to attribute
    doubleCode = pDoubleCode;
  }

  /**
   * Method returns the attribute "extensibleEnum".
   * 
   * 
   * @return ExtensibleEnum Value to which the attribute "extensibleEnum" is set.
   */
  public ExtensibleEnum getExtensibleEnum( ) {
    return extensibleEnum;
  }

  /**
   * Method sets the attribute "extensibleEnum".
   * 
   * 
   * @param pExtensibleEnum Value to which the attribute "extensibleEnum" should be set.
   */
  public void setExtensibleEnum( ExtensibleEnum pExtensibleEnum ) {
    // Assign value to attribute
    extensibleEnum = pExtensibleEnum;
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
    lBuilder.append("header: ");
    lBuilder.append(header);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCode: ");
    lBuilder.append(doubleCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("extensibleEnum: ");
    lBuilder.append(extensibleEnum);
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
