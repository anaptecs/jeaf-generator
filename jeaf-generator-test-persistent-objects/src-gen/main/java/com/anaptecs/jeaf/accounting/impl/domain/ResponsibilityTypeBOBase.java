package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class ResponsibilityTypeBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1109, ResponsibilityTypeBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "RESPONSIBILITYTYPEBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "type".
   */
  public static final String TYPE_ROW = "TYPE";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE_ATTRIBUTE = "type";

  /**
   * Constant for the name of the row that is used to store the values of attribute "typeChar".
   */
  public static final String TYPECHAR_ROW = "TYPECHAR";

  /**
   * Constant for the name of attribute "typeChar".
   */
  public static final String TYPECHAR_ATTRIBUTE = "typeChar";

  /**
   * Constant for the name of the row that is used to store the values of attribute "sortorder".
   */
  public static final String SORTORDER_ROW = "SORTORDER";

  /**
   * Constant for the name of attribute "sortorder".
   */
  public static final String SORTORDER_ATTRIBUTE = "sortorder";

  private String type;

  private Character typeChar;

  private Byte sortorder;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected ResponsibilityTypeBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<ResponsibilityTypeBO> findAllResponsibilityTypeBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(ResponsibilityTypeBO.class);
  }

  /**
   * Method returns the attribute "type".
   * 
   * 
   * @return String Value to which the attribute "type" is set.
   */
  public String getType( ) {
    return type;
  }

  /**
   * Method sets the attribute "type".
   * 
   * 
   * @param pType Value to which the attribute "type" should be set.
   */
  public void setType( String pType ) {
    // Assign value to attribute
    type = pType;
  }

  /**
   * Method returns the attribute "typeChar".
   * 
   * 
   * @return Character Value to which the attribute "typeChar" is set.
   */
  public Character getTypeChar( ) {
    return typeChar;
  }

  /**
   * Method sets the attribute "typeChar".
   * 
   * 
   * @param pTypeChar Value to which the attribute "typeChar" should be set.
   */
  public void setTypeChar( Character pTypeChar ) {
    // Assign value to attribute
    typeChar = pTypeChar;
  }

  /**
   * Method returns the attribute "sortorder".
   * 
   * 
   * @return Byte Value to which the attribute "sortorder" is set.
   */
  public Byte getSortorder( ) {
    return sortorder;
  }

  /**
   * Method sets the attribute "sortorder".
   * 
   * 
   * @param pSortorder Value to which the attribute "sortorder" should be set.
   */
  public void setSortorder( Byte pSortorder ) {
    // Assign value to attribute
    sortorder = pSortorder;
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
