/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = ImmutableAssociationPOJO.Builder.class)
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

  private final boolean yetAnotherAttribute;

  private final SortedSet<ImmutablePOJO> readonlyAssociation;

  private final ImmutableChildPOJO immutableChildPOJO;

  @Deprecated
  private Set<ImmutableChildPOJO> deprecatedRefs;

  @Deprecated
  private ChildPOJO deprecatedRef;

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
      readonlyAssociation = new TreeSet<>();
    }
    immutableChildPOJO = pBuilder.immutableChildPOJO;
    if (pBuilder.deprecatedRefs != null) {
      deprecatedRefs = pBuilder.deprecatedRefs;
    }
    else {
      deprecatedRefs = new HashSet<>();
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
   * Convenience method to create new instance of class ImmutableAssociationPOJO.
   *
   *
   * @param pYetAnotherAttribute Value to which {@link #yetAnotherAttribute} should be set.
   *
   * @return {@link ImmutableAssociationPOJO}
   */
  public static ImmutableAssociationPOJO of( boolean pYetAnotherAttribute ) {
    var lBuilder = ImmutableAssociationPOJO.builder();
    lBuilder.setYetAnotherAttribute(pYetAnotherAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ImmutableAssociationPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private boolean yetAnotherAttribute;

    private SortedSet<ImmutablePOJO> readonlyAssociation;

    private ImmutableChildPOJO immutableChildPOJO;

    @Deprecated
    private Set<ImmutableChildPOJO> deprecatedRefs;

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
        this.setYetAnotherAttribute(pObject.yetAnotherAttribute);
        this.setReadonlyAssociation(pObject.readonlyAssociation);
        this.setImmutableChildPOJO(pObject.immutableChildPOJO);
        this.setDeprecatedRefs(pObject.deprecatedRefs);
        this.setDeprecatedRef(pObject.deprecatedRef);
      }
    }

    /**
     * Method sets attribute {@link #yetAnotherAttribute}.<br/>
     *
     * @param pYetAnotherAttribute Value to which {@link #yetAnotherAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setYetAnotherAttribute( boolean pYetAnotherAttribute ) {
      // Assign value to attribute
      yetAnotherAttribute = pYetAnotherAttribute;
      return this;
    }

    /**
     * Method sets association {@link #readonlyAssociation}.<br/>
     *
     * @param pReadonlyAssociation Collection to which {@link #readonlyAssociation} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #readonlyAssociation}.<br/>
     *
     * @param pReadonlyAssociation Array of objects that should be added to {@link #readonlyAssociation}. The parameter
     * may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToReadonlyAssociation( ImmutablePOJO... pReadonlyAssociation ) {
      if (pReadonlyAssociation != null) {
        if (readonlyAssociation == null) {
          readonlyAssociation = new TreeSet<ImmutablePOJO>();
        }
        readonlyAssociation.addAll(Arrays.asList(pReadonlyAssociation));
      }
      return this;
    }

    /**
     * Method sets association {@link #immutableChildPOJO}.<br/>
     *
     * @param pImmutableChildPOJO Value to which {@link #immutableChildPOJO} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setImmutableChildPOJO( ImmutableChildPOJO pImmutableChildPOJO ) {
      immutableChildPOJO = pImmutableChildPOJO;
      return this;
    }

    /**
     * Method sets association {@link #deprecatedRefs}.<br/>
     *
     * @param pDeprecatedRefs Collection to which {@link #deprecatedRefs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #deprecatedRefs}.<br/>
     *
     * @param pDeprecatedRefs Array of objects that should be added to {@link #deprecatedRefs}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    public Builder addToDeprecatedRefs( ImmutableChildPOJO... pDeprecatedRefs ) {
      if (pDeprecatedRefs != null) {
        if (deprecatedRefs == null) {
          deprecatedRefs = new HashSet<ImmutableChildPOJO>();
        }
        deprecatedRefs.addAll(Arrays.asList(pDeprecatedRefs));
      }
      return this;
    }

    /**
     * Method sets association {@link #deprecatedRef}.<br/>
     *
     * @param pDeprecatedRef Value to which {@link #deprecatedRef} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
      ImmutableAssociationPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #yetAnotherAttribute}.<br/>
   *
   * @return boolean Value to which {@link #yetAnotherAttribute} is set.
   */
  @Deprecated
  public boolean getYetAnotherAttribute( ) {
    return yetAnotherAttribute;
  }

  /**
   * Method returns attribute {@link #yetAnotherAttribute}.<br/>
   *
   * @return boolean Value to which {@link #yetAnotherAttribute} is set.
   */
  public boolean isYetAnotherAttribute( ) {
    return yetAnotherAttribute;
  }

  /**
   * Method returns association {@link #readonlyAssociation}.<br/>
   *
   * @return {@link SortedSet<ImmutablePOJO>} Value to which {@link #readonlyAssociation} is set. The method never
   * returns null and the returned collection is unmodifiable.
   */
  public SortedSet<ImmutablePOJO> getReadonlyAssociation( ) {
    // Return all ImmutablePOJO objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(readonlyAssociation);
  }

  /**
   * Method returns association {@link #immutableChildPOJO}.<br/>
   *
   * @return {@link ImmutableChildPOJO} Value to which {@link #immutableChildPOJO} is set.
   */
  public ImmutableChildPOJO getImmutableChildPOJO( ) {
    return immutableChildPOJO;
  }

  /**
   * Method returns association {@link #deprecatedRefs}.<br/>
   *
   * @return {@link Set<ImmutableChildPOJO>} Value to which {@link #deprecatedRefs} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ImmutableChildPOJO> getDeprecatedRefs( ) {
    // Return all ImmutableChildPOJO objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedRefs);
  }

  /**
   * Method adds the passed object to {@link #deprecatedRefs}.
   *
   * @param pDeprecatedRefs Object that should be added to {@link #deprecatedRefs}. The parameter must not be null.
   */
  @Deprecated
  public void addToDeprecatedRefs( ImmutableChildPOJO pDeprecatedRefs ) {
    // Check parameter "pDeprecatedRefs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Add passed object to collection of associated ImmutableChildPOJO objects.
    deprecatedRefs.add(pDeprecatedRefs);
  }

  /**
   * Method adds all passed objects to {@link #deprecatedRefs}.
   *
   * @param pDeprecatedRefs Collection with all objects that should be added to {@link #deprecatedRefs}. The parameter
   * must not be null.
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
   * Method removes the passed object from {@link #deprecatedRefs}.<br/>
   *
   * @param pDeprecatedRefs Object that should be removed from {@link #deprecatedRefs}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromDeprecatedRefs( ImmutableChildPOJO pDeprecatedRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedRefs, "pDeprecatedRefs");
    // Remove passed object from collection of associated ImmutableChildPOJO objects.
    deprecatedRefs.remove(pDeprecatedRefs);
  }

  /**
   * Method removes all objects from {@link #deprecatedRefs}.
   */
  @Deprecated
  public void clearDeprecatedRefs( ) {
    // Remove all objects from association "deprecatedRefs".
    deprecatedRefs.clear();
  }

  /**
   * Method returns association {@link #deprecatedRef}.<br/>
   *
   * @return {@link ChildPOJO} Value to which {@link #deprecatedRef} is set.
   */
  @Deprecated
  public ChildPOJO getDeprecatedRef( ) {
    return deprecatedRef;
  }

  /**
   * Method sets association {@link #deprecatedRef}.<br/>
   *
   * @param pDeprecatedRef Value to which {@link #deprecatedRef} should be set.
   */
  @Deprecated
  public void setDeprecatedRef( ChildPOJO pDeprecatedRef ) {
    deprecatedRef = pDeprecatedRef;
  }

  /**
   * Method unsets {@link #deprecatedRef}.
   */
  @Deprecated
  public final void unsetDeprecatedRef( ) {
    deprecatedRef = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Boolean.hashCode(yetAnotherAttribute);
    lResult = lPrime * lResult + Objects.hashCode(readonlyAssociation);
    lResult = lPrime * lResult + Objects.hashCode(immutableChildPOJO);
    lResult = lPrime * lResult + Objects.hashCode(deprecatedRefs);
    lResult = lPrime * lResult + Objects.hashCode(deprecatedRef);
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
      ImmutableAssociationPOJO lOther = (ImmutableAssociationPOJO) pObject;
      lEquals = yetAnotherAttribute == lOther.yetAnotherAttribute
          && Objects.equals(readonlyAssociation, lOther.readonlyAssociation)
          && Objects.equals(immutableChildPOJO, lOther.immutableChildPOJO)
          && Objects.equals(deprecatedRefs, lOther.deprecatedRefs)
          && Objects.equals(deprecatedRef, lOther.deprecatedRef);
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
    lBuilder.append("yetAnotherAttribute: ");
    lBuilder.append(yetAnotherAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readonlyAssociation: ");
    if (readonlyAssociation != null) {
      lBuilder.append(readonlyAssociation.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (readonlyAssociation != null) {
      for (ImmutablePOJO lNext : readonlyAssociation) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("immutableChildPOJO: ");
    if (immutableChildPOJO != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(immutableChildPOJO.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedRefs: ");
    if (deprecatedRefs != null) {
      lBuilder.append(deprecatedRefs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (deprecatedRefs != null) {
      for (ImmutableChildPOJO lNext : deprecatedRefs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedRef: ");
    if (deprecatedRef != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(deprecatedRef.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
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
   * @return {@link Builder} New builder that can be used to create new ImmutableAssociationPOJO objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}