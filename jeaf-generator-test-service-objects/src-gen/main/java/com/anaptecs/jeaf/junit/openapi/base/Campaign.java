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
public class Campaign implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "discountOffers".
   */
  public static final String DISCOUNTOFFERS = "discountOffers";

  /**
   * 
   */
  private Set<DiscountOffer> discountOffers = new HashSet<DiscountOffer>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Campaign( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Campaign( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.discountOffers != null) {
      discountOffers.addAll(pBuilder.discountOffers);
    }
  }

  /**
   * Class implements builder to create a new instance of class Campaign. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<DiscountOffer> discountOffers;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Campaign)} instead of private constructor to create new builder.
     */
    protected Builder( Campaign pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        discountOffers = pObject.discountOffers;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Campaign objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Campaign pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "discountOffers".
     * 
     * @param pDiscountOffers Collection with objects to which the association should be set.
     */
    public Builder setDiscountOffers( Set<DiscountOffer> pDiscountOffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDiscountOffers != null) {
        discountOffers = new HashSet<DiscountOffer>(pDiscountOffers);
      }
      else {
        discountOffers = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Campaign. The object will be initialized with the values of the builder.
     * 
     * @return Campaign Created object. The method never returns null.
     */
    public Campaign build( ) {
      return new Campaign(this);
    }

    /**
     * Method creates a new validated instance of class Campaign. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Campaign Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Campaign buildValidated( ) throws ConstraintViolationException {
      Campaign lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "discountOffers".
   * 
   *
   * @return Collection All DiscountOffer objects that belong to the association "discountOffers". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<DiscountOffer> getDiscountOffers( ) {
    // Return all DiscountOffer objects as unmodifiable collection.
    return Collections.unmodifiableSet(discountOffers);
  }

  /**
   * Method sets the association "discountOffers" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pDiscountOffers Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setDiscountOffers( Set<DiscountOffer> pDiscountOffers ) {
    // Check of parameter is not required.
    // Remove all objects from association "discountOffers".
    this.clearDiscountOffers();
    // If the association is null, removing all entries is sufficient.
    if (pDiscountOffers != null) {
      discountOffers = new HashSet<DiscountOffer>(pDiscountOffers);
    }
  }

  /**
   * Method adds the passed DiscountOffer object to the association "discountOffers".
   * 
   * 
   * @param pDiscountOffers Object that should be added to the association "discountOffers". The parameter must not be
   * null.
   */
  public void addToDiscountOffers( DiscountOffer pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add passed object to collection of associated DiscountOffer objects.
    discountOffers.add(pDiscountOffers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pDiscountOffers != null && pDiscountOffers.getCampaigns().contains(this) == false) {
      pDiscountOffers.addToCampaigns((Campaign) this);
    }
  }

  /**
   * Method adds all passed objects to the association "discountOffers".
   * 
   * 
   * @param pDiscountOffers Collection with all objects that should be added to the association "discountOffers". The
   * parameter must not be null.
   */
  public void addToDiscountOffers( Collection<DiscountOffer> pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add all passed objects.
    for (DiscountOffer lNextObject : pDiscountOffers) {
      this.addToDiscountOffers(lNextObject);
    }
  }

  /**
   * Method removes the passed DiscountOffer object from the association "discountOffers".
   * 
   * 
   * @param pDiscountOffers Object that should be removed from the association "discountOffers". The parameter must not
   * be null.
   */
  public void removeFromDiscountOffers( DiscountOffer pDiscountOffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Remove passed object from collection of associated DiscountOffer objects.
    discountOffers.remove(pDiscountOffers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pDiscountOffers.getCampaigns().contains(this) == true) {
      pDiscountOffers.removeFromCampaigns((Campaign) this);
    }
  }

  /**
   * Method removes all objects from the association "discountOffers".
   * 
   */
  public void clearDiscountOffers( ) {
    // Remove all objects from association "discountOffers".
    Collection<DiscountOffer> lDiscountOffers = new HashSet<DiscountOffer>(discountOffers);
    Iterator<DiscountOffer> lIterator = lDiscountOffers.iterator();
    while (lIterator.hasNext()) {
      this.removeFromDiscountOffers(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
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
