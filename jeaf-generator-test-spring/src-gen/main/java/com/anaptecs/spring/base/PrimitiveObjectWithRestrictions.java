/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

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

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class PrimitiveObjectWithRestrictions {
  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "bBoolean".
   */
  public static final String BBOOLEAN = "bBoolean";

  /**
   * Constant for the name of attribute "cBoolean".
   */
  public static final String CBOOLEAN = "cBoolean";

  /**
   * Constant for the name of attribute "aByte".
   */
  public static final String ABYTE = "aByte";

  /**
   * Constant for the name of attribute "bByte".
   */
  public static final String BBYTE = "bByte";

  /**
   * Constant for the name of attribute "aShort".
   */
  public static final String ASHORT = "aShort";

  /**
   * Constant for the name of attribute "bShort".
   */
  public static final String BSHORT = "bShort";

  /**
   * Constant for the name of attribute "aInteger".
   */
  public static final String AINTEGER = "aInteger";

  /**
   * Constant for the name of attribute "bInteger".
   */
  public static final String BINTEGER = "bInteger";

  /**
   * Constant for the name of attribute "cInteger".
   */
  public static final String CINTEGER = "cInteger";

  /**
   * Constant for the name of attribute "aLong".
   */
  public static final String ALONG = "aLong";

  /**
   * Constant for the name of attribute "bLong".
   */
  public static final String BLONG = "bLong";

  /**
   * Constant for the name of attribute "aBigInteger".
   */
  public static final String ABIGINTEGER = "aBigInteger";

  /**
   * Constant for the name of attribute "aCharacter".
   */
  public static final String ACHARACTER = "aCharacter";

  /**
   * Constant for the name of attribute "bCharacter".
   */
  public static final String BCHARACTER = "bCharacter";

  /**
   * Constant for the name of attribute "aFloat".
   */
  public static final String AFLOAT = "aFloat";

  /**
   * Constant for the name of attribute "bFloat".
   */
  public static final String BFLOAT = "bFloat";

  /**
   * Constant for the name of attribute "aDouble".
   */
  public static final String ADOUBLE = "aDouble";

  /**
   * Constant for the name of attribute "bDouble".
   */
  public static final String BDOUBLE = "bDouble";

  /**
   * Constant for the name of attribute "aBigDecimal".
   */
  public static final String ABIGDECIMAL = "aBigDecimal";

  /**
   * Constant for the name of attribute "aString".
   */
  public static final String ASTRING = "aString";

  /**
   * Constant for the name of attribute "bString".
   */
  public static final String BSTRING = "bString";

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private boolean aBoolean;

  private Boolean bBoolean;

  private boolean cBoolean;

  @Negative
  private byte aByte;

  @NegativeOrZero
  private Byte bByte;

  @Min(value = -237)
  private short aShort;

  @Positive
  private Short bShort;

  @PositiveOrZero
  private int aInteger;

  @Min(value = 4711)
  private Integer bInteger;

  @Min(value = 100)
  @Max(value = 1000)
  private Integer cInteger;

  private long aLong;

  @DecimalMax(value = "299792458", inclusive = false)
  private Long bLong;

  @DecimalMax(value = "3.14159265359", inclusive = true)
  @DecimalMin(value = "-3.14159265359", inclusive = true)
  private BigInteger aBigInteger;

  private char aCharacter;

  private Character bCharacter;

  private float aFloat;

  private Float bFloat;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42.0</code>
   */
  private double aDouble;

  private Double bDouble;

  @DecimalMin(value = "4711.0815", inclusive = true)
  private BigDecimal aBigDecimal;

  /**
   * <br/>
   * <b>Default Value:</b> <code>"Hello OpenAPI"</code>
   */
  @Size(min = 8, max = 32)
  private String aString;

  @NotEmpty
  @Size(min = 0, max = 128)
  private String bString;

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
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    bBoolean = pBuilder.bBoolean;
    cBoolean = pBuilder.cBoolean;
    aByte = pBuilder.aByte;
    bByte = pBuilder.bByte;
    aShort = pBuilder.aShort;
    bShort = pBuilder.bShort;
    aInteger = pBuilder.aInteger;
    bInteger = pBuilder.bInteger;
    cInteger = pBuilder.cInteger;
    aLong = pBuilder.aLong;
    bLong = pBuilder.bLong;
    aBigInteger = pBuilder.aBigInteger;
    aCharacter = pBuilder.aCharacter;
    bCharacter = pBuilder.bCharacter;
    aFloat = pBuilder.aFloat;
    bFloat = pBuilder.bFloat;
    aDouble = pBuilder.aDouble;
    bDouble = pBuilder.bDouble;
    aBigDecimal = pBuilder.aBigDecimal;
    aString = pBuilder.aString;
    bString = pBuilder.bString;
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
   * Convenience method to create new instance of class PrimitiveObjectWithRestrictions.
   *
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   *
   * @param pBBoolean Value to which {@link #bBoolean} should be set.
   *
   * @param pCBoolean Value to which {@link #cBoolean} should be set.
   *
   * @param pAByte Value to which {@link #aByte} should be set.
   *
   * @param pBByte Value to which {@link #bByte} should be set.
   *
   * @param pAShort Value to which {@link #aShort} should be set.
   *
   * @param pBShort Value to which {@link #bShort} should be set.
   *
   * @param pAInteger Value to which {@link #aInteger} should be set.
   *
   * @param pBInteger Value to which {@link #bInteger} should be set.
   *
   * @param pCInteger Value to which {@link #cInteger} should be set.
   *
   * @param pALong Value to which {@link #aLong} should be set.
   *
   * @param pBLong Value to which {@link #bLong} should be set.
   *
   * @param pABigInteger Value to which {@link #aBigInteger} should be set.
   *
   * @param pACharacter Value to which {@link #aCharacter} should be set.
   *
   * @param pBCharacter Value to which {@link #bCharacter} should be set.
   *
   * @param pAFloat Value to which {@link #aFloat} should be set.
   *
   * @param pBFloat Value to which {@link #bFloat} should be set.
   *
   * @param pADouble Value to which {@link #aDouble} should be set.
   *
   * @param pBDouble Value to which {@link #bDouble} should be set.
   *
   * @param pABigDecimal Value to which {@link #aBigDecimal} should be set.
   *
   * @param pAString Value to which {@link #aString} should be set.
   *
   * @param pBString Value to which {@link #bString} should be set.
   *
   * @return {@link com.anaptecs.spring.base.PrimitiveObjectWithRestrictions}
   */
  public static PrimitiveObjectWithRestrictions of( boolean pABoolean, Boolean pBBoolean, boolean pCBoolean,
      byte pAByte, Byte pBByte, short pAShort, Short pBShort, int pAInteger, Integer pBInteger, Integer pCInteger,
      long pALong, Long pBLong, BigInteger pABigInteger, char pACharacter, Character pBCharacter, float pAFloat,
      Float pBFloat, double pADouble, Double pBDouble, BigDecimal pABigDecimal, String pAString, String pBString ) {
    PrimitiveObjectWithRestrictions.Builder lBuilder = PrimitiveObjectWithRestrictions.builder();
    lBuilder.setABoolean(pABoolean);
    lBuilder.setBBoolean(pBBoolean);
    lBuilder.setCBoolean(pCBoolean);
    lBuilder.setAByte(pAByte);
    lBuilder.setBByte(pBByte);
    lBuilder.setAShort(pAShort);
    lBuilder.setBShort(pBShort);
    lBuilder.setAInteger(pAInteger);
    lBuilder.setBInteger(pBInteger);
    lBuilder.setCInteger(pCInteger);
    lBuilder.setALong(pALong);
    lBuilder.setBLong(pBLong);
    lBuilder.setABigInteger(pABigInteger);
    lBuilder.setACharacter(pACharacter);
    lBuilder.setBCharacter(pBCharacter);
    lBuilder.setAFloat(pAFloat);
    lBuilder.setBFloat(pBFloat);
    lBuilder.setADouble(pADouble);
    lBuilder.setBDouble(pBDouble);
    lBuilder.setABigDecimal(pABigDecimal);
    lBuilder.setAString(pAString);
    lBuilder.setBString(pBString);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveObjectWithRestrictions</code>.
   */
  public static class Builder {
    /**
     * <br/>
     * <b>Default Value:</b> <code>true</code>
     */
    private boolean aBoolean = true;

    private Boolean bBoolean;

    private boolean cBoolean;

    @Negative
    private byte aByte;

    @NegativeOrZero
    private Byte bByte;

    @Min(value = -237)
    private short aShort;

    @Positive
    private Short bShort;

    @PositiveOrZero
    private int aInteger;

    @Min(value = 4711)
    private Integer bInteger;

    @Min(value = 100)
    @Max(value = 1000)
    private Integer cInteger;

    private long aLong;

    @DecimalMax(value = "299792458", inclusive = false)
    private Long bLong;

    @DecimalMax(value = "3.14159265359", inclusive = true)
    @DecimalMin(value = "-3.14159265359", inclusive = true)
    private BigInteger aBigInteger;

    private char aCharacter;

    private Character bCharacter;

    private float aFloat;

    private Float bFloat;

    /**
     * <br/>
     * <b>Default Value:</b> <code>42.0</code>
     */
    private double aDouble = 42.0;

    private Double bDouble;

    @DecimalMin(value = "4711.0815", inclusive = true)
    private BigDecimal aBigDecimal;

    /**
     * <br/>
     * <b>Default Value:</b> <code>"Hello OpenAPI"</code>
     */
    @Size(min = 8, max = 32)
    private String aString = "Hello OpenAPI";

    @NotEmpty
    @Size(min = 0, max = 128)
    private String bString;

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
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new PrimitiveObjectWithRestrictions objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PrimitiveObjectWithRestrictions objects. The
     * method never returns null.
     */
    public static Builder newBuilder( PrimitiveObjectWithRestrictions pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #aBoolean}.<br/>
     *
     * @param pABoolean Value to which {@link #aBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets attribute {@link #bBoolean}.<br/>
     *
     * @param pBBoolean Value to which {@link #bBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBBoolean( @MyNotNullProperty Boolean pBBoolean ) {
      // Assign value to attribute
      bBoolean = pBBoolean;
      return this;
    }

    /**
     * Method sets attribute {@link #cBoolean}.<br/>
     *
     * @param pCBoolean Value to which {@link #cBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCBoolean( boolean pCBoolean ) {
      // Assign value to attribute
      cBoolean = pCBoolean;
      return this;
    }

    /**
     * Method sets attribute {@link #aByte}.<br/>
     *
     * @param pAByte Value to which {@link #aByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAByte( byte pAByte ) {
      // Assign value to attribute
      aByte = pAByte;
      return this;
    }

    /**
     * Method sets attribute {@link #bByte}.<br/>
     *
     * @param pBByte Value to which {@link #bByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBByte( @MyNotNullProperty Byte pBByte ) {
      // Assign value to attribute
      bByte = pBByte;
      return this;
    }

    /**
     * Method sets attribute {@link #aShort}.<br/>
     *
     * @param pAShort Value to which {@link #aShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAShort( short pAShort ) {
      // Assign value to attribute
      aShort = pAShort;
      return this;
    }

    /**
     * Method sets attribute {@link #bShort}.<br/>
     *
     * @param pBShort Value to which {@link #bShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBShort( @MyNotNullProperty Short pBShort ) {
      // Assign value to attribute
      bShort = pBShort;
      return this;
    }

    /**
     * Method sets attribute {@link #aInteger}.<br/>
     *
     * @param pAInteger Value to which {@link #aInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAInteger( int pAInteger ) {
      // Assign value to attribute
      aInteger = pAInteger;
      return this;
    }

    /**
     * Method sets attribute {@link #bInteger}.<br/>
     *
     * @param pBInteger Value to which {@link #bInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBInteger( @MyNotNullProperty Integer pBInteger ) {
      // Assign value to attribute
      bInteger = pBInteger;
      return this;
    }

    /**
     * Method sets attribute {@link #cInteger}.<br/>
     *
     * @param pCInteger Value to which {@link #cInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCInteger( @MyNotNullProperty Integer pCInteger ) {
      // Assign value to attribute
      cInteger = pCInteger;
      return this;
    }

    /**
     * Method sets attribute {@link #aLong}.<br/>
     *
     * @param pALong Value to which {@link #aLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setALong( long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this;
    }

    /**
     * Method sets attribute {@link #bLong}.<br/>
     *
     * @param pBLong Value to which {@link #bLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBLong( @MyNotNullProperty Long pBLong ) {
      // Assign value to attribute
      bLong = pBLong;
      return this;
    }

    /**
     * Method sets attribute {@link #aBigInteger}.<br/>
     *
     * @param pABigInteger Value to which {@link #aBigInteger} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigInteger( @MyNotNullProperty BigInteger pABigInteger ) {
      // Assign value to attribute
      aBigInteger = pABigInteger;
      return this;
    }

    /**
     * Method sets attribute {@link #aCharacter}.<br/>
     *
     * @param pACharacter Value to which {@link #aCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setACharacter( char pACharacter ) {
      // Assign value to attribute
      aCharacter = pACharacter;
      return this;
    }

    /**
     * Method sets attribute {@link #bCharacter}.<br/>
     *
     * @param pBCharacter Value to which {@link #bCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBCharacter( @MyNotNullProperty Character pBCharacter ) {
      // Assign value to attribute
      bCharacter = pBCharacter;
      return this;
    }

    /**
     * Method sets attribute {@link #aFloat}.<br/>
     *
     * @param pAFloat Value to which {@link #aFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAFloat( float pAFloat ) {
      // Assign value to attribute
      aFloat = pAFloat;
      return this;
    }

    /**
     * Method sets attribute {@link #bFloat}.<br/>
     *
     * @param pBFloat Value to which {@link #bFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBFloat( @MyNotNullProperty Float pBFloat ) {
      // Assign value to attribute
      bFloat = pBFloat;
      return this;
    }

    /**
     * Method sets attribute {@link #aDouble}.<br/>
     *
     * @param pADouble Value to which {@link #aDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setADouble( double pADouble ) {
      // Assign value to attribute
      aDouble = pADouble;
      return this;
    }

    /**
     * Method sets attribute {@link #bDouble}.<br/>
     *
     * @param pBDouble Value to which {@link #bDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBDouble( @MyNotNullProperty Double pBDouble ) {
      // Assign value to attribute
      bDouble = pBDouble;
      return this;
    }

    /**
     * Method sets attribute {@link #aBigDecimal}.<br/>
     *
     * @param pABigDecimal Value to which {@link #aBigDecimal} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABigDecimal( @MyNotNullProperty BigDecimal pABigDecimal ) {
      // Assign value to attribute
      aBigDecimal = pABigDecimal;
      return this;
    }

    /**
     * Method sets attribute {@link #aString}.<br/>
     *
     * @param pAString Value to which {@link #aString} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAString( @MyNotNullProperty String pAString ) {
      // Assign value to attribute
      aString = pAString;
      return this;
    }

    /**
     * Method sets attribute {@link #bString}.<br/>
     *
     * @param pBString Value to which {@link #bString} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBString( @MyNotNullProperty String pBString ) {
      // Assign value to attribute
      bString = pBString;
      return this;
    }

    /**
     * Method creates a new instance of class PrimitiveObjectWithRestrictions. The object will be initialized with the
     * values of the builder.
     *
     * @return PrimitiveObjectWithRestrictions Created object. The method never returns null.
     */
    public PrimitiveObjectWithRestrictions build( ) {
      PrimitiveObjectWithRestrictions lObject = new PrimitiveObjectWithRestrictions(this);
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
   * Method returns attribute {@link #bBoolean}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #bBoolean} is set.
   */
  @MyNotNullProperty
  public Boolean getBBoolean( ) {
    return bBoolean;
  }

  /**
   * Method sets attribute {@link #bBoolean}.<br/>
   *
   * @param pBBoolean Value to which {@link #bBoolean} should be set.
   */
  public void setBBoolean( @MyNotNullProperty Boolean pBBoolean ) {
    // Assign value to attribute
    bBoolean = pBBoolean;
  }

  /**
   * Method returns attribute {@link #cBoolean}.<br/>
   *
   * @return boolean Value to which {@link #cBoolean} is set.
   */
  @Deprecated
  public boolean getCBoolean( ) {
    return cBoolean;
  }

  /**
   * Method returns attribute {@link #cBoolean}.<br/>
   *
   * @return boolean Value to which {@link #cBoolean} is set.
   */
  public boolean isCBoolean( ) {
    return cBoolean;
  }

  /**
   * Method sets attribute {@link #cBoolean}.<br/>
   *
   * @param pCBoolean Value to which {@link #cBoolean} should be set.
   */
  public void setCBoolean( boolean pCBoolean ) {
    // Assign value to attribute
    cBoolean = pCBoolean;
  }

  /**
   * Method returns attribute {@link #aByte}.<br/>
   *
   * @return byte Value to which {@link #aByte} is set.
   */
  public byte getAByte( ) {
    return aByte;
  }

  /**
   * Method sets attribute {@link #aByte}.<br/>
   *
   * @param pAByte Value to which {@link #aByte} should be set.
   */
  public void setAByte( byte pAByte ) {
    // Assign value to attribute
    aByte = pAByte;
  }

  /**
   * Method returns attribute {@link #bByte}.<br/>
   *
   * @return {@link Byte} Value to which {@link #bByte} is set.
   */
  @MyNotNullProperty
  public Byte getBByte( ) {
    return bByte;
  }

  /**
   * Method sets attribute {@link #bByte}.<br/>
   *
   * @param pBByte Value to which {@link #bByte} should be set.
   */
  public void setBByte( @MyNotNullProperty Byte pBByte ) {
    // Assign value to attribute
    bByte = pBByte;
  }

  /**
   * Method returns attribute {@link #aShort}.<br/>
   *
   * @return short Value to which {@link #aShort} is set.
   */
  public short getAShort( ) {
    return aShort;
  }

  /**
   * Method sets attribute {@link #aShort}.<br/>
   *
   * @param pAShort Value to which {@link #aShort} should be set.
   */
  public void setAShort( short pAShort ) {
    // Assign value to attribute
    aShort = pAShort;
  }

  /**
   * Method returns attribute {@link #bShort}.<br/>
   *
   * @return {@link Short} Value to which {@link #bShort} is set.
   */
  @MyNotNullProperty
  public Short getBShort( ) {
    return bShort;
  }

  /**
   * Method sets attribute {@link #bShort}.<br/>
   *
   * @param pBShort Value to which {@link #bShort} should be set.
   */
  public void setBShort( @MyNotNullProperty Short pBShort ) {
    // Assign value to attribute
    bShort = pBShort;
  }

  /**
   * Method returns attribute {@link #aInteger}.<br/>
   *
   * @return int Value to which {@link #aInteger} is set.
   */
  public int getAInteger( ) {
    return aInteger;
  }

  /**
   * Method sets attribute {@link #aInteger}.<br/>
   *
   * @param pAInteger Value to which {@link #aInteger} should be set.
   */
  public void setAInteger( int pAInteger ) {
    // Assign value to attribute
    aInteger = pAInteger;
  }

  /**
   * Method returns attribute {@link #bInteger}.<br/>
   *
   * @return {@link Integer} Value to which {@link #bInteger} is set.
   */
  @MyNotNullProperty
  public Integer getBInteger( ) {
    return bInteger;
  }

  /**
   * Method sets attribute {@link #bInteger}.<br/>
   *
   * @param pBInteger Value to which {@link #bInteger} should be set.
   */
  public void setBInteger( @MyNotNullProperty Integer pBInteger ) {
    // Assign value to attribute
    bInteger = pBInteger;
  }

  /**
   * Method returns attribute {@link #cInteger}.<br/>
   *
   * @return {@link Integer} Value to which {@link #cInteger} is set.
   */
  @MyNotNullProperty
  public Integer getCInteger( ) {
    return cInteger;
  }

  /**
   * Method sets attribute {@link #cInteger}.<br/>
   *
   * @param pCInteger Value to which {@link #cInteger} should be set.
   */
  public void setCInteger( @MyNotNullProperty Integer pCInteger ) {
    // Assign value to attribute
    cInteger = pCInteger;
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
   * Method returns attribute {@link #bLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #bLong} is set.
   */
  @MyNotNullProperty
  public Long getBLong( ) {
    return bLong;
  }

  /**
   * Method sets attribute {@link #bLong}.<br/>
   *
   * @param pBLong Value to which {@link #bLong} should be set.
   */
  public void setBLong( @MyNotNullProperty Long pBLong ) {
    // Assign value to attribute
    bLong = pBLong;
  }

  /**
   * Method returns attribute {@link #aBigInteger}.<br/>
   *
   * @return {@link BigInteger} Value to which {@link #aBigInteger} is set.
   */
  @MyNotNullProperty
  public BigInteger getABigInteger( ) {
    return aBigInteger;
  }

  /**
   * Method sets attribute {@link #aBigInteger}.<br/>
   *
   * @param pABigInteger Value to which {@link #aBigInteger} should be set.
   */
  public void setABigInteger( @MyNotNullProperty BigInteger pABigInteger ) {
    // Assign value to attribute
    aBigInteger = pABigInteger;
  }

  /**
   * Method returns attribute {@link #aCharacter}.<br/>
   *
   * @return char Value to which {@link #aCharacter} is set.
   */
  public char getACharacter( ) {
    return aCharacter;
  }

  /**
   * Method sets attribute {@link #aCharacter}.<br/>
   *
   * @param pACharacter Value to which {@link #aCharacter} should be set.
   */
  public void setACharacter( char pACharacter ) {
    // Assign value to attribute
    aCharacter = pACharacter;
  }

  /**
   * Method returns attribute {@link #bCharacter}.<br/>
   *
   * @return {@link Character} Value to which {@link #bCharacter} is set.
   */
  @MyNotNullProperty
  public Character getBCharacter( ) {
    return bCharacter;
  }

  /**
   * Method sets attribute {@link #bCharacter}.<br/>
   *
   * @param pBCharacter Value to which {@link #bCharacter} should be set.
   */
  public void setBCharacter( @MyNotNullProperty Character pBCharacter ) {
    // Assign value to attribute
    bCharacter = pBCharacter;
  }

  /**
   * Method returns attribute {@link #aFloat}.<br/>
   *
   * @return float Value to which {@link #aFloat} is set.
   */
  public float getAFloat( ) {
    return aFloat;
  }

  /**
   * Method sets attribute {@link #aFloat}.<br/>
   *
   * @param pAFloat Value to which {@link #aFloat} should be set.
   */
  public void setAFloat( float pAFloat ) {
    // Assign value to attribute
    aFloat = pAFloat;
  }

  /**
   * Method returns attribute {@link #bFloat}.<br/>
   *
   * @return {@link Float} Value to which {@link #bFloat} is set.
   */
  @MyNotNullProperty
  public Float getBFloat( ) {
    return bFloat;
  }

  /**
   * Method sets attribute {@link #bFloat}.<br/>
   *
   * @param pBFloat Value to which {@link #bFloat} should be set.
   */
  public void setBFloat( @MyNotNullProperty Float pBFloat ) {
    // Assign value to attribute
    bFloat = pBFloat;
  }

  /**
   * Method returns attribute {@link #aDouble}.<br/>
   *
   * @return double Value to which {@link #aDouble} is set.
   */
  public double getADouble( ) {
    return aDouble;
  }

  /**
   * Method sets attribute {@link #aDouble}.<br/>
   *
   * @param pADouble Value to which {@link #aDouble} should be set.
   */
  public void setADouble( double pADouble ) {
    // Assign value to attribute
    aDouble = pADouble;
  }

  /**
   * Method returns attribute {@link #bDouble}.<br/>
   *
   * @return {@link Double} Value to which {@link #bDouble} is set.
   */
  @MyNotNullProperty
  public Double getBDouble( ) {
    return bDouble;
  }

  /**
   * Method sets attribute {@link #bDouble}.<br/>
   *
   * @param pBDouble Value to which {@link #bDouble} should be set.
   */
  public void setBDouble( @MyNotNullProperty Double pBDouble ) {
    // Assign value to attribute
    bDouble = pBDouble;
  }

  /**
   * Method returns attribute {@link #aBigDecimal}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #aBigDecimal} is set.
   */
  @MyNotNullProperty
  public BigDecimal getABigDecimal( ) {
    return aBigDecimal;
  }

  /**
   * Method sets attribute {@link #aBigDecimal}.<br/>
   *
   * @param pABigDecimal Value to which {@link #aBigDecimal} should be set.
   */
  public void setABigDecimal( @MyNotNullProperty BigDecimal pABigDecimal ) {
    // Assign value to attribute
    aBigDecimal = pABigDecimal;
  }

  /**
   * Method returns attribute {@link #aString}.<br/>
   *
   * @return {@link String} Value to which {@link #aString} is set.
   */
  @MyNotNullProperty
  public String getAString( ) {
    return aString;
  }

  /**
   * Method sets attribute {@link #aString}.<br/>
   *
   * @param pAString Value to which {@link #aString} should be set.
   */
  public void setAString( @MyNotNullProperty String pAString ) {
    // Assign value to attribute
    aString = pAString;
  }

  /**
   * Method returns attribute {@link #bString}.<br/>
   *
   * @return {@link String} Value to which {@link #bString} is set.
   */
  @MyNotNullProperty
  public String getBString( ) {
    return bString;
  }

  /**
   * Method sets attribute {@link #bString}.<br/>
   *
   * @param pBString Value to which {@link #bString} should be set.
   */
  public void setBString( @MyNotNullProperty String pBString ) {
    // Assign value to attribute
    bString = pBString;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Boolean.hashCode(aBoolean);
    lResult = lPrime * lResult + Objects.hashCode(bBoolean);
    lResult = lPrime * lResult + Boolean.hashCode(cBoolean);
    lResult = lPrime * lResult + aByte;
    lResult = lPrime * lResult + Objects.hashCode(bByte);
    lResult = lPrime * lResult + aShort;
    lResult = lPrime * lResult + Objects.hashCode(bShort);
    lResult = lPrime * lResult + aInteger;
    lResult = lPrime * lResult + Objects.hashCode(bInteger);
    lResult = lPrime * lResult + Objects.hashCode(cInteger);
    lResult = lPrime * lResult + Long.hashCode(aLong);
    lResult = lPrime * lResult + Objects.hashCode(bLong);
    lResult = lPrime * lResult + Objects.hashCode(aBigInteger);
    lResult = lPrime * lResult + aCharacter;
    lResult = lPrime * lResult + Objects.hashCode(bCharacter);
    lResult = lPrime * lResult + Float.hashCode(aFloat);
    lResult = lPrime * lResult + Objects.hashCode(bFloat);
    lResult = lPrime * lResult + Double.hashCode(aDouble);
    lResult = lPrime * lResult + Objects.hashCode(bDouble);
    lResult = lPrime * lResult + Objects.hashCode(aBigDecimal);
    lResult = lPrime * lResult + Objects.hashCode(aString);
    lResult = lPrime * lResult + Objects.hashCode(bString);
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
      PrimitiveObjectWithRestrictions lOther = (PrimitiveObjectWithRestrictions) pObject;
      lEquals = aBoolean == lOther.aBoolean && Objects.equals(bBoolean, lOther.bBoolean) && cBoolean == lOther.cBoolean
          && aByte == lOther.aByte && Objects.equals(bByte, lOther.bByte) && aShort == lOther.aShort
          && Objects.equals(bShort, lOther.bShort) && aInteger == lOther.aInteger
          && Objects.equals(bInteger, lOther.bInteger) && Objects.equals(cInteger, lOther.cInteger)
          && aLong == lOther.aLong && Objects.equals(bLong, lOther.bLong)
          && Objects.equals(aBigInteger, lOther.aBigInteger) && aCharacter == lOther.aCharacter
          && Objects.equals(bCharacter, lOther.bCharacter) && Float.compare(aFloat, lOther.aFloat) == 0
          && Objects.equals(bFloat, lOther.bFloat) && Double.compare(aDouble, lOther.aDouble) == 0
          && Objects.equals(bDouble, lOther.bDouble) && Objects.equals(aBigDecimal, lOther.aBigDecimal)
          && Objects.equals(aString, lOther.aString) && Objects.equals(bString, lOther.bString);
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