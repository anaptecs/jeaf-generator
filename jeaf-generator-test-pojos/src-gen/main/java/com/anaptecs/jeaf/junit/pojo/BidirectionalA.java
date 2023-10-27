/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class BidirectionalA extends BidirectionalABase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectionalA( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected BidirectionalA( BidirectionalA.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BidirectionalA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BidirectionalA objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( BidirectionalA pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class BidirectionalA. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends BidirectionalA.BuilderBase {
    /**
     * Use {@link BidirectionalA#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BidirectionalA#builder(BidirectionalA)} instead of protected constructor to create new builder.
     */
    protected Builder( BidirectionalA pObject ) {
      super(pObject);
    }
  }
}