/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class WrapperTypesServiceObject implements ServiceObject {
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
  private Boolean aBoolean;

  /**
   * 
   */
  private Byte aByte;

  /**
   * 
   */
  private Short aShort;

  /**
   * 
   */
  private Integer aInt;

  /**
   * 
   */
  private Long aLong;

  /**
   * 
   */
  private Float aFloat;

  /**
   * 
   */
  private Double aDouble;

  /**
   * 
   */
  private Character aChar;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * @return {@link Builder} New builder that can be used to create new WrapperTypesServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new WrapperTypesServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( WrapperTypesServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class WrapperTypesServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Boolean aBoolean;

    /**
     * 
     */
    private Byte aByte;

    /**
     * 
     */
    private Short aShort;

    /**
     * 
     */
    private Integer aInt;

    /**
     * 
     */
    private Long aLong;

    /**
     * 
     */
    private Float aFloat;

    /**
     * 
     */
    private Double aDouble;

    /**
     * 
     */
    private Character aChar;

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
     * Method sets the attribute "aBoolean".
     * 
     * @param pABoolean Value to which the attribute "aBoolean" should be set.
     */
    public Builder setABoolean( Boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets the attribute "aByte".
     * 
     * @param pAByte Value to which the attribute "aByte" should be set.
     */
    public Builder setAByte( Byte pAByte ) {
      // Assign value to attribute
      aByte = pAByte;
      return this;
    }

    /**
     * Method sets the attribute "aShort".
     * 
     * @param pAShort Value to which the attribute "aShort" should be set.
     */
    public Builder setAShort( Short pAShort ) {
      // Assign value to attribute
      aShort = pAShort;
      return this;
    }

    /**
     * Method sets the attribute "aInt".
     * 
     * @param pAInt Value to which the attribute "aInt" should be set.
     */
    public Builder setAInt( Integer pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
      return this;
    }

    /**
     * Method sets the attribute "aLong".
     * 
     * @param pALong Value to which the attribute "aLong" should be set.
     */
    public Builder setALong( Long pALong ) {
      // Assign value to attribute
      aLong = pALong;
      return this;
    }

    /**
     * Method sets the attribute "aFloat".
     * 
     * @param pAFloat Value to which the attribute "aFloat" should be set.
     */
    public Builder setAFloat( Float pAFloat ) {
      // Assign value to attribute
      aFloat = pAFloat;
      return this;
    }

    /**
     * Method sets the attribute "aDouble".
     * 
     * @param pADouble Value to which the attribute "aDouble" should be set.
     */
    public Builder setADouble( Double pADouble ) {
      // Assign value to attribute
      aDouble = pADouble;
      return this;
    }

    /**
     * Method sets the attribute "aChar".
     * 
     * @param pAChar Value to which the attribute "aChar" should be set.
     */
    public Builder setAChar( Character pAChar ) {
      // Assign value to attribute
      aChar = pAChar;
      return this;
    }

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
      WrapperTypesServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "aBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "aBoolean" is set.
   */
  public Boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets the attribute "aBoolean".
   * 
   * 
   * @param pABoolean Value to which the attribute "aBoolean" should be set.
   */
  public void setABoolean( Boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  /**
   * Method returns the attribute "aByte".
   * 
   * 
   * @return Byte Value to which the attribute "aByte" is set.
   */
  public Byte getAByte( ) {
    return aByte;
  }

  /**
   * Method sets the attribute "aByte".
   * 
   * 
   * @param pAByte Value to which the attribute "aByte" should be set.
   */
  public void setAByte( Byte pAByte ) {
    // Assign value to attribute
    aByte = pAByte;
  }

  /**
   * Method returns the attribute "aShort".
   * 
   * 
   * @return Short Value to which the attribute "aShort" is set.
   */
  public Short getAShort( ) {
    return aShort;
  }

  /**
   * Method sets the attribute "aShort".
   * 
   * 
   * @param pAShort Value to which the attribute "aShort" should be set.
   */
  public void setAShort( Short pAShort ) {
    // Assign value to attribute
    aShort = pAShort;
  }

  /**
   * Method returns the attribute "aInt".
   * 
   * 
   * @return Integer Value to which the attribute "aInt" is set.
   */
  public Integer getAInt( ) {
    return aInt;
  }

  /**
   * Method sets the attribute "aInt".
   * 
   * 
   * @param pAInt Value to which the attribute "aInt" should be set.
   */
  public void setAInt( Integer pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
  }

  /**
   * Method returns the attribute "aLong".
   * 
   * 
   * @return Long Value to which the attribute "aLong" is set.
   */
  public Long getALong( ) {
    return aLong;
  }

  /**
   * Method sets the attribute "aLong".
   * 
   * 
   * @param pALong Value to which the attribute "aLong" should be set.
   */
  public void setALong( Long pALong ) {
    // Assign value to attribute
    aLong = pALong;
  }

  /**
   * Method returns the attribute "aFloat".
   * 
   * 
   * @return Float Value to which the attribute "aFloat" is set.
   */
  public Float getAFloat( ) {
    return aFloat;
  }

  /**
   * Method sets the attribute "aFloat".
   * 
   * 
   * @param pAFloat Value to which the attribute "aFloat" should be set.
   */
  public void setAFloat( Float pAFloat ) {
    // Assign value to attribute
    aFloat = pAFloat;
  }

  /**
   * Method returns the attribute "aDouble".
   * 
   * 
   * @return Double Value to which the attribute "aDouble" is set.
   */
  public Double getADouble( ) {
    return aDouble;
  }

  /**
   * Method sets the attribute "aDouble".
   * 
   * 
   * @param pADouble Value to which the attribute "aDouble" should be set.
   */
  public void setADouble( Double pADouble ) {
    // Assign value to attribute
    aDouble = pADouble;
  }

  /**
   * Method returns the attribute "aChar".
   * 
   * 
   * @return Character Value to which the attribute "aChar" is set.
   */
  public Character getAChar( ) {
    return aChar;
  }

  /**
   * Method sets the attribute "aChar".
   * 
   * 
   * @param pAChar Value to which the attribute "aChar" should be set.
   */
  public void setAChar( Character pAChar ) {
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
