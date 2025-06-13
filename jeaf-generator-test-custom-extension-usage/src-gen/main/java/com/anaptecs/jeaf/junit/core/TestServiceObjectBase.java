/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * This is a service object that was modeled in order to test the output of the JEAF Generator.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public abstract class TestServiceObjectBase extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "key".
   */
  @JEAFCustomAnnotationTest
  public static final String KEY = "key";

  /**
   * Constant for the name of attribute "info".
   */
  @JEAFCustomAnnotationTest
  public static final String INFO = "info";

  /**
   * Constant for the name of attribute "someTest".
   */
  @JEAFCustomAnnotationTest
  public static final String SOMETEST = "someTest";

  /**
   * Constant for the name of attribute "dummy1".
   */
  @JEAFCustomAnnotationTest
  public static final String DUMMY1 = "dummy1";

  /**
   * Constant for the name of attribute "dummy2".
   */
  @JEAFCustomAnnotationTest
  public static final String DUMMY2 = "dummy2";

  /**
   * Constant for the name of attribute "dummy3".
   */
  @JEAFCustomAnnotationTest
  public static final String DUMMY3 = "dummy3";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String key;

  // "java.lang.String"
  private int keyXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String info;

  // "java.lang.String"
  private int infoXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private int someTest;

  // "int"
  private int someTestXYZ = 0;

  // "java.lang.Double"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Double dummy1;

  // "java.lang.Double"
  private int dummy1XYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String[] dummy2;

  // "java.lang.String"
  private int dummy2XYZ = 0;

  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Integer[] dummy3;

  // "java.lang.Integer"
  private int dummy3XYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
    // "java.lang.String"
    keyXYZ = pBuilder.keyXYZ;
    info = pBuilder.info;
    // "java.lang.String"
    infoXYZ = pBuilder.infoXYZ;
    someTest = pBuilder.someTest;
    // "int"
    someTestXYZ = pBuilder.someTestXYZ;
    dummy1 = pBuilder.dummy1;
    // "java.lang.Double"
    dummy1XYZ = pBuilder.dummy1XYZ;
    dummy2 = pBuilder.dummy2;
    // "java.lang.String"
    dummy2XYZ = pBuilder.dummy2XYZ;
    dummy3 = pBuilder.dummy3;
    // "java.lang.Integer"
    dummy3XYZ = pBuilder.dummy3XYZ;
  }

  /**
   * Class implements builder to create a new instance of class TestServiceObject. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String key;

    // "java.lang.String"
    private int keyXYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String info;

    // "java.lang.String"
    private int infoXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private int someTest;

    // "int"
    private int someTestXYZ = 0;

    // "java.lang.Double"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Double dummy1;

    // "java.lang.Double"
    private int dummy1XYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String[] dummy2;

    // "java.lang.String"
    private int dummy2XYZ = 0;

    // "java.lang.Integer"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Integer[] dummy3;

    // "java.lang.Integer"
    private int dummy3XYZ = 0;

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
        this.setKey(pObject.key);
        this.setInfo(pObject.info);
        this.setSomeTest(pObject.someTest);
        this.setDummy1(pObject.dummy1);
        this.setDummy2(pObject.dummy2);
        this.setDummy3(pObject.dummy3);
      }
    }

    /**
     * Method sets attribute {@link #key}.<br/>
     *
     * @param pKey Value to which {@link #key} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setKey( String pKey ) {
      // Assign value to attribute
      key = pKey;
      return this;
    }

    public BuilderBase setKeyXYZ( int value ) {
      // "java.lang.String"
      keyXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #info}.<br/>
     *
     * @param pInfo Value to which {@link #info} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setInfo( String pInfo ) {
      // Assign value to attribute
      info = pInfo;
      return this;
    }

    public BuilderBase setInfoXYZ( int value ) {
      // "java.lang.String"
      infoXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #someTest}.<br/>
     *
     * @param pSomeTest Value to which {@link #someTest} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setSomeTest( int pSomeTest ) {
      // Assign value to attribute
      someTest = pSomeTest;
      return this;
    }

    public BuilderBase setSomeTestXYZ( int value ) {
      // "int"
      someTestXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #dummy1}.<br/>
     *
     * @param pDummy1 Value to which {@link #dummy1} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setDummy1( Double pDummy1 ) {
      // Assign value to attribute
      dummy1 = pDummy1;
      return this;
    }

    public BuilderBase setDummy1XYZ( int value ) {
      // "java.lang.Double"
      dummy1XYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #dummy2}.<br/>
     *
     * @param pDummy2 Collection to which {@link #dummy2} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
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

    public BuilderBase setDummy2XYZ( int value ) {
      // "java.lang.String"
      dummy2XYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #dummy3}.<br/>
     *
     * @param pDummy3 Collection to which {@link #dummy3} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
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

    public BuilderBase setDummy3XYZ( int value ) {
      // "java.lang.Integer"
      dummy3XYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
   * Method returns attribute {@link #key}.<br/>
   *
   * @return {@link String} Value to which {@link #key} is set.
   */
  @JEAFCustomAnnotationTest
  public String getKey( ) {
    return key;
  }

  /**
   * Method sets attribute {@link #key}.<br/>
   *
   * @param pKey Value to which {@link #key} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setKey( String pKey ) {
    // Assign value to attribute
    key = pKey;
  }

  public int getKeyXYZ( ) {
    // "java.lang.String"
    return keyXYZ;
  }

  public void setKeyXYZ( int value ) {
    keyXYZ = value;
  }

  /**
   * Method returns attribute {@link #info}.<br/>
   *
   * @return {@link String} Value to which {@link #info} is set.
   */
  @JEAFCustomAnnotationTest
  public String getInfo( ) {
    return info;
  }

  /**
   * Method sets attribute {@link #info}.<br/>
   *
   * @param pInfo Value to which {@link #info} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setInfo( String pInfo ) {
    // Assign value to attribute
    info = pInfo;
  }

  public int getInfoXYZ( ) {
    // "java.lang.String"
    return infoXYZ;
  }

  public void setInfoXYZ( int value ) {
    infoXYZ = value;
  }

  /**
   * Method returns attribute {@link #someTest}.<br/>
   *
   * @return int Value to which {@link #someTest} is set.
   */
  @JEAFCustomAnnotationTest
  public int getSomeTest( ) {
    return someTest;
  }

  /**
   * Method sets attribute {@link #someTest}.<br/>
   *
   * @param pSomeTest Value to which {@link #someTest} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setSomeTest( int pSomeTest ) {
    // Assign value to attribute
    someTest = pSomeTest;
  }

  public int getSomeTestXYZ( ) {
    // "int"
    return someTestXYZ;
  }

  public void setSomeTestXYZ( int value ) {
    someTestXYZ = value;
  }

  /**
   * Method returns attribute {@link #dummy1}.<br/>
   *
   * @return {@link Double} Value to which {@link #dummy1} is set.
   */
  @JEAFCustomAnnotationTest
  public Double getDummy1( ) {
    return dummy1;
  }

  /**
   * Method sets attribute {@link #dummy1}.<br/>
   *
   * @param pDummy1 Value to which {@link #dummy1} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setDummy1( Double pDummy1 ) {
    // Assign value to attribute
    dummy1 = pDummy1;
  }

  public int getDummy1XYZ( ) {
    // "java.lang.Double"
    return dummy1XYZ;
  }

  public void setDummy1XYZ( int value ) {
    dummy1XYZ = value;
  }

  /**
   * Method returns attribute {@link #dummy2}.<br/>
   *
   * @return {@link String[]} Value to which {@link #dummy2} is set.
   */
  @JEAFCustomAnnotationTest
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
   * Method sets attribute {@link #dummy2}.<br/>
   *
   * @param pDummy2 Value to which {@link #dummy2} should be set.
   */
  @JEAFCustomAnnotationTest
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

  public int getDummy2XYZ( ) {
    // "java.lang.String"
    return dummy2XYZ;
  }

  public void setDummy2XYZ( int value ) {
    dummy2XYZ = value;
  }

  /**
   * Method returns attribute {@link #dummy3}.<br/>
   *
   * @return {@link Integer[]} Value to which {@link #dummy3} is set.
   */
  @JEAFCustomAnnotationTest
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
   * Method sets attribute {@link #dummy3}.<br/>
   *
   * @param pDummy3 Value to which {@link #dummy3} should be set.
   */
  @JEAFCustomAnnotationTest
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

  public int getDummy3XYZ( ) {
    // "java.lang.Integer"
    return dummy3XYZ;
  }

  public void setDummy3XYZ( int value ) {
    dummy3XYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("key: ");
    lBuilder.append(key);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("info: ");
    lBuilder.append(info);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("someTest: ");
    lBuilder.append(someTest);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dummy1: ");
    lBuilder.append(dummy1);
    lBuilder.append(System.lineSeparator());
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
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new TestServiceObject objects. The method never
   * returns null.
   */
  public TestServiceObject.Builder toBuilder( ) {
    return new TestServiceObject.Builder((TestServiceObject) this);
  }
}