/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class BidirectB implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * the A
   */
  @NotNull
  private BidirectA a;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean aBackReferenceInitialized;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectB( ) {
    // Nothing to do.
    // Bidirectional back reference is not yet set up correctly
    aBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectB( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    a = pBuilder.a;
    // Bidirectional back reference is set up correctly as a builder is used.
    aBackReferenceInitialized = true;
  }

  /**
   * Class implements builder to create a new instance of class BidirectB. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * the A
     */
    private BidirectA a;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BidirectB)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        a = pObject.a;
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
     * @return {@link Builder} New builder that can be used to create new BidirectB objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BidirectB pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "a". the A
     * 
     * @param pA BidirectA to which the association "a" should be set.
     */
    public Builder setA( BidirectA pA ) {
      a = pA;
      return this;
    }

    /**
     * Method creates a new instance of class BidirectB. The object will be initialized with the values of the builder.
     * 
     * @return BidirectB Created object. The method never returns null.
     */
    public BidirectB build( ) {
      return new BidirectB(this);
    }

    /**
     * Method creates a new validated instance of class BidirectB. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return BidirectB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BidirectB buildValidated( ) throws ConstraintViolationException {
      BidirectB lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "a". the A
   *
   * @return BidirectA BidirectA to which the association "a" is set.
   */
  public BidirectA getA( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (aBackReferenceInitialized == false) {
      aBackReferenceInitialized = true;
      a.addToTransientBs((BidirectB) this);
    }
    return a;
  }

  /**
   * Method sets the association "a". the A
   * 
   * @param pA BidirectA to which the association "a" should be set.
   */
  public void setA( BidirectA pA ) {
    // Release already referenced object before setting a new association.
    if (a != null) {
      a.removeFromTransientBs((BidirectB) this);
    }
    a = pA;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA != null && pA.getTransientBs().contains(this) == false) {
      pA.addToTransientBs((BidirectB) this);
    }
  }

  /**
   * Method unsets the association "a". the A
   */
  public final void unsetA( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectA lBidirectA = a;
    a = null;
    if (lBidirectA != null && lBidirectA.getTransientBs().contains(this) == true) {
      lBidirectA.removeFromTransientBs((BidirectB) this);
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
