/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonIgnoreProperties(value = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = GeoPosition.class, name = "GeoPosition"),
  @JsonSubTypes.Type(value = SwissGeoPosition.class, name = "SwissGeoPosition"),
  @JsonSubTypes.Type(value = CHStopPlace.class, name = "FOO"),
  @JsonSubTypes.Type(value = UICStopPlace.class, name = "UICStopPlace"),
  @JsonSubTypes.Type(value = TopoRef.class, name = "FOO-BAR") })
public abstract class PlaceRef {
  @NotNull
  private String name;

  @NotNull
  private MyType type;

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
    type = pBuilder.type;
  }

  /**
   * Class implements builder to create a new instance of class <code>PlaceRef</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class Builder {
    private String name;

    private MyType type;

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
        this.setName(pObject.name);
        this.setType(pObject.type);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( @MyNotNullProperty String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets association {@link #type}.<br/>
     *
     * @param pType Value to which {@link #type} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setType( @MyNotNullProperty MyType pType ) {
      type = pType;
      return this;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @MyNotNullProperty
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( @MyNotNullProperty String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns association {@link #type}.<br/>
   *
   * @return {@link MyType} Value to which {@link #type} is set.
   */
  @MyNotNullProperty
  public MyType getType( ) {
    return type;
  }

  /**
   * Method sets association {@link #type}.<br/>
   *
   * @param pType Value to which {@link #type} should be set.
   */
  public void setType( @MyNotNullProperty MyType pType ) {
    type = pType;
  }

  /**
   * Method unsets {@link #type}.
   */
  public final void unsetType( ) {
    type = null;
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
    lBuilder.append(pIndent);
    lBuilder.append("type: ");
    lBuilder.append(type);
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