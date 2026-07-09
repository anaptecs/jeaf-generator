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
@JsonDeserialize(builder = MyPojoRequest.Builder.class)
public class MyPojoRequest {
  /**
   * Constant for the name of attribute "upcomingMandatoryProperty".
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public static final String UPCOMINGMANDATORYPROPERTY = "upcomingMandatoryProperty";

  /**
   * Constant for the name of attribute "propertyWithNewConstraints".
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public static final String PROPERTYWITHNEWCONSTRAINTS = "propertyWithNewConstraints";

  /**
   * Constant for the name of attribute "formerMandatoryRequestProperty".
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public static final String FORMERMANDATORYREQUESTPROPERTY = "formerMandatoryRequestProperty";

  /**
   * Constant for the name of attribute "untouchedProperty".
   */
  public static final String UNTOUCHEDPROPERTY = "untouchedProperty";

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  private String upcomingMandatoryProperty;

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  private String propertyWithNewConstraints;

  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  private String formerMandatoryRequestProperty;

  private String untouchedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyPojoRequest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    upcomingMandatoryProperty = pBuilder.upcomingMandatoryProperty;
    propertyWithNewConstraints = pBuilder.propertyWithNewConstraints;
    formerMandatoryRequestProperty = pBuilder.formerMandatoryRequestProperty;
    untouchedProperty = pBuilder.untouchedProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class MyPojoRequest.
   *
   *
   * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
   *
   * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   *
   * @return {@link MyPojoRequest}
   */
  public static MyPojoRequest of( String pUpcomingMandatoryProperty, String pPropertyWithNewConstraints,
      String pUntouchedProperty ) {
    var lBuilder = MyPojoRequest.builder();
    lBuilder.setUpcomingMandatoryProperty(pUpcomingMandatoryProperty);
    lBuilder.setPropertyWithNewConstraints(pPropertyWithNewConstraints);
    lBuilder.setUntouchedProperty(pUntouchedProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MyPojoRequest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * <p/>
     * <b>Breaking Change with :</b>
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    private String upcomingMandatoryProperty;

    /**
     * <p/>
     * <b>Breaking Change with :</b>
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    private String propertyWithNewConstraints;

    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
    private String formerMandatoryRequestProperty;

    private String untouchedProperty;

    /**
     * Use {@link MyPojoRequest#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyPojoRequest#builder(MyPojoRequest)} instead of private constructor to create new builder.
     */
    protected Builder( MyPojoRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setUpcomingMandatoryProperty(pObject.upcomingMandatoryProperty);
        this.setPropertyWithNewConstraints(pObject.propertyWithNewConstraints);
        this.setFormerMandatoryRequestProperty(pObject.formerMandatoryRequestProperty);
        this.setUntouchedProperty(pObject.untouchedProperty);
      }
    }

    /**
     * Method sets attribute {@link #upcomingMandatoryProperty}.<br/>
     * <p/>
     * <b>Breaking Change with :</b>
     *
     * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setUpcomingMandatoryProperty( String pUpcomingMandatoryProperty ) {
      // Assign value to attribute
      upcomingMandatoryProperty = pUpcomingMandatoryProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #propertyWithNewConstraints}.<br/>
     * <p/>
     * <b>Breaking Change with :</b>
     *
     * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setPropertyWithNewConstraints( String pPropertyWithNewConstraints ) {
      // Assign value to attribute
      propertyWithNewConstraints = pPropertyWithNewConstraints;
      return this;
    }

    /**
     * Method sets attribute {@link #formerMandatoryRequestProperty}.<br/>
     *
     * @param pFormerMandatoryRequestProperty Value to which {@link #formerMandatoryRequestProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setFormerMandatoryRequestProperty( String pFormerMandatoryRequestProperty ) {
      // Assign value to attribute
      formerMandatoryRequestProperty = pFormerMandatoryRequestProperty;
      return this;
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
     * Method creates a new instance of class MyPojoRequest. The object will be initialized with the values of the
     * builder.
     *
     * @return MyPojoRequest Created object. The method never returns null.
     */
    public MyPojoRequest build( ) {
      return new MyPojoRequest(this);
    }

    /**
     * Method creates a new validated instance of class MyPojoRequest. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return MyPojoRequest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MyPojoRequest buildValidated( ) throws ConstraintViolationException {
      MyPojoRequest lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #upcomingMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @return {@link String} Value to which {@link #upcomingMandatoryProperty} is set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public String getUpcomingMandatoryProperty( ) {
    return upcomingMandatoryProperty;
  }

  /**
   * Method sets attribute {@link #upcomingMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public void setUpcomingMandatoryProperty( String pUpcomingMandatoryProperty ) {
    // Assign value to attribute
    upcomingMandatoryProperty = pUpcomingMandatoryProperty;
  }

  /**
   * Method returns attribute {@link #propertyWithNewConstraints}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @return {@link String} Value to which {@link #propertyWithNewConstraints} is set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public String getPropertyWithNewConstraints( ) {
    return propertyWithNewConstraints;
  }

  /**
   * Method sets attribute {@link #propertyWithNewConstraints}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
   */
  @BreakingChangeNotice(description = "", since = "", activeWith = "", activationDate = "")
  public void setPropertyWithNewConstraints( String pPropertyWithNewConstraints ) {
    // Assign value to attribute
    propertyWithNewConstraints = pPropertyWithNewConstraints;
  }

  /**
   * Method returns attribute {@link #formerMandatoryRequestProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #formerMandatoryRequestProperty} is set.
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public String getFormerMandatoryRequestProperty( ) {
    return formerMandatoryRequestProperty;
  }

  /**
   * Method sets attribute {@link #formerMandatoryRequestProperty}.<br/>
   *
   * @param pFormerMandatoryRequestProperty Value to which {@link #formerMandatoryRequestProperty} should be set.
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "", removalDate = "")
  public void setFormerMandatoryRequestProperty( String pFormerMandatoryRequestProperty ) {
    // Assign value to attribute
    formerMandatoryRequestProperty = pFormerMandatoryRequestProperty;
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(upcomingMandatoryProperty);
    lResult = lPrime * lResult + Objects.hashCode(propertyWithNewConstraints);
    lResult = lPrime * lResult + Objects.hashCode(formerMandatoryRequestProperty);
    lResult = lPrime * lResult + Objects.hashCode(untouchedProperty);
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
      MyPojoRequest lOther = (MyPojoRequest) pObject;
      lEquals = Objects.equals(upcomingMandatoryProperty, lOther.upcomingMandatoryProperty)
          && Objects.equals(propertyWithNewConstraints, lOther.propertyWithNewConstraints)
          && Objects.equals(formerMandatoryRequestProperty, lOther.formerMandatoryRequestProperty)
          && Objects.equals(untouchedProperty, lOther.untouchedProperty);
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
    lBuilder.append("upcomingMandatoryProperty: ");
    lBuilder.append(upcomingMandatoryProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("propertyWithNewConstraints: ");
    lBuilder.append(propertyWithNewConstraints);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("formerMandatoryRequestProperty: ");
    lBuilder.append(formerMandatoryRequestProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("untouchedProperty: ");
    lBuilder.append(untouchedProperty);
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
   * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}