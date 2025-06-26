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
   * Convenience method to create new instance of class JustAType.
   *
   *
   * @param pAttribute Value to which {@link #attribute} should be set.
   *
   * @param pLegacy Value to which {@link #legacy} should be set.
   *
   * @return {@link JustAType}
   */
  public static JustAType of( int pAttribute, double pLegacy ) {
    var lBuilder = JustAType.builder();
    lBuilder.setAttribute(pAttribute);
    lBuilder.setLegacy(pLegacy);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>JustAType</code>.
   */
  public static class Builder {
    private int attribute;

    /**
     * @deprecated Hello (<b>since:</b> TBD, <b>removed with:</b> TBD)
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
        this.setAttribute(pObject.attribute);
        this.setLegacy(pObject.legacy);
      }
    }

    /**
     * Method sets attribute {@link #attribute}.<br/>
     *
     * @param pAttribute Value to which {@link #attribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAttribute( int pAttribute ) {
      // Assign value to attribute
      attribute = pAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #legacy}.<br/>
     *
     * @param pLegacy Value to which {@link #legacy} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated Hello (<b>since:</b> TBD, <b>removed with:</b> TBD)
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
      JustAType lObject = new JustAType(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class JustAType. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return JustAType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public JustAType buildValidated( ) throws ConstraintViolationException {
      JustAType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new JustAType objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}