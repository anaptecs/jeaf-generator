/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Cat.class, name = "Cat"),
  @JsonSubTypes.Type(value = Dog.class, name = "Dog"), @JsonSubTypes.Type(value = Elephant.class, name = "Elephant") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Animal.AnimalBuilderImpl.class)
public class Animal {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Animal( AnimalBuilder<?, ?> pBuilder ) {
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link AnimalBuilder} New builder that can be used to create new Animal objects.
   */
  public static AnimalBuilder<?, ?> builder( ) {
    return new AnimalBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Animal.
   *
   *
   * @return {@link Animal}
   */
  public static Animal of( ) {
    var lBuilder = Animal.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Animal</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class AnimalBuilder<T extends Animal, B extends AnimalBuilder<T, B>> {
    /**
     * Use {@link Animal#builder()} instead of private constructor to create new builder.
     */
    protected AnimalBuilder( ) {
    }

    /**
     * Use {@link Animal#builder(Animal)} instead of private constructor to create new builder.
     */
    protected AnimalBuilder( Animal pObject ) {
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Animal. The object will be initialized with the values of the builder.
     *
     * @return Animal Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class AnimalBuilderImpl extends AnimalBuilder<Animal, AnimalBuilderImpl> {
    protected AnimalBuilderImpl( ) {
    }

    protected AnimalBuilderImpl( Animal pObject ) {
      super(pObject);
    }

    @Override
    protected AnimalBuilderImpl self( ) {
      return this;
    }

    @Override
    public Animal build( ) {
      Animal lObject = new Animal(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return 1;
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
      lEquals = true;
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
   * @return {@link AnimalBuilder} New builder that can be used to create new Animal objects. The method never returns
   * null.
   */
  public AnimalBuilder<?, ?> toBuilder( ) {
    return new AnimalBuilderImpl(this);
  }
}