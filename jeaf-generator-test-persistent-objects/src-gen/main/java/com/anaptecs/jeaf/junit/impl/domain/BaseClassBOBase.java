package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

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
   * Constant for the name of role "deprecatedPO".
   */
  public static final String DEPRECATEDPO_ROLE = "deprecatedPO";

  private String name;

  private Integer number;

  private DeprecatedPO deprecatedPO;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected BaseClassBOBase( ) {
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
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns attribute {@link #number}.<br/>
   *
   * @return {@link Integer} Value to which {@link #number} is set.
   */
  public Integer getNumber( ) {
    return number;
  }

  /**
   * Method sets attribute {@link #number}.<br/>
   *
   * @param pNumber Value to which {@link #number} should be set.
   */
  public void setNumber( Integer pNumber ) {
    // Assign value to attribute
    number = pNumber;
  }

  /**
   * Method returns association {@link #deprecatedPO}.<br/>
   *
   * @return {@link DeprecatedPO} Value to which {@link #deprecatedPO} is set.
   */
  public DeprecatedPO getDeprecatedPO( ) {
    deprecatedPO = this.unproxy(deprecatedPO);
    return deprecatedPO;
  }

  /**
   * Method sets association {@link #deprecatedPO}.<br/>
   *
   * @param pDeprecatedPO Value to which {@link #deprecatedPO} should be set.
   */
  public void setDeprecatedPO( DeprecatedPO pDeprecatedPO ) {
    // Release already referenced object before setting a new association.
    if (deprecatedPO != null) {
      deprecatedPO.removeFromBaseClasses((BaseClassBO) this);
    }
    deprecatedPO = pDeprecatedPO;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pDeprecatedPO != null && pDeprecatedPO.getBaseClasses().contains(this) == false) {
      pDeprecatedPO.addToBaseClasses((BaseClassBO) this);
    }
  }

  /**
   * Method unsets {@link #deprecatedPO}.
   */
  public final void unsetDeprecatedPO( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    DeprecatedPO lDeprecatedPO = deprecatedPO;
    deprecatedPO = null;
    if (lDeprecatedPO != null && lDeprecatedPO.getBaseClasses().contains(this) == true) {
      lDeprecatedPO.removeFromBaseClasses((BaseClassBO) this);
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
