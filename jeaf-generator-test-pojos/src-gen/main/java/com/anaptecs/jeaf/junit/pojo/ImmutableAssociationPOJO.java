/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImmutableAssociationPOJO {
  /**
   * Constant for the name of attribute "yetAnotherAttribute".
   */
  public static final String YETANOTHERATTRIBUTE = "yetAnotherAttribute";

  /**
   * Constant for the name of attribute "readonlyAssociation".
   */
  public static final String READONLYASSOCIATION = "readonlyAssociation";

  /**
   * Constant for the name of attribute "immutableChildPOJO".
   */
  public static final String IMMUTABLECHILDPOJO = "immutableChildPOJO";

  /**
   * Constant for the name of attribute "deprecatedRefs".
   */
  @Deprecated
  public static final String DEPRECATEDREFS = "deprecatedRefs";

  /**
   * Constant for the name of attribute "deprecatedRef".
   */
  @Deprecated
  public static final String DEPRECATEDREF = "deprecatedRef";

  /**
   * 
   */
  private final boolean yetAnotherAttribute;

  /**
   * 
   */
  private final SortedSet<ImmutablePOJO> readonlyAssociation;

  /**
   * 
   */
  private final ImmutableChildPOJO immutableChildPOJO;

  /**
   * 
   */
  @Deprecated
  private Set<ImmutableChildPOJO> deprecatedRefs;

  /**
   * 
   */
  @Deprecated
  private ChildPOJO deprecatedRef;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ImmutableAssociationPOJO( ) {
    yetAnotherAttribute = false;
    readonlyAssociation = new TreeSet<ImmutablePOJO>();
    immutableChildPOJO = null;
    deprecatedRefs = new HashSet<ImmutableChildPOJO>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutableAssociationPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    yetAnotherAttribute = pBuilder.yetAnotherAttribute;
    if (pBuilder.readonlyAssociation != null) {
      readonlyAssociation = pBuilder.readonlyAssociation;
    }
    else {
      readonlyAssociation = new TreeSet<ImmutablePOJO>();
    }
    immutableChildPOJO = pBuilder.immutableChildPOJO;
    if (pBuilder.deprecatedRefs != null) {
      deprecatedRefs = pBuilder.deprecatedRefs;
    }
    else {
      deprecatedRefs = new HashSet<ImmutableChildPOJO>();
    }
    deprecatedRef = pBuilder.deprecatedRef;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ImmutableAssociationPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ImmutableAssociationPOJO objects. The method
   * never returns null.
   */
  public static Builder builder( ImmutableAssociationPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ImmutableAssociationPOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean yetAnotherAttribute;

    /**
     * 
     */
    private SortedSet<ImmutablePOJO> readonlyAssociation;

    /**
     * 
     */
    private ImmutableChildPOJO immutableChildPOJO;

    /**
     * 
     */
    @Deprecated
    private Set<ImmutableChildPOJO> deprecatedRefs;

    /**
     * 
     */
    @Deprecated
    private ChildPOJO deprecatedRef;

    /**
     * Use {@link ImmutableAssociationPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ImmutableAssociationPOJO#builder(ImmutableAssociationPOJO)} instead of private constructor to create
     * new builder.
     */
    protected Builder( ImmutableAssociationPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        yetAnotherAttribute = pObject.yetAnotherAttribute;
        readonlyAssociation = pObject.readonlyAssociation;
        immutableChildPOJO = pObject.immutableChildPOJO;
        deprecatedRefs = pObject.deprecatedRefs;
        deprecatedRef = pObject.deprecatedRef;
      }
    }

    /**
     * Method sets the attribute "yetAnotherAttribute".
     * 
     * @param pYetAnotherAttribute Value to which the attribute "yetAnotherAttribute" should be set.
     */
    public Builder setYetAnotherAttribute( boolean pYetAnotherAttribute ) {
      // Assign value to attribute
      yetAnotherAttribute = pYetAnotherAttribute;
      return this;
    }

    /**
     * Method sets the association "readonlyAssociation".
     * 
     * @param pReadonlyAssociation Collection with objects to which the association should be set.
     */
    public Builder setReadonlyAssociation( SortedSet<ImmutablePOJO> pReadonlyAssociation ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pReadonlyAssociation != null) {
        readonlyAssociation = new TreeSet<ImmutablePOJO>(pReadonlyAssociation);
      }
      else {
        readonlyAssociation = null;
      }
      return this;
    }

    /**
     * Method sets the association "immutableChildPOJO".
     * 
     * @param pImmutableChildPOJO ImmutableChildPOJO to which the association "immutableChildPOJO" should be set.
     */
    public Builder setImmutableChildPOJO( ImmutableChildPOJO pImmutableChildPOJO ) {
      immutableChildPOJO = pImmutableChildPOJO;
      return this;
    }

    /**
     * Method sets the association "deprecatedRefs".
     * 
     * @param pDeprecatedRefs Collection with objects to which the association should be set.
     */
    @Deprecated
    public Builder setDeprecatedRefs( Set<ImmutableChildPOJO> pDeprecatedRefs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDeprecatedRefs != null) {
        deprecatedRefs = new HashSet<ImmutableChildPOJO>(pDeprecatedRefs);
      }
      else {
        deprecatedRefs = null;
      }
      return this;
    }

    /**
     * Method sets the association "deprecatedRef".
     * 
     * @param pDeprecatedRef ChildPOJO to which the association "deprecatedRef" should be set.
     */
    @Deprecated
    public Builder setDeprecatedRef( ChildPOJO pDeprecatedRef ) {
      deprecatedRef = pDeprecatedRef;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutableAssociationPOJO. The object will be initialized with the values
     * of the builder.
     * 
     * @return ImmutableAssociationPOJO Created object. The method never returns null.
     */
    public ImmutableAssociationPOJO build( ) {
      return new ImmutableAssociationPOJO(this);
    }

    /**
     * Method creates a new validated instance of class ImmutableAssociationPOJO. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return ImmutableAssociationPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutableAssociationPOJO buildValidated( ) throws ConstraintViolationException {
      ImmutableAssociationPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "yetAnotherAttribute".
   * 
   * 
   * @return Boolean Value to which the attribute "yetAnotherAttribute" is set.
   */
  public boolean getYetAnotherAttribute( ) {
    return yetAnotherAttribute;
  }

  /**
   * Method returns the association "readonlyAssociation".
   * 
   *
   * @return Collection All ImmutablePOJO objects that belong to the association "readonlyAssociation". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public SortedSet<ImmutablePOJO> getReadonlyAssociation( ) {
    // Return all ImmutablePOJO objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(readonlyAssociation);
  }

  /**
   * Method returns the association "immutableChildPOJO".
   * 
   *
   * @return ImmutableChildPOJO ImmutableChildPOJO to which the association "immutableChildPOJO" is set.
   */
  public ImmutableChildPOJO getImmutableChildPOJO( ) {
    return immutableChildPOJO;
  }

  /**
   * Method returns the association "deprecatedRefs".
   * 
   *
   * @return Collection All ImmutableChildPOJO objects that belong to the association "deprecatedRefs". The method never
   * returns null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ImmutableChildPOJO> getDeprecatedRefs( ) {
    // Return all ImmutableChildPOJO objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedRefs);
  }

  /**
   * Method adds the passed ImmutableChildPOJO object to the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be added to the association "deprecatedRefs". The parameter must not be
   * null.
   */
  @Deprecated
  public void addToDeprecatedRefs( ImmutableChildPOJO pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add passed object to collection of associated ImmutableChildPOJO objects.
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
  public void addToDeprecatedRefs( Collection<ImmutableChildPOJO> pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add all passed objects.
    for (ImmutableChildPOJO lNextObject : pDeprecatedRefs) {
      this.addToDeprecatedRefs(lNextObject);
    }
  }

  /**
   * Method removes the passed ImmutableChildPOJO object from the association "deprecatedRefs".
   * 
   * 
   * @param pDeprecatedRefs Object that should be removed from the association "deprecatedRefs". The parameter must not
   * be null.
   */
  @Deprecated
  public void removeFromDeprecatedRefs( ImmutableChildPOJO pDeprecatedRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Remove passed object from collection of associated ImmutableChildPOJO objects.
    deprecatedRefs.remove(pDeprecatedRefs);
  }

  /**
   * Method removes all objects from the association "deprecatedRefs".
   * 
   */
  @Deprecated
  public void clearDeprecatedRefs( ) {
    // Remove all objects from association "deprecatedRefs".
    deprecatedRefs.clear();
  }

  /**
   * Method returns the association "deprecatedRef".
   * 
   *
   * @return ChildPOJO ChildPOJO to which the association "deprecatedRef" is set.
   */
  @Deprecated
  public ChildPOJO getDeprecatedRef( ) {
    return deprecatedRef;
  }

  /**
   * Method sets the association "deprecatedRef".
   * 
   * 
   * @param pDeprecatedRef ChildPOJO to which the association "deprecatedRef" should be set.
   */
  @Deprecated
  public void setDeprecatedRef( ChildPOJO pDeprecatedRef ) {
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
    lBuilder.append("yetAnotherAttribute: ");
    lBuilder.append(yetAnotherAttribute);
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
