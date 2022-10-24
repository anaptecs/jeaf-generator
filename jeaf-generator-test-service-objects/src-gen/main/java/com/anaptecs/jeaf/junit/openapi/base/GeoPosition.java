/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class GeoPosition extends PlaceRef {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

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
  private int longitude;

  /**
   * 
   */
  private int latitude;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected GeoPosition( ) {
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
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
   * null.
   */
  public static Builder builder( GeoPosition pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class GeoPosition. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * 
     */
    private int longitude;

    /**
     * 
     */
    private int latitude;

    /**
     * Use {@link GeoPosition#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link GeoPosition#builder(GeoPosition)} instead of private constructor to create new builder.
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
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets the attribute "longitude".
     * 
     * @param pLongitude Value to which the attribute "longitude" should be set.
     */
    public Builder setLongitude( int pLongitude ) {
      // Assign value to attribute
      longitude = pLongitude;
      return this;
    }

    /**
     * Method sets the attribute "latitude".
     * 
     * @param pLatitude Value to which the attribute "latitude" should be set.
     */
    public Builder setLatitude( int pLatitude ) {
      // Assign value to attribute
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
   * Method returns the attribute "longitude".
   * 
   * 
   * @return int Value to which the attribute "longitude" is set.
   */
  public int getLongitude( ) {
    return longitude;
  }

  /**
   * Method sets the attribute "longitude".
   * 
   * 
   * @param pLongitude Value to which the attribute "longitude" should be set.
   */
  public void setLongitude( int pLongitude ) {
    // Assign value to attribute
    longitude = pLongitude;
  }

  /**
   * Method returns the attribute "latitude".
   * 
   * 
   * @return int Value to which the attribute "latitude" is set.
   */
  public int getLatitude( ) {
    return latitude;
  }

  /**
   * Method sets the attribute "latitude".
   * 
   * 
   * @param pLatitude Value to which the attribute "latitude" should be set.
   */
  public void setLatitude( int pLatitude ) {
    // Assign value to attribute
    latitude = pLatitude;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "longitude", "" + longitude));
    lBuilder.append(System.lineSeparator());
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "latitude", "" + latitude));
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
}
