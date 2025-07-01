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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = SoftLinkChildB.Builder.class)
public class SoftLinkChildB extends SoftLinkParent {
  /**
   * Constant for the name of attribute "heyBrother".
   */
  public static final String HEYBROTHER = "heyBrother";

  /**
   * Constant for the name of attribute "softLinkPartners".
   */
  public static final String SOFTLINKPARTNERS = "softLinkPartners";

  /**
   * Constant for the name of attribute "oneLink".
   */
  public static final String ONELINK = "oneLink";

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #heyBrother} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   */
  private String heyBrotherID;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #softLinkPartners} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private Set<String> softLinkPartnerIDs;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private SoftLinkID oneLinkID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkChildB( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    heyBrotherID = pBuilder.heyBrotherID;
    if (pBuilder.softLinkPartnerIDs != null) {
      softLinkPartnerIDs = pBuilder.softLinkPartnerIDs;
    }
    else {
      softLinkPartnerIDs = new HashSet<>();
    }
    oneLinkID = pBuilder.oneLinkID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class SoftLinkChildB.
   *
   *
   * @param pPartners Value to which {@link #partners} should be set.
   *
   * @param pThePartner Value to which {@link #thePartner} should be set.
   *
   * @param pOneLink Value to which {@link #oneLink} should be set.
   *
   * @return {@link SoftLinkChildB}
   */
  public static SoftLinkChildB of( Set<SoftLinkID> pPartnerIDs, SoftLinkID pThePartnerID, SoftLinkID pOneLinkID ) {
    var lBuilder = SoftLinkChildB.builder();
    lBuilder.setPartnerIDs(pPartnerIDs);
    lBuilder.setThePartnerID(pThePartnerID);
    lBuilder.setOneLinkID(pOneLinkID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkChildB</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder extends SoftLinkParent.Builder {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #heyBrother} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private String heyBrotherID;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #softLinkPartners}
     * is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private Set<String> softLinkPartnerIDs;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private SoftLinkID oneLinkID;

    /**
     * Use {@link SoftLinkChildB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SoftLinkChildB#builder(SoftLinkChildB)} instead of private constructor to create new builder.
     */
    protected Builder( SoftLinkChildB pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setHeyBrotherID(pObject.heyBrotherID);
        this.setSoftLinkPartnerIDs(pObject.softLinkPartnerIDs);
        this.setOneLinkID(pObject.oneLinkID);
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setPartnerIDs( Set<SoftLinkID> pPartners ) {
      // Call super class implementation.
      super.setPartnerIDs(pPartners);
      return this;
    }

    /**
     * Method sets association {@link #thePartner}.<br/>
     *
     * @param pThePartner Value to which {@link #thePartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setThePartnerID( SoftLinkID pThePartner ) {
      // Call super class implementation.
      super.setThePartnerID(pThePartner);
      return this;
    }

    /**
     * Method sets association {@link #readonlyPartner}.<br/>
     *
     * @param pReadonlyPartner Value to which {@link #readonlyPartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setReadonlyPartnerID( SoftLinkID pReadonlyPartner ) {
      // Call super class implementation.
      super.setReadonlyPartnerID(pReadonlyPartner);
      return this;
    }

    /**
     * Method sets association {@link #heyBrother}.<br/>
     *
     * @param pHeyBrother Value to which {@link #heyBrother} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHeyBrotherID( String pHeyBrother ) {
      heyBrotherID = pHeyBrother;
      return this;
    }

    /**
     * Method sets association {@link #softLinkPartners}.<br/>
     *
     * @param pSoftLinkPartners Collection to which {@link #softLinkPartners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSoftLinkPartnerIDs( Set<String> pSoftLinkPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSoftLinkPartners != null) {
        softLinkPartnerIDs = new HashSet<String>(pSoftLinkPartners);
      }
      else {
        softLinkPartnerIDs = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #oneLink}.<br/>
     *
     * @param pOneLink Value to which {@link #oneLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOneLinkID( SoftLinkID pOneLink ) {
      oneLinkID = pOneLink;
      return this;
    }

    /**
     * Method creates a new instance of class SoftLinkChildB. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkChildB Created object. The method never returns null.
     */
    public SoftLinkChildB build( ) {
      return new SoftLinkChildB(this);
    }

    /**
     * Method creates a new validated instance of class SoftLinkChildB. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SoftLinkChildB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkChildB buildValidated( ) throws ConstraintViolationException {
      SoftLinkChildB lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #heyBrother}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #heyBrother} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   *
   * @return {@link String} Value to which {@link #heyBrother} is set.
   */
  public String getHeyBrotherID( ) {
    return heyBrotherID;
  }

  /**
   * Method sets association {@link #heyBrother}.<br/>
   *
   * @param pHeyBrother Value to which {@link #heyBrother} should be set.
   */
  public void setHeyBrotherID( String pHeyBrother ) {
    heyBrotherID = pHeyBrother;
  }

  /**
   * Method unsets {@link #heyBrother}.
   */
  public final void unsetHeyBrotherID( ) {
    heyBrotherID = null;
  }

  /**
   * Method returns association {@link #softLinkPartners}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #softLinkPartners} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link Set<String>} Value to which {@link #softLinkPartners} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<String> getSoftLinkPartnerIDs( ) {
    // Return all SoftLinkPartner objects as unmodifiable collection.
    return Collections.unmodifiableSet(softLinkPartnerIDs);
  }

  /**
   * Method adds the passed object to {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Object that should be added to {@link #softLinkPartners}. The parameter must not be null.
   */
  public void addToSoftLinkPartnerIDs( String pSoftLinkPartners ) {
    // Check parameter "pSoftLinkPartners" for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Add passed object to collection of associated SoftLinkPartner objects.
    softLinkPartnerIDs.add(pSoftLinkPartners);
  }

  /**
   * Method adds all passed objects to {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Collection with all objects that should be added to {@link #softLinkPartners}. The
   * parameter must not be null.
   */
  public void addToSoftLinkPartnerIDs( Collection<String> pSoftLinkPartners ) {
    // Check parameter "pSoftLinkPartners" for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Add all passed objects.
    for (String lNextObject : pSoftLinkPartners) {
      this.addToSoftLinkPartnerIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Object that should be removed from {@link #softLinkPartners}. The parameter must not be
   * null.
   */
  public void removeFromSoftLinkPartnerIDs( String pSoftLinkPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Remove passed object from collection of associated SoftLinkPartner objects.
    softLinkPartnerIDs.remove(pSoftLinkPartners);
  }

  /**
   * Method removes all objects from {@link #softLinkPartners}.
   */
  public void clearSoftLinkPartnerIDs( ) {
    // Remove all objects from association "softLinkPartners".
    softLinkPartnerIDs.clear();
  }

  /**
   * Method returns association {@link #oneLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #oneLink} is set.
   */
  public SoftLinkID getOneLinkID( ) {
    return oneLinkID;
  }

  /**
   * Method sets association {@link #oneLink}.<br/>
   *
   * @param pOneLink Value to which {@link #oneLink} should be set.
   */
  public void setOneLinkID( SoftLinkID pOneLink ) {
    oneLinkID = pOneLink;
  }

  /**
   * Method unsets {@link #oneLink}.
   */
  public final void unsetOneLinkID( ) {
    oneLinkID = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(heyBrotherID);
    lResult = lPrime * lResult + Objects.hashCode(softLinkPartnerIDs);
    lResult = lPrime * lResult + Objects.hashCode(oneLinkID);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      SoftLinkChildB lOther = (SoftLinkChildB) pObject;
      lEquals = Objects.equals(heyBrotherID, lOther.heyBrotherID)
          && Objects.equals(softLinkPartnerIDs, lOther.softLinkPartnerIDs)
          && Objects.equals(oneLinkID, lOther.oneLinkID);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("heyBrotherID: ");
    lBuilder.append(heyBrotherID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("softLinkPartnerIDs: ");
    if (softLinkPartnerIDs != null) {
      lBuilder.append(softLinkPartnerIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (softLinkPartnerIDs != null) {
      for (String lNext : softLinkPartnerIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("oneLinkID: ");
    lBuilder.append(oneLinkID);
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
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildB objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}