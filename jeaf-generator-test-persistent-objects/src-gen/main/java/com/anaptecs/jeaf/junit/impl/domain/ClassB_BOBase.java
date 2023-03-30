package com.anaptecs.jeaf.junit.impl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class ClassB_BOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1013, ClassB_BO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "CLASSB_BO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "intValue".
   */
  public static final String INTVALUE_ROW = "INTVALUE";

  /**
   * Constant for the name of attribute "intValue".
   */
  public static final String INTVALUE_ATTRIBUTE = "intValue";

  /**
   * Constant for the name of role "classAs".
   */
  public static final String CLASSAS_ROLE = "classAs";

  private Set<ClassA_BO> classAs;

  private Integer intValue;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected ClassB_BOBase( ) {
    classAs = new HashSet<ClassA_BO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<ClassB_BO> findAllClassB_BOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(ClassB_BO.class);
  }

  /**
   * Method returns association {@link #classAs}.<br/>
   *
   * @return {@link Set<ClassA_BO>} Value to which {@link #classAs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<ClassA_BO> getClassAs( ) {
    // Return all ClassA_BO objects as unmodifiable collection.
    return Collections.unmodifiableSet(classAs);
  }

  /**
   * Method adds the passed object to {@link #classAs}.
   *
   * @param pClassAs Object that should be added to {@link #classAs}. The parameter must not be null.
   */
  public void addToClassAs( ClassA_BO pClassAs ) {
    // Check parameter "pClassAs" for invalid value null.
    Check.checkInvalidParameterNull(pClassAs, "pClassAs");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pClassAs.unsetClassB();
    // Add passed object to collection of associated ClassA_BO objects.
    classAs.add(pClassAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pClassAs != null && this.equals(pClassAs.getClassB()) == false) {
      pClassAs.setClassB((ClassB_BO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #classAs}.
   *
   * @param pClassAs Collection with all objects that should be added to {@link #classAs}. The parameter must not be
   * null.
   */
  public void addToClassAs( Collection<ClassA_BO> pClassAs ) {
    // Check parameter "pClassAs" for invalid value null.
    Check.checkInvalidParameterNull(pClassAs, "pClassAs");
    // Add all passed objects.
    for (ClassA_BO lNextObject : pClassAs) {
      this.addToClassAs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #classAs}.<br/>
   *
   * @param pClassAs Object that should be removed from {@link #classAs}. The parameter must not be null.
   */
  public void removeFromClassAs( ClassA_BO pClassAs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pClassAs, "pClassAs");
    // Remove passed object from collection of associated ClassA_BO objects.
    classAs.remove(pClassAs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pClassAs.getClassB()) == true) {
      pClassAs.unsetClassB();
    }
  }

  /**
   * Method removes all objects from {@link #classAs}.
   */
  public void clearClassAs( ) {
    // Remove all objects from association "classAs".
    Collection<ClassA_BO> lClassAs = new HashSet<ClassA_BO>(classAs);
    Iterator<ClassA_BO> lIterator = lClassAs.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromClassAs(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #intValue}.<br/>
   *
   * @return {@link Integer} Value to which {@link #intValue} is set.
   */
  public Integer getIntValue( ) {
    return intValue;
  }

  /**
   * Method sets attribute {@link #intValue}.<br/>
   *
   * @param pIntValue Value to which {@link #intValue} should be set.
   */
  public void setIntValue( Integer pIntValue ) {
    // Assign value to attribute
    intValue = pIntValue;
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
