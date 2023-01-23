/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Campaign implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  private List<DiscountOffer> discountOffers;

  /**
   * 
   */
  @Deprecated
  private LinkObject theLink;

  /**
   * 
   */
  @Deprecated
  @Size(min = 1)
  @NotNull
  private Set<LinkObject> moreLinks;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Campaign( ) {
    discountOffers = new ArrayList<DiscountOffer>();
    moreLinks = new HashSet<LinkObject>();
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
      discountOffers = pBuilder.discountOffers;
    }
    else {
      discountOffers = new ArrayList<DiscountOffer>();
    }
    theLink = pBuilder.theLink;
    if (pBuilder.moreLinks != null) {
      moreLinks = pBuilder.moreLinks;
    }
    else {
      moreLinks = new HashSet<LinkObject>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Campaign objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Campaign objects. The method never returns null.
   */
  public static Builder builder( Campaign pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Campaign. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<DiscountOffer> discountOffers;

    /**
     * 
     */
    @Deprecated
    private LinkObject theLink;

    /**
     * 
     */
    @Deprecated
    private Set<LinkObject> moreLinks;

    /**
     * Use {@link Campaign#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Campaign#builder(Campaign)} instead of private constructor to create new builder.
     */
    protected Builder( Campaign pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        discountOffers = pObject.discountOffers;
        theLink = pObject.theLink;
        moreLinks = pObject.moreLinks;
      }
    }

    /**
     * Method sets the association "discountOffers".
     * 
     * @param pDiscountOffers Collection with objects to which the association should be set.
     */
    public Builder setDiscountOffers( List<DiscountOffer> pDiscountOffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDiscountOffers != null) {
        discountOffers = new ArrayList<DiscountOffer>(pDiscountOffers);
      }
      else {
        discountOffers = null;
      }
      return this;
    }

    /**
     * Method sets the association "theLink".
     * 
     * @param pTheLink LinkObject to which the association "theLink" should be set.
     */
    public Builder setTheLink( LinkObject pTheLink ) {
      theLink = pTheLink;
      return this;
    }

    /**
     * Method sets the association "moreLinks".
     * 
     * @param pMoreLinks Collection with objects to which the association should be set.
     */
    @Deprecated
    public Builder setMoreLinks( Set<LinkObject> pMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMoreLinks != null) {
        moreLinks = new HashSet<LinkObject>(pMoreLinks);
      }
      else {
        moreLinks = null;
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
   * returns null and the returned collection is modifiable.
   */
  public List<DiscountOffer> getDiscountOffers( ) {
    // Return all DiscountOffer objects directly without any protection against modification.
    return discountOffers;
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
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromDiscountOffers(lIterator.next());
    }
  }

  /**
   * Method returns the association "theLink".
   * 
   *
   * @return LinkObject LinkObject to which the association "theLink" is set.
   */
  @Deprecated
  public LinkObject getTheLink( ) {
    return theLink;
  }

  /**
   * Method sets the association "theLink".
   * 
   * 
   * @param pTheLink LinkObject to which the association "theLink" should be set.
   */
  @Deprecated
  public void setTheLink( LinkObject pTheLink ) {
    theLink = pTheLink;
  }

  /**
   * Method unsets the association "theLink".
   * 
   */
  @Deprecated
  public final void unsetTheLink( ) {
    theLink = null;
  }

  /**
   * Method returns the association "moreLinks".
   * 
   *
   * @return Collection All LinkObject objects that belong to the association "moreLinks". The method never returns null
   * and the returned collection is modifiable.
   */
  @Deprecated
  public Set<LinkObject> getMoreLinks( ) {
    // Return all LinkObject objects directly without any protection against modification.
    return moreLinks;
  }

  /**
   * Method adds the passed LinkObject object to the association "moreLinks".
   * 
   * 
   * @param pMoreLinks Object that should be added to the association "moreLinks". The parameter must not be null.
   */
  @Deprecated
  public void addToMoreLinks( LinkObject pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    moreLinks.add(pMoreLinks);
  }

  /**
   * Method adds all passed objects to the association "moreLinks".
   * 
   * 
   * @param pMoreLinks Collection with all objects that should be added to the association "moreLinks". The parameter
   * must not be null.
   */
  @Deprecated
  public void addToMoreLinks( Collection<LinkObject> pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add all passed objects.
    for (LinkObject lNextObject : pMoreLinks) {
      this.addToMoreLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed LinkObject object from the association "moreLinks".
   * 
   * 
   * @param pMoreLinks Object that should be removed from the association "moreLinks". The parameter must not be null.
   */
  @Deprecated
  public void removeFromMoreLinks( LinkObject pMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    moreLinks.remove(pMoreLinks);
  }

  /**
   * Method removes all objects from the association "moreLinks".
   * 
   */
  @Deprecated
  public void clearMoreLinks( ) {
    // Remove all objects from association "moreLinks".
    moreLinks.clear();
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
    lBuilder.append("discountOffers: ");
    if (discountOffers != null) {
      lBuilder.append(discountOffers.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (discountOffers != null) {
      for (DiscountOffer lNext : discountOffers) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("theLink: ");
    if (theLink != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(theLink.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("moreLinks: ");
    if (moreLinks != null) {
      lBuilder.append(moreLinks.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (moreLinks != null) {
      for (LinkObject lNext : moreLinks) {
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
}
