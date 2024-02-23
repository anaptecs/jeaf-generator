/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class POJOWithIDnMethod extends POJOWithIDnMethodBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POJOWithIDnMethod( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected POJOWithIDnMethod( POJOWithIDnMethod.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class POJOWithIDnMethod. As the class has readonly attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends POJOWithIDnMethod.BuilderBase {
    /**
     * Use {@link POJOWithIDnMethod#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link POJOWithIDnMethod#builder(POJOWithIDnMethod)} instead of protected constructor to create new builder.
     */
    protected Builder( POJOWithIDnMethod pObject ) {
      super(pObject);
    }
  }

  /**
   * @return boolean
   */
  @Override
  public boolean doSomethingFunny( ) {
    // TODO: Implement business logic for method.
    return false;
  }
}