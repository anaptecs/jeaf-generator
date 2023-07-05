package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class IndividualBOBase extends CustomerBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1105, IndividualBO.class);

  /**
   * Constant for the name of role "person".
   */
  public static final String PERSON_ROLE = "person";

  private MyPersonBO person;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected IndividualBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<IndividualBO> findAllIndividualBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(IndividualBO.class);
  }

  /**
   * Method returns association {@link #person}.<br/>
   *
   * @return {@link MyPersonBO} Value to which {@link #person} is set.
   */
  public MyPersonBO getPerson( ) {
    person = this.unproxy(person);
    return person;
  }

  /**
   * Method sets association {@link #person}.<br/>
   *
   * @param pPerson Value to which {@link #person} should be set.
   */
  public void setPerson( MyPersonBO pPerson ) {
    // Release already referenced object before setting a new association.
    if (person != null) {
      person.unsetCustomer();
    }
    person = pPerson;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pPerson != null && this.equals(pPerson.getCustomer()) == false) {
      pPerson.setCustomer((IndividualBO) this);
    }
  }

  /**
   * Method unsets {@link #person}.
   */
  public final void unsetPerson( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    MyPersonBO lMyPersonBO = person;
    person = null;
    if (lMyPersonBO != null && this.equals(lMyPersonBO.getCustomer()) == true) {
      lMyPersonBO.unsetCustomer();
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
