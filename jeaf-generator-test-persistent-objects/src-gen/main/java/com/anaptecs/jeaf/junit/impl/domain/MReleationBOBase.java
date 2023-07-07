package com.anaptecs.jeaf.junit.impl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class MReleationBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1003, MReleationBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "M_RELEATION";

  /**
   * Constant for the name of the row that is used to store the values of attribute "myNumber".
   */
  public static final String MYNUMBER_ROW = "MYNUMBER";

  /**
   * Constant for the name of attribute "myNumber".
   */
  public static final String MYNUMBER_ATTRIBUTE = "myNumber";

  /**
   * Constant for the name of role "ns".
   */
  public static final String NS_ROLE = "ns";

  private Set<NReleationBO> ns;

  private Integer myNumber;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected MReleationBOBase( ) {
    ns = new HashSet<NReleationBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<MReleationBO> findAllMReleationBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(MReleationBO.class);
  }

  /**
   * Method returns association {@link #ns}.<br/>
   *
   * @return {@link Set<NReleationBO>} Value to which {@link #ns} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public Set<NReleationBO> getNs( ) {
    // Return all NReleationBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(ns);
  }

  /**
   * Method adds the passed object to {@link #ns}.
   *
   * @param pNs Object that should be added to {@link #ns}. The parameter must not be null.
   */
  public void addToNs( NReleationBO pNs ) {
    // Check parameter "pNs" for invalid value null.
    Check.checkInvalidParameterNull(pNs, "pNs");
    // Add passed object to collection of associated NReleationBO objects.
    ns.add(pNs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNs != null && pNs.getMs().contains(this) == false) {
      pNs.addToMs((MReleationBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #ns}.
   *
   * @param pNs Collection with all objects that should be added to {@link #ns}. The parameter must not be null.
   */
  public void addToNs( Collection<NReleationBO> pNs ) {
    // Check parameter "pNs" for invalid value null.
    Check.checkInvalidParameterNull(pNs, "pNs");
    // Add all passed objects.
    for (NReleationBO lNextObject : pNs) {
      this.addToNs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #ns}.<br/>
   *
   * @param pNs Object that should be removed from {@link #ns}. The parameter must not be null.
   */
  public void removeFromNs( NReleationBO pNs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pNs, "pNs");
    // Remove passed object from collection of associated NReleationBO objects.
    ns.remove(pNs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNs.getMs().contains(this) == true) {
      pNs.removeFromMs((MReleationBO) this);
    }
  }

  /**
   * Method removes all objects from {@link #ns}.
   */
  public void clearNs( ) {
    // Remove all objects from association "ns".
    Collection<NReleationBO> lNs = new HashSet<NReleationBO>(ns);
    Iterator<NReleationBO> lIterator = lNs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromNs(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #myNumber}.<br/>
   *
   * @return {@link Integer} Value to which {@link #myNumber} is set.
   */
  public Integer getMyNumber( ) {
    return myNumber;
  }

  /**
   * Method sets attribute {@link #myNumber}.<br/>
   *
   * @param pMyNumber Value to which {@link #myNumber} should be set.
   */
  public void setMyNumber( Integer pMyNumber ) {
    // Assign value to attribute
    myNumber = pMyNumber;
  }

  /**
   * @return {@link NReleationBO}
   */
  public abstract NReleationBO getMySpecialN( );

  /**
   * @return char
   */
  public abstract char returnPrimitive( );

  /**
   * Method returns the class id of this business object class.
   *
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}
