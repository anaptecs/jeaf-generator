/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.HeaderParam;

import com.anaptecs.spring.base.StringCode;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class MultiValuedHeaderBeanParam {
  /**
   * Constant for the name of attribute "names".
   */
  public static final String NAMES = "names";

  /**
   * Constant for the name of attribute "ints".
   */
  public static final String INTS = "ints";

  /**
   * Constant for the name of attribute "doubles".
   */
  public static final String DOUBLES = "doubles";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  /**
   * Constant for the name of attribute "stringCodeList".
   */
  public static final String STRINGCODELIST = "stringCodeList";

  /**
   * 
   */
  @HeaderParam("names")
  private String[] names;

  /**
   * 
   */
  @HeaderParam("ints")
  private int[] ints;

  /**
   * 
   */
  @HeaderParam("doubles")
  private Double[] doubles;

  /**
   * 
   */
  @HeaderParam("codes")
  private StringCode[] codes;

  /**
   * 
   */
  private Set<StringCode> stringCodeList;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public MultiValuedHeaderBeanParam( ) {
    stringCodeList = new HashSet<StringCode>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultiValuedHeaderBeanParam( Builder pBuilder ) {
    // Read attribute values from builder.
    names = pBuilder.names;
    ints = pBuilder.ints;
    doubles = pBuilder.doubles;
    codes = pBuilder.codes;
    if (pBuilder.stringCodeList != null) {
      stringCodeList = pBuilder.stringCodeList;
    }
    else {
      stringCodeList = new HashSet<StringCode>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new MultiValuedHeaderBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MultiValuedHeaderBeanParam objects. The method
   * never returns null.
   */
  public static Builder builder( MultiValuedHeaderBeanParam pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class MultiValuedHeaderBeanParam. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String[] names;

    /**
     * 
     */
    private int[] ints;

    /**
     * 
     */
    private Double[] doubles;

    /**
     * 
     */
    private StringCode[] codes;

    /**
     * 
     */
    private Set<StringCode> stringCodeList;

    /**
     * Use {@link MultiValuedHeaderBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultiValuedHeaderBeanParam#builder(MultiValuedHeaderBeanParam)} instead of private constructor to
     * create new builder.
     */
    protected Builder( MultiValuedHeaderBeanParam pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        names = pObject.names;
        ints = pObject.ints;
        doubles = pObject.doubles;
        codes = pObject.codes;
        stringCodeList = pObject.stringCodeList;
      }
    }

    /**
     * Method sets the attribute "names".
     * 
     * @param pNames Value to which the attribute "names" should be set.
     */
    public Builder setNames( String[] pNames ) {
      // Assign value to attribute
      if (pNames != null) {
        names = new String[pNames.length];
        System.arraycopy(pNames, 0, names, 0, pNames.length);
      }
      else {
        names = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "ints".
     * 
     * @param pInts Value to which the attribute "ints" should be set.
     */
    public Builder setInts( int[] pInts ) {
      // Assign value to attribute
      if (pInts != null) {
        ints = new int[pInts.length];
        System.arraycopy(pInts, 0, ints, 0, pInts.length);
      }
      else {
        ints = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "doubles".
     * 
     * @param pDoubles Value to which the attribute "doubles" should be set.
     */
    public Builder setDoubles( Double[] pDoubles ) {
      // Assign value to attribute
      if (pDoubles != null) {
        doubles = new Double[pDoubles.length];
        System.arraycopy(pDoubles, 0, doubles, 0, pDoubles.length);
      }
      else {
        doubles = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "codes".
     * 
     * @param pCodes Value to which the attribute "codes" should be set.
     */
    public Builder setCodes( StringCode[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new StringCode[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method sets the association "stringCodeList".
     * 
     * @param pStringCodeList Collection with objects to which the association should be set.
     */
    public Builder setStringCodeList( Set<StringCode> pStringCodeList ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStringCodeList != null) {
        stringCodeList = new HashSet<StringCode>(pStringCodeList);
      }
      else {
        stringCodeList = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class MultiValuedHeaderBeanParam. The object will be initialized with the values
     * of the builder.
     * 
     * @return MultiValuedHeaderBeanParam Created object. The method never returns null.
     */
    public MultiValuedHeaderBeanParam build( ) {
      return new MultiValuedHeaderBeanParam(this);
    }
  }

  /**
   * Method returns the attribute "names".
   * 
   * 
   * @return String Value to which the attribute "names" is set.
   */
  public String[] getNames( ) {
    String[] lReturnValue;
    if (names != null) {
      lReturnValue = new String[names.length];
      System.arraycopy(names, 0, lReturnValue, 0, names.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "names".
   * 
   * 
   * @param pNames Value to which the attribute "names" should be set.
   */
  public void setNames( String[] pNames ) {
    // Assign value to attribute
    if (pNames != null) {
      names = new String[pNames.length];
      System.arraycopy(pNames, 0, names, 0, pNames.length);
    }
    else {
      names = null;
    }
  }

  /**
   * Method returns the attribute "ints".
   * 
   * 
   * @return int Value to which the attribute "ints" is set.
   */
  public int[] getInts( ) {
    int[] lReturnValue;
    if (ints != null) {
      lReturnValue = new int[ints.length];
      System.arraycopy(ints, 0, lReturnValue, 0, ints.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "ints".
   * 
   * 
   * @param pInts Value to which the attribute "ints" should be set.
   */
  public void setInts( int[] pInts ) {
    // Assign value to attribute
    if (pInts != null) {
      ints = new int[pInts.length];
      System.arraycopy(pInts, 0, ints, 0, pInts.length);
    }
    else {
      ints = null;
    }
  }

  /**
   * Method returns the attribute "doubles".
   * 
   * 
   * @return Double Value to which the attribute "doubles" is set.
   */
  public Double[] getDoubles( ) {
    Double[] lReturnValue;
    if (doubles != null) {
      lReturnValue = new Double[doubles.length];
      System.arraycopy(doubles, 0, lReturnValue, 0, doubles.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "doubles".
   * 
   * 
   * @param pDoubles Value to which the attribute "doubles" should be set.
   */
  public void setDoubles( Double[] pDoubles ) {
    // Assign value to attribute
    if (pDoubles != null) {
      doubles = new Double[pDoubles.length];
      System.arraycopy(pDoubles, 0, doubles, 0, pDoubles.length);
    }
    else {
      doubles = null;
    }
  }

  /**
   * Method returns the attribute "codes".
   * 
   * 
   * @return StringCode Value to which the attribute "codes" is set.
   */
  public StringCode[] getCodes( ) {
    StringCode[] lReturnValue;
    if (codes != null) {
      lReturnValue = new StringCode[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "codes".
   * 
   * 
   * @param pCodes Value to which the attribute "codes" should be set.
   */
  public void setCodes( StringCode[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new StringCode[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns the association "stringCodeList".
   * 
   *
   * @return Collection All StringCode objects that belong to the association "stringCodeList". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<StringCode> getStringCodeList( ) {
    // Return all StringCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(stringCodeList);
  }

  /**
   * Method adds the passed StringCode object to the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Object that should be added to the association "stringCodeList". The parameter must not be
   * null.
   */
  public void addToStringCodeList( StringCode pStringCodeList ) {
    // Add passed object to collection of associated StringCode objects.
    stringCodeList.add(pStringCodeList);
  }

  /**
   * Method adds all passed objects to the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Collection with all objects that should be added to the association "stringCodeList". The
   * parameter must not be null.
   */
  public void addToStringCodeList( Collection<StringCode> pStringCodeList ) {
    // Add all passed objects.
    for (StringCode lNextObject : pStringCodeList) {
      this.addToStringCodeList(lNextObject);
    }
  }

  /**
   * Method removes the passed StringCode object from the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Object that should be removed from the association "stringCodeList". The parameter must not
   * be null.
   */
  public void removeFromStringCodeList( StringCode pStringCodeList ) {
    // Remove passed object from collection of associated StringCode objects.
    stringCodeList.remove(pStringCodeList);
  }

  /**
   * Method removes all objects from the association "stringCodeList".
   * 
   */
  public void clearStringCodeList( ) {
    // Remove all objects from association "stringCodeList".
    stringCodeList.clear();
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
    lBuilder.append("names: ");
    if (names != null) {
      lBuilder.append(Arrays.toString(names));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("ints: ");
    if (ints != null) {
      lBuilder.append(Arrays.toString(ints));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubles: ");
    if (doubles != null) {
      lBuilder.append(Arrays.toString(doubles));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("codes: ");
    if (codes != null) {
      lBuilder.append(Arrays.toString(codes));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("stringCodeList: ");
    if (stringCodeList != null) {
      lBuilder.append(stringCodeList.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (stringCodeList != null) {
      for (StringCode lNext : stringCodeList) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
