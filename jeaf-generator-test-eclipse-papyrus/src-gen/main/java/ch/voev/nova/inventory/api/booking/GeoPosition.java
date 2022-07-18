/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * WGS84 coordinates position. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class GeoPosition extends PlaceRef {
  /**
   * Constant for the name of attribute "longitude".
   */
  public static final String LONGITUDE = "longitude";

  /**
   * Constant for the name of attribute "latitude".
   */
  public static final String LATITUDE = "latitude";

  /**
   * 
   */
  private Longitude longitude;

  /**
   * 
   */
  private Latitude latitude;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected GeoPosition( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GeoPosition( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    longitude = pBuilder.longitude;
    latitude = pBuilder.latitude;
  }

  /**
   * Class implements builder to create a new instance of class GeoPosition. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * 
     */
    private Longitude longitude;

    /**
     * 
     */
    private Latitude latitude;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(GeoPosition)} instead of private constructor to create new builder.
     */
    protected Builder( GeoPosition pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        longitude = pObject.longitude;
        latitude = pObject.latitude;
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
     * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
     * null.
     */
    public static Builder newBuilder( GeoPosition pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "longitude".
     * 
     * @param pLongitude Longitude to which the association "longitude" should be set.
     */
    public Builder setLongitude( Longitude pLongitude ) {
      longitude = pLongitude;
      return this;
    }

    /**
     * Method sets the association "latitude".
     * 
     * @param pLatitude Latitude to which the association "latitude" should be set.
     */
    public Builder setLatitude( Latitude pLatitude ) {
      latitude = pLatitude;
      return this;
    }

    /**
     * Method creates a new instance of class GeoPosition. The object will be initialized with the values of the
     * builder.
     * 
     * @return GeoPosition Created object. The method never returns null.
     */
    public GeoPosition build( ) {
      return new GeoPosition(this);
    }

    /**
     * Method creates a new validated instance of class GeoPosition. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return GeoPosition Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public GeoPosition buildValidated( ) throws ConstraintViolationException {
      GeoPosition lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "longitude".
   * 
   *
   * @return Longitude Longitude to which the association "longitude" is set.
   */
  public Longitude getLongitude( ) {
    return longitude;
  }

  /**
   * Method sets the association "longitude".
   * 
   * 
   * @param pLongitude Longitude to which the association "longitude" should be set.
   */
  public void setLongitude( Longitude pLongitude ) {
    longitude = pLongitude;
  }

  /**
   * Method unsets the association "longitude".
   * 
   */
  public final void unsetLongitude( ) {
    longitude = null;
  }

  /**
   * Method returns the association "latitude".
   * 
   *
   * @return Latitude Latitude to which the association "latitude" is set.
   */
  public Latitude getLatitude( ) {
    return latitude;
  }

  /**
   * Method sets the association "latitude".
   * 
   * 
   * @param pLatitude Latitude to which the association "latitude" should be set.
   */
  public void setLatitude( Latitude pLatitude ) {
    latitude = pLatitude;
  }

  /**
   * Method unsets the association "latitude".
   * 
   */
  public final void unsetLatitude( ) {
    latitude = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
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
