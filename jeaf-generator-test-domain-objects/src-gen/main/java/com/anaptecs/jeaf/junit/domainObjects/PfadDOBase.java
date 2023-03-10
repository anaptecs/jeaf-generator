/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class PfadDOBase extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  private List<KanteDO> kantenSequenz;

  /**
   * Initialize object. Nothing special to do.
   */
  public PfadDOBase( ) {
    kantenSequenz = new ArrayList<KanteDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public PfadDOBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    kantenSequenz = new ArrayList<KanteDO>();
  }

  /**
   * Method returns association {@link #kantenSequenz}.<br/>
   * 
   * @return {@link List<KanteDO>} Value to which {@link #kantenSequenz} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<KanteDO> getKantenSequenz( ) {
    // Return all KanteDO objects as unmodifiable collection.
    return Collections.unmodifiableList(kantenSequenz);
  }

  /**
   * Method adds the passed KanteDO object to the association "kantenSequenz".
   * 
   * 
   * @param pKantenSequenz Object that should be added to the association "kantenSequenz". The parameter must not be
   * null.
   */
  public void addToKantenSequenz( KanteDO pKantenSequenz ) {
    // Check parameter "pKantenSequenz" for invalid value null.
    Check.checkInvalidParameterNull(pKantenSequenz, "pKantenSequenz");
    // Add passed object to collection of associated KanteDO objects.
    kantenSequenz.add(pKantenSequenz);
  }

  /**
   * Method adds all passed objects to the association "kantenSequenz".
   * 
   * 
   * @param pKantenSequenz Collection with all objects that should be added to the association "kantenSequenz". The
   * parameter must not be null.
   */
  public void addToKantenSequenz( Collection<KanteDO> pKantenSequenz ) {
    // Check parameter "pKantenSequenz" for invalid value null.
    Check.checkInvalidParameterNull(pKantenSequenz, "pKantenSequenz");
    // Add all passed objects.
    for (KanteDO lNextObject : pKantenSequenz) {
      this.addToKantenSequenz(lNextObject);
    }
  }

  /**
   * Method removes the passed KanteDO object from the association "kantenSequenz".
   * 
   * 
   * @param pKantenSequenz Object that should be removed from the association "kantenSequenz". The parameter must not be
   * null.
   */
  public void removeFromKantenSequenz( KanteDO pKantenSequenz ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pKantenSequenz, "pKantenSequenz");
    // Remove passed object from collection of associated KanteDO objects.
    kantenSequenz.remove(pKantenSequenz);
  }

  /**
   * Method removes all objects from the association "kantenSequenz".
   * 
   */
  public void clearKantenSequenz( ) {
    // Remove all objects from association "kantenSequenz".
    kantenSequenz.clear();
  }

  /**
   * @return {@link Reiseweg}
   */
  public abstract Reiseweg ermittleReiseweg( );

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
