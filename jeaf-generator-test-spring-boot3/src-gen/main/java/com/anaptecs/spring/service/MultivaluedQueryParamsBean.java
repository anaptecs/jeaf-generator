/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.anaptecs.spring.base.TimeUnit;

public class MultivaluedQueryParamsBean {
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
   * Constant for the name of attribute "timeUnits".
   */
  public static final String TIMEUNITS = "timeUnits";

  /**
   * Constant for the name of attribute "timeUnitArray".
   */
  public static final String TIMEUNITARRAY = "timeUnitArray";

  private final int[] intArray;

  private final String[] strings;

  private final Integer[] integers;

  private final Set<TimeUnit> timeUnits;

  private final TimeUnit[] timeUnitArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public MultivaluedQueryParamsBean( ) {
    intArray = null;
    strings = null;
    integers = null;
    timeUnits = new HashSet<>();
    timeUnitArray = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultivaluedQueryParamsBean( Builder pBuilder ) {
    // Read attribute values from builder.
    intArray = pBuilder.intArray;
    strings = pBuilder.strings;
    integers = pBuilder.integers;
    if (pBuilder.timeUnits != null) {
      timeUnits = pBuilder.timeUnits;
    }
    else {
      timeUnits = new HashSet<>();
    }
    timeUnitArray = pBuilder.timeUnitArray;
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
   * Convenience method to create new instance of class MultivaluedQueryParamsBean.
   *
   *
   * @return {@link com.anaptecs.spring.service.MultivaluedQueryParamsBean}
   */
  public static MultivaluedQueryParamsBean of( ) {
    var lBuilder = MultivaluedQueryParamsBean.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MultivaluedQueryParamsBean</code>.
   */
  public static class Builder {
    private int[] intArray;

    private String[] strings;

    private Integer[] integers;

    private Set<TimeUnit> timeUnits;

    private TimeUnit[] timeUnitArray;

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
        this.setTimeUnits(pObject.timeUnits);
        this.setTimeUnitArray(pObject.timeUnitArray);
      }
    }

    /**
     * Method sets attribute {@link #intArray}.<br/>
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

    /**
     * Method sets association {@link #timeUnits}.<br/>
     *
     * @param pTimeUnits Collection to which {@link #timeUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimeUnits( Set<TimeUnit> pTimeUnits ) {
      timeUnits = pTimeUnits;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #timeUnits}.<br/>
     *
     * @param pTimeUnits Array of objects that should be added to {@link #timeUnits}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToTimeUnits( TimeUnit... pTimeUnits ) {
      if (pTimeUnits != null) {
        if (timeUnits == null) {
          timeUnits = new HashSet<TimeUnit>();
        }
        timeUnits.addAll(Arrays.asList(pTimeUnits));
      }
      return this;
    }

    /**
     * Method sets association {@link #timeUnits}.<br/>
     *
     * @param pTimeUnits Array with objects to which {@link #timeUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimeUnits( TimeUnit... pTimeUnits ) {
      // Copy the content of the passed array.
      if (pTimeUnits != null) {
        timeUnits = new HashSet<TimeUnit>(Arrays.asList(pTimeUnits));
      }
      else {
        timeUnits = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #timeUnitArray}.<br/>
     *
     * @param pTimeUnitArray Collection to which {@link #timeUnitArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimeUnitArray( TimeUnit[] pTimeUnitArray ) {
      // Assign value to attribute
      if (pTimeUnitArray != null) {
        timeUnitArray = new TimeUnit[pTimeUnitArray.length];
        System.arraycopy(pTimeUnitArray, 0, timeUnitArray, 0, pTimeUnitArray.length);
      }
      else {
        timeUnitArray = null;
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
  }

  /**
   * Method returns attribute {@link #intArray}.<br/>
   *
   * @return int[] Value to which {@link #intArray} is set.
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
   * Method returns attribute {@link #strings}.<br/>
   *
   * @return {@link String[]} Value to which {@link #strings} is set.
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
   * Method returns attribute {@link #integers}.<br/>
   *
   * @return {@link Integer[]} Value to which {@link #integers} is set.
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
   * Method returns association {@link #timeUnits}.<br/>
   *
   * @return {@link Set<TimeUnit>} Value to which {@link #timeUnits} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<TimeUnit> getTimeUnits( ) {
    // Return all TimeUnit objects as unmodifiable collection.
    return Collections.unmodifiableSet(timeUnits);
  }

  /**
   * Method returns attribute {@link #timeUnitArray}.<br/>
   *
   * @return {@link TimeUnit[]} Value to which {@link #timeUnitArray} is set.
   */
  public TimeUnit[] getTimeUnitArray( ) {
    TimeUnit[] lReturnValue;
    if (timeUnitArray != null) {
      lReturnValue = new TimeUnit[timeUnitArray.length];
      System.arraycopy(timeUnitArray, 0, lReturnValue, 0, timeUnitArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Arrays.hashCode(intArray);
    lResult = lPrime * lResult + Arrays.hashCode(strings);
    lResult = lPrime * lResult + Arrays.hashCode(integers);
    lResult = lPrime * lResult + Objects.hashCode(timeUnits);
    lResult = lPrime * lResult + Arrays.hashCode(timeUnitArray);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      MultivaluedQueryParamsBean lOther = (MultivaluedQueryParamsBean) pObject;
      lEquals = Arrays.equals(intArray, lOther.intArray) && Arrays.equals(strings, lOther.strings)
          && Arrays.equals(integers, lOther.integers) && Objects.equals(timeUnits, lOther.timeUnits)
          && Arrays.equals(timeUnitArray, lOther.timeUnitArray);
    }
    return lEquals;
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
    lBuilder.append("intArray: ");
    if (intArray != null) {
      lBuilder.append(Arrays.toString(intArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("strings: ");
    if (strings != null) {
      lBuilder.append(Arrays.toString(strings));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("integers: ");
    if (integers != null) {
      lBuilder.append(Arrays.toString(integers));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("timeUnits: ");
    if (timeUnits != null) {
      lBuilder.append(timeUnits.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (timeUnits != null) {
      for (TimeUnit lNext : timeUnits) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("timeUnitArray: ");
    if (timeUnitArray != null) {
      lBuilder.append(Arrays.toString(timeUnitArray));
    }
    else {
      lBuilder.append(" null");
    }
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