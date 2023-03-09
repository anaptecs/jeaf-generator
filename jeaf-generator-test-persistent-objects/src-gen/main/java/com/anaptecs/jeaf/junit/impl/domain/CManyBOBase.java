package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class CManyBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1009, CManyBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "C_MANY";

  /**
   * Constant for the name of the row that is used to store the values of attribute "cNumber".
   */
  public static final String CNUMBER_ROW = "CNUMBER";

  /**
   * Constant for the name of attribute "cNumber".
   */
  public static final String CNUMBER_ATTRIBUTE = "cNumber";

  /**
   * Constant for the name of role "aOne".
   */
  public static final String AONE_ROLE = "aOne";

  private Integer cNumber;

  private AOneBO aOne;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected CManyBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<CManyBO> findAllCManyBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(CManyBO.class);
  }

  /**
   * Method returns attribute {@link #cNumber}.<br/>
   * 
   * @return Integer Value to which {@link #cNumber} is set.
   */
  public Integer getCNumber( ) {
    return cNumber;
  }

  /**
   * Method sets attribute {@link #cNumber}.<br/>
   * 
   * @param pCNumber Value to which {@link #cNumber} should be set.
   */
  public void setCNumber( Integer pCNumber ) {
    // Assign value to attribute
    cNumber = pCNumber;
  }

  /**
   * Method returns the association "aOne".
   * 
   *
   * @return AOneBO AOneBO to which the association "aOne" is set.
   */
  public AOneBO getAOne( ) {
    aOne = this.unproxy(aOne);
    return aOne;
  }

  /**
   * Method sets the association "aOne".
   * 
   * 
   * @param pAOne AOneBO to which the association "aOne" should be set.
   */
  public void setAOne( AOneBO pAOne ) {
    // Release already referenced object before setting a new association.
    if (aOne != null) {
      aOne.removeFromCManys((CManyBO) this);
    }
    aOne = pAOne;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAOne != null && pAOne.getCManys().contains(this) == false) {
      pAOne.addToCManys((CManyBO) this);
    }
  }

  /**
   * Method unsets the association "aOne".
   * 
   */
  public final void unsetAOne( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    AOneBO lAOneBO = aOne;
    aOne = null;
    if (lAOneBO != null && lAOneBO.getCManys().contains(this) == true) {
      lAOneBO.removeFromCManys((CManyBO) this);
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
