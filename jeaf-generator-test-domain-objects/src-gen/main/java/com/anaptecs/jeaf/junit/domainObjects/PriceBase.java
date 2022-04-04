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
public abstract class PriceBase extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "price".
   */
  public static final String PRICE = "price";

  /**
   * Constant for the name of attribute "reiseweg".
   */
  public static final String REISEWEG = "reiseweg";

  /**
   * 
   */
  @Deprecated
  private double price;

  /**
   * 
   */
  @Deprecated
  private Reiseweg reiseweg;

  /**
   * 
   */
  @Deprecated
  private Set<VerbindungspunktDO> verbindungspunkte = new HashSet<VerbindungspunktDO>();

  /**
   * Initialize object. Nothing special to do.
   */
  public PriceBase( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public PriceBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * Method returns the attribute "price".
   * 
   * 
   * @return double Value to which the attribute "price" is set.
   */
  @Deprecated
  public double getPrice( ) {
    return price;
  }

  /**
   * Method sets the attribute "price".
   * 
   * 
   * @param pPrice Value to which the attribute "price" should be set.
   */
  @Deprecated
  public void setPrice( double pPrice ) {
    // Assign value to attribute
    price = pPrice;
  }

  /**
   * Method returns the association "reiseweg".
   * 
   *
   * @return Reiseweg Reiseweg to which the association "reiseweg" is set.
   */
  @Deprecated
  public Reiseweg getReiseweg( ) {
    return reiseweg;
  }

  /**
   * Method sets the association "reiseweg".
   * 
   * 
   * @param pReiseweg Reiseweg to which the association "reiseweg" should be set.
   */
  @Deprecated
  public void setReiseweg( Reiseweg pReiseweg ) {
    reiseweg = pReiseweg;
  }

  /**
   * Method unsets the association "reiseweg".
   * 
   */
  @Deprecated
  public final void unsetReiseweg( ) {
    reiseweg = null;
  }

  /**
   * Method returns the association "verbindungspunkte".
   * 
   *
   * @return Collection All VerbindungspunktDO objects that belong to the association "verbindungspunkte". The method
   * never returns null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<VerbindungspunktDO> getVerbindungspunkte( ) {
    // Return all VerbindungspunktDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(verbindungspunkte);
  }

  /**
   * Method sets the association "verbindungspunkte" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pVerbindungspunkte Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  @Deprecated
  void setVerbindungspunkte( Set<VerbindungspunktDO> pVerbindungspunkte ) {
    // Check of parameter is not required.
    // Remove all objects from association "verbindungspunkte".
    this.clearVerbindungspunkte();
    // If the association is null, removing all entries is sufficient.
    if (pVerbindungspunkte != null) {
      verbindungspunkte = new HashSet<VerbindungspunktDO>(pVerbindungspunkte);
    }
  }

  /**
   * Method adds the passed VerbindungspunktDO object to the association "verbindungspunkte".
   * 
   * 
   * @param pVerbindungspunkte Object that should be added to the association "verbindungspunkte". The parameter must
   * not be null.
   */
  @Deprecated
  public void addToVerbindungspunkte( VerbindungspunktDO pVerbindungspunkte ) {
    // Check parameter "pVerbindungspunkte" for invalid value null.
    Check.checkInvalidParameterNull(pVerbindungspunkte, "pVerbindungspunkte");
    // Add passed object to collection of associated VerbindungspunktDO objects.
    verbindungspunkte.add(pVerbindungspunkte);
  }

  /**
   * Method adds all passed objects to the association "verbindungspunkte".
   * 
   * 
   * @param pVerbindungspunkte Collection with all objects that should be added to the association "verbindungspunkte".
   * The parameter must not be null.
   */
  @Deprecated
  public void addToVerbindungspunkte( Collection<VerbindungspunktDO> pVerbindungspunkte ) {
    // Check parameter "pVerbindungspunkte" for invalid value null.
    Check.checkInvalidParameterNull(pVerbindungspunkte, "pVerbindungspunkte");
    // Add all passed objects.
    for (VerbindungspunktDO lNextObject : pVerbindungspunkte) {
      this.addToVerbindungspunkte(lNextObject);
    }
  }

  /**
   * Method removes the passed VerbindungspunktDO object from the association "verbindungspunkte".
   * 
   * 
   * @param pVerbindungspunkte Object that should be removed from the association "verbindungspunkte". The parameter
   * must not be null.
   */
  @Deprecated
  public void removeFromVerbindungspunkte( VerbindungspunktDO pVerbindungspunkte ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pVerbindungspunkte, "pVerbindungspunkte");
    // Remove passed object from collection of associated VerbindungspunktDO objects.
    verbindungspunkte.remove(pVerbindungspunkte);
  }

  /**
   * Method removes all objects from the association "verbindungspunkte".
   * 
   */
  @Deprecated
  public void clearVerbindungspunkte( ) {
    // Remove all objects from association "verbindungspunkte".
    Collection<VerbindungspunktDO> lVerbindungspunkte = new HashSet<VerbindungspunktDO>(verbindungspunkte);
    Iterator<VerbindungspunktDO> lIterator = lVerbindungspunkte.iterator();
    while (lIterator.hasNext()) {
      this.removeFromVerbindungspunkte(lIterator.next());
    }
  }

  /**
  * 
  */
  @Deprecated
  public abstract void recalculatePrice( );

  /**
   * 
   * @param pParam1
   * @param pParam2
   * @return {@link String}
   */
  @Deprecated
  public abstract String doSomething( int pParam1, @Deprecated int pParam2 );

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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "price", "" + price));
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
