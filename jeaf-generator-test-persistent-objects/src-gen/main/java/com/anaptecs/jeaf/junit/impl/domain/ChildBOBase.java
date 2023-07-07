package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class ChildBOBase extends BaseClassBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1001, ChildBO.class);

  /**
   * Constant for the name of the row that is used to store the values of attribute "childName".
   */
  public static final String CHILDNAME_ROW = "CHILDNAME";

  /**
   * Constant for the name of attribute "childName".
   */
  public static final String CHILDNAME_ATTRIBUTE = "childName";

  /**
   * Constant for the name of the row that is used to store the values of attribute "childNumber".
   */
  public static final String CHILDNUMBER_ROW = "CHILDNUMBER";

  /**
   * Constant for the name of attribute "childNumber".
   */
  public static final String CHILDNUMBER_ATTRIBUTE = "childNumber";

  private String childName;

  private Integer childNumber;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected ChildBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<ChildBO> findAllChildBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(ChildBO.class);
  }

  /**
   * Method returns attribute {@link #childName}.<br/>
   *
   * @return {@link String} Value to which {@link #childName} is set.
   */
  public String getChildName( ) {
    return childName;
  }

  /**
   * Method sets attribute {@link #childName}.<br/>
   *
   * @param pChildName Value to which {@link #childName} should be set.
   */
  public void setChildName( String pChildName ) {
    // Assign value to attribute
    childName = pChildName;
  }

  /**
   * Method returns attribute {@link #childNumber}.<br/>
   *
   * @return {@link Integer} Value to which {@link #childNumber} is set.
   */
  public Integer getChildNumber( ) {
    return childNumber;
  }

  /**
   * Method sets attribute {@link #childNumber}.<br/>
   *
   * @param pChildNumber Value to which {@link #childNumber} should be set.
   */
  public void setChildNumber( Integer pChildNumber ) {
    // Assign value to attribute
    childNumber = pChildNumber;
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
