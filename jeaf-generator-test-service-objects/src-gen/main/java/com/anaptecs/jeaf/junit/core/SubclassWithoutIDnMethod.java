/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

public class SubclassWithoutIDnMethod extends SubclassWithoutIDnMethodBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SubclassWithoutIDnMethod( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected SubclassWithoutIDnMethod( SubclassWithoutIDnMethod.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SubclassWithoutIDnMethod objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SubclassWithoutIDnMethod objects. The method
   * never returns null.
   */
  public static Builder builder( SubclassWithoutIDnMethod pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SubclassWithoutIDnMethod. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends SubclassWithoutIDnMethod.BuilderBase {
    /**
     * Use {@link SubclassWithoutIDnMethod#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SubclassWithoutIDnMethod#builder(SubclassWithoutIDnMethod)} instead of protected constructor to create
     * new builder.
     */
    protected Builder( SubclassWithoutIDnMethod pObject ) {
      super(pObject);
    }
  }

  /**
   */
  @Override
  public void doLess( ) {
    // TODO: Implement business logic for method.
  }
}