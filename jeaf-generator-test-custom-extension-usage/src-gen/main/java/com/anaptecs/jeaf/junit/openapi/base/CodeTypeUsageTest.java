/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class CodeTypeUsageTest extends Object implements ServiceObject {
  /**
   * Default serial version uid.
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
   * Constant for the name of attribute "shortCode".
   */
  public static final String SHORTCODE = "shortCode";

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
  @ClassPropertyDeclaration
  private BooleanCodeType booleanCode;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
  private int booleanCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
  @ClassPropertyDeclaration
  private Set<BooleanCodeType> booleanCodeAssociation;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
  private int booleanCodeAssociationXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
  @ClassPropertyDeclaration
  @Valid
  private Set<ShortCodeType> shortCodeTypeAssociation;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
  private int shortCodeTypeAssociationXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
  @ClassPropertyDeclaration
  private StringCodeType stringCode;

  // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
  private int stringCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
  @ClassPropertyDeclaration
  private ShortCode shortCode;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
  private int shortCodeXYZ = 0;

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
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    booleanCodeXYZ = pBuilder.booleanCodeXYZ;
    if (pBuilder.booleanCodeAssociation != null) {
      booleanCodeAssociation = pBuilder.booleanCodeAssociation;
    }
    else {
      booleanCodeAssociation = new HashSet<BooleanCodeType>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    booleanCodeAssociationXYZ = pBuilder.booleanCodeAssociationXYZ;
    if (pBuilder.shortCodeTypeAssociation != null) {
      shortCodeTypeAssociation = pBuilder.shortCodeTypeAssociation;
    }
    else {
      shortCodeTypeAssociation = new HashSet<ShortCodeType>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
    shortCodeTypeAssociationXYZ = pBuilder.shortCodeTypeAssociationXYZ;
    stringCode = pBuilder.stringCode;
    // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
    stringCodeXYZ = pBuilder.stringCodeXYZ;
    shortCode = pBuilder.shortCode;
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    shortCodeXYZ = pBuilder.shortCodeXYZ;
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
   * Class implements builder to create a new instance of class <code>CodeTypeUsageTest</code>.
   */
  public static class Builder {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    @BuilderPropertyDeclaration
    private BooleanCodeType booleanCode;

    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    private int booleanCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    @BuilderPropertyDeclaration
    private Set<BooleanCodeType> booleanCodeAssociation;

    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    private int booleanCodeAssociationXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
    @BuilderPropertyDeclaration
    private Set<ShortCodeType> shortCodeTypeAssociation;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
    private int shortCodeTypeAssociationXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
    @BuilderPropertyDeclaration
    private StringCodeType stringCode;

    // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
    private int stringCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    @BuilderPropertyDeclaration
    private ShortCode shortCode;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    private int shortCodeXYZ = 0;

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
        this.setShortCode(pObject.shortCode);
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

    public Builder setBooleanCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
      booleanCodeXYZ = value;
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

    public Builder setBooleanCodeAssociationXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
      booleanCodeAssociationXYZ = value;
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

    public Builder setShortCodeTypeAssociationXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
      shortCodeTypeAssociationXYZ = value;
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

    public Builder setStringCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
      stringCodeXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #shortCode}.<br/>
     *
     * @param pShortCode Value to which {@link #shortCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setShortCode( ShortCode pShortCode ) {
      shortCode = pShortCode;
      return this;
    }

    public Builder setShortCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
      shortCodeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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

  public int getBooleanCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    return booleanCodeXYZ;
  }

  public void setBooleanCodeXYZ( int value ) {
    booleanCodeXYZ = value;
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

  public int getBooleanCodeAssociationXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCodeType"
    return booleanCodeAssociationXYZ;
  }

  public void setBooleanCodeAssociationXYZ( int value ) {
    booleanCodeAssociationXYZ = value;
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

  public int getShortCodeTypeAssociationXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCodeType"
    return shortCodeTypeAssociationXYZ;
  }

  public void setShortCodeTypeAssociationXYZ( int value ) {
    shortCodeTypeAssociationXYZ = value;
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

  public int getStringCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.StringCodeType"
    return stringCodeXYZ;
  }

  public void setStringCodeXYZ( int value ) {
    stringCodeXYZ = value;
  }

  /**
   * Method returns association {@link #shortCode}.<br/>
   *
   * @return {@link ShortCode} Value to which {@link #shortCode} is set.
   */
  public ShortCode getShortCode( ) {
    return shortCode;
  }

  /**
   * Method sets association {@link #shortCode}.<br/>
   *
   * @param pShortCode Value to which {@link #shortCode} should be set.
   */
  public void setShortCode( ShortCode pShortCode ) {
    shortCode = pShortCode;
  }

  /**
   * Method unsets {@link #shortCode}.
   */
  public final void unsetShortCode( ) {
    shortCode = null;
  }

  public int getShortCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    return shortCodeXYZ;
  }

  public void setShortCodeXYZ( int value ) {
    shortCodeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
