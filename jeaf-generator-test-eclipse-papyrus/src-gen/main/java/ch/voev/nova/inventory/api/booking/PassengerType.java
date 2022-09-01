package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Passenger type according to UIC passenger, i.e. passenger type list. See
 * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
 */
public final class PassengerType {
  public static enum PassengerTypeType {
    /**
     * 
     */
    DOG,
    /**
     * 
     */
    PET,
    /**
     * 
     */
    LUGGAGE,
    /**
     * 
     */
    PRM,
    /**
     * 
     */
    BICYCLE,
    /**
     * 
     */
    PRAM,
    /**
     * 
     */
    ACCOMP_DOG,
    /**
     * 
     */
    CAR,
    /**
     * 
     */
    PERSON,
    /**
     * 
     */
    MOTOCYCLE,
    /**
     * 
     */
    TRAILER,
    /**
     * 
     */
    FAMILY_CHILD,
    /**
     * 
     */
    WHEELCHAR,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final PassengerType DOG = new PassengerType(PassengerTypeType.DOG);

  /**
   * 
   */
  public static final PassengerType PET = new PassengerType(PassengerTypeType.PET);

  /**
   * 
   */
  public static final PassengerType LUGGAGE = new PassengerType(PassengerTypeType.LUGGAGE);

  /**
   * 
   */
  public static final PassengerType PRM = new PassengerType(PassengerTypeType.PRM);

  /**
   * 
   */
  public static final PassengerType BICYCLE = new PassengerType(PassengerTypeType.BICYCLE);

  /**
   * 
   */
  public static final PassengerType PRAM = new PassengerType(PassengerTypeType.PRAM);

  /**
   * 
   */
  public static final PassengerType ACCOMP_DOG = new PassengerType(PassengerTypeType.ACCOMP_DOG);

  /**
   * 
   */
  public static final PassengerType CAR = new PassengerType(PassengerTypeType.CAR);

  /**
   * 
   */
  public static final PassengerType PERSON = new PassengerType(PassengerTypeType.PERSON);

  /**
   * 
   */
  public static final PassengerType MOTOCYCLE = new PassengerType(PassengerTypeType.MOTOCYCLE);

  /**
   * 
   */
  public static final PassengerType TRAILER = new PassengerType(PassengerTypeType.TRAILER);

  /**
   * 
   */
  public static final PassengerType FAMILY_CHILD = new PassengerType(PassengerTypeType.FAMILY_CHILD);

  /**
   * 
   */
  public static final PassengerType WHEELCHAR = new PassengerType(PassengerTypeType.WHEELCHAR);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private PassengerTypeType literal;

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
  public static PassengerType valueOf( String pLiteralName ) {
    PassengerType lEnum;
    try {
      PassengerTypeType lEnumValue = Enum.valueOf(PassengerTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case DOG:
          lEnum = DOG;
          break;
        case PET:
          lEnum = PET;
          break;
        case LUGGAGE:
          lEnum = LUGGAGE;
          break;
        case PRM:
          lEnum = PRM;
          break;
        case BICYCLE:
          lEnum = BICYCLE;
          break;
        case PRAM:
          lEnum = PRAM;
          break;
        case ACCOMP_DOG:
          lEnum = ACCOMP_DOG;
          break;
        case CAR:
          lEnum = CAR;
          break;
        case PERSON:
          lEnum = PERSON;
          break;
        case MOTOCYCLE:
          lEnum = MOTOCYCLE;
          break;
        case TRAILER:
          lEnum = TRAILER;
          break;
        case FAMILY_CHILD:
          lEnum = FAMILY_CHILD;
          break;
        case WHEELCHAR:
          lEnum = WHEELCHAR;
          break;
        default:
          lEnum = new PassengerType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new PassengerType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public PassengerType( PassengerTypeType pLiteral ) {
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
   * @see PassengerType#isUnknownLiteral()
   */
  public PassengerType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(PassengerTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = PassengerTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link PassengerType} Literal that is represented by this object. The method never returns null.
   */
  public PassengerTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == PassengerTypeType.UNKNOWN;
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
        PassengerType lEnum = (PassengerType) pObject;
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