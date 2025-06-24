/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = POI.POIBuilderImpl.class)
public class POI extends Stop {
  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  private String description;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POI( POIBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    description = pBuilder.description;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new POI objects.
   */
  public static POIBuilder<?, ?> builder( ) {
    return new POIBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class POI.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pDescription Value to which {@link #description} should be set.
   *
   * @return {@link POI}
   */
  public static POI of( String pName, String pDescription ) {
    POIBuilder<?, ?> lBuilder = POI.builder();
    lBuilder.setName(pName);
    lBuilder.setDescription(pDescription);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>POI</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class POIBuilder<T extends POI, S extends POIBuilder<T, S>> extends StopBuilder<T, S> {
    private String description;

    /**
     * Use {@link POIBuilder#builder()} instead of private constructor to create new builder.
     */
    protected POIBuilder( ) {
      super();
    }

    /**
     * Use {@link POIBuilder#builder(POI)} instead of private constructor to create new builder.
     */
    protected POIBuilder( POI pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDescription(pObject.description);
      }
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setDescription( @MyNotNullProperty String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this.self();
    }

    /**
     * Method creates a new instance of class POI. The object will be initialized with the values of the builder.
     *
     * @return POI Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class POIBuilderImpl extends POIBuilder<POI, POIBuilderImpl> {
    protected POIBuilderImpl( ) {
    }

    protected POIBuilderImpl( POI pObject ) {
      super(pObject);
    }

    @Override
    protected POIBuilderImpl self( ) {
      return this;
    }

    @Override
    public POI build( ) {
      POI lObject = new POI(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #description}.<br/>
   *
   * @return {@link String} Value to which {@link #description} is set.
   */
  @MyNotNullProperty
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   *
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( @MyNotNullProperty String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(description);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      POI lOther = (POI) pObject;
      lEquals = Objects.equals(description, lOther.description);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new POI objects. The method never returns null.
   */
  public POIBuilder<?, ?> toBuilder( ) {
    return new POIBuilderImpl(this);
  }
}