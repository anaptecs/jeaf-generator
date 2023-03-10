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

public abstract class AOneBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1007, AOneBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "AONEBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "aName".
   */
  public static final String ANAME_ROW = "ANAME";

  /**
   * Constant for the name of attribute "aName".
   */
  public static final String ANAME_ATTRIBUTE = "aName";

  /**
   * Constant for the name of role "b".
   */
  public static final String B_ROLE = "b";

  /**
   * Constant for the name of role "cManys".
   */
  public static final String CMANYS_ROLE = "cManys";

  private String aName;

  private BOneBO b;

  private Set<CManyBO> cManys;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected AOneBOBase( ) {
    cManys = new HashSet<CManyBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<AOneBO> findAllAOneBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(AOneBO.class);
  }

  /**
   * Method returns attribute {@link #aName}.<br/>
   * 
   * @return {@link String} Value to which {@link #aName} is set.
   */
  public String getAName( ) {
    return aName;
  }

  /**
   * Method sets attribute {@link #aName}.<br/>
   * 
   * @param pAName Value to which {@link #aName} should be set.
   */
  public void setAName( String pAName ) {
    // Assign value to attribute
    aName = pAName;
  }

  /**
   * Method returns association {@link #b}.<br/>
   * 
   * @return {@link BOneBO} Value to which {@link #b} is set.
   */
  public BOneBO getB( ) {
    b = this.unproxy(b);
    return b;
  }

  /**
   * Method sets association {@link #b}.<br/>
   * 
   * @param pB Value to which {@link #b} should be set.
   */
  public void setB( BOneBO pB ) {
    // Release already referenced object before setting a new association.
    if (b != null) {
      b.unsetA();
    }
    b = pB;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pB != null && this.equals(pB.getA()) == false) {
      pB.setA((AOneBO) this);
    }
  }

  /**
   * Method unsets {@link #b}.
   */
  public final void unsetB( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BOneBO lBOneBO = b;
    b = null;
    if (lBOneBO != null && this.equals(lBOneBO.getA()) == true) {
      lBOneBO.unsetA();
    }
  }

  /**
   * Method returns association {@link #cManys}.<br/>
   * 
   * @return {@link Set<CManyBO>} Value to which {@link #cManys} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public Set<CManyBO> getCManys( ) {
    // Return all CManyBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(cManys);
  }

  /**
   * Method adds the passed object to {@link #cManys}.
   * 
   * @param pCManys Object that should be added to {@link #cManys}. The parameter must not be null.
   */
  public void addToCManys( CManyBO pCManys ) {
    // Check parameter "pCManys" for invalid value null.
    Check.checkInvalidParameterNull(pCManys, "pCManys");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pCManys.unsetAOne();
    // Add passed object to collection of associated CManyBO objects.
    cManys.add(pCManys);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCManys != null && this.equals(pCManys.getAOne()) == false) {
      pCManys.setAOne((AOneBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #cManys}.
   * 
   * @param pCManys Collection with all objects that should be added to {@link #cManys}. The parameter must not be null.
   */
  public void addToCManys( Collection<CManyBO> pCManys ) {
    // Check parameter "pCManys" for invalid value null.
    Check.checkInvalidParameterNull(pCManys, "pCManys");
    // Add all passed objects.
    for (CManyBO lNextObject : pCManys) {
      this.addToCManys(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #cManys}.<br/>
   * 
   * @param pCManys Object that should be removed from {@link #cManys}. The parameter must not be null.
   */
  public void removeFromCManys( CManyBO pCManys ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCManys, "pCManys");
    // Remove passed object from collection of associated CManyBO objects.
    cManys.remove(pCManys);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pCManys.getAOne()) == true) {
      pCManys.unsetAOne();
    }
  }

  /**
   * Method removes all objects from {@link #cManys}.
   */
  public void clearCManys( ) {
    // Remove all objects from association "cManys".
    Collection<CManyBO> lCManys = new HashSet<CManyBO>(cManys);
    Iterator<CManyBO> lIterator = lCManys.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromCManys(lIterator.next());
    }
  }

  /**
   * @return {@link Integer}
   */
  public abstract Integer countCMany( );

  /**
   * Method returns the class id of this business object class.
   * 
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}
