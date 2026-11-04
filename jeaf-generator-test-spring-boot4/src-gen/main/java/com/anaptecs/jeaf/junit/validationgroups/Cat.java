/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Cat.CatBuilderImpl.class)
public class Cat extends Animal {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Cat( CatBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link CatBuilder} New builder that can be used to create new Cat objects.
   */
  public static CatBuilder<?, ?> builder( ) {
    return new CatBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Cat.
   *
   *
   * @return {@link Cat}
   */
  public static Cat of( ) {
    var lBuilder = Cat.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Cat</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class CatBuilder<T extends Cat, B extends CatBuilder<T, B>> extends AnimalBuilder<T, B> {
    /**
     * Use {@link Cat#builder()} instead of private constructor to create new builder.
     */
    protected CatBuilder( ) {
      super();
    }

    /**
     * Use {@link Cat#builder(Cat)} instead of private constructor to create new builder.
     */
    protected CatBuilder( Cat pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class Cat. The object will be initialized with the values of the builder.
     *
     * @return Cat Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class CatBuilderImpl extends CatBuilder<Cat, CatBuilderImpl> {
    protected CatBuilderImpl( ) {
    }

    protected CatBuilderImpl( Cat pObject ) {
      super(pObject);
    }

    @Override
    protected CatBuilderImpl self( ) {
      return this;
    }

    @Override
    public Cat build( ) {
      Cat lObject = new Cat(this);
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
   * @return {@link CatBuilder} New builder that can be used to create new Cat objects. The method never returns null.
   */
  public CatBuilder<?, ?> toBuilder( ) {
    return new CatBuilderImpl(this);
  }
}