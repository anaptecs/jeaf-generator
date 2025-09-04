/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Valid
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

  private final List<Channel> channels;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean channelsBackReferenceInitialized;

  private final transient Set<Product> products;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42</code>
   */
  public static final Integer MAGIC = 42;

  @NotBlank
  @Size(min = 0, max = 32)
  private final String name;

  private final Locale language;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ResellerBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    channels = (pBuilder.channels == null) ? List.of() : List.copyOf(pBuilder.channels);
    // As association is bidirectional we also have to set it in the other direction.
    for (Channel lNext : channels) {
      lNext.setReseller((Reseller) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    channelsBackReferenceInitialized = true;
    products = new HashSet<>();
    name = pBuilder.name;
    language = pBuilder.language;
  }

  /**
   * Class implements builder to create a new instance of class Reseller. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private List<Channel> channels;

    @NotBlank
    @Size(min = 0, max = 32)
    private String name;

    private Locale language;

    /**
     * Use {@link Reseller.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Reseller.builder(Reseller)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ResellerBase pObject ) {
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
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setChannels( List<Channel> pChannels ) {
      channels = pChannels;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #channels}.<br/>
     *
     * @param pChannels Array of objects that should be added to {@link #channels}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToChannels( Channel... pChannels ) {
      if (pChannels != null) {
        if (channels == null) {
          channels = new ArrayList<Channel>();
        }
        channels.addAll(Arrays.asList(pChannels));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method creates a new instance of class Reseller. The object will be initialized with the values of the builder.
     *
     * @return Reseller Created object. The method never returns null.
     */
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
  public List<Channel> getChannels( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (channelsBackReferenceInitialized == false) {
      channelsBackReferenceInitialized = true;
      for (Channel lNext : channels) {
        lNext.setReseller((Reseller) this);
      }
    }
    return channels;
  }

  /**
   * Method returns association {@link #products}.<br/>
   *
   * @return {@link Set<Product>} Value to which {@link #products} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
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
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  public Locale getLanguage( ) {
    return language;
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
    var lBuilder = Reseller.builder();
    lBuilder.setChannels(pChannels);
    lBuilder.setName(pName);
    lBuilder.setLanguage(pLanguage);
    return lBuilder.build();
  }

  /**
   * @return {@link Integer}
   */
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
  public Reseller.Builder toBuilder( ) {
    return new Reseller.Builder((Reseller) this);
  }
}