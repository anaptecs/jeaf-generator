/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OtherPojo extends OtherPojoBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected OtherPojo( OtherPojo.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new OtherPojo objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class OtherPojo. As the class has read-only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends OtherPojo.BuilderBase {
    /**
     * Use {@link OtherPojo#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link OtherPojo#builder(OtherPojo)} instead of protected constructor to create new builder.
     */
    protected Builder( OtherPojo pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedString}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedString} is set.
   */
  @Override
  public @Size(min = 1, max = 111) @NotNull String getDerivedString( ) {
    // TODO Implement method for derived property "derivedString".
    return null;
  }

  /**
   * Method returns attribute {@link #derivedList}.<br/>
   *
   * @return {@link String[]} Value to which {@link #derivedList} is set.
   */
  @Override
  public @Size(min = 7, max = 42) String[] getDerivedList( ) {
    // TODO Implement method for derived property "derivedList".
    return null;
  }
}