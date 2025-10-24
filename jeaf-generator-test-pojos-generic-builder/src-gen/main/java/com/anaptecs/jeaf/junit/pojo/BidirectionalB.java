/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = BidirectionalB.Builder.class)
public class BidirectionalB {
  /**
   * Constant for the name of attribute "as".
   */
  public static final String AS = "as";

  /**
   * Constant for the name of attribute "theAs".
   */
  public static final String THEAS = "theAs";

  private final List<BidirectionalA> as;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean asBackReferenceInitialized;

  private final List<BidirectionalA> theAs;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean theAsBackReferenceInitialized;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectionalB( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    as = (pBuilder.as == null) ? List.of() : List.copyOf(pBuilder.as);
    // As association is bidirectional we also have to set it in the other direction.
    for (BidirectionalA lNext : as) {
      lNext.setTransientB((BidirectionalB) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    asBackReferenceInitialized = true;
    theAs = (pBuilder.theAs == null) ? List.of() : List.copyOf(pBuilder.theAs);
    // As association is bidirectional we also have to set it in the other direction.
    for (BidirectionalA lNext : theAs) {
      lNext.addToTransientBs((BidirectionalB) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    theAsBackReferenceInitialized = true;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BidirectionalB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class BidirectionalB.
   *
   *
   * @return {@link BidirectionalB}
   */
  public static BidirectionalB of( ) {
    var lBuilder = BidirectionalB.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BidirectionalB</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private List<BidirectionalA> as;

    private List<BidirectionalA> theAs;

    /**
     * Use {@link BidirectionalB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BidirectionalB#builder(BidirectionalB)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectionalB pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAs(pObject.as);
        this.setTheAs(pObject.theAs);
      }
    }

    /**
     * Method sets association {@link #as}.<br/>
     *
     * @param pAs Collection to which {@link #as} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #as}.<br/>
     *
     * @param pAs Array of objects that should be added to {@link #as}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToAs( BidirectionalA... pAs ) {
      if (pAs != null) {
        if (as == null) {
          as = new ArrayList<BidirectionalA>();
        }
        as.addAll(Arrays.asList(pAs));
      }
      return this;
    }

    /**
     * Method sets association {@link #theAs}.<br/>
     *
     * @param pTheAs Collection to which {@link #theAs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #theAs}.<br/>
     *
     * @param pTheAs Array of objects that should be added to {@link #theAs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToTheAs( BidirectionalA... pTheAs ) {
      if (pTheAs != null) {
        if (theAs == null) {
          theAs = new ArrayList<BidirectionalA>();
        }
        theAs.addAll(Arrays.asList(pTheAs));
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
      BidirectionalB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #as}.<br/>
   *
   * @return {@link List<BidirectionalA>} Value to which {@link #as} is set. The method never returns null and the
   * returned collection is unmodifiable.
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
    return as;
  }

  /**
   * Method returns association {@link #theAs}.<br/>
   *
   * @return {@link List<BidirectionalA>} Value to which {@link #theAs} is set. The method never returns null and the
   * returned collection is unmodifiable.
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
    return theAs;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(as);
    lResult = lPrime * lResult + Objects.hashCode(theAs);
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
      BidirectionalB lOther = (BidirectionalB) pObject;
      lEquals = Objects.equals(as, lOther.as) && Objects.equals(theAs, lOther.theAs);
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
    lBuilder.append("as: ");
    if (as != null) {
      lBuilder.append(as.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (as != null) {
      for (BidirectionalA lNext : as) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("theAs: ");
    if (theAs != null) {
      lBuilder.append(theAs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (theAs != null) {
      for (BidirectionalA lNext : theAs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
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
   * @return {@link Builder} New builder that can be used to create new BidirectionalB objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}