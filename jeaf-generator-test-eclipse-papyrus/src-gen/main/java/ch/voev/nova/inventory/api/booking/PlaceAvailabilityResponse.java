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

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PlaceAvailabilityResponse {
  /**
   * Constant for the name of attribute "warnings".
   */
  public static final String WARNINGS = "warnings";

  /**
   * Constant for the name of attribute "tripAvailabilities".
   */
  public static final String TRIPAVAILABILITIES = "tripAvailabilities";

  /**
   * 
   */
  private List<Warning> warnings = new ArrayList<Warning>();

  /**
   * 
   */
  @NotNull()
  private List<TripAvailability> tripAvailabilities = new ArrayList<TripAvailability>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PlaceAvailabilityResponse( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PlaceAvailabilityResponse( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.warnings != null) {
      warnings.addAll(pBuilder.warnings);
    }
    if (pBuilder.tripAvailabilities != null) {
      tripAvailabilities.addAll(pBuilder.tripAvailabilities);
    }
  }

  /**
   * Class implements builder to create a new instance of class PlaceAvailabilityResponse. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<Warning> warnings;

    /**
     * 
     */
    private List<TripAvailability> tripAvailabilities;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PlaceAvailabilityResponse)} instead of private constructor to create new builder.
     */
    protected Builder( PlaceAvailabilityResponse pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        warnings = pObject.warnings;
        tripAvailabilities = pObject.tripAvailabilities;
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
     * @return {@link Builder} New builder that can be used to create new PlaceAvailabilityResponse objects. The method
     * never returns null.
     */
    public static Builder newBuilder( PlaceAvailabilityResponse pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "warnings".
     * 
     * @param pWarnings Collection with objects to which the association should be set.
     */
    public Builder setWarnings( List<Warning> pWarnings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pWarnings != null) {
        warnings = new ArrayList<Warning>(pWarnings);
      }
      else {
        warnings = null;
      }
      return this;
    }

    /**
     * Method sets the association "tripAvailabilities".
     * 
     * @param pTripAvailabilities Collection with objects to which the association should be set.
     */
    public Builder setTripAvailabilities( List<TripAvailability> pTripAvailabilities ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTripAvailabilities != null) {
        tripAvailabilities = new ArrayList<TripAvailability>(pTripAvailabilities);
      }
      else {
        tripAvailabilities = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PlaceAvailabilityResponse. The object will be initialized with the values
     * of the builder.
     * 
     * @return PlaceAvailabilityResponse Created object. The method never returns null.
     */
    public PlaceAvailabilityResponse build( ) {
      return new PlaceAvailabilityResponse(this);
    }

    /**
     * Method creates a new validated instance of class PlaceAvailabilityResponse. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return PlaceAvailabilityResponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PlaceAvailabilityResponse buildValidated( ) throws ConstraintViolationException {
      PlaceAvailabilityResponse lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "warnings".
   * 
   *
   * @return Collection All Warning objects that belong to the association "warnings". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<Warning> getWarnings( ) {
    // Return all Warning objects as unmodifiable collection.
    return Collections.unmodifiableList(warnings);
  }

  /**
   * Method sets the association "warnings" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pWarnings Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setWarnings( List<Warning> pWarnings ) {
    // Check of parameter is not required.
    // Remove all objects from association "warnings".
    this.clearWarnings();
    // If the association is null, removing all entries is sufficient.
    if (pWarnings != null) {
      warnings = new ArrayList<Warning>(pWarnings);
    }
  }

  /**
   * Method adds the passed Warning object to the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be added to the association "warnings". The parameter must not be null.
   */
  public void addToWarnings( Warning pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add passed object to collection of associated Warning objects.
    warnings.add(pWarnings);
  }

  /**
   * Method adds all passed objects to the association "warnings".
   * 
   * 
   * @param pWarnings Collection with all objects that should be added to the association "warnings". The parameter must
   * not be null.
   */
  public void addToWarnings( Collection<Warning> pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add all passed objects.
    for (Warning lNextObject : pWarnings) {
      this.addToWarnings(lNextObject);
    }
  }

  /**
   * Method removes the passed Warning object from the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be removed from the association "warnings". The parameter must not be null.
   */
  public void removeFromWarnings( Warning pWarnings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Remove passed object from collection of associated Warning objects.
    warnings.remove(pWarnings);
  }

  /**
   * Method removes all objects from the association "warnings".
   * 
   */
  public void clearWarnings( ) {
    // Remove all objects from association "warnings".
    Collection<Warning> lWarnings = new HashSet<Warning>(warnings);
    Iterator<Warning> lIterator = lWarnings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromWarnings(lIterator.next());
    }
  }

  /**
   * Method returns the association "tripAvailabilities".
   * 
   *
   * @return Collection All TripAvailability objects that belong to the association "tripAvailabilities". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<TripAvailability> getTripAvailabilities( ) {
    // Return all TripAvailability objects as unmodifiable collection.
    return Collections.unmodifiableList(tripAvailabilities);
  }

  /**
   * Method sets the association "tripAvailabilities" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pTripAvailabilities Collection with objects to which the association should be set. The parameter must not
   * be null.
   */
  void setTripAvailabilities( List<TripAvailability> pTripAvailabilities ) {
    // Check of parameter is not required.
    // Remove all objects from association "tripAvailabilities".
    this.clearTripAvailabilities();
    // If the association is null, removing all entries is sufficient.
    if (pTripAvailabilities != null) {
      tripAvailabilities = new ArrayList<TripAvailability>(pTripAvailabilities);
    }
  }

  /**
   * Method adds the passed TripAvailability object to the association "tripAvailabilities".
   * 
   * 
   * @param pTripAvailabilities Object that should be added to the association "tripAvailabilities". The parameter must
   * not be null.
   */
  public void addToTripAvailabilities( TripAvailability pTripAvailabilities ) {
    // Check parameter "pTripAvailabilities" for invalid value null.
    Check.checkInvalidParameterNull(pTripAvailabilities, "pTripAvailabilities");
    // Add passed object to collection of associated TripAvailability objects.
    tripAvailabilities.add(pTripAvailabilities);
  }

  /**
   * Method adds all passed objects to the association "tripAvailabilities".
   * 
   * 
   * @param pTripAvailabilities Collection with all objects that should be added to the association
   * "tripAvailabilities". The parameter must not be null.
   */
  public void addToTripAvailabilities( Collection<TripAvailability> pTripAvailabilities ) {
    // Check parameter "pTripAvailabilities" for invalid value null.
    Check.checkInvalidParameterNull(pTripAvailabilities, "pTripAvailabilities");
    // Add all passed objects.
    for (TripAvailability lNextObject : pTripAvailabilities) {
      this.addToTripAvailabilities(lNextObject);
    }
  }

  /**
   * Method removes the passed TripAvailability object from the association "tripAvailabilities".
   * 
   * 
   * @param pTripAvailabilities Object that should be removed from the association "tripAvailabilities". The parameter
   * must not be null.
   */
  public void removeFromTripAvailabilities( TripAvailability pTripAvailabilities ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTripAvailabilities, "pTripAvailabilities");
    // Remove passed object from collection of associated TripAvailability objects.
    tripAvailabilities.remove(pTripAvailabilities);
  }

  /**
   * Method removes all objects from the association "tripAvailabilities".
   * 
   */
  public void clearTripAvailabilities( ) {
    // Remove all objects from association "tripAvailabilities".
    Collection<TripAvailability> lTripAvailabilities = new HashSet<TripAvailability>(tripAvailabilities);
    Iterator<TripAvailability> lIterator = lTripAvailabilities.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTripAvailabilities(lIterator.next());
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
