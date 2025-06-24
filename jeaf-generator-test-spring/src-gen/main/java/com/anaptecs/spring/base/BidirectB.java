/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

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
@JsonDeserialize(builder = BidirectB.BidirectBBuilderImpl.class)
public class BidirectB {
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
  protected BidirectB( BidirectBBuilder<?, ?> pBuilder ) {
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
  public static BidirectBBuilder<?, ?> builder( ) {
    return new BidirectBBuilderImpl();
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
  public static abstract class BidirectBBuilder<T extends BidirectB, B extends BidirectBBuilder<T, B>> {
    /**
     * the A
     */
    private BidirectA a;

    /**
     * Use {@link BidirectBBuilder#builder()} instead of private constructor to create new builder.
     */
    protected BidirectBBuilder( ) {
    }

    /**
     * Use {@link BidirectBBuilder#builder(BidirectB)} instead of private constructor to create new builder.
     */
    protected BidirectBBuilder( BidirectB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setA(pObject.a);
      }
    }

    /**
     * Method sets association {@link #a}.<br/>
     *
     * @param pA Value to which {@link #a} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setA( @MyNotNullProperty BidirectA pA ) {
      a = pA;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class BidirectB. The object will be initialized with the values of the builder.
     *
     * @return BidirectB Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BidirectBBuilderImpl extends BidirectBBuilder<BidirectB, BidirectBBuilderImpl> {
    protected BidirectBBuilderImpl( ) {
    }

    protected BidirectBBuilderImpl( BidirectB pObject ) {
      super(pObject);
    }

    @Override
    protected BidirectBBuilderImpl self( ) {
      return this;
    }

    @Override
    public BidirectB build( ) {
      BidirectB lObject = new BidirectB(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #a}.<br/>
   * the A
   *
   * @return {@link BidirectA} Value to which {@link #a} is set.
   */
  @MyNotNullProperty
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
  public void setA( @MyNotNullProperty BidirectA pA ) {
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(a);
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
      BidirectB lOther = (BidirectB) pObject;
      lEquals = Objects.equals(a, lOther.a);
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
    lBuilder.append("a: ");
    if (a != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(a.toStringBuilder(pIndent + "    "));
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
   * @return {@link Builder} New builder that can be used to create new BidirectB objects. The method never returns
   * null.
   */
  public BidirectBBuilder<?, ?> toBuilder( ) {
    return new BidirectBBuilderImpl(this);
  }
}