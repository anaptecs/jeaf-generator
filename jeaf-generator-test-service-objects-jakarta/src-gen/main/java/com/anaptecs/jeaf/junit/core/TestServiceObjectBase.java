/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
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

  private String key;

  private String info;

  private int someTest;

  private Double dummy1;

  private Set<String> dummy2;

  private Set<Integer> dummy3;

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
    private String key;

    private String info;

    private int someTest;

    private Double dummy1;

    private Set<String> dummy2;

    private Set<Integer> dummy3;

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
    public BuilderBase setKey( String pKey ) {
      // Assign value to attribute
      key = pKey;
      return this;
    }

    /**
     * Method sets attribute {@link #info}.<br/>
     *
     * @param pInfo Value to which {@link #info} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setInfo( String pInfo ) {
      // Assign value to attribute
      info = pInfo;
      return this;
    }

    /**
     * Method sets attribute {@link #someTest}.<br/>
     *
     * @param pSomeTest Value to which {@link #someTest} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSomeTest( int pSomeTest ) {
      // Assign value to attribute
      someTest = pSomeTest;
      return this;
    }

    /**
     * Method sets attribute {@link #dummy1}.<br/>
     *
     * @param pDummy1 Value to which {@link #dummy1} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDummy1( Double pDummy1 ) {
      // Assign value to attribute
      dummy1 = pDummy1;
      return this;
    }

    /**
     * Method sets attribute {@link #dummy2}.<br/>
     *
     * @param pDummy2 Collection to which {@link #dummy2} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDummy2( Set<String> pDummy2 ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDummy2 != null) {
        dummy2 = new HashSet<String>(pDummy2);
      }
      else {
        dummy2 = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #dummy2}.<br/>
     *
     * @param pDummy2 Array of objects that should be added to {@link #dummy2}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToDummy2( String... pDummy2 ) {
      if (pDummy2 != null) {
        if (dummy2 == null) {
          dummy2 = new HashSet<String>();
        }
        dummy2.addAll(Arrays.asList(pDummy2));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #dummy3}.<br/>
     *
     * @param pDummy3 Collection to which {@link #dummy3} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDummy3( Set<Integer> pDummy3 ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDummy3 != null) {
        dummy3 = new HashSet<Integer>(pDummy3);
      }
      else {
        dummy3 = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #dummy3}.<br/>
     *
     * @param pDummy3 Array of objects that should be added to {@link #dummy3}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToDummy3( Integer... pDummy3 ) {
      if (pDummy3 != null) {
        if (dummy3 == null) {
          dummy3 = new HashSet<Integer>();
        }
        dummy3.addAll(Arrays.asList(pDummy3));
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
      TestServiceObject lObject = new TestServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
  public String getKey( ) {
    return key;
  }

  /**
   * Method sets attribute {@link #key}.<br/>
   *
   * @param pKey Value to which {@link #key} should be set.
   */
  public void setKey( String pKey ) {
    // Assign value to attribute
    key = pKey;
  }

  /**
   * Method returns attribute {@link #info}.<br/>
   *
   * @return {@link String} Value to which {@link #info} is set.
   */
  public String getInfo( ) {
    return info;
  }

  /**
   * Method sets attribute {@link #info}.<br/>
   *
   * @param pInfo Value to which {@link #info} should be set.
   */
  public void setInfo( String pInfo ) {
    // Assign value to attribute
    info = pInfo;
  }

  /**
   * Method returns attribute {@link #someTest}.<br/>
   *
   * @return int Value to which {@link #someTest} is set.
   */
  public int getSomeTest( ) {
    return someTest;
  }

  /**
   * Method sets attribute {@link #someTest}.<br/>
   *
   * @param pSomeTest Value to which {@link #someTest} should be set.
   */
  public void setSomeTest( int pSomeTest ) {
    // Assign value to attribute
    someTest = pSomeTest;
  }

  /**
   * Method returns attribute {@link #dummy1}.<br/>
   *
   * @return {@link Double} Value to which {@link #dummy1} is set.
   */
  public Double getDummy1( ) {
    return dummy1;
  }

  /**
   * Method sets attribute {@link #dummy1}.<br/>
   *
   * @param pDummy1 Value to which {@link #dummy1} should be set.
   */
  public void setDummy1( Double pDummy1 ) {
    // Assign value to attribute
    dummy1 = pDummy1;
  }

  /**
   * Method returns attribute {@link #dummy2}.<br/>
   *
   * @return {@link Set<String>} Value to which {@link #dummy2} is set.
   */
  public Set<String> getDummy2( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(dummy2);
  }

  /**
   * Method adds the passed object to {@link #dummy2}.
   *
   * @param pDummy2 Object that should be added to {@link #dummy2}. The parameter must not be null.
   */
  public void addToDummy2( String pDummy2 ) {
    // Check parameter "pDummy2" for invalid value null.
    Check.checkInvalidParameterNull(pDummy2, "pDummy2");
    // Add passed object to collection of associated String objects.
    dummy2.add(pDummy2);
  }

  /**
   * Method adds all passed objects to {@link #dummy2}.
   *
   * @param pDummy2 Collection with all objects that should be added to {@link #dummy2}. The parameter must not be null.
   */
  public void addToDummy2( Collection<String> pDummy2 ) {
    // Check parameter "pDummy2" for invalid value null.
    Check.checkInvalidParameterNull(pDummy2, "pDummy2");
    // Add all passed objects.
    for (String lNextObject : pDummy2) {
      this.addToDummy2(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #dummy2}.<br/>
   *
   * @param pDummy2 Object that should be removed from {@link #dummy2}. The parameter must not be null.
   */
  public void removeFromDummy2( String pDummy2 ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDummy2, "pDummy2");
    // Remove passed object from collection of associated String objects.
    dummy2.remove(pDummy2);
  }

  /**
   * Method removes all objects from {@link #dummy2}.
   */
  public void clearDummy2( ) {
    // Remove all objects from association "dummy2".
    dummy2.clear();
  }

  /**
   * Method returns attribute {@link #dummy3}.<br/>
   *
   * @return {@link Set<Integer>} Value to which {@link #dummy3} is set.
   */
  public Set<Integer> getDummy3( ) {
    // Return all Integer objects as unmodifiable collection.
    return Collections.unmodifiableSet(dummy3);
  }

  /**
   * Method adds the passed object to {@link #dummy3}.
   *
   * @param pDummy3 Object that should be added to {@link #dummy3}. The parameter must not be null.
   */
  public void addToDummy3( Integer pDummy3 ) {
    // Check parameter "pDummy3" for invalid value null.
    Check.checkInvalidParameterNull(pDummy3, "pDummy3");
    // Add passed object to collection of associated Integer objects.
    dummy3.add(pDummy3);
  }

  /**
   * Method adds all passed objects to {@link #dummy3}.
   *
   * @param pDummy3 Collection with all objects that should be added to {@link #dummy3}. The parameter must not be null.
   */
  public void addToDummy3( Collection<Integer> pDummy3 ) {
    // Check parameter "pDummy3" for invalid value null.
    Check.checkInvalidParameterNull(pDummy3, "pDummy3");
    // Add all passed objects.
    for (Integer lNextObject : pDummy3) {
      this.addToDummy3(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #dummy3}.<br/>
   *
   * @param pDummy3 Object that should be removed from {@link #dummy3}. The parameter must not be null.
   */
  public void removeFromDummy3( Integer pDummy3 ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDummy3, "pDummy3");
    // Remove passed object from collection of associated Integer objects.
    dummy3.remove(pDummy3);
  }

  /**
   * Method removes all objects from {@link #dummy3}.
   */
  public void clearDummy3( ) {
    // Remove all objects from association "dummy3".
    dummy3.clear();
  }

  /**
   * Convenience method to create new instance of class TestServiceObject.
   *
   *
   * @param pKey Value to which {@link #key} should be set.
   *
   * @param pInfo Value to which {@link #info} should be set.
   *
   * @param pSomeTest Value to which {@link #someTest} should be set.
   *
   * @param pDummy2 Value to which {@link #dummy2} should be set.
   *
   * @return {@link TestServiceObject}
   */
  public static TestServiceObject of( String pKey, String pInfo, int pSomeTest, Set<String> pDummy2 ) {
    var lBuilder = TestServiceObject.builder();
    lBuilder.setKey(pKey);
    lBuilder.setInfo(pInfo);
    lBuilder.setSomeTest(pSomeTest);
    lBuilder.setDummy2(pDummy2);
    return lBuilder.build();
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