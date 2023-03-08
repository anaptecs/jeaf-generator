/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.List;

public class UICStop extends Stop {
  /**
   * Constant for the name of attribute "uicCode".
   */
  public static final String UICCODE = "uicCode";

  private String uicCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected UICStop( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICStop( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    uicCode = pBuilder.uicCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new UICStop objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new UICStop objects. The method never returns null.
   */
  public static Builder builder( UICStop pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class UICStop. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Stop.Builder {
    /**
     * 
     */
    private String uicCode;

    /**
     * Use {@link UICStop#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link UICStop#builder(UICStop)} instead of private constructor to create new builder.
     */
    protected Builder( UICStop pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        uicCode = pObject.uicCode;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets the association "links".
     * 
     * @param pLinks Collection with objects to which the association should be set.
     */
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method sets the attribute "uicCode".
     * 
     * @param pUicCode Value to which the attribute "uicCode" should be set.
     */
    public Builder setUicCode( String pUicCode ) {
      // Assign value to attribute
      uicCode = pUicCode;
      return this;
    }

    /**
     * Method creates a new instance of class UICStop. The object will be initialized with the values of the builder.
     * 
     * @return UICStop Created object. The method never returns null.
     */
    public UICStop build( ) {
      return new UICStop(this);
    }
  }

  /**
   * Method returns the attribute "uicCode".
   * 
   * 
   * @return String Value to which the attribute "uicCode" is set.
   */
  public String getUicCode( ) {
    return uicCode;
  }

  /**
   * Method sets the attribute "uicCode".
   * 
   * 
   * @param pUicCode Value to which the attribute "uicCode" should be set.
   */
  public void setUicCode( String pUicCode ) {
    // Assign value to attribute
    uicCode = pUicCode;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("uicCode: ");
    lBuilder.append(uicCode);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   * 
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }
}
