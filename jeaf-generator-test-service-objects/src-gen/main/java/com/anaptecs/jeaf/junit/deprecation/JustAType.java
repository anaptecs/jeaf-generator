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

public class JustAType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "attribute".
   */
  public static final String ATTRIBUTE = "attribute";

  /**
   * Constant for the name of attribute "legacy".
   */
  @Deprecated
  public static final String LEGACY = "legacy";

  private int attribute;

  /**
   * @deprecated Hello (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  private double legacy;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected JustAType( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected JustAType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    attribute = pBuilder.attribute;
    legacy = pBuilder.legacy;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new JustAType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new JustAType objects. The method never returns
   * null.
   */
  public static Builder builder( JustAType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class JustAType. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private int attribute;

    /**
     * 
     */
    @Deprecated
    private double legacy;

    /**
     * Use {@link JustAType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link JustAType#builder(JustAType)} instead of private constructor to create new builder.
     */
    protected Builder( JustAType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        attribute = pObject.attribute;
        legacy = pObject.legacy;
      }
    }

    /**
     * Method sets the attribute "attribute".
     * 
     * @param pAttribute Value to which the attribute "attribute" should be set.
     */
    public Builder setAttribute( int pAttribute ) {
      // Assign value to attribute
      attribute = pAttribute;
      return this;
    }

    /**
     * Method sets the attribute "legacy".
     * 
     * @param pLegacy Value to which the attribute "legacy" should be set.
     */
    @Deprecated
    public Builder setLegacy( double pLegacy ) {
      // Assign value to attribute
      legacy = pLegacy;
      return this;
    }

    /**
     * Method creates a new instance of class JustAType. The object will be initialized with the values of the builder.
     * 
     * @return JustAType Created object. The method never returns null.
     */
    public JustAType build( ) {
      return new JustAType(this);
    }

    /**
     * Method creates a new validated instance of class JustAType. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return JustAType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public JustAType buildValidated( ) throws ConstraintViolationException {
      JustAType lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #attribute}.<br/>
   * 
   * @return int Value to which {@link #attribute} is set.
   */
  public int getAttribute( ) {
    return attribute;
  }

  /**
   * Method sets attribute {@link #attribute}.<br/>
   * 
   * @param pAttribute Value to which {@link #attribute} should be set.
   */
  public void setAttribute( int pAttribute ) {
    // Assign value to attribute
    attribute = pAttribute;
  }

  /**
   * Method returns attribute {@link #legacy}.<br/>
   * 
   * @return double Value to which {@link #legacy} is set.
   * @deprecated Hello (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  public double getLegacy( ) {
    return legacy;
  }

  /**
   * Method sets attribute {@link #legacy}.<br/>
   * 
   * @param pLegacy Value to which {@link #legacy} should be set.
   * @deprecated Hello (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  public void setLegacy( double pLegacy ) {
    // Assign value to attribute
    legacy = pLegacy;
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
    lBuilder.append("attribute: ");
    lBuilder.append(attribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("legacy: ");
    lBuilder.append(legacy);
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
