/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private boolean aBoolean;

  /**
   * 
   */
  private byte aByte;

  /**
   * 
   */
  private short aShort;

  /**
   * 
   */
  private int aInt;

  /**
   * 
   */
  private long aLong;

  /**
   * 
   */
  private float aFloat;

  /**
   * 
   */
  private double aDouble;

  /**
   * 
   */
  private char aChar;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveServiceObject( ) {
    // Nothing to do.
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
   * Class implements builder to create a new instance of class PrimitiveServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean aBoolean;

    /**
     * 
     */
    private byte aByte;

    /**
     * 
     */
    private short aShort;

    /**
     * 
     */
    private int aInt;

    /**
     * 
     */
    private long aLong;

    /**
     * 
     */
    private float aFloat;

    /**
     * 
     */
    private double aDouble;

    /**
     * 
     */
    private char aChar;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PrimitiveServiceObject)} instead of private constructor to create new builder.
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
     * @return {@link Builder} New builder that can be used to create new PrimitiveServiceObject objects. The method
     * never returns null.
     */
    public static Builder newBuilder( PrimitiveServiceObject pObject ) {
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
     * Method sets the attribute "aInt".
     * 
     * @param pAInt Value to which the attribute "aInt" should be set.
     */
    public Builder setAInt( int pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
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
     * Method sets the attribute "aChar".
     * 
     * @param pAChar Value to which the attribute "aChar" should be set.
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
      PrimitiveServiceObject lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
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
   * Method returns the attribute "aInt".
   * 
   * 
   * @return int Value to which the attribute "aInt" is set.
   */
  public int getAInt( ) {
    return aInt;
  }

  /**
   * Method sets the attribute "aInt".
   * 
   * 
   * @param pAInt Value to which the attribute "aInt" should be set.
   */
  public void setAInt( int pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
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
   * Method returns the attribute "aChar".
   * 
   * 
   * @return char Value to which the attribute "aChar" is set.
   */
  public char getAChar( ) {
    return aChar;
  }

  /**
   * Method sets the attribute "aChar".
   * 
   * 
   * @param pAChar Value to which the attribute "aChar" should be set.
   */
  public void setAChar( char pAChar ) {
    // Assign value to attribute
    aChar = pAChar;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aByte", "" + aByte));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aShort", "" + aShort));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aInt", "" + aInt));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aLong", "" + aLong));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aFloat", "" + aFloat));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aDouble", "" + aDouble));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aChar", "" + aChar));
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
