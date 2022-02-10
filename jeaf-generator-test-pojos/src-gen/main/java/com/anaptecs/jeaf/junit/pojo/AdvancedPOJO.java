/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.validation.Valid;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Valid()
public class AdvancedPOJO extends AdvancedPOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AdvancedPOJO( AdvancedPOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class AdvancedPOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AdvancedPOJO.BuilderBase {
    /**
     * Use {@link #newBuilder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(AdvancedPOJO)} instead of protected constructor to create new builder.
     */
    protected Builder( AdvancedPOJO pObject ) {
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
    public static Builder newBuilder( AdvancedPOJO pObject ) {
      return new Builder(pObject);
    }
  }

  /**
   * 
   * @param pName
   * @return {@link Boolean}
   */
  @Override
  public boolean doSomething( String pName ) {
    // TODO: Implement business logic for method.
    return false;
  }

  /**
   * 
   * @return {@link int}
   */
  @Override
  public int returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}