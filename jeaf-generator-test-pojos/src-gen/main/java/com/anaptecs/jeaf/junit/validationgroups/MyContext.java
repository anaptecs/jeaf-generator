/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
public class MyContext {
  /**
   * Constant for the name of attribute "firstProperty".
   */
  public static final String FIRSTPROPERTY = "firstProperty";

  /**
   * Constant for the name of attribute "clientTypes".
   */
  public static final String CLIENTTYPES = "clientTypes";

  @NotNull(groups = { V7.class })
  private String firstProperty;

  @Size(min = 1, groups = { V7.class })
  @NotNull(groups = { V7.class })
  private Set<ClientType> clientTypes;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyContext( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    firstProperty = pBuilder.firstProperty;
    clientTypes = (pBuilder.clientTypes == null) ? new HashSet<>() : pBuilder.clientTypes;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class MyContext.
   *
   *
   * @param pFirstProperty Value to which {@link #firstProperty} should be set.
   *
   * @param pClientTypes Value to which {@link #clientTypes} should be set.
   *
   * @return {@link MyContext}
   */
  public static MyContext of( String pFirstProperty, Set<ClientType> pClientTypes ) {
    var lBuilder = MyContext.builder();
    lBuilder.setFirstProperty(pFirstProperty);
    lBuilder.setClientTypes(pClientTypes);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MyContext</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String firstProperty;

    private Set<ClientType> clientTypes;

    /**
     * Use {@link MyContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyContext#builder(MyContext)} instead of private constructor to create new builder.
     */
    protected Builder( MyContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setFirstProperty(pObject.firstProperty);
        this.setClientTypes(pObject.clientTypes);
      }
    }

    /**
     * Method sets attribute {@link #firstProperty}.<br/>
     *
     * @param pFirstProperty Value to which {@link #firstProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setFirstProperty( String pFirstProperty ) {
      // Assign value to attribute
      firstProperty = pFirstProperty;
      return this;
    }

    /**
     * Method sets association {@link #clientTypes}.<br/>
     *
     * @param pClientTypes Collection to which {@link #clientTypes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setClientTypes( Set<ClientType> pClientTypes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pClientTypes != null) {
        clientTypes = new HashSet<ClientType>(pClientTypes);
      }
      else {
        clientTypes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #clientTypes}.<br/>
     *
     * @param pClientTypes Array of objects that should be added to {@link #clientTypes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToClientTypes( ClientType... pClientTypes ) {
      if (pClientTypes != null) {
        if (clientTypes == null) {
          clientTypes = new HashSet<ClientType>();
        }
        clientTypes.addAll(Arrays.asList(pClientTypes));
      }
      return this;
    }

    /**
     * Method sets association {@link #clientTypes}.<br/>
     *
     * @param pClientTypes Array with objects to which {@link #clientTypes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setClientTypes( ClientType... pClientTypes ) {
      // Copy the content of the passed array.
      if (pClientTypes != null) {
        clientTypes = new HashSet<ClientType>(Arrays.asList(pClientTypes));
      }
      else {
        clientTypes = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class MyContext. The object will be initialized with the values of the builder.
     *
     * @return MyContext Created object. The method never returns null.
     */
    public MyContext build( ) {
      return new MyContext(this);
    }

    /**
     * Method creates a new validated instance of class MyContext. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return MyContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MyContext buildValidated( ) throws ConstraintViolationException {
      MyContext lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #firstProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #firstProperty} is set.
   */
  public String getFirstProperty( ) {
    return firstProperty;
  }

  /**
   * Method sets attribute {@link #firstProperty}.<br/>
   *
   * @param pFirstProperty Value to which {@link #firstProperty} should be set.
   */
  public void setFirstProperty( String pFirstProperty ) {
    // Assign value to attribute
    firstProperty = pFirstProperty;
  }

  /**
   * Method returns association {@link #clientTypes}.<br/>
   *
   * @return {@link Set<ClientType>} Value to which {@link #clientTypes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<ClientType> getClientTypes( ) {
    // Return all ClientType objects as unmodifiable collection.
    return Collections.unmodifiableSet(clientTypes);
  }

  /**
   * Method adds the passed object to {@link #clientTypes}.
   *
   * @param pClientTypes Object that should be added to {@link #clientTypes}. The parameter must not be null.
   */
  public void addToClientTypes( ClientType pClientTypes ) {
    // Check parameter "pClientTypes" for invalid value null.
    Check.checkInvalidParameterNull(pClientTypes, "pClientTypes");
    // Add passed object to collection of associated ClientType objects.
    clientTypes.add(pClientTypes);
  }

  /**
   * Method adds all passed objects to {@link #clientTypes}.
   *
   * @param pClientTypes Collection with all objects that should be added to {@link #clientTypes}. The parameter must
   * not be null.
   */
  public void addToClientTypes( Collection<ClientType> pClientTypes ) {
    // Check parameter "pClientTypes" for invalid value null.
    Check.checkInvalidParameterNull(pClientTypes, "pClientTypes");
    // Add all passed objects.
    for (ClientType lNextObject : pClientTypes) {
      this.addToClientTypes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #clientTypes}.<br/>
   *
   * @param pClientTypes Object that should be removed from {@link #clientTypes}. The parameter must not be null.
   */
  public void removeFromClientTypes( ClientType pClientTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pClientTypes, "pClientTypes");
    // Remove passed object from collection of associated ClientType objects.
    clientTypes.remove(pClientTypes);
  }

  /**
   * Method removes all objects from {@link #clientTypes}.
   */
  public void clearClientTypes( ) {
    // Remove all objects from association "clientTypes".
    clientTypes.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(firstProperty);
    lResult = lPrime * lResult + Objects.hashCode(clientTypes);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      MyContext lOther = (MyContext) pObject;
      lEquals = Objects.equals(firstProperty, lOther.firstProperty) && Objects.equals(clientTypes, lOther.clientTypes);
    }
    return lEquals;
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
    lBuilder.append("firstProperty: ");
    lBuilder.append(firstProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("clientTypes: ");
    if (clientTypes != null) {
      lBuilder.append(clientTypes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (clientTypes != null) {
      for (ClientType lNext : clientTypes) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new MyContext objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}