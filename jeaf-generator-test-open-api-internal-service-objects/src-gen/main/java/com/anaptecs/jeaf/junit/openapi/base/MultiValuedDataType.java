/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class MultiValuedDataType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * This is my multivalued test header
   */
  @HeaderParam("stringCodeHeader")
  private List<StringCode> stringCodeHeader;

  /**
   * Multivalued query param
   */
  @QueryParam("longCodeQueryParam")
  private List<LongCode> longCodeQueryParam;

  /**
   * so many literals are possible
   */
  @QueryParam("literals")
  @Size(min = 1)
  @NotNull
  private List<BooleanLiteralsEnum> literals;

  @QueryParam("stringProperty")
  @Size(min = 32, max = 64)
  @NotNull
  private String stringProperty;

  /**
   * long values as multivalued header
   */
  @HeaderParam("longValues")
  @Min(value = 3270)
  @Max(value = 4711)
  private long longValues;

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
    if (pBuilder.longCodeQueryParam != null) {
      longCodeQueryParam = pBuilder.longCodeQueryParam;
    }
    else {
      longCodeQueryParam = new ArrayList<LongCode>();
    }
    if (pBuilder.literals != null) {
      literals = pBuilder.literals;
    }
    else {
      literals = new ArrayList<BooleanLiteralsEnum>();
    }
    stringProperty = pBuilder.stringProperty;
    longValues = pBuilder.longValues;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MultiValuedDataType objects. The method never
   * returns null.
   */
  public static Builder builder( MultiValuedDataType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pStringProperty, long pLongValues ) {
    Builder lBuilder = builder();
    lBuilder.setStringProperty(pStringProperty);
    lBuilder.setLongValues(pLongValues);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class MultiValuedDataType. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * This is my multivalued test header
     */
    private List<StringCode> stringCodeHeader;

    /**
     * Multivalued query param
     */
    private List<LongCode> longCodeQueryParam;

    /**
     * so many literals are possible
     */
    private List<BooleanLiteralsEnum> literals;

    /**
     * 
     */
    @Size(min = 32, max = 64)
    private String stringProperty;

    /**
     * long values as multivalued header
     */
    @Min(value = 3270)
    @Max(value = 4711)
    private long longValues;

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
        stringCodeHeader = pObject.stringCodeHeader;
        longCodeQueryParam = pObject.longCodeQueryParam;
        literals = pObject.literals;
        stringProperty = pObject.stringProperty;
        longValues = pObject.longValues;
      }
    }

    /**
     * Method sets the association "stringCodeHeader". This is my multivalued test header
     * 
     * @param pStringCodeHeader Collection with objects to which the association should be set.
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
     * Method sets the association "longCodeQueryParam". Multivalued query param
     * 
     * @param pLongCodeQueryParam Collection with objects to which the association should be set.
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
     * Method sets the association "literals". so many literals are possible
     * 
     * @param pLiterals Collection with objects to which the association should be set.
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
     * Method sets the association "literals". so many literals are possible
     * 
     * @param pLiterals Array with objects to which the association should be set.
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

    /**
     * Method sets the attribute "stringProperty".
     * 
     * @param pStringProperty Value to which the attribute "stringProperty" should be set.
     */
    public Builder setStringProperty( String pStringProperty ) {
      // Assign value to attribute
      stringProperty = pStringProperty;
      return this;
    }

    /**
     * Method sets the attribute "longValues". long values as multivalued header
     * 
     * @param pLongValues Value to which the attribute "longValues" should be set.
     */
    public Builder setLongValues( long pLongValues ) {
      // Assign value to attribute
      longValues = pLongValues;
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
      MultiValuedDataType lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "stringCodeHeader". This is my multivalued test header
   *
   * @return Collection All StringCode objects that belong to the association "stringCodeHeader". The method never
   * returns null and the returned collection is modifiable.
   */
  public List<StringCode> getStringCodeHeader( ) {
    // Return all StringCode objects directly without any protection against modification.
    return stringCodeHeader;
  }

  /**
   * Method adds the passed StringCode object to the association "stringCodeHeader". This is my multivalued test header
   * 
   * @param pStringCodeHeader Object that should be added to the association "stringCodeHeader". The parameter must not
   * be null.
   */
  public void addToStringCodeHeader( StringCode pStringCodeHeader ) {
    // Check parameter "pStringCodeHeader" for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeHeader, "pStringCodeHeader");
    // Add passed object to collection of associated StringCode objects.
    stringCodeHeader.add(pStringCodeHeader);
  }

  /**
   * Method adds all passed objects to the association "stringCodeHeader". This is my multivalued test header
   * 
   * @param pStringCodeHeader Collection with all objects that should be added to the association "stringCodeHeader".
   * The parameter must not be null.
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
   * Method removes the passed StringCode object from the association "stringCodeHeader". This is my multivalued test
   * header
   * 
   * @param pStringCodeHeader Object that should be removed from the association "stringCodeHeader". The parameter must
   * not be null.
   */
  public void removeFromStringCodeHeader( StringCode pStringCodeHeader ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeHeader, "pStringCodeHeader");
    // Remove passed object from collection of associated StringCode objects.
    stringCodeHeader.remove(pStringCodeHeader);
  }

  /**
   * Method removes all objects from the association "stringCodeHeader". This is my multivalued test header
   */
  public void clearStringCodeHeader( ) {
    // Remove all objects from association "stringCodeHeader".
    stringCodeHeader.clear();
  }

  /**
   * Method returns the association "longCodeQueryParam". Multivalued query param
   *
   * @return Collection All LongCode objects that belong to the association "longCodeQueryParam". The method never
   * returns null and the returned collection is modifiable.
   */
  public List<LongCode> getLongCodeQueryParam( ) {
    // Return all LongCode objects directly without any protection against modification.
    return longCodeQueryParam;
  }

  /**
   * Method adds the passed LongCode object to the association "longCodeQueryParam". Multivalued query param
   * 
   * @param pLongCodeQueryParam Object that should be added to the association "longCodeQueryParam". The parameter must
   * not be null.
   */
  public void addToLongCodeQueryParam( LongCode pLongCodeQueryParam ) {
    // Check parameter "pLongCodeQueryParam" for invalid value null.
    Check.checkInvalidParameterNull(pLongCodeQueryParam, "pLongCodeQueryParam");
    // Add passed object to collection of associated LongCode objects.
    longCodeQueryParam.add(pLongCodeQueryParam);
  }

  /**
   * Method adds all passed objects to the association "longCodeQueryParam". Multivalued query param
   * 
   * @param pLongCodeQueryParam Collection with all objects that should be added to the association
   * "longCodeQueryParam". The parameter must not be null.
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
   * Method removes the passed LongCode object from the association "longCodeQueryParam". Multivalued query param
   * 
   * @param pLongCodeQueryParam Object that should be removed from the association "longCodeQueryParam". The parameter
   * must not be null.
   */
  public void removeFromLongCodeQueryParam( LongCode pLongCodeQueryParam ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLongCodeQueryParam, "pLongCodeQueryParam");
    // Remove passed object from collection of associated LongCode objects.
    longCodeQueryParam.remove(pLongCodeQueryParam);
  }

  /**
   * Method removes all objects from the association "longCodeQueryParam". Multivalued query param
   */
  public void clearLongCodeQueryParam( ) {
    // Remove all objects from association "longCodeQueryParam".
    longCodeQueryParam.clear();
  }

  /**
   * Method returns the association "literals". so many literals are possible
   *
   * @return Collection All BooleanLiteralsEnum objects that belong to the association "literals". The method never
   * returns null and the returned collection is modifiable.
   */
  public List<BooleanLiteralsEnum> getLiterals( ) {
    // Return all BooleanLiteralsEnum objects directly without any protection against modification.
    return literals;
  }

  /**
   * Method adds the passed BooleanLiteralsEnum object to the association "literals". so many literals are possible
   * 
   * @param pLiterals Object that should be added to the association "literals". The parameter must not be null.
   */
  public void addToLiterals( BooleanLiteralsEnum pLiterals ) {
    // Check parameter "pLiterals" for invalid value null.
    Check.checkInvalidParameterNull(pLiterals, "pLiterals");
    // Add passed object to collection of associated BooleanLiteralsEnum objects.
    literals.add(pLiterals);
  }

  /**
   * Method adds all passed objects to the association "literals". so many literals are possible
   * 
   * @param pLiterals Collection with all objects that should be added to the association "literals". The parameter must
   * not be null.
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
   * Method removes the passed BooleanLiteralsEnum object from the association "literals". so many literals are possible
   * 
   * @param pLiterals Object that should be removed from the association "literals". The parameter must not be null.
   */
  public void removeFromLiterals( BooleanLiteralsEnum pLiterals ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLiterals, "pLiterals");
    // Remove passed object from collection of associated BooleanLiteralsEnum objects.
    literals.remove(pLiterals);
  }

  /**
   * Method removes all objects from the association "literals". so many literals are possible
   */
  public void clearLiterals( ) {
    // Remove all objects from association "literals".
    literals.clear();
  }

  /**
   * Method returns attribute {@link #stringProperty}.<br/>
   * 
   * @return String Value to which {@link #stringProperty} is set.
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
   * Method returns attribute {@link #longValues}.<br/>
   * long values as multivalued header
   * 
   * @return long Value to which {@link #longValues} is set.
   */
  public long getLongValues( ) {
    return longValues;
  }

  /**
   * Method sets attribute {@link #longValues}.<br/>
   * long values as multivalued header
   * 
   * @param pLongValues Value to which {@link #longValues} should be set.
   */
  public void setLongValues( long pLongValues ) {
    // Assign value to attribute
    longValues = pLongValues;
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
    lBuilder.append("stringCodeHeader: ");
    if (stringCodeHeader != null) {
      lBuilder.append(stringCodeHeader.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (stringCodeHeader != null) {
      for (StringCode lNext : stringCodeHeader) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("longCodeQueryParam: ");
    if (longCodeQueryParam != null) {
      lBuilder.append(longCodeQueryParam.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (longCodeQueryParam != null) {
      for (LongCode lNext : longCodeQueryParam) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("literals: ");
    if (literals != null) {
      lBuilder.append(literals.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (literals != null) {
      for (BooleanLiteralsEnum lNext : literals) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("stringProperty: ");
    lBuilder.append(stringProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("longValues: ");
    lBuilder.append(longValues);
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
