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

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PlaceAvailabilityRequest {
  /**
   * Constant for the name of attribute "tripSpecifications".
   */
  public static final String TRIPSPECIFICATIONS = "tripSpecifications";

  /**
   * Constant for the name of attribute "passengerSpecifications".
   */
  public static final String PASSENGERSPECIFICATIONS = "passengerSpecifications";

  /**
   * Constant for the name of attribute "embeddedParts".
   */
  public static final String EMBEDDEDPARTS = "embeddedParts";

  /**
   * 
   */
  private List<TripSpecification> tripSpecifications;

  /**
   * 
   */
  private List<PassengerSpecification> passengerSpecifications;

  /**
   * <br/>
   * <b>Default Value:</b> <code>ALL</code>
   */
  private EmbeddedParts embeddedParts;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PlaceAvailabilityRequest( ) {
    tripSpecifications = new ArrayList<TripSpecification>();
    passengerSpecifications = new ArrayList<PassengerSpecification>();
    embeddedParts = EmbeddedParts.ALL;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PlaceAvailabilityRequest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.tripSpecifications != null) {
      tripSpecifications = pBuilder.tripSpecifications;
    }
    else {
      tripSpecifications = new ArrayList<TripSpecification>();
    }
    if (pBuilder.passengerSpecifications != null) {
      passengerSpecifications = pBuilder.passengerSpecifications;
    }
    else {
      passengerSpecifications = new ArrayList<PassengerSpecification>();
    }
    embeddedParts = pBuilder.embeddedParts;
  }

  /**
   * Class implements builder to create a new instance of class PlaceAvailabilityRequest. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<TripSpecification> tripSpecifications;

    /**
     * 
     */
    private List<PassengerSpecification> passengerSpecifications;

    /**
     * 
     */
    private EmbeddedParts embeddedParts = EmbeddedParts.ALL;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PlaceAvailabilityRequest)} instead of private constructor to create new builder.
     */
    protected Builder( PlaceAvailabilityRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        tripSpecifications = pObject.tripSpecifications;
        passengerSpecifications = pObject.passengerSpecifications;
        embeddedParts = pObject.embeddedParts;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new PlaceAvailabilityRequest objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PlaceAvailabilityRequest objects. The method
     * never returns null.
     */
    public static Builder newBuilder( PlaceAvailabilityRequest pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "tripSpecifications".
     * 
     * @param pTripSpecifications Collection with objects to which the association should be set.
     */
    public Builder setTripSpecifications( List<TripSpecification> pTripSpecifications ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTripSpecifications != null) {
        tripSpecifications = new ArrayList<TripSpecification>(pTripSpecifications);
      }
      else {
        tripSpecifications = null;
      }
      return this;
    }

    /**
     * Method sets the association "passengerSpecifications".
     * 
     * @param pPassengerSpecifications Collection with objects to which the association should be set.
     */
    public Builder setPassengerSpecifications( List<PassengerSpecification> pPassengerSpecifications ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPassengerSpecifications != null) {
        passengerSpecifications = new ArrayList<PassengerSpecification>(pPassengerSpecifications);
      }
      else {
        passengerSpecifications = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "embeddedParts".
     * 
     * @param pEmbeddedParts Value to which the attribute "embeddedParts" should be set.
     */
    public Builder setEmbeddedParts( EmbeddedParts pEmbeddedParts ) {
      // Assign value to attribute
      embeddedParts = pEmbeddedParts;
      return this;
    }

    /**
     * Method creates a new instance of class PlaceAvailabilityRequest. The object will be initialized with the values
     * of the builder.
     * 
     * @return PlaceAvailabilityRequest Created object. The method never returns null.
     */
    public PlaceAvailabilityRequest build( ) {
      return new PlaceAvailabilityRequest(this);
    }

    /**
     * Method creates a new validated instance of class PlaceAvailabilityRequest. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return PlaceAvailabilityRequest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PlaceAvailabilityRequest buildValidated( ) throws ConstraintViolationException {
      PlaceAvailabilityRequest lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "tripSpecifications".
   * 
   *
   * @return Collection All TripSpecification objects that belong to the association "tripSpecifications". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<TripSpecification> getTripSpecifications( ) {
    // Return all TripSpecification objects as unmodifiable collection.
    return Collections.unmodifiableList(tripSpecifications);
  }

  /**
   * Method adds the passed TripSpecification object to the association "tripSpecifications".
   * 
   * 
   * @param pTripSpecifications Object that should be added to the association "tripSpecifications". The parameter must
   * not be null.
   */
  public void addToTripSpecifications( TripSpecification pTripSpecifications ) {
    // Check parameter "pTripSpecifications" for invalid value null.
    Check.checkInvalidParameterNull(pTripSpecifications, "pTripSpecifications");
    // Add passed object to collection of associated TripSpecification objects.
    tripSpecifications.add(pTripSpecifications);
  }

  /**
   * Method adds all passed objects to the association "tripSpecifications".
   * 
   * 
   * @param pTripSpecifications Collection with all objects that should be added to the association
   * "tripSpecifications". The parameter must not be null.
   */
  public void addToTripSpecifications( Collection<TripSpecification> pTripSpecifications ) {
    // Check parameter "pTripSpecifications" for invalid value null.
    Check.checkInvalidParameterNull(pTripSpecifications, "pTripSpecifications");
    // Add all passed objects.
    for (TripSpecification lNextObject : pTripSpecifications) {
      this.addToTripSpecifications(lNextObject);
    }
  }

  /**
   * Method removes the passed TripSpecification object from the association "tripSpecifications".
   * 
   * 
   * @param pTripSpecifications Object that should be removed from the association "tripSpecifications". The parameter
   * must not be null.
   */
  public void removeFromTripSpecifications( TripSpecification pTripSpecifications ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTripSpecifications, "pTripSpecifications");
    // Remove passed object from collection of associated TripSpecification objects.
    tripSpecifications.remove(pTripSpecifications);
  }

  /**
   * Method removes all objects from the association "tripSpecifications".
   * 
   */
  public void clearTripSpecifications( ) {
    // Remove all objects from association "tripSpecifications".
    Collection<TripSpecification> lTripSpecifications = new HashSet<TripSpecification>(tripSpecifications);
    Iterator<TripSpecification> lIterator = lTripSpecifications.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTripSpecifications(lIterator.next());
    }
  }

  /**
   * Method returns the association "passengerSpecifications".
   * 
   *
   * @return Collection All PassengerSpecification objects that belong to the association "passengerSpecifications". The
   * method never returns null and the returned collection is unmodifiable.
   */
  public List<PassengerSpecification> getPassengerSpecifications( ) {
    // Return all PassengerSpecification objects as unmodifiable collection.
    return Collections.unmodifiableList(passengerSpecifications);
  }

  /**
   * Method adds the passed PassengerSpecification object to the association "passengerSpecifications".
   * 
   * 
   * @param pPassengerSpecifications Object that should be added to the association "passengerSpecifications". The
   * parameter must not be null.
   */
  public void addToPassengerSpecifications( PassengerSpecification pPassengerSpecifications ) {
    // Check parameter "pPassengerSpecifications" for invalid value null.
    Check.checkInvalidParameterNull(pPassengerSpecifications, "pPassengerSpecifications");
    // Add passed object to collection of associated PassengerSpecification objects.
    passengerSpecifications.add(pPassengerSpecifications);
  }

  /**
   * Method adds all passed objects to the association "passengerSpecifications".
   * 
   * 
   * @param pPassengerSpecifications Collection with all objects that should be added to the association
   * "passengerSpecifications". The parameter must not be null.
   */
  public void addToPassengerSpecifications( Collection<PassengerSpecification> pPassengerSpecifications ) {
    // Check parameter "pPassengerSpecifications" for invalid value null.
    Check.checkInvalidParameterNull(pPassengerSpecifications, "pPassengerSpecifications");
    // Add all passed objects.
    for (PassengerSpecification lNextObject : pPassengerSpecifications) {
      this.addToPassengerSpecifications(lNextObject);
    }
  }

  /**
   * Method removes the passed PassengerSpecification object from the association "passengerSpecifications".
   * 
   * 
   * @param pPassengerSpecifications Object that should be removed from the association "passengerSpecifications". The
   * parameter must not be null.
   */
  public void removeFromPassengerSpecifications( PassengerSpecification pPassengerSpecifications ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPassengerSpecifications, "pPassengerSpecifications");
    // Remove passed object from collection of associated PassengerSpecification objects.
    passengerSpecifications.remove(pPassengerSpecifications);
  }

  /**
   * Method removes all objects from the association "passengerSpecifications".
   * 
   */
  public void clearPassengerSpecifications( ) {
    // Remove all objects from association "passengerSpecifications".
    Collection<PassengerSpecification> lPassengerSpecifications =
        new HashSet<PassengerSpecification>(passengerSpecifications);
    Iterator<PassengerSpecification> lIterator = lPassengerSpecifications.iterator();
    while (lIterator.hasNext()) {
      this.removeFromPassengerSpecifications(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "embeddedParts".
   * 
   * 
   * @return EmbeddedParts Value to which the attribute "embeddedParts" is set.
   */
  public EmbeddedParts getEmbeddedParts( ) {
    return embeddedParts;
  }

  /**
   * Method sets the attribute "embeddedParts".
   * 
   * 
   * @param pEmbeddedParts Value to which the attribute "embeddedParts" should be set.
   */
  public void setEmbeddedParts( EmbeddedParts pEmbeddedParts ) {
    // Assign value to attribute
    embeddedParts = pEmbeddedParts;
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
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "embeddedParts", "" + embeddedParts));
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
