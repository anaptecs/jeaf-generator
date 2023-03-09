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
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

  private String theBackLink;

  private final Set<SoftLinkID> childLinks;

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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects. The method never
   * returns null.
   */
  public static Builder builder( SoftLinkPartner pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SoftLinkPartner. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String theBackLink;

    /**
     * 
     */
    private Set<SoftLinkID> childLinks;

    /**
     * 
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
        theBackLink = pObject.theBackLink;
        childLinks = pObject.childLinks;
        longLinks = pObject.longLinks;
      }
    }

    /**
     * Method sets the association "theBackLink".
     * 
     * @param pTheBackLink SoftLinkParent to which the association "theBackLink" should be set.
     */
    public Builder setTheBackLink( String pTheBackLink ) {
      theBackLink = pTheBackLink;
      return this;
    }

    /**
     * Method sets the association "childLinks".
     * 
     * @param pChildLinks Collection with objects to which the association should be set.
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
     * Method sets the association "longLinks".
     * 
     * @param pLongLinks Collection with objects to which the association should be set.
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
      SoftLinkPartner lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns association {@link #theBackLink}.<br/>
   * 
   * @return com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent Value to which {@link #theBackLink} is set.
   */
  public String getTheBackLink( ) {
    return theBackLink;
  }

  /**
   * Method sets the association "theBackLink".
   * 
   * 
   * @param pTheBackLink SoftLinkParent to which the association "theBackLink" should be set.
   */
  /**
   * Method sets association {@link #theBackLink}.<br/>
   * 
   * @param pTheBackLink Value to which {@link #theBackLink} should be set.
   */
  public void setTheBackLink( String pTheBackLink ) {
    theBackLink = pTheBackLink;
  }

  /**
   * Method unsets the association "theBackLink".
   * 
   */
  public final void unsetTheBackLink( ) {
    theBackLink = null;
  }

  /**
   * Method returns the association "childLinks".
   * 
   *
   * @return Collection All SoftLinkChildA objects that belong to the association "childLinks". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<SoftLinkID> getChildLinks( ) {
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableSet(childLinks);
  }

  /**
   * Method returns the association "longLinks".
   * 
   *
   * @return Collection All SoftLinkChildA objects that belong to the association "longLinks". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<Long> getLongLinks( ) {
    // Return all SoftLinkChildA objects as unmodifiable collection.
    return Collections.unmodifiableList(longLinks);
  }

  /**
   * Method adds the passed SoftLinkChildA object to the association "longLinks".
   * 
   * 
   * @param pLongLinks Object that should be added to the association "longLinks". The parameter must not be null.
   */
  public void addToLongLinks( Long pLongLinks ) {
    // Check parameter "pLongLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Add passed object to collection of associated SoftLinkChildA objects.
    longLinks.add(pLongLinks);
  }

  /**
   * Method adds all passed objects to the association "longLinks".
   * 
   * 
   * @param pLongLinks Collection with all objects that should be added to the association "longLinks". The parameter
   * must not be null.
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
   * Method removes the passed SoftLinkChildA object from the association "longLinks".
   * 
   * 
   * @param pLongLinks Object that should be removed from the association "longLinks". The parameter must not be null.
   */
  public void removeFromLongLinks( Long pLongLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLongLinks, "pLongLinks");
    // Remove passed object from collection of associated SoftLinkChildA objects.
    longLinks.remove(pLongLinks);
  }

  /**
   * Method removes all objects from the association "longLinks".
   * 
   */
  public void clearLongLinks( ) {
    // Remove all objects from association "longLinks".
    longLinks.clear();
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
