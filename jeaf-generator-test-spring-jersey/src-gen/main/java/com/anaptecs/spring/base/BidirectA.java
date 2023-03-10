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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BidirectA {
  /**
   * Constant for the name of attribute "transientBs".
   */
  public static final String TRANSIENTBS = "transientBs";

  /**
   * Constant for the name of attribute "parent".
   */
  public static final String PARENT = "parent";

  /**
   * Constant for the name of attribute "transientChild".
   */
  public static final String TRANSIENTCHILD = "transientChild";

  private transient Set<BidirectB> transientBs;

  private BidirectA parent;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean parentBackReferenceInitialized;

  private transient BidirectA transientChild;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectA( ) {
    transientBs = new HashSet<BidirectB>();
    // Bidirectional back reference is not yet set up correctly
    parentBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectA( Builder pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.transientBs != null) {
      transientBs = pBuilder.transientBs;
    }
    else {
      transientBs = new HashSet<BidirectB>();
    }
    parent = pBuilder.parent;
    // Bidirectional back reference is set up correctly as a builder is used.
    parentBackReferenceInitialized = true;
    transientChild = pBuilder.transientChild;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new BidirectA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BidirectA objects. The method never returns
   * null.
   */
  public static Builder builder( BidirectA pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>BidirectA</code>.
   */
  public static class Builder {
    private Set<BidirectB> transientBs;

    private BidirectA parent;

    private BidirectA transientChild;

    /**
     * Use {@link BidirectA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BidirectA#builder(BidirectA)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectA pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        transientBs = pObject.transientBs;
        parent = pObject.parent;
        transientChild = pObject.transientChild;
      }
    }

    /**
     * Method sets association {@link #transientBs}.<br/>
     * 
     * @param pTransientBs Collection to which {@link #transientBs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTransientBs( Set<BidirectB> pTransientBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTransientBs != null) {
        transientBs = new HashSet<BidirectB>(pTransientBs);
      }
      else {
        transientBs = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #parent}.<br/>
     * 
     * @param pParent Value to which {@link #parent} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setParent( BidirectA pParent ) {
      parent = pParent;
      return this;
    }

    /**
     * Method sets association {@link #transientChild}.<br/>
     * 
     * @param pTransientChild Value to which {@link #transientChild} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTransientChild( BidirectA pTransientChild ) {
      transientChild = pTransientChild;
      return this;
    }

    /**
     * Method creates a new instance of class BidirectA. The object will be initialized with the values of the builder.
     * 
     * @return BidirectA Created object. The method never returns null.
     */
    public BidirectA build( ) {
      return new BidirectA(this);
    }
  }

  /**
   * Method returns association {@link #transientBs}.<br/>
   * 
   * @return {@link Set<BidirectB>} Value to which {@link #transientBs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<BidirectB> getTransientBs( ) {
    // Return all BidirectB objects as unmodifiable collection.
    return Collections.unmodifiableSet(transientBs);
  }

  /**
   * Method adds the passed object to {@link #transientBs}.
   * 
   * @param pTransientBs Object that should be added to {@link #transientBs}. The parameter must not be null.
   */
  public void addToTransientBs( BidirectB pTransientBs ) {
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pTransientBs.unsetA();
    // Add passed object to collection of associated BidirectB objects.
    transientBs.add(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientBs != null && this.equals(pTransientBs.getA()) == false) {
      pTransientBs.setA((BidirectA) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #transientBs}.
   * 
   * @param pTransientBs Collection with all objects that should be added to {@link #transientBs}. The parameter must
   * not be null.
   */
  public void addToTransientBs( Collection<BidirectB> pTransientBs ) {
    // Add all passed objects.
    for (BidirectB lNextObject : pTransientBs) {
      this.addToTransientBs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #transientBs}.<br/>
   * 
   * @param pTransientBs Object that should be removed from {@link #transientBs}. The parameter must not be null.
   */
  public void removeFromTransientBs( BidirectB pTransientBs ) {
    // Remove passed object from collection of associated BidirectB objects.
    transientBs.remove(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pTransientBs.getA()) == true) {
      pTransientBs.unsetA();
    }
  }

  /**
   * Method removes all objects from {@link #transientBs}.
   */
  public void clearTransientBs( ) {
    // Remove all objects from association "transientBs".
    Collection<BidirectB> lTransientBs = new HashSet<BidirectB>(transientBs);
    Iterator<BidirectB> lIterator = lTransientBs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromTransientBs(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #parent}.<br/>
   * 
   * @return {@link BidirectA} Value to which {@link #parent} is set.
   */
  public BidirectA getParent( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (parentBackReferenceInitialized == false) {
      parentBackReferenceInitialized = true;
      parent.setTransientChild((BidirectA) this);
    }
    return parent;
  }

  /**
   * Method sets association {@link #parent}.<br/>
   * 
   * @param pParent Value to which {@link #parent} should be set.
   */
  public void setParent( BidirectA pParent ) {
    // Release already referenced object before setting a new association.
    if (parent != null) {
      parent.unsetTransientChild();
    }
    parent = pParent;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pParent != null && this.equals(pParent.getTransientChild()) == false) {
      pParent.setTransientChild((BidirectA) this);
    }
  }

  /**
   * Method unsets {@link #parent}.
   */
  public final void unsetParent( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectA lBidirectA = parent;
    parent = null;
    if (lBidirectA != null && this.equals(lBidirectA.getTransientChild()) == true) {
      lBidirectA.unsetTransientChild();
    }
  }

  /**
   * Method returns association {@link #transientChild}.<br/>
   * 
   * @return {@link BidirectA} Value to which {@link #transientChild} is set.
   */
  public BidirectA getTransientChild( ) {
    return transientChild;
  }

  /**
   * Method sets association {@link #transientChild}.<br/>
   * 
   * @param pTransientChild Value to which {@link #transientChild} should be set.
   */
  public void setTransientChild( BidirectA pTransientChild ) {
    // Release already referenced object before setting a new association.
    if (transientChild != null) {
      transientChild.unsetParent();
    }
    transientChild = pTransientChild;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientChild != null && this.equals(pTransientChild.getParent()) == false) {
      pTransientChild.setParent((BidirectA) this);
    }
  }

  /**
   * Method unsets {@link #transientChild}.
   */
  public final void unsetTransientChild( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectA lBidirectA = transientChild;
    transientChild = null;
    if (lBidirectA != null && this.equals(lBidirectA.getParent()) == true) {
      lBidirectA.unsetParent();
    }
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
    lBuilder.append("transientBs: ");
    if (transientBs != null) {
      lBuilder.append(transientBs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (transientBs != null) {
      for (BidirectB lNext : transientBs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("parent: ");
    if (parent != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(parent.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("transientChild: ");
    if (transientChild != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(transientChild.toStringBuilder(pIndent + "    "));
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
}
