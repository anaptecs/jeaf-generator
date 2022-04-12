package ch.voev.nova.inventory.api.masterdata;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Type of quality level, finer grained than the comfort class.
 */
public final class ServiceClassType {
  public static enum ServiceClassTypeType {
    /**
     * 
     */
    BEST,
    /**
     * 
     */
    HIGH,
    /**
     * 
     */
    STANDARD,
    /**
     * 
     */
    BASIC,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final ServiceClassType BEST = new ServiceClassType(ServiceClassTypeType.BEST);

  /**
   * 
   */
  public static final ServiceClassType HIGH = new ServiceClassType(ServiceClassTypeType.HIGH);

  /**
   * 
   */
  public static final ServiceClassType STANDARD = new ServiceClassType(ServiceClassTypeType.STANDARD);

  /**
   * 
   */
  public static final ServiceClassType BASIC = new ServiceClassType(ServiceClassTypeType.BASIC);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private ServiceClassTypeType literal;

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
  public static ServiceClassType valueOf( String pLiteralName ) {
    ServiceClassType lEnum;
    try {
      ServiceClassTypeType lEnumValue = Enum.valueOf(ServiceClassTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case BEST:
          lEnum = BEST;
          break;
        case HIGH:
          lEnum = HIGH;
          break;
        case STANDARD:
          lEnum = STANDARD;
          break;
        case BASIC:
          lEnum = BASIC;
          break;
        default:
          lEnum = new ServiceClassType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new ServiceClassType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public ServiceClassType( ServiceClassTypeType pLiteral ) {
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
   * @see ServiceClassType#isUnknownLiteral()
   */
  public ServiceClassType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(ServiceClassTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = ServiceClassTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link ServiceClassType} Literal that is represented by this object. The method never returns null.
   */
  public ServiceClassTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == ServiceClassTypeType.UNKNOWN;
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
        ServiceClassType lEnum = (ServiceClassType) pObject;
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