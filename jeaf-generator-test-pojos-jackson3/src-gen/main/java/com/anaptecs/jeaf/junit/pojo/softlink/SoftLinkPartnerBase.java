/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonPropertyOrder(value = { "theBackLink", "childLinks", "longLinks", "derivedSoftLink", "theDerivedSoftLinks" })
@JsonDeserialize(builder = SoftLinkPartner.Builder.class)
public abstract class SoftLinkPartnerBase {
  /**
   * Constant for the name of attribute "theBackLink".
   */
  public static final String THEBACKLINK = "theBackLink";

  /**
   * Constant for the name of attribute "childLinks".
   */
  public static final String CHILDLINKS = "childLinks";

  /**
   * Constant for the name of attribute "longLinks".
   */
  public static final String LONGLINKS = "longLinks";

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
   * <code>SoftLinkParent</code><br/>
   */
  private final String theBackLinkID;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #childLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   */
  private final Set<SoftLinkID> childLinkIDs;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #longLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   */
  private final List<Long> longLinkIDs;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkPartnerBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    theBackLinkID = pBuilder.theBackLinkID;
    childLinkIDs = (pBuilder.childLinkIDs == null) ? Set.of() : Set.copyOf(pBuilder.childLinkIDs);
    longLinkIDs = (pBuilder.longLinkIDs == null) ? List.of() : List.copyOf(pBuilder.longLinkIDs);
  }

  /**
   * Class implements builder to create a new instance of class SoftLinkPartner. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
     * <code>SoftLinkParent</code><br/>
     */
    private String theBackLinkID;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #childLinks} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private Set<SoftLinkID> childLinkIDs;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #longLinks} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private List<Long> longLinkIDs;

    /**
     * Use {@link SoftLinkPartner.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link SoftLinkPartner.builder(SoftLinkPartner)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( SoftLinkPartnerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTheBackLinkID(pObject.theBackLinkID);
        this.setChildLinkIDs(pObject.childLinkIDs);
        this.setLongLinkIDs(pObject.longLinkIDs);
      }
    }

    /**
     * Method sets association {@link #theBackLink}.<br/>
     *
     * @param pTheBackLink Value to which {@link #theBackLink} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setTheBackLinkID( String pTheBackLink ) {
      theBackLinkID = pTheBackLink;
      return this;
    }

    /**
     * Method sets association {@link #childLinks}.<br/>
     *
     * @param pChildLinks Collection to which {@link #childLinks} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public BuilderBase setChildLinkIDs( Set<SoftLinkID> pChildLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChildLinks != null) {
        childLinkIDs = new HashSet<SoftLinkID>(pChildLinks);
      }
      else {
        childLinkIDs = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #longLinks}.<br/>
     *
     * @param pLongLinks Collection to which {@link #longLinks} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public BuilderBase setLongLinkIDs( List<Long> pLongLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLongLinks != null) {
        longLinkIDs = new ArrayList<Long>(pLongLinks);
      }
      else {
        longLinkIDs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class SoftLinkPartner. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkPartner Created object. The method never returns null.
     */
    public SoftLinkPartner build( ) {
      return new SoftLinkPartner(this);
    }

    /**
     * Method creates a new validated instance of class SoftLinkPartner. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SoftLinkPartner Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkPartner buildValidated( ) throws ConstraintViolationException {
      SoftLinkPartner lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #theBackLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
   * <code>SoftLinkParent</code><br/>
   *
   * @return {@link String} Value to which {@link #theBackLink} is set.
   */
  public String getTheBackLinkID( ) {
    return theBackLinkID;
  }

  /**
   * Method returns association {@link #childLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #childLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   *
   * @return {@link Set<SoftLinkID>} Value to which {@link #childLinks} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<SoftLinkID> getChildLinkIDs( ) {
    return childLinkIDs;
  }

  /**
   * Method returns association {@link #longLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #longLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   *
   * @return {@link List<long>} Value to which {@link #longLinks} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<Long> getLongLinkIDs( ) {
    return longLinkIDs;
  }

  /**
   * Convenience method to create new instance of class SoftLinkPartner.
   *
   *
   * @param pLongLinks Value to which {@link #longLinks} should be set.
   *
   * @return {@link SoftLinkPartner}
   */
  public static SoftLinkPartner of( List<Long> pLongLinkIDs ) {
    var lBuilder = SoftLinkPartner.builder();
    lBuilder.setLongLinkIDs(pLongLinkIDs);
    return lBuilder.build();
  }

  /**
   * Method returns association {@link #derivedSoftLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #derivedSoftLink} is
   * <code>SoftLinkParent</code><br/>
   *
   * @return {@link String} Value to which {@link #derivedSoftLink} is set.
   */
  @JsonGetter
  public abstract String getDerivedSoftLinkID( );

  /**
   * Method returns association {@link #theDerivedSoftLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theDerivedSoftLinks}
   * is <code>SoftLinkParent</code><br/>
   *
   * @return {@link List<SoftLinkID>} Value to which {@link #theDerivedSoftLinks} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  @JsonGetter
  public abstract List<SoftLinkID> getTheDerivedSoftLinkIDs( );

  @JsonSetter
  private void setTheDerivedSoftLinks( List<SoftLinkParent> pTheDerivedSoftLinks ) {
    // Actively ignore passed objects as this is just a derived property. Unfortunately there is no more elegant variant
    // to not run into problems during deserialization.
  }

  /**
   * Method returns association {@link #javaOnlyDerivedSoftLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by
   * {@link #javaOnlyDerivedSoftLink} is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #javaOnlyDerivedSoftLink} is set.
   */
  public abstract SoftLinkID getJavaOnlyDerivedSoftLinkID( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(theBackLinkID);
    lResult = lPrime * lResult + Objects.hashCode(childLinkIDs);
    lResult = lPrime * lResult + Objects.hashCode(longLinkIDs);
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
      SoftLinkPartnerBase lOther = (SoftLinkPartnerBase) pObject;
      lEquals = Objects.equals(theBackLinkID, lOther.theBackLinkID) && Objects.equals(childLinkIDs, lOther.childLinkIDs)
          && Objects.equals(longLinkIDs, lOther.longLinkIDs);
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
    lBuilder.append("theBackLinkID: ");
    lBuilder.append(theBackLinkID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("childLinkIDs: ");
    if (childLinkIDs != null) {
      lBuilder.append(childLinkIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (childLinkIDs != null) {
      for (SoftLinkID lNext : childLinkIDs) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("longLinkIDs: ");
    if (longLinkIDs != null) {
      lBuilder.append(longLinkIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (longLinkIDs != null) {
      for (Long lNext : longLinkIDs) {
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
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects. The method never
   * returns null.
   */
  public SoftLinkPartner.Builder toBuilder( ) {
    return new SoftLinkPartner.Builder((SoftLinkPartner) this);
  }
}