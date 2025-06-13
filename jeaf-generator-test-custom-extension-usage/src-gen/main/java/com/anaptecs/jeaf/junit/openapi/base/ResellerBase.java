/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@Valid
@JEAFCustomAnnotationTest
public abstract class ResellerBase extends Object implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "channels".
   */
  @JEAFCustomAnnotationTest
  public static final String CHANNELS = "channels";

  /**
   * Constant for the name of attribute "products".
   */
  @JEAFCustomAnnotationTest
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "language".
   */
  @JEAFCustomAnnotationTest
  public static final String LANGUAGE = "language";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  // "com.anaptecs.jeaf.junit.openapi.base.Channel"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private List<Channel> channels;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean channelsBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.base.Channel"
  private int channelsXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.Product"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private transient Set<Product> products;

  // "com.anaptecs.jeaf.junit.openapi.base.Product"
  private int productsXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with 1.1:</b> Maximum size will be increased.
   */
  @JEAFCustomAnnotationTest
  @NotBlank
  @Size(min = 0, max = 32)
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "java.util.Locale"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Locale language;

  // "java.util.Locale"
  private int languageXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ResellerBase( ) {
    objectID = null;
    channels = new ArrayList<>();
    // Bidirectional back reference is not yet set up correctly
    channelsBackReferenceInitialized = false;
    products = new HashSet<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ResellerBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
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
    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    channelsXYZ = pBuilder.channelsXYZ;
    products = new HashSet<>();
    name = pBuilder.name;
    // "java.lang.String"
    nameXYZ = pBuilder.nameXYZ;
    language = pBuilder.language;
    // "java.util.Locale"
    languageXYZ = pBuilder.languageXYZ;
  }

  /**
   * Class implements builder to create a new instance of class Reseller. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private List<Channel> channels;

    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    private int channelsXYZ = 0;

    /**
     * <p/>
     * <b>Breaking Change with 1.1:</b> Maximum size will be increased.
     */
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @NotBlank
    @Size(min = 0, max = 32)
    private String name;

    // "java.lang.String"
    private int nameXYZ = 0;

    // "java.util.Locale"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Locale language;

    // "java.util.Locale"
    private int languageXYZ = 0;

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
        objectID = pObject.objectID;
        this.setChannels(pObject.channels);
        this.setName(pObject.name);
        this.setLanguage(pObject.language);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets association {@link #channels}.<br/>
     *
     * @param pChannels Collection to which {@link #channels} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setChannels( List<Channel> pChannels ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChannels != null) {
        channels = new ArrayList<Channel>(pChannels);
      }
      else {
        channels = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #channels}.<br/>
     *
     * @param pChannels Array of objects that should be added to {@link #channels}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase addToChannels( Channel... pChannels ) {
      if (pChannels != null) {
        if (channels == null) {
          channels = new ArrayList<Channel>();
        }
        channels.addAll(Arrays.asList(pChannels));
      }
      return this;
    }

    public BuilderBase setChannelsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Channel"
      channelsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     * <p/>
     * <b>Breaking Change with 1.1:</b> Maximum size will be increased.
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public BuilderBase setNameXYZ( int value ) {
      // "java.lang.String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public BuilderBase setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    public BuilderBase setLanguageXYZ( int value ) {
      // "java.util.Locale"
      languageXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Reseller. The object will be initialized with the values of the builder.
     *
     * @return Reseller Created object. The method never returns null.
     */
    public Reseller build( ) {
      return new Reseller(this);
    }

    /**
     * Method creates a new validated instance of class Reseller. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Reseller Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Reseller buildValidated( ) throws ConstraintViolationException {
      Reseller lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns association {@link #channels}.<br/>
   *
   * @return {@link List<Channel>} Value to which {@link #channels} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
  public void addToChannels( Channel pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
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
  @JEAFCustomAnnotationTest
  public void addToChannels( Collection<Channel> pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
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
  @JEAFCustomAnnotationTest
  public void removeFromChannels( Channel pChannels ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
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
  @JEAFCustomAnnotationTest
  public void clearChannels( ) {
    // Remove all objects from association "channels".
    Collection<Channel> lChannels = new HashSet<Channel>(channels);
    Iterator<Channel> lIterator = lChannels.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromChannels(lIterator.next());
    }
  }

  public int getChannelsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    return channelsXYZ;
  }

  public void setChannelsXYZ( int value ) {
    channelsXYZ = value;
  }

  /**
   * Method returns association {@link #products}.<br/>
   *
   * @return {@link Set<Product>} Value to which {@link #products} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public Set<Product> getProducts( ) {
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method adds the passed object to {@link #products}.
   *
   * @param pProducts Object that should be added to {@link #products}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  void addToProducts( Product pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
  }

  /**
   * Method adds all passed objects to {@link #products}.
   *
   * @param pProducts Collection with all objects that should be added to {@link #products}. The parameter must not be
   * null.
   */
  @JEAFCustomAnnotationTest
  void addToProducts( Collection<Product> pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
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
  @JEAFCustomAnnotationTest
  void removeFromProducts( Product pProducts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
  }

  /**
   * Method removes all objects from {@link #products}.
   */
  @JEAFCustomAnnotationTest
  void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromProducts(lIterator.next());
    }
  }

  public int getProductsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Product"
    return productsXYZ;
  }

  public void setProductsXYZ( int value ) {
    productsXYZ = value;
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   * <p/>
   * <b>Breaking Change with 1.1:</b> Maximum size will be increased.
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @JEAFCustomAnnotationTest
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   * <p/>
   * <b>Breaking Change with 1.1:</b> Maximum size will be increased.
   *
   * @param pName Value to which {@link #name} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  public int getNameXYZ( ) {
    // "java.lang.String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @JEAFCustomAnnotationTest
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  public int getLanguageXYZ( ) {
    // "java.util.Locale"
    return languageXYZ;
  }

  public void setLanguageXYZ( int value ) {
    languageXYZ = value;
  }

  /**
   * @return {@link Integer}
   */
  @JEAFCustomAnnotationTest
  public abstract Integer doSomething( );

  /**
   * @return double
   */
  @JEAFCustomAnnotationTest
  public abstract double returnPrimitive( );

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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