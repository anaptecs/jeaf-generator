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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
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
  private String heyBrother;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #softLinkPartners} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  @JsonSetter(nulls = Nulls.SKIP)
  private Set<String> softLinkPartners;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   */
  private SoftLinkID oneLink;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLinkChildB( ) {
    softLinkPartners = new HashSet<String>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkChildB( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    heyBrother = pBuilder.heyBrother;
    if (pBuilder.softLinkPartners != null) {
      softLinkPartners = pBuilder.softLinkPartners;
    }
    else {
      softLinkPartners = new HashSet<String>();
    }
    oneLink = pBuilder.oneLink;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildB objects. The method never returns
   * null.
   */
  public static Builder builder( SoftLinkChildB pObject ) {
    return new Builder(pObject);
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
  public static SoftLinkChildB of( Set<SoftLinkID> pPartners, SoftLinkID pThePartner, SoftLinkID pOneLink ) {
    SoftLinkChildB.Builder lBuilder = SoftLinkChildB.builder();
    lBuilder.setPartners(pPartners);
    lBuilder.setThePartner(pThePartner);
    lBuilder.setOneLink(pOneLink);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkChildB</code>.
   */
  public static class Builder extends SoftLinkParent.Builder {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #heyBrother} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private String heyBrother;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #softLinkPartners}
     * is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private Set<String> softLinkPartners;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
     */
    private SoftLinkID oneLink;

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
        heyBrother = pObject.heyBrother;
        softLinkPartners = pObject.softLinkPartners;
        oneLink = pObject.oneLink;
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setPartners( Set<SoftLinkID> pPartners ) {
      // Call super class implementation.
      super.setPartners(pPartners);
      return this;
    }

    /**
     * Method sets association {@link #thePartner}.<br/>
     *
     * @param pThePartner Value to which {@link #thePartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setThePartner( SoftLinkID pThePartner ) {
      // Call super class implementation.
      super.setThePartner(pThePartner);
      return this;
    }

    /**
     * Method sets association {@link #readonlyPartner}.<br/>
     *
     * @param pReadonlyPartner Value to which {@link #readonlyPartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setReadonlyPartner( SoftLinkID pReadonlyPartner ) {
      // Call super class implementation.
      super.setReadonlyPartner(pReadonlyPartner);
      return this;
    }

    /**
     * Method sets association {@link #heyBrother}.<br/>
     *
     * @param pHeyBrother Value to which {@link #heyBrother} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHeyBrother( String pHeyBrother ) {
      heyBrother = pHeyBrother;
      return this;
    }

    /**
     * Method sets association {@link #softLinkPartners}.<br/>
     *
     * @param pSoftLinkPartners Collection to which {@link #softLinkPartners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSoftLinkPartners( Set<String> pSoftLinkPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSoftLinkPartners != null) {
        softLinkPartners = new HashSet<String>(pSoftLinkPartners);
      }
      else {
        softLinkPartners = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #oneLink}.<br/>
     *
     * @param pOneLink Value to which {@link #oneLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOneLink( SoftLinkID pOneLink ) {
      oneLink = pOneLink;
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
  public String getHeyBrother( ) {
    return heyBrother;
  }

  /**
   * Method sets association {@link #heyBrother}.<br/>
   *
   * @param pHeyBrother Value to which {@link #heyBrother} should be set.
   */
  public void setHeyBrother( String pHeyBrother ) {
    heyBrother = pHeyBrother;
  }

  /**
   * Method unsets {@link #heyBrother}.
   */
  public final void unsetHeyBrother( ) {
    heyBrother = null;
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
  public Set<String> getSoftLinkPartners( ) {
    // Return all SoftLinkPartner objects as unmodifiable collection.
    return Collections.unmodifiableSet(softLinkPartners);
  }

  /**
   * Method adds the passed object to {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Object that should be added to {@link #softLinkPartners}. The parameter must not be null.
   */
  public void addToSoftLinkPartners( String pSoftLinkPartners ) {
    // Check parameter "pSoftLinkPartners" for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Add passed object to collection of associated SoftLinkPartner objects.
    softLinkPartners.add(pSoftLinkPartners);
  }

  /**
   * Method adds all passed objects to {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Collection with all objects that should be added to {@link #softLinkPartners}. The
   * parameter must not be null.
   */
  public void addToSoftLinkPartners( Collection<String> pSoftLinkPartners ) {
    // Check parameter "pSoftLinkPartners" for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Add all passed objects.
    for (String lNextObject : pSoftLinkPartners) {
      this.addToSoftLinkPartners(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #softLinkPartners}.
   *
   * @param pSoftLinkPartners Object that should be removed from {@link #softLinkPartners}. The parameter must not be
   * null.
   */
  public void removeFromSoftLinkPartners( String pSoftLinkPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Remove passed object from collection of associated SoftLinkPartner objects.
    softLinkPartners.remove(pSoftLinkPartners);
  }

  /**
   * Method removes all objects from {@link #softLinkPartners}.
   */
  public void clearSoftLinkPartners( ) {
    // Remove all objects from association "softLinkPartners".
    softLinkPartners.clear();
  }

  /**
   * Method returns association {@link #oneLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #oneLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #oneLink} is set.
   */
  public SoftLinkID getOneLink( ) {
    return oneLink;
  }

  /**
   * Method sets association {@link #oneLink}.<br/>
   *
   * @param pOneLink Value to which {@link #oneLink} should be set.
   */
  public void setOneLink( SoftLinkID pOneLink ) {
    oneLink = pOneLink;
  }

  /**
   * Method unsets {@link #oneLink}.
   */
  public final void unsetOneLink( ) {
    oneLink = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(heyBrother);
    lResult = lPrime * lResult + Objects.hashCode(softLinkPartners);
    lResult = lPrime * lResult + Objects.hashCode(oneLink);
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
      lEquals = Objects.equals(heyBrother, lOther.heyBrother)
          && Objects.equals(softLinkPartners, lOther.softLinkPartners) && Objects.equals(oneLink, lOther.oneLink);
    }
    return lEquals;
  }
}
