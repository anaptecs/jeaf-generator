package com.anaptecs.spring.base;

public final class DataUnit {
  public static enum DataUnitType {
    COUPON("CMP"), UNKNOWN("N/A");

    /**
     * Empty constructor is required for UNKNWON literal.
     */
    private DataUnitType( ) {
      dataUnitID = null;
    }

    /**
     * Initialize object.
     */
    private DataUnitType( String pDataUnitID ) {
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

  public static final DataUnit COUPON = new DataUnit(DataUnitType.COUPON);

  public static final DataUnit UNKNOWN = new DataUnit(DataUnitType.UNKNOWN);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private DataUnitType literal;

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
  public static DataUnit valueOf( String pLiteralName ) {
    DataUnit lEnum;
    try {
      DataUnitType lEnumValue = Enum.valueOf(DataUnitType.class, pLiteralName);
      switch (lEnumValue) {
        case COUPON:
          lEnum = COUPON;
          break;
        case UNKNOWN:
          lEnum = UNKNOWN;
          break;
        default:
          lEnum = new DataUnit(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new DataUnit(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation available constructors {@link #DataUnit(DataUnitType)} and {@link #DataUnit(String)} should be
   * used.
   */
  DataUnit( ) {
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public DataUnit( DataUnitType pLiteral ) {
    literal = pLiteral;
    unknownLiteralName = null;
  }

  /**
   * Initialize object using the name of the literal.
   * 
   * @param pLiteralName Literal name that should be used to initialize the extensible enumeration. If the parameter is
   * null or has an unknown literal name then a "unknown" version will be created.
   * 
   * @see DataUnit#isUnknownLiteral()
   */
  public DataUnit( String pLiteralName ) {
    try {
      literal = Enum.valueOf(DataUnitType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = DataUnitType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link DataUnit} Literal that is represented by this object. The method never returns null.
   */
  public DataUnitType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == DataUnitType.UNKNOWN;
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
    if (unknownLiteralName != null && this.isUnknownLiteral() == true) {
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
        DataUnit lEnum = (DataUnit) pObject;
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