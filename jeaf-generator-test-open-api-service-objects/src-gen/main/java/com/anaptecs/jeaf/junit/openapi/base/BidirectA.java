/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class BidirectA implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  private transient Set<BidirectB> transientBs;

  @NotNull
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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    transientBs = new HashSet<BidirectB>();
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
  public static Builder builder( ) {
    return new Builder();
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
    BidirectA.Builder lBuilder = BidirectA.builder();
    lBuilder.setParent(pParent);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BidirectA</code>.
   */
  public static class Builder {
    private BidirectA parent;

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
        this.setParent(pObject.parent);
      }
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
     * Method creates a new instance of class BidirectA. The object will be initialized with the values of the builder.
     *
     * @return BidirectA Created object. The method never returns null.
     */
    public BidirectA build( ) {
      return new BidirectA(this);
    }

    /**
     * Method creates a new validated instance of class BidirectA. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return BidirectA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BidirectA buildValidated( ) throws ConstraintViolationException {
      BidirectA lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #transientBs}.<br/>
   *
   * @return {@link Set<BidirectB>} Value to which {@link #transientBs} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public Set<BidirectB> getTransientBs( ) {
    // Return all BidirectB objects directly without any protection against modification.
    return transientBs;
  }

  /**
   * Method adds the passed object to {@link #transientBs}.
   *
   * @param pTransientBs Object that should be added to {@link #transientBs}. The parameter must not be null.
   */
  void addToTransientBs( BidirectB pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
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
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
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
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
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
  void setTransientChild( BidirectA pTransientChild ) {
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
