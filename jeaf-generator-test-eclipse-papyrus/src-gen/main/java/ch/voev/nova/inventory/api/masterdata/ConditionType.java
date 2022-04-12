package ch.voev.nova.inventory.api.masterdata;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public final class ConditionType {
  public static enum ConditionTypeType {
    /**
     * 
     */
    SALE,
    /**
     * 
     */
    PLACE_CHANGE,
    /**
     * 
     */
    FULFILLMENT,
    /**
     * 
     */
    EXCHANGE,
    /**
     * 
     */
    REFUND,
    /**
     * 
     */
    TRAVEL,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final ConditionType SALE = new ConditionType(ConditionTypeType.SALE);

  /**
   * 
   */
  public static final ConditionType PLACE_CHANGE = new ConditionType(ConditionTypeType.PLACE_CHANGE);

  /**
   * 
   */
  public static final ConditionType FULFILLMENT = new ConditionType(ConditionTypeType.FULFILLMENT);

  /**
   * 
   */
  public static final ConditionType EXCHANGE = new ConditionType(ConditionTypeType.EXCHANGE);

  /**
   * 
   */
  public static final ConditionType REFUND = new ConditionType(ConditionTypeType.REFUND);

  /**
   * 
   */
  public static final ConditionType TRAVEL = new ConditionType(ConditionTypeType.TRAVEL);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private ConditionTypeType literal;

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
  public static ConditionType valueOf( String pLiteralName ) {
    ConditionType lEnum;
    try {
      ConditionTypeType lEnumValue = Enum.valueOf(ConditionTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case SALE:
          lEnum = SALE;
          break;
        case PLACE_CHANGE:
          lEnum = PLACE_CHANGE;
          break;
        case FULFILLMENT:
          lEnum = FULFILLMENT;
          break;
        case EXCHANGE:
          lEnum = EXCHANGE;
          break;
        case REFUND:
          lEnum = REFUND;
          break;
        case TRAVEL:
          lEnum = TRAVEL;
          break;
        default:
          lEnum = new ConditionType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new ConditionType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public ConditionType( ConditionTypeType pLiteral ) {
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
   * @see ConditionType#isUnknownLiteral()
   */
  public ConditionType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(ConditionTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = ConditionTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link ConditionType} Literal that is represented by this object. The method never returns null.
   */
  public ConditionTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == ConditionTypeType.UNKNOWN;
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
        ConditionType lEnum = (ConditionType) pObject;
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
}