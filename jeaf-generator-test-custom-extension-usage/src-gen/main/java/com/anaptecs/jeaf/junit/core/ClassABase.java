/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@JEAFCustomAnnotationTest
public abstract class ClassABase extends Object implements ServiceObject, Identifiable<ServiceObjectID> {
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
   * Constant for the name of attribute "oneB".
   */
  @JEAFCustomAnnotationTest
  public static final String ONEB = "oneB";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.core.ClassB"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private ClassB oneB;

  // "com.anaptecs.jeaf.junit.core.ClassB"
  private int oneBXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ClassABase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ClassABase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    name = pBuilder.name;
    // "java.lang.String"
    nameXYZ = pBuilder.nameXYZ;
    oneB = pBuilder.oneB;
    if (oneB != null) {
      // As association is bidirectional we also have to set it in the other direction.
      oneB.addToManyAs((ClassA) this);
    }
    // "com.anaptecs.jeaf.junit.core.ClassB"
    oneBXYZ = pBuilder.oneBXYZ;
  }

  /**
   * Class implements builder to create a new instance of class ClassA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String name;

    // "java.lang.String"
    private int nameXYZ = 0;

    // "com.anaptecs.jeaf.junit.core.ClassB"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private ClassB oneB;

    // "com.anaptecs.jeaf.junit.core.ClassB"
    private int oneBXYZ = 0;

    /**
     * Use {@link ClassA.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ClassA.builder(ClassA)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ClassABase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setName(pObject.name);
        this.setOneB(pObject.oneB);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
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
     * Method sets association {@link #oneB}.<br/>
     *
     * @param pOneB Value to which {@link #oneB} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setOneB( ClassB pOneB ) {
      oneB = pOneB;
      return this;
    }

    public BuilderBase setOneBXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.core.ClassB"
      oneBXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ClassA. The object will be initialized with the values of the builder.
     *
     * @return ClassA Created object. The method never returns null.
     */
    public ClassA build( ) {
      return new ClassA(this);
    }

    /**
     * Method creates a new validated instance of class ClassA. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ClassA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ClassA buildValidated( ) throws ConstraintViolationException {
      ClassA lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
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
   * Method returns association {@link #oneB}.<br/>
   *
   * @return {@link ClassB} Value to which {@link #oneB} is set.
   */
  @JEAFCustomAnnotationTest
  public ClassB getOneB( ) {
    return oneB;
  }

  /**
   * Method sets association {@link #oneB}.<br/>
   *
   * @param pOneB Value to which {@link #oneB} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setOneB( ClassB pOneB ) {
    // Release already referenced object before setting a new association.
    if (oneB != null) {
      oneB.removeFromManyAs((ClassA) this);
    }
    oneB = pOneB;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pOneB != null && pOneB.getManyAs().contains(this) == false) {
      pOneB.addToManyAs((ClassA) this);
    }
  }

  /**
   * Method unsets {@link #oneB}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetOneB( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    ClassB lClassB = oneB;
    oneB = null;
    if (lClassB != null && lClassB.getManyAs().contains(this) == true) {
      lClassB.removeFromManyAs((ClassA) this);
    }
  }

  public int getOneBXYZ( ) {
    // "com.anaptecs.jeaf.junit.core.ClassB"
    return oneBXYZ;
  }

  public void setOneBXYZ( int value ) {
    oneBXYZ = value;
  }

  /**
   * @return {@link Double}
   */
  @JEAFCustomAnnotationTest
  public abstract Double calculate( );

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
   * @return {@link Builder} New builder that can be used to create new ClassA objects. The method never returns null.
   */
  public ClassA.Builder toBuilder( ) {
    return new ClassA.Builder((ClassA) this);
  }
}