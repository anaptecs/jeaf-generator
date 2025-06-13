/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.QueryObject;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@JEAFCustomAnnotationTest
public class ProductQuery extends QueryObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "minAvailability".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String MINAVAILABILITY = "minAvailability";

  /**
   * Constant for the name of attribute "minPrice".
   */
  @JEAFCustomAnnotationTest
  public static final String MINPRICE = "minPrice";

  /**
   * Constant for the name of attribute "maxPrice".
   */
  @JEAFCustomAnnotationTest
  public static final String MAXPRICE = "maxPrice";

  /**
   * Constant for the name of attribute "manufacturer".
   */
  @JEAFCustomAnnotationTest
  public static final String MANUFACTURER = "manufacturer";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private Integer minAvailability;

  // "java.lang.Integer"
  private int minAvailabilityXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Integer minPrice;

  // "java.lang.Integer"
  private int minPriceXYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Integer maxPrice;

  // "java.lang.Integer"
  private int maxPriceXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String manufacturer;

  // "java.lang.String"
  private int manufacturerXYZ = 0;

  /**
   * Initialize object. Nothing special to do.
   */
  public ProductQuery( ) {
    // Nothing to do.
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @JEAFCustomAnnotationTest
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  public int getNameXYZ( ) {
    // "java.lang.String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns attribute {@link #minAvailability}.<br/>
   *
   * @return {@link Integer} Value to which {@link #minAvailability} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public Integer getMinAvailability( ) {
    return minAvailability;
  }

  /**
   * Method sets attribute {@link #minAvailability}.<br/>
   *
   * @param pMinAvailability Value to which {@link #minAvailability} should be set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setMinAvailability( Integer pMinAvailability ) {
    // Assign value to attribute
    minAvailability = pMinAvailability;
  }

  public int getMinAvailabilityXYZ( ) {
    // "java.lang.Integer"
    return minAvailabilityXYZ;
  }

  public void setMinAvailabilityXYZ( int value ) {
    minAvailabilityXYZ = value;
  }

  /**
   * Method returns attribute {@link #minPrice}.<br/>
   *
   * @return {@link Integer} Value to which {@link #minPrice} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getMinPrice( ) {
    return minPrice;
  }

  /**
   * Method sets attribute {@link #minPrice}.<br/>
   *
   * @param pMinPrice Value to which {@link #minPrice} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMinPrice( Integer pMinPrice ) {
    // Assign value to attribute
    minPrice = pMinPrice;
  }

  public int getMinPriceXYZ( ) {
    // "java.lang.Integer"
    return minPriceXYZ;
  }

  public void setMinPriceXYZ( int value ) {
    minPriceXYZ = value;
  }

  /**
   * Method returns attribute {@link #maxPrice}.<br/>
   *
   * @return {@link Integer} Value to which {@link #maxPrice} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getMaxPrice( ) {
    return maxPrice;
  }

  /**
   * Method sets attribute {@link #maxPrice}.<br/>
   *
   * @param pMaxPrice Value to which {@link #maxPrice} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMaxPrice( Integer pMaxPrice ) {
    // Assign value to attribute
    maxPrice = pMaxPrice;
  }

  public int getMaxPriceXYZ( ) {
    // "java.lang.Integer"
    return maxPriceXYZ;
  }

  public void setMaxPriceXYZ( int value ) {
    maxPriceXYZ = value;
  }

  /**
   * Method returns attribute {@link #manufacturer}.<br/>
   *
   * @return {@link String} Value to which {@link #manufacturer} is set.
   */
  @JEAFCustomAnnotationTest
  public String getManufacturer( ) {
    return manufacturer;
  }

  /**
   * Method sets attribute {@link #manufacturer}.<br/>
   *
   * @param pManufacturer Value to which {@link #manufacturer} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setManufacturer( String pManufacturer ) {
    // Assign value to attribute
    manufacturer = pManufacturer;
  }

  public int getManufacturerXYZ( ) {
    // "java.lang.String"
    return manufacturerXYZ;
  }

  public void setManufacturerXYZ( int value ) {
    manufacturerXYZ = value;
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("minAvailability: ");
    lBuilder.append(minAvailability);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("minPrice: ");
    lBuilder.append(minPrice);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("maxPrice: ");
    lBuilder.append(maxPrice);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("manufacturer: ");
    lBuilder.append(manufacturer);
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