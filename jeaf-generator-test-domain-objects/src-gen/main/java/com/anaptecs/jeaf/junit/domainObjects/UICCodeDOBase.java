/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;

public abstract class UICCodeDOBase extends DomainObject implements Identifiable<DomainObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final DomainObjectID objectID;

  private Integer code;

  /**
   * Initialize object. Nothing special to do.
   */
  public UICCodeDOBase( ) {
    objectID = null;
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public UICCodeDOBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    objectID = null;
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link DomainObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final DomainObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link DomainObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final DomainObjectID getUnversionedID( ) {
    DomainObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link Integer} Value to which {@link #code} is set.
   */
  public Integer getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( Integer pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * @return {@link String}
   */
  public abstract String getCountry( );

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
    lBuilder.append("code: ");
    lBuilder.append(code);
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
