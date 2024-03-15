/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PostalAddress implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "street".
   */
  public static final String STREET = "street";

  /**
   * Constant for the name of attribute "houseNumber".
   */
  public static final String HOUSENUMBER = "houseNumber";

  /**
   * Constant for the name of attribute "city".
   */
  public static final String CITY = "city";

  /**
   * Constant for the name of attribute "postalCode".
   */
  public static final String POSTALCODE = "postalCode";

  @ClassPropertyDeclaration
  private String street;

  private int streetXYZ = 0;

  @ClassPropertyDeclaration
  private String houseNumber;

  private int houseNumberXYZ = 0;

  @ClassPropertyDeclaration
  private String city;

  private int cityXYZ = 0;

  @ClassPropertyDeclaration
  private int postalCode;

  private int postalCodeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PostalAddress( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PostalAddress( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    street = pBuilder.street;
    streetXYZ = pBuilder.streetXYZ;
    houseNumber = pBuilder.houseNumber;
    houseNumberXYZ = pBuilder.houseNumberXYZ;
    city = pBuilder.city;
    cityXYZ = pBuilder.cityXYZ;
    postalCode = pBuilder.postalCode;
    postalCodeXYZ = pBuilder.postalCodeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>PostalAddress</code>.
   */
  public static class Builder {
    @BuilderPropertyDeclaration
    private String street;

    private int streetXYZ = 0;

    @BuilderPropertyDeclaration
    private String houseNumber;

    private int houseNumberXYZ = 0;

    @BuilderPropertyDeclaration
    private String city;

    private int cityXYZ = 0;

    @BuilderPropertyDeclaration
    private int postalCode;

    private int postalCodeXYZ = 0;

    /**
     * Use {@link PostalAddress#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PostalAddress#builder(PostalAddress)} instead of private constructor to create new builder.
     */
    protected Builder( PostalAddress pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStreet(pObject.street);
        this.setHouseNumber(pObject.houseNumber);
        this.setCity(pObject.city);
        this.setPostalCode(pObject.postalCode);
      }
    }

    /**
     * Method sets attribute {@link #street}.<br/>
     *
     * @param pStreet Value to which {@link #street} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStreet( String pStreet ) {
      // Assign value to attribute
      street = pStreet;
      return this;
    }

    public Builder setStreetXYZ( int value ) {
      streetXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #houseNumber}.<br/>
     *
     * @param pHouseNumber Value to which {@link #houseNumber} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHouseNumber( String pHouseNumber ) {
      // Assign value to attribute
      houseNumber = pHouseNumber;
      return this;
    }

    public Builder setHouseNumberXYZ( int value ) {
      houseNumberXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #city}.<br/>
     *
     * @param pCity Value to which {@link #city} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCity( String pCity ) {
      // Assign value to attribute
      city = pCity;
      return this;
    }

    public Builder setCityXYZ( int value ) {
      cityXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #postalCode}.<br/>
     *
     * @param pPostalCode Value to which {@link #postalCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPostalCode( int pPostalCode ) {
      // Assign value to attribute
      postalCode = pPostalCode;
      return this;
    }

    public Builder setPostalCodeXYZ( int value ) {
      postalCodeXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class PostalAddress. The object will be initialized with the values of the
     * builder.
     *
     * @return PostalAddress Created object. The method never returns null.
     */
    public PostalAddress build( ) {
      return new PostalAddress(this);
    }

    /**
     * Method creates a new validated instance of class PostalAddress. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return PostalAddress Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PostalAddress buildValidated( ) throws ConstraintViolationException {
      PostalAddress lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #street}.<br/>
   *
   * @return {@link String} Value to which {@link #street} is set.
   */
  public String getStreet( ) {
    return street;
  }

  /**
   * Method sets attribute {@link #street}.<br/>
   *
   * @param pStreet Value to which {@link #street} should be set.
   */
  public void setStreet( String pStreet ) {
    // Assign value to attribute
    street = pStreet;
  }

  public int getStreetXYZ( ) {
    return streetXYZ;
  }

  public void setStreetXYZ( int value ) {
    streetXYZ = value;
  }

  /**
   * Method returns attribute {@link #houseNumber}.<br/>
   *
   * @return {@link String} Value to which {@link #houseNumber} is set.
   */
  public String getHouseNumber( ) {
    return houseNumber;
  }

  /**
   * Method sets attribute {@link #houseNumber}.<br/>
   *
   * @param pHouseNumber Value to which {@link #houseNumber} should be set.
   */
  public void setHouseNumber( String pHouseNumber ) {
    // Assign value to attribute
    houseNumber = pHouseNumber;
  }

  public int getHouseNumberXYZ( ) {
    return houseNumberXYZ;
  }

  public void setHouseNumberXYZ( int value ) {
    houseNumberXYZ = value;
  }

  /**
   * Method returns attribute {@link #city}.<br/>
   *
   * @return {@link String} Value to which {@link #city} is set.
   */
  public String getCity( ) {
    return city;
  }

  /**
   * Method sets attribute {@link #city}.<br/>
   *
   * @param pCity Value to which {@link #city} should be set.
   */
  public void setCity( String pCity ) {
    // Assign value to attribute
    city = pCity;
  }

  public int getCityXYZ( ) {
    return cityXYZ;
  }

  public void setCityXYZ( int value ) {
    cityXYZ = value;
  }

  /**
   * Method returns attribute {@link #postalCode}.<br/>
   *
   * @return int Value to which {@link #postalCode} is set.
   */
  public int getPostalCode( ) {
    return postalCode;
  }

  /**
   * Method sets attribute {@link #postalCode}.<br/>
   *
   * @param pPostalCode Value to which {@link #postalCode} should be set.
   */
  public void setPostalCode( int pPostalCode ) {
    // Assign value to attribute
    postalCode = pPostalCode;
  }

  public int getPostalCodeXYZ( ) {
    return postalCodeXYZ;
  }

  public void setPostalCodeXYZ( int value ) {
    postalCodeXYZ = value;
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
    lBuilder.append("street: ");
    lBuilder.append(street);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("houseNumber: ");
    lBuilder.append(houseNumber);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("city: ");
    lBuilder.append(city);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("postalCode: ");
    lBuilder.append(postalCode);
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
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
