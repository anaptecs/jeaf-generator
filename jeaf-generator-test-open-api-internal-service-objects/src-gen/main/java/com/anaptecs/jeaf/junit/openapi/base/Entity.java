package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.xfun.api.checks.Check;

public final class Entity {
  public static enum EntityType {
    DISCOUNT_CAMPAIGN, DISCOUNT_OFFER("DISOFF", DataUnit.COUPON), UNKNOWN("N/A", DataUnit.UNKNOWN);

    /**
     * Empty constructor is required for UNKNWON literal.
     */
    private EntityType( ) {
      entityID = null;
      dataUnit = null;
    }

    /**
     * Initialize object.
     */
    private EntityType( String pEntityID, DataUnit pDataUnit ) {
      entityID = pEntityID;
      dataUnit = pDataUnit;
    }

    @NotNull
    private final String entityID;

    @NotNull
    private DataUnit dataUnit;

    /**
     * Method returns attribute {@link #entityID}.<br/>
     * 
     * @return {@link String} Value to which {@link #entityID} is set.
     */
    public String getEntityID( ) {
      return entityID;
    }

    /**
     * Method returns association {@link #dataUnit}.<br/>
     * 
     * @return {@link DataUnit} Value to which {@link #dataUnit} is set.
     */
    public DataUnit getDataUnit( ) {
      return dataUnit;
    }
  }

  public static final Entity DISCOUNT_CAMPAIGN = new Entity(EntityType.DISCOUNT_CAMPAIGN);

  public static final Entity DISCOUNT_OFFER = new Entity(EntityType.DISCOUNT_OFFER);

  public static final Entity UNKNOWN = new Entity(EntityType.UNKNOWN);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private EntityType literal;

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
  public static Entity valueOf( String pLiteralName ) {
    Entity lEnum;
    try {
      EntityType lEnumValue = Enum.valueOf(EntityType.class, pLiteralName);
      switch (lEnumValue) {
        case DISCOUNT_CAMPAIGN:
          lEnum = DISCOUNT_CAMPAIGN;
          break;
        case DISCOUNT_OFFER:
          lEnum = DISCOUNT_OFFER;
          break;
        case UNKNOWN:
          lEnum = UNKNOWN;
          break;
        default:
          lEnum = new Entity(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new Entity(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation available constructors {@link #Entity(EntityType)} and {@link #Entity(String)} should be used.
   */
  Entity( ) {
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public Entity( EntityType pLiteral ) {
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
   * @see Entity#isUnknownLiteral()
   */
  public Entity( String pLiteralName ) {
    try {
      literal = Enum.valueOf(EntityType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = EntityType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link Entity} Literal that is represented by this object. The method never returns null.
   */
  public EntityType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == EntityType.UNKNOWN;
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
        Entity lEnum = (Entity) pObject;
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
