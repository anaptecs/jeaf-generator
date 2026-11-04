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
@JsonDeserialize(builder = Dog.DogBuilderImpl.class)
public class Dog extends Animal {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Dog( DogBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link DogBuilder} New builder that can be used to create new Dog objects.
   */
  public static DogBuilder<?, ?> builder( ) {
    return new DogBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Dog.
   *
   *
   * @return {@link Dog}
   */
  public static Dog of( ) {
    var lBuilder = Dog.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Dog</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DogBuilder<T extends Dog, B extends DogBuilder<T, B>> extends AnimalBuilder<T, B> {
    /**
     * Use {@link Dog#builder()} instead of private constructor to create new builder.
     */
    protected DogBuilder( ) {
      super();
    }

    /**
     * Use {@link Dog#builder(Dog)} instead of private constructor to create new builder.
     */
    protected DogBuilder( Dog pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class Dog. The object will be initialized with the values of the builder.
     *
     * @return Dog Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DogBuilderImpl extends DogBuilder<Dog, DogBuilderImpl> {
    protected DogBuilderImpl( ) {
    }

    protected DogBuilderImpl( Dog pObject ) {
      super(pObject);
    }

    @Override
    protected DogBuilderImpl self( ) {
      return this;
    }

    @Override
    public Dog build( ) {
      Dog lObject = new Dog(this);
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
   * @return {@link DogBuilder} New builder that can be used to create new Dog objects. The method never returns null.
   */
  public DogBuilder<?, ?> toBuilder( ) {
    return new DogBuilderImpl(this);
  }
}