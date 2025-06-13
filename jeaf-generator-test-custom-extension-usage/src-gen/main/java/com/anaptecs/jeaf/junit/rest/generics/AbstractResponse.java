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

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public abstract class AbstractResponse<T> extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "errors".
   */
  @JEAFCustomAnnotationTest
  public static final String ERRORS = "errors";

  /**
   * Constant for the name of attribute "warnings".
   */
  @JEAFCustomAnnotationTest
  public static final String WARNINGS = "warnings";

  // "com.anaptecs.jeaf.junit.rest.generics.Message"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private List<Message> errors;

  // "com.anaptecs.jeaf.junit.rest.generics.Message"
  private int errorsXYZ = 0;

  // "com.anaptecs.jeaf.junit.rest.generics.Message"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private List<Message> warnings;

  // "com.anaptecs.jeaf.junit.rest.generics.Message"
  private int warningsXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AbstractResponse( ) {
    errors = new ArrayList<>();
    warnings = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractResponse( Builder<T> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.errors != null) {
      errors = pBuilder.errors;
    }
    else {
      errors = new ArrayList<>();
    }
    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    errorsXYZ = pBuilder.errorsXYZ;
    if (pBuilder.warnings != null) {
      warnings = pBuilder.warnings;
    }
    else {
      warnings = new ArrayList<>();
    }
    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    warningsXYZ = pBuilder.warningsXYZ;
  }

  /**
   * Class implements builder to create a new instance of class <code>AbstractResponse</code>.
   */
  @JEAFCustomAnnotationTest
  public static abstract class Builder<T> {
    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<Message> errors;

    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    private int errorsXYZ = 0;

    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<Message> warnings;

    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    private int warningsXYZ = 0;

    /**
     * Use {@link AbstractResponse#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AbstractResponse#builder(AbstractResponse)} instead of private constructor to create new builder.
     */
    protected Builder( AbstractResponse<T> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setErrors(pObject.errors);
        this.setWarnings(pObject.warnings);
      }
    }

    /**
     * Method sets association {@link #errors}.<br/>
     *
     * @param pErrors Collection to which {@link #errors} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> setErrors( List<Message> pErrors ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pErrors != null) {
        errors = new ArrayList<Message>(pErrors);
      }
      else {
        errors = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #errors}.<br/>
     *
     * @param pErrors Array of objects that should be added to {@link #errors}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> addToErrors( Message... pErrors ) {
      if (pErrors != null) {
        if (errors == null) {
          errors = new ArrayList<Message>();
        }
        errors.addAll(Arrays.asList(pErrors));
      }
      return this;
    }

    public Builder setErrorsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.rest.generics.Message"
      errorsXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #warnings}.<br/>
     *
     * @param pWarnings Collection to which {@link #warnings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> setWarnings( List<Message> pWarnings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pWarnings != null) {
        warnings = new ArrayList<Message>(pWarnings);
      }
      else {
        warnings = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #warnings}.<br/>
     *
     * @param pWarnings Array of objects that should be added to {@link #warnings}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder<T> addToWarnings( Message... pWarnings ) {
      if (pWarnings != null) {
        if (warnings == null) {
          warnings = new ArrayList<Message>();
        }
        warnings.addAll(Arrays.asList(pWarnings));
      }
      return this;
    }

    public Builder setWarningsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.rest.generics.Message"
      warningsXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(
  }

  /**
   * Method returns association {@link #errors}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #errors} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<Message> getErrors( ) {
    // Return all Message objects as unmodifiable collection.
    return Collections.unmodifiableList(errors);
  }

  /**
   * Method adds the passed object to {@link #errors}.
   *
   * @param pErrors Object that should be added to {@link #errors}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToErrors( Message pErrors ) {
    // Check parameter "pErrors" for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Add passed object to collection of associated Message objects.
    errors.add(pErrors);
  }

  /**
   * Method adds all passed objects to {@link #errors}.
   *
   * @param pErrors Collection with all objects that should be added to {@link #errors}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToErrors( Collection<Message> pErrors ) {
    // Check parameter "pErrors" for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Add all passed objects.
    for (Message lNextObject : pErrors) {
      this.addToErrors(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #errors}.<br/>
   *
   * @param pErrors Object that should be removed from {@link #errors}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void removeFromErrors( Message pErrors ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pErrors, "pErrors");
    // Remove passed object from collection of associated Message objects.
    errors.remove(pErrors);
  }

  /**
   * Method removes all objects from {@link #errors}.
   */
  @JEAFCustomAnnotationTest
  public void clearErrors( ) {
    // Remove all objects from association "errors".
    errors.clear();
  }

  public int getErrorsXYZ( ) {
    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    return errorsXYZ;
  }

  public void setErrorsXYZ( int value ) {
    errorsXYZ = value;
  }

  /**
   * Method returns association {@link #warnings}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #warnings} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public List<Message> getWarnings( ) {
    // Return all Message objects as unmodifiable collection.
    return Collections.unmodifiableList(warnings);
  }

  /**
   * Method adds the passed object to {@link #warnings}.
   *
   * @param pWarnings Object that should be added to {@link #warnings}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToWarnings( Message pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add passed object to collection of associated Message objects.
    warnings.add(pWarnings);
  }

  /**
   * Method adds all passed objects to {@link #warnings}.
   *
   * @param pWarnings Collection with all objects that should be added to {@link #warnings}. The parameter must not be
   * null.
   */
  @JEAFCustomAnnotationTest
  public void addToWarnings( Collection<Message> pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add all passed objects.
    for (Message lNextObject : pWarnings) {
      this.addToWarnings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #warnings}.<br/>
   *
   * @param pWarnings Object that should be removed from {@link #warnings}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void removeFromWarnings( Message pWarnings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Remove passed object from collection of associated Message objects.
    warnings.remove(pWarnings);
  }

  /**
   * Method removes all objects from {@link #warnings}.
   */
  @JEAFCustomAnnotationTest
  public void clearWarnings( ) {
    // Remove all objects from association "warnings".
    warnings.clear();
  }

  public int getWarningsXYZ( ) {
    // "com.anaptecs.jeaf.junit.rest.generics.Message"
    return warningsXYZ;
  }

  public void setWarningsXYZ( int value ) {
    warningsXYZ = value;
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