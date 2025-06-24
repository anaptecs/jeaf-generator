/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = PostalAddress.PostalAddressBuilderImpl.class)
public class PostalAddress {
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

  /**
   * Constant for the name of attribute "country".
   */
  public static final String COUNTRY = "country";

  private String street;

  private String houseNumber;

  private String city;

  private int postalCode;

  /**
   * <br/>
   * <b>Default Value:</b> <code>"Germany"</code>
   */
  private String country;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PostalAddress( PostalAddressBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    street = pBuilder.street;
    houseNumber = pBuilder.houseNumber;
    city = pBuilder.city;
    postalCode = pBuilder.postalCode;
    country = pBuilder.country;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects.
   */
  public static PostalAddressBuilder<?, ?> builder( ) {
    return new PostalAddressBuilderImpl();
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
   * @param pCountry Value to which {@link #country} should be set.
   *
   * @return {@link PostalAddress}
   */
  public static PostalAddress of( String pStreet, String pHouseNumber, String pCity, int pPostalCode,
      String pCountry ) {
    var lBuilder = PostalAddress.builder();
    lBuilder.setStreet(pStreet);
    lBuilder.setHouseNumber(pHouseNumber);
    lBuilder.setCity(pCity);
    lBuilder.setPostalCode(pPostalCode);
    lBuilder.setCountry(pCountry);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PostalAddress</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class PostalAddressBuilder<T extends PostalAddress, B extends PostalAddressBuilder<T, B>> {
    private String street;

    private String houseNumber;

    private String city;

    private int postalCode;

    /**
     * <br/>
     * <b>Default Value:</b> <code>"Germany"</code>
     */
    private String country = "Germany";

    /**
     * Use {@link PostalAddressBuilder#builder()} instead of private constructor to create new builder.
     */
    protected PostalAddressBuilder( ) {
    }

    /**
     * Use {@link PostalAddressBuilder#builder(PostalAddress)} instead of private constructor to create new builder.
     */
    protected PostalAddressBuilder( PostalAddress pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStreet(pObject.street);
        this.setHouseNumber(pObject.houseNumber);
        this.setCity(pObject.city);
        this.setPostalCode(pObject.postalCode);
        this.setCountry(pObject.country);
      }
    }

    /**
     * Method sets attribute {@link #street}.<br/>
     *
     * @param pStreet Value to which {@link #street} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setStreet( @MyNotNullProperty String pStreet ) {
      // Assign value to attribute
      street = pStreet;
      return this.self();
    }

    /**
     * Method sets attribute {@link #houseNumber}.<br/>
     *
     * @param pHouseNumber Value to which {@link #houseNumber} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setHouseNumber( @MyNotNullProperty String pHouseNumber ) {
      // Assign value to attribute
      houseNumber = pHouseNumber;
      return this.self();
    }

    /**
     * Method sets attribute {@link #city}.<br/>
     *
     * @param pCity Value to which {@link #city} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setCity( @MyNotNullProperty String pCity ) {
      // Assign value to attribute
      city = pCity;
      return this.self();
    }

    /**
     * Method sets attribute {@link #postalCode}.<br/>
     *
     * @param pPostalCode Value to which {@link #postalCode} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setPostalCode( int pPostalCode ) {
      // Assign value to attribute
      postalCode = pPostalCode;
      return this.self();
    }

    /**
     * Method sets attribute {@link #country}.<br/>
     *
     * @param pCountry Value to which {@link #country} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setCountry( @MyNotNullProperty String pCountry ) {
      // Assign value to attribute
      country = pCountry;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class PostalAddress. The object will be initialized with the values of the
     * builder.
     *
     * @return PostalAddress Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class PostalAddressBuilderImpl extends PostalAddressBuilder<PostalAddress, PostalAddressBuilderImpl> {
    protected PostalAddressBuilderImpl( ) {
    }

    protected PostalAddressBuilderImpl( PostalAddress pObject ) {
      super(pObject);
    }

    @Override
    protected PostalAddressBuilderImpl self( ) {
      return this;
    }

    @Override
    public PostalAddress build( ) {
      PostalAddress lObject = new PostalAddress(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #street}.<br/>
   *
   * @return {@link String} Value to which {@link #street} is set.
   */
  @MyNotNullProperty
  public String getStreet( ) {
    return street;
  }

  /**
   * Method sets attribute {@link #street}.<br/>
   *
   * @param pStreet Value to which {@link #street} should be set.
   */
  public void setStreet( @MyNotNullProperty String pStreet ) {
    // Assign value to attribute
    street = pStreet;
  }

  /**
   * Method returns attribute {@link #houseNumber}.<br/>
   *
   * @return {@link String} Value to which {@link #houseNumber} is set.
   */
  @MyNotNullProperty
  public String getHouseNumber( ) {
    return houseNumber;
  }

  /**
   * Method sets attribute {@link #houseNumber}.<br/>
   *
   * @param pHouseNumber Value to which {@link #houseNumber} should be set.
   */
  public void setHouseNumber( @MyNotNullProperty String pHouseNumber ) {
    // Assign value to attribute
    houseNumber = pHouseNumber;
  }

  /**
   * Method returns attribute {@link #city}.<br/>
   *
   * @return {@link String} Value to which {@link #city} is set.
   */
  @MyNotNullProperty
  public String getCity( ) {
    return city;
  }

  /**
   * Method sets attribute {@link #city}.<br/>
   *
   * @param pCity Value to which {@link #city} should be set.
   */
  public void setCity( @MyNotNullProperty String pCity ) {
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
   * Method returns attribute {@link #country}.<br/>
   *
   * @return {@link String} Value to which {@link #country} is set.
   */
  @MyNotNullProperty
  public String getCountry( ) {
    return country;
  }

  /**
   * Method sets attribute {@link #country}.<br/>
   *
   * @param pCountry Value to which {@link #country} should be set.
   */
  public void setCountry( @MyNotNullProperty String pCountry ) {
    // Assign value to attribute
    country = pCountry;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(street);
    lResult = lPrime * lResult + Objects.hashCode(houseNumber);
    lResult = lPrime * lResult + Objects.hashCode(city);
    lResult = lPrime * lResult + postalCode;
    lResult = lPrime * lResult + Objects.hashCode(country);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      PostalAddress lOther = (PostalAddress) pObject;
      lEquals = Objects.equals(street, lOther.street) && Objects.equals(houseNumber, lOther.houseNumber)
          && Objects.equals(city, lOther.city) && postalCode == lOther.postalCode
          && Objects.equals(country, lOther.country);
    }
    return lEquals;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects. The method never returns
   * null.
   */
  public PostalAddressBuilder<?, ?> toBuilder( ) {
    return new PostalAddressBuilderImpl(this);
  }
}