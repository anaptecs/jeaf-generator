package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * scope where the VAT applies
 */
public final class VatScope {
  public static enum VatScopeType {
    /**
     * 
     */
    INTERNATIONAL,
    /**
     * 
     */
    NATIONAL,
    /**
     * 
     */
    SHORT_DISTANCE,
    /**
     * 
     */
    LONG_DISTANCE,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final VatScope INTERNATIONAL = new VatScope(VatScopeType.INTERNATIONAL);

  /**
   * 
   */
  public static final VatScope NATIONAL = new VatScope(VatScopeType.NATIONAL);

  /**
   * 
   */
  public static final VatScope SHORT_DISTANCE = new VatScope(VatScopeType.SHORT_DISTANCE);

  /**
   * 
   */
  public static final VatScope LONG_DISTANCE = new VatScope(VatScopeType.LONG_DISTANCE);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private VatScopeType literal;

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
  public static VatScope valueOf( String pLiteralName ) {
    VatScope lEnum;
    try {
      VatScopeType lEnumValue = Enum.valueOf(VatScopeType.class, pLiteralName);
      switch (lEnumValue) {
        case INTERNATIONAL:
          lEnum = INTERNATIONAL;
          break;
        case NATIONAL:
          lEnum = NATIONAL;
          break;
        case SHORT_DISTANCE:
          lEnum = SHORT_DISTANCE;
          break;
        case LONG_DISTANCE:
          lEnum = LONG_DISTANCE;
          break;
        default:
          lEnum = new VatScope(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new VatScope(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public VatScope( VatScopeType pLiteral ) {
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
   * @see VatScope#isUnknownLiteral()
   */
  public VatScope( String pLiteralName ) {
    try {
      literal = Enum.valueOf(VatScopeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = VatScopeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link VatScope} Literal that is represented by this object. The method never returns null.
   */
  public VatScopeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == VatScopeType.UNKNOWN;
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
        VatScope lEnum = (VatScope) pObject;
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