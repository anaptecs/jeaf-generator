/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Multi line class comment
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildB extends ParentClass {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childBAttribute".
   */
  public static final String CHILDBATTRIBUTE = "childBAttribute";

  /**
   * Constant for the name of attribute "composition".
   */
  public static final String COMPOSITION = "composition";

  /**
   * A child attribute
   */
  @Size(min = 11, max = 42)
  private boolean childBAttribute;

  /**
   * the composition
   */
  private Set<ParentClass> composition = new HashSet<ParentClass>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildB( ) {
    // Nothing to do.
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
      composition.addAll(pBuilder.composition);
    }
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
    private boolean childBAttribute;

    /**
     * the composition
     */
    private Set<ParentClass> composition;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(ChildB)} instead of private constructor to create new builder.
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ChildB objects. The method never returns null.
     */
    public static Builder newBuilder( ChildB pObject ) {
      return new Builder(pObject);
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
     * Method sets the attribute "childBAttribute". A child attribute
     * 
     * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
     */
    public Builder setChildBAttribute( boolean pChildBAttribute ) {
      // Assign value to attribute
      childBAttribute = pChildBAttribute;
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
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childBAttribute". A child attribute
   * 
   * @return Boolean Value to which the attribute "childBAttribute" is set.
   */
  public boolean getChildBAttribute( ) {
    return childBAttribute;
  }

  /**
   * Method sets the attribute "childBAttribute". A child attribute
   * 
   * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
   */
  public void setChildBAttribute( boolean pChildBAttribute ) {
    // Assign value to attribute
    childBAttribute = pChildBAttribute;
  }

  /**
   * Method returns the association "composition". the composition
   *
   * @return Collection All ParentClass objects that belong to the association "composition". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<ParentClass> getComposition( ) {
    // Return all ParentClass objects as unmodifiable collection.
    return Collections.unmodifiableSet(composition);
  }

  /**
   * Method sets the association "composition" to the passed collection. All objects that formerly were part of the
   * association will be removed from it. the composition
   * 
   * @param pComposition Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setComposition( Set<ParentClass> pComposition ) {
    // Check of parameter is not required.
    // Remove all objects from association "composition".
    this.clearComposition();
    // If the association is null, removing all entries is sufficient.
    if (pComposition != null) {
      composition = new HashSet<ParentClass>(pComposition);
    }
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
    Collection<ParentClass> lComposition = new HashSet<ParentClass>(composition);
    Iterator<ParentClass> lIterator = lComposition.iterator();
    while (lIterator.hasNext()) {
      this.removeFromComposition(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "childBAttribute", "" + childBAttribute));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}