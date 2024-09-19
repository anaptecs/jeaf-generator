/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class Stop implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "links".
   */
  public static final String LINKS = "links";

  /**
   * Constant for the name of attribute "index".
   */
  public static final String INDEX = "index";

  /**
   * Constant for the name of attribute "theSoftLink".
   */
  public static final String THESOFTLINK = "theSoftLink";

  private String name;

  private List<LinkObject> links;

  @Max(value = 32)
  @PositiveOrZero
  private byte index;

  /**
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theSoftLink} is
   * <code>LinkObject</code><br/>
   */
  private SoftLink theSoftLinkLink;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Stop( ) {
    links = new ArrayList<LinkObject>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Stop( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    if (pBuilder.links != null) {
      links = pBuilder.links;
    }
    else {
      links = new ArrayList<LinkObject>();
    }
    index = pBuilder.index;
    theSoftLinkLink = pBuilder.theSoftLinkLink;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Stop objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Stop.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pIndex Value to which {@link #index} should be set.
   *
   * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.Stop}
   */
  public static Stop of( String pName, byte pIndex, SoftLink pTheSoftLinkLink ) {
    Stop.Builder lBuilder = Stop.builder();
    lBuilder.setName(pName);
    lBuilder.setIndex(pIndex);
    lBuilder.setTheSoftLinkLink(pTheSoftLinkLink);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Stop</code>.
   */
  public static class Builder {
    private String name;

    private List<LinkObject> links;

    @Max(value = 32)
    @PositiveOrZero
    private byte index;

    /**
     * <p/>
     * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theSoftLink} is
     * <code>LinkObject</code><br/>
     */
    private SoftLink theSoftLinkLink;

    /**
     * Use {@link Stop#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Stop#builder(Stop)} instead of private constructor to create new builder.
     */
    protected Builder( Stop pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setLinks(pObject.links);
        this.setIndex(pObject.index);
        this.setTheSoftLinkLink(pObject.theSoftLinkLink);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLinks( List<LinkObject> pLinks ) {
      links = pLinks;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #links}.<br/>
     *
     * @param pLinks Array of objects that should be added to {@link #links}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLinks( LinkObject... pLinks ) {
      if (pLinks != null) {
        if (links == null) {
          links = new ArrayList<LinkObject>();
        }
        links.addAll(Arrays.asList(pLinks));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #index}.<br/>
     *
     * @param pIndex Value to which {@link #index} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIndex( byte pIndex ) {
      // Assign value to attribute
      index = pIndex;
      return this;
    }

    /**
     * Method sets association {@link #theSoftLink}.<br/>
     *
     * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTheSoftLinkLink( SoftLink pTheSoftLink ) {
      theSoftLinkLink = pTheSoftLink;
      return this;
    }

    /**
     * Method creates a new instance of class Stop. The object will be initialized with the values of the builder.
     *
     * @return Stop Created object. The method never returns null.
     */
    public Stop build( ) {
      Stop lObject = new Stop(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class Stop. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Stop Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Stop buildValidated( ) throws ConstraintViolationException {
      Stop lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns association {@link #links}.<br/>
   *
   * @return {@link List<LinkObject>} Value to which {@link #links} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<LinkObject> getLinks( ) {
    // Return all LinkObject objects as unmodifiable collection.
    return Collections.unmodifiableList(links);
  }

  /**
   * Method adds the passed object to {@link #links}.
   *
   * @param pLinks Object that should be added to {@link #links}. The parameter must not be null.
   */
  public void addToLinks( LinkObject pLinks ) {
    // Check parameter "pLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLinks, "pLinks");
    // Add passed object to collection of associated LinkObject objects.
    links.add(pLinks);
  }

  /**
   * Method adds all passed objects to {@link #links}.
   *
   * @param pLinks Collection with all objects that should be added to {@link #links}. The parameter must not be null.
   */
  public void addToLinks( Collection<LinkObject> pLinks ) {
    // Check parameter "pLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLinks, "pLinks");
    // Add all passed objects.
    for (LinkObject lNextObject : pLinks) {
      this.addToLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #links}.<br/>
   *
   * @param pLinks Object that should be removed from {@link #links}. The parameter must not be null.
   */
  public void removeFromLinks( LinkObject pLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLinks, "pLinks");
    // Remove passed object from collection of associated LinkObject objects.
    links.remove(pLinks);
  }

  /**
   * Method removes all objects from {@link #links}.
   */
  public void clearLinks( ) {
    // Remove all objects from association "links".
    links.clear();
  }

  /**
   * Method returns attribute {@link #index}.<br/>
   *
   * @return byte Value to which {@link #index} is set.
   */
  public byte getIndex( ) {
    return index;
  }

  /**
   * Method sets attribute {@link #index}.<br/>
   *
   * @param pIndex Value to which {@link #index} should be set.
   */
  public void setIndex( byte pIndex ) {
    // Assign value to attribute
    index = pIndex;
  }

  /**
   * Method returns association {@link #theSoftLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theSoftLink} is
   * <code>LinkObject</code><br/>
   *
   * @return {@link SoftLink} Value to which {@link #theSoftLink} is set.
   */
  public SoftLink getTheSoftLinkLink( ) {
    return theSoftLinkLink;
  }

  /**
   * Method sets association {@link #theSoftLink}.<br/>
   *
   * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
   */
  public void setTheSoftLinkLink( SoftLink pTheSoftLink ) {
    theSoftLinkLink = pTheSoftLink;
  }

  /**
   * Method unsets {@link #theSoftLink}.
   */
  public final void unsetTheSoftLinkLink( ) {
    theSoftLinkLink = null;
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("index: ");
    lBuilder.append(index);
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
   * @return {@link Builder} New builder that can be used to create new Stop objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}