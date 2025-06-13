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
public class WrapperDatatypeServiceObject extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "myBoolean".
   */
  @JEAFCustomAnnotationTest
  public static final String MYBOOLEAN = "myBoolean";

  /**
   * Constant for the name of attribute "myByte".
   */
  @JEAFCustomAnnotationTest
  public static final String MYBYTE = "myByte";

  /**
   * Constant for the name of attribute "myCharacter".
   */
  @JEAFCustomAnnotationTest
  public static final String MYCHARACTER = "myCharacter";

  /**
   * Constant for the name of attribute "myDouble".
   */
  @JEAFCustomAnnotationTest
  public static final String MYDOUBLE = "myDouble";

  /**
   * Constant for the name of attribute "myFloat".
   */
  @JEAFCustomAnnotationTest
  public static final String MYFLOAT = "myFloat";

  /**
   * Constant for the name of attribute "myLong".
   */
  @JEAFCustomAnnotationTest
  public static final String MYLONG = "myLong";

  /**
   * Constant for the name of attribute "myShort".
   */
  @JEAFCustomAnnotationTest
  public static final String MYSHORT = "myShort";

  /**
   * Constant for the name of attribute "myByteArray".
   */
  @JEAFCustomAnnotationTest
  public static final String MYBYTEARRAY = "myByteArray";

  // "java.lang.Boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Boolean myBoolean;

  // "java.lang.Boolean"
  private int myBooleanXYZ = 0;

  // "java.lang.Byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Byte myByte;

  // "java.lang.Byte"
  private int myByteXYZ = 0;

  // "java.lang.Character"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Character myCharacter;

  // "java.lang.Character"
  private int myCharacterXYZ = 0;

  // "java.lang.Double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Double myDouble;

  // "java.lang.Double"
  private int myDoubleXYZ = 0;

  // "java.lang.Float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Float myFloat;

  // "java.lang.Float"
  private int myFloatXYZ = 0;

  // "java.lang.Long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Long myLong;

  // "java.lang.Long"
  private int myLongXYZ = 0;

  // "java.lang.Short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Short myShort;

  // "java.lang.Short"
  private int myShortXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private byte[] myByteArray;

  // "byte"
  private int myByteArrayXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WrapperDatatypeServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WrapperDatatypeServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    myBoolean = pBuilder.myBoolean;
    // "java.lang.Boolean"
    myBooleanXYZ = pBuilder.myBooleanXYZ;
    myByte = pBuilder.myByte;
    // "java.lang.Byte"
    myByteXYZ = pBuilder.myByteXYZ;
    myCharacter = pBuilder.myCharacter;
    // "java.lang.Character"
    myCharacterXYZ = pBuilder.myCharacterXYZ;
    myDouble = pBuilder.myDouble;
    // "java.lang.Double"
    myDoubleXYZ = pBuilder.myDoubleXYZ;
    myFloat = pBuilder.myFloat;
    // "java.lang.Float"
    myFloatXYZ = pBuilder.myFloatXYZ;
    myLong = pBuilder.myLong;
    // "java.lang.Long"
    myLongXYZ = pBuilder.myLongXYZ;
    myShort = pBuilder.myShort;
    // "java.lang.Short"
    myShortXYZ = pBuilder.myShortXYZ;
    myByteArray = pBuilder.myByteArray;
    // "byte"
    myByteArrayXYZ = pBuilder.myByteArrayXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WrapperDatatypeServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>WrapperDatatypeServiceObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.Boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Boolean myBoolean;

    // "java.lang.Boolean"
    private int myBooleanXYZ = 0;

    // "java.lang.Byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Byte myByte;

    // "java.lang.Byte"
    private int myByteXYZ = 0;

    // "java.lang.Character"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Character myCharacter;

    // "java.lang.Character"
    private int myCharacterXYZ = 0;

    // "java.lang.Double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Double myDouble;

    // "java.lang.Double"
    private int myDoubleXYZ = 0;

    // "java.lang.Float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Float myFloat;

    // "java.lang.Float"
    private int myFloatXYZ = 0;

    // "java.lang.Long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Long myLong;

    // "java.lang.Long"
    private int myLongXYZ = 0;

    // "java.lang.Short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Short myShort;

    // "java.lang.Short"
    private int myShortXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private byte[] myByteArray;

    // "byte"
    private int myByteArrayXYZ = 0;

    /**
     * Use {@link WrapperDatatypeServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WrapperDatatypeServiceObject#builder(WrapperDatatypeServiceObject)} instead of private constructor to
     * create new builder.
     */
    protected Builder( WrapperDatatypeServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyBoolean(pObject.myBoolean);
        this.setMyByte(pObject.myByte);
        this.setMyCharacter(pObject.myCharacter);
        this.setMyDouble(pObject.myDouble);
        this.setMyFloat(pObject.myFloat);
        this.setMyLong(pObject.myLong);
        this.setMyShort(pObject.myShort);
        this.setMyByteArray(pObject.myByteArray);
      }
    }

    /**
     * Method sets attribute {@link #myBoolean}.<br/>
     *
     * @param pMyBoolean Value to which {@link #myBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyBoolean( Boolean pMyBoolean ) {
      // Assign value to attribute
      myBoolean = pMyBoolean;
      return this;
    }

    public Builder setMyBooleanXYZ( int value ) {
      // "java.lang.Boolean"
      myBooleanXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myByte}.<br/>
     *
     * @param pMyByte Value to which {@link #myByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyByte( Byte pMyByte ) {
      // Assign value to attribute
      myByte = pMyByte;
      return this;
    }

    public Builder setMyByteXYZ( int value ) {
      // "java.lang.Byte"
      myByteXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myCharacter}.<br/>
     *
     * @param pMyCharacter Value to which {@link #myCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyCharacter( Character pMyCharacter ) {
      // Assign value to attribute
      myCharacter = pMyCharacter;
      return this;
    }

    public Builder setMyCharacterXYZ( int value ) {
      // "java.lang.Character"
      myCharacterXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myDouble}.<br/>
     *
     * @param pMyDouble Value to which {@link #myDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyDouble( Double pMyDouble ) {
      // Assign value to attribute
      myDouble = pMyDouble;
      return this;
    }

    public Builder setMyDoubleXYZ( int value ) {
      // "java.lang.Double"
      myDoubleXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myFloat}.<br/>
     *
     * @param pMyFloat Value to which {@link #myFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyFloat( Float pMyFloat ) {
      // Assign value to attribute
      myFloat = pMyFloat;
      return this;
    }

    public Builder setMyFloatXYZ( int value ) {
      // "java.lang.Float"
      myFloatXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myLong}.<br/>
     *
     * @param pMyLong Value to which {@link #myLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyLong( Long pMyLong ) {
      // Assign value to attribute
      myLong = pMyLong;
      return this;
    }

    public Builder setMyLongXYZ( int value ) {
      // "java.lang.Long"
      myLongXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myShort}.<br/>
     *
     * @param pMyShort Value to which {@link #myShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyShort( Short pMyShort ) {
      // Assign value to attribute
      myShort = pMyShort;
      return this;
    }

    public Builder setMyShortXYZ( int value ) {
      // "java.lang.Short"
      myShortXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myByteArray}.<br/>
     *
     * @param pMyByteArray Value to which {@link #myByteArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyByteArray( byte[] pMyByteArray ) {
      // Assign value to attribute
      if (pMyByteArray != null) {
        myByteArray = new byte[pMyByteArray.length];
        System.arraycopy(pMyByteArray, 0, myByteArray, 0, pMyByteArray.length);
      }
      else {
        myByteArray = null;
      }
      return this;
    }

    public Builder setMyByteArrayXYZ( int value ) {
      // "byte"
      myByteArrayXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class WrapperDatatypeServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return WrapperDatatypeServiceObject Created object. The method never returns null.
     */
    public WrapperDatatypeServiceObject build( ) {
      return new WrapperDatatypeServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class WrapperDatatypeServiceObject. The object will be initialized
     * with the values of the builder and validated afterwards.
     *
     * @return WrapperDatatypeServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WrapperDatatypeServiceObject buildValidated( ) throws ConstraintViolationException {
      WrapperDatatypeServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myBoolean}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #myBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public Boolean getMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method sets attribute {@link #myBoolean}.<br/>
   *
   * @param pMyBoolean Value to which {@link #myBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyBoolean( Boolean pMyBoolean ) {
    // Assign value to attribute
    myBoolean = pMyBoolean;
  }

  public int getMyBooleanXYZ( ) {
    // "java.lang.Boolean"
    return myBooleanXYZ;
  }

  public void setMyBooleanXYZ( int value ) {
    myBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #myByte}.<br/>
   *
   * @return {@link Byte} Value to which {@link #myByte} is set.
   */
  @JEAFCustomAnnotationTest
  public Byte getMyByte( ) {
    return myByte;
  }

  /**
   * Method sets attribute {@link #myByte}.<br/>
   *
   * @param pMyByte Value to which {@link #myByte} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyByte( Byte pMyByte ) {
    // Assign value to attribute
    myByte = pMyByte;
  }

  public int getMyByteXYZ( ) {
    // "java.lang.Byte"
    return myByteXYZ;
  }

  public void setMyByteXYZ( int value ) {
    myByteXYZ = value;
  }

  /**
   * Method returns attribute {@link #myCharacter}.<br/>
   *
   * @return {@link Character} Value to which {@link #myCharacter} is set.
   */
  @JEAFCustomAnnotationTest
  public Character getMyCharacter( ) {
    return myCharacter;
  }

  /**
   * Method sets attribute {@link #myCharacter}.<br/>
   *
   * @param pMyCharacter Value to which {@link #myCharacter} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyCharacter( Character pMyCharacter ) {
    // Assign value to attribute
    myCharacter = pMyCharacter;
  }

  public int getMyCharacterXYZ( ) {
    // "java.lang.Character"
    return myCharacterXYZ;
  }

  public void setMyCharacterXYZ( int value ) {
    myCharacterXYZ = value;
  }

  /**
   * Method returns attribute {@link #myDouble}.<br/>
   *
   * @return {@link Double} Value to which {@link #myDouble} is set.
   */
  @JEAFCustomAnnotationTest
  public Double getMyDouble( ) {
    return myDouble;
  }

  /**
   * Method sets attribute {@link #myDouble}.<br/>
   *
   * @param pMyDouble Value to which {@link #myDouble} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyDouble( Double pMyDouble ) {
    // Assign value to attribute
    myDouble = pMyDouble;
  }

  public int getMyDoubleXYZ( ) {
    // "java.lang.Double"
    return myDoubleXYZ;
  }

  public void setMyDoubleXYZ( int value ) {
    myDoubleXYZ = value;
  }

  /**
   * Method returns attribute {@link #myFloat}.<br/>
   *
   * @return {@link Float} Value to which {@link #myFloat} is set.
   */
  @JEAFCustomAnnotationTest
  public Float getMyFloat( ) {
    return myFloat;
  }

  /**
   * Method sets attribute {@link #myFloat}.<br/>
   *
   * @param pMyFloat Value to which {@link #myFloat} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyFloat( Float pMyFloat ) {
    // Assign value to attribute
    myFloat = pMyFloat;
  }

  public int getMyFloatXYZ( ) {
    // "java.lang.Float"
    return myFloatXYZ;
  }

  public void setMyFloatXYZ( int value ) {
    myFloatXYZ = value;
  }

  /**
   * Method returns attribute {@link #myLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #myLong} is set.
   */
  @JEAFCustomAnnotationTest
  public Long getMyLong( ) {
    return myLong;
  }

  /**
   * Method sets attribute {@link #myLong}.<br/>
   *
   * @param pMyLong Value to which {@link #myLong} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyLong( Long pMyLong ) {
    // Assign value to attribute
    myLong = pMyLong;
  }

  public int getMyLongXYZ( ) {
    // "java.lang.Long"
    return myLongXYZ;
  }

  public void setMyLongXYZ( int value ) {
    myLongXYZ = value;
  }

  /**
   * Method returns attribute {@link #myShort}.<br/>
   *
   * @return {@link Short} Value to which {@link #myShort} is set.
   */
  @JEAFCustomAnnotationTest
  public Short getMyShort( ) {
    return myShort;
  }

  /**
   * Method sets attribute {@link #myShort}.<br/>
   *
   * @param pMyShort Value to which {@link #myShort} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyShort( Short pMyShort ) {
    // Assign value to attribute
    myShort = pMyShort;
  }

  public int getMyShortXYZ( ) {
    // "java.lang.Short"
    return myShortXYZ;
  }

  public void setMyShortXYZ( int value ) {
    myShortXYZ = value;
  }

  /**
   * Method returns attribute {@link #myByteArray}.<br/>
   *
   * @return byte[] Value to which {@link #myByteArray} is set.
   */
  @JEAFCustomAnnotationTest
  public byte[] getMyByteArray( ) {
    byte[] lReturnValue;
    if (myByteArray != null) {
      lReturnValue = new byte[myByteArray.length];
      System.arraycopy(myByteArray, 0, lReturnValue, 0, myByteArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #myByteArray}.<br/>
   *
   * @param pMyByteArray Value to which {@link #myByteArray} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyByteArray( byte[] pMyByteArray ) {
    // Assign value to attribute
    if (pMyByteArray != null) {
      myByteArray = new byte[pMyByteArray.length];
      System.arraycopy(pMyByteArray, 0, myByteArray, 0, pMyByteArray.length);
    }
    else {
      myByteArray = null;
    }
  }

  public int getMyByteArrayXYZ( ) {
    // "byte"
    return myByteArrayXYZ;
  }

  public void setMyByteArrayXYZ( int value ) {
    myByteArrayXYZ = value;
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
    lBuilder.append("myBoolean: ");
    lBuilder.append(myBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myByte: ");
    lBuilder.append(myByte);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myCharacter: ");
    lBuilder.append(myCharacter);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myDouble: ");
    lBuilder.append(myDouble);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myFloat: ");
    lBuilder.append(myFloat);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myLong: ");
    lBuilder.append(myLong);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("myShort: ");
    lBuilder.append(myShort);
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
   * @return {@link Builder} New builder that can be used to create new WrapperDatatypeServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}