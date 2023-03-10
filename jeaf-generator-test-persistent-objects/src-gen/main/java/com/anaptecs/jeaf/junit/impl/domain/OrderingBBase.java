package com.anaptecs.jeaf.junit.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class OrderingBBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1011, OrderingB.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "ORDERINGB";

  private OrderingA a1;

  private OrderingA a2;

  private OrderingA a3;

  private OrderingA a4;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected OrderingBBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<OrderingB> findAllOrderingBs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(OrderingB.class);
  }

  /**
   * Method returns association {@link #a1}.<br/>
   * 
   * @return {@link OrderingA} Value to which {@link #a1} is set.
   */
  public OrderingA getA1( ) {
    a1 = this.unproxy(a1);
    return a1;
  }

  /**
   * Method sets association {@link #a1}.<br/>
   * 
   * @param pA1 Value to which {@link #a1} should be set.
   */
  public void setA1( OrderingA pA1 ) {
    // Release already referenced object before setting a new association.
    if (a1 != null) {
      a1.removeFromOrderedUnique((OrderingB) this);
    }
    a1 = pA1;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA1 != null && pA1.getOrderedUnique().contains(this) == false) {
      pA1.addToOrderedUnique((OrderingB) this);
    }
  }

  /**
   * Method unsets the association "a1".
   * 
   */
  public final void unsetA1( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    OrderingA lOrderingA = a1;
    a1 = null;
    if (lOrderingA != null && lOrderingA.getOrderedUnique().contains(this) == true) {
      lOrderingA.removeFromOrderedUnique((OrderingB) this);
    }
  }

  /**
   * Method returns association {@link #a2}.<br/>
   * 
   * @return {@link OrderingA} Value to which {@link #a2} is set.
   */
  public OrderingA getA2( ) {
    a2 = this.unproxy(a2);
    return a2;
  }

  /**
   * Method sets association {@link #a2}.<br/>
   * 
   * @param pA2 Value to which {@link #a2} should be set.
   */
  public void setA2( OrderingA pA2 ) {
    // Release already referenced object before setting a new association.
    if (a2 != null) {
      a2.removeFromOrderedNotUnique((OrderingB) this);
    }
    a2 = pA2;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA2 != null && pA2.getOrderedNotUnique().contains(this) == false) {
      pA2.addToOrderedNotUnique((OrderingB) this);
    }
  }

  /**
   * Method unsets the association "a2".
   * 
   */
  public final void unsetA2( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    OrderingA lOrderingA = a2;
    a2 = null;
    if (lOrderingA != null && lOrderingA.getOrderedNotUnique().contains(this) == true) {
      lOrderingA.removeFromOrderedNotUnique((OrderingB) this);
    }
  }

  /**
   * Method returns association {@link #a3}.<br/>
   * 
   * @return {@link OrderingA} Value to which {@link #a3} is set.
   */
  public OrderingA getA3( ) {
    a3 = this.unproxy(a3);
    return a3;
  }

  /**
   * Method sets association {@link #a3}.<br/>
   * 
   * @param pA3 Value to which {@link #a3} should be set.
   */
  public void setA3( OrderingA pA3 ) {
    // Release already referenced object before setting a new association.
    if (a3 != null) {
      a3.unsetNotOrderedUnique();
    }
    a3 = pA3;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA3 != null && this.equals(pA3.getNotOrderedUnique()) == false) {
      pA3.setNotOrderedUnique((OrderingB) this);
    }
  }

  /**
   * Method unsets the association "a3".
   * 
   */
  public final void unsetA3( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    OrderingA lOrderingA = a3;
    a3 = null;
    if (lOrderingA != null && this.equals(lOrderingA.getNotOrderedUnique()) == true) {
      lOrderingA.unsetNotOrderedUnique();
    }
  }

  /**
   * Method returns association {@link #a4}.<br/>
   * 
   * @return {@link OrderingA} Value to which {@link #a4} is set.
   */
  public OrderingA getA4( ) {
    a4 = this.unproxy(a4);
    return a4;
  }

  /**
   * Method sets association {@link #a4}.<br/>
   * 
   * @param pA4 Value to which {@link #a4} should be set.
   */
  public void setA4( OrderingA pA4 ) {
    // Release already referenced object before setting a new association.
    if (a4 != null) {
      a4.removeFromNotOrderedNotUnique((OrderingB) this);
    }
    a4 = pA4;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pA4 != null && pA4.getNotOrderedNotUnique().contains(this) == false) {
      pA4.addToNotOrderedNotUnique((OrderingB) this);
    }
  }

  /**
   * Method unsets the association "a4".
   * 
   */
  public final void unsetA4( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    OrderingA lOrderingA = a4;
    a4 = null;
    if (lOrderingA != null && lOrderingA.getNotOrderedNotUnique().contains(this) == true) {
      lOrderingA.removeFromNotOrderedNotUnique((OrderingB) this);
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
