/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class ChildBeanParameterType extends ParentBeanParamType {
  /**
   * Constant for the name of attribute "childProperty".
   */
  public static final String CHILDPROPERTY = "childProperty";

  private String childProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildBeanParameterType( ChildBeanParameterTypeBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childProperty = pBuilder.childProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildBeanParameterType objects.
   */
  public static ChildBeanParameterTypeBuilder<?, ?> builder( ) {
    return new ChildBeanParameterTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ChildBeanParameterType.
   *
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @param pChildProperty Value to which {@link #childProperty} should be set.
   *
   * @return {@link com.anaptecs.spring.service.ChildBeanParameterType}
   */
  public static ChildBeanParameterType of( String pNovaKey, String pTkID, DoubleCode pCode, String pChildProperty ) {
    ChildBeanParameterTypeBuilder<?, ?> lBuilder = ChildBeanParameterType.builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    lBuilder.setCode(pCode);
    lBuilder.setChildProperty(pChildProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildBeanParameterType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ChildBeanParameterTypeBuilder<T extends ChildBeanParameterType, B extends ChildBeanParameterTypeBuilder<T, B>>
      extends ParentBeanParamTypeBuilder<T, B> {
    private String childProperty;

    /**
     * Use {@link ChildBeanParameterTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ChildBeanParameterTypeBuilder( ) {
      super();
    }

    /**
     * Use {@link ChildBeanParameterTypeBuilder#builder(ChildBeanParameterType)} instead of private constructor to
     * create new builder.
     */
    protected ChildBeanParameterTypeBuilder( ChildBeanParameterType pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildProperty(pObject.childProperty);
      }
    }

    /**
     * Method sets attribute {@link #childProperty}.<br/>
     *
     * @param pChildProperty Value to which {@link #childProperty} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChildProperty( @MyNotNullProperty String pChildProperty ) {
      // Assign value to attribute
      childProperty = pChildProperty;
      return this.self();
    }

    /**
     * Method creates a new instance of class ChildBeanParameterType. The object will be initialized with the values of
     * the builder.
     *
     * @return ChildBeanParameterType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ChildBeanParameterTypeBuilderImpl
      extends ChildBeanParameterTypeBuilder<ChildBeanParameterType, ChildBeanParameterTypeBuilderImpl> {
    protected ChildBeanParameterTypeBuilderImpl( ) {
    }

    protected ChildBeanParameterTypeBuilderImpl( ChildBeanParameterType pObject ) {
      super(pObject);
    }

    @Override
    protected ChildBeanParameterTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public ChildBeanParameterType build( ) {
      ChildBeanParameterType lObject = new ChildBeanParameterType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #childProperty} is set.
   */
  @MyNotNullProperty
  public String getChildProperty( ) {
    return childProperty;
  }

  /**
   * Method sets attribute {@link #childProperty}.<br/>
   *
   * @param pChildProperty Value to which {@link #childProperty} should be set.
   */
  public void setChildProperty( @MyNotNullProperty String pChildProperty ) {
    // Assign value to attribute
    childProperty = pChildProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(childProperty);
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
      ChildBeanParameterType lOther = (ChildBeanParameterType) pObject;
      lEquals = Objects.equals(childProperty, lOther.childProperty);
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
    lBuilder.append("childProperty: ");
    lBuilder.append(childProperty);
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
   * @return {@link Builder} New builder that can be used to create new ChildBeanParameterType objects. The method never
   * returns null.
   */
  public ChildBeanParameterTypeBuilder<?, ?> toBuilder( ) {
    return new ChildBeanParameterTypeBuilderImpl(this);
  }
}