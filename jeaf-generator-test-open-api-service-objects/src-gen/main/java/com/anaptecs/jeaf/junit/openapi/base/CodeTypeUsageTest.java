/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class CodeTypeUsageTest implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private BooleanCodeType booleanCode;

  /**
   * 
   */
  private Set<BooleanCodeType> booleanCodeAssociation;

  /**
   * 
   */
  @Size(min = 1)
  private Set<ShortCodeType> shortCodeTypeAssociation;

  /**
   * 
   */
  @NotNull
  private StringCodeType stringCode;

  /**
   * 
   */
  @NotNull
  private ShortCode shortCode;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected CodeTypeUsageTest( ) {
    booleanCodeAssociation = new HashSet<BooleanCodeType>();
    shortCodeTypeAssociation = new HashSet<ShortCodeType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CodeTypeUsageTest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanCode = pBuilder.booleanCode;
    if (pBuilder.booleanCodeAssociation != null) {
      booleanCodeAssociation = pBuilder.booleanCodeAssociation;
    }
    else {
      booleanCodeAssociation = new HashSet<BooleanCodeType>();
    }
    if (pBuilder.shortCodeTypeAssociation != null) {
      shortCodeTypeAssociation = pBuilder.shortCodeTypeAssociation;
    }
    else {
      shortCodeTypeAssociation = new HashSet<ShortCodeType>();
    }
    stringCode = pBuilder.stringCode;
    shortCode = pBuilder.shortCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new CodeTypeUsageTest objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new CodeTypeUsageTest objects. The method never
   * returns null.
   */
  public static Builder builder( CodeTypeUsageTest pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BooleanCodeType pBooleanCode, StringCodeType pStringCode, ShortCode pShortCode ) {
    Builder lBuilder = builder();
    lBuilder.setBooleanCode(pBooleanCode);
    lBuilder.setStringCode(pStringCode);
    lBuilder.setShortCode(pShortCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class CodeTypeUsageTest. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BooleanCodeType booleanCode;

    /**
     * 
     */
    private Set<BooleanCodeType> booleanCodeAssociation;

    /**
     * 
     */
    private Set<ShortCodeType> shortCodeTypeAssociation;

    /**
     * 
     */
    private StringCodeType stringCode;

    /**
     * 
     */
    private ShortCode shortCode;

    /**
     * Use {@link CodeTypeUsageTest#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CodeTypeUsageTest#builder(CodeTypeUsageTest)} instead of private constructor to create new builder.
     */
    protected Builder( CodeTypeUsageTest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        booleanCode = pObject.booleanCode;
        booleanCodeAssociation = pObject.booleanCodeAssociation;
        shortCodeTypeAssociation = pObject.shortCodeTypeAssociation;
        stringCode = pObject.stringCode;
        shortCode = pObject.shortCode;
      }
    }

    /**
     * Method sets the attribute "booleanCode".
     * 
     * @param pBooleanCode Value to which the attribute "booleanCode" should be set.
     */
    public Builder setBooleanCode( BooleanCodeType pBooleanCode ) {
      // Assign value to attribute
      booleanCode = pBooleanCode;
      return this;
    }

    /**
     * Method sets the association "booleanCodeAssociation".
     * 
     * @param pBooleanCodeAssociation Collection with objects to which the association should be set.
     */
    public Builder setBooleanCodeAssociation( Set<BooleanCodeType> pBooleanCodeAssociation ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBooleanCodeAssociation != null) {
        booleanCodeAssociation = new HashSet<BooleanCodeType>(pBooleanCodeAssociation);
      }
      else {
        booleanCodeAssociation = null;
      }
      return this;
    }

    /**
     * Method sets the association "shortCodeTypeAssociation".
     * 
     * @param pShortCodeTypeAssociation Collection with objects to which the association should be set.
     */
    public Builder setShortCodeTypeAssociation( Set<ShortCodeType> pShortCodeTypeAssociation ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pShortCodeTypeAssociation != null) {
        shortCodeTypeAssociation = new HashSet<ShortCodeType>(pShortCodeTypeAssociation);
      }
      else {
        shortCodeTypeAssociation = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "stringCode".
     * 
     * @param pStringCode Value to which the attribute "stringCode" should be set.
     */
    public Builder setStringCode( StringCodeType pStringCode ) {
      // Assign value to attribute
      stringCode = pStringCode;
      return this;
    }

    /**
     * Method sets the association "shortCode".
     * 
     * @param pShortCode ShortCode to which the association "shortCode" should be set.
     */
    public Builder setShortCode( ShortCode pShortCode ) {
      shortCode = pShortCode;
      return this;
    }

    /**
     * Method creates a new instance of class CodeTypeUsageTest. The object will be initialized with the values of the
     * builder.
     * 
     * @return CodeTypeUsageTest Created object. The method never returns null.
     */
    public CodeTypeUsageTest build( ) {
      return new CodeTypeUsageTest(this);
    }

    /**
     * Method creates a new validated instance of class CodeTypeUsageTest. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return CodeTypeUsageTest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CodeTypeUsageTest buildValidated( ) throws ConstraintViolationException {
      CodeTypeUsageTest lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "booleanCode".
   * 
   * 
   * @return BooleanCodeType Value to which the attribute "booleanCode" is set.
   */
  public BooleanCodeType getBooleanCode( ) {
    return booleanCode;
  }

  /**
   * Method sets the attribute "booleanCode".
   * 
   * 
   * @param pBooleanCode Value to which the attribute "booleanCode" should be set.
   */
  public void setBooleanCode( BooleanCodeType pBooleanCode ) {
    // Assign value to attribute
    booleanCode = pBooleanCode;
  }

  /**
   * Method returns the association "booleanCodeAssociation".
   * 
   *
   * @return Collection All BooleanCodeType objects that belong to the association "booleanCodeAssociation". The method
   * never returns null and the returned collection is modifiable.
   */
  public Set<BooleanCodeType> getBooleanCodeAssociation( ) {
    // Return all BooleanCodeType objects directly without any protection against modification.
    return booleanCodeAssociation;
  }

  /**
   * Method adds the passed BooleanCodeType object to the association "booleanCodeAssociation".
   * 
   * 
   * @param pBooleanCodeAssociation Object that should be added to the association "booleanCodeAssociation". The
   * parameter must not be null.
   */
  public void addToBooleanCodeAssociation( BooleanCodeType pBooleanCodeAssociation ) {
    // Check parameter "pBooleanCodeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanCodeAssociation, "pBooleanCodeAssociation");
    // Add passed object to collection of associated BooleanCodeType objects.
    booleanCodeAssociation.add(pBooleanCodeAssociation);
  }

  /**
   * Method adds all passed objects to the association "booleanCodeAssociation".
   * 
   * 
   * @param pBooleanCodeAssociation Collection with all objects that should be added to the association
   * "booleanCodeAssociation". The parameter must not be null.
   */
  public void addToBooleanCodeAssociation( Collection<BooleanCodeType> pBooleanCodeAssociation ) {
    // Check parameter "pBooleanCodeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanCodeAssociation, "pBooleanCodeAssociation");
    // Add all passed objects.
    for (BooleanCodeType lNextObject : pBooleanCodeAssociation) {
      this.addToBooleanCodeAssociation(lNextObject);
    }
  }

  /**
   * Method removes the passed BooleanCodeType object from the association "booleanCodeAssociation".
   * 
   * 
   * @param pBooleanCodeAssociation Object that should be removed from the association "booleanCodeAssociation". The
   * parameter must not be null.
   */
  public void removeFromBooleanCodeAssociation( BooleanCodeType pBooleanCodeAssociation ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBooleanCodeAssociation, "pBooleanCodeAssociation");
    // Remove passed object from collection of associated BooleanCodeType objects.
    booleanCodeAssociation.remove(pBooleanCodeAssociation);
  }

  /**
   * Method removes all objects from the association "booleanCodeAssociation".
   * 
   */
  public void clearBooleanCodeAssociation( ) {
    // Remove all objects from association "booleanCodeAssociation".
    booleanCodeAssociation.clear();
  }

  /**
   * Method returns the association "shortCodeTypeAssociation".
   * 
   *
   * @return Collection All ShortCodeType objects that belong to the association "shortCodeTypeAssociation". The method
   * never returns null and the returned collection is modifiable.
   */
  public Set<ShortCodeType> getShortCodeTypeAssociation( ) {
    // Return all ShortCodeType objects directly without any protection against modification.
    return shortCodeTypeAssociation;
  }

  /**
   * Method adds the passed ShortCodeType object to the association "shortCodeTypeAssociation".
   * 
   * 
   * @param pShortCodeTypeAssociation Object that should be added to the association "shortCodeTypeAssociation". The
   * parameter must not be null.
   */
  public void addToShortCodeTypeAssociation( ShortCodeType pShortCodeTypeAssociation ) {
    // Check parameter "pShortCodeTypeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pShortCodeTypeAssociation, "pShortCodeTypeAssociation");
    // Add passed object to collection of associated ShortCodeType objects.
    shortCodeTypeAssociation.add(pShortCodeTypeAssociation);
  }

  /**
   * Method adds all passed objects to the association "shortCodeTypeAssociation".
   * 
   * 
   * @param pShortCodeTypeAssociation Collection with all objects that should be added to the association
   * "shortCodeTypeAssociation". The parameter must not be null.
   */
  public void addToShortCodeTypeAssociation( Collection<ShortCodeType> pShortCodeTypeAssociation ) {
    // Check parameter "pShortCodeTypeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pShortCodeTypeAssociation, "pShortCodeTypeAssociation");
    // Add all passed objects.
    for (ShortCodeType lNextObject : pShortCodeTypeAssociation) {
      this.addToShortCodeTypeAssociation(lNextObject);
    }
  }

  /**
   * Method removes the passed ShortCodeType object from the association "shortCodeTypeAssociation".
   * 
   * 
   * @param pShortCodeTypeAssociation Object that should be removed from the association "shortCodeTypeAssociation". The
   * parameter must not be null.
   */
  public void removeFromShortCodeTypeAssociation( ShortCodeType pShortCodeTypeAssociation ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pShortCodeTypeAssociation, "pShortCodeTypeAssociation");
    // Remove passed object from collection of associated ShortCodeType objects.
    shortCodeTypeAssociation.remove(pShortCodeTypeAssociation);
  }

  /**
   * Method removes all objects from the association "shortCodeTypeAssociation".
   * 
   */
  public void clearShortCodeTypeAssociation( ) {
    // Remove all objects from association "shortCodeTypeAssociation".
    shortCodeTypeAssociation.clear();
  }

  /**
   * Method returns the attribute "stringCode".
   * 
   * 
   * @return StringCodeType Value to which the attribute "stringCode" is set.
   */
  public StringCodeType getStringCode( ) {
    return stringCode;
  }

  /**
   * Method sets the attribute "stringCode".
   * 
   * 
   * @param pStringCode Value to which the attribute "stringCode" should be set.
   */
  public void setStringCode( StringCodeType pStringCode ) {
    // Assign value to attribute
    stringCode = pStringCode;
  }

  /**
   * Method returns the association "shortCode".
   * 
   *
   * @return ShortCode ShortCode to which the association "shortCode" is set.
   */
  public ShortCode getShortCode( ) {
    return shortCode;
  }

  /**
   * Method sets the association "shortCode".
   * 
   * 
   * @param pShortCode ShortCode to which the association "shortCode" should be set.
   */
  public void setShortCode( ShortCode pShortCode ) {
    shortCode = pShortCode;
  }

  /**
   * Method unsets the association "shortCode".
   * 
   */
  public final void unsetShortCode( ) {
    shortCode = null;
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
    lBuilder.append("booleanCode: ");
    lBuilder.append(booleanCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("booleanCodeAssociation: ");
    if (booleanCodeAssociation != null) {
      lBuilder.append(booleanCodeAssociation.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (booleanCodeAssociation != null) {
      for (BooleanCodeType lNext : booleanCodeAssociation) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("shortCodeTypeAssociation: ");
    if (shortCodeTypeAssociation != null) {
      lBuilder.append(shortCodeTypeAssociation.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (shortCodeTypeAssociation != null) {
      for (ShortCodeType lNext : shortCodeTypeAssociation) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("stringCode: ");
    lBuilder.append(stringCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("shortCode: ");
    if (shortCode != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(shortCode.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
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
