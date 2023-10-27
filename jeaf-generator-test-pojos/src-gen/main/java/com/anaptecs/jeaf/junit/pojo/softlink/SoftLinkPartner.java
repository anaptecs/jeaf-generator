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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
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
  private String theBackLink;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #childLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   */
  @JsonSetter(nulls = Nulls.SKIP)
  private final Set<SoftLinkID> childLinks;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #longLinks} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   */
  @JsonSetter(nulls = Nulls.SKIP)
  private List<Long> longLinks;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLinkPartner( ) {
    childLinks = new HashSet<SoftLinkID>();
    longLinks = new ArrayList<Long>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkPartner( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    theBackLink = pBuilder.theBackLink;
    if (pBuilder.childLinks != null) {
      childLinks = pBuilder.childLinks;
    }
    else {
      childLinks = new HashSet<SoftLinkID>();
    }
    if (pBuilder.longLinks != null) {
      longLinks = pBuilder.longLinks;
    }
    else {
      longLinks = new ArrayList<Long>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects. The method never
   * returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( SoftLinkPartner pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class SoftLinkPartner.
   *
   *
   * @param pLongLinks Value to which {@link #longLinks} should be set.
   *
   * @return {@link SoftLinkPartner}
   */
  public static SoftLinkPartner of( List<Long> pLongLinks ) {
    SoftLinkPartner.Builder lBuilder = SoftLinkPartner.builder();
    lBuilder.setLongLinks(pLongLinks);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkPartner</code>.
   */
  public static class Builder {
    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theBackLink} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
     */
    private String theBackLink;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #childLinks} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private Set<SoftLinkID> childLinks;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #longLinks} is
     * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
     */
    private List<Long> longLinks;

    /**
     * Use {@link SoftLinkPartner#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SoftLinkPartner#builder(SoftLinkPartner)} instead of private constructor to create new builder.
     */
    protected Builder( SoftLinkPartner pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTheBackLink(pObject.theBackLink);
        this.setChildLinks(pObject.childLinks);
        this.setLongLinks(pObject.longLinks);
      }
    }

    /**
     * Method sets association {@link #theBackLink}.<br/>
     *
     * @param pTheBackLink Value to which {@link #theBackLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTheBackLink( String pTheBackLink ) {
      theBackLink = pTheBackLink;
      return this;
    }

    /**
     * Method sets association {@link #childLinks}.<br/>
     *
     * @param pChildLinks Collection to which {@link #childLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildLinks( Set<SoftLinkID> pChildLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChildLinks != null) {
        childLinks = new HashSet<SoftLinkID>(pChildLinks);
      }
      else {
        childLinks = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #longLinks}.<br/>
     *
     * @param pLongLinks Collection to which {@link #longLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLongLinks( List<Long> pLongLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLongLinks != null) {
        longLinks = new ArrayList<Long>(pLongLinks);
      }
      else {
        longLinks = null;
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
      SoftLinkPartner lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
  public String getTheBackLink( ) {
    return theBackLink;
  }

  /**
   * Method sets association {@link #theBackLink}.<br/>
   *
   * @param pTheBackLink Value to which {@link #theBackLink} should be set.
   */
  public void setTheBackLink( String pTheBackLink ) {
    theBackLink = pTheBackLink;
  }

  /**
   * Method unsets {@link #theBackLink}.
   */
  public final void unsetTheBackLink( ) {
    theBackLink = null;
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
  public Set<SoftLinkID> getChildLinks( ) {
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableSet(childLinks);
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
  public List<Long> getLongLinks( ) {
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableList(longLinks);
  }

  /**
   * Method adds the passed object to {@link #longLinks}.
   *
   * @param pLongLinks Object that should be added to {@link #longLinks}. The parameter must not be null.
   */
  public void addToLongLinks( Long pLongLinks ) {
    // Check parameter "pLongLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Add passed object to collection of associated SoftLinkChildA objects.
    longLinks.add(pLongLinks);
  }

  /**
   * Method adds all passed objects to {@link #longLinks}.
   *
   * @param pLongLinks Collection with all objects that should be added to {@link #longLinks}. The parameter must not be
   * null.
   */
  public void addToLongLinks( Collection<Long> pLongLinks ) {
    // Check parameter "pLongLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Add all passed objects.
    for (Long lNextObject : pLongLinks) {
      this.addToLongLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #longLinks}.
   *
   * @param pLongLinks Object that should be removed from {@link #longLinks}. The parameter must not be null.
   */
  public void removeFromLongLinks( Long pLongLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Remove passed object from collection of associated SoftLinkChildA objects.
    longLinks.remove(pLongLinks);
  }

  /**
   * Method removes all objects from {@link #longLinks}.
   */
  public void clearLongLinks( ) {
    // Remove all objects from association "longLinks".
    longLinks.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(theBackLink);
    lResult = lPrime * lResult + Objects.hashCode(childLinks);
    lResult = lPrime * lResult + Objects.hashCode(longLinks);
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
      lEquals = Objects.equals(theBackLink, lOther.theBackLink) && Objects.equals(childLinks, lOther.childLinks)
          && Objects.equals(longLinks, lOther.longLinks);
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
