/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CHStopPlace extends StopPlaceRef {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected CHStopPlace( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CHStopPlace( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class CHStopPlace. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends StopPlaceRef.Builder {
    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(CHStopPlace)} instead of private constructor to create new builder.
     */
    protected Builder( CHStopPlace pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new CHStopPlace objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new CHStopPlace objects. The method never returns
     * null.
     */
    public static Builder newBuilder( CHStopPlace pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method creates a new instance of class CHStopPlace. The object will be initialized with the values of the
     * builder.
     * 
     * @return CHStopPlace Created object. The method never returns null.
     */
    public CHStopPlace build( ) {
      return new CHStopPlace(this);
    }
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
