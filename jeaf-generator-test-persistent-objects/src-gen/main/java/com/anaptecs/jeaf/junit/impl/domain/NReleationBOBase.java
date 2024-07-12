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

public abstract class NReleationBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1002, NReleationBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "N_RELATION";

  /**
   * Constant for the name of the row that is used to store the values of attribute "myString".
   */
  public static final String MYSTRING_ROW = "MYSTRING";

  /**
   * Constant for the name of attribute "myString".
   */
  public static final String MYSTRING_ATTRIBUTE = "myString";

  /**
   * Constant for the name of role "ms".
   */
  public static final String MS_ROLE = "ms";

  private Set<MReleationBO> ms;

  private String myString;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected NReleationBOBase( ) {
    ms = new HashSet<MReleationBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<NReleationBO> findAllNReleationBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(NReleationBO.class);
  }

  /**
   * Method returns association {@link #ms}.<br/>
   *
   * @return {@link Set<MReleationBO>} Value to which {@link #ms} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public Set<MReleationBO> getMs( ) {
    // Return all MReleationBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(ms);
  }

  /**
   * Method adds the passed object to {@link #ms}.
   *
   * @param pMs Object that should be added to {@link #ms}. The parameter must not be null.
   */
  public void addToMs( MReleationBO pMs ) {
    // Check parameter "pMs" for invalid value null.
    Check.checkInvalidParameterNull(pMs, "pMs");
    // Add passed object to collection of associated MReleationBO objects.
    ms.add(pMs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pMs != null && pMs.getNs().contains(this) == false) {
      pMs.addToNs((NReleationBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #ms}.
   *
   * @param pMs Collection with all objects that should be added to {@link #ms}. The parameter must not be null.
   */
  public void addToMs( Collection<MReleationBO> pMs ) {
    // Check parameter "pMs" for invalid value null.
    Check.checkInvalidParameterNull(pMs, "pMs");
    // Add all passed objects.
    for (MReleationBO lNextObject : pMs) {
      this.addToMs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #ms}.<br/>
   *
   * @param pMs Object that should be removed from {@link #ms}. The parameter must not be null.
   */
  public void removeFromMs( MReleationBO pMs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMs, "pMs");
    // Remove passed object from collection of associated MReleationBO objects.
    ms.remove(pMs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pMs.getNs().contains(this) == true) {
      pMs.removeFromNs((NReleationBO) this);
    }
  }

  /**
   * Method removes all objects from {@link #ms}.
   */
  public void clearMs( ) {
    // Remove all objects from association "ms".
    Collection<MReleationBO> lMs = new HashSet<MReleationBO>(ms);
    Iterator<MReleationBO> lIterator = lMs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromMs(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #myString}.<br/>
   *
   * @return {@link String} Value to which {@link #myString} is set.
   */
  public String getMyString( ) {
    return myString;
  }

  /**
   * Method sets attribute {@link #myString}.<br/>
   *
   * @param pMyString Value to which {@link #myString} should be set.
   */
  public void setMyString( String pMyString ) {
    // Assign value to attribute
    myString = pMyString;
  }

  /**
   * Method returns the class id of this business object class.
   *
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}