/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public enum DataUnit {
  COUPON("CMP"), UNKNOWN("N/A");

  /**
   * Initialize object.
   */
  private DataUnit( String pDataUnitID ) {
    dataUnitID = pDataUnitID;
  }

  private final String dataUnitID;

  /**
   * Method returns attribute {@link #dataUnitID}.<br/>
   *
   * @return {@link String} Value to which {@link #dataUnitID} is set.
   */
  public String getDataUnitID( ) {
    return dataUnitID;
  }
}