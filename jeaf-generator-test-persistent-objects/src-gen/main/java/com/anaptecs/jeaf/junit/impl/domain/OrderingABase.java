package com.anaptecs.jeaf.junit.impl.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class OrderingABase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1010, OrderingA.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "ORDERINGA";

  private SortedSet<OrderingB> orderedUnique;

  private List<OrderingB> orderedNotUnique;

  private OrderingB notOrderedUnique;

  private Collection<OrderingB> notOrderedNotUnique;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected OrderingABase( ) {
    orderedUnique = new TreeSet<OrderingB>();
    orderedNotUnique = new ArrayList<OrderingB>();
    notOrderedNotUnique = new ArrayList<OrderingB>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<OrderingA> findAllOrderingAs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(OrderingA.class);
  }

  /**
   * Method returns association {@link #orderedUnique}.<br/>
   *
   * @return {@link SortedSet<OrderingB>} Value to which {@link #orderedUnique} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public SortedSet<OrderingB> getOrderedUnique( ) {
    // Return all OrderingB objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(orderedUnique);
  }

  /**
   * Method adds the passed object to {@link #orderedUnique}.
   *
   * @param pOrderedUnique Object that should be added to {@link #orderedUnique}. The parameter must not be null.
   */
  public void addToOrderedUnique( OrderingB pOrderedUnique ) {
    // Check parameter "pOrderedUnique" for invalid value null.
    Check.checkInvalidParameterNull(pOrderedUnique, "pOrderedUnique");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pOrderedUnique.unsetA1();
    // Add passed object to collection of associated OrderingB objects.
    orderedUnique.add(pOrderedUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pOrderedUnique != null && this.equals(pOrderedUnique.getA1()) == false) {
      pOrderedUnique.setA1((OrderingA) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #orderedUnique}.
   *
   * @param pOrderedUnique Collection with all objects that should be added to {@link #orderedUnique}. The parameter
   * must not be null.
   */
  public void addToOrderedUnique( Collection<OrderingB> pOrderedUnique ) {
    // Check parameter "pOrderedUnique" for invalid value null.
    Check.checkInvalidParameterNull(pOrderedUnique, "pOrderedUnique");
    // Add all passed objects.
    for (OrderingB lNextObject : pOrderedUnique) {
      this.addToOrderedUnique(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #orderedUnique}.<br/>
   *
   * @param pOrderedUnique Object that should be removed from {@link #orderedUnique}. The parameter must not be null.
   */
  public void removeFromOrderedUnique( OrderingB pOrderedUnique ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pOrderedUnique, "pOrderedUnique");
    // Remove passed object from collection of associated OrderingB objects.
    orderedUnique.remove(pOrderedUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pOrderedUnique.getA1()) == true) {
      pOrderedUnique.unsetA1();
    }
  }

  /**
   * Method removes all objects from {@link #orderedUnique}.
   */
  public void clearOrderedUnique( ) {
    // Remove all objects from association "orderedUnique".
    Collection<OrderingB> lOrderedUnique = new HashSet<OrderingB>(orderedUnique);
    Iterator<OrderingB> lIterator = lOrderedUnique.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromOrderedUnique(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #orderedNotUnique}.<br/>
   *
   * @return {@link List<OrderingB>} Value to which {@link #orderedNotUnique} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<OrderingB> getOrderedNotUnique( ) {
    // Return all OrderingB objects as unmodifiable collection.
    return Collections.unmodifiableList(orderedNotUnique);
  }

  /**
   * Method adds the passed object to {@link #orderedNotUnique}.
   *
   * @param pOrderedNotUnique Object that should be added to {@link #orderedNotUnique}. The parameter must not be null.
   */
  public void addToOrderedNotUnique( OrderingB pOrderedNotUnique ) {
    // Check parameter "pOrderedNotUnique" for invalid value null.
    Check.checkInvalidParameterNull(pOrderedNotUnique, "pOrderedNotUnique");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pOrderedNotUnique.unsetA2();
    // Add passed object to collection of associated OrderingB objects.
    orderedNotUnique.add(pOrderedNotUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pOrderedNotUnique != null && this.equals(pOrderedNotUnique.getA2()) == false) {
      pOrderedNotUnique.setA2((OrderingA) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #orderedNotUnique}.
   *
   * @param pOrderedNotUnique Collection with all objects that should be added to {@link #orderedNotUnique}. The
   * parameter must not be null.
   */
  public void addToOrderedNotUnique( Collection<OrderingB> pOrderedNotUnique ) {
    // Check parameter "pOrderedNotUnique" for invalid value null.
    Check.checkInvalidParameterNull(pOrderedNotUnique, "pOrderedNotUnique");
    // Add all passed objects.
    for (OrderingB lNextObject : pOrderedNotUnique) {
      this.addToOrderedNotUnique(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #orderedNotUnique}.<br/>
   *
   * @param pOrderedNotUnique Object that should be removed from {@link #orderedNotUnique}. The parameter must not be
   * null.
   */
  public void removeFromOrderedNotUnique( OrderingB pOrderedNotUnique ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pOrderedNotUnique, "pOrderedNotUnique");
    // Remove passed object from collection of associated OrderingB objects.
    orderedNotUnique.remove(pOrderedNotUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pOrderedNotUnique.getA2()) == true) {
      pOrderedNotUnique.unsetA2();
    }
  }

  /**
   * Method removes all objects from {@link #orderedNotUnique}.
   */
  public void clearOrderedNotUnique( ) {
    // Remove all objects from association "orderedNotUnique".
    Collection<OrderingB> lOrderedNotUnique = new HashSet<OrderingB>(orderedNotUnique);
    Iterator<OrderingB> lIterator = lOrderedNotUnique.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromOrderedNotUnique(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #notOrderedUnique}.<br/>
   *
   * @return {@link OrderingB} Value to which {@link #notOrderedUnique} is set.
   */
  public OrderingB getNotOrderedUnique( ) {
    notOrderedUnique = this.unproxy(notOrderedUnique);
    return notOrderedUnique;
  }

  /**
   * Method sets association {@link #notOrderedUnique}.<br/>
   *
   * @param pNotOrderedUnique Value to which {@link #notOrderedUnique} should be set.
   */
  public void setNotOrderedUnique( OrderingB pNotOrderedUnique ) {
    // Release already referenced object before setting a new association.
    if (notOrderedUnique != null) {
      notOrderedUnique.unsetA3();
    }
    notOrderedUnique = pNotOrderedUnique;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNotOrderedUnique != null && this.equals(pNotOrderedUnique.getA3()) == false) {
      pNotOrderedUnique.setA3((OrderingA) this);
    }
  }

  /**
   * Method unsets {@link #notOrderedUnique}.
   */
  public final void unsetNotOrderedUnique( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    OrderingB lOrderingB = notOrderedUnique;
    notOrderedUnique = null;
    if (lOrderingB != null && this.equals(lOrderingB.getA3()) == true) {
      lOrderingB.unsetA3();
    }
  }

  /**
   * Method returns association {@link #notOrderedNotUnique}.<br/>
   *
   * @return {@link Collection<OrderingB>} Value to which {@link #notOrderedNotUnique} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Collection<OrderingB> getNotOrderedNotUnique( ) {
    // Return all OrderingB objects as unmodifiable collection.
    return Collections.unmodifiableCollection(notOrderedNotUnique);
  }

  /**
   * Method adds the passed object to {@link #notOrderedNotUnique}.
   *
   * @param pNotOrderedNotUnique Object that should be added to {@link #notOrderedNotUnique}. The parameter must not be
   * null.
   */
  public void addToNotOrderedNotUnique( OrderingB pNotOrderedNotUnique ) {
    // Check parameter "pNotOrderedNotUnique" for invalid value null.
    Check.checkInvalidParameterNull(pNotOrderedNotUnique, "pNotOrderedNotUnique");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pNotOrderedNotUnique.unsetA4();
    // Add passed object to collection of associated OrderingB objects.
    notOrderedNotUnique.add(pNotOrderedNotUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pNotOrderedNotUnique != null && this.equals(pNotOrderedNotUnique.getA4()) == false) {
      pNotOrderedNotUnique.setA4((OrderingA) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #notOrderedNotUnique}.
   *
   * @param pNotOrderedNotUnique Collection with all objects that should be added to {@link #notOrderedNotUnique}. The
   * parameter must not be null.
   */
  public void addToNotOrderedNotUnique( Collection<OrderingB> pNotOrderedNotUnique ) {
    // Check parameter "pNotOrderedNotUnique" for invalid value null.
    Check.checkInvalidParameterNull(pNotOrderedNotUnique, "pNotOrderedNotUnique");
    // Add all passed objects.
    for (OrderingB lNextObject : pNotOrderedNotUnique) {
      this.addToNotOrderedNotUnique(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #notOrderedNotUnique}.<br/>
   *
   * @param pNotOrderedNotUnique Object that should be removed from {@link #notOrderedNotUnique}. The parameter must not
   * be null.
   */
  public void removeFromNotOrderedNotUnique( OrderingB pNotOrderedNotUnique ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pNotOrderedNotUnique, "pNotOrderedNotUnique");
    // Remove passed object from collection of associated OrderingB objects.
    notOrderedNotUnique.remove(pNotOrderedNotUnique);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pNotOrderedNotUnique.getA4()) == true) {
      pNotOrderedNotUnique.unsetA4();
    }
  }

  /**
   * Method removes all objects from {@link #notOrderedNotUnique}.
   */
  public void clearNotOrderedNotUnique( ) {
    // Remove all objects from association "notOrderedNotUnique".
    Collection<OrderingB> lNotOrderedNotUnique = new HashSet<OrderingB>(notOrderedNotUnique);
    Iterator<OrderingB> lIterator = lNotOrderedNotUnique.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromNotOrderedNotUnique(lIterator.next());
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