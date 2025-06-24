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
@JsonDeserialize(builder = IgnoringClass.IgnoringClassBuilderImpl.class)
public class IgnoringClass {
  /**
   * Constant for the name of attribute "age".
   */
  public static final String AGE = "age";

  private Integer age;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IgnoringClass( IgnoringClassBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    age = pBuilder.age;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects.
   */
  public static IgnoringClassBuilder<?, ?> builder( ) {
    return new IgnoringClassBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class IgnoringClass.
   *
   *
   * @param pAge Value to which {@link #age} should be set.
   *
   * @return {@link IgnoringClass}
   */
  public static IgnoringClass of( Integer pAge ) {
    var lBuilder = IgnoringClass.builder();
    lBuilder.setAge(pAge);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>IgnoringClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class IgnoringClassBuilder<T extends IgnoringClass, B extends IgnoringClassBuilder<T, B>> {
    private Integer age;

    /**
     * Use {@link IgnoringClassBuilder#builder()} instead of private constructor to create new builder.
     */
    protected IgnoringClassBuilder( ) {
    }

    /**
     * Use {@link IgnoringClassBuilder#builder(IgnoringClass)} instead of private constructor to create new builder.
     */
    protected IgnoringClassBuilder( IgnoringClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAge(pObject.age);
      }
    }

    /**
     * Method sets attribute {@link #age}.<br/>
     *
     * @param pAge Value to which {@link #age} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAge( @MyNotNullProperty Integer pAge ) {
      // Assign value to attribute
      age = pAge;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class IgnoringClass. The object will be initialized with the values of the
     * builder.
     *
     * @return IgnoringClass Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class IgnoringClassBuilderImpl extends IgnoringClassBuilder<IgnoringClass, IgnoringClassBuilderImpl> {
    protected IgnoringClassBuilderImpl( ) {
    }

    protected IgnoringClassBuilderImpl( IgnoringClass pObject ) {
      super(pObject);
    }

    @Override
    protected IgnoringClassBuilderImpl self( ) {
      return this;
    }

    @Override
    public IgnoringClass build( ) {
      IgnoringClass lObject = new IgnoringClass(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #age}.<br/>
   *
   * @return {@link Integer} Value to which {@link #age} is set.
   */
  @MyNotNullProperty
  public Integer getAge( ) {
    return age;
  }

  /**
   * Method sets attribute {@link #age}.<br/>
   *
   * @param pAge Value to which {@link #age} should be set.
   */
  public void setAge( @MyNotNullProperty Integer pAge ) {
    // Assign value to attribute
    age = pAge;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(age);
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
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      IgnoringClass lOther = (IgnoringClass) pObject;
      lEquals = Objects.equals(age, lOther.age);
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
    lBuilder.append("age: ");
    lBuilder.append(age);
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
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects. The method never returns
   * null.
   */
  public IgnoringClassBuilder<?, ?> toBuilder( ) {
    return new IgnoringClassBuilderImpl(this);
  }
}