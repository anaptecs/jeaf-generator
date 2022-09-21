/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PlainPOJO extends PlainPOJOBase {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PlainPOJO( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected PlainPOJO( PlainPOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class PlainPOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlainPOJO.BuilderBase {
    /**
     * Use {@link #newBuilder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PlainPOJO)} instead of protected constructor to create new builder.
     */
    protected Builder( PlainPOJO pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new PlainPOJO objects.
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
    public static Builder newBuilder( PlainPOJO pObject ) {
      return new Builder(pObject);
    }
  }

  /**
  * 
  */
  @Deprecated
  @Override
  public void doDeprectedStuff( ) {
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
  public String doSomething( @Deprecated int pParam1, int pParam2 ) {
    // TODO: Implement business logic for method.
    return null;
  }
}