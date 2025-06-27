/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ParentBeanParamType;

public class ChildBeanParameterType extends ParentBeanParamType {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childProperty".
   */
  public static final String CHILDPROPERTY = "childProperty";

  @HeaderParam("X-Child-Property")
  private String childProperty;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public ChildBeanParameterType( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildBeanParameterType( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childProperty = pBuilder.childProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildBeanParameterType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pNovaKey, String pTkID, DoubleCode pCode, String pChildProperty ) {
    Builder lBuilder = builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    lBuilder.setCode(pCode);
    lBuilder.setChildProperty(pChildProperty);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class ChildBeanParameterType.
   *
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @param pChildProperty Value to which {@link #childProperty} should be set.
   *
   * @return {@link ChildBeanParameterType}
   */
  public static ChildBeanParameterType of( String pNovaKey, String pTkID, DoubleCode pCode, String pChildProperty ) {
    var lBuilder = ChildBeanParameterType.builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    lBuilder.setCode(pCode);
    lBuilder.setChildProperty(pChildProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildBeanParameterType</code>.
   */
  public static class Builder extends ParentBeanParamType.Builder {
    private String childProperty;

    /**
     * Use {@link ChildBeanParameterType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildBeanParameterType#builder(ChildBeanParameterType)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ChildBeanParameterType pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildProperty(pObject.childProperty);
      }
    }

    /**
     * Method sets attribute {@link #novaKey}.<br/>
     *
     * @param pNovaKey Value to which {@link #novaKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setNovaKey( String pNovaKey ) {
      // Call super class implementation.
      super.setNovaKey(pNovaKey);
      return this;
    }

    /**
     * Method sets attribute {@link #tkID}.<br/>
     *
     * @param pTkID Value to which {@link #tkID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setTkID( String pTkID ) {
      // Call super class implementation.
      super.setTkID(pTkID);
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setCode( DoubleCode pCode ) {
      // Call super class implementation.
      super.setCode(pCode);
      return this;
    }

    /**
     * Method sets attribute {@link #childProperty}.<br/>
     *
     * @param pChildProperty Value to which {@link #childProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildProperty( String pChildProperty ) {
      // Assign value to attribute
      childProperty = pChildProperty;
      return this;
    }

    /**
     * Method creates a new instance of class ChildBeanParameterType. The object will be initialized with the values of
     * the builder.
     *
     * @return ChildBeanParameterType Created object. The method never returns null.
     */
    public ChildBeanParameterType build( ) {
      return new ChildBeanParameterType(this);
    }

    /**
     * Method creates a new validated instance of class ChildBeanParameterType. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ChildBeanParameterType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildBeanParameterType buildValidated( ) throws ConstraintViolationException {
      ChildBeanParameterType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #childProperty} is set.
   */
  public String getChildProperty( ) {
    return childProperty;
  }

  /**
   * Method sets attribute {@link #childProperty}.<br/>
   *
   * @param pChildProperty Value to which {@link #childProperty} should be set.
   */
  public void setChildProperty( String pChildProperty ) {
    // Assign value to attribute
    childProperty = pChildProperty;
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
    lBuilder.append("childProperty: ");
    lBuilder.append(childProperty);
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
   * @return {@link Builder} New builder that can be used to create new ChildBeanParameterType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}