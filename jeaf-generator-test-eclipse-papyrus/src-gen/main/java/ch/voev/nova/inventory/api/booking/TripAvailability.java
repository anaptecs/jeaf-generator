/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Availability per leg for a given trip.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TripAvailability {
  /**
   * Constant for the name of attribute "tripId".
   */
  public static final String TRIPID = "tripId";

  /**
   * Constant for the name of attribute "placeAvailabilities".
   */
  public static final String PLACEAVAILABILITIES = "placeAvailabilities";

  /**
   * Constant for the name of attribute "reservationOffers".
   */
  public static final String RESERVATIONOFFERS = "reservationOffers";

  /**
   * 
   */
  @NotNull
  private String tripId;

  /**
   * 
   */
  private List<PlaceAvailability> placeAvailabilities = new ArrayList<PlaceAvailability>();

  /**
   * 
   */
  private List<ReservationOffer> reservationOffers = new ArrayList<ReservationOffer>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TripAvailability( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TripAvailability( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    tripId = pBuilder.tripId;
    if (pBuilder.placeAvailabilities != null) {
      placeAvailabilities.addAll(pBuilder.placeAvailabilities);
    }
    if (pBuilder.reservationOffers != null) {
      reservationOffers.addAll(pBuilder.reservationOffers);
    }
  }

  /**
   * Class implements builder to create a new instance of class TripAvailability. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotNull
    private String tripId;

    /**
     * 
     */
    private List<PlaceAvailability> placeAvailabilities;

    /**
     * 
     */
    private List<ReservationOffer> reservationOffers;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(TripAvailability)} instead of private constructor to create new builder.
     */
    protected Builder( TripAvailability pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        tripId = pObject.tripId;
        placeAvailabilities = pObject.placeAvailabilities;
        reservationOffers = pObject.reservationOffers;
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
     * @return {@link Builder} New builder that can be used to create new TripAvailability objects. The method never
     * returns null.
     */
    public static Builder newBuilder( TripAvailability pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "tripId".
     * 
     * @param pTripId Value to which the attribute "tripId" should be set.
     */
    public Builder setTripId( String pTripId ) {
      // Assign value to attribute
      tripId = pTripId;
      return this;
    }

    /**
     * Method sets the association "placeAvailabilities".
     * 
     * @param pPlaceAvailabilities Collection with objects to which the association should be set.
     */
    public Builder setPlaceAvailabilities( List<PlaceAvailability> pPlaceAvailabilities ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPlaceAvailabilities != null) {
        placeAvailabilities = new ArrayList<PlaceAvailability>(pPlaceAvailabilities);
      }
      else {
        placeAvailabilities = null;
      }
      return this;
    }

    /**
     * Method sets the association "reservationOffers".
     * 
     * @param pReservationOffers Collection with objects to which the association should be set.
     */
    public Builder setReservationOffers( List<ReservationOffer> pReservationOffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pReservationOffers != null) {
        reservationOffers = new ArrayList<ReservationOffer>(pReservationOffers);
      }
      else {
        reservationOffers = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class TripAvailability. The object will be initialized with the values of the
     * builder.
     * 
     * @return TripAvailability Created object. The method never returns null.
     */
    public TripAvailability build( ) {
      return new TripAvailability(this);
    }

    /**
     * Method creates a new validated instance of class TripAvailability. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return TripAvailability Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TripAvailability buildValidated( ) throws ConstraintViolationException {
      TripAvailability lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "tripId".
   * 
   * 
   * @return String Value to which the attribute "tripId" is set.
   */
  public String getTripId( ) {
    return tripId;
  }

  /**
   * Method sets the attribute "tripId".
   * 
   * 
   * @param pTripId Value to which the attribute "tripId" should be set.
   */
  public void setTripId( String pTripId ) {
    // Assign value to attribute
    tripId = pTripId;
  }

  /**
   * Method returns the association "placeAvailabilities".
   * 
   *
   * @return Collection All PlaceAvailability objects that belong to the association "placeAvailabilities". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<PlaceAvailability> getPlaceAvailabilities( ) {
    // Return all PlaceAvailability objects as unmodifiable collection.
    return Collections.unmodifiableList(placeAvailabilities);
  }

  /**
   * Method sets the association "placeAvailabilities" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pPlaceAvailabilities Collection with objects to which the association should be set. The parameter must not
   * be null.
   */
  void setPlaceAvailabilities( List<PlaceAvailability> pPlaceAvailabilities ) {
    // Check of parameter is not required.
    // Remove all objects from association "placeAvailabilities".
    this.clearPlaceAvailabilities();
    // If the association is null, removing all entries is sufficient.
    if (pPlaceAvailabilities != null) {
      placeAvailabilities = new ArrayList<PlaceAvailability>(pPlaceAvailabilities);
    }
  }

  /**
   * Method adds the passed PlaceAvailability object to the association "placeAvailabilities".
   * 
   * 
   * @param pPlaceAvailabilities Object that should be added to the association "placeAvailabilities". The parameter
   * must not be null.
   */
  public void addToPlaceAvailabilities( PlaceAvailability pPlaceAvailabilities ) {
    // Check parameter "pPlaceAvailabilities" for invalid value null.
    Check.checkInvalidParameterNull(pPlaceAvailabilities, "pPlaceAvailabilities");
    // Add passed object to collection of associated PlaceAvailability objects.
    placeAvailabilities.add(pPlaceAvailabilities);
  }

  /**
   * Method adds all passed objects to the association "placeAvailabilities".
   * 
   * 
   * @param pPlaceAvailabilities Collection with all objects that should be added to the association
   * "placeAvailabilities". The parameter must not be null.
   */
  public void addToPlaceAvailabilities( Collection<PlaceAvailability> pPlaceAvailabilities ) {
    // Check parameter "pPlaceAvailabilities" for invalid value null.
    Check.checkInvalidParameterNull(pPlaceAvailabilities, "pPlaceAvailabilities");
    // Add all passed objects.
    for (PlaceAvailability lNextObject : pPlaceAvailabilities) {
      this.addToPlaceAvailabilities(lNextObject);
    }
  }

  /**
   * Method removes the passed PlaceAvailability object from the association "placeAvailabilities".
   * 
   * 
   * @param pPlaceAvailabilities Object that should be removed from the association "placeAvailabilities". The parameter
   * must not be null.
   */
  public void removeFromPlaceAvailabilities( PlaceAvailability pPlaceAvailabilities ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPlaceAvailabilities, "pPlaceAvailabilities");
    // Remove passed object from collection of associated PlaceAvailability objects.
    placeAvailabilities.remove(pPlaceAvailabilities);
  }

  /**
   * Method removes all objects from the association "placeAvailabilities".
   * 
   */
  public void clearPlaceAvailabilities( ) {
    // Remove all objects from association "placeAvailabilities".
    Collection<PlaceAvailability> lPlaceAvailabilities = new HashSet<PlaceAvailability>(placeAvailabilities);
    Iterator<PlaceAvailability> lIterator = lPlaceAvailabilities.iterator();
    while (lIterator.hasNext()) {
      this.removeFromPlaceAvailabilities(lIterator.next());
    }
  }

  /**
   * Method returns the association "reservationOffers".
   * 
   *
   * @return Collection All ReservationOffer objects that belong to the association "reservationOffers". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<ReservationOffer> getReservationOffers( ) {
    // Return all ReservationOffer objects as unmodifiable collection.
    return Collections.unmodifiableList(reservationOffers);
  }

  /**
   * Method sets the association "reservationOffers" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pReservationOffers Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setReservationOffers( List<ReservationOffer> pReservationOffers ) {
    // Check of parameter is not required.
    // Remove all objects from association "reservationOffers".
    this.clearReservationOffers();
    // If the association is null, removing all entries is sufficient.
    if (pReservationOffers != null) {
      reservationOffers = new ArrayList<ReservationOffer>(pReservationOffers);
    }
  }

  /**
   * Method adds the passed ReservationOffer object to the association "reservationOffers".
   * 
   * 
   * @param pReservationOffers Object that should be added to the association "reservationOffers". The parameter must
   * not be null.
   */
  public void addToReservationOffers( ReservationOffer pReservationOffers ) {
    // Check parameter "pReservationOffers" for invalid value null.
    Check.checkInvalidParameterNull(pReservationOffers, "pReservationOffers");
    // Add passed object to collection of associated ReservationOffer objects.
    reservationOffers.add(pReservationOffers);
  }

  /**
   * Method adds all passed objects to the association "reservationOffers".
   * 
   * 
   * @param pReservationOffers Collection with all objects that should be added to the association "reservationOffers".
   * The parameter must not be null.
   */
  public void addToReservationOffers( Collection<ReservationOffer> pReservationOffers ) {
    // Check parameter "pReservationOffers" for invalid value null.
    Check.checkInvalidParameterNull(pReservationOffers, "pReservationOffers");
    // Add all passed objects.
    for (ReservationOffer lNextObject : pReservationOffers) {
      this.addToReservationOffers(lNextObject);
    }
  }

  /**
   * Method removes the passed ReservationOffer object from the association "reservationOffers".
   * 
   * 
   * @param pReservationOffers Object that should be removed from the association "reservationOffers". The parameter
   * must not be null.
   */
  public void removeFromReservationOffers( ReservationOffer pReservationOffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pReservationOffers, "pReservationOffers");
    // Remove passed object from collection of associated ReservationOffer objects.
    reservationOffers.remove(pReservationOffers);
  }

  /**
   * Method removes all objects from the association "reservationOffers".
   * 
   */
  public void clearReservationOffers( ) {
    // Remove all objects from association "reservationOffers".
    Collection<ReservationOffer> lReservationOffers = new HashSet<ReservationOffer>(reservationOffers);
    Iterator<ReservationOffer> lIterator = lReservationOffers.iterator();
    while (lIterator.hasNext()) {
      this.removeFromReservationOffers(lIterator.next());
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "tripId", "" + tripId));
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
