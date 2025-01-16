/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
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

  /**
   * Multi<br/>
   * line<br/>
   * docs
   */
  private byte childAAAttribute;

  @Size(min = 10, max = 100)
  private int[] sizedArray;

  private Set<String> requiredArray;

  private BigIntegerCode bigIntegerCode;

  private IntegerCodeType integerCode;

  private Set<IntegerCode> codes;

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
   * Convenience method to create new instance of class ChildAA.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
   *
   * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
   *
   * @param pRequiredArray Value to which {@link #requiredArray} should be set.
   *
   * @param pBigIntegerCode Value to which {@link #bigIntegerCode} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.ChildAA}
   */
  public static ChildAA of( String pParentAttribute, int pChildAAttribute, byte pChildAAAttribute,
      Set<String> pRequiredArray, BigIntegerCode pBigIntegerCode ) {
    ChildAA.Builder lBuilder = ChildAA.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setChildAAttribute(pChildAAttribute);
    lBuilder.setChildAAAttribute(pChildAAAttribute);
    lBuilder.setRequiredArray(pRequiredArray);
    lBuilder.setBigIntegerCode(pBigIntegerCode);
    return lBuilder.build();
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

    private Set<String> requiredArray;

    private BigIntegerCode bigIntegerCode;

    private IntegerCodeType integerCode;

    private Set<IntegerCode> codes;

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

    /**
     * Method sets attribute {@link #requiredArray}.<br/>
     *
     * @param pRequiredArray Collection to which {@link #requiredArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setRequiredArray( Set<String> pRequiredArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pRequiredArray != null) {
        requiredArray = new HashSet<String>(pRequiredArray);
      }
      else {
        requiredArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #requiredArray}.<br/>
     *
     * @param pRequiredArray Array of objects that should be added to {@link #requiredArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToRequiredArray( String... pRequiredArray ) {
      if (pRequiredArray != null) {
        if (requiredArray == null) {
          requiredArray = new HashSet<String>();
        }
        requiredArray.addAll(Arrays.asList(pRequiredArray));
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
    public Builder setCodes( Set<IntegerCode> pCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCodes != null) {
        codes = new HashSet<IntegerCode>(pCodes);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #codes}.<br/>
     *
     * @param pCodes Array of objects that should be added to {@link #codes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToCodes( IntegerCode... pCodes ) {
      if (pCodes != null) {
        if (codes == null) {
          codes = new HashSet<IntegerCode>();
        }
        codes.addAll(Arrays.asList(pCodes));
      }
      return this;
    }

    /**
     * Method creates a new instance of class ChildAA. The object will be initialized with the values of the builder.
     *
     * @return ChildAA Created object. The method never returns null.
     */
    public ChildAA build( ) {
      ChildAA lObject = new ChildAA(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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

  /**
   * Method returns attribute {@link #requiredArray}.<br/>
   *
   * @return {@link Set<String>} Value to which {@link #requiredArray} is set.
   */
  public Set<String> getRequiredArray( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(requiredArray);
  }

  /**
   * Method adds the passed object to {@link #requiredArray}.
   *
   * @param pRequiredArray Object that should be added to {@link #requiredArray}. The parameter must not be null.
   */
  public void addToRequiredArray( String pRequiredArray ) {
    // Check parameter "pRequiredArray" for invalid value null.
    Check.checkInvalidParameterNull(pRequiredArray, "pRequiredArray");
    // Add passed object to collection of associated String objects.
    requiredArray.add(pRequiredArray);
  }

  /**
   * Method adds all passed objects to {@link #requiredArray}.
   *
   * @param pRequiredArray Collection with all objects that should be added to {@link #requiredArray}. The parameter
   * must not be null.
   */
  public void addToRequiredArray( Collection<String> pRequiredArray ) {
    // Check parameter "pRequiredArray" for invalid value null.
    Check.checkInvalidParameterNull(pRequiredArray, "pRequiredArray");
    // Add all passed objects.
    for (String lNextObject : pRequiredArray) {
      this.addToRequiredArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #requiredArray}.<br/>
   *
   * @param pRequiredArray Object that should be removed from {@link #requiredArray}. The parameter must not be null.
   */
  public void removeFromRequiredArray( String pRequiredArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pRequiredArray, "pRequiredArray");
    // Remove passed object from collection of associated String objects.
    requiredArray.remove(pRequiredArray);
  }

  /**
   * Method removes all objects from {@link #requiredArray}.
   */
  public void clearRequiredArray( ) {
    // Remove all objects from association "requiredArray".
    requiredArray.clear();
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
   * @return {@link Set<IntegerCode>} Value to which {@link #codes} is set.
   */
  public Set<IntegerCode> getCodes( ) {
    // Return all IntegerCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(codes);
  }

  /**
   * Method adds the passed object to {@link #codes}.
   *
   * @param pCodes Object that should be added to {@link #codes}. The parameter must not be null.
   */
  public void addToCodes( IntegerCode pCodes ) {
    // Check parameter "pCodes" for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Add passed object to collection of associated IntegerCode objects.
    codes.add(pCodes);
  }

  /**
   * Method adds all passed objects to {@link #codes}.
   *
   * @param pCodes Collection with all objects that should be added to {@link #codes}. The parameter must not be null.
   */
  public void addToCodes( Collection<IntegerCode> pCodes ) {
    // Check parameter "pCodes" for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Add all passed objects.
    for (IntegerCode lNextObject : pCodes) {
      this.addToCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #codes}.<br/>
   *
   * @param pCodes Object that should be removed from {@link #codes}. The parameter must not be null.
   */
  public void removeFromCodes( IntegerCode pCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Remove passed object from collection of associated IntegerCode objects.
    codes.remove(pCodes);
  }

  /**
   * Method removes all objects from {@link #codes}.
   */
  public void clearCodes( ) {
    // Remove all objects from association "codes".
    codes.clear();
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