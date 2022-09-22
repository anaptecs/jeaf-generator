package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.types.EncryptedString;
import com.anaptecs.jeaf.xfun.types.Gender;
import com.anaptecs.jeaf.xfun.types.Period;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Deprecated
public abstract class PublicClassBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1006, PublicClassBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "PUBLICCLASSBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "period".
   */
  public static final String PERIOD_ROW = "PERIOD";

  /**
   * Constant for the name of attribute "period".
   */
  public static final String PERIOD_ATTRIBUTE = "period";

  /**
   * Constant for the name of the row that is used to store the values of attribute "gender".
   */
  public static final String GENDER_ROW = "GENDER";

  /**
   * Constant for the name of attribute "gender".
   */
  public static final String GENDER_ATTRIBUTE = "gender";

  /**
   * Constant for the name of the row that is used to store the values of attribute "encryptedString".
   */
  public static final String ENCRYPTEDSTRING_ROW = "ENCRYPTEDSTRING";

  /**
   * Constant for the name of attribute "encryptedString".
   */
  public static final String ENCRYPTEDSTRING_ATTRIBUTE = "encryptedString";

  /**
   * 
   */
  private Period period;

  /**
   * 
   */
  private Gender gender;

  /**
   * 
   */
  private EncryptedString encryptedString;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected PublicClassBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<PublicClassBO> findAllPublicClassBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(PublicClassBO.class);
  }

  /**
   * Method returns the attribute "period".
   * 
   * 
   * @return Period Value to which the attribute "period" is set.
   */
  public Period getPeriod( ) {
    return period;
  }

  /**
   * Method sets the attribute "period".
   * 
   * 
   * @param pPeriod Value to which the attribute "period" should be set.
   */
  public void setPeriod( Period pPeriod ) {
    // Assign value to attribute
    period = pPeriod;
  }

  /**
   * Method returns the attribute "gender".
   * 
   * 
   * @return Gender Value to which the attribute "gender" is set.
   */
  public Gender getGender( ) {
    return gender;
  }

  /**
   * Method sets the attribute "gender".
   * 
   * 
   * @param pGender Value to which the attribute "gender" should be set.
   */
  public void setGender( Gender pGender ) {
    // Assign value to attribute
    gender = pGender;
  }

  /**
   * Method returns the attribute "encryptedString".
   * 
   * 
   * @return EncryptedString Value to which the attribute "encryptedString" is set.
   */
  public EncryptedString getEncryptedString( ) {
    return encryptedString;
  }

  /**
   * Method sets the attribute "encryptedString".
   * 
   * 
   * @param pEncryptedString Value to which the attribute "encryptedString" should be set.
   */
  public void setEncryptedString( EncryptedString pEncryptedString ) {
    // Assign value to attribute
    encryptedString = pEncryptedString;
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
