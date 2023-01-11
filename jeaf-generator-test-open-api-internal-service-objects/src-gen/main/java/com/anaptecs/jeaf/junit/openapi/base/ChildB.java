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
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Multi line class comment
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ChildB objects. The method never returns null.
   */
  public static Builder builder( ChildB pObject ) {
    return new Builder(pObject);
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
   * Class implements builder to create a new instance of class ChildB. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
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
        childBAttribute = pObject.childBAttribute;
        composition = pObject.composition;
      }
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets the association "ibans".
     * 
     * @param pIbans Collection with objects to which the association should be set.
     */
    @Override
    public Builder setIbans( Set<IBAN> pIbans ) {
      // Call super class implementation.
      super.setIbans(pIbans);
      return this;
    }

    /**
     * Method sets the association "theBankAccount". I would like to document references to other types.
     * 
     * @param pTheBankAccount BankAccount to which the association "theBankAccount" should be set.
     */
    @Override
    public Builder setTheBankAccount( BankAccount pTheBankAccount ) {
      // Call super class implementation.
      super.setTheBankAccount(pTheBankAccount);
      return this;
    }

    /**
     * Method sets the association "legacyBankAccounts". Association is still there be SemVer compliant.
     * 
     * @param pLegacyBankAccounts Collection with objects to which the association should be set.
     */
    @Override
    public Builder setLegacyBankAccounts( List<BankAccount> pLegacyBankAccounts ) {
      // Call super class implementation.
      super.setLegacyBankAccounts(pLegacyBankAccounts);
      return this;
    }

    /**
     * Method sets the attribute "childBAttribute". A child attribute
     * 
     * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
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
     * Method sets the association "composition". the composition
     * 
     * @param pComposition Collection with objects to which the association should be set.
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
      ChildB lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childBAttribute". A child attribute
   * 
   * @return Boolean Value to which the attribute "childBAttribute" is set.
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
   * Method sets the attribute "childBAttribute". A child attribute
   * 
   * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
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
   * Method returns the association "composition". the composition
   *
   * @return Collection All ParentClass objects that belong to the association "composition". The method never returns
   * null and the returned collection is modifiable.
   */
  public Set<ParentClass> getComposition( ) {
    // Return all ParentClass objects directly without any protection against modification.
    return composition;
  }

  /**
   * Method adds the passed ParentClass object to the association "composition". the composition
   * 
   * @param pComposition Object that should be added to the association "composition". The parameter must not be null.
   */
  public void addToComposition( ParentClass pComposition ) {
    // Check parameter "pComposition" for invalid value null.
    Check.checkInvalidParameterNull(pComposition, "pComposition");
    // Add passed object to collection of associated ParentClass objects.
    composition.add(pComposition);
  }

  /**
   * Method adds all passed objects to the association "composition". the composition
   * 
   * @param pComposition Collection with all objects that should be added to the association "composition". The
   * parameter must not be null.
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
   * Method removes the passed ParentClass object from the association "composition". the composition
   * 
   * @param pComposition Object that should be removed from the association "composition". The parameter must not be
   * null.
   */
  public void removeFromComposition( ParentClass pComposition ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pComposition, "pComposition");
    // Remove passed object from collection of associated ParentClass objects.
    composition.remove(pComposition);
  }

  /**
   * Method removes all objects from the association "composition". the composition
   */
  public void clearComposition( ) {
    // Remove all objects from association "composition".
    composition.clear();
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
}
