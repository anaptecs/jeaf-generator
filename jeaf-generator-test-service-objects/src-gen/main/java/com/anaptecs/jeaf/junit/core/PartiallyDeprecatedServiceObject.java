/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PartiallyDeprecatedServiceObject extends PartiallyDeprecatedServiceObjectBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class PartiallyDeprecatedServiceObject. As the class has
   * readonly attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static class Builder extends PartiallyDeprecatedServiceObject.BuilderBase {
    /**
     * Use {@link #newBuilder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PartiallyDeprecatedServiceObject)} instead of protected constructor to create new builder.
     */
    protected Builder( PartiallyDeprecatedServiceObject pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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
    public static Builder newBuilder( PartiallyDeprecatedServiceObject pObject ) {
      return new Builder(pObject);
    }
  }

  /**
  * 
  */
  @Deprecated
  @Override
  public void doSomethingDeprecated( ) {
    // TODO: Implement business logic for method.
  }

  /**
   * 
   * @param pParam1
   * @param pParam2
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String doSomething( int pParam1, @Deprecated int pParam2 ) {
    // TODO: Implement business logic for method.
    return null;
  }
}