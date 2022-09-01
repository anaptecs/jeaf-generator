package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public final class FulfillmentType {
  public static enum FulfillmentTypeType {
    /**
     * 
     */
    ETICKET,
    /**
     * 
     */
    CIT_PAPER,
    /**
     * 
     */
    PASS_CHIP,
    /**
     * 
     */
    PASS_REFERENCE,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final FulfillmentType ETICKET = new FulfillmentType(FulfillmentTypeType.ETICKET);

  /**
   * 
   */
  public static final FulfillmentType CIT_PAPER = new FulfillmentType(FulfillmentTypeType.CIT_PAPER);

  /**
   * 
   */
  public static final FulfillmentType PASS_CHIP = new FulfillmentType(FulfillmentTypeType.PASS_CHIP);

  /**
   * 
   */
  public static final FulfillmentType PASS_REFERENCE = new FulfillmentType(FulfillmentTypeType.PASS_REFERENCE);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private FulfillmentTypeType literal;

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
  public static FulfillmentType valueOf( String pLiteralName ) {
    FulfillmentType lEnum;
    try {
      FulfillmentTypeType lEnumValue = Enum.valueOf(FulfillmentTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case ETICKET:
          lEnum = ETICKET;
          break;
        case CIT_PAPER:
          lEnum = CIT_PAPER;
          break;
        case PASS_CHIP:
          lEnum = PASS_CHIP;
          break;
        case PASS_REFERENCE:
          lEnum = PASS_REFERENCE;
          break;
        default:
          lEnum = new FulfillmentType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new FulfillmentType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public FulfillmentType( FulfillmentTypeType pLiteral ) {
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
   * @see FulfillmentType#isUnknownLiteral()
   */
  public FulfillmentType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(FulfillmentTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = FulfillmentTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link FulfillmentType} Literal that is represented by this object. The method never returns null.
   */
  public FulfillmentTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == FulfillmentTypeType.UNKNOWN;
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
        FulfillmentType lEnum = (FulfillmentType) pObject;
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