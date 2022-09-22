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
import java.util.Set;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class NetzbereichDOBase extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  private Set<KanteDO> kanten;

  /**
   * Initialize object. Nothing special to do.
   */
  public NetzbereichDOBase( ) {
    // Nothing to do.
    kanten = new HashSet<KanteDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public NetzbereichDOBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    kanten = new HashSet<KanteDO>();
  }

  /**
   * Method returns the association "kanten".
   * 
   *
   * @return Collection All KanteDO objects that belong to the association "kanten". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<KanteDO> getKanten( ) {
    // Return all KanteDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(kanten);
  }

  /**
   * Method adds the passed KanteDO object to the association "kanten".
   * 
   * 
   * @param pKanten Object that should be added to the association "kanten". The parameter must not be null.
   */
  public void addToKanten( KanteDO pKanten ) {
    // Check parameter "pKanten" for invalid value null.
    Check.checkInvalidParameterNull(pKanten, "pKanten");
    // Add passed object to collection of associated KanteDO objects.
    kanten.add(pKanten);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pKanten != null && pKanten.getNetzbereiche().contains(this) == false) {
      pKanten.addToNetzbereiche((NetzbereichDO) this);
    }
  }

  /**
   * Method adds all passed objects to the association "kanten".
   * 
   * 
   * @param pKanten Collection with all objects that should be added to the association "kanten". The parameter must not
   * be null.
   */
  public void addToKanten( Collection<KanteDO> pKanten ) {
    // Check parameter "pKanten" for invalid value null.
    Check.checkInvalidParameterNull(pKanten, "pKanten");
    // Add all passed objects.
    for (KanteDO lNextObject : pKanten) {
      this.addToKanten(lNextObject);
    }
  }

  /**
   * Method removes the passed KanteDO object from the association "kanten".
   * 
   * 
   * @param pKanten Object that should be removed from the association "kanten". The parameter must not be null.
   */
  public void removeFromKanten( KanteDO pKanten ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pKanten, "pKanten");
    // Remove passed object from collection of associated KanteDO objects.
    kanten.remove(pKanten);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pKanten.getNetzbereiche().contains(this) == true) {
      pKanten.removeFromNetzbereiche((NetzbereichDO) this);
    }
  }

  /**
   * Method removes all objects from the association "kanten".
   * 
   */
  public void clearKanten( ) {
    // Remove all objects from association "kanten".
    Collection<KanteDO> lKanten = new HashSet<KanteDO>(kanten);
    Iterator<KanteDO> lIterator = lKanten.iterator();
    while (lIterator.hasNext()) {
      this.removeFromKanten(lIterator.next());
    }
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
