/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class SimpleDatatypeServiceObject extends Object implements ServiceObject, Identifiable<ServiceObjectID> {
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
   * Constant for the name of attribute "myChar".
   */
  @JEAFCustomAnnotationTest
  public static final String MYCHAR = "myChar";

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

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  // "boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private boolean myBoolean;

  // "boolean"
  private int myBooleanXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private byte myByte;

  // "byte"
  private int myByteXYZ = 0;

  // "char"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private char myChar;

  // "char"
  private int myCharXYZ = 0;

  // "double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private double myDouble;

  // "double"
  private int myDoubleXYZ = 0;

  // "float"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private float myFloat;

  // "float"
  private int myFloatXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private long myLong;

  // "long"
  private int myLongXYZ = 0;

  // "short"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private short myShort;

  // "short"
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
  protected SimpleDatatypeServiceObject( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SimpleDatatypeServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    myBoolean = pBuilder.myBoolean;
    // "boolean"
    myBooleanXYZ = pBuilder.myBooleanXYZ;
    myByte = pBuilder.myByte;
    // "byte"
    myByteXYZ = pBuilder.myByteXYZ;
    myChar = pBuilder.myChar;
    // "char"
    myCharXYZ = pBuilder.myCharXYZ;
    myDouble = pBuilder.myDouble;
    // "double"
    myDoubleXYZ = pBuilder.myDoubleXYZ;
    myFloat = pBuilder.myFloat;
    // "float"
    myFloatXYZ = pBuilder.myFloatXYZ;
    myLong = pBuilder.myLong;
    // "long"
    myLongXYZ = pBuilder.myLongXYZ;
    myShort = pBuilder.myShort;
    // "short"
    myShortXYZ = pBuilder.myShortXYZ;
    myByteArray = pBuilder.myByteArray;
    // "byte"
    myByteArrayXYZ = pBuilder.myByteArrayXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SimpleDatatypeServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>SimpleDatatypeServiceObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    // "boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private boolean myBoolean;

    // "boolean"
    private int myBooleanXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private byte myByte;

    // "byte"
    private int myByteXYZ = 0;

    // "char"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private char myChar;

    // "char"
    private int myCharXYZ = 0;

    // "double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private double myDouble;

    // "double"
    private int myDoubleXYZ = 0;

    // "float"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private float myFloat;

    // "float"
    private int myFloatXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private long myLong;

    // "long"
    private int myLongXYZ = 0;

    // "short"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private short myShort;

    // "short"
    private int myShortXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private byte[] myByteArray;

    // "byte"
    private int myByteArrayXYZ = 0;

    /**
     * Use {@link SimpleDatatypeServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SimpleDatatypeServiceObject#builder(SimpleDatatypeServiceObject)} instead of private constructor to
     * create new builder.
     */
    protected Builder( SimpleDatatypeServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setMyBoolean(pObject.myBoolean);
        this.setMyByte(pObject.myByte);
        this.setMyChar(pObject.myChar);
        this.setMyDouble(pObject.myDouble);
        this.setMyFloat(pObject.myFloat);
        this.setMyLong(pObject.myLong);
        this.setMyShort(pObject.myShort);
        this.setMyByteArray(pObject.myByteArray);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets attribute {@link #myBoolean}.<br/>
     *
     * @param pMyBoolean Value to which {@link #myBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyBoolean( boolean pMyBoolean ) {
      // Assign value to attribute
      myBoolean = pMyBoolean;
      return this;
    }

    public Builder setMyBooleanXYZ( int value ) {
      // "boolean"
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
    public Builder setMyByte( byte pMyByte ) {
      // Assign value to attribute
      myByte = pMyByte;
      return this;
    }

    public Builder setMyByteXYZ( int value ) {
      // "byte"
      myByteXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myChar}.<br/>
     *
     * @param pMyChar Value to which {@link #myChar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyChar( char pMyChar ) {
      // Assign value to attribute
      myChar = pMyChar;
      return this;
    }

    public Builder setMyCharXYZ( int value ) {
      // "char"
      myCharXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #myDouble}.<br/>
     *
     * @param pMyDouble Value to which {@link #myDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyDouble( double pMyDouble ) {
      // Assign value to attribute
      myDouble = pMyDouble;
      return this;
    }

    public Builder setMyDoubleXYZ( int value ) {
      // "double"
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
    public Builder setMyFloat( float pMyFloat ) {
      // Assign value to attribute
      myFloat = pMyFloat;
      return this;
    }

    public Builder setMyFloatXYZ( int value ) {
      // "float"
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
    public Builder setMyLong( long pMyLong ) {
      // Assign value to attribute
      myLong = pMyLong;
      return this;
    }

    public Builder setMyLongXYZ( int value ) {
      // "long"
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
    public Builder setMyShort( short pMyShort ) {
      // Assign value to attribute
      myShort = pMyShort;
      return this;
    }

    public Builder setMyShortXYZ( int value ) {
      // "short"
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
     * Method creates a new instance of class SimpleDatatypeServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return SimpleDatatypeServiceObject Created object. The method never returns null.
     */
    public SimpleDatatypeServiceObject build( ) {
      return new SimpleDatatypeServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class SimpleDatatypeServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return SimpleDatatypeServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SimpleDatatypeServiceObject buildValidated( ) throws ConstraintViolationException {
      SimpleDatatypeServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns attribute {@link #myBoolean}.<br/>
   *
   * @return boolean Value to which {@link #myBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  public boolean getMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method returns attribute {@link #myBoolean}.<br/>
   *
   * @return boolean Value to which {@link #myBoolean} is set.
   */
  @JEAFCustomAnnotationTest
  public boolean isMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method sets attribute {@link #myBoolean}.<br/>
   *
   * @param pMyBoolean Value to which {@link #myBoolean} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyBoolean( boolean pMyBoolean ) {
    // Assign value to attribute
    myBoolean = pMyBoolean;
  }

  public int getMyBooleanXYZ( ) {
    // "boolean"
    return myBooleanXYZ;
  }

  public void setMyBooleanXYZ( int value ) {
    myBooleanXYZ = value;
  }

  /**
   * Method returns attribute {@link #myByte}.<br/>
   *
   * @return byte Value to which {@link #myByte} is set.
   */
  @JEAFCustomAnnotationTest
  public byte getMyByte( ) {
    return myByte;
  }

  /**
   * Method sets attribute {@link #myByte}.<br/>
   *
   * @param pMyByte Value to which {@link #myByte} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyByte( byte pMyByte ) {
    // Assign value to attribute
    myByte = pMyByte;
  }

  public int getMyByteXYZ( ) {
    // "byte"
    return myByteXYZ;
  }

  public void setMyByteXYZ( int value ) {
    myByteXYZ = value;
  }

  /**
   * Method returns attribute {@link #myChar}.<br/>
   *
   * @return char Value to which {@link #myChar} is set.
   */
  @JEAFCustomAnnotationTest
  public char getMyChar( ) {
    return myChar;
  }

  /**
   * Method sets attribute {@link #myChar}.<br/>
   *
   * @param pMyChar Value to which {@link #myChar} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyChar( char pMyChar ) {
    // Assign value to attribute
    myChar = pMyChar;
  }

  public int getMyCharXYZ( ) {
    // "char"
    return myCharXYZ;
  }

  public void setMyCharXYZ( int value ) {
    myCharXYZ = value;
  }

  /**
   * Method returns attribute {@link #myDouble}.<br/>
   *
   * @return double Value to which {@link #myDouble} is set.
   */
  @JEAFCustomAnnotationTest
  public double getMyDouble( ) {
    return myDouble;
  }

  /**
   * Method sets attribute {@link #myDouble}.<br/>
   *
   * @param pMyDouble Value to which {@link #myDouble} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyDouble( double pMyDouble ) {
    // Assign value to attribute
    myDouble = pMyDouble;
  }

  public int getMyDoubleXYZ( ) {
    // "double"
    return myDoubleXYZ;
  }

  public void setMyDoubleXYZ( int value ) {
    myDoubleXYZ = value;
  }

  /**
   * Method returns attribute {@link #myFloat}.<br/>
   *
   * @return float Value to which {@link #myFloat} is set.
   */
  @JEAFCustomAnnotationTest
  public float getMyFloat( ) {
    return myFloat;
  }

  /**
   * Method sets attribute {@link #myFloat}.<br/>
   *
   * @param pMyFloat Value to which {@link #myFloat} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyFloat( float pMyFloat ) {
    // Assign value to attribute
    myFloat = pMyFloat;
  }

  public int getMyFloatXYZ( ) {
    // "float"
    return myFloatXYZ;
  }

  public void setMyFloatXYZ( int value ) {
    myFloatXYZ = value;
  }

  /**
   * Method returns attribute {@link #myLong}.<br/>
   *
   * @return long Value to which {@link #myLong} is set.
   */
  @JEAFCustomAnnotationTest
  public long getMyLong( ) {
    return myLong;
  }

  /**
   * Method sets attribute {@link #myLong}.<br/>
   *
   * @param pMyLong Value to which {@link #myLong} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyLong( long pMyLong ) {
    // Assign value to attribute
    myLong = pMyLong;
  }

  public int getMyLongXYZ( ) {
    // "long"
    return myLongXYZ;
  }

  public void setMyLongXYZ( int value ) {
    myLongXYZ = value;
  }

  /**
   * Method returns attribute {@link #myShort}.<br/>
   *
   * @return short Value to which {@link #myShort} is set.
   */
  @JEAFCustomAnnotationTest
  public short getMyShort( ) {
    return myShort;
  }

  /**
   * Method sets attribute {@link #myShort}.<br/>
   *
   * @param pMyShort Value to which {@link #myShort} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyShort( short pMyShort ) {
    // Assign value to attribute
    myShort = pMyShort;
  }

  public int getMyShortXYZ( ) {
    // "short"
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
    lBuilder.append("myChar: ");
    lBuilder.append(myChar);
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
   * @return {@link Builder} New builder that can be used to create new SimpleDatatypeServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}