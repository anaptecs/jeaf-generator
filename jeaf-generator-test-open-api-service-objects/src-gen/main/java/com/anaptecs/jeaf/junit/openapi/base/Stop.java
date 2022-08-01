/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
@JsonIgnoreProperties(value = "objectType")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = POI.class, name = "POI"),
  @JsonSubTypes.Type(value = UICStop.class, name = "UICStop") })
public class Stop implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private String name;

  /**
   * 
   */
  @JsonProperty("_links")
  private List<LinkObject> links = new ArrayList<LinkObject>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Stop( ) {
    // Nothing to do.
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
      links.addAll(pBuilder.links);
    }
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Stop)} instead of private constructor to create new builder.
     */
    protected Builder( Stop pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        links = pObject.links;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Stop objects. The method never returns null.
     */
    public static Builder newBuilder( Stop pObject ) {
      return new Builder(pObject);
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
   * Method returns the association "links".
   * 
   *
   * @return Collection All LinkObject objects that belong to the association "links". The method never returns null and
   * the returned collection is modifiable.
   */
  public List<LinkObject> getLinks( ) {
    // Return all LinkObject objects directly without any protection against modification.
    return links;
  }

  /**
   * Method sets the association "links" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pLinks Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setLinks( List<LinkObject> pLinks ) {
    // Check of parameter is not required.
    // Remove all objects from association "links".
    this.clearLinks();
    // If the association is null, removing all entries is sufficient.
    if (pLinks != null) {
      links = new ArrayList<LinkObject>(pLinks);
    }
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
    Collection<LinkObject> lLinks = new HashSet<LinkObject>(links);
    Iterator<LinkObject> lIterator = lLinks.iterator();
    while (lIterator.hasNext()) {
      this.removeFromLinks(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
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
