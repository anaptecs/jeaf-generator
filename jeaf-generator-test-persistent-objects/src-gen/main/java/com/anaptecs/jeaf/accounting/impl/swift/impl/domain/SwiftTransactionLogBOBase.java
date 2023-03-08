package com.anaptecs.jeaf.accounting.impl.swift.impl.domain;

import java.util.Calendar;
import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class SwiftTransactionLogBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1120, SwiftTransactionLogBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "SWIFTTRANSACTIONLOGBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "timestamp".
   */
  public static final String TIMESTAMP_ROW = "TIMESTAMP";

  /**
   * Constant for the name of attribute "timestamp".
   */
  public static final String TIMESTAMP_ATTRIBUTE = "timestamp";

  /**
   * Constant for the name of the row that is used to store the values of attribute "amount".
   */
  public static final String AMOUNT_ROW = "AMOUNT";

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT_ATTRIBUTE = "amount";

  private Calendar timestamp;

  private Double amount;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected SwiftTransactionLogBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<SwiftTransactionLogBO> findAllSwiftTransactionLogBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(SwiftTransactionLogBO.class);
  }

  /**
   * Method returns attribute {@link #timestamp}.<br/>
   * 
   * @return Calendar Value to which the attribute "timestamp" is set.
   */
  public Calendar getTimestamp( ) {
    return timestamp;
  }

  /**
   * Method sets the attribute "timestamp".
   * 
   * 
   * @param pTimestamp Value to which the attribute "timestamp" should be set.
   */
  public void setTimestamp( Calendar pTimestamp ) {
    // Assign value to attribute
    timestamp = pTimestamp;
  }

  /**
   * Method returns attribute {@link #amount}.<br/>
   * 
   * @return Double Value to which the attribute "amount" is set.
   */
  public Double getAmount( ) {
    return amount;
  }

  /**
   * Method sets the attribute "amount".
   * 
   * 
   * @param pAmount Value to which the attribute "amount" should be set.
   */
  public void setAmount( Double pAmount ) {
    // Assign value to attribute
    amount = pAmount;
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
