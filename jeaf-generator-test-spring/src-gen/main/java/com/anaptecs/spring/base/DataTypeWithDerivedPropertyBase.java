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
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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
  protected DataTypeWithDerivedPropertyBase( DataTypeWithDerivedPropertyBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    property = pBuilder.property;
  }

  /**
   * Class implements builder to create a new instance of class <code>DataTypeWithDerivedProperty</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DataTypeWithDerivedPropertyBuilder<T extends DataTypeWithDerivedProperty, S extends DataTypeWithDerivedPropertyBuilder<T, S>> {
    private int property;

    /**
     * Use {@link DataTypeWithDerivedPropertyBuilder#builder()} instead of private constructor to create new builder.
     */
    protected DataTypeWithDerivedPropertyBuilder( ) {
    }

    /**
     * Use {@link DataTypeWithDerivedPropertyBuilder#builder(DataTypeWithDerivedProperty)} instead of private
     * constructor to create new builder.
     */
    protected DataTypeWithDerivedPropertyBuilder( DataTypeWithDerivedPropertyBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProperty(pObject.property);
      }
    }

    /**
     * Method sets attribute {@link #property}.<br/>
     *
     * @param pProperty Value to which {@link #property} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setProperty( int pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract S self( );

    /**
     * Method creates a new instance of class DataTypeWithDerivedProperty. The object will be initialized with the
     * values of the builder.
     *
     * @return DataTypeWithDerivedProperty Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DataTypeWithDerivedPropertyBuilderImpl
      extends DataTypeWithDerivedPropertyBuilder<DataTypeWithDerivedProperty, DataTypeWithDerivedPropertyBuilderImpl> {
    protected DataTypeWithDerivedPropertyBuilderImpl( ) {
    }

    protected DataTypeWithDerivedPropertyBuilderImpl( DataTypeWithDerivedProperty pObject ) {
      super(pObject);
    }

    @Override
    protected DataTypeWithDerivedPropertyBuilderImpl self( ) {
      return this;
    }

    @Override
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
    DataTypeWithDerivedPropertyBuilder<?, ?> lBuilder = DataTypeWithDerivedProperty.builder();
    lBuilder.setProperty(pProperty);
    return lBuilder.build();
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
  public DataTypeWithDerivedPropertyBuilder<?, ?> toBuilder( ) {
    return new DataTypeWithDerivedPropertyBuilderImpl((DataTypeWithDerivedProperty) this);
  }
}