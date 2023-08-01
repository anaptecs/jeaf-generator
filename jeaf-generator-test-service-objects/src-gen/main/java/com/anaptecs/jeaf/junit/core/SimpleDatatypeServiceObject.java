/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class SimpleDatatypeServiceObject implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "myBoolean".
   */
  public static final String MYBOOLEAN = "myBoolean";

  /**
   * Constant for the name of attribute "myByte".
   */
  public static final String MYBYTE = "myByte";

  /**
   * Constant for the name of attribute "myChar".
   */
  public static final String MYCHAR = "myChar";

  /**
   * Constant for the name of attribute "myDouble".
   */
  public static final String MYDOUBLE = "myDouble";

  /**
   * Constant for the name of attribute "myFloat".
   */
  public static final String MYFLOAT = "myFloat";

  /**
   * Constant for the name of attribute "myLong".
   */
  public static final String MYLONG = "myLong";

  /**
   * Constant for the name of attribute "myShort".
   */
  public static final String MYSHORT = "myShort";

  /**
   * Constant for the name of attribute "myByteArray".
   */
  public static final String MYBYTEARRAY = "myByteArray";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  private boolean myBoolean;

  private byte myByte;

  private char myChar;

  private double myDouble;

  private float myFloat;

  private long myLong;

  private short myShort;

  private byte[] myByteArray;

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
    myByte = pBuilder.myByte;
    myChar = pBuilder.myChar;
    myDouble = pBuilder.myDouble;
    myFloat = pBuilder.myFloat;
    myLong = pBuilder.myLong;
    myShort = pBuilder.myShort;
    myByteArray = pBuilder.myByteArray;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SimpleDatatypeServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( SimpleDatatypeServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class SimpleDatatypeServiceObject.
   *
   *
   * @param pMyBoolean Value to which {@link #myBoolean} should be set.
   *
   * @param pMyByte Value to which {@link #myByte} should be set.
   *
   * @param pMyChar Value to which {@link #myChar} should be set.
   *
   * @param pMyDouble Value to which {@link #myDouble} should be set.
   *
   * @param pMyFloat Value to which {@link #myFloat} should be set.
   *
   * @param pMyLong Value to which {@link #myLong} should be set.
   *
   * @param pMyShort Value to which {@link #myShort} should be set.
   *
   * @param pMyByteArray Value to which {@link #myByteArray} should be set.
   *
   * @return {@link SimpleDatatypeServiceObject}
   */
  public static SimpleDatatypeServiceObject of( boolean pMyBoolean, byte pMyByte, char pMyChar, double pMyDouble,
      float pMyFloat, long pMyLong, short pMyShort, byte[] pMyByteArray ) {
    SimpleDatatypeServiceObject.Builder lBuilder = SimpleDatatypeServiceObject.builder();
    lBuilder.setMyBoolean(pMyBoolean);
    lBuilder.setMyByte(pMyByte);
    lBuilder.setMyChar(pMyChar);
    lBuilder.setMyDouble(pMyDouble);
    lBuilder.setMyFloat(pMyFloat);
    lBuilder.setMyLong(pMyLong);
    lBuilder.setMyShort(pMyShort);
    lBuilder.setMyByteArray(pMyByteArray);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SimpleDatatypeServiceObject</code>.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    private boolean myBoolean;

    private byte myByte;

    private char myChar;

    private double myDouble;

    private float myFloat;

    private long myLong;

    private short myShort;

    private byte[] myByteArray;

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
        myBoolean = pObject.myBoolean;
        myByte = pObject.myByte;
        myChar = pObject.myChar;
        myDouble = pObject.myDouble;
        myFloat = pObject.myFloat;
        myLong = pObject.myLong;
        myShort = pObject.myShort;
        myByteArray = pObject.myByteArray;
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
    public Builder setMyBoolean( boolean pMyBoolean ) {
      // Assign value to attribute
      myBoolean = pMyBoolean;
      return this;
    }

    /**
     * Method sets attribute {@link #myByte}.<br/>
     *
     * @param pMyByte Value to which {@link #myByte} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyByte( byte pMyByte ) {
      // Assign value to attribute
      myByte = pMyByte;
      return this;
    }

    /**
     * Method sets attribute {@link #myChar}.<br/>
     *
     * @param pMyChar Value to which {@link #myChar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyChar( char pMyChar ) {
      // Assign value to attribute
      myChar = pMyChar;
      return this;
    }

    /**
     * Method sets attribute {@link #myDouble}.<br/>
     *
     * @param pMyDouble Value to which {@link #myDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyDouble( double pMyDouble ) {
      // Assign value to attribute
      myDouble = pMyDouble;
      return this;
    }

    /**
     * Method sets attribute {@link #myFloat}.<br/>
     *
     * @param pMyFloat Value to which {@link #myFloat} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyFloat( float pMyFloat ) {
      // Assign value to attribute
      myFloat = pMyFloat;
      return this;
    }

    /**
     * Method sets attribute {@link #myLong}.<br/>
     *
     * @param pMyLong Value to which {@link #myLong} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyLong( long pMyLong ) {
      // Assign value to attribute
      myLong = pMyLong;
      return this;
    }

    /**
     * Method sets attribute {@link #myShort}.<br/>
     *
     * @param pMyShort Value to which {@link #myShort} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyShort( short pMyShort ) {
      // Assign value to attribute
      myShort = pMyShort;
      return this;
    }

    /**
     * Method sets attribute {@link #myByteArray}.<br/>
     *
     * @param pMyByteArray Value to which {@link #myByteArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
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

    /**
     * Method creates a new instance of class SimpleDatatypeServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return SimpleDatatypeServiceObject Created object. The method never returns null.
     */
    public SimpleDatatypeServiceObject build( ) {
      SimpleDatatypeServiceObject lObject = new SimpleDatatypeServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
  public boolean getMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method sets attribute {@link #myBoolean}.<br/>
   *
   * @param pMyBoolean Value to which {@link #myBoolean} should be set.
   */
  public void setMyBoolean( boolean pMyBoolean ) {
    // Assign value to attribute
    myBoolean = pMyBoolean;
  }

  /**
   * Method returns attribute {@link #myByte}.<br/>
   *
   * @return byte Value to which {@link #myByte} is set.
   */
  public byte getMyByte( ) {
    return myByte;
  }

  /**
   * Method sets attribute {@link #myByte}.<br/>
   *
   * @param pMyByte Value to which {@link #myByte} should be set.
   */
  public void setMyByte( byte pMyByte ) {
    // Assign value to attribute
    myByte = pMyByte;
  }

  /**
   * Method returns attribute {@link #myChar}.<br/>
   *
   * @return char Value to which {@link #myChar} is set.
   */
  public char getMyChar( ) {
    return myChar;
  }

  /**
   * Method sets attribute {@link #myChar}.<br/>
   *
   * @param pMyChar Value to which {@link #myChar} should be set.
   */
  public void setMyChar( char pMyChar ) {
    // Assign value to attribute
    myChar = pMyChar;
  }

  /**
   * Method returns attribute {@link #myDouble}.<br/>
   *
   * @return double Value to which {@link #myDouble} is set.
   */
  public double getMyDouble( ) {
    return myDouble;
  }

  /**
   * Method sets attribute {@link #myDouble}.<br/>
   *
   * @param pMyDouble Value to which {@link #myDouble} should be set.
   */
  public void setMyDouble( double pMyDouble ) {
    // Assign value to attribute
    myDouble = pMyDouble;
  }

  /**
   * Method returns attribute {@link #myFloat}.<br/>
   *
   * @return float Value to which {@link #myFloat} is set.
   */
  public float getMyFloat( ) {
    return myFloat;
  }

  /**
   * Method sets attribute {@link #myFloat}.<br/>
   *
   * @param pMyFloat Value to which {@link #myFloat} should be set.
   */
  public void setMyFloat( float pMyFloat ) {
    // Assign value to attribute
    myFloat = pMyFloat;
  }

  /**
   * Method returns attribute {@link #myLong}.<br/>
   *
   * @return long Value to which {@link #myLong} is set.
   */
  public long getMyLong( ) {
    return myLong;
  }

  /**
   * Method sets attribute {@link #myLong}.<br/>
   *
   * @param pMyLong Value to which {@link #myLong} should be set.
   */
  public void setMyLong( long pMyLong ) {
    // Assign value to attribute
    myLong = pMyLong;
  }

  /**
   * Method returns attribute {@link #myShort}.<br/>
   *
   * @return short Value to which {@link #myShort} is set.
   */
  public short getMyShort( ) {
    return myShort;
  }

  /**
   * Method sets attribute {@link #myShort}.<br/>
   *
   * @param pMyShort Value to which {@link #myShort} should be set.
   */
  public void setMyShort( short pMyShort ) {
    // Assign value to attribute
    myShort = pMyShort;
  }

  /**
   * Method returns attribute {@link #myByteArray}.<br/>
   *
   * @return byte Value to which {@link #myByteArray} is set.
   */
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
}
