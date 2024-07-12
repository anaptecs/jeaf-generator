package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class NRelationSubTwoBOBase extends NReleationBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1005, NRelationSubTwoBO.class);

  /**
   * Constant for the name of the row that is used to store the values of attribute "fieldTwo".
   */
  public static final String FIELDTWO_ROW = "FIELDTWO";

  /**
   * Constant for the name of attribute "fieldTwo".
   */
  public static final String FIELDTWO_ATTRIBUTE = "fieldTwo";

  private String fieldTwo;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected NRelationSubTwoBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<NRelationSubTwoBO> findAllNRelationSubTwoBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(NRelationSubTwoBO.class);
  }

  /**
   * Method returns attribute {@link #fieldTwo}.<br/>
   *
   * @return {@link String} Value to which {@link #fieldTwo} is set.
   */
  public String getFieldTwo( ) {
    return fieldTwo;
  }

  /**
   * Method sets attribute {@link #fieldTwo}.<br/>
   *
   * @param pFieldTwo Value to which {@link #fieldTwo} should be set.
   */
  public void setFieldTwo( String pFieldTwo ) {
    // Assign value to attribute
    fieldTwo = pFieldTwo;
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