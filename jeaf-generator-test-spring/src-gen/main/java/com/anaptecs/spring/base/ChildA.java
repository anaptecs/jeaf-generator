/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * single line class comment
 * <p/>
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ChildA extends ParentClass {
  /**
   * Constant for the name of attribute "childAAttribute".
   */
  public static final String CHILDAATTRIBUTE = "childAAttribute";

  /**
   * 
   */
  private int childAAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildA( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAttribute = pBuilder.childAAttribute;
  }

  /**
   * Class implements builder to create a new instance of class ChildA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class Builder extends ParentClass.Builder {
    /**
     * 
     */
    private int childAAttribute;

    /**
     * Use {@link ChildA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildA#builder(ChildA)} instead of private constructor to create new builder.
     */
    protected Builder( ChildA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childAAttribute = pObject.childAAttribute;
      }
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "childAAttribute".
     * 
     * @param pChildAAttribute Value to which the attribute "childAAttribute" should be set.
     */
    public Builder setChildAAttribute( int pChildAAttribute ) {
      // Assign value to attribute
      childAAttribute = pChildAAttribute;
      return this;
    }
  }

  /**
   * Method returns the attribute "childAAttribute".
   * 
   * 
   * @return int Value to which the attribute "childAAttribute" is set.
   */
  public int getChildAAttribute( ) {
    return childAAttribute;
  }

  /**
   * Method sets the attribute "childAAttribute".
   * 
   * 
   * @param pChildAAttribute Value to which the attribute "childAAttribute" should be set.
   */
  public void setChildAAttribute( int pChildAAttribute ) {
    // Assign value to attribute
    childAAttribute = pChildAAttribute;
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
    lBuilder.append("childAAttribute: ");
    lBuilder.append(childAAttribute);
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
