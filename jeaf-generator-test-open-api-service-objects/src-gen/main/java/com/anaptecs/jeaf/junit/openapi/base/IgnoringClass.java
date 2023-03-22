/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class IgnoringClass implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String ignoredName;

  private int ignoredPrimitive;

  private boolean[] ignoredArray;

  @NotNull
  private Integer age;

  private Stop ignoredStop;

  private List<DirectedEdge> ignoredEdges;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected IgnoringClass( ) {
    ignoredEdges = new ArrayList<DirectedEdge>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IgnoringClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    ignoredName = pBuilder.ignoredName;
    ignoredPrimitive = pBuilder.ignoredPrimitive;
    ignoredArray = pBuilder.ignoredArray;
    age = pBuilder.age;
    ignoredStop = pBuilder.ignoredStop;
    if (pBuilder.ignoredEdges != null) {
      ignoredEdges = pBuilder.ignoredEdges;
    }
    else {
      ignoredEdges = new ArrayList<DirectedEdge>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects. The method never returns
   * null.
   */
  public static Builder builder( IgnoringClass pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>IgnoringClass</code>.
   */
  public static class Builder {
    private String ignoredName;

    private int ignoredPrimitive;

    private boolean[] ignoredArray;

    private Integer age;

    private Stop ignoredStop;

    private List<DirectedEdge> ignoredEdges;

    /**
     * Use {@link IgnoringClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link IgnoringClass#builder(IgnoringClass)} instead of private constructor to create new builder.
     */
    protected Builder( IgnoringClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        ignoredName = pObject.ignoredName;
        ignoredPrimitive = pObject.ignoredPrimitive;
        ignoredArray = pObject.ignoredArray;
        age = pObject.age;
        ignoredStop = pObject.ignoredStop;
        ignoredEdges = pObject.ignoredEdges;
      }
    }

    /**
     * Method sets attribute {@link #ignoredName}.<br/>
     * 
     * @param pIgnoredName Value to which {@link #ignoredName} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIgnoredName( String pIgnoredName ) {
      // Assign value to attribute
      ignoredName = pIgnoredName;
      return this;
    }

    /**
     * Method sets attribute {@link #ignoredPrimitive}.<br/>
     * 
     * @param pIgnoredPrimitive Value to which {@link #ignoredPrimitive} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIgnoredPrimitive( int pIgnoredPrimitive ) {
      // Assign value to attribute
      ignoredPrimitive = pIgnoredPrimitive;
      return this;
    }

    /**
     * Method sets attribute {@link #ignoredArray}.<br/>
     * 
     * @param pIgnoredArray Value to which {@link #ignoredArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIgnoredArray( boolean[] pIgnoredArray ) {
      // Assign value to attribute
      if (pIgnoredArray != null) {
        ignoredArray = pIgnoredArray;
      }
      else {
        ignoredArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #age}.<br/>
     * 
     * @param pAge Value to which {@link #age} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAge( Integer pAge ) {
      // Assign value to attribute
      age = pAge;
      return this;
    }

    /**
     * Method sets association {@link #ignoredStop}.<br/>
     * 
     * @param pIgnoredStop Value to which {@link #ignoredStop} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIgnoredStop( Stop pIgnoredStop ) {
      ignoredStop = pIgnoredStop;
      return this;
    }

    /**
     * Method sets association {@link #ignoredEdges}.<br/>
     * 
     * @param pIgnoredEdges Collection to which {@link #ignoredEdges} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIgnoredEdges( List<DirectedEdge> pIgnoredEdges ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pIgnoredEdges != null) {
        ignoredEdges = new ArrayList<DirectedEdge>(pIgnoredEdges);
      }
      else {
        ignoredEdges = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class IgnoringClass. The object will be initialized with the values of the
     * builder.
     * 
     * @return IgnoringClass Created object. The method never returns null.
     */
    public IgnoringClass build( ) {
      return new IgnoringClass(this);
    }

    /**
     * Method creates a new validated instance of class IgnoringClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return IgnoringClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public IgnoringClass buildValidated( ) throws ConstraintViolationException {
      IgnoringClass lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #ignoredName}.<br/>
   * 
   * @return {@link String} Value to which {@link #ignoredName} is set.
   */
  public String getIgnoredName( ) {
    return ignoredName;
  }

  /**
   * Method sets attribute {@link #ignoredName}.<br/>
   * 
   * @param pIgnoredName Value to which {@link #ignoredName} should be set.
   */
  public void setIgnoredName( String pIgnoredName ) {
    // Assign value to attribute
    ignoredName = pIgnoredName;
  }

  /**
   * Method returns attribute {@link #ignoredPrimitive}.<br/>
   * 
   * @return int Value to which {@link #ignoredPrimitive} is set.
   */
  public int getIgnoredPrimitive( ) {
    return ignoredPrimitive;
  }

  /**
   * Method sets attribute {@link #ignoredPrimitive}.<br/>
   * 
   * @param pIgnoredPrimitive Value to which {@link #ignoredPrimitive} should be set.
   */
  public void setIgnoredPrimitive( int pIgnoredPrimitive ) {
    // Assign value to attribute
    ignoredPrimitive = pIgnoredPrimitive;
  }

  /**
   * Method returns attribute {@link #ignoredArray}.<br/>
   * 
   * @return boolean Value to which {@link #ignoredArray} is set.
   */
  public boolean[] getIgnoredArray( ) {
    boolean[] lReturnValue;
    if (ignoredArray != null) {
      lReturnValue = ignoredArray;
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #ignoredArray}.<br/>
   * 
   * @param pIgnoredArray Value to which {@link #ignoredArray} should be set.
   */
  public void setIgnoredArray( boolean[] pIgnoredArray ) {
    // Assign value to attribute
    if (pIgnoredArray != null) {
      ignoredArray = pIgnoredArray;
    }
    else {
      ignoredArray = null;
    }
  }

  /**
   * Method returns attribute {@link #age}.<br/>
   * 
   * @return {@link Integer} Value to which {@link #age} is set.
   */
  public Integer getAge( ) {
    return age;
  }

  /**
   * Method sets attribute {@link #age}.<br/>
   * 
   * @param pAge Value to which {@link #age} should be set.
   */
  public void setAge( Integer pAge ) {
    // Assign value to attribute
    age = pAge;
  }

  /**
   * Method returns association {@link #ignoredStop}.<br/>
   * 
   * @return {@link Stop} Value to which {@link #ignoredStop} is set.
   */
  public Stop getIgnoredStop( ) {
    return ignoredStop;
  }

  /**
   * Method sets association {@link #ignoredStop}.<br/>
   * 
   * @param pIgnoredStop Value to which {@link #ignoredStop} should be set.
   */
  public void setIgnoredStop( Stop pIgnoredStop ) {
    ignoredStop = pIgnoredStop;
  }

  /**
   * Method unsets {@link #ignoredStop}.
   */
  public final void unsetIgnoredStop( ) {
    ignoredStop = null;
  }

  /**
   * Method returns association {@link #ignoredEdges}.<br/>
   * 
   * @return {@link List<DirectedEdge>} Value to which {@link #ignoredEdges} is set. The method never returns null and
   * the returned collection is modifiable.
   */
  public List<DirectedEdge> getIgnoredEdges( ) {
    // Return all DirectedEdge objects directly without any protection against modification.
    return ignoredEdges;
  }

  /**
   * Method adds the passed object to {@link #ignoredEdges}.
   * 
   * @param pIgnoredEdges Object that should be added to {@link #ignoredEdges}. The parameter must not be null.
   */
  public void addToIgnoredEdges( DirectedEdge pIgnoredEdges ) {
    // Check parameter "pIgnoredEdges" for invalid value null.
    Check.checkInvalidParameterNull(pIgnoredEdges, "pIgnoredEdges");
    // Add passed object to collection of associated DirectedEdge objects.
    ignoredEdges.add(pIgnoredEdges);
  }

  /**
   * Method adds all passed objects to {@link #ignoredEdges}.
   * 
   * @param pIgnoredEdges Collection with all objects that should be added to {@link #ignoredEdges}. The parameter must
   * not be null.
   */
  public void addToIgnoredEdges( Collection<DirectedEdge> pIgnoredEdges ) {
    // Check parameter "pIgnoredEdges" for invalid value null.
    Check.checkInvalidParameterNull(pIgnoredEdges, "pIgnoredEdges");
    // Add all passed objects.
    for (DirectedEdge lNextObject : pIgnoredEdges) {
      this.addToIgnoredEdges(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #ignoredEdges}.<br/>
   * 
   * @param pIgnoredEdges Object that should be removed from {@link #ignoredEdges}. The parameter must not be null.
   */
  public void removeFromIgnoredEdges( DirectedEdge pIgnoredEdges ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pIgnoredEdges, "pIgnoredEdges");
    // Remove passed object from collection of associated DirectedEdge objects.
    ignoredEdges.remove(pIgnoredEdges);
  }

  /**
   * Method removes all objects from {@link #ignoredEdges}.
   */
  public void clearIgnoredEdges( ) {
    // Remove all objects from association "ignoredEdges".
    ignoredEdges.clear();
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
    lBuilder.append("ignoredName: ");
    lBuilder.append(ignoredName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("ignoredPrimitive: ");
    lBuilder.append(ignoredPrimitive);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("ignoredArray: ");
    if (ignoredArray != null) {
      lBuilder.append(Arrays.toString(ignoredArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("age: ");
    lBuilder.append(age);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("ignoredStop: ");
    if (ignoredStop != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(ignoredStop.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("ignoredEdges: ");
    if (ignoredEdges != null) {
      lBuilder.append(ignoredEdges.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (ignoredEdges != null) {
      for (DirectedEdge lNext : ignoredEdges) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
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
}
