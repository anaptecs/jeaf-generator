/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.core.BusinessObjectTestService;

/**
 * This is the base class of the test suite of service BusinessObjectTestService.
 * 
 * @version $LastChangedRevision: 931 $
 */
public abstract class BusinessObjectTestServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected BusinessObjectTestService businessObjectTestService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public BusinessObjectTestServiceTestBase( String pName ) {
    super(pName);
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided. The userId and the
   * password of a specific user can be given to this Constructor so this specific user can be logged in.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   * @param pUserId UserId of the User who should be logged in for this Test.
   * @param pPassword Password of the User who should be logged in for this Test.
   */
  public BusinessObjectTestServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method testBusinessMethods(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestBusinessMethods( ) throws Exception;

  /**
   * Method test the implementation of service method testBOneToAOne(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestBOneToAOne( ) throws Exception;

  /**
   * Method test the implementation of service method testCreateBusinessObjectsWithUserTypeMapping(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestCreateBusinessObjectsWithUserTypeMapping( ) throws Exception;

  /**
   * Method test the implementation of service method createBusinessObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateBusinessObject( ) throws Exception;

  /**
   * Method test the implementation of service method testCreateSimpleBusinessObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestCreateSimpleBusinessObject( ) throws Exception;

  /**
   * Method test the implementation of service method testDynamicPropertyAccess(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestDynamicPropertyAccess( ) throws Exception;

  /**
   * Method test the implementation of service method testFlush(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestFlush( ) throws Exception;

  /**
   * Method test the implementation of service method getClassA(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetClassA( ) throws Exception;

  /**
   * Method test the implementation of service method testTransactionListener(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestTransactionListener( ) throws Exception;

  /**
   * Method test the implementation of service method testAOneToBOne(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestAOneToBOne( ) throws Exception;

  /**
   * Method test the implementation of service method removeCMany(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testRemoveCMany( ) throws Exception;

  /**
   * Method test the implementation of service method testAttributeAccess(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestAttributeAccess( ) throws Exception;

  /**
   * Method test the implementation of service method updateClassA(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testUpdateClassA( ) throws Exception;

  /**
   * Method test the implementation of service method clearCMany(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testClearCMany( ) throws Exception;

  /**
   * Method test the implementation of service method createClassA(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateClassA( ) throws Exception;

  /**
   * Method test the implementation of service method testInitialObjectCache(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestInitialObjectCache( ) throws Exception;

  /**
   * Method test the implementation of service method testBusinessObjectsWithManyToManyAssociations(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestBusinessObjectsWithManyToManyAssociations( ) throws Exception;

  /**
   * Method test the implementation of service method testServiceObjectsWithOneToManyAssociations(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestServiceObjectsWithOneToManyAssociations( ) throws Exception;

  /**
   * Method test the implementation of service method testMToNReleation(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestMToNReleation( ) throws Exception;

  /**
   * Method test the implementation of service method createABCObjects(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateABCObjects( ) throws Exception;

  /**
   * Method test the implementation of service method testServiceObjectsWithOneToOneAssociations(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestServiceObjectsWithOneToOneAssociations( ) throws Exception;

  /**
   * Method test the implementation of service method testNativeQuery(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestNativeQuery( ) throws Exception;

  /**
   * Method test the implementation of service method testObjectCacheReloading(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestObjectCacheReloading( ) throws Exception;

  /**
   * Method test the implementation of service method deleteBusinessObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeleteBusinessObject( ) throws Exception;

  /**
   * Method test the implementation of service method getCManys(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetCManys( ) throws Exception;

  /**
   * Method test the implementation of service method testJDBCWorker(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestJDBCWorker( ) throws Exception;

  /**
   * Method test the implementation of service method createXOne(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateXOne( ) throws Exception;

  /**
   * Method test the implementation of service method testReadBusinessObjectsWithUserTypeMapping(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestReadBusinessObjectsWithUserTypeMapping( ) throws Exception;

  /**
   * Method test the implementation of service method testBusinessObjectsWithInheritance(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestBusinessObjectsWithInheritance( ) throws Exception;

  /**
   * Method test the implementation of service method addCMany(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testAddCMany( ) throws Exception;

  /**
   * Method test the implementation of service method updateBusinessObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testUpdateBusinessObject( ) throws Exception;

  /**
   * Method test the implementation of service method testQueryWithJPAQL(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestQueryWithJPAQL( ) throws Exception;
}