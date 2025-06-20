/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.annotation.processing.Generated;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class ClassA extends ClassABase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ClassA( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected ClassA( ClassA.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ClassA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class ClassA. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ClassA.BuilderBase {
    /**
     * Use {@link ClassA#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ClassA#builder(ClassA)} instead of protected constructor to create new builder.
     */
    protected Builder( ClassA pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link Double}
   */
  @JEAFCustomAnnotationTest
  @Override
  public Double calculate( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}