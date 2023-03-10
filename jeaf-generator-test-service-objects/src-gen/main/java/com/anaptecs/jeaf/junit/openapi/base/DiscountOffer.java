/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class DiscountOffer implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "campaigns".
   */
  @Deprecated
  public static final String CAMPAIGNS = "campaigns";

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
   */
  @Deprecated
  private Set<SoftLink> campaigns;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DiscountOffer( ) {
    campaigns = new HashSet<SoftLink>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DiscountOffer( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.campaigns != null) {
      campaigns = pBuilder.campaigns;
    }
    else {
      campaigns = new HashSet<SoftLink>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DiscountOffer objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DiscountOffer objects. The method never returns
   * null.
   */
  public static Builder builder( DiscountOffer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class DiscountOffer. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
     */
    @Deprecated
    private Set<SoftLink> campaigns;

    /**
     * Use {@link DiscountOffer#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DiscountOffer#builder(DiscountOffer)} instead of private constructor to create new builder.
     */
    protected Builder( DiscountOffer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        campaigns = pObject.campaigns;
      }
    }

    /**
     * Method sets the association "campaigns".
     * 
     * @param pCampaigns Collection with objects to which the association should be set.
     */
    @Deprecated
    public Builder setCampaigns( Set<SoftLink> pCampaigns ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCampaigns != null) {
        campaigns = new HashSet<SoftLink>(pCampaigns);
      }
      else {
        campaigns = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class DiscountOffer. The object will be initialized with the values of the
     * builder.
     * 
     * @return DiscountOffer Created object. The method never returns null.
     */
    public DiscountOffer build( ) {
      return new DiscountOffer(this);
    }

    /**
     * Method creates a new validated instance of class DiscountOffer. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return DiscountOffer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DiscountOffer buildValidated( ) throws ConstraintViolationException {
      DiscountOffer lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #campaigns}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
   * 
   * @return {@link Set<SoftLink>} Value to which {@link #campaigns} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<SoftLink> getCampaigns( ) {
    // Return all Campaign objects as unmodifiable collection.
    return Collections.unmodifiableSet(campaigns);
  }

  /**
   * Method adds the passed object to {@link #campaigns}.
   * 
   * @param pCampaigns Object that should be added to {@link #campaigns}. The parameter must not be null.
   */
  @Deprecated
  public void addToCampaigns( SoftLink pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add passed object to collection of associated Campaign objects.
    campaigns.add(pCampaigns);
  }

  /**
   * Method adds all passed objects to {@link #campaigns}.
   * 
   * @param pCampaigns Collection with all objects that should be added to {@link #campaigns}. The parameter must not be
   * null.
   */
  @Deprecated
  public void addToCampaigns( Collection<SoftLink> pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add all passed objects.
    for (SoftLink lNextObject : pCampaigns) {
      this.addToCampaigns(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #campaigns}.
   * 
   * @param pCampaigns Object that should be removed from {@link #campaigns}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromCampaigns( SoftLink pCampaigns ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Remove passed object from collection of associated Campaign objects.
    campaigns.remove(pCampaigns);
  }

  /**
   * Method removes all objects from {@link #campaigns}.
   */
  @Deprecated
  public void clearCampaigns( ) {
    // Remove all objects from association "campaigns".
    campaigns.clear();
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
}
