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

public class ComplexArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "classBs".
   */
  public static final String CLASSBS = "classBs";

  private Set<ClassB> classBs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    classBs = pBuilder.classBs;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ComplexArrayServiceObject.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.core.ComplexArrayServiceObject}
   */
  public static ComplexArrayServiceObject of( ) {
    var lBuilder = ComplexArrayServiceObject.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ComplexArrayServiceObject</code>.
   */
  public static class Builder {
    private Set<ClassB> classBs;

    /**
     * Use {@link ComplexArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplexArrayServiceObject#builder(ComplexArrayServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( ComplexArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setClassBs(pObject.classBs);
      }
    }

    /**
     * Method sets attribute {@link #classBs}.<br/>
     *
     * @param pClassBs Collection to which {@link #classBs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setClassBs( Set<ClassB> pClassBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pClassBs != null) {
        classBs = new HashSet<ClassB>(pClassBs);
      }
      else {
        classBs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #classBs}.<br/>
     *
     * @param pClassBs Array of objects that should be added to {@link #classBs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToClassBs( ClassB... pClassBs ) {
      if (pClassBs != null) {
        if (classBs == null) {
          classBs = new HashSet<ClassB>();
        }
        classBs.addAll(Arrays.asList(pClassBs));
      }
      return this;
    }

    /**
     * Method creates a new instance of class ComplexArrayServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return ComplexArrayServiceObject Created object. The method never returns null.
     */
    public ComplexArrayServiceObject build( ) {
      ComplexArrayServiceObject lObject = new ComplexArrayServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ComplexArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return ComplexArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ComplexArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      ComplexArrayServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #classBs}.<br/>
   *
   * @return {@link Set<ClassB>} Value to which {@link #classBs} is set.
   */
  public Set<ClassB> getClassBs( ) {
    // Return all ClassB objects as unmodifiable collection.
    return Collections.unmodifiableSet(classBs);
  }

  /**
   * Method adds the passed object to {@link #classBs}.
   *
   * @param pClassBs Object that should be added to {@link #classBs}. The parameter must not be null.
   */
  public void addToClassBs( ClassB pClassBs ) {
    // Check parameter "pClassBs" for invalid value null.
    Check.checkInvalidParameterNull(pClassBs, "pClassBs");
    // Add passed object to collection of associated ClassB objects.
    classBs.add(pClassBs);
  }

  /**
   * Method adds all passed objects to {@link #classBs}.
   *
   * @param pClassBs Collection with all objects that should be added to {@link #classBs}. The parameter must not be
   * null.
   */
  public void addToClassBs( Collection<ClassB> pClassBs ) {
    // Check parameter "pClassBs" for invalid value null.
    Check.checkInvalidParameterNull(pClassBs, "pClassBs");
    // Add all passed objects.
    for (ClassB lNextObject : pClassBs) {
      this.addToClassBs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #classBs}.<br/>
   *
   * @param pClassBs Object that should be removed from {@link #classBs}. The parameter must not be null.
   */
  public void removeFromClassBs( ClassB pClassBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pClassBs, "pClassBs");
    // Remove passed object from collection of associated ClassB objects.
    classBs.remove(pClassBs);
  }

  /**
   * Method removes all objects from {@link #classBs}.
   */
  public void clearClassBs( ) {
    // Remove all objects from association "classBs".
    classBs.clear();
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
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}