/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class ClassB implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "manyAs".
   */
  public static final String MANYAS = "manyAs";

  /**
   * Constant for the name of attribute "intValue".
   */
  public static final String INTVALUE = "intValue";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  private SortedSet<ClassA> manyAs;

  private Integer intValue;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ClassB( ) {
    objectID = null;
    manyAs = new TreeSet<ClassA>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ClassB( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    if (pBuilder.manyAs != null) {
      manyAs = pBuilder.manyAs;
      // As association is bidirectional we also have to set it in the other direction.
      for (ClassA lNext : manyAs) {
        lNext.setOneB((ClassB) this);
      }
    }
    else {
      manyAs = new TreeSet<ClassA>();
    }
    intValue = pBuilder.intValue;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ClassB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ClassB.
   *
   *
   * @param pIntValue Value to which {@link #intValue} should be set.
   *
   * @return {@link ClassB}
   */
  public static ClassB of( Integer pIntValue ) {
    ClassB.Builder lBuilder = ClassB.builder();
    lBuilder.setIntValue(pIntValue);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ClassB</code>.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    private SortedSet<ClassA> manyAs;

    private Integer intValue;

    /**
     * Use {@link ClassB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ClassB#builder(ClassB)} instead of private constructor to create new builder.
     */
    protected Builder( ClassB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setManyAs(pObject.manyAs);
        this.setIntValue(pObject.intValue);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets association {@link #manyAs}.<br/>
     *
     * @param pManyAs Collection to which {@link #manyAs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setManyAs( SortedSet<ClassA> pManyAs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pManyAs != null) {
        manyAs = new TreeSet<ClassA>(pManyAs);
      }
      else {
        manyAs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #manyAs}.<br/>
     *
     * @param pManyAs Array of objects that should be added to {@link #manyAs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToManyAs( ClassA... pManyAs ) {
      if (pManyAs != null) {
        if (manyAs == null) {
          manyAs = new TreeSet<ClassA>();
        }
        manyAs.addAll(Arrays.asList(pManyAs));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #intValue}.<br/>
     *
     * @param pIntValue Value to which {@link #intValue} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntValue( Integer pIntValue ) {
      // Assign value to attribute
      intValue = pIntValue;
      return this;
    }

    /**
     * Method creates a new instance of class ClassB. The object will be initialized with the values of the builder.
     *
     * @return ClassB Created object. The method never returns null.
     */
    public ClassB build( ) {
      ClassB lObject = new ClassB(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ClassB. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ClassB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ClassB buildValidated( ) throws ConstraintViolationException {
      ClassB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns association {@link #manyAs}.<br/>
   *
   * @return {@link SortedSet<ClassA>} Value to which {@link #manyAs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public SortedSet<ClassA> getManyAs( ) {
    // Return all ClassA objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(manyAs);
  }

  /**
   * Method adds the passed object to {@link #manyAs}.
   *
   * @param pManyAs Object that should be added to {@link #manyAs}. The parameter must not be null.
   */
  public void addToManyAs( ClassA pManyAs ) {
    // Check parameter "pManyAs" for invalid value null.
    Check.checkInvalidParameterNull(pManyAs, "pManyAs");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pManyAs.unsetOneB();
    // Add passed object to collection of associated ClassA objects.
    manyAs.add(pManyAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pManyAs != null && this.equals(pManyAs.getOneB()) == false) {
      pManyAs.setOneB((ClassB) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #manyAs}.
   *
   * @param pManyAs Collection with all objects that should be added to {@link #manyAs}. The parameter must not be null.
   */
  public void addToManyAs( Collection<ClassA> pManyAs ) {
    // Check parameter "pManyAs" for invalid value null.
    Check.checkInvalidParameterNull(pManyAs, "pManyAs");
    // Add all passed objects.
    for (ClassA lNextObject : pManyAs) {
      this.addToManyAs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #manyAs}.<br/>
   *
   * @param pManyAs Object that should be removed from {@link #manyAs}. The parameter must not be null.
   */
  public void removeFromManyAs( ClassA pManyAs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pManyAs, "pManyAs");
    // Remove passed object from collection of associated ClassA objects.
    manyAs.remove(pManyAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pManyAs.getOneB()) == true) {
      pManyAs.unsetOneB();
    }
  }

  /**
   * Method removes all objects from {@link #manyAs}.
   */
  public void clearManyAs( ) {
    // Remove all objects from association "manyAs".
    Collection<ClassA> lManyAs = new HashSet<ClassA>(manyAs);
    Iterator<ClassA> lIterator = lManyAs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromManyAs(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #intValue}.<br/>
   *
   * @return {@link Integer} Value to which {@link #intValue} is set.
   */
  public Integer getIntValue( ) {
    return intValue;
  }

  /**
   * Method sets attribute {@link #intValue}.<br/>
   *
   * @param pIntValue Value to which {@link #intValue} should be set.
   */
  public void setIntValue( Integer pIntValue ) {
    // Assign value to attribute
    intValue = pIntValue;
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
    lBuilder.append("intValue: ");
    lBuilder.append(intValue);
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
   * @return {@link Builder} New builder that can be used to create new ClassB objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}