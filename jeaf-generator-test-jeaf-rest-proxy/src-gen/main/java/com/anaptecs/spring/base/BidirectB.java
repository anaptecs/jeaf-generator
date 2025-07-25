/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = BidirectB.Builder.class)
public class BidirectB implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "a".
   */
  public static final String A = "a";

  /**
   * the A
   */
  private BidirectA a;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean aBackReferenceInitialized;

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
    if (a != null) {
      // As association is bidirectional we also have to set it in the other direction.
      a.addToTransientBs((BidirectB) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    aBackReferenceInitialized = true;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BidirectB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BidirectA pA ) {
    Builder lBuilder = builder();
    lBuilder.setA(pA);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class BidirectB.
   *
   *
   * @param pA Value to which {@link #a} should be set.
   *
   * @return {@link BidirectB}
   */
  public static BidirectB of( BidirectA pA ) {
    var lBuilder = BidirectB.builder();
    lBuilder.setA(pA);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BidirectB</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * the A
     */
    private BidirectA a;

    /**
     * Use {@link BidirectB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BidirectB#builder(BidirectB)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setA(pObject.a);
      }
    }

    /**
     * Method sets association {@link #a}.<br/>
     *
     * @param pA Value to which {@link #a} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
      BidirectB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #a}.<br/>
   * the A
   *
   * @return {@link BidirectA} Value to which {@link #a} is set.
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
   * Method sets association {@link #a}.<br/>
   * the A
   *
   * @param pA Value to which {@link #a} should be set.
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
   * Method unsets {@link #a}.
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
   * @return {@link Builder} New builder that can be used to create new BidirectB objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}