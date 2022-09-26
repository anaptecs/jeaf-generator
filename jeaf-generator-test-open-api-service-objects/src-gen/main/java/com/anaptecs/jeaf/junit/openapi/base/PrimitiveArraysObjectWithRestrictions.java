/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class PrimitiveArraysObjectWithRestrictions implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  private boolean[] aBooleanArray;

  /**
   * 
   */
  private Boolean[] bBooleanArray;

  /**
   * 
   */
  private boolean[] cBooleanArray;

  /**
   * 
   */
  @Size(min = 0, max = 32768)
  private byte[] aByteArray;

  /**
   * 
   */
  private Byte[] bByteArray;

  /**
   * 
   */
  private short[] aShortArray;

  /**
   * 
   */
  private Short[] bShortArray;

  /**
   * 
   */
  private int[] aIntegerArray;

  /**
   * 
   */
  private Integer[] bIntegerArray;

  /**
   * 
   */
  private Integer[] cIntegerArray;

  /**
   * 
   */
  @NotEmpty
  private long[] aLongArray;

  /**
   * 
   */
  private Long[] bLongArray;

  /**
   * 
   */
  private BigInteger[] aBigIntegerArray;

  /**
   * 
   */
  private char[] aCharacterArray;

  /**
   * 
   */
  private Character[] bCharacterArray;

  /**
   * 
   */
  private float[] aFloatArray;

  /**
   * 
   */
  private Float[] bFloatArray;

  /**
   * 
   */
  @Size(min = 4, max = 12)
  private double[] aDoubleArray;

  /**
   * 
   */
  private Double[] bDoubleArray;

  /**
   * 
   */
  private BigDecimal[] aBigDecimalArray;

  /**
   * 
   */
  private String[] aStringArray;

  /**
   * 
   */
  private String[] bStringArray;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveArraysObjectWithRestrictions objects.
   * The method never returns null.
   */
  public static Builder builder( PrimitiveArraysObjectWithRestrictions pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PrimitiveArraysObjectWithRestrictions. As the class has
   * read only attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean[] aBooleanArray;

    /**
     * 
     */
    private Boolean[] bBooleanArray;

    /**
     * 
     */
    private boolean[] cBooleanArray;

    /**
     * 
     */
    @Size(min = 0, max = 32768)
    private byte[] aByteArray;

    /**
     * 
     */
    private Byte[] bByteArray;

    /**
     * 
     */
    private short[] aShortArray;

    /**
     * 
     */
    private Short[] bShortArray;

    /**
     * 
     */
    private int[] aIntegerArray;

    /**
     * 
     */
    private Integer[] bIntegerArray;

    /**
     * 
     */
    private Integer[] cIntegerArray;

    /**
     * 
     */
    @NotEmpty
    private long[] aLongArray;

    /**
     * 
     */
    private Long[] bLongArray;

    /**
     * 
     */
    private BigInteger[] aBigIntegerArray;

    /**
     * 
     */
    private char[] aCharacterArray;

    /**
     * 
     */
    private Character[] bCharacterArray;

    /**
     * 
     */
    private float[] aFloatArray;

    /**
     * 
     */
    private Float[] bFloatArray;

    /**
     * 
     */
    @Size(min = 4, max = 12)
    private double[] aDoubleArray;

    /**
     * 
     */
    private Double[] bDoubleArray;

    /**
     * 
     */
    private BigDecimal[] aBigDecimalArray;

    /**
     * 
     */
    private String[] aStringArray;

    /**
     * 
     */
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
        aBooleanArray = pObject.aBooleanArray;
        bBooleanArray = pObject.bBooleanArray;
        cBooleanArray = pObject.cBooleanArray;
        aByteArray = pObject.aByteArray;
        bByteArray = pObject.bByteArray;
        aShortArray = pObject.aShortArray;
        bShortArray = pObject.bShortArray;
        aIntegerArray = pObject.aIntegerArray;
        bIntegerArray = pObject.bIntegerArray;
        cIntegerArray = pObject.cIntegerArray;
        aLongArray = pObject.aLongArray;
        bLongArray = pObject.bLongArray;
        aBigIntegerArray = pObject.aBigIntegerArray;
        aCharacterArray = pObject.aCharacterArray;
        bCharacterArray = pObject.bCharacterArray;
        aFloatArray = pObject.aFloatArray;
        bFloatArray = pObject.bFloatArray;
        aDoubleArray = pObject.aDoubleArray;
        bDoubleArray = pObject.bDoubleArray;
        aBigDecimalArray = pObject.aBigDecimalArray;
        aStringArray = pObject.aStringArray;
        bStringArray = pObject.bStringArray;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new PrimitiveArraysObjectWithRestrictions objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PrimitiveArraysObjectWithRestrictions objects.
     * The method never returns null.
     */
    public static Builder newBuilder( PrimitiveArraysObjectWithRestrictions pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "aBooleanArray".
     * 
     * @param pABooleanArray Value to which the attribute "aBooleanArray" should be set.
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
     * Method sets the attribute "bBooleanArray".
     * 
     * @param pBBooleanArray Value to which the attribute "bBooleanArray" should be set.
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
     * Method sets the attribute "cBooleanArray".
     * 
     * @param pCBooleanArray Value to which the attribute "cBooleanArray" should be set.
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
     * Method sets the attribute "aByteArray".
     * 
     * @param pAByteArray Value to which the attribute "aByteArray" should be set.
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
     * Method sets the attribute "bByteArray".
     * 
     * @param pBByteArray Value to which the attribute "bByteArray" should be set.
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
     * Method sets the attribute "aShortArray".
     * 
     * @param pAShortArray Value to which the attribute "aShortArray" should be set.
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
     * Method sets the attribute "bShortArray".
     * 
     * @param pBShortArray Value to which the attribute "bShortArray" should be set.
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
     * Method sets the attribute "aIntegerArray".
     * 
     * @param pAIntegerArray Value to which the attribute "aIntegerArray" should be set.
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
     * Method sets the attribute "bIntegerArray".
     * 
     * @param pBIntegerArray Value to which the attribute "bIntegerArray" should be set.
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
     * Method sets the attribute "cIntegerArray".
     * 
     * @param pCIntegerArray Value to which the attribute "cIntegerArray" should be set.
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
     * Method sets the attribute "aLongArray".
     * 
     * @param pALongArray Value to which the attribute "aLongArray" should be set.
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
     * Method sets the attribute "bLongArray".
     * 
     * @param pBLongArray Value to which the attribute "bLongArray" should be set.
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
     * Method sets the attribute "aBigIntegerArray".
     * 
     * @param pABigIntegerArray Value to which the attribute "aBigIntegerArray" should be set.
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
     * Method sets the attribute "aCharacterArray".
     * 
     * @param pACharacterArray Value to which the attribute "aCharacterArray" should be set.
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
     * Method sets the attribute "bCharacterArray".
     * 
     * @param pBCharacterArray Value to which the attribute "bCharacterArray" should be set.
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
     * Method sets the attribute "aFloatArray".
     * 
     * @param pAFloatArray Value to which the attribute "aFloatArray" should be set.
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
     * Method sets the attribute "bFloatArray".
     * 
     * @param pBFloatArray Value to which the attribute "bFloatArray" should be set.
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
     * Method sets the attribute "aDoubleArray".
     * 
     * @param pADoubleArray Value to which the attribute "aDoubleArray" should be set.
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
     * Method sets the attribute "bDoubleArray".
     * 
     * @param pBDoubleArray Value to which the attribute "bDoubleArray" should be set.
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
     * Method sets the attribute "aBigDecimalArray".
     * 
     * @param pABigDecimalArray Value to which the attribute "aBigDecimalArray" should be set.
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
     * Method sets the attribute "aStringArray".
     * 
     * @param pAStringArray Value to which the attribute "aStringArray" should be set.
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
     * Method sets the attribute "bStringArray".
     * 
     * @param pBStringArray Value to which the attribute "bStringArray" should be set.
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
      PrimitiveArraysObjectWithRestrictions lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "aBooleanArray".
   * 
   * 
   * @return Boolean Value to which the attribute "aBooleanArray" is set.
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
   * Method sets the attribute "aBooleanArray".
   * 
   * 
   * @param pABooleanArray Value to which the attribute "aBooleanArray" should be set.
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
   * Method returns the attribute "bBooleanArray".
   * 
   * 
   * @return Boolean Value to which the attribute "bBooleanArray" is set.
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
   * Method sets the attribute "bBooleanArray".
   * 
   * 
   * @param pBBooleanArray Value to which the attribute "bBooleanArray" should be set.
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
   * Method returns the attribute "cBooleanArray".
   * 
   * 
   * @return Boolean Value to which the attribute "cBooleanArray" is set.
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
   * Method sets the attribute "cBooleanArray".
   * 
   * 
   * @param pCBooleanArray Value to which the attribute "cBooleanArray" should be set.
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
   * Method returns the attribute "aByteArray".
   * 
   * 
   * @return byte Value to which the attribute "aByteArray" is set.
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
   * Method sets the attribute "aByteArray".
   * 
   * 
   * @param pAByteArray Value to which the attribute "aByteArray" should be set.
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
   * Method returns the attribute "bByteArray".
   * 
   * 
   * @return Byte Value to which the attribute "bByteArray" is set.
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
   * Method sets the attribute "bByteArray".
   * 
   * 
   * @param pBByteArray Value to which the attribute "bByteArray" should be set.
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
   * Method returns the attribute "aShortArray".
   * 
   * 
   * @return short Value to which the attribute "aShortArray" is set.
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
   * Method sets the attribute "aShortArray".
   * 
   * 
   * @param pAShortArray Value to which the attribute "aShortArray" should be set.
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
   * Method returns the attribute "bShortArray".
   * 
   * 
   * @return Short Value to which the attribute "bShortArray" is set.
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
   * Method sets the attribute "bShortArray".
   * 
   * 
   * @param pBShortArray Value to which the attribute "bShortArray" should be set.
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
   * Method returns the attribute "aIntegerArray".
   * 
   * 
   * @return int Value to which the attribute "aIntegerArray" is set.
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
   * Method sets the attribute "aIntegerArray".
   * 
   * 
   * @param pAIntegerArray Value to which the attribute "aIntegerArray" should be set.
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
   * Method returns the attribute "bIntegerArray".
   * 
   * 
   * @return Integer Value to which the attribute "bIntegerArray" is set.
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
   * Method sets the attribute "bIntegerArray".
   * 
   * 
   * @param pBIntegerArray Value to which the attribute "bIntegerArray" should be set.
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
   * Method returns the attribute "cIntegerArray".
   * 
   * 
   * @return Integer Value to which the attribute "cIntegerArray" is set.
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
   * Method sets the attribute "cIntegerArray".
   * 
   * 
   * @param pCIntegerArray Value to which the attribute "cIntegerArray" should be set.
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
   * Method returns the attribute "aLongArray".
   * 
   * 
   * @return long Value to which the attribute "aLongArray" is set.
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
   * Method sets the attribute "aLongArray".
   * 
   * 
   * @param pALongArray Value to which the attribute "aLongArray" should be set.
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
   * Method returns the attribute "bLongArray".
   * 
   * 
   * @return Long Value to which the attribute "bLongArray" is set.
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
   * Method sets the attribute "bLongArray".
   * 
   * 
   * @param pBLongArray Value to which the attribute "bLongArray" should be set.
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
   * Method returns the attribute "aBigIntegerArray".
   * 
   * 
   * @return BigInteger Value to which the attribute "aBigIntegerArray" is set.
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
   * Method sets the attribute "aBigIntegerArray".
   * 
   * 
   * @param pABigIntegerArray Value to which the attribute "aBigIntegerArray" should be set.
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
   * Method returns the attribute "aCharacterArray".
   * 
   * 
   * @return char Value to which the attribute "aCharacterArray" is set.
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
   * Method sets the attribute "aCharacterArray".
   * 
   * 
   * @param pACharacterArray Value to which the attribute "aCharacterArray" should be set.
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
   * Method returns the attribute "bCharacterArray".
   * 
   * 
   * @return Character Value to which the attribute "bCharacterArray" is set.
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
   * Method sets the attribute "bCharacterArray".
   * 
   * 
   * @param pBCharacterArray Value to which the attribute "bCharacterArray" should be set.
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
   * Method returns the attribute "aFloatArray".
   * 
   * 
   * @return float Value to which the attribute "aFloatArray" is set.
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
   * Method sets the attribute "aFloatArray".
   * 
   * 
   * @param pAFloatArray Value to which the attribute "aFloatArray" should be set.
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
   * Method returns the attribute "bFloatArray".
   * 
   * 
   * @return Float Value to which the attribute "bFloatArray" is set.
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
   * Method sets the attribute "bFloatArray".
   * 
   * 
   * @param pBFloatArray Value to which the attribute "bFloatArray" should be set.
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
   * Method returns the attribute "aDoubleArray".
   * 
   * 
   * @return double Value to which the attribute "aDoubleArray" is set.
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
   * Method sets the attribute "aDoubleArray".
   * 
   * 
   * @param pADoubleArray Value to which the attribute "aDoubleArray" should be set.
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
   * Method returns the attribute "bDoubleArray".
   * 
   * 
   * @return Double Value to which the attribute "bDoubleArray" is set.
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
   * Method sets the attribute "bDoubleArray".
   * 
   * 
   * @param pBDoubleArray Value to which the attribute "bDoubleArray" should be set.
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
   * Method returns the attribute "aBigDecimalArray".
   * 
   * 
   * @return BigDecimal Value to which the attribute "aBigDecimalArray" is set.
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
   * Method sets the attribute "aBigDecimalArray".
   * 
   * 
   * @param pABigDecimalArray Value to which the attribute "aBigDecimalArray" should be set.
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
   * Method returns the attribute "aStringArray".
   * 
   * 
   * @return String Value to which the attribute "aStringArray" is set.
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
   * Method sets the attribute "aStringArray".
   * 
   * 
   * @param pAStringArray Value to which the attribute "aStringArray" should be set.
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
   * Method returns the attribute "bStringArray".
   * 
   * 
   * @return String Value to which the attribute "bStringArray" is set.
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
   * Method sets the attribute "bStringArray".
   * 
   * 
   * @param pBStringArray Value to which the attribute "bStringArray" should be set.
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

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
