package ch.voev.nova.inventory.api.masterdata;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Fulfillment types. RCT2, RCCST and UIC-PDF are official UIC standards.
 */
public final class FulfillmentMediaType {
  public static enum FulfillmentMediaTypeType {
    /**
     * 
     */
    RCT2,
    /**
     * 
     */
    RCCST,
    /**
     * 
     */
    UIC_PDF,
    /**
     * 
     */
    PDF_A4,
    /**
     * 
     */
    PKPASS,
    /**
     * 
     */
    TICKETLESS,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final FulfillmentMediaType RCT2 = new FulfillmentMediaType(FulfillmentMediaTypeType.RCT2);

  /**
   * 
   */
  public static final FulfillmentMediaType RCCST = new FulfillmentMediaType(FulfillmentMediaTypeType.RCCST);

  /**
   * 
   */
  public static final FulfillmentMediaType UIC_PDF = new FulfillmentMediaType(FulfillmentMediaTypeType.UIC_PDF);

  /**
   * 
   */
  public static final FulfillmentMediaType PDF_A4 = new FulfillmentMediaType(FulfillmentMediaTypeType.PDF_A4);

  /**
   * 
   */
  public static final FulfillmentMediaType PKPASS = new FulfillmentMediaType(FulfillmentMediaTypeType.PKPASS);

  /**
   * 
   */
  public static final FulfillmentMediaType TICKETLESS = new FulfillmentMediaType(FulfillmentMediaTypeType.TICKETLESS);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private FulfillmentMediaTypeType literal;

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
  public static FulfillmentMediaType valueOf( String pLiteralName ) {
    FulfillmentMediaType lEnum;
    try {
      FulfillmentMediaTypeType lEnumValue = Enum.valueOf(FulfillmentMediaTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case RCT2:
          lEnum = RCT2;
          break;
        case RCCST:
          lEnum = RCCST;
          break;
        case UIC_PDF:
          lEnum = UIC_PDF;
          break;
        case PDF_A4:
          lEnum = PDF_A4;
          break;
        case PKPASS:
          lEnum = PKPASS;
          break;
        case TICKETLESS:
          lEnum = TICKETLESS;
          break;
        default:
          lEnum = new FulfillmentMediaType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new FulfillmentMediaType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public FulfillmentMediaType( FulfillmentMediaTypeType pLiteral ) {
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
   * @see FulfillmentMediaType#isUnknownLiteral()
   */
  public FulfillmentMediaType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(FulfillmentMediaTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = FulfillmentMediaTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link FulfillmentMediaType} Literal that is represented by this object. The method never returns null.
   */
  public FulfillmentMediaTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == FulfillmentMediaTypeType.UNKNOWN;
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
        FulfillmentMediaType lEnum = (FulfillmentMediaType) pObject;
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