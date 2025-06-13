/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

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
@JsonDeserialize(builder = TopoRef.TopoRefBuilderImpl.class)
public class TopoRef extends PlaceRef {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TopoRef( TopoRefBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TopoRef objects.
   */
  public static TopoRefBuilder<?, ?> builder( ) {
    return new TopoRefBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class TopoRef.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pType Value to which {@link #type} should be set.
   *
   * @return {@link TopoRef}
   */
  public static TopoRef of( String pName, MyType pType ) {
    TopoRefBuilder<?, ?> lBuilder = TopoRef.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TopoRef</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class TopoRefBuilder<T extends TopoRef, B extends TopoRefBuilder<T, B>>
      extends PlaceRefBuilder<T, B> {
    /**
     * Use {@link TopoRefBuilder#builder()} instead of private constructor to create new builder.
     */
    protected TopoRefBuilder( ) {
      super();
    }

    /**
     * Use {@link TopoRefBuilder#builder(TopoRef)} instead of private constructor to create new builder.
     */
    protected TopoRefBuilder( TopoRef pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class TopoRef. The object will be initialized with the values of the builder.
     *
     * @return TopoRef Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class TopoRefBuilderImpl extends TopoRefBuilder<TopoRef, TopoRefBuilderImpl> {
    protected TopoRefBuilderImpl( ) {
    }

    protected TopoRefBuilderImpl( TopoRef pObject ) {
      super(pObject);
    }

    @Override
    protected TopoRefBuilderImpl self( ) {
      return this;
    }

    @Override
    public TopoRef build( ) {
      TopoRef lObject = new TopoRef(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return super.hashCode();
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
      lEquals = true;
    }
    return lEquals;
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new TopoRef objects. The method never returns null.
   */
  public TopoRefBuilder<?, ?> toBuilder( ) {
    return new TopoRefBuilderImpl(this);
  }
}