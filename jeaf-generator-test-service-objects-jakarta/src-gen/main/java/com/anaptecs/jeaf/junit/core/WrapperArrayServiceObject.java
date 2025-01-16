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

public class WrapperArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanArray".
   */
  public static final String BOOLEANARRAY = "booleanArray";

  private Set<Boolean> booleanArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WrapperArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WrapperArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanArray = pBuilder.booleanArray;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WrapperArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class WrapperArrayServiceObject.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.core.WrapperArrayServiceObject}
   */
  public static WrapperArrayServiceObject of( ) {
    WrapperArrayServiceObject.Builder lBuilder = WrapperArrayServiceObject.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>WrapperArrayServiceObject</code>.
   */
  public static class Builder {
    private Set<Boolean> booleanArray;

    /**
     * Use {@link WrapperArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WrapperArrayServiceObject#builder(WrapperArrayServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( WrapperArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBooleanArray(pObject.booleanArray);
      }
    }

    /**
     * Method sets attribute {@link #booleanArray}.<br/>
     *
     * @param pBooleanArray Collection to which {@link #booleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooleanArray( Set<Boolean> pBooleanArray ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBooleanArray != null) {
        booleanArray = new HashSet<Boolean>(pBooleanArray);
      }
      else {
        booleanArray = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #booleanArray}.<br/>
     *
     * @param pBooleanArray Array of objects that should be added to {@link #booleanArray}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBooleanArray( Boolean... pBooleanArray ) {
      if (pBooleanArray != null) {
        if (booleanArray == null) {
          booleanArray = new HashSet<Boolean>();
        }
        booleanArray.addAll(Arrays.asList(pBooleanArray));
      }
      return this;
    }

    /**
     * Method creates a new instance of class WrapperArrayServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return WrapperArrayServiceObject Created object. The method never returns null.
     */
    public WrapperArrayServiceObject build( ) {
      WrapperArrayServiceObject lObject = new WrapperArrayServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class WrapperArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return WrapperArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WrapperArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      WrapperArrayServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #booleanArray}.<br/>
   *
   * @return {@link Set<Boolean>} Value to which {@link #booleanArray} is set.
   */
  public Set<Boolean> getBooleanArray( ) {
    // Return all Boolean objects as unmodifiable collection.
    return Collections.unmodifiableSet(booleanArray);
  }

  /**
   * Method adds the passed object to {@link #booleanArray}.
   *
   * @param pBooleanArray Object that should be added to {@link #booleanArray}. The parameter must not be null.
   */
  public void addToBooleanArray( Boolean pBooleanArray ) {
    // Check parameter "pBooleanArray" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanArray, "pBooleanArray");
    // Add passed object to collection of associated Boolean objects.
    booleanArray.add(pBooleanArray);
  }

  /**
   * Method adds all passed objects to {@link #booleanArray}.
   *
   * @param pBooleanArray Collection with all objects that should be added to {@link #booleanArray}. The parameter must
   * not be null.
   */
  public void addToBooleanArray( Collection<Boolean> pBooleanArray ) {
    // Check parameter "pBooleanArray" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanArray, "pBooleanArray");
    // Add all passed objects.
    for (Boolean lNextObject : pBooleanArray) {
      this.addToBooleanArray(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #booleanArray}.<br/>
   *
   * @param pBooleanArray Object that should be removed from {@link #booleanArray}. The parameter must not be null.
   */
  public void removeFromBooleanArray( Boolean pBooleanArray ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBooleanArray, "pBooleanArray");
    // Remove passed object from collection of associated Boolean objects.
    booleanArray.remove(pBooleanArray);
  }

  /**
   * Method removes all objects from {@link #booleanArray}.
   */
  public void clearBooleanArray( ) {
    // Remove all objects from association "booleanArray".
    booleanArray.clear();
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
   * @return {@link Builder} New builder that can be used to create new WrapperArrayServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}