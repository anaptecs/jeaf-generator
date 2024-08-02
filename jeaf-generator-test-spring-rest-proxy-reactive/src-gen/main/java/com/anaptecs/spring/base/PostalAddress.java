/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PostalAddress( ) {
    country = "Germany";
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PostalAddress( Builder pBuilder ) {
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
   * @param pCountry Value to which {@link #country} should be set.
   *
   * @return {@link com.anaptecs.spring.base.PostalAddress}
   */
  public static PostalAddress of( String pStreet, String pHouseNumber, String pCity, int pPostalCode,
      String pCountry ) {
    PostalAddress.Builder lBuilder = PostalAddress.builder();
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
  public static class Builder {
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
        this.setCountry(pObject.country);
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
     * Method sets attribute {@link #country}.<br/>
     *
     * @param pCountry Value to which {@link #country} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCountry( String pCountry ) {
      // Assign value to attribute
      country = pCountry;
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
  public String getCountry( ) {
    return country;
  }

  /**
   * Method sets attribute {@link #country}.<br/>
   *
   * @param pCountry Value to which {@link #country} should be set.
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}