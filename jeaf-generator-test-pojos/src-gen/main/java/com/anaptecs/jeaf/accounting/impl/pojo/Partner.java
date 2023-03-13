/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

public abstract class Partner extends PartnerBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Partner( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Partner( Partner.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class Partner. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Partner.BuilderBase {
    /**
     * Use {@link Partner#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Partner#builder(Partner)} instead of protected constructor to create new builder.
     */
    protected Builder( Partner pObject ) {
      super(pObject);
    }
  }
}