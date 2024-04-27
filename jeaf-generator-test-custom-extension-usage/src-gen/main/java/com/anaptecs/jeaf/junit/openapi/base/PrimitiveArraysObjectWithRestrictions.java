/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PrimitiveArraysObjectWithRestrictions extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

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

  // "Boolean"
  @ClassPropertyDeclaration
  private boolean[] aBooleanArray;

  // "Boolean"
  private int aBooleanArrayXYZ = 0;

  // "java.lang.Boolean"
  @ClassPropertyDeclaration
  private Boolean[] bBooleanArray;

  // "java.lang.Boolean"
  private int bBooleanArrayXYZ = 0;

  // "Boolean"
  @ClassPropertyDeclaration
  private boolean[] cBooleanArray;

  // "Boolean"
  private int cBooleanArrayXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @Size(min = 0, max = 32768)
  private byte[] aByteArray;

  // "byte"
  private int aByteArrayXYZ = 0;

  // "java.lang.Byte"
  @ClassPropertyDeclaration
  private Byte[] bByteArray;

  // "java.lang.Byte"
  private int bByteArrayXYZ = 0;

  // "short"
  @ClassPropertyDeclaration
  private short[] aShortArray;

  // "short"
  private int aShortArrayXYZ = 0;

  // "java.lang.Short"
  @ClassPropertyDeclaration
  private Short[] bShortArray;

  // "java.lang.Short"
  private int bShortArrayXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  private int[] aIntegerArray;

  // "int"
  private int aIntegerArrayXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  private Integer[] bIntegerArray;

  // "java.lang.Integer"
  private int bIntegerArrayXYZ = 0;

  // "Integer"
  @ClassPropertyDeclaration
  private Integer[] cIntegerArray;

  // "Integer"
  private int cIntegerArrayXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @NotEmpty
  private long[] aLongArray;

  // "long"
  private int aLongArrayXYZ = 0;

  // "java.lang.Long"
  @ClassPropertyDeclaration
  private Long[] bLongArray;

  // "java.lang.Long"
  private int bLongArrayXYZ = 0;

  // "java.math.BigInteger"
  @ClassPropertyDeclaration
  private BigInteger[] aBigIntegerArray;

  // "java.math.BigInteger"
  private int aBigIntegerArrayXYZ = 0;

  // "char"
  @ClassPropertyDeclaration
  private char[] aCharacterArray;

  // "char"
  private int aCharacterArrayXYZ = 0;

  // "java.lang.Character"
  @ClassPropertyDeclaration
  private Character[] bCharacterArray;

  // "java.lang.Character"
  private int bCharacterArrayXYZ = 0;

  // "float"
  @ClassPropertyDeclaration
  private float[] aFloatArray;

  // "float"
  private int aFloatArrayXYZ = 0;

  // "java.lang.Float"
  @ClassPropertyDeclaration
  private Float[] bFloatArray;

  // "java.lang.Float"
  private int bFloatArrayXYZ = 0;

  // "double"
  @ClassPropertyDeclaration
  @Size(min = 4, max = 12)
  private double[] aDoubleArray;

  // "double"
  private int aDoubleArrayXYZ = 0;

  // "java.lang.Double"
  @ClassPropertyDeclaration
  private Double[] bDoubleArray;

  // "java.lang.Double"
  private int bDoubleArrayXYZ = 0;

  // "java.math.BigDecimal"
  @ClassPropertyDeclaration
  private BigDecimal[] aBigDecimalArray;

  // "java.math.BigDecimal"
  private int aBigDecimalArrayXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String[] aStringArray;

  // "String"
  private int aStringArrayXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String[] bStringArray;

  // "String"
  private int bStringArrayXYZ = 0;

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
    // "Boolean"
    aBooleanArrayXYZ = pBuilder.aBooleanArrayXYZ;
    bBooleanArray = pBuilder.bBooleanArray;
    // "java.lang.Boolean"
    bBooleanArrayXYZ = pBuilder.bBooleanArrayXYZ;
    cBooleanArray = pBuilder.cBooleanArray;
    // "Boolean"
    cBooleanArrayXYZ = pBuilder.cBooleanArrayXYZ;
    aByteArray = pBuilder.aByteArray;
    // "byte"
    aByteArrayXYZ = pBuilder.aByteArrayXYZ;
    bByteArray = pBuilder.bByteArray;
    // "java.lang.Byte"
    bByteArrayXYZ = pBuilder.bByteArrayXYZ;
    aShortArray = pBuilder.aShortArray;
    // "short"
    aShortArrayXYZ = pBuilder.aShortArrayXYZ;
    bShortArray = pBuilder.bShortArray;
    // "java.lang.Short"
    bShortArrayXYZ = pBuilder.bShortArrayXYZ;
    aIntegerArray = pBuilder.aIntegerArray;
    // "int"
    aIntegerArrayXYZ = pBuilder.aIntegerArrayXYZ;
    bIntegerArray = pBuilder.bIntegerArray;
    // "java.lang.Integer"
    bIntegerArrayXYZ = pBuilder.bIntegerArrayXYZ;
    cIntegerArray = pBuilder.cIntegerArray;
    // "Integer"
    cIntegerArrayXYZ = pBuilder.cIntegerArrayXYZ;
    aLongArray = pBuilder.aLongArray;
    // "long"
    aLongArrayXYZ = pBuilder.aLongArrayXYZ;
    bLongArray = pBuilder.bLongArray;
    // "java.lang.Long"
    bLongArrayXYZ = pBuilder.bLongArrayXYZ;
    aBigIntegerArray = pBuilder.aBigIntegerArray;
    // "java.math.BigInteger"
    aBigIntegerArrayXYZ = pBuilder.aBigIntegerArrayXYZ;
    aCharacterArray = pBuilder.aCharacterArray;
    // "char"
    aCharacterArrayXYZ = pBuilder.aCharacterArrayXYZ;
    bCharacterArray = pBuilder.bCharacterArray;
    // "java.lang.Character"
    bCharacterArrayXYZ = pBuilder.bCharacterArrayXYZ;
    aFloatArray = pBuilder.aFloatArray;
    // "float"
    aFloatArrayXYZ = pBuilder.aFloatArrayXYZ;
    bFloatArray = pBuilder.bFloatArray;
    // "java.lang.Float"
    bFloatArrayXYZ = pBuilder.bFloatArrayXYZ;
    aDoubleArray = pBuilder.aDoubleArray;
    // "double"
    aDoubleArrayXYZ = pBuilder.aDoubleArrayXYZ;
    bDoubleArray = pBuilder.bDoubleArray;
    // "java.lang.Double"
    bDoubleArrayXYZ = pBuilder.bDoubleArrayXYZ;
    aBigDecimalArray = pBuilder.aBigDecimalArray;
    // "java.math.BigDecimal"
    aBigDecimalArrayXYZ = pBuilder.aBigDecimalArrayXYZ;
    aStringArray = pBuilder.aStringArray;
    // "String"
    aStringArrayXYZ = pBuilder.aStringArrayXYZ;
    bStringArray = pBuilder.bStringArray;
    // "String"
    bStringArrayXYZ = pBuilder.bStringArrayXYZ;
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
   * Class implements builder to create a new instance of class <code>PrimitiveArraysObjectWithRestrictions</code>.
   */
  public static class Builder {
    // "Boolean"
    @BuilderPropertyDeclaration
    private boolean[] aBooleanArray;

    // "Boolean"
    private int aBooleanArrayXYZ = 0;

    // "java.lang.Boolean"
    @BuilderPropertyDeclaration
    private Boolean[] bBooleanArray;

    // "java.lang.Boolean"
    private int bBooleanArrayXYZ = 0;

    // "Boolean"
    @BuilderPropertyDeclaration
    private boolean[] cBooleanArray;

    // "Boolean"
    private int cBooleanArrayXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @Size(min = 0, max = 32768)
    private byte[] aByteArray;

    // "byte"
    private int aByteArrayXYZ = 0;

    // "java.lang.Byte"
    @BuilderPropertyDeclaration
    private Byte[] bByteArray;

    // "java.lang.Byte"
    private int bByteArrayXYZ = 0;

    // "short"
    @BuilderPropertyDeclaration
    private short[] aShortArray;

    // "short"
    private int aShortArrayXYZ = 0;

    // "java.lang.Short"
    @BuilderPropertyDeclaration
    private Short[] bShortArray;

    // "java.lang.Short"
    private int bShortArrayXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    private int[] aIntegerArray;

    // "int"
    private int aIntegerArrayXYZ = 0;

    // "java.lang.Integer"
    @BuilderPropertyDeclaration
    private Integer[] bIntegerArray;

    // "java.lang.Integer"
    private int bIntegerArrayXYZ = 0;

    // "Integer"
    @BuilderPropertyDeclaration
    private Integer[] cIntegerArray;

    // "Integer"
    private int cIntegerArrayXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @NotEmpty
    private long[] aLongArray;

    // "long"
    private int aLongArrayXYZ = 0;

    // "java.lang.Long"
    @BuilderPropertyDeclaration
    private Long[] bLongArray;

    // "java.lang.Long"
    private int bLongArrayXYZ = 0;

    // "java.math.BigInteger"
    @BuilderPropertyDeclaration
    private BigInteger[] aBigIntegerArray;

    // "java.math.BigInteger"
    private int aBigIntegerArrayXYZ = 0;

    // "char"
    @BuilderPropertyDeclaration
    private char[] aCharacterArray;

    // "char"
    private int aCharacterArrayXYZ = 0;

    // "java.lang.Character"
    @BuilderPropertyDeclaration
    private Character[] bCharacterArray;

    // "java.lang.Character"
    private int bCharacterArrayXYZ = 0;

    // "float"
    @BuilderPropertyDeclaration
    private float[] aFloatArray;

    // "float"
    private int aFloatArrayXYZ = 0;

    // "java.lang.Float"
    @BuilderPropertyDeclaration
    private Float[] bFloatArray;

    // "java.lang.Float"
    private int bFloatArrayXYZ = 0;

    // "double"
    @BuilderPropertyDeclaration
    @Size(min = 4, max = 12)
    private double[] aDoubleArray;

    // "double"
    private int aDoubleArrayXYZ = 0;

    // "java.lang.Double"
    @BuilderPropertyDeclaration
    private Double[] bDoubleArray;

    // "java.lang.Double"
    private int bDoubleArrayXYZ = 0;

    // "java.math.BigDecimal"
    @BuilderPropertyDeclaration
    private BigDecimal[] aBigDecimalArray;

    // "java.math.BigDecimal"
    private int aBigDecimalArrayXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String[] aStringArray;

    // "String"
    private int aStringArrayXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String[] bStringArray;

    // "String"
    private int bStringArrayXYZ = 0;

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
        aBooleanArray = new boolean[pABooleanArray.length];
        System.arraycopy(pABooleanArray, 0, aBooleanArray, 0, pABooleanArray.length);
      }
      else {
        aBooleanArray = null;
      }
      return this;
    }

    public Builder setABooleanArrayXYZ( int value ) {
      // "Boolean"
      aBooleanArrayXYZ = value;
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
        bBooleanArray = new Boolean[pBBooleanArray.length];
        System.arraycopy(pBBooleanArray, 0, bBooleanArray, 0, pBBooleanArray.length);
      }
      else {
        bBooleanArray = null;
      }
      return this;
    }

    public Builder setBBooleanArrayXYZ( int value ) {
      // "java.lang.Boolean"
      bBooleanArrayXYZ = value;
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
        cBooleanArray = new boolean[pCBooleanArray.length];
        System.arraycopy(pCBooleanArray, 0, cBooleanArray, 0, pCBooleanArray.length);
      }
      else {
        cBooleanArray = null;
      }
      return this;
    }

    public Builder setCBooleanArrayXYZ( int value ) {
      // "Boolean"
      cBooleanArrayXYZ = value;
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
        aByteArray = new byte[pAByteArray.length];
        System.arraycopy(pAByteArray, 0, aByteArray, 0, pAByteArray.length);
      }
      else {
        aByteArray = null;
      }
      return this;
    }

    public Builder setAByteArrayXYZ( int value ) {
      // "byte"
      aByteArrayXYZ = value;
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
        bByteArray = new Byte[pBByteArray.length];
        System.arraycopy(pBByteArray, 0, bByteArray, 0, pBByteArray.length);
      }
      else {
        bByteArray = null;
      }
      return this;
    }

    public Builder setBByteArrayXYZ( int value ) {
      // "java.lang.Byte"
      bByteArrayXYZ = value;
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
        aShortArray = new short[pAShortArray.length];
        System.arraycopy(pAShortArray, 0, aShortArray, 0, pAShortArray.length);
      }
      else {
        aShortArray = null;
      }
      return this;
    }

    public Builder setAShortArrayXYZ( int value ) {
      // "short"
      aShortArrayXYZ = value;
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
        bShortArray = new Short[pBShortArray.length];
        System.arraycopy(pBShortArray, 0, bShortArray, 0, pBShortArray.length);
      }
      else {
        bShortArray = null;
      }
      return this;
    }

    public Builder setBShortArrayXYZ( int value ) {
      // "java.lang.Short"
      bShortArrayXYZ = value;
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
        aIntegerArray = new int[pAIntegerArray.length];
        System.arraycopy(pAIntegerArray, 0, aIntegerArray, 0, pAIntegerArray.length);
      }
      else {
        aIntegerArray = null;
      }
      return this;
    }

    public Builder setAIntegerArrayXYZ( int value ) {
      // "int"
      aIntegerArrayXYZ = value;
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
        bIntegerArray = new Integer[pBIntegerArray.length];
        System.arraycopy(pBIntegerArray, 0, bIntegerArray, 0, pBIntegerArray.length);
      }
      else {
        bIntegerArray = null;
      }
      return this;
    }

    public Builder setBIntegerArrayXYZ( int value ) {
      // "java.lang.Integer"
      bIntegerArrayXYZ = value;
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
        cIntegerArray = new Integer[pCIntegerArray.length];
        System.arraycopy(pCIntegerArray, 0, cIntegerArray, 0, pCIntegerArray.length);
      }
      else {
        cIntegerArray = null;
      }
      return this;
    }

    public Builder setCIntegerArrayXYZ( int value ) {
      // "Integer"
      cIntegerArrayXYZ = value;
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
        aLongArray = new long[pALongArray.length];
        System.arraycopy(pALongArray, 0, aLongArray, 0, pALongArray.length);
      }
      else {
        aLongArray = null;
      }
      return this;
    }

    public Builder setALongArrayXYZ( int value ) {
      // "long"
      aLongArrayXYZ = value;
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
        bLongArray = new Long[pBLongArray.length];
        System.arraycopy(pBLongArray, 0, bLongArray, 0, pBLongArray.length);
      }
      else {
        bLongArray = null;
      }
      return this;
    }

    public Builder setBLongArrayXYZ( int value ) {
      // "java.lang.Long"
      bLongArrayXYZ = value;
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
        aBigIntegerArray = new BigInteger[pABigIntegerArray.length];
        System.arraycopy(pABigIntegerArray, 0, aBigIntegerArray, 0, pABigIntegerArray.length);
      }
      else {
        aBigIntegerArray = null;
      }
      return this;
    }

    public Builder setABigIntegerArrayXYZ( int value ) {
      // "java.math.BigInteger"
      aBigIntegerArrayXYZ = value;
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
        aCharacterArray = new char[pACharacterArray.length];
        System.arraycopy(pACharacterArray, 0, aCharacterArray, 0, pACharacterArray.length);
      }
      else {
        aCharacterArray = null;
      }
      return this;
    }

    public Builder setACharacterArrayXYZ( int value ) {
      // "char"
      aCharacterArrayXYZ = value;
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
        bCharacterArray = new Character[pBCharacterArray.length];
        System.arraycopy(pBCharacterArray, 0, bCharacterArray, 0, pBCharacterArray.length);
      }
      else {
        bCharacterArray = null;
      }
      return this;
    }

    public Builder setBCharacterArrayXYZ( int value ) {
      // "java.lang.Character"
      bCharacterArrayXYZ = value;
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
        aFloatArray = new float[pAFloatArray.length];
        System.arraycopy(pAFloatArray, 0, aFloatArray, 0, pAFloatArray.length);
      }
      else {
        aFloatArray = null;
      }
      return this;
    }

    public Builder setAFloatArrayXYZ( int value ) {
      // "float"
      aFloatArrayXYZ = value;
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
        bFloatArray = new Float[pBFloatArray.length];
        System.arraycopy(pBFloatArray, 0, bFloatArray, 0, pBFloatArray.length);
      }
      else {
        bFloatArray = null;
      }
      return this;
    }

    public Builder setBFloatArrayXYZ( int value ) {
      // "java.lang.Float"
      bFloatArrayXYZ = value;
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
        aDoubleArray = new double[pADoubleArray.length];
        System.arraycopy(pADoubleArray, 0, aDoubleArray, 0, pADoubleArray.length);
      }
      else {
        aDoubleArray = null;
      }
      return this;
    }

    public Builder setADoubleArrayXYZ( int value ) {
      // "double"
      aDoubleArrayXYZ = value;
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
        bDoubleArray = new Double[pBDoubleArray.length];
        System.arraycopy(pBDoubleArray, 0, bDoubleArray, 0, pBDoubleArray.length);
      }
      else {
        bDoubleArray = null;
      }
      return this;
    }

    public Builder setBDoubleArrayXYZ( int value ) {
      // "java.lang.Double"
      bDoubleArrayXYZ = value;
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
        aBigDecimalArray = new BigDecimal[pABigDecimalArray.length];
        System.arraycopy(pABigDecimalArray, 0, aBigDecimalArray, 0, pABigDecimalArray.length);
      }
      else {
        aBigDecimalArray = null;
      }
      return this;
    }

    public Builder setABigDecimalArrayXYZ( int value ) {
      // "java.math.BigDecimal"
      aBigDecimalArrayXYZ = value;
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
        aStringArray = new String[pAStringArray.length];
        System.arraycopy(pAStringArray, 0, aStringArray, 0, pAStringArray.length);
      }
      else {
        aStringArray = null;
      }
      return this;
    }

    public Builder setAStringArrayXYZ( int value ) {
      // "String"
      aStringArrayXYZ = value;
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
        bStringArray = new String[pBStringArray.length];
        System.arraycopy(pBStringArray, 0, bStringArray, 0, pBStringArray.length);
      }
      else {
        bStringArray = null;
      }
      return this;
    }

    public Builder setBStringArrayXYZ( int value ) {
      // "String"
      bStringArrayXYZ = value;
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

  public int getABooleanArrayXYZ( ) {
    // "Boolean"
    return aBooleanArrayXYZ;
  }

  public void setABooleanArrayXYZ( int value ) {
    aBooleanArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bBooleanArray}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #bBooleanArray} is set.
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

  public int getBBooleanArrayXYZ( ) {
    // "java.lang.Boolean"
    return bBooleanArrayXYZ;
  }

  public void setBBooleanArrayXYZ( int value ) {
    bBooleanArrayXYZ = value;
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

  public int getCBooleanArrayXYZ( ) {
    // "Boolean"
    return cBooleanArrayXYZ;
  }

  public void setCBooleanArrayXYZ( int value ) {
    cBooleanArrayXYZ = value;
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

  public int getAByteArrayXYZ( ) {
    // "byte"
    return aByteArrayXYZ;
  }

  public void setAByteArrayXYZ( int value ) {
    aByteArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bByteArray}.<br/>
   *
   * @return {@link Byte} Value to which {@link #bByteArray} is set.
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

  public int getBByteArrayXYZ( ) {
    // "java.lang.Byte"
    return bByteArrayXYZ;
  }

  public void setBByteArrayXYZ( int value ) {
    bByteArrayXYZ = value;
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

  public int getAShortArrayXYZ( ) {
    // "short"
    return aShortArrayXYZ;
  }

  public void setAShortArrayXYZ( int value ) {
    aShortArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bShortArray}.<br/>
   *
   * @return {@link Short} Value to which {@link #bShortArray} is set.
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

  public int getBShortArrayXYZ( ) {
    // "java.lang.Short"
    return bShortArrayXYZ;
  }

  public void setBShortArrayXYZ( int value ) {
    bShortArrayXYZ = value;
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
   * Method sets attribute {@link #aIntegerArray}.<br/>
   *
   * @param pAIntegerArray Value to which {@link #aIntegerArray} should be set.
   */
  public void setAIntegerArray( int[] pAIntegerArray ) {
    // Assign value to attribute
    if (pAIntegerArray != null) {
      aIntegerArray = new int[pAIntegerArray.length];
      System.arraycopy(pAIntegerArray, 0, aIntegerArray, 0, pAIntegerArray.length);
    }
    else {
      aIntegerArray = null;
    }
  }

  public int getAIntegerArrayXYZ( ) {
    // "int"
    return aIntegerArrayXYZ;
  }

  public void setAIntegerArrayXYZ( int value ) {
    aIntegerArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bIntegerArray}.<br/>
   *
   * @return {@link Integer} Value to which {@link #bIntegerArray} is set.
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

  public int getBIntegerArrayXYZ( ) {
    // "java.lang.Integer"
    return bIntegerArrayXYZ;
  }

  public void setBIntegerArrayXYZ( int value ) {
    bIntegerArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #cIntegerArray}.<br/>
   *
   * @return {@link Integer} Value to which {@link #cIntegerArray} is set.
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

  public int getCIntegerArrayXYZ( ) {
    // "Integer"
    return cIntegerArrayXYZ;
  }

  public void setCIntegerArrayXYZ( int value ) {
    cIntegerArrayXYZ = value;
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

  public int getALongArrayXYZ( ) {
    // "long"
    return aLongArrayXYZ;
  }

  public void setALongArrayXYZ( int value ) {
    aLongArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bLongArray}.<br/>
   *
   * @return {@link Long} Value to which {@link #bLongArray} is set.
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

  public int getBLongArrayXYZ( ) {
    // "java.lang.Long"
    return bLongArrayXYZ;
  }

  public void setBLongArrayXYZ( int value ) {
    bLongArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #aBigIntegerArray}.<br/>
   *
   * @return {@link BigInteger} Value to which {@link #aBigIntegerArray} is set.
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

  public int getABigIntegerArrayXYZ( ) {
    // "java.math.BigInteger"
    return aBigIntegerArrayXYZ;
  }

  public void setABigIntegerArrayXYZ( int value ) {
    aBigIntegerArrayXYZ = value;
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

  public int getACharacterArrayXYZ( ) {
    // "char"
    return aCharacterArrayXYZ;
  }

  public void setACharacterArrayXYZ( int value ) {
    aCharacterArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bCharacterArray}.<br/>
   *
   * @return {@link Character} Value to which {@link #bCharacterArray} is set.
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

  public int getBCharacterArrayXYZ( ) {
    // "java.lang.Character"
    return bCharacterArrayXYZ;
  }

  public void setBCharacterArrayXYZ( int value ) {
    bCharacterArrayXYZ = value;
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

  public int getAFloatArrayXYZ( ) {
    // "float"
    return aFloatArrayXYZ;
  }

  public void setAFloatArrayXYZ( int value ) {
    aFloatArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bFloatArray}.<br/>
   *
   * @return {@link Float} Value to which {@link #bFloatArray} is set.
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

  public int getBFloatArrayXYZ( ) {
    // "java.lang.Float"
    return bFloatArrayXYZ;
  }

  public void setBFloatArrayXYZ( int value ) {
    bFloatArrayXYZ = value;
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

  public int getADoubleArrayXYZ( ) {
    // "double"
    return aDoubleArrayXYZ;
  }

  public void setADoubleArrayXYZ( int value ) {
    aDoubleArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bDoubleArray}.<br/>
   *
   * @return {@link Double} Value to which {@link #bDoubleArray} is set.
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

  public int getBDoubleArrayXYZ( ) {
    // "java.lang.Double"
    return bDoubleArrayXYZ;
  }

  public void setBDoubleArrayXYZ( int value ) {
    bDoubleArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #aBigDecimalArray}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #aBigDecimalArray} is set.
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

  public int getABigDecimalArrayXYZ( ) {
    // "java.math.BigDecimal"
    return aBigDecimalArrayXYZ;
  }

  public void setABigDecimalArrayXYZ( int value ) {
    aBigDecimalArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #aStringArray}.<br/>
   *
   * @return {@link String} Value to which {@link #aStringArray} is set.
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

  public int getAStringArrayXYZ( ) {
    // "String"
    return aStringArrayXYZ;
  }

  public void setAStringArrayXYZ( int value ) {
    aStringArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #bStringArray}.<br/>
   *
   * @return {@link String} Value to which {@link #bStringArray} is set.
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

  public int getBStringArrayXYZ( ) {
    // "String"
    return bStringArrayXYZ;
  }

  public void setBStringArrayXYZ( int value ) {
    bStringArrayXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
