/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class EnumTest implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * <br/>
   * <b>Default Value:</b> <code>GREEN</code>
   */
  @NotNull
  private ExtensibleEnum property;

  /**
   * 
   */
  @NotNull
  private ExtensibleEnum enumRef;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new EnumTest objects. The method never returns null.
   */
  public static Builder builder( EnumTest pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class EnumTest. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ExtensibleEnum property = ExtensibleEnum.GREEN;

    /**
     * 
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
        property = pObject.property;
        enumRef = pObject.enumRef;
      }
    }

    /**
     * Method sets the attribute "property".
     * 
     * @param pProperty Value to which the attribute "property" should be set.
     */
    public Builder setProperty( ExtensibleEnum pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this;
    }

    /**
     * Method sets the association "enumRef".
     * 
     * @param pEnumRef ExtensibleEnum to which the association "enumRef" should be set.
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

    /**
     * Method creates a new validated instance of class EnumTest. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return EnumTest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public EnumTest buildValidated( ) throws ConstraintViolationException {
      EnumTest lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "property".
   * 
   * 
   * @return ExtensibleEnum Value to which the attribute "property" is set.
   */
  public ExtensibleEnum getProperty( ) {
    return property;
  }

  /**
   * Method sets the attribute "property".
   * 
   * 
   * @param pProperty Value to which the attribute "property" should be set.
   */
  public void setProperty( ExtensibleEnum pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  /**
   * Method returns the association "enumRef".
   * 
   *
   * @return ExtensibleEnum ExtensibleEnum to which the association "enumRef" is set.
   */
  public ExtensibleEnum getEnumRef( ) {
    return enumRef;
  }

  /**
   * Method sets the association "enumRef".
   * 
   * 
   * @param pEnumRef ExtensibleEnum to which the association "enumRef" should be set.
   */
  public void setEnumRef( ExtensibleEnum pEnumRef ) {
    enumRef = pEnumRef;
  }

  /**
   * Method unsets the association "enumRef".
   * 
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
}