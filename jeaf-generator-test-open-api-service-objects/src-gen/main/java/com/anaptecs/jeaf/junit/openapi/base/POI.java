/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class POI extends Stop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String description;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  @NotNull
  private Long theLinkID;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  @JsonSetter(nulls = Nulls.SKIP)
  private Set<SoftLink> evenMoreLinkIDs;

  /**
   * <p/>
   * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
   */
  @Size(min = 2, max = 42)
  @JsonSetter(nulls = Nulls.SKIP)
  @NotNull
  private Set<UICStop> stops;

  @JsonSetter(nulls = Nulls.SKIP)
  @Size(min = 1)
  @NotNull
  private Set<BookingCode> bookingCodes;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POI( ) {
    evenMoreLinkIDs = new HashSet<>();
    stops = new HashSet<>();
    bookingCodes = new HashSet<>();
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
    theLinkID = pBuilder.theLinkID;
    if (pBuilder.evenMoreLinkIDs != null) {
      evenMoreLinkIDs = pBuilder.evenMoreLinkIDs;
    }
    else {
      evenMoreLinkIDs = new HashSet<>();
    }
    if (pBuilder.stops != null) {
      stops = pBuilder.stops;
    }
    else {
      stops = new HashSet<>();
    }
    if (pBuilder.bookingCodes != null) {
      bookingCodes = pBuilder.bookingCodes;
    }
    else {
      bookingCodes = new HashSet<>();
    }
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
   * Convenience method to create new instance of class POI.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pIndex Value to which {@link #index} should be set.
   *
   * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
   *
   * @param pDescription Value to which {@link #description} should be set.
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   *
   * @param pStops Value to which {@link #stops} should be set.
   *
   * @param pBookingCodes Value to which {@link #bookingCodes} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.POI}
   */
  public static POI of( String pName, byte pIndex, SoftLink pTheSoftLinkID, String pDescription, Long pTheLinkID,
      Set<UICStop> pStops, Set<BookingCode> pBookingCodes ) {
    var lBuilder = POI.builder();
    lBuilder.setName(pName);
    lBuilder.setIndex(pIndex);
    lBuilder.setTheSoftLinkID(pTheSoftLinkID);
    lBuilder.setDescription(pDescription);
    lBuilder.setTheLinkID(pTheLinkID);
    lBuilder.setStops(pStops);
    lBuilder.setBookingCodes(pBookingCodes);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>POI</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder extends Stop.Builder {
    private String description;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
     * <code>LinkObject</code><br/>
     */
    @Deprecated
    @NotNull
    private Long theLinkID;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
     * <code>LinkObject</code><br/>
     */
    @Deprecated
    private Set<SoftLink> evenMoreLinkIDs;

    /**
     * <p/>
     * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
     */
    private Set<UICStop> stops;

    private Set<BookingCode> bookingCodes;

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
        this.setTheLinkID(pObject.theLinkID);
        this.setEvenMoreLinkIDs(pObject.evenMoreLinkIDs);
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
    public Builder setTheSoftLinkID( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLinkID(pTheSoftLink);
      return this;
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDescription( @MyNotNullProperty String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    /**
     * Method sets association {@link #theLink}.<br/>
     *
     * @param pTheLink Value to which {@link #theLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setTheLinkID( @MyNotNullProperty Long pTheLink ) {
      theLinkID = pTheLink;
      return this;
    }

    /**
     * Method sets association {@link #evenMoreLinks}.<br/>
     *
     * @param pEvenMoreLinks Collection to which {@link #evenMoreLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setEvenMoreLinkIDs( Set<SoftLink> pEvenMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pEvenMoreLinks != null) {
        evenMoreLinkIDs = new HashSet<SoftLink>(pEvenMoreLinks);
      }
      else {
        evenMoreLinkIDs = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #stops}.<br/>
     * <p/>
     * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
     *
     * @param pStops Collection to which {@link #stops} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStops( @MyNotEmptyProperty Set<UICStop> pStops ) {
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
     * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
     *
     * @param pStops Array of objects that should be added to {@link #stops}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToStops( @MyNotEmptyProperty UICStop... pStops ) {
      if (pStops != null) {
        if (stops == null) {
          stops = new HashSet<UICStop>();
        }
        stops.addAll(Arrays.asList(pStops));
      }
      return this;
    }

    /**
     * Method sets association {@link #bookingCodes}.<br/>
     *
     * @param pBookingCodes Collection to which {@link #bookingCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingCodes( @MyNotEmptyProperty Set<BookingCode> pBookingCodes ) {
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
    public Builder addToBookingCodes( @MyNotEmptyProperty BookingCode... pBookingCodes ) {
      if (pBookingCodes != null) {
        if (bookingCodes == null) {
          bookingCodes = new HashSet<BookingCode>();
        }
        bookingCodes.addAll(Arrays.asList(pBookingCodes));
      }
      return this;
    }

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
  @MyNotNullProperty
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   *
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( @MyNotNullProperty String pDescription ) {
    // Assign value to attribute
    description = pDescription;
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
  @MyNotNullProperty
  public Long getTheLinkID( ) {
    return theLinkID;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   *
   * @param pTheLink Value to which {@link #theLink} should be set.
   */
  @Deprecated
  public void setTheLinkID( @MyNotNullProperty Long pTheLink ) {
    theLinkID = pTheLink;
  }

  /**
   * Method unsets {@link #theLink}.
   */
  @Deprecated
  public final void unsetTheLinkID( ) {
    theLinkID = null;
  }

  /**
   * Method returns association {@link #evenMoreLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   *
   * @return {@link Set<SoftLink>} Value to which {@link #evenMoreLinks} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  @Deprecated
  public Set<SoftLink> getEvenMoreLinkIDs( ) {
    // Return all LinkObject objects directly without any protection against modification.
    return evenMoreLinkIDs;
  }

  /**
   * Method adds the passed object to {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Object that should be added to {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinkIDs( SoftLink pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    evenMoreLinkIDs.add(pEvenMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Collection with all objects that should be added to {@link #evenMoreLinks}. The parameter
   * must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinkIDs( Collection<SoftLink> pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add all passed objects.
    for (SoftLink lNextObject : pEvenMoreLinks) {
      this.addToEvenMoreLinkIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #evenMoreLinks}.
   *
   * @param pEvenMoreLinks Object that should be removed from {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromEvenMoreLinkIDs( SoftLink pEvenMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    evenMoreLinkIDs.remove(pEvenMoreLinks);
  }

  /**
   * Method removes all objects from {@link #evenMoreLinks}.
   */
  @Deprecated
  public void clearEvenMoreLinkIDs( ) {
    // Remove all objects from association "evenMoreLinks".
    evenMoreLinkIDs.clear();
  }

  /**
   * Method returns association {@link #stops}.<br/>
   * <p/>
   * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
   *
   * @return {@link Set<UICStop>} Value to which {@link #stops} is set. The method never returns null and the returned
   * collection is modifiable.
   */
  @MyNotEmptyProperty
  public Set<UICStop> getStops( ) {
    // Return all UICStop objects directly without any protection against modification.
    return stops;
  }

  /**
   * Method adds the passed object to {@link #stops}.
   * <p/>
   * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
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
   * <b>Breaking Change on 2024-12-24:</b> New mandatory association is required to support upcoming features.
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

  /**
   * Method returns association {@link #bookingCodes}.<br/>
   *
   * @return {@link Set<BookingCode>} Value to which {@link #bookingCodes} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  @MyNotEmptyProperty
  public Set<BookingCode> getBookingCodes( ) {
    // Return all BookingCode objects directly without any protection against modification.
    return bookingCodes;
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
    lBuilder.append(pIndent);
    lBuilder.append("theLinkID: ");
    lBuilder.append(theLinkID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("evenMoreLinkIDs: ");
    if (evenMoreLinkIDs != null) {
      lBuilder.append(evenMoreLinkIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (evenMoreLinkIDs != null) {
      for (SoftLink lNext : evenMoreLinkIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("stops: ");
    if (stops != null) {
      lBuilder.append(stops.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (stops != null) {
      for (UICStop lNext : stops) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("bookingCodes: ");
    if (bookingCodes != null) {
      lBuilder.append(bookingCodes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (bookingCodes != null) {
      for (BookingCode lNext : bookingCodes) {
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new POI objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}