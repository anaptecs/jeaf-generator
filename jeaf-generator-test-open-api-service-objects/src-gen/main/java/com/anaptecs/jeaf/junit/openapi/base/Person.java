/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.Valid;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Person extends PersonBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class Person. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Person.BuilderBase {
    /**
     * Use {@link #newBuilder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Person)} instead of protected constructor to create new builder.
     */
    protected Builder( Person pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Person objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects. The method never
     * returns null.
     */
    public static Builder newBuilder( Person pObject ) {
      return new Builder(pObject);
    }
  }

  /**
   * 
   * @return {@link String}
   */
  @Override
  public String getDisplayName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}