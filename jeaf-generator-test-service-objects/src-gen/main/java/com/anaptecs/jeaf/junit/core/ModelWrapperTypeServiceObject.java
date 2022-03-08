/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ModelWrapperTypeServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "aInt".
   */
  public static final String AINT = "aInt";

  /**
   * 
   */
  private boolean aBoolean;

  /**
   * 
   */
  private Integer aInt;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ModelWrapperTypeServiceObject( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ModelWrapperTypeServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    aInt = pBuilder.aInt;
  }

  /**
   * Class implements builder to create a new instance of class ModelWrapperTypeServiceObject. As the class has read
   * only attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean aBoolean;

    /**
     * 
     */
    private Integer aInt;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ModelWrapperTypeServiceObject)} instead of private constructor to create new builder.
     */
    protected Builder( ModelWrapperTypeServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        aBoolean = pObject.aBoolean;
        aInt = pObject.aInt;
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
     * @return {@link Builder} New builder that can be used to create new ModelWrapperTypeServiceObject objects. The
     * method never returns null.
     */
    public static Builder newBuilder( ModelWrapperTypeServiceObject pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "aBoolean".
     * 
     * @param pABoolean Value to which the attribute "aBoolean" should be set.
     */
    public Builder setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets the attribute "aInt".
     * 
     * @param pAInt Value to which the attribute "aInt" should be set.
     */
    public Builder setAInt( Integer pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
      return this;
    }

    /**
     * Method creates a new instance of class ModelWrapperTypeServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @return ModelWrapperTypeServiceObject Created object. The method never returns null.
     */
    public ModelWrapperTypeServiceObject build( ) {
      return new ModelWrapperTypeServiceObject(this);
    }

    /**
     * Method creates a new instance of class ModelWrapperTypeServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ModelWrapperTypeServiceObject Created object. The method never returns null.
     */
    public ModelWrapperTypeServiceObject build( boolean pValidate ) {
      ModelWrapperTypeServiceObject lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "aBoolean".
   * 
   * 
   * @return Boolean Value to which the attribute "aBoolean" is set.
   */
  public boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets the attribute "aBoolean".
   * 
   * 
   * @param pABoolean Value to which the attribute "aBoolean" should be set.
   */
  public void setABoolean( boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  /**
   * Method returns the attribute "aInt".
   * 
   * 
   * @return Integer Value to which the attribute "aInt" is set.
   */
  public Integer getAInt( ) {
    return aInt;
  }

  /**
   * Method sets the attribute "aInt".
   * 
   * 
   * @param pAInt Value to which the attribute "aInt" should be set.
   */
  public void setAInt( Integer pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aBoolean", "" + aBoolean));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "aInt", "" + aInt));
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