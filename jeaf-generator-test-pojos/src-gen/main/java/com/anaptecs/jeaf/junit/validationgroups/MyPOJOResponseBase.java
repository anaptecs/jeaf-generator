/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.generator.annotations.BreakingChangeNotice;
import com.anaptecs.jeaf.generator.annotations.DeprecationNotice;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = MyPOJOResponse.Builder.class)
public abstract class MyPOJOResponseBase {
  /**
   * Constant for the name of attribute "untouchedProperty".
   */
  public static final String UNTOUCHEDPROPERTY = "untouchedProperty";

  /**
   * Constant for the name of attribute "formerMandatoryProperty".
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
  public static final String FORMERMANDATORYPROPERTY = "formerMandatoryProperty";

  /**
   * Constant for the name of attribute "deprecatedProperty".
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  public static final String DEPRECATEDPROPERTY = "deprecatedProperty";

  @NotNull
  private String untouchedProperty;

  /**
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 7.0, <b>activation date:</b> 2026-09-13):
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
  @NotNull(groups = { V4.class, V5.class, V6.class })
  private String formerMandatoryProperty;

  /**
   * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  private String deprecatedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyPOJOResponseBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    untouchedProperty = pBuilder.untouchedProperty;
    formerMandatoryProperty = pBuilder.formerMandatoryProperty;
    deprecatedProperty = pBuilder.deprecatedProperty;
  }

  /**
   * Class implements builder to create a new instance of class MyPOJOResponse. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private String untouchedProperty;

    /**
     * <p/>
     * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 7.0, <b>activation date:</b> 2026-09-13):
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
    private String formerMandatoryProperty;

    /**
     * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
     */
    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
    private String deprecatedProperty;

    /**
     * Use {@link MyPOJOResponse.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link MyPOJOResponse.builder(MyPOJOResponse)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( MyPOJOResponseBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setUntouchedProperty(pObject.untouchedProperty);
        this.setFormerMandatoryProperty(pObject.formerMandatoryProperty);
        this.setDeprecatedProperty(pObject.deprecatedProperty);
      }
    }

    /**
     * Method sets attribute {@link #untouchedProperty}.<br/>
     *
     * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setUntouchedProperty( String pUntouchedProperty ) {
      // Assign value to attribute
      untouchedProperty = pUntouchedProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #formerMandatoryProperty}.<br/>
     * <p/>
     * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 7.0, <b>activation date:</b> 2026-09-13):
     *
     * @param pFormerMandatoryProperty Value to which {@link #formerMandatoryProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setFormerMandatoryProperty( String pFormerMandatoryProperty ) {
      // Assign value to attribute
      formerMandatoryProperty = pFormerMandatoryProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedProperty}.<br/>
     *
     * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
     */
    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setDeprecatedProperty( String pDeprecatedProperty ) {
      // Assign value to attribute
      deprecatedProperty = pDeprecatedProperty;
      return this;
    }

    /**
     * Method creates a new instance of class MyPOJOResponse. The object will be initialized with the values of the
     * builder.
     *
     * @return MyPOJOResponse Created object. The method never returns null.
     */
    public MyPOJOResponse build( ) {
      return new MyPOJOResponse(this);
    }

    /**
     * Method creates a new validated instance of class MyPOJOResponse. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return MyPOJOResponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MyPOJOResponse buildValidated( ) throws ConstraintViolationException {
      MyPOJOResponse lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #untouchedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #untouchedProperty} is set.
   */
  public String getUntouchedProperty( ) {
    return untouchedProperty;
  }

  /**
   * Method sets attribute {@link #untouchedProperty}.<br/>
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   */
  public void setUntouchedProperty( String pUntouchedProperty ) {
    // Assign value to attribute
    untouchedProperty = pUntouchedProperty;
  }

  /**
   * Method returns attribute {@link #formerMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 7.0, <b>activation date:</b> 2026-09-13):
   *
   * @return {@link String} Value to which {@link #formerMandatoryProperty} is set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
  public String getFormerMandatoryProperty( ) {
    return formerMandatoryProperty;
  }

  /**
   * Method sets attribute {@link #formerMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 7.0, <b>activation date:</b> 2026-09-13):
   *
   * @param pFormerMandatoryProperty Value to which {@link #formerMandatoryProperty} should be set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "7.0", activationDate = "2026-09-13")
  public void setFormerMandatoryProperty( String pFormerMandatoryProperty ) {
    // Assign value to attribute
    formerMandatoryProperty = pFormerMandatoryProperty;
  }

  /**
   * Method returns attribute {@link #deprecatedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #deprecatedProperty} is set.
   * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  public String getDeprecatedProperty( ) {
    return deprecatedProperty;
  }

  /**
   * Method sets attribute {@link #deprecatedProperty}.<br/>
   *
   * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
   * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  public void setDeprecatedProperty( String pDeprecatedProperty ) {
    // Assign value to attribute
    deprecatedProperty = pDeprecatedProperty;
  }

  /**
   * Convenience method to create new instance of class MyPOJOResponse.
   *
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   *
   * @return {@link MyPOJOResponse}
   */
  public static MyPOJOResponse of( String pUntouchedProperty ) {
    var lBuilder = MyPOJOResponse.builder();
    lBuilder.setUntouchedProperty(pUntouchedProperty);
    return lBuilder.build();
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @NotNull(groups = { V7.class })
  public abstract String getDerivedProperty( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(untouchedProperty);
    lResult = lPrime * lResult + Objects.hashCode(formerMandatoryProperty);
    lResult = lPrime * lResult + Objects.hashCode(deprecatedProperty);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      MyPOJOResponseBase lOther = (MyPOJOResponseBase) pObject;
      lEquals = Objects.equals(untouchedProperty, lOther.untouchedProperty)
          && Objects.equals(formerMandatoryProperty, lOther.formerMandatoryProperty)
          && Objects.equals(deprecatedProperty, lOther.deprecatedProperty);
    }
    return lEquals;
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
    lBuilder.append("untouchedProperty: ");
    lBuilder.append(untouchedProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("formerMandatoryProperty: ");
    lBuilder.append(formerMandatoryProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedProperty: ");
    lBuilder.append(deprecatedProperty);
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
   * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects. The method never returns
   * null.
   */
  public MyPOJOResponse.Builder toBuilder( ) {
    return new MyPOJOResponse.Builder((MyPOJOResponse) this);
  }
}