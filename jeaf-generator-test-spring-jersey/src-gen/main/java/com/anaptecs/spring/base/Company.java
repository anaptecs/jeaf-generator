/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Company.Builder.class)
public class Company extends Partner {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  private String name;

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
   * Class implements builder to create a new instance of class <code>Company</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder extends Partner.Builder {
    private String name;

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
        this.setName(pObject.name);
      }
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // Call super class implementation.
      super.setPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Array of objects that should be added to {@link #postalAddresses}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToPostalAddresses( PostalAddress... pPostalAddresses ) {
      // Call super class implementation.
      super.addToPostalAddresses(pPostalAddresses);
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
     * Method creates a new instance of class Company. The object will be initialized with the values of the builder.
     *
     * @return Company Created object. The method never returns null.
     */
    public Company build( ) {
      return new Company(this);
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
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
   * @return {@link Builder} New builder that can be used to create new Company objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}