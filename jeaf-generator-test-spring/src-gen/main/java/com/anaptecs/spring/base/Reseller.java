/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;

@Valid
public class Reseller extends ResellerBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Reseller( ) {
  }

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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Reseller objects. The method never returns null.
   */
  public static Builder builder( Reseller pObject ) {
    return new Builder(pObject);
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

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new Reseller objects.
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
    public static Builder newBuilder( Reseller pObject ) {
      return new Builder(pObject);
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