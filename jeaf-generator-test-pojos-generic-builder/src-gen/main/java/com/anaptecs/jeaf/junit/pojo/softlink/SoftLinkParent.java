/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = SoftLinkChildA.class, name = "SoftLinkChildA"),
  @JsonSubTypes.Type(value = SoftLinkChildB.class, name = "SoftLinkChildB") })
@JsonDeserialize(builder = SoftLinkParent.SoftLinkParentBuilderImpl.class)
public class SoftLinkParent {
  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  /**
   * Constant for the name of attribute "thePartner".
   */
  public static final String THEPARTNER = "thePartner";

  /**
   * Constant for the name of attribute "readonlyPartner".
   */
  public static final String READONLYPARTNER = "readonlyPartner";

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #partners} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private Set<SoftLinkID> partnerIDs;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #thePartner} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private SoftLinkID thePartnerID;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #readonlyPartner} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private final SoftLinkID readonlyPartnerID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkParent( SoftLinkParentBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.partnerIDs != null) {
      partnerIDs = pBuilder.partnerIDs;
    }
    else {
      partnerIDs = new HashSet<>();
    }
    thePartnerID = pBuilder.thePartnerID;
    readonlyPartnerID = pBuilder.readonlyPartnerID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkParent objects.
   */
  public static SoftLinkParentBuilder<?, ?> builder( ) {
    return new SoftLinkParentBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class SoftLinkParent.
   *
   *
   * @param pPartners Value to which {@link #partners} should be set.
   *
   * @param pThePartner Value to which {@link #thePartner} should be set.
   *
   * @return {@link SoftLinkParent}
   */
  public static SoftLinkParent of( Set<SoftLinkID> pPartnerIDs, SoftLinkID pThePartnerID ) {
    SoftLinkParentBuilder<?, ?> lBuilder = SoftLinkParent.builder();
    lBuilder.setPartnerIDs(pPartnerIDs);
    lBuilder.setThePartnerID(pThePartnerID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkParent</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SoftLinkParentBuilder<T extends SoftLinkParent, B extends SoftLinkParentBuilder<T, B>> {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #partners} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private Set<SoftLinkID> partnerIDs;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #thePartner} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private SoftLinkID thePartnerID;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #readonlyPartner}
     * is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private SoftLinkID readonlyPartnerID;

    /**
     * Use {@link SoftLinkParentBuilder#builder()} instead of private constructor to create new builder.
     */
    protected SoftLinkParentBuilder( ) {
    }

    /**
     * Use {@link SoftLinkParentBuilder#builder(SoftLinkParent)} instead of private constructor to create new builder.
     */
    protected SoftLinkParentBuilder( SoftLinkParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setPartnerIDs(pObject.partnerIDs);
        this.setThePartnerID(pObject.thePartnerID);
        this.setReadonlyPartnerID(pObject.readonlyPartnerID);
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setPartnerIDs( Set<SoftLinkID> pPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPartners != null) {
        partnerIDs = new HashSet<SoftLinkID>(pPartners);
      }
      else {
        partnerIDs = null;
      }
      return this.self();
    }

    /**
     * Method sets association {@link #thePartner}.<br/>
     *
     * @param pThePartner Value to which {@link #thePartner} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setThePartnerID( SoftLinkID pThePartner ) {
      thePartnerID = pThePartner;
      return this.self();
    }

    /**
     * Method sets association {@link #readonlyPartner}.<br/>
     *
     * @param pReadonlyPartner Value to which {@link #readonlyPartner} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setReadonlyPartnerID( SoftLinkID pReadonlyPartner ) {
      readonlyPartnerID = pReadonlyPartner;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class SoftLinkParent. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkParent Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class SoftLinkParent. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SoftLinkParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkParent buildValidated( ) throws ConstraintViolationException {
      SoftLinkParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class SoftLinkParentBuilderImpl
      extends SoftLinkParentBuilder<SoftLinkParent, SoftLinkParentBuilderImpl> {
    protected SoftLinkParentBuilderImpl( ) {
    }

    protected SoftLinkParentBuilderImpl( SoftLinkParent pObject ) {
      super(pObject);
    }

    @Override
    protected SoftLinkParentBuilderImpl self( ) {
      return this;
    }

    @Override
    public SoftLinkParent build( ) {
      return new SoftLinkParent(this);
    }
  }

  /**
   * Method returns association {@link #partners}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #partners} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link Set<SoftLinkID>} Value to which {@link #partners} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<SoftLinkID> getPartnerIDs( ) {
    // Return all SoftLinkPartner objects as unmodifiable collection.
    return Collections.unmodifiableSet(partnerIDs);
  }

  /**
   * Method adds the passed object to {@link #partners}.
   *
   * @param pPartners Object that should be added to {@link #partners}. The parameter must not be null.
   */
  public void addToPartnerIDs( SoftLinkID pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add passed object to collection of associated SoftLinkPartner objects.
    partnerIDs.add(pPartners);
  }

  /**
   * Method adds all passed objects to {@link #partners}.
   *
   * @param pPartners Collection with all objects that should be added to {@link #partners}. The parameter must not be
   * null.
   */
  public void addToPartnerIDs( Collection<SoftLinkID> pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add all passed objects.
    for (SoftLinkID lNextObject : pPartners) {
      this.addToPartnerIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #partners}.
   *
   * @param pPartners Object that should be removed from {@link #partners}. The parameter must not be null.
   */
  public void removeFromPartnerIDs( SoftLinkID pPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Remove passed object from collection of associated SoftLinkPartner objects.
    partnerIDs.remove(pPartners);
  }

  /**
   * Method removes all objects from {@link #partners}.
   */
  public void clearPartnerIDs( ) {
    // Remove all objects from association "partners".
    partnerIDs.clear();
  }

  /**
   * Method returns association {@link #thePartner}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #thePartner} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #thePartner} is set.
   */
  public SoftLinkID getThePartnerID( ) {
    return thePartnerID;
  }

  /**
   * Method sets association {@link #thePartner}.<br/>
   *
   * @param pThePartner Value to which {@link #thePartner} should be set.
   */
  public void setThePartnerID( SoftLinkID pThePartner ) {
    thePartnerID = pThePartner;
  }

  /**
   * Method unsets {@link #thePartner}.
   */
  public final void unsetThePartnerID( ) {
    thePartnerID = null;
  }

  /**
   * Method returns association {@link #readonlyPartner}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #readonlyPartner} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #readonlyPartner} is set.
   */
  public SoftLinkID getReadonlyPartnerID( ) {
    return readonlyPartnerID;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(partnerIDs);
    lResult = lPrime * lResult + Objects.hashCode(thePartnerID);
    lResult = lPrime * lResult + Objects.hashCode(readonlyPartnerID);
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
      SoftLinkParent lOther = (SoftLinkParent) pObject;
      lEquals = Objects.equals(partnerIDs, lOther.partnerIDs) && Objects.equals(thePartnerID, lOther.thePartnerID)
          && Objects.equals(readonlyPartnerID, lOther.readonlyPartnerID);
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
    lBuilder.append("partnerIDs: ");
    if (partnerIDs != null) {
      lBuilder.append(partnerIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (partnerIDs != null) {
      for (SoftLinkID lNext : partnerIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("thePartnerID: ");
    lBuilder.append(thePartnerID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readonlyPartnerID: ");
    lBuilder.append(readonlyPartnerID);
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
   * @return {@link Builder} New builder that can be used to create new SoftLinkParent objects. The method never returns
   * null.
   */
  public SoftLinkParentBuilder<?, ?> toBuilder( ) {
    return new SoftLinkParentBuilderImpl(this);
  }
}