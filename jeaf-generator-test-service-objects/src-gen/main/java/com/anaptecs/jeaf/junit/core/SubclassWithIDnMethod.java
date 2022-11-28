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
public class SubclassWithIDnMethod extends SubclassWithIDnMethodBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SubclassWithIDnMethod( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected SubclassWithIDnMethod( SubclassWithIDnMethod.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SubclassWithIDnMethod objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SubclassWithIDnMethod objects. The method never
   * returns null.
   */
  public static Builder builder( SubclassWithIDnMethod pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( Integer pHello, Boolean pAttr ) {
    Builder lBuilder = builder();
    lBuilder.setHello(pHello);
    lBuilder.setAttr(pAttr);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class SubclassWithIDnMethod. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends SubclassWithIDnMethod.BuilderBase {
    /**
     * Use {@link SubclassWithIDnMethod#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SubclassWithIDnMethod#builder(SubclassWithIDnMethod)} instead of protected constructor to create new
     * builder.
     */
    protected Builder( SubclassWithIDnMethod pObject ) {
      super(pObject);
    }
  }

  /**
  * 
  */
  @Override
  public void doMore( ) {
    // TODO: Implement business logic for method.
  }
}