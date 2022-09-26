/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Connection point connecting two fare regimes. The connection is possible between stations of the two provided station
 * sets. A legacy border point code (id) might be provided as an additional code within the stations (code list
 * BORDER_POINT provided in URN). In case the connection point is a real station this station is indicated. In case the
 * connection point is between stations for each side of the border real stations must be provided. Multiple sets of
 * station can be provided in the rare case that the connection point connects more than two station (A-B and A-C).
 * Multiple stations within a set at one side of the border might be provided in case of changes (new stations build
 * near the border).
 * 
 * Providing the UIC code for the station is mandatory.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class FareConnectionPoint {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "stationSets".
   */
  public static final String STATIONSETS = "stationSets";

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private List<StationSet> stationSets;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected FareConnectionPoint( ) {
    stationSets = new ArrayList<StationSet>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected FareConnectionPoint( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    if (pBuilder.stationSets != null) {
      stationSets = pBuilder.stationSets;
    }
    else {
      stationSets = new ArrayList<StationSet>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new FareConnectionPoint objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new FareConnectionPoint objects. The method never
   * returns null.
   */
  public static Builder builder( FareConnectionPoint pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class FareConnectionPoint. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private List<StationSet> stationSets;

    /**
     * Use {@link FareConnectionPoint#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link FareConnectionPoint#builder(FareConnectionPoint)} instead of private constructor to create new
     * builder.
     */
    protected Builder( FareConnectionPoint pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        stationSets = pObject.stationSets;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the association "stationSets".
     * 
     * @param pStationSets Collection with objects to which the association should be set.
     */
    public Builder setStationSets( List<StationSet> pStationSets ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStationSets != null) {
        stationSets = new ArrayList<StationSet>(pStationSets);
      }
      else {
        stationSets = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class FareConnectionPoint. The object will be initialized with the values of the
     * builder.
     * 
     * @return FareConnectionPoint Created object. The method never returns null.
     */
    public FareConnectionPoint build( ) {
      return new FareConnectionPoint(this);
    }

    /**
     * Method creates a new validated instance of class FareConnectionPoint. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return FareConnectionPoint Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public FareConnectionPoint buildValidated( ) throws ConstraintViolationException {
      FareConnectionPoint lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the association "stationSets".
   * 
   *
   * @return Collection All StationSet objects that belong to the association "stationSets". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<StationSet> getStationSets( ) {
    // Return all StationSet objects as unmodifiable collection.
    return Collections.unmodifiableList(stationSets);
  }

  /**
   * Method adds the passed StationSet object to the association "stationSets".
   * 
   * 
   * @param pStationSets Object that should be added to the association "stationSets". The parameter must not be null.
   */
  public void addToStationSets( StationSet pStationSets ) {
    // Check parameter "pStationSets" for invalid value null.
    Check.checkInvalidParameterNull(pStationSets, "pStationSets");
    // Add passed object to collection of associated StationSet objects.
    stationSets.add(pStationSets);
  }

  /**
   * Method adds all passed objects to the association "stationSets".
   * 
   * 
   * @param pStationSets Collection with all objects that should be added to the association "stationSets". The
   * parameter must not be null.
   */
  public void addToStationSets( Collection<StationSet> pStationSets ) {
    // Check parameter "pStationSets" for invalid value null.
    Check.checkInvalidParameterNull(pStationSets, "pStationSets");
    // Add all passed objects.
    for (StationSet lNextObject : pStationSets) {
      this.addToStationSets(lNextObject);
    }
  }

  /**
   * Method removes the passed StationSet object from the association "stationSets".
   * 
   * 
   * @param pStationSets Object that should be removed from the association "stationSets". The parameter must not be
   * null.
   */
  public void removeFromStationSets( StationSet pStationSets ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStationSets, "pStationSets");
    // Remove passed object from collection of associated StationSet objects.
    stationSets.remove(pStationSets);
  }

  /**
   * Method removes all objects from the association "stationSets".
   * 
   */
  public void clearStationSets( ) {
    // Remove all objects from association "stationSets".
    stationSets.clear();
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
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
