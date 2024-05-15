/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class POI extends Stop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "theLink".
   */
  @Deprecated
  public static final String THELINK = "theLink";

  /**
   * Constant for the name of attribute "evenMoreLinks".
   */
  @Deprecated
  public static final String EVENMORELINKS = "evenMoreLinks";

  /**
   * Constant for the name of attribute "stops".
   */
  public static final String STOPS = "stops";

  /**
   * Constant for the name of attribute "bookingCodes".
   */
  public static final String BOOKINGCODES = "bookingCodes";

  // "String"
  @ClassPropertyDeclaration
  private String description;

  // "String"
  private int descriptionXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  private Long theLink;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  private int theLinkXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  private Set<SoftLink> evenMoreLinks;

  // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
  private int evenMoreLinksXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
   */
  @Size(min = 2, max = 42)
  private Set<UICStop> stops;

  // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
  private int stopsXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
  @ClassPropertyDeclaration
  private Set<BookingCode> bookingCodes;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
  private int bookingCodesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POI( ) {
    evenMoreLinks = new HashSet<SoftLink>();
    stops = new HashSet<UICStop>();
    bookingCodes = new HashSet<BookingCode>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POI( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    description = pBuilder.description;
    // "String"
    descriptionXYZ = pBuilder.descriptionXYZ;
    theLink = pBuilder.theLink;
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    theLinkXYZ = pBuilder.theLinkXYZ;
    if (pBuilder.evenMoreLinks != null) {
      evenMoreLinks = pBuilder.evenMoreLinks;
    }
    else {
      evenMoreLinks = new HashSet<SoftLink>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    evenMoreLinksXYZ = pBuilder.evenMoreLinksXYZ;
    if (pBuilder.stops != null) {
      stops = pBuilder.stops;
    }
    else {
      stops = new HashSet<UICStop>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
    stopsXYZ = pBuilder.stopsXYZ;
    if (pBuilder.bookingCodes != null) {
      bookingCodes = pBuilder.bookingCodes;
    }
    else {
      bookingCodes = new HashSet<BookingCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    bookingCodesXYZ = pBuilder.bookingCodesXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new POI objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>POI</code>.
   */
  public static class Builder extends Stop.Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String description;

    // "String"
    private int descriptionXYZ = 0;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
     * <code>LinkObject</code><br/>
     */
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    @BuilderPropertyDeclaration
    @Deprecated
    private Long theLink;

    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    private int theLinkXYZ = 0;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
     * <code>LinkObject</code><br/>
     */
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    @BuilderPropertyDeclaration
    @Deprecated
    private Set<SoftLink> evenMoreLinks;

    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    private int evenMoreLinksXYZ = 0;

    /**
     * <p/>
     * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
     */
    // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
    @BuilderPropertyDeclaration
    private Set<UICStop> stops;

    // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
    private int stopsXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    @BuilderPropertyDeclaration
    private Set<BookingCode> bookingCodes;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    private int bookingCodesXYZ = 0;

    /**
     * Use {@link POI#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link POI#builder(POI)} instead of private constructor to create new builder.
     */
    protected Builder( POI pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDescription(pObject.description);
        this.setTheLink(pObject.theLink);
        this.setEvenMoreLinks(pObject.evenMoreLinks);
        this.setStops(pObject.stops);
        this.setBookingCodes(pObject.bookingCodes);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #links}.<br/>
     *
     * @param pLinks Array of objects that should be added to {@link #links}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLinks( LinkObject... pLinks ) {
      // Call super class implementation.
      super.addToLinks(pLinks);
      return this;
    }

    /**
     * Method sets attribute {@link #index}.<br/>
     *
     * @param pIndex Value to which {@link #index} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setIndex( byte pIndex ) {
      // Call super class implementation.
      super.setIndex(pIndex);
      return this;
    }

    /**
     * Method sets association {@link #theSoftLink}.<br/>
     *
     * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setTheSoftLink( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLink(pTheSoftLink);
      return this;
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    public Builder setDescriptionXYZ( int value ) {
      // "String"
      descriptionXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #theLink}.<br/>
     *
     * @param pTheLink Value to which {@link #theLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setTheLink( Long pTheLink ) {
      theLink = pTheLink;
      return this;
    }

    public Builder setTheLinkXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
      theLinkXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #evenMoreLinks}.<br/>
     *
     * @param pEvenMoreLinks Collection to which {@link #evenMoreLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setEvenMoreLinks( Set<SoftLink> pEvenMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pEvenMoreLinks != null) {
        evenMoreLinks = new HashSet<SoftLink>(pEvenMoreLinks);
      }
      else {
        evenMoreLinks = null;
      }
      return this;
    }

    public Builder setEvenMoreLinksXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
      evenMoreLinksXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #stops}.<br/>
     * <p/>
     * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
     *
     * @param pStops Collection to which {@link #stops} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStops( Set<UICStop> pStops ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStops != null) {
        stops = new HashSet<UICStop>(pStops);
      }
      else {
        stops = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #stops}.<br/>
     * <p/>
     * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
     *
     * @param pStops Array of objects that should be added to {@link #stops}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToStops( UICStop... pStops ) {
      if (pStops != null) {
        if (stops == null) {
          stops = new HashSet<UICStop>();
        }
        stops.addAll(Arrays.asList(pStops));
      }
      return this;
    }

    public Builder setStopsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
      stopsXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #bookingCodes}.<br/>
     *
     * @param pBookingCodes Collection to which {@link #bookingCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingCodes( Set<BookingCode> pBookingCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingCodes != null) {
        bookingCodes = new HashSet<BookingCode>(pBookingCodes);
      }
      else {
        bookingCodes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bookingCodes}.<br/>
     *
     * @param pBookingCodes Array of objects that should be added to {@link #bookingCodes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBookingCodes( BookingCode... pBookingCodes ) {
      if (pBookingCodes != null) {
        if (bookingCodes == null) {
          bookingCodes = new HashSet<BookingCode>();
        }
        bookingCodes.addAll(Arrays.asList(pBookingCodes));
      }
      return this;
    }

    public Builder setBookingCodesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
      bookingCodesXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class POI. The object will be initialized with the values of the builder.
     *
     * @return POI Created object. The method never returns null.
     */
    public POI build( ) {
      return new POI(this);
    }

    /**
     * Method creates a new validated instance of class POI. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return POI Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public POI buildValidated( ) throws ConstraintViolationException {
      POI lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #description}.<br/>
   *
   * @return {@link String} Value to which {@link #description} is set.
   */
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   *
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  public int getDescriptionXYZ( ) {
    // "String"
    return descriptionXYZ;
  }

  public void setDescriptionXYZ( int value ) {
    descriptionXYZ = value;
  }

  /**
   * Method returns association {@link #theLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>LinkObject</code><br/>
   *
   * @return {@link Long} Value to which {@link #theLink} is set.
   */
  @Deprecated
  public Long getTheLink( ) {
    return theLink;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   */
  @Deprecated
  public void setTheLink( Long pTheLink ) {
    theLink = pTheLink;
  }

  /**
   * Method unsets {@link #theLink}.
   */
  @Deprecated
  public final void unsetTheLink( ) {
    theLink = null;
  }

  public int getTheLinkXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    return theLinkXYZ;
  }

  public void setTheLinkXYZ( int value ) {
    theLinkXYZ = value;
  }

  /**
   * Method returns association {@link #evenMoreLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   *
   * @return {@link Set<SoftLink>} Value to which {@link #evenMoreLinks} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<SoftLink> getEvenMoreLinks( ) {
    // Return all LinkObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(evenMoreLinks);
  }

  /**
   * Method adds the passed object to {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Object that should be added to {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinks( SoftLink pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    evenMoreLinks.add(pEvenMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Collection with all objects that should be added to {@link #evenMoreLinks}. The parameter
   * must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinks( Collection<SoftLink> pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add all passed objects.
    for (SoftLink lNextObject : pEvenMoreLinks) {
      this.addToEvenMoreLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Object that should be removed from {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromEvenMoreLinks( SoftLink pEvenMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    evenMoreLinks.remove(pEvenMoreLinks);
  }

  /**
   * Method removes all objects from {@link #evenMoreLinks}.
   */
  @Deprecated
  public void clearEvenMoreLinks( ) {
    // Remove all objects from association "evenMoreLinks".
    evenMoreLinks.clear();
  }

  public int getEvenMoreLinksXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.LinkObject"
    return evenMoreLinksXYZ;
  }

  public void setEvenMoreLinksXYZ( int value ) {
    evenMoreLinksXYZ = value;
  }

  /**
   * Method returns association {@link #stops}.<br/>
   * <p/>
   * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
   *
   * @return {@link Set<UICStop>} Value to which {@link #stops} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public Set<UICStop> getStops( ) {
    // Return all UICStop objects as unmodifiable collection.
    return Collections.unmodifiableSet(stops);
  }

  /**
   * Method adds the passed object to {@link #stops}.
   * <p/>
   * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
   *
   * @param pStops Object that should be added to {@link #stops}. The parameter must not be null.
   */
  public void addToStops( UICStop pStops ) {
    // Check parameter "pStops" for invalid value null.
    Check.checkInvalidParameterNull(pStops, "pStops");
    // Add passed object to collection of associated UICStop objects.
    stops.add(pStops);
  }

  /**
   * Method adds all passed objects to {@link #stops}.
   * <p/>
   * <b>Breaking Change with PI 15:</b> New mandatory association is required to support upcoming features.
   *
   * @param pStops Collection with all objects that should be added to {@link #stops}. The parameter must not be null.
   */
  public void addToStops( Collection<UICStop> pStops ) {
    // Check parameter "pStops" for invalid value null.
    Check.checkInvalidParameterNull(pStops, "pStops");
    // Add all passed objects.
    for (UICStop lNextObject : pStops) {
      this.addToStops(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #stops}.<br/>
   *
   * @param pStops Object that should be removed from {@link #stops}. The parameter must not be null.
   */
  public void removeFromStops( UICStop pStops ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStops, "pStops");
    // Remove passed object from collection of associated UICStop objects.
    stops.remove(pStops);
  }

  /**
   * Method removes all objects from {@link #stops}.
   */
  public void clearStops( ) {
    // Remove all objects from association "stops".
    stops.clear();
  }

  public int getStopsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.UICStop"
    return stopsXYZ;
  }

  public void setStopsXYZ( int value ) {
    stopsXYZ = value;
  }

  /**
   * Method returns association {@link #bookingCodes}.<br/>
   *
   * @return {@link Set<BookingCode>} Value to which {@link #bookingCodes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<BookingCode> getBookingCodes( ) {
    // Return all BookingCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookingCodes);
  }

  /**
   * Method adds the passed object to {@link #bookingCodes}.
   *
   * @param pBookingCodes Object that should be added to {@link #bookingCodes}. The parameter must not be null.
   */
  public void addToBookingCodes( BookingCode pBookingCodes ) {
    // Check parameter "pBookingCodes" for invalid value null.
    Check.checkInvalidParameterNull(pBookingCodes, "pBookingCodes");
    // Add passed object to collection of associated BookingCode objects.
    bookingCodes.add(pBookingCodes);
  }

  /**
   * Method adds all passed objects to {@link #bookingCodes}.
   *
   * @param pBookingCodes Collection with all objects that should be added to {@link #bookingCodes}. The parameter must
   * not be null.
   */
  public void addToBookingCodes( Collection<BookingCode> pBookingCodes ) {
    // Check parameter "pBookingCodes" for invalid value null.
    Check.checkInvalidParameterNull(pBookingCodes, "pBookingCodes");
    // Add all passed objects.
    for (BookingCode lNextObject : pBookingCodes) {
      this.addToBookingCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bookingCodes}.<br/>
   *
   * @param pBookingCodes Object that should be removed from {@link #bookingCodes}. The parameter must not be null.
   */
  public void removeFromBookingCodes( BookingCode pBookingCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBookingCodes, "pBookingCodes");
    // Remove passed object from collection of associated BookingCode objects.
    bookingCodes.remove(pBookingCodes);
  }

  /**
   * Method removes all objects from {@link #bookingCodes}.
   */
  public void clearBookingCodes( ) {
    // Remove all objects from association "bookingCodes".
    bookingCodes.clear();
  }

  public int getBookingCodesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    return bookingCodesXYZ;
  }

  public void setBookingCodesXYZ( int value ) {
    bookingCodesXYZ = value;
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
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
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
   * @return {@link Builder} New builder that can be used to create new POI objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
