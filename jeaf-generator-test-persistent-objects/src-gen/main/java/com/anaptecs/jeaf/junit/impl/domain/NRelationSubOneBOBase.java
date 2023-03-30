package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class NRelationSubOneBOBase extends NReleationBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1004, NRelationSubOneBO.class);

  /**
   * Constant for the name of the row that is used to store the values of attribute "fieldOne".
   */
  public static final String FIELDONE_ROW = "FIELDONE";

  /**
   * Constant for the name of attribute "fieldOne".
   */
  public static final String FIELDONE_ATTRIBUTE = "fieldOne";

  private String fieldOne;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected NRelationSubOneBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<NRelationSubOneBO> findAllNRelationSubOneBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(NRelationSubOneBO.class);
  }

  /**
   * Method returns attribute {@link #fieldOne}.<br/>
   *
   * @return {@link String} Value to which {@link #fieldOne} is set.
   */
  public String getFieldOne( ) {
    return fieldOne;
  }

  /**
   * Method sets attribute {@link #fieldOne}.<br/>
   *
   * @param pFieldOne Value to which {@link #fieldOne} should be set.
   */
  public void setFieldOne( String pFieldOne ) {
    // Assign value to attribute
    fieldOne = pFieldOne;
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
