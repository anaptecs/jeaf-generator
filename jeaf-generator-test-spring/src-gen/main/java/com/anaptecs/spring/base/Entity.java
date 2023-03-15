package com.anaptecs.spring.base;

public enum Entity {
  DISCOUNT_CAMPAIGN, DISCOUNT_OFFER,
  /**
   * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
   * interface.
   */
  UNKNOWN;

  /**
   * Empty constructor is required for UNKNWON literal.
   */
  private Entity( ) {
    entityID = null;
  }

  /**
   * Initialize object.
   */
  private Entity( String pEntityID ) {
    entityID = pEntityID;
  }

  private final String entityID;

  /**
   * Method returns attribute {@link #entityID}.<br/>
   * 
   * @return {@link String} Value to which {@link #entityID} is set.
   */
  public String getEntityID( ) {
    return entityID;
  }
}