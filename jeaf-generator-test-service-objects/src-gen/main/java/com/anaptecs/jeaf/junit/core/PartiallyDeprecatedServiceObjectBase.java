/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class PartiallyDeprecatedServiceObjectBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "outdated".
   */
  @Deprecated
  public static final String OUTDATED = "outdated";

  /**
   * Constant for the name of attribute "deprecatedRef".
   */
  @Deprecated
  public static final String DEPRECATEDREF = "deprecatedRef";

  /**
   * Constant for the name of attribute "deprecatedRefs".
   */
  @Deprecated
  public static final String DEPRECATEDREFS = "deprecatedRefs";

  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  private String name;

  @Deprecated
  private boolean outdated;

  @Deprecated
  private DeprecatedServiceObject deprecatedRef;

  @Deprecated
  private Set<ValidationTestObject> deprecatedRefs;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PartiallyDeprecatedServiceObjectBase( ) {
    deprecatedRefs = new HashSet<ValidationTestObject>();
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
    outdated = pBuilder.outdated;
    deprecatedRef = pBuilder.deprecatedRef;
    if (pBuilder.deprecatedRefs != null) {
      deprecatedRefs = pBuilder.deprecatedRefs;
    }
    else {
      deprecatedRefs = new HashSet<ValidationTestObject>();
    }
    readonlyDefault = pBuilder.readonlyDefault;
  }

  /**
   * Class implements builder to create a new instance of class PartiallyDeprecatedServiceObject. As the class has read
   * only attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    @Deprecated
    private boolean outdated;

    /**
     * 
     */
    @Deprecated
    private DeprecatedServiceObject deprecatedRef;

    /**
     * 
     */
    @Deprecated
    private Set<ValidationTestObject> deprecatedRefs;

    /**
     * 
     */
    private int readonlyDefault = 4711;

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
        name = pObject.name;
        outdated = pObject.outdated;
        deprecatedRef = pObject.deprecatedRef;
        deprecatedRefs = pObject.deprecatedRefs;
        readonlyDefault = pObject.readonlyDefault;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "outdated".
     * 
     * @param pOutdated Value to which the attribute "outdated" should be set.
     */
    @Deprecated
    public BuilderBase setOutdated( boolean pOutdated ) {
      // Assign value to attribute
      outdated = pOutdated;
      return this;
    }

    /**
     * Method sets the association "deprecatedRef".
     * 
     * @param pDeprecatedRef DeprecatedServiceObject to which the association "deprecatedRef" should be set.
     */
    @Deprecated
    public BuilderBase setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
      deprecatedRef = pDeprecatedRef;
      return this;
    }

    /**
     * Method sets the association "deprecatedRefs".
     * 
     * @param pDeprecatedRefs Collection with objects to which the association should be set.
     */
    @Deprecated
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
     * Method sets the attribute "readonlyDefault".
     * 
     * @param pReadonlyDefault Value to which the attribute "readonlyDefault" should be set.
     */
    public BuilderBase setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

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
   * Method returns attribute {@link #outdated}.<br/>
   * 
   * @return boolean Value to which {@link #outdated} is set.
   */
  @Deprecated
  public boolean getOutdated( ) {
    return outdated;
  }

  /**
   * Method sets attribute {@link #outdated}.<br/>
   * 
   * @param pOutdated Value to which {@link #outdated} should be set.
   */
  @Deprecated
  public void setOutdated( boolean pOutdated ) {
    // Assign value to attribute
    outdated = pOutdated;
  }

  /**
   * Method returns the association "deprecatedRef".
   * 
   *
   * @return DeprecatedServiceObject DeprecatedServiceObject to which the association "deprecatedRef" is set.
   */
  @Deprecated
  public DeprecatedServiceObject getDeprecatedRef( ) {
    return deprecatedRef;
  }

  /**
   * Method sets the association "deprecatedRef".
   * 
   * 
   * @param pDeprecatedRef DeprecatedServiceObject to which the association "deprecatedRef" should be set.
   */
  @Deprecated
  public void setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
    deprecatedRef = pDeprecatedRef;
  }

  /**
   * Method unsets the association "deprecatedRef".
   * 
   */
  @Deprecated
  public final void unsetDeprecatedRef( ) {
    deprecatedRef = null;
  }

  /**
   * Method returns the association "deprecatedRefs".
   * 
   *
   * @return Collection All ValidationTestObject objects that belong to the association "deprecatedRefs". The method
   * never returns null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ValidationTestObject> getDeprecatedRefs( ) {
    // Return all ValidationTestObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedRefs);
  }

  /**
   * Method adds the passed ValidationTestObject object to the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be added to the association "deprecatedRefs". The parameter must not be
   * null.
   */
  @Deprecated
  public void addToDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add passed object to collection of associated ValidationTestObject objects.
    deprecatedRefs.add(pDeprecatedRefs);
  }

  /**
   * Method adds all passed objects to the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Collection with all objects that should be added to the association "deprecatedRefs". The
   * parameter must not be null.
   */
  @Deprecated
  public void addToDeprecatedRefs( Collection<ValidationTestObject> pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add all passed objects.
    for (ValidationTestObject lNextObject : pDeprecatedRefs) {
      this.addToDeprecatedRefs(lNextObject);
    }
  }

  /**
   * Method removes the passed ValidationTestObject object from the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be removed from the association "deprecatedRefs". The parameter must not
   * be null.
   */
  @Deprecated
  public void removeFromDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Remove passed object from collection of associated ValidationTestObject objects.
    deprecatedRefs.remove(pDeprecatedRefs);
  }

  /**
   * Method removes all objects from the association "deprecatedRefs".
   * 
   */
  @Deprecated
  public void clearDeprecatedRefs( ) {
    // Remove all objects from association "deprecatedRefs".
    deprecatedRefs.clear();
  }

  /**
   * Method returns attribute {@link #readonlyDefault}.<br/>
   * 
   * @return int Value to which {@link #readonlyDefault} is set.
   */
  public int getReadonlyDefault( ) {
    return readonlyDefault;
  }

  /**
   */
  @Deprecated
  public abstract void doSomethingDeprecated( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  public abstract String doSomething( int pParam1, @Deprecated int pParam2 );

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
}
