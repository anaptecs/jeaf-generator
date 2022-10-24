/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MutableChildPOJO extends ImmutablePOJOParent {
  /**
   * Constant for the name of attribute "writeable".
   */
  public static final String WRITEABLE = "writeable";

  /**
   * 
   */
  private Integer writeable;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected MutableChildPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MutableChildPOJO( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    writeable = pBuilder.writeable;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new MutableChildPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MutableChildPOJO objects. The method never
   * returns null.
   */
  public static Builder builder( MutableChildPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class MutableChildPOJO. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ImmutablePOJOParent.Builder {
    /**
     * 
     */
    private Integer writeable;

    /**
     * Use {@link MutableChildPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link MutableChildPOJO#builder(MutableChildPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( MutableChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        writeable = pObject.writeable;
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
     * Method sets the attribute "anotherParentAttribute".
     * 
     * @param pAnotherParentAttribute Value to which the attribute "anotherParentAttribute" should be set.
     */
    @Override
    public Builder setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
      // Call super class implementation.
      super.setAnotherParentAttribute(pAnotherParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "writeable".
     * 
     * @param pWriteable Value to which the attribute "writeable" should be set.
     */
    public Builder setWriteable( Integer pWriteable ) {
      // Assign value to attribute
      writeable = pWriteable;
      return this;
    }

    /**
     * Method creates a new instance of class MutableChildPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return MutableChildPOJO Created object. The method never returns null.
     */
    public MutableChildPOJO build( ) {
      return new MutableChildPOJO(this);
    }

    /**
     * Method creates a new validated instance of class MutableChildPOJO. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return MutableChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MutableChildPOJO buildValidated( ) throws ConstraintViolationException {
      MutableChildPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "writeable".
   * 
   * 
   * @return Integer Value to which the attribute "writeable" is set.
   */
  public Integer getWriteable( ) {
    return writeable;
  }

  /**
   * Method sets the attribute "writeable".
   * 
   * 
   * @param pWriteable Value to which the attribute "writeable" should be set.
   */
  public void setWriteable( Integer pWriteable ) {
    // Assign value to attribute
    writeable = pWriteable;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "writeable", "" + writeable));
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
