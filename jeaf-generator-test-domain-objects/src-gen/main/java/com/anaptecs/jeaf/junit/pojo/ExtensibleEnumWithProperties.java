package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.xfun.api.checks.Check;

public final class ExtensibleEnumWithProperties {
  public static enum ExtensibleEnumWithPropertiesType {
    CAMPAIGN_DATA_UNIT("AX2", "Campaign Data Unit", 4711, 1234567890, true, -0.1f, 1.234), RELATION_KEY_DATA_UNIT("X56",
        "Relation Key Data Unit", 12345, 1, false, 1.0E-4f, 0.1),
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;

    /**
     * Empty constructor is required for UNKNWON literal.
     */
    private ExtensibleEnumWithPropertiesType( ) {
      dataUnitID = null;
      name = null;
      order = -1;
      longProperty = -1;
      booleanProperty = false;
      floatProperty = -1;
      doubleProperty = -1;
    }

    /**
     * Initialize object.
     */
    private ExtensibleEnumWithPropertiesType( String pDataUnitID, String pName, int pOrder, long pLongProperty,
        boolean pBooleanProperty, float pFloatProperty, double pDoubleProperty ) {
      dataUnitID = pDataUnitID;
      name = pName;
      order = pOrder;
      longProperty = pLongProperty;
      booleanProperty = pBooleanProperty;
      floatProperty = pFloatProperty;
      doubleProperty = pDoubleProperty;
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
     * 
     */
    private final long longProperty;

    /**
     * 
     */
    private final boolean booleanProperty;

    /**
     * 
     */
    private final float floatProperty;

    /**
     * 
     */
    private final double doubleProperty;

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

    /**
     * Method returns the attribute "longProperty".
     * 
     * 
     * @return long Value to which the attribute "longProperty" is set.
     */
    public long getLongProperty( ) {
      return longProperty;
    }

    /**
     * Method returns the attribute "booleanProperty".
     * 
     * 
     * @return Boolean Value to which the attribute "booleanProperty" is set.
     */
    public boolean getBooleanProperty( ) {
      return booleanProperty;
    }

    /**
     * Method returns the attribute "floatProperty".
     * 
     * 
     * @return float Value to which the attribute "floatProperty" is set.
     */
    public float getFloatProperty( ) {
      return floatProperty;
    }

    /**
     * Method returns the attribute "doubleProperty".
     * 
     * 
     * @return double Value to which the attribute "doubleProperty" is set.
     */
    public double getDoubleProperty( ) {
      return doubleProperty;
    }
  }

  public static final ExtensibleEnumWithProperties CAMPAIGN_DATA_UNIT =
      new ExtensibleEnumWithProperties(ExtensibleEnumWithPropertiesType.CAMPAIGN_DATA_UNIT);

  public static final ExtensibleEnumWithProperties RELATION_KEY_DATA_UNIT =
      new ExtensibleEnumWithProperties(ExtensibleEnumWithPropertiesType.RELATION_KEY_DATA_UNIT);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private ExtensibleEnumWithPropertiesType literal;

  /**
   * In case that the literal is unknown then also it's actual name is still available as
   * <code>unknownLiteralName</code>
   */
  private String unknownLiteralName;

  /**
   * Method returns extensible enumeration based on the passed name. If the literal name is unknown then an instance
   * representing "unknown" will be returned.
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   * @return
   */
  public static ExtensibleEnumWithProperties valueOf( String pLiteralName ) {
    ExtensibleEnumWithProperties lEnum;
    try {
      ExtensibleEnumWithPropertiesType lEnumValue = Enum.valueOf(ExtensibleEnumWithPropertiesType.class, pLiteralName);
      switch (lEnumValue) {
        case CAMPAIGN_DATA_UNIT:
          lEnum = CAMPAIGN_DATA_UNIT;
          break;
        case RELATION_KEY_DATA_UNIT:
          lEnum = RELATION_KEY_DATA_UNIT;
          break;
        default:
          lEnum = new ExtensibleEnumWithProperties(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new ExtensibleEnumWithProperties(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation available constructors {@link #ExtensibleEnumWithProperties(ExtensibleEnumWithPropertiesType)} and
   * {@link #ExtensibleEnumWithProperties(String)} should be used.
   */
  ExtensibleEnumWithProperties( ) {
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public ExtensibleEnumWithProperties( ExtensibleEnumWithPropertiesType pLiteral ) {
    Check.checkInvalidParameterNull(pLiteral, "pLiteral");
    literal = pLiteral;
    unknownLiteralName = null;
  }

  /**
   * Initialize object using the name of the literal.
   * 
   * @param pLiteralName Literal name that should be used to initialize the extensible enumeration. If the parameter is
   * null or has an unknown literal name then a "unknown" version will be created.
   * 
   * @see ExtensibleEnumWithProperties#isUnknownLiteral()
   */
  public ExtensibleEnumWithProperties( String pLiteralName ) {
    try {
      literal = Enum.valueOf(ExtensibleEnumWithPropertiesType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = ExtensibleEnumWithPropertiesType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link ExtensibleEnumWithProperties} Literal that is represented by this object. The method never returns
   * null.
   */
  public ExtensibleEnumWithPropertiesType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == ExtensibleEnumWithPropertiesType.UNKNOWN;
  }

  /**
   * Method returns the actual name of the unknown literal
   * 
   * @return {@link String} Name of the unknown literal or null in case that the literal is known.
   */
  public String getUnknownLiteralName( ) {
    return unknownLiteralName;
  }

  /**
   * {@link Object#hashCode()}
   */
  @Override
  public int hashCode( ) {
    int lHashCode;
    if (this.isUnknownLiteral() == true) {
      lHashCode = unknownLiteralName.hashCode();
    }
    else {
      lHashCode = literal.hashCode();
    }
    return lHashCode;
  }

  /**
   * {@link Object#equals(Object)}
   */
  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (pObject != null) {
      if (this == pObject) {
        lEquals = true;
      }
      // Passed object is of same type
      else if (this.getClass() == pObject.getClass()) {
        ExtensibleEnumWithProperties lEnum = (ExtensibleEnumWithProperties) pObject;
        // Compare if unknown literal is the same
        if (this.isUnknownLiteral() && lEnum.isUnknownLiteral()) {
          if (this.unknownLiteralName != null) {
            lEquals = this.unknownLiteralName.equals(lEnum.unknownLiteralName);
          }
          else if (lEnum.unknownLiteralName == null) {
            lEquals = true;
          }
          else {
            lEquals = false;
          }
        }
        // Compare based on literals
        else {
          lEquals = this.literal == lEnum.literal;
        }
      }
      // Passed object is of different type
      else {
        lEquals = false;
      }
    }
    // Passed object is null.
    else {
      lEquals = false;
    }
    return lEquals;
  }

  /**
   * {@link Object#toString()}
   */
  @Override
  public String toString( ) {
    String lLiteralName;
    if (this.isUnknownLiteral() == false) {
      lLiteralName = this.getLiteral().name();
    }
    // Object represents unknown literal.
    else {
      String lUnknownLiteralName = this.getUnknownLiteralName();
      if (lUnknownLiteralName != null) {
        lLiteralName = lUnknownLiteralName;
      }
      else {
        lLiteralName = this.getLiteral().name();
      }
    }
    return lLiteralName;
  }
}