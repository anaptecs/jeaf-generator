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
public class WrapperTypesServiceObject extends Object implements ServiceObject {
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

  // "java.lang.Boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Boolean aBoolean;

  // "java.lang.Boolean"
  private int aBooleanXYZ = 0;

  // "java.lang.Byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Byte aByte;

  // "java.lang.Byte"
  private int aByteXYZ = 0;

  // "java.lang.Short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Short aShort;

  // "java.lang.Short"
  private int aShortXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Integer aInt;

  // "java.lang.Integer"
  private int aIntXYZ = 0;

  // "java.lang.Long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Long aLong;

  // "java.lang.Long"
  private int aLongXYZ = 0;

  // "java.lang.Float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Float aFloat;

  // "java.lang.Float"
  private int aFloatXYZ = 0;

  // "java.lang.Double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Double aDouble;

  // "java.lang.Double"
  private int aDoubleXYZ = 0;

  // "java.lang.Character"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Character aChar;

  // "java.lang.Character"
  private int aCharXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WrapperTypesServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WrapperTypesServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    // "java.lang.Boolean"
    aBooleanXYZ = pBuilder.aBooleanXYZ;
    aByte = pBuilder.aByte;
    // "java.lang.Byte"
    aByteXYZ = pBuilder.aByteXYZ;
    aShort = pBuilder.aShort;
    // "java.lang.Short"
    aShortXYZ = pBuilder.aShortXYZ;
    aInt = pBuilder.aInt;
    // "java.lang.Integer"
    aIntXYZ = pBuilder.aIntXYZ;
    aLong = pBuilder.aLong;
    // "java.lang.Long"
    aLongXYZ = pBuilder.aLongXYZ;
    aFloat = pBuilder.aFloat;
    // "java.lang.Float"
    aFloatXYZ = pBuilder.aFloatXYZ;
    aDouble = pBuilder.aDouble;
    // "java.lang.Double"
    aDoubleXYZ = pBuilder.aDoubleXYZ;
    aChar = pBuilder.aChar;
    // "java.lang.Character"
    aCharXYZ = pBuilder.aCharXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WrapperTypesServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>WrapperTypesServiceObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.Boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Boolean aBoolean;

    // "java.lang.Boolean"
    private int aBooleanXYZ = 0;

    // "java.lang.Byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Byte aByte;

    // "java.lang.Byte"
    private int aByteXYZ = 0;

    // "java.lang.Short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Short aShort;

    // "java.lang.Short"
    private int aShortXYZ = 0;

    // "java.lang.Integer"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Integer aInt;

    // "java.lang.Integer"
    private int aIntXYZ = 0;

    // "java.lang.Long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Long aLong;

    // "java.lang.Long"
    private int aLongXYZ = 0;

    // "java.lang.Float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Float aFloat;

    // "java.lang.Float"
    private int aFloatXYZ = 0;

    // "java.lang.Double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Double aDouble;

    // "java.lang.Double"
    private int aDoubleXYZ = 0;

    // "java.lang.Character"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Character aChar;

    // "java.lang.Character"
    private int aCharXYZ = 0;

