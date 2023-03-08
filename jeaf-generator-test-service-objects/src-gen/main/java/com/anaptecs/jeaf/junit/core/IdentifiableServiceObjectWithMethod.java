/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

public class IdentifiableServiceObjectWithMethod extends IdentifiableServiceObjectWithMethodBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected IdentifiableServiceObjectWithMethod( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected IdentifiableServiceObjectWithMethod( IdentifiableServiceObjectWithMethod.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new IdentifiableServiceObjectWithMethod objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new IdentifiableServiceObjectWithMethod objects. The
   * method never returns null.
   */
  public static Builder builder( IdentifiableServiceObjectWithMethod pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class IdentifiableServiceObjectWithMethod. As the class has
   * readonly attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static class Builder extends IdentifiableServiceObjectWithMethod.BuilderBase {
    /**
     * Use {@link IdentifiableServiceObjectWithMethod#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link IdentifiableServiceObjectWithMethod#builder(IdentifiableServiceObjectWithMethod)} instead of protected
     * constructor to create new builder.
     */
    protected Builder( IdentifiableServiceObjectWithMethod pObject ) {
      super(pObject);
    }
  }

  /**
  * 
  */
  @Override
  public void doSomething( ) {
    // TODO: Implement business logic for method.
  }
}