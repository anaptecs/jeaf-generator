/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class ResponsibilityType implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "typeChar".
   */
  public static final String TYPECHAR = "typeChar";

  /**
   * Constant for the name of attribute "sortorder".
   */
  public static final String SORTORDER = "sortorder";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  private String type;

  private Character typeChar;

  private Byte sortorder;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ResponsibilityType( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ResponsibilityType( Builder pBuilder ) {
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
    type = pBuilder.type;
    typeChar = pBuilder.typeChar;
    sortorder = pBuilder.sortorder;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ResponsibilityType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ResponsibilityType objects. The method never
   * returns null.
   */
  public static Builder builder( ResponsibilityType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>ResponsibilityType</code>.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    private String type;

    private Character typeChar;

    private Byte sortorder;

    /**
     * Use {@link ResponsibilityType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ResponsibilityType#builder(ResponsibilityType)} instead of private constructor to create new builder.
     */
    protected Builder( ResponsibilityType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        type = pObject.type;
        typeChar = pObject.typeChar;
        sortorder = pObject.sortorder;
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
     * Method sets attribute {@link #type}.<br/>
     *
     * @param pType Value to which {@link #type} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setType( String pType ) {
      // Assign value to attribute
      type = pType;
      return this;
    }

    /**
     * Method sets attribute {@link #typeChar}.<br/>
     *
     * @param pTypeChar Value to which {@link #typeChar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTypeChar( Character pTypeChar ) {
      // Assign value to attribute
      typeChar = pTypeChar;
      return this;
    }

    /**
     * Method sets attribute {@link #sortorder}.<br/>
     *
     * @param pSortorder Value to which {@link #sortorder} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSortorder( Byte pSortorder ) {
      // Assign value to attribute
      sortorder = pSortorder;
      return this;
    }

    /**
     * Method creates a new instance of class ResponsibilityType. The object will be initialized with the values of the
     * builder.
     *
     * @return ResponsibilityType Created object. The method never returns null.
     */
    public ResponsibilityType build( ) {
      return new ResponsibilityType(this);
    }

    /**
     * Method creates a new validated instance of class ResponsibilityType. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ResponsibilityType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ResponsibilityType buildValidated( ) throws ConstraintViolationException {
      ResponsibilityType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * Method returns attribute {@link #type}.<br/>
   *
   * @return {@link String} Value to which {@link #type} is set.
   */
  public String getType( ) {
    return type;
  }

  /**
   * Method sets attribute {@link #type}.<br/>
   *
   * @param pType Value to which {@link #type} should be set.
   */
  public void setType( String pType ) {
    // Assign value to attribute
    type = pType;
  }

  /**
   * Method returns attribute {@link #typeChar}.<br/>
   *
   * @return {@link Character} Value to which {@link #typeChar} is set.
   */
  public Character getTypeChar( ) {
    return typeChar;
  }

  /**
   * Method sets attribute {@link #typeChar}.<br/>
   *
   * @param pTypeChar Value to which {@link #typeChar} should be set.
   */
  public void setTypeChar( Character pTypeChar ) {
    // Assign value to attribute
    typeChar = pTypeChar;
  }

  /**
   * Method returns attribute {@link #sortorder}.<br/>
   *
   * @return {@link Byte} Value to which {@link #sortorder} is set.
   */
  public Byte getSortorder( ) {
    return sortorder;
  }

  /**
   * Method sets attribute {@link #sortorder}.<br/>
   *
   * @param pSortorder Value to which {@link #sortorder} should be set.
   */
  public void setSortorder( Byte pSortorder ) {
    // Assign value to attribute
    sortorder = pSortorder;
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
    lBuilder.append("type: ");
    lBuilder.append(type);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("typeChar: ");
    lBuilder.append(typeChar);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sortorder: ");
    lBuilder.append(sortorder);
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
