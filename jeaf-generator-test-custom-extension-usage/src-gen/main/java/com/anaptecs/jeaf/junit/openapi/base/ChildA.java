/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;

/**
 * single line class comment
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public abstract class ChildA extends ParentClass {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childAAttribute".
   */
  public static final String CHILDAATTRIBUTE = "childAAttribute";

  // "int"
  @ClassPropertyDeclaration
  private int childAAttribute;

  // "int"
  private int childAAttributeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildA( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAttribute = pBuilder.childAAttribute;
    // "int"
    childAAttributeXYZ = pBuilder.childAAttributeXYZ;
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildA</code>.
   */
  public static abstract class Builder extends ParentClass.Builder {
    // "int"
    @BuilderPropertyDeclaration
    private int childAAttribute;

    // "int"
    private int childAAttributeXYZ = 0;

    /**
     * Use {@link ChildA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildA#builder(ChildA)} instead of private constructor to create new builder.
     */
    protected Builder( ChildA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAAttribute(pObject.childAAttribute);
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
    public Builder setChildAAttribute( int pChildAAttribute ) {
      // Assign value to attribute
      childAAttribute = pChildAAttribute;
      return this;
    }

    public Builder setChildAAttributeXYZ( int value ) {
      // "int"
      childAAttributeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(
  }

  /**
   * Method returns attribute {@link #childAAttribute}.<br/>
   *
   * @return int Value to which {@link #childAAttribute} is set.
   */
  public int getChildAAttribute( ) {
    return childAAttribute;
  }

  /**
   * Method sets attribute {@link #childAAttribute}.<br/>
   *
   * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
   */
  public void setChildAAttribute( int pChildAAttribute ) {
    // Assign value to attribute
    childAAttribute = pChildAAttribute;
  }

  public int getChildAAttributeXYZ( ) {
    // "int"
    return childAAttributeXYZ;
  }

  public void setChildAAttributeXYZ( int value ) {
    childAAttributeXYZ = value;
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
    lBuilder.append("childAAttribute: ");
    lBuilder.append(childAAttribute);
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
