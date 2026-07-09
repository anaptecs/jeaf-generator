/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.generator.annotations.BreakingChangeNotice;
import com.anaptecs.jeaf.generator.annotations.DeprecationNotice;
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
public class MyPOJOResponse {
  /**
   * Constant for the name of attribute "untouchedProperty".
   */
  public static final String UNTOUCHEDPROPERTY = "untouchedProperty";

  /**
   * Constant for the name of attribute "formerMandatoryProperty".
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public static final String FORMERMANDATORYPROPERTY = "formerMandatoryProperty";

  /**
   * Constant for the name of attribute "deprecatedProperty".
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public static final String DEPRECATEDPROPERTY = "deprecatedProperty";

  private String untouchedProperty;

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  private String formerMandatoryProperty;

  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  private String deprecatedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyPOJOResponse( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    untouchedProperty = pBuilder.untouchedProperty;
    formerMandatoryProperty = pBuilder.formerMandatoryProperty;
    deprecatedProperty = pBuilder.deprecatedProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects.
   */
  public static Builder builder( ) {
    return new Builder();
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
   * Class implements builder to create a new instance of class <code>MyPOJOResponse</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String untouchedProperty;

    /**
     * <p/>
     * <b>Breaking Change with :</b>
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    private String formerMandatoryProperty;

    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
    private String deprecatedProperty;

    /**
     * Use {@link MyPOJOResponse#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyPOJOResponse#builder(MyPOJOResponse)} instead of private constructor to create new builder.
     */
    protected Builder( MyPOJOResponse pObject ) {
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
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setUntouchedProperty( String pUntouchedProperty ) {
      // Assign value to attribute
      untouchedProperty = pUntouchedProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #formerMandatoryProperty}.<br/>
     * <p/>
     * <b>Breaking Change with :</b>
     *
     * @param pFormerMandatoryProperty Value to which {@link #formerMandatoryProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setFormerMandatoryProperty( String pFormerMandatoryProperty ) {
      // Assign value to attribute
      formerMandatoryProperty = pFormerMandatoryProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedProperty}.<br/>
     *
     * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setDeprecatedProperty( String pDeprecatedProperty ) {
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
      MyPOJOResponse lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * <b>Breaking Change with :</b>
   *
   * @return {@link String} Value to which {@link #formerMandatoryProperty} is set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public String getFormerMandatoryProperty( ) {
    return formerMandatoryProperty;
  }

  /**
   * Method sets attribute {@link #formerMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @param pFormerMandatoryProperty Value to which {@link #formerMandatoryProperty} should be set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public void setFormerMandatoryProperty( String pFormerMandatoryProperty ) {
    // Assign value to attribute
    formerMandatoryProperty = pFormerMandatoryProperty;
  }

  /**
   * Method returns attribute {@link #deprecatedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #deprecatedProperty} is set.
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public String getDeprecatedProperty( ) {
    return deprecatedProperty;
  }

  /**
   * Method sets attribute {@link #deprecatedProperty}.<br/>
   *
   * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public void setDeprecatedProperty( String pDeprecatedProperty ) {
    // Assign value to attribute
    deprecatedProperty = pDeprecatedProperty;
  }

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
      MyPOJOResponse lOther = (MyPOJOResponse) pObject;
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}