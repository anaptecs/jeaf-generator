package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class BOneBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1008, BOneBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "BONEBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "bName".
   */
  public static final String BNAME_ROW = "BNAME";

  /**
   * Constant for the name of attribute "bName".
   */
  public static final String BNAME_ATTRIBUTE = "bName";

  /**
   * Constant for the name of role "a".
   */
  public static final String A_ROLE = "a";

  /**
   * 
   */
  private String bName;

  /**
   * 
   */
  private AOneBO a;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected BOneBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<BOneBO> findAllBOneBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(BOneBO.class);
  }

  /**
   * Method returns the attribute "bName".
   * 
   * 
   * @return String Value to which the attribute "bName" is set.
   */
  public String getBName( ) {
    return bName;
  }

  /**
   * Method sets the attribute "bName".
   * 
   * 
   * @param pBName Value to which the attribute "bName" should be set.
   */
  public void setBName( String pBName ) {
    // Assign value to attribute
    bName = pBName;
  }

  /**
   * Method returns the association "a".
   * 
   *
   * @return AOneBO AOneBO to which the association "a" is set.
   */
  public AOneBO getA( ) {
    a = this.unproxy(a);
    return a;
  }

  /**
   * Method sets the association "a".
   * 
   * 
   * @param pA AOneBO to which the association "a" should be set.
   */
  public void setA( AOneBO pA ) {
    // Release already referenced object before setting a new association.
    if (a != null) {
      a.unsetB();
    }
    a = pA;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA != null && this.equals(pA.getB()) == false) {
      pA.setB((BOneBO) this);
    }
  }

  /**
   * Method unsets the association "a".
   * 
   */
  public final void unsetA( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    AOneBO lAOneBO = a;
    a = null;
    if (lAOneBO != null && this.equals(lAOneBO.getB()) == true) {
      lAOneBO.unsetB();
    }
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
