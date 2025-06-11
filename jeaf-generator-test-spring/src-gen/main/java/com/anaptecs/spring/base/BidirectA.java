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
import java.util.Objects;
import java.util.Set;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = BidirectA.BidirectABuilderImpl.class)
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
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectA( BidirectABuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    transientBs = new HashSet<>();
    parent = pBuilder.parent;
    if (parent != null) {
      // As association is bidirectional we also have to set it in the other direction.
      parent.setTransientChild((BidirectA) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    parentBackReferenceInitialized = true;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BidirectA objects.
   */
  public static BidirectABuilder<?, ?> builder( ) {
    return new BidirectABuilderImpl();
  }

  /**
   * Convenience method to create new instance of class BidirectA.
   *
   *
   * @param pParent Value to which {@link #parent} should be set.
   *
   * @return {@link BidirectA}
   */
  public static BidirectA of( BidirectA pParent ) {
    BidirectABuilder<?, ?> lBuilder = BidirectA.builder();
    lBuilder.setParent(pParent);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BidirectA</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BidirectABuilder<T extends BidirectA, B extends BidirectABuilder<T, B>> {
    private BidirectA parent;

    /**
     * Use {@link BidirectABuilder#builder()} instead of private constructor to create new builder.
     */
    protected BidirectABuilder( ) {
    }

    /**
     * Use {@link BidirectABuilder#builder(BidirectA)} instead of private constructor to create new builder.
     */
    protected BidirectABuilder( BidirectA pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParent(pObject.parent);
      }
    }

    /**
     * Method sets association {@link #parent}.<br/>
     *
     * @param pParent Value to which {@link #parent} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setParent( @MyNotNullProperty BidirectA pParent ) {
      parent = pParent;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class BidirectA. The object will be initialized with the values of the builder.
     *
     * @return BidirectA Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BidirectABuilderImpl extends BidirectABuilder<BidirectA, BidirectABuilderImpl> {
    protected BidirectABuilderImpl( ) {
    }

    protected BidirectABuilderImpl( BidirectA pObject ) {
      super(pObject);
    }

    @Override
    protected BidirectABuilderImpl self( ) {
      return this;
    }

    @Override
    public BidirectA build( ) {
      BidirectA lObject = new BidirectA(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
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
  void addToTransientBs( BidirectB pTransientBs ) {
    // Add passed object to collection of associated BidirectB objects.
    transientBs.add(pTransientBs);
  }

  /**
   * Method adds all passed objects to {@link #transientBs}.
   *
   * @param pTransientBs Collection with all objects that should be added to {@link #transientBs}. The parameter must
   * not be null.
   */
  void addToTransientBs( Collection<BidirectB> pTransientBs ) {
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
  void removeFromTransientBs( BidirectB pTransientBs ) {
    // Remove passed object from collection of associated BidirectB objects.
    transientBs.remove(pTransientBs);
  }

  /**
   * Method removes all objects from {@link #transientBs}.
   */
  void clearTransientBs( ) {
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
  @MyNotNullProperty
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
  public void setParent( @MyNotNullProperty BidirectA pParent ) {
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
  @MyNotNullProperty
  public BidirectA getTransientChild( ) {
    return transientChild;
  }

  /**
   * Method sets association {@link #transientChild}.<br/>
   *
   * @param pTransientChild Value to which {@link #transientChild} should be set.
   */
  void setTransientChild( @MyNotNullProperty BidirectA pTransientChild ) {
    // Release already referenced object before setting a new association.
    if (transientChild != null) {
      transientChild.unsetParent();
    }
    transientChild = pTransientChild;
  }

  /**
   * Method unsets {@link #transientChild}.
   */
  final void unsetTransientChild( ) {
    transientChild = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(parent);
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
      BidirectA lOther = (BidirectA) pObject;
      lEquals = Objects.equals(parent, lOther.parent);
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
    lBuilder.append("parent: ");
    if (parent != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(parent.toStringBuilder(pIndent + "    "));
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
   * @return {@link Builder} New builder that can be used to create new BidirectA objects. The method never returns
   * null.
   */
  public BidirectABuilder<?, ?> toBuilder( ) {
    return new BidirectABuilderImpl(this);
  }
}