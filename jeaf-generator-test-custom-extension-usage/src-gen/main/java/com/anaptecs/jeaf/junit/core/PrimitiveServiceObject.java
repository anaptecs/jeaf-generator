/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class PrimitiveServiceObject extends Object implements ServiceObject {
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
   * Constant for the name of attribute "aByte".
   */
  @JEAFCustomAnnotationTest
  public static final String ABYTE = "aByte";

  /**
   * Constant for the name of attribute "aShort".
   */
  @JEAFCustomAnnotationTest
  public static final String ASHORT = "aShort";

  /**
   * Constant for the name of attribute "aInt".
   */
  @JEAFCustomAnnotationTest
  public static final String AINT = "aInt";

  /**
   * Constant for the name of attribute "aLong".
   */
  @JEAFCustomAnnotationTest
  public static final String ALONG = "aLong";

  /**
   * Constant for the name of attribute "aFloat".
   */
  @JEAFCustomAnnotationTest
  public static final String AFLOAT = "aFloat";

  /**
   * Constant for the name of attribute "aDouble".
   */
  @JEAFCustomAnnotationTest
  public static final String ADOUBLE = "aDouble";

  /**
   * Constant for the name of attribute "aChar".
   */
  @JEAFCustomAnnotationTest
  public static final String ACHAR = "aChar";

  // "boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private boolean aBoolean;

  // "boolean"
  private int aBooleanXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private byte aByte;

  // "byte"
  private int aByteXYZ = 0;

  // "short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private short aShort;

  // "short"
  private int aShortXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private int aInt;

  // "int"
  private int aIntXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private long aLong;

  // "long"
  private int aLongXYZ = 0;

  // "float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private float aFloat;

  // "float"
  private int aFloatXYZ = 0;

  // "double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private double aDouble;

  // "double"
  private int aDoubleXYZ = 0;

  // "char"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private char aChar;

  // "char"
  private int aCharXYZ = 0;

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
    // "boolean"
    aBooleanXYZ = pBuilder.aBooleanXYZ;
    aByte = pBuilder.aByte;
    // "byte"
    aByteXYZ = pBuilder.aByteXYZ;
    aShort = pBuilder.aShort;
    // "short"
    aShortXYZ = pBuilder.aShortXYZ;
    aInt = pBuilder.aInt;
    // "int"
    aIntXYZ = pBuilder.aIntXYZ;
    aLong = pBuilder.aLong;
    // "long"
    aLongXYZ = pBuilder.aLongXYZ;
    aFloat = pBuilder.aFloat;
    // "float"
    aFloatXYZ = pBuilder.aFloatXYZ;
    aDouble = pBuilder.aDouble;
    // "double"
    aDoubleXYZ = pBuilder.aDoubleXYZ;
    aChar = pBuilder.aChar;
    // "char"
    aCharXYZ = pBuilder.aCharXYZ;
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
   * Class implements builder to create a new instance of class <code>PrimitiveServiceObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private boolean aBoolean;

    // "boolean"
    private int aBooleanXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private byte aByte;

    // "byte"
    private int aByteXYZ = 0;

    // "short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private short aShort;

    // "short"
    private int aShortXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private int aInt;

    // "int"
    private int aIntXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private long aLong;

    // "long"
    private int aLongXYZ = 0;

    // "float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private float aFloat;

    // "float"
    private int aFloatXYZ = 0;

    // "double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private double aDouble;

    // "double"
    private int aDoubleXYZ = 0;

    // "char"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private char aChar;

    // "char"
    private int aCharXYZ = 0;

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
        this.setABoolean(pObject.aBoolean);
        this.setAByte(pObject.aByte);
        this.setAShort(pObject.aShort);
        this.setAInt(pObject.aInt);
        this.setALong(pObject.aLong);
        this.setAFloat(pObject.aFloat);
        this.setADouble(pObject.aDouble);
        this.setAChar(pObject.aChar);
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
     * Method sets attribute {@link #aInt}.<br/>
     *
     * @param pAInt Value to which {@link #aInt} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAInt( int pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
      return this;
    }

    public Builder setAIntXYZ( int value ) {
      // "int"
      aIntXYZ = value;
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
     * Method sets attribute {@link #aChar}.<br/>
     *
     * @param pAChar Value to which {@link #aChar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAChar( char pAChar ) {
      // Assign value to attribute
      aChar = pAChar;
      return this;
    }

    public Builder setACharXYZ( int value ) {
      // "char"
      aCharXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class PrimitiveServiceObject. The object will be initialized with the values of
     * the builder.
     *
     * @return PrimitiveServiceObject Created object. The method never returns null.
     */
    public PrimitiveServiceObject build( ) {
      return new PrimitiveServiceObject(this);
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
   * Method returns attribute {@link #aInt}.<br/>
   *
   * @return int Value to which {@link #aInt} is set.
   */
  @JEAFCustomAnnotationTest
  public int getAInt( ) {
    return aInt;
  }

  /**
   * Method sets attribute {@link #aInt}.<br/>
   *
   * @param pAInt Value to which {@link #aInt} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAInt( int pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
  }

  public int getAIntXYZ( ) {
    // "int"
    return aIntXYZ;
  }

  public void setAIntXYZ( int value ) {
    aIntXYZ = value;
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
   * Method returns attribute {@link #aChar}.<br/>
   *
   * @return char Value to which {@link #aChar} is set.
   */
  @JEAFCustomAnnotationTest
  public char getAChar( ) {
    return aChar;
  }

  /**
   * Method sets attribute {@link #aChar}.<br/>
   *
   * @param pAChar Value to which {@link #aChar} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAChar( char pAChar ) {
    // Assign value to attribute
    aChar = pAChar;
  }

  public int getACharXYZ( ) {
    // "char"
    return aCharXYZ;
  }

  public void setACharXYZ( int value ) {
    aCharXYZ = value;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new PrimitiveServiceObject objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}