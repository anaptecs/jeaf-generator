/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class PostalAddress implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String street;

  @NotNull
  private String houseNumber;

  @NotNull
  private String city;

  private int postalCode;

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
    houseNumber = pBuilder.houseNumber;
    city = pBuilder.city;
    postalCode = pBuilder.postalCode;
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
   * Convenience method to create new instance of class PostalAddress.
   *
   *
   * @param pStreet Value to which {@link #street} should be set.
   *
   * @param pHouseNumber Value to which {@link #houseNumber} should be set.
   *
   * @param pCity Value to which {@link #city} should be set.
   *
   * @param pPostalCode Value to which {@link #postalCode} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.PostalAddress}
   */
  public static PostalAddress of( String pStreet, String pHouseNumber, String pCity, int pPostalCode ) {
    PostalAddress.Builder lBuilder = PostalAddress.builder();
    lBuilder.setStreet(pStreet);
    lBuilder.setHouseNumber(pHouseNumber);
    lBuilder.setCity(pCity);
    lBuilder.setPostalCode(pPostalCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PostalAddress</code>.
   */
  public static class Builder {
    private String street;

    private String houseNumber;

    private String city;

    private int postalCode;

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
    public Builder setStreet( @MyNotNull String pStreet ) {
      // Assign value to attribute
      street = pStreet;
      return this;
    }

    /**
     * Method sets attribute {@link #houseNumber}.<br/>
     *
     * @param pHouseNumber Value to which {@link #houseNumber} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHouseNumber( @MyNotNull String pHouseNumber ) {
      // Assign value to attribute
      houseNumber = pHouseNumber;
      return this;
    }

    /**
     * Method sets attribute {@link #city}.<br/>
     *
     * @param pCity Value to which {@link #city} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCity( @MyNotNull String pCity ) {
      // Assign value to attribute
      city = pCity;
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
  @MyNotNull
  public String getStreet( ) {
    return street;
  }

  /**
   * Method sets attribute {@link #street}.<br/>
   *
   * @param pStreet Value to which {@link #street} should be set.
   */
  public void setStreet( @MyNotNull String pStreet ) {
    // Assign value to attribute
    street = pStreet;
  }

  /**
   * Method returns attribute {@link #houseNumber}.<br/>
   *
   * @return {@link String} Value to which {@link #houseNumber} is set.
   */
  @MyNotNull
  public String getHouseNumber( ) {
    return houseNumber;
  }

  /**
   * Method sets attribute {@link #houseNumber}.<br/>
   *
   * @param pHouseNumber Value to which {@link #houseNumber} should be set.
   */
  public void setHouseNumber( @MyNotNull String pHouseNumber ) {
    // Assign value to attribute
    houseNumber = pHouseNumber;
  }

  /**
   * Method returns attribute {@link #city}.<br/>
   *
   * @return {@link String} Value to which {@link #city} is set.
   */
  @MyNotNull
  public String getCity( ) {
    return city;
  }

  /**
   * Method sets attribute {@link #city}.<br/>
   *
   * @param pCity Value to which {@link #city} should be set.
   */
  public void setCity( @MyNotNull String pCity ) {
    // Assign value to attribute
    city = pCity;
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
