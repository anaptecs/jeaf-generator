/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@Valid
@JEAFCustomAnnotationTest
public abstract class PersonBase extends Partner {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "surname".
   */
  @JEAFCustomAnnotationTest
  public static final String SURNAME = "surname";

  /**
   * Constant for the name of attribute "firstName".
   */
  @JEAFCustomAnnotationTest
  public static final String FIRSTNAME = "firstName";

  /**
   * <p/>
   * <b>Alternate Name:</b> <code>Vorname</code>
   */
  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String surname;

  // "java.lang.String"
  private int surnameXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String firstName;

  // "java.lang.String"
  private int firstNameXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PersonBase( ) {
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
    // "java.lang.String"
    surnameXYZ = pBuilder.surnameXYZ;
    firstName = pBuilder.firstName;
    // "java.lang.String"
    firstNameXYZ = pBuilder.firstNameXYZ;
  }

  /**
   * Class implements builder to create a new instance of class Person. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase extends Partner.Builder {
    /**
     * <p/>
     * <b>Alternate Name:</b> <code>Vorname</code>
     */
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String surname;

    // "java.lang.String"
    private int surnameXYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String firstName;

    // "java.lang.String"
    private int firstNameXYZ = 0;

    /**
     * Use {@link Person.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
      super();
    }

    /**
     * Use {@link Person.builder(Person)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( PersonBase pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSurname(pObject.surname);
        this.setFirstName(pObject.firstName);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
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
    @JEAFCustomAnnotationTest
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
    @JEAFCustomAnnotationTest
    public BuilderBase setSurname( String pSurname ) {
      // Assign value to attribute
      surname = pSurname;
      return this;
    }

    public BuilderBase setSurnameXYZ( int value ) {
      // "java.lang.String"
      surnameXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    public BuilderBase setFirstNameXYZ( int value ) {
      // "java.lang.String"
      firstNameXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Person. The object will be initialized with the values of the builder.
     *
     * @return Person Created object. The method never returns null.
     */
    public Person build( ) {
      return new Person(this);
    }

    /**
     * Method creates a new validated instance of class Person. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Person Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Person buildValidated( ) throws ConstraintViolationException {
      Person lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #surname}.<br/>
   *
   * @return {@link String} Value to which {@link #surname} is set.
   */
  @JEAFCustomAnnotationTest
  public String getSurname( ) {
    return surname;
  }

  /**
   * Method sets attribute {@link #surname}.<br/>
   *
   * @param pSurname Value to which {@link #surname} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setSurname( String pSurname ) {
    // Assign value to attribute
    surname = pSurname;
  }

  public int getSurnameXYZ( ) {
    // "java.lang.String"
    return surnameXYZ;
  }

  public void setSurnameXYZ( int value ) {
    surnameXYZ = value;
  }

  /**
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  @JEAFCustomAnnotationTest
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets attribute {@link #firstName}.<br/>
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  public int getFirstNameXYZ( ) {
    // "java.lang.String"
    return firstNameXYZ;
  }

  public void setFirstNameXYZ( int value ) {
    firstNameXYZ = value;
  }

  /**
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  public abstract String getDisplayName( );

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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