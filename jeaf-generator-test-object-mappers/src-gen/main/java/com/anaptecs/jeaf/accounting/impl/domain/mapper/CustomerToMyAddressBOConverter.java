/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.accounting.Customer;
import com.anaptecs.jeaf.accounting.impl.domain.MyAddressBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link Customer} as source and {@link MyAddressBO} as
 * target.
 */
public class CustomerToMyAddressBOConverter implements ObjectMapper<Customer, MyAddressBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final CustomerToMyAddressBOConverter INSTANCE = new CustomerToMyAddressBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private CustomerToMyAddressBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Customer and MyAddressBO. The
   * method never returns null.
   */
  public static CustomerToMyAddressBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new MyAddressBO object from the passed Customer object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource Customer object that should be used to create a new MyAddressBO object. The parameter must not be
   * null.
   * @return {@link MyAddressBO} Created MyAddressBO object. The method never returns null.
   */
  public static MyAddressBO createNewTargetObject( Customer pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    MyAddressBO lTarget = lPersistenceServiceProvider.createPersistentObject(MyAddressBO.class);
    CustomerToMyAddressBOConverter lObjectMapper = CustomerToMyAddressBOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new MyAddressBO objects based on the passed Customer objects. For every Customer object a new
   * MyAddressBO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All Customer objects that should be used to create MyAddressBO objects. The parameter must
   * not be null.
   * @return {@link List} List with all MyAddressBO objects that were created. The method never returns null.
   */
  public static List<MyAddressBO> createNewTargetObjects( Collection<Customer> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<MyAddressBO> lTargetObjects = new ArrayList<MyAddressBO>(pSourceObjects.size());
    for (Customer lNext : pSourceObjects) {
      MyAddressBO lNewTargetObject = CustomerToMyAddressBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource Customer object that should be used to update an existing MyAddressBO object. The parameter must not
   * be null.
   * @return {@link MyAddressBO} Updated MyAddressBO object. The method never returns null.
   */
  public static MyAddressBO updatePersistentTarget( Customer pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    MyAddressBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), MyAddressBO.class);
    CustomerToMyAddressBOConverter lObjectMapper = CustomerToMyAddressBOConverter.getConverter();
    lObjectMapper.applyMappings(pSource, lTargetObject, MappingType.UPDATE);
    return lTargetObject;
  }

  /**
   * Method applies the mappings according to the passed mapping type on the passed source and target object.
   *
   * @param pSource Source object which should be used. The parameter must not be null. The effective type and direction
   * of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pTarget Target object which should be used. The parameter must not be null. The effective type and direction
   * of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  @Override
  public void applyMappings( Customer pSource, MyAddressBO pTarget, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSource, "pSource");
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Select the type of mapping that should be executed.
    switch (pMappingType) {
      // Mappings for creation of target object.
      case CREATE:
        this.setTargetObject(pSource, pTarget);
        break;
      // Mapping for update of target object
      case UPDATE:
        this.updateTargetObject(pSource, pTarget);
        break;
      // Mapping for reading from target object.
      case READ:
        this.setSourceObject(pSource, pTarget);
        break;
      // Invalid mapping type. Most likely this is because of an outdated version of JEAF Generator that does not match
      // to the used version of JEAF Core.
      default:
        Assert.internalError("Unexpected object mapping type '" + pMappingType.name()
            + ". Please regenerate code with the latest version of JEAF Generator.");
    }
  }

  /**
   * Method applies the mappings according to the passed mapping type on the passed source and target objects. The
   * entries in the list of source and target objects are matched according to their index. This also means that both
   * list must have the same amount of entries.
   *
   * @param pSources Source objects which should be used. The parameter must not be null. The effective type and
   * direction of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pTargets Target objects which should be used. The parameter must not be null. The effective type and
   * direction of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  @Override
  public void applyMappings( List<Customer> pSources, List<MyAddressBO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Customer> lSourceIterator = pSources.iterator();
    Iterator<MyAddressBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method maps all attributes from Customer to MyAddressBO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Customer pSource, MyAddressBO pTarget ) {
    pTarget.setStreet(pSource.getStreet());
    pTarget.setZipCode(pSource.getZipCode());
    pTarget.setCity(pSource.getCity());
    pTarget.setCountry(pSource.getCountry());
  }

  /**
   * Method maps all attributes from Customer to MyAddressBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Customer pSource, MyAddressBO pTarget ) {
    // In order to avoid dirty writes on persistent objects, we first check for optimistic lock conflicts. Therefore we
    // have to compare version labels of source and target.
    Integer lSourceVersionLabel = pSource.getID().getVersionLabel();
    int lTargetVersionLabel = pTarget.getVersionLabel();
    // Optimistic lock conflict detected
    if (lSourceVersionLabel != null && lSourceVersionLabel.intValue() != lTargetVersionLabel) {
      String[] lParams = new String[] { pTarget.getClass().getName(), pTarget.getID().getObjectID(),
        lSourceVersionLabel.toString(), Integer.toString(pTarget.getVersionLabel()) };
      throw new JEAFSystemException(PersistenceServiceProviderMessages.OPTIMISTIC_LOCK_CONFLICT, lParams);
    }
    else {
      // Update target object
      pTarget.setStreet(pSource.getStreet());
      pTarget.setZipCode(pSource.getZipCode());
      pTarget.setCity(pSource.getCity());
      pTarget.setCountry(pSource.getCountry());
    }
  }

  /**
   * Method maps all attributes from MyAddressBO to Customer. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Customer pSource, MyAddressBO pTarget ) {
    pSource.setStreet(pTarget.getStreet());
    pSource.setZipCode(pTarget.getZipCode());
    pSource.setCity(pTarget.getCity());
    pSource.setCountry(pTarget.getCountry());
  }
}
