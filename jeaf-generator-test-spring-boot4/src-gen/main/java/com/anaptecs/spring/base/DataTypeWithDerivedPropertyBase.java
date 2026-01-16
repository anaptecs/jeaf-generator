/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class DataTypeWithDerivedPropertyBase {
  /**
   * Constant for the name of attribute "property".
   */
  public static final String PROPERTY = "property";

  private int property;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeWithDerivedPropertyBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    property = pBuilder.property;
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  DataTypeWithDerivedPropertyBase( int pProperty ) {
    property = pProperty;
  }

  /**
   * Class implements builder to create a new instance of class DataTypeWithDerivedProperty. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private int property;

    /**
     * Use {@link DataTypeWithDerivedProperty.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link DataTypeWithDerivedProperty.builder(DataTypeWithDerivedProperty)} instead of protected constructor to
     * create new builder.
     */
    protected BuilderBase( DataTypeWithDerivedPropertyBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProperty(pObject.property);
      }
    }

    /**
     * Method sets attribute {@link #property}.<br/>
     *
     * @param pProperty Value to which {@link #property} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setProperty( int pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this;
    }

    /**
     * Method creates a new instance of class DataTypeWithDerivedProperty. The object will be initialized with the
     * values of the builder.
     *
     * @return DataTypeWithDerivedProperty Created object. The method never returns null.
     */
    public DataTypeWithDerivedProperty build( ) {
      DataTypeWithDerivedProperty lObject = new DataTypeWithDerivedProperty(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #property}.<br/>
   *
   * @return int Value to which {@link #property} is set.
   */
  public int getProperty( ) {
    return property;
  }

  /**
   * Method sets attribute {@link #property}.<br/>
   *
   * @param pProperty Value to which {@link #property} should be set.
   */
  public void setProperty( int pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  /**
   * Convenience method to create new instance of class DataTypeWithDerivedProperty.
   *
   *
   * @param pProperty Value to which {@link #property} should be set.
   *
   * @return {@link DataTypeWithDerivedProperty}
   */
  public static DataTypeWithDerivedProperty of( int pProperty ) {
    return new DataTypeWithDerivedProperty(pProperty);
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  public abstract String getDerivedProperty( );

  @Override
  public int hashCode( ) {
    return property;
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DataTypeWithDerivedProperty == false) {
      lEquals = false;
    }
    else {
      lEquals = (property == ((DataTypeWithDerivedProperty) pOtherObject).getProperty());
    }
    return lEquals;
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
    lBuilder.append("property: ");
    lBuilder.append(property);
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
   * @return {@link Builder} New builder that can be used to create new DataTypeWithDerivedProperty objects. The method
   * never returns null.
   */
  public DataTypeWithDerivedProperty.Builder toBuilder( ) {
    return new DataTypeWithDerivedProperty.Builder((DataTypeWithDerivedProperty) this);
  }
}