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

import com.anaptecs.jeaf.generator.annotations.DeprecationNotice;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> 5.x, <b>removed with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of compatibility
 * period:</b> 2026-10-20)
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Deprecated
@DeprecationNotice(
    description = "",
    since = "5.x",
    removedWith = "8.0",
    goLiveDate = "2027-05-01",
    endOfCompatibilityPeriod = "2026-10-20")
@JsonDeserialize(builder = DeprecatedChildClassForValidationGroups.Builder.class)
public class DeprecatedChildClassForValidationGroups extends ParentClassForValidationGroups {
  /**
   * Constant for the name of attribute "myProperty".
   */
  public static final String MYPROPERTY = "myProperty";

  @NotNull
  private String myProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedChildClassForValidationGroups( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    myProperty = pBuilder.myProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DeprecatedChildClassForValidationGroups objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DeprecatedChildClassForValidationGroups.
   *
   *
   * @param pParentProperty Value to which {@link #parentProperty} should be set.
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   *
   * @return {@link DeprecatedChildClassForValidationGroups}
   */
  public static DeprecatedChildClassForValidationGroups of( String pParentProperty, String pMyProperty ) {
    var lBuilder = DeprecatedChildClassForValidationGroups.builder();
    lBuilder.setParentProperty(pParentProperty);
    lBuilder.setMyProperty(pMyProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedChildClassForValidationGroups</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @Deprecated
  @DeprecationNotice(
      description = "",
      since = "5.x",
      removedWith = "8.0",
      goLiveDate = "2027-05-01",
      endOfCompatibilityPeriod = "2026-10-20")
  public static class Builder extends ParentClassForValidationGroups.Builder {
    private String myProperty;

    /**
     * Use {@link DeprecatedChildClassForValidationGroups#builder()} instead of private constructor to create new
     * builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link DeprecatedChildClassForValidationGroups#builder(DeprecatedChildClassForValidationGroups)} instead of
     * private constructor to create new builder.
     */
    protected Builder( DeprecatedChildClassForValidationGroups pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyProperty(pObject.myProperty);
      }
    }

    /**
     * Method sets attribute {@link #parentProperty}.<br/>
     *
     * @param pParentProperty Value to which {@link #parentProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    @Override
    public Builder setParentProperty( String pParentProperty ) {
      // Call super class implementation.
      super.setParentProperty(pParentProperty);
      return this;
    }

    /**
     * Method sets attribute {@link #myProperty}.<br/>
     *
     * @param pMyProperty Value to which {@link #myProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setMyProperty( String pMyProperty ) {
      // Assign value to attribute
      myProperty = pMyProperty;
      return this;
    }

    /**
     * Method creates a new instance of class DeprecatedChildClassForValidationGroups. The object will be initialized
     * with the values of the builder.
     *
     * @return DeprecatedChildClassForValidationGroups Created object. The method never returns null.
     */
    public DeprecatedChildClassForValidationGroups build( ) {
      return new DeprecatedChildClassForValidationGroups(this);
    }

    /**
     * Method creates a new validated instance of class DeprecatedChildClassForValidationGroups. The object will be
     * initialized with the values of the builder and validated afterwards.
     *
     * @return DeprecatedChildClassForValidationGroups Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DeprecatedChildClassForValidationGroups buildValidated( ) throws ConstraintViolationException {
      DeprecatedChildClassForValidationGroups lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #myProperty} is set.
   */
  public String getMyProperty( ) {
    return myProperty;
  }

  /**
   * Method sets attribute {@link #myProperty}.<br/>
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   */
  public void setMyProperty( String pMyProperty ) {
    // Assign value to attribute
    myProperty = pMyProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(myProperty);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      DeprecatedChildClassForValidationGroups lOther = (DeprecatedChildClassForValidationGroups) pObject;
      lEquals = Objects.equals(myProperty, lOther.myProperty);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("myProperty: ");
    lBuilder.append(myProperty);
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
   * @return {@link Builder} New builder that can be used to create new DeprecatedChildClassForValidationGroups objects.
   * The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}