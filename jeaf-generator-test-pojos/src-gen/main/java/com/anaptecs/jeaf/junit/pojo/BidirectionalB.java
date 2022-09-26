/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BidirectionalB {
  /**
   * Constant for the name of attribute "as".
   */
  public static final String AS = "as";

  /**
   * Constant for the name of attribute "theAs".
   */
  public static final String THEAS = "theAs";

  /**
   * 
   */
  private List<BidirectionalA> as;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean asBackReferenceInitialized;

  /**
   * 
   */
  private List<BidirectionalA> theAs;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean theAsBackReferenceInitialized;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectionalB( ) {
    as = new ArrayList<BidirectionalA>();
    // Bidirectional back reference is not yet set up correctly
    asBackReferenceInitialized = false;
    theAs = new ArrayList<BidirectionalA>();
    // Bidirectional back reference is not yet set up correctly
    theAsBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectionalB( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.as != null) {
      as = pBuilder.as;
    }
    else {
      as = new ArrayList<BidirectionalA>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    asBackReferenceInitialized = true;
    if (pBuilder.theAs != null) {
      theAs = pBuilder.theAs;
    }
    else {
      theAs = new ArrayList<BidirectionalA>();
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
    private List<BidirectionalA> as;

    /**
     * 
     */
    private List<BidirectionalA> theAs;

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
        as = pObject.as;
        theAs = pObject.theAs;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new BidirectionalB objects.
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
     * Method sets the association "as".
     * 
     * @param pAs Collection with objects to which the association should be set.
     */
    public Builder setAs( List<BidirectionalA> pAs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAs != null) {
        as = new ArrayList<BidirectionalA>(pAs);
      }
      else {
        as = null;
      }
      return this;
    }

    /**
     * Method sets the association "theAs".
     * 
     * @param pTheAs Collection with objects to which the association should be set.
     */
    public Builder setTheAs( List<BidirectionalA> pTheAs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTheAs != null) {
        theAs = new ArrayList<BidirectionalA>(pTheAs);
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
     * Method creates a new validated instance of class BidirectionalB. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return BidirectionalB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BidirectionalB buildValidated( ) throws ConstraintViolationException {
      BidirectionalB lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "as".
   * 
   *
   * @return Collection All BidirectionalA objects that belong to the association "as". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<BidirectionalA> getAs( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (asBackReferenceInitialized == false) {
      asBackReferenceInitialized = true;
      for (BidirectionalA lNext : as) {
        lNext.setTransientB((BidirectionalB) this);
      }
    }
    // Return all BidirectionalA objects as unmodifiable collection.
    return Collections.unmodifiableList(as);
  }

  /**
   * Method adds the passed BidirectionalA object to the association "as".
   * 
   * 
   * @param pAs Object that should be added to the association "as". The parameter must not be null.
   */
  public void addToAs( BidirectionalA pAs ) {
    // Check parameter "pAs" for invalid value null.
    Check.checkInvalidParameterNull(pAs, "pAs");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pAs.unsetTransientB();
    // Add passed object to collection of associated BidirectionalA objects.
    as.add(pAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAs != null && this.equals(pAs.getTransientB()) == false) {
      pAs.setTransientB((BidirectionalB) this);
    }
  }

  /**
   * Method adds all passed objects to the association "as".
   * 
   * 
   * @param pAs Collection with all objects that should be added to the association "as". The parameter must not be
   * null.
   */
  public void addToAs( Collection<BidirectionalA> pAs ) {
    // Check parameter "pAs" for invalid value null.
    Check.checkInvalidParameterNull(pAs, "pAs");
    // Add all passed objects.
    for (BidirectionalA lNextObject : pAs) {
      this.addToAs(lNextObject);
    }
  }

  /**
   * Method removes the passed BidirectionalA object from the association "as".
   * 
   * 
   * @param pAs Object that should be removed from the association "as". The parameter must not be null.
   */
  public void removeFromAs( BidirectionalA pAs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAs, "pAs");
    // Remove passed object from collection of associated BidirectionalA objects.
    as.remove(pAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pAs.getTransientB()) == true) {
      pAs.unsetTransientB();
    }
  }

  /**
   * Method removes all objects from the association "as".
   * 
   */
  public void clearAs( ) {
    // Remove all objects from association "as".
    Collection<BidirectionalA> lAs = new HashSet<BidirectionalA>(as);
    Iterator<BidirectionalA> lIterator = lAs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAs(lIterator.next());
    }
  }

  /**
   * Method returns the association "theAs".
   * 
   *
   * @return Collection All BidirectionalA objects that belong to the association "theAs". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<BidirectionalA> getTheAs( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (theAsBackReferenceInitialized == false) {
      theAsBackReferenceInitialized = true;
      for (BidirectionalA lNext : theAs) {
        lNext.addToTransientBs((BidirectionalB) this);
      }
    }
    // Return all BidirectionalA objects as unmodifiable collection.
    return Collections.unmodifiableList(theAs);
  }

  /**
   * Method adds the passed BidirectionalA object to the association "theAs".
   * 
   * 
   * @param pTheAs Object that should be added to the association "theAs". The parameter must not be null.
   */
  public void addToTheAs( BidirectionalA pTheAs ) {
    // Check parameter "pTheAs" for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Add passed object to collection of associated BidirectionalA objects.
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
  public void addToTheAs( Collection<BidirectionalA> pTheAs ) {
    // Check parameter "pTheAs" for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Add all passed objects.
    for (BidirectionalA lNextObject : pTheAs) {
      this.addToTheAs(lNextObject);
    }
  }

  /**
   * Method removes the passed BidirectionalA object from the association "theAs".
   * 
   * 
   * @param pTheAs Object that should be removed from the association "theAs". The parameter must not be null.
   */
  public void removeFromTheAs( BidirectionalA pTheAs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTheAs, "pTheAs");
    // Remove passed object from collection of associated BidirectionalA objects.
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
    Collection<BidirectionalA> lTheAs = new HashSet<BidirectionalA>(theAs);
    Iterator<BidirectionalA> lIterator = lTheAs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
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
    StringBuilder lBuilder = new StringBuilder();
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
