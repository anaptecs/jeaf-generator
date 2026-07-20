/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = MyPOJOResponse.Builder.class)
public class MyPOJOResponse {
  /**
   * Constant for the name of attribute "untouchedProperty".
   */
  public static final String UNTOUCHEDPROPERTY = "untouchedProperty";

  /**
   * Constant for the name of attribute "formerMandatoryProperty".
   */
  public static final String FORMERMANDATORYPROPERTY = "formerMandatoryProperty";

  /**
   * Constant for the name of attribute "deprecatedProperty".
   */
  @Deprecated
  public static final String DEPRECATEDPROPERTY = "deprecatedProperty";

  private String untouchedProperty;

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @NotNull(groups = { V4.class, V5.class, V6.class })
  private String formerMandatoryProperty;

  @Deprecated
  private String deprecatedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyPOJOResponse( Builder pBuilder ) {
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
    private String formerMandatoryProperty;

    @Deprecated
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
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects. The method never
     * returns null.
     */
    public static Builder newBuilder( MyPOJOResponse pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #untouchedProperty}.<br/>
     *
     * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setUntouchedProperty( @MyNotNullProperty String pUntouchedProperty ) {
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
      MyPOJOResponse lObject = new MyPOJOResponse(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #untouchedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #untouchedProperty} is set.
   */
  @MyNotNullProperty
  public String getUntouchedProperty( ) {
    return untouchedProperty;
  }

  /**
   * Method sets attribute {@link #untouchedProperty}.<br/>
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   */
  public void setUntouchedProperty( @MyNotNullProperty String pUntouchedProperty ) {
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
  public String getDeprecatedProperty( ) {
    return deprecatedProperty;
  }

  /**
   * Method sets attribute {@link #deprecatedProperty}.<br/>
   *
   * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
   */
  @Deprecated
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