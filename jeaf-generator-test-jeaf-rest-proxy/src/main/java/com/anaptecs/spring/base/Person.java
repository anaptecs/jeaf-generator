
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

@javax.validation.Valid
public class Person extends PersonBase {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Person objects. The method never returns null.
   */
  public static Builder builder(com.anaptecs.spring.base.Person pObject) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder(java.lang.String pSurname, java.lang.String pFirstName) {
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
   * @return {@link java.lang.String}
   */
  @Override
  public java.lang.String getDisplayName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}
