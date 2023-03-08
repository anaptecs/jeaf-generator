package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class FlushTestMasterBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1015, FlushTestMasterBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "FLUSHTESTMASTERBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "requiredField".
   */
  public static final String REQUIREDFIELD_ROW = "REQUIREDFIELD";

  /**
   * Constant for the name of attribute "requiredField".
   */
  public static final String REQUIREDFIELD_ATTRIBUTE = "requiredField";

  private String requiredField;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected FlushTestMasterBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<FlushTestMasterBO> findAllFlushTestMasterBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(FlushTestMasterBO.class);
  }

  /**
   * Method returns the attribute "requiredField".
   * 
   * 
   * @return String Value to which the attribute "requiredField" is set.
   */
  public String getRequiredField( ) {
    return requiredField;
  }

  /**
   * Method sets the attribute "requiredField".
   * 
   * 
   * @param pRequiredField Value to which the attribute "requiredField" should be set.
   */
  public void setRequiredField( String pRequiredField ) {
    // Assign value to attribute
    requiredField = pRequiredField;
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
