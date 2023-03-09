/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

  private String heyBrother;

  private Set<String> softLinkPartners;

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
   * Class implements builder to create a new instance of class SoftLinkChildB. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends SoftLinkParent.Builder {
    /**
     * 
     */
    private String heyBrother;

    /**
     * 
     */
    private Set<String> softLinkPartners;

    /**
     * 
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
     * Method sets the association "partners".
     * 
     * @param pPartners Collection with objects to which the association should be set.
     */
    @Override
    public Builder setPartners( Set<SoftLinkID> pPartners ) {
      // Call super class implementation.
      super.setPartners(pPartners);
      return this;
    }

    /**
     * Method sets the association "thePartner".
     * 
     * @param pThePartner SoftLinkPartner to which the association "thePartner" should be set.
     */
    @Override
    public Builder setThePartner( SoftLinkID pThePartner ) {
      // Call super class implementation.
      super.setThePartner(pThePartner);
      return this;
    }

    /**
     * Method sets the association "readonlyPartner".
     * 
     * @param pReadonlyPartner SoftLinkPartner to which the association "readonlyPartner" should be set.
     */
    @Override
    public Builder setReadonlyPartner( SoftLinkID pReadonlyPartner ) {
      // Call super class implementation.
      super.setReadonlyPartner(pReadonlyPartner);
      return this;
    }

    /**
     * Method sets the association "heyBrother".
     * 
     * @param pHeyBrother SoftLinkChildA to which the association "heyBrother" should be set.
     */
    public Builder setHeyBrother( String pHeyBrother ) {
      heyBrother = pHeyBrother;
      return this;
    }

    /**
     * Method sets the association "softLinkPartners".
     * 
     * @param pSoftLinkPartners Collection with objects to which the association should be set.
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
     * Method sets the association "oneLink".
     * 
     * @param pOneLink SoftLinkPartner to which the association "oneLink" should be set.
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
      SoftLinkChildB lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #heyBrother}.<br/>
   * 
   * @return {@link String} Value to which {@link #heyBrother} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA
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
   * Method unsets the association "heyBrother".
   * 
   */
  public final void unsetHeyBrother( ) {
    heyBrother = null;
  }

  /**
   * Method returns the association "softLinkPartners".
   * 
   *
   * @return Collection All SoftLinkPartner objects that belong to the association "softLinkPartners". The method never
   * returns null and the returned collection is unmodifiable.
   */
  /**
   * Method returns association {@link #softLinkPartners}.<br/>
   * 
   * @return {@link Set<String>} Value to which {@link #softLinkPartners} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner
   */
  public Set<String> getSoftLinkPartners( ) {
    // Return all SoftLinkPartner objects as unmodifiable collection.
    return Collections.unmodifiableSet(softLinkPartners);
  }

  /**
   * Method adds the passed SoftLinkPartner object to the association "softLinkPartners".
   * 
   * 
   * @param pSoftLinkPartners Object that should be added to the association "softLinkPartners". The parameter must not
   * be null.
   */
  public void addToSoftLinkPartners( String pSoftLinkPartners ) {
    // Check parameter "pSoftLinkPartners" for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Add passed object to collection of associated SoftLinkPartner objects.
    softLinkPartners.add(pSoftLinkPartners);
  }

  /**
   * Method adds all passed objects to the association "softLinkPartners".
   * 
   * 
   * @param pSoftLinkPartners Collection with all objects that should be added to the association "softLinkPartners".
   * The parameter must not be null.
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
   * Method removes the passed SoftLinkPartner object from the association "softLinkPartners".
   * 
   * 
   * @param pSoftLinkPartners Object that should be removed from the association "softLinkPartners". The parameter must
   * not be null.
   */
  public void removeFromSoftLinkPartners( String pSoftLinkPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSoftLinkPartners, "pSoftLinkPartners");
    // Remove passed object from collection of associated SoftLinkPartner objects.
    softLinkPartners.remove(pSoftLinkPartners);
  }

  /**
   * Method removes all objects from the association "softLinkPartners".
   * 
   */
  public void clearSoftLinkPartners( ) {
    // Remove all objects from association "softLinkPartners".
    softLinkPartners.clear();
  }

  /**
   * Method returns association {@link #oneLink}.<br/>
   * 
   * @return {@link SoftLinkID} Value to which {@link #oneLink} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner
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
   * Method unsets the association "oneLink".
   * 
   */
  public final void unsetOneLink( ) {
    oneLink = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
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
}
