/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class Customer extends CustomerBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Customer( CustomerBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link CustomerBuilder} New builder that can be used to create new Customer objects.
   */
  public static CustomerBuilder<?, ?> builder( ) {
    return new CustomerBuilderImpl();
  }

  /**
   * Class implements builder to create a new instance of class <code>Customer</code>.
   *
   * This class is intended to contain additional custom implementations inside the builder.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class CustomerBuilder<T extends Customer, B extends CustomerBuilder<T, B>>
      extends CustomerBuilderBase<T, B> {
    /**
     * Use {@link Customer#builder()} instead of private constructor to create new builder.
     */
    protected CustomerBuilder( ) {
      super();
    }

    /**
     * Use {@link Customer#builder(Customer)} instead of private constructor to create new builder.
     */
    protected CustomerBuilder( Customer pObject ) {
      super(pObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T build( ) {
      return (T) new Customer(this);
    }
    // TODO: Add your custom builder operations here.
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