/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class Pageable<T> implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @JsonSetter(nulls = Nulls.SKIP)
  private List<T> objects;

  private int size;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Pageable( ) {
    objects = new ArrayList<T>();
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
    if (pBuilder.objects != null) {
      objects = pBuilder.objects;
    }
    else {
      objects = new ArrayList<T>();
    }
    size = pBuilder.size;
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
  public static <T> Builder<T> builder( Class<T> pClass ) {
    return new Builder<T>();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Pageable objects. The method never returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static <T> Builder<T> builder( Pageable<T> pObject ) {
    return new Builder<T>(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static <T> Builder<T> builder( int pSize ) {
    Builder<T> lBuilder = builder();
    lBuilder.setSize(pSize);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>Pageable</code>.
   */
  public static class Builder<T> {
    private List<T> objects;

    private int size;

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
    public Builder<T> addToObjects( @SuppressWarnings("unchecked") T... pObjects ) {
      if (pObjects != null) {
        if (objects == null) {
          objects = new ArrayList<T>();
        }
        objects.addAll(Arrays.asList(pObjects));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #size}.<br/>
     *
     * @param pSize Value to which {@link #size} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T> setSize( int pSize ) {
      // Assign value to attribute
      size = pSize;
      return this;
    }

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
   * collection is modifiable.
   */
  public List<T> getObjects( ) {
    // Return all T objects directly without any protection against modification.
    return objects;
  }

  /**
   * Method adds the passed object to {@link #objects}.
   *
   * @param pObjects Object that should be added to {@link #objects}. The parameter must not be null.
   */
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
  public void removeFromObjects( T pObjects ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pObjects, "pObjects");
    // Remove passed object from collection of associated T objects.
    objects.remove(pObjects);
  }

  /**
   * Method removes all objects from {@link #objects}.
   */
  public void clearObjects( ) {
    // Remove all objects from association "objects".
    objects.clear();
  }

  /**
   * Method returns attribute {@link #size}.<br/>
   *
   * @return int Value to which {@link #size} is set.
   */
  public int getSize( ) {
    return size;
  }

  /**
   * Method sets attribute {@link #size}.<br/>
   *
   * @param pSize Value to which {@link #size} should be set.
   */
  public void setSize( int pSize ) {
    // Assign value to attribute
    size = pSize;
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
    lBuilder.append("objects: ");
    if (objects != null) {
      lBuilder.append(objects.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (objects != null) {
      for (T lNext : objects) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
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
