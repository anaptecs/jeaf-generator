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
@JsonDeserialize(builder = Elephant.ElephantBuilderImpl.class)
public class Elephant extends Animal {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Elephant( ElephantBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ElephantBuilder} New builder that can be used to create new Elephant objects.
   */
  public static ElephantBuilder<?, ?> builder( ) {
    return new ElephantBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Elephant.
   *
   *
   * @return {@link Elephant}
   */
  public static Elephant of( ) {
    var lBuilder = Elephant.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Elephant</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ElephantBuilder<T extends Elephant, B extends ElephantBuilder<T, B>>
      extends AnimalBuilder<T, B> {
    /**
     * Use {@link Elephant#builder()} instead of private constructor to create new builder.
     */
    protected ElephantBuilder( ) {
      super();
    }

    /**
     * Use {@link Elephant#builder(Elephant)} instead of private constructor to create new builder.
     */
    protected ElephantBuilder( Elephant pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class Elephant. The object will be initialized with the values of the builder.
     *
     * @return Elephant Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ElephantBuilderImpl extends ElephantBuilder<Elephant, ElephantBuilderImpl> {
    protected ElephantBuilderImpl( ) {
    }

    protected ElephantBuilderImpl( Elephant pObject ) {
      super(pObject);
    }

    @Override
    protected ElephantBuilderImpl self( ) {
      return this;
    }

    @Override
    public Elephant build( ) {
      Elephant lObject = new Elephant(this);
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
   * @return {@link ElephantBuilder} New builder that can be used to create new Elephant objects. The method never
   * returns null.
   */
  public ElephantBuilder<?, ?> toBuilder( ) {
    return new ElephantBuilderImpl(this);
  }
}