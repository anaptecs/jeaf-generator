/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class CompositeID extends CompositeIDBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CompositeID( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected CompositeID( CompositeID.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CompositeID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class CompositeID. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends CompositeID.BuilderBase {
    /**
     * Use {@link CompositeID#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CompositeID#builder(CompositeID)} instead of protected constructor to create new builder.
     */
    protected Builder( CompositeID pObject ) {
      super(pObject);
    }
  }

  /**
   * Method serializes this object into its custom string representation.
   *
   * @return {@link String} Serialized String representation of this object. The method must not return null.
   */
  public String serialize( ) {
    // TODO Implementation required
    return null;
  }

  /**
   * Method deserialized the passed String representation of this object into a new instance of this class.
   *
   * @param pSerialized Serialized representation that should be used to create a new instance. The parameter is never
   * null.
   * @return {@link CompositeID} Instance of this class as it was deserialized from the passed string. The method must
   * not return null.
   */
  public static CompositeID deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}