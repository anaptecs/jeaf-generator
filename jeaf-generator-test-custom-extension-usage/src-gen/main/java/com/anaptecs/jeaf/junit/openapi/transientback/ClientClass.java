/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class ClientClass extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "transientMaster".
   */
  @JEAFCustomAnnotationTest
  public static final String TRANSIENTMASTER = "transientMaster";

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "manyMasters".
   */
  @JEAFCustomAnnotationTest
  public static final String MANYMASTERS = "manyMasters";

  // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private transient MasterClass transientMaster;

  // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
  private int transientMasterXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String name;

  // "String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private transient List<MasterClass> manyMasters;

  // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
  private int manyMastersXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ClientClass( ) {
    manyMasters = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ClientClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    // "String"
    nameXYZ = pBuilder.nameXYZ;
    manyMasters = new ArrayList<>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ClientClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ClientClass</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String name;

    // "String"
    private int nameXYZ = 0;

    /**
     * Use {@link ClientClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ClientClass#builder(ClientClass)} instead of private constructor to create new builder.
     */
    protected Builder( ClientClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public Builder setNameXYZ( int value ) {
      // "String"
      nameXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ClientClass. The object will be initialized with the values of the
     * builder.
     *
     * @return ClientClass Created object. The method never returns null.
     */
    public ClientClass build( ) {
      return new ClientClass(this);
    }

    /**
     * Method creates a new validated instance of class ClientClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ClientClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ClientClass buildValidated( ) throws ConstraintViolationException {
      ClientClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #transientMaster}.<br/>
   *
   * @return {@link MasterClass} Value to which {@link #transientMaster} is set.
   */
  @JEAFCustomAnnotationTest
  public MasterClass getTransientMaster( ) {
    return transientMaster;
  }

  /**
   * Method sets association {@link #transientMaster}.<br/>
   *
   * @param pTransientMaster Value to which {@link #transientMaster} should be set.
   */
  @JEAFCustomAnnotationTest
  void setTransientMaster( MasterClass pTransientMaster ) {
    // Release already referenced object before setting a new association.
    if (transientMaster != null) {
      transientMaster.removeFromClients((ClientClass) this);
    }
    transientMaster = pTransientMaster;
  }

  /**
   * Method unsets {@link #transientMaster}.
   */
  @JEAFCustomAnnotationTest
  final void unsetTransientMaster( ) {
    transientMaster = null;
  }

  public int getTransientMasterXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
    return transientMasterXYZ;
  }

  public void setTransientMasterXYZ( int value ) {
    transientMasterXYZ = value;
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
    // "String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns association {@link #manyMasters}.<br/>
   *
   * @return {@link List<MasterClass>} Value to which {@link #manyMasters} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<MasterClass> getManyMasters( ) {
    // Return all MasterClass objects as unmodifiable collection.
    return Collections.unmodifiableList(manyMasters);
  }

  /**
   * Method adds the passed object to {@link #manyMasters}.
   *
   * @param pManyMasters Object that should be added to {@link #manyMasters}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  void addToManyMasters( MasterClass pManyMasters ) {
    // Check parameter "pManyMasters" for invalid value null.
    Check.checkInvalidParameterNull(pManyMasters, "pManyMasters");
    // Add passed object to collection of associated MasterClass objects.
    manyMasters.add(pManyMasters);
  }

  /**
   * Method adds all passed objects to {@link #manyMasters}.
   *
   * @param pManyMasters Collection with all objects that should be added to {@link #manyMasters}. The parameter must
   * not be null.
   */
  @JEAFCustomAnnotationTest
  void addToManyMasters( Collection<MasterClass> pManyMasters ) {
    // Check parameter "pManyMasters" for invalid value null.
    Check.checkInvalidParameterNull(pManyMasters, "pManyMasters");
    // Add all passed objects.
    for (MasterClass lNextObject : pManyMasters) {
      this.addToManyMasters(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #manyMasters}.<br/>
   *
   * @param pManyMasters Object that should be removed from {@link #manyMasters}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  void removeFromManyMasters( MasterClass pManyMasters ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pManyMasters, "pManyMasters");
    // Remove passed object from collection of associated MasterClass objects.
    manyMasters.remove(pManyMasters);
  }

  /**
   * Method removes all objects from {@link #manyMasters}.
   */
  @JEAFCustomAnnotationTest
  void clearManyMasters( ) {
    // Remove all objects from association "manyMasters".
    Collection<MasterClass> lManyMasters = new HashSet<MasterClass>(manyMasters);
    Iterator<MasterClass> lIterator = lManyMasters.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromManyMasters(lIterator.next());
    }
  }

  public int getManyMastersXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.MasterClass"
    return manyMastersXYZ;
  }

  public void setManyMastersXYZ( int value ) {
    manyMastersXYZ = value;
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
   * @return {@link Builder} New builder that can be used to create new ClientClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}