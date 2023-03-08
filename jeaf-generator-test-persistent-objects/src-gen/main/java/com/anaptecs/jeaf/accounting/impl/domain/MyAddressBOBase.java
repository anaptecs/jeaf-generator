package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class MyAddressBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1110, MyAddressBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "SAMPLE_ADDRESS";

  /**
   * Constant for the name of the row that is used to store the values of attribute "street".
   */
  public static final String STREET_ROW = "STREET";

  /**
   * Constant for the name of attribute "street".
   */
  public static final String STREET_ATTRIBUTE = "street";

  /**
   * Constant for the name of the row that is used to store the values of attribute "zipCode".
   */
  public static final String ZIPCODE_ROW = "ZIPCODE";

  /**
   * Constant for the name of attribute "zipCode".
   */
  public static final String ZIPCODE_ATTRIBUTE = "zipCode";

  /**
   * Constant for the name of the row that is used to store the values of attribute "city".
   */
  public static final String CITY_ROW = "CITY";

  /**
   * Constant for the name of attribute "city".
   */
  public static final String CITY_ATTRIBUTE = "city";

  /**
   * Constant for the name of the row that is used to store the values of attribute "country".
   */
  public static final String COUNTRY_ROW = "COUNTRY";

  /**
   * Constant for the name of attribute "country".
   */
  public static final String COUNTRY_ATTRIBUTE = "country";

  private String street;

  private Integer zipCode;

  private String city;

  private String country;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected MyAddressBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<MyAddressBO> findAllMyAddressBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(MyAddressBO.class);
  }

  /**
   * Method returns attribute {@link #street}.<br/>
   * 
   * @return String Value to which the attribute "street" is set.
   */
  public String getStreet( ) {
    return street;
  }

  /**
   * Method sets the attribute "street".
   * 
   * 
   * @param pStreet Value to which the attribute "street" should be set.
   */
  public void setStreet( String pStreet ) {
    // Assign value to attribute
    street = pStreet;
  }

  /**
   * Method returns attribute {@link #zipCode}.<br/>
   * 
   * @return Integer Value to which the attribute "zipCode" is set.
   */
  public Integer getZipCode( ) {
    return zipCode;
  }

  /**
   * Method sets the attribute "zipCode".
   * 
   * 
   * @param pZipCode Value to which the attribute "zipCode" should be set.
   */
  public void setZipCode( Integer pZipCode ) {
    // Assign value to attribute
    zipCode = pZipCode;
  }

  /**
   * Method returns attribute {@link #city}.<br/>
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
   * Method returns attribute {@link #country}.<br/>
   * 
   * @return String Value to which the attribute "country" is set.
   */
  public String getCountry( ) {
    return country;
  }

  /**
   * Method sets the attribute "country".
   * 
   * 
   * @param pCountry Value to which the attribute "country" should be set.
   */
  public void setCountry( String pCountry ) {
    // Assign value to attribute
    country = pCountry;
  }

  /**
   * Method returns the class id of this business object class.
   * 
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}
