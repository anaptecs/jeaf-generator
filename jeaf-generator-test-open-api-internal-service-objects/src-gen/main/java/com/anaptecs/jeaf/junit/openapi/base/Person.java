/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.Valid;

@Valid
public class Person extends PersonBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Person( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Person( Person.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Person objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pSurname, String pFirstName ) {
    Builder lBuilder = builder();
    lBuilder.setSurname(pSurname);
    lBuilder.setFirstName(pFirstName);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class Person. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Person.BuilderBase {
    /**
     * Use {@link Person#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Person#builder(Person)} instead of protected constructor to create new builder.
     */
    protected Builder( Person pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link String}
   */
  @Override
  public String getDisplayName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}