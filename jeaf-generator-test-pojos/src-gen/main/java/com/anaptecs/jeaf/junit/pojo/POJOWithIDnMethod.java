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
public class POJOWithIDnMethod extends POJOWithIDnMethodBase {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects. The method never
   * returns null.
   */
  public static Builder builder( POJOWithIDnMethod pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( Double pAttr ) {
    Builder lBuilder = builder();
    lBuilder.setAttr(pAttr);
    return lBuilder;
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
   * 
   * @return {@link Boolean}
   */
  @Override
  public boolean doSomethingFunny( ) {
    // TODO: Implement business logic for method.
    return false;
  }
}