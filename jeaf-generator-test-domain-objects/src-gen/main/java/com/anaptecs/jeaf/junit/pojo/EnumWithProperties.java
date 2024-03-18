package com.anaptecs.jeaf.junit.pojo;

public enum EnumWithProperties {
  CAMPAIGN_DATA_UNIT("AX2", "Campaign Data Unit", 4712, MyType.ALPHA), RELATION_KEY_DATA_UNIT("X56",
      "Relation Key Data Unit", 12345, null), LITERAL_WITH_DEFAULTS("ABC", "ABCDEF", 1208, MyType.GAMMA);

  /**
   * Initialize object.
   */
  private EnumWithProperties( String pDataUnitID, String pName, int pOrder, MyType pMyType ) {
    dataUnitID = pDataUnitID;
    name = pName;
    order = pOrder;
    myType = pMyType;
  }

  private final String dataUnitID;

  private final String name;

  /**
   * <br/>
   * <b>Default Value:</b> <code>1208</code>
   */
  private final int order;

  /**
   * <br/>
   * <b>Default Value:</b> <code>GAMMA</code>
   */
  private MyType myType;

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

  /**
   * Method returns association {@link #myType}.<br/>
   *
   * @return {@link MyType} Value to which {@link #myType} is set.
   */
  public MyType getMyType( ) {
    return myType;
  }
}