/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectID;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "objectID", generator = PropertyGenerator.class)
public class POJOWithID implements Identifiable<ObjectID> {
  /**
   * Constant for the name of attribute "attr".
   */
  public static final String ATTR = "attr";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ObjectID objectID;

  private Double attr;

  private String name;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POJOWithID( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POJOWithID( Builder pBuilder ) {
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
    name = pBuilder.name;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new POJOWithID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new POJOWithID objects. The method never returns
   * null.
   */
  public static Builder builder( POJOWithID pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class POJOWithID. As the class has read only attributes or
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
    private Double attr;

    /**
     * 
     */
    private String name;

    /**
     * Use {@link POJOWithID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link POJOWithID#builder(POJOWithID)} instead of private constructor to create new builder.
     */
    protected Builder( POJOWithID pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        attr = pObject.attr;
        name = pObject.name;
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
     * Method sets the attribute "attr".
     * 
     * @param pAttr Value to which the attribute "attr" should be set.
     */
    public Builder setAttr( Double pAttr ) {
      // Assign value to attribute
      attr = pAttr;
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
     * Method creates a new instance of class POJOWithID. The object will be initialized with the values of the builder.
     * 
     * @return POJOWithID Created object. The method never returns null.
     */
    public POJOWithID build( ) {
      return new POJOWithID(this);
    }

    /**
     * Method creates a new validated instance of class POJOWithID. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return POJOWithID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public POJOWithID buildValidated( ) throws ConstraintViolationException {
      POJOWithID lPOJO = this.build();
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
   * @return Double Value to which {@link #attr} is set.
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
   * Method returns attribute {@link #name}.<br/>
   * 
   * @return String Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   * 
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
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
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
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
