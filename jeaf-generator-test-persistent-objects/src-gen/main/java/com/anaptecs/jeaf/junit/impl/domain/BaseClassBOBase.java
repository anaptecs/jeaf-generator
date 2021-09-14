package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class BaseClassBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1000, BaseClassBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "BASE_CLASS";

  /**
   * Constant for the name of the row that is used to store the values of attribute "name".
   */
  public static final String NAME_ROW = "NAME";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME_ATTRIBUTE = "name";

  /**
   * Constant for the name of the row that is used to store the values of attribute "number".
   */
  public static final String NUMBER_ROW = "NUMBER";

  /**
   * Constant for the name of attribute "number".
   */
  public static final String NUMBER_ATTRIBUTE = "number";

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private Integer number;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected BaseClassBOBase( ) {
    // Nothing to do.
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<BaseClassBO> findAllBaseClassBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(BaseClassBO.class);
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "number".
   * 
   * 
   * @return Integer Value to which the attribute "number" is set.
   */
  public Integer getNumber( ) {
    return number;
  }

  /**
   * Method sets the attribute "number".
   * 
   * 
   * @param pNumber Value to which the attribute "number" should be set.
   */
  public void setNumber( Integer pNumber ) {
    // Assign value to attribute
    number = pNumber;
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