    /**
     * Use {@link WrapperTypesServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WrapperTypesServiceObject#builder(WrapperTypesServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( WrapperTypesServiceObject pObject ) {
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
    public Builder setABoolean( Boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    public Builder setABooleanXYZ( int value ) {
      // "java.lang.Boolean"
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
    public Builder setAByte( Byte pAByte ) {
      // Assign value to attribute
      aByte = pAByte;
      return this;
    }

    public Builder setAByteXYZ( int value ) {
      // "java.lang.Byte"
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
    public Builder setAShort( Short pAShort ) {
      // Assign value to attribute
      aShort = pAShort;
      return this;
    }

    public Builder setAShortXYZ( int value ) {
      // "java.lang.Short"
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
    public Builder setAInt( Integer pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
      return this;
    }

    public Builder setAIntXYZ( int value ) {
      // "java.lang.Integer"
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
    public Builder setALong( Long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this;
    }

    public Builder setALongXYZ( int value ) {
      // "java.lang.Long"
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
    public Builder setAFloat( Float pAFloat ) {
      // Assign value to attribute
      aFloat = pAFloat;
      return this;
    }

    public Builder setAFloatXYZ( int value ) {
      // "java.lang.Float"
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
    public Builder setADouble( Double pADouble ) {
      // Assign value to attribute
      aDouble = pADouble;
      return this;
    }

    public Builder setADoubleXYZ( int value ) {
      // "java.lang.Double"
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
    public Builder setAChar( Character pAChar ) {
      // Assign value to attribute
      aChar = pAChar;
      return this;
    }

    public Builder setACharXYZ( int value ) {
      // "java.lang.Character"
      aCharXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class WrapperTypesServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return WrapperTypesServiceObject Created object. The method never returns null.
     */
    public WrapperTypesServiceObject build( ) {
      return new WrapperTypesServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class WrapperTypesServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return WrapperTypesServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WrapperTypesServiceObject buildValidated( ) throws ConstraintViolationException {
      WrapperTypesServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #aBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public Boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets attribute {@link #aBoolean}.<br/>
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setABoolean( Boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  public int getABooleanXYZ( ) {
    // "java.lang.Boolean"
    return aBooleanXYZ;
  }

  public void setABooleanXYZ( int value ) {
    aBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #aByte}.<br/>
   *
   * @return {@link Byte} Value to which {@link #aByte} is set.
   */
  @JEAFCustomAnnotationTest
  public Byte getAByte( ) {
    return aByte;
  }

  /**
   * Method sets attribute {@link #aByte}.<br/>
   *
   * @param pAByte Value to which {@link #aByte} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAByte( Byte pAByte ) {
    // Assign value to attribute
    aByte = pAByte;
  }

  public int getAByteXYZ( ) {
    // "java.lang.Byte"
    return aByteXYZ;
  }

  public void setAByteXYZ( int value ) {
    aByteXYZ = value;
  }

  /**
   * Method returns attribute {@link #aShort}.<br/>
   *
   * @return {@link Short} Value to which {@link #aShort} is set.
   */
  @JEAFCustomAnnotationTest
  public Short getAShort( ) {
    return aShort;
  }

  /**
   * Method sets attribute {@link #aShort}.<br/>
   *
   * @param pAShort Value to which {@link #aShort} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAShort( Short pAShort ) {
    // Assign value to attribute
    aShort = pAShort;
  }

  public int getAShortXYZ( ) {
    // "java.lang.Short"
    return aShortXYZ;
  }

  public void setAShortXYZ( int value ) {
    aShortXYZ = value;
  }

  /**
   * Method returns attribute {@link #aInt}.<br/>
   *
   * @return {@link Integer} Value to which {@link #aInt} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getAInt( ) {
    return aInt;
  }

  /**
   * Method sets attribute {@link #aInt}.<br/>
   *
   * @param pAInt Value to which {@link #aInt} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAInt( Integer pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
  }

  public int getAIntXYZ( ) {
    // "java.lang.Integer"
    return aIntXYZ;
  }

  public void setAIntXYZ( int value ) {
    aIntXYZ = value;
  }

  /**
   * Method returns attribute {@link #aLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #aLong} is set.
   */
  @JEAFCustomAnnotationTest
  public Long getALong( ) {
    return aLong;
  }

  /**
   * Method sets attribute {@link #aLong}.<br/>
   *
   * @param pALong Value to which {@link #aLong} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setALong( Long pALong ) {
    // Assign value to attribute
    aLong = pALong;
  }

  public int getALongXYZ( ) {
    // "java.lang.Long"
    return aLongXYZ;
  }

  public void setALongXYZ( int value ) {
    aLongXYZ = value;
  }

  /**
   * Method returns attribute {@link #aFloat}.<br/>
   *
   * @return {@link Float} Value to which {@link #aFloat} is set.
   */
  @JEAFCustomAnnotationTest
  public Float getAFloat( ) {
    return aFloat;
  }

  /**
   * Method sets attribute {@link #aFloat}.<br/>
   *
   * @param pAFloat Value to which {@link #aFloat} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAFloat( Float pAFloat ) {
    // Assign value to attribute
    aFloat = pAFloat;
  }

  public int getAFloatXYZ( ) {
    // "java.lang.Float"
    return aFloatXYZ;
  }

  public void setAFloatXYZ( int value ) {
    aFloatXYZ = value;
  }

  /**
   * Method returns attribute {@link #aDouble}.<br/>
   *
   * @return {@link Double} Value to which {@link #aDouble} is set.
   */
  @JEAFCustomAnnotationTest
  public Double getADouble( ) {
    return aDouble;
  }

  /**
   * Method sets attribute {@link #aDouble}.<br/>
   *
   * @param pADouble Value to which {@link #aDouble} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setADouble( Double pADouble ) {
    // Assign value to attribute
    aDouble = pADouble;
  }

  public int getADoubleXYZ( ) {
    // "java.lang.Double"
    return aDoubleXYZ;
  }

  public void setADoubleXYZ( int value ) {
    aDoubleXYZ = value;
  }

  /**
   * Method returns attribute {@link #aChar}.<br/>
   *
   * @return {@link Character} Value to which {@link #aChar} is set.
   */
  @JEAFCustomAnnotationTest
  public Character getAChar( ) {
    return aChar;
  }

  /**
   * Method sets attribute {@link #aChar}.<br/>
   *
   * @param pAChar Value to which {@link #aChar} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAChar( Character pAChar ) {
    // Assign value to attribute
    aChar = pAChar;
  }

  public int getACharXYZ( ) {
    // "java.lang.Character"
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
   * @return {@link Builder} New builder that can be used to create new WrapperTypesServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}