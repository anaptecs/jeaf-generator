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

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Company.class, name = "Company"),
  @JsonSubTypes.Type(value = Person.class, name = "Person") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Partner.PartnerBuilderImpl.class)
public class Partner {
  /**
   * Constant for the name of attribute "postalAddresses".
   */
  public static final String POSTALADDRESSES = "postalAddresses";

  private List<PostalAddress> postalAddresses;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Partner( PartnerBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.postalAddresses != null) {
      postalAddresses = pBuilder.postalAddresses;
    }
    else {
      postalAddresses = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link PartnerBuilder} New builder that can be used to create new Partner objects.
   */
  public static PartnerBuilder<?, ?> builder( ) {
    return new PartnerBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Partner.
   *
   *
   * @return {@link Partner}
   */
  public static Partner of( ) {
    var lBuilder = Partner.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Partner</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class PartnerBuilder<T extends Partner, B extends PartnerBuilder<T, B>> {
    private List<PostalAddress> postalAddresses;

    /**
     * Use {@link Partner#builder()} instead of private constructor to create new builder.
     */
    protected PartnerBuilder( ) {
    }

    /**
     * Use {@link Partner#builder(Partner)} instead of private constructor to create new builder.
     */
    protected PartnerBuilder( Partner pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setPostalAddresses(pObject.postalAddresses);
      }
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPostalAddresses != null) {
        postalAddresses = new ArrayList<PostalAddress>(pPostalAddresses);
      }
      else {
        postalAddresses = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Array of objects that should be added to {@link #postalAddresses}. The parameter may be
     * null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToPostalAddresses( PostalAddress... pPostalAddresses ) {
      if (pPostalAddresses != null) {
        if (postalAddresses == null) {
          postalAddresses = new ArrayList<PostalAddress>();
        }
        postalAddresses.addAll(Arrays.asList(pPostalAddresses));
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Partner. The object will be initialized with the values of the builder.
     *
     * @return Partner Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class PartnerBuilderImpl extends PartnerBuilder<Partner, PartnerBuilderImpl> {
    protected PartnerBuilderImpl( ) {
    }

    protected PartnerBuilderImpl( Partner pObject ) {
      super(pObject);
    }

    @Override
    protected PartnerBuilderImpl self( ) {
      return this;
    }

    @Override
    public Partner build( ) {
      Partner lObject = new Partner(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #postalAddresses}.<br/>
   *
   * @return {@link List<PostalAddress>} Value to which {@link #postalAddresses} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<PostalAddress> getPostalAddresses( ) {
    // Return all PostalAddress objects as unmodifiable collection.
    return Collections.unmodifiableList(postalAddresses);
  }

  /**
   * Method adds the passed object to {@link #postalAddresses}.
   *
   * @param pPostalAddresses Object that should be added to {@link #postalAddresses}. The parameter must not be null.
   */
  public void addToPostalAddresses( PostalAddress pPostalAddresses ) {
    // Add passed object to collection of associated PostalAddress objects.
    postalAddresses.add(pPostalAddresses);
  }

  /**
   * Method adds all passed objects to {@link #postalAddresses}.
   *
   * @param pPostalAddresses Collection with all objects that should be added to {@link #postalAddresses}. The parameter
   * must not be null.
   */
  public void addToPostalAddresses( Collection<PostalAddress> pPostalAddresses ) {
    // Add all passed objects.
    for (PostalAddress lNextObject : pPostalAddresses) {
      this.addToPostalAddresses(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #postalAddresses}.<br/>
   *
   * @param pPostalAddresses Object that should be removed from {@link #postalAddresses}. The parameter must not be
   * null.
   */
  public void removeFromPostalAddresses( PostalAddress pPostalAddresses ) {
    // Remove passed object from collection of associated PostalAddress objects.
    postalAddresses.remove(pPostalAddresses);
  }

  /**
   * Method removes all objects from {@link #postalAddresses}.
   */
  public void clearPostalAddresses( ) {
    // Remove all objects from association "postalAddresses".
    postalAddresses.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(postalAddresses);
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
      Partner lOther = (Partner) pObject;
      lEquals = Objects.equals(postalAddresses, lOther.postalAddresses);
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
    lBuilder.append("postalAddresses: ");
    if (postalAddresses != null) {
      lBuilder.append(postalAddresses.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (postalAddresses != null) {
      for (PostalAddress lNext : postalAddresses) {
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
   * @return {@link PartnerBuilder} New builder that can be used to create new Partner objects. The method never returns
   * null.
   */
  public PartnerBuilder<?, ?> toBuilder( ) {
    return new PartnerBuilderImpl(this);
  }
}