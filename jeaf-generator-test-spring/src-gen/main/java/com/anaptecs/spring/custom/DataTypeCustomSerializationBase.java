/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class DataTypeCustomSerializationBase {
  /**
   * Constant for the name of attribute "property1".
   */
  public static final String PROPERTY1 = "property1";

  private String property1;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DataTypeCustomSerializationBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeCustomSerializationBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    property1 = pBuilder.property1;
  }

  /**
   * Class implements builder to create a new instance of class DataTypeCustomSerialization. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private String property1;

    /**
     * Use {@link DataTypeCustomSerialization.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link DataTypeCustomSerialization.builder(DataTypeCustomSerialization)} instead of protected constructor to
     * create new builder.
     */
    protected BuilderBase( DataTypeCustomSerializationBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProperty1(pObject.property1);
      }
    }

    /**
     * Method sets attribute {@link #property1}.<br/>
     *
     * @param pProperty1 Value to which {@link #property1} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setProperty1( String pProperty1 ) {
      // Assign value to attribute
      property1 = pProperty1;
      return this;
    }

    /**
     * Method creates a new instance of class DataTypeCustomSerialization. The object will be initialized with the
     * values of the builder.
     *
     * @return DataTypeCustomSerialization Created object. The method never returns null.
     */
    public DataTypeCustomSerialization build( ) {
      DataTypeCustomSerialization lObject = new DataTypeCustomSerialization(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #property1}.<br/>
   *
   * @return {@link String} Value to which {@link #property1} is set.
   */
  @MyNotNull
  public String getProperty1( ) {
    return property1;
  }

  /**
   * Method sets attribute {@link #property1}.<br/>
   *
   * @param pProperty1 Value to which {@link #property1} should be set.
   */
  public void setProperty1( String pProperty1 ) {
    // Assign value to attribute
    property1 = pProperty1;
  }

  /**
   * Convenience method to create new instance of class DataTypeCustomSerialization.
   *
   *
   * @param pProperty1 Value to which {@link #property1} should be set.
   *
   * @return {@link DataTypeCustomSerialization}
   */
  public static DataTypeCustomSerialization of( String pProperty1 ) {
    DataTypeCustomSerialization.Builder lBuilder = DataTypeCustomSerialization.builder();
    lBuilder.setProperty1(pProperty1);
    return lBuilder.build();
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(property1);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DataTypeCustomSerialization == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(property1, ((DataTypeCustomSerialization) pOtherObject).getProperty1());
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
    lBuilder.append("property1: ");
    lBuilder.append(property1);
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
   * @return {@link Builder} New builder that can be used to create new DataTypeCustomSerialization objects. The method
   * never returns null.
   */
  public DataTypeCustomSerialization.Builder toBuilder( ) {
    return new DataTypeCustomSerialization.Builder((DataTypeCustomSerialization) this);
  }
}
