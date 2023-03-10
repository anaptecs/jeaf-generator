/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.objectmapping;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PrimitiveReferenceServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "booleanSet".
   */
  public static final String BOOLEANSET = "booleanSet";

  /**
   * Constant for the name of attribute "buffers".
   */
  public static final String BUFFERS = "buffers";

  /**
   * Constant for the name of attribute "strings".
   */
  public static final String STRINGS = "strings";

  /**
   * Constant for the name of attribute "stringArray".
   */
  public static final String STRINGARRAY = "stringArray";

  private Boolean aBoolean;

  private Set<Boolean> booleanSet;

  private Set<StringBuffer> buffers;

  private Set<String> strings;

  private String[] stringArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveReferenceServiceObject( ) {
    booleanSet = new HashSet<Boolean>();
    buffers = new HashSet<StringBuffer>();
    strings = new HashSet<String>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveReferenceServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    if (pBuilder.booleanSet != null) {
      booleanSet = pBuilder.booleanSet;
    }
    else {
      booleanSet = new HashSet<Boolean>();
    }
    if (pBuilder.buffers != null) {
      buffers = pBuilder.buffers;
    }
    else {
      buffers = new HashSet<StringBuffer>();
    }
    if (pBuilder.strings != null) {
      strings = pBuilder.strings;
    }
    else {
      strings = new HashSet<String>();
    }
    stringArray = pBuilder.stringArray;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PrimitiveReferenceServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveReferenceServiceObject objects. The
   * method never returns null.
   */
  public static Builder builder( PrimitiveReferenceServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>PrimitiveReferenceServiceObject</code>.
   */
  public static class Builder {
    private Boolean aBoolean;

    private Set<Boolean> booleanSet;

    private Set<StringBuffer> buffers;

    private Set<String> strings;

    private String[] stringArray;

    /**
     * Use {@link PrimitiveReferenceServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveReferenceServiceObject#builder(PrimitiveReferenceServiceObject)} instead of private
     * constructor to create new builder.
     */
    protected Builder( PrimitiveReferenceServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        aBoolean = pObject.aBoolean;
        booleanSet = pObject.booleanSet;
        buffers = pObject.buffers;
        strings = pObject.strings;
        stringArray = pObject.stringArray;
      }
    }

    /**
     * Method sets the association "aBoolean".
     * 
     * @param pABoolean Boolean to which the association "aBoolean" should be set.
     */
    public Builder setABoolean( Boolean pABoolean ) {
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets the association "booleanSet".
     * 
     * @param pBooleanSet Collection with objects to which the association should be set.
     */
    public Builder setBooleanSet( Set<Boolean> pBooleanSet ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBooleanSet != null) {
        booleanSet = new HashSet<Boolean>(pBooleanSet);
      }
      else {
        booleanSet = null;
      }
      return this;
    }

    /**
     * Method sets the association "buffers".
     * 
     * @param pBuffers Collection with objects to which the association should be set.
     */
    public Builder setBuffers( Set<StringBuffer> pBuffers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBuffers != null) {
        buffers = new HashSet<StringBuffer>(pBuffers);
      }
      else {
        buffers = null;
      }
      return this;
    }

    /**
     * Method sets the association "strings".
     * 
     * @param pStrings Collection with objects to which the association should be set.
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
     * Method sets the attribute "stringArray".
     * 
     * @param pStringArray Value to which the attribute "stringArray" should be set.
     */
    public Builder setStringArray( String[] pStringArray ) {
      // Assign value to attribute
      if (pStringArray != null) {
        stringArray = new String[pStringArray.length];
        System.arraycopy(pStringArray, 0, stringArray, 0, pStringArray.length);
      }
      else {
        stringArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PrimitiveReferenceServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @return PrimitiveReferenceServiceObject Created object. The method never returns null.
     */
    public PrimitiveReferenceServiceObject build( ) {
      return new PrimitiveReferenceServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class PrimitiveReferenceServiceObject. The object will be initialized
     * with the values of the builder and validated afterwards.
     * 
     * @return PrimitiveReferenceServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrimitiveReferenceServiceObject buildValidated( ) throws ConstraintViolationException {
      PrimitiveReferenceServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #aBoolean}.<br/>
   * 
   * @return {@link Boolean} Value to which {@link #aBoolean} is set.
   */
  public Boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets association {@link #aBoolean}.<br/>
   * 
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   */
  public void setABoolean( Boolean pABoolean ) {
    aBoolean = pABoolean;
  }

  /**
   * Method unsets {@link #aBoolean}.
   */
  public final void unsetABoolean( ) {
    aBoolean = null;
  }

  /**
   * Method returns association {@link #booleanSet}.<br/>
   * 
   * @return {@link Set<Boolean>} Value to which {@link #booleanSet} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Boolean> getBooleanSet( ) {
    // Return all Boolean objects as unmodifiable collection.
    return Collections.unmodifiableSet(booleanSet);
  }

  /**
   * Method adds the passed object to {@link #booleanSet}.
   * 
   * @param pBooleanSet Object that should be added to {@link #booleanSet}. The parameter must not be null.
   */
  public void addToBooleanSet( Boolean pBooleanSet ) {
    // Check parameter "pBooleanSet" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanSet, "pBooleanSet");
    // Add passed object to collection of associated Boolean objects.
    booleanSet.add(pBooleanSet);
  }

  /**
   * Method adds all passed objects to {@link #booleanSet}.
   * 
   * @param pBooleanSet Collection with all objects that should be added to {@link #booleanSet}. The parameter must not
   * be null.
   */
  public void addToBooleanSet( Collection<Boolean> pBooleanSet ) {
    // Check parameter "pBooleanSet" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanSet, "pBooleanSet");
    // Add all passed objects.
    for (Boolean lNextObject : pBooleanSet) {
      this.addToBooleanSet(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #booleanSet}.<br/>
   * 
   * @param pBooleanSet Object that should be removed from {@link #booleanSet}. The parameter must not be null.
   */
  public void removeFromBooleanSet( Boolean pBooleanSet ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBooleanSet, "pBooleanSet");
    // Remove passed object from collection of associated Boolean objects.
    booleanSet.remove(pBooleanSet);
  }

  /**
   * Method removes all objects from {@link #booleanSet}.
   */
  public void clearBooleanSet( ) {
    // Remove all objects from association "booleanSet".
    booleanSet.clear();
  }

  /**
   * Method returns association {@link #buffers}.<br/>
   * 
   * @return {@link Set<StringBuffer>} Value to which {@link #buffers} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<StringBuffer> getBuffers( ) {
    // Return all StringBuffer objects as unmodifiable collection.
    return Collections.unmodifiableSet(buffers);
  }

  /**
   * Method adds the passed object to {@link #buffers}.
   * 
   * @param pBuffers Object that should be added to {@link #buffers}. The parameter must not be null.
   */
  public void addToBuffers( StringBuffer pBuffers ) {
    // Check parameter "pBuffers" for invalid value null.
    Check.checkInvalidParameterNull(pBuffers, "pBuffers");
    // Add passed object to collection of associated StringBuffer objects.
    buffers.add(pBuffers);
  }

  /**
   * Method adds all passed objects to {@link #buffers}.
   * 
   * @param pBuffers Collection with all objects that should be added to {@link #buffers}. The parameter must not be
   * null.
   */
  public void addToBuffers( Collection<StringBuffer> pBuffers ) {
    // Check parameter "pBuffers" for invalid value null.
    Check.checkInvalidParameterNull(pBuffers, "pBuffers");
    // Add all passed objects.
    for (StringBuffer lNextObject : pBuffers) {
      this.addToBuffers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #buffers}.<br/>
   * 
   * @param pBuffers Object that should be removed from {@link #buffers}. The parameter must not be null.
   */
  public void removeFromBuffers( StringBuffer pBuffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBuffers, "pBuffers");
    // Remove passed object from collection of associated StringBuffer objects.
    buffers.remove(pBuffers);
  }

  /**
   * Method removes all objects from {@link #buffers}.
   */
  public void clearBuffers( ) {
    // Remove all objects from association "buffers".
    buffers.clear();
  }

  /**
   * Method returns association {@link #strings}.<br/>
   * 
   * @return {@link Set<String>} Value to which {@link #strings} is set. The method never returns null and the returned
   * collection is unmodifiable.
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
   * Method returns attribute {@link #stringArray}.<br/>
   * 
   * @return {@link String} Value to which {@link #stringArray} is set.
   */
  public String[] getStringArray( ) {
    String[] lReturnValue;
    if (stringArray != null) {
      lReturnValue = new String[stringArray.length];
      System.arraycopy(stringArray, 0, lReturnValue, 0, stringArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #stringArray}.<br/>
   * 
   * @param pStringArray Value to which {@link #stringArray} should be set.
   */
  public void setStringArray( String[] pStringArray ) {
    // Assign value to attribute
    if (pStringArray != null) {
      stringArray = new String[pStringArray.length];
      System.arraycopy(pStringArray, 0, stringArray, 0, pStringArray.length);
    }
    else {
      stringArray = null;
    }
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
