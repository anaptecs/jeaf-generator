/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

public class Channel extends ChannelBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Channel( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Channel( Channel.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Channel objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Channel objects. The method never returns null.
   */
  public static Builder builder( Channel pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Channel. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Channel.BuilderBase {
    /**
     * Use {@link Channel#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Channel#builder(Channel)} instead of protected constructor to create new builder.
     */
    protected Builder( Channel pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedSomething}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedSomething} is set.
   */
  public String getDerivedSomething( ) {
    // TODO Implement method for derived property "derivedSomething".
    return null;
  }
}