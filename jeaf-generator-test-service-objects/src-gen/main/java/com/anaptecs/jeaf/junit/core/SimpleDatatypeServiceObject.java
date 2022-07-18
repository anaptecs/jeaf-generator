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
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private boolean myBoolean;

  /**
   * 
   */
  private byte myByte;

  /**
   * 
   */
  private char myChar;

  /**
   * 
   */
  private double myDouble;

  /**
   * 
   */
  private float myFloat;

  /**
   * 
   */
  private long myLong;

  /**
   * 
   */
  private short myShort;

  /**
   * 
   */
  private byte[] myByteArray;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class SimpleDatatypeServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    /**
     * 
     */
    private boolean myBoolean;

    /**
     * 
     */
    private byte myByte;

    /**
     * 
     */
    private char myChar;

    /**
     * 
     */
    private double myDouble;

    /**
     * 
     */
    private float myFloat;

    /**
     * 
     */
    private long myLong;

    /**
     * 
     */
    private short myShort;

    /**
     * 
     */
    private byte[] myByteArray;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(SimpleDatatypeServiceObject)} instead of private constructor to create new builder.
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new SimpleDatatypeServiceObject objects. The
     * method never returns null.
     */
    public static Builder newBuilder( SimpleDatatypeServiceObject pObject ) {
      return new Builder(pObject);
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
     * Method sets the attribute "myBoolean".
     * 
     * @param pMyBoolean Value to which the attribute "myBoolean" should be set.
     */
    public Builder setMyBoolean( boolean pMyBoolean ) {
      // Assign value to attribute
      myBoolean = pMyBoolean;
      return this;
    }

    /**
     * Method sets the attribute "myByte".
     * 
     * @param pMyByte Value to which the attribute "myByte" should be set.
     */
    public Builder setMyByte( byte pMyByte ) {
      // Assign value to attribute
      myByte = pMyByte;
      return this;
    }

    /**
     * Method sets the attribute "myChar".
     * 
     * @param pMyChar Value to which the attribute "myChar" should be set.
     */
    public Builder setMyChar( char pMyChar ) {
      // Assign value to attribute
      myChar = pMyChar;
      return this;
    }

    /**
     * Method sets the attribute "myDouble".
     * 
     * @param pMyDouble Value to which the attribute "myDouble" should be set.
     */
    public Builder setMyDouble( double pMyDouble ) {
      // Assign value to attribute
      myDouble = pMyDouble;
      return this;
    }

    /**
     * Method sets the attribute "myFloat".
     * 
     * @param pMyFloat Value to which the attribute "myFloat" should be set.
     */
    public Builder setMyFloat( float pMyFloat ) {
      // Assign value to attribute
      myFloat = pMyFloat;
      return this;
    }

    /**
     * Method sets the attribute "myLong".
     * 
     * @param pMyLong Value to which the attribute "myLong" should be set.
     */
    public Builder setMyLong( long pMyLong ) {
      // Assign value to attribute
      myLong = pMyLong;
      return this;
    }

    /**
     * Method sets the attribute "myShort".
     * 
     * @param pMyShort Value to which the attribute "myShort" should be set.
     */
    public Builder setMyShort( short pMyShort ) {
      // Assign value to attribute
      myShort = pMyShort;
      return this;
    }

    /**
     * Method sets the attribute "myByteArray".
     * 
     * @param pMyByteArray Value to which the attribute "myByteArray" should be set.
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
      SimpleDatatypeServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
   * Method returns the attribute "myBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "myBoolean" is set.
   */
  public boolean getMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method sets the attribute "myBoolean".
   * 
   * 
   * @param pMyBoolean Value to which the attribute "myBoolean" should be set.
   */
  public void setMyBoolean( boolean pMyBoolean ) {
    // Assign value to attribute
    myBoolean = pMyBoolean;
  }

  /**
   * Method returns the attribute "myByte".
   * 
   * 
   * @return byte Value to which the attribute "myByte" is set.
   */
  public byte getMyByte( ) {
    return myByte;
  }

  /**
   * Method sets the attribute "myByte".
   * 
   * 
   * @param pMyByte Value to which the attribute "myByte" should be set.
   */
  public void setMyByte( byte pMyByte ) {
    // Assign value to attribute
    myByte = pMyByte;
  }

  /**
   * Method returns the attribute "myChar".
   * 
   * 
   * @return char Value to which the attribute "myChar" is set.
   */
  public char getMyChar( ) {
    return myChar;
  }

  /**
   * Method sets the attribute "myChar".
   * 
   * 
   * @param pMyChar Value to which the attribute "myChar" should be set.
   */
  public void setMyChar( char pMyChar ) {
    // Assign value to attribute
    myChar = pMyChar;
  }

  /**
   * Method returns the attribute "myDouble".
   * 
   * 
   * @return double Value to which the attribute "myDouble" is set.
   */
  public double getMyDouble( ) {
    return myDouble;
  }

  /**
   * Method sets the attribute "myDouble".
   * 
   * 
   * @param pMyDouble Value to which the attribute "myDouble" should be set.
   */
  public void setMyDouble( double pMyDouble ) {
    // Assign value to attribute
    myDouble = pMyDouble;
  }

  /**
   * Method returns the attribute "myFloat".
   * 
   * 
   * @return float Value to which the attribute "myFloat" is set.
   */
  public float getMyFloat( ) {
    return myFloat;
  }

  /**
   * Method sets the attribute "myFloat".
   * 
   * 
   * @param pMyFloat Value to which the attribute "myFloat" should be set.
   */
  public void setMyFloat( float pMyFloat ) {
    // Assign value to attribute
    myFloat = pMyFloat;
  }

  /**
   * Method returns the attribute "myLong".
   * 
   * 
   * @return long Value to which the attribute "myLong" is set.
   */
  public long getMyLong( ) {
    return myLong;
  }

  /**
   * Method sets the attribute "myLong".
   * 
   * 
   * @param pMyLong Value to which the attribute "myLong" should be set.
   */
  public void setMyLong( long pMyLong ) {
    // Assign value to attribute
    myLong = pMyLong;
  }

  /**
   * Method returns the attribute "myShort".
   * 
   * 
   * @return short Value to which the attribute "myShort" is set.
   */
  public short getMyShort( ) {
    return myShort;
  }

  /**
   * Method sets the attribute "myShort".
   * 
   * 
   * @param pMyShort Value to which the attribute "myShort" should be set.
   */
  public void setMyShort( short pMyShort ) {
    // Assign value to attribute
    myShort = pMyShort;
  }

  /**
   * Method returns the attribute "myByteArray".
   * 
   * 
   * @return byte Value to which the attribute "myByteArray" is set.
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
   * Method sets the attribute "myByteArray".
   * 
   * 
   * @param pMyByteArray Value to which the attribute "myByteArray" should be set.
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myBoolean", "" + myBoolean));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myByte", "" + myByte));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myChar", "" + myChar));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myDouble", "" + myDouble));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myFloat", "" + myFloat));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myLong", "" + myLong));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "myShort", "" + myShort));
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
