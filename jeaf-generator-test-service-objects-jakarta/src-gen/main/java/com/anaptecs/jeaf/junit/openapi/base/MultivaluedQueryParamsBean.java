/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class MultivaluedQueryParamsBean implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "intArray".
   */
  public static final String INTARRAY = "intArray";

  /**
   * Constant for the name of attribute "strings".
   */
  public static final String STRINGS = "strings";

  /**
   * Constant for the name of attribute "integers".
   */
  public static final String INTEGERS = "integers";

  /**
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   */
  private int[] intArray;

  private Set<String> strings;

  private Set<Integer> integers;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MultivaluedQueryParamsBean( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultivaluedQueryParamsBean( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    intArray = pBuilder.intArray;
    strings = pBuilder.strings;
    integers = pBuilder.integers;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MultivaluedQueryParamsBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class MultivaluedQueryParamsBean.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.MultivaluedQueryParamsBean}
   */
  public static MultivaluedQueryParamsBean of( ) {
    var lBuilder = MultivaluedQueryParamsBean.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MultivaluedQueryParamsBean</code>.
   */
  public static class Builder {
    /**
     * <p/>
     * <b>Breaking Change with 47.11:</b> At least one will become mandatory
     */
    private int[] intArray;

    private Set<String> strings;

    private Set<Integer> integers;

    /**
     * Use {@link MultivaluedQueryParamsBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultivaluedQueryParamsBean#builder(MultivaluedQueryParamsBean)} instead of private constructor to
     * create new builder.
     */
    protected Builder( MultivaluedQueryParamsBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setIntArray(pObject.intArray);
        this.setStrings(pObject.strings);
        this.setIntegers(pObject.integers);
      }
    }

    /**
     * Method sets attribute {@link #intArray}.<br/>
     * <p/>
     * <b>Breaking Change with 47.11:</b> At least one will become mandatory
     *
     * @param pIntArray Value to which {@link #intArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntArray( int[] pIntArray ) {
      // Assign value to attribute
      if (pIntArray != null) {
        intArray = new int[pIntArray.length];
        System.arraycopy(pIntArray, 0, intArray, 0, pIntArray.length);
      }
      else {
        intArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #strings}.<br/>
     *
     * @param pStrings Collection to which {@link #strings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStrings( Set<String> pStrings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStrings != null) {
        strings = new HashSet<String>(pStrings);
      }
      else {
        strings = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #strings}.<br/>
     *
     * @param pStrings Array of objects that should be added to {@link #strings}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToStrings( String... pStrings ) {
      if (pStrings != null) {
        if (strings == null) {
          strings = new HashSet<String>();
        }
        strings.addAll(Arrays.asList(pStrings));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #integers}.<br/>
     *
     * @param pIntegers Collection to which {@link #integers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIntegers( Set<Integer> pIntegers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pIntegers != null) {
        integers = new HashSet<Integer>(pIntegers);
      }
      else {
        integers = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #integers}.<br/>
     *
     * @param pIntegers Array of objects that should be added to {@link #integers}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToIntegers( Integer... pIntegers ) {
      if (pIntegers != null) {
        if (integers == null) {
          integers = new HashSet<Integer>();
        }
        integers.addAll(Arrays.asList(pIntegers));
      }
      return this;
    }

    /**
     * Method creates a new instance of class MultivaluedQueryParamsBean. The object will be initialized with the values
     * of the builder.
     *
     * @return MultivaluedQueryParamsBean Created object. The method never returns null.
     */
    public MultivaluedQueryParamsBean build( ) {
      MultivaluedQueryParamsBean lObject = new MultivaluedQueryParamsBean(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class MultivaluedQueryParamsBean. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return MultivaluedQueryParamsBean Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MultivaluedQueryParamsBean buildValidated( ) throws ConstraintViolationException {
      MultivaluedQueryParamsBean lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #intArray}.<br/>
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   *
   * @return int[] Value to which {@link #intArray} is set.
   */
  public int[] getIntArray( ) {
    int[] lReturnValue;
    if (intArray != null) {
      lReturnValue = new int[intArray.length];
      System.arraycopy(intArray, 0, lReturnValue, 0, intArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #intArray}.<br/>
   * <p/>
   * <b>Breaking Change with 47.11:</b> At least one will become mandatory
   *
   * @param pIntArray Value to which {@link #intArray} should be set.
   */
  public void setIntArray( int[] pIntArray ) {
    // Assign value to attribute
    if (pIntArray != null) {
      intArray = new int[pIntArray.length];
      System.arraycopy(pIntArray, 0, intArray, 0, pIntArray.length);
    }
    else {
      intArray = null;
    }
  }

  /**
   * Method returns attribute {@link #strings}.<br/>
   *
   * @return {@link Set<String>} Value to which {@link #strings} is set.
   */
  public Set<String> getStrings( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(strings);
  }

  /**
   * Method adds the passed object to {@link #strings}.
   *
   * @param pStrings Object that should be added to {@link #strings}. The parameter must not be null.
   */
  public void addToStrings( String pStrings ) {
    // Check parameter "pStrings" for invalid value null.
    Check.checkInvalidParameterNull(pStrings, "pStrings");
    // Add passed object to collection of associated String objects.
    strings.add(pStrings);
  }

  /**
   * Method adds all passed objects to {@link #strings}.
   *
   * @param pStrings Collection with all objects that should be added to {@link #strings}. The parameter must not be
   * null.
   */
  public void addToStrings( Collection<String> pStrings ) {
    // Check parameter "pStrings" for invalid value null.
    Check.checkInvalidParameterNull(pStrings, "pStrings");
    // Add all passed objects.
    for (String lNextObject : pStrings) {
      this.addToStrings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #strings}.<br/>
   *
   * @param pStrings Object that should be removed from {@link #strings}. The parameter must not be null.
   */
  public void removeFromStrings( String pStrings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStrings, "pStrings");
    // Remove passed object from collection of associated String objects.
    strings.remove(pStrings);
  }

  /**
   * Method removes all objects from {@link #strings}.
   */
  public void clearStrings( ) {
    // Remove all objects from association "strings".
    strings.clear();
  }

  /**
   * Method returns attribute {@link #integers}.<br/>
   *
   * @return {@link Set<Integer>} Value to which {@link #integers} is set.
   */
  public Set<Integer> getIntegers( ) {
    // Return all Integer objects as unmodifiable collection.
    return Collections.unmodifiableSet(integers);
  }

  /**
   * Method adds the passed object to {@link #integers}.
   *
   * @param pIntegers Object that should be added to {@link #integers}. The parameter must not be null.
   */
  public void addToIntegers( Integer pIntegers ) {
    // Check parameter "pIntegers" for invalid value null.
    Check.checkInvalidParameterNull(pIntegers, "pIntegers");
    // Add passed object to collection of associated Integer objects.
    integers.add(pIntegers);
  }

  /**
   * Method adds all passed objects to {@link #integers}.
   *
   * @param pIntegers Collection with all objects that should be added to {@link #integers}. The parameter must not be
   * null.
   */
  public void addToIntegers( Collection<Integer> pIntegers ) {
    // Check parameter "pIntegers" for invalid value null.
    Check.checkInvalidParameterNull(pIntegers, "pIntegers");
    // Add all passed objects.
    for (Integer lNextObject : pIntegers) {
      this.addToIntegers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #integers}.<br/>
   *
   * @param pIntegers Object that should be removed from {@link #integers}. The parameter must not be null.
   */
  public void removeFromIntegers( Integer pIntegers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pIntegers, "pIntegers");
    // Remove passed object from collection of associated Integer objects.
    integers.remove(pIntegers);
  }

  /**
   * Method removes all objects from {@link #integers}.
   */
  public void clearIntegers( ) {
    // Remove all objects from association "integers".
    integers.clear();
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
   * @return {@link Builder} New builder that can be used to create new MultivaluedQueryParamsBean objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}