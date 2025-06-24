/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class ContextWithPrimitives {
  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "aBooleanWrapper".
   */
  public static final String ABOOLEANWRAPPER = "aBooleanWrapper";

  /**
   * Constant for the name of attribute "anInt".
   */
  public static final String ANINT = "anInt";

  /**
   * Constant for the name of attribute "anInteger".
   */
  public static final String ANINTEGER = "anInteger";

  /**
   * Constant for the name of attribute "aLong".
   */
  public static final String ALONG = "aLong";

  /**
   * Constant for the name of attribute "aVeryLong".
   */
  public static final String AVERYLONG = "aVeryLong";

  private boolean aBoolean;

  private Boolean aBooleanWrapper;

  private int anInt;

  private Integer anInteger;

  private long aLong;

  private Long aVeryLong;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ContextWithPrimitives( ContextWithPrimitivesBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    aBooleanWrapper = pBuilder.aBooleanWrapper;
    anInt = pBuilder.anInt;
    anInteger = pBuilder.anInteger;
    aLong = pBuilder.aLong;
    aVeryLong = pBuilder.aVeryLong;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ContextWithPrimitives objects.
   */
  public static ContextWithPrimitivesBuilder<?, ?> builder( ) {
    return new ContextWithPrimitivesBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ContextWithPrimitives.
   *
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   *
   * @param pABooleanWrapper Value to which {@link #aBooleanWrapper} should be set.
   *
   * @param pAnInt Value to which {@link #anInt} should be set.
   *
   * @param pAnInteger Value to which {@link #anInteger} should be set.
   *
   * @param pALong Value to which {@link #aLong} should be set.
   *
   * @param pAVeryLong Value to which {@link #aVeryLong} should be set.
   *
   * @return {@link com.anaptecs.spring.service.ContextWithPrimitives}
   */
  public static ContextWithPrimitives of( boolean pABoolean, Boolean pABooleanWrapper, int pAnInt, Integer pAnInteger,
      long pALong, Long pAVeryLong ) {
    ContextWithPrimitivesBuilder<?, ?> lBuilder = ContextWithPrimitives.builder();
    lBuilder.setABoolean(pABoolean);
    lBuilder.setABooleanWrapper(pABooleanWrapper);
    lBuilder.setAnInt(pAnInt);
    lBuilder.setAnInteger(pAnInteger);
    lBuilder.setALong(pALong);
    lBuilder.setAVeryLong(pAVeryLong);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ContextWithPrimitives</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ContextWithPrimitivesBuilder<T extends ContextWithPrimitives, S extends ContextWithPrimitivesBuilder<T, S>> {
    private boolean aBoolean;

    private Boolean aBooleanWrapper;

    private int anInt;

    private Integer anInteger;

    private long aLong;

    private Long aVeryLong;

    /**
     * Use {@link ContextWithPrimitivesBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ContextWithPrimitivesBuilder( ) {
    }

    /**
     * Use {@link ContextWithPrimitivesBuilder#builder(ContextWithPrimitives)} instead of private constructor to create
     * new builder.
     */
    protected ContextWithPrimitivesBuilder( ContextWithPrimitives pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setABoolean(pObject.aBoolean);
        this.setABooleanWrapper(pObject.aBooleanWrapper);
        this.setAnInt(pObject.anInt);
        this.setAnInteger(pObject.anInteger);
        this.setALong(pObject.aLong);
        this.setAVeryLong(pObject.aVeryLong);
      }
    }

    /**
     * Method sets attribute {@link #aBoolean}.<br/>
     *
     * @param pABoolean Value to which {@link #aBoolean} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this.self();
    }

    /**
     * Method sets attribute {@link #aBooleanWrapper}.<br/>
     *
     * @param pABooleanWrapper Value to which {@link #aBooleanWrapper} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setABooleanWrapper( @MyNotNullProperty Boolean pABooleanWrapper ) {
      // Assign value to attribute
      aBooleanWrapper = pABooleanWrapper;
      return this.self();
    }

    /**
     * Method sets attribute {@link #anInt}.<br/>
     *
     * @param pAnInt Value to which {@link #anInt} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setAnInt( int pAnInt ) {
      // Assign value to attribute
      anInt = pAnInt;
      return this.self();
    }

    /**
     * Method sets attribute {@link #anInteger}.<br/>
     *
     * @param pAnInteger Value to which {@link #anInteger} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setAnInteger( @MyNotNullProperty Integer pAnInteger ) {
      // Assign value to attribute
      anInteger = pAnInteger;
      return this.self();
    }

    /**
     * Method sets attribute {@link #aLong}.<br/>
     *
     * @param pALong Value to which {@link #aLong} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setALong( long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this.self();
    }

    /**
     * Method sets attribute {@link #aVeryLong}.<br/>
     *
     * @param pAVeryLong Value to which {@link #aVeryLong} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setAVeryLong( @MyNotNullProperty Long pAVeryLong ) {
      // Assign value to attribute
      aVeryLong = pAVeryLong;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract S self( );

    /**
     * Method creates a new instance of class ContextWithPrimitives. The object will be initialized with the values of
     * the builder.
     *
     * @return ContextWithPrimitives Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ContextWithPrimitivesBuilderImpl
      extends ContextWithPrimitivesBuilder<ContextWithPrimitives, ContextWithPrimitivesBuilderImpl> {
    protected ContextWithPrimitivesBuilderImpl( ) {
    }

    protected ContextWithPrimitivesBuilderImpl( ContextWithPrimitives pObject ) {
      super(pObject);
    }

    @Override
    protected ContextWithPrimitivesBuilderImpl self( ) {
      return this;
    }

    @Override
    public ContextWithPrimitives build( ) {
      ContextWithPrimitives lObject = new ContextWithPrimitives(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  @Deprecated
  public boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  public boolean isABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets attribute {@link #aBoolean}.<br/>
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   */
  public void setABoolean( boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  /**
   * Method returns attribute {@link #aBooleanWrapper}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #aBooleanWrapper} is set.
   */
  @MyNotNullProperty
  public Boolean getABooleanWrapper( ) {
    return aBooleanWrapper;
  }

  /**
   * Method sets attribute {@link #aBooleanWrapper}.<br/>
   *
   * @param pABooleanWrapper Value to which {@link #aBooleanWrapper} should be set.
   */
  public void setABooleanWrapper( @MyNotNullProperty Boolean pABooleanWrapper ) {
    // Assign value to attribute
    aBooleanWrapper = pABooleanWrapper;
  }

  /**
   * Method returns attribute {@link #anInt}.<br/>
   *
   * @return int Value to which {@link #anInt} is set.
   */
  public int getAnInt( ) {
    return anInt;
  }

  /**
   * Method sets attribute {@link #anInt}.<br/>
   *
   * @param pAnInt Value to which {@link #anInt} should be set.
   */
  public void setAnInt( int pAnInt ) {
    // Assign value to attribute
    anInt = pAnInt;
  }

  /**
   * Method returns attribute {@link #anInteger}.<br/>
   *
   * @return {@link Integer} Value to which {@link #anInteger} is set.
   */
  @MyNotNullProperty
  public Integer getAnInteger( ) {
    return anInteger;
  }

  /**
   * Method sets attribute {@link #anInteger}.<br/>
   *
   * @param pAnInteger Value to which {@link #anInteger} should be set.
   */
  public void setAnInteger( @MyNotNullProperty Integer pAnInteger ) {
    // Assign value to attribute
    anInteger = pAnInteger;
  }

  /**
   * Method returns attribute {@link #aLong}.<br/>
   *
   * @return long Value to which {@link #aLong} is set.
   */
  public long getALong( ) {
    return aLong;
  }

  /**
   * Method sets attribute {@link #aLong}.<br/>
   *
   * @param pALong Value to which {@link #aLong} should be set.
   */
  public void setALong( long pALong ) {
    // Assign value to attribute
    aLong = pALong;
  }

  /**
   * Method returns attribute {@link #aVeryLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #aVeryLong} is set.
   */
  @MyNotNullProperty
  public Long getAVeryLong( ) {
    return aVeryLong;
  }

  /**
   * Method sets attribute {@link #aVeryLong}.<br/>
   *
   * @param pAVeryLong Value to which {@link #aVeryLong} should be set.
   */
  public void setAVeryLong( @MyNotNullProperty Long pAVeryLong ) {
    // Assign value to attribute
    aVeryLong = pAVeryLong;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Boolean.hashCode(aBoolean);
    lResult = lPrime * lResult + Objects.hashCode(aBooleanWrapper);
    lResult = lPrime * lResult + anInt;
    lResult = lPrime * lResult + Objects.hashCode(anInteger);
    lResult = lPrime * lResult + Long.hashCode(aLong);
    lResult = lPrime * lResult + Objects.hashCode(aVeryLong);
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
      ContextWithPrimitives lOther = (ContextWithPrimitives) pObject;
      lEquals = aBoolean == lOther.aBoolean && Objects.equals(aBooleanWrapper, lOther.aBooleanWrapper)
          && anInt == lOther.anInt && Objects.equals(anInteger, lOther.anInteger) && aLong == lOther.aLong
          && Objects.equals(aVeryLong, lOther.aVeryLong);
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
    lBuilder.append("aBoolean: ");
    lBuilder.append(aBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aBooleanWrapper: ");
    lBuilder.append(aBooleanWrapper);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anInt: ");
    lBuilder.append(anInt);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anInteger: ");
    lBuilder.append(anInteger);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aLong: ");
    lBuilder.append(aLong);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aVeryLong: ");
    lBuilder.append(aVeryLong);
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
   * @return {@link Builder} New builder that can be used to create new ContextWithPrimitives objects. The method never
   * returns null.
   */
  public ContextWithPrimitivesBuilder<?, ?> toBuilder( ) {
    return new ContextWithPrimitivesBuilderImpl(this);
  }
}