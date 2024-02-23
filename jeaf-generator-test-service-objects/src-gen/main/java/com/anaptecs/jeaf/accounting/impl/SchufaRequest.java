/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl;

import java.util.Calendar;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class SchufaRequest implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH = "dateOfBirth";

  private String name;

  private String firstName;

  private Calendar dateOfBirth;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SchufaRequest( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SchufaRequest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    firstName = pBuilder.firstName;
    dateOfBirth = pBuilder.dateOfBirth;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SchufaRequest objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class SchufaRequest.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   *
   * @return {@link com.anaptecs.jeaf.accounting.impl.SchufaRequest}
   */
  public static SchufaRequest of( String pName, String pFirstName, Calendar pDateOfBirth ) {
    SchufaRequest.Builder lBuilder = SchufaRequest.builder();
    lBuilder.setName(pName);
    lBuilder.setFirstName(pFirstName);
    lBuilder.setDateOfBirth(pDateOfBirth);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SchufaRequest</code>.
   */
  public static class Builder {
    private String name;

    private String firstName;

    private Calendar dateOfBirth;

    /**
     * Use {@link SchufaRequest#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SchufaRequest#builder(SchufaRequest)} instead of private constructor to create new builder.
     */
    protected Builder( SchufaRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setFirstName(pObject.firstName);
        this.setDateOfBirth(pObject.dateOfBirth);
      }
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
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method sets attribute {@link #dateOfBirth}.<br/>
     *
     * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDateOfBirth( Calendar pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    /**
     * Method creates a new instance of class SchufaRequest. The object will be initialized with the values of the
     * builder.
     *
     * @return SchufaRequest Created object. The method never returns null.
     */
    public SchufaRequest build( ) {
      SchufaRequest lObject = new SchufaRequest(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class SchufaRequest. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return SchufaRequest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SchufaRequest buildValidated( ) throws ConstraintViolationException {
      SchufaRequest lObject = this.build();
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
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets attribute {@link #firstName}.<br/>
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   */
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * Method returns attribute {@link #dateOfBirth}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #dateOfBirth} is set.
   */
  public Calendar getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets attribute {@link #dateOfBirth}.<br/>
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   */
  public void setDateOfBirth( Calendar pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("firstName: ");
    lBuilder.append(firstName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dateOfBirth: ");
    lBuilder.append(dateOfBirth);
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
   * @return {@link Builder} New builder that can be used to create new SchufaRequest objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
