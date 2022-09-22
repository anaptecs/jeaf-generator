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
public class StationSet {
  /**
   * Constant for the name of attribute "stations".
   */
  public static final String STATIONS = "stations";

  /**
   * 
   */
  private List<StopPlaceRef> stations;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected StationSet( ) {
    stations = new ArrayList<StopPlaceRef>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected StationSet( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.stations != null) {
      stations = pBuilder.stations;
    }
    else {
      stations = new ArrayList<StopPlaceRef>();
    }
  }

  /**
   * Class implements builder to create a new instance of class StationSet. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<StopPlaceRef> stations;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(StationSet)} instead of private constructor to create new builder.
     */
    protected Builder( StationSet pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        stations = pObject.stations;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new StationSet objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new StationSet objects. The method never returns
     * null.
     */
    public static Builder newBuilder( StationSet pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "stations".
     * 
     * @param pStations Collection with objects to which the association should be set.
     */
    public Builder setStations( List<StopPlaceRef> pStations ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStations != null) {
        stations = new ArrayList<StopPlaceRef>(pStations);
      }
      else {
        stations = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class StationSet. The object will be initialized with the values of the builder.
     * 
     * @return StationSet Created object. The method never returns null.
     */
    public StationSet build( ) {
      return new StationSet(this);
    }

    /**
     * Method creates a new validated instance of class StationSet. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return StationSet Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public StationSet buildValidated( ) throws ConstraintViolationException {
      StationSet lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "stations".
   * 
   *
   * @return Collection All StopPlaceRef objects that belong to the association "stations". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<StopPlaceRef> getStations( ) {
    // Return all StopPlaceRef objects as unmodifiable collection.
    return Collections.unmodifiableList(stations);
  }

  /**
   * Method adds the passed StopPlaceRef object to the association "stations".
   * 
   * 
   * @param pStations Object that should be added to the association "stations". The parameter must not be null.
   */
  public void addToStations( StopPlaceRef pStations ) {
    // Check parameter "pStations" for invalid value null.
    Check.checkInvalidParameterNull(pStations, "pStations");
    // Add passed object to collection of associated StopPlaceRef objects.
    stations.add(pStations);
  }

  /**
   * Method adds all passed objects to the association "stations".
   * 
   * 
   * @param pStations Collection with all objects that should be added to the association "stations". The parameter must
   * not be null.
   */
  public void addToStations( Collection<StopPlaceRef> pStations ) {
    // Check parameter "pStations" for invalid value null.
    Check.checkInvalidParameterNull(pStations, "pStations");
    // Add all passed objects.
    for (StopPlaceRef lNextObject : pStations) {
      this.addToStations(lNextObject);
    }
  }

  /**
   * Method removes the passed StopPlaceRef object from the association "stations".
   * 
   * 
   * @param pStations Object that should be removed from the association "stations". The parameter must not be null.
   */
  public void removeFromStations( StopPlaceRef pStations ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStations, "pStations");
    // Remove passed object from collection of associated StopPlaceRef objects.
    stations.remove(pStations);
  }

  /**
   * Method removes all objects from the association "stations".
   * 
   */
  public void clearStations( ) {
    // Remove all objects from association "stations".
    Collection<StopPlaceRef> lStations = new HashSet<StopPlaceRef>(stations);
    Iterator<StopPlaceRef> lIterator = lStations.iterator();
    while (lIterator.hasNext()) {
      this.removeFromStations(lIterator.next());
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
