/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectID;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "objectID", generator = ObjectIdGenerators.PropertyGenerator.class)
public abstract class POJOWithIDnMethodBase implements Identifiable<ObjectID> {
  /**
   * Constant for the name of attribute "attr".
   */
  public static final String ATTR = "attr";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ObjectID objectID;

  private Double attr;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POJOWithIDnMethodBase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POJOWithIDnMethodBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    attr = pBuilder.attr;
  }

  /**
   * Class implements builder to create a new instance of class POJOWithIDnMethod. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    private Double attr;

    /**
     * Use {@link POJOWithIDnMethod.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link POJOWithIDnMethod.builder(POJOWithIDnMethod)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( POJOWithIDnMethodBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setAttr(pObject.attr);
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
     * Method sets attribute {@link #attr}.<br/>
     *
     * @param pAttr Value to which {@link #attr} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setAttr( Double pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    /**
     * Method creates a new instance of class POJOWithIDnMethod. The object will be initialized with the values of the
     * builder.
     *
     * @return POJOWithIDnMethod Created object. The method never returns null.
     */
    public POJOWithIDnMethod build( ) {
      return new POJOWithIDnMethod(this);
    }

    /**
     * Method creates a new validated instance of class POJOWithIDnMethod. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return POJOWithIDnMethod Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public POJOWithIDnMethod buildValidated( ) throws ConstraintViolationException {
      POJOWithIDnMethod lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ObjectID} ID of this object. Since an object must not have an id the method may also return null.
   */
  @Override
  public final ObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ObjectID} ID of this object. Since an object must not have an id the method may also return null.
   */
  @Override
  public final ObjectID getUnversionedID( ) {
    ObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns attribute {@link #attr}.<br/>
   *
   * @return {@link Double} Value to which {@link #attr} is set.
   */
  public Double getAttr( ) {
    return attr;
  }

  /**
   * Method sets attribute {@link #attr}.<br/>
   *
   * @param pAttr Value to which {@link #attr} should be set.
   */
  public void setAttr( Double pAttr ) {
    // Assign value to attribute
    attr = pAttr;
  }

  /**
   * Convenience method to create new instance of class POJOWithIDnMethod.
   *
   *
   * @param pAttr Value to which {@link #attr} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.pojo.POJOWithIDnMethod}
   */
  public static POJOWithIDnMethod of( Double pAttr ) {
    POJOWithIDnMethod.Builder lBuilder = POJOWithIDnMethod.builder();
    lBuilder.setAttr(pAttr);
    return lBuilder.build();
  }

  /**
   * @return boolean
   */
  public abstract boolean doSomethingFunny( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(attr);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      POJOWithIDnMethodBase lOther = (POJOWithIDnMethodBase) pObject;
      lEquals = Objects.equals(attr, lOther.attr);
    }
    return lEquals;
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
    lBuilder.append("attr: ");
    lBuilder.append(attr);
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
   * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects. The method never
   * returns null.
   */
  public POJOWithIDnMethod.Builder toBuilder( ) {
    return new POJOWithIDnMethod.Builder((POJOWithIDnMethod) this);
  }
}