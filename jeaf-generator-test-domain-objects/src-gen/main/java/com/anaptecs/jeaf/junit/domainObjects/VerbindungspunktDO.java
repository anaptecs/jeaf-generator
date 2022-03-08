/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.core.api.Identifiable;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private String bavName;

  /**
   * 
   */
  private SortedSet<UICCodeDO> uicCodes = new TreeSet<UICCodeDO>();

  /**
   * Initialize object. Nothing special to do.
   */
  public VerbindungspunktDO( ) {
    objectID = null;
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public VerbindungspunktDO( DomainObjectID pDomainObjectID ) {
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
   * Method returns the attribute "bavName".
   * 
   * 
   * @return String Value to which the attribute "bavName" is set.
   */
  public String getBavName( ) {
    return bavName;
  }

  /**
   * Method sets the attribute "bavName".
   * 
   * 
   * @param pBavName Value to which the attribute "bavName" should be set.
   */
  public void setBavName( String pBavName ) {
    // Assign value to attribute
    bavName = pBavName;
  }

  /**
   * Method returns the association "uicCodes".
   * 
   *
   * @return Collection All UICCodeDO objects that belong to the association "uicCodes". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public SortedSet<UICCodeDO> getUicCodes( ) {
    // Return all UICCodeDO objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(uicCodes);
  }

  /**
   * Method sets the association "uicCodes" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pUicCodes Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setUicCodes( SortedSet<UICCodeDO> pUicCodes ) {
    // Check of parameter is not required.
    // Remove all objects from association "uicCodes".
    this.clearUicCodes();
    // If the association is null, removing all entries is sufficient.
    if (pUicCodes != null) {
      uicCodes = new TreeSet<UICCodeDO>(pUicCodes);
    }
  }

  /**
   * Method adds the passed UICCodeDO object to the association "uicCodes".
   * 
   * 
   * @param pUicCodes Object that should be added to the association "uicCodes". The parameter must not be null.
   */
  public void addToUicCodes( UICCodeDO pUicCodes ) {
    // Check parameter "pUicCodes" for invalid value null.
    Check.checkInvalidParameterNull(pUicCodes, "pUicCodes");
    // Add passed object to collection of associated UICCodeDO objects.
    uicCodes.add(pUicCodes);
  }

  /**
   * Method adds all passed objects to the association "uicCodes".
   * 
   * 
   * @param pUicCodes Collection with all objects that should be added to the association "uicCodes". The parameter must
   * not be null.
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
    Collection<UICCodeDO> lUicCodes = new HashSet<UICCodeDO>(uicCodes);
    Iterator<UICCodeDO> lIterator = lUicCodes.iterator();
    while (lIterator.hasNext()) {
      this.removeFromUicCodes(lIterator.next());
    }
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bavName", "" + bavName));
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
