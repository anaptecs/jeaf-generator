/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 * @deprecated Please do not use this class any longer. There are better alternatives but I do not tell you which ones.
 * May be <code>java.lang.Nothing</code> (<b>since:</b> 0.5, <b>removed with:</b> 2.0)
 */
@Deprecated
public class ChildAA extends ChildA {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childAAAttribute".
   */
  public static final String CHILDAAATTRIBUTE = "childAAAttribute";

  /**
   * Constant for the name of attribute "sizedArray".
   */
  public static final String SIZEDARRAY = "sizedArray";

  /**
   * Constant for the name of attribute "requiredArray".
   */
  public static final String REQUIREDARRAY = "requiredArray";

  /**
   * Constant for the name of attribute "bigIntegerCode".
   */
  public static final String BIGINTEGERCODE = "bigIntegerCode";

  /**
   * Constant for the name of attribute "integerCode".
   */
  public static final String INTEGERCODE = "integerCode";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  // "byte"
  @ClassPropertyDeclaration
  /**
   * Multi<br/>
   * line<br/>
   * docs
   */
  private byte childAAAttribute;

  // "byte"
  private int childAAAttributeXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @Size(min = 10, max = 100)
  private int[] sizedArray;

  // "int"
  private int sizedArrayXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String[] requiredArray;

  // "String"
  private int requiredArrayXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
  @ClassPropertyDeclaration
  private BigIntegerCode bigIntegerCode;

  // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
  private int bigIntegerCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
  @ClassPropertyDeclaration
  private IntegerCodeType integerCode;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
  private int integerCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
  @ClassPropertyDeclaration
  private IntegerCode[] codes;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
  private int codesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildAA( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildAA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAAttribute = pBuilder.childAAAttribute;
    // "byte"
    childAAAttributeXYZ = pBuilder.childAAAttributeXYZ;
    sizedArray = pBuilder.sizedArray;
    // "int"
    sizedArrayXYZ = pBuilder.sizedArrayXYZ;
    requiredArray = pBuilder.requiredArray;
    // "String"
    requiredArrayXYZ = pBuilder.requiredArrayXYZ;
    bigIntegerCode = pBuilder.bigIntegerCode;
    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    bigIntegerCodeXYZ = pBuilder.bigIntegerCodeXYZ;
    integerCode = pBuilder.integerCode;
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    integerCodeXYZ = pBuilder.integerCodeXYZ;
    codes = pBuilder.codes;
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    codesXYZ = pBuilder.codesXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildAA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildAA</code>.
   */
  @Deprecated
  public static class Builder extends ChildA.Builder {
    /**
     * Multi<br/>
     * line<br/>
     * docs
     */
    // "byte"
    @BuilderPropertyDeclaration
    private byte childAAAttribute;

    // "byte"
    private int childAAAttributeXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @Size(min = 10, max = 100)
    private int[] sizedArray;

    // "int"
    private int sizedArrayXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String[] requiredArray;

    // "String"
    private int requiredArrayXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    @BuilderPropertyDeclaration
    private BigIntegerCode bigIntegerCode;

    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    private int bigIntegerCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    @BuilderPropertyDeclaration
    private IntegerCodeType integerCode;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    private int integerCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    @BuilderPropertyDeclaration
    private IntegerCode[] codes;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    private int codesXYZ = 0;

    /**
     * Use {@link ChildAA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildAA#builder(ChildAA)} instead of private constructor to create new builder.
     */
    protected Builder( ChildAA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAAAttribute(pObject.childAAAttribute);
        this.setSizedArray(pObject.sizedArray);
        this.setRequiredArray(pObject.requiredArray);
        this.setBigIntegerCode(pObject.bigIntegerCode);
        this.setIntegerCode(pObject.integerCode);
        this.setCodes(pObject.codes);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets association {@link #ibans}.<br/>
     *
     * @param pIbans Collection to which {@link #ibans} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setIbans( Set<IBAN> pIbans ) {
      // Call super class implementation.
      super.setIbans(pIbans);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #ibans}.<br/>
     *
     * @param pIbans Array of objects that should be added to {@link #ibans}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToIbans( IBAN... pIbans ) {
      // Call super class implementation.
      super.addToIbans(pIbans);
      return this;
    }

    /**
     * Method sets association {@link #theBankAccount}.<br/>
     *
     * @param pTheBankAccount Value to which {@link #theBankAccount} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @Override
    public Builder setTheBankAccount( BankAccount pTheBankAccount ) {
      // Call super class implementation.
      super.setTheBankAccount(pTheBankAccount);
      return this;
    }

    /**
     * Method sets association {@link #legacyBankAccounts}.<br/>
     *
     * @param pLegacyBankAccounts Collection to which {@link #legacyBankAccounts} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @Override
    public Builder setLegacyBankAccounts( List<BankAccount> pLegacyBankAccounts ) {
      // Call super class implementation.
      super.setLegacyBankAccounts(pLegacyBankAccounts);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #legacyBankAccounts}.<br/>
     *
     * @param pLegacyBankAccounts Array of objects that should be added to {@link #legacyBankAccounts}. The parameter
     * may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    public Builder addToLegacyBankAccounts( BankAccount... pLegacyBankAccounts ) {
      // Call super class implementation.
      super.addToLegacyBankAccounts(pLegacyBankAccounts);
      return this;
    }

    /**
     * Method sets attribute {@link #childAAttribute}.<br/>
     *
     * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setChildAAttribute( int pChildAAttribute ) {
      // Call super class implementation.
      super.setChildAAttribute(pChildAAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #childAAAttribute}.<br/>
     *
     * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildAAAttribute( byte pChildAAAttribute ) {
      // Assign value to attribute
      childAAAttribute = pChildAAAttribute;
      return this;
    }

    public Builder setChildAAAttributeXYZ( int value ) {
      // "byte"
      childAAAttributeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #sizedArray}.<br/>
     *
     * @param pSizedArray Value to which {@link #sizedArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSizedArray( int[] pSizedArray ) {
      // Assign value to attribute
      if (pSizedArray != null) {
        sizedArray = new int[pSizedArray.length];
        System.arraycopy(pSizedArray, 0, sizedArray, 0, pSizedArray.length);
      }
      else {
        sizedArray = null;
      }
      return this;
    }

    public Builder setSizedArrayXYZ( int value ) {
      // "int"
      sizedArrayXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #requiredArray}.<br/>
     *
     * @param pRequiredArray Collection to which {@link #requiredArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setRequiredArray( String[] pRequiredArray ) {
      // Assign value to attribute
      if (pRequiredArray != null) {
        requiredArray = new String[pRequiredArray.length];
        System.arraycopy(pRequiredArray, 0, requiredArray, 0, pRequiredArray.length);
      }
      else {
        requiredArray = null;
      }
      return this;
    }

    public Builder setRequiredArrayXYZ( int value ) {
      // "String"
      requiredArrayXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bigIntegerCode}.<br/>
     *
     * @param pBigIntegerCode Value to which {@link #bigIntegerCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBigIntegerCode( BigIntegerCode pBigIntegerCode ) {
      // Assign value to attribute
      bigIntegerCode = pBigIntegerCode;
      return this;
    }

    public Builder setBigIntegerCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
      bigIntegerCodeXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #integerCode}.<br/>
     *
     * @param pIntegerCode Value to which {@link #integerCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntegerCode( IntegerCodeType pIntegerCode ) {
      integerCode = pIntegerCode;
      return this;
    }

    public Builder setIntegerCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
      integerCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #codes}.<br/>
     *
     * @param pCodes Collection to which {@link #codes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCodes( IntegerCode[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new IntegerCode[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    public Builder setCodesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
      codesXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ChildAA. The object will be initialized with the values of the builder.
     *
     * @return ChildAA Created object. The method never returns null.
     */
    public ChildAA build( ) {
      return new ChildAA(this);
    }

    /**
     * Method creates a new validated instance of class ChildAA. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ChildAA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildAA buildValidated( ) throws ConstraintViolationException {
      ChildAA lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childAAAttribute}.<br/>
   * Multi<br/>
   * line<br/>
   * docs
   *
   * @return byte Value to which {@link #childAAAttribute} is set.
   */
  public byte getChildAAAttribute( ) {
    return childAAAttribute;
  }

  /**
   * Method sets attribute {@link #childAAAttribute}.<br/>
   * Multi<br/>
   * line<br/>
   * docs
   *
   * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
   */
  public void setChildAAAttribute( byte pChildAAAttribute ) {
    // Assign value to attribute
    childAAAttribute = pChildAAAttribute;
  }

  public int getChildAAAttributeXYZ( ) {
    // "byte"
    return childAAAttributeXYZ;
  }

  public void setChildAAAttributeXYZ( int value ) {
    childAAAttributeXYZ = value;
  }

  /**
   * Method returns attribute {@link #sizedArray}.<br/>
   *
   * @return int[] Value to which {@link #sizedArray} is set.
   */
  public int[] getSizedArray( ) {
    int[] lReturnValue;
    if (sizedArray != null) {
      lReturnValue = new int[sizedArray.length];
      System.arraycopy(sizedArray, 0, lReturnValue, 0, sizedArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #sizedArray}.<br/>
   *
   * @param pSizedArray Value to which {@link #sizedArray} should be set.
   */
  public void setSizedArray( int[] pSizedArray ) {
    // Assign value to attribute
    if (pSizedArray != null) {
      sizedArray = new int[pSizedArray.length];
      System.arraycopy(pSizedArray, 0, sizedArray, 0, pSizedArray.length);
    }
    else {
      sizedArray = null;
    }
  }

  public int getSizedArrayXYZ( ) {
    // "int"
    return sizedArrayXYZ;
  }

  public void setSizedArrayXYZ( int value ) {
    sizedArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #requiredArray}.<br/>
   *
   * @return {@link String[]} Value to which {@link #requiredArray} is set.
   */
  public String[] getRequiredArray( ) {
    String[] lReturnValue;
    if (requiredArray != null) {
      lReturnValue = new String[requiredArray.length];
      System.arraycopy(requiredArray, 0, lReturnValue, 0, requiredArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #requiredArray}.<br/>
   *
   * @param pRequiredArray Value to which {@link #requiredArray} should be set.
   */
  public void setRequiredArray( String[] pRequiredArray ) {
    // Assign value to attribute
    if (pRequiredArray != null) {
      requiredArray = new String[pRequiredArray.length];
      System.arraycopy(pRequiredArray, 0, requiredArray, 0, pRequiredArray.length);
    }
    else {
      requiredArray = null;
    }
  }

  public int getRequiredArrayXYZ( ) {
    // "String"
    return requiredArrayXYZ;
  }

  public void setRequiredArrayXYZ( int value ) {
    requiredArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bigIntegerCode}.<br/>
   *
   * @return {@link BigIntegerCode} Value to which {@link #bigIntegerCode} is set.
   */
  public BigIntegerCode getBigIntegerCode( ) {
    return bigIntegerCode;
  }

  /**
   * Method sets attribute {@link #bigIntegerCode}.<br/>
   *
   * @param pBigIntegerCode Value to which {@link #bigIntegerCode} should be set.
   */
  public void setBigIntegerCode( BigIntegerCode pBigIntegerCode ) {
    // Assign value to attribute
    bigIntegerCode = pBigIntegerCode;
  }

  public int getBigIntegerCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    return bigIntegerCodeXYZ;
  }

  public void setBigIntegerCodeXYZ( int value ) {
    bigIntegerCodeXYZ = value;
  }

  /**
   * Method returns association {@link #integerCode}.<br/>
   *
   * @return {@link IntegerCodeType} Value to which {@link #integerCode} is set.
   */
  public IntegerCodeType getIntegerCode( ) {
    return integerCode;
  }

  /**
   * Method sets association {@link #integerCode}.<br/>
   *
   * @param pIntegerCode Value to which {@link #integerCode} should be set.
   */
  public void setIntegerCode( IntegerCodeType pIntegerCode ) {
    integerCode = pIntegerCode;
  }

  /**
   * Method unsets {@link #integerCode}.
   */
  public final void unsetIntegerCode( ) {
    integerCode = null;
  }

  public int getIntegerCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType"
    return integerCodeXYZ;
  }

  public void setIntegerCodeXYZ( int value ) {
    integerCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #codes}.<br/>
   *
   * @return {@link IntegerCode[]} Value to which {@link #codes} is set.
   */
  public IntegerCode[] getCodes( ) {
    IntegerCode[] lReturnValue;
    if (codes != null) {
      lReturnValue = new IntegerCode[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #codes}.<br/>
   *
   * @param pCodes Value to which {@link #codes} should be set.
   */
  public void setCodes( IntegerCode[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new IntegerCode[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  public int getCodesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    return codesXYZ;
  }

  public void setCodesXYZ( int value ) {
    codesXYZ = value;
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
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childAAAttribute: ");
    lBuilder.append(childAAAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bigIntegerCode: ");
    lBuilder.append(bigIntegerCode);
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
   * @return {@link Builder} New builder that can be used to create new ChildAA objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
