/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public abstract class IdentifiableServiceObjectWithMethodBase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  private Integer hello;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected IdentifiableServiceObjectWithMethodBase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IdentifiableServiceObjectWithMethodBase( BuilderBase pBuilder ) {
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
    hello = pBuilder.hello;
  }

  /**
   * Class implements builder to create a new instance of class IdentifiableServiceObjectWithMethod. As the class has
   * read only attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    private Integer hello;

    /**
     * Use {@link IdentifiableServiceObjectWithMethod.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link IdentifiableServiceObjectWithMethod.builder(IdentifiableServiceObjectWithMethod)} instead of protected
     * constructor to create new builder.
     */
    protected BuilderBase( IdentifiableServiceObjectWithMethodBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setHello(pObject.hello);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets attribute {@link #hello}.<br/>
     *
     * @param pHello Value to which {@link #hello} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setHello( Integer pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method creates a new instance of class IdentifiableServiceObjectWithMethod. The object will be initialized with
     * the values of the builder.
     *
     * @return IdentifiableServiceObjectWithMethod Created object. The method never returns null.
     */
    public IdentifiableServiceObjectWithMethod build( ) {
      IdentifiableServiceObjectWithMethod lObject = new IdentifiableServiceObjectWithMethod(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class IdentifiableServiceObjectWithMethod. The object will be
     * initialized with the values of the builder and validated afterwards.
     *
     * @return IdentifiableServiceObjectWithMethod Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public IdentifiableServiceObjectWithMethod buildValidated( ) throws ConstraintViolationException {
      IdentifiableServiceObjectWithMethod lPOJO = this.build();
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
   * Method returns attribute {@link #hello}.<br/>
   *
   * @return {@link Integer} Value to which {@link #hello} is set.
   */
  public Integer getHello( ) {
    return hello;
  }

  /**
   * Method sets attribute {@link #hello}.<br/>
   *
   * @param pHello Value to which {@link #hello} should be set.
   */
  public void setHello( Integer pHello ) {
    // Assign value to attribute
    hello = pHello;
  }

  /**
   * Convenience method to create new instance of class IdentifiableServiceObjectWithMethod.
   *
   *
   * @param pHello Value to which {@link #hello} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.core.IdentifiableServiceObjectWithMethod}
   */
  public static IdentifiableServiceObjectWithMethod of( Integer pHello ) {
    IdentifiableServiceObjectWithMethod.Builder lBuilder = IdentifiableServiceObjectWithMethod.builder();
    lBuilder.setHello(pHello);
    return lBuilder.build();
  }

  /**
   */
  public abstract void doSomething( );

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
    lBuilder.append("hello: ");
    lBuilder.append(hello);
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
   * @return {@link Builder} New builder that can be used to create new IdentifiableServiceObjectWithMethod objects. The
   * method never returns null.
   */
  public IdentifiableServiceObjectWithMethod.Builder toBuilder( ) {
    return new IdentifiableServiceObjectWithMethod.Builder((IdentifiableServiceObjectWithMethod) this);
  }
}