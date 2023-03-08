package com.anaptecs.jeaf.junit.pojo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private final String dataUnitID;

  /**
   * 
   */
  private final String name;

  /**
   * 
   */
  private final int order;

  /**
   * Method returns the attribute "dataUnitID".
   * 
   * 
   * @return String Value to which the attribute "dataUnitID" is set.
   */
  public String getDataUnitID( ) {
    return dataUnitID;
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns the attribute "order".
   * 
   * 
   * @return int Value to which the attribute "order" is set.
   */
  public int getOrder( ) {
    return order;
  }
}