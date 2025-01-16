/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;

@Valid
public abstract class PersonBase extends Partner {
  /**
   * Constant for the name of attribute "surname".
   */
  public static final String SURNAME = "surname";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  private final String surname;

  private final String firstName;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PersonBase( ) {
    surname = null;
    firstName = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PersonBase( BuilderBase pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    surname = pBuilder.surname;
    firstName = pBuilder.firstName;
  }

  /**
   * Class implements builder to create a new instance of class Person. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase extends Partner.Builder {
    private String surname;

    private String firstName;

    /**
     * Use {@link Person.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Person.builder(Person)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( PersonBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSurname(pObject.surname);
        this.setFirstName(pObject.firstName);
      }
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public BuilderBase setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // Call super class implementation.
      super.setPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Array of objects that should be added to {@link #postalAddresses}. The parameter may be
     * null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToPostalAddresses( PostalAddress... pPostalAddresses ) {
      // Call super class implementation.
      super.addToPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method sets attribute {@link #surname}.<br/>
     *
     * @param pSurname Value to which {@link #surname} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSurname( String pSurname ) {
      // Assign value to attribute
      surname = pSurname;
      return this;
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method creates a new instance of class Person. The object will be initialized with the values of the builder.
     *
     * @return Person Created object. The method never returns null.
     */
    public Person build( ) {
      return new Person(this);
    }
  }

  /**
   * Method returns attribute {@link #surname}.<br/>
   *
   * @return {@link String} Value to which {@link #surname} is set.
   */
  public String getSurname( ) {
    return surname;
  }

  /**
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Convenience method to create new instance of class Person.
   *
   *
   * @param pSurname Value to which {@link #surname} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @return {@link com.anaptecs.spring.base.Person}
   */
  public static Person of( String pSurname, String pFirstName ) {
    Person.Builder lBuilder = Person.builder();
    lBuilder.setSurname(pSurname);
    lBuilder.setFirstName(pFirstName);
    return lBuilder.build();
  }

  /**
   * @return {@link String}
   */
  public abstract String getDisplayName( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(surname);
    lResult = lPrime * lResult + Objects.hashCode(firstName);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      PersonBase lOther = (PersonBase) pObject;
      lEquals = Objects.equals(surname, lOther.surname) && Objects.equals(firstName, lOther.firstName);
    }
    return lEquals;
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
    lBuilder.append("surname: ");
    lBuilder.append(surname);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("firstName: ");
    lBuilder.append(firstName);
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
   * @return {@link Builder} New builder that can be used to create new Person objects. The method never returns null.
   */
  public Person.Builder toBuilder( ) {
    return new Person.Builder((Person) this);
  }
}