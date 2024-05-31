/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
public class HeavyDataTypeUser extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanCode".
   */
  public static final String BOOLEANCODE = "booleanCode";

  /**
   * Constant for the name of attribute "byteCode".
   */
  public static final String BYTECODE = "byteCode";

  /**
   * Constant for the name of attribute "shortCode".
   */
  public static final String SHORTCODE = "shortCode";

  /**
   * Constant for the name of attribute "integerCode".
   */
  public static final String INTEGERCODE = "integerCode";

  /**
   * Constant for the name of attribute "floatCode".
   */
  public static final String FLOATCODE = "floatCode";

  /**
   * Constant for the name of attribute "doubleCode".
   */
  public static final String DOUBLECODE = "doubleCode";

  /**
   * Constant for the name of attribute "bigInegerCode".
   */
  public static final String BIGINEGERCODE = "bigInegerCode";

  /**
   * Constant for the name of attribute "bigDecimalCode".
   */
  public static final String BIGDECIMALCODE = "bigDecimalCode";

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
  @ClassPropertyDeclaration
  private BooleanCode booleanCode;

  // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
  private int booleanCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
  @ClassPropertyDeclaration
  private ByteCode byteCode;

  // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
  private int byteCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
  @ClassPropertyDeclaration
  private ShortCode shortCode;

  // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
  private int shortCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
  @ClassPropertyDeclaration
  private IntegerCode integerCode;

  // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
  private int integerCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
  @ClassPropertyDeclaration
  private FloatCode floatCode;

  // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
  private int floatCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
  @ClassPropertyDeclaration
  private DoubleCode doubleCode;

  // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
  private int doubleCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
  @ClassPropertyDeclaration
  private BigIntegerCode bigInegerCode;

  // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
  private int bigInegerCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
  @ClassPropertyDeclaration
  private BigDecimalCode bigDecimalCode;

  // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
  private int bigDecimalCodeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected HeavyDataTypeUser( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected HeavyDataTypeUser( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanCode = pBuilder.booleanCode;
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
    booleanCodeXYZ = pBuilder.booleanCodeXYZ;
    byteCode = pBuilder.byteCode;
    // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
    byteCodeXYZ = pBuilder.byteCodeXYZ;
    shortCode = pBuilder.shortCode;
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    shortCodeXYZ = pBuilder.shortCodeXYZ;
    integerCode = pBuilder.integerCode;
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    integerCodeXYZ = pBuilder.integerCodeXYZ;
    floatCode = pBuilder.floatCode;
    // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
    floatCodeXYZ = pBuilder.floatCodeXYZ;
    doubleCode = pBuilder.doubleCode;
    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    doubleCodeXYZ = pBuilder.doubleCodeXYZ;
    bigInegerCode = pBuilder.bigInegerCode;
    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    bigInegerCodeXYZ = pBuilder.bigInegerCodeXYZ;
    bigDecimalCode = pBuilder.bigDecimalCode;
    // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
    bigDecimalCodeXYZ = pBuilder.bigDecimalCodeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new HeavyDataTypeUser objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>HeavyDataTypeUser</code>.
   */
  public static class Builder {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
    @BuilderPropertyDeclaration
    private BooleanCode booleanCode;

    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
    private int booleanCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
    @BuilderPropertyDeclaration
    private ByteCode byteCode;

    // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
    private int byteCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    @BuilderPropertyDeclaration
    private ShortCode shortCode;

    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    private int shortCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    @BuilderPropertyDeclaration
    private IntegerCode integerCode;

    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    private int integerCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
    @BuilderPropertyDeclaration
    private FloatCode floatCode;

    // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
    private int floatCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    @BuilderPropertyDeclaration
    private DoubleCode doubleCode;

    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    private int doubleCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    @BuilderPropertyDeclaration
    private BigIntegerCode bigInegerCode;

    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    private int bigInegerCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
    @BuilderPropertyDeclaration
    private BigDecimalCode bigDecimalCode;

    // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
    private int bigDecimalCodeXYZ = 0;

    /**
     * Use {@link HeavyDataTypeUser#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link HeavyDataTypeUser#builder(HeavyDataTypeUser)} instead of private constructor to create new builder.
     */
    protected Builder( HeavyDataTypeUser pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBooleanCode(pObject.booleanCode);
        this.setByteCode(pObject.byteCode);
        this.setShortCode(pObject.shortCode);
        this.setIntegerCode(pObject.integerCode);
        this.setFloatCode(pObject.floatCode);
        this.setDoubleCode(pObject.doubleCode);
        this.setBigInegerCode(pObject.bigInegerCode);
        this.setBigDecimalCode(pObject.bigDecimalCode);
      }
    }

    /**
     * Method sets attribute {@link #booleanCode}.<br/>
     *
     * @param pBooleanCode Value to which {@link #booleanCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooleanCode( BooleanCode pBooleanCode ) {
      // Assign value to attribute
      booleanCode = pBooleanCode;
      return this;
    }

    public Builder setBooleanCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
      booleanCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #byteCode}.<br/>
     *
     * @param pByteCode Value to which {@link #byteCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setByteCode( ByteCode pByteCode ) {
      // Assign value to attribute
      byteCode = pByteCode;
      return this;
    }

    public Builder setByteCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
      byteCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #shortCode}.<br/>
     *
     * @param pShortCode Value to which {@link #shortCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setShortCode( ShortCode pShortCode ) {
      // Assign value to attribute
      shortCode = pShortCode;
      return this;
    }

    public Builder setShortCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
      shortCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #integerCode}.<br/>
     *
     * @param pIntegerCode Value to which {@link #integerCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntegerCode( IntegerCode pIntegerCode ) {
      // Assign value to attribute
      integerCode = pIntegerCode;
      return this;
    }

    public Builder setIntegerCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
      integerCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #floatCode}.<br/>
     *
     * @param pFloatCode Value to which {@link #floatCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setFloatCode( FloatCode pFloatCode ) {
      // Assign value to attribute
      floatCode = pFloatCode;
      return this;
    }

    public Builder setFloatCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
      floatCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #doubleCode}.<br/>
     *
     * @param pDoubleCode Value to which {@link #doubleCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDoubleCode( DoubleCode pDoubleCode ) {
      // Assign value to attribute
      doubleCode = pDoubleCode;
      return this;
    }

    public Builder setDoubleCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
      doubleCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bigInegerCode}.<br/>
     *
     * @param pBigInegerCode Value to which {@link #bigInegerCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBigInegerCode( BigIntegerCode pBigInegerCode ) {
      // Assign value to attribute
      bigInegerCode = pBigInegerCode;
      return this;
    }

    public Builder setBigInegerCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
      bigInegerCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bigDecimalCode}.<br/>
     *
     * @param pBigDecimalCode Value to which {@link #bigDecimalCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBigDecimalCode( BigDecimalCode pBigDecimalCode ) {
      // Assign value to attribute
      bigDecimalCode = pBigDecimalCode;
      return this;
    }

    public Builder setBigDecimalCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
      bigDecimalCodeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class HeavyDataTypeUser. The object will be initialized with the values of the
     * builder.
     *
     * @return HeavyDataTypeUser Created object. The method never returns null.
     */
    public HeavyDataTypeUser build( ) {
      return new HeavyDataTypeUser(this);
    }

    /**
     * Method creates a new validated instance of class HeavyDataTypeUser. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return HeavyDataTypeUser Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public HeavyDataTypeUser buildValidated( ) throws ConstraintViolationException {
      HeavyDataTypeUser lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #booleanCode}.<br/>
   *
   * @return {@link BooleanCode} Value to which {@link #booleanCode} is set.
   */
  public BooleanCode getBooleanCode( ) {
    return booleanCode;
  }

  /**
   * Method sets attribute {@link #booleanCode}.<br/>
   *
   * @param pBooleanCode Value to which {@link #booleanCode} should be set.
   */
  public void setBooleanCode( BooleanCode pBooleanCode ) {
    // Assign value to attribute
    booleanCode = pBooleanCode;
  }

  public int getBooleanCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BooleanCode"
    return booleanCodeXYZ;
  }

  public void setBooleanCodeXYZ( int value ) {
    booleanCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #byteCode}.<br/>
   *
   * @return {@link ByteCode} Value to which {@link #byteCode} is set.
   */
  public ByteCode getByteCode( ) {
    return byteCode;
  }

  /**
   * Method sets attribute {@link #byteCode}.<br/>
   *
   * @param pByteCode Value to which {@link #byteCode} should be set.
   */
  public void setByteCode( ByteCode pByteCode ) {
    // Assign value to attribute
    byteCode = pByteCode;
  }

  public int getByteCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ByteCode"
    return byteCodeXYZ;
  }

  public void setByteCodeXYZ( int value ) {
    byteCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #shortCode}.<br/>
   *
   * @return {@link ShortCode} Value to which {@link #shortCode} is set.
   */
  public ShortCode getShortCode( ) {
    return shortCode;
  }

  /**
   * Method sets attribute {@link #shortCode}.<br/>
   *
   * @param pShortCode Value to which {@link #shortCode} should be set.
   */
  public void setShortCode( ShortCode pShortCode ) {
    // Assign value to attribute
    shortCode = pShortCode;
  }

  public int getShortCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ShortCode"
    return shortCodeXYZ;
  }

  public void setShortCodeXYZ( int value ) {
    shortCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #integerCode}.<br/>
   *
   * @return {@link IntegerCode} Value to which {@link #integerCode} is set.
   */
  public IntegerCode getIntegerCode( ) {
    return integerCode;
  }

  /**
   * Method sets attribute {@link #integerCode}.<br/>
   *
   * @param pIntegerCode Value to which {@link #integerCode} should be set.
   */
  public void setIntegerCode( IntegerCode pIntegerCode ) {
    // Assign value to attribute
    integerCode = pIntegerCode;
  }

  public int getIntegerCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.IntegerCode"
    return integerCodeXYZ;
  }

  public void setIntegerCodeXYZ( int value ) {
    integerCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #floatCode}.<br/>
   *
   * @return {@link FloatCode} Value to which {@link #floatCode} is set.
   */
  public FloatCode getFloatCode( ) {
    return floatCode;
  }

  /**
   * Method sets attribute {@link #floatCode}.<br/>
   *
   * @param pFloatCode Value to which {@link #floatCode} should be set.
   */
  public void setFloatCode( FloatCode pFloatCode ) {
    // Assign value to attribute
    floatCode = pFloatCode;
  }

  public int getFloatCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.FloatCode"
    return floatCodeXYZ;
  }

  public void setFloatCodeXYZ( int value ) {
    floatCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #doubleCode}.<br/>
   *
   * @return {@link DoubleCode} Value to which {@link #doubleCode} is set.
   */
  public DoubleCode getDoubleCode( ) {
    return doubleCode;
  }

  /**
   * Method sets attribute {@link #doubleCode}.<br/>
   *
   * @param pDoubleCode Value to which {@link #doubleCode} should be set.
   */
  public void setDoubleCode( DoubleCode pDoubleCode ) {
    // Assign value to attribute
    doubleCode = pDoubleCode;
  }

  public int getDoubleCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    return doubleCodeXYZ;
  }

  public void setDoubleCodeXYZ( int value ) {
    doubleCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #bigInegerCode}.<br/>
   *
   * @return {@link BigIntegerCode} Value to which {@link #bigInegerCode} is set.
   */
  public BigIntegerCode getBigInegerCode( ) {
    return bigInegerCode;
  }

  /**
   * Method sets attribute {@link #bigInegerCode}.<br/>
   *
   * @param pBigInegerCode Value to which {@link #bigInegerCode} should be set.
   */
  public void setBigInegerCode( BigIntegerCode pBigInegerCode ) {
    // Assign value to attribute
    bigInegerCode = pBigInegerCode;
  }

  public int getBigInegerCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BigIntegerCode"
    return bigInegerCodeXYZ;
  }

  public void setBigInegerCodeXYZ( int value ) {
    bigInegerCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #bigDecimalCode}.<br/>
   *
   * @return {@link BigDecimalCode} Value to which {@link #bigDecimalCode} is set.
   */
  public BigDecimalCode getBigDecimalCode( ) {
    return bigDecimalCode;
  }

  /**
   * Method sets attribute {@link #bigDecimalCode}.<br/>
   *
   * @param pBigDecimalCode Value to which {@link #bigDecimalCode} should be set.
   */
  public void setBigDecimalCode( BigDecimalCode pBigDecimalCode ) {
    // Assign value to attribute
    bigDecimalCode = pBigDecimalCode;
  }

  public int getBigDecimalCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode"
    return bigDecimalCodeXYZ;
  }

  public void setBigDecimalCodeXYZ( int value ) {
    bigDecimalCodeXYZ = value;
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
    lBuilder.append("booleanCode: ");
    lBuilder.append(booleanCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("byteCode: ");
    lBuilder.append(byteCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("shortCode: ");
    lBuilder.append(shortCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("integerCode: ");
    lBuilder.append(integerCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("floatCode: ");
    lBuilder.append(floatCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCode: ");
    lBuilder.append(doubleCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bigInegerCode: ");
    lBuilder.append(bigInegerCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bigDecimalCode: ");
    lBuilder.append(bigDecimalCode);
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
   * @return {@link Builder} New builder that can be used to create new HeavyDataTypeUser objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
