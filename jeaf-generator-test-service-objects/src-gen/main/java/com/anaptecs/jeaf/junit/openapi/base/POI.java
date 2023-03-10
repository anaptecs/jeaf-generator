/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class POI extends Stop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "theLink".
   */
  @Deprecated
  public static final String THELINK = "theLink";

  /**
   * Constant for the name of attribute "evenMoreLinks".
   */
  @Deprecated
  public static final String EVENMORELINKS = "evenMoreLinks";

  private String description;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  private Long theLink;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   */
  @Deprecated
  private Set<SoftLink> evenMoreLinks;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POI( ) {
    evenMoreLinks = new HashSet<SoftLink>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POI( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    description = pBuilder.description;
    theLink = pBuilder.theLink;
    if (pBuilder.evenMoreLinks != null) {
      evenMoreLinks = pBuilder.evenMoreLinks;
    }
    else {
      evenMoreLinks = new HashSet<SoftLink>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new POI objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new POI objects. The method never returns null.
   */
  public static Builder builder( POI pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class POI. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Stop.Builder {
    private String description;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
     * <code>LinkObject</code><br/>
     */
    @Deprecated
    private Long theLink;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
     * <code>LinkObject</code><br/>
     */
    @Deprecated
    private Set<SoftLink> evenMoreLinks;

    /**
     * Use {@link POI#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link POI#builder(POI)} instead of private constructor to create new builder.
     */
    protected Builder( POI pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        description = pObject.description;
        theLink = pObject.theLink;
        evenMoreLinks = pObject.evenMoreLinks;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets the association "links".
     * 
     * @param pLinks Collection with objects to which the association should be set.
     */
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method sets the attribute "index".
     * 
     * @param pIndex Value to which the attribute "index" should be set.
     */
    @Override
    public Builder setIndex( byte pIndex ) {
      // Call super class implementation.
      super.setIndex(pIndex);
      return this;
    }

    /**
     * Method sets the association "theSoftLink".
     * 
     * @param pTheSoftLink LinkObject to which the association "theSoftLink" should be set.
     */
    @Override
    public Builder setTheSoftLink( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLink(pTheSoftLink);
      return this;
    }

    /**
     * Method sets the attribute "description".
     * 
     * @param pDescription Value to which the attribute "description" should be set.
     */
    public Builder setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    /**
     * Method sets the association "theLink".
     * 
     * @param pTheLink LinkObject to which the association "theLink" should be set.
     */
    public Builder setTheLink( Long pTheLink ) {
      theLink = pTheLink;
      return this;
    }

    /**
     * Method sets the association "evenMoreLinks".
     * 
     * @param pEvenMoreLinks Collection with objects to which the association should be set.
     */
    @Deprecated
    public Builder setEvenMoreLinks( Set<SoftLink> pEvenMoreLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pEvenMoreLinks != null) {
        evenMoreLinks = new HashSet<SoftLink>(pEvenMoreLinks);
      }
      else {
        evenMoreLinks = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class POI. The object will be initialized with the values of the builder.
     * 
     * @return POI Created object. The method never returns null.
     */
    public POI build( ) {
      return new POI(this);
    }

    /**
     * Method creates a new validated instance of class POI. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return POI Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public POI buildValidated( ) throws ConstraintViolationException {
      POI lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #description}.<br/>
   * 
   * @return {@link String} Value to which {@link #description} is set.
   */
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   * 
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  /**
   * Method returns association {@link #theLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theLink} is
   * <code>LinkObject</code><br/>
   * 
   * @return {@link Long} Value to which {@link #theLink} is set.
   */
  @Deprecated
  public Long getTheLink( ) {
    return theLink;
  }

  /**
   * Method sets association {@link #theLink}.<br/>
   * 
   * @param pTheLink Value to which {@link #theLink} should be set.
   */
  @Deprecated
  public void setTheLink( Long pTheLink ) {
    theLink = pTheLink;
  }

  /**
   * Method unsets {@link #theLink}.
   */
  @Deprecated
  public final void unsetTheLink( ) {
    theLink = null;
  }

  /**
   * Method returns association {@link #evenMoreLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #evenMoreLinks} is
   * <code>LinkObject</code><br/>
   * 
   * @return {@link Set<SoftLink>} Value to which {@link #evenMoreLinks} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<SoftLink> getEvenMoreLinks( ) {
    // Return all LinkObject objects as unmodifiable collection.
    return Collections.unmodifiableSet(evenMoreLinks);
  }

  /**
   * Method adds the passed object to {@link #evenMoreLinks}.
   * 
   * @param pEvenMoreLinks Object that should be added to {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinks( SoftLink pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add passed object to collection of associated LinkObject objects.
    evenMoreLinks.add(pEvenMoreLinks);
  }

  /**
   * Method adds all passed objects to {@link #evenMoreLinks}.
   * 
   * @param pEvenMoreLinks Collection with all objects that should be added to {@link #evenMoreLinks}. The parameter
   * must not be null.
   */
  @Deprecated
  public void addToEvenMoreLinks( Collection<SoftLink> pEvenMoreLinks ) {
    // Check parameter "pEvenMoreLinks" for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Add all passed objects.
    for (SoftLink lNextObject : pEvenMoreLinks) {
      this.addToEvenMoreLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #evenMoreLinks}.
   * 
   * @param pEvenMoreLinks Object that should be removed from {@link #evenMoreLinks}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromEvenMoreLinks( SoftLink pEvenMoreLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pEvenMoreLinks, "pEvenMoreLinks");
    // Remove passed object from collection of associated LinkObject objects.
    evenMoreLinks.remove(pEvenMoreLinks);
  }

  /**
   * Method removes all objects from {@link #evenMoreLinks}.
   */
  @Deprecated
  public void clearEvenMoreLinks( ) {
    // Remove all objects from association "evenMoreLinks".
    evenMoreLinks.clear();
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
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
