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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildAA.class, name = "ChildAA"),
  @JsonSubTypes.Type(value = ChildB.class, name = "ChildB"),
  @JsonSubTypes.Type(value = ChildBB.class, name = "ChildBB") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = ParentClass.ParentClassBuilderImpl.class)
public class ParentClass {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  private String parentAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentClass( ParentClassBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ParentClassBuilder} New builder that can be used to create new ParentClass objects.
   */
  public static ParentClassBuilder<?, ?> builder( ) {
    return new ParentClassBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ParentClass.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @return {@link ParentClass}
   */
  public static ParentClass of( String pParentAttribute ) {
    var lBuilder = ParentClass.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ParentClassBuilder<T extends ParentClass, B extends ParentClassBuilder<T, B>> {
    private String parentAttribute;

    /**
     * Use {@link ParentClass#builder()} instead of private constructor to create new builder.
     */
    protected ParentClassBuilder( ) {
    }

    /**
     * Use {@link ParentClass#builder(ParentClass)} instead of private constructor to create new builder.
     */
    protected ParentClassBuilder( ParentClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setParentAttribute( @MyNotNullProperty String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ParentClass. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentClass Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ParentClassBuilderImpl extends ParentClassBuilder<ParentClass, ParentClassBuilderImpl> {
    protected ParentClassBuilderImpl( ) {
    }

    protected ParentClassBuilderImpl( ParentClass pObject ) {
      super(pObject);
    }

    @Override
    protected ParentClassBuilderImpl self( ) {
      return this;
    }

    @Override
    public ParentClass build( ) {
      ParentClass lObject = new ParentClass(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  @MyNotNullProperty
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets attribute {@link #parentAttribute}.<br/>
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   */
  public void setParentAttribute( @MyNotNullProperty String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(parentAttribute);
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
      ParentClass lOther = (ParentClass) pObject;
      lEquals = Objects.equals(parentAttribute, lOther.parentAttribute);
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
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
   * @return {@link ParentClassBuilder} New builder that can be used to create new ParentClass objects. The method never
   * returns null.
   */
  public ParentClassBuilder<?, ?> toBuilder( ) {
    return new ParentClassBuilderImpl(this);
  }
}