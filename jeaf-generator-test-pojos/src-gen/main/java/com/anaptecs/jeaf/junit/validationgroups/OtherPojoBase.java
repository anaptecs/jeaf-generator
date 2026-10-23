/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
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

import com.anaptecs.jeaf.generator.annotations.BreakingChangeNotice;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.validation.api.EnumSubset;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = OtherPojo.Builder.class)
public abstract class OtherPojoBase {
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

  /**
   * Constant for the name of attribute "positiveValueProperty".
   */
  public static final String POSITIVEVALUEPROPERTY = "positiveValueProperty";

  /**
   * Constant for the name of attribute "negativeProperty".
   */
  public static final String NEGATIVEPROPERTY = "negativeProperty";

  /**
   * Constant for the name of attribute "v6Property".
   */
  @BreakingChangeNotice(
      description = "Property will become mandatory.",
      since = "",
      activeWith = "8.0",
      goLiveDate = "2027-05-01",
      endOfCompatibilityPeriod = "2026-10-20")
  public static final String V6PROPERTY = "v6Property";

  /**
   * Constant for the name of attribute "myLimitiedColor".
   */
  public static final String MYLIMITIEDCOLOR = "myLimitiedColor";

  /**
   * Constant for the name of attribute "myColors".
   */
  public static final String MYCOLORS = "myColors";

  /**
   * Constant for the name of attribute "myColor".
   */
  public static final String MYCOLOR = "myColor";

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

  @PositiveOrZero(groups = { V7.class })
  @Positive(groups = { V4.class, V5.class, V6.class })
  private int positiveValueProperty;

  @Negative(groups = { V7.class })
  @NegativeOrZero(groups = { V4.class, V5.class, V6.class })
  private int negativeProperty;

  /**
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> , <b>active with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of
   * compatibility period:</b> 2026-10-20): Property will become mandatory.
   */
  @BreakingChangeNotice(
      description = "Property will become mandatory.",
      since = "",
      activeWith = "8.0",
      goLiveDate = "2027-05-01",
      endOfCompatibilityPeriod = "2026-10-20")
  @Size(min = 10, max = 32, groups = { V7.class })
  @Size(min = 0, max = 32, groups = { V4.class, V5.class, V6.class })
  @NotNull(groups = { V7.class })
  private String v6Property;

  @EnumSubset(notAllowedLiterals = { "WHITE", "BLACK" })
  @NotNull
  private MyLimitiedColor myLimitiedColor;

  @EnumSubset(allowedLiterals = { "RED", "GREEN", "BLUE" }, groups = { V7.class })
  private Set<MyLimitiedColor> myColors;

