/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class EnumTest extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "property".
   */
  @JEAFCustomAnnotationTest
  public static final String PROPERTY = "property";

  /**
   * Constant for the name of attribute "enumRef".
   */
  @JEAFCustomAnnotationTest
  public static final String ENUMREF = "enumRef";

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Default Value:</b> <code>GREEN</code>
   */
  @JEAFCustomAnnotationTest
  private ExtensibleEnum property;

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  private int propertyXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Default Value:</b> <code>RED</code>
   */
  @JEAFCustomAnnotationTest
  private ExtensibleEnum enumRef;

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  private int enumRefXYZ = 0;

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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    property = pBuilder.property;
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    propertyXYZ = pBuilder.propertyXYZ;
    enumRef = pBuilder.enumRef;
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    enumRefXYZ = pBuilder.enumRefXYZ;
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
   * Class implements builder to create a new instance of class <code>EnumTest</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    /**
     * <br/>
     * <b>Default Value:</b> <code>GREEN</code>
     */
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private ExtensibleEnum property = ExtensibleEnum.GREEN;

    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    private int propertyXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>RED</code>
     */
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private ExtensibleEnum enumRef = ExtensibleEnum.RED;

    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    private int enumRefXYZ = 0;

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
    @JEAFCustomAnnotationTest
    public Builder setProperty( ExtensibleEnum pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this;
    }

    public Builder setPropertyXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
      propertyXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #enumRef}.<br/>
     *
     * @param pEnumRef Value to which {@link #enumRef} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setEnumRef( ExtensibleEnum pEnumRef ) {
      enumRef = pEnumRef;
      return this;
    }

    public Builder setEnumRefXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
      enumRefXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class EnumTest. The object will be initialized with the values of the builder.
     *
     * @return EnumTest Created object. The method never returns null.
     */
    public EnumTest build( ) {
      return new EnumTest(this);
    }

    /**
     * Method creates a new validated instance of class EnumTest. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return EnumTest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public EnumTest buildValidated( ) throws ConstraintViolationException {
      EnumTest lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #property}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #property} is set.
   */
  @JEAFCustomAnnotationTest
  public ExtensibleEnum getProperty( ) {
    return property;
  }

  /**
   * Method sets attribute {@link #property}.<br/>
   *
   * @param pProperty Value to which {@link #property} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setProperty( ExtensibleEnum pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  public int getPropertyXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    return propertyXYZ;
  }

  public void setPropertyXYZ( int value ) {
    propertyXYZ = value;
  }

  /**
   * Method returns association {@link #enumRef}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #enumRef} is set.
   */
  @JEAFCustomAnnotationTest
  public ExtensibleEnum getEnumRef( ) {
    return enumRef;
  }

  /**
   * Method sets association {@link #enumRef}.<br/>
   *
   * @param pEnumRef Value to which {@link #enumRef} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setEnumRef( ExtensibleEnum pEnumRef ) {
    enumRef = pEnumRef;
  }

  /**
   * Method unsets {@link #enumRef}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetEnumRef( ) {
    enumRef = null;
  }

  public int getEnumRefXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    return enumRefXYZ;
  }

  public void setEnumRefXYZ( int value ) {
    enumRefXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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