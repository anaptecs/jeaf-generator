/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;

public class VerbindungspunktDO extends DomainObject implements Identifiable<DomainObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "bavName".
   */
  public static final String BAVNAME = "bavName";

  /**
   * Constant for the name of attribute "uicCodes".
   */
  public static final String UICCODES = "uicCodes";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final DomainObjectID objectID;

  private String bavName;

  private SortedSet<UICCodeDO> uicCodes;

  /**
   * Initialize object. Nothing special to do.
   */
  public VerbindungspunktDO( ) {
    objectID = null;
    uicCodes = new TreeSet<UICCodeDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public VerbindungspunktDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    objectID = null;
    uicCodes = new TreeSet<UICCodeDO>();
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
   * Method returns attribute {@link #bavName}.<br/>
   * 
   * @return {@link String} Value to which {@link #bavName} is set.
   */
  public String getBavName( ) {
    return bavName;
  }

  /**
   * Method sets attribute {@link #bavName}.<br/>
   * 
   * @param pBavName Value to which {@link #bavName} should be set.
   */
  public void setBavName( String pBavName ) {
    // Assign value to attribute
    bavName = pBavName;
  }

  /**
   * Method returns association {@link #uicCodes}.<br/>
   * 
   * @return {@link SortedSet<UICCodeDO>} Value to which {@link #uicCodes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public SortedSet<UICCodeDO> getUicCodes( ) {
    // Return all UICCodeDO objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(uicCodes);
  }

  /**
   * Method adds the passed object to {@link #uicCodes}.
   * 
   * @param pUicCodes Object that should be added to {@link #uicCodes}. The parameter must not be null.
   */
  public void addToUicCodes( UICCodeDO pUicCodes ) {
    // Check parameter "pUicCodes" for invalid value null.
    Check.checkInvalidParameterNull(pUicCodes, "pUicCodes");
    // Add passed object to collection of associated UICCodeDO objects.
    uicCodes.add(pUicCodes);
  }

  /**
   * Method adds all passed objects to {@link #uicCodes}.
   * 
   * @param pUicCodes Collection with all objects that should be added to {@link #uicCodes}. The parameter must not be
   * null.
   */
  public void addToUicCodes( Collection<UICCodeDO> pUicCodes ) {
    // Check parameter "pUicCodes" for invalid value null.
    Check.checkInvalidParameterNull(pUicCodes, "pUicCodes");
    // Add all passed objects.
    for (UICCodeDO lNextObject : pUicCodes) {
      this.addToUicCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed UICCodeDO object from the association "uicCodes".
   * 
   * 
   * @param pUicCodes Object that should be removed from the association "uicCodes". The parameter must not be null.
   */
  public void removeFromUicCodes( UICCodeDO pUicCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pUicCodes, "pUicCodes");
    // Remove passed object from collection of associated UICCodeDO objects.
    uicCodes.remove(pUicCodes);
  }

  /**
   * Method removes all objects from the association "uicCodes".
   * 
   */
  public void clearUicCodes( ) {
    // Remove all objects from association "uicCodes".
    uicCodes.clear();
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
    lBuilder.append("bavName: ");
    lBuilder.append(bavName);
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
