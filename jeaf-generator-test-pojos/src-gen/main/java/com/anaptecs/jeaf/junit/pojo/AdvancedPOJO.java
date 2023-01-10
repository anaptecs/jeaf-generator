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
@Valid
public class AdvancedPOJO extends AdvancedPOJOBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AdvancedPOJO( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected AdvancedPOJO( AdvancedPOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new AdvancedPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new AdvancedPOJO objects. The method never returns
   * null.
   */
  public static Builder builder( AdvancedPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class AdvancedPOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AdvancedPOJO.BuilderBase {
    /**
     * Use {@link AdvancedPOJO#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AdvancedPOJO#builder(AdvancedPOJO)} instead of protected constructor to create new builder.
     */
    protected Builder( AdvancedPOJO pObject ) {
      super(pObject);
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