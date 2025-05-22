/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class Campaign implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "theLink".
   */
  @Deprecated
  public static final String THELINK = "theLink";

  /**
   * Constant for the name of attribute "moreLinks".
   */
  @Deprecated
  public static final String MORELINKS = "moreLinks";

  /**
   * Constant for the name of attribute "discountOffers".
   */
  @Deprecated
  public static final String DISCOUNTOFFERS = "discountOffers";

  /**
   * The magic link.
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  private long theLinkLink;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  private Set<Long> moreLinkLinks;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
   */
  @Deprecated
  private List<String> discountOfferLinks;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Campaign( ) {
    moreLinkLinks = new HashSet<>();
    discountOfferLinks = new ArrayList<>();
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
    theLinkLink = pBuilder.theLinkLink;
    if (pBuilder.moreLinkLinks != null) {
      moreLinkLinks = pBuilder.moreLinkLinks;
    }
    else {
      moreLinkLinks = new HashSet<>();
    }
    if (pBuilder.discountOfferLinks != null) {
      discountOfferLinks = pBuilder.discountOfferLinks;
    }
    else {
      discountOfferLinks = new ArrayList<>();
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
   * Convenience method to create new instance of class Campaign.
   *
   *
   * @param pMoreLinks Value to which {@link #moreLinks} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.Campaign}
   */
  public static Campaign of( Set<Long> pMoreLinkLinks ) {
    Campaign.Builder lBuilder = Campaign.builder();
    lBuilder.setMoreLinkLinks(pMoreLinkLinks);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Campaign</code>.
   */
  public static class Builder {
    /**
     * The magic link.
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
     *
     * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
     */
    @Deprecated
    private long theLinkLink;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
     *
     * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
     */
    @Deprecated
    private Set<Long> moreLinkLinks;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
     */
    @Deprecated
    private List<String> discountOfferLinks;

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
        this.setTheLinkLink(pObject.theLinkLink);
        this.setMoreLinkLinks(pObject.moreLinkLinks);
        this.setDiscountOfferLinks(pObject.discountOfferLinks);
      }
    }

    /**
     * Method sets association {@link #theLink}.<br/>
     *
     * @param pTheLink Value to which {@link #theLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
     */
    @Deprecated
    public Builder setTheLinkLink( long pTheLink ) {
      theLinkLink = pTheLink;
      return this;
    }

    /**
     * Method sets association {@link #moreLinks}.<br/>
     *
     * @param pMoreLinks Collection to which {@link #moreLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
     */
    @Deprecated
    public Builder setMoreLinkLinks( Set<Long> pMoreLinks ) {
      moreLinkLinks = pMoreLinks;
      return this;
    }

    /**
     * Method sets association {@link #discountOffers}.<br/>
     *
     * @param pDiscountOffers Collection to which {@link #discountOffers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDiscountOfferLinks( List<String> pDiscountOffers ) {
      discountOfferLinks = pDiscountOffers;
      return this;
    }

    /**
     * Method creates a new instance of class Campaign. The object will be initialized with the values of the builder.
     *
     * @return Campaign Created object. The method never returns null.
     */
    public Campaign build( ) {
      Campaign lObject = new Campaign(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class Campaign. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Campaign Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Campaign buildValidated( ) throws ConstraintViolationException {
      Campaign lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #theLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   * The magic link.
   *
   * @return {@link long} Value to which {@link #theLink} is set.
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  public long getTheLinkLink( ) {
    return theLinkLink;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   * The magic link.
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  public void setTheLinkLink( long pTheLink ) {
    theLinkLink = pTheLink;
  }

  /**
   * Method returns association {@link #moreLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @return {@link Set<Long>} Value to which {@link #moreLinks} is set. The method never returns null and the returned
   * collection is unmodifiable.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public Set<Long> getMoreLinkLinks( ) {
    // Return all LinkObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(moreLinkLinks);
  }

  /**
   * Method adds the passed object to {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be added to {@link #moreLinks}. The parameter must not be null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToMoreLinkLinks( Long pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    moreLinkLinks.add(pMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #moreLinks}.
   *
   * @param pMoreLinks Collection with all objects that should be added to {@link #moreLinks}. The parameter must not be
   * null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToMoreLinkLinks( Collection<Long> pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add all passed objects.
    for (Long lNextObject : pMoreLinks) {
      this.addToMoreLinkLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be removed from {@link #moreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromMoreLinkLinks( Long pMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    moreLinkLinks.remove(pMoreLinks);
  }

  /**
   * Method removes all objects from {@link #moreLinks}.
   */
  @Deprecated
  public void clearMoreLinkLinks( ) {
    // Remove all objects from association "moreLinks".
    moreLinkLinks.clear();
  }

  /**
   * Method returns association {@link #discountOffers}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
   *
   * @return {@link List<String>} Value to which {@link #discountOffers} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public List<String> getDiscountOfferLinks( ) {
    // Return all DiscountOffer objects as unmodifiable collection.
    return Collections.unmodifiableList(discountOfferLinks);
  }

  /**
   * Method adds the passed object to {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be added to {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  public void addToDiscountOfferLinks( String pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add passed object to collection of associated DiscountOffer objects.
    discountOfferLinks.add(pDiscountOffers);
  }

  /**
   * Method adds all passed objects to {@link #discountOffers}.
   *
   * @param pDiscountOffers Collection with all objects that should be added to {@link #discountOffers}. The parameter
   * must not be null.
   */
  @Deprecated
  public void addToDiscountOfferLinks( Collection<String> pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add all passed objects.
    for (String lNextObject : pDiscountOffers) {
      this.addToDiscountOfferLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be removed from {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromDiscountOfferLinks( String pDiscountOffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Remove passed object from collection of associated DiscountOffer objects.
    discountOfferLinks.remove(pDiscountOffers);
  }

  /**
   * Method removes all objects from {@link #discountOffers}.
   */
  @Deprecated
  public void clearDiscountOfferLinks( ) {
    // Remove all objects from association "discountOffers".
    discountOfferLinks.clear();
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Campaign objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}