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
public class KanteDO extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "abgang".
   */
  public static final String ABGANG = "abgang";

  /**
   * Constant for the name of attribute "bestimmung".
   */
  public static final String BESTIMMUNG = "bestimmung";

  /**
   * Constant for the name of attribute "verkehrsmittelTyp".
   */
  public static final String VERKEHRSMITTELTYP = "verkehrsmittelTyp";

  /**
   * Constant for the name of attribute "gerichtet".
   */
  public static final String GERICHTET = "gerichtet";

  /**
   * Constant for the name of attribute "netzbereiche".
   */
  public static final String NETZBEREICHE = "netzbereiche";

  /**
   * 
   */
  private VerbindungspunktDO abgang;

  /**
   * 
   */
  private VerbindungspunktDO bestimmung;

  /**
   * 
   */
  private VerkehrsmittelTyp verkehrsmittelTyp;

  /**
   * 
   */
  private Boolean gerichtet;

  /**
   * 
   */
  private Set<NetzbereichDO> netzbereiche = new HashSet<NetzbereichDO>();

  /**
   * Initialize object. Nothing special to do.
   */
  public KanteDO( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public KanteDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * Method returns the association "abgang".
   * 
   *
   * @return VerbindungspunktDO VerbindungspunktDO to which the association "abgang" is set.
   */
  public VerbindungspunktDO getAbgang( ) {
    return abgang;
  }

  /**
   * Method sets the association "abgang".
   * 
   * 
   * @param pAbgang VerbindungspunktDO to which the association "abgang" should be set.
   */
  public void setAbgang( VerbindungspunktDO pAbgang ) {
    abgang = pAbgang;
  }

  /**
   * Method unsets the association "abgang".
   * 
   */
  public final void unsetAbgang( ) {
    abgang = null;
  }

  /**
   * Method returns the association "bestimmung".
   * 
   *
   * @return VerbindungspunktDO VerbindungspunktDO to which the association "bestimmung" is set.
   */
  public VerbindungspunktDO getBestimmung( ) {
    return bestimmung;
  }

  /**
   * Method sets the association "bestimmung".
   * 
   * 
   * @param pBestimmung VerbindungspunktDO to which the association "bestimmung" should be set.
   */
  public void setBestimmung( VerbindungspunktDO pBestimmung ) {
    bestimmung = pBestimmung;
  }

  /**
   * Method unsets the association "bestimmung".
   * 
   */
  public final void unsetBestimmung( ) {
    bestimmung = null;
  }

  /**
   * Method returns the association "verkehrsmittelTyp".
   * 
   *
   * @return VerkehrsmittelTyp VerkehrsmittelTyp to which the association "verkehrsmittelTyp" is set.
   */
  public VerkehrsmittelTyp getVerkehrsmittelTyp( ) {
    return verkehrsmittelTyp;
  }

  /**
   * Method sets the association "verkehrsmittelTyp".
   * 
   * 
   * @param pVerkehrsmittelTyp VerkehrsmittelTyp to which the association "verkehrsmittelTyp" should be set.
   */
  public void setVerkehrsmittelTyp( VerkehrsmittelTyp pVerkehrsmittelTyp ) {
    verkehrsmittelTyp = pVerkehrsmittelTyp;
  }

  /**
   * Method unsets the association "verkehrsmittelTyp".
   * 
   */
  public final void unsetVerkehrsmittelTyp( ) {
    verkehrsmittelTyp = null;
  }

  /**
   * Method returns the attribute "gerichtet".
   * 
   * 
   * @return Boolean Value to which the attribute "gerichtet" is set.
   */
  public Boolean getGerichtet( ) {
    return gerichtet;
  }

  /**
   * Method sets the attribute "gerichtet".
   * 
   * 
   * @param pGerichtet Value to which the attribute "gerichtet" should be set.
   */
  public void setGerichtet( Boolean pGerichtet ) {
    // Assign value to attribute
    gerichtet = pGerichtet;
  }

  /**
   * Method returns the association "netzbereiche".
   * 
   *
   * @return Collection All NetzbereichDO objects that belong to the association "netzbereiche". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public Set<NetzbereichDO> getNetzbereiche( ) {
    // Return all NetzbereichDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(netzbereiche);
  }

  /**
   * Method sets the association "netzbereiche" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pNetzbereiche Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setNetzbereiche( Set<NetzbereichDO> pNetzbereiche ) {
    // Check of parameter is not required.
    // Remove all objects from association "netzbereiche".
    this.clearNetzbereiche();
    // If the association is null, removing all entries is sufficient.
    if (pNetzbereiche != null) {
      netzbereiche = new HashSet<NetzbereichDO>(pNetzbereiche);
    }
  }

  /**
   * Method adds the passed NetzbereichDO object to the association "netzbereiche".
   * 
   * 
   * @param pNetzbereiche Object that should be added to the association "netzbereiche". The parameter must not be null.
   */
  public void addToNetzbereiche( NetzbereichDO pNetzbereiche ) {
    // Check parameter "pNetzbereiche" for invalid value null.
    Check.checkInvalidParameterNull(pNetzbereiche, "pNetzbereiche");
    // Add passed object to collection of associated NetzbereichDO objects.
    netzbereiche.add(pNetzbereiche);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNetzbereiche != null && pNetzbereiche.getKanten().contains(this) == false) {
      pNetzbereiche.addToKanten((KanteDO) this);
    }
  }

  /**
   * Method adds all passed objects to the association "netzbereiche".
   * 
   * 
   * @param pNetzbereiche Collection with all objects that should be added to the association "netzbereiche". The
   * parameter must not be null.
   */
  public void addToNetzbereiche( Collection<NetzbereichDO> pNetzbereiche ) {
    // Check parameter "pNetzbereiche" for invalid value null.
    Check.checkInvalidParameterNull(pNetzbereiche, "pNetzbereiche");
    // Add all passed objects.
    for (NetzbereichDO lNextObject : pNetzbereiche) {
      this.addToNetzbereiche(lNextObject);
    }
  }

  /**
   * Method removes the passed NetzbereichDO object from the association "netzbereiche".
   * 
   * 
   * @param pNetzbereiche Object that should be removed from the association "netzbereiche". The parameter must not be
   * null.
   */
  public void removeFromNetzbereiche( NetzbereichDO pNetzbereiche ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pNetzbereiche, "pNetzbereiche");
    // Remove passed object from collection of associated NetzbereichDO objects.
    netzbereiche.remove(pNetzbereiche);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNetzbereiche.getKanten().contains(this) == true) {
      pNetzbereiche.removeFromKanten((KanteDO) this);
    }
  }

  /**
   * Method removes all objects from the association "netzbereiche".
   * 
   */
  public void clearNetzbereiche( ) {
    // Remove all objects from association "netzbereiche".
    Collection<NetzbereichDO> lNetzbereiche = new HashSet<NetzbereichDO>(netzbereiche);
    Iterator<NetzbereichDO> lIterator = lNetzbereiche.iterator();
    while (lIterator.hasNext()) {
      this.removeFromNetzbereiche(lIterator.next());
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "gerichtet", "" + gerichtet));
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
