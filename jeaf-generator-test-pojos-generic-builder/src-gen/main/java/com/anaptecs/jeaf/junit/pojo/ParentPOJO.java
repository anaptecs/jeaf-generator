/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildPOJO.class, name = "ChildPOJO") })
@JsonDeserialize(builder = ParentPOJO.ParentPOJOBuilderImpl.class)
public class ParentPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "weirdAttribute".
   */
  @Deprecated
  public static final String WEIRDATTRIBUTE = "weirdAttribute";

  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  private final String parentAttribute;

  @Deprecated
  private final byte weirdAttribute;

  private final String hello;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentPOJO( ParentPOJOBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    weirdAttribute = pBuilder.weirdAttribute;
    hello = pBuilder.hello;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentPOJO objects.
   */
  public static ParentPOJOBuilder<?, ?> builder( ) {
    return new ParentPOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ParentPOJO.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
   *
   * @param pHello Value to which {@link #hello} should be set.
   *
   * @return {@link ParentPOJO}
   */
  public static ParentPOJO of( String pParentAttribute, byte pWeirdAttribute, String pHello ) {
    ParentPOJOBuilder<?, ?> lBuilder = ParentPOJO.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setWeirdAttribute(pWeirdAttribute);
    lBuilder.setHello(pHello);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ParentPOJOBuilder<T extends ParentPOJO, B extends ParentPOJOBuilder<T, B>> {
    private String parentAttribute;

    @Deprecated
    private byte weirdAttribute;

    private String hello;

    /**
     * Use {@link ParentPOJOBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ParentPOJOBuilder( ) {
    }

    /**
     * Use {@link ParentPOJOBuilder#builder(ParentPOJO)} instead of private constructor to create new builder.
     */
    protected ParentPOJOBuilder( ParentPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
        this.setWeirdAttribute(pObject.weirdAttribute);
        this.setHello(pObject.hello);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this.self();
    }

    /**
     * Method sets attribute {@link #weirdAttribute}.<br/>
     *
     * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public B setWeirdAttribute( byte pWeirdAttribute ) {
      // Assign value to attribute
      weirdAttribute = pWeirdAttribute;
      return this.self();
    }

    /**
     * Method sets attribute {@link #hello}.<br/>
     *
     * @param pHello Value to which {@link #hello} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ParentPOJO. The object will be initialized with the values of the builder.
     *
     * @return ParentPOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class ParentPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ParentPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentPOJO buildValidated( ) throws ConstraintViolationException {
      ParentPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class ParentPOJOBuilderImpl extends ParentPOJOBuilder<ParentPOJO, ParentPOJOBuilderImpl> {
    protected ParentPOJOBuilderImpl( ) {
    }

    protected ParentPOJOBuilderImpl( ParentPOJO pObject ) {
      super(pObject);
    }

    @Override
    protected ParentPOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public ParentPOJO build( ) {
      return new ParentPOJO(this);
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method returns attribute {@link #weirdAttribute}.<br/>
   *
   * @return byte Value to which {@link #weirdAttribute} is set.
   */
  @Deprecated
  public byte getWeirdAttribute( ) {
    return weirdAttribute;
  }

  /**
   * Method returns attribute {@link #hello}.<br/>
   *
   * @return {@link String} Value to which {@link #hello} is set.
   */
  public String getHello( ) {
    return hello;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(parentAttribute);
    lResult = lPrime * lResult + weirdAttribute;
    lResult = lPrime * lResult + Objects.hashCode(hello);
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
      ParentPOJO lOther = (ParentPOJO) pObject;
      lEquals = Objects.equals(parentAttribute, lOther.parentAttribute) && weirdAttribute == lOther.weirdAttribute
          && Objects.equals(hello, lOther.hello);
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
    lBuilder.append(pIndent);
    lBuilder.append("weirdAttribute: ");
    lBuilder.append(weirdAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("hello: ");
    lBuilder.append(hello);
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
   * @return {@link Builder} New builder that can be used to create new ParentPOJO objects. The method never returns
   * null.
   */
  public ParentPOJOBuilder<?, ?> toBuilder( ) {
    return new ParentPOJOBuilderImpl(this);
  }
}