/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class DerivedClassImpl extends AbtractWithDerivedProperty {
  /**
   * Constant for the name of attribute "derivedProperty".
   */
  public static final String DERIVEDPROPERTY = "derivedProperty";

  private String derivedProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DerivedClassImpl( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    derivedProperty = pBuilder.derivedProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DerivedClassImpl objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DerivedClassImpl.
   *
   *
   * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
   *
   * @return {@link DerivedClassImpl}
   */
  public static DerivedClassImpl of( String pDerivedProperty ) {
    var lBuilder = DerivedClassImpl.builder();
    lBuilder.setDerivedProperty(pDerivedProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DerivedClassImpl</code>.
   */
  public static class Builder extends AbtractWithDerivedProperty.Builder {
    private String derivedProperty;

    /**
     * Use {@link DerivedClassImpl#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link DerivedClassImpl#builder(DerivedClassImpl)} instead of private constructor to create new builder.
     */
    protected Builder( DerivedClassImpl pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDerivedProperty(pObject.derivedProperty);
      }
    }

    /**
     * Method sets attribute {@link #derivedProperty}.<br/>
     *
     * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedProperty( String pDerivedProperty ) {
      // Assign value to attribute
      derivedProperty = pDerivedProperty;
      return this;
    }

    /**
     * Method creates a new instance of class DerivedClassImpl. The object will be initialized with the values of the
     * builder.
     *
     * @return DerivedClassImpl Created object. The method never returns null.
     */
    public DerivedClassImpl build( ) {
      return new DerivedClassImpl(this);
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @Override
  public String getDerivedProperty( ) {
    return derivedProperty;
  }

  /**
   * Method sets attribute {@link #derivedProperty}.<br/>
   *
   * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
   */
  public void setDerivedProperty( String pDerivedProperty ) {
    // Assign value to attribute
    derivedProperty = pDerivedProperty;
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
    lBuilder.append("derivedProperty: ");
    lBuilder.append(derivedProperty);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new DerivedClassImpl objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}