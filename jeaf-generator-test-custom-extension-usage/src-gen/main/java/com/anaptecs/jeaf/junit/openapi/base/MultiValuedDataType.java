/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class MultiValuedDataType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "stringCodeHeader".
   */
  public static final String STRINGCODEHEADER = "stringCodeHeader";

  /**
   * Constant for the name of attribute "longCodeQueryParam".
   */
  public static final String LONGCODEQUERYPARAM = "longCodeQueryParam";

  /**
   * Constant for the name of attribute "literals".
   */
  public static final String LITERALS = "literals";

  /**
   * Constant for the name of attribute "stringProperty".
   */
  public static final String STRINGPROPERTY = "stringProperty";

  /**
   * Constant for the name of attribute "longValues".
   */
  public static final String LONGVALUES = "longValues";

  // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
  @ClassPropertyDeclaration
  /**
   * This is my multivalued test header
   */
  private List<StringCode> stringCodeHeader;

  // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
  private int stringCodeHeaderXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
  @ClassPropertyDeclaration
  /**
   * Multivalued query param
   */
  private List<LongCode> longCodeQueryParam;

  // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
  private int longCodeQueryParamXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
  @ClassPropertyDeclaration
  /**
   * so many literals are possible
   */
  private List<BooleanLiteralsEnum> literals;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
  private int literalsXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  @Size(min = 32, max = 64)
  private String stringProperty;

  // "String"
  private int stringPropertyXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  /**
   * long values as multivalued header
   */
  @Min(value = 3270)
  @Max(value = 4711)
  private long[] longValues;

  // "long"
  private int longValuesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MultiValuedDataType( ) {
    stringCodeHeader = new ArrayList<StringCode>();
    longCodeQueryParam = new ArrayList<LongCode>();
    literals = new ArrayList<BooleanLiteralsEnum>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultiValuedDataType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.stringCodeHeader != null) {
      stringCodeHeader = pBuilder.stringCodeHeader;
    }
    else {
      stringCodeHeader = new ArrayList<StringCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    stringCodeHeaderXYZ = pBuilder.stringCodeHeaderXYZ;
    if (pBuilder.longCodeQueryParam != null) {
      longCodeQueryParam = pBuilder.longCodeQueryParam;
    }
    else {
      longCodeQueryParam = new ArrayList<LongCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
    longCodeQueryParamXYZ = pBuilder.longCodeQueryParamXYZ;
    if (pBuilder.literals != null) {
      literals = pBuilder.literals;
    }
    else {
      literals = new ArrayList<BooleanLiteralsEnum>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
    literalsXYZ = pBuilder.literalsXYZ;
    stringProperty = pBuilder.stringProperty;
    // "String"
    stringPropertyXYZ = pBuilder.stringPropertyXYZ;
    longValues = pBuilder.longValues;
    // "long"
    longValuesXYZ = pBuilder.longValuesXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MultiValuedDataType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>MultiValuedDataType</code>.
   */
  public static class Builder {
    /**
     * This is my multivalued test header
     */
    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    @BuilderPropertyDeclaration
    private List<StringCode> stringCodeHeader;

    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    private int stringCodeHeaderXYZ = 0;

    /**
     * Multivalued query param
     */
    // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
    @BuilderPropertyDeclaration
    private List<LongCode> longCodeQueryParam;

    // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
    private int longCodeQueryParamXYZ = 0;

    /**
     * so many literals are possible
     */
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
    @BuilderPropertyDeclaration
    private List<BooleanLiteralsEnum> literals;

    // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
    private int literalsXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    @Size(min = 32, max = 64)
    private String stringProperty;

    // "String"
    private int stringPropertyXYZ = 0;

    /**
     * long values as multivalued header
     */
    // "long"
    @BuilderPropertyDeclaration
    @Min(value = 3270)
    @Max(value = 4711)
    private long[] longValues;

    // "long"
    private int longValuesXYZ = 0;

    /**
     * Use {@link MultiValuedDataType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultiValuedDataType#builder(MultiValuedDataType)} instead of private constructor to create new
     * builder.
     */
    protected Builder( MultiValuedDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStringCodeHeader(pObject.stringCodeHeader);
        this.setLongCodeQueryParam(pObject.longCodeQueryParam);
        this.setLiterals(pObject.literals);
        this.setStringProperty(pObject.stringProperty);
        this.setLongValues(pObject.longValues);
      }
    }

    /**
     * Method sets association {@link #stringCodeHeader}.<br/>
     *
     * @param pStringCodeHeader Collection to which {@link #stringCodeHeader} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStringCodeHeader( List<StringCode> pStringCodeHeader ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStringCodeHeader != null) {
        stringCodeHeader = new ArrayList<StringCode>(pStringCodeHeader);
      }
      else {
        stringCodeHeader = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #stringCodeHeader}.<br/>
     *
     * @param pStringCodeHeader Array of objects that should be added to {@link #stringCodeHeader}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToStringCodeHeader( StringCode... pStringCodeHeader ) {
      if (pStringCodeHeader != null) {
        if (stringCodeHeader == null) {
          stringCodeHeader = new ArrayList<StringCode>();
        }
        stringCodeHeader.addAll(Arrays.asList(pStringCodeHeader));
      }
      return this;
    }

    public Builder setStringCodeHeaderXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
      stringCodeHeaderXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #longCodeQueryParam}.<br/>
     *
     * @param pLongCodeQueryParam Collection to which {@link #longCodeQueryParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLongCodeQueryParam( List<LongCode> pLongCodeQueryParam ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLongCodeQueryParam != null) {
        longCodeQueryParam = new ArrayList<LongCode>(pLongCodeQueryParam);
      }
      else {
        longCodeQueryParam = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #longCodeQueryParam}.<br/>
     *
     * @param pLongCodeQueryParam Array of objects that should be added to {@link #longCodeQueryParam}. The parameter
     * may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLongCodeQueryParam( LongCode... pLongCodeQueryParam ) {
      if (pLongCodeQueryParam != null) {
        if (longCodeQueryParam == null) {
          longCodeQueryParam = new ArrayList<LongCode>();
        }
        longCodeQueryParam.addAll(Arrays.asList(pLongCodeQueryParam));
      }
      return this;
    }

    public Builder setLongCodeQueryParamXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
      longCodeQueryParamXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #literals}.<br/>
     *
     * @param pLiterals Collection to which {@link #literals} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLiterals( List<BooleanLiteralsEnum> pLiterals ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLiterals != null) {
        literals = new ArrayList<BooleanLiteralsEnum>(pLiterals);
      }
      else {
        literals = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #literals}.<br/>
     *
     * @param pLiterals Array of objects that should be added to {@link #literals}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLiterals( BooleanLiteralsEnum... pLiterals ) {
      if (pLiterals != null) {
        if (literals == null) {
          literals = new ArrayList<BooleanLiteralsEnum>();
        }
        literals.addAll(Arrays.asList(pLiterals));
      }
      return this;
    }

    /**
     * Method sets association {@link #literals}.<br/>
     *
     * @param pLiterals Array with objects to which {@link #literals} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLiterals( BooleanLiteralsEnum... pLiterals ) {
      // To ensure immutability we have to copy the content of the passed array.
      if (pLiterals != null) {
        literals = new ArrayList<BooleanLiteralsEnum>(Arrays.asList(pLiterals));
      }
      else {
        literals = null;
      }
      return this;
    }

    public Builder setLiteralsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
      literalsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #stringProperty}.<br/>
     *
     * @param pStringProperty Value to which {@link #stringProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStringProperty( String pStringProperty ) {
      // Assign value to attribute
      stringProperty = pStringProperty;
      return this;
    }

    public Builder setStringPropertyXYZ( int value ) {
      // "String"
      stringPropertyXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #longValues}.<br/>
     *
     * @param pLongValues Value to which {@link #longValues} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLongValues( long[] pLongValues ) {
      // Assign value to attribute
      if (pLongValues != null) {
        longValues = new long[pLongValues.length];
        System.arraycopy(pLongValues, 0, longValues, 0, pLongValues.length);
      }
      else {
        longValues = null;
      }
      return this;
    }

    public Builder setLongValuesXYZ( int value ) {
      // "long"
      longValuesXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class MultiValuedDataType. The object will be initialized with the values of the
     * builder.
     *
     * @return MultiValuedDataType Created object. The method never returns null.
     */
    public MultiValuedDataType build( ) {
      return new MultiValuedDataType(this);
    }

    /**
     * Method creates a new validated instance of class MultiValuedDataType. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return MultiValuedDataType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MultiValuedDataType buildValidated( ) throws ConstraintViolationException {
      MultiValuedDataType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #stringCodeHeader}.<br/>
   * This is my multivalued test header
   *
   * @return {@link List<StringCode>} Value to which {@link #stringCodeHeader} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<StringCode> getStringCodeHeader( ) {
    // Return all StringCode objects as unmodifiable collection.
    return Collections.unmodifiableList(stringCodeHeader);
  }

  /**
   * Method adds the passed object to {@link #stringCodeHeader}.
   *
   * @param pStringCodeHeader Object that should be added to {@link #stringCodeHeader}. The parameter must not be null.
   */
  public void addToStringCodeHeader( StringCode pStringCodeHeader ) {
    // Check parameter "pStringCodeHeader" for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeHeader, "pStringCodeHeader");
    // Add passed object to collection of associated StringCode objects.
    stringCodeHeader.add(pStringCodeHeader);
  }

  /**
   * Method adds all passed objects to {@link #stringCodeHeader}.
   *
   * @param pStringCodeHeader Collection with all objects that should be added to {@link #stringCodeHeader}. The
   * parameter must not be null.
   */
  public void addToStringCodeHeader( Collection<StringCode> pStringCodeHeader ) {
    // Check parameter "pStringCodeHeader" for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeHeader, "pStringCodeHeader");
    // Add all passed objects.
    for (StringCode lNextObject : pStringCodeHeader) {
      this.addToStringCodeHeader(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #stringCodeHeader}.<br/>
   *
   * @param pStringCodeHeader Object that should be removed from {@link #stringCodeHeader}. The parameter must not be
   * null.
   */
  public void removeFromStringCodeHeader( StringCode pStringCodeHeader ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeHeader, "pStringCodeHeader");
    // Remove passed object from collection of associated StringCode objects.
    stringCodeHeader.remove(pStringCodeHeader);
  }

  /**
   * Method removes all objects from {@link #stringCodeHeader}.
   */
  public void clearStringCodeHeader( ) {
    // Remove all objects from association "stringCodeHeader".
    stringCodeHeader.clear();
  }

  public int getStringCodeHeaderXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    return stringCodeHeaderXYZ;
  }

  public void setStringCodeHeaderXYZ( int value ) {
    stringCodeHeaderXYZ = value;
  }

  /**
   * Method returns association {@link #longCodeQueryParam}.<br/>
   * Multivalued query param
   *
   * @return {@link List<LongCode>} Value to which {@link #longCodeQueryParam} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<LongCode> getLongCodeQueryParam( ) {
    // Return all LongCode objects as unmodifiable collection.
    return Collections.unmodifiableList(longCodeQueryParam);
  }

  /**
   * Method adds the passed object to {@link #longCodeQueryParam}.
   *
   * @param pLongCodeQueryParam Object that should be added to {@link #longCodeQueryParam}. The parameter must not be
   * null.
   */
  public void addToLongCodeQueryParam( LongCode pLongCodeQueryParam ) {
    // Check parameter "pLongCodeQueryParam" for invalid value null.
    Check.checkInvalidParameterNull(pLongCodeQueryParam, "pLongCodeQueryParam");
    // Add passed object to collection of associated LongCode objects.
    longCodeQueryParam.add(pLongCodeQueryParam);
  }

  /**
   * Method adds all passed objects to {@link #longCodeQueryParam}.
   *
   * @param pLongCodeQueryParam Collection with all objects that should be added to {@link #longCodeQueryParam}. The
   * parameter must not be null.
   */
  public void addToLongCodeQueryParam( Collection<LongCode> pLongCodeQueryParam ) {
    // Check parameter "pLongCodeQueryParam" for invalid value null.
    Check.checkInvalidParameterNull(pLongCodeQueryParam, "pLongCodeQueryParam");
    // Add all passed objects.
    for (LongCode lNextObject : pLongCodeQueryParam) {
      this.addToLongCodeQueryParam(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #longCodeQueryParam}.<br/>
   *
   * @param pLongCodeQueryParam Object that should be removed from {@link #longCodeQueryParam}. The parameter must not
   * be null.
   */
  public void removeFromLongCodeQueryParam( LongCode pLongCodeQueryParam ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLongCodeQueryParam, "pLongCodeQueryParam");
    // Remove passed object from collection of associated LongCode objects.
    longCodeQueryParam.remove(pLongCodeQueryParam);
  }

  /**
   * Method removes all objects from {@link #longCodeQueryParam}.
   */
  public void clearLongCodeQueryParam( ) {
    // Remove all objects from association "longCodeQueryParam".
    longCodeQueryParam.clear();
  }

  public int getLongCodeQueryParamXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.LongCode"
    return longCodeQueryParamXYZ;
  }

  public void setLongCodeQueryParamXYZ( int value ) {
    longCodeQueryParamXYZ = value;
  }

  /**
   * Method returns association {@link #literals}.<br/>
   * so many literals are possible
   *
   * @return {@link List<BooleanLiteralsEnum>} Value to which {@link #literals} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<BooleanLiteralsEnum> getLiterals( ) {
    // Return all BooleanLiteralsEnum objects as unmodifiable collection.
    return Collections.unmodifiableList(literals);
  }

  /**
   * Method adds the passed object to {@link #literals}.
   *
   * @param pLiterals Object that should be added to {@link #literals}. The parameter must not be null.
   */
  public void addToLiterals( BooleanLiteralsEnum pLiterals ) {
    // Check parameter "pLiterals" for invalid value null.
    Check.checkInvalidParameterNull(pLiterals, "pLiterals");
    // Add passed object to collection of associated BooleanLiteralsEnum objects.
    literals.add(pLiterals);
  }

  /**
   * Method adds all passed objects to {@link #literals}.
   *
   * @param pLiterals Collection with all objects that should be added to {@link #literals}. The parameter must not be
   * null.
   */
  public void addToLiterals( Collection<BooleanLiteralsEnum> pLiterals ) {
    // Check parameter "pLiterals" for invalid value null.
    Check.checkInvalidParameterNull(pLiterals, "pLiterals");
    // Add all passed objects.
    for (BooleanLiteralsEnum lNextObject : pLiterals) {
      this.addToLiterals(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #literals}.<br/>
   *
   * @param pLiterals Object that should be removed from {@link #literals}. The parameter must not be null.
   */
  public void removeFromLiterals( BooleanLiteralsEnum pLiterals ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLiterals, "pLiterals");
    // Remove passed object from collection of associated BooleanLiteralsEnum objects.
    literals.remove(pLiterals);
  }

  /**
   * Method removes all objects from {@link #literals}.
   */
  public void clearLiterals( ) {
    // Remove all objects from association "literals".
    literals.clear();
  }

  public int getLiteralsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum"
    return literalsXYZ;
  }

  public void setLiteralsXYZ( int value ) {
    literalsXYZ = value;
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

  public int getStringPropertyXYZ( ) {
    // "String"
    return stringPropertyXYZ;
  }

  public void setStringPropertyXYZ( int value ) {
    stringPropertyXYZ = value;
  }

  /**
   * Method returns attribute {@link #longValues}.<br/>
   * long values as multivalued header
   *
   * @return long Value to which {@link #longValues} is set.
   */
  public long[] getLongValues( ) {
    long[] lReturnValue;
    if (longValues != null) {
      lReturnValue = new long[longValues.length];
      System.arraycopy(longValues, 0, lReturnValue, 0, longValues.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #longValues}.<br/>
   * long values as multivalued header
   *
   * @param pLongValues Value to which {@link #longValues} should be set.
   */
  public void setLongValues( long[] pLongValues ) {
    // Assign value to attribute
    if (pLongValues != null) {
      longValues = new long[pLongValues.length];
      System.arraycopy(pLongValues, 0, longValues, 0, pLongValues.length);
    }
    else {
      longValues = null;
    }
  }

  public int getLongValuesXYZ( ) {
    // "long"
    return longValuesXYZ;
  }

  public void setLongValuesXYZ( int value ) {
    longValuesXYZ = value;
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
    lBuilder.append("stringProperty: ");
    lBuilder.append(stringProperty);
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
   * @return {@link Builder} New builder that can be used to create new MultiValuedDataType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
