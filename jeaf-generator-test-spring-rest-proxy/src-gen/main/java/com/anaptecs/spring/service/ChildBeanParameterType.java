/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.spring.base.ParentBeanParamType;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ChildBeanParameterType extends ParentBeanParamType {
  /**
   * Constant for the name of attribute "childProperty".
   */
  public static final String CHILDPROPERTY = "childProperty";

  /**
   * 
   */
  private String childProperty;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ChildBeanParameterType objects. The method never
   * returns null.
   */
  public static Builder builder( ChildBeanParameterType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ChildBeanParameterType. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ParentBeanParamType.Builder {
    /**
     * 
     */
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
        childProperty = pObject.childProperty;
      }
    }

    /**
     * Method sets the attribute "novaKey".
     * 
     * @param pNovaKey Value to which the attribute "novaKey" should be set.
     */
    @Override
    public Builder setNovaKey( String pNovaKey ) {
      // Call super class implementation.
      super.setNovaKey(pNovaKey);
      return this;
    }

    /**
     * Method sets the attribute "tkID".
     * 
     * @param pTkID Value to which the attribute "tkID" should be set.
     */
    @Override
    public Builder setTkID( String pTkID ) {
      // Call super class implementation.
      super.setTkID(pTkID);
      return this;
    }

    /**
     * Method sets the attribute "childProperty".
     * 
     * @param pChildProperty Value to which the attribute "childProperty" should be set.
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
  }

  /**
   * Method returns the attribute "childProperty".
   * 
   * 
   * @return String Value to which the attribute "childProperty" is set.
   */
  public String getChildProperty( ) {
    return childProperty;
  }

  /**
   * Method sets the attribute "childProperty".
   * 
   * 
   * @param pChildProperty Value to which the attribute "childProperty" should be set.
   */
  public void setChildProperty( String pChildProperty ) {
    // Assign value to attribute
    childProperty = pChildProperty;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append("childProperty: ");
    lBuilder.append(childProperty);
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
