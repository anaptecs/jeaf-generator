/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

/**
 * Multi<br/>
 * line<br/>
 * class<br/>
 * comment
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class ChildB extends ParentClass {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * A child attribute
   */
  @Size(min = 11, max = 42)
  private boolean[] childBAttribute;

  /**
   * the composition
   */
  @Valid
  @JsonSetter(nulls = Nulls.SKIP)
  private Set<ParentClass> composition;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildB( ) {
    composition = new HashSet<ParentClass>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildB( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childBAttribute = pBuilder.childBAttribute;
    if (pBuilder.composition != null) {
      composition = pBuilder.composition;
    }
    else {
      composition = new HashSet<ParentClass>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pParentAttribute ) {
    Builder lBuilder = builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class ChildB.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.ChildB}
   */
  public static ChildB of( String pParentAttribute ) {
    ChildB.Builder lBuilder = ChildB.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildB</code>.
   */
  public static class Builder extends ParentClass.Builder {
    /**
     * A child attribute
     */
    @Size(min = 11, max = 42)
    private boolean[] childBAttribute;

    /**
     * the composition
     */
    private Set<ParentClass> composition;

    /**
     * Use {@link ChildB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildB#builder(ChildB)} instead of private constructor to create new builder.
     */
    protected Builder( ChildB pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildBAttribute(pObject.childBAttribute);
        this.setComposition(pObject.composition);
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
    public Builder setChildBAttribute( boolean[] pChildBAttribute ) {
      // Assign value to attribute
      if (pChildBAttribute != null) {
        childBAttribute = pChildBAttribute;
      }
      else {
        childBAttribute = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #composition}.<br/>
     *
     * @param pComposition Collection to which {@link #composition} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setComposition( Set<ParentClass> pComposition ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pComposition != null) {
        composition = new HashSet<ParentClass>(pComposition);
      }
      else {
        composition = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #composition}.<br/>
     *
     * @param pComposition Array of objects that should be added to {@link #composition}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToComposition( ParentClass... pComposition ) {
      if (pComposition != null) {
        if (composition == null) {
          composition = new HashSet<ParentClass>();
        }
        composition.addAll(Arrays.asList(pComposition));
      }
      return this;
    }

    /**
     * Method creates a new instance of class ChildB. The object will be initialized with the values of the builder.
     *
     * @return ChildB Created object. The method never returns null.
     */
    public ChildB build( ) {
      return new ChildB(this);
    }

    /**
     * Method creates a new validated instance of class ChildB. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ChildB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildB buildValidated( ) throws ConstraintViolationException {
      ChildB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childBAttribute}.<br/>
   * A child attribute
   *
   * @return boolean[] Value to which {@link #childBAttribute} is set.
   */
  public boolean[] getChildBAttribute( ) {
    boolean[] lReturnValue;
    if (childBAttribute != null) {
      lReturnValue = childBAttribute;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #childBAttribute}.<br/>
   * A child attribute
   *
   * @param pChildBAttribute Value to which {@link #childBAttribute} should be set.
   */
  public void setChildBAttribute( boolean[] pChildBAttribute ) {
    // Assign value to attribute
    if (pChildBAttribute != null) {
      childBAttribute = pChildBAttribute;
    }
    else {
      childBAttribute = null;
    }
  }

  /**
   * Method returns association {@link #composition}.<br/>
   * the composition
   *
   * @return {@link Set<ParentClass>} Value to which {@link #composition} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public Set<ParentClass> getComposition( ) {
    // Return all ParentClass objects directly without any protection against modification.
    return composition;
  }

  /**
   * Method adds the passed object to {@link #composition}.
   *
   * @param pComposition Object that should be added to {@link #composition}. The parameter must not be null.
   */
  public void addToComposition( ParentClass pComposition ) {
    // Check parameter "pComposition" for invalid value null.
    Check.checkInvalidParameterNull(pComposition, "pComposition");
    // Add passed object to collection of associated ParentClass objects.
    composition.add(pComposition);
  }

  /**
   * Method adds all passed objects to {@link #composition}.
   *
   * @param pComposition Collection with all objects that should be added to {@link #composition}. The parameter must
   * not be null.
   */
  public void addToComposition( Collection<ParentClass> pComposition ) {
    // Check parameter "pComposition" for invalid value null.
    Check.checkInvalidParameterNull(pComposition, "pComposition");
    // Add all passed objects.
    for (ParentClass lNextObject : pComposition) {
      this.addToComposition(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #composition}.<br/>
   *
   * @param pComposition Object that should be removed from {@link #composition}. The parameter must not be null.
   */
  public void removeFromComposition( ParentClass pComposition ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pComposition, "pComposition");
    // Remove passed object from collection of associated ParentClass objects.
    composition.remove(pComposition);
  }

  /**
   * Method removes all objects from {@link #composition}.
   */
  public void clearComposition( ) {
    // Remove all objects from association "composition".
    composition.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Arrays.hashCode(childBAttribute);
    lResult = lPrime * lResult + Objects.hashCode(composition);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      ChildB lOther = (ChildB) pObject;
      lEquals =
          Arrays.equals(childBAttribute, lOther.childBAttribute) && Objects.equals(composition, lOther.composition);
    }
    return lEquals;
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
    lBuilder.append("childBAttribute: ");
    if (childBAttribute != null) {
      lBuilder.append(Arrays.toString(childBAttribute));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("composition: ");
    if (composition != null) {
      lBuilder.append(composition.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (composition != null) {
      for (ParentClass lNext : composition) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new ChildB objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
