/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Company extends Customer {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "registrationNumber".
   */
  public static final String REGISTRATIONNUMBER = "registrationNumber";

  /**
   * Constant for the name of attribute "taxNumber".
   */
  public static final String TAXNUMBER = "taxNumber";

  /**
   * Constant for the name of attribute "attendant".
   */
  public static final String ATTENDANT = "attendant";

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private Long registrationNumber;

  /**
   * 
   */
  private Long taxNumber;

  /**
   * 
   */
  private String attendant;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Company( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Company( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    name = pBuilder.name;
    registrationNumber = pBuilder.registrationNumber;
    taxNumber = pBuilder.taxNumber;
    attendant = pBuilder.attendant;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Company objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Company objects. The method never returns null.
   */
  public static Builder builder( Company pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Company. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Customer.Builder {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long registrationNumber;

    /**
     * 
     */
    private Long taxNumber;

    /**
     * 
     */
    private String attendant;

    /**
     * Use {@link Company#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link Company#builder(Company)} instead of private constructor to create new builder.
     */
    protected Builder( Company pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        registrationNumber = pObject.registrationNumber;
        taxNumber = pObject.taxNumber;
        attendant = pObject.attendant;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets the attribute "active".
     * 
     * @param pActive Value to which the attribute "active" should be set.
     */
    @Override
    public Builder setActive( Boolean pActive ) {
      // Call super class implementation.
      super.setActive(pActive);
      return this;
    }

    /**
     * Method sets the attribute "street".
     * 
     * @param pStreet Value to which the attribute "street" should be set.
     */
    @Override
    public Builder setStreet( String pStreet ) {
      // Call super class implementation.
      super.setStreet(pStreet);
      return this;
    }

    /**
     * Method sets the attribute "zipCode".
     * 
     * @param pZipCode Value to which the attribute "zipCode" should be set.
     */
    @Override
    public Builder setZipCode( Integer pZipCode ) {
      // Call super class implementation.
      super.setZipCode(pZipCode);
      return this;
    }

    /**
     * Method sets the attribute "city".
     * 
     * @param pCity Value to which the attribute "city" should be set.
     */
    @Override
    public Builder setCity( String pCity ) {
      // Call super class implementation.
      super.setCity(pCity);
      return this;
    }

    /**
     * Method sets the attribute "country".
     * 
     * @param pCountry Value to which the attribute "country" should be set.
     */
    @Override
    public Builder setCountry( String pCountry ) {
      // Call super class implementation.
      super.setCountry(pCountry);
      return this;
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "registrationNumber".
     * 
     * @param pRegistrationNumber Value to which the attribute "registrationNumber" should be set.
     */
    public Builder setRegistrationNumber( Long pRegistrationNumber ) {
      // Assign value to attribute
      registrationNumber = pRegistrationNumber;
      return this;
    }

    /**
     * Method sets the attribute "taxNumber".
     * 
     * @param pTaxNumber Value to which the attribute "taxNumber" should be set.
     */
    public Builder setTaxNumber( Long pTaxNumber ) {
      // Assign value to attribute
      taxNumber = pTaxNumber;
      return this;
    }

    /**
     * Method sets the attribute "attendant".
     * 
     * @param pAttendant Value to which the attribute "attendant" should be set.
     */
    public Builder setAttendant( String pAttendant ) {
      // Assign value to attribute
      attendant = pAttendant;
      return this;
    }

    /**
     * Method creates a new instance of class Company. The object will be initialized with the values of the builder.
     * 
     * @return Company Created object. The method never returns null.
     */
    public Company build( ) {
      return new Company(this);
    }

    /**
     * Method creates a new validated instance of class Company. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Company Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Company buildValidated( ) throws ConstraintViolationException {
      Company lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
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
   * Method returns the attribute "registrationNumber".
   * 
   * 
   * @return Long Value to which the attribute "registrationNumber" is set.
   */
  public Long getRegistrationNumber( ) {
    return registrationNumber;
  }

  /**
   * Method sets the attribute "registrationNumber".
   * 
   * 
   * @param pRegistrationNumber Value to which the attribute "registrationNumber" should be set.
   */
  public void setRegistrationNumber( Long pRegistrationNumber ) {
    // Assign value to attribute
    registrationNumber = pRegistrationNumber;
  }

  /**
   * Method returns the attribute "taxNumber".
   * 
   * 
   * @return Long Value to which the attribute "taxNumber" is set.
   */
  public Long getTaxNumber( ) {
    return taxNumber;
  }

  /**
   * Method sets the attribute "taxNumber".
   * 
   * 
   * @param pTaxNumber Value to which the attribute "taxNumber" should be set.
   */
  public void setTaxNumber( Long pTaxNumber ) {
    // Assign value to attribute
    taxNumber = pTaxNumber;
  }

  /**
   * Method returns the attribute "attendant".
   * 
   * 
   * @return String Value to which the attribute "attendant" is set.
   */
  public String getAttendant( ) {
    return attendant;
  }

  /**
   * Method sets the attribute "attendant".
   * 
   * 
   * @param pAttendant Value to which the attribute "attendant" should be set.
   */
  public void setAttendant( String pAttendant ) {
    // Assign value to attribute
    attendant = pAttendant;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "registrationNumber",
        "" + registrationNumber));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "taxNumber", "" + taxNumber));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "attendant", "" + attendant));
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
