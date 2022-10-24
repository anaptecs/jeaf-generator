/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
@JsonIgnoreProperties(value = "objectType")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildA.class, name = "ChildA"),
  @JsonSubTypes.Type(value = ChildAA.class, name = "ChildAA"),
  @JsonSubTypes.Type(value = ChildB.class, name = "ChildB"),
  @JsonSubTypes.Type(value = ChildBB.class, name = "ChildBB") })
public class ParentClass implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private String parentAttribute;

  /**
   * 
   */
  private Set<IBAN> ibans;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentClass( ) {
    ibans = new HashSet<IBAN>();
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
    if (pBuilder.ibans != null) {
      ibans = pBuilder.ibans;
    }
    else {
      ibans = new HashSet<IBAN>();
    }
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ParentClass objects. The method never returns
   * null.
   */
  public static Builder builder( ParentClass pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ParentClass. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String parentAttribute;

    /**
     * 
     */
    private Set<IBAN> ibans;

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
        parentAttribute = pObject.parentAttribute;
        ibans = pObject.ibans;
      }
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    public Builder setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    /**
     * Method sets the association "ibans".
     * 
     * @param pIbans Collection with objects to which the association should be set.
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
      ParentClass lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "parentAttribute".
   * 
   * 
   * @return String Value to which the attribute "parentAttribute" is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets the attribute "parentAttribute".
   * 
   * 
   * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
   */
  public void setParentAttribute( String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  /**
   * Method returns the association "ibans".
   * 
   *
   * @return Collection All IBAN objects that belong to the association "ibans". The method never returns null and the
   * returned collection is modifiable.
   */
  public Set<IBAN> getIbans( ) {
    // Return all IBAN objects directly without any protection against modification.
    return ibans;
  }

  /**
   * Method adds the passed IBAN object to the association "ibans".
   * 
   * 
   * @param pIbans Object that should be added to the association "ibans". The parameter must not be null.
   */
  public void addToIbans( IBAN pIbans ) {
    // Check parameter "pIbans" for invalid value null.
    Check.checkInvalidParameterNull(pIbans, "pIbans");
    // Add passed object to collection of associated IBAN objects.
    ibans.add(pIbans);
  }

  /**
   * Method adds all passed objects to the association "ibans".
   * 
   * 
   * @param pIbans Collection with all objects that should be added to the association "ibans". The parameter must not
   * be null.
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
   * Method removes the passed IBAN object from the association "ibans".
   * 
   * 
   * @param pIbans Object that should be removed from the association "ibans". The parameter must not be null.
   */
  public void removeFromIbans( IBAN pIbans ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pIbans, "pIbans");
    // Remove passed object from collection of associated IBAN objects.
    ibans.remove(pIbans);
  }

  /**
   * Method removes all objects from the association "ibans".
   * 
   */
  public void clearIbans( ) {
    // Remove all objects from association "ibans".
    ibans.clear();
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append(System.lineSeparator());
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append(System.lineSeparator());
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "parentAttribute", "" + parentAttribute));
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
