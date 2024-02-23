/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Set;

/**
 * Data type represents a product definition
 * <p/>
 * <b>Alternate Name:</b> Produkt
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Product extends ProductBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Product( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Product( Product.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Product objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class Product. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Product.BuilderBase {
    /**
     * Use {@link Product#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Product#builder(Product)} instead of protected constructor to create new builder.
     */
    protected Builder( Product pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns association {@link #theChannels}.<br/>
   *
   * @return {@link Set<Channel>} Value to which {@link #theChannels} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Channel> getTheChannels( ) {
    // TODO Implement method for derived property "theChannels".
    return null;
  }
}