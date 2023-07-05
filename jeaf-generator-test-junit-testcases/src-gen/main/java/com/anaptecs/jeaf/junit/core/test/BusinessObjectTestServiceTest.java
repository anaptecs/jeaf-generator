/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service BusinessObjectTestService.
 */
public class BusinessObjectTestServiceTest extends BusinessObjectTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("BusinessObjectTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestBusinessMethods"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestBOneToAOne"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestCreateBusinessObjectsWithUserTypeMapping"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testCreateBusinessObject"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestCreateSimpleBusinessObject"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestDynamicPropertyAccess"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestFlush"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testGetClassA"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestTransactionListener"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestAOneToBOne"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testRemoveCMany"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestAttributeAccess"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testDeprectedOperation"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testUpdateClassA"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testClearCMany"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testCreateClassA"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestInitialObjectCache"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestBusinessObjectsWithManyToManyAssociations"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestServiceObjectsWithOneToManyAssociations"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestMToNReleation"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testCreateABCObjects"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestServiceObjectsWithOneToOneAssociations"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestNativeQuery"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestObjectCacheReloading"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testDeleteBusinessObject"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testGetCManys"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestJDBCWorker"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testCreateXOne"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestReadBusinessObjectsWithUserTypeMapping"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestBusinessObjectsWithInheritance"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testAddCMany"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testUpdateBusinessObject"));
    lSuite.addTest(new BusinessObjectTestServiceTest("testTestQueryWithJPAQL"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public BusinessObjectTestServiceTest( String pName ) {
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
  public BusinessObjectTestServiceTest( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method performs test case specific initialization routines. If a test case implementation requires some special
   * operations at startup this method can be overridden.
   *
   * @throws Exception if an error occurs during initialization.
   */
  @Override
  protected void init( ) throws Exception {
    super.init();
    // TODO Add additional initializations if required.
  }

  /**
   * Method test the implementation of service method testBusinessMethods
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestBusinessMethods( ) throws Exception {
    // TODO Implement test for service method testBusinessMethods(...)
  }

  /**
   * Method test the implementation of service method testBOneToAOne
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestBOneToAOne( ) throws Exception {
    // TODO Implement test for service method testBOneToAOne(...)
  }

  /**
   * Method test the implementation of service method testCreateBusinessObjectsWithUserTypeMapping
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestCreateBusinessObjectsWithUserTypeMapping( ) throws Exception {
    // TODO Implement test for service method testCreateBusinessObjectsWithUserTypeMapping(...)
  }

  /**
   * Method test the implementation of service method createBusinessObject
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateBusinessObject( ) throws Exception {
    // TODO Implement test for service method createBusinessObject(...)
  }

  /**
   * Method test the implementation of service method testCreateSimpleBusinessObject
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestCreateSimpleBusinessObject( ) throws Exception {
    // TODO Implement test for service method testCreateSimpleBusinessObject(...)
  }

  /**
   * Method test the implementation of service method testDynamicPropertyAccess
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestDynamicPropertyAccess( ) throws Exception {
    // TODO Implement test for service method testDynamicPropertyAccess(...)
  }

  /**
   * Method test the implementation of service method testFlush
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestFlush( ) throws Exception {
    // TODO Implement test for service method testFlush(...)
  }

  /**
   * Method test the implementation of service method getClassA
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetClassA( ) throws Exception {
    // TODO Implement test for service method getClassA(...)
  }

  /**
   * Method test the implementation of service method testTransactionListener
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestTransactionListener( ) throws Exception {
    // TODO Implement test for service method testTransactionListener(...)
  }

  /**
   * Method test the implementation of service method testAOneToBOne
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestAOneToBOne( ) throws Exception {
    // TODO Implement test for service method testAOneToBOne(...)
  }

  /**
   * Method test the implementation of service method removeCMany
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testRemoveCMany( ) throws Exception {
    // TODO Implement test for service method removeCMany(...)
  }

  /**
   * Method test the implementation of service method testAttributeAccess
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestAttributeAccess( ) throws Exception {
    // TODO Implement test for service method testAttributeAccess(...)
  }

  /**
   * Method test the implementation of service method deprectedOperation
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprectedOperation( ) throws Exception {
    // TODO Implement test for service method deprectedOperation(...)
  }

  /**
   * Method test the implementation of service method updateClassA
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testUpdateClassA( ) throws Exception {
    // TODO Implement test for service method updateClassA(...)
  }

  /**
   * Method test the implementation of service method clearCMany
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testClearCMany( ) throws Exception {
    // TODO Implement test for service method clearCMany(...)
  }

  /**
   * Method test the implementation of service method createClassA
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateClassA( ) throws Exception {
    // TODO Implement test for service method createClassA(...)
  }

  /**
   * Method test the implementation of service method testInitialObjectCache
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestInitialObjectCache( ) throws Exception {
    // TODO Implement test for service method testInitialObjectCache(...)
  }

  /**
   * Method test the implementation of service method testBusinessObjectsWithManyToManyAssociations
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestBusinessObjectsWithManyToManyAssociations( ) throws Exception {
    // TODO Implement test for service method testBusinessObjectsWithManyToManyAssociations(...)
  }

  /**
   * Method test the implementation of service method testServiceObjectsWithOneToManyAssociations
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestServiceObjectsWithOneToManyAssociations( ) throws Exception {
    // TODO Implement test for service method testServiceObjectsWithOneToManyAssociations(...)
  }

  /**
   * Method test the implementation of service method testMToNReleation
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestMToNReleation( ) throws Exception {
    // TODO Implement test for service method testMToNReleation(...)
  }

  /**
   * Method test the implementation of service method createABCObjects
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateABCObjects( ) throws Exception {
    // TODO Implement test for service method createABCObjects(...)
  }

  /**
   * Method test the implementation of service method testServiceObjectsWithOneToOneAssociations
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestServiceObjectsWithOneToOneAssociations( ) throws Exception {
    // TODO Implement test for service method testServiceObjectsWithOneToOneAssociations(...)
  }

  /**
   * Method test the implementation of service method testNativeQuery
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestNativeQuery( ) throws Exception {
    // TODO Implement test for service method testNativeQuery(...)
  }

  /**
   * Method test the implementation of service method testObjectCacheReloading
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestObjectCacheReloading( ) throws Exception {
    // TODO Implement test for service method testObjectCacheReloading(...)
  }

  /**
   * Method test the implementation of service method deleteBusinessObject
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeleteBusinessObject( ) throws Exception {
    // TODO Implement test for service method deleteBusinessObject(...)
  }

  /**
   * Method test the implementation of service method getCManys
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetCManys( ) throws Exception {
    // TODO Implement test for service method getCManys(...)
  }

  /**
   * Method test the implementation of service method testJDBCWorker
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestJDBCWorker( ) throws Exception {
    // TODO Implement test for service method testJDBCWorker(...)
  }

  /**
   * Method test the implementation of service method createXOne
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateXOne( ) throws Exception {
    // TODO Implement test for service method createXOne(...)
  }

  /**
   * Method test the implementation of service method testReadBusinessObjectsWithUserTypeMapping
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestReadBusinessObjectsWithUserTypeMapping( ) throws Exception {
    // TODO Implement test for service method testReadBusinessObjectsWithUserTypeMapping(...)
  }

  /**
   * Method test the implementation of service method testBusinessObjectsWithInheritance
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestBusinessObjectsWithInheritance( ) throws Exception {
    // TODO Implement test for service method testBusinessObjectsWithInheritance(...)
  }

  /**
   * Method test the implementation of service method addCMany
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testAddCMany( ) throws Exception {
    // TODO Implement test for service method addCMany(...)
  }

  /**
   * Method test the implementation of service method updateBusinessObject
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testUpdateBusinessObject( ) throws Exception {
    // TODO Implement test for service method updateBusinessObject(...)
  }

  /**
   * Method test the implementation of service method testQueryWithJPAQL
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestQueryWithJPAQL( ) throws Exception {
    // TODO Implement test for service method testQueryWithJPAQL(...)
  }
}