/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import jakarta.validation.Valid;

@Valid
public class Reseller extends ResellerBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Reseller( Reseller.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Reseller objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class Reseller. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Reseller.BuilderBase {
    /**
     * Use {@link Reseller#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Reseller#builder(Reseller)} instead of protected constructor to create new builder.
     */
    protected Builder( Reseller pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link Integer}
   */
  @Override
  public Integer doSomething( ) {
    // TODO: Implement business logic for method.
    return null;
  }

  /**
   * @return double
   */
  @Override
  public double returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}