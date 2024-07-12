/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class EnumTest {
  /**
   * Constant for the name of attribute "property".
   */
  public static final String PROPERTY = "property";

  /**
   * Constant for the name of attribute "enumRef".
   */
  public static final String ENUMREF = "enumRef";

  /**
   * <br/>
   * <b>Default Value:</b> <code>GREEN</code>
   */
  private ExtensibleEnum property;

  /**
   * <br/>
   * <b>Default Value:</b> <code>RED</code>
   */
  private ExtensibleEnum enumRef;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected EnumTest( ) {
    property = ExtensibleEnum.GREEN;
    enumRef = ExtensibleEnum.RED;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected EnumTest( Builder pBuilder ) {
    // Read attribute values from builder.
    property = pBuilder.property;
    enumRef = pBuilder.enumRef;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new EnumTest objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class EnumTest.
   *
   *
   * @param pProperty Value to which {@link #property} should be set.
   *
   * @param pEnumRef Value to which {@link #enumRef} should be set.
   *
   * @return {@link com.anaptecs.spring.base.EnumTest}
   */
  public static EnumTest of( ExtensibleEnum pProperty, ExtensibleEnum pEnumRef ) {
    EnumTest.Builder lBuilder = EnumTest.builder();
    lBuilder.setProperty(pProperty);
    lBuilder.setEnumRef(pEnumRef);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>EnumTest</code>.
   */
  public static class Builder {
    /**
     * <br/>
     * <b>Default Value:</b> <code>GREEN</code>
     */
    private ExtensibleEnum property = ExtensibleEnum.GREEN;

    /**
     * <br/>
     * <b>Default Value:</b> <code>RED</code>
     */
    private ExtensibleEnum enumRef = ExtensibleEnum.RED;

    /**
     * Use {@link EnumTest#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link EnumTest#builder(EnumTest)} instead of private constructor to create new builder.
     */
    protected Builder( EnumTest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProperty(pObject.property);
        this.setEnumRef(pObject.enumRef);
      }
    }

    /**
     * Method sets attribute {@link #property}.<br/>
     *
     * @param pProperty Value to which {@link #property} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setProperty( ExtensibleEnum pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this;
    }

    /**
     * Method sets association {@link #enumRef}.<br/>
     *
     * @param pEnumRef Value to which {@link #enumRef} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setEnumRef( ExtensibleEnum pEnumRef ) {
      enumRef = pEnumRef;
      return this;
    }

    /**
     * Method creates a new instance of class EnumTest. The object will be initialized with the values of the builder.
     *
     * @return EnumTest Created object. The method never returns null.
     */
    public EnumTest build( ) {
      return new EnumTest(this);
    }
  }

  /**
   * Method returns attribute {@link #property}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #property} is set.
   */
  public ExtensibleEnum getProperty( ) {
    return property;
  }

  /**
   * Method sets attribute {@link #property}.<br/>
   *
   * @param pProperty Value to which {@link #property} should be set.
   */
  public void setProperty( ExtensibleEnum pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  /**
   * Method returns association {@link #enumRef}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #enumRef} is set.
   */
  public ExtensibleEnum getEnumRef( ) {
    return enumRef;
  }

  /**
   * Method sets association {@link #enumRef}.<br/>
   *
   * @param pEnumRef Value to which {@link #enumRef} should be set.
   */
  public void setEnumRef( ExtensibleEnum pEnumRef ) {
    enumRef = pEnumRef;
  }

  /**
   * Method unsets {@link #enumRef}.
   */
  public final void unsetEnumRef( ) {
    enumRef = null;
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
    lBuilder.append("property: ");
    lBuilder.append(property);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("enumRef: ");
    lBuilder.append(enumRef);
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
   * @return {@link Builder} New builder that can be used to create new EnumTest objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}