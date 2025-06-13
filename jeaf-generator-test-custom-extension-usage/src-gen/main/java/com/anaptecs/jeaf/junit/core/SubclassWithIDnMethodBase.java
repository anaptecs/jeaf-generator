/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@JEAFCustomAnnotationTest
public abstract class SubclassWithIDnMethodBase extends IdentifiableServiceObjectWithMethod {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "attr".
   */
  @JEAFCustomAnnotationTest
  public static final String ATTR = "attr";

  // "boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private boolean attr;

  // "boolean"
  private int attrXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SubclassWithIDnMethodBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SubclassWithIDnMethodBase( BuilderBase pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    attr = pBuilder.attr;
    // "boolean"
    attrXYZ = pBuilder.attrXYZ;
  }

  /**
   * Class implements builder to create a new instance of class SubclassWithIDnMethod. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase extends IdentifiableServiceObjectWithMethod.Builder {
    // "boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private boolean attr;

    // "boolean"
    private int attrXYZ = 0;

    /**
     * Use {@link SubclassWithIDnMethod.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
      super();
    }

    /**
     * Use {@link SubclassWithIDnMethod.builder(SubclassWithIDnMethod)} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( SubclassWithIDnMethodBase pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAttr(pObject.attr);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets attribute {@link #hello}.<br/>
     *
     * @param pHello Value to which {@link #hello} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public BuilderBase setHello( Integer pHello ) {
      // Call super class implementation.
      super.setHello(pHello);
      return this;
    }

    /**
     * Method sets attribute {@link #attr}.<br/>
     *
     * @param pAttr Value to which {@link #attr} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setAttr( boolean pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    public BuilderBase setAttrXYZ( int value ) {
      // "boolean"
      attrXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class SubclassWithIDnMethod. The object will be initialized with the values of
     * the builder.
     *
     * @return SubclassWithIDnMethod Created object. The method never returns null.
     */
    public SubclassWithIDnMethod build( ) {
      return new SubclassWithIDnMethod(this);
    }

    /**
     * Method creates a new validated instance of class SubclassWithIDnMethod. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return SubclassWithIDnMethod Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SubclassWithIDnMethod buildValidated( ) throws ConstraintViolationException {
      SubclassWithIDnMethod lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #attr}.<br/>
   *
   * @return boolean Value to which {@link #attr} is set.
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  public boolean getAttr( ) {
    return attr;
  }

  /**
   * Method returns attribute {@link #attr}.<br/>
   *
   * @return boolean Value to which {@link #attr} is set.
   */
  @JEAFCustomAnnotationTest
  public boolean isAttr( ) {
    return attr;
  }

  /**
   * Method sets attribute {@link #attr}.<br/>
   *
   * @param pAttr Value to which {@link #attr} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAttr( boolean pAttr ) {
    // Assign value to attribute
    attr = pAttr;
  }

  public int getAttrXYZ( ) {
    // "boolean"
    return attrXYZ;
  }

  public void setAttrXYZ( int value ) {
    attrXYZ = value;
  }

  /**
   */
  @JEAFCustomAnnotationTest
  public abstract void doMore( );

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("attr: ");
    lBuilder.append(attr);
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
   * @return {@link Builder} New builder that can be used to create new SubclassWithIDnMethod objects. The method never
   * returns null.
   */
  public SubclassWithIDnMethod.Builder toBuilder( ) {
    return new SubclassWithIDnMethod.Builder((SubclassWithIDnMethod) this);
  }
}