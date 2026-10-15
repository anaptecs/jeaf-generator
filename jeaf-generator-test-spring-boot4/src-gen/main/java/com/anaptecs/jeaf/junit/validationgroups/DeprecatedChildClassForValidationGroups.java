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
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> 5.x, <b>removed with:</b> 8.0, <b>go live date:</b> 2027-05-01, <b>end of compatibility
 * period:</b> 2026-10-20)
 */
@Deprecated
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(
    builder = DeprecatedChildClassForValidationGroups.DeprecatedChildClassForValidationGroupsBuilderImpl.class)
public class DeprecatedChildClassForValidationGroups extends ParentClassForValidationGroups {
  /**
   * Constant for the name of attribute "myProperty".
   */
  public static final String MYPROPERTY = "myProperty";

  @NotNull
  private String myProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedChildClassForValidationGroups( DeprecatedChildClassForValidationGroupsBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    myProperty = pBuilder.myProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link DeprecatedChildClassForValidationGroupsBuilder} New builder that can be used to create new
   * DeprecatedChildClassForValidationGroups objects.
   */
  public static DeprecatedChildClassForValidationGroupsBuilder<?, ?> builder( ) {
    return new DeprecatedChildClassForValidationGroupsBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class DeprecatedChildClassForValidationGroups.
   *
   *
   * @param pParentProperty Value to which {@link #parentProperty} should be set.
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   *
   * @return {@link DeprecatedChildClassForValidationGroups}
   */
  public static DeprecatedChildClassForValidationGroups of( String pParentProperty, String pMyProperty ) {
    var lBuilder = DeprecatedChildClassForValidationGroups.builder();
    lBuilder.setParentProperty(pParentProperty);
    lBuilder.setMyProperty(pMyProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedChildClassForValidationGroups</code>.
   */
  @Deprecated
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DeprecatedChildClassForValidationGroupsBuilder<T extends DeprecatedChildClassForValidationGroups, B extends DeprecatedChildClassForValidationGroupsBuilder<T, B>>
      extends ParentClassForValidationGroupsBuilder<T, B> {
    private String myProperty;

    /**
     * Use {@link DeprecatedChildClassForValidationGroups#builder()} instead of private constructor to create new
     * builder.
     */
    protected DeprecatedChildClassForValidationGroupsBuilder( ) {
      super();
    }

    /**
     * Use {@link DeprecatedChildClassForValidationGroups#builder(DeprecatedChildClassForValidationGroups)} instead of
     * private constructor to create new builder.
     */
    protected DeprecatedChildClassForValidationGroupsBuilder( DeprecatedChildClassForValidationGroups pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyProperty(pObject.myProperty);
      }
    }

    /**
     * Method sets attribute {@link #myProperty}.<br/>
     *
     * @param pMyProperty Value to which {@link #myProperty} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setMyProperty( @MyNotNullProperty String pMyProperty ) {
      // Assign value to attribute
      myProperty = pMyProperty;
      return this.self();
    }

    /**
     * Method creates a new instance of class DeprecatedChildClassForValidationGroups. The object will be initialized
     * with the values of the builder.
     *
     * @return DeprecatedChildClassForValidationGroups Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DeprecatedChildClassForValidationGroupsBuilderImpl extends
      DeprecatedChildClassForValidationGroupsBuilder<DeprecatedChildClassForValidationGroups, DeprecatedChildClassForValidationGroupsBuilderImpl> {
    protected DeprecatedChildClassForValidationGroupsBuilderImpl( ) {
    }

    protected DeprecatedChildClassForValidationGroupsBuilderImpl( DeprecatedChildClassForValidationGroups pObject ) {
      super(pObject);
    }

    @Override
    protected DeprecatedChildClassForValidationGroupsBuilderImpl self( ) {
      return this;
    }

    @Override
    public DeprecatedChildClassForValidationGroups build( ) {
      DeprecatedChildClassForValidationGroups lObject = new DeprecatedChildClassForValidationGroups(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #myProperty} is set.
   */
  @MyNotNullProperty
  public String getMyProperty( ) {
    return myProperty;
  }

  /**
   * Method sets attribute {@link #myProperty}.<br/>
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   */
  public void setMyProperty( @MyNotNullProperty String pMyProperty ) {
    // Assign value to attribute
    myProperty = pMyProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(myProperty);
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
      DeprecatedChildClassForValidationGroups lOther = (DeprecatedChildClassForValidationGroups) pObject;
      lEquals = Objects.equals(myProperty, lOther.myProperty);
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
    lBuilder.append("myProperty: ");
    lBuilder.append(myProperty);
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
   * @return {@link DeprecatedChildClassForValidationGroupsBuilder} New builder that can be used to create new
   * DeprecatedChildClassForValidationGroups objects. The method never returns null.
   */
  public DeprecatedChildClassForValidationGroupsBuilder<?, ?> toBuilder( ) {
    return new DeprecatedChildClassForValidationGroupsBuilderImpl(this);
  }
}