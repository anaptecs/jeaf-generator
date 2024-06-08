/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.backward;

import java.util.Objects;

public class SimpleBackwardCompatibility {
  /**
   * Constant for the name of attribute "deprecatedProperty".
   */
  @Deprecated
  public static final String DEPRECATEDPROPERTY = "deprecatedProperty";

  /**
   * Constant for the name of attribute "successorProperty".
   */
  public static final String SUCCESSORPROPERTY = "successorProperty";

  @Deprecated
  private String deprecatedProperty;

  private String successorProperty;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SimpleBackwardCompatibility( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SimpleBackwardCompatibility( Builder pBuilder ) {
    // Read attribute values from builder.
    deprecatedProperty = pBuilder.deprecatedProperty;
    successorProperty = pBuilder.successorProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SimpleBackwardCompatibility objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class SimpleBackwardCompatibility.
   *
   *
   * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
   *
   * @param pSuccessorProperty Value to which {@link #successorProperty} should be set.
   *
   * @return {@link com.anaptecs.spring.base.backward.SimpleBackwardCompatibility}
   */
  public static SimpleBackwardCompatibility of( String pDeprecatedProperty, String pSuccessorProperty ) {
    SimpleBackwardCompatibility.Builder lBuilder = SimpleBackwardCompatibility.builder();
    lBuilder.setDeprecatedProperty(pDeprecatedProperty);
    lBuilder.setSuccessorProperty(pSuccessorProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SimpleBackwardCompatibility</code>.
   */
  public static class Builder {
    @Deprecated
    private String deprecatedProperty;

    private String successorProperty;

    /**
     * Use {@link SimpleBackwardCompatibility#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SimpleBackwardCompatibility#builder(SimpleBackwardCompatibility)} instead of private constructor to
     * create new builder.
     */
    protected Builder( SimpleBackwardCompatibility pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDeprecatedProperty(pObject.deprecatedProperty);
        this.setSuccessorProperty(pObject.successorProperty);
      }
    }

    /**
     * Method sets attribute {@link #deprecatedProperty}.<br/>
     *
     * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDeprecatedProperty( String pDeprecatedProperty ) {
      // Assign value to attribute
      deprecatedProperty = pDeprecatedProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #successorProperty}.<br/>
     *
     * @param pSuccessorProperty Value to which {@link #successorProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSuccessorProperty( String pSuccessorProperty ) {
      // Assign value to attribute
      successorProperty = pSuccessorProperty;
      return this;
    }

    /**
     * Method creates a new instance of class SimpleBackwardCompatibility. The object will be initialized with the
     * values of the builder.
     *
     * @return SimpleBackwardCompatibility Created object. The method never returns null.
     */
    public SimpleBackwardCompatibility build( ) {
      return new SimpleBackwardCompatibility(this);
    }
  }

  /**
   * Method returns attribute {@link #deprecatedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #deprecatedProperty} is set.
   */
  @Deprecated
  public String getDeprecatedProperty( ) {
    return deprecatedProperty;
  }

  /**
   * Method sets attribute {@link #deprecatedProperty}.<br/>
   *
   * @param pDeprecatedProperty Value to which {@link #deprecatedProperty} should be set.
   */
  @Deprecated
  public void setDeprecatedProperty( String pDeprecatedProperty ) {
    // Assign value to attribute
    deprecatedProperty = pDeprecatedProperty;
  }

  /**
   * Method returns attribute {@link #successorProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #successorProperty} is set.
   */
  public String getSuccessorProperty( ) {
    return successorProperty;
  }

  /**
   * Method sets attribute {@link #successorProperty}.<br/>
   *
   * @param pSuccessorProperty Value to which {@link #successorProperty} should be set.
   */
  public void setSuccessorProperty( String pSuccessorProperty ) {
    // Assign value to attribute
    successorProperty = pSuccessorProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(deprecatedProperty);
    lResult = lPrime * lResult + Objects.hashCode(successorProperty);
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
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      SimpleBackwardCompatibility lOther = (SimpleBackwardCompatibility) pObject;
      lEquals = Objects.equals(deprecatedProperty, lOther.deprecatedProperty)
          && Objects.equals(successorProperty, lOther.successorProperty);
    }
    return lEquals;
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
    lBuilder.append("deprecatedProperty: ");
    lBuilder.append(deprecatedProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("successorProperty: ");
    lBuilder.append(successorProperty);
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
   * @return {@link Builder} New builder that can be used to create new SimpleBackwardCompatibility objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
