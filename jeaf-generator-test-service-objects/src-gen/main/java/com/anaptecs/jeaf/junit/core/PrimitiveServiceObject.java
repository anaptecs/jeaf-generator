/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PrimitiveServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "aByte".
   */
  public static final String ABYTE = "aByte";

  /**
   * Constant for the name of attribute "aShort".
   */
  public static final String ASHORT = "aShort";

  /**
   * Constant for the name of attribute "aInt".
   */
  public static final String AINT = "aInt";

  /**
   * Constant for the name of attribute "aLong".
   */
  public static final String ALONG = "aLong";

  /**
   * Constant for the name of attribute "aFloat".
   */
  public static final String AFLOAT = "aFloat";

  /**
   * Constant for the name of attribute "aDouble".
   */
  public static final String ADOUBLE = "aDouble";

  /**
   * Constant for the name of attribute "aChar".
   */
  public static final String ACHAR = "aChar";

  private boolean aBoolean;

  private byte aByte;

  private short aShort;

  private int aInt;

  private long aLong;

  private float aFloat;

  private double aDouble;

  private char aChar;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    aByte = pBuilder.aByte;
    aShort = pBuilder.aShort;
    aInt = pBuilder.aInt;
    aLong = pBuilder.aLong;
    aFloat = pBuilder.aFloat;
    aDouble = pBuilder.aDouble;
    aChar = pBuilder.aChar;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PrimitiveServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveServiceObject objects. The method never
   * returns null.
   */
  public static Builder builder( PrimitiveServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveServiceObject</code>.
   */
  public static class Builder {
    private boolean aBoolean;

    private byte aByte;

    private short aShort;

    private int aInt;

    private long aLong;

    private float aFloat;

    private double aDouble;

    private char aChar;

    /**
     * Use {@link PrimitiveServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveServiceObject#builder(PrimitiveServiceObject)} instead of private constructor to create new
     * builder.
     */
    protected Builder( PrimitiveServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        aBoolean = pObject.aBoolean;
        aByte = pObject.aByte;
        aShort = pObject.aShort;
        aInt = pObject.aInt;
        aLong = pObject.aLong;
        aFloat = pObject.aFloat;
        aDouble = pObject.aDouble;
        aChar = pObject.aChar;
      }
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
     * Method sets attribute {@link #aInt}.<br/>
     *
     * @param pAInt Value to which {@link #aInt} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAInt( int pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
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
     * Method sets attribute {@link #aChar}.<br/>
     *
     * @param pAChar Value to which {@link #aChar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAChar( char pAChar ) {
      // Assign value to attribute
      aChar = pAChar;
      return this;
    }

    /**
     * Method creates a new instance of class PrimitiveServiceObject. The object will be initialized with the values of
     * the builder.
     *
     * @return PrimitiveServiceObject Created object. The method never returns null.
     */
    public PrimitiveServiceObject build( ) {
      PrimitiveServiceObject lObject = new PrimitiveServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class PrimitiveServiceObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return PrimitiveServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrimitiveServiceObject buildValidated( ) throws ConstraintViolationException {
      PrimitiveServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  public boolean getABoolean( ) {
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
   * Method returns attribute {@link #aInt}.<br/>
   *
   * @return int Value to which {@link #aInt} is set.
   */
  public int getAInt( ) {
    return aInt;
  }

  /**
   * Method sets attribute {@link #aInt}.<br/>
   *
   * @param pAInt Value to which {@link #aInt} should be set.
   */
  public void setAInt( int pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
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
   * Method returns attribute {@link #aChar}.<br/>
   *
   * @return char Value to which {@link #aChar} is set.
   */
  public char getAChar( ) {
    return aChar;
  }

  /**
   * Method sets attribute {@link #aChar}.<br/>
   *
   * @param pAChar Value to which {@link #aChar} should be set.
   */
  public void setAChar( char pAChar ) {
    // Assign value to attribute
    aChar = pAChar;
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
    lBuilder.append("aByte: ");
    lBuilder.append(aByte);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aShort: ");
    lBuilder.append(aShort);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aInt: ");
    lBuilder.append(aInt);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aLong: ");
    lBuilder.append(aLong);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aFloat: ");
    lBuilder.append(aFloat);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aDouble: ");
    lBuilder.append(aDouble);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aChar: ");
    lBuilder.append(aChar);
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
