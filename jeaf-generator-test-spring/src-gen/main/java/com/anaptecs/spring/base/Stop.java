/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = POI.class, name = "POI"),
  @JsonSubTypes.Type(value = UICStop.class, name = "UICStop") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Stop.StopBuilderImpl.class)
public class Stop {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "links".
   */
  public static final String LINKS = "links";

  @JsonAlias({ "bavName", "stopName" })
  private String name;

  @JsonProperty("_links")
  private List<LinkObject> links;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Stop( StopBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    name = pBuilder.name;
    if (pBuilder.links != null) {
      links = pBuilder.links;
    }
    else {
      links = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Stop objects.
   */
  public static StopBuilder<?, ?> builder( ) {
    return new StopBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Stop.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link Stop}
   */
  public static Stop of( String pName ) {
    StopBuilder<?, ?> lBuilder = Stop.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Stop</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class StopBuilder<T extends Stop, B extends StopBuilder<T, B>> {
    private String name;

    private List<LinkObject> links;

    /**
     * Use {@link StopBuilder#builder()} instead of private constructor to create new builder.
     */
    protected StopBuilder( ) {
    }

    /**
     * Use {@link StopBuilder#builder(Stop)} instead of private constructor to create new builder.
     */
    protected StopBuilder( Stop pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setLinks(pObject.links);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setName( @MyNotNullProperty String pName ) {
      // Assign value to attribute
      name = pName;
      return this.self();
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLinks( List<LinkObject> pLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLinks != null) {
        links = new ArrayList<LinkObject>(pLinks);
      }
      else {
        links = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #links}.<br/>
     *
     * @param pLinks Array of objects that should be added to {@link #links}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToLinks( LinkObject... pLinks ) {
      if (pLinks != null) {
        if (links == null) {
          links = new ArrayList<LinkObject>();
        }
        links.addAll(Arrays.asList(pLinks));
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Stop. The object will be initialized with the values of the builder.
     *
     * @return Stop Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class StopBuilderImpl extends StopBuilder<Stop, StopBuilderImpl> {
    protected StopBuilderImpl( ) {
    }

    protected StopBuilderImpl( Stop pObject ) {
      super(pObject);
    }

    @Override
    protected StopBuilderImpl self( ) {
      return this;
    }

    @Override
    public Stop build( ) {
      Stop lObject = new Stop(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @MyNotNullProperty
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( @MyNotNullProperty String pName ) {
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
    // Add passed object to collection of associated LinkObject objects.
    links.add(pLinks);
  }

  /**
   * Method adds all passed objects to {@link #links}.
   *
   * @param pLinks Collection with all objects that should be added to {@link #links}. The parameter must not be null.
   */
  public void addToLinks( Collection<LinkObject> pLinks ) {
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(name);
    lResult = lPrime * lResult + Objects.hashCode(links);
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
      Stop lOther = (Stop) pObject;
      lEquals = Objects.equals(name, lOther.name) && Objects.equals(links, lOther.links);
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("links: ");
    if (links != null) {
      lBuilder.append(links.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (links != null) {
      for (LinkObject lNext : links) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
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
   * @return {@link Builder} New builder that can be used to create new Stop objects. The method never returns null.
   */
  public StopBuilder<?, ?> toBuilder( ) {
    return new StopBuilderImpl(this);
  }
}