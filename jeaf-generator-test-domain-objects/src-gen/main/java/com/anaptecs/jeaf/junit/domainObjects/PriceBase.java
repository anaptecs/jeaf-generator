/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.checks.Check;

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

  @Deprecated
  private double price;

  @Deprecated
  private Reiseweg reiseweg;

  @Deprecated
  private Set<VerbindungspunktDO> verbindungspunkte;

  /**
   * Initialize object. Nothing special to do.
   */
  public PriceBase( ) {
    verbindungspunkte = new HashSet<VerbindungspunktDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public PriceBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    verbindungspunkte = new HashSet<VerbindungspunktDO>();
  }

  /**
   * Method returns attribute {@link #price}.<br/>
   *
   * @return double Value to which {@link #price} is set.
   */
  @Deprecated
  public double getPrice( ) {
    return price;
  }

  /**
   * Method sets attribute {@link #price}.<br/>
   *
   * @param pPrice Value to which {@link #price} should be set.
   */
  @Deprecated
  public void setPrice( double pPrice ) {
    // Assign value to attribute
    price = pPrice;
  }

  /**
   * Method returns association {@link #reiseweg}.<br/>
   *
   * @return {@link Reiseweg} Value to which {@link #reiseweg} is set.
   */
  @Deprecated
  public Reiseweg getReiseweg( ) {
    return reiseweg;
  }

  /**
   * Method sets association {@link #reiseweg}.<br/>
   *
   * @param pReiseweg Value to which {@link #reiseweg} should be set.
   */
  @Deprecated
  public void setReiseweg( Reiseweg pReiseweg ) {
    reiseweg = pReiseweg;
  }

  /**
   * Method unsets {@link #reiseweg}.
   */
  @Deprecated
  public final void unsetReiseweg( ) {
    reiseweg = null;
  }

  /**
   * Method returns association {@link #verbindungspunkte}.<br/>
   *
   * @return {@link Set<VerbindungspunktDO>} Value to which {@link #verbindungspunkte} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<VerbindungspunktDO> getVerbindungspunkte( ) {
    // Return all VerbindungspunktDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(verbindungspunkte);
  }

  /**
   * Method adds the passed object to {@link #verbindungspunkte}.
   *
   * @param pVerbindungspunkte Object that should be added to {@link #verbindungspunkte}. The parameter must not be
   * null.
   */
  @Deprecated
  public void addToVerbindungspunkte( VerbindungspunktDO pVerbindungspunkte ) {
    // Check parameter "pVerbindungspunkte" for invalid value null.
    Check.checkInvalidParameterNull(pVerbindungspunkte, "pVerbindungspunkte");
    // Add passed object to collection of associated VerbindungspunktDO objects.
    verbindungspunkte.add(pVerbindungspunkte);
  }

  /**
   * Method adds all passed objects to {@link #verbindungspunkte}.
   *
   * @param pVerbindungspunkte Collection with all objects that should be added to {@link #verbindungspunkte}. The
   * parameter must not be null.
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
   * Method removes the passed object from {@link #verbindungspunkte}.<br/>
   *
   * @param pVerbindungspunkte Object that should be removed from {@link #verbindungspunkte}. The parameter must not be
   * null.
   */
  @Deprecated
  public void removeFromVerbindungspunkte( VerbindungspunktDO pVerbindungspunkte ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pVerbindungspunkte, "pVerbindungspunkte");
    // Remove passed object from collection of associated VerbindungspunktDO objects.
    verbindungspunkte.remove(pVerbindungspunkte);
  }

  /**
   * Method removes all objects from {@link #verbindungspunkte}.
   */
  @Deprecated
  public void clearVerbindungspunkte( ) {
    // Remove all objects from association "verbindungspunkte".
    verbindungspunkte.clear();
  }

  /**
   */
  @Deprecated
  public abstract void recalculatePrice( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  public abstract String doSomething( int pParam1, @Deprecated int pParam2 );

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
    lBuilder.append("price: ");
    lBuilder.append(price);
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