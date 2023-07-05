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

public class WrapperDatatypeServiceObject implements ServiceObject {
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
   * Constant for the name of attribute "myCharacter".
   */
  public static final String MYCHARACTER = "myCharacter";

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

  private Boolean myBoolean;

  private Byte myByte;

  private Character myCharacter;

  private Double myDouble;

  private Float myFloat;

  private Long myLong;

  private Short myShort;

  private byte[] myByteArray;

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
    myByte = pBuilder.myByte;
    myCharacter = pBuilder.myCharacter;
    myDouble = pBuilder.myDouble;
    myFloat = pBuilder.myFloat;
    myLong = pBuilder.myLong;
    myShort = pBuilder.myShort;
    myByteArray = pBuilder.myByteArray;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new WrapperDatatypeServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( WrapperDatatypeServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>WrapperDatatypeServiceObject</code>.
   */
  public static class Builder {
    private Boolean myBoolean;

    private Byte myByte;

    private Character myCharacter;

    private Double myDouble;

    private Float myFloat;

    private Long myLong;

    private Short myShort;

    private byte[] myByteArray;

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
        myBoolean = pObject.myBoolean;
        myByte = pObject.myByte;
        myCharacter = pObject.myCharacter;
        myDouble = pObject.myDouble;
        myFloat = pObject.myFloat;
        myLong = pObject.myLong;
        myShort = pObject.myShort;
        myByteArray = pObject.myByteArray;
      }
    }

    /**
     * Method sets attribute {@link #myBoolean}.<br/>
     *
     * @param pMyBoolean Value to which {@link #myBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyBoolean( Boolean pMyBoolean ) {
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
    public Builder setMyByte( Byte pMyByte ) {
      // Assign value to attribute
      myByte = pMyByte;
      return this;
    }

    /**
     * Method sets attribute {@link #myCharacter}.<br/>
     *
     * @param pMyCharacter Value to which {@link #myCharacter} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyCharacter( Character pMyCharacter ) {
      // Assign value to attribute
      myCharacter = pMyCharacter;
      return this;
    }

    /**
     * Method sets attribute {@link #myDouble}.<br/>
     *
     * @param pMyDouble Value to which {@link #myDouble} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyDouble( Double pMyDouble ) {
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
    public Builder setMyFloat( Float pMyFloat ) {
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
    public Builder setMyLong( Long pMyLong ) {
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
    public Builder setMyShort( Short pMyShort ) {
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
     * Method creates a new instance of class WrapperDatatypeServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return WrapperDatatypeServiceObject Created object. The method never returns null.
     */
    public WrapperDatatypeServiceObject build( ) {
      WrapperDatatypeServiceObject lObject = new WrapperDatatypeServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
  public Boolean getMyBoolean( ) {
    return myBoolean;
  }

  /**
   * Method sets attribute {@link #myBoolean}.<br/>
   *
   * @param pMyBoolean Value to which {@link #myBoolean} should be set.
   */
  public void setMyBoolean( Boolean pMyBoolean ) {
    // Assign value to attribute
    myBoolean = pMyBoolean;
  }

  /**
   * Method returns attribute {@link #myByte}.<br/>
   *
   * @return {@link Byte} Value to which {@link #myByte} is set.
   */
  public Byte getMyByte( ) {
    return myByte;
  }

  /**
   * Method sets attribute {@link #myByte}.<br/>
   *
   * @param pMyByte Value to which {@link #myByte} should be set.
   */
  public void setMyByte( Byte pMyByte ) {
    // Assign value to attribute
    myByte = pMyByte;
  }

  /**
   * Method returns attribute {@link #myCharacter}.<br/>
   *
   * @return {@link Character} Value to which {@link #myCharacter} is set.
   */
  public Character getMyCharacter( ) {
    return myCharacter;
  }

  /**
   * Method sets attribute {@link #myCharacter}.<br/>
   *
   * @param pMyCharacter Value to which {@link #myCharacter} should be set.
   */
  public void setMyCharacter( Character pMyCharacter ) {
    // Assign value to attribute
    myCharacter = pMyCharacter;
  }

  /**
   * Method returns attribute {@link #myDouble}.<br/>
   *
   * @return {@link Double} Value to which {@link #myDouble} is set.
   */
  public Double getMyDouble( ) {
    return myDouble;
  }

  /**
   * Method sets attribute {@link #myDouble}.<br/>
   *
   * @param pMyDouble Value to which {@link #myDouble} should be set.
   */
  public void setMyDouble( Double pMyDouble ) {
    // Assign value to attribute
    myDouble = pMyDouble;
  }

  /**
   * Method returns attribute {@link #myFloat}.<br/>
   *
   * @return {@link Float} Value to which {@link #myFloat} is set.
   */
  public Float getMyFloat( ) {
    return myFloat;
  }

  /**
   * Method sets attribute {@link #myFloat}.<br/>
   *
   * @param pMyFloat Value to which {@link #myFloat} should be set.
   */
  public void setMyFloat( Float pMyFloat ) {
    // Assign value to attribute
    myFloat = pMyFloat;
  }

  /**
   * Method returns attribute {@link #myLong}.<br/>
   *
   * @return {@link Long} Value to which {@link #myLong} is set.
   */
  public Long getMyLong( ) {
    return myLong;
  }

  /**
   * Method sets attribute {@link #myLong}.<br/>
   *
   * @param pMyLong Value to which {@link #myLong} should be set.
   */
  public void setMyLong( Long pMyLong ) {
    // Assign value to attribute
    myLong = pMyLong;
  }

  /**
   * Method returns attribute {@link #myShort}.<br/>
   *
   * @return {@link Short} Value to which {@link #myShort} is set.
   */
  public Short getMyShort( ) {
    return myShort;
  }

  /**
   * Method sets attribute {@link #myShort}.<br/>
   *
   * @param pMyShort Value to which {@link #myShort} should be set.
   */
  public void setMyShort( Short pMyShort ) {
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
}
