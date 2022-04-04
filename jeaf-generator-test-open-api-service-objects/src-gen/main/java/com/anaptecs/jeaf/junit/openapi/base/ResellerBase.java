/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid()
public abstract class ResellerBase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  @Size(min = 1)
  private List<Channel> channels = new ArrayList<Channel>();

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean channelsBackReferenceInitialized;

  /**
   * 
   */
  private transient Set<Product> products = new HashSet<Product>();

  /**
   * 
   */
  @NotBlank()
  @Size(min = 0, max = 32)
  private String name;

  /**
   * 
   */
  @NotNull
  private Locale language;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ResellerBase( ) {
    objectID = null;
    // Bidirectional back reference is not yet set up correctly
    channelsBackReferenceInitialized = false;
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
      channels.addAll(pBuilder.channels);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    channelsBackReferenceInitialized = true;
    if (pBuilder.products != null) {
      products.addAll(pBuilder.products);
    }
    name = pBuilder.name;
    language = pBuilder.language;
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

    /**
     * 
     */
    private List<Channel> channels;

    /**
     * 
     */
    private Set<Product> products;

    /**
     * 
     */
    @NotBlank()
    @Size(min = 0, max = 32)
    private String name;

    /**
     * 
     */
    private Locale language;

    /**
     * Use {@link Reseller.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Reseller.Builder#newBuilder(Reseller)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ResellerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        channels = pObject.channels;
        products = pObject.products;
        name = pObject.name;
        language = pObject.language;
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
     * Method sets the association "channels".
     * 
     * @param pChannels Collection with objects to which the association should be set.
     */
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
     * Method sets the association "products".
     * 
     * @param pProducts Collection with objects to which the association should be set.
     */
    public BuilderBase setProducts( Set<Product> pProducts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pProducts != null) {
        products = new HashSet<Product>(pProducts);
      }
      else {
        products = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
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
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
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
   * Method returns the association "channels".
   * 
   *
   * @return Collection All Channel objects that belong to the association "channels". The method never returns null and
   * the returned collection is unmodifiable.
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
    // Return all Channel objects as unmodifiable collection.
    return Collections.unmodifiableList(channels);
  }

  /**
   * Method sets the association "channels" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pChannels Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setChannels( List<Channel> pChannels ) {
    // Check of parameter is not required.
    // Remove all objects from association "channels".
    this.clearChannels();
    // If the association is null, removing all entries is sufficient.
    if (pChannels != null) {
      channels = new ArrayList<Channel>(pChannels);
    }
  }

  /**
   * Method adds the passed Channel object to the association "channels".
   * 
   * 
   * @param pChannels Object that should be added to the association "channels". The parameter must not be null.
   */
  public void addToChannels( Channel pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
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
   * Method adds all passed objects to the association "channels".
   * 
   * 
   * @param pChannels Collection with all objects that should be added to the association "channels". The parameter must
   * not be null.
   */
  public void addToChannels( Collection<Channel> pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
    // Add all passed objects.
    for (Channel lNextObject : pChannels) {
      this.addToChannels(lNextObject);
    }
  }

  /**
   * Method removes the passed Channel object from the association "channels".
   * 
   * 
   * @param pChannels Object that should be removed from the association "channels". The parameter must not be null.
   */
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
   * Method removes all objects from the association "channels".
   * 
   */
  public void clearChannels( ) {
    // Remove all objects from association "channels".
    Collection<Channel> lChannels = new HashSet<Channel>(channels);
    Iterator<Channel> lIterator = lChannels.iterator();
    while (lIterator.hasNext()) {
      this.removeFromChannels(lIterator.next());
    }
  }

  /**
   * Method returns the association "products".
   * 
   *
   * @return Collection All Product objects that belong to the association "products". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Product> getProducts( ) {
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method sets the association "products" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pProducts Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setProducts( Set<Product> pProducts ) {
    // Check of parameter is not required.
    // Remove all objects from association "products".
    this.clearProducts();
    // If the association is null, removing all entries is sufficient.
    if (pProducts != null) {
      products = new HashSet<Product>(pProducts);
    }
  }

  /**
   * Method adds the passed Product object to the association "products".
   * 
   * 
   * @param pProducts Object that should be added to the association "products". The parameter must not be null.
   */
  public void addToProducts( Product pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts != null && pProducts.getResellers().contains(this) == false) {
      pProducts.addToResellers((Reseller) this);
    }
  }

  /**
   * Method adds all passed objects to the association "products".
   * 
   * 
   * @param pProducts Collection with all objects that should be added to the association "products". The parameter must
   * not be null.
   */
  public void addToProducts( Collection<Product> pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add all passed objects.
    for (Product lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed Product object from the association "products".
   * 
   * 
   * @param pProducts Object that should be removed from the association "products". The parameter must not be null.
   */
  public void removeFromProducts( Product pProducts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts.getResellers().contains(this) == true) {
      pProducts.removeFromResellers((Reseller) this);
    }
  }

  /**
   * Method removes all objects from the association "products".
   * 
   */
  public void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      this.removeFromProducts(lIterator.next());
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
   * Method returns the attribute "language".
   * 
   * 
   * @return Locale Value to which the attribute "language" is set.
   */
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets the attribute "language".
   * 
   * 
   * @param pLanguage Value to which the attribute "language" should be set.
   */
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * 
   * @return {@link Integer}
   */
  public abstract Integer doSomething( );

  /**
   * 
   * @return {@link double}
   */
  public abstract double returnPrimitive( );

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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "language", "" + language));
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
