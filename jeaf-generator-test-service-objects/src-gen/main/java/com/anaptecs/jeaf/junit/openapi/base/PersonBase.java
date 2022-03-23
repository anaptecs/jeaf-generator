/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Valid()
public abstract class PersonBase extends Partner {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "surname".
   */
  public static final String SURNAME = "surname";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  /**
   * 
   */
  private String surname;

  /**
   * 
   */
  private String firstName;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PersonBase( ) {
    // Nothing to do.
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
    /**
     * 
     */
    private String surname;

    /**
     * 
     */
    private String firstName;

    /**
     * Use {@link Person.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
      super();
    }

    /**
     * Use {@link Person.Builder#newBuilder(Person)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( PersonBase pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        surname = pObject.surname;
        firstName = pObject.firstName;
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
     * Method sets the association "postalAddresses".
     * 
     * @param pPostalAddresses Collection with objects to which the association should be set.
     */
    @Override
    public BuilderBase setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // Call super class implementation.
      super.setPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method sets the attribute "surname".
     * 
     * @param pSurname Value to which the attribute "surname" should be set.
     */
    public BuilderBase setSurname( String pSurname ) {
      // Assign value to attribute
      surname = pSurname;
      return this;
    }

    /**
     * Method sets the attribute "firstName".
     * 
     * @param pFirstName Value to which the attribute "firstName" should be set.
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

    /**
     * Method creates a new validated instance of class Person. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Person Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Person buildValidated( ) throws ConstraintViolationException {
      Person lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "surname".
   * 
   * 
   * @return String Value to which the attribute "surname" is set.
   */
  public String getSurname( ) {
    return surname;
  }

  /**
   * Method sets the attribute "surname".
   * 
   * 
   * @param pSurname Value to which the attribute "surname" should be set.
   */
  public void setSurname( String pSurname ) {
    // Assign value to attribute
    surname = pSurname;
  }

  /**
   * Method returns the attribute "firstName".
   * 
   * 
   * @return String Value to which the attribute "firstName" is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets the attribute "firstName".
   * 
   * 
   * @param pFirstName Value to which the attribute "firstName" should be set.
   */
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * 
   * @return {@link String}
   */
  public abstract String getDisplayName( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "surname", "" + surname));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "firstName", "" + firstName));
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
