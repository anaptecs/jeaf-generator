package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class GrandchildBOBase extends ChildBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1012, GrandchildBO.class);

  /**
   * Constant for the name of the row that is used to store the values of attribute "grandchildName".
   */
  public static final String GRANDCHILDNAME_ROW = "GRANDCHILDNAME";

  /**
   * Constant for the name of attribute "grandchildName".
   */
  public static final String GRANDCHILDNAME_ATTRIBUTE = "grandchildName";

  private String grandchildName;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected GrandchildBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<GrandchildBO> findAllGrandchildBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(GrandchildBO.class);
  }

  /**
   * Method returns the attribute "grandchildName".
   * 
   * 
   * @return String Value to which the attribute "grandchildName" is set.
   */
  public String getGrandchildName( ) {
    return grandchildName;
  }

  /**
   * Method sets the attribute "grandchildName".
   * 
   * 
   * @param pGrandchildName Value to which the attribute "grandchildName" should be set.
   */
  public void setGrandchildName( String pGrandchildName ) {
    // Assign value to attribute
    grandchildName = pGrandchildName;
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
