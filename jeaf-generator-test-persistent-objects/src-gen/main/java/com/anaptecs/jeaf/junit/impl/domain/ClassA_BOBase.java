package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class ClassA_BOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1014, ClassA_BO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "CLASSA_BO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "name".
   */
  public static final String NAME_ROW = "NAME";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME_ATTRIBUTE = "name";

  /**
   * Constant for the name of the row that is used to store the values of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT_ROW = "READONLYDEFAULT";

  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT_ATTRIBUTE = "readonlyDefault";

  /**
   * Constant for the name of role "classB".
   */
  public static final String CLASSB_ROLE = "classB";

  private ClassB_BO classB;

  private String name;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected ClassA_BOBase( ) {
    readonlyDefault = 4711;
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<ClassA_BO> findAllClassA_BOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(ClassA_BO.class);
  }

  /**
   * Method returns the association "classB".
   * 
   *
   * @return ClassB_BO ClassB_BO to which the association "classB" is set.
   */
  public ClassB_BO getClassB( ) {
    classB = this.unproxy(classB);
    return classB;
  }

  /**
   * Method sets the association "classB".
   * 
   * 
   * @param pClassB ClassB_BO to which the association "classB" should be set.
   */
  public void setClassB( ClassB_BO pClassB ) {
    // Release already referenced object before setting a new association.
    if (classB != null) {
      classB.removeFromClassAs((ClassA_BO) this);
    }
    classB = pClassB;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pClassB != null && pClassB.getClassAs().contains(this) == false) {
      pClassB.addToClassAs((ClassA_BO) this);
    }
  }

  /**
   * Method unsets the association "classB".
   * 
   */
  public final void unsetClassB( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    ClassB_BO lClassB_BO = classB;
    classB = null;
    if (lClassB_BO != null && lClassB_BO.getClassAs().contains(this) == true) {
      lClassB_BO.removeFromClassAs((ClassA_BO) this);
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
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
   * Method returns attribute {@link #readonlyDefault}.<br/>
   * 
   * @return int Value to which the attribute "readonlyDefault" is set.
   */
  public int getReadonlyDefault( ) {
    return readonlyDefault;
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
