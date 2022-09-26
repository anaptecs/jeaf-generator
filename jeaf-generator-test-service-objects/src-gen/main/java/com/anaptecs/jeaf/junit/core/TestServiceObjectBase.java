/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * This is a service object that was modeled in order to test the output of the JEAF Generator.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class TestServiceObjectBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "key".
   */
  public static final String KEY = "key";

  /**
   * Constant for the name of attribute "info".
   */
  public static final String INFO = "info";

  /**
   * Constant for the name of attribute "someTest".
   */
  public static final String SOMETEST = "someTest";

  /**
   * Constant for the name of attribute "dummy1".
   */
  public static final String DUMMY1 = "dummy1";

  /**
   * Constant for the name of attribute "dummy2".
   */
  public static final String DUMMY2 = "dummy2";

  /**
   * Constant for the name of attribute "dummy3".
   */
  public static final String DUMMY3 = "dummy3";

  /**
   * 
   */
  private String key;

  /**
   * 
   */
  private String info;

  /**
   * 
   */
  private int someTest;

  /**
   * 
   */
  private Double dummy1;

  /**
   * 
   */
  private String[] dummy2;

  /**
   * 
   */
  private Integer[] dummy3;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TestServiceObjectBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TestServiceObjectBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    key = pBuilder.key;
    info = pBuilder.info;
    someTest = pBuilder.someTest;
    dummy1 = pBuilder.dummy1;
    dummy2 = pBuilder.dummy2;
    dummy3 = pBuilder.dummy3;
  }

  /**
   * Class implements builder to create a new instance of class TestServiceObject. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private String key;

    /**
     * 
     */
    private String info;

    /**
     * 
     */
    private int someTest;

    /**
     * 
     */
    private Double dummy1;

    /**
     * 
     */
    private String[] dummy2;

    /**
     * 
     */
    private Integer[] dummy3;

    /**
     * Use {@link TestServiceObject.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link TestServiceObject.builder(TestServiceObject)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( TestServiceObjectBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        key = pObject.key;
        info = pObject.info;
        someTest = pObject.someTest;
        dummy1 = pObject.dummy1;
        dummy2 = pObject.dummy2;
        dummy3 = pObject.dummy3;
      }
    }

    /**
     * Method sets the attribute "key".
     * 
     * @param pKey Value to which the attribute "key" should be set.
     */
    public BuilderBase setKey( String pKey ) {
      // Assign value to attribute
      key = pKey;
      return this;
    }

    /**
     * Method sets the attribute "info".
     * 
     * @param pInfo Value to which the attribute "info" should be set.
     */
    public BuilderBase setInfo( String pInfo ) {
      // Assign value to attribute
      info = pInfo;
      return this;
    }

    /**
     * Method sets the attribute "someTest".
     * 
     * @param pSomeTest Value to which the attribute "someTest" should be set.
     */
    public BuilderBase setSomeTest( int pSomeTest ) {
      // Assign value to attribute
      someTest = pSomeTest;
      return this;
    }

    /**
     * Method sets the attribute "dummy1".
     * 
     * @param pDummy1 Value to which the attribute "dummy1" should be set.
     */
    public BuilderBase setDummy1( Double pDummy1 ) {
      // Assign value to attribute
      dummy1 = pDummy1;
      return this;
    }

    /**
     * Method sets the attribute "dummy2".
     * 
     * @param pDummy2 Value to which the attribute "dummy2" should be set.
     */
    public BuilderBase setDummy2( String[] pDummy2 ) {
      // Assign value to attribute
      if (pDummy2 != null) {
        dummy2 = new String[pDummy2.length];
        System.arraycopy(pDummy2, 0, dummy2, 0, pDummy2.length);
      }
      else {
        dummy2 = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "dummy3".
     * 
     * @param pDummy3 Value to which the attribute "dummy3" should be set.
     */
    public BuilderBase setDummy3( Integer[] pDummy3 ) {
      // Assign value to attribute
      if (pDummy3 != null) {
        dummy3 = new Integer[pDummy3.length];
        System.arraycopy(pDummy3, 0, dummy3, 0, pDummy3.length);
      }
      else {
        dummy3 = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class TestServiceObject. The object will be initialized with the values of the
     * builder.
     * 
     * @return TestServiceObject Created object. The method never returns null.
     */
    public TestServiceObject build( ) {
      return new TestServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class TestServiceObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return TestServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TestServiceObject buildValidated( ) throws ConstraintViolationException {
      TestServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "key".
   * 
   * 
   * @return String Value to which the attribute "key" is set.
   */
  public String getKey( ) {
    return key;
  }

  /**
   * Method sets the attribute "key".
   * 
   * 
   * @param pKey Value to which the attribute "key" should be set.
   */
  public void setKey( String pKey ) {
    // Assign value to attribute
    key = pKey;
  }

  /**
   * Method returns the attribute "info".
   * 
   * 
   * @return String Value to which the attribute "info" is set.
   */
  public String getInfo( ) {
    return info;
  }

  /**
   * Method sets the attribute "info".
   * 
   * 
   * @param pInfo Value to which the attribute "info" should be set.
   */
  public void setInfo( String pInfo ) {
    // Assign value to attribute
    info = pInfo;
  }

  /**
   * Method returns the attribute "someTest".
   * 
   * 
   * @return int Value to which the attribute "someTest" is set.
   */
  public int getSomeTest( ) {
    return someTest;
  }

  /**
   * Method sets the attribute "someTest".
   * 
   * 
   * @param pSomeTest Value to which the attribute "someTest" should be set.
   */
  public void setSomeTest( int pSomeTest ) {
    // Assign value to attribute
    someTest = pSomeTest;
  }

  /**
   * Method returns the attribute "dummy1".
   * 
   * 
   * @return Double Value to which the attribute "dummy1" is set.
   */
  public Double getDummy1( ) {
    return dummy1;
  }

  /**
   * Method sets the attribute "dummy1".
   * 
   * 
   * @param pDummy1 Value to which the attribute "dummy1" should be set.
   */
  public void setDummy1( Double pDummy1 ) {
    // Assign value to attribute
    dummy1 = pDummy1;
  }

  /**
   * Method returns the attribute "dummy2".
   * 
   * 
   * @return String Value to which the attribute "dummy2" is set.
   */
  public String[] getDummy2( ) {
    String[] lReturnValue;
    if (dummy2 != null) {
      lReturnValue = new String[dummy2.length];
      System.arraycopy(dummy2, 0, lReturnValue, 0, dummy2.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "dummy2".
   * 
   * 
   * @param pDummy2 Value to which the attribute "dummy2" should be set.
   */
  public void setDummy2( String[] pDummy2 ) {
    // Assign value to attribute
    if (pDummy2 != null) {
      dummy2 = new String[pDummy2.length];
      System.arraycopy(pDummy2, 0, dummy2, 0, pDummy2.length);
    }
    else {
      dummy2 = null;
    }
  }

  /**
   * Method returns the attribute "dummy3".
   * 
   * 
   * @return Integer Value to which the attribute "dummy3" is set.
   */
  public Integer[] getDummy3( ) {
    Integer[] lReturnValue;
    if (dummy3 != null) {
      lReturnValue = new Integer[dummy3.length];
      System.arraycopy(dummy3, 0, lReturnValue, 0, dummy3.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "dummy3".
   * 
   * 
   * @param pDummy3 Value to which the attribute "dummy3" should be set.
   */
  public void setDummy3( Integer[] pDummy3 ) {
    // Assign value to attribute
    if (pDummy3 != null) {
      dummy3 = new Integer[pDummy3.length];
      System.arraycopy(pDummy3, 0, dummy3, 0, pDummy3.length);
    }
    else {
      dummy3 = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "key", "" + key));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "info", "" + info));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "someTest", "" + someTest));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "dummy1", "" + dummy1));
    lBuilder.append('\n');
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   * 
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder().toString();
  }
}
