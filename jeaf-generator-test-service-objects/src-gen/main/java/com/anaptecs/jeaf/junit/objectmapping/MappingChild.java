/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.objectmapping;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class MappingChild extends MappingParent {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * 
   */
  private int value;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected MappingChild( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MappingChild( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Class implements builder to create a new instance of class MappingChild. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends MappingParent.Builder {
    /**
     * 
     */
    private int value;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(MappingChild)} instead of private constructor to create new builder.
     */
    protected Builder( MappingChild pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        value = pObject.value;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new MappingChild objects. The method never returns
     * null.
     */
    public static Builder newBuilder( MappingChild pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets the attribute "value".
     * 
     * @param pValue Value to which the attribute "value" should be set.
     */
    public Builder setValue( int pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class MappingChild. The object will be initialized with the values of the
     * builder.
     * 
     * @return MappingChild Created object. The method never returns null.
     */
    public MappingChild build( ) {
      return new MappingChild(this);
    }

    /**
     * Method creates a new instance of class MappingChild. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return MappingChild Created object. The method never returns null.
     */
    public MappingChild build( boolean pValidate ) {
      MappingChild lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "value".
   * 
   * 
   * @return int Value to which the attribute "value" is set.
   */
  public int getValue( ) {
    return value;
  }

  /**
   * Method sets the attribute "value".
   * 
   * 
   * @param pValue Value to which the attribute "value" should be set.
   */
  public void setValue( int pValue ) {
    // Assign value to attribute
    value = pValue;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "value", "" + value));
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