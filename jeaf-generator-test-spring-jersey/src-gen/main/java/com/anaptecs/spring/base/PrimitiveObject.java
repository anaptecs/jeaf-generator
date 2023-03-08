/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimitiveObject {
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

  private boolean aBoolean;

  private Boolean bBoolean;

  private boolean cBoolean;

  private byte aByte;

  private Byte bByte;

  private short aShort;

  private Short bShort;

  private int aInteger;

  private Integer bInteger;

  private Integer cInteger;

  private long aLong;

  private Long bLong;

  private BigInteger aBigInteger;

  private char aCharacter;

  private Character bCharacter;

  private float aFloat;

  private Float bFloat;

  private double aDouble;

  private Double bDouble;

  private BigDecimal aBigDecimal;

  private String aString;

  private String bString;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveObject( Builder pBuilder ) {
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
   * @return {@link Builder} New builder that can be used to create new PrimitiveObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveObject objects. The method never
   * returns null.
   */
  public static Builder builder( PrimitiveObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PrimitiveObject. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean aBoolean;

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
    private byte aByte;

    /**
     * 
     */
    private Byte bByte;

    /**
     * 
     */
    private short aShort;

    /**
     * 
     */
    private Short bShort;

    /**
     * 
     */
    private int aInteger;

    /**
     * 
     */
    private Integer bInteger;

    /**
     * 
     */
    private Integer cInteger;

    /**
     * 
     */
    private long aLong;

    /**
     * 
     */
    private Long bLong;

    /**
     * 
     */
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
    private double aDouble;

    /**
     * 
     */
    private Double bDouble;

    /**
     * 
     */
    private BigDecimal aBigDecimal;

    /**
     * 
     */
    private String aString;

    /**
     * 
     */
    private String bString;

    /**
     * Use {@link PrimitiveObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveObject#builder(PrimitiveObject)} instead of private constructor to create new builder.
     */
    protected Builder( PrimitiveObject pObject ) {
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
     * Method creates a new instance of class PrimitiveObject. The object will be initialized with the values of the
     * builder.
     * 
     * @return PrimitiveObject Created object. The method never returns null.
     */
    public PrimitiveObject build( ) {
      return new PrimitiveObject(this);
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
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
   * Method returns attribute {@link #bBoolean}.<br/>
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
   * Method returns attribute {@link #cBoolean}.<br/>
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
   * Method returns attribute {@link #aByte}.<br/>
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
   * Method returns attribute {@link #bByte}.<br/>
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
   * Method returns attribute {@link #aShort}.<br/>
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
   * Method returns attribute {@link #bShort}.<br/>
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
   * Method returns attribute {@link #aInteger}.<br/>
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
   * Method returns attribute {@link #bInteger}.<br/>
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
   * Method returns attribute {@link #cInteger}.<br/>
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
   * Method returns attribute {@link #aLong}.<br/>
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
   * Method returns attribute {@link #bLong}.<br/>
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
   * Method returns attribute {@link #aBigInteger}.<br/>
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
   * Method returns attribute {@link #aCharacter}.<br/>
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
   * Method returns attribute {@link #bCharacter}.<br/>
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
   * Method returns attribute {@link #aFloat}.<br/>
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
   * Method returns attribute {@link #bFloat}.<br/>
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
   * Method returns attribute {@link #aDouble}.<br/>
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
   * Method returns attribute {@link #bDouble}.<br/>
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
   * Method returns attribute {@link #aBigDecimal}.<br/>
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
   * Method returns attribute {@link #aString}.<br/>
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
   * Method returns attribute {@link #bString}.<br/>
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
}
