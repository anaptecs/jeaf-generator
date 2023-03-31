/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 * @deprecated Please do not use this class any longer. There are better alternatives but I do not tell you which ones.
 * (<b>since:</b> 0.5, <b>removed with:</b> 2.0)
 */
@Valid
@Deprecated
public class ChildAA extends ChildA {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Multi<br/>
   * line<br/>
   * docs
   */
  private byte childAAAttribute;

  @Size(min = 10, max = 100)
  private int[] sizedArray;

  @Size(min = 1)
  private String[] requiredArray;

  @NotNull
  private BigIntegerCode bigIntegerCode;

  private IntegerCodeType integerCode;

  private IntegerCode[] codes;

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
    sizedArray = pBuilder.sizedArray;
    requiredArray = pBuilder.requiredArray;
    bigIntegerCode = pBuilder.bigIntegerCode;
    integerCode = pBuilder.integerCode;
    codes = pBuilder.codes;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ChildAA objects. The method never returns null.
   */
  public static Builder builder( ChildAA pObject ) {
    return new Builder(pObject);
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
    private byte childAAAttribute;

    @Size(min = 10, max = 100)
    private int[] sizedArray;

    private String[] requiredArray;

    private BigIntegerCode bigIntegerCode;

    private IntegerCodeType integerCode;

    private IntegerCode[] codes;

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
        childAAAttribute = pObject.childAAAttribute;
        sizedArray = pObject.sizedArray;
        requiredArray = pObject.requiredArray;
        bigIntegerCode = pObject.bigIntegerCode;
        integerCode = pObject.integerCode;
        codes = pObject.codes;
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

    /**
     * Method sets attribute {@link #sizedArray}.<br/>
     *
     * @param pSizedArray Value to which {@link #sizedArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSizedArray( int[] pSizedArray ) {
      // Assign value to attribute
      if (pSizedArray != null) {
        sizedArray = pSizedArray;
      }
      else {
        sizedArray = null;
      }
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
        requiredArray = pRequiredArray;
      }
      else {
        requiredArray = null;
      }
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

    /**
     * Method sets attribute {@link #codes}.<br/>
     *
     * @param pCodes Collection to which {@link #codes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCodes( IntegerCode[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = pCodes;
      }
      else {
        codes = null;
      }
      return this;
    }

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

  /**
   * Method returns attribute {@link #sizedArray}.<br/>
   *
   * @return int Value to which {@link #sizedArray} is set.
   */
  public int[] getSizedArray( ) {
    int[] lReturnValue;
    if (sizedArray != null) {
      lReturnValue = sizedArray;
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
      sizedArray = pSizedArray;
    }
    else {
      sizedArray = null;
    }
  }

  /**
   * Method returns attribute {@link #requiredArray}.<br/>
   *
   * @return {@link String} Value to which {@link #requiredArray} is set.
   */
  public String[] getRequiredArray( ) {
    String[] lReturnValue;
    if (requiredArray != null) {
      lReturnValue = requiredArray;
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
      requiredArray = pRequiredArray;
    }
    else {
      requiredArray = null;
    }
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

  /**
   * Method returns attribute {@link #codes}.<br/>
   *
   * @return {@link IntegerCode} Value to which {@link #codes} is set.
   */
  public IntegerCode[] getCodes( ) {
    IntegerCode[] lReturnValue;
    if (codes != null) {
      lReturnValue = codes;
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
      codes = pCodes;
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childAAAttribute: ");
    lBuilder.append(childAAAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sizedArray: ");
    if (sizedArray != null) {
      lBuilder.append(Arrays.toString(sizedArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("requiredArray: ");
    if (requiredArray != null) {
      lBuilder.append(Arrays.toString(requiredArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bigIntegerCode: ");
    lBuilder.append(bigIntegerCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("integerCode: ");
    if (integerCode != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(integerCode.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("codes: ");
    if (codes != null) {
      lBuilder.append(Arrays.toString(codes));
    }
    else {
      lBuilder.append(" null");
    }
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
