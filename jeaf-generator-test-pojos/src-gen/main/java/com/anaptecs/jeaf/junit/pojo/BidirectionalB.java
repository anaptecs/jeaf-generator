/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BidirectionalB {
  /**
   * Constant for the name of attribute "theA".
   */
  public static final String THEA = "theA";

  /**
   * Constant for the name of attribute "theAs".
   */
  public static final String THEAS = "theAs";

  /**
   * 
   */
  private Set<BidrectionalA> theA = new HashSet<BidrectionalA>();

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean theABackReferenceInitialized;

  /**
   * 
   */
  private Set<BidrectionalA> theAs = new HashSet<BidrectionalA>();

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean theAsBackReferenceInitialized;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectionalB( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.theA != null) {
      theA.addAll(pBuilder.theA);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    theABackReferenceInitialized = true;
    if (pBuilder.theAs != null) {
      theAs.addAll(pBuilder.theAs);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    theAsBackReferenceInitialized = true;
  }

  /**
   * Class implements builder to create a new instance of class BidirectionalB. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<BidrectionalA> theA;

    /**
     * 
     */
    private Set<BidrectionalA> theAs;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BidirectionalB)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectionalB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        theA = pObject.theA;
        theAs = pObject.theAs;
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
     * @return {@link Builder} New builder that can be used to create new BidirectionalB objects. The method never
     * returns null.
     */
    public static Builder newBuilder( BidirectionalB pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "theA".
     * 
     * @param pTheA Collection with objects to which the association should be set.
     */
    public Builder setTheA( Set<BidrectionalA> pTheA ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTheA != null) {
        theA = new HashSet<BidrectionalA>(pTheA);
      }
      else {
        theA = null;
      }
      return this;
    }

    /**
     * Method sets the association "theAs".
     * 
     * @param pTheAs Collection with objects to which the association should be set.
     */
    public Builder setTheAs( Set<BidrectionalA> pTheAs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTheAs != null) {
        theAs = new HashSet<BidrectionalA>(pTheAs);
      }
      else {
        theAs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class BidirectionalB. The object will be initialized with the values of the
     * builder.
     * 
     * @return BidirectionalB Created object. The method never returns null.
     */
    public BidirectionalB build( ) {
      return new BidirectionalB(this);
    }

    /**
     * Method creates a new instance of class BidirectionalB. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return BidirectionalB Created object. The method never returns null.
     */
    public BidirectionalB build( boolean pValidate ) {
      BidirectionalB lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the association "theA".
   * 
   *
   * @return Collection All BidrectionalA objects that belong to the association "theA". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<BidrectionalA> getTheA( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (theABackReferenceInitialized == false) {
      theABackReferenceInitialized = true;
      for (BidrectionalA lNext : theA) {
        lNext.setTransientB((BidirectionalB) this);
      }
    }
    // Return all BidrectionalA objects as unmodifiable collection.
    return Collections.unmodifiableSet(theA);
  }

  /**
   * Method sets the association "theA" to the passed collection. All objects that formerly were part of the association
   * will be removed from it.
   * 
   * 
   * @param pTheA Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setTheA( Set<BidrectionalA> pTheA ) {
    // Check of parameter is not required.
    // Remove all objects from association "theA".
    this.clearTheA();
    // If the association is null, removing all entries is sufficient.
    if (pTheA != null) {
      theA = new HashSet<BidrectionalA>(pTheA);
    }
  }

  /**
   * Method adds the passed BidrectionalA object to the association "theA".
   * 
   * 
   * @param pTheA Object that should be added to the association "theA". The parameter must not be null.
   */
  public void addToTheA( BidrectionalA pTheA ) {
    // Check parameter "pTheA" for invalid value null.
    Check.checkInvalidParameterNull(pTheA, "pTheA");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pTheA.unsetTransientB();
    // Add passed object to collection of associated BidrectionalA objects.
    theA.add(pTheA);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTheA != null && this.equals(pTheA.getTransientB()) == false) {
      pTheA.setTransientB((BidirectionalB) this);
    }
  }

  /**
   * Method adds all passed objects to the association "theA".
   * 
   * 
   * @param pTheA Collection with all objects that should be added to the association "theA". The parameter must not be
   * null.
   */
  public void addToTheA( Collection<BidrectionalA> pTheA ) {
    // Check parameter "pTheA" for invalid value null.
    Check.checkInvalidParameterNull(pTheA, "pTheA");
    // Add all passed objects.
    for (BidrectionalA lNextObject : pTheA) {
      this.addToTheA(lNextObject);
    }
  }

  /**
   * Method removes the passed BidrectionalA object from the association "theA".
   * 
   * 
   * @param pTheA Object that should be removed from the association "theA". The parameter must not be null.
   */
  public void removeFromTheA( BidrectionalA pTheA ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTheA, "pTheA");
    // Remove passed object from collection of associated BidrectionalA objects.
    theA.remove(pTheA);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pTheA.getTransientB()) == true) {
      pTheA.unsetTransientB();
    }
  }

  /**
   * Method removes all objects from the association "theA".
   * 
   */
  public void clearTheA( ) {
    // Remove all objects from association "theA".
    Collection<BidrectionalA> lTheA = new HashSet<BidrectionalA>(theA);
    Iterator<BidrectionalA> lIterator = lTheA.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTheA(lIterator.next());
    }
  }

  /**
   * Method returns the association "theAs".
   * 
   *
   * @return Collection All BidrectionalA objects that belong to the association "theAs". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<BidrectionalA> getTheAs( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (theAsBackReferenceInitialized == false) {
      theAsBackReferenceInitialized = true;
      for (BidrectionalA lNext : theAs) {
        lNext.addToTransientBs((BidirectionalB) this);
      }
    }
    // Return all BidrectionalA objects as unmodifiable collection.
    return Collections.unmodifiableSet(theAs);
  }

  /**
   * Method sets the association "theAs" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pTheAs Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setTheAs( Set<BidrectionalA> pTheAs ) {
    // Check of parameter is not required.
    // Remove all objects from association "theAs".
    this.clearTheAs();
    // If the association is null, removing all entries is sufficient.
    if (pTheAs != null) {
      theAs = new HashSet<BidrectionalA>(pTheAs);
    }
  }

  /**
   * Method adds the passed BidrectionalA object to the association "theAs".
   * 
   * 
   * @param pTheAs Object that should be added to the association "theAs". The parameter must not be null.
   */
  public void addToTheAs( BidrectionalA pTheAs ) {
    // Check parameter "pTheAs" for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Add passed object to collection of associated BidrectionalA objects.
    theAs.add(pTheAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTheAs != null && pTheAs.getTransientBs().contains(this) == false) {
      pTheAs.addToTransientBs((BidirectionalB) this);
    }
  }

  /**
   * Method adds all passed objects to the association "theAs".
   * 
   * 
   * @param pTheAs Collection with all objects that should be added to the association "theAs". The parameter must not
   * be null.
   */
  public void addToTheAs( Collection<BidrectionalA> pTheAs ) {
    // Check parameter "pTheAs" for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Add all passed objects.
    for (BidrectionalA lNextObject : pTheAs) {
      this.addToTheAs(lNextObject);
    }
  }

  /**
   * Method removes the passed BidrectionalA object from the association "theAs".
   * 
   * 
   * @param pTheAs Object that should be removed from the association "theAs". The parameter must not be null.
   */
  public void removeFromTheAs( BidrectionalA pTheAs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Remove passed object from collection of associated BidrectionalA objects.
    theAs.remove(pTheAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTheAs.getTransientBs().contains(this) == true) {
      pTheAs.removeFromTransientBs((BidirectionalB) this);
    }
  }

  /**
   * Method removes all objects from the association "theAs".
   * 
   */
  public void clearTheAs( ) {
    // Remove all objects from association "theAs".
    Collection<BidrectionalA> lTheAs = new HashSet<BidrectionalA>(theAs);
    Iterator<BidrectionalA> lIterator = lTheAs.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTheAs(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
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
