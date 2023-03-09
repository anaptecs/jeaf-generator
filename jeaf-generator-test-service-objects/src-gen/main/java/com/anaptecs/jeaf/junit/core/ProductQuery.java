/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.QueryObject;

public class ProductQuery extends QueryObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "minAvailability".
   */
  @Deprecated
  public static final String MINAVAILABILITY = "minAvailability";

  /**
   * Constant for the name of attribute "minPrice".
   */
  public static final String MINPRICE = "minPrice";

  /**
   * Constant for the name of attribute "maxPrice".
   */
  public static final String MAXPRICE = "maxPrice";

  /**
   * Constant for the name of attribute "manufacturer".
   */
  public static final String MANUFACTURER = "manufacturer";

  private String name;

  @Deprecated
  private Integer minAvailability;

  private Integer minPrice;

  private Integer maxPrice;

  private String manufacturer;

  /**
   * Initialize object. Nothing special to do.
   */
  public ProductQuery( ) {
    // Nothing to do.
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   * 
   * @return String Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   * 
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns attribute {@link #minAvailability}.<br/>
   * 
   * @return Integer Value to which {@link #minAvailability} is set.
   */
  @Deprecated
  public Integer getMinAvailability( ) {
    return minAvailability;
  }

  /**
   * Method sets attribute {@link #minAvailability}.<br/>
   * 
   * @param pMinAvailability Value to which {@link #minAvailability} should be set.
   */
  @Deprecated
  public void setMinAvailability( Integer pMinAvailability ) {
    // Assign value to attribute
    minAvailability = pMinAvailability;
  }

  /**
   * Method returns attribute {@link #minPrice}.<br/>
   * 
   * @return Integer Value to which {@link #minPrice} is set.
   */
  public Integer getMinPrice( ) {
    return minPrice;
  }

  /**
   * Method sets attribute {@link #minPrice}.<br/>
   * 
   * @param pMinPrice Value to which {@link #minPrice} should be set.
   */
  public void setMinPrice( Integer pMinPrice ) {
    // Assign value to attribute
    minPrice = pMinPrice;
  }

  /**
   * Method returns attribute {@link #maxPrice}.<br/>
   * 
   * @return Integer Value to which {@link #maxPrice} is set.
   */
  public Integer getMaxPrice( ) {
    return maxPrice;
  }

  /**
   * Method sets attribute {@link #maxPrice}.<br/>
   * 
   * @param pMaxPrice Value to which {@link #maxPrice} should be set.
   */
  public void setMaxPrice( Integer pMaxPrice ) {
    // Assign value to attribute
    maxPrice = pMaxPrice;
  }

  /**
   * Method returns attribute {@link #manufacturer}.<br/>
   * 
   * @return String Value to which {@link #manufacturer} is set.
   */
  public String getManufacturer( ) {
    return manufacturer;
  }

  /**
   * Method sets attribute {@link #manufacturer}.<br/>
   * 
   * @param pManufacturer Value to which {@link #manufacturer} should be set.
   */
  public void setManufacturer( String pManufacturer ) {
    // Assign value to attribute
    manufacturer = pManufacturer;
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
