/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PrimitiveArraysObjectWithRestrictions implements ServiceObject {
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

  private boolean[] aBooleanArray;

  private Set<Boolean> bBooleanArray;

  private boolean[] cBooleanArray;

  @Size(min = 0, max = 32768)
  private byte[] aByteArray;

  private Set<Byte> bByteArray;

  private short[] aShortArray;

  private Set<Short> bShortArray;

  private int[] aIntegerArray;

  private Set<Integer> bIntegerArray;

  private Set<Integer> cIntegerArray;

  @NotEmpty
  private long[] aLongArray;

  private Set<Long> bLongArray;

  private Set<BigInteger> aBigIntegerArray;

  private char[] aCharacterArray;

  private Set<Character> bCharacterArray;

  private float[] aFloatArray;

  private Set<Float> bFloatArray;

  @Size(min = 4, max = 12)
  private double[] aDoubleArray;

  private Set<Double> bDoubleArray;

  private Set<BigDecimal> aBigDecimalArray;

  private Set<String> aStringArray;

  private Set<String> bStringArray;

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
   * @return {@link PrimitiveArraysObjectWithRestrictions}
   */
  public static PrimitiveArraysObjectWithRestrictions of( long[] pALongArray ) {
    var lBuilder = PrimitiveArraysObjectWithRestrictions.builder();
    lBuilder.setALongArray(pALongArray);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveArraysObjectWithRestrictions</code>.
   */
  public static class Builder {
    private boolean[] aBooleanArray;

    private Set<Boolean> bBooleanArray;

    private boolean[] cBooleanArray;

    @Size(min = 0, max = 32768)
    private byte[] aByteArray;

    private Set<Byte> bByteArray;

    private short[] aShortArray;

    private Set<Short> bShortArray;

    private int[] aIntegerArray;

    private Set<Integer> bIntegerArray;

    private Set<Integer> cIntegerArray;

    @NotEmpty
    private long[] aLongArray;

    private Set<Long> bLongArray;

    private Set<BigInteger> aBigIntegerArray;

    private char[] aCharacterArray;

    private Set<Character> bCharacterArray;

    private float[] aFloatArray;

    private Set<Float> bFloatArray;

    @Size(min = 4, max = 12)
    private double[] aDoubleArray;

    private Set<Double> bDoubleArray;

    private Set<BigDecimal> aBigDecimalArray;

    private Set<String> aStringArray;

    private Set<String> bStringArray;

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

    /**
     * Method sets attribute {@link #bBooleanArray}.<br/>
     *
     * @param pBBooleanArray Collection to which {@link #bBooleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBBooleanArray( Set<Boolean> pBBooleanArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBBooleanArray != null) {
        bBooleanArray = new HashSet<Boolean>(pBBooleanArray);
      }
      else {
        bBooleanArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bBooleanArray}.<br/>
     *
     * @param pBBooleanArray Array of objects that should be added to {@link #bBooleanArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBBooleanArray( Boolean... pBBooleanArray ) {
      if (pBBooleanArray != null) {
        if (bBooleanArray == null) {
          bBooleanArray = new HashSet<Boolean>();
        }
        bBooleanArray.addAll(Arrays.asList(pBBooleanArray));
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
        cBooleanArray = new boolean[pCBooleanArray.length];
        System.arraycopy(pCBooleanArray, 0, cBooleanArray, 0, pCBooleanArray.length);
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
        aByteArray = new byte[pAByteArray.length];
        System.arraycopy(pAByteArray, 0, aByteArray, 0, pAByteArray.length);
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
    public Builder setBByteArray( Set<Byte> pBByteArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBByteArray != null) {
        bByteArray = new HashSet<Byte>(pBByteArray);
      }
      else {
        bByteArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bByteArray}.<br/>
     *
     * @param pBByteArray Array of objects that should be added to {@link #bByteArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBByteArray( Byte... pBByteArray ) {
      if (pBByteArray != null) {
        if (bByteArray == null) {
          bByteArray = new HashSet<Byte>();
        }
        bByteArray.addAll(Arrays.asList(pBByteArray));
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
        aShortArray = new short[pAShortArray.length];
        System.arraycopy(pAShortArray, 0, aShortArray, 0, pAShortArray.length);
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
    public Builder setBShortArray( Set<Short> pBShortArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBShortArray != null) {
        bShortArray = new HashSet<Short>(pBShortArray);
      }
      else {
        bShortArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bShortArray}.<br/>
     *
     * @param pBShortArray Array of objects that should be added to {@link #bShortArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBShortArray( Short... pBShortArray ) {
      if (pBShortArray != null) {
        if (bShortArray == null) {
          bShortArray = new HashSet<Short>();
        }
        bShortArray.addAll(Arrays.asList(pBShortArray));
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
        aIntegerArray = new int[pAIntegerArray.length];
        System.arraycopy(pAIntegerArray, 0, aIntegerArray, 0, pAIntegerArray.length);
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
    public Builder setBIntegerArray( Set<Integer> pBIntegerArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBIntegerArray != null) {
        bIntegerArray = new HashSet<Integer>(pBIntegerArray);
      }
      else {
        bIntegerArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bIntegerArray}.<br/>
     *
     * @param pBIntegerArray Array of objects that should be added to {@link #bIntegerArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBIntegerArray( Integer... pBIntegerArray ) {
      if (pBIntegerArray != null) {
        if (bIntegerArray == null) {
          bIntegerArray = new HashSet<Integer>();
        }
        bIntegerArray.addAll(Arrays.asList(pBIntegerArray));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #cIntegerArray}.<br/>
     *
     * @param pCIntegerArray Collection to which {@link #cIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCIntegerArray( Set<Integer> pCIntegerArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCIntegerArray != null) {
        cIntegerArray = new HashSet<Integer>(pCIntegerArray);
      }
      else {
        cIntegerArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #cIntegerArray}.<br/>
     *
     * @param pCIntegerArray Array of objects that should be added to {@link #cIntegerArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToCIntegerArray( Integer... pCIntegerArray ) {
      if (pCIntegerArray != null) {
        if (cIntegerArray == null) {
          cIntegerArray = new HashSet<Integer>();
        }
        cIntegerArray.addAll(Arrays.asList(pCIntegerArray));
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
        aLongArray = new long[pALongArray.length];
        System.arraycopy(pALongArray, 0, aLongArray, 0, pALongArray.length);
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
    public Builder setBLongArray( Set<Long> pBLongArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBLongArray != null) {
        bLongArray = new HashSet<Long>(pBLongArray);
      }
      else {
        bLongArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bLongArray}.<br/>
     *
     * @param pBLongArray Array of objects that should be added to {@link #bLongArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBLongArray( Long... pBLongArray ) {
      if (pBLongArray != null) {
        if (bLongArray == null) {
          bLongArray = new HashSet<Long>();
        }
        bLongArray.addAll(Arrays.asList(pBLongArray));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aBigIntegerArray}.<br/>
     *
     * @param pABigIntegerArray Collection to which {@link #aBigIntegerArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigIntegerArray( Set<BigInteger> pABigIntegerArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pABigIntegerArray != null) {
        aBigIntegerArray = new HashSet<BigInteger>(pABigIntegerArray);
      }
      else {
        aBigIntegerArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #aBigIntegerArray}.<br/>
     *
     * @param pABigIntegerArray Array of objects that should be added to {@link #aBigIntegerArray}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToABigIntegerArray( BigInteger... pABigIntegerArray ) {
      if (pABigIntegerArray != null) {
        if (aBigIntegerArray == null) {
          aBigIntegerArray = new HashSet<BigInteger>();
        }
        aBigIntegerArray.addAll(Arrays.asList(pABigIntegerArray));
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
        aCharacterArray = new char[pACharacterArray.length];
        System.arraycopy(pACharacterArray, 0, aCharacterArray, 0, pACharacterArray.length);
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
    public Builder setBCharacterArray( Set<Character> pBCharacterArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBCharacterArray != null) {
        bCharacterArray = new HashSet<Character>(pBCharacterArray);
      }
      else {
        bCharacterArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bCharacterArray}.<br/>
     *
     * @param pBCharacterArray Array of objects that should be added to {@link #bCharacterArray}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBCharacterArray( Character... pBCharacterArray ) {
      if (pBCharacterArray != null) {
        if (bCharacterArray == null) {
          bCharacterArray = new HashSet<Character>();
        }
        bCharacterArray.addAll(Arrays.asList(pBCharacterArray));
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
        aFloatArray = new float[pAFloatArray.length];
        System.arraycopy(pAFloatArray, 0, aFloatArray, 0, pAFloatArray.length);
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
    public Builder setBFloatArray( Set<Float> pBFloatArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBFloatArray != null) {
        bFloatArray = new HashSet<Float>(pBFloatArray);
      }
      else {
        bFloatArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bFloatArray}.<br/>
     *
     * @param pBFloatArray Array of objects that should be added to {@link #bFloatArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBFloatArray( Float... pBFloatArray ) {
      if (pBFloatArray != null) {
        if (bFloatArray == null) {
          bFloatArray = new HashSet<Float>();
        }
        bFloatArray.addAll(Arrays.asList(pBFloatArray));
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
        aDoubleArray = new double[pADoubleArray.length];
        System.arraycopy(pADoubleArray, 0, aDoubleArray, 0, pADoubleArray.length);
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
    public Builder setBDoubleArray( Set<Double> pBDoubleArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBDoubleArray != null) {
        bDoubleArray = new HashSet<Double>(pBDoubleArray);
      }
      else {
        bDoubleArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bDoubleArray}.<br/>
     *
     * @param pBDoubleArray Array of objects that should be added to {@link #bDoubleArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBDoubleArray( Double... pBDoubleArray ) {
      if (pBDoubleArray != null) {
        if (bDoubleArray == null) {
          bDoubleArray = new HashSet<Double>();
        }
        bDoubleArray.addAll(Arrays.asList(pBDoubleArray));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aBigDecimalArray}.<br/>
     *
     * @param pABigDecimalArray Collection to which {@link #aBigDecimalArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigDecimalArray( Set<BigDecimal> pABigDecimalArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pABigDecimalArray != null) {
        aBigDecimalArray = new HashSet<BigDecimal>(pABigDecimalArray);
      }
      else {
        aBigDecimalArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #aBigDecimalArray}.<br/>
     *
     * @param pABigDecimalArray Array of objects that should be added to {@link #aBigDecimalArray}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToABigDecimalArray( BigDecimal... pABigDecimalArray ) {
      if (pABigDecimalArray != null) {
        if (aBigDecimalArray == null) {
          aBigDecimalArray = new HashSet<BigDecimal>();
        }
        aBigDecimalArray.addAll(Arrays.asList(pABigDecimalArray));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #aStringArray}.<br/>
     *
     * @param pAStringArray Collection to which {@link #aStringArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAStringArray( Set<String> pAStringArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAStringArray != null) {
        aStringArray = new HashSet<String>(pAStringArray);
      }
      else {
        aStringArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #aStringArray}.<br/>
     *
     * @param pAStringArray Array of objects that should be added to {@link #aStringArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToAStringArray( String... pAStringArray ) {
      if (pAStringArray != null) {
        if (aStringArray == null) {
          aStringArray = new HashSet<String>();
        }
        aStringArray.addAll(Arrays.asList(pAStringArray));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bStringArray}.<br/>
     *
     * @param pBStringArray Collection to which {@link #bStringArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBStringArray( Set<String> pBStringArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBStringArray != null) {
        bStringArray = new HashSet<String>(pBStringArray);
      }
      else {
        bStringArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bStringArray}.<br/>
     *
     * @param pBStringArray Array of objects that should be added to {@link #bStringArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBStringArray( String... pBStringArray ) {
      if (pBStringArray != null) {
        if (bStringArray == null) {
          bStringArray = new HashSet<String>();
        }
        bStringArray.addAll(Arrays.asList(pBStringArray));
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
      PrimitiveArraysObjectWithRestrictions lObject = new PrimitiveArraysObjectWithRestrictions(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * @return {@link Set<Boolean>} Value to which {@link #bBooleanArray} is set.
   */
  public Set<Boolean> getBBooleanArray( ) {
    // Return all Boolean objects as unmodifiable collection.
    return Collections.unmodifiableSet(bBooleanArray);
  }

  /**
   * Method adds the passed object to {@link #bBooleanArray}.
   *
   * @param pBBooleanArray Object that should be added to {@link #bBooleanArray}. The parameter must not be null.
   */
  public void addToBBooleanArray( Boolean pBBooleanArray ) {
    // Check parameter "pBBooleanArray" for invalid value null.
    Check.checkInvalidParameterNull(pBBooleanArray, "pBBooleanArray");
    // Add passed object to collection of associated Boolean objects.
    bBooleanArray.add(pBBooleanArray);
  }

  /**
   * Method adds all passed objects to {@link #bBooleanArray}.
   *
   * @param pBBooleanArray Collection with all objects that should be added to {@link #bBooleanArray}. The parameter
   * must not be null.
   */
  public void addToBBooleanArray( Collection<Boolean> pBBooleanArray ) {
    // Check parameter "pBBooleanArray" for invalid value null.
    Check.checkInvalidParameterNull(pBBooleanArray, "pBBooleanArray");
    // Add all passed objects.
    for (Boolean lNextObject : pBBooleanArray) {
      this.addToBBooleanArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bBooleanArray}.<br/>
   *
   * @param pBBooleanArray Object that should be removed from {@link #bBooleanArray}. The parameter must not be null.
   */
  public void removeFromBBooleanArray( Boolean pBBooleanArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBBooleanArray, "pBBooleanArray");
    // Remove passed object from collection of associated Boolean objects.
    bBooleanArray.remove(pBBooleanArray);
  }

  /**
   * Method removes all objects from {@link #bBooleanArray}.
   */
  public void clearBBooleanArray( ) {
    // Remove all objects from association "bBooleanArray".
    bBooleanArray.clear();
  }

  /**
   * Method returns attribute {@link #cBooleanArray}.<br/>
   *
   * @return boolean[] Value to which {@link #cBooleanArray} is set.
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
   * @return byte[] Value to which {@link #aByteArray} is set.
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
   * @return {@link Set<Byte>} Value to which {@link #bByteArray} is set.
   */
  public Set<Byte> getBByteArray( ) {
    // Return all Byte objects as unmodifiable collection.
    return Collections.unmodifiableSet(bByteArray);
  }

  /**
   * Method adds the passed object to {@link #bByteArray}.
   *
   * @param pBByteArray Object that should be added to {@link #bByteArray}. The parameter must not be null.
   */
  public void addToBByteArray( Byte pBByteArray ) {
    // Check parameter "pBByteArray" for invalid value null.
    Check.checkInvalidParameterNull(pBByteArray, "pBByteArray");
    // Add passed object to collection of associated Byte objects.
    bByteArray.add(pBByteArray);
  }

  /**
   * Method adds all passed objects to {@link #bByteArray}.
   *
   * @param pBByteArray Collection with all objects that should be added to {@link #bByteArray}. The parameter must not
   * be null.
   */
  public void addToBByteArray( Collection<Byte> pBByteArray ) {
    // Check parameter "pBByteArray" for invalid value null.
    Check.checkInvalidParameterNull(pBByteArray, "pBByteArray");
    // Add all passed objects.
    for (Byte lNextObject : pBByteArray) {
      this.addToBByteArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bByteArray}.<br/>
   *
   * @param pBByteArray Object that should be removed from {@link #bByteArray}. The parameter must not be null.
   */
  public void removeFromBByteArray( Byte pBByteArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBByteArray, "pBByteArray");
    // Remove passed object from collection of associated Byte objects.
    bByteArray.remove(pBByteArray);
  }

  /**
   * Method removes all objects from {@link #bByteArray}.
   */
  public void clearBByteArray( ) {
    // Remove all objects from association "bByteArray".
    bByteArray.clear();
  }

  /**
   * Method returns attribute {@link #aShortArray}.<br/>
   *
   * @return short[] Value to which {@link #aShortArray} is set.
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
   * @return {@link Set<Short>} Value to which {@link #bShortArray} is set.
   */
  public Set<Short> getBShortArray( ) {
    // Return all Short objects as unmodifiable collection.
    return Collections.unmodifiableSet(bShortArray);
  }

  /**
   * Method adds the passed object to {@link #bShortArray}.
   *
   * @param pBShortArray Object that should be added to {@link #bShortArray}. The parameter must not be null.
   */
  public void addToBShortArray( Short pBShortArray ) {
    // Check parameter "pBShortArray" for invalid value null.
    Check.checkInvalidParameterNull(pBShortArray, "pBShortArray");
    // Add passed object to collection of associated Short objects.
    bShortArray.add(pBShortArray);
  }

  /**
   * Method adds all passed objects to {@link #bShortArray}.
   *
   * @param pBShortArray Collection with all objects that should be added to {@link #bShortArray}. The parameter must
   * not be null.
   */
  public void addToBShortArray( Collection<Short> pBShortArray ) {
    // Check parameter "pBShortArray" for invalid value null.
    Check.checkInvalidParameterNull(pBShortArray, "pBShortArray");
    // Add all passed objects.
    for (Short lNextObject : pBShortArray) {
      this.addToBShortArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bShortArray}.<br/>
   *
   * @param pBShortArray Object that should be removed from {@link #bShortArray}. The parameter must not be null.
   */
  public void removeFromBShortArray( Short pBShortArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBShortArray, "pBShortArray");
    // Remove passed object from collection of associated Short objects.
    bShortArray.remove(pBShortArray);
  }

  /**
   * Method removes all objects from {@link #bShortArray}.
   */
  public void clearBShortArray( ) {
    // Remove all objects from association "bShortArray".
    bShortArray.clear();
  }

  /**
   * Method returns attribute {@link #aIntegerArray}.<br/>
   *
   * @return int[] Value to which {@link #aIntegerArray} is set.
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

  /**
   * Method returns attribute {@link #bIntegerArray}.<br/>
   *
   * @return {@link Set<Integer>} Value to which {@link #bIntegerArray} is set.
   */
  public Set<Integer> getBIntegerArray( ) {
    // Return all Integer objects as unmodifiable collection.
    return Collections.unmodifiableSet(bIntegerArray);
  }

  /**
   * Method adds the passed object to {@link #bIntegerArray}.
   *
   * @param pBIntegerArray Object that should be added to {@link #bIntegerArray}. The parameter must not be null.
   */
  public void addToBIntegerArray( Integer pBIntegerArray ) {
    // Check parameter "pBIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pBIntegerArray, "pBIntegerArray");
    // Add passed object to collection of associated Integer objects.
    bIntegerArray.add(pBIntegerArray);
  }

  /**
   * Method adds all passed objects to {@link #bIntegerArray}.
   *
   * @param pBIntegerArray Collection with all objects that should be added to {@link #bIntegerArray}. The parameter
   * must not be null.
   */
  public void addToBIntegerArray( Collection<Integer> pBIntegerArray ) {
    // Check parameter "pBIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pBIntegerArray, "pBIntegerArray");
    // Add all passed objects.
    for (Integer lNextObject : pBIntegerArray) {
      this.addToBIntegerArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bIntegerArray}.<br/>
   *
   * @param pBIntegerArray Object that should be removed from {@link #bIntegerArray}. The parameter must not be null.
   */
  public void removeFromBIntegerArray( Integer pBIntegerArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBIntegerArray, "pBIntegerArray");
    // Remove passed object from collection of associated Integer objects.
    bIntegerArray.remove(pBIntegerArray);
  }

  /**
   * Method removes all objects from {@link #bIntegerArray}.
   */
  public void clearBIntegerArray( ) {
    // Remove all objects from association "bIntegerArray".
    bIntegerArray.clear();
  }

  /**
   * Method returns attribute {@link #cIntegerArray}.<br/>
   *
   * @return {@link Set<Integer>} Value to which {@link #cIntegerArray} is set.
   */
  public Set<Integer> getCIntegerArray( ) {
    // Return all Integer objects as unmodifiable collection.
    return Collections.unmodifiableSet(cIntegerArray);
  }

  /**
   * Method adds the passed object to {@link #cIntegerArray}.
   *
   * @param pCIntegerArray Object that should be added to {@link #cIntegerArray}. The parameter must not be null.
   */
  public void addToCIntegerArray( Integer pCIntegerArray ) {
    // Check parameter "pCIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pCIntegerArray, "pCIntegerArray");
    // Add passed object to collection of associated Integer objects.
    cIntegerArray.add(pCIntegerArray);
  }

  /**
   * Method adds all passed objects to {@link #cIntegerArray}.
   *
   * @param pCIntegerArray Collection with all objects that should be added to {@link #cIntegerArray}. The parameter
   * must not be null.
   */
  public void addToCIntegerArray( Collection<Integer> pCIntegerArray ) {
    // Check parameter "pCIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pCIntegerArray, "pCIntegerArray");
    // Add all passed objects.
    for (Integer lNextObject : pCIntegerArray) {
      this.addToCIntegerArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #cIntegerArray}.<br/>
   *
   * @param pCIntegerArray Object that should be removed from {@link #cIntegerArray}. The parameter must not be null.
   */
  public void removeFromCIntegerArray( Integer pCIntegerArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCIntegerArray, "pCIntegerArray");
    // Remove passed object from collection of associated Integer objects.
    cIntegerArray.remove(pCIntegerArray);
  }

  /**
   * Method removes all objects from {@link #cIntegerArray}.
   */
  public void clearCIntegerArray( ) {
    // Remove all objects from association "cIntegerArray".
    cIntegerArray.clear();
  }

  /**
   * Method returns attribute {@link #aLongArray}.<br/>
   *
   * @return long[] Value to which {@link #aLongArray} is set.
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
   * @return {@link Set<Long>} Value to which {@link #bLongArray} is set.
   */
  public Set<Long> getBLongArray( ) {
    // Return all Long objects as unmodifiable collection.
    return Collections.unmodifiableSet(bLongArray);
  }

  /**
   * Method adds the passed object to {@link #bLongArray}.
   *
   * @param pBLongArray Object that should be added to {@link #bLongArray}. The parameter must not be null.
   */
  public void addToBLongArray( Long pBLongArray ) {
    // Check parameter "pBLongArray" for invalid value null.
    Check.checkInvalidParameterNull(pBLongArray, "pBLongArray");
    // Add passed object to collection of associated Long objects.
    bLongArray.add(pBLongArray);
  }

  /**
   * Method adds all passed objects to {@link #bLongArray}.
   *
   * @param pBLongArray Collection with all objects that should be added to {@link #bLongArray}. The parameter must not
   * be null.
   */
  public void addToBLongArray( Collection<Long> pBLongArray ) {
    // Check parameter "pBLongArray" for invalid value null.
    Check.checkInvalidParameterNull(pBLongArray, "pBLongArray");
    // Add all passed objects.
    for (Long lNextObject : pBLongArray) {
      this.addToBLongArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bLongArray}.<br/>
   *
   * @param pBLongArray Object that should be removed from {@link #bLongArray}. The parameter must not be null.
   */
  public void removeFromBLongArray( Long pBLongArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBLongArray, "pBLongArray");
    // Remove passed object from collection of associated Long objects.
    bLongArray.remove(pBLongArray);
  }

  /**
   * Method removes all objects from {@link #bLongArray}.
   */
  public void clearBLongArray( ) {
    // Remove all objects from association "bLongArray".
    bLongArray.clear();
  }

  /**
   * Method returns attribute {@link #aBigIntegerArray}.<br/>
   *
   * @return {@link Set<BigInteger>} Value to which {@link #aBigIntegerArray} is set.
   */
  public Set<BigInteger> getABigIntegerArray( ) {
    // Return all BigInteger objects as unmodifiable collection.
    return Collections.unmodifiableSet(aBigIntegerArray);
  }

  /**
   * Method adds the passed object to {@link #aBigIntegerArray}.
   *
   * @param pABigIntegerArray Object that should be added to {@link #aBigIntegerArray}. The parameter must not be null.
   */
  public void addToABigIntegerArray( BigInteger pABigIntegerArray ) {
    // Check parameter "pABigIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pABigIntegerArray, "pABigIntegerArray");
    // Add passed object to collection of associated BigInteger objects.
    aBigIntegerArray.add(pABigIntegerArray);
  }

  /**
   * Method adds all passed objects to {@link #aBigIntegerArray}.
   *
   * @param pABigIntegerArray Collection with all objects that should be added to {@link #aBigIntegerArray}. The
   * parameter must not be null.
   */
  public void addToABigIntegerArray( Collection<BigInteger> pABigIntegerArray ) {
    // Check parameter "pABigIntegerArray" for invalid value null.
    Check.checkInvalidParameterNull(pABigIntegerArray, "pABigIntegerArray");
    // Add all passed objects.
    for (BigInteger lNextObject : pABigIntegerArray) {
      this.addToABigIntegerArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #aBigIntegerArray}.<br/>
   *
   * @param pABigIntegerArray Object that should be removed from {@link #aBigIntegerArray}. The parameter must not be
   * null.
   */
  public void removeFromABigIntegerArray( BigInteger pABigIntegerArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pABigIntegerArray, "pABigIntegerArray");
    // Remove passed object from collection of associated BigInteger objects.
    aBigIntegerArray.remove(pABigIntegerArray);
  }

  /**
   * Method removes all objects from {@link #aBigIntegerArray}.
   */
  public void clearABigIntegerArray( ) {
    // Remove all objects from association "aBigIntegerArray".
    aBigIntegerArray.clear();
  }

  /**
   * Method returns attribute {@link #aCharacterArray}.<br/>
   *
   * @return char[] Value to which {@link #aCharacterArray} is set.
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
   * @return {@link Set<Character>} Value to which {@link #bCharacterArray} is set.
   */
  public Set<Character> getBCharacterArray( ) {
    // Return all Character objects as unmodifiable collection.
    return Collections.unmodifiableSet(bCharacterArray);
  }

  /**
   * Method adds the passed object to {@link #bCharacterArray}.
   *
   * @param pBCharacterArray Object that should be added to {@link #bCharacterArray}. The parameter must not be null.
   */
  public void addToBCharacterArray( Character pBCharacterArray ) {
    // Check parameter "pBCharacterArray" for invalid value null.
    Check.checkInvalidParameterNull(pBCharacterArray, "pBCharacterArray");
    // Add passed object to collection of associated Character objects.
    bCharacterArray.add(pBCharacterArray);
  }

  /**
   * Method adds all passed objects to {@link #bCharacterArray}.
   *
   * @param pBCharacterArray Collection with all objects that should be added to {@link #bCharacterArray}. The parameter
   * must not be null.
   */
  public void addToBCharacterArray( Collection<Character> pBCharacterArray ) {
    // Check parameter "pBCharacterArray" for invalid value null.
    Check.checkInvalidParameterNull(pBCharacterArray, "pBCharacterArray");
    // Add all passed objects.
    for (Character lNextObject : pBCharacterArray) {
      this.addToBCharacterArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bCharacterArray}.<br/>
   *
   * @param pBCharacterArray Object that should be removed from {@link #bCharacterArray}. The parameter must not be
   * null.
   */
  public void removeFromBCharacterArray( Character pBCharacterArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBCharacterArray, "pBCharacterArray");
    // Remove passed object from collection of associated Character objects.
    bCharacterArray.remove(pBCharacterArray);
  }

  /**
   * Method removes all objects from {@link #bCharacterArray}.
   */
  public void clearBCharacterArray( ) {
    // Remove all objects from association "bCharacterArray".
    bCharacterArray.clear();
  }

  /**
   * Method returns attribute {@link #aFloatArray}.<br/>
   *
   * @return float[] Value to which {@link #aFloatArray} is set.
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
   * @return {@link Set<Float>} Value to which {@link #bFloatArray} is set.
   */
  public Set<Float> getBFloatArray( ) {
    // Return all Float objects as unmodifiable collection.
    return Collections.unmodifiableSet(bFloatArray);
  }

  /**
   * Method adds the passed object to {@link #bFloatArray}.
   *
   * @param pBFloatArray Object that should be added to {@link #bFloatArray}. The parameter must not be null.
   */
  public void addToBFloatArray( Float pBFloatArray ) {
    // Check parameter "pBFloatArray" for invalid value null.
    Check.checkInvalidParameterNull(pBFloatArray, "pBFloatArray");
    // Add passed object to collection of associated Float objects.
    bFloatArray.add(pBFloatArray);
  }

  /**
   * Method adds all passed objects to {@link #bFloatArray}.
   *
   * @param pBFloatArray Collection with all objects that should be added to {@link #bFloatArray}. The parameter must
   * not be null.
   */
  public void addToBFloatArray( Collection<Float> pBFloatArray ) {
    // Check parameter "pBFloatArray" for invalid value null.
    Check.checkInvalidParameterNull(pBFloatArray, "pBFloatArray");
    // Add all passed objects.
    for (Float lNextObject : pBFloatArray) {
      this.addToBFloatArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bFloatArray}.<br/>
   *
   * @param pBFloatArray Object that should be removed from {@link #bFloatArray}. The parameter must not be null.
   */
  public void removeFromBFloatArray( Float pBFloatArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBFloatArray, "pBFloatArray");
    // Remove passed object from collection of associated Float objects.
    bFloatArray.remove(pBFloatArray);
  }

  /**
   * Method removes all objects from {@link #bFloatArray}.
   */
  public void clearBFloatArray( ) {
    // Remove all objects from association "bFloatArray".
    bFloatArray.clear();
  }

  /**
   * Method returns attribute {@link #aDoubleArray}.<br/>
   *
   * @return double[] Value to which {@link #aDoubleArray} is set.
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
   * @return {@link Set<Double>} Value to which {@link #bDoubleArray} is set.
   */
  public Set<Double> getBDoubleArray( ) {
    // Return all Double objects as unmodifiable collection.
    return Collections.unmodifiableSet(bDoubleArray);
  }

  /**
   * Method adds the passed object to {@link #bDoubleArray}.
   *
   * @param pBDoubleArray Object that should be added to {@link #bDoubleArray}. The parameter must not be null.
   */
  public void addToBDoubleArray( Double pBDoubleArray ) {
    // Check parameter "pBDoubleArray" for invalid value null.
    Check.checkInvalidParameterNull(pBDoubleArray, "pBDoubleArray");
    // Add passed object to collection of associated Double objects.
    bDoubleArray.add(pBDoubleArray);
  }

  /**
   * Method adds all passed objects to {@link #bDoubleArray}.
   *
   * @param pBDoubleArray Collection with all objects that should be added to {@link #bDoubleArray}. The parameter must
   * not be null.
   */
  public void addToBDoubleArray( Collection<Double> pBDoubleArray ) {
    // Check parameter "pBDoubleArray" for invalid value null.
    Check.checkInvalidParameterNull(pBDoubleArray, "pBDoubleArray");
    // Add all passed objects.
    for (Double lNextObject : pBDoubleArray) {
      this.addToBDoubleArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bDoubleArray}.<br/>
   *
   * @param pBDoubleArray Object that should be removed from {@link #bDoubleArray}. The parameter must not be null.
   */
  public void removeFromBDoubleArray( Double pBDoubleArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBDoubleArray, "pBDoubleArray");
    // Remove passed object from collection of associated Double objects.
    bDoubleArray.remove(pBDoubleArray);
  }

  /**
   * Method removes all objects from {@link #bDoubleArray}.
   */
  public void clearBDoubleArray( ) {
    // Remove all objects from association "bDoubleArray".
    bDoubleArray.clear();
  }

  /**
   * Method returns attribute {@link #aBigDecimalArray}.<br/>
   *
   * @return {@link Set<BigDecimal>} Value to which {@link #aBigDecimalArray} is set.
   */
  public Set<BigDecimal> getABigDecimalArray( ) {
    // Return all BigDecimal objects as unmodifiable collection.
    return Collections.unmodifiableSet(aBigDecimalArray);
  }

  /**
   * Method adds the passed object to {@link #aBigDecimalArray}.
   *
   * @param pABigDecimalArray Object that should be added to {@link #aBigDecimalArray}. The parameter must not be null.
   */
  public void addToABigDecimalArray( BigDecimal pABigDecimalArray ) {
    // Check parameter "pABigDecimalArray" for invalid value null.
    Check.checkInvalidParameterNull(pABigDecimalArray, "pABigDecimalArray");
    // Add passed object to collection of associated BigDecimal objects.
    aBigDecimalArray.add(pABigDecimalArray);
  }

  /**
   * Method adds all passed objects to {@link #aBigDecimalArray}.
   *
   * @param pABigDecimalArray Collection with all objects that should be added to {@link #aBigDecimalArray}. The
   * parameter must not be null.
   */
  public void addToABigDecimalArray( Collection<BigDecimal> pABigDecimalArray ) {
    // Check parameter "pABigDecimalArray" for invalid value null.
    Check.checkInvalidParameterNull(pABigDecimalArray, "pABigDecimalArray");
    // Add all passed objects.
    for (BigDecimal lNextObject : pABigDecimalArray) {
      this.addToABigDecimalArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #aBigDecimalArray}.<br/>
   *
   * @param pABigDecimalArray Object that should be removed from {@link #aBigDecimalArray}. The parameter must not be
   * null.
   */
  public void removeFromABigDecimalArray( BigDecimal pABigDecimalArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pABigDecimalArray, "pABigDecimalArray");
    // Remove passed object from collection of associated BigDecimal objects.
    aBigDecimalArray.remove(pABigDecimalArray);
  }

  /**
   * Method removes all objects from {@link #aBigDecimalArray}.
   */
  public void clearABigDecimalArray( ) {
    // Remove all objects from association "aBigDecimalArray".
    aBigDecimalArray.clear();
  }

  /**
   * Method returns attribute {@link #aStringArray}.<br/>
   *
   * @return {@link Set<String>} Value to which {@link #aStringArray} is set.
   */
  public Set<String> getAStringArray( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(aStringArray);
  }

  /**
   * Method adds the passed object to {@link #aStringArray}.
   *
   * @param pAStringArray Object that should be added to {@link #aStringArray}. The parameter must not be null.
   */
  public void addToAStringArray( String pAStringArray ) {
    // Check parameter "pAStringArray" for invalid value null.
    Check.checkInvalidParameterNull(pAStringArray, "pAStringArray");
    // Add passed object to collection of associated String objects.
    aStringArray.add(pAStringArray);
  }

  /**
   * Method adds all passed objects to {@link #aStringArray}.
   *
   * @param pAStringArray Collection with all objects that should be added to {@link #aStringArray}. The parameter must
   * not be null.
   */
  public void addToAStringArray( Collection<String> pAStringArray ) {
    // Check parameter "pAStringArray" for invalid value null.
    Check.checkInvalidParameterNull(pAStringArray, "pAStringArray");
    // Add all passed objects.
    for (String lNextObject : pAStringArray) {
      this.addToAStringArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #aStringArray}.<br/>
   *
   * @param pAStringArray Object that should be removed from {@link #aStringArray}. The parameter must not be null.
   */
  public void removeFromAStringArray( String pAStringArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAStringArray, "pAStringArray");
    // Remove passed object from collection of associated String objects.
    aStringArray.remove(pAStringArray);
  }

  /**
   * Method removes all objects from {@link #aStringArray}.
   */
  public void clearAStringArray( ) {
    // Remove all objects from association "aStringArray".
    aStringArray.clear();
  }

  /**
   * Method returns attribute {@link #bStringArray}.<br/>
   *
   * @return {@link Set<String>} Value to which {@link #bStringArray} is set.
   */
  public Set<String> getBStringArray( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(bStringArray);
  }

  /**
   * Method adds the passed object to {@link #bStringArray}.
   *
   * @param pBStringArray Object that should be added to {@link #bStringArray}. The parameter must not be null.
   */
  public void addToBStringArray( String pBStringArray ) {
    // Check parameter "pBStringArray" for invalid value null.
    Check.checkInvalidParameterNull(pBStringArray, "pBStringArray");
    // Add passed object to collection of associated String objects.
    bStringArray.add(pBStringArray);
  }

  /**
   * Method adds all passed objects to {@link #bStringArray}.
   *
   * @param pBStringArray Collection with all objects that should be added to {@link #bStringArray}. The parameter must
   * not be null.
   */
  public void addToBStringArray( Collection<String> pBStringArray ) {
    // Check parameter "pBStringArray" for invalid value null.
    Check.checkInvalidParameterNull(pBStringArray, "pBStringArray");
    // Add all passed objects.
    for (String lNextObject : pBStringArray) {
      this.addToBStringArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bStringArray}.<br/>
   *
   * @param pBStringArray Object that should be removed from {@link #bStringArray}. The parameter must not be null.
   */
  public void removeFromBStringArray( String pBStringArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBStringArray, "pBStringArray");
    // Remove passed object from collection of associated String objects.
    bStringArray.remove(pBStringArray);
  }

  /**
   * Method removes all objects from {@link #bStringArray}.
   */
  public void clearBStringArray( ) {
    // Remove all objects from association "bStringArray".
    bStringArray.clear();
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