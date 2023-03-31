/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

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

  private String name;

  private Long registrationNumber;

  private Long taxNumber;

  private String attendant;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Class implements builder to create a new instance of class <code>Company</code>.
   */
  public static class Builder extends Customer.Builder {
    private String name;

    private Long registrationNumber;

    private Long taxNumber;

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
     * Method sets attribute {@link #active}.<br/>
     *
     * @param pActive Value to which {@link #active} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setActive( Boolean pActive ) {
      // Call super class implementation.
      super.setActive(pActive);
      return this;
    }

    /**
     * Method sets attribute {@link #street}.<br/>
     *
     * @param pStreet Value to which {@link #street} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setStreet( String pStreet ) {
      // Call super class implementation.
      super.setStreet(pStreet);
      return this;
    }

    /**
     * Method sets attribute {@link #zipCode}.<br/>
     *
     * @param pZipCode Value to which {@link #zipCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setZipCode( Integer pZipCode ) {
      // Call super class implementation.
      super.setZipCode(pZipCode);
      return this;
    }

    /**
     * Method sets attribute {@link #city}.<br/>
     *
     * @param pCity Value to which {@link #city} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setCity( String pCity ) {
      // Call super class implementation.
      super.setCity(pCity);
      return this;
    }

    /**
     * Method sets attribute {@link #country}.<br/>
     *
     * @param pCountry Value to which {@link #country} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setCountry( String pCountry ) {
      // Call super class implementation.
      super.setCountry(pCountry);
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #registrationNumber}.<br/>
     *
     * @param pRegistrationNumber Value to which {@link #registrationNumber} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setRegistrationNumber( Long pRegistrationNumber ) {
      // Assign value to attribute
      registrationNumber = pRegistrationNumber;
      return this;
    }

    /**
     * Method sets attribute {@link #taxNumber}.<br/>
     *
     * @param pTaxNumber Value to which {@link #taxNumber} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTaxNumber( Long pTaxNumber ) {
      // Assign value to attribute
      taxNumber = pTaxNumber;
      return this;
    }

    /**
     * Method sets attribute {@link #attendant}.<br/>
     *
     * @param pAttendant Value to which {@link #attendant} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
      Company lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
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
   * Method returns attribute {@link #registrationNumber}.<br/>
   *
   * @return {@link Long} Value to which {@link #registrationNumber} is set.
   */
  public Long getRegistrationNumber( ) {
    return registrationNumber;
  }

  /**
   * Method sets attribute {@link #registrationNumber}.<br/>
   *
   * @param pRegistrationNumber Value to which {@link #registrationNumber} should be set.
   */
  public void setRegistrationNumber( Long pRegistrationNumber ) {
    // Assign value to attribute
    registrationNumber = pRegistrationNumber;
  }

  /**
   * Method returns attribute {@link #taxNumber}.<br/>
   *
   * @return {@link Long} Value to which {@link #taxNumber} is set.
   */
  public Long getTaxNumber( ) {
    return taxNumber;
  }

  /**
   * Method sets attribute {@link #taxNumber}.<br/>
   *
   * @param pTaxNumber Value to which {@link #taxNumber} should be set.
   */
  public void setTaxNumber( Long pTaxNumber ) {
    // Assign value to attribute
    taxNumber = pTaxNumber;
  }

  /**
   * Method returns attribute {@link #attendant}.<br/>
   *
   * @return {@link String} Value to which {@link #attendant} is set.
   */
  public String getAttendant( ) {
    return attendant;
  }

  /**
   * Method sets attribute {@link #attendant}.<br/>
   *
   * @param pAttendant Value to which {@link #attendant} should be set.
   */
  public void setAttendant( String pAttendant ) {
    // Assign value to attribute
    attendant = pAttendant;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("registrationNumber: ");
    lBuilder.append(registrationNumber);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("taxNumber: ");
    lBuilder.append(taxNumber);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("attendant: ");
    lBuilder.append(attendant);
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
