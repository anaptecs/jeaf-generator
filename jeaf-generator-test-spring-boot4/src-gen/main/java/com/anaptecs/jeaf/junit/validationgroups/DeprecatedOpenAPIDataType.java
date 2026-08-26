/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
 */
@Deprecated
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class DeprecatedOpenAPIDataType {
  /**
   * Constant for the name of attribute "theOneAndOnlyProperty".
   */
  public static final String THEONEANDONLYPROPERTY = "theOneAndOnlyProperty";

  @NotNull
  private String theOneAndOnlyProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedOpenAPIDataType( Builder pBuilder ) {
    // Read attribute values from builder.
    theOneAndOnlyProperty = pBuilder.theOneAndOnlyProperty;
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  private DeprecatedOpenAPIDataType( String pTheOneAndOnlyProperty ) {
    theOneAndOnlyProperty = pTheOneAndOnlyProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DeprecatedOpenAPIDataType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DeprecatedOpenAPIDataType.
   *
   *
   * @param pTheOneAndOnlyProperty Value to which {@link #theOneAndOnlyProperty} should be set.
   *
   * @return {@link DeprecatedOpenAPIDataType}
   */
  public static DeprecatedOpenAPIDataType of( String pTheOneAndOnlyProperty ) {
    return new DeprecatedOpenAPIDataType(pTheOneAndOnlyProperty);
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedOpenAPIDataType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @Deprecated
  public static class Builder {
    private String theOneAndOnlyProperty;

    /**
     * Use {@link DeprecatedOpenAPIDataType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DeprecatedOpenAPIDataType#builder(DeprecatedOpenAPIDataType)} instead of private constructor to create
     * new builder.
     */
    protected Builder( DeprecatedOpenAPIDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTheOneAndOnlyProperty(pObject.theOneAndOnlyProperty);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new DeprecatedOpenAPIDataType objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new DeprecatedOpenAPIDataType objects. The method
     * never returns null.
     */
    public static Builder newBuilder( DeprecatedOpenAPIDataType pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #theOneAndOnlyProperty}.<br/>
     *
     * @param pTheOneAndOnlyProperty Value to which {@link #theOneAndOnlyProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTheOneAndOnlyProperty( @MyNotNullProperty String pTheOneAndOnlyProperty ) {
      // Assign value to attribute
      theOneAndOnlyProperty = pTheOneAndOnlyProperty;
      return this;
    }

    /**
     * Method creates a new instance of class DeprecatedOpenAPIDataType. The object will be initialized with the values
     * of the builder.
     *
     * @return DeprecatedOpenAPIDataType Created object. The method never returns null.
     */
    public DeprecatedOpenAPIDataType build( ) {
      DeprecatedOpenAPIDataType lObject = new DeprecatedOpenAPIDataType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #theOneAndOnlyProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #theOneAndOnlyProperty} is set.
   */
  @MyNotNullProperty
  public String getTheOneAndOnlyProperty( ) {
    return theOneAndOnlyProperty;
  }

  /**
   * Method sets attribute {@link #theOneAndOnlyProperty}.<br/>
   *
   * @param pTheOneAndOnlyProperty Value to which {@link #theOneAndOnlyProperty} should be set.
   */
  public void setTheOneAndOnlyProperty( @MyNotNullProperty String pTheOneAndOnlyProperty ) {
    // Assign value to attribute
    theOneAndOnlyProperty = pTheOneAndOnlyProperty;
  }

  @Override
  public int hashCode( ) {
    return Objects.hashCode(theOneAndOnlyProperty);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DeprecatedOpenAPIDataType == false) {
      lEquals = false;
    }
    else {
      lEquals =
          Objects.equals(theOneAndOnlyProperty, ((DeprecatedOpenAPIDataType) pOtherObject).getTheOneAndOnlyProperty());
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
    lBuilder.append("theOneAndOnlyProperty: ");
    lBuilder.append(theOneAndOnlyProperty);
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
   * @return {@link Builder} New builder that can be used to create new DeprecatedOpenAPIDataType objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}