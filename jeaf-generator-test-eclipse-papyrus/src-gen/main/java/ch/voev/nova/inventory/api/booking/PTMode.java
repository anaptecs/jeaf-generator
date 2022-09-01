package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public final class PTMode {
  public static enum PTModeType {
    /**
     * 
     */
    HIGH_SPEED_TRAIN,
    /**
     * 
     */
    HISTORIC_TRAIN,
    /**
     * 
     */
    INTERCITY,
    /**
     * 
     */
    REGIONAL,
    /**
     * 
     */
    INTERREGIONAL,
    /**
     * 
     */
    URBAN,
    /**
     * 
     */
    TRAM,
    /**
     * 
     */
    UNDERGROUND,
    /**
     * 
     */
    NIGHT_TRAIN,
    /**
     * 
     */
    SHARED_TAXI,
    /**
     * 
     */
    MOTOR_RAIL,
    /**
     * 
     */
    MOUNTAIN_TRAIN,
    /**
     * 
     */
    PLANE,
    /**
     * 
     */
    COACH_GROUP,
    /**
     * 
     */
    SHIP,
    /**
     * 
     */
    BUS,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final PTMode HIGH_SPEED_TRAIN = new PTMode(PTModeType.HIGH_SPEED_TRAIN);

  /**
   * 
   */
  public static final PTMode HISTORIC_TRAIN = new PTMode(PTModeType.HISTORIC_TRAIN);

  /**
   * 
   */
  public static final PTMode INTERCITY = new PTMode(PTModeType.INTERCITY);

  /**
   * 
   */
  public static final PTMode REGIONAL = new PTMode(PTModeType.REGIONAL);

  /**
   * 
   */
  public static final PTMode INTERREGIONAL = new PTMode(PTModeType.INTERREGIONAL);

  /**
   * 
   */
  public static final PTMode URBAN = new PTMode(PTModeType.URBAN);

  /**
   * 
   */
  public static final PTMode TRAM = new PTMode(PTModeType.TRAM);

  /**
   * 
   */
  public static final PTMode UNDERGROUND = new PTMode(PTModeType.UNDERGROUND);

  /**
   * 
   */
  public static final PTMode NIGHT_TRAIN = new PTMode(PTModeType.NIGHT_TRAIN);

  /**
   * 
   */
  public static final PTMode SHARED_TAXI = new PTMode(PTModeType.SHARED_TAXI);

  /**
   * 
   */
  public static final PTMode MOTOR_RAIL = new PTMode(PTModeType.MOTOR_RAIL);

  /**
   * 
   */
  public static final PTMode MOUNTAIN_TRAIN = new PTMode(PTModeType.MOUNTAIN_TRAIN);

  /**
   * 
   */
  public static final PTMode PLANE = new PTMode(PTModeType.PLANE);

  /**
   * 
   */
  public static final PTMode COACH_GROUP = new PTMode(PTModeType.COACH_GROUP);

  /**
   * 
   */
  public static final PTMode SHIP = new PTMode(PTModeType.SHIP);

  /**
   * 
   */
  public static final PTMode BUS = new PTMode(PTModeType.BUS);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private PTModeType literal;

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
  public static PTMode valueOf( String pLiteralName ) {
    PTMode lEnum;
    try {
      PTModeType lEnumValue = Enum.valueOf(PTModeType.class, pLiteralName);
      switch (lEnumValue) {
        case HIGH_SPEED_TRAIN:
          lEnum = HIGH_SPEED_TRAIN;
          break;
        case HISTORIC_TRAIN:
          lEnum = HISTORIC_TRAIN;
          break;
        case INTERCITY:
          lEnum = INTERCITY;
          break;
        case REGIONAL:
          lEnum = REGIONAL;
          break;
        case INTERREGIONAL:
          lEnum = INTERREGIONAL;
          break;
        case URBAN:
          lEnum = URBAN;
          break;
        case TRAM:
          lEnum = TRAM;
          break;
        case UNDERGROUND:
          lEnum = UNDERGROUND;
          break;
        case NIGHT_TRAIN:
          lEnum = NIGHT_TRAIN;
          break;
        case SHARED_TAXI:
          lEnum = SHARED_TAXI;
          break;
        case MOTOR_RAIL:
          lEnum = MOTOR_RAIL;
          break;
        case MOUNTAIN_TRAIN:
          lEnum = MOUNTAIN_TRAIN;
          break;
        case PLANE:
          lEnum = PLANE;
          break;
        case COACH_GROUP:
          lEnum = COACH_GROUP;
          break;
        case SHIP:
          lEnum = SHIP;
          break;
        case BUS:
          lEnum = BUS;
          break;
        default:
          lEnum = new PTMode(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new PTMode(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public PTMode( PTModeType pLiteral ) {
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
   * @see PTMode#isUnknownLiteral()
   */
  public PTMode( String pLiteralName ) {
    try {
      literal = Enum.valueOf(PTModeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = PTModeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link PTMode} Literal that is represented by this object. The method never returns null.
   */
  public PTModeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == PTModeType.UNKNOWN;
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
        PTMode lEnum = (PTMode) pObject;
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