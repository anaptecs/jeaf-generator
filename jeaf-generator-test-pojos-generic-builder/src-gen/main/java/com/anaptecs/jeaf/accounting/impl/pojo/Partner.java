/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public abstract class Partner extends PartnerBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Partner( PartnerBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class <code>Partner</code>.
   *
   * This class is intended to contain additional custom implementations inside the builder.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class PartnerBuilder<T extends Partner, S extends PartnerBuilder<T, S>>
      extends PartnerBuilderBase<T, S> {
    /**
     * Use {@link PartnerBuilder#builder()} instead of private constructor to create new builder.
     */
    protected PartnerBuilder( ) {
      super();
    }

    /**
     * Use {@link PartnerBuilder#builder(Partner)} instead of private constructor to create new builder.
     */
    protected PartnerBuilder( Partner pObject ) {
      super(pObject);
    }
    // TODO: Add your custom builder operations here.
  }
}