/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeTypeUsageTest implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanCode".
   */
  public static final String BOOLEANCODE = "booleanCode";

  /**
   * Constant for the name of attribute "booleanCodeAssociation".
   */
  public static final String BOOLEANCODEASSOCIATION = "booleanCodeAssociation";

  /**
   * Constant for the name of attribute "shortCodeTypeAssociation".
   */
  public static final String SHORTCODETYPEASSOCIATION = "shortCodeTypeAssociation";

  /**
   * Constant for the name of attribute "stringCode".
   */
  public static final String STRINGCODE = "stringCode";

  /**
   * Constant for the name of attribute "characterCode".
   */
  public static final String CHARACTERCODE = "characterCode";

  private BooleanCodeType booleanCode;

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<BooleanCodeType> booleanCodeAssociation;

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<ShortCodeType> shortCodeTypeAssociation;

  private StringCodeType stringCode;

  private CharacterCode characterCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
    characterCode = pBuilder.characterCode;
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BooleanCodeType pBooleanCode, StringCodeType pStringCode ) {
    Builder lBuilder = builder();
    lBuilder.setBooleanCode(pBooleanCode);
    lBuilder.setStringCode(pStringCode);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class CodeTypeUsageTest.
   *
   *
   * @param pBooleanCode Value to which {@link #booleanCode} should be set.
   *
   * @param pShortCodeTypeAssociation Value to which {@link #shortCodeTypeAssociation} should be set.
   *
   * @param pStringCode Value to which {@link #stringCode} should be set.
   *
   * @return {@link com.anaptecs.spring.base.CodeTypeUsageTest}
   */
  public static CodeTypeUsageTest of( BooleanCodeType pBooleanCode, Set<ShortCodeType> pShortCodeTypeAssociation,
      StringCodeType pStringCode ) {
    CodeTypeUsageTest.Builder lBuilder = CodeTypeUsageTest.builder();
    lBuilder.setBooleanCode(pBooleanCode);
    lBuilder.setShortCodeTypeAssociation(pShortCodeTypeAssociation);
    lBuilder.setStringCode(pStringCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>CodeTypeUsageTest</code>.
   */
  public static class Builder {
    private BooleanCodeType booleanCode;

    private Set<BooleanCodeType> booleanCodeAssociation;

    private Set<ShortCodeType> shortCodeTypeAssociation;

    private StringCodeType stringCode;

    private CharacterCode characterCode;

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
        this.setBooleanCode(pObject.booleanCode);
        this.setBooleanCodeAssociation(pObject.booleanCodeAssociation);
        this.setShortCodeTypeAssociation(pObject.shortCodeTypeAssociation);
        this.setStringCode(pObject.stringCode);
        this.setCharacterCode(pObject.characterCode);
      }
    }

    /**
     * Method sets attribute {@link #booleanCode}.<br/>
     *
     * @param pBooleanCode Value to which {@link #booleanCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooleanCode( BooleanCodeType pBooleanCode ) {
      // Assign value to attribute
      booleanCode = pBooleanCode;
      return this;
    }

    /**
     * Method sets association {@link #booleanCodeAssociation}.<br/>
     *
     * @param pBooleanCodeAssociation Collection to which {@link #booleanCodeAssociation} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #booleanCodeAssociation}.<br/>
     *
     * @param pBooleanCodeAssociation Array of objects that should be added to {@link #booleanCodeAssociation}. The
     * parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBooleanCodeAssociation( BooleanCodeType... pBooleanCodeAssociation ) {
      if (pBooleanCodeAssociation != null) {
        if (booleanCodeAssociation == null) {
          booleanCodeAssociation = new HashSet<BooleanCodeType>();
        }
        booleanCodeAssociation.addAll(Arrays.asList(pBooleanCodeAssociation));
      }
      return this;
    }

    /**
     * Method sets association {@link #shortCodeTypeAssociation}.<br/>
     *
     * @param pShortCodeTypeAssociation Collection to which {@link #shortCodeTypeAssociation} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #shortCodeTypeAssociation}.<br/>
     *
     * @param pShortCodeTypeAssociation Array of objects that should be added to {@link #shortCodeTypeAssociation}. The
     * parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToShortCodeTypeAssociation( ShortCodeType... pShortCodeTypeAssociation ) {
      if (pShortCodeTypeAssociation != null) {
        if (shortCodeTypeAssociation == null) {
          shortCodeTypeAssociation = new HashSet<ShortCodeType>();
        }
        shortCodeTypeAssociation.addAll(Arrays.asList(pShortCodeTypeAssociation));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #stringCode}.<br/>
     *
     * @param pStringCode Value to which {@link #stringCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStringCode( StringCodeType pStringCode ) {
      // Assign value to attribute
      stringCode = pStringCode;
      return this;
    }

    /**
     * Method sets association {@link #characterCode}.<br/>
     *
     * @param pCharacterCode Value to which {@link #characterCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCharacterCode( CharacterCode pCharacterCode ) {
      characterCode = pCharacterCode;
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
      CodeTypeUsageTest lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #booleanCode}.<br/>
   *
   * @return {@link BooleanCodeType} Value to which {@link #booleanCode} is set.
   */
  public BooleanCodeType getBooleanCode( ) {
    return booleanCode;
  }

  /**
   * Method sets attribute {@link #booleanCode}.<br/>
   *
   * @param pBooleanCode Value to which {@link #booleanCode} should be set.
   */
  public void setBooleanCode( BooleanCodeType pBooleanCode ) {
    // Assign value to attribute
    booleanCode = pBooleanCode;
  }

  /**
   * Method returns association {@link #booleanCodeAssociation}.<br/>
   *
   * @return {@link Set<BooleanCodeType>} Value to which {@link #booleanCodeAssociation} is set. The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<BooleanCodeType> getBooleanCodeAssociation( ) {
    // Return all BooleanCodeType objects as unmodifiable collection.
    return Collections.unmodifiableSet(booleanCodeAssociation);
  }

  /**
   * Method adds the passed object to {@link #booleanCodeAssociation}.
   *
   * @param pBooleanCodeAssociation Object that should be added to {@link #booleanCodeAssociation}. The parameter must
   * not be null.
   */
  public void addToBooleanCodeAssociation( BooleanCodeType pBooleanCodeAssociation ) {
    // Check parameter "pBooleanCodeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanCodeAssociation, "pBooleanCodeAssociation");
    // Add passed object to collection of associated BooleanCodeType objects.
    booleanCodeAssociation.add(pBooleanCodeAssociation);
  }

  /**
   * Method adds all passed objects to {@link #booleanCodeAssociation}.
   *
   * @param pBooleanCodeAssociation Collection with all objects that should be added to {@link #booleanCodeAssociation}.
   * The parameter must not be null.
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
   * Method removes the passed object from {@link #booleanCodeAssociation}.<br/>
   *
   * @param pBooleanCodeAssociation Object that should be removed from {@link #booleanCodeAssociation}. The parameter
   * must not be null.
   */
  public void removeFromBooleanCodeAssociation( BooleanCodeType pBooleanCodeAssociation ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBooleanCodeAssociation, "pBooleanCodeAssociation");
    // Remove passed object from collection of associated BooleanCodeType objects.
    booleanCodeAssociation.remove(pBooleanCodeAssociation);
  }

  /**
   * Method removes all objects from {@link #booleanCodeAssociation}.
   */
  public void clearBooleanCodeAssociation( ) {
    // Remove all objects from association "booleanCodeAssociation".
    booleanCodeAssociation.clear();
  }

  /**
   * Method returns association {@link #shortCodeTypeAssociation}.<br/>
   *
   * @return {@link Set<ShortCodeType>} Value to which {@link #shortCodeTypeAssociation} is set. The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<ShortCodeType> getShortCodeTypeAssociation( ) {
    // Return all ShortCodeType objects as unmodifiable collection.
    return Collections.unmodifiableSet(shortCodeTypeAssociation);
  }

  /**
   * Method adds the passed object to {@link #shortCodeTypeAssociation}.
   *
   * @param pShortCodeTypeAssociation Object that should be added to {@link #shortCodeTypeAssociation}. The parameter
   * must not be null.
   */
  public void addToShortCodeTypeAssociation( ShortCodeType pShortCodeTypeAssociation ) {
    // Check parameter "pShortCodeTypeAssociation" for invalid value null.
    Check.checkInvalidParameterNull(pShortCodeTypeAssociation, "pShortCodeTypeAssociation");
    // Add passed object to collection of associated ShortCodeType objects.
    shortCodeTypeAssociation.add(pShortCodeTypeAssociation);
  }

  /**
   * Method adds all passed objects to {@link #shortCodeTypeAssociation}.
   *
   * @param pShortCodeTypeAssociation Collection with all objects that should be added to
   * {@link #shortCodeTypeAssociation}. The parameter must not be null.
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
   * Method removes the passed object from {@link #shortCodeTypeAssociation}.<br/>
   *
   * @param pShortCodeTypeAssociation Object that should be removed from {@link #shortCodeTypeAssociation}. The
   * parameter must not be null.
   */
  public void removeFromShortCodeTypeAssociation( ShortCodeType pShortCodeTypeAssociation ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pShortCodeTypeAssociation, "pShortCodeTypeAssociation");
    // Remove passed object from collection of associated ShortCodeType objects.
    shortCodeTypeAssociation.remove(pShortCodeTypeAssociation);
  }

  /**
   * Method removes all objects from {@link #shortCodeTypeAssociation}.
   */
  public void clearShortCodeTypeAssociation( ) {
    // Remove all objects from association "shortCodeTypeAssociation".
    shortCodeTypeAssociation.clear();
  }

  /**
   * Method returns attribute {@link #stringCode}.<br/>
   *
   * @return {@link StringCodeType} Value to which {@link #stringCode} is set.
   */
  public StringCodeType getStringCode( ) {
    return stringCode;
  }

  /**
   * Method sets attribute {@link #stringCode}.<br/>
   *
   * @param pStringCode Value to which {@link #stringCode} should be set.
   */
  public void setStringCode( StringCodeType pStringCode ) {
    // Assign value to attribute
    stringCode = pStringCode;
  }

  /**
   * Method returns association {@link #characterCode}.<br/>
   *
   * @return {@link CharacterCode} Value to which {@link #characterCode} is set.
   */
  public CharacterCode getCharacterCode( ) {
    return characterCode;
  }

  /**
   * Method sets association {@link #characterCode}.<br/>
   *
   * @param pCharacterCode Value to which {@link #characterCode} should be set.
   */
  public void setCharacterCode( CharacterCode pCharacterCode ) {
    characterCode = pCharacterCode;
  }

  /**
   * Method unsets {@link #characterCode}.
   */
  public final void unsetCharacterCode( ) {
    characterCode = null;
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
    lBuilder.append("stringCode: ");
    lBuilder.append(stringCode);
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
   * @return {@link Builder} New builder that can be used to create new CodeTypeUsageTest objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}