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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
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
public class PrimitiveObjectWithRestrictions implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private boolean aBoolean;

  /**
   * 
   */
  @NotNull
  private Boolean bBoolean;

  /**
   * 
   */
  private boolean cBoolean;

  /**
   * 
   */
  @Negative
  private byte aByte;

  /**
   * 
   */
  @NegativeOrZero
  private Byte bByte;

  /**
   * 
   */
  @Min(value = -237)
  private short aShort;

  /**
   * 
   */
  @Positive
  private Short bShort;

  /**
   * 
   */
  @PositiveOrZero
  private int aInteger;

  /**
   * 
   */
  @Min(value = 4711)
  private Integer bInteger;

  /**
   * 
   */
  @Min(value = 100)
  @Max(value = 1000)
  private Integer cInteger;

  /**
   * 
   */
  private long aLong;

  /**
   * 
   */
  @DecimalMax(value = "299792458", inclusive = false)
  private Long bLong;

  /**
   * 
   */
  @DecimalMax(value = "3.14159265359", inclusive = true)
  @DecimalMin(value = "-3.14159265359", inclusive = true)
  private BigInteger aBigInteger;

  /**
   * 
   */
  private char aCharacter;

  /**
   * 
   */
  @NotNull
  private Character bCharacter;

  /**
   * 
   */
  private float aFloat;

  /**
   * 
   */
  @NotNull
  private Float bFloat;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42.0</code>
   */
  private double aDouble;

  /**
   * 
   */
  @NotNull
  private Double bDouble;

  /**
   * 
   */
  @DecimalMin(value = "4711.0815", inclusive = true)
  private BigDecimal aBigDecimal;

  /**
   * <br/>
   * <b>Default Value:</b> <code>"Hello OpenAPI"</code>
   */
  @Size(min = 8, max = 32)
  private String aString;

  /**
   * 
   */
  @NotEmpty
  @Size(min = 0, max = 128)
  private String bString;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveObjectWithRestrictions objects. The
   * method never returns null.
   */
  public static Builder builder( PrimitiveObjectWithRestrictions pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PrimitiveObjectWithRestrictions. As the class has read
   * only attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean aBoolean = true;

    /**
     * 
     */
    private Boolean bBoolean;

    /**
     * 
     */
    private boolean cBoolean;

    /**
     * 
     */
    @Negative
    private byte aByte;

    /**
     * 
     */
    @NegativeOrZero
    private Byte bByte;

    /**
     * 
     */
    @Min(value = -237)
    private short aShort;

    /**
     * 
     */
    @Positive
    private Short bShort;

    /**
     * 
     */
    @PositiveOrZero
    private int aInteger;

    /**
     * 
     */
    @Min(value = 4711)
    private Integer bInteger;

    /**
     * 
     */
    @Min(value = 100)
    @Max(value = 1000)
    private Integer cInteger;

    /**
     * 
     */
    private long aLong;

    /**
     * 
     */
    @DecimalMax(value = "299792458", inclusive = false)
    private Long bLong;

    /**
     * 
     */
    @DecimalMax(value = "3.14159265359", inclusive = true)
    @DecimalMin(value = "-3.14159265359", inclusive = true)
    private BigInteger aBigInteger;

    /**
     * 
     */
    private char aCharacter;

    /**
     * 
     */
    private Character bCharacter;

    /**
     * 
     */
    private float aFloat;

    /**
     * 
     */
    private Float bFloat;

    /**
     * 
     */
    private double aDouble = 42.0;

    /**
     * 
     */
    private Double bDouble;

    /**
     * 
     */
    @DecimalMin(value = "4711.0815", inclusive = true)
    private BigDecimal aBigDecimal;

    /**
     * 
     */
    @Size(min = 8, max = 32)
    private String aString = "Hello OpenAPI";

    /**
     * 
     */
    @NotEmpty
    @Size(min = 0, max = 128)
    private String bString;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PrimitiveObjectWithRestrictions)} instead of private constructor to create new builder.
     */
    protected Builder( PrimitiveObjectWithRestrictions pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        aBoolean = pObject.aBoolean;
        bBoolean = pObject.bBoolean;
        cBoolean = pObject.cBoolean;
        aByte = pObject.aByte;
        bByte = pObject.bByte;
        aShort = pObject.aShort;
        bShort = pObject.bShort;
        aInteger = pObject.aInteger;
        bInteger = pObject.bInteger;
        cInteger = pObject.cInteger;
        aLong = pObject.aLong;
        bLong = pObject.bLong;
        aBigInteger = pObject.aBigInteger;
        aCharacter = pObject.aCharacter;
        bCharacter = pObject.bCharacter;
        aFloat = pObject.aFloat;
        bFloat = pObject.bFloat;
        aDouble = pObject.aDouble;
        bDouble = pObject.bDouble;
        aBigDecimal = pObject.aBigDecimal;
        aString = pObject.aString;
        bString = pObject.bString;
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
     * Method sets the attribute "aBoolean".
     * 
     * @param pABoolean Value to which the attribute "aBoolean" should be set.
     */
    public Builder setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets the attribute "bBoolean".
     * 
     * @param pBBoolean Value to which the attribute "bBoolean" should be set.
     */
    public Builder setBBoolean( Boolean pBBoolean ) {
      // Assign value to attribute
      bBoolean = pBBoolean;
      return this;
    }

    /**
     * Method sets the attribute "cBoolean".
     * 
     * @param pCBoolean Value to which the attribute "cBoolean" should be set.
     */
    public Builder setCBoolean( boolean pCBoolean ) {
      // Assign value to attribute
      cBoolean = pCBoolean;
      return this;
    }

    /**
     * Method sets the attribute "aByte".
     * 
     * @param pAByte Value to which the attribute "aByte" should be set.
     */
    public Builder setAByte( byte pAByte ) {
      // Assign value to attribute
      aByte = pAByte;
      return this;
    }

    /**
     * Method sets the attribute "bByte".
     * 
     * @param pBByte Value to which the attribute "bByte" should be set.
     */
    public Builder setBByte( Byte pBByte ) {
      // Assign value to attribute
      bByte = pBByte;
      return this;
    }

    /**
     * Method sets the attribute "aShort".
     * 
     * @param pAShort Value to which the attribute "aShort" should be set.
     */
    public Builder setAShort( short pAShort ) {
      // Assign value to attribute
      aShort = pAShort;
      return this;
    }

    /**
     * Method sets the attribute "bShort".
     * 
     * @param pBShort Value to which the attribute "bShort" should be set.
     */
    public Builder setBShort( Short pBShort ) {
      // Assign value to attribute
      bShort = pBShort;
      return this;
    }

    /**
     * Method sets the attribute "aInteger".
     * 
     * @param pAInteger Value to which the attribute "aInteger" should be set.
     */
    public Builder setAInteger( int pAInteger ) {
      // Assign value to attribute
      aInteger = pAInteger;
      return this;
    }

    /**
     * Method sets the attribute "bInteger".
     * 
     * @param pBInteger Value to which the attribute "bInteger" should be set.
     */
    public Builder setBInteger( Integer pBInteger ) {
      // Assign value to attribute
      bInteger = pBInteger;
      return this;
    }

    /**
     * Method sets the attribute "cInteger".
     * 
     * @param pCInteger Value to which the attribute "cInteger" should be set.
     */
    public Builder setCInteger( Integer pCInteger ) {
      // Assign value to attribute
      cInteger = pCInteger;
      return this;
    }

    /**
     * Method sets the attribute "aLong".
     * 
     * @param pALong Value to which the attribute "aLong" should be set.
     */
    public Builder setALong( long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this;
    }

    /**
     * Method sets the attribute "bLong".
     * 
     * @param pBLong Value to which the attribute "bLong" should be set.
     */
    public Builder setBLong( Long pBLong ) {
      // Assign value to attribute
      bLong = pBLong;
      return this;
    }

    /**
     * Method sets the attribute "aBigInteger".
     * 
     * @param pABigInteger Value to which the attribute "aBigInteger" should be set.
     */
    public Builder setABigInteger( BigInteger pABigInteger ) {
      // Assign value to attribute
      aBigInteger = pABigInteger;
      return this;
    }

    /**
     * Method sets the attribute "aCharacter".
     * 
     * @param pACharacter Value to which the attribute "aCharacter" should be set.
     */
    public Builder setACharacter( char pACharacter ) {
      // Assign value to attribute
      aCharacter = pACharacter;
      return this;
    }

    /**
     * Method sets the attribute "bCharacter".
     * 
     * @param pBCharacter Value to which the attribute "bCharacter" should be set.
     */
    public Builder setBCharacter( Character pBCharacter ) {
      // Assign value to attribute
      bCharacter = pBCharacter;
      return this;
    }

    /**
     * Method sets the attribute "aFloat".
     * 
     * @param pAFloat Value to which the attribute "aFloat" should be set.
     */
    public Builder setAFloat( float pAFloat ) {
      // Assign value to attribute
      aFloat = pAFloat;
      return this;
    }

    /**
     * Method sets the attribute "bFloat".
     * 
     * @param pBFloat Value to which the attribute "bFloat" should be set.
     */
    public Builder setBFloat( Float pBFloat ) {
      // Assign value to attribute
      bFloat = pBFloat;
      return this;
    }

    /**
     * Method sets the attribute "aDouble".
     * 
     * @param pADouble Value to which the attribute "aDouble" should be set.
     */
    public Builder setADouble( double pADouble ) {
      // Assign value to attribute
      aDouble = pADouble;
      return this;
    }

    /**
     * Method sets the attribute "bDouble".
     * 
     * @param pBDouble Value to which the attribute "bDouble" should be set.
     */
    public Builder setBDouble( Double pBDouble ) {
      // Assign value to attribute
      bDouble = pBDouble;
      return this;
    }

    /**
     * Method sets the attribute "aBigDecimal".
     * 
     * @param pABigDecimal Value to which the attribute "aBigDecimal" should be set.
     */
    public Builder setABigDecimal( BigDecimal pABigDecimal ) {
      // Assign value to attribute
      aBigDecimal = pABigDecimal;
      return this;
    }

    /**
     * Method sets the attribute "aString".
     * 
     * @param pAString Value to which the attribute "aString" should be set.
     */
    public Builder setAString( String pAString ) {
      // Assign value to attribute
      aString = pAString;
      return this;
    }

    /**
     * Method sets the attribute "bString".
     * 
     * @param pBString Value to which the attribute "bString" should be set.
     */
    public Builder setBString( String pBString ) {
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
      PrimitiveObjectWithRestrictions lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "aBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "aBoolean" is set.
   */
  public boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets the attribute "aBoolean".
   * 
   * 
   * @param pABoolean Value to which the attribute "aBoolean" should be set.
   */
  public void setABoolean( boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  /**
   * Method returns the attribute "bBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "bBoolean" is set.
   */
  public Boolean getBBoolean( ) {
    return bBoolean;
  }

  /**
   * Method sets the attribute "bBoolean".
   * 
   * 
   * @param pBBoolean Value to which the attribute "bBoolean" should be set.
   */
  public void setBBoolean( Boolean pBBoolean ) {
    // Assign value to attribute
    bBoolean = pBBoolean;
  }

  /**
   * Method returns the attribute "cBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "cBoolean" is set.
   */
  public boolean getCBoolean( ) {
    return cBoolean;
  }

  /**
   * Method sets the attribute "cBoolean".
   * 
   * 
   * @param pCBoolean Value to which the attribute "cBoolean" should be set.
   */
  public void setCBoolean( boolean pCBoolean ) {
    // Assign value to attribute
    cBoolean = pCBoolean;
  }

  /**
   * Method returns the attribute "aByte".
   * 
   * 
   * @return byte Value to which the attribute "aByte" is set.
   */
  public byte getAByte( ) {
    return aByte;
  }

  /**
   * Method sets the attribute "aByte".
   * 
   * 
   * @param pAByte Value to which the attribute "aByte" should be set.
   */
  public void setAByte( byte pAByte ) {
    // Assign value to attribute
    aByte = pAByte;
  }

  /**
   * Method returns the attribute "bByte".
   * 
   * 
   * @return Byte Value to which the attribute "bByte" is set.
   */
  public Byte getBByte( ) {
    return bByte;
  }

  /**
   * Method sets the attribute "bByte".
   * 
   * 
   * @param pBByte Value to which the attribute "bByte" should be set.
   */
  public void setBByte( Byte pBByte ) {
    // Assign value to attribute
    bByte = pBByte;
  }

  /**
   * Method returns the attribute "aShort".
   * 
   * 
   * @return short Value to which the attribute "aShort" is set.
   */
  public short getAShort( ) {
    return aShort;
  }

  /**
   * Method sets the attribute "aShort".
   * 
   * 
   * @param pAShort Value to which the attribute "aShort" should be set.
   */
  public void setAShort( short pAShort ) {
    // Assign value to attribute
    aShort = pAShort;
  }

  /**
   * Method returns the attribute "bShort".
   * 
   * 
   * @return Short Value to which the attribute "bShort" is set.
   */
  public Short getBShort( ) {
    return bShort;
  }

  /**
   * Method sets the attribute "bShort".
   * 
   * 
   * @param pBShort Value to which the attribute "bShort" should be set.
   */
  public void setBShort( Short pBShort ) {
    // Assign value to attribute
    bShort = pBShort;
  }

  /**
   * Method returns the attribute "aInteger".
   * 
   * 
   * @return int Value to which the attribute "aInteger" is set.
   */
  public int getAInteger( ) {
    return aInteger;
  }

  /**
   * Method sets the attribute "aInteger".
   * 
   * 
   * @param pAInteger Value to which the attribute "aInteger" should be set.
   */
  public void setAInteger( int pAInteger ) {
    // Assign value to attribute
    aInteger = pAInteger;
  }

  /**
   * Method returns the attribute "bInteger".
   * 
   * 
   * @return Integer Value to which the attribute "bInteger" is set.
   */
  public Integer getBInteger( ) {
    return bInteger;
  }

  /**
   * Method sets the attribute "bInteger".
   * 
   * 
   * @param pBInteger Value to which the attribute "bInteger" should be set.
   */
  public void setBInteger( Integer pBInteger ) {
    // Assign value to attribute
    bInteger = pBInteger;
  }

  /**
   * Method returns the attribute "cInteger".
   * 
   * 
   * @return Integer Value to which the attribute "cInteger" is set.
   */
  public Integer getCInteger( ) {
    return cInteger;
  }

  /**
   * Method sets the attribute "cInteger".
   * 
   * 
   * @param pCInteger Value to which the attribute "cInteger" should be set.
   */
  public void setCInteger( Integer pCInteger ) {
    // Assign value to attribute
    cInteger = pCInteger;
  }

  /**
   * Method returns the attribute "aLong".
   * 
   * 
   * @return long Value to which the attribute "aLong" is set.
   */
  public long getALong( ) {
    return aLong;
  }

  /**
   * Method sets the attribute "aLong".
   * 
   * 
   * @param pALong Value to which the attribute "aLong" should be set.
   */
  public void setALong( long pALong ) {
    // Assign value to attribute
    aLong = pALong;
  }

  /**
   * Method returns the attribute "bLong".
   * 
   * 
   * @return Long Value to which the attribute "bLong" is set.
   */
  public Long getBLong( ) {
    return bLong;
  }

  /**
   * Method sets the attribute "bLong".
   * 
   * 
   * @param pBLong Value to which the attribute "bLong" should be set.
   */
  public void setBLong( Long pBLong ) {
    // Assign value to attribute
    bLong = pBLong;
  }

  /**
   * Method returns the attribute "aBigInteger".
   * 
   * 
   * @return BigInteger Value to which the attribute "aBigInteger" is set.
   */
  public BigInteger getABigInteger( ) {
    return aBigInteger;
  }

  /**
   * Method sets the attribute "aBigInteger".
   * 
   * 
   * @param pABigInteger Value to which the attribute "aBigInteger" should be set.
   */
  public void setABigInteger( BigInteger pABigInteger ) {
    // Assign value to attribute
    aBigInteger = pABigInteger;
  }

  /**
   * Method returns the attribute "aCharacter".
   * 
   * 
   * @return char Value to which the attribute "aCharacter" is set.
   */
  public char getACharacter( ) {
    return aCharacter;
  }

  /**
   * Method sets the attribute "aCharacter".
   * 
   * 
   * @param pACharacter Value to which the attribute "aCharacter" should be set.
   */
  public void setACharacter( char pACharacter ) {
    // Assign value to attribute
    aCharacter = pACharacter;
  }

  /**
   * Method returns the attribute "bCharacter".
   * 
   * 
   * @return Character Value to which the attribute "bCharacter" is set.
   */
  public Character getBCharacter( ) {
    return bCharacter;
  }

  /**
   * Method sets the attribute "bCharacter".
   * 
   * 
   * @param pBCharacter Value to which the attribute "bCharacter" should be set.
   */
  public void setBCharacter( Character pBCharacter ) {
    // Assign value to attribute
    bCharacter = pBCharacter;
  }

  /**
   * Method returns the attribute "aFloat".
   * 
   * 
   * @return float Value to which the attribute "aFloat" is set.
   */
  public float getAFloat( ) {
    return aFloat;
  }

  /**
   * Method sets the attribute "aFloat".
   * 
   * 
   * @param pAFloat Value to which the attribute "aFloat" should be set.
   */
  public void setAFloat( float pAFloat ) {
    // Assign value to attribute
    aFloat = pAFloat;
  }

  /**
   * Method returns the attribute "bFloat".
   * 
   * 
   * @return Float Value to which the attribute "bFloat" is set.
   */
  public Float getBFloat( ) {
    return bFloat;
  }

  /**
   * Method sets the attribute "bFloat".
   * 
   * 
   * @param pBFloat Value to which the attribute "bFloat" should be set.
   */
  public void setBFloat( Float pBFloat ) {
    // Assign value to attribute
    bFloat = pBFloat;
  }

  /**
   * Method returns the attribute "aDouble".
   * 
   * 
   * @return double Value to which the attribute "aDouble" is set.
   */
  public double getADouble( ) {
    return aDouble;
  }

  /**
   * Method sets the attribute "aDouble".
   * 
   * 
   * @param pADouble Value to which the attribute "aDouble" should be set.
   */
  public void setADouble( double pADouble ) {
    // Assign value to attribute
    aDouble = pADouble;
  }

  /**
   * Method returns the attribute "bDouble".
   * 
   * 
   * @return Double Value to which the attribute "bDouble" is set.
   */
  public Double getBDouble( ) {
    return bDouble;
  }

  /**
   * Method sets the attribute "bDouble".
   * 
   * 
   * @param pBDouble Value to which the attribute "bDouble" should be set.
   */
  public void setBDouble( Double pBDouble ) {
    // Assign value to attribute
    bDouble = pBDouble;
  }

  /**
   * Method returns the attribute "aBigDecimal".
   * 
   * 
   * @return BigDecimal Value to which the attribute "aBigDecimal" is set.
   */
  public BigDecimal getABigDecimal( ) {
    return aBigDecimal;
  }

  /**
   * Method sets the attribute "aBigDecimal".
   * 
   * 
   * @param pABigDecimal Value to which the attribute "aBigDecimal" should be set.
   */
  public void setABigDecimal( BigDecimal pABigDecimal ) {
    // Assign value to attribute
    aBigDecimal = pABigDecimal;
  }

  /**
   * Method returns the attribute "aString".
   * 
   * 
   * @return String Value to which the attribute "aString" is set.
   */
  public String getAString( ) {
    return aString;
  }

  /**
   * Method sets the attribute "aString".
   * 
   * 
   * @param pAString Value to which the attribute "aString" should be set.
   */
  public void setAString( String pAString ) {
    // Assign value to attribute
    aString = pAString;
  }

  /**
   * Method returns the attribute "bString".
   * 
   * 
   * @return String Value to which the attribute "bString" is set.
   */
  public String getBString( ) {
    return bString;
  }

  /**
   * Method sets the attribute "bString".
   * 
   * 
   * @param pBString Value to which the attribute "bString" should be set.
   */
  public void setBString( String pBString ) {
    // Assign value to attribute
    bString = pBString;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aBoolean", "" + aBoolean));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bBoolean", "" + bBoolean));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "cBoolean", "" + cBoolean));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aByte", "" + aByte));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bByte", "" + bByte));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aShort", "" + aShort));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bShort", "" + bShort));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aInteger", "" + aInteger));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bInteger", "" + bInteger));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "cInteger", "" + cInteger));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aLong", "" + aLong));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bLong", "" + bLong));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aBigInteger", "" + aBigInteger));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aCharacter", "" + aCharacter));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bCharacter", "" + bCharacter));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aFloat", "" + aFloat));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bFloat", "" + bFloat));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aDouble", "" + aDouble));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bDouble", "" + bDouble));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aBigDecimal", "" + aBigDecimal));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aString", "" + aString));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bString", "" + bString));
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
