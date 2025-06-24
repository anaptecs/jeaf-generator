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
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BidirectionalABase {
  /**
   * Constant for the name of attribute "transientB".
   */
  public static final String TRANSIENTB = "transientB";

  /**
   * Constant for the name of attribute "transientParent".
   */
  public static final String TRANSIENTPARENT = "transientParent";

  /**
   * Constant for the name of attribute "child".
   */
  public static final String CHILD = "child";

  /**
   * Constant for the name of attribute "transientBs".
   */
  public static final String TRANSIENTBS = "transientBs";

  private transient BidirectionalB transientB;

  private transient BidirectionalA transientParent;

  private BidirectionalA child;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean childBackReferenceInitialized;

  private transient Set<BidirectionalB> transientBs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectionalABase( ) {
    // Bidirectional back reference is not yet set up correctly
    childBackReferenceInitialized = false;
    transientBs = new HashSet<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectionalABase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    child = pBuilder.child;
    if (child != null) {
      // As association is bidirectional we also have to set it in the other direction.
      child.setTransientParent((BidirectionalA) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    childBackReferenceInitialized = true;
    transientBs = new HashSet<>();
  }

  /**
   * Class implements builder to create a new instance of class BidirectionalA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private BidirectionalA child;

    /**
     * Use {@link BidirectionalA.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link BidirectionalA.builder(BidirectionalA)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( BidirectionalABase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChild(pObject.child);
      }
    }

    /**
     * Method sets association {@link #child}.<br/>
     *
     * @param pChild Value to which {@link #child} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setChild( BidirectionalA pChild ) {
      child = pChild;
      return this;
    }

    /**
     * Method creates a new instance of class BidirectionalA. The object will be initialized with the values of the
     * builder.
     *
     * @return BidirectionalA Created object. The method never returns null.
     */
    public BidirectionalA build( ) {
      return new BidirectionalA(this);
    }

    /**
     * Method creates a new validated instance of class BidirectionalA. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return BidirectionalA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BidirectionalA buildValidated( ) throws ConstraintViolationException {
      BidirectionalA lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #transientB}.<br/>
   *
   * @return {@link BidirectionalB} Value to which {@link #transientB} is set.
   */
  public BidirectionalB getTransientB( ) {
    return transientB;
  }

  /**
   * Method sets association {@link #transientB}.<br/>
   *
   * @param pTransientB Value to which {@link #transientB} should be set.
   */
  void setTransientB( BidirectionalB pTransientB ) {
    // Release already referenced object before setting a new association.
    if (transientB != null) {
      transientB.removeFromAs((BidirectionalA) this);
    }
    transientB = pTransientB;
  }

  /**
   * Method unsets {@link #transientB}.
   */
  final void unsetTransientB( ) {
    transientB = null;
  }

  /**
   * Method returns association {@link #transientParent}.<br/>
   *
   * @return {@link BidirectionalA} Value to which {@link #transientParent} is set.
   */
  public BidirectionalA getTransientParent( ) {
    return transientParent;
  }

  /**
   * Method sets association {@link #transientParent}.<br/>
   *
   * @param pTransientParent Value to which {@link #transientParent} should be set.
   */
  void setTransientParent( BidirectionalA pTransientParent ) {
    // Release already referenced object before setting a new association.
    if (transientParent != null) {
      transientParent.unsetChild();
    }
    transientParent = pTransientParent;
  }

  /**
   * Method unsets {@link #transientParent}.
   */
  final void unsetTransientParent( ) {
    transientParent = null;
  }

  /**
   * Method returns association {@link #child}.<br/>
   *
   * @return {@link BidirectionalA} Value to which {@link #child} is set.
   */
  public BidirectionalA getChild( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (childBackReferenceInitialized == false) {
      childBackReferenceInitialized = true;
      child.setTransientParent((BidirectionalA) this);
    }
    return child;
  }

  /**
   * Method sets association {@link #child}.<br/>
   *
   * @param pChild Value to which {@link #child} should be set.
   */
  public void setChild( BidirectionalA pChild ) {
    // Release already referenced object before setting a new association.
    if (child != null) {
      child.unsetTransientParent();
    }
    child = pChild;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pChild != null && this.equals(pChild.getTransientParent()) == false) {
      pChild.setTransientParent((BidirectionalA) this);
    }
  }

  /**
   * Method unsets {@link #child}.
   */
  public final void unsetChild( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectionalA lBidirectionalA = child;
    child = null;
    if (lBidirectionalA != null && this.equals(lBidirectionalA.getTransientParent()) == true) {
      lBidirectionalA.unsetTransientParent();
    }
  }

  /**
   * Method returns association {@link #transientBs}.<br/>
   *
   * @return {@link Set<BidirectionalB>} Value to which {@link #transientBs} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<BidirectionalB> getTransientBs( ) {
    // Return all BidirectionalB objects as unmodifiable collection.
    return Collections.unmodifiableSet(transientBs);
  }

  /**
   * Method adds the passed object to {@link #transientBs}.
   *
   * @param pTransientBs Object that should be added to {@link #transientBs}. The parameter must not be null.
   */
  void addToTransientBs( BidirectionalB pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Add passed object to collection of associated BidirectionalB objects.
    transientBs.add(pTransientBs);
  }

  /**
   * Method adds all passed objects to {@link #transientBs}.
   *
   * @param pTransientBs Collection with all objects that should be added to {@link #transientBs}. The parameter must
   * not be null.
   */
  void addToTransientBs( Collection<BidirectionalB> pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Add all passed objects.
    for (BidirectionalB lNextObject : pTransientBs) {
      this.addToTransientBs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #transientBs}.<br/>
   *
   * @param pTransientBs Object that should be removed from {@link #transientBs}. The parameter must not be null.
   */
  void removeFromTransientBs( BidirectionalB pTransientBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Remove passed object from collection of associated BidirectionalB objects.
    transientBs.remove(pTransientBs);
  }

  /**
   * Method removes all objects from {@link #transientBs}.
   */
  void clearTransientBs( ) {
    // Remove all objects from association "transientBs".
    Collection<BidirectionalB> lTransientBs = new HashSet<BidirectionalB>(transientBs);
    Iterator<BidirectionalB> lIterator = lTransientBs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromTransientBs(lIterator.next());
    }
  }

  /**
   * Convenience method to create new instance of class BidirectionalA.
   *
   *
   * @return {@link BidirectionalA}
   */
  public static BidirectionalA of( ) {
    var lBuilder = BidirectionalA.builder();
    return lBuilder.build();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(child);
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
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      BidirectionalABase lOther = (BidirectionalABase) pObject;
      lEquals = Objects.equals(child, lOther.child);
    }
    return lEquals;
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
    lBuilder.append("child: ");
    if (child != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(child.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
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
   * @return {@link Builder} New builder that can be used to create new BidirectionalA objects. The method never returns
   * null.
   */
  public BidirectionalA.Builder toBuilder( ) {
    return new BidirectionalA.Builder((BidirectionalA) this);
  }
}