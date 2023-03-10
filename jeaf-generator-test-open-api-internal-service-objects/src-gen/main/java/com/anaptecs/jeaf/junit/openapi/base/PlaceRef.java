/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Valid
@JsonIgnoreProperties(value = "objectType")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = GeoPosition.class, name = "GeoPosition"),
  @JsonSubTypes.Type(value = SwissGeoPosition.class, name = "SwissGeoPosition"),
  @JsonSubTypes.Type(value = StopPlaceRef.class, name = "StopPlaceRef"),
  @JsonSubTypes.Type(value = CHStopPlace.class, name = "CHStopPlace"),
  @JsonSubTypes.Type(value = UICStopPlace.class, name = "UICStopPlace"),
  @JsonSubTypes.Type(value = TopoRef.class, name = "TopoRef") })
public abstract class PlaceRef implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String name;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PlaceRef( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PlaceRef( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
  }

  /**
   * Class implements builder to create a new instance of class <code>PlaceRef</code>.
   */
  public static abstract class Builder {
    private String name;

    /**
     * Use {@link PlaceRef#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PlaceRef#builder(PlaceRef)} instead of private constructor to create new builder.
     */
    protected Builder( PlaceRef pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     * 
     * @param pName Value to which {@link #name} should be set.
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   * 
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   * 
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
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
