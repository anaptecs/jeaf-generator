/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
@JsonIdentityInfo(property = "objectID", generator = PropertyGenerator.class)
public class Reseller extends ResellerBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Reseller objects. The method never returns null.
   */
  public static Builder builder( Reseller pObject ) {
    return new Builder(pObject);
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
   * 
   * @return {@link Integer}
   */
  @Override
  public Integer doSomething( ) {
    // TODO: Implement business logic for method.
    return null;
  }

  /**
   * 
   * @return {@link double}
   */
  @Override
  public double returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}