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
@JsonDeserialize(builder = EnumTest.EnumTestBuilderImpl.class)
public class EnumTest {
  /**
   * Constant for the name of attribute "property".
   */
  public static final String PROPERTY = "property";

  /**
   * Constant for the name of attribute "enumRef".
   */
  public static final String ENUMREF = "enumRef";

  /**
   * <br/>
   * <b>Default Value:</b> <code>GREEN</code>
   */
  private ExtensibleEnum property;

  /**
   * <br/>
   * <b>Default Value:</b> <code>RED</code>
   */
  private ExtensibleEnum enumRef;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected EnumTest( EnumTestBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    property = pBuilder.property;
    enumRef = pBuilder.enumRef;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new EnumTest objects.
   */
  public static EnumTestBuilder<?, ?> builder( ) {
    return new EnumTestBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class EnumTest.
   *
   *
   * @param pProperty Value to which {@link #property} should be set.
   *
   * @param pEnumRef Value to which {@link #enumRef} should be set.
   *
   * @return {@link EnumTest}
   */
  public static EnumTest of( ExtensibleEnum pProperty, ExtensibleEnum pEnumRef ) {
    EnumTestBuilder<?, ?> lBuilder = EnumTest.builder();
    lBuilder.setProperty(pProperty);
    lBuilder.setEnumRef(pEnumRef);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>EnumTest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class EnumTestBuilder<T extends EnumTest, S extends EnumTestBuilder<T, S>> {
    /**
     * <br/>
     * <b>Default Value:</b> <code>GREEN</code>
     */
    private ExtensibleEnum property = ExtensibleEnum.GREEN;

    /**
     * <br/>
     * <b>Default Value:</b> <code>RED</code>
     */
    private ExtensibleEnum enumRef = ExtensibleEnum.RED;

    /**
     * Use {@link EnumTestBuilder#builder()} instead of private constructor to create new builder.
     */
    protected EnumTestBuilder( ) {
    }

    /**
     * Use {@link EnumTestBuilder#builder(EnumTest)} instead of private constructor to create new builder.
     */
    protected EnumTestBuilder( EnumTest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProperty(pObject.property);
        this.setEnumRef(pObject.enumRef);
      }
    }

    /**
     * Method sets attribute {@link #property}.<br/>
     *
     * @param pProperty Value to which {@link #property} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setProperty( @MyNotNullProperty ExtensibleEnum pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this.self();
    }

    /**
     * Method sets association {@link #enumRef}.<br/>
     *
     * @param pEnumRef Value to which {@link #enumRef} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setEnumRef( @MyNotNullProperty ExtensibleEnum pEnumRef ) {
      enumRef = pEnumRef;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract S self( );

    /**
     * Method creates a new instance of class EnumTest. The object will be initialized with the values of the builder.
     *
     * @return EnumTest Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class EnumTestBuilderImpl extends EnumTestBuilder<EnumTest, EnumTestBuilderImpl> {
    protected EnumTestBuilderImpl( ) {
    }

    protected EnumTestBuilderImpl( EnumTest pObject ) {
      super(pObject);
    }

    @Override
    protected EnumTestBuilderImpl self( ) {
      return this;
    }

    @Override
    public EnumTest build( ) {
      EnumTest lObject = new EnumTest(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #property}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #property} is set.
   */
  @MyNotNullProperty
  public ExtensibleEnum getProperty( ) {
    return property;
  }

  /**
   * Method sets attribute {@link #property}.<br/>
   *
   * @param pProperty Value to which {@link #property} should be set.
   */
  public void setProperty( @MyNotNullProperty ExtensibleEnum pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  /**
   * Method returns association {@link #enumRef}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #enumRef} is set.
   */
  @MyNotNullProperty
  public ExtensibleEnum getEnumRef( ) {
    return enumRef;
  }

  /**
   * Method sets association {@link #enumRef}.<br/>
   *
   * @param pEnumRef Value to which {@link #enumRef} should be set.
   */
  public void setEnumRef( @MyNotNullProperty ExtensibleEnum pEnumRef ) {
    enumRef = pEnumRef;
  }

  /**
   * Method unsets {@link #enumRef}.
   */
  public final void unsetEnumRef( ) {
    enumRef = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(property);
    lResult = lPrime * lResult + Objects.hashCode(enumRef);
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
      EnumTest lOther = (EnumTest) pObject;
      lEquals = Objects.equals(property, lOther.property) && Objects.equals(enumRef, lOther.enumRef);
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
    lBuilder.append("property: ");
    lBuilder.append(property);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("enumRef: ");
    lBuilder.append(enumRef);
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
   * @return {@link Builder} New builder that can be used to create new EnumTest objects. The method never returns null.
   */
  public EnumTestBuilder<?, ?> toBuilder( ) {
    return new EnumTestBuilderImpl(this);
  }
}