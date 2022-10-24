/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import com.anaptecs.jeaf.core.api.QueryObject;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class CustomerQuery extends QueryObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  /**
   * Constant for the name of attribute "companyName".
   */
  public static final String COMPANYNAME = "companyName";

  /**
   * Constant for the name of attribute "city".
   */
  public static final String CITY = "city";

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private String firstName;

  /**
   * 
   */
  private String companyName;

  /**
   * 
   */
  private String city;

  /**
   * Initialize object. Nothing special to do.
   */
  public CustomerQuery( ) {
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
   * Method returns the attribute "firstName".
   * 
   * 
   * @return String Value to which the attribute "firstName" is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets the attribute "firstName".
   * 
   * 
   * @param pFirstName Value to which the attribute "firstName" should be set.
   */
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * Method returns the attribute "companyName".
   * 
   * 
   * @return String Value to which the attribute "companyName" is set.
   */
  public String getCompanyName( ) {
    return companyName;
  }

  /**
   * Method sets the attribute "companyName".
   * 
   * 
   * @param pCompanyName Value to which the attribute "companyName" should be set.
   */
  public void setCompanyName( String pCompanyName ) {
    // Assign value to attribute
    companyName = pCompanyName;
  }

  /**
   * Method returns the attribute "city".
   * 
   * 
   * @return String Value to which the attribute "city" is set.
   */
  public String getCity( ) {
    return city;
  }

  /**
   * Method sets the attribute "city".
   * 
   * 
   * @param pCity Value to which the attribute "city" should be set.
   */
  public void setCity( String pCity ) {
    // Assign value to attribute
    city = pCity;
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
    lBuilder.append("firstName: ");
    lBuilder.append(firstName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("companyName: ");
    lBuilder.append(companyName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("city: ");
    lBuilder.append(city);
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
