/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

/**
 * This is a service object that was modeled in order to test the output of the JEAF Generator.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TestServiceObject extends TestServiceObjectBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TestServiceObject( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected TestServiceObject( TestServiceObject.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TestServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class TestServiceObject. As the class has readonly attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends TestServiceObject.BuilderBase {
    /**
     * Use {@link TestServiceObject#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TestServiceObject#builder(TestServiceObject)} instead of protected constructor to create new builder.
     */
    protected Builder( TestServiceObject pObject ) {
      super(pObject);
    }
  }
}