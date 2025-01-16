/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class PrimitiveArraysObjectWithRestrictions implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  private boolean[] aBooleanArray;

  private Boolean[] bBooleanArray;

  private boolean[] cBooleanArray;

  @Size(min = 0, max = 32768)
  private byte[] aByteArray;

  private Byte[] bByteArray;

  private short[] aShortArray;

  private Short[] bShortArray;

  private int[] aIntegerArray;

  private Integer[] bIntegerArray;

  private Integer[] cIntegerArray;

  @NotEmpty
  private long[] aLongArray;

  private Long[] bLongArray;

  private BigInteger[] aBigIntegerArray;

  private char[] aCharacterArray;

  private Character[] bCharacterArray;

  private float[] aFloatArray;

  private Float[] bFloatArray;

  @Size(min = 4, max = 12)
  private double[] aDoubleArray;

  private Double[] bDoubleArray;

  private BigDecimal[] aBigDecimalArray;

  private String[] aStringArray;

  private String[] bStringArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveArraysObjectWithRestrictions( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveArraysObjectWithRestrictions( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBooleanArray = pBuilder.aBooleanArray;
    bBooleanArray = pBuilder.bBooleanArray;
    cBooleanArray = pBuilder.cBooleanArray;
    aByteArray = pBuilder.aByteArray;
    bByteArray = pBuilder.bByteArray;
    aShortArray = pBuilder.aShortArray;
    bShortArray = pBuilder.bShortArray;
    aIntegerArray = pBuilder.aIntegerArray;
    bIntegerArray = pBuilder.bIntegerArray;
    cIntegerArray = pBuilder.cIntegerArray;
    aLongArray = pBuilder.aLongArray;
    bLongArray = pBuilder.bLongArray;
    aBigIntegerArray = pBuilder.aBigIntegerArray;
    aCharacterArray = pBuilder.aCharacterArray;
    bCharacterArray = pBuilder.bCharacterArray;
    aFloatArray = pBuilder.aFloatArray;
    bFloatArray = pBuilder.bFloatArray;
    aDoubleArray = pBuilder.aDoubleArray;
    bDoubleArray = pBuilder.bDoubleArray;
    aBigDecimalArray = pBuilder.aBigDecimalArray;
    aStringArray = pBuilder.aStringArray;
    bStringArray = pBuilder.bStringArray;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PrimitiveArraysObjectWithRestrictions objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class PrimitiveArraysObjectWithRestrictions.
   *
   *
   * @param pALongArray Value to which {@link #aLongArray} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.PrimitiveArraysObjectWithRestrictions}
   */
  public static PrimitiveArraysObjectWithRestrictions of( long[] pALongArray ) {
    PrimitiveArraysObjectWithRestrictions.Builder lBuilder = PrimitiveArraysObjectWithRestrictions.builder();
    lBuilder.setALongArray(pALongArray);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveArraysObjectWithRestrictions</code>.
   */
  public static class Builder {
    private boolean[] aBooleanArray;

    private Boolean[] bBooleanArray;

    private boolean[] cBooleanArray;

    @Size(min = 0, max = 32768)
    private byte[] aByteArray;

    private Byte[] bByteArray;

    private short[] aShortArray;

    private Short[] bShortArray;

    private int[] aIntegerArray;

    private Integer[] bIntegerArray;

    private Integer[] cIntegerArray;

    @NotEmpty
    private long[] aLongArray;

    private Long[] bLongArray;

    private BigInteger[] aBigIntegerArray;

    private char[] aCharacterArray;

    private Character[] bCharacterArray;

    private float[] aFloatArray;

    private Float[] bFloatArray;

    @Size(min = 4, max = 12)
    private double[] aDoubleArray;

    private Double[] bDoubleArray;

    private BigDecimal[] aBigDecimalArray;

    private String[] aStringArray;

    private String[] bStringArray;

    /**
     * Use {@link PrimitiveArraysObjectWithRestrictions#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveArraysObjectWithRestrictions#builder(PrimitiveArraysObjectWithRestrictions)} instead of
     * private constructor to create new builder.
     */
    protected Builder( PrimitiveArraysObjectWithRestrictions pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setABooleanArray(pObject.aBooleanArray);
        this.setBBooleanArray(pObject.bBooleanArray);
        this.setCBooleanArray(pObject.cBooleanArray);
        this.setAByteArray(pObject.aByteArray);
        this.setBByteArray(pObject.bByteArray);
        this.setAShortArray(pObject.aShortArray);
        this.setBShortArray(pObject.bShortArray);
        this.setAIntegerArray(pObject.aIntegerArray);
        this.setBIntegerArray(pObject.bIntegerArray);
        this.setCIntegerArray(pObject.cIntegerArray);
        this.setALongArray(pObject.aLongArray);
        this.setBLongArray(pObject.bLongArray);
        this.setABigIntegerArray(pObject.aBigIntegerArray);
        this.setACharacterArray(pObject.aCharacterArray);
        this.setBCharacterArray(pObject.bCharacterArray);
        this.setAFloatArray(pObject.aFloatArray);
        this.setBFloatArray(pObject.bFloatArray);
        this.setADoubleArray(pObject.aDoubleArray);
        this.setBDoubleArray(pObject.bDoubleArray);
        this.setABigDecimalArray(pObject.aBigDecimalArray);
        this.setAStringArray(pObject.aStringArray);
        this.setBStringArray(pObject.bStringArray);
      }
    }

    /**
     * Method sets attribute {@link #aBooleanArray}.<br/>
     *
     * @param pABooleanArray Value to which {@link #aBooleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABooleanArray( boolean[] pABooleanArray ) {
      // Assign value to attribute
      if (pABooleanArray != null) {
        aBooleanArray = pABooleanArray;
      }
      else {
        aBooleanArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bBooleanArray}.<br/>
     *
     * @param pBBooleanArray Collection to which {@link #bBooleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBBooleanArray( Boolean[] pBBooleanArray ) {
      // Assign value to attribute
      if (pBBooleanArray != null) {
        bBooleanArray = pBBooleanArray;
      }
      else {
        bBooleanArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #cBooleanArray}.<br/>
     *
     * @param pCBooleanArray Value to which {@link #cBooleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCBooleanArray( boolean[] pCBooleanArray ) {
      // Assign value to attribute
      if (pCBooleanArray != null) {
        cBooleanArray = pCBooleanArray;
      }
      else {
        cBooleanArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aByteArray}.<br/>
     *
     * @param pAByteArray Value to which {@link #aByteArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAByteArray( byte[] pAByteArray ) {
      // Assign value to attribute
      if (pAByteArray != null) {
        aByteArray = pAByteArray;
      }
      else {
        aByteArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bByteArray}.<br/>
     *
     * @param pBByteArray Collection to which {@link #bByteArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBByteArray( Byte[] pBByteArray ) {
      // Assign value to attribute
      if (pBByteArray != null) {
        bByteArray = pBByteArray;
      }
      else {
        bByteArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aShortArray}.<br/>
     *
     * @param pAShortArray Value to which {@link #aShortArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAShortArray( short[] pAShortArray ) {
      // Assign value to attribute
      if (pAShortArray != null) {
        aShortArray = pAShortArray;
      }
      else {
        aShortArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bShortArray}.<br/>
     *
     * @param pBShortArray Collection to which {@link #bShortArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBShortArray( Short[] pBShortArray ) {
      // Assign value to attribute
      if (pBShortArray != null) {
        bShortArray = pBShortArray;
      }
      else {
        bShortArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aIntegerArray}.<br/>
     *
     * @param pAIntegerArray Value to which {@link #aIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAIntegerArray( int[] pAIntegerArray ) {
      // Assign value to attribute
      if (pAIntegerArray != null) {
        aIntegerArray = pAIntegerArray;
      }
      else {
        aIntegerArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bIntegerArray}.<br/>
     *
     * @param pBIntegerArray Collection to which {@link #bIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBIntegerArray( Integer[] pBIntegerArray ) {
      // Assign value to attribute
      if (pBIntegerArray != null) {
        bIntegerArray = pBIntegerArray;
      }
      else {
        bIntegerArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #cIntegerArray}.<br/>
     *
     * @param pCIntegerArray Collection to which {@link #cIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCIntegerArray( Integer[] pCIntegerArray ) {
      // Assign value to attribute
      if (pCIntegerArray != null) {
        cIntegerArray = pCIntegerArray;
      }
      else {
        cIntegerArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aLongArray}.<br/>
     *
     * @param pALongArray Value to which {@link #aLongArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setALongArray( long[] pALongArray ) {
      // Assign value to attribute
      if (pALongArray != null) {
        aLongArray = pALongArray;
      }
      else {
        aLongArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bLongArray}.<br/>
     *
     * @param pBLongArray Collection to which {@link #bLongArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBLongArray( Long[] pBLongArray ) {
      // Assign value to attribute
      if (pBLongArray != null) {
        bLongArray = pBLongArray;
      }
      else {
        bLongArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aBigIntegerArray}.<br/>
     *
     * @param pABigIntegerArray Collection to which {@link #aBigIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigIntegerArray( BigInteger[] pABigIntegerArray ) {
      // Assign value to attribute
      if (pABigIntegerArray != null) {
        aBigIntegerArray = pABigIntegerArray;
      }
      else {
        aBigIntegerArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aCharacterArray}.<br/>
     *
     * @param pACharacterArray Value to which {@link #aCharacterArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setACharacterArray( char[] pACharacterArray ) {
      // Assign value to attribute
      if (pACharacterArray != null) {
        aCharacterArray = pACharacterArray;
      }
      else {
        aCharacterArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bCharacterArray}.<br/>
     *
     * @param pBCharacterArray Collection to which {@link #bCharacterArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBCharacterArray( Character[] pBCharacterArray ) {
      // Assign value to attribute
      if (pBCharacterArray != null) {
        bCharacterArray = pBCharacterArray;
      }
      else {
        bCharacterArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aFloatArray}.<br/>
     *
     * @param pAFloatArray Value to which {@link #aFloatArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAFloatArray( float[] pAFloatArray ) {
      // Assign value to attribute
      if (pAFloatArray != null) {
        aFloatArray = pAFloatArray;
      }
      else {
        aFloatArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bFloatArray}.<br/>
     *
     * @param pBFloatArray Collection to which {@link #bFloatArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBFloatArray( Float[] pBFloatArray ) {
      // Assign value to attribute
      if (pBFloatArray != null) {
        bFloatArray = pBFloatArray;
      }
      else {
        bFloatArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aDoubleArray}.<br/>
     *
     * @param pADoubleArray Value to which {@link #aDoubleArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setADoubleArray( double[] pADoubleArray ) {
      // Assign value to attribute
      if (pADoubleArray != null) {
        aDoubleArray = pADoubleArray;
      }
      else {
        aDoubleArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bDoubleArray}.<br/>
     *
     * @param pBDoubleArray Collection to which {@link #bDoubleArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBDoubleArray( Double[] pBDoubleArray ) {
      // Assign value to attribute
      if (pBDoubleArray != null) {
        bDoubleArray = pBDoubleArray;
      }
      else {
        bDoubleArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aBigDecimalArray}.<br/>
     *
     * @param pABigDecimalArray Collection to which {@link #aBigDecimalArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigDecimalArray( BigDecimal[] pABigDecimalArray ) {
      // Assign value to attribute
      if (pABigDecimalArray != null) {
        aBigDecimalArray = pABigDecimalArray;
      }
      else {
        aBigDecimalArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aStringArray}.<br/>
     *
     * @param pAStringArray Collection to which {@link #aStringArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAStringArray( String[] pAStringArray ) {
      // Assign value to attribute
      if (pAStringArray != null) {
        aStringArray = pAStringArray;
      }
      else {
        aStringArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bStringArray}.<br/>
     *
     * @param pBStringArray Collection to which {@link #bStringArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBStringArray( String[] pBStringArray ) {
      // Assign value to attribute
      if (pBStringArray != null) {
        bStringArray = pBStringArray;
      }
      else {
        bStringArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PrimitiveArraysObjectWithRestrictions. The object will be initialized with
     * the values of the builder.
     *
     * @return PrimitiveArraysObjectWithRestrictions Created object. The method never returns null.
     */
    public PrimitiveArraysObjectWithRestrictions build( ) {
      return new PrimitiveArraysObjectWithRestrictions(this);
    }

    /**
     * Method creates a new validated instance of class PrimitiveArraysObjectWithRestrictions. The object will be
     * initialized with the values of the builder and validated afterwards.
     *
     * @return PrimitiveArraysObjectWithRestrictions Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrimitiveArraysObjectWithRestrictions buildValidated( ) throws ConstraintViolationException {
      PrimitiveArraysObjectWithRestrictions lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBooleanArray}.<br/>
   *
   * @return boolean[] Value to which {@link #aBooleanArray} is set.
   */
  public boolean[] getABooleanArray( ) {
    boolean[] lReturnValue;
    if (aBooleanArray != null) {
      lReturnValue = aBooleanArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aBooleanArray}.<br/>
   *
   * @param pABooleanArray Value to which {@link #aBooleanArray} should be set.
   */
  public void setABooleanArray( boolean[] pABooleanArray ) {
    // Assign value to attribute
    if (pABooleanArray != null) {
      aBooleanArray = pABooleanArray;
    }
    else {
      aBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bBooleanArray}.<br/>
   *
   * @return {@link Boolean[]} Value to which {@link #bBooleanArray} is set.
   */
  public Boolean[] getBBooleanArray( ) {
    Boolean[] lReturnValue;
    if (bBooleanArray != null) {
      lReturnValue = bBooleanArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bBooleanArray}.<br/>
   *
   * @param pBBooleanArray Value to which {@link #bBooleanArray} should be set.
   */
  public void setBBooleanArray( Boolean[] pBBooleanArray ) {
    // Assign value to attribute
    if (pBBooleanArray != null) {
      bBooleanArray = pBBooleanArray;
    }
    else {
      bBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #cBooleanArray}.<br/>
   *
   * @return boolean[] Value to which {@link #cBooleanArray} is set.
   */
  public boolean[] getCBooleanArray( ) {
    boolean[] lReturnValue;
    if (cBooleanArray != null) {
      lReturnValue = cBooleanArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #cBooleanArray}.<br/>
   *
   * @param pCBooleanArray Value to which {@link #cBooleanArray} should be set.
   */
  public void setCBooleanArray( boolean[] pCBooleanArray ) {
    // Assign value to attribute
    if (pCBooleanArray != null) {
      cBooleanArray = pCBooleanArray;
    }
    else {
      cBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aByteArray}.<br/>
   *
   * @return byte[] Value to which {@link #aByteArray} is set.
   */
  public byte[] getAByteArray( ) {
    byte[] lReturnValue;
    if (aByteArray != null) {
      lReturnValue = aByteArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aByteArray}.<br/>
   *
   * @param pAByteArray Value to which {@link #aByteArray} should be set.
   */
  public void setAByteArray( byte[] pAByteArray ) {
    // Assign value to attribute
    if (pAByteArray != null) {
      aByteArray = pAByteArray;
    }
    else {
      aByteArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bByteArray}.<br/>
   *
   * @return {@link Byte[]} Value to which {@link #bByteArray} is set.
   */
  public Byte[] getBByteArray( ) {
    Byte[] lReturnValue;
    if (bByteArray != null) {
      lReturnValue = bByteArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bByteArray}.<br/>
   *
   * @param pBByteArray Value to which {@link #bByteArray} should be set.
   */
  public void setBByteArray( Byte[] pBByteArray ) {
    // Assign value to attribute
    if (pBByteArray != null) {
      bByteArray = pBByteArray;
    }
    else {
      bByteArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aShortArray}.<br/>
   *
   * @return short[] Value to which {@link #aShortArray} is set.
   */
  public short[] getAShortArray( ) {
    short[] lReturnValue;
    if (aShortArray != null) {
      lReturnValue = aShortArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aShortArray}.<br/>
   *
   * @param pAShortArray Value to which {@link #aShortArray} should be set.
   */
  public void setAShortArray( short[] pAShortArray ) {
    // Assign value to attribute
    if (pAShortArray != null) {
      aShortArray = pAShortArray;
    }
    else {
      aShortArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bShortArray}.<br/>
   *
   * @return {@link Short[]} Value to which {@link #bShortArray} is set.
   */
  public Short[] getBShortArray( ) {
    Short[] lReturnValue;
    if (bShortArray != null) {
      lReturnValue = bShortArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bShortArray}.<br/>
   *
   * @param pBShortArray Value to which {@link #bShortArray} should be set.
   */
  public void setBShortArray( Short[] pBShortArray ) {
    // Assign value to attribute
    if (pBShortArray != null) {
      bShortArray = pBShortArray;
    }
    else {
      bShortArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aIntegerArray}.<br/>
   *
   * @return int[] Value to which {@link #aIntegerArray} is set.
   */
  public int[] getAIntegerArray( ) {
    int[] lReturnValue;
    if (aIntegerArray != null) {
      lReturnValue = aIntegerArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aIntegerArray}.<br/>
   *
   * @param pAIntegerArray Value to which {@link #aIntegerArray} should be set.
   */
  public void setAIntegerArray( int[] pAIntegerArray ) {
    // Assign value to attribute
    if (pAIntegerArray != null) {
      aIntegerArray = pAIntegerArray;
    }
    else {
      aIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bIntegerArray}.<br/>
   *
   * @return {@link Integer[]} Value to which {@link #bIntegerArray} is set.
   */
  public Integer[] getBIntegerArray( ) {
    Integer[] lReturnValue;
    if (bIntegerArray != null) {
      lReturnValue = bIntegerArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bIntegerArray}.<br/>
   *
   * @param pBIntegerArray Value to which {@link #bIntegerArray} should be set.
   */
  public void setBIntegerArray( Integer[] pBIntegerArray ) {
    // Assign value to attribute
    if (pBIntegerArray != null) {
      bIntegerArray = pBIntegerArray;
    }
    else {
      bIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #cIntegerArray}.<br/>
   *
   * @return {@link Integer[]} Value to which {@link #cIntegerArray} is set.
   */
  public Integer[] getCIntegerArray( ) {
    Integer[] lReturnValue;
    if (cIntegerArray != null) {
      lReturnValue = cIntegerArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #cIntegerArray}.<br/>
   *
   * @param pCIntegerArray Value to which {@link #cIntegerArray} should be set.
   */
  public void setCIntegerArray( Integer[] pCIntegerArray ) {
    // Assign value to attribute
    if (pCIntegerArray != null) {
      cIntegerArray = pCIntegerArray;
    }
    else {
      cIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aLongArray}.<br/>
   *
   * @return long[] Value to which {@link #aLongArray} is set.
   */
  public long[] getALongArray( ) {
    long[] lReturnValue;
    if (aLongArray != null) {
      lReturnValue = aLongArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aLongArray}.<br/>
   *
   * @param pALongArray Value to which {@link #aLongArray} should be set.
   */
  public void setALongArray( long[] pALongArray ) {
    // Assign value to attribute
    if (pALongArray != null) {
      aLongArray = pALongArray;
    }
    else {
      aLongArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bLongArray}.<br/>
   *
   * @return {@link Long[]} Value to which {@link #bLongArray} is set.
   */
  public Long[] getBLongArray( ) {
    Long[] lReturnValue;
    if (bLongArray != null) {
      lReturnValue = bLongArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bLongArray}.<br/>
   *
   * @param pBLongArray Value to which {@link #bLongArray} should be set.
   */
  public void setBLongArray( Long[] pBLongArray ) {
    // Assign value to attribute
    if (pBLongArray != null) {
      bLongArray = pBLongArray;
    }
    else {
      bLongArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aBigIntegerArray}.<br/>
   *
   * @return {@link BigInteger[]} Value to which {@link #aBigIntegerArray} is set.
   */
  public BigInteger[] getABigIntegerArray( ) {
    BigInteger[] lReturnValue;
    if (aBigIntegerArray != null) {
      lReturnValue = aBigIntegerArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aBigIntegerArray}.<br/>
   *
   * @param pABigIntegerArray Value to which {@link #aBigIntegerArray} should be set.
   */
  public void setABigIntegerArray( BigInteger[] pABigIntegerArray ) {
    // Assign value to attribute
    if (pABigIntegerArray != null) {
      aBigIntegerArray = pABigIntegerArray;
    }
    else {
      aBigIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aCharacterArray}.<br/>
   *
   * @return char[] Value to which {@link #aCharacterArray} is set.
   */
  public char[] getACharacterArray( ) {
    char[] lReturnValue;
    if (aCharacterArray != null) {
      lReturnValue = aCharacterArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aCharacterArray}.<br/>
   *
   * @param pACharacterArray Value to which {@link #aCharacterArray} should be set.
   */
  public void setACharacterArray( char[] pACharacterArray ) {
    // Assign value to attribute
    if (pACharacterArray != null) {
      aCharacterArray = pACharacterArray;
    }
    else {
      aCharacterArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bCharacterArray}.<br/>
   *
   * @return {@link Character[]} Value to which {@link #bCharacterArray} is set.
   */
  public Character[] getBCharacterArray( ) {
    Character[] lReturnValue;
    if (bCharacterArray != null) {
      lReturnValue = bCharacterArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bCharacterArray}.<br/>
   *
   * @param pBCharacterArray Value to which {@link #bCharacterArray} should be set.
   */
  public void setBCharacterArray( Character[] pBCharacterArray ) {
    // Assign value to attribute
    if (pBCharacterArray != null) {
      bCharacterArray = pBCharacterArray;
    }
    else {
      bCharacterArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aFloatArray}.<br/>
   *
   * @return float[] Value to which {@link #aFloatArray} is set.
   */
  public float[] getAFloatArray( ) {
    float[] lReturnValue;
    if (aFloatArray != null) {
      lReturnValue = aFloatArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aFloatArray}.<br/>
   *
   * @param pAFloatArray Value to which {@link #aFloatArray} should be set.
   */
  public void setAFloatArray( float[] pAFloatArray ) {
    // Assign value to attribute
    if (pAFloatArray != null) {
      aFloatArray = pAFloatArray;
    }
    else {
      aFloatArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bFloatArray}.<br/>
   *
   * @return {@link Float[]} Value to which {@link #bFloatArray} is set.
   */
  public Float[] getBFloatArray( ) {
    Float[] lReturnValue;
    if (bFloatArray != null) {
      lReturnValue = bFloatArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bFloatArray}.<br/>
   *
   * @param pBFloatArray Value to which {@link #bFloatArray} should be set.
   */
  public void setBFloatArray( Float[] pBFloatArray ) {
    // Assign value to attribute
    if (pBFloatArray != null) {
      bFloatArray = pBFloatArray;
    }
    else {
      bFloatArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aDoubleArray}.<br/>
   *
   * @return double[] Value to which {@link #aDoubleArray} is set.
   */
  public double[] getADoubleArray( ) {
    double[] lReturnValue;
    if (aDoubleArray != null) {
      lReturnValue = aDoubleArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aDoubleArray}.<br/>
   *
   * @param pADoubleArray Value to which {@link #aDoubleArray} should be set.
   */
  public void setADoubleArray( double[] pADoubleArray ) {
    // Assign value to attribute
    if (pADoubleArray != null) {
      aDoubleArray = pADoubleArray;
    }
    else {
      aDoubleArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bDoubleArray}.<br/>
   *
   * @return {@link Double[]} Value to which {@link #bDoubleArray} is set.
   */
  public Double[] getBDoubleArray( ) {
    Double[] lReturnValue;
    if (bDoubleArray != null) {
      lReturnValue = bDoubleArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bDoubleArray}.<br/>
   *
   * @param pBDoubleArray Value to which {@link #bDoubleArray} should be set.
   */
  public void setBDoubleArray( Double[] pBDoubleArray ) {
    // Assign value to attribute
    if (pBDoubleArray != null) {
      bDoubleArray = pBDoubleArray;
    }
    else {
      bDoubleArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aBigDecimalArray}.<br/>
   *
   * @return {@link BigDecimal[]} Value to which {@link #aBigDecimalArray} is set.
   */
  public BigDecimal[] getABigDecimalArray( ) {
    BigDecimal[] lReturnValue;
    if (aBigDecimalArray != null) {
      lReturnValue = aBigDecimalArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aBigDecimalArray}.<br/>
   *
   * @param pABigDecimalArray Value to which {@link #aBigDecimalArray} should be set.
   */
  public void setABigDecimalArray( BigDecimal[] pABigDecimalArray ) {
    // Assign value to attribute
    if (pABigDecimalArray != null) {
      aBigDecimalArray = pABigDecimalArray;
    }
    else {
      aBigDecimalArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aStringArray}.<br/>
   *
   * @return {@link String[]} Value to which {@link #aStringArray} is set.
   */
  public String[] getAStringArray( ) {
    String[] lReturnValue;
    if (aStringArray != null) {
      lReturnValue = aStringArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #aStringArray}.<br/>
   *
   * @param pAStringArray Value to which {@link #aStringArray} should be set.
   */
  public void setAStringArray( String[] pAStringArray ) {
    // Assign value to attribute
    if (pAStringArray != null) {
      aStringArray = pAStringArray;
    }
    else {
      aStringArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bStringArray}.<br/>
   *
   * @return {@link String[]} Value to which {@link #bStringArray} is set.
   */
  public String[] getBStringArray( ) {
    String[] lReturnValue;
    if (bStringArray != null) {
      lReturnValue = bStringArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bStringArray}.<br/>
   *
   * @param pBStringArray Value to which {@link #bStringArray} should be set.
   */
  public void setBStringArray( String[] pBStringArray ) {
    // Assign value to attribute
    if (pBStringArray != null) {
      bStringArray = pBStringArray;
    }
    else {
      bStringArray = null;
    }
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Arrays.hashCode(aBooleanArray);
    lResult = lPrime * lResult + Arrays.hashCode(bBooleanArray);
    lResult = lPrime * lResult + Arrays.hashCode(cBooleanArray);
    lResult = lPrime * lResult + Arrays.hashCode(aByteArray);
    lResult = lPrime * lResult + Arrays.hashCode(bByteArray);
    lResult = lPrime * lResult + Arrays.hashCode(aShortArray);
    lResult = lPrime * lResult + Arrays.hashCode(bShortArray);
    lResult = lPrime * lResult + Arrays.hashCode(aIntegerArray);
    lResult = lPrime * lResult + Arrays.hashCode(bIntegerArray);
    lResult = lPrime * lResult + Arrays.hashCode(cIntegerArray);
    lResult = lPrime * lResult + Arrays.hashCode(aLongArray);
    lResult = lPrime * lResult + Arrays.hashCode(bLongArray);
    lResult = lPrime * lResult + Arrays.hashCode(aBigIntegerArray);
    lResult = lPrime * lResult + Arrays.hashCode(aCharacterArray);
    lResult = lPrime * lResult + Arrays.hashCode(bCharacterArray);
    lResult = lPrime * lResult + Arrays.hashCode(aFloatArray);
    lResult = lPrime * lResult + Arrays.hashCode(bFloatArray);
    lResult = lPrime * lResult + Arrays.hashCode(aDoubleArray);
    lResult = lPrime * lResult + Arrays.hashCode(bDoubleArray);
    lResult = lPrime * lResult + Arrays.hashCode(aBigDecimalArray);
    lResult = lPrime * lResult + Arrays.hashCode(aStringArray);
    lResult = lPrime * lResult + Arrays.hashCode(bStringArray);
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
      PrimitiveArraysObjectWithRestrictions lOther = (PrimitiveArraysObjectWithRestrictions) pObject;
      lEquals = Arrays.equals(aBooleanArray, lOther.aBooleanArray) && Arrays.equals(bBooleanArray, lOther.bBooleanArray)
          && Arrays.equals(cBooleanArray, lOther.cBooleanArray) && Arrays.equals(aByteArray, lOther.aByteArray)
          && Arrays.equals(bByteArray, lOther.bByteArray) && Arrays.equals(aShortArray, lOther.aShortArray)
          && Arrays.equals(bShortArray, lOther.bShortArray) && Arrays.equals(aIntegerArray, lOther.aIntegerArray)
          && Arrays.equals(bIntegerArray, lOther.bIntegerArray) && Arrays.equals(cIntegerArray, lOther.cIntegerArray)
          && Arrays.equals(aLongArray, lOther.aLongArray) && Arrays.equals(bLongArray, lOther.bLongArray)
          && Arrays.equals(aBigIntegerArray, lOther.aBigIntegerArray)
          && Arrays.equals(aCharacterArray, lOther.aCharacterArray)
          && Arrays.equals(bCharacterArray, lOther.bCharacterArray) && Arrays.equals(aFloatArray, lOther.aFloatArray)
          && Arrays.equals(bFloatArray, lOther.bFloatArray) && Arrays.equals(aDoubleArray, lOther.aDoubleArray)
          && Arrays.equals(bDoubleArray, lOther.bDoubleArray)
          && Arrays.equals(aBigDecimalArray, lOther.aBigDecimalArray)
          && Arrays.equals(aStringArray, lOther.aStringArray) && Arrays.equals(bStringArray, lOther.bStringArray);
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
    lBuilder.append("aBooleanArray: ");
    if (aBooleanArray != null) {
      lBuilder.append(Arrays.toString(aBooleanArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bBooleanArray: ");
    if (bBooleanArray != null) {
      lBuilder.append(Arrays.toString(bBooleanArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("cBooleanArray: ");
    if (cBooleanArray != null) {
      lBuilder.append(Arrays.toString(cBooleanArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aByteArray: ");
    if (aByteArray != null) {
      lBuilder.append(Arrays.toString(aByteArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bByteArray: ");
    if (bByteArray != null) {
      lBuilder.append(Arrays.toString(bByteArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aShortArray: ");
    if (aShortArray != null) {
      lBuilder.append(Arrays.toString(aShortArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bShortArray: ");
    if (bShortArray != null) {
      lBuilder.append(Arrays.toString(bShortArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aIntegerArray: ");
    if (aIntegerArray != null) {
      lBuilder.append(Arrays.toString(aIntegerArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bIntegerArray: ");
    if (bIntegerArray != null) {
      lBuilder.append(Arrays.toString(bIntegerArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("cIntegerArray: ");
    if (cIntegerArray != null) {
      lBuilder.append(Arrays.toString(cIntegerArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aLongArray: ");
    if (aLongArray != null) {
      lBuilder.append(Arrays.toString(aLongArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bLongArray: ");
    if (bLongArray != null) {
      lBuilder.append(Arrays.toString(bLongArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aBigIntegerArray: ");
    if (aBigIntegerArray != null) {
      lBuilder.append(Arrays.toString(aBigIntegerArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aCharacterArray: ");
    if (aCharacterArray != null) {
      lBuilder.append(Arrays.toString(aCharacterArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bCharacterArray: ");
    if (bCharacterArray != null) {
      lBuilder.append(Arrays.toString(bCharacterArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aFloatArray: ");
    if (aFloatArray != null) {
      lBuilder.append(Arrays.toString(aFloatArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bFloatArray: ");
    if (bFloatArray != null) {
      lBuilder.append(Arrays.toString(bFloatArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aDoubleArray: ");
    if (aDoubleArray != null) {
      lBuilder.append(Arrays.toString(aDoubleArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bDoubleArray: ");
    if (bDoubleArray != null) {
      lBuilder.append(Arrays.toString(bDoubleArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aBigDecimalArray: ");
    if (aBigDecimalArray != null) {
      lBuilder.append(Arrays.toString(aBigDecimalArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aStringArray: ");
    if (aStringArray != null) {
      lBuilder.append(Arrays.toString(aStringArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bStringArray: ");
    if (bStringArray != null) {
      lBuilder.append(Arrays.toString(bStringArray));
    }
    else {
      lBuilder.append(" null");
    }
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
   * @return {@link Builder} New builder that can be used to create new PrimitiveArraysObjectWithRestrictions objects.
   * The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}