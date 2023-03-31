/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class HeavyDataTypeUser implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private BooleanCode booleanCode;

  @NotNull
  private ByteCode byteCode;

  @NotNull
  private ShortCode shortCode;

  @NotNull
  private IntegerCode integerCode;

  @NotNull
  private FloatCode floatCode;

  @NotNull
  private DoubleCode doubleCode;

  @NotNull
  private BigIntegerCode bigInegerCode;

  @NotNull
  private BigDecimalCode bigDecimalCode;

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
    byteCode = pBuilder.byteCode;
    shortCode = pBuilder.shortCode;
    integerCode = pBuilder.integerCode;
    floatCode = pBuilder.floatCode;
    doubleCode = pBuilder.doubleCode;
    bigInegerCode = pBuilder.bigInegerCode;
    bigDecimalCode = pBuilder.bigDecimalCode;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new HeavyDataTypeUser objects. The method never
   * returns null.
   */
  public static Builder builder( HeavyDataTypeUser pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BooleanCode pBooleanCode, ByteCode pByteCode, ShortCode pShortCode,
      IntegerCode pIntegerCode, FloatCode pFloatCode, DoubleCode pDoubleCode, BigIntegerCode pBigInegerCode,
      BigDecimalCode pBigDecimalCode ) {
    Builder lBuilder = builder();
    lBuilder.setBooleanCode(pBooleanCode);
    lBuilder.setByteCode(pByteCode);
    lBuilder.setShortCode(pShortCode);
    lBuilder.setIntegerCode(pIntegerCode);
    lBuilder.setFloatCode(pFloatCode);
    lBuilder.setDoubleCode(pDoubleCode);
    lBuilder.setBigInegerCode(pBigInegerCode);
    lBuilder.setBigDecimalCode(pBigDecimalCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>HeavyDataTypeUser</code>.
   */
  public static class Builder {
    private BooleanCode booleanCode;

    private ByteCode byteCode;

    private ShortCode shortCode;

    private IntegerCode integerCode;

    private FloatCode floatCode;

    private DoubleCode doubleCode;

    private BigIntegerCode bigInegerCode;

    private BigDecimalCode bigDecimalCode;

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
        booleanCode = pObject.booleanCode;
        byteCode = pObject.byteCode;
        shortCode = pObject.shortCode;
        integerCode = pObject.integerCode;
        floatCode = pObject.floatCode;
        doubleCode = pObject.doubleCode;
        bigInegerCode = pObject.bigInegerCode;
        bigDecimalCode = pObject.bigDecimalCode;
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
}
