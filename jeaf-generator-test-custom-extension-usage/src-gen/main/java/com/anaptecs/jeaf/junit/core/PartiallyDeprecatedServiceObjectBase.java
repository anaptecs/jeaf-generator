/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@JEAFCustomAnnotationTest
public abstract class PartiallyDeprecatedServiceObjectBase extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "outdated".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String OUTDATED = "outdated";

  /**
   * Constant for the name of attribute "deprecatedRef".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String DEPRECATEDREF = "deprecatedRef";

  /**
   * Constant for the name of attribute "deprecatedRefs".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String DEPRECATEDREFS = "deprecatedRefs";

  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  @JEAFCustomAnnotationTest
  public static final String READONLYDEFAULT = "readonlyDefault";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "boolean"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private boolean outdated;

  // "boolean"
  private int outdatedXYZ = 0;

  // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private DeprecatedServiceObject deprecatedRef;

  // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
  private int deprecatedRefXYZ = 0;

  // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private Set<ValidationTestObject> deprecatedRefs;

  // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
  private int deprecatedRefsXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  @JEAFCustomAnnotationTest
  private final int readonlyDefault;

  // "int"
  private int readonlyDefaultXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PartiallyDeprecatedServiceObjectBase( ) {
    deprecatedRefs = new HashSet<>();
    readonlyDefault = 4711;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartiallyDeprecatedServiceObjectBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    // "java.lang.String"
    nameXYZ = pBuilder.nameXYZ;
    outdated = pBuilder.outdated;
    // "boolean"
    outdatedXYZ = pBuilder.outdatedXYZ;
    deprecatedRef = pBuilder.deprecatedRef;
    // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
    deprecatedRefXYZ = pBuilder.deprecatedRefXYZ;
    if (pBuilder.deprecatedRefs != null) {
      deprecatedRefs = pBuilder.deprecatedRefs;
    }
    else {
      deprecatedRefs = new HashSet<>();
    }
    // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
    deprecatedRefsXYZ = pBuilder.deprecatedRefsXYZ;
    readonlyDefault = pBuilder.readonlyDefault;
    // "int"
    readonlyDefaultXYZ = pBuilder.readonlyDefaultXYZ;
  }

  /**
   * Class implements builder to create a new instance of class PartiallyDeprecatedServiceObject. As the class has read
   * only attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String name;

    // "java.lang.String"
    private int nameXYZ = 0;

    // "boolean"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private boolean outdated;

    // "boolean"
    private int outdatedXYZ = 0;

    // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private DeprecatedServiceObject deprecatedRef;

    // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
    private int deprecatedRefXYZ = 0;

    // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private Set<ValidationTestObject> deprecatedRefs;

    // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
    private int deprecatedRefsXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>4711</code>
     */
    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private int readonlyDefault = 4711;

    // "int"
    private int readonlyDefaultXYZ = 0;

    /**
     * Use {@link PartiallyDeprecatedServiceObject.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link PartiallyDeprecatedServiceObject.builder(PartiallyDeprecatedServiceObject)} instead of protected
     * constructor to create new builder.
     */
    protected BuilderBase( PartiallyDeprecatedServiceObjectBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setOutdated(pObject.outdated);
        this.setDeprecatedRef(pObject.deprecatedRef);
        this.setDeprecatedRefs(pObject.deprecatedRefs);
        this.setReadonlyDefault(pObject.readonlyDefault);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public BuilderBase setNameXYZ( int value ) {
      // "java.lang.String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #outdated}.<br/>
     *
     * @param pOutdated Value to which {@link #outdated} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public BuilderBase setOutdated( boolean pOutdated ) {
      // Assign value to attribute
      outdated = pOutdated;
      return this;
    }

    public BuilderBase setOutdatedXYZ( int value ) {
      // "boolean"
      outdatedXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #deprecatedRef}.<br/>
     *
     * @param pDeprecatedRef Value to which {@link #deprecatedRef} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public BuilderBase setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
      deprecatedRef = pDeprecatedRef;
      return this;
    }

    public BuilderBase setDeprecatedRefXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
      deprecatedRefXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #deprecatedRefs}.<br/>
     *
     * @param pDeprecatedRefs Collection to which {@link #deprecatedRefs} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public BuilderBase setDeprecatedRefs( Set<ValidationTestObject> pDeprecatedRefs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDeprecatedRefs != null) {
        deprecatedRefs = new HashSet<ValidationTestObject>(pDeprecatedRefs);
      }
      else {
        deprecatedRefs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #deprecatedRefs}.<br/>
     *
     * @param pDeprecatedRefs Array of objects that should be added to {@link #deprecatedRefs}. The parameter may be
     * null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public BuilderBase addToDeprecatedRefs( ValidationTestObject... pDeprecatedRefs ) {
      if (pDeprecatedRefs != null) {
        if (deprecatedRefs == null) {
          deprecatedRefs = new HashSet<ValidationTestObject>();
        }
        deprecatedRefs.addAll(Arrays.asList(pDeprecatedRefs));
      }
      return this;
    }

    public BuilderBase setDeprecatedRefsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
      deprecatedRefsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #readonlyDefault}.<br/>
     *
     * @param pReadonlyDefault Value to which {@link #readonlyDefault} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

    public BuilderBase setReadonlyDefaultXYZ( int value ) {
      // "int"
      readonlyDefaultXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class PartiallyDeprecatedServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return PartiallyDeprecatedServiceObject Created object. The method never returns null.
     */
    public PartiallyDeprecatedServiceObject build( ) {
      return new PartiallyDeprecatedServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class PartiallyDeprecatedServiceObject. The object will be initialized
     * with the values of the builder and validated afterwards.
     *
     * @return PartiallyDeprecatedServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PartiallyDeprecatedServiceObject buildValidated( ) throws ConstraintViolationException {
      PartiallyDeprecatedServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @JEAFCustomAnnotationTest
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  public int getNameXYZ( ) {
    // "java.lang.String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns attribute {@link #outdated}.<br/>
   *
   * @return boolean Value to which {@link #outdated} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public boolean getOutdated( ) {
    return outdated;
  }

  /**
   * Method returns attribute {@link #outdated}.<br/>
   *
   * @return boolean Value to which {@link #outdated} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public boolean isOutdated( ) {
    return outdated;
  }

  /**
   * Method sets attribute {@link #outdated}.<br/>
   *
   * @param pOutdated Value to which {@link #outdated} should be set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setOutdated( boolean pOutdated ) {
    // Assign value to attribute
    outdated = pOutdated;
  }

  public int getOutdatedXYZ( ) {
    // "boolean"
    return outdatedXYZ;
  }

  public void setOutdatedXYZ( int value ) {
    outdatedXYZ = value;
  }

  /**
   * Method returns association {@link #deprecatedRef}.<br/>
   *
   * @return {@link DeprecatedServiceObject} Value to which {@link #deprecatedRef} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public DeprecatedServiceObject getDeprecatedRef( ) {
    return deprecatedRef;
  }

  /**
   * Method sets association {@link #deprecatedRef}.<br/>
   *
   * @param pDeprecatedRef Value to which {@link #deprecatedRef} should be set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
    deprecatedRef = pDeprecatedRef;
  }

  /**
   * Method unsets {@link #deprecatedRef}.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public final void unsetDeprecatedRef( ) {
    deprecatedRef = null;
  }

  public int getDeprecatedRefXYZ( ) {
    // "com.anaptecs.jeaf.junit.core.DeprecatedServiceObject"
    return deprecatedRefXYZ;
  }

  public void setDeprecatedRefXYZ( int value ) {
    deprecatedRefXYZ = value;
  }

  /**
   * Method returns association {@link #deprecatedRefs}.<br/>
   *
   * @return {@link Set<ValidationTestObject>} Value to which {@link #deprecatedRefs} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public Set<ValidationTestObject> getDeprecatedRefs( ) {
    // Return all ValidationTestObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedRefs);
  }

  /**
   * Method adds the passed object to {@link #deprecatedRefs}.
   *
   * @param pDeprecatedRefs Object that should be added to {@link #deprecatedRefs}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add passed object to collection of associated ValidationTestObject objects.
    deprecatedRefs.add(pDeprecatedRefs);
  }

  /**
   * Method adds all passed objects to {@link #deprecatedRefs}.
   *
   * @param pDeprecatedRefs Collection with all objects that should be added to {@link #deprecatedRefs}. The parameter
   * must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void addToDeprecatedRefs( Collection<ValidationTestObject> pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add all passed objects.
    for (ValidationTestObject lNextObject : pDeprecatedRefs) {
      this.addToDeprecatedRefs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #deprecatedRefs}.<br/>
   *
   * @param pDeprecatedRefs Object that should be removed from {@link #deprecatedRefs}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void removeFromDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Remove passed object from collection of associated ValidationTestObject objects.
    deprecatedRefs.remove(pDeprecatedRefs);
  }

  /**
   * Method removes all objects from {@link #deprecatedRefs}.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void clearDeprecatedRefs( ) {
    // Remove all objects from association "deprecatedRefs".
    deprecatedRefs.clear();
  }

  public int getDeprecatedRefsXYZ( ) {
    // "com.anaptecs.jeaf.junit.core.ValidationTestObject"
    return deprecatedRefsXYZ;
  }

  public void setDeprecatedRefsXYZ( int value ) {
    deprecatedRefsXYZ = value;
  }

  /**
   * Method returns attribute {@link #readonlyDefault}.<br/>
   *
   * @return int Value to which {@link #readonlyDefault} is set.
   */
  @JEAFCustomAnnotationTest
  public int getReadonlyDefault( ) {
    return readonlyDefault;
  }

  public int getReadonlyDefaultXYZ( ) {
    // "int"
    return readonlyDefaultXYZ;
  }

  public void setReadonlyDefaultXYZ( int value ) {
    readonlyDefaultXYZ = value;
  }

  /**
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public abstract void doSomethingDeprecated( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  public abstract String doSomething( @JEAFCustomAnnotationTest int pParam1,
      @Deprecated @JEAFCustomAnnotationTest int pParam2 );

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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("outdated: ");
    lBuilder.append(outdated);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readonlyDefault: ");
    lBuilder.append(readonlyDefault);
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
   * @return {@link Builder} New builder that can be used to create new PartiallyDeprecatedServiceObject objects. The
   * method never returns null.
   */
  public PartiallyDeprecatedServiceObject.Builder toBuilder( ) {
    return new PartiallyDeprecatedServiceObject.Builder((PartiallyDeprecatedServiceObject) this);
  }
}