/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.accounting.validation.MyEnum;
import com.anaptecs.jeaf.accounting.validation.MyGeneratedCustomConstraint;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.Severity.Warning;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@MyGeneratedCustomConstraint(myEnum = MyEnum.WORLD, message = "4711", payload = Warning.class)
public class Bank implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * <br/>
   * <b>Default Value:</b> <code>1</code>
   */
  public static final short MUTUAL_SAVINGS = 1;

  /**
   * <br/>
   * <b>Default Value:</b> <code>2</code>
   */
  public static final short PRIVATE_BANK = 2;

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private Long code;

  /**
   * 
   */
  private BankType type;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Bank( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Bank( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    name = pBuilder.name;
    code = pBuilder.code;
    type = pBuilder.type;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Bank objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Bank objects. The method never returns null.
   */
  public static Builder builder( Bank pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Bank. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long code;

    /**
     * 
     */
    private BankType type;

    /**
     * Use {@link Bank#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Bank#builder(Bank)} instead of private constructor to create new builder.
     */
    protected Builder( Bank pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        name = pObject.name;
        code = pObject.code;
        type = pObject.type;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "code".
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( Long pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets the attribute "type".
     * 
     * @param pType Value to which the attribute "type" should be set.
     */
    public Builder setType( BankType pType ) {
      // Assign value to attribute
      type = pType;
      return this;
    }

    /**
     * Method creates a new instance of class Bank. The object will be initialized with the values of the builder.
     * 
     * @return Bank Created object. The method never returns null.
     */
    public Bank build( ) {
      return new Bank(this);
    }

    /**
     * Method creates a new validated instance of class Bank. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Bank Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Bank buildValidated( ) throws ConstraintViolationException {
      Bank lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return Long Value to which the attribute "code" is set.
   */
  public Long getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code".
   * 
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( Long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns the attribute "type".
   * 
   * 
   * @return BankType Value to which the attribute "type" is set.
   */
  public BankType getType( ) {
    return type;
  }

  /**
   * Method sets the attribute "type".
   * 
   * 
   * @param pType Value to which the attribute "type" should be set.
   */
  public void setType( BankType pType ) {
    // Assign value to attribute
    type = pType;
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
    lBuilder.append("MUTUAL_SAVINGS: ");
    lBuilder.append(MUTUAL_SAVINGS);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("PRIVATE_BANK: ");
    lBuilder.append(PRIVATE_BANK);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("type: ");
    lBuilder.append(type);
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
