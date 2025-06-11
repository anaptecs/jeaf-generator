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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = MutableChildPOJO.MutableChildPOJOBuilderImpl.class)
public class MutableChildPOJO extends ImmutablePOJOParent {
  /**
   * Constant for the name of attribute "writeable".
   */
  public static final String WRITEABLE = "writeable";

  /**
   * Constant for the name of attribute "booleanDefault".
   */
  public static final String BOOLEANDEFAULT = "booleanDefault";

  private final Integer writeable;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private final Boolean booleanDefault;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MutableChildPOJO( MutableChildPOJOBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    writeable = pBuilder.writeable;
    booleanDefault = pBuilder.booleanDefault;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MutableChildPOJO objects.
   */
  public static MutableChildPOJOBuilder<?, ?> builder( ) {
    return new MutableChildPOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class MutableChildPOJO.
   *
   *
   * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
   *
   * @param pWriteable Value to which {@link #writeable} should be set.
   *
   * @param pBooleanDefault Value to which {@link #booleanDefault} should be set.
   *
   * @return {@link MutableChildPOJO}
   */
  public static MutableChildPOJO of( String pAbtractAttr, String pParentAttribute, Integer pAnotherParentAttribute,
      Integer pWriteable, Boolean pBooleanDefault ) {
    MutableChildPOJOBuilder<?, ?> lBuilder = MutableChildPOJO.builder();
    lBuilder.setAbtractAttr(pAbtractAttr);
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setAnotherParentAttribute(pAnotherParentAttribute);
    lBuilder.setWriteable(pWriteable);
    lBuilder.setBooleanDefault(pBooleanDefault);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MutableChildPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class MutableChildPOJOBuilder<T extends MutableChildPOJO, B extends MutableChildPOJOBuilder<T, B>>
      extends ImmutablePOJOParentBuilder<T, B> {
    private Integer writeable;

    /**
     * <br/>
     * <b>Default Value:</b> <code>true</code>
     */
    private Boolean booleanDefault = true;

    /**
     * Use {@link MutableChildPOJOBuilder#builder()} instead of private constructor to create new builder.
     */
    protected MutableChildPOJOBuilder( ) {
      super();
    }

    /**
     * Use {@link MutableChildPOJOBuilder#builder(MutableChildPOJO)} instead of private constructor to create new
     * builder.
     */
    protected MutableChildPOJOBuilder( MutableChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setWriteable(pObject.writeable);
        this.setBooleanDefault(pObject.booleanDefault);
      }
    }

    /**
     * Method sets attribute {@link #writeable}.<br/>
     *
     * @param pWriteable Value to which {@link #writeable} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setWriteable( Integer pWriteable ) {
      // Assign value to attribute
      writeable = pWriteable;
      return this.self();
    }

    /**
     * Method sets attribute {@link #booleanDefault}.<br/>
     *
     * @param pBooleanDefault Value to which {@link #booleanDefault} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setBooleanDefault( Boolean pBooleanDefault ) {
      // Assign value to attribute
      booleanDefault = pBooleanDefault;
      return this.self();
    }

    /**
     * Method creates a new instance of class MutableChildPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return MutableChildPOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class MutableChildPOJO. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return MutableChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MutableChildPOJO buildValidated( ) throws ConstraintViolationException {
      MutableChildPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class MutableChildPOJOBuilderImpl
      extends MutableChildPOJOBuilder<MutableChildPOJO, MutableChildPOJOBuilderImpl> {
    protected MutableChildPOJOBuilderImpl( ) {
    }

    protected MutableChildPOJOBuilderImpl( MutableChildPOJO pObject ) {
      super(pObject);
    }

    @Override
    protected MutableChildPOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public MutableChildPOJO build( ) {
      return new MutableChildPOJO(this);
    }
  }

  /**
   * Method returns attribute {@link #writeable}.<br/>
   *
   * @return {@link Integer} Value to which {@link #writeable} is set.
   */
  public Integer getWriteable( ) {
    return writeable;
  }

  /**
   * Method returns attribute {@link #booleanDefault}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #booleanDefault} is set.
   */
  public Boolean getBooleanDefault( ) {
    return booleanDefault;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(writeable);
    lResult = lPrime * lResult + Objects.hashCode(booleanDefault);
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
      MutableChildPOJO lOther = (MutableChildPOJO) pObject;
      lEquals = Objects.equals(writeable, lOther.writeable) && Objects.equals(booleanDefault, lOther.booleanDefault);
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
    lBuilder.append("writeable: ");
    lBuilder.append(writeable);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("booleanDefault: ");
    lBuilder.append(booleanDefault);
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
   * @return {@link Builder} New builder that can be used to create new MutableChildPOJO objects. The method never
   * returns null.
   */
  public MutableChildPOJOBuilder<?, ?> toBuilder( ) {
    return new MutableChildPOJOBuilderImpl(this);
  }
}