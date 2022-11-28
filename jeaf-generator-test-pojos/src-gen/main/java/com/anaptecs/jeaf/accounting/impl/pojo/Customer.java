/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Customer extends CustomerBase {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Customer( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Customer( Customer.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Customer objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Customer objects. The method never returns null.
   */
  public static Builder builder( Customer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName, String pFirstName, String pEmail ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    lBuilder.setFirstName(pFirstName);
    lBuilder.setEmail(pEmail);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class Customer. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Customer.BuilderBase {
    /**
     * Use {@link Customer#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Customer#builder(Customer)} instead of protected constructor to create new builder.
     */
    protected Builder( Customer pObject ) {
      super(pObject);
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