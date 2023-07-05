package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class FlushTestSlaveBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1016, FlushTestSlaveBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "FLUSHTESTSLAVEBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "optionalField".
   */
  public static final String OPTIONALFIELD_ROW = "OPTIONALFIELD";

  /**
   * Constant for the name of attribute "optionalField".
   */
  public static final String OPTIONALFIELD_ATTRIBUTE = "optionalField";

  /**
   * Constant for the name of role "masterObject".
   */
  public static final String MASTEROBJECT_ROLE = "masterObject";

  private FlushTestMasterBO masterObject;

  private String optionalField;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected FlushTestSlaveBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<FlushTestSlaveBO> findAllFlushTestSlaveBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(FlushTestSlaveBO.class);
  }

  /**
   * Method returns association {@link #masterObject}.<br/>
   *
   * @return {@link FlushTestMasterBO} Value to which {@link #masterObject} is set.
   */
  public FlushTestMasterBO getMasterObject( ) {
    masterObject = this.unproxy(masterObject);
    return masterObject;
  }

  /**
   * Method sets association {@link #masterObject}.<br/>
   *
   * @param pMasterObject Value to which {@link #masterObject} should be set.
   */
  public void setMasterObject( FlushTestMasterBO pMasterObject ) {
    masterObject = pMasterObject;
  }

  /**
   * Method unsets {@link #masterObject}.
   */
  public final void unsetMasterObject( ) {
    masterObject = null;
  }

  /**
   * Method returns attribute {@link #optionalField}.<br/>
   *
   * @return {@link String} Value to which {@link #optionalField} is set.
   */
  public String getOptionalField( ) {
    return optionalField;
  }

  /**
   * Method sets attribute {@link #optionalField}.<br/>
   *
   * @param pOptionalField Value to which {@link #optionalField} should be set.
   */
  public void setOptionalField( String pOptionalField ) {
    // Assign value to attribute
    optionalField = pOptionalField;
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
