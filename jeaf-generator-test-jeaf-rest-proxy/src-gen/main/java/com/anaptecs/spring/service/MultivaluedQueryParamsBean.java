/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class MultivaluedQueryParamsBean implements Serializable {
  /**
   * Default serial version UID.
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

  /**
   * 
   */
  @QueryParam("intArray")
  private int[] intArray;

  /**
   * 
   */
  @QueryParam("strings")
  private String[] strings;

  /**
   * 
   */
  @QueryParam("integers")
  private Integer[] integers;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public MultivaluedQueryParamsBean( ) {
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
    strings = pBuilder.strings;
    integers = pBuilder.integers;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MultivaluedQueryParamsBean objects. The method
   * never returns null.
   */
  public static Builder builder( MultivaluedQueryParamsBean pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class MultivaluedQueryParamsBean. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private int[] intArray;

    /**
     * 
     */
    private String[] strings;

    /**
     * 
     */
    private Integer[] integers;

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
        intArray = pObject.intArray;
        strings = pObject.strings;
        integers = pObject.integers;
      }
    }

    /**
     * Method sets the attribute "intArray".
     * 
     * @param pIntArray Value to which the attribute "intArray" should be set.
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

    /**
     * Method sets the attribute "strings".
     * 
     * @param pStrings Value to which the attribute "strings" should be set.
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

    /**
     * Method sets the attribute "integers".
     * 
     * @param pIntegers Value to which the attribute "integers" should be set.
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
      MultivaluedQueryParamsBean lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "intArray".
   * 
   * 
   * @return int Value to which the attribute "intArray" is set.
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
   * Method sets the attribute "intArray".
   * 
   * 
   * @param pIntArray Value to which the attribute "intArray" should be set.
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

  /**
   * Method returns the attribute "strings".
   * 
   * 
   * @return String Value to which the attribute "strings" is set.
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
   * Method sets the attribute "strings".
   * 
   * 
   * @param pStrings Value to which the attribute "strings" should be set.
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

  /**
   * Method returns the attribute "integers".
   * 
   * 
   * @return Integer Value to which the attribute "integers" is set.
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
   * Method sets the attribute "integers".
   * 
   * 
   * @param pIntegers Value to which the attribute "integers" should be set.
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
}