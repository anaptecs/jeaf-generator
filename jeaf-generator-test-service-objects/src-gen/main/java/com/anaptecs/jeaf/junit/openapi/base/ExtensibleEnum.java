package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public class ExtensibleEnum {
  public static enum ExtensibleEnumType {
    /**
     * 
     */
    RED,
    /**
     * 
     */
    GREEN,
    /**
     * 
     */
    BLUE,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final ExtensibleEnum RED = new ExtensibleEnum(ExtensibleEnumType.RED);

  /**
   * 
   */
  public static final ExtensibleEnum GREEN = new ExtensibleEnum(ExtensibleEnumType.GREEN);

  /**
   * 
   */
  public static final ExtensibleEnum BLUE = new ExtensibleEnum(ExtensibleEnumType.BLUE);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private ExtensibleEnumType literal;

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
  public static ExtensibleEnum valueOf( String pLiteralName ) {
    ExtensibleEnum lEnum;
    try {
      ExtensibleEnumType lEnumValue = Enum.valueOf(ExtensibleEnumType.class, pLiteralName);
      switch (lEnumValue) {
        case RED:
          lEnum = RED;
          break;
        case GREEN:
          lEnum = GREEN;
          break;
        case BLUE:
          lEnum = BLUE;
          break;
        default:
          lEnum = new ExtensibleEnum(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new ExtensibleEnum(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public ExtensibleEnum( ExtensibleEnumType pLiteral ) {
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
   * @see ExtensibleEnum#isUnknownLiteral()
   */
  public ExtensibleEnum( String pLiteralName ) {
    try {
      literal = Enum.valueOf(ExtensibleEnumType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = ExtensibleEnumType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link ExtensibleEnum} Literal that is represented by this object. The method never returns null.
   */
  public ExtensibleEnumType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == ExtensibleEnumType.UNKNOWN;
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
      else if (pObject instanceof ExtensibleEnum) {
        ExtensibleEnum lEnum = (ExtensibleEnum) pObject;
        // Compare if unknown literal is the same
        if (this.isUnknownLiteral() && lEnum.isUnknownLiteral()) {
          lEquals = this.unknownLiteralName.equals(lEnum.unknownLiteralName);
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