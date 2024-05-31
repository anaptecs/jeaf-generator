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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
public class ParentClass extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "ibans".
   */
  public static final String IBANS = "ibans";

  /**
   * Constant for the name of attribute "theBankAccount".
   */
  @Deprecated
  public static final String THEBANKACCOUNT = "theBankAccount";

  /**
   * Constant for the name of attribute "legacyBankAccounts".
   */
  @Deprecated
  public static final String LEGACYBANKACCOUNTS = "legacyBankAccounts";

  // "java.lang.String"
  @ClassPropertyDeclaration
  private String parentAttribute;

  // "java.lang.String"
  private int parentAttributeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
  @ClassPropertyDeclaration
  private Set<IBAN> ibans;

  // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
  private int ibansXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
  @ClassPropertyDeclaration
  /**
   * I would like to document references to other types.
   */
  @Deprecated
  private BankAccount theBankAccount;

  // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
  private int theBankAccountXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
  @ClassPropertyDeclaration
  /**
   * Association is still there be SemVer compliant.
   */
  @Deprecated
  private List<BankAccount> legacyBankAccounts;

  // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
  private int legacyBankAccountsXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentClass( ) {
    ibans = new HashSet<IBAN>();
    legacyBankAccounts = new ArrayList<BankAccount>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    // "java.lang.String"
    parentAttributeXYZ = pBuilder.parentAttributeXYZ;
    if (pBuilder.ibans != null) {
      ibans = pBuilder.ibans;
    }
    else {
      ibans = new HashSet<IBAN>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
    ibansXYZ = pBuilder.ibansXYZ;
    theBankAccount = pBuilder.theBankAccount;
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    theBankAccountXYZ = pBuilder.theBankAccountXYZ;
    if (pBuilder.legacyBankAccounts != null) {
      legacyBankAccounts = pBuilder.legacyBankAccounts;
    }
    else {
      legacyBankAccounts = new ArrayList<BankAccount>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    legacyBankAccountsXYZ = pBuilder.legacyBankAccountsXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentClass</code>.
   */
  public static class Builder {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    private String parentAttribute;

    // "java.lang.String"
    private int parentAttributeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
    @BuilderPropertyDeclaration
    private Set<IBAN> ibans;

    // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
    private int ibansXYZ = 0;

    /**
     * I would like to document references to other types.
     */
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    @BuilderPropertyDeclaration
    @Deprecated
    private BankAccount theBankAccount;

    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    private int theBankAccountXYZ = 0;

    /**
     * Association is still there be SemVer compliant.
     */
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    @BuilderPropertyDeclaration
    @Deprecated
    private List<BankAccount> legacyBankAccounts;

    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    private int legacyBankAccountsXYZ = 0;

    /**
     * Use {@link ParentClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentClass#builder(ParentClass)} instead of private constructor to create new builder.
     */
    protected Builder( ParentClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
        this.setIbans(pObject.ibans);
        this.setTheBankAccount(pObject.theBankAccount);
        this.setLegacyBankAccounts(pObject.legacyBankAccounts);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    public Builder setParentAttributeXYZ( int value ) {
      // "java.lang.String"
      parentAttributeXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #ibans}.<br/>
     *
     * @param pIbans Collection to which {@link #ibans} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIbans( Set<IBAN> pIbans ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pIbans != null) {
        ibans = new HashSet<IBAN>(pIbans);
      }
      else {
        ibans = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #ibans}.<br/>
     *
     * @param pIbans Array of objects that should be added to {@link #ibans}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToIbans( IBAN... pIbans ) {
      if (pIbans != null) {
        if (ibans == null) {
          ibans = new HashSet<IBAN>();
        }
        ibans.addAll(Arrays.asList(pIbans));
      }
      return this;
    }

    public Builder setIbansXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
      ibansXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #theBankAccount}.<br/>
     *
     * @param pTheBankAccount Value to which {@link #theBankAccount} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setTheBankAccount( BankAccount pTheBankAccount ) {
      theBankAccount = pTheBankAccount;
      return this;
    }

    public Builder setTheBankAccountXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
      theBankAccountXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #legacyBankAccounts}.<br/>
     *
     * @param pLegacyBankAccounts Collection to which {@link #legacyBankAccounts} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setLegacyBankAccounts( List<BankAccount> pLegacyBankAccounts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLegacyBankAccounts != null) {
        legacyBankAccounts = new ArrayList<BankAccount>(pLegacyBankAccounts);
      }
      else {
        legacyBankAccounts = null;
      }
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
      if (pLegacyBankAccounts != null) {
        if (legacyBankAccounts == null) {
          legacyBankAccounts = new ArrayList<BankAccount>();
        }
        legacyBankAccounts.addAll(Arrays.asList(pLegacyBankAccounts));
      }
      return this;
    }

    public Builder setLegacyBankAccountsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
      legacyBankAccountsXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ParentClass. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentClass Created object. The method never returns null.
     */
    public ParentClass build( ) {
      return new ParentClass(this);
    }

    /**
     * Method creates a new validated instance of class ParentClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ParentClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentClass buildValidated( ) throws ConstraintViolationException {
      ParentClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets attribute {@link #parentAttribute}.<br/>
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   */
  public void setParentAttribute( String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  public int getParentAttributeXYZ( ) {
    // "java.lang.String"
    return parentAttributeXYZ;
  }

  public void setParentAttributeXYZ( int value ) {
    parentAttributeXYZ = value;
  }

  /**
   * Method returns association {@link #ibans}.<br/>
   *
   * @return {@link Set<IBAN>} Value to which {@link #ibans} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public Set<IBAN> getIbans( ) {
    // Return all IBAN objects as unmodifiable collection.
    return Collections.unmodifiableSet(ibans);
  }

  /**
   * Method adds the passed object to {@link #ibans}.
   *
   * @param pIbans Object that should be added to {@link #ibans}. The parameter must not be null.
   */
  public void addToIbans( IBAN pIbans ) {
    // Check parameter "pIbans" for invalid value null.
    Check.checkInvalidParameterNull(pIbans, "pIbans");
    // Add passed object to collection of associated IBAN objects.
    ibans.add(pIbans);
  }

  /**
   * Method adds all passed objects to {@link #ibans}.
   *
   * @param pIbans Collection with all objects that should be added to {@link #ibans}. The parameter must not be null.
   */
  public void addToIbans( Collection<IBAN> pIbans ) {
    // Check parameter "pIbans" for invalid value null.
    Check.checkInvalidParameterNull(pIbans, "pIbans");
    // Add all passed objects.
    for (IBAN lNextObject : pIbans) {
      this.addToIbans(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #ibans}.<br/>
   *
   * @param pIbans Object that should be removed from {@link #ibans}. The parameter must not be null.
   */
  public void removeFromIbans( IBAN pIbans ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pIbans, "pIbans");
    // Remove passed object from collection of associated IBAN objects.
    ibans.remove(pIbans);
  }

  /**
   * Method removes all objects from {@link #ibans}.
   */
  public void clearIbans( ) {
    // Remove all objects from association "ibans".
    ibans.clear();
  }

  public int getIbansXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.IBAN"
    return ibansXYZ;
  }

  public void setIbansXYZ( int value ) {
    ibansXYZ = value;
  }

  /**
   * Method returns association {@link #theBankAccount}.<br/>
   * I would like to document references to other types.
   *
   * @return {@link BankAccount} Value to which {@link #theBankAccount} is set.
   */
  @Deprecated
  public BankAccount getTheBankAccount( ) {
    return theBankAccount;
  }

  /**
   * Method sets association {@link #theBankAccount}.<br/>
   * I would like to document references to other types.
   *
   * @param pTheBankAccount Value to which {@link #theBankAccount} should be set.
   */
  @Deprecated
  public void setTheBankAccount( BankAccount pTheBankAccount ) {
    theBankAccount = pTheBankAccount;
  }

  /**
   * Method unsets {@link #theBankAccount}.
   */
  @Deprecated
  public final void unsetTheBankAccount( ) {
    theBankAccount = null;
  }

  public int getTheBankAccountXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    return theBankAccountXYZ;
  }

  public void setTheBankAccountXYZ( int value ) {
    theBankAccountXYZ = value;
  }

  /**
   * Method returns association {@link #legacyBankAccounts}.<br/>
   * Association is still there be SemVer compliant.
   *
   * @return {@link List<BankAccount>} Value to which {@link #legacyBankAccounts} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  @Deprecated
  public List<BankAccount> getLegacyBankAccounts( ) {
    // Return all BankAccount objects as unmodifiable collection.
    return Collections.unmodifiableList(legacyBankAccounts);
  }

  /**
   * Method adds the passed object to {@link #legacyBankAccounts}.
   *
   * @param pLegacyBankAccounts Object that should be added to {@link #legacyBankAccounts}. The parameter must not be
   * null.
   */
  @Deprecated
  public void addToLegacyBankAccounts( BankAccount pLegacyBankAccounts ) {
    // Check parameter "pLegacyBankAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pLegacyBankAccounts, "pLegacyBankAccounts");
    // Add passed object to collection of associated BankAccount objects.
    legacyBankAccounts.add(pLegacyBankAccounts);
  }

  /**
   * Method adds all passed objects to {@link #legacyBankAccounts}.
   *
   * @param pLegacyBankAccounts Collection with all objects that should be added to {@link #legacyBankAccounts}. The
   * parameter must not be null.
   */
  @Deprecated
  public void addToLegacyBankAccounts( Collection<BankAccount> pLegacyBankAccounts ) {
    // Check parameter "pLegacyBankAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pLegacyBankAccounts, "pLegacyBankAccounts");
    // Add all passed objects.
    for (BankAccount lNextObject : pLegacyBankAccounts) {
      this.addToLegacyBankAccounts(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #legacyBankAccounts}.<br/>
   *
   * @param pLegacyBankAccounts Object that should be removed from {@link #legacyBankAccounts}. The parameter must not
   * be null.
   */
  @Deprecated
  public void removeFromLegacyBankAccounts( BankAccount pLegacyBankAccounts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLegacyBankAccounts, "pLegacyBankAccounts");
    // Remove passed object from collection of associated BankAccount objects.
    legacyBankAccounts.remove(pLegacyBankAccounts);
  }

  /**
   * Method removes all objects from {@link #legacyBankAccounts}.
   */
  @Deprecated
  public void clearLegacyBankAccounts( ) {
    // Remove all objects from association "legacyBankAccounts".
    legacyBankAccounts.clear();
  }

  public int getLegacyBankAccountsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BankAccount"
    return legacyBankAccountsXYZ;
  }

  public void setLegacyBankAccountsXYZ( int value ) {
    legacyBankAccountsXYZ = value;
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
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
   * @return {@link Builder} New builder that can be used to create new ParentClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
