/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = SoftLinkPartner.SoftLinkPartnerBuilderImpl.class)
public class SoftLinkPartner {
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
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
   */
  private String theBackLinkID;

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
  private List<Long> longLinkIDs;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkPartner( SoftLinkPartnerBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    theBackLinkID = pBuilder.theBackLinkID;
    if (pBuilder.childLinkIDs != null) {
      childLinkIDs = pBuilder.childLinkIDs;
    }
    else {
      childLinkIDs = new HashSet<>();
    }
    if (pBuilder.longLinkIDs != null) {
      longLinkIDs = pBuilder.longLinkIDs;
    }
    else {
      longLinkIDs = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects.
   */
  public static SoftLinkPartnerBuilder<?, ?> builder( ) {
    return new SoftLinkPartnerBuilderImpl();
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
    SoftLinkPartnerBuilder<?, ?> lBuilder = SoftLinkPartner.builder();
    lBuilder.setLongLinkIDs(pLongLinkIDs);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkPartner</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SoftLinkPartnerBuilder<T extends SoftLinkPartner, B extends SoftLinkPartnerBuilder<T, B>> {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
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
     * Use {@link SoftLinkPartnerBuilder#builder()} instead of private constructor to create new builder.
     */
    protected SoftLinkPartnerBuilder( ) {
    }

    /**
     * Use {@link SoftLinkPartnerBuilder#builder(SoftLinkPartner)} instead of private constructor to create new builder.
     */
    protected SoftLinkPartnerBuilder( SoftLinkPartner pObject ) {
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTheBackLinkID( String pTheBackLink ) {
      theBackLinkID = pTheBackLink;
      return this.self();
    }

    /**
     * Method sets association {@link #childLinks}.<br/>
     *
     * @param pChildLinks Collection to which {@link #childLinks} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChildLinkIDs( Set<SoftLinkID> pChildLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChildLinks != null) {
        childLinkIDs = new HashSet<SoftLinkID>(pChildLinks);
      }
      else {
        childLinkIDs = null;
      }
      return this.self();
    }

    /**
     * Method sets association {@link #longLinks}.<br/>
     *
     * @param pLongLinks Collection to which {@link #longLinks} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLongLinkIDs( List<Long> pLongLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLongLinks != null) {
        longLinkIDs = new ArrayList<Long>(pLongLinks);
      }
      else {
        longLinkIDs = null;
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class SoftLinkPartner. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkPartner Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class SoftLinkPartner. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SoftLinkPartner Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkPartner buildValidated( ) throws ConstraintViolationException {
      SoftLinkPartner lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class SoftLinkPartnerBuilderImpl
      extends SoftLinkPartnerBuilder<SoftLinkPartner, SoftLinkPartnerBuilderImpl> {
    protected SoftLinkPartnerBuilderImpl( ) {
    }

    protected SoftLinkPartnerBuilderImpl( SoftLinkPartner pObject ) {
      super(pObject);
    }

    @Override
    protected SoftLinkPartnerBuilderImpl self( ) {
      return this;
    }

    @Override
    public SoftLinkPartner build( ) {
      return new SoftLinkPartner(this);
    }
  }

  /**
   * Method returns association {@link #theBackLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
   *
   * @return {@link String} Value to which {@link #theBackLink} is set.
   */
  public String getTheBackLinkID( ) {
    return theBackLinkID;
  }

  /**
   * Method sets association {@link #theBackLink}.<br/>
   *
   * @param pTheBackLink Value to which {@link #theBackLink} should be set.
   */
  public void setTheBackLinkID( String pTheBackLink ) {
    theBackLinkID = pTheBackLink;
  }

  /**
   * Method unsets {@link #theBackLink}.
   */
  public final void unsetTheBackLinkID( ) {
    theBackLinkID = null;
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
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableSet(childLinkIDs);
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
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableList(longLinkIDs);
  }

  /**
   * Method adds the passed object to {@link #longLinks}.
   *
   * @param pLongLinks Object that should be added to {@link #longLinks}. The parameter must not be null.
   */
  public void addToLongLinkIDs( Long pLongLinks ) {
    // Check parameter "pLongLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Add passed object to collection of associated SoftLinkChildA objects.
    longLinkIDs.add(pLongLinks);
  }

  /**
   * Method adds all passed objects to {@link #longLinks}.
   *
   * @param pLongLinks Collection with all objects that should be added to {@link #longLinks}. The parameter must not be
   * null.
   */
  public void addToLongLinkIDs( Collection<Long> pLongLinks ) {
    // Check parameter "pLongLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Add all passed objects.
    for (Long lNextObject : pLongLinks) {
      this.addToLongLinkIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #longLinks}.
   *
   * @param pLongLinks Object that should be removed from {@link #longLinks}. The parameter must not be null.
   */
  public void removeFromLongLinkIDs( Long pLongLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Remove passed object from collection of associated SoftLinkChildA objects.
    longLinkIDs.remove(pLongLinks);
  }

  /**
   * Method removes all objects from {@link #longLinks}.
   */
  public void clearLongLinkIDs( ) {
    // Remove all objects from association "longLinks".
    longLinkIDs.clear();
  }

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
      SoftLinkPartner lOther = (SoftLinkPartner) pObject;
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
  public SoftLinkPartnerBuilder<?, ?> toBuilder( ) {
    return new SoftLinkPartnerBuilderImpl(this);
  }
}