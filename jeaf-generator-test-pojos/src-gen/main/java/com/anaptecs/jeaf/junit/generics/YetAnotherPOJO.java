/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

public class YetAnotherPOJO extends YetAnotherPOJOBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected YetAnotherPOJO( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected YetAnotherPOJO( YetAnotherPOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new YetAnotherPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new YetAnotherPOJO objects. The method never returns
   * null.
   */
  public static Builder builder( YetAnotherPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class YetAnotherPOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends YetAnotherPOJO.BuilderBase {
    /**
     * Use {@link YetAnotherPOJO#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link YetAnotherPOJO#builder(YetAnotherPOJO)} instead of protected constructor to create new builder.
     */
    protected Builder( YetAnotherPOJO pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link GenericResponsePOJO<MyBusinessObject>}
   */
  @Override
  public GenericResponsePOJO<MyBusinessObject> getResponse( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}