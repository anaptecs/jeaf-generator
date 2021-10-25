/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class PartiallyDeprecatedServiceObjectBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "outdated".
   */
  @Deprecated
  public static final String OUTDATED = "outdated";

  /**
   * Constant for the name of attribute "deprecatedRef".
   */
  @Deprecated
  public static final String DEPRECATEDREF = "deprecatedRef";

  /**
   * Constant for the name of attribute "deprecatedRefs".
   */
  @Deprecated
  public static final String DEPRECATEDREFS = "deprecatedRefs";

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  @Deprecated
  private boolean outdated;

  /**
   * 
   */
  @Deprecated
  private DeprecatedServiceObject deprecatedRef;

  /**
   * 
   */
  @Deprecated
  private Set<ValidationTestObject> deprecatedRefs = new HashSet<ValidationTestObject>();

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartiallyDeprecatedServiceObjectBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    outdated = pBuilder.outdated;
    deprecatedRef = pBuilder.deprecatedRef;
    if (pBuilder.deprecatedRefs != null) {
      deprecatedRefs.addAll(pBuilder.deprecatedRefs);
    }
  }

  /**
   * Class implements builder to create a new instance of class PartiallyDeprecatedServiceObject. As the class has
   * readonly attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    @Deprecated
    private boolean outdated;

    /**
     * 
     */
    @Deprecated
    private DeprecatedServiceObject deprecatedRef;

    /**
     * 
     */
    @Deprecated
    private Set<ValidationTestObject> deprecatedRefs;

    /**
     * Use {@link PartiallyDeprecatedServiceObject.Builder#newBuilder()} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link PartiallyDeprecatedServiceObject.Builder#newBuilder(PartiallyDeprecatedServiceObject)} instead of
     * protected constructor to create new builder.
     */
    protected BuilderBase( PartiallyDeprecatedServiceObjectBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        outdated = pObject.outdated;
        deprecatedRef = pObject.deprecatedRef;
        deprecatedRefs = pObject.deprecatedRefs;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "outdated".
     * 
     * @param pOutdated Value to which the attribute "outdated" should be set.
     */
    @Deprecated
    public BuilderBase setOutdated( boolean pOutdated ) {
      // Assign value to attribute
      outdated = pOutdated;
      return this;
    }

    /**
     * Method sets the association "deprecatedRef".
     * 
     * @param pDeprecatedRef DeprecatedServiceObject to which the association "deprecatedRef" should be set.
     */
    public BuilderBase setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
      deprecatedRef = pDeprecatedRef;
      return this;
    }

    /**
     * Method sets the association "deprecatedRefs".
     * 
     * @param pDeprecatedRefs Collection with objects to which the association should be set.
     */
    @Deprecated
    public BuilderBase setDeprecatedRefs( Set<ValidationTestObject> pDeprecatedRefs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDeprecatedRefs != null) {
        deprecatedRefs = new HashSet<ValidationTestObject>(pDeprecatedRefs);
      }
      else {
        deprecatedRefs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PartiallyDeprecatedServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @return PartiallyDeprecatedServiceObject Created object. The method never returns null.
     */
    public PartiallyDeprecatedServiceObject build( ) {
      return new PartiallyDeprecatedServiceObject(this);
    }

    /**
     * Method creates a new instance of class PartiallyDeprecatedServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return PartiallyDeprecatedServiceObject Created object. The method never returns null.
     */
    public PartiallyDeprecatedServiceObject build( boolean pValidate ) {
      PartiallyDeprecatedServiceObject lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "outdated".
   * 
   * 
   * @return Boolean Value to which the attribute "outdated" is set.
   */
  @Deprecated
  public boolean getOutdated( ) {
    return outdated;
  }

  /**
   * Method sets the attribute "outdated".
   * 
   * 
   * @param pOutdated Value to which the attribute "outdated" should be set.
   */
  @Deprecated
  public void setOutdated( boolean pOutdated ) {
    // Assign value to attribute
    outdated = pOutdated;
  }

  /**
   * Method returns the association "deprecatedRef".
   * 
   *
   * @return DeprecatedServiceObject DeprecatedServiceObject to which the association "deprecatedRef" is set.
   */
  @Deprecated
  public DeprecatedServiceObject getDeprecatedRef( ) {
    return deprecatedRef;
  }

  /**
   * Method sets the association "deprecatedRef".
   * 
   * 
   * @param pDeprecatedRef DeprecatedServiceObject to which the association "deprecatedRef" should be set.
   */
  @Deprecated
  public void setDeprecatedRef( DeprecatedServiceObject pDeprecatedRef ) {
    deprecatedRef = pDeprecatedRef;
  }

  /**
   * Method unsets the association "deprecatedRef".
   * 
   */
  @Deprecated
  public final void unsetDeprecatedRef( ) {
    deprecatedRef = null;
  }

  /**
   * Method returns the association "deprecatedRefs".
   * 
   *
   * @return Collection All ValidationTestObject objects that belong to the association "deprecatedRefs". The method
   * never returns null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ValidationTestObject> getDeprecatedRefs( ) {
    // Return all ValidationTestObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedRefs);
  }

  /**
   * Method sets the association "deprecatedRefs" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pDeprecatedRefs Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  @Deprecated
  void setDeprecatedRefs( Set<ValidationTestObject> pDeprecatedRefs ) {
    // Check of parameter is not required.
    // Remove all objects from association "deprecatedRefs".
    this.clearDeprecatedRefs();
    // If the association is null, removing all entries is sufficient.
    if (pDeprecatedRefs != null) {
      deprecatedRefs = new HashSet<ValidationTestObject>(pDeprecatedRefs);
    }
  }

  /**
   * Method adds the passed ValidationTestObject object to the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be added to the association "deprecatedRefs". The parameter must not be
   * null.
   */
  @Deprecated
  public void addToDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add passed object to collection of associated ValidationTestObject objects.
    deprecatedRefs.add(pDeprecatedRefs);
  }

  /**
   * Method adds all passed objects to the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Collection with all objects that should be added to the association "deprecatedRefs". The
   * parameter must not be null.
   */
  @Deprecated
  public void addToDeprecatedRefs( Collection<ValidationTestObject> pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add all passed objects.
    for (ValidationTestObject lNextObject : pDeprecatedRefs) {
      this.addToDeprecatedRefs(lNextObject);
    }
  }

  /**
   * Method removes the passed ValidationTestObject object from the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be removed from the association "deprecatedRefs". The parameter must not
   * be null.
   */
  @Deprecated
  public void removeFromDeprecatedRefs( ValidationTestObject pDeprecatedRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Remove passed object from collection of associated ValidationTestObject objects.
    deprecatedRefs.remove(pDeprecatedRefs);
  }

  /**
   * Method removes all objects from the association "deprecatedRefs".
   * 
   */
  @Deprecated
  public void clearDeprecatedRefs( ) {
    // Remove all objects from association "deprecatedRefs".
    Collection<ValidationTestObject> lDeprecatedRefs = new HashSet<ValidationTestObject>(deprecatedRefs);
    Iterator<ValidationTestObject> lIterator = lDeprecatedRefs.iterator();
    while (lIterator.hasNext()) {
      this.removeFromDeprecatedRefs(lIterator.next());
    }
  }

  /**
  * 
  */
  @Deprecated
  public abstract void doSomethingDeprecated( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "outdated", "" + outdated));
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
