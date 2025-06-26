/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

public class AndOneMorePOJO extends AndOneMorePOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AndOneMorePOJO( AndOneMorePOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class AndOneMorePOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AndOneMorePOJO.BuilderBase {
    /**
     * Use {@link AndOneMorePOJO#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AndOneMorePOJO#builder(AndOneMorePOJO)} instead of protected constructor to create new builder.
     */
    protected Builder( AndOneMorePOJO pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link GenericResponsePOJO<TemplateEnumTest>}
   */
  @Override
  public GenericResponsePOJO<TemplateEnumTest> getEnumTemplate( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}