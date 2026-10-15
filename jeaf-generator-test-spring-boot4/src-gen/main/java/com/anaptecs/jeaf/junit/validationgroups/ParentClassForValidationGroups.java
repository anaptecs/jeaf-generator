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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeMapping", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(
    value = DeprecatedChildClassForValidationGroups.class,
    name = "DeprecatedChildClassForValidationGroups") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = ParentClassForValidationGroups.ParentClassForValidationGroupsBuilderImpl.class)
public class ParentClassForValidationGroups {
  /**
   * Constant for the name of attribute "parentProperty".
   */
  public static final String PARENTPROPERTY = "parentProperty";

  @NotNull
  private String parentProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentClassForValidationGroups( ParentClassForValidationGroupsBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    parentProperty = pBuilder.parentProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ParentClassForValidationGroupsBuilder} New builder that can be used to create new
   * ParentClassForValidationGroups objects.
   */
  public static ParentClassForValidationGroupsBuilder<?, ?> builder( ) {
    return new ParentClassForValidationGroupsBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ParentClassForValidationGroups.
   *
   *
   * @param pParentProperty Value to which {@link #parentProperty} should be set.
   *
   * @return {@link ParentClassForValidationGroups}
   */
  public static ParentClassForValidationGroups of( String pParentProperty ) {
    var lBuilder = ParentClassForValidationGroups.builder();
    lBuilder.setParentProperty(pParentProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentClassForValidationGroups</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ParentClassForValidationGroupsBuilder<T extends ParentClassForValidationGroups, B extends ParentClassForValidationGroupsBuilder<T, B>> {
    private String parentProperty;

    /**
     * Use {@link ParentClassForValidationGroups#builder()} instead of private constructor to create new builder.
     */
    protected ParentClassForValidationGroupsBuilder( ) {
    }

    /**
     * Use {@link ParentClassForValidationGroups#builder(ParentClassForValidationGroups)} instead of private constructor
     * to create new builder.
     */
    protected ParentClassForValidationGroupsBuilder( ParentClassForValidationGroups pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentProperty(pObject.parentProperty);
      }
    }

    /**
     * Method sets attribute {@link #parentProperty}.<br/>
     *
     * @param pParentProperty Value to which {@link #parentProperty} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setParentProperty( @MyNotNullProperty String pParentProperty ) {
      // Assign value to attribute
      parentProperty = pParentProperty;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ParentClassForValidationGroups. The object will be initialized with the
     * values of the builder.
     *
     * @return ParentClassForValidationGroups Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ParentClassForValidationGroupsBuilderImpl extends
      ParentClassForValidationGroupsBuilder<ParentClassForValidationGroups, ParentClassForValidationGroupsBuilderImpl> {
    protected ParentClassForValidationGroupsBuilderImpl( ) {
    }

    protected ParentClassForValidationGroupsBuilderImpl( ParentClassForValidationGroups pObject ) {
      super(pObject);
    }

    @Override
    protected ParentClassForValidationGroupsBuilderImpl self( ) {
      return this;
    }

    @Override
    public ParentClassForValidationGroups build( ) {
      ParentClassForValidationGroups lObject = new ParentClassForValidationGroups(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #parentProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #parentProperty} is set.
   */
  @MyNotNullProperty
  public String getParentProperty( ) {
    return parentProperty;
  }

  /**
   * Method sets attribute {@link #parentProperty}.<br/>
   *
   * @param pParentProperty Value to which {@link #parentProperty} should be set.
   */
  public void setParentProperty( @MyNotNullProperty String pParentProperty ) {
    // Assign value to attribute
    parentProperty = pParentProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(parentProperty);
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
      ParentClassForValidationGroups lOther = (ParentClassForValidationGroups) pObject;
      lEquals = Objects.equals(parentProperty, lOther.parentProperty);
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
    lBuilder.append("parentProperty: ");
    lBuilder.append(parentProperty);
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
   * @return {@link ParentClassForValidationGroupsBuilder} New builder that can be used to create new
   * ParentClassForValidationGroups objects. The method never returns null.
   */
  public ParentClassForValidationGroupsBuilder<?, ?> toBuilder( ) {
    return new ParentClassForValidationGroupsBuilderImpl(this);
  }
}