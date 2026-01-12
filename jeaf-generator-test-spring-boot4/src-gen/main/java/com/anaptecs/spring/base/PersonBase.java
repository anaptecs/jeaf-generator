/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = PersonBase.PersonBuilderImpl.class)
public abstract class PersonBase extends Partner {
  /**
   * Constant for the name of attribute "surname".
   */
  public static final String SURNAME = "surname";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  private String surname;

  private String firstName;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PersonBase( PersonBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    surname = pBuilder.surname;
    firstName = pBuilder.firstName;
  }

  /**
   * Class implements builder to create a new instance of class <code>Person</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class PersonBuilder<T extends Person, B extends PersonBuilder<T, B>>
      extends PartnerBuilder<T, B> {
    private String surname;

    private String firstName;

    /**
     * Use {@link Person#builder()} instead of private constructor to create new builder.
     */
    protected PersonBuilder( ) {
      super();
    }

    /**
     * Use {@link Person#builder(Person)} instead of private constructor to create new builder.
     */
    protected PersonBuilder( PersonBase pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSurname(pObject.surname);
        this.setFirstName(pObject.firstName);
      }
    }

    /**
     * Method sets attribute {@link #surname}.<br/>
     *
     * @param pSurname Value to which {@link #surname} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSurname( @MyNotNullProperty String pSurname ) {
      // Assign value to attribute
      surname = pSurname;
      return this.self();
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setFirstName( @MyNotNullProperty String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this.self();
    }

    /**
     * Method creates a new instance of class Person. The object will be initialized with the values of the builder.
     *
     * @return Person Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class PersonBuilderImpl extends PersonBuilder<Person, PersonBuilderImpl> {
    protected PersonBuilderImpl( ) {
    }

    protected PersonBuilderImpl( Person pObject ) {
      super(pObject);
    }

    @Override
    protected PersonBuilderImpl self( ) {
      return this;
    }

    @Override
    public Person build( ) {
      Person lObject = new Person(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #surname}.<br/>
   *
   * @return {@link String} Value to which {@link #surname} is set.
   */
  @MyNotNullProperty
  public String getSurname( ) {
    return surname;
  }

  /**
   * Method sets attribute {@link #surname}.<br/>
   *
   * @param pSurname Value to which {@link #surname} should be set.
   */
  public void setSurname( @MyNotNullProperty String pSurname ) {
    // Assign value to attribute
    surname = pSurname;
  }

  /**
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  @MyNotNullProperty
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets attribute {@link #firstName}.<br/>
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   */
  public void setFirstName( @MyNotNullProperty String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * Convenience method to create new instance of class Person.
   *
   *
   * @param pSurname Value to which {@link #surname} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @return {@link Person}
   */
  public static Person of( String pSurname, String pFirstName ) {
    var lBuilder = Person.builder();
    lBuilder.setSurname(pSurname);
    lBuilder.setFirstName(pFirstName);
    return lBuilder.build();
  }

  /**
   * @return {@link String}
   */
  @MyNotNullProperty
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
   * @return {@link PersonBuilder} New builder that can be used to create new Person objects. The method never returns
   * null.
   */
  public PersonBuilder<?, ?> toBuilder( ) {
    return new PersonBuilderImpl((Person) this);
  }
}