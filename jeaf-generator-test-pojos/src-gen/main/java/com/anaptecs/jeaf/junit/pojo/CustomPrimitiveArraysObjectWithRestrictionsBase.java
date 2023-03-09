/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CustomPrimitiveArraysObjectWithRestrictionsBase {
  /**
   * Constant for the name of attribute "aBooleanArray".
   */
  public static final String ABOOLEANARRAY = "aBooleanArray";

  /**
   * Constant for the name of attribute "bBooleanArray".
   */
  public static final String BBOOLEANARRAY = "bBooleanArray";

  /**
   * Constant for the name of attribute "cBooleanArray".
   */
  public static final String CBOOLEANARRAY = "cBooleanArray";

  /**
   * Constant for the name of attribute "aByteArray".
   */
  public static final String ABYTEARRAY = "aByteArray";

  /**
   * Constant for the name of attribute "bByteArray".
   */
  public static final String BBYTEARRAY = "bByteArray";

  /**
   * Constant for the name of attribute "aShortArray".
   */
  public static final String ASHORTARRAY = "aShortArray";

  /**
   * Constant for the name of attribute "bShortArray".
   */
  public static final String BSHORTARRAY = "bShortArray";

  /**
   * Constant for the name of attribute "aIntegerArray".
   */
  public static final String AINTEGERARRAY = "aIntegerArray";

  /**
   * Constant for the name of attribute "bIntegerArray".
   */
  public static final String BINTEGERARRAY = "bIntegerArray";

  /**
   * Constant for the name of attribute "cIntegerArray".
   */
  public static final String CINTEGERARRAY = "cIntegerArray";

  /**
   * Constant for the name of attribute "aLongArray".
   */
  public static final String ALONGARRAY = "aLongArray";

  /**
   * Constant for the name of attribute "bLongArray".
   */
  public static final String BLONGARRAY = "bLongArray";

  /**
   * Constant for the name of attribute "aBigIntegerArray".
   */
  public static final String ABIGINTEGERARRAY = "aBigIntegerArray";

  /**
   * Constant for the name of attribute "aCharacterArray".
   */
  public static final String ACHARACTERARRAY = "aCharacterArray";

  /**
   * Constant for the name of attribute "bCharacterArray".
   */
  public static final String BCHARACTERARRAY = "bCharacterArray";

  /**
   * Constant for the name of attribute "aFloatArray".
   */
  public static final String AFLOATARRAY = "aFloatArray";

  /**
   * Constant for the name of attribute "bFloatArray".
   */
  public static final String BFLOATARRAY = "bFloatArray";

  /**
   * Constant for the name of attribute "aDoubleArray".
   */
  public static final String ADOUBLEARRAY = "aDoubleArray";

  /**
   * Constant for the name of attribute "bDoubleArray".
   */
  public static final String BDOUBLEARRAY = "bDoubleArray";

  /**
   * Constant for the name of attribute "aBigDecimalArray".
   */
  public static final String ABIGDECIMALARRAY = "aBigDecimalArray";

  /**
   * Constant for the name of attribute "aStringArray".
   */
  public static final String ASTRINGARRAY = "aStringArray";

  /**
   * Constant for the name of attribute "bStringArray".
   */
  public static final String BSTRINGARRAY = "bStringArray";

  private boolean[] aBooleanArray;

  private Boolean[] bBooleanArray;

  private boolean[] cBooleanArray;

  @Size(min = 0, max = 32768)
  private byte[] aByteArray;

  private Byte[] bByteArray;

  private short[] aShortArray;

  private Short[] bShortArray;

  private final int[] aIntegerArray;

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
  protected CustomPrimitiveArraysObjectWithRestrictionsBase( ) {
    aIntegerArray = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CustomPrimitiveArraysObjectWithRestrictionsBase( BuilderBase pBuilder ) {
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
   * Class implements builder to create a new instance of class CustomPrimitiveArraysObjectWithRestrictions. As the
   * class has read only attributes or associations instances can not be created directly. Instead this builder class
   * has to be used.
   */
  public static abstract class BuilderBase {
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
     * Use {@link CustomPrimitiveArraysObjectWithRestrictions.builder()} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link CustomPrimitiveArraysObjectWithRestrictions.builder(CustomPrimitiveArraysObjectWithRestrictions)}
     * instead of protected constructor to create new builder.
     */
    protected BuilderBase( CustomPrimitiveArraysObjectWithRestrictionsBase pObject ) {
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
     * Method sets the attribute "aBooleanArray".
     * 
     * @param pABooleanArray Value to which the attribute "aBooleanArray" should be set.
     */
    public BuilderBase setABooleanArray( boolean[] pABooleanArray ) {
      // Assign value to attribute
      if (pABooleanArray != null) {
        aBooleanArray = new boolean[pABooleanArray.length];
        System.arraycopy(pABooleanArray, 0, aBooleanArray, 0, pABooleanArray.length);
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
    public BuilderBase setBBooleanArray( Boolean[] pBBooleanArray ) {
      // Assign value to attribute
      if (pBBooleanArray != null) {
        bBooleanArray = new Boolean[pBBooleanArray.length];
        System.arraycopy(pBBooleanArray, 0, bBooleanArray, 0, pBBooleanArray.length);
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
    public BuilderBase setCBooleanArray( boolean[] pCBooleanArray ) {
      // Assign value to attribute
      if (pCBooleanArray != null) {
        cBooleanArray = new boolean[pCBooleanArray.length];
        System.arraycopy(pCBooleanArray, 0, cBooleanArray, 0, pCBooleanArray.length);
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
    public BuilderBase setAByteArray( byte[] pAByteArray ) {
      // Assign value to attribute
      if (pAByteArray != null) {
        aByteArray = new byte[pAByteArray.length];
        System.arraycopy(pAByteArray, 0, aByteArray, 0, pAByteArray.length);
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
    public BuilderBase setBByteArray( Byte[] pBByteArray ) {
      // Assign value to attribute
      if (pBByteArray != null) {
        bByteArray = new Byte[pBByteArray.length];
        System.arraycopy(pBByteArray, 0, bByteArray, 0, pBByteArray.length);
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
    public BuilderBase setAShortArray( short[] pAShortArray ) {
      // Assign value to attribute
      if (pAShortArray != null) {
        aShortArray = new short[pAShortArray.length];
        System.arraycopy(pAShortArray, 0, aShortArray, 0, pAShortArray.length);
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
    public BuilderBase setBShortArray( Short[] pBShortArray ) {
      // Assign value to attribute
      if (pBShortArray != null) {
        bShortArray = new Short[pBShortArray.length];
        System.arraycopy(pBShortArray, 0, bShortArray, 0, pBShortArray.length);
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
    public BuilderBase setAIntegerArray( int[] pAIntegerArray ) {
      // Assign value to attribute
      if (pAIntegerArray != null) {
        aIntegerArray = new int[pAIntegerArray.length];
        System.arraycopy(pAIntegerArray, 0, aIntegerArray, 0, pAIntegerArray.length);
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
    public BuilderBase setBIntegerArray( Integer[] pBIntegerArray ) {
      // Assign value to attribute
      if (pBIntegerArray != null) {
        bIntegerArray = new Integer[pBIntegerArray.length];
        System.arraycopy(pBIntegerArray, 0, bIntegerArray, 0, pBIntegerArray.length);
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
    public BuilderBase setCIntegerArray( Integer[] pCIntegerArray ) {
      // Assign value to attribute
      if (pCIntegerArray != null) {
        cIntegerArray = new Integer[pCIntegerArray.length];
        System.arraycopy(pCIntegerArray, 0, cIntegerArray, 0, pCIntegerArray.length);
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
    public BuilderBase setALongArray( long[] pALongArray ) {
      // Assign value to attribute
      if (pALongArray != null) {
        aLongArray = new long[pALongArray.length];
        System.arraycopy(pALongArray, 0, aLongArray, 0, pALongArray.length);
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
    public BuilderBase setBLongArray( Long[] pBLongArray ) {
      // Assign value to attribute
      if (pBLongArray != null) {
        bLongArray = new Long[pBLongArray.length];
        System.arraycopy(pBLongArray, 0, bLongArray, 0, pBLongArray.length);
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
    public BuilderBase setABigIntegerArray( BigInteger[] pABigIntegerArray ) {
      // Assign value to attribute
      if (pABigIntegerArray != null) {
        aBigIntegerArray = new BigInteger[pABigIntegerArray.length];
        System.arraycopy(pABigIntegerArray, 0, aBigIntegerArray, 0, pABigIntegerArray.length);
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
    public BuilderBase setACharacterArray( char[] pACharacterArray ) {
      // Assign value to attribute
      if (pACharacterArray != null) {
        aCharacterArray = new char[pACharacterArray.length];
        System.arraycopy(pACharacterArray, 0, aCharacterArray, 0, pACharacterArray.length);
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
    public BuilderBase setBCharacterArray( Character[] pBCharacterArray ) {
      // Assign value to attribute
      if (pBCharacterArray != null) {
        bCharacterArray = new Character[pBCharacterArray.length];
        System.arraycopy(pBCharacterArray, 0, bCharacterArray, 0, pBCharacterArray.length);
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
    public BuilderBase setAFloatArray( float[] pAFloatArray ) {
      // Assign value to attribute
      if (pAFloatArray != null) {
        aFloatArray = new float[pAFloatArray.length];
        System.arraycopy(pAFloatArray, 0, aFloatArray, 0, pAFloatArray.length);
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
    public BuilderBase setBFloatArray( Float[] pBFloatArray ) {
      // Assign value to attribute
      if (pBFloatArray != null) {
        bFloatArray = new Float[pBFloatArray.length];
        System.arraycopy(pBFloatArray, 0, bFloatArray, 0, pBFloatArray.length);
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
    public BuilderBase setADoubleArray( double[] pADoubleArray ) {
      // Assign value to attribute
      if (pADoubleArray != null) {
        aDoubleArray = new double[pADoubleArray.length];
        System.arraycopy(pADoubleArray, 0, aDoubleArray, 0, pADoubleArray.length);
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
    public BuilderBase setBDoubleArray( Double[] pBDoubleArray ) {
      // Assign value to attribute
      if (pBDoubleArray != null) {
        bDoubleArray = new Double[pBDoubleArray.length];
        System.arraycopy(pBDoubleArray, 0, bDoubleArray, 0, pBDoubleArray.length);
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
    public BuilderBase setABigDecimalArray( BigDecimal[] pABigDecimalArray ) {
      // Assign value to attribute
      if (pABigDecimalArray != null) {
        aBigDecimalArray = new BigDecimal[pABigDecimalArray.length];
        System.arraycopy(pABigDecimalArray, 0, aBigDecimalArray, 0, pABigDecimalArray.length);
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
    public BuilderBase setAStringArray( String[] pAStringArray ) {
      // Assign value to attribute
      if (pAStringArray != null) {
        aStringArray = new String[pAStringArray.length];
        System.arraycopy(pAStringArray, 0, aStringArray, 0, pAStringArray.length);
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
    public BuilderBase setBStringArray( String[] pBStringArray ) {
      // Assign value to attribute
      if (pBStringArray != null) {
        bStringArray = new String[pBStringArray.length];
        System.arraycopy(pBStringArray, 0, bStringArray, 0, pBStringArray.length);
      }
      else {
        bStringArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class CustomPrimitiveArraysObjectWithRestrictions. The object will be
     * initialized with the values of the builder.
     * 
     * @return CustomPrimitiveArraysObjectWithRestrictions Created object. The method never returns null.
     */
    public CustomPrimitiveArraysObjectWithRestrictions build( ) {
      return new CustomPrimitiveArraysObjectWithRestrictions(this);
    }

    /**
     * Method creates a new validated instance of class CustomPrimitiveArraysObjectWithRestrictions. The object will be
     * initialized with the values of the builder and validated afterwards.
     * 
     * @return CustomPrimitiveArraysObjectWithRestrictions Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CustomPrimitiveArraysObjectWithRestrictions buildValidated( ) throws ConstraintViolationException {
      CustomPrimitiveArraysObjectWithRestrictions lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #aBooleanArray}.<br/>
   * 
   * @return boolean Value to which {@link #aBooleanArray} is set.
   */
  public boolean[] getABooleanArray( ) {
    boolean[] lReturnValue;
    if (aBooleanArray != null) {
      lReturnValue = new boolean[aBooleanArray.length];
      System.arraycopy(aBooleanArray, 0, lReturnValue, 0, aBooleanArray.length);
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
      aBooleanArray = new boolean[pABooleanArray.length];
      System.arraycopy(pABooleanArray, 0, aBooleanArray, 0, pABooleanArray.length);
    }
    else {
      aBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bBooleanArray}.<br/>
   * 
   * @return Boolean Value to which {@link #bBooleanArray} is set.
   */
  public Boolean[] getBBooleanArray( ) {
    Boolean[] lReturnValue;
    if (bBooleanArray != null) {
      lReturnValue = new Boolean[bBooleanArray.length];
      System.arraycopy(bBooleanArray, 0, lReturnValue, 0, bBooleanArray.length);
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
      bBooleanArray = new Boolean[pBBooleanArray.length];
      System.arraycopy(pBBooleanArray, 0, bBooleanArray, 0, pBBooleanArray.length);
    }
    else {
      bBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #cBooleanArray}.<br/>
   * 
   * @return boolean Value to which {@link #cBooleanArray} is set.
   */
  public boolean[] getCBooleanArray( ) {
    boolean[] lReturnValue;
    if (cBooleanArray != null) {
      lReturnValue = new boolean[cBooleanArray.length];
      System.arraycopy(cBooleanArray, 0, lReturnValue, 0, cBooleanArray.length);
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
      cBooleanArray = new boolean[pCBooleanArray.length];
      System.arraycopy(pCBooleanArray, 0, cBooleanArray, 0, pCBooleanArray.length);
    }
    else {
      cBooleanArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aByteArray}.<br/>
   * 
   * @return byte Value to which {@link #aByteArray} is set.
   */
  public byte[] getAByteArray( ) {
    byte[] lReturnValue;
    if (aByteArray != null) {
      lReturnValue = new byte[aByteArray.length];
      System.arraycopy(aByteArray, 0, lReturnValue, 0, aByteArray.length);
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
      aByteArray = new byte[pAByteArray.length];
      System.arraycopy(pAByteArray, 0, aByteArray, 0, pAByteArray.length);
    }
    else {
      aByteArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bByteArray}.<br/>
   * 
   * @return Byte Value to which {@link #bByteArray} is set.
   */
  public Byte[] getBByteArray( ) {
    Byte[] lReturnValue;
    if (bByteArray != null) {
      lReturnValue = new Byte[bByteArray.length];
      System.arraycopy(bByteArray, 0, lReturnValue, 0, bByteArray.length);
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
      bByteArray = new Byte[pBByteArray.length];
      System.arraycopy(pBByteArray, 0, bByteArray, 0, pBByteArray.length);
    }
    else {
      bByteArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aShortArray}.<br/>
   * 
   * @return short Value to which {@link #aShortArray} is set.
   */
  public short[] getAShortArray( ) {
    short[] lReturnValue;
    if (aShortArray != null) {
      lReturnValue = new short[aShortArray.length];
      System.arraycopy(aShortArray, 0, lReturnValue, 0, aShortArray.length);
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
      aShortArray = new short[pAShortArray.length];
      System.arraycopy(pAShortArray, 0, aShortArray, 0, pAShortArray.length);
    }
    else {
      aShortArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bShortArray}.<br/>
   * 
   * @return Short Value to which {@link #bShortArray} is set.
   */
  public Short[] getBShortArray( ) {
    Short[] lReturnValue;
    if (bShortArray != null) {
      lReturnValue = new Short[bShortArray.length];
      System.arraycopy(bShortArray, 0, lReturnValue, 0, bShortArray.length);
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
      bShortArray = new Short[pBShortArray.length];
      System.arraycopy(pBShortArray, 0, bShortArray, 0, pBShortArray.length);
    }
    else {
      bShortArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aIntegerArray}.<br/>
   * 
   * @return int Value to which {@link #aIntegerArray} is set.
   */
  public int[] getAIntegerArray( ) {
    int[] lReturnValue;
    if (aIntegerArray != null) {
      lReturnValue = new int[aIntegerArray.length];
      System.arraycopy(aIntegerArray, 0, lReturnValue, 0, aIntegerArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method returns attribute {@link #bIntegerArray}.<br/>
   * 
   * @return Integer Value to which {@link #bIntegerArray} is set.
   */
  public Integer[] getBIntegerArray( ) {
    Integer[] lReturnValue;
    if (bIntegerArray != null) {
      lReturnValue = new Integer[bIntegerArray.length];
      System.arraycopy(bIntegerArray, 0, lReturnValue, 0, bIntegerArray.length);
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
      bIntegerArray = new Integer[pBIntegerArray.length];
      System.arraycopy(pBIntegerArray, 0, bIntegerArray, 0, pBIntegerArray.length);
    }
    else {
      bIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #cIntegerArray}.<br/>
   * 
   * @return Integer Value to which {@link #cIntegerArray} is set.
   */
  public Integer[] getCIntegerArray( ) {
    Integer[] lReturnValue;
    if (cIntegerArray != null) {
      lReturnValue = new Integer[cIntegerArray.length];
      System.arraycopy(cIntegerArray, 0, lReturnValue, 0, cIntegerArray.length);
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
      cIntegerArray = new Integer[pCIntegerArray.length];
      System.arraycopy(pCIntegerArray, 0, cIntegerArray, 0, pCIntegerArray.length);
    }
    else {
      cIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aLongArray}.<br/>
   * 
   * @return long Value to which {@link #aLongArray} is set.
   */
  public long[] getALongArray( ) {
    long[] lReturnValue;
    if (aLongArray != null) {
      lReturnValue = new long[aLongArray.length];
      System.arraycopy(aLongArray, 0, lReturnValue, 0, aLongArray.length);
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
      aLongArray = new long[pALongArray.length];
      System.arraycopy(pALongArray, 0, aLongArray, 0, pALongArray.length);
    }
    else {
      aLongArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bLongArray}.<br/>
   * 
   * @return Long Value to which {@link #bLongArray} is set.
   */
  public Long[] getBLongArray( ) {
    Long[] lReturnValue;
    if (bLongArray != null) {
      lReturnValue = new Long[bLongArray.length];
      System.arraycopy(bLongArray, 0, lReturnValue, 0, bLongArray.length);
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
      bLongArray = new Long[pBLongArray.length];
      System.arraycopy(pBLongArray, 0, bLongArray, 0, pBLongArray.length);
    }
    else {
      bLongArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aBigIntegerArray}.<br/>
   * 
   * @return BigInteger Value to which {@link #aBigIntegerArray} is set.
   */
  public BigInteger[] getABigIntegerArray( ) {
    BigInteger[] lReturnValue;
    if (aBigIntegerArray != null) {
      lReturnValue = new BigInteger[aBigIntegerArray.length];
      System.arraycopy(aBigIntegerArray, 0, lReturnValue, 0, aBigIntegerArray.length);
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
      aBigIntegerArray = new BigInteger[pABigIntegerArray.length];
      System.arraycopy(pABigIntegerArray, 0, aBigIntegerArray, 0, pABigIntegerArray.length);
    }
    else {
      aBigIntegerArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aCharacterArray}.<br/>
   * 
   * @return char Value to which {@link #aCharacterArray} is set.
   */
  public char[] getACharacterArray( ) {
    char[] lReturnValue;
    if (aCharacterArray != null) {
      lReturnValue = new char[aCharacterArray.length];
      System.arraycopy(aCharacterArray, 0, lReturnValue, 0, aCharacterArray.length);
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
      aCharacterArray = new char[pACharacterArray.length];
      System.arraycopy(pACharacterArray, 0, aCharacterArray, 0, pACharacterArray.length);
    }
    else {
      aCharacterArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bCharacterArray}.<br/>
   * 
   * @return Character Value to which {@link #bCharacterArray} is set.
   */
  public Character[] getBCharacterArray( ) {
    Character[] lReturnValue;
    if (bCharacterArray != null) {
      lReturnValue = new Character[bCharacterArray.length];
      System.arraycopy(bCharacterArray, 0, lReturnValue, 0, bCharacterArray.length);
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
      bCharacterArray = new Character[pBCharacterArray.length];
      System.arraycopy(pBCharacterArray, 0, bCharacterArray, 0, pBCharacterArray.length);
    }
    else {
      bCharacterArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aFloatArray}.<br/>
   * 
   * @return float Value to which {@link #aFloatArray} is set.
   */
  public float[] getAFloatArray( ) {
    float[] lReturnValue;
    if (aFloatArray != null) {
      lReturnValue = new float[aFloatArray.length];
      System.arraycopy(aFloatArray, 0, lReturnValue, 0, aFloatArray.length);
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
      aFloatArray = new float[pAFloatArray.length];
      System.arraycopy(pAFloatArray, 0, aFloatArray, 0, pAFloatArray.length);
    }
    else {
      aFloatArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bFloatArray}.<br/>
   * 
   * @return Float Value to which {@link #bFloatArray} is set.
   */
  public Float[] getBFloatArray( ) {
    Float[] lReturnValue;
    if (bFloatArray != null) {
      lReturnValue = new Float[bFloatArray.length];
      System.arraycopy(bFloatArray, 0, lReturnValue, 0, bFloatArray.length);
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
      bFloatArray = new Float[pBFloatArray.length];
      System.arraycopy(pBFloatArray, 0, bFloatArray, 0, pBFloatArray.length);
    }
    else {
      bFloatArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aDoubleArray}.<br/>
   * 
   * @return double Value to which {@link #aDoubleArray} is set.
   */
  public double[] getADoubleArray( ) {
    double[] lReturnValue;
    if (aDoubleArray != null) {
      lReturnValue = new double[aDoubleArray.length];
      System.arraycopy(aDoubleArray, 0, lReturnValue, 0, aDoubleArray.length);
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
      aDoubleArray = new double[pADoubleArray.length];
      System.arraycopy(pADoubleArray, 0, aDoubleArray, 0, pADoubleArray.length);
    }
    else {
      aDoubleArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bDoubleArray}.<br/>
   * 
   * @return Double Value to which {@link #bDoubleArray} is set.
   */
  public Double[] getBDoubleArray( ) {
    Double[] lReturnValue;
    if (bDoubleArray != null) {
      lReturnValue = new Double[bDoubleArray.length];
      System.arraycopy(bDoubleArray, 0, lReturnValue, 0, bDoubleArray.length);
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
      bDoubleArray = new Double[pBDoubleArray.length];
      System.arraycopy(pBDoubleArray, 0, bDoubleArray, 0, pBDoubleArray.length);
    }
    else {
      bDoubleArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aBigDecimalArray}.<br/>
   * 
   * @return BigDecimal Value to which {@link #aBigDecimalArray} is set.
   */
  public BigDecimal[] getABigDecimalArray( ) {
    BigDecimal[] lReturnValue;
    if (aBigDecimalArray != null) {
      lReturnValue = new BigDecimal[aBigDecimalArray.length];
      System.arraycopy(aBigDecimalArray, 0, lReturnValue, 0, aBigDecimalArray.length);
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
      aBigDecimalArray = new BigDecimal[pABigDecimalArray.length];
      System.arraycopy(pABigDecimalArray, 0, aBigDecimalArray, 0, pABigDecimalArray.length);
    }
    else {
      aBigDecimalArray = null;
    }
  }

  /**
   * Method returns attribute {@link #aStringArray}.<br/>
   * 
   * @return String Value to which {@link #aStringArray} is set.
   */
  public String[] getAStringArray( ) {
    String[] lReturnValue;
    if (aStringArray != null) {
      lReturnValue = new String[aStringArray.length];
      System.arraycopy(aStringArray, 0, lReturnValue, 0, aStringArray.length);
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
      aStringArray = new String[pAStringArray.length];
      System.arraycopy(pAStringArray, 0, aStringArray, 0, pAStringArray.length);
    }
    else {
      aStringArray = null;
    }
  }

  /**
   * Method returns attribute {@link #bStringArray}.<br/>
   * 
   * @return String Value to which {@link #bStringArray} is set.
   */
  public String[] getBStringArray( ) {
    String[] lReturnValue;
    if (bStringArray != null) {
      lReturnValue = new String[bStringArray.length];
      System.arraycopy(bStringArray, 0, lReturnValue, 0, bStringArray.length);
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
      bStringArray = new String[pBStringArray.length];
      System.arraycopy(pBStringArray, 0, bStringArray, 0, pBStringArray.length);
    }
    else {
      bStringArray = null;
    }
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
}