  @EnumSubset(notAllowedLiterals = { "BLACK", "WHITE" }, groups = { V7.class })
  @EnumSubset(allowedLiterals = { "WHITE", "RED" }, groups = { V4.class, V5.class, V6.class })
  @NotNull
  private MyLimitiedColor myColor;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected OtherPojoBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    multiValuedProperty = pBuilder.multiValuedProperty;
    decimalProperty = pBuilder.decimalProperty;
    integerProperty = pBuilder.integerProperty;
    stringProperty = pBuilder.stringProperty;
    emailProperty = pBuilder.emailProperty;
    booleanProperty = pBuilder.booleanProperty;
    dateTimeProperty = pBuilder.dateTimeProperty;
    positiveValueProperty = pBuilder.positiveValueProperty;
    negativeProperty = pBuilder.negativeProperty;
    v6Property = pBuilder.v6Property;
    myLimitiedColor = pBuilder.myLimitiedColor;
    myColors = (pBuilder.myColors == null) ? new HashSet<>() : pBuilder.myColors;
    myColor = pBuilder.myColor;
  }

  /**
   * Class implements builder to create a new instance of class OtherPojo. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private String[] multiValuedProperty;

    private BigDecimal decimalProperty;

    private Integer integerProperty;

    private String stringProperty;

    private String emailProperty;

    private Boolean booleanProperty;

    private OffsetDateTime dateTimeProperty;

    private int positiveValueProperty;

    private int negativeProperty;

    /**
     * <p/>
     * <b>Breaking Change</b> (<b>since:</b> , <b>active with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of
     * compatibility period:</b> 2026-10-20): Property will become mandatory.
     */
    @BreakingChangeNotice(
        description = "Property will become mandatory.",
        since = "",
        activeWith = "8.0",
        goLiveDate = "2027-05-01",
        endOfCompatibilityPeriod = "2026-10-20")
    private String v6Property;

    private MyLimitiedColor myLimitiedColor;

    private Set<MyLimitiedColor> myColors;

    private MyLimitiedColor myColor;

    /**
     * Use {@link OtherPojo.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link OtherPojo.builder(OtherPojo)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( OtherPojoBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMultiValuedProperty(pObject.multiValuedProperty);
        this.setDecimalProperty(pObject.decimalProperty);
        this.setIntegerProperty(pObject.integerProperty);
        this.setStringProperty(pObject.stringProperty);
        this.setEmailProperty(pObject.emailProperty);
        this.setBooleanProperty(pObject.booleanProperty);
        this.setDateTimeProperty(pObject.dateTimeProperty);
        this.setPositiveValueProperty(pObject.positiveValueProperty);
        this.setNegativeProperty(pObject.negativeProperty);
        this.setV6Property(pObject.v6Property);
        this.setMyLimitiedColor(pObject.myLimitiedColor);
        this.setMyColors(pObject.myColors);
        this.setMyColor(pObject.myColor);
      }
    }

    /**
     * Method sets attribute {@link #multiValuedProperty}.<br/>
     *
     * @param pMultiValuedProperty Collection to which {@link #multiValuedProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public BuilderBase setMultiValuedProperty( String[] pMultiValuedProperty ) {
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
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setDecimalProperty( BigDecimal pDecimalProperty ) {
      // Assign value to attribute
      decimalProperty = pDecimalProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #integerProperty}.<br/>
     *
     * @param pIntegerProperty Value to which {@link #integerProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setIntegerProperty( Integer pIntegerProperty ) {
      // Assign value to attribute
      integerProperty = pIntegerProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #stringProperty}.<br/>
     *
     * @param pStringProperty Value to which {@link #stringProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setStringProperty( String pStringProperty ) {
      // Assign value to attribute
      stringProperty = pStringProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #emailProperty}.<br/>
     *
     * @param pEmailProperty Value to which {@link #emailProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setEmailProperty( String pEmailProperty ) {
      // Assign value to attribute
      emailProperty = pEmailProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #booleanProperty}.<br/>
     *
     * @param pBooleanProperty Value to which {@link #booleanProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setBooleanProperty( Boolean pBooleanProperty ) {
      // Assign value to attribute
      booleanProperty = pBooleanProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #dateTimeProperty}.<br/>
     *
     * @param pDateTimeProperty Value to which {@link #dateTimeProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setDateTimeProperty( OffsetDateTime pDateTimeProperty ) {
      // Assign value to attribute
      dateTimeProperty = pDateTimeProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #positiveValueProperty}.<br/>
     *
     * @param pPositiveValueProperty Value to which {@link #positiveValueProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setPositiveValueProperty( int pPositiveValueProperty ) {
      // Assign value to attribute
      positiveValueProperty = pPositiveValueProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #negativeProperty}.<br/>
     *
     * @param pNegativeProperty Value to which {@link #negativeProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setNegativeProperty( int pNegativeProperty ) {
      // Assign value to attribute
      negativeProperty = pNegativeProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #v6Property}.<br/>
     * <p/>
     * <b>Breaking Change</b> (<b>since:</b> , <b>active with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of
     * compatibility period:</b> 2026-10-20): Property will become mandatory.
     *
     * @param pV6Property Value to which {@link #v6Property} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @BreakingChangeNotice(
        description = "Property will become mandatory.",
        since = "",
        activeWith = "8.0",
        goLiveDate = "2027-05-01",
        endOfCompatibilityPeriod = "2026-10-20")
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setV6Property( String pV6Property ) {
      // Assign value to attribute
      v6Property = pV6Property;
      return this;
    }

    /**
     * Method sets association {@link #myLimitiedColor}.<br/>
     *
     * @param pMyLimitiedColor Value to which {@link #myLimitiedColor} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setMyLimitiedColor( MyLimitiedColor pMyLimitiedColor ) {
      myLimitiedColor = pMyLimitiedColor;
      return this;
    }

    /**
     * Method sets association {@link #myColors}.<br/>
     *
     * @param pMyColors Collection to which {@link #myColors} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public BuilderBase setMyColors( Set<MyLimitiedColor> pMyColors ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMyColors != null) {
        myColors = new HashSet<MyLimitiedColor>(pMyColors);
      }
      else {
        myColors = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #myColors}.<br/>
     *
     * @param pMyColors Array of objects that should be added to {@link #myColors}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToMyColors( MyLimitiedColor... pMyColors ) {
      if (pMyColors != null) {
        if (myColors == null) {
          myColors = new HashSet<MyLimitiedColor>();
        }
        myColors.addAll(Arrays.asList(pMyColors));
      }
      return this;
    }

    /**
     * Method sets association {@link #myColors}.<br/>
     *
     * @param pMyColors Array with objects to which {@link #myColors} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setMyColors( MyLimitiedColor... pMyColors ) {
      // Copy the content of the passed array.
      if (pMyColors != null) {
        myColors = new HashSet<MyLimitiedColor>(Arrays.asList(pMyColors));
      }
      else {
        myColors = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #myColor}.<br/>
     *
     * @param pMyColor Value to which {@link #myColor} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setMyColor( MyLimitiedColor pMyColor ) {
      // Assign value to attribute
      myColor = pMyColor;
      return this;
    }

    /**
     * Method creates a new instance of class OtherPojo. The object will be initialized with the values of the builder.
     *
     * @return OtherPojo Created object. The method never returns null.
     */
    public OtherPojo build( ) {
      return new OtherPojo(this);
    }

    /**
     * Method creates a new validated instance of class OtherPojo. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return OtherPojo Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public OtherPojo buildValidated( ) throws ConstraintViolationException {
      OtherPojo lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #multiValuedProperty}.<br/>
   *
   * @return {@link String[]} Value to which {@link #multiValuedProperty} is set.
   */
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
  public void setMultiValuedProperty( String[] pMultiValuedProperty ) {
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
  public BigDecimal getDecimalProperty( ) {
    return decimalProperty;
  }

  /**
   * Method sets attribute {@link #decimalProperty}.<br/>
   *
   * @param pDecimalProperty Value to which {@link #decimalProperty} should be set.
   */
  public void setDecimalProperty( BigDecimal pDecimalProperty ) {
    // Assign value to attribute
    decimalProperty = pDecimalProperty;
  }

  /**
   * Method returns attribute {@link #integerProperty}.<br/>
   *
   * @return {@link Integer} Value to which {@link #integerProperty} is set.
   */
  public Integer getIntegerProperty( ) {
    return integerProperty;
  }

  /**
   * Method sets attribute {@link #integerProperty}.<br/>
   *
   * @param pIntegerProperty Value to which {@link #integerProperty} should be set.
   */
  public void setIntegerProperty( Integer pIntegerProperty ) {
    // Assign value to attribute
    integerProperty = pIntegerProperty;
  }

  /**
   * Method returns attribute {@link #stringProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #stringProperty} is set.
   */
  public String getStringProperty( ) {
    return stringProperty;
  }

  /**
   * Method sets attribute {@link #stringProperty}.<br/>
   *
   * @param pStringProperty Value to which {@link #stringProperty} should be set.
   */
  public void setStringProperty( String pStringProperty ) {
    // Assign value to attribute
    stringProperty = pStringProperty;
  }

  /**
   * Method returns attribute {@link #emailProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #emailProperty} is set.
   */
  public String getEmailProperty( ) {
    return emailProperty;
  }

  /**
   * Method sets attribute {@link #emailProperty}.<br/>
   *
   * @param pEmailProperty Value to which {@link #emailProperty} should be set.
   */
  public void setEmailProperty( String pEmailProperty ) {
    // Assign value to attribute
    emailProperty = pEmailProperty;
  }

  /**
   * Method returns attribute {@link #booleanProperty}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #booleanProperty} is set.
   */
  public Boolean getBooleanProperty( ) {
    return booleanProperty;
  }

  /**
   * Method sets attribute {@link #booleanProperty}.<br/>
   *
   * @param pBooleanProperty Value to which {@link #booleanProperty} should be set.
   */
  public void setBooleanProperty( Boolean pBooleanProperty ) {
    // Assign value to attribute
    booleanProperty = pBooleanProperty;
  }

  /**
   * Method returns attribute {@link #dateTimeProperty}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #dateTimeProperty} is set.
   */
  public OffsetDateTime getDateTimeProperty( ) {
    return dateTimeProperty;
  }

  /**
   * Method sets attribute {@link #dateTimeProperty}.<br/>
   *
   * @param pDateTimeProperty Value to which {@link #dateTimeProperty} should be set.
   */
  public void setDateTimeProperty( OffsetDateTime pDateTimeProperty ) {
    // Assign value to attribute
    dateTimeProperty = pDateTimeProperty;
  }

  /**
   * Method returns attribute {@link #positiveValueProperty}.<br/>
   *
   * @return int Value to which {@link #positiveValueProperty} is set.
   */
  public int getPositiveValueProperty( ) {
    return positiveValueProperty;
  }

  /**
   * Method sets attribute {@link #positiveValueProperty}.<br/>
   *
   * @param pPositiveValueProperty Value to which {@link #positiveValueProperty} should be set.
   */
  public void setPositiveValueProperty( int pPositiveValueProperty ) {
    // Assign value to attribute
    positiveValueProperty = pPositiveValueProperty;
  }

  /**
   * Method returns attribute {@link #negativeProperty}.<br/>
   *
   * @return int Value to which {@link #negativeProperty} is set.
   */
  public int getNegativeProperty( ) {
    return negativeProperty;
  }

  /**
   * Method sets attribute {@link #negativeProperty}.<br/>
   *
   * @param pNegativeProperty Value to which {@link #negativeProperty} should be set.
   */
  public void setNegativeProperty( int pNegativeProperty ) {
    // Assign value to attribute
    negativeProperty = pNegativeProperty;
  }

  /**
   * Method returns attribute {@link #v6Property}.<br/>
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> , <b>active with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of
   * compatibility period:</b> 2026-10-20): Property will become mandatory.
   *
   * @return {@link String} Value to which {@link #v6Property} is set.
   */
  @BreakingChangeNotice(
      description = "Property will become mandatory.",
      since = "",
      activeWith = "8.0",
      goLiveDate = "2027-05-01",
      endOfCompatibilityPeriod = "2026-10-20")
  public String getV6Property( ) {
    return v6Property;
  }

  /**
   * Method sets attribute {@link #v6Property}.<br/>
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> , <b>active with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of
   * compatibility period:</b> 2026-10-20): Property will become mandatory.
   *
   * @param pV6Property Value to which {@link #v6Property} should be set.
   */
  @BreakingChangeNotice(
      description = "Property will become mandatory.",
      since = "",
      activeWith = "8.0",
      goLiveDate = "2027-05-01",
      endOfCompatibilityPeriod = "2026-10-20")
  public void setV6Property( String pV6Property ) {
    // Assign value to attribute
    v6Property = pV6Property;
  }

  /**
   * Method returns association {@link #myLimitiedColor}.<br/>
   *
   * @return {@link MyLimitiedColor} Value to which {@link #myLimitiedColor} is set.
   */
  public MyLimitiedColor getMyLimitiedColor( ) {
    return myLimitiedColor;
  }

  /**
   * Method sets association {@link #myLimitiedColor}.<br/>
   *
   * @param pMyLimitiedColor Value to which {@link #myLimitiedColor} should be set.
   */
  public void setMyLimitiedColor( MyLimitiedColor pMyLimitiedColor ) {
    myLimitiedColor = pMyLimitiedColor;
  }

  /**
   * Method unsets {@link #myLimitiedColor}.
   */
  public final void unsetMyLimitiedColor( ) {
    myLimitiedColor = null;
  }

  /**
   * Method returns association {@link #myColors}.<br/>
   *
   * @return {@link Set<MyLimitiedColor>} Value to which {@link #myColors} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<MyLimitiedColor> getMyColors( ) {
    // Return all MyLimitiedColor objects as unmodifiable collection.
    return Collections.unmodifiableSet(myColors);
  }

  /**
   * Method adds the passed object to {@link #myColors}.
   *
   * @param pMyColors Object that should be added to {@link #myColors}. The parameter must not be null.
   */
  public void addToMyColors( MyLimitiedColor pMyColors ) {
    // Check parameter "pMyColors" for invalid value null.
    Check.checkInvalidParameterNull(pMyColors, "pMyColors");
    // Add passed object to collection of associated MyLimitiedColor objects.
    myColors.add(pMyColors);
  }

  /**
   * Method adds all passed objects to {@link #myColors}.
   *
   * @param pMyColors Collection with all objects that should be added to {@link #myColors}. The parameter must not be
   * null.
   */
  public void addToMyColors( Collection<MyLimitiedColor> pMyColors ) {
    // Check parameter "pMyColors" for invalid value null.
    Check.checkInvalidParameterNull(pMyColors, "pMyColors");
    // Add all passed objects.
    for (MyLimitiedColor lNextObject : pMyColors) {
      this.addToMyColors(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #myColors}.<br/>
   *
   * @param pMyColors Object that should be removed from {@link #myColors}. The parameter must not be null.
   */
  public void removeFromMyColors( MyLimitiedColor pMyColors ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMyColors, "pMyColors");
    // Remove passed object from collection of associated MyLimitiedColor objects.
    myColors.remove(pMyColors);
  }

  /**
   * Method removes all objects from {@link #myColors}.
   */
  public void clearMyColors( ) {
    // Remove all objects from association "myColors".
    myColors.clear();
  }

  /**
   * Method returns attribute {@link #myColor}.<br/>
   *
   * @return {@link MyLimitiedColor} Value to which {@link #myColor} is set.
   */
  public MyLimitiedColor getMyColor( ) {
    return myColor;
  }

  /**
   * Method sets attribute {@link #myColor}.<br/>
   *
   * @param pMyColor Value to which {@link #myColor} should be set.
   */
  public void setMyColor( MyLimitiedColor pMyColor ) {
    // Assign value to attribute
    myColor = pMyColor;
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
   * @param pPositiveValueProperty Value to which {@link #positiveValueProperty} should be set.
   *
   * @param pNegativeProperty Value to which {@link #negativeProperty} should be set.
   *
   * @param pV6Property Value to which {@link #v6Property} should be set.
   *
   * @param pMyLimitiedColor Value to which {@link #myLimitiedColor} should be set.
   *
   * @param pMyColor Value to which {@link #myColor} should be set.
   *
   * @return {@link OtherPojo}
   */
  public static OtherPojo of( String[] pMultiValuedProperty, BigDecimal pDecimalProperty, Integer pIntegerProperty,
      String pStringProperty, String pEmailProperty, Boolean pBooleanProperty, OffsetDateTime pDateTimeProperty,
      int pPositiveValueProperty, int pNegativeProperty, String pV6Property, MyLimitiedColor pMyLimitiedColor,
      MyLimitiedColor pMyColor ) {
    var lBuilder = OtherPojo.builder();
    lBuilder.setMultiValuedProperty(pMultiValuedProperty);
    lBuilder.setDecimalProperty(pDecimalProperty);
    lBuilder.setIntegerProperty(pIntegerProperty);
    lBuilder.setStringProperty(pStringProperty);
    lBuilder.setEmailProperty(pEmailProperty);
    lBuilder.setBooleanProperty(pBooleanProperty);
    lBuilder.setDateTimeProperty(pDateTimeProperty);
    lBuilder.setPositiveValueProperty(pPositiveValueProperty);
    lBuilder.setNegativeProperty(pNegativeProperty);
    lBuilder.setV6Property(pV6Property);
    lBuilder.setMyLimitiedColor(pMyLimitiedColor);
    lBuilder.setMyColor(pMyColor);
    return lBuilder.build();
  }

  /**
   * Method returns attribute {@link #derivedString}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedString} is set.
   */
  public abstract @Size(min = 1, max = 111) @NotNull String getDerivedString( );

  /**
   * Method returns attribute {@link #derivedList}.<br/>
   *
   * @return {@link String[]} Value to which {@link #derivedList} is set.
   */
  public abstract @Size(min = 7, max = 42) String[] getDerivedList( );

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
    lResult = lPrime * lResult + positiveValueProperty;
    lResult = lPrime * lResult + negativeProperty;
    lResult = lPrime * lResult + Objects.hashCode(v6Property);
    lResult = lPrime * lResult + Objects.hashCode(myLimitiedColor);
    lResult = lPrime * lResult + Objects.hashCode(myColors);
    lResult = lPrime * lResult + Objects.hashCode(myColor);
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
      OtherPojoBase lOther = (OtherPojoBase) pObject;
      lEquals = Arrays.equals(multiValuedProperty, lOther.multiValuedProperty)
          && Objects.equals(decimalProperty, lOther.decimalProperty)
          && Objects.equals(integerProperty, lOther.integerProperty)
          && Objects.equals(stringProperty, lOther.stringProperty)
          && Objects.equals(emailProperty, lOther.emailProperty)
          && Objects.equals(booleanProperty, lOther.booleanProperty)
          && Objects.equals(dateTimeProperty, lOther.dateTimeProperty)
          && positiveValueProperty == lOther.positiveValueProperty && negativeProperty == lOther.negativeProperty
          && Objects.equals(v6Property, lOther.v6Property) && Objects.equals(myLimitiedColor, lOther.myLimitiedColor)
          && Objects.equals(myColors, lOther.myColors) && Objects.equals(myColor, lOther.myColor);
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
    lBuilder.append(pIndent);
    lBuilder.append("positiveValueProperty: ");
    lBuilder.append(positiveValueProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("negativeProperty: ");
    lBuilder.append(negativeProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("v6Property: ");
    lBuilder.append(v6Property);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myLimitiedColor: ");
    lBuilder.append(myLimitiedColor);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myColors: ");
    if (myColors != null) {
      lBuilder.append(myColors.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (myColors != null) {
      for (MyLimitiedColor lNext : myColors) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("myColor: ");
    lBuilder.append(myColor);
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
  public OtherPojo.Builder toBuilder( ) {
    return new OtherPojo.Builder((OtherPojo) this);
  }
}