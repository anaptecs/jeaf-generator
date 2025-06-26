/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public abstract class MySortCriteriaBase {
  /**
   * Constant for the name of attribute "sortOrder".
   */
  public static final String SORTORDER = "sortOrder";

  /**
   * Constant for the name of attribute "sortProperty".
   */
  public static final String SORTPROPERTY = "sortProperty";

  private SortOrder sortOrder;

  private MySortProperty sortProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MySortCriteriaBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    sortOrder = pBuilder.sortOrder;
    sortProperty = pBuilder.sortProperty;
  }

  /**
   * Class implements builder to create a new instance of class MySortCriteria. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private SortOrder sortOrder;

    private MySortProperty sortProperty;

    /**
     * Use {@link MySortCriteria.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link MySortCriteria.builder(MySortCriteria)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( MySortCriteriaBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSortOrder(pObject.sortOrder);
        this.setSortProperty(pObject.sortProperty);
      }
    }

    /**
     * Method sets association {@link #sortOrder}.<br/>
     *
     * @param pSortOrder Value to which {@link #sortOrder} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSortOrder( SortOrder pSortOrder ) {
      sortOrder = pSortOrder;
      return this;
    }

    /**
     * Method sets association {@link #sortProperty}.<br/>
     *
     * @param pSortProperty Value to which {@link #sortProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSortProperty( MySortProperty pSortProperty ) {
      sortProperty = pSortProperty;
      return this;
    }

    /**
     * Method creates a new instance of class MySortCriteria. The object will be initialized with the values of the
     * builder.
     *
     * @return MySortCriteria Created object. The method never returns null.
     */
    public MySortCriteria build( ) {
      return new MySortCriteria(this);
    }
  }

  /**
   * Method returns association {@link #sortOrder}.<br/>
   *
   * @return {@link SortOrder} Value to which {@link #sortOrder} is set.
   */
  public SortOrder getSortOrder( ) {
    return sortOrder;
  }

  /**
   * Method sets association {@link #sortOrder}.<br/>
   *
   * @param pSortOrder Value to which {@link #sortOrder} should be set.
   */
  public void setSortOrder( SortOrder pSortOrder ) {
    sortOrder = pSortOrder;
  }

  /**
   * Method unsets {@link #sortOrder}.
   */
  public final void unsetSortOrder( ) {
    sortOrder = null;
  }

  /**
   * Method returns association {@link #sortProperty}.<br/>
   *
   * @return {@link MySortProperty} Value to which {@link #sortProperty} is set.
   */
  public MySortProperty getSortProperty( ) {
    return sortProperty;
  }

  /**
   * Method sets association {@link #sortProperty}.<br/>
   *
   * @param pSortProperty Value to which {@link #sortProperty} should be set.
   */
  public void setSortProperty( MySortProperty pSortProperty ) {
    sortProperty = pSortProperty;
  }

  /**
   * Method unsets {@link #sortProperty}.
   */
  public final void unsetSortProperty( ) {
    sortProperty = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sortOrder: ");
    lBuilder.append(sortOrder);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sortProperty: ");
    lBuilder.append(sortProperty);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new MySortCriteria objects. The method never returns
   * null.
   */
  public MySortCriteria.Builder toBuilder( ) {
    return new MySortCriteria.Builder((MySortCriteria) this);
  }
}