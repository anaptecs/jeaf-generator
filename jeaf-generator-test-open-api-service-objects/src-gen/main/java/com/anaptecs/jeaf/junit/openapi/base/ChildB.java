/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class ChildB extends ParentClass {
  /**
   * Default serial version uid.
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
   * 
   */
  private boolean childBAttribute;

  /**
   * 
   */
  private Set<ParentClass> composition = new HashSet<ParentClass>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildB( ) {
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
   * Class implements builder to create a new instance of class ChildB. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ParentClass.Builder {
    /**
     * 
     */
    private boolean childBAttribute;

    /**
     * 
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
     * Method sets the attribute "childBAttribute".
     * 
     * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
     */
    public Builder setChildBAttribute( boolean pChildBAttribute ) {
      // Assign value to attribute
      childBAttribute = pChildBAttribute;
      return this;
    }

    /**
     * Method sets the association "composition".
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
     * Method creates a new instance of class ChildB. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ChildB Created object. The method never returns null.
     */
    public ChildB build( boolean pValidate ) {
      ChildB lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childBAttribute".
   * 
   * 
   * @return Boolean Value to which the attribute "childBAttribute" is set.
   */
  public boolean getChildBAttribute( ) {
    return childBAttribute;
  }

  /**
   * Method sets the attribute "childBAttribute".
   * 
   * 
   * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
   */
  public void setChildBAttribute( boolean pChildBAttribute ) {
    // Assign value to attribute
    childBAttribute = pChildBAttribute;
  }

  /**
   * Method returns the association "composition".
   * 
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
   * association will be removed from it.
   * 
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
   * Method adds the passed ParentClass object to the association "composition".
   * 
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
   * Method adds all passed objects to the association "composition".
   * 
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
   * Method removes the passed ParentClass object from the association "composition".
   * 
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
   * Method removes all objects from the association "composition".
   * 
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
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "childBAttribute",
        "" + childBAttribute));
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
