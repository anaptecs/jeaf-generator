/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class PrimitiveObjectWithRestrictions extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "aBoolean".
   */
  @JEAFCustomAnnotationTest
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "bBoolean".
   */
  @JEAFCustomAnnotationTest
  public static final String BBOOLEAN = "bBoolean";

  /**
   * Constant for the name of attribute "cBoolean".
   */
  @JEAFCustomAnnotationTest
  public static final String CBOOLEAN = "cBoolean";

  /**
   * Constant for the name of attribute "aByte".
   */
  @JEAFCustomAnnotationTest
  public static final String ABYTE = "aByte";

  /**
   * Constant for the name of attribute "bByte".
   */
  @JEAFCustomAnnotationTest
  public static final String BBYTE = "bByte";

  /**
   * Constant for the name of attribute "aShort".
   */
  @JEAFCustomAnnotationTest
  public static final String ASHORT = "aShort";

  /**
   * Constant for the name of attribute "bShort".
   */
  @JEAFCustomAnnotationTest
  public static final String BSHORT = "bShort";

  /**
   * Constant for the name of attribute "aInteger".
   */
  @JEAFCustomAnnotationTest
  public static final String AINTEGER = "aInteger";

  /**
   * Constant for the name of attribute "bInteger".
   */
  @JEAFCustomAnnotationTest
  public static final String BINTEGER = "bInteger";

  /**
   * Constant for the name of attribute "cInteger".
   */
  @JEAFCustomAnnotationTest
  public static final String CINTEGER = "cInteger";

  /**
   * Constant for the name of attribute "aLong".
   */
  @JEAFCustomAnnotationTest
  public static final String ALONG = "aLong";

  /**
   * Constant for the name of attribute "bLong".
   */
  @JEAFCustomAnnotationTest
  public static final String BLONG = "bLong";

  /**
   * Constant for the name of attribute "aBigInteger".
   */
  @JEAFCustomAnnotationTest
  public static final String ABIGINTEGER = "aBigInteger";

  /**
   * Constant for the name of attribute "aCharacter".
   */
  @JEAFCustomAnnotationTest
  public static final String ACHARACTER = "aCharacter";

  /**
   * Constant for the name of attribute "bCharacter".
   */
  @JEAFCustomAnnotationTest
  public static final String BCHARACTER = "bCharacter";

  /**
   * Constant for the name of attribute "aFloat".
   */
  @JEAFCustomAnnotationTest
  public static final String AFLOAT = "aFloat";

  /**
   * Constant for the name of attribute "bFloat".
   */
  @JEAFCustomAnnotationTest
  public static final String BFLOAT = "bFloat";

  /**
   * Constant for the name of attribute "aDouble".
   */
  @JEAFCustomAnnotationTest
  public static final String ADOUBLE = "aDouble";

  /**
   * Constant for the name of attribute "bDouble".
   */
  @JEAFCustomAnnotationTest
  public static final String BDOUBLE = "bDouble";

  /**
   * Constant for the name of attribute "aBigDecimal".
   */
  @JEAFCustomAnnotationTest
  public static final String ABIGDECIMAL = "aBigDecimal";

  /**
   * Constant for the name of attribute "aString".
   */
  @JEAFCustomAnnotationTest
  public static final String ASTRING = "aString";

  /**
   * Constant for the name of attribute "bString".
   */
  @JEAFCustomAnnotationTest
  public static final String BSTRING = "bString";

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  // "boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private boolean aBoolean;

  // "boolean"
  private int aBooleanXYZ = 0;

  // "java.lang.Boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Boolean bBoolean;

  // "java.lang.Boolean"
  private int bBooleanXYZ = 0;

  // "boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private boolean cBoolean;

  // "boolean"
  private int cBooleanXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Negative
  private byte aByte;

  // "byte"
  private int aByteXYZ = 0;

  // "java.lang.Byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @NegativeOrZero
  private Byte bByte;

  // "java.lang.Byte"
  private int bByteXYZ = 0;

  // "short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Min(value = -237)
  private short aShort;

  // "short"
  private int aShortXYZ = 0;

  // "java.lang.Short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Positive
  private Short bShort;

  // "java.lang.Short"
  private int bShortXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @PositiveOrZero
  private int aInteger;

  // "int"
  private int aIntegerXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Min(value = 4711)
  private Integer bInteger;

  // "java.lang.Integer"
  private int bIntegerXYZ = 0;

  // "Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Min(value = 100)
  @Max(value = 1000)
  private Integer cInteger;

  // "Integer"
  private int cIntegerXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private long aLong;

  // "long"
  private int aLongXYZ = 0;

  // "java.lang.Long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @DecimalMax(value = "299792458", inclusive = false)
  private Long bLong;

  // "java.lang.Long"
  private int bLongXYZ = 0;

  // "java.math.BigInteger"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @DecimalMax(value = "3.14159265359", inclusive = true)
  @DecimalMin(value = "-3.14159265359", inclusive = true)
  private BigInteger aBigInteger;

  // "java.math.BigInteger"
  private int aBigIntegerXYZ = 0;

  // "char"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private char aCharacter;

  // "char"
  private int aCharacterXYZ = 0;

  // "java.lang.Character"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Character bCharacter;

  // "java.lang.Character"
  private int bCharacterXYZ = 0;

  // "float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private float aFloat;

  // "float"
  private int aFloatXYZ = 0;

  // "java.lang.Float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Float bFloat;

  // "java.lang.Float"
  private int bFloatXYZ = 0;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42.0</code>
   */
  // "double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private double aDouble;

  // "double"
  private int aDoubleXYZ = 0;

  // "java.lang.Double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Double bDouble;

  // "java.lang.Double"
  private int bDoubleXYZ = 0;

  // "java.math.BigDecimal"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @DecimalMin(value = "4711.0815", inclusive = true)
  private BigDecimal aBigDecimal;

  // "java.math.BigDecimal"
  private int aBigDecimalXYZ = 0;

  /**
   * <br/>
   * <b>Default Value:</b> <code>"Hello OpenAPI"</code>
   */
  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Size(min = 8, max = 32)
  private String aString;

  // "String"
  private int aStringXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @NotEmpty
  @Size(min = 0, max = 128)
  private String bString;

  // "String"
  private int bStringXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveObjectWithRestrictions( ) {
    aBoolean = true;
    aDouble = 42.0;
    aString = "Hello OpenAPI";
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveObjectWithRestrictions( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    // "boolean"
    aBooleanXYZ = pBuilder.aBooleanXYZ;
    bBoolean = pBuilder.bBoolean;
    // "java.lang.Boolean"
    bBooleanXYZ = pBuilder.bBooleanXYZ;
    cBoolean = pBuilder.cBoolean;
    // "boolean"
    cBooleanXYZ = pBuilder.cBooleanXYZ;
    aByte = pBuilder.aByte;
    // "byte"
    aByteXYZ = pBuilder.aByteXYZ;
    bByte = pBuilder.bByte;
    // "java.lang.Byte"
    bByteXYZ = pBuilder.bByteXYZ;
    aShort = pBuilder.aShort;
    // "short"
    aShortXYZ = pBuilder.aShortXYZ;
    bShort = pBuilder.bShort;
    // "java.lang.Short"
    bShortXYZ = pBuilder.bShortXYZ;
    aInteger = pBuilder.aInteger;
    // "int"
    aIntegerXYZ = pBuilder.aIntegerXYZ;
    bInteger = pBuilder.bInteger;
    // "java.lang.Integer"
    bIntegerXYZ = pBuilder.bIntegerXYZ;
    cInteger = pBuilder.cInteger;
    // "Integer"
    cIntegerXYZ = pBuilder.cIntegerXYZ;
    aLong = pBuilder.aLong;
    // "long"
    aLongXYZ = pBuilder.aLongXYZ;
    bLong = pBuilder.bLong;
    // "java.lang.Long"
    bLongXYZ = pBuilder.bLongXYZ;
    aBigInteger = pBuilder.aBigInteger;
    // "java.math.BigInteger"
    aBigIntegerXYZ = pBuilder.aBigIntegerXYZ;
    aCharacter = pBuilder.aCharacter;
    // "char"
    aCharacterXYZ = pBuilder.aCharacterXYZ;
    bCharacter = pBuilder.bCharacter;
    // "java.lang.Character"
    bCharacterXYZ = pBuilder.bCharacterXYZ;
    aFloat = pBuilder.aFloat;
    // "float"
    aFloatXYZ = pBuilder.aFloatXYZ;
    bFloat = pBuilder.bFloat;
    // "java.lang.Float"
    bFloatXYZ = pBuilder.bFloatXYZ;
    aDouble = pBuilder.aDouble;
    // "double"
    aDoubleXYZ = pBuilder.aDoubleXYZ;
    bDouble = pBuilder.bDouble;
    // "java.lang.Double"
    bDoubleXYZ = pBuilder.bDoubleXYZ;
    aBigDecimal = pBuilder.aBigDecimal;
    // "java.math.BigDecimal"
    aBigDecimalXYZ = pBuilder.aBigDecimalXYZ;
    aString = pBuilder.aString;
    // "String"
    aStringXYZ = pBuilder.aStringXYZ;
    bString = pBuilder.bString;
    // "String"
    bStringXYZ = pBuilder.bStringXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PrimitiveObjectWithRestrictions objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveObjectWithRestrictions</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    /**
     * <br/>
     * <b>Default Value:</b> <code>true</code>
     */
    // "boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private boolean aBoolean = true;

    // "boolean"
    private int aBooleanXYZ = 0;

    // "java.lang.Boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Boolean bBoolean;

    // "java.lang.Boolean"
    private int bBooleanXYZ = 0;

    // "boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private boolean cBoolean;

    // "boolean"
    private int cBooleanXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Negative
    private byte aByte;

    // "byte"
    private int aByteXYZ = 0;

    // "java.lang.Byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @NegativeOrZero
    private Byte bByte;

    // "java.lang.Byte"
    private int bByteXYZ = 0;

    // "short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Min(value = -237)
    private short aShort;

    // "short"
    private int aShortXYZ = 0;

    // "java.lang.Short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Positive
    private Short bShort;

    // "java.lang.Short"
    private int bShortXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @PositiveOrZero
    private int aInteger;

    // "int"
    private int aIntegerXYZ = 0;

    // "java.lang.Integer"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Min(value = 4711)
    private Integer bInteger;

    // "java.lang.Integer"
    private int bIntegerXYZ = 0;

    // "Integer"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Min(value = 100)
    @Max(value = 1000)
    private Integer cInteger;

    // "Integer"
    private int cIntegerXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private long aLong;

    // "long"
    private int aLongXYZ = 0;

    // "java.lang.Long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @DecimalMax(value = "299792458", inclusive = false)
    private Long bLong;

    // "java.lang.Long"
    private int bLongXYZ = 0;

    // "java.math.BigInteger"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @DecimalMax(value = "3.14159265359", inclusive = true)
    @DecimalMin(value = "-3.14159265359", inclusive = true)
    private BigInteger aBigInteger;

    // "java.math.BigInteger"
    private int aBigIntegerXYZ = 0;

    // "char"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private char aCharacter;

    // "char"
    private int aCharacterXYZ = 0;

    // "java.lang.Character"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Character bCharacter;

    // "java.lang.Character"
    private int bCharacterXYZ = 0;

    // "float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private float aFloat;

    // "float"
    private int aFloatXYZ = 0;

    // "java.lang.Float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Float bFloat;

    // "java.lang.Float"
    private int bFloatXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>42.0</code>
     */
    // "double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private double aDouble = 42.0;

    // "double"
    private int aDoubleXYZ = 0;

    // "java.lang.Double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Double bDouble;

    // "java.lang.Double"
    private int bDoubleXYZ = 0;

    // "java.math.BigDecimal"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @DecimalMin(value = "4711.0815", inclusive = true)
    private BigDecimal aBigDecimal;

    // "java.math.BigDecimal"
    private int aBigDecimalXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>"Hello OpenAPI"</code>
     */
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Size(min = 8, max = 32)
    private String aString = "Hello OpenAPI";

    // "String"
    private int aStringXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @NotEmpty
    @Size(min = 0, max = 128)
    private String bString;

    // "String"
    private int bStringXYZ = 0;

    /**
     * Use {@link PrimitiveObjectWithRestrictions#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveObjectWithRestrictions#builder(PrimitiveObjectWithRestrictions)} instead of private
     * constructor to create new builder.
     */
    protected Builder( PrimitiveObjectWithRestrictions pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setABoolean(pObject.aBoolean);
        this.setBBoolean(pObject.bBoolean);
        this.setCBoolean(pObject.cBoolean);
        this.setAByte(pObject.aByte);
        this.setBByte(pObject.bByte);
        this.setAShort(pObject.aShort);
        this.setBShort(pObject.bShort);
        this.setAInteger(pObject.aInteger);
        this.setBInteger(pObject.bInteger);
        this.setCInteger(pObject.cInteger);
        this.setALong(pObject.aLong);
        this.setBLong(pObject.bLong);
        this.setABigInteger(pObject.aBigInteger);
        this.setACharacter(pObject.aCharacter);
        this.setBCharacter(pObject.bCharacter);
        this.setAFloat(pObject.aFloat);
        this.setBFloat(pObject.bFloat);
        this.setADouble(pObject.aDouble);
        this.setBDouble(pObject.bDouble);
        this.setABigDecimal(pObject.aBigDecimal);
        this.setAString(pObject.aString);
        this.setBString(pObject.bString);
      }
    }

    /**
     * Method sets attribute {@link #aBoolean}.<br/>
     *
     * @param pABoolean Value to which {@link #aBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    public Builder setABooleanXYZ( int value ) {
      // "boolean"
      aBooleanXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bBoolean}.<br/>
     *
     * @param pBBoolean Value to which {@link #bBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBBoolean( Boolean pBBoolean ) {
      // Assign value to attribute
      bBoolean = pBBoolean;
      return this;
    }

    public Builder setBBooleanXYZ( int value ) {
      // "java.lang.Boolean"
      bBooleanXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #cBoolean}.<br/>
     *
     * @param pCBoolean Value to which {@link #cBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setCBoolean( boolean pCBoolean ) {
      // Assign value to attribute
      cBoolean = pCBoolean;
      return this;
    }

    public Builder setCBooleanXYZ( int value ) {
      // "boolean"
      cBooleanXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aByte}.<br/>
     *
     * @param pAByte Value to which {@link #aByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAByte( byte pAByte ) {
      // Assign value to attribute
      aByte = pAByte;
      return this;
    }

    public Builder setAByteXYZ( int value ) {
      // "byte"
      aByteXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bByte}.<br/>
     *
     * @param pBByte Value to which {@link #bByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBByte( Byte pBByte ) {
      // Assign value to attribute
      bByte = pBByte;
      return this;
    }

    public Builder setBByteXYZ( int value ) {
      // "java.lang.Byte"
      bByteXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aShort}.<br/>
     *
     * @param pAShort Value to which {@link #aShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAShort( short pAShort ) {
      // Assign value to attribute
      aShort = pAShort;
      return this;
    }

    public Builder setAShortXYZ( int value ) {
      // "short"
      aShortXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bShort}.<br/>
     *
     * @param pBShort Value to which {@link #bShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBShort( Short pBShort ) {
      // Assign value to attribute
      bShort = pBShort;
      return this;
    }

    public Builder setBShortXYZ( int value ) {
      // "java.lang.Short"
      bShortXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aInteger}.<br/>
     *
     * @param pAInteger Value to which {@link #aInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAInteger( int pAInteger ) {
      // Assign value to attribute
      aInteger = pAInteger;
      return this;
    }

    public Builder setAIntegerXYZ( int value ) {
      // "int"
      aIntegerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bInteger}.<br/>
     *
     * @param pBInteger Value to which {@link #bInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBInteger( Integer pBInteger ) {
      // Assign value to attribute
      bInteger = pBInteger;
      return this;
    }

    public Builder setBIntegerXYZ( int value ) {
      // "java.lang.Integer"
      bIntegerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #cInteger}.<br/>
     *
     * @param pCInteger Value to which {@link #cInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setCInteger( Integer pCInteger ) {
      // Assign value to attribute
      cInteger = pCInteger;
      return this;
    }

    public Builder setCIntegerXYZ( int value ) {
      // "Integer"
      cIntegerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aLong}.<br/>
     *
     * @param pALong Value to which {@link #aLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setALong( long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this;
    }

    public Builder setALongXYZ( int value ) {
      // "long"
      aLongXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bLong}.<br/>
     *
     * @param pBLong Value to which {@link #bLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBLong( Long pBLong ) {
      // Assign value to attribute
      bLong = pBLong;
      return this;
    }

    public Builder setBLongXYZ( int value ) {
      // "java.lang.Long"
      bLongXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aBigInteger}.<br/>
     *
     * @param pABigInteger Value to which {@link #aBigInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setABigInteger( BigInteger pABigInteger ) {
      // Assign value to attribute
      aBigInteger = pABigInteger;
      return this;
    }

    public Builder setABigIntegerXYZ( int value ) {
      // "java.math.BigInteger"
      aBigIntegerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aCharacter}.<br/>
     *
     * @param pACharacter Value to which {@link #aCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setACharacter( char pACharacter ) {
      // Assign value to attribute
      aCharacter = pACharacter;
      return this;
    }

    public Builder setACharacterXYZ( int value ) {
      // "char"
      aCharacterXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bCharacter}.<br/>
     *
     * @param pBCharacter Value to which {@link #bCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBCharacter( Character pBCharacter ) {
      // Assign value to attribute
      bCharacter = pBCharacter;
      return this;
    }

    public Builder setBCharacterXYZ( int value ) {
      // "java.lang.Character"
      bCharacterXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aFloat}.<br/>
     *
     * @param pAFloat Value to which {@link #aFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAFloat( float pAFloat ) {
      // Assign value to attribute
      aFloat = pAFloat;
      return this;
    }

    public Builder setAFloatXYZ( int value ) {
      // "float"
      aFloatXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bFloat}.<br/>
     *
     * @param pBFloat Value to which {@link #bFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBFloat( Float pBFloat ) {
      // Assign value to attribute
      bFloat = pBFloat;
      return this;
    }

    public Builder setBFloatXYZ( int value ) {
      // "java.lang.Float"
      bFloatXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aDouble}.<br/>
     *
     * @param pADouble Value to which {@link #aDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setADouble( double pADouble ) {
      // Assign value to attribute
      aDouble = pADouble;
      return this;
    }

    public Builder setADoubleXYZ( int value ) {
      // "double"
      aDoubleXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bDouble}.<br/>
     *
     * @param pBDouble Value to which {@link #bDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBDouble( Double pBDouble ) {
      // Assign value to attribute
      bDouble = pBDouble;
      return this;
    }

    public Builder setBDoubleXYZ( int value ) {
      // "java.lang.Double"
      bDoubleXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aBigDecimal}.<br/>
     *
     * @param pABigDecimal Value to which {@link #aBigDecimal} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setABigDecimal( BigDecimal pABigDecimal ) {
      // Assign value to attribute
      aBigDecimal = pABigDecimal;
      return this;
    }

    public Builder setABigDecimalXYZ( int value ) {
      // "java.math.BigDecimal"
      aBigDecimalXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #aString}.<br/>
     *
     * @param pAString Value to which {@link #aString} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAString( String pAString ) {
      // Assign value to attribute
      aString = pAString;
      return this;
    }

    public Builder setAStringXYZ( int value ) {
      // "String"
      aStringXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bString}.<br/>
     *
     * @param pBString Value to which {@link #bString} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBString( String pBString ) {
      // Assign value to attribute
      bString = pBString;
      return this;
    }

    public Builder setBStringXYZ( int value ) {
      // "String"
      bStringXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class PrimitiveObjectWithRestrictions. The object will be initialized with the
     * values of the builder.
     *
     * @return PrimitiveObjectWithRestrictions Created object. The method never returns null.
     */
    public PrimitiveObjectWithRestrictions build( ) {
      return new PrimitiveObjectWithRestrictions(this);
    }

    /**
     * Method creates a new validated instance of class PrimitiveObjectWithRestrictions. The object will be initialized
     * with the values of the builder and validated afterwards.
     *
     * @return PrimitiveObjectWithRestrictions Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrimitiveObjectWithRestrictions buildValidated( ) throws ConstraintViolationException {
      PrimitiveObjectWithRestrictions lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  public boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public boolean isABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets attribute {@link #aBoolean}.<br/>
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setABoolean( boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  public int getABooleanXYZ( ) {
    // "boolean"
    return aBooleanXYZ;
  }

  public void setABooleanXYZ( int value ) {
    aBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #bBoolean}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #bBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public Boolean getBBoolean( ) {
    return bBoolean;
  }

  /**
   * Method sets attribute {@link #bBoolean}.<br/>
   *
   * @param pBBoolean Value to which {@link #bBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBBoolean( Boolean pBBoolean ) {
    // Assign value to attribute
    bBoolean = pBBoolean;
  }

  public int getBBooleanXYZ( ) {
    // "java.lang.Boolean"
    return bBooleanXYZ;
  }

  public void setBBooleanXYZ( int value ) {
    bBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #cBoolean}.<br/>
   *
   * @return boolean Value to which {@link #cBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  public boolean getCBoolean( ) {
    return cBoolean;
  }

  /**
   * Method returns attribute {@link #cBoolean}.<br/>
   *
   * @return boolean Value to which {@link #cBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public boolean isCBoolean( ) {
    return cBoolean;
  }

  /**
   * Method sets attribute {@link #cBoolean}.<br/>
   *
   * @param pCBoolean Value to which {@link #cBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setCBoolean( boolean pCBoolean ) {
    // Assign value to attribute
    cBoolean = pCBoolean;
  }

  public int getCBooleanXYZ( ) {
    // "boolean"
    return cBooleanXYZ;
  }

  public void setCBooleanXYZ( int value ) {
    cBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #aByte}.<br/>
   *
   * @return byte Value to which {@link #aByte} is set.
   */
  @JEAFCustomAnnotationTest
  public byte getAByte( ) {
    return aByte;
  }

  /**
   * Method sets attribute {@link #aByte}.<br/>
   *
   * @param pAByte Value to which {@link #aByte} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAByte( byte pAByte ) {
    // Assign value to attribute
    aByte = pAByte;
  }

  public int getAByteXYZ( ) {
    // "byte"
    return aByteXYZ;
  }

  public void setAByteXYZ( int value ) {
    aByteXYZ = value;
  }

  /**
   * Method returns attribute {@link #bByte}.<br/>
   *
   * @return {@link Byte} Value to which {@link #bByte} is set.
   */
  @JEAFCustomAnnotationTest
  public Byte getBByte( ) {
    return bByte;
  }

  /**
   * Method sets attribute {@link #bByte}.<br/>
   *
   * @param pBByte Value to which {@link #bByte} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBByte( Byte pBByte ) {
    // Assign value to attribute
    bByte = pBByte;
  }

  public int getBByteXYZ( ) {
    // "java.lang.Byte"
    return bByteXYZ;
  }

  public void setBByteXYZ( int value ) {
    bByteXYZ = value;
  }

  /**
   * Method returns attribute {@link #aShort}.<br/>
   *
   * @return short Value to which {@link #aShort} is set.
   */
  @JEAFCustomAnnotationTest
  public short getAShort( ) {
    return aShort;
  }

  /**
   * Method sets attribute {@link #aShort}.<br/>
   *
   * @param pAShort Value to which {@link #aShort} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAShort( short pAShort ) {
    // Assign value to attribute
    aShort = pAShort;
  }

  public int getAShortXYZ( ) {
    // "short"
    return aShortXYZ;
  }

  public void setAShortXYZ( int value ) {
    aShortXYZ = value;
  }

  /**
   * Method returns attribute {@link #bShort}.<br/>
   *
   * @return {@link Short} Value to which {@link #bShort} is set.
   */
  @JEAFCustomAnnotationTest
  public Short getBShort( ) {
    return bShort;
  }

  /**
   * Method sets attribute {@link #bShort}.<br/>
   *
   * @param pBShort Value to which {@link #bShort} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBShort( Short pBShort ) {
    // Assign value to attribute
    bShort = pBShort;
  }

  public int getBShortXYZ( ) {
    // "java.lang.Short"
    return bShortXYZ;
  }

  public void setBShortXYZ( int value ) {
    bShortXYZ = value;
  }

  /**
   * Method returns attribute {@link #aInteger}.<br/>
   *
   * @return int Value to which {@link #aInteger} is set.
   */
  @JEAFCustomAnnotationTest
  public int getAInteger( ) {
    return aInteger;
  }

  /**
   * Method sets attribute {@link #aInteger}.<br/>
   *
   * @param pAInteger Value to which {@link #aInteger} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAInteger( int pAInteger ) {
    // Assign value to attribute
    aInteger = pAInteger;
  }

  public int getAIntegerXYZ( ) {
    // "int"
    return aIntegerXYZ;
  }

  public void setAIntegerXYZ( int value ) {
    aIntegerXYZ = value;
  }

  /**
   * Method returns attribute {@link #bInteger}.<br/>
   *
   * @return {@link Integer} Value to which {@link #bInteger} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getBInteger( ) {
    return bInteger;
  }

  /**
   * Method sets attribute {@link #bInteger}.<br/>
   *
   * @param pBInteger Value to which {@link #bInteger} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBInteger( Integer pBInteger ) {
    // Assign value to attribute
    bInteger = pBInteger;
  }

  public int getBIntegerXYZ( ) {
    // "java.lang.Integer"
    return bIntegerXYZ;
  }

  public void setBIntegerXYZ( int value ) {
    bIntegerXYZ = value;
  }

  /**
   * Method returns attribute {@link #cInteger}.<br/>
   *
   * @return {@link Integer} Value to which {@link #cInteger} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getCInteger( ) {
    return cInteger;
  }

  /**
   * Method sets attribute {@link #cInteger}.<br/>
   *
   * @param pCInteger Value to which {@link #cInteger} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setCInteger( Integer pCInteger ) {
    // Assign value to attribute
    cInteger = pCInteger;
  }

  public int getCIntegerXYZ( ) {
    // "Integer"
    return cIntegerXYZ;
  }

  public void setCIntegerXYZ( int value ) {
    cIntegerXYZ = value;
  }

  /**
   * Method returns attribute {@link #aLong}.<br/>
   *
   * @return long Value to which {@link #aLong} is set.
   */
  @JEAFCustomAnnotationTest
  public long getALong( ) {
    return aLong;
  }

  /**
   * Method sets attribute {@link #aLong}.<br/>
   *
   * @param pALong Value to which {@link #aLong} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setALong( long pALong ) {
    // Assign value to attribute
    aLong = pALong;
  }

  public int getALongXYZ( ) {
    // "long"
    return aLongXYZ;
  }

  public void setALongXYZ( int value ) {
    aLongXYZ = value;
  }

  /**
   * Method returns attribute {@link #bLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #bLong} is set.
   */
  @JEAFCustomAnnotationTest
  public Long getBLong( ) {
    return bLong;
  }

  /**
   * Method sets attribute {@link #bLong}.<br/>
   *
   * @param pBLong Value to which {@link #bLong} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBLong( Long pBLong ) {
    // Assign value to attribute
    bLong = pBLong;
  }

  public int getBLongXYZ( ) {
    // "java.lang.Long"
    return bLongXYZ;
  }

  public void setBLongXYZ( int value ) {
    bLongXYZ = value;
  }

  /**
   * Method returns attribute {@link #aBigInteger}.<br/>
   *
   * @return {@link BigInteger} Value to which {@link #aBigInteger} is set.
   */
  @JEAFCustomAnnotationTest
  public BigInteger getABigInteger( ) {
    return aBigInteger;
  }

  /**
   * Method sets attribute {@link #aBigInteger}.<br/>
   *
   * @param pABigInteger Value to which {@link #aBigInteger} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setABigInteger( BigInteger pABigInteger ) {
    // Assign value to attribute
    aBigInteger = pABigInteger;
  }

  public int getABigIntegerXYZ( ) {
    // "java.math.BigInteger"
    return aBigIntegerXYZ;
  }

  public void setABigIntegerXYZ( int value ) {
    aBigIntegerXYZ = value;
  }

  /**
   * Method returns attribute {@link #aCharacter}.<br/>
   *
   * @return char Value to which {@link #aCharacter} is set.
   */
  @JEAFCustomAnnotationTest
  public char getACharacter( ) {
    return aCharacter;
  }

  /**
   * Method sets attribute {@link #aCharacter}.<br/>
   *
   * @param pACharacter Value to which {@link #aCharacter} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setACharacter( char pACharacter ) {
    // Assign value to attribute
    aCharacter = pACharacter;
  }

  public int getACharacterXYZ( ) {
    // "char"
    return aCharacterXYZ;
  }

  public void setACharacterXYZ( int value ) {
    aCharacterXYZ = value;
  }

  /**
   * Method returns attribute {@link #bCharacter}.<br/>
   *
   * @return {@link Character} Value to which {@link #bCharacter} is set.
   */
  @JEAFCustomAnnotationTest
  public Character getBCharacter( ) {
    return bCharacter;
  }

  /**
   * Method sets attribute {@link #bCharacter}.<br/>
   *
   * @param pBCharacter Value to which {@link #bCharacter} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBCharacter( Character pBCharacter ) {
    // Assign value to attribute
    bCharacter = pBCharacter;
  }

  public int getBCharacterXYZ( ) {
    // "java.lang.Character"
    return bCharacterXYZ;
  }

  public void setBCharacterXYZ( int value ) {
    bCharacterXYZ = value;
  }

  /**
   * Method returns attribute {@link #aFloat}.<br/>
   *
   * @return float Value to which {@link #aFloat} is set.
   */
  @JEAFCustomAnnotationTest
  public float getAFloat( ) {
    return aFloat;
  }

  /**
   * Method sets attribute {@link #aFloat}.<br/>
   *
   * @param pAFloat Value to which {@link #aFloat} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAFloat( float pAFloat ) {
    // Assign value to attribute
    aFloat = pAFloat;
  }

  public int getAFloatXYZ( ) {
    // "float"
    return aFloatXYZ;
  }

  public void setAFloatXYZ( int value ) {
    aFloatXYZ = value;
  }

  /**
   * Method returns attribute {@link #bFloat}.<br/>
   *
   * @return {@link Float} Value to which {@link #bFloat} is set.
   */
  @JEAFCustomAnnotationTest
  public Float getBFloat( ) {
    return bFloat;
  }

  /**
   * Method sets attribute {@link #bFloat}.<br/>
   *
   * @param pBFloat Value to which {@link #bFloat} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBFloat( Float pBFloat ) {
    // Assign value to attribute
    bFloat = pBFloat;
  }

  public int getBFloatXYZ( ) {
    // "java.lang.Float"
    return bFloatXYZ;
  }

  public void setBFloatXYZ( int value ) {
    bFloatXYZ = value;
  }

  /**
   * Method returns attribute {@link #aDouble}.<br/>
   *
   * @return double Value to which {@link #aDouble} is set.
   */
  @JEAFCustomAnnotationTest
  public double getADouble( ) {
    return aDouble;
  }

  /**
   * Method sets attribute {@link #aDouble}.<br/>
   *
   * @param pADouble Value to which {@link #aDouble} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setADouble( double pADouble ) {
    // Assign value to attribute
    aDouble = pADouble;
  }

  public int getADoubleXYZ( ) {
    // "double"
    return aDoubleXYZ;
  }

  public void setADoubleXYZ( int value ) {
    aDoubleXYZ = value;
  }

  /**
   * Method returns attribute {@link #bDouble}.<br/>
   *
   * @return {@link Double} Value to which {@link #bDouble} is set.
   */
  @JEAFCustomAnnotationTest
  public Double getBDouble( ) {
    return bDouble;
  }

  /**
   * Method sets attribute {@link #bDouble}.<br/>
   *
   * @param pBDouble Value to which {@link #bDouble} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBDouble( Double pBDouble ) {
    // Assign value to attribute
    bDouble = pBDouble;
  }

  public int getBDoubleXYZ( ) {
    // "java.lang.Double"
    return bDoubleXYZ;
  }

  public void setBDoubleXYZ( int value ) {
    bDoubleXYZ = value;
  }

  /**
   * Method returns attribute {@link #aBigDecimal}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #aBigDecimal} is set.
   */
  @JEAFCustomAnnotationTest
  public BigDecimal getABigDecimal( ) {
    return aBigDecimal;
  }

  /**
   * Method sets attribute {@link #aBigDecimal}.<br/>
   *
   * @param pABigDecimal Value to which {@link #aBigDecimal} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setABigDecimal( BigDecimal pABigDecimal ) {
    // Assign value to attribute
    aBigDecimal = pABigDecimal;
  }

  public int getABigDecimalXYZ( ) {
    // "java.math.BigDecimal"
    return aBigDecimalXYZ;
  }

  public void setABigDecimalXYZ( int value ) {
    aBigDecimalXYZ = value;
  }

  /**
   * Method returns attribute {@link #aString}.<br/>
   *
   * @return {@link String} Value to which {@link #aString} is set.
   */
  @JEAFCustomAnnotationTest
  public String getAString( ) {
    return aString;
  }

  /**
   * Method sets attribute {@link #aString}.<br/>
   *
   * @param pAString Value to which {@link #aString} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAString( String pAString ) {
    // Assign value to attribute
    aString = pAString;
  }

  public int getAStringXYZ( ) {
    // "String"
    return aStringXYZ;
  }

  public void setAStringXYZ( int value ) {
    aStringXYZ = value;
  }

  /**
   * Method returns attribute {@link #bString}.<br/>
   *
   * @return {@link String} Value to which {@link #bString} is set.
   */
  @JEAFCustomAnnotationTest
  public String getBString( ) {
    return bString;
  }

  /**
   * Method sets attribute {@link #bString}.<br/>
   *
   * @param pBString Value to which {@link #bString} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setBString( String pBString ) {
    // Assign value to attribute
    bString = pBString;
  }

  public int getBStringXYZ( ) {
    // "String"
    return bStringXYZ;
  }

  public void setBStringXYZ( int value ) {
    bStringXYZ = value;
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
    lBuilder.append(pIndent);
    lBuilder.append("aBoolean: ");
    lBuilder.append(aBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bBoolean: ");
    lBuilder.append(bBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("cBoolean: ");
    lBuilder.append(cBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aByte: ");
    lBuilder.append(aByte);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bByte: ");
    lBuilder.append(bByte);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aShort: ");
    lBuilder.append(aShort);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bShort: ");
    lBuilder.append(bShort);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aInteger: ");
    lBuilder.append(aInteger);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bInteger: ");
    lBuilder.append(bInteger);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("cInteger: ");
    lBuilder.append(cInteger);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aLong: ");
    lBuilder.append(aLong);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bLong: ");
    lBuilder.append(bLong);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aBigInteger: ");
    lBuilder.append(aBigInteger);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aCharacter: ");
    lBuilder.append(aCharacter);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bCharacter: ");
    lBuilder.append(bCharacter);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aFloat: ");
    lBuilder.append(aFloat);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bFloat: ");
    lBuilder.append(bFloat);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aDouble: ");
    lBuilder.append(aDouble);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bDouble: ");
    lBuilder.append(bDouble);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aBigDecimal: ");
    lBuilder.append(aBigDecimal);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aString: ");
    lBuilder.append(aString);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bString: ");
    lBuilder.append(bString);
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
   * @return {@link Builder} New builder that can be used to create new PrimitiveObjectWithRestrictions objects. The
   * method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}