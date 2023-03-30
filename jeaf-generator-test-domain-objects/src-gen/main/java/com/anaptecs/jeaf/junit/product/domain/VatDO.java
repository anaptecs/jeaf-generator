/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.product.domain;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;

public class VatDO extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "rate".
   */
  public static final String RATE = "rate";

  private double rate;

  /**
   * Initialize object. Nothing special to do.
   */
  public VatDO( ) {
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public VatDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * Method returns attribute {@link #rate}.<br/>
   *
   * @return double Value to which {@link #rate} is set.
   */
  public double getRate( ) {
    return rate;
  }

  /**
   * Method sets attribute {@link #rate}.<br/>
   *
   * @param pRate Value to which {@link #rate} should be set.
   */
  public void setRate( double pRate ) {
    // Assign value to attribute
    rate = pRate;
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
    lBuilder.append("rate: ");
    lBuilder.append(rate);
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
}
