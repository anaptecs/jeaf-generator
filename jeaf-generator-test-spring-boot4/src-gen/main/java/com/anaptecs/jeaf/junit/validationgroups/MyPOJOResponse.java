/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import com.anaptecs.annotations.MyNotNullProperty;

public class MyPOJOResponse extends MyPOJOResponseBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected MyPOJOResponse( MyPOJOResponse.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class MyPOJOResponse. As the class has read-only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends MyPOJOResponse.BuilderBase {
    /**
     * Use {@link MyPOJOResponse#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyPOJOResponse#builder(MyPOJOResponse)} instead of protected constructor to create new builder.
     */
    protected Builder( MyPOJOResponse pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new MyPOJOResponse objects.
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
    public static Builder newBuilder( MyPOJOResponse pObject ) {
      return new Builder(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  @Override
  public String getDerivedProperty( ) {
    // TODO Implement method for derived property "derivedProperty".
    return null;
  }
}