/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * This is the first line of the first comment<br/>
 * 2nd line
 * <p/>
 * 2.1<br/>
 * 2.2
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated We do not like this class any more. (<b>since:</b> Big bang, <b>removed with:</b> Last X-Mas)
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Deprecated
@JsonDeserialize(builder = ChildPOJO.ChildPOJOBuilderImpl.class)
public class ChildPOJO extends ParentPOJO {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  @NotNull
  private final Integer childAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildPOJO( ChildPOJOBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ChildPOJOBuilder} New builder that can be used to create new ChildPOJO objects.
   */
  public static ChildPOJOBuilder<?, ?> builder( ) {
    return new ChildPOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ChildPOJO.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
   *
   * @param pHello Value to which {@link #hello} should be set.
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   *
   * @return {@link ChildPOJO}
   */
  public static ChildPOJO of( String pParentAttribute, byte pWeirdAttribute, String pHello, Integer pChildAttribute ) {
    var lBuilder = ChildPOJO.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setWeirdAttribute(pWeirdAttribute);
    lBuilder.setHello(pHello);
    lBuilder.setChildAttribute(pChildAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildPOJO</code>.
   */
  @Deprecated
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ChildPOJOBuilder<T extends ChildPOJO, B extends ChildPOJOBuilder<T, B>>
      extends ParentPOJOBuilder<T, B> {
    @NotNull
    private Integer childAttribute;

    /**
     * Use {@link ChildPOJO#builder()} instead of private constructor to create new builder.
     */
    protected ChildPOJOBuilder( ) {
      super();
    }

    /**
     * Use {@link ChildPOJO#builder(ChildPOJO)} instead of private constructor to create new builder.
     */
    protected ChildPOJOBuilder( ChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAttribute(pObject.childAttribute);
      }
    }

    /**
     * Method sets attribute {@link #childAttribute}.<br/>
     *
     * @param pChildAttribute Value to which {@link #childAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChildAttribute( Integer pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this.self();
    }

    /**
     * Method creates a new instance of class ChildPOJO. The object will be initialized with the values of the builder.
     *
     * @return ChildPOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class ChildPOJO. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildPOJO buildValidated( ) throws ConstraintViolationException {
      ChildPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class ChildPOJOBuilderImpl extends ChildPOJOBuilder<ChildPOJO, ChildPOJOBuilderImpl> {
    protected ChildPOJOBuilderImpl( ) {
    }

    protected ChildPOJOBuilderImpl( ChildPOJO pObject ) {
      super(pObject);
    }

    @Override
    protected ChildPOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public ChildPOJO build( ) {
      return new ChildPOJO(this);
    }
  }

  /**
   * Method returns attribute {@link #childAttribute}.<br/>
   *
   * @return {@link Integer} Value to which {@link #childAttribute} is set.
   */
  public Integer getChildAttribute( ) {
    return childAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(childAttribute);
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
      ChildPOJO lOther = (ChildPOJO) pObject;
      lEquals = Objects.equals(childAttribute, lOther.childAttribute);
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
    lBuilder.append("childAttribute: ");
    lBuilder.append(childAttribute);
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
   * @return {@link ChildPOJOBuilder} New builder that can be used to create new ChildPOJO objects. The method never
   * returns null.
   */
  public ChildPOJOBuilder<?, ?> toBuilder( ) {
    return new ChildPOJOBuilderImpl(this);
  }
}