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
@JsonDeserialize(builder = DerivedClassImpl.DerivedClassImplBuilderImpl.class)
public class DerivedClassImpl extends AbtractWithDerivedProperty {
  /**
   * Constant for the name of attribute "derivedProperty".
   */
  public static final String DERIVEDPROPERTY = "derivedProperty";

  private String derivedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DerivedClassImpl( DerivedClassImplBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    derivedProperty = pBuilder.derivedProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link DerivedClassImplBuilder} New builder that can be used to create new DerivedClassImpl objects.
   */
  public static DerivedClassImplBuilder<?, ?> builder( ) {
    return new DerivedClassImplBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class DerivedClassImpl.
   *
   *
   * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
   *
   * @return {@link DerivedClassImpl}
   */
  public static DerivedClassImpl of( String pDerivedProperty ) {
    var lBuilder = DerivedClassImpl.builder();
    lBuilder.setDerivedProperty(pDerivedProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DerivedClassImpl</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DerivedClassImplBuilder<T extends DerivedClassImpl, B extends DerivedClassImplBuilder<T, B>>
      extends AbtractWithDerivedPropertyBuilder<T, B> {
    private String derivedProperty;

    /**
     * Use {@link DerivedClassImpl#builder()} instead of private constructor to create new builder.
     */
    protected DerivedClassImplBuilder( ) {
      super();
    }

    /**
     * Use {@link DerivedClassImpl#builder(DerivedClassImpl)} instead of private constructor to create new builder.
     */
    protected DerivedClassImplBuilder( DerivedClassImpl pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDerivedProperty(pObject.derivedProperty);
      }
    }

    /**
     * Method sets attribute {@link #derivedProperty}.<br/>
     *
     * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setDerivedProperty( @MyNotNullProperty String pDerivedProperty ) {
      // Assign value to attribute
      derivedProperty = pDerivedProperty;
      return this.self();
    }

    /**
     * Method creates a new instance of class DerivedClassImpl. The object will be initialized with the values of the
     * builder.
     *
     * @return DerivedClassImpl Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DerivedClassImplBuilderImpl
      extends DerivedClassImplBuilder<DerivedClassImpl, DerivedClassImplBuilderImpl> {
    protected DerivedClassImplBuilderImpl( ) {
    }

    protected DerivedClassImplBuilderImpl( DerivedClassImpl pObject ) {
      super(pObject);
    }

    @Override
    protected DerivedClassImplBuilderImpl self( ) {
      return this;
    }

    @Override
    public DerivedClassImpl build( ) {
      DerivedClassImpl lObject = new DerivedClassImpl(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  @Override
  public String getDerivedProperty( ) {
    return derivedProperty;
  }

  /**
   * Method sets attribute {@link #derivedProperty}.<br/>
   *
   * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
   */
  public void setDerivedProperty( @MyNotNullProperty String pDerivedProperty ) {
    // Assign value to attribute
    derivedProperty = pDerivedProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(derivedProperty);
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
      DerivedClassImpl lOther = (DerivedClassImpl) pObject;
      lEquals = Objects.equals(derivedProperty, lOther.derivedProperty);
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
    lBuilder.append("derivedProperty: ");
    lBuilder.append(derivedProperty);
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
   * @return {@link DerivedClassImplBuilder} New builder that can be used to create new DerivedClassImpl objects. The
   * method never returns null.
   */
  public DerivedClassImplBuilder<?, ?> toBuilder( ) {
    return new DerivedClassImplBuilderImpl(this);
  }
}