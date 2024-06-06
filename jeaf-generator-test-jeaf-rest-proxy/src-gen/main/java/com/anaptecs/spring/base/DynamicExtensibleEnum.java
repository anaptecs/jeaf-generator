/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.jeaf.xfun.api.checks.Check;

public final class DynamicExtensibleEnum {
  public static enum DynamicExtensibleEnumType {
    STATIC_LITERAL,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  public static final DynamicExtensibleEnum STATIC_LITERAL =
      new DynamicExtensibleEnum(DynamicExtensibleEnumType.STATIC_LITERAL);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private DynamicExtensibleEnumType literal;

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
  public static DynamicExtensibleEnum valueOf( String pLiteralName ) {
    DynamicExtensibleEnum lEnum;
    try {
      DynamicExtensibleEnumType lEnumValue = Enum.valueOf(DynamicExtensibleEnumType.class, pLiteralName);
      switch (lEnumValue) {
        case STATIC_LITERAL:
          lEnum = STATIC_LITERAL;
          break;
        default:
          lEnum = new DynamicExtensibleEnum(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new DynamicExtensibleEnum(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation available constructors {@link #DynamicExtensibleEnum(DynamicExtensibleEnumType)} and
   * {@link #DynamicExtensibleEnum(String)} should be used.
   */
  DynamicExtensibleEnum( ) {
  }

  /**
   * Initialize object from real enumeration literal
   *
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public DynamicExtensibleEnum( DynamicExtensibleEnumType pLiteral ) {
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
   * @see DynamicExtensibleEnum#isUnknownLiteral()
   */
  public DynamicExtensibleEnum( String pLiteralName ) {
    try {
      literal = Enum.valueOf(DynamicExtensibleEnumType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = DynamicExtensibleEnumType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   *
   * @return {@link DynamicExtensibleEnum} Literal that is represented by this object. The method never returns null.
   */
  public DynamicExtensibleEnumType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   *
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == DynamicExtensibleEnumType.UNKNOWN;
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
        DynamicExtensibleEnum lEnum = (DynamicExtensibleEnum) pObject;
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