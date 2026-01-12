/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

public class BidirectB {
  /**
   * Constant for the name of attribute "a".
   */
  public static final String A = "a";

  /**
   * the A
   */
  private final BidirectA a;

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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}