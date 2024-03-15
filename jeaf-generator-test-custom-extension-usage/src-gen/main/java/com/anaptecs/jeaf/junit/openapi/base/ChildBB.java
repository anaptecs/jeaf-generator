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
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class ChildBB extends ChildB {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childBBAttribute".
   */
  public static final String CHILDBBATTRIBUTE = "childBBAttribute";

  /**
   * Constant for the name of attribute "deprecatedAttribute".
   */
  @Deprecated
  public static final String DEPRECATEDATTRIBUTE = "deprecatedAttribute";

  /**
   * Constant for the name of attribute "deprecatedBs".
   */
  @Deprecated
  public static final String DEPRECATEDBS = "deprecatedBs";

  /**
   * Constant for the name of attribute "deprecatedParent".
   */
  @Deprecated
  public static final String DEPRECATEDPARENT = "deprecatedParent";

  /**
   * Constant for the name of attribute "deprecatedArray".
   */
  @Deprecated
  public static final String DEPRECATEDARRAY = "deprecatedArray";

  // "java.lang.Long"
  @ClassPropertyDeclaration
  private Long childBBAttribute;

  // "java.lang.Long"
  private int childBBAttributeXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  /**
   * @deprecated Please keep <code>hands off</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  private int deprecatedAttribute;

  // "int"
  private int deprecatedAttributeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
  @ClassPropertyDeclaration
  @Deprecated
  private Set<ChildB> deprecatedBs;

  // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
  private int deprecatedBsXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
  @ClassPropertyDeclaration
  @Deprecated
  private ParentClass deprecatedParent;

  // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
  private int deprecatedParentXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @Deprecated
  @Size(min = 0, max = 4711)
  private byte[] deprecatedArray;

  // "byte"
  private int deprecatedArrayXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildBB( ) {
    deprecatedBs = new HashSet<ChildB>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildBB( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childBBAttribute = pBuilder.childBBAttribute;
    // "java.lang.Long"
    childBBAttributeXYZ = pBuilder.childBBAttributeXYZ;
    deprecatedAttribute = pBuilder.deprecatedAttribute;
    // "int"
    deprecatedAttributeXYZ = pBuilder.deprecatedAttributeXYZ;
    if (pBuilder.deprecatedBs != null) {
      deprecatedBs = pBuilder.deprecatedBs;
    }
    else {
      deprecatedBs = new HashSet<ChildB>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
    deprecatedBsXYZ = pBuilder.deprecatedBsXYZ;
    deprecatedParent = pBuilder.deprecatedParent;
    // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
    deprecatedParentXYZ = pBuilder.deprecatedParentXYZ;
    deprecatedArray = pBuilder.deprecatedArray;
    // "byte"
    deprecatedArrayXYZ = pBuilder.deprecatedArrayXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildBB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildBB</code>.
   */
  public static class Builder extends ChildB.Builder {
    // "java.lang.Long"
    @BuilderPropertyDeclaration
    private Long childBBAttribute;

    // "java.lang.Long"
    private int childBBAttributeXYZ = 0;

    /**
     * @deprecated Please keep <code>hands off</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
     */
    // "int"
    @BuilderPropertyDeclaration
    @Deprecated
    private int deprecatedAttribute;

    // "int"
    private int deprecatedAttributeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
    @BuilderPropertyDeclaration
    @Deprecated
    private Set<ChildB> deprecatedBs;

    // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
    private int deprecatedBsXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
    @BuilderPropertyDeclaration
    @Deprecated
    private ParentClass deprecatedParent;

    // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
    private int deprecatedParentXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @Deprecated
    @Size(min = 0, max = 4711)
    private byte[] deprecatedArray;

    // "byte"
    private int deprecatedArrayXYZ = 0;

    /**
     * Use {@link ChildBB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildBB#builder(ChildBB)} instead of private constructor to create new builder.
     */
    protected Builder( ChildBB pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildBBAttribute(pObject.childBBAttribute);
        this.setDeprecatedAttribute(pObject.deprecatedAttribute);
        this.setDeprecatedBs(pObject.deprecatedBs);
        this.setDeprecatedParent(pObject.deprecatedParent);
        this.setDeprecatedArray(pObject.deprecatedArray);
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
     * Method sets attribute {@link #childBAttribute}.<br/>
     *
     * @param pChildBAttribute Value to which {@link #childBAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setChildBAttribute( boolean[] pChildBAttribute ) {
      // Call super class implementation.
      super.setChildBAttribute(pChildBAttribute);
      return this;
    }

    /**
     * Method sets association {@link #composition}.<br/>
     *
     * @param pComposition Collection to which {@link #composition} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setComposition( Set<ParentClass> pComposition ) {
      // Call super class implementation.
      super.setComposition(pComposition);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #composition}.<br/>
     *
     * @param pComposition Array of objects that should be added to {@link #composition}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToComposition( ParentClass... pComposition ) {
      // Call super class implementation.
      super.addToComposition(pComposition);
      return this;
    }

    /**
     * Method sets attribute {@link #childBBAttribute}.<br/>
     *
     * @param pChildBBAttribute Value to which {@link #childBBAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildBBAttribute( Long pChildBBAttribute ) {
      // Assign value to attribute
      childBBAttribute = pChildBBAttribute;
      return this;
    }

    public Builder setChildBBAttributeXYZ( int value ) {
      // "java.lang.Long"
      childBBAttributeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedAttribute}.<br/>
     *
     * @param pDeprecatedAttribute Value to which {@link #deprecatedAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated Please keep <code>hands off</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
     */
    @Deprecated
    public Builder setDeprecatedAttribute( int pDeprecatedAttribute ) {
      // Assign value to attribute
      deprecatedAttribute = pDeprecatedAttribute;
      return this;
    }

    public Builder setDeprecatedAttributeXYZ( int value ) {
      // "int"
      deprecatedAttributeXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #deprecatedBs}.<br/>
     *
     * @param pDeprecatedBs Collection to which {@link #deprecatedBs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDeprecatedBs( Set<ChildB> pDeprecatedBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDeprecatedBs != null) {
        deprecatedBs = new HashSet<ChildB>(pDeprecatedBs);
      }
      else {
        deprecatedBs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #deprecatedBs}.<br/>
     *
     * @param pDeprecatedBs Array of objects that should be added to {@link #deprecatedBs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    public Builder addToDeprecatedBs( ChildB... pDeprecatedBs ) {
      if (pDeprecatedBs != null) {
        if (deprecatedBs == null) {
          deprecatedBs = new HashSet<ChildB>();
        }
        deprecatedBs.addAll(Arrays.asList(pDeprecatedBs));
      }
      return this;
    }

    public Builder setDeprecatedBsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
      deprecatedBsXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #deprecatedParent}.<br/>
     *
     * @param pDeprecatedParent Value to which {@link #deprecatedParent} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDeprecatedParent( ParentClass pDeprecatedParent ) {
      deprecatedParent = pDeprecatedParent;
      return this;
    }

    public Builder setDeprecatedParentXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
      deprecatedParentXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedArray}.<br/>
     *
     * @param pDeprecatedArray Value to which {@link #deprecatedArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDeprecatedArray( byte[] pDeprecatedArray ) {
      // Assign value to attribute
      if (pDeprecatedArray != null) {
        deprecatedArray = new byte[pDeprecatedArray.length];
        System.arraycopy(pDeprecatedArray, 0, deprecatedArray, 0, pDeprecatedArray.length);
      }
      else {
        deprecatedArray = null;
      }
      return this;
    }

    public Builder setDeprecatedArrayXYZ( int value ) {
      // "byte"
      deprecatedArrayXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class ChildBB. The object will be initialized with the values of the builder.
     *
     * @return ChildBB Created object. The method never returns null.
     */
    public ChildBB build( ) {
      return new ChildBB(this);
    }

    /**
     * Method creates a new validated instance of class ChildBB. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ChildBB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildBB buildValidated( ) throws ConstraintViolationException {
      ChildBB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childBBAttribute}.<br/>
   *
   * @return {@link Long} Value to which {@link #childBBAttribute} is set.
   */
  public Long getChildBBAttribute( ) {
    return childBBAttribute;
  }

  /**
   * Method sets attribute {@link #childBBAttribute}.<br/>
   *
   * @param pChildBBAttribute Value to which {@link #childBBAttribute} should be set.
   */
  public void setChildBBAttribute( Long pChildBBAttribute ) {
    // Assign value to attribute
    childBBAttribute = pChildBBAttribute;
  }

  public int getChildBBAttributeXYZ( ) {
    // "java.lang.Long"
    return childBBAttributeXYZ;
  }

  public void setChildBBAttributeXYZ( int value ) {
    childBBAttributeXYZ = value;
  }

  /**
   * Method returns attribute {@link #deprecatedAttribute}.<br/>
   *
   * @return int Value to which {@link #deprecatedAttribute} is set.
   * @deprecated Please keep <code>hands off</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  public int getDeprecatedAttribute( ) {
    return deprecatedAttribute;
  }

  /**
   * Method sets attribute {@link #deprecatedAttribute}.<br/>
   *
   * @param pDeprecatedAttribute Value to which {@link #deprecatedAttribute} should be set.
   * @deprecated Please keep <code>hands off</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  public void setDeprecatedAttribute( int pDeprecatedAttribute ) {
    // Assign value to attribute
    deprecatedAttribute = pDeprecatedAttribute;
  }

  public int getDeprecatedAttributeXYZ( ) {
    // "int"
    return deprecatedAttributeXYZ;
  }

  public void setDeprecatedAttributeXYZ( int value ) {
    deprecatedAttributeXYZ = value;
  }

  /**
   * Method returns association {@link #deprecatedBs}.<br/>
   *
   * @return {@link Set<ChildB>} Value to which {@link #deprecatedBs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ChildB> getDeprecatedBs( ) {
    // Return all ChildB objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedBs);
  }

  /**
   * Method adds the passed object to {@link #deprecatedBs}.
   *
   * @param pDeprecatedBs Object that should be added to {@link #deprecatedBs}. The parameter must not be null.
   */
  @Deprecated
  public void addToDeprecatedBs( ChildB pDeprecatedBs ) {
    // Check parameter "pDeprecatedBs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Add passed object to collection of associated ChildB objects.
    deprecatedBs.add(pDeprecatedBs);
  }

  /**
   * Method adds all passed objects to {@link #deprecatedBs}.
   *
   * @param pDeprecatedBs Collection with all objects that should be added to {@link #deprecatedBs}. The parameter must
   * not be null.
   */
  @Deprecated
  public void addToDeprecatedBs( Collection<ChildB> pDeprecatedBs ) {
    // Check parameter "pDeprecatedBs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Add all passed objects.
    for (ChildB lNextObject : pDeprecatedBs) {
      this.addToDeprecatedBs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #deprecatedBs}.<br/>
   *
   * @param pDeprecatedBs Object that should be removed from {@link #deprecatedBs}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromDeprecatedBs( ChildB pDeprecatedBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Remove passed object from collection of associated ChildB objects.
    deprecatedBs.remove(pDeprecatedBs);
  }

  /**
   * Method removes all objects from {@link #deprecatedBs}.
   */
  @Deprecated
  public void clearDeprecatedBs( ) {
    // Remove all objects from association "deprecatedBs".
    deprecatedBs.clear();
  }

  public int getDeprecatedBsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ChildB"
    return deprecatedBsXYZ;
  }

  public void setDeprecatedBsXYZ( int value ) {
    deprecatedBsXYZ = value;
  }

  /**
   * Method returns association {@link #deprecatedParent}.<br/>
   *
   * @return {@link ParentClass} Value to which {@link #deprecatedParent} is set.
   */
  @Deprecated
  public ParentClass getDeprecatedParent( ) {
    return deprecatedParent;
  }

  /**
   * Method sets association {@link #deprecatedParent}.<br/>
   *
   * @param pDeprecatedParent Value to which {@link #deprecatedParent} should be set.
   */
  @Deprecated
  public void setDeprecatedParent( ParentClass pDeprecatedParent ) {
    deprecatedParent = pDeprecatedParent;
  }

  /**
   * Method unsets {@link #deprecatedParent}.
   */
  @Deprecated
  public final void unsetDeprecatedParent( ) {
    deprecatedParent = null;
  }

  public int getDeprecatedParentXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ParentClass"
    return deprecatedParentXYZ;
  }

  public void setDeprecatedParentXYZ( int value ) {
    deprecatedParentXYZ = value;
  }

  /**
   * Method returns attribute {@link #deprecatedArray}.<br/>
   *
   * @return byte Value to which {@link #deprecatedArray} is set.
   */
  @Deprecated
  public byte[] getDeprecatedArray( ) {
    byte[] lReturnValue;
    if (deprecatedArray != null) {
      lReturnValue = new byte[deprecatedArray.length];
      System.arraycopy(deprecatedArray, 0, lReturnValue, 0, deprecatedArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #deprecatedArray}.<br/>
   *
   * @param pDeprecatedArray Value to which {@link #deprecatedArray} should be set.
   */
  @Deprecated
  public void setDeprecatedArray( byte[] pDeprecatedArray ) {
    // Assign value to attribute
    if (pDeprecatedArray != null) {
      deprecatedArray = new byte[pDeprecatedArray.length];
      System.arraycopy(pDeprecatedArray, 0, deprecatedArray, 0, pDeprecatedArray.length);
    }
    else {
      deprecatedArray = null;
    }
  }

  public int getDeprecatedArrayXYZ( ) {
    // "byte"
    return deprecatedArrayXYZ;
  }

  public void setDeprecatedArrayXYZ( int value ) {
    deprecatedArrayXYZ = value;
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
    lBuilder.append("childBBAttribute: ");
    lBuilder.append(childBBAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedAttribute: ");
    lBuilder.append(deprecatedAttribute);
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
   * @return {@link Builder} New builder that can be used to create new ChildBB objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
