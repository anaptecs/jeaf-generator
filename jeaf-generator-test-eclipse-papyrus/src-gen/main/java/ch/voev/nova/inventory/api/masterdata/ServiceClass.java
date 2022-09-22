/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class of service.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ServiceClass {
  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * 
   */
  private ServiceClassType type;

  /**
   * The name the carrier itself uses to designate this specific service class.
   */
  private String name;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ServiceClass( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ServiceClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    type = pBuilder.type;
    name = pBuilder.name;
  }

  /**
   * Class implements builder to create a new instance of class ServiceClass. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ServiceClassType type;

    /**
     * The name the carrier itself uses to designate this specific service class.
     */
    private String name;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ServiceClass)} instead of private constructor to create new builder.
     */
    protected Builder( ServiceClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        type = pObject.type;
        name = pObject.name;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ServiceClass objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ServiceClass objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ServiceClass pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "type".
     * 
     * @param pType ServiceClassType to which the association "type" should be set.
     */
    public Builder setType( ServiceClassType pType ) {
      type = pType;
      return this;
    }

    /**
     * Method sets the attribute "name". The name the carrier itself uses to designate this specific service class.
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method creates a new instance of class ServiceClass. The object will be initialized with the values of the
     * builder.
     * 
     * @return ServiceClass Created object. The method never returns null.
     */
    public ServiceClass build( ) {
      return new ServiceClass(this);
    }

    /**
     * Method creates a new validated instance of class ServiceClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ServiceClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ServiceClass buildValidated( ) throws ConstraintViolationException {
      ServiceClass lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "type".
   * 
   *
   * @return ServiceClassType ServiceClassType to which the association "type" is set.
   */
  public ServiceClassType getType( ) {
    return type;
  }

  /**
   * Method sets the association "type".
   * 
   * 
   * @param pType ServiceClassType to which the association "type" should be set.
   */
  public void setType( ServiceClassType pType ) {
    type = pType;
  }

  /**
   * Method unsets the association "type".
   * 
   */
  public final void unsetType( ) {
    type = null;
  }

  /**
   * Method returns the attribute "name". The name the carrier itself uses to designate this specific service class.
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name". The name the carrier itself uses to designate this specific service class.
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
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
