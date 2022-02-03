/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class AccountInfo extends AccountInfoBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected AccountInfo( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected AccountInfo( AccountInfo.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class AccountInfo. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AccountInfo.BuilderBase {
    /**
     * Use {@link #newBuilder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(AccountInfo)} instead of protected constructor to create new builder.
     */
    protected Builder( AccountInfo pObject ) {
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
    public static Builder newBuilder( AccountInfo pObject ) {
      return new Builder(pObject);
    }
  }

  /**
   * 
   * @return {@link Double}
   */
  @Override
  public Double calclulateBalance( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}