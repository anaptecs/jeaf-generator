/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class DiscountOffer implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "campaigns".
   */
  public static final String CAMPAIGNS = "campaigns";

  /**
   * 
   */
  private Set<Campaign> campaigns;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected DiscountOffer( ) {
    campaigns = new HashSet<Campaign>();
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
      campaigns = new HashSet<Campaign>();
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
     * 
     */
    private Set<Campaign> campaigns;

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
    public Builder setCampaigns( Set<Campaign> pCampaigns ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCampaigns != null) {
        campaigns = new HashSet<Campaign>(pCampaigns);
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
   * Method returns the association "campaigns".
   * 
   *
   * @return Collection All Campaign objects that belong to the association "campaigns". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<Campaign> getCampaigns( ) {
    // Return all Campaign objects as unmodifiable collection.
    return Collections.unmodifiableSet(campaigns);
  }

  /**
   * Method adds the passed Campaign object to the association "campaigns".
   * 
   * 
   * @param pCampaigns Object that should be added to the association "campaigns". The parameter must not be null.
   */
  public void addToCampaigns( Campaign pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add passed object to collection of associated Campaign objects.
    campaigns.add(pCampaigns);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCampaigns != null && pCampaigns.getDiscountOffers().contains(this) == false) {
      pCampaigns.addToDiscountOffers((DiscountOffer) this);
    }
  }

  /**
   * Method adds all passed objects to the association "campaigns".
   * 
   * 
   * @param pCampaigns Collection with all objects that should be added to the association "campaigns". The parameter
   * must not be null.
   */
  public void addToCampaigns( Collection<Campaign> pCampaigns ) {
    // Check parameter "pCampaigns" for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Add all passed objects.
    for (Campaign lNextObject : pCampaigns) {
      this.addToCampaigns(lNextObject);
    }
  }

  /**
   * Method removes the passed Campaign object from the association "campaigns".
   * 
   * 
   * @param pCampaigns Object that should be removed from the association "campaigns". The parameter must not be null.
   */
  public void removeFromCampaigns( Campaign pCampaigns ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCampaigns, "pCampaigns");
    // Remove passed object from collection of associated Campaign objects.
    campaigns.remove(pCampaigns);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCampaigns.getDiscountOffers().contains(this) == true) {
      pCampaigns.removeFromDiscountOffers((DiscountOffer) this);
    }
  }

  /**
   * Method removes all objects from the association "campaigns".
   * 
   */
  public void clearCampaigns( ) {
    // Remove all objects from association "campaigns".
    Collection<Campaign> lCampaigns = new HashSet<Campaign>(campaigns);
    Iterator<Campaign> lIterator = lCampaigns.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromCampaigns(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
