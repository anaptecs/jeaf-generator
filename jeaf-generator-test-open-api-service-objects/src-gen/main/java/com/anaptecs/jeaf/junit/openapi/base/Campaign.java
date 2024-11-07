/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class Campaign implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The magic link.
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  private long theLinkID;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  @JsonSetter(nulls = Nulls.SKIP)
  @Size(min = 1)
  @NotNull
  private Set<Long> moreLinkIDs;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
   */
  @Deprecated
  @JsonSetter(nulls = Nulls.SKIP)
  private List<String> discountOfferIDs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Campaign( ) {
    moreLinkIDs = new HashSet<Long>();
    discountOfferIDs = new ArrayList<String>();
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
    theLinkID = pBuilder.theLinkID;
    if (pBuilder.moreLinkIDs != null) {
      moreLinkIDs = pBuilder.moreLinkIDs;
    }
    else {
      moreLinkIDs = new HashSet<Long>();
    }
    if (pBuilder.discountOfferIDs != null) {
      discountOfferIDs = pBuilder.discountOfferIDs;
    }
    else {
      discountOfferIDs = new ArrayList<String>();
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
  public static Campaign of( Set<Long> pMoreLinkIDs ) {
    Campaign.Builder lBuilder = Campaign.builder();
    lBuilder.setMoreLinkIDs(pMoreLinkIDs);
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
    private long theLinkID;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
     *
     * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
     */
    @Deprecated
    @Size(min = 1)
    @NotNull
    private Set<Long> moreLinkIDs;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
     */
    @Deprecated
    private List<String> discountOfferIDs;

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
        this.setTheLinkID(pObject.theLinkID);
        this.setMoreLinkIDs(pObject.moreLinkIDs);
        this.setDiscountOfferIDs(pObject.discountOfferIDs);
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
    public Builder setTheLinkID( long pTheLink ) {
      theLinkID = pTheLink;
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
    public Builder setMoreLinkIDs( @MyNotEmptyProperty Set<Long> pMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMoreLinks != null) {
        moreLinkIDs = new HashSet<Long>(pMoreLinks);
      }
      else {
        moreLinkIDs = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #discountOffers}.<br/>
     *
     * @param pDiscountOffers Collection to which {@link #discountOffers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDiscountOfferIDs( List<String> pDiscountOffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDiscountOffers != null) {
        discountOfferIDs = new ArrayList<String>(pDiscountOffers);
      }
      else {
        discountOfferIDs = null;
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
  public long getTheLinkID( ) {
    return theLinkID;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   * The magic link.
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  public void setTheLinkID( long pTheLink ) {
    theLinkID = pTheLink;
  }

  /**
   * Method returns association {@link #moreLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @return {@link Set<Long>} Value to which {@link #moreLinks} is set. The method never returns null and the returned
   * collection is modifiable.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  @MyNotEmptyProperty
  public Set<Long> getMoreLinkIDs( ) {
    // Return all LinkObject objects directly without any protection against modification.
    return moreLinkIDs;
  }

  /**
   * Method adds the passed object to {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be added to {@link #moreLinks}. The parameter must not be null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToMoreLinkIDs( Long pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    moreLinkIDs.add(pMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #moreLinks}.
   *
   * @param pMoreLinks Collection with all objects that should be added to {@link #moreLinks}. The parameter must not be
   * null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToMoreLinkIDs( Collection<Long> pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add all passed objects.
    for (Long lNextObject : pMoreLinks) {
      this.addToMoreLinkIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be removed from {@link #moreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromMoreLinkIDs( Long pMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    moreLinkIDs.remove(pMoreLinks);
  }

  /**
   * Method removes all objects from {@link #moreLinks}.
   */
  @Deprecated
  public void clearMoreLinkIDs( ) {
    // Remove all objects from association "moreLinks".
    moreLinkIDs.clear();
  }

  /**
   * Method returns association {@link #discountOffers}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
   *
   * @return {@link List<String>} Value to which {@link #discountOffers} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  @Deprecated
  public List<String> getDiscountOfferIDs( ) {
    // Return all DiscountOffer objects directly without any protection against modification.
    return discountOfferIDs;
  }

  /**
   * Method adds the passed object to {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be added to {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  public void addToDiscountOfferIDs( String pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add passed object to collection of associated DiscountOffer objects.
    discountOfferIDs.add(pDiscountOffers);
  }

  /**
   * Method adds all passed objects to {@link #discountOffers}.
   *
   * @param pDiscountOffers Collection with all objects that should be added to {@link #discountOffers}. The parameter
   * must not be null.
   */
  @Deprecated
  public void addToDiscountOfferIDs( Collection<String> pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add all passed objects.
    for (String lNextObject : pDiscountOffers) {
      this.addToDiscountOfferIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be removed from {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromDiscountOfferIDs( String pDiscountOffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Remove passed object from collection of associated DiscountOffer objects.
    discountOfferIDs.remove(pDiscountOffers);
  }

  /**
   * Method removes all objects from {@link #discountOffers}.
   */
  @Deprecated
  public void clearDiscountOfferIDs( ) {
    // Remove all objects from association "discountOffers".
    discountOfferIDs.clear();
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
    lBuilder.append("theLinkID: ");
    lBuilder.append(theLinkID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("moreLinkIDs: ");
    if (moreLinkIDs != null) {
      lBuilder.append(moreLinkIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (moreLinkIDs != null) {
      for (Long lNext : moreLinkIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("discountOfferIDs: ");
    if (discountOfferIDs != null) {
      lBuilder.append(discountOfferIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (discountOfferIDs != null) {
      for (String lNext : discountOfferIDs) {
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
   * @return {@link Builder} New builder that can be used to create new Campaign objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}