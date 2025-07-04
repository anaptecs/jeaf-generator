/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Campaign extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "theLink".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String THELINK = "theLink";

  /**
   * Constant for the name of attribute "moreLinks".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String MORELINKS = "moreLinks";

  /**
   * Constant for the name of attribute "discountOffers".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String DISCOUNTOFFERS = "discountOffers";

  /**
   * The magic link.
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private long theLink;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  private int theLinkXYZ = 0;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
   *
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private Set<Long> moreLinks;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  private int moreLinksXYZ = 0;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
   * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
   */
  // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private List<String> discountOffers;

  // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
  private int discountOffersXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Campaign( ) {
    moreLinks = new HashSet<>();
    discountOffers = new ArrayList<>();
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
    theLink = pBuilder.theLink;
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    theLinkXYZ = pBuilder.theLinkXYZ;
    if (pBuilder.moreLinks != null) {
      moreLinks = pBuilder.moreLinks;
    }
    else {
      moreLinks = new HashSet<>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    moreLinksXYZ = pBuilder.moreLinksXYZ;
    if (pBuilder.discountOffers != null) {
      discountOffers = pBuilder.discountOffers;
    }
    else {
      discountOffers = new ArrayList<>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
    discountOffersXYZ = pBuilder.discountOffersXYZ;
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
   * Class implements builder to create a new instance of class <code>Campaign</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    /**
     * The magic link.
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
     *
     * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
     */
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private long theLink;

    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    private int theLinkXYZ = 0;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #moreLinks} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.LinkObject</code><br/>
     *
     * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
     */
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private Set<Long> moreLinks;

    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    private int moreLinksXYZ = 0;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #discountOffers} is
     * <code>com.anaptecs.jeaf.junit.openapi.base.DiscountOffer</code><br/>
     */
    // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private List<String> discountOffers;

    // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
    private int discountOffersXYZ = 0;

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
        this.setTheLink(pObject.theLink);
        this.setMoreLinks(pObject.moreLinks);
        this.setDiscountOffers(pObject.discountOffers);
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
    @JEAFCustomAnnotationTest
    public Builder setTheLink( long pTheLink ) {
      theLink = pTheLink;
      return this;
    }

    public Builder setTheLinkXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
      theLinkXYZ = value;
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
    @JEAFCustomAnnotationTest
    public Builder setMoreLinks( Set<Long> pMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMoreLinks != null) {
        moreLinks = new HashSet<Long>(pMoreLinks);
      }
      else {
        moreLinks = null;
      }
      return this;
    }

    public Builder setMoreLinksXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
      moreLinksXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #discountOffers}.<br/>
     *
     * @param pDiscountOffers Collection to which {@link #discountOffers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public Builder setDiscountOffers( List<String> pDiscountOffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDiscountOffers != null) {
        discountOffers = new ArrayList<String>(pDiscountOffers);
      }
      else {
        discountOffers = null;
      }
      return this;
    }

    public Builder setDiscountOffersXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
      discountOffersXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
  public long getTheLink( ) {
    return theLink;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   * The magic link.
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   * @deprecated Please use &quot;moreLinks&quot; instead. (<b>since:</b> 2.3.1, <b>removed with:</b> 2.4)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setTheLink( long pTheLink ) {
    theLink = pTheLink;
  }

  public int getTheLinkXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    return theLinkXYZ;
  }

  public void setTheLinkXYZ( int value ) {
    theLinkXYZ = value;
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
  @JEAFCustomAnnotationTest
  public Set<Long> getMoreLinks( ) {
    // Return all LinkObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(moreLinks);
  }

  /**
   * Method adds the passed object to {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be added to {@link #moreLinks}. The parameter must not be null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToMoreLinks( Long pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    moreLinks.add(pMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #moreLinks}.
   *
   * @param pMoreLinks Collection with all objects that should be added to {@link #moreLinks}. The parameter must not be
   * null.
   * @deprecated No good any more (<b>since:</b> 1.2, <b>removed with:</b> 3.0)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToMoreLinks( Collection<Long> pMoreLinks ) {
    // Check parameter "pMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Add all passed objects.
    for (Long lNextObject : pMoreLinks) {
      this.addToMoreLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #moreLinks}.
   *
   * @param pMoreLinks Object that should be removed from {@link #moreLinks}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void removeFromMoreLinks( Long pMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMoreLinks, "pMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    moreLinks.remove(pMoreLinks);
  }

  /**
   * Method removes all objects from {@link #moreLinks}.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void clearMoreLinks( ) {
    // Remove all objects from association "moreLinks".
    moreLinks.clear();
  }

  public int getMoreLinksXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    return moreLinksXYZ;
  }

  public void setMoreLinksXYZ( int value ) {
    moreLinksXYZ = value;
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
  @JEAFCustomAnnotationTest
  public List<String> getDiscountOffers( ) {
    // Return all DiscountOffer objects as unmodifiable collection.
    return Collections.unmodifiableList(discountOffers);
  }

  /**
   * Method adds the passed object to {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be added to {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToDiscountOffers( String pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add passed object to collection of associated DiscountOffer objects.
    discountOffers.add(pDiscountOffers);
  }

  /**
   * Method adds all passed objects to {@link #discountOffers}.
   *
   * @param pDiscountOffers Collection with all objects that should be added to {@link #discountOffers}. The parameter
   * must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToDiscountOffers( Collection<String> pDiscountOffers ) {
    // Check parameter "pDiscountOffers" for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Add all passed objects.
    for (String lNextObject : pDiscountOffers) {
      this.addToDiscountOffers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #discountOffers}.
   *
   * @param pDiscountOffers Object that should be removed from {@link #discountOffers}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void removeFromDiscountOffers( String pDiscountOffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDiscountOffers, "pDiscountOffers");
    // Remove passed object from collection of associated DiscountOffer objects.
    discountOffers.remove(pDiscountOffers);
  }

  /**
   * Method removes all objects from {@link #discountOffers}.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void clearDiscountOffers( ) {
    // Remove all objects from association "discountOffers".
    discountOffers.clear();
  }

  public int getDiscountOffersXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.DiscountOffer"
    return discountOffersXYZ;
  }

  public void setDiscountOffersXYZ( int value ) {
    discountOffersXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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