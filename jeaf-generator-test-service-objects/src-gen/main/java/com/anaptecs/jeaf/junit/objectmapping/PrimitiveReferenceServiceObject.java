/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.objectmapping;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private Boolean aBoolean;

  /**
   * 
   */
  private Set<Boolean> booleanSet = new HashSet<Boolean>();

  /**
   * 
   */
  private Set<StringBuffer> buffers = new HashSet<StringBuffer>();

  /**
   * 
   */
  private Set<String> strings = new HashSet<String>();

  /**
   * 
   */
  private String[] stringArray;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveReferenceServiceObject( ) {
    // Nothing to do.
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
      booleanSet.addAll(pBuilder.booleanSet);
    }
    if (pBuilder.buffers != null) {
      buffers.addAll(pBuilder.buffers);
    }
    if (pBuilder.strings != null) {
      strings.addAll(pBuilder.strings);
    }
    stringArray = pBuilder.stringArray;
  }

  /**
   * Class implements builder to create a new instance of class PrimitiveReferenceServiceObject. As the class has read
   * only attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Boolean aBoolean;

    /**
     * 
     */
    private Set<Boolean> booleanSet;

    /**
     * 
     */
    private Set<StringBuffer> buffers;

    /**
     * 
     */
    private Set<String> strings;

    /**
     * 
     */
    private String[] stringArray;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PrimitiveReferenceServiceObject)} instead of private constructor to create new builder.
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PrimitiveReferenceServiceObject objects. The
     * method never returns null.
     */
    public static Builder newBuilder( PrimitiveReferenceServiceObject pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class PrimitiveReferenceServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return PrimitiveReferenceServiceObject Created object. The method never returns null.
     */
    public PrimitiveReferenceServiceObject build( boolean pValidate ) {
      PrimitiveReferenceServiceObject lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the association "aBoolean".
   * 
   *
   * @return Boolean Boolean to which the association "aBoolean" is set.
   */
  public Boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets the association "aBoolean".
   * 
   * 
   * @param pABoolean Boolean to which the association "aBoolean" should be set.
   */
  public void setABoolean( Boolean pABoolean ) {
    aBoolean = pABoolean;
  }

  /**
   * Method unsets the association "aBoolean".
   * 
   */
  public final void unsetABoolean( ) {
    aBoolean = null;
  }

  /**
   * Method returns the association "booleanSet".
   * 
   *
   * @return Collection All Boolean objects that belong to the association "booleanSet". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<Boolean> getBooleanSet( ) {
    // Return all Boolean objects as unmodifiable collection.
    return Collections.unmodifiableSet(booleanSet);
  }

  /**
   * Method sets the association "booleanSet" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pBooleanSet Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setBooleanSet( Set<Boolean> pBooleanSet ) {
    // Check of parameter is not required.
    // Remove all objects from association "booleanSet".
    this.clearBooleanSet();
    // If the association is null, removing all entries is sufficient.
    if (pBooleanSet != null) {
      booleanSet = new HashSet<Boolean>(pBooleanSet);
    }
  }

  /**
   * Method adds the passed Boolean object to the association "booleanSet".
   * 
   * 
   * @param pBooleanSet Object that should be added to the association "booleanSet". The parameter must not be null.
   */
  public void addToBooleanSet( Boolean pBooleanSet ) {
    // Check parameter "pBooleanSet" for invalid value null.
    Check.checkInvalidParameterNull(pBooleanSet, "pBooleanSet");
    // Add passed object to collection of associated Boolean objects.
    booleanSet.add(pBooleanSet);
  }

  /**
   * Method adds all passed objects to the association "booleanSet".
   * 
   * 
   * @param pBooleanSet Collection with all objects that should be added to the association "booleanSet". The parameter
   * must not be null.
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
   * Method removes the passed Boolean object from the association "booleanSet".
   * 
   * 
   * @param pBooleanSet Object that should be removed from the association "booleanSet". The parameter must not be null.
   */
  public void removeFromBooleanSet( Boolean pBooleanSet ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBooleanSet, "pBooleanSet");
    // Remove passed object from collection of associated Boolean objects.
    booleanSet.remove(pBooleanSet);
  }

  /**
   * Method removes all objects from the association "booleanSet".
   * 
   */
  public void clearBooleanSet( ) {
    // Remove all objects from association "booleanSet".
    Collection<Boolean> lBooleanSet = new HashSet<Boolean>(booleanSet);
    Iterator<Boolean> lIterator = lBooleanSet.iterator();
    while (lIterator.hasNext()) {
      this.removeFromBooleanSet(lIterator.next());
    }
  }

  /**
   * Method returns the association "buffers".
   * 
   *
   * @return Collection All StringBuffer objects that belong to the association "buffers". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<StringBuffer> getBuffers( ) {
    // Return all StringBuffer objects as unmodifiable collection.
    return Collections.unmodifiableSet(buffers);
  }

  /**
   * Method sets the association "buffers" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pBuffers Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setBuffers( Set<StringBuffer> pBuffers ) {
    // Check of parameter is not required.
    // Remove all objects from association "buffers".
    this.clearBuffers();
    // If the association is null, removing all entries is sufficient.
    if (pBuffers != null) {
      buffers = new HashSet<StringBuffer>(pBuffers);
    }
  }

  /**
   * Method adds the passed StringBuffer object to the association "buffers".
   * 
   * 
   * @param pBuffers Object that should be added to the association "buffers". The parameter must not be null.
   */
  public void addToBuffers( StringBuffer pBuffers ) {
    // Check parameter "pBuffers" for invalid value null.
    Check.checkInvalidParameterNull(pBuffers, "pBuffers");
    // Add passed object to collection of associated StringBuffer objects.
    buffers.add(pBuffers);
  }

  /**
   * Method adds all passed objects to the association "buffers".
   * 
   * 
   * @param pBuffers Collection with all objects that should be added to the association "buffers". The parameter must
   * not be null.
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
   * Method removes the passed StringBuffer object from the association "buffers".
   * 
   * 
   * @param pBuffers Object that should be removed from the association "buffers". The parameter must not be null.
   */
  public void removeFromBuffers( StringBuffer pBuffers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBuffers, "pBuffers");
    // Remove passed object from collection of associated StringBuffer objects.
    buffers.remove(pBuffers);
  }

  /**
   * Method removes all objects from the association "buffers".
   * 
   */
  public void clearBuffers( ) {
    // Remove all objects from association "buffers".
    Collection<StringBuffer> lBuffers = new HashSet<StringBuffer>(buffers);
    Iterator<StringBuffer> lIterator = lBuffers.iterator();
    while (lIterator.hasNext()) {
      this.removeFromBuffers(lIterator.next());
    }
  }

  /**
   * Method returns the association "strings".
   * 
   *
   * @return Collection All String objects that belong to the association "strings". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<String> getStrings( ) {
    // Return all String objects as unmodifiable collection.
    return Collections.unmodifiableSet(strings);
  }

  /**
   * Method sets the association "strings" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pStrings Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setStrings( Set<String> pStrings ) {
    // Check of parameter is not required.
    // Remove all objects from association "strings".
    this.clearStrings();
    // If the association is null, removing all entries is sufficient.
    if (pStrings != null) {
      strings = new HashSet<String>(pStrings);
    }
  }

  /**
   * Method adds the passed String object to the association "strings".
   * 
   * 
   * @param pStrings Object that should be added to the association "strings". The parameter must not be null.
   */
  public void addToStrings( String pStrings ) {
    // Check parameter "pStrings" for invalid value null.
    Check.checkInvalidParameterNull(pStrings, "pStrings");
    // Add passed object to collection of associated String objects.
    strings.add(pStrings);
  }

  /**
   * Method adds all passed objects to the association "strings".
   * 
   * 
   * @param pStrings Collection with all objects that should be added to the association "strings". The parameter must
   * not be null.
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
   * Method removes the passed String object from the association "strings".
   * 
   * 
   * @param pStrings Object that should be removed from the association "strings". The parameter must not be null.
   */
  public void removeFromStrings( String pStrings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStrings, "pStrings");
    // Remove passed object from collection of associated String objects.
    strings.remove(pStrings);
  }

  /**
   * Method removes all objects from the association "strings".
   * 
   */
  public void clearStrings( ) {
    // Remove all objects from association "strings".
    Collection<String> lStrings = new HashSet<String>(strings);
    Iterator<String> lIterator = lStrings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromStrings(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "stringArray".
   * 
   * 
   * @return String Value to which the attribute "stringArray" is set.
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
   * Method sets the attribute "stringArray".
   * 
   * 
   * @param pStringArray Value to which the attribute "stringArray" should be set.
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
