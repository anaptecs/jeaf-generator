/*
 * Copyright 2004 - 2011 anaptecs GmbH Burgstr. 96, 72764 Reutlingen, Germany All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.persistence;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.BusinessObjectTestService;

/**
 * Implementation of BusinessObjectTestService.
 */
abstract class BusinessObjectTestServiceImplBase extends BusinessObjectTestPort implements BusinessObjectTestService {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String ADDCMANY_AUTH_TYPE = "addCMany.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String CLEARCMANY_AUTH_TYPE = "clearCMany.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String CREATEABCOBJECTS_AUTH_TYPE =
      "createABCObjects.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String CREATEBUSINESSOBJECT_AUTH_TYPE =
      "createBusinessObject.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String CREATECLASSA_AUTH_TYPE =
      "createClassA.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String CREATEXONE_AUTH_TYPE = "createXOne.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String DELETEBUSINESSOBJECT_AUTH_TYPE =
      "deleteBusinessObject.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String DEPRECTEDOPERATION_AUTH_TYPE =
      "deprectedOperation.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String GETCLASSA_AUTH_TYPE = "getClassA.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String GETCMANYS_AUTH_TYPE = "getCManys.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String REMOVECMANY_AUTH_TYPE =
      "removeCMany.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTAONETOBONE_AUTH_TYPE =
      "testAOneToBOne.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTATTRIBUTEACCESS_AUTH_TYPE =
      "testAttributeAccess.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTBONETOAONE_AUTH_TYPE =
      "testBOneToAOne.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTBUSINESSMETHODS_AUTH_TYPE =
      "testBusinessMethods.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTBUSINESSOBJECTSWITHINHERITANCE_AUTH_TYPE =
      "testBusinessObjectsWithInheritance.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTBUSINESSOBJECTSWITHMANYTOMANYASSOCIATIONS_AUTH_TYPE =
      "testBusinessObjectsWithManyToManyAssociations.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTCREATEBUSINESSOBJECTSWITHUSERTYPEMAPPING_AUTH_TYPE =
      "testCreateBusinessObjectsWithUserTypeMapping.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTCREATESIMPLEBUSINESSOBJECT_AUTH_TYPE =
      "testCreateSimpleBusinessObject.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTDYNAMICPROPERTYACCESS_AUTH_TYPE =
      "testDynamicPropertyAccess.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTFLUSH_AUTH_TYPE = "testFlush.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTINITIALOBJECTCACHE_AUTH_TYPE =
      "testInitialObjectCache.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTJDBCWORKER_AUTH_TYPE =
      "testJDBCWorker.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTMTONRELEATION_AUTH_TYPE =
      "testMToNReleation.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTNATIVEQUERY_AUTH_TYPE =
      "testNativeQuery.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTOBJECTCACHERELOADING_AUTH_TYPE =
      "testObjectCacheReloading.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTQUERYWITHJPAQL_AUTH_TYPE =
      "testQueryWithJPAQL.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTREADBUSINESSOBJECTSWITHUSERTYPEMAPPING_AUTH_TYPE =
      "testReadBusinessObjectsWithUserTypeMapping.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTSERVICEOBJECTSWITHONETOMANYASSOCIATIONS_AUTH_TYPE =
      "testServiceObjectsWithOneToManyAssociations.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTSERVICEOBJECTSWITHONETOONEASSOCIATIONS_AUTH_TYPE =
      "testServiceObjectsWithOneToOneAssociations.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String TESTTRANSACTIONLISTENER_AUTH_TYPE =
      "testTransactionListener.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String UPDATEBUSINESSOBJECT_AUTH_TYPE =
      "updateBusinessObject.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  public static final String UPDATECLASSA_AUTH_TYPE =
      "updateClassA.com.anaptecs.jeaf.junit.core.BusinessObjectTestService";

  /**
   * Initialize object.
   */
  BusinessObjectTestServiceImplBase( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method returns the class object of the service that is implemented by this service instance.
   *
   * @return Class Class object of the service interface that is implemented by the service instance. The method never
   * returns null.
   *
   * @see ServiceImplementation#getServiceType()
   */
  public final Class<? extends Service> getServiceType( ) {
    return BusinessObjectTestService.class;
  }
}