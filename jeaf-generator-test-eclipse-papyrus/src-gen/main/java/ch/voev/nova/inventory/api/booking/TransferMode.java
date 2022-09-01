package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Modes dedicated to perform transfers. Provided by OJP.
 */
public final class TransferMode {
  public static enum TransferModeType {
    /**
     * 
     */
    WALK,
    /**
     * 
     */
    PARK_AND_RIDE,
    /**
     * 
     */
    BIKE_AND_RIDE,
    /**
     * 
     */
    CAR_HIRE,
    /**
     * 
     */
    BIKE_HIRE,
    /**
     * 
     */
    PROTECTED_CONNECTION,
    /**
     * 
     */
    GUARANTEED_CONNECTION,
    /**
     * 
     */
    REMAIN_IN_VEHICLE,
    /**
     * 
     */
    CHANGE_WITHIN_VEHICLE,
    /**
     * 
     */
    CHECK_IN,
    /**
     * 
     */
    CHECK_OUT,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final TransferMode WALK = new TransferMode(TransferModeType.WALK);

  /**
   * 
   */
  public static final TransferMode PARK_AND_RIDE = new TransferMode(TransferModeType.PARK_AND_RIDE);

  /**
   * 
   */
  public static final TransferMode BIKE_AND_RIDE = new TransferMode(TransferModeType.BIKE_AND_RIDE);

  /**
   * 
   */
  public static final TransferMode CAR_HIRE = new TransferMode(TransferModeType.CAR_HIRE);

  /**
   * 
   */
  public static final TransferMode BIKE_HIRE = new TransferMode(TransferModeType.BIKE_HIRE);

  /**
   * 
   */
  public static final TransferMode PROTECTED_CONNECTION = new TransferMode(TransferModeType.PROTECTED_CONNECTION);

  /**
   * 
   */
  public static final TransferMode GUARANTEED_CONNECTION = new TransferMode(TransferModeType.GUARANTEED_CONNECTION);

  /**
   * 
   */
  public static final TransferMode REMAIN_IN_VEHICLE = new TransferMode(TransferModeType.REMAIN_IN_VEHICLE);

  /**
   * 
   */
  public static final TransferMode CHANGE_WITHIN_VEHICLE = new TransferMode(TransferModeType.CHANGE_WITHIN_VEHICLE);

  /**
   * 
   */
  public static final TransferMode CHECK_IN = new TransferMode(TransferModeType.CHECK_IN);

  /**
   * 
   */
  public static final TransferMode CHECK_OUT = new TransferMode(TransferModeType.CHECK_OUT);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private TransferModeType literal;

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
  public static TransferMode valueOf( String pLiteralName ) {
    TransferMode lEnum;
    try {
      TransferModeType lEnumValue = Enum.valueOf(TransferModeType.class, pLiteralName);
      switch (lEnumValue) {
        case WALK:
          lEnum = WALK;
          break;
        case PARK_AND_RIDE:
          lEnum = PARK_AND_RIDE;
          break;
        case BIKE_AND_RIDE:
          lEnum = BIKE_AND_RIDE;
          break;
        case CAR_HIRE:
          lEnum = CAR_HIRE;
          break;
        case BIKE_HIRE:
          lEnum = BIKE_HIRE;
          break;
        case PROTECTED_CONNECTION:
          lEnum = PROTECTED_CONNECTION;
          break;
        case GUARANTEED_CONNECTION:
          lEnum = GUARANTEED_CONNECTION;
          break;
        case REMAIN_IN_VEHICLE:
          lEnum = REMAIN_IN_VEHICLE;
          break;
        case CHANGE_WITHIN_VEHICLE:
          lEnum = CHANGE_WITHIN_VEHICLE;
          break;
        case CHECK_IN:
          lEnum = CHECK_IN;
          break;
        case CHECK_OUT:
          lEnum = CHECK_OUT;
          break;
        default:
          lEnum = new TransferMode(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new TransferMode(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public TransferMode( TransferModeType pLiteral ) {
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
   * @see TransferMode#isUnknownLiteral()
   */
  public TransferMode( String pLiteralName ) {
    try {
      literal = Enum.valueOf(TransferModeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = TransferModeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link TransferMode} Literal that is represented by this object. The method never returns null.
   */
  public TransferModeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == TransferModeType.UNKNOWN;
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
        TransferMode lEnum = (TransferMode) pObject;
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