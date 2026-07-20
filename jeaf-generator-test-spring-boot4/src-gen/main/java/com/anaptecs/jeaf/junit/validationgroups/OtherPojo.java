/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
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
@JsonDeserialize(builder = OtherPojo.Builder.class)
public class OtherPojo {
  /**
   * Constant for the name of attribute "multiValuedProperty".
   */
  public static final String MULTIVALUEDPROPERTY = "multiValuedProperty";

  /**
   * Constant for the name of attribute "decimalProperty".
   */
  public static final String DECIMALPROPERTY = "decimalProperty";

  /**
   * Constant for the name of attribute "integerProperty".
   */
  public static final String INTEGERPROPERTY = "integerProperty";

  /**
   * Constant for the name of attribute "stringProperty".
   */
  public static final String STRINGPROPERTY = "stringProperty";

  /**
   * Constant for the name of attribute "emailProperty".
   */
  public static final String EMAILPROPERTY = "emailProperty";

  /**
   * Constant for the name of attribute "booleanProperty".
   */
  public static final String BOOLEANPROPERTY = "booleanProperty";

  /**
   * Constant for the name of attribute "dateTimeProperty".
   */
  public static final String DATETIMEPROPERTY = "dateTimeProperty";

  @Size(min = 1, groups = { V7.class })
  private String[] multiValuedProperty;

  @DecimalMax(value = "48", inclusive = false, groups = { V7.class })
  @DecimalMax(value = "49", inclusive = true, groups = { V4.class, V5.class, V6.class })
  @DecimalMin(value = "42", inclusive = false, groups = { V7.class })
  @DecimalMin(value = "42", inclusive = true, groups = { V4.class, V5.class, V6.class })
  @Digits(integer = 5, fraction = 2, groups = { V7.class })
  @Digits(integer = 5, fraction = 3, groups = { V4.class, V5.class, V6.class })
  @NotNull(groups = { V7.class })
  private BigDecimal decimalProperty;

  @Min(value = 333, groups = { V7.class })
  @Min(value = 300, groups = { V4.class, V5.class, V6.class })
  @Max(value = 666, groups = { V7.class })
  @Max(value = 667, groups = { V4.class, V5.class, V6.class })
  @Negative(groups = { V7.class })
  @PositiveOrZero(groups = { V7.class })
  @NegativeOrZero(groups = { V4.class, V5.class, V6.class })
  @Positive(groups = { V4.class, V5.class, V6.class })
  @NotNull
  private Integer integerProperty;

  @Pattern(regexp = "[A-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE }, groups = { V7.class })
  @Pattern(regexp = "[B-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE }, groups = { V4.class, V5.class, V6.class })
  @NotBlank(groups = { V4.class, V5.class, V6.class })
  @NotNull
  private String stringProperty;

  @Email(groups = { V7.class })
  @NotEmpty(groups = { V7.class })
  private String emailProperty;

  @AssertTrue(groups = { V7.class })
  @AssertFalse(groups = { V4.class, V5.class, V6.class })
  @NotNull
  private Boolean booleanProperty;

  @FutureOrPresent(groups = { V7.class })
  @Past(groups = { V7.class })
  @Future(groups = { V4.class, V5.class, V6.class })
  @PastOrPresent(groups = { V4.class, V5.class, V6.class })
  @NotNull
  private OffsetDateTime dateTimeProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected OtherPojo( Builder pBuilder ) {
    // Read attribute values from builder.
    multiValuedProperty = pBuilder.multiValuedProperty;
    decimalProperty = pBuilder.decimalProperty;
    integerProperty = pBuilder.integerProperty;
    stringProperty = pBuilder.stringProperty;
    emailProperty = pBuilder.emailProperty;
    booleanProperty = pBuilder.booleanProperty;
    dateTimeProperty = pBuilder.dateTimeProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new OtherPojo objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class OtherPojo.
   *
   *
   * @param pMultiValuedProperty Value to which {@link #multiValuedProperty} should be set.
   *
   * @param pDecimalProperty Value to which {@link #decimalProperty} should be set.
   *
   * @param pIntegerProperty Value to which {@link #integerProperty} should be set.
   *
   * @param pStringProperty Value to which {@link #stringProperty} should be set.
   *
   * @param pEmailProperty Value to which {@link #emailProperty} should be set.
   *
   * @param pBooleanProperty Value to which {@link #booleanProperty} should be set.
   *
   * @param pDateTimeProperty Value to which {@link #dateTimeProperty} should be set.
   *
   * @return {@link OtherPojo}
   */
  public static OtherPojo of( String[] pMultiValuedProperty, BigDecimal pDecimalProperty, Integer pIntegerProperty,
      String pStringProperty, String pEmailProperty, Boolean pBooleanProperty, OffsetDateTime pDateTimeProperty ) {
    var lBuilder = OtherPojo.builder();
    lBuilder.setMultiValuedProperty(pMultiValuedProperty);
    lBuilder.setDecimalProperty(pDecimalProperty);
    lBuilder.setIntegerProperty(pIntegerProperty);
    lBuilder.setStringProperty(pStringProperty);
    lBuilder.setEmailProperty(pEmailProperty);
    lBuilder.setBooleanProperty(pBooleanProperty);
    lBuilder.setDateTimeProperty(pDateTimeProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>OtherPojo</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String[] multiValuedProperty;

    private BigDecimal decimalProperty;

    private Integer integerProperty;

    private String stringProperty;

    private String emailProperty;

    private Boolean booleanProperty;

    private OffsetDateTime dateTimeProperty;

    /**
     * Use {@link OtherPojo#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link OtherPojo#builder(OtherPojo)} instead of private constructor to create new builder.
     */
    protected Builder( OtherPojo pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMultiValuedProperty(pObject.multiValuedProperty);
        this.setDecimalProperty(pObject.decimalProperty);
        this.setIntegerProperty(pObject.integerProperty);
        this.setStringProperty(pObject.stringProperty);
        this.setEmailProperty(pObject.emailProperty);
        this.setBooleanProperty(pObject.booleanProperty);
        this.setDateTimeProperty(pObject.dateTimeProperty);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new OtherPojo objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new OtherPojo objects. The method never returns
     * null.
     */
    public static Builder newBuilder( OtherPojo pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #multiValuedProperty}.<br/>
     *
     * @param pMultiValuedProperty Collection to which {@link #multiValuedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setMultiValuedProperty( @MyNotEmptyProperty String[] pMultiValuedProperty ) {
      // Assign value to attribute
      if (pMultiValuedProperty != null) {
        multiValuedProperty = new String[pMultiValuedProperty.length];
        System.arraycopy(pMultiValuedProperty, 0, multiValuedProperty, 0, pMultiValuedProperty.length);
      }
      else {
        multiValuedProperty = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #decimalProperty}.<br/>
     *
     * @param pDecimalProperty Value to which {@link #decimalProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setDecimalProperty( @MyNotNullProperty BigDecimal pDecimalProperty ) {
      // Assign value to attribute
      decimalProperty = pDecimalProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #integerProperty}.<br/>
     *
     * @param pIntegerProperty Value to which {@link #integerProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setIntegerProperty( @MyNotNullProperty Integer pIntegerProperty ) {
      // Assign value to attribute
      integerProperty = pIntegerProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #stringProperty}.<br/>
     *
     * @param pStringProperty Value to which {@link #stringProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setStringProperty( @MyNotNullProperty String pStringProperty ) {
      // Assign value to attribute
      stringProperty = pStringProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #emailProperty}.<br/>
     *
     * @param pEmailProperty Value to which {@link #emailProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setEmailProperty( @MyNotNullProperty String pEmailProperty ) {
      // Assign value to attribute
      emailProperty = pEmailProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #booleanProperty}.<br/>
     *
     * @param pBooleanProperty Value to which {@link #booleanProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setBooleanProperty( @MyNotNullProperty Boolean pBooleanProperty ) {
      // Assign value to attribute
      booleanProperty = pBooleanProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #dateTimeProperty}.<br/>
     *
     * @param pDateTimeProperty Value to which {@link #dateTimeProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setDateTimeProperty( @MyNotNullProperty OffsetDateTime pDateTimeProperty ) {
      // Assign value to attribute
      dateTimeProperty = pDateTimeProperty;
      return this;
    }

    /**
     * Method creates a new instance of class OtherPojo. The object will be initialized with the values of the builder.
     *
     * @return OtherPojo Created object. The method never returns null.
     */
    public OtherPojo build( ) {
      OtherPojo lObject = new OtherPojo(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #multiValuedProperty}.<br/>
   *
   * @return {@link String[]} Value to which {@link #multiValuedProperty} is set.
   */
  @MyNotEmptyProperty
  public String[] getMultiValuedProperty( ) {
    String[] lReturnValue;
    if (multiValuedProperty != null) {
      lReturnValue = new String[multiValuedProperty.length];
      System.arraycopy(multiValuedProperty, 0, lReturnValue, 0, multiValuedProperty.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #multiValuedProperty}.<br/>
   *
   * @param pMultiValuedProperty Value to which {@link #multiValuedProperty} should be set.
   */
  public void setMultiValuedProperty( @MyNotEmptyProperty String[] pMultiValuedProperty ) {
    // Assign value to attribute
    if (pMultiValuedProperty != null) {
      multiValuedProperty = new String[pMultiValuedProperty.length];
      System.arraycopy(pMultiValuedProperty, 0, multiValuedProperty, 0, pMultiValuedProperty.length);
    }
    else {
      multiValuedProperty = null;
    }
  }

  /**
   * Method returns attribute {@link #decimalProperty}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #decimalProperty} is set.
   */
  @MyNotNullProperty
  public BigDecimal getDecimalProperty( ) {
    return decimalProperty;
  }

  /**
   * Method sets attribute {@link #decimalProperty}.<br/>
   *
   * @param pDecimalProperty Value to which {@link #decimalProperty} should be set.
   */
  public void setDecimalProperty( @MyNotNullProperty BigDecimal pDecimalProperty ) {
    // Assign value to attribute
    decimalProperty = pDecimalProperty;
  }

  /**
   * Method returns attribute {@link #integerProperty}.<br/>
   *
   * @return {@link Integer} Value to which {@link #integerProperty} is set.
   */
  @MyNotNullProperty
  public Integer getIntegerProperty( ) {
    return integerProperty;
  }

  /**
   * Method sets attribute {@link #integerProperty}.<br/>
   *
   * @param pIntegerProperty Value to which {@link #integerProperty} should be set.
   */
  public void setIntegerProperty( @MyNotNullProperty Integer pIntegerProperty ) {
    // Assign value to attribute
    integerProperty = pIntegerProperty;
  }

  /**
   * Method returns attribute {@link #stringProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #stringProperty} is set.
   */
  @MyNotNullProperty
  public String getStringProperty( ) {
    return stringProperty;
  }

  /**
   * Method sets attribute {@link #stringProperty}.<br/>
   *
   * @param pStringProperty Value to which {@link #stringProperty} should be set.
   */
  public void setStringProperty( @MyNotNullProperty String pStringProperty ) {
    // Assign value to attribute
    stringProperty = pStringProperty;
  }

  /**
   * Method returns attribute {@link #emailProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #emailProperty} is set.
   */
  @MyNotNullProperty
  public String getEmailProperty( ) {
    return emailProperty;
  }

  /**
   * Method sets attribute {@link #emailProperty}.<br/>
   *
   * @param pEmailProperty Value to which {@link #emailProperty} should be set.
   */
  public void setEmailProperty( @MyNotNullProperty String pEmailProperty ) {
    // Assign value to attribute
    emailProperty = pEmailProperty;
  }

  /**
   * Method returns attribute {@link #booleanProperty}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #booleanProperty} is set.
   */
  @MyNotNullProperty
  public Boolean getBooleanProperty( ) {
    return booleanProperty;
  }

  /**
   * Method sets attribute {@link #booleanProperty}.<br/>
   *
   * @param pBooleanProperty Value to which {@link #booleanProperty} should be set.
   */
  public void setBooleanProperty( @MyNotNullProperty Boolean pBooleanProperty ) {
    // Assign value to attribute
    booleanProperty = pBooleanProperty;
  }

  /**
   * Method returns attribute {@link #dateTimeProperty}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #dateTimeProperty} is set.
   */
  @MyNotNullProperty
  public OffsetDateTime getDateTimeProperty( ) {
    return dateTimeProperty;
  }

  /**
   * Method sets attribute {@link #dateTimeProperty}.<br/>
   *
   * @param pDateTimeProperty Value to which {@link #dateTimeProperty} should be set.
   */
  public void setDateTimeProperty( @MyNotNullProperty OffsetDateTime pDateTimeProperty ) {
    // Assign value to attribute
    dateTimeProperty = pDateTimeProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Arrays.hashCode(multiValuedProperty);
    lResult = lPrime * lResult + Objects.hashCode(decimalProperty);
    lResult = lPrime * lResult + Objects.hashCode(integerProperty);
    lResult = lPrime * lResult + Objects.hashCode(stringProperty);
    lResult = lPrime * lResult + Objects.hashCode(emailProperty);
    lResult = lPrime * lResult + Objects.hashCode(booleanProperty);
    lResult = lPrime * lResult + Objects.hashCode(dateTimeProperty);
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
      OtherPojo lOther = (OtherPojo) pObject;
      lEquals = Arrays.equals(multiValuedProperty, lOther.multiValuedProperty)
          && Objects.equals(decimalProperty, lOther.decimalProperty)
          && Objects.equals(integerProperty, lOther.integerProperty)
          && Objects.equals(stringProperty, lOther.stringProperty)
          && Objects.equals(emailProperty, lOther.emailProperty)
          && Objects.equals(booleanProperty, lOther.booleanProperty)
          && Objects.equals(dateTimeProperty, lOther.dateTimeProperty);
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
    lBuilder.append("multiValuedProperty: ");
    if (multiValuedProperty != null) {
      lBuilder.append(Arrays.toString(multiValuedProperty));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("decimalProperty: ");
    lBuilder.append(decimalProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("integerProperty: ");
    lBuilder.append(integerProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("stringProperty: ");
    lBuilder.append(stringProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("emailProperty: ");
    lBuilder.append(emailProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("booleanProperty: ");
    lBuilder.append(booleanProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dateTimeProperty: ");
    lBuilder.append(dateTimeProperty);
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
   * @return {@link Builder} New builder that can be used to create new OtherPojo objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}