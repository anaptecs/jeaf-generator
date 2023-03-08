/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

public class PartiallyDeprecatedServiceObject extends PartiallyDeprecatedServiceObjectBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PartiallyDeprecatedServiceObject( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected PartiallyDeprecatedServiceObject( PartiallyDeprecatedServiceObject.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PartiallyDeprecatedServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PartiallyDeprecatedServiceObject objects. The
   * method never returns null.
   */
  public static Builder builder( PartiallyDeprecatedServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PartiallyDeprecatedServiceObject. As the class has
   * readonly attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static class Builder extends PartiallyDeprecatedServiceObject.BuilderBase {
    /**
     * Use {@link PartiallyDeprecatedServiceObject#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PartiallyDeprecatedServiceObject#builder(PartiallyDeprecatedServiceObject)} instead of protected
     * constructor to create new builder.
     */
    protected Builder( PartiallyDeprecatedServiceObject pObject ) {
      super(pObject);
    }
  }

  /**
   * @deprecated (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public void doSomethingDeprecated( ) {
    // TODO: Implement business logic for method.
  }

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String doSomething( int pParam1, @Deprecated int pParam2 ) {
    // TODO: Implement business logic for method.
    return null;
  }
}