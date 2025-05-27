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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = ResellerBase.ResellerBuilderImpl.class)
public abstract class ResellerBase {
  /**
   * Constant for the name of attribute "channels".
   */
  public static final String CHANNELS = "channels";

  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "language".
   */
  public static final String LANGUAGE = "language";

  private List<Channel> channels;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean channelsBackReferenceInitialized;

  private transient Set<Product> products;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42</code>
   */
  public static final Integer MAGIC = 42;

  @NotBlank
  @Size(min = 0, max = 32)
  private String name;

  private Locale language;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ResellerBase( ResellerBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.channels != null) {
      channels = pBuilder.channels;
      // As association is bidirectional we also have to set it in the other direction.
      for (Channel lNext : channels) {
        lNext.setReseller((Reseller) this);
      }
    }
    else {
      channels = new ArrayList<>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    channelsBackReferenceInitialized = true;
    products = new HashSet<>();
    name = pBuilder.name;
    language = pBuilder.language;
  }

  /**
   * Class implements builder to create a new instance of class <code>Reseller</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ResellerBuilder<T extends Reseller, B extends ResellerBuilder<T, B>> {
    private List<Channel> channels;

    @NotBlank
    @Size(min = 0, max = 32)
    private String name;

    private Locale language;

    /**
     * Use {@link ResellerBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ResellerBuilder( ) {
    }

    /**
     * Use {@link ResellerBuilder#builder(Reseller)} instead of private constructor to create new builder.
     */
    protected ResellerBuilder( ResellerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChannels(pObject.channels);
        this.setName(pObject.name);
        this.setLanguage(pObject.language);
      }
    }

    /**
     * Method sets association {@link #channels}.<br/>
     *
     * @param pChannels Collection to which {@link #channels} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChannels( @MyNotEmptyProperty List<Channel> pChannels ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChannels != null) {
        channels = new ArrayList<Channel>(pChannels);
      }
      else {
        channels = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #channels}.<br/>
     *
     * @param pChannels Array of objects that should be added to {@link #channels}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToChannels( @MyNotEmptyProperty Channel... pChannels ) {
      if (pChannels != null) {
        if (channels == null) {
          channels = new ArrayList<Channel>();
        }
        channels.addAll(Arrays.asList(pChannels));
      }
      return this.self();
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
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLanguage( @MyNotNullProperty Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Reseller. The object will be initialized with the values of the builder.
     *
     * @return Reseller Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ResellerBuilderImpl extends ResellerBuilder<Reseller, ResellerBuilderImpl> {
    protected ResellerBuilderImpl( ) {
    }

    protected ResellerBuilderImpl( Reseller pObject ) {
      super(pObject);
    }

    @Override
    protected ResellerBuilderImpl self( ) {
      return this;
    }

    @Override
    public Reseller build( ) {
      Reseller lObject = new Reseller(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #channels}.<br/>
   *
   * @return {@link List<Channel>} Value to which {@link #channels} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @MyNotEmptyProperty
  public List<Channel> getChannels( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (channelsBackReferenceInitialized == false) {
      channelsBackReferenceInitialized = true;
      for (Channel lNext : channels) {
        lNext.setReseller((Reseller) this);
      }
    }
    // Return all Channel objects as unmodifiable collection.
    return Collections.unmodifiableList(channels);
  }

  /**
   * Method adds the passed object to {@link #channels}.
   *
   * @param pChannels Object that should be added to {@link #channels}. The parameter must not be null.
   */
  public void addToChannels( Channel pChannels ) {
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pChannels.unsetReseller();
    // Add passed object to collection of associated Channel objects.
    channels.add(pChannels);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pChannels != null && this.equals(pChannels.getReseller()) == false) {
      pChannels.setReseller((Reseller) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #channels}.
   *
   * @param pChannels Collection with all objects that should be added to {@link #channels}. The parameter must not be
   * null.
   */
  public void addToChannels( Collection<Channel> pChannels ) {
    // Add all passed objects.
    for (Channel lNextObject : pChannels) {
      this.addToChannels(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #channels}.<br/>
   *
   * @param pChannels Object that should be removed from {@link #channels}. The parameter must not be null.
   */
  public void removeFromChannels( Channel pChannels ) {
    // Remove passed object from collection of associated Channel objects.
    channels.remove(pChannels);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pChannels.getReseller()) == true) {
      pChannels.unsetReseller();
    }
  }

  /**
   * Method removes all objects from {@link #channels}.
   */
  public void clearChannels( ) {
    // Remove all objects from association "channels".
    Collection<Channel> lChannels = new HashSet<Channel>(channels);
    Iterator<Channel> lIterator = lChannels.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromChannels(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #products}.<br/>
   *
   * @return {@link Set<Product>} Value to which {@link #products} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @MyNotEmptyProperty
  public Set<Product> getProducts( ) {
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method adds the passed object to {@link #products}.
   *
   * @param pProducts Object that should be added to {@link #products}. The parameter must not be null.
   */
  void addToProducts( Product pProducts ) {
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
  }

  /**
   * Method adds all passed objects to {@link #products}.
   *
   * @param pProducts Collection with all objects that should be added to {@link #products}. The parameter must not be
   * null.
   */
  void addToProducts( Collection<Product> pProducts ) {
    // Add all passed objects.
    for (Product lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #products}.<br/>
   *
   * @param pProducts Object that should be removed from {@link #products}. The parameter must not be null.
   */
  void removeFromProducts( Product pProducts ) {
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
  }

  /**
   * Method removes all objects from {@link #products}.
   */
  void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromProducts(lIterator.next());
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
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @MyNotNullProperty
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  public void setLanguage( @MyNotNullProperty Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Convenience method to create new instance of class Reseller.
   *
   *
   * @param pChannels Value to which {@link #channels} should be set.
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pLanguage Value to which {@link #language} should be set.
   *
   * @return {@link Reseller}
   */
  public static Reseller of( List<Channel> pChannels, String pName, Locale pLanguage ) {
    ResellerBuilder<?, ?> lBuilder = Reseller.builder();
    lBuilder.setChannels(pChannels);
    lBuilder.setName(pName);
    lBuilder.setLanguage(pLanguage);
    return lBuilder.build();
  }

  /**
   * @return {@link Integer}
   */
  @MyNotNullProperty
  public abstract Integer doSomething( );

  /**
   * @return double
   */
  public abstract double returnPrimitive( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(channels);
    lResult = lPrime * lResult + Objects.hashCode(name);
    lResult = lPrime * lResult + Objects.hashCode(language);
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
      ResellerBase lOther = (ResellerBase) pObject;
      lEquals = Objects.equals(channels, lOther.channels) && Objects.equals(name, lOther.name)
          && Objects.equals(language, lOther.language);
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
    lBuilder.append("channels: ");
    if (channels != null) {
      lBuilder.append(channels.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (channels != null) {
      for (Channel lNext : channels) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("language: ");
    lBuilder.append(language);
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
   * @return {@link Builder} New builder that can be used to create new Reseller objects. The method never returns null.
   */
  public ResellerBuilder<?, ?> toBuilder( ) {
    return new ResellerBuilderImpl((Reseller) this);
  }
}