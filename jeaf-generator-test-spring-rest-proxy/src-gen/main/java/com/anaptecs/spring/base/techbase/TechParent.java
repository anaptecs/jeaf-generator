/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TechParent {
  /**
   * Constant for the name of attribute "techAttribute".
   */
  public static final String TECHATTRIBUTE = "techAttribute";

  /**
   * 
   */
  private String techAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TechParent( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechParent( Builder pBuilder ) {
    // Read attribute values from builder.
    techAttribute = pBuilder.techAttribute;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TechParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TechParent objects. The method never returns
   * null.
   */
  public static Builder builder( TechParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TechParent. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String techAttribute;

    /**
     * Use {@link TechParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechParent#builder(TechParent)} instead of private constructor to create new builder.
     */
    protected Builder( TechParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        techAttribute = pObject.techAttribute;
      }
    }

    /**
     * Method sets the attribute "techAttribute".
     * 
     * @param pTechAttribute Value to which the attribute "techAttribute" should be set.
     */
    public Builder setTechAttribute( String pTechAttribute ) {
      // Assign value to attribute
      techAttribute = pTechAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class TechParent. The object will be initialized with the values of the builder.
     * 
     * @return TechParent Created object. The method never returns null.
     */
    public TechParent build( ) {
      return new TechParent(this);
    }
  }

  /**
   * Method returns the attribute "techAttribute".
   * 
   * 
   * @return String Value to which the attribute "techAttribute" is set.
   */
  public String getTechAttribute( ) {
    return techAttribute;
  }

  /**
   * Method sets the attribute "techAttribute".
   * 
   * 
   * @param pTechAttribute Value to which the attribute "techAttribute" should be set.
   */
  public void setTechAttribute( String pTechAttribute ) {
    // Assign value to attribute
    techAttribute = pTechAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("techAttribute: ");
    lBuilder.append(techAttribute);
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