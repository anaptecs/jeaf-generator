/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class DiscountOffer implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
   */
  @Deprecated
  @JsonSetter(nulls = Nulls.SKIP)
  private Set<SoftLink> campaignIDs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DiscountOffer( ) {
    campaignIDs = new HashSet<SoftLink>();
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
    if (pBuilder.campaignIDs != null) {
      campaignIDs = pBuilder.campaignIDs;
    }
    else {
      campaignIDs = new HashSet<SoftLink>();
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
   * Convenience method to create new instance of class DiscountOffer.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.DiscountOffer}
   */
  public static DiscountOffer of( ) {
    DiscountOffer.Builder lBuilder = DiscountOffer.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DiscountOffer</code>.
   */
  public static class Builder {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
     */
    @Deprecated
    private Set<SoftLink> campaignIDs;

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
        this.setCampaignIDs(pObject.campaignIDs);
      }
    }

    /**
     * Method sets association {@link #campaigns}.<br/>
     *
     * @param pCampaigns Collection to which {@link #campaigns} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setCampaignIDs( Set<SoftLink> pCampaigns ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCampaigns != null) {
        campaignIDs = new HashSet<SoftLink>(pCampaigns);
      }
      else {
        campaignIDs = null;
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
      DiscountOffer lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #campaigns}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #campaigns} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.Campaign</code><br/>
   *
   * @return {@link Set<SoftLink>} Value to which {@link #campaigns} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  @Deprecated
  public Set<SoftLink> getCampaignIDs( ) {
    // Return all Campaign objects directly without any protection against modification.
    return campaignIDs;
  }

  /**
   * Method adds the passed object to {@link #campaigns}.
   *
   * @param pCampaigns Object that should be added to {@link #campaigns}. The parameter must not be null.
   */
  @Deprecated
  public void addToCampaignIDs( SoftLink pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add passed object to collection of associated Campaign objects.
    campaignIDs.add(pCampaigns);
  }

  /**
   * Method adds all passed objects to {@link #campaigns}.
   *
   * @param pCampaigns Collection with all objects that should be added to {@link #campaigns}. The parameter must not be
   * null.
   */
  @Deprecated
  public void addToCampaignIDs( Collection<SoftLink> pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add all passed objects.
    for (SoftLink lNextObject : pCampaigns) {
      this.addToCampaignIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #campaigns}.
   *
   * @param pCampaigns Object that should be removed from {@link #campaigns}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromCampaignIDs( SoftLink pCampaigns ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Remove passed object from collection of associated Campaign objects.
    campaignIDs.remove(pCampaigns);
  }

  /**
   * Method removes all objects from {@link #campaigns}.
   */
  @Deprecated
  public void clearCampaignIDs( ) {
    // Remove all objects from association "campaigns".
    campaignIDs.clear();
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
    lBuilder.append("campaigns: ");
    if (campaignIDs != null) {
      lBuilder.append(campaignIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (campaignIDs != null) {
      for (SoftLink lNext : campaignIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
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
   * @return {@link Builder} New builder that can be used to create new DiscountOffer objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
