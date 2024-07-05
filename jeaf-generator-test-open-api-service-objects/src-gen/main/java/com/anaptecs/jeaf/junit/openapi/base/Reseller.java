/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Valid
@JsonIdentityInfo(property = "objectID", generator = PropertyGenerator.class)
public class Reseller extends ResellerBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Reseller( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Reseller( Reseller.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Reseller objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class Reseller. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Reseller.BuilderBase {
    /**
     * Use {@link Reseller#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Reseller#builder(Reseller)} instead of protected constructor to create new builder.
     */
    protected Builder( Reseller pObject ) {
      super(pObject);
    }
  }

  /**
   * @return {@link Integer}
   */
  @MyNotNullProperty
  @Override
  public Integer doSomething( ) {
    // TODO: Implement business logic for method.
    return null;
  }

  /**
   * @return double
   */
  @Override
  public double returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}
