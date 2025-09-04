/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
public class Pageable<T> extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "objects".
   */
  @JEAFCustomAnnotationTest
  public static final String OBJECTS = "objects";

  /**
   * Constant for the name of attribute "size".
   */
  @JEAFCustomAnnotationTest
  public static final String SIZE = "size";

  // "T"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private List<T> objects;

  // "T"
  private int objectsXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private int size;

  // "int"
  private int sizeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Pageable( ) {
    objects = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Pageable( Builder<T> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    objects = (pBuilder.objects == null) ? new ArrayList<>() : pBuilder.objects;
    // "T"
    objectsXYZ = pBuilder.objectsXYZ;
    size = pBuilder.size;
    // "int"
    sizeXYZ = pBuilder.sizeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Pageable objects.
   */
  public static <T> Builder<T> builder( ) {
    return new Builder<T>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Pageable objects.
   */
  public static <T> Builder<T> builder( Class<T> pClassT ) {
    return new Builder<T>();
  }

  /**
   * Class implements builder to create a new instance of class <code>Pageable</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder<T> {
    // "T"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<T> objects;

    // "T"
    private int objectsXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private int size;

    // "int"
    private int sizeXYZ = 0;

    /**
     * Use {@link Pageable#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Pageable#builder(Pageable)} instead of private constructor to create new builder.
     */
    protected Builder( Pageable<T> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setObjects(pObject.objects);
        this.setSize(pObject.size);
      }
    }

    /**
     * Method sets association {@link #objects}.<br/>
     *
     * @param pObjects Collection to which {@link #objects} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> setObjects( List<T> pObjects ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pObjects != null) {
        objects = new ArrayList<T>(pObjects);
      }
      else {
        objects = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #objects}.<br/>
     *
     * @param pObjects Array of objects that should be added to {@link #objects}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> addToObjects( @SuppressWarnings("unchecked") T... pObjects ) {
      if (pObjects != null) {
        if (objects == null) {
          objects = new ArrayList<T>();
        }
        objects.addAll(Arrays.asList(pObjects));
      }
      return this;
    }

    public Builder setObjectsXYZ( int value ) {
      // "T"
      objectsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #size}.<br/>
     *
     * @param pSize Value to which {@link #size} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> setSize( int pSize ) {
      // Assign value to attribute
      size = pSize;
      return this;
    }

    public Builder setSizeXYZ( int value ) {
      // "int"
      sizeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Pageable. The object will be initialized with the values of the builder.
     *
     * @return Pageable Created object. The method never returns null.
     */
    public Pageable<T> build( ) {
      return new Pageable<T>(this);
    }

    /**
     * Method creates a new validated instance of class Pageable. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Pageable Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Pageable<T> buildValidated( ) throws ConstraintViolationException {
      Pageable<T> lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #objects}.<br/>
   *
   * @return {@link List<T>} Value to which {@link #objects} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<T> getObjects( ) {
    // Return all T objects as unmodifiable collection.
    return Collections.unmodifiableList(objects);
  }

  /**
   * Method adds the passed object to {@link #objects}.
   *
   * @param pObjects Object that should be added to {@link #objects}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToObjects( T pObjects ) {
    // Check parameter "pObjects" for invalid value null.
    Check.checkInvalidParameterNull(pObjects, "pObjects");
    // Add passed object to collection of associated T objects.
    objects.add(pObjects);
  }

  /**
   * Method adds all passed objects to {@link #objects}.
   *
   * @param pObjects Collection with all objects that should be added to {@link #objects}. The parameter must not be
   * null.
   */
  @JEAFCustomAnnotationTest
  public void addToObjects( Collection<T> pObjects ) {
    // Check parameter "pObjects" for invalid value null.
    Check.checkInvalidParameterNull(pObjects, "pObjects");
    // Add all passed objects.
    for (T lNextObject : pObjects) {
      this.addToObjects(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #objects}.<br/>
   *
   * @param pObjects Object that should be removed from {@link #objects}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void removeFromObjects( T pObjects ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pObjects, "pObjects");
    // Remove passed object from collection of associated T objects.
    objects.remove(pObjects);
  }

  /**
   * Method removes all objects from {@link #objects}.
   */
  @JEAFCustomAnnotationTest
  public void clearObjects( ) {
    // Remove all objects from association "objects".
    objects.clear();
  }

  public int getObjectsXYZ( ) {
    // "T"
    return objectsXYZ;
  }

  public void setObjectsXYZ( int value ) {
    objectsXYZ = value;
  }

  /**
   * Method returns attribute {@link #size}.<br/>
   *
   * @return int Value to which {@link #size} is set.
   */
  @JEAFCustomAnnotationTest
  public int getSize( ) {
    return size;
  }

  /**
   * Method sets attribute {@link #size}.<br/>
   *
   * @param pSize Value to which {@link #size} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setSize( int pSize ) {
    // Assign value to attribute
    size = pSize;
  }

  public int getSizeXYZ( ) {
    // "int"
    return sizeXYZ;
  }

  public void setSizeXYZ( int value ) {
    sizeXYZ = value;
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
    lBuilder.append("size: ");
    lBuilder.append(size);
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
   * @return {@link Builder} New builder that can be used to create new Pageable objects. The method never returns null.
   */
  public Builder<T> toBuilder( ) {
    return new Builder<T>(this);
  }
}