/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

public class Customer extends CustomerBase {
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
   * @return {@link String}
   */
  @Override
  public String getDisplayName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}