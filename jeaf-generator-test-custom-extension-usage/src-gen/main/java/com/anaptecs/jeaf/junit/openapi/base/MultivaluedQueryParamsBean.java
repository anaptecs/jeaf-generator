/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class MultivaluedQueryParamsBean implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "intArray".
   */
  public static final String INTARRAY = "intArray";

  /**
   * Constant for the name of attribute "strings".
   */
  public static final String STRINGS = "strings";

  /**
   * Constant for the name of attribute "integers".
   */
  public static final String INTEGERS = "integers";

  // "int"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   */
  private int[] intArray;

  // "int"
  private int intArrayXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String[] strings;

  // "String"
  private int stringsXYZ = 0;

  // "Integer"
  @ClassPropertyDeclaration
  private Integer[] integers;

  // "Integer"
  private int integersXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MultivaluedQueryParamsBean( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultivaluedQueryParamsBean( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    intArray = pBuilder.intArray;
    // "int"
    intArrayXYZ = pBuilder.intArrayXYZ;
    strings = pBuilder.strings;
    // "String"
    stringsXYZ = pBuilder.stringsXYZ;
    integers = pBuilder.integers;
    // "Integer"
    integersXYZ = pBuilder.integersXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MultivaluedQueryParamsBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>MultivaluedQueryParamsBean</code>.
   */
  public static class Builder {
    /**
     * <p/>
     * <b>Breaking Change with 47.11:</b> At least one will become mandatory
     */
    // "int"
    @BuilderPropertyDeclaration
    private int[] intArray;

    // "int"
    private int intArrayXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String[] strings;

    // "String"
    private int stringsXYZ = 0;

    // "Integer"
    @BuilderPropertyDeclaration
    private Integer[] integers;

    // "Integer"
    private int integersXYZ = 0;

    /**
     * Use {@link MultivaluedQueryParamsBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultivaluedQueryParamsBean#builder(MultivaluedQueryParamsBean)} instead of private constructor to
     * create new builder.
     */
    protected Builder( MultivaluedQueryParamsBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setIntArray(pObject.intArray);
        this.setStrings(pObject.strings);
        this.setIntegers(pObject.integers);
      }
    }

    /**
     * Method sets attribute {@link #intArray}.<br/>
     * <p/>
     * <b>Breaking Change with 47.11:</b> At least one will become mandatory
     *
     * @param pIntArray Value to which {@link #intArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntArray( int[] pIntArray ) {
      // Assign value to attribute
      if (pIntArray != null) {
        intArray = new int[pIntArray.length];
        System.arraycopy(pIntArray, 0, intArray, 0, pIntArray.length);
      }
      else {
        intArray = null;
      }
      return this;
    }

    public Builder setIntArrayXYZ( int value ) {
      // "int"
      intArrayXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #strings}.<br/>
     *
     * @param pStrings Collection to which {@link #strings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStrings( String[] pStrings ) {
      // Assign value to attribute
      if (pStrings != null) {
        strings = new String[pStrings.length];
        System.arraycopy(pStrings, 0, strings, 0, pStrings.length);
      }
      else {
        strings = null;
      }
      return this;
    }

    public Builder setStringsXYZ( int value ) {
      // "String"
      stringsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #integers}.<br/>
     *
     * @param pIntegers Collection to which {@link #integers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntegers( Integer[] pIntegers ) {
      // Assign value to attribute
      if (pIntegers != null) {
        integers = new Integer[pIntegers.length];
        System.arraycopy(pIntegers, 0, integers, 0, pIntegers.length);
      }
      else {
        integers = null;
      }
      return this;
    }

    public Builder setIntegersXYZ( int value ) {
      // "Integer"
      integersXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class MultivaluedQueryParamsBean. The object will be initialized with the values
     * of the builder.
     *
     * @return MultivaluedQueryParamsBean Created object. The method never returns null.
     */
    public MultivaluedQueryParamsBean build( ) {
      return new MultivaluedQueryParamsBean(this);
    }

    /**
     * Method creates a new validated instance of class MultivaluedQueryParamsBean. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return MultivaluedQueryParamsBean Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MultivaluedQueryParamsBean buildValidated( ) throws ConstraintViolationException {
      MultivaluedQueryParamsBean lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #intArray}.<br/>
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   *
   * @return int Value to which {@link #intArray} is set.
   */
  public int[] getIntArray( ) {
    int[] lReturnValue;
    if (intArray != null) {
      lReturnValue = new int[intArray.length];
      System.arraycopy(intArray, 0, lReturnValue, 0, intArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #intArray}.<br/>
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   *
   * @param pIntArray Value to which {@link #intArray} should be set.
   */
  public void setIntArray( int[] pIntArray ) {
    // Assign value to attribute
    if (pIntArray != null) {
      intArray = new int[pIntArray.length];
      System.arraycopy(pIntArray, 0, intArray, 0, pIntArray.length);
    }
    else {
      intArray = null;
    }
  }

  public int getIntArrayXYZ( ) {
    // "int"
    return intArrayXYZ;
  }

  public void setIntArrayXYZ( int value ) {
    intArrayXYZ = value;
  }

  /**
   * Method returns attribute {@link #strings}.<br/>
   *
   * @return {@link String} Value to which {@link #strings} is set.
   */
  public String[] getStrings( ) {
    String[] lReturnValue;
    if (strings != null) {
      lReturnValue = new String[strings.length];
      System.arraycopy(strings, 0, lReturnValue, 0, strings.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #strings}.<br/>
   *
   * @param pStrings Value to which {@link #strings} should be set.
   */
  public void setStrings( String[] pStrings ) {
    // Assign value to attribute
    if (pStrings != null) {
      strings = new String[pStrings.length];
      System.arraycopy(pStrings, 0, strings, 0, pStrings.length);
    }
    else {
      strings = null;
    }
  }

  public int getStringsXYZ( ) {
    // "String"
    return stringsXYZ;
  }

  public void setStringsXYZ( int value ) {
    stringsXYZ = value;
  }

  /**
   * Method returns attribute {@link #integers}.<br/>
   *
   * @return {@link Integer} Value to which {@link #integers} is set.
   */
  public Integer[] getIntegers( ) {
    Integer[] lReturnValue;
    if (integers != null) {
      lReturnValue = new Integer[integers.length];
      System.arraycopy(integers, 0, lReturnValue, 0, integers.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #integers}.<br/>
   *
   * @param pIntegers Value to which {@link #integers} should be set.
   */
  public void setIntegers( Integer[] pIntegers ) {
    // Assign value to attribute
    if (pIntegers != null) {
      integers = new Integer[pIntegers.length];
      System.arraycopy(pIntegers, 0, integers, 0, pIntegers.length);
    }
    else {
      integers = null;
    }
  }

  public int getIntegersXYZ( ) {
    // "Integer"
    return integersXYZ;
  }

  public void setIntegersXYZ( int value ) {
    integersXYZ = value;
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
   * @return {@link Builder} New builder that can be used to create new MultivaluedQueryParamsBean objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
