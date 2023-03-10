/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = POI.class, name = "POI"),
  @JsonSubTypes.Type(value = UICStop.class, name = "UICStop") })
public class Stop implements Serializable {
  /**
   * Default serial version UID.
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

  private String name;

  @JsonProperty("_links")
  private List<LinkObject> links;

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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Stop objects. The method never returns null.
   */
  public static Builder builder( Stop pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class Stop. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private List<LinkObject> links;

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
        name = pObject.name;
        links = pObject.links;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the association "links".
     * 
     * @param pLinks Collection with objects to which the association should be set.
     */
    public Builder setLinks( List<LinkObject> pLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLinks != null) {
        links = new ArrayList<LinkObject>(pLinks);
      }
      else {
        links = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Stop. The object will be initialized with the values of the builder.
     * 
     * @return Stop Created object. The method never returns null.
     */
    public Stop build( ) {
      return new Stop(this);
    }

    /**
     * Method creates a new validated instance of class Stop. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Stop Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Stop buildValidated( ) throws ConstraintViolationException {
      Stop lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
   * Method adds the passed LinkObject object to the association "links".
   * 
   * 
   * @param pLinks Object that should be added to the association "links". The parameter must not be null.
   */
  public void addToLinks( LinkObject pLinks ) {
    // Check parameter "pLinks" for invalid value null.
    Check.checkInvalidParameterNull(pLinks, "pLinks");
    // Add passed object to collection of associated LinkObject objects.
    links.add(pLinks);
  }

  /**
   * Method adds all passed objects to the association "links".
   * 
   * 
   * @param pLinks Collection with all objects that should be added to the association "links". The parameter must not
   * be null.
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
   * Method removes the passed LinkObject object from the association "links".
   * 
   * 
   * @param pLinks Object that should be removed from the association "links". The parameter must not be null.
   */
  public void removeFromLinks( LinkObject pLinks ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLinks, "pLinks");
    // Remove passed object from collection of associated LinkObject objects.
    links.remove(pLinks);
  }

  /**
   * Method removes all objects from the association "links".
   * 
   */
  public void clearLinks( ) {
    // Remove all objects from association "links".
    links.clear();
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
