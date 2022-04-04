/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.QueryObject;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  @Deprecated
  private Integer minAvailability;

  /**
   * 
   */
  private Integer minPrice;

  /**
   * 
   */
  private Integer maxPrice;

  /**
   * 
   */
  private String manufacturer;

  /**
   * Initialize object. Nothing special to do.
   */
  public ProductQuery( ) {
    // Nothing to do.
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "minAvailability".
   * 
   * 
   * @return Integer Value to which the attribute "minAvailability" is set.
   */
  @Deprecated
  public Integer getMinAvailability( ) {
    return minAvailability;
  }

  /**
   * Method sets the attribute "minAvailability".
   * 
   * 
   * @param pMinAvailability Value to which the attribute "minAvailability" should be set.
   */
  @Deprecated
  public void setMinAvailability( Integer pMinAvailability ) {
    // Assign value to attribute
    minAvailability = pMinAvailability;
  }

  /**
   * Method returns the attribute "minPrice".
   * 
   * 
   * @return Integer Value to which the attribute "minPrice" is set.
   */
  public Integer getMinPrice( ) {
    return minPrice;
  }

  /**
   * Method sets the attribute "minPrice".
   * 
   * 
   * @param pMinPrice Value to which the attribute "minPrice" should be set.
   */
  public void setMinPrice( Integer pMinPrice ) {
    // Assign value to attribute
    minPrice = pMinPrice;
  }

  /**
   * Method returns the attribute "maxPrice".
   * 
   * 
   * @return Integer Value to which the attribute "maxPrice" is set.
   */
  public Integer getMaxPrice( ) {
    return maxPrice;
  }

  /**
   * Method sets the attribute "maxPrice".
   * 
   * 
   * @param pMaxPrice Value to which the attribute "maxPrice" should be set.
   */
  public void setMaxPrice( Integer pMaxPrice ) {
    // Assign value to attribute
    maxPrice = pMaxPrice;
  }

  /**
   * Method returns the attribute "manufacturer".
   * 
   * 
   * @return String Value to which the attribute "manufacturer" is set.
   */
  public String getManufacturer( ) {
    return manufacturer;
  }

  /**
   * Method sets the attribute "manufacturer".
   * 
   * 
   * @param pManufacturer Value to which the attribute "manufacturer" should be set.
   */
  public void setManufacturer( String pManufacturer ) {
    // Assign value to attribute
    manufacturer = pManufacturer;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "minAvailability", "" + minAvailability));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "minPrice", "" + minPrice));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "maxPrice", "" + maxPrice));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "manufacturer", "" + manufacturer));
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