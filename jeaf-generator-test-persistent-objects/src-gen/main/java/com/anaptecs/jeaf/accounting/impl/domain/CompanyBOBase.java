package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.List;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;

public abstract class CompanyBOBase extends CustomerBO {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1106, CompanyBO.class);

  /**
   * Constant for the name of the row that is used to store the values of attribute "name".
   */
  public static final String NAME_ROW = "NAME";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME_ATTRIBUTE = "name";

  /**
   * Constant for the name of the row that is used to store the values of attribute "registrationNumber".
   */
  public static final String REGISTRATIONNUMBER_ROW = "REGISTRATIONNUMBER";

  /**
   * Constant for the name of attribute "registrationNumber".
   */
  public static final String REGISTRATIONNUMBER_ATTRIBUTE = "registrationNumber";

  /**
   * Constant for the name of the row that is used to store the values of attribute "taxNumber".
   */
  public static final String TAXNUMBER_ROW = "TAXNUMBER";

  /**
   * Constant for the name of attribute "taxNumber".
   */
  public static final String TAXNUMBER_ATTRIBUTE = "taxNumber";

  private String name;

  private Long registrationNumber;

  private Long taxNumber;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected CompanyBOBase( ) {
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<CompanyBO> findAllCompanyBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(CompanyBO.class);
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
   * Method returns attribute {@link #registrationNumber}.<br/>
   *
   * @return {@link Long} Value to which {@link #registrationNumber} is set.
   */
  public Long getRegistrationNumber( ) {
    return registrationNumber;
  }

  /**
   * Method sets attribute {@link #registrationNumber}.<br/>
   *
   * @param pRegistrationNumber Value to which {@link #registrationNumber} should be set.
   */
  public void setRegistrationNumber( Long pRegistrationNumber ) {
    // Assign value to attribute
    registrationNumber = pRegistrationNumber;
  }

  /**
   * Method returns attribute {@link #taxNumber}.<br/>
   *
   * @return {@link Long} Value to which {@link #taxNumber} is set.
   */
  public Long getTaxNumber( ) {
    return taxNumber;
  }

  /**
   * Method sets attribute {@link #taxNumber}.<br/>
   *
   * @param pTaxNumber Value to which {@link #taxNumber} should be set.
   */
  public void setTaxNumber( Long pTaxNumber ) {
    // Assign value to attribute
    taxNumber = pTaxNumber;
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
