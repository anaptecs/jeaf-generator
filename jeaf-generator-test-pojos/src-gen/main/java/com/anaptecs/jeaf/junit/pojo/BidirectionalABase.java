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
   * 
   */
  private transient BidirectionalB transientB;

  /**
   * 
   */
  private transient BidirectionalA transientParent;

  /**
   * 
   */
  private BidirectionalA child;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean childBackReferenceInitialized;

  /**
   * 
   */
  private transient Set<BidirectionalB> transientBs = new HashSet<BidirectionalB>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectionalABase( ) {
    // Nothing to do.
    // Bidirectional back reference is not yet set up correctly
    childBackReferenceInitialized = false;
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
    transientB = pBuilder.transientB;
    transientParent = pBuilder.transientParent;
    child = pBuilder.child;
    // Bidirectional back reference is set up correctly as a builder is used.
    childBackReferenceInitialized = true;
    if (pBuilder.transientBs != null) {
      transientBs.addAll(pBuilder.transientBs);
    }
  }

  /**
   * Class implements builder to create a new instance of class BidirectionalA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private BidirectionalB transientB;

    /**
     * 
     */
    private BidirectionalA transientParent;

    /**
     * 
     */
    private BidirectionalA child;

    /**
     * 
     */
    private Set<BidirectionalB> transientBs;

    /**
     * Use {@link BidirectionalA.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link BidirectionalA.Builder#newBuilder(BidirectionalA)} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( BidirectionalABase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        transientB = pObject.transientB;
        transientParent = pObject.transientParent;
        child = pObject.child;
        transientBs = pObject.transientBs;
      }
    }

    /**
     * Method sets the association "transientB".
     * 
     * @param pTransientB BidirectionalB to which the association "transientB" should be set.
     */
    public BuilderBase setTransientB( BidirectionalB pTransientB ) {
      transientB = pTransientB;
      return this;
    }

    /**
     * Method sets the association "transientParent".
     * 
     * @param pTransientParent BidirectionalA to which the association "transientParent" should be set.
     */
    public BuilderBase setTransientParent( BidirectionalA pTransientParent ) {
      transientParent = pTransientParent;
      return this;
    }

    /**
     * Method sets the association "child".
     * 
     * @param pChild BidirectionalA to which the association "child" should be set.
     */
    public BuilderBase setChild( BidirectionalA pChild ) {
      child = pChild;
      return this;
    }

    /**
     * Method sets the association "transientBs".
     * 
     * @param pTransientBs Collection with objects to which the association should be set.
     */
    public BuilderBase setTransientBs( Set<BidirectionalB> pTransientBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTransientBs != null) {
        transientBs = new HashSet<BidirectionalB>(pTransientBs);
      }
      else {
        transientBs = null;
      }
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
     * Method creates a new instance of class BidirectionalA. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return BidirectionalA Created object. The method never returns null.
     */
    public BidirectionalA build( boolean pValidate ) {
      BidirectionalA lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the association "transientB".
   * 
   *
   * @return BidirectionalB BidirectionalB to which the association "transientB" is set.
   */
  public BidirectionalB getTransientB( ) {
    return transientB;
  }

  /**
   * Method sets the association "transientB".
   * 
   * 
   * @param pTransientB BidirectionalB to which the association "transientB" should be set.
   */
  public void setTransientB( BidirectionalB pTransientB ) {
    // Release already referenced object before setting a new association.
    if (transientB != null) {
      transientB.removeFromAs((BidirectionalA) this);
    }
    transientB = pTransientB;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientB != null && pTransientB.getAs().contains(this) == false) {
      pTransientB.addToAs((BidirectionalA) this);
    }
  }

  /**
   * Method unsets the association "transientB".
   * 
   */
  public final void unsetTransientB( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectionalB lBidirectionalB = transientB;
    transientB = null;
    if (lBidirectionalB != null && lBidirectionalB.getAs().contains(this) == true) {
      lBidirectionalB.removeFromAs((BidirectionalA) this);
    }
  }

  /**
   * Method returns the association "transientParent".
   * 
   *
   * @return BidirectionalA BidirectionalA to which the association "transientParent" is set.
   */
  public BidirectionalA getTransientParent( ) {
    return transientParent;
  }

  /**
   * Method sets the association "transientParent".
   * 
   * 
   * @param pTransientParent BidirectionalA to which the association "transientParent" should be set.
   */
  public void setTransientParent( BidirectionalA pTransientParent ) {
    // Release already referenced object before setting a new association.
    if (transientParent != null) {
      transientParent.unsetChild();
    }
    transientParent = pTransientParent;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientParent != null && this.equals(pTransientParent.getChild()) == false) {
      pTransientParent.setChild((BidirectionalA) this);
    }
  }

  /**
   * Method unsets the association "transientParent".
   * 
   */
  public final void unsetTransientParent( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectionalA lBidirectionalA = transientParent;
    transientParent = null;
    if (lBidirectionalA != null && this.equals(lBidirectionalA.getChild()) == true) {
      lBidirectionalA.unsetChild();
    }
  }

  /**
   * Method returns the association "child".
   * 
   *
   * @return BidirectionalA BidirectionalA to which the association "child" is set.
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
   * Method sets the association "child".
   * 
   * 
   * @param pChild BidirectionalA to which the association "child" should be set.
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
   * Method unsets the association "child".
   * 
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
   * Method returns the association "transientBs".
   * 
   *
   * @return Collection All BidirectionalB objects that belong to the association "transientBs". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<BidirectionalB> getTransientBs( ) {
    // Return all BidirectionalB objects as unmodifiable collection.
    return Collections.unmodifiableSet(transientBs);
  }

  /**
   * Method sets the association "transientBs" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pTransientBs Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setTransientBs( Set<BidirectionalB> pTransientBs ) {
    // Check of parameter is not required.
    // Remove all objects from association "transientBs".
    this.clearTransientBs();
    // If the association is null, removing all entries is sufficient.
    if (pTransientBs != null) {
      transientBs = new HashSet<BidirectionalB>(pTransientBs);
    }
  }

  /**
   * Method adds the passed BidirectionalB object to the association "transientBs".
   * 
   * 
   * @param pTransientBs Object that should be added to the association "transientBs". The parameter must not be null.
   */
  public void addToTransientBs( BidirectionalB pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Add passed object to collection of associated BidirectionalB objects.
    transientBs.add(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientBs != null && pTransientBs.getTheAs().contains(this) == false) {
      pTransientBs.addToTheAs((BidirectionalA) this);
    }
  }

  /**
   * Method adds all passed objects to the association "transientBs".
   * 
   * 
   * @param pTransientBs Collection with all objects that should be added to the association "transientBs". The
   * parameter must not be null.
   */
  public void addToTransientBs( Collection<BidirectionalB> pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Add all passed objects.
    for (BidirectionalB lNextObject : pTransientBs) {
      this.addToTransientBs(lNextObject);
    }
  }

  /**
   * Method removes the passed BidirectionalB object from the association "transientBs".
   * 
   * 
   * @param pTransientBs Object that should be removed from the association "transientBs". The parameter must not be
   * null.
   */
  public void removeFromTransientBs( BidirectionalB pTransientBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Remove passed object from collection of associated BidirectionalB objects.
    transientBs.remove(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientBs.getTheAs().contains(this) == true) {
      pTransientBs.removeFromTheAs((BidirectionalA) this);
    }
  }

  /**
   * Method removes all objects from the association "transientBs".
   * 
   */
  public void clearTransientBs( ) {
    // Remove all objects from association "transientBs".
    Collection<BidirectionalB> lTransientBs = new HashSet<BidirectionalB>(transientBs);
    Iterator<BidirectionalB> lIterator = lTransientBs.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTransientBs(lIterator.next());
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
