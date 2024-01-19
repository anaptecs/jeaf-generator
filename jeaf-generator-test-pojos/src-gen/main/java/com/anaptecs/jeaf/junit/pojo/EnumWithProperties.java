package com.anaptecs.jeaf.junit.pojo;

public enum EnumWithProperties {
  CAMPAIGN_DATA_UNIT("AX2", "Campaign Data Unit", 4711), RELATION_KEY_DATA_UNIT("X56", "Relation Key Data Unit", 12345);

  /**
   * Initialize object.
   */
  private EnumWithProperties( String pDataUnitID, String pName, int pOrder ) {
    dataUnitID = pDataUnitID;
    name = pName;
    order = pOrder;
  }

  private final String dataUnitID;

  private final String name;

  private final int order;

  /**
   * Method returns attribute {@link #dataUnitID}.<br/>
   *
   * @return {@link String} Value to which {@link #dataUnitID} is set.
   */
  public String getDataUnitID( ) {
    return dataUnitID;
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns attribute {@link #order}.<br/>
   *
   * @return int Value to which {@link #order} is set.
   */
  public int getOrder( ) {
    return order;
  }
}