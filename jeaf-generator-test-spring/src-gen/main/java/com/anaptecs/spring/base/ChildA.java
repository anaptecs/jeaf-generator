/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * single line class comment
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ChildA extends ParentClass {
  /**
   * Constant for the name of attribute "childAAttribute".
   */
  public static final String CHILDAATTRIBUTE = "childAAttribute";

  private int childAAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildA( ChildABuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAttribute = pBuilder.childAAttribute;
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildA</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ChildABuilder<T extends ChildA, S extends ChildABuilder<T, S>>
      extends ParentClassBuilder<T, S> {
    private int childAAttribute;

    /**
     * Use {@link ChildABuilder#builder()} instead of private constructor to create new builder.
     */
    protected ChildABuilder( ) {
      super();
    }

    /**
     * Use {@link ChildABuilder#builder(ChildA)} instead of private constructor to create new builder.
     */
    protected ChildABuilder( ChildA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAAttribute(pObject.childAAttribute);
      }
    }

    /**
     * Method sets attribute {@link #childAAttribute}.<br/>
     *
     * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setChildAAttribute( int pChildAAttribute ) {
      // Assign value to attribute
      childAAttribute = pChildAAttribute;
      return this.self();
    }
  }

  /**
   * Method returns attribute {@link #childAAttribute}.<br/>
   *
   * @return int Value to which {@link #childAAttribute} is set.
   */
  public int getChildAAttribute( ) {
    return childAAttribute;
  }

  /**
   * Method sets attribute {@link #childAAttribute}.<br/>
   *
   * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
   */
  public void setChildAAttribute( int pChildAAttribute ) {
    // Assign value to attribute
    childAAttribute = pChildAAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + childAAttribute;
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      ChildA lOther = (ChildA) pObject;
      lEquals = childAAttribute == lOther.childAAttribute;
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
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