/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class Customer implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "active".
   */
  public static final String ACTIVE = "active";

  /**
   * Constant for the name of attribute "street".
   */
  public static final String STREET = "street";

  /**
   * Constant for the name of attribute "zipCode".
   */
  public static final String ZIPCODE = "zipCode";

  /**
   * Constant for the name of attribute "city".
   */
  public static final String CITY = "city";

  /**
   * Constant for the name of attribute "country".
   */
  public static final String COUNTRY = "country";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  @NotNull
  private Boolean active;

  /**
   * 
   */
  private String street;

  /**
   * 
   */
  @Positive
  private Integer zipCode;

  /**
   * 
   */
  @NotBlank
  private String city;

  /**
   * 
   */
  @NotBlank
  private String country;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Customer( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Customer( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    active = pBuilder.active;
    street = pBuilder.street;
    zipCode = pBuilder.zipCode;
    city = pBuilder.city;
    country = pBuilder.country;
  }

  /**
   * Class implements builder to create a new instance of class Customer. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    /**
     * 
     */
    @NotNull
    private Boolean active;

    /**
     * 
     */
    private String street;

    /**
     * 
     */
    @Positive
    private Integer zipCode;

    /**
     * 
     */
    @NotBlank
    private String city;

    /**
     * 
     */
    @NotBlank
    private String country;

    /**
     * Use {@link Customer#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Customer#builder(Customer)} instead of private constructor to create new builder.
     */
    protected Builder( Customer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        active = pObject.active;
        street = pObject.street;
        zipCode = pObject.zipCode;
        city = pObject.city;
        country = pObject.country;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "active".
     * 
     * @param pActive Value to which the attribute "active" should be set.
     */
    public Builder setActive( Boolean pActive ) {
      // Assign value to attribute
      active = pActive;
      return this;
    }

    /**
     * Method sets the attribute "street".
     * 
     * @param pStreet Value to which the attribute "street" should be set.
     */
    public Builder setStreet( String pStreet ) {
      // Assign value to attribute
      street = pStreet;
      return this;
    }

    /**
     * Method sets the attribute "zipCode".
     * 
     * @param pZipCode Value to which the attribute "zipCode" should be set.
     */
    public Builder setZipCode( Integer pZipCode ) {
      // Assign value to attribute
      zipCode = pZipCode;
      return this;
    }

    /**
     * Method sets the attribute "city".
     * 
     * @param pCity Value to which the attribute "city" should be set.
     */
    public Builder setCity( String pCity ) {
      // Assign value to attribute
      city = pCity;
      return this;
    }

    /**
     * Method sets the attribute "country".
     * 
     * @param pCountry Value to which the attribute "country" should be set.
     */
    public Builder setCountry( String pCountry ) {
      // Assign value to attribute
      country = pCountry;
      return this;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the attribute "active".
   * 
   * 
   * @return Boolean Value to which the attribute "active" is set.
   */
  public Boolean getActive( ) {
    return active;
  }

  /**
   * Method sets the attribute "active".
   * 
   * 
   * @param pActive Value to which the attribute "active" should be set.
   */
  public void setActive( Boolean pActive ) {
    // Assign value to attribute
    active = pActive;
  }

  /**
   * Method returns the attribute "street".
   * 
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
   * Method returns the attribute "zipCode".
   * 
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
   * Method returns the attribute "country".
   * 
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
    lBuilder.append("active: ");
    lBuilder.append(active);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("street: ");
    lBuilder.append(street);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("zipCode: ");
    lBuilder.append(zipCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("city: ");
    lBuilder.append(city);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("country: ");
    lBuilder.append(country);
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
