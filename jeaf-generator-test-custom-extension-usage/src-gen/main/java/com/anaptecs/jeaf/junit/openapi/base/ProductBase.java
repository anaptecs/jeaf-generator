/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * Data type represents a product definition
 * <p/>
 * <b>Alternate Name:</b> <code>Produkt</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public abstract class ProductBase extends Object implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "resellers".
   */
  public static final String RESELLERS = "resellers";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "image".
   */
  public static final String IMAGE = "image";

  /**
   * Constant for the name of attribute "link".
   */
  public static final String LINK = "link";

  /**
   * Constant for the name of attribute "productID".
   */
  public static final String PRODUCTID = "productID";

  /**
   * Constant for the name of attribute "supportedCurrencies".
   */
  public static final String SUPPORTEDCURRENCIES = "supportedCurrencies";

  /**
   * Constant for the name of attribute "productCodes".
   */
  public static final String PRODUCTCODES = "productCodes";

  /**
   * Constant for the name of attribute "description".
   */
  @Deprecated
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "sortiments".
   */
  public static final String SORTIMENTS = "sortiments";

  /**
   * Constant for the name of attribute "uri".
   */
  public static final String URI = "uri";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
  @ClassPropertyDeclaration
  private Set<Reseller> resellers;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean resellersBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
  private int resellersXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @Size(min = 12, max = Integer.MAX_VALUE)
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  /**
   * Image describing the product.
   */
  private byte[] image;

  // "byte"
  private int imageXYZ = 0;

  // "java.net.URL"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>https://www.company.com/products/1345-345</code></li>
   * </ul>
   */
  private URL link;

  // "java.net.URL"
  private int linkXYZ = 0;

  // "java.util.UUID"
  @ClassPropertyDeclaration
  private final UUID productID;

  // "java.util.UUID"
  private int productIDXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
  @ClassPropertyDeclaration
  @Size(min = 7, max = 42)
  private Set<CurrencyCode> supportedCurrencies;

  // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
  private int supportedCurrenciesXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
  @ClassPropertyDeclaration
  private Set<ProductCode> productCodes;

  // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
  private int productCodesXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  @Deprecated
  private String description;

  // "String"
  private int descriptionXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.Sortiment"
  @ClassPropertyDeclaration
  private transient Set<Sortiment> sortiments;

  // "com.anaptecs.jeaf.junit.openapi.base.Sortiment"
  private int sortimentsXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Default Value:</b> <code>"https://products.anaptecs.de/123456789"</code>
   */
  private String uri;

  // "String"
  private int uriXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ProductBase( ) {
    objectID = null;
    resellers = new HashSet<Reseller>();
    // Bidirectional back reference is not yet set up correctly
    resellersBackReferenceInitialized = false;
    productID = null;
    supportedCurrencies = new HashSet<CurrencyCode>();
    productCodes = new HashSet<ProductCode>();
    sortiments = new HashSet<Sortiment>();
    uri = "https://products.anaptecs.de/123456789";
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductBase( BuilderBase pBuilder ) {
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
    if (pBuilder.resellers != null) {
      resellers = pBuilder.resellers;
      // As association is bidirectional we also have to set it in the other direction.
      for (Reseller lNext : resellers) {
        lNext.addToProducts((Product) this);
      }
    }
    else {
      resellers = new HashSet<Reseller>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    resellersBackReferenceInitialized = true;
    // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
    resellersXYZ = pBuilder.resellersXYZ;
    name = pBuilder.name;
    // "java.lang.String"
    nameXYZ = pBuilder.nameXYZ;
    image = pBuilder.image;
    // "byte"
    imageXYZ = pBuilder.imageXYZ;
    link = pBuilder.link;
    // "java.net.URL"
    linkXYZ = pBuilder.linkXYZ;
    productID = pBuilder.productID;
    // "java.util.UUID"
    productIDXYZ = pBuilder.productIDXYZ;
    if (pBuilder.supportedCurrencies != null) {
      supportedCurrencies = pBuilder.supportedCurrencies;
    }
    else {
      supportedCurrencies = new HashSet<CurrencyCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
    supportedCurrenciesXYZ = pBuilder.supportedCurrenciesXYZ;
    if (pBuilder.productCodes != null) {
      productCodes = pBuilder.productCodes;
    }
    else {
      productCodes = new HashSet<ProductCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
    productCodesXYZ = pBuilder.productCodesXYZ;
    description = pBuilder.description;
    // "String"
    descriptionXYZ = pBuilder.descriptionXYZ;
    sortiments = new HashSet<Sortiment>();
    uri = pBuilder.uri;
    // "String"
    uriXYZ = pBuilder.uriXYZ;
  }

  /**
   * Class implements builder to create a new instance of class Product. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
    @BuilderPropertyDeclaration
    private Set<Reseller> resellers;

    // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
    private int resellersXYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @Size(min = 12, max = Integer.MAX_VALUE)
    private String name;

    // "java.lang.String"
    private int nameXYZ = 0;

    /**
     * Image describing the product.
     */
    // "byte"
    @BuilderPropertyDeclaration
    private byte[] image;

    // "byte"
    private int imageXYZ = 0;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>https://www.company.com/products/1345-345</code></li>
     * </ul>
     */
    // "java.net.URL"
    @BuilderPropertyDeclaration
    private URL link;

    // "java.net.URL"
    private int linkXYZ = 0;

    // "java.util.UUID"
    @BuilderPropertyDeclaration
    private UUID productID;

    // "java.util.UUID"
    private int productIDXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
    @BuilderPropertyDeclaration
    private Set<CurrencyCode> supportedCurrencies;

    // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
    private int supportedCurrenciesXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
    @BuilderPropertyDeclaration
    private Set<ProductCode> productCodes;

    // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
    private int productCodesXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    @Deprecated
    private String description;

    // "String"
    private int descriptionXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>"https://products.anaptecs.de/123456789"</code>
     */
    // "String"
    @BuilderPropertyDeclaration
    private String uri = "https://products.anaptecs.de/123456789";

    // "String"
    private int uriXYZ = 0;

    /**
     * Use {@link Product.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Product.builder(Product)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ProductBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setResellers(pObject.resellers);
        this.setName(pObject.name);
        this.setImage(pObject.image);
        this.setLink(pObject.link);
        this.setProductID(pObject.productID);
        this.setSupportedCurrencies(pObject.supportedCurrencies);
        this.setProductCodes(pObject.productCodes);
        this.setDescription(pObject.description);
        this.setUri(pObject.uri);
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
     * Method sets association {@link #resellers}.<br/>
     *
     * @param pResellers Collection to which {@link #resellers} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setResellers( Set<Reseller> pResellers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pResellers != null) {
        resellers = new HashSet<Reseller>(pResellers);
      }
      else {
        resellers = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #resellers}.<br/>
     *
     * @param pResellers Array of objects that should be added to {@link #resellers}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToResellers( Reseller... pResellers ) {
      if (pResellers != null) {
        if (resellers == null) {
          resellers = new HashSet<Reseller>();
        }
        resellers.addAll(Arrays.asList(pResellers));
      }
      return this;
    }

    public BuilderBase setResellersXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
      resellersXYZ = value;
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

    public BuilderBase setNameXYZ( int value ) {
      // "java.lang.String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #image}.<br/>
     *
     * @param pImage Value to which {@link #image} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setImage( byte[] pImage ) {
      // Assign value to attribute
      if (pImage != null) {
        image = new byte[pImage.length];
        System.arraycopy(pImage, 0, image, 0, pImage.length);
      }
      else {
        image = null;
      }
      return this;
    }

    public BuilderBase setImageXYZ( int value ) {
      // "byte"
      imageXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setLink( URL pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    public BuilderBase setLinkXYZ( int value ) {
      // "java.net.URL"
      linkXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #productID}.<br/>
     *
     * @param pProductID Value to which {@link #productID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setProductID( UUID pProductID ) {
      // Assign value to attribute
      productID = pProductID;
      return this;
    }

    public BuilderBase setProductIDXYZ( int value ) {
      // "java.util.UUID"
      productIDXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #supportedCurrencies}.<br/>
     *
     * @param pSupportedCurrencies Collection to which {@link #supportedCurrencies} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSupportedCurrencies( Set<CurrencyCode> pSupportedCurrencies ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSupportedCurrencies != null) {
        supportedCurrencies = new HashSet<CurrencyCode>(pSupportedCurrencies);
      }
      else {
        supportedCurrencies = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #supportedCurrencies}.<br/>
     *
     * @param pSupportedCurrencies Array of objects that should be added to {@link #supportedCurrencies}. The parameter
     * may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToSupportedCurrencies( CurrencyCode... pSupportedCurrencies ) {
      if (pSupportedCurrencies != null) {
        if (supportedCurrencies == null) {
          supportedCurrencies = new HashSet<CurrencyCode>();
        }
        supportedCurrencies.addAll(Arrays.asList(pSupportedCurrencies));
      }
      return this;
    }

    public BuilderBase setSupportedCurrenciesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
      supportedCurrenciesXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #productCodes}.<br/>
     *
     * @param pProductCodes Collection to which {@link #productCodes} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setProductCodes( Set<ProductCode> pProductCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pProductCodes != null) {
        productCodes = new HashSet<ProductCode>(pProductCodes);
      }
      else {
        productCodes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #productCodes}.<br/>
     *
     * @param pProductCodes Array of objects that should be added to {@link #productCodes}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToProductCodes( ProductCode... pProductCodes ) {
      if (pProductCodes != null) {
        if (productCodes == null) {
          productCodes = new HashSet<ProductCode>();
        }
        productCodes.addAll(Arrays.asList(pProductCodes));
      }
      return this;
    }

    public BuilderBase setProductCodesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
      productCodesXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public BuilderBase setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    public BuilderBase setDescriptionXYZ( int value ) {
      // "String"
      descriptionXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #uri}.<br/>
     *
     * @param pUri Value to which {@link #uri} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setUri( String pUri ) {
      // Assign value to attribute
      uri = pUri;
      return this;
    }

    public BuilderBase setUriXYZ( int value ) {
      // "String"
      uriXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Product. The object will be initialized with the values of the builder.
     *
     * @return Product Created object. The method never returns null.
     */
    public Product build( ) {
      return new Product(this);
    }

    /**
     * Method creates a new validated instance of class Product. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Product Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Product buildValidated( ) throws ConstraintViolationException {
      Product lPOJO = this.build();
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
   * Method returns association {@link #resellers}.<br/>
   *
   * @return {@link Set<Reseller>} Value to which {@link #resellers} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Reseller> getResellers( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (resellersBackReferenceInitialized == false) {
      resellersBackReferenceInitialized = true;
      for (Reseller lNext : resellers) {
        lNext.addToProducts((Product) this);
      }
    }
    // Return all Reseller objects as unmodifiable collection.
    return Collections.unmodifiableSet(resellers);
  }

  /**
   * Method adds the passed object to {@link #resellers}.
   *
   * @param pResellers Object that should be added to {@link #resellers}. The parameter must not be null.
   */
  public void addToResellers( Reseller pResellers ) {
    // Check parameter "pResellers" for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Add passed object to collection of associated Reseller objects.
    resellers.add(pResellers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pResellers != null && pResellers.getProducts().contains(this) == false) {
      pResellers.addToProducts((Product) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #resellers}.
   *
   * @param pResellers Collection with all objects that should be added to {@link #resellers}. The parameter must not be
   * null.
   */
  public void addToResellers( Collection<Reseller> pResellers ) {
    // Check parameter "pResellers" for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Add all passed objects.
    for (Reseller lNextObject : pResellers) {
      this.addToResellers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #resellers}.<br/>
   *
   * @param pResellers Object that should be removed from {@link #resellers}. The parameter must not be null.
   */
  public void removeFromResellers( Reseller pResellers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Remove passed object from collection of associated Reseller objects.
    resellers.remove(pResellers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pResellers.getProducts().contains(this) == true) {
      pResellers.removeFromProducts((Product) this);
    }
  }

  /**
   * Method removes all objects from {@link #resellers}.
   */
  public void clearResellers( ) {
    // Remove all objects from association "resellers".
    Collection<Reseller> lResellers = new HashSet<Reseller>(resellers);
    Iterator<Reseller> lIterator = lResellers.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromResellers(lIterator.next());
    }
  }

  public int getResellersXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Reseller"
    return resellersXYZ;
  }

  public void setResellersXYZ( int value ) {
    resellersXYZ = value;
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

  public int getNameXYZ( ) {
    // "java.lang.String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns attribute {@link #image}.<br/>
   * Image describing the product.
   *
   * @return byte[] Value to which {@link #image} is set.
   */
  public byte[] getImage( ) {
    byte[] lReturnValue;
    if (image != null) {
      lReturnValue = new byte[image.length];
      System.arraycopy(image, 0, lReturnValue, 0, image.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #image}.<br/>
   * Image describing the product.
   *
   * @param pImage Value to which {@link #image} should be set.
   */
  public void setImage( byte[] pImage ) {
    // Assign value to attribute
    if (pImage != null) {
      image = new byte[pImage.length];
      System.arraycopy(pImage, 0, image, 0, pImage.length);
    }
    else {
      image = null;
    }
  }

  public int getImageXYZ( ) {
    // "byte"
    return imageXYZ;
  }

  public void setImageXYZ( int value ) {
    imageXYZ = value;
  }

  /**
   * Method returns attribute {@link #link}.<br/>
   *
   * @return {@link URL} Value to which {@link #link} is set.
   */
  public URL getLink( ) {
    return link;
  }

  /**
   * Method sets attribute {@link #link}.<br/>
   *
   * @param pLink Value to which {@link #link} should be set.
   */
  public void setLink( URL pLink ) {
    // Assign value to attribute
    link = pLink;
  }

  public int getLinkXYZ( ) {
    // "java.net.URL"
    return linkXYZ;
  }

  public void setLinkXYZ( int value ) {
    linkXYZ = value;
  }

  /**
   * Method returns attribute {@link #productID}.<br/>
   *
   * @return {@link UUID} Value to which {@link #productID} is set.
   */
  public UUID getProductID( ) {
    return productID;
  }

  public int getProductIDXYZ( ) {
    // "java.util.UUID"
    return productIDXYZ;
  }

  public void setProductIDXYZ( int value ) {
    productIDXYZ = value;
  }

  /**
   * Method returns association {@link #supportedCurrencies}.<br/>
   *
   * @return {@link Set<CurrencyCode>} Value to which {@link #supportedCurrencies} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<CurrencyCode> getSupportedCurrencies( ) {
    // Return all CurrencyCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(supportedCurrencies);
  }

  /**
   * Method adds the passed object to {@link #supportedCurrencies}.
   *
   * @param pSupportedCurrencies Object that should be added to {@link #supportedCurrencies}. The parameter must not be
   * null.
   */
  public void addToSupportedCurrencies( CurrencyCode pSupportedCurrencies ) {
    // Check parameter "pSupportedCurrencies" for invalid value null.
    Check.checkInvalidParameterNull(pSupportedCurrencies, "pSupportedCurrencies");
    // Add passed object to collection of associated CurrencyCode objects.
    supportedCurrencies.add(pSupportedCurrencies);
  }

  /**
   * Method adds all passed objects to {@link #supportedCurrencies}.
   *
   * @param pSupportedCurrencies Collection with all objects that should be added to {@link #supportedCurrencies}. The
   * parameter must not be null.
   */
  public void addToSupportedCurrencies( Collection<CurrencyCode> pSupportedCurrencies ) {
    // Check parameter "pSupportedCurrencies" for invalid value null.
    Check.checkInvalidParameterNull(pSupportedCurrencies, "pSupportedCurrencies");
    // Add all passed objects.
    for (CurrencyCode lNextObject : pSupportedCurrencies) {
      this.addToSupportedCurrencies(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #supportedCurrencies}.<br/>
   *
   * @param pSupportedCurrencies Object that should be removed from {@link #supportedCurrencies}. The parameter must not
   * be null.
   */
  public void removeFromSupportedCurrencies( CurrencyCode pSupportedCurrencies ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSupportedCurrencies, "pSupportedCurrencies");
    // Remove passed object from collection of associated CurrencyCode objects.
    supportedCurrencies.remove(pSupportedCurrencies);
  }

  /**
   * Method removes all objects from {@link #supportedCurrencies}.
   */
  public void clearSupportedCurrencies( ) {
    // Remove all objects from association "supportedCurrencies".
    supportedCurrencies.clear();
  }

  public int getSupportedCurrenciesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.CurrencyCode"
    return supportedCurrenciesXYZ;
  }

  public void setSupportedCurrenciesXYZ( int value ) {
    supportedCurrenciesXYZ = value;
  }

  /**
   * Method returns association {@link #productCodes}.<br/>
   *
   * @return {@link Set<ProductCode>} Value to which {@link #productCodes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<ProductCode> getProductCodes( ) {
    // Return all ProductCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(productCodes);
  }

  /**
   * Method adds the passed object to {@link #productCodes}.
   *
   * @param pProductCodes Object that should be added to {@link #productCodes}. The parameter must not be null.
   */
  public void addToProductCodes( ProductCode pProductCodes ) {
    // Check parameter "pProductCodes" for invalid value null.
    Check.checkInvalidParameterNull(pProductCodes, "pProductCodes");
    // Add passed object to collection of associated ProductCode objects.
    productCodes.add(pProductCodes);
  }

  /**
   * Method adds all passed objects to {@link #productCodes}.
   *
   * @param pProductCodes Collection with all objects that should be added to {@link #productCodes}. The parameter must
   * not be null.
   */
  public void addToProductCodes( Collection<ProductCode> pProductCodes ) {
    // Check parameter "pProductCodes" for invalid value null.
    Check.checkInvalidParameterNull(pProductCodes, "pProductCodes");
    // Add all passed objects.
    for (ProductCode lNextObject : pProductCodes) {
      this.addToProductCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #productCodes}.<br/>
   *
   * @param pProductCodes Object that should be removed from {@link #productCodes}. The parameter must not be null.
   */
  public void removeFromProductCodes( ProductCode pProductCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProductCodes, "pProductCodes");
    // Remove passed object from collection of associated ProductCode objects.
    productCodes.remove(pProductCodes);
  }

  /**
   * Method removes all objects from {@link #productCodes}.
   */
  public void clearProductCodes( ) {
    // Remove all objects from association "productCodes".
    productCodes.clear();
  }

  public int getProductCodesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ProductCode"
    return productCodesXYZ;
  }

  public void setProductCodesXYZ( int value ) {
    productCodesXYZ = value;
  }

  /**
   * Method returns attribute {@link #description}.<br/>
   *
   * @return {@link String} Value to which {@link #description} is set.
   */
  @Deprecated
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   *
   * @param pDescription Value to which {@link #description} should be set.
   */
  @Deprecated
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  public int getDescriptionXYZ( ) {
    // "String"
    return descriptionXYZ;
  }

  public void setDescriptionXYZ( int value ) {
    descriptionXYZ = value;
  }

  /**
   * Method returns association {@link #sortiments}.<br/>
   *
   * @return {@link Set<Sortiment>} Value to which {@link #sortiments} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Sortiment> getSortiments( ) {
    // Return all Sortiment objects as unmodifiable collection.
    return Collections.unmodifiableSet(sortiments);
  }

  /**
   * Method adds the passed object to {@link #sortiments}.
   *
   * @param pSortiments Object that should be added to {@link #sortiments}. The parameter must not be null.
   */
  void addToSortiments( Sortiment pSortiments ) {
    // Check parameter "pSortiments" for invalid value null.
    Check.checkInvalidParameterNull(pSortiments, "pSortiments");
    // Add passed object to collection of associated Sortiment objects.
    sortiments.add(pSortiments);
  }

  /**
   * Method adds all passed objects to {@link #sortiments}.
   *
   * @param pSortiments Collection with all objects that should be added to {@link #sortiments}. The parameter must not
   * be null.
   */
  void addToSortiments( Collection<Sortiment> pSortiments ) {
    // Check parameter "pSortiments" for invalid value null.
    Check.checkInvalidParameterNull(pSortiments, "pSortiments");
    // Add all passed objects.
    for (Sortiment lNextObject : pSortiments) {
      this.addToSortiments(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #sortiments}.<br/>
   *
   * @param pSortiments Object that should be removed from {@link #sortiments}. The parameter must not be null.
   */
  void removeFromSortiments( Sortiment pSortiments ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSortiments, "pSortiments");
    // Remove passed object from collection of associated Sortiment objects.
    sortiments.remove(pSortiments);
  }

  /**
   * Method removes all objects from {@link #sortiments}.
   */
  void clearSortiments( ) {
    // Remove all objects from association "sortiments".
    Collection<Sortiment> lSortiments = new HashSet<Sortiment>(sortiments);
    Iterator<Sortiment> lIterator = lSortiments.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromSortiments(lIterator.next());
    }
  }

  public int getSortimentsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Sortiment"
    return sortimentsXYZ;
  }

  public void setSortimentsXYZ( int value ) {
    sortimentsXYZ = value;
  }

  /**
   * Method returns attribute {@link #uri}.<br/>
   *
   * @return {@link String} Value to which {@link #uri} is set.
   */
  public String getUri( ) {
    return uri;
  }

  /**
   * Method sets attribute {@link #uri}.<br/>
   *
   * @param pUri Value to which {@link #uri} should be set.
   */
  public void setUri( String pUri ) {
    // Assign value to attribute
    uri = pUri;
  }

  public int getUriXYZ( ) {
    // "String"
    return uriXYZ;
  }

  public void setUriXYZ( int value ) {
    uriXYZ = value;
  }

  /**
   * Method returns association {@link #theChannels}.<br/>
   *
   * @return {@link Set<Channel>} Value to which {@link #theChannels} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public abstract Set<Channel> getTheChannels( );

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
    lBuilder.append("link: ");
    lBuilder.append(link);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("productID: ");
    lBuilder.append(productID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("uri: ");
    lBuilder.append(uri);
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
   * @return {@link Builder} New builder that can be used to create new Product objects. The method never returns null.
   */
  public Product.Builder toBuilder( ) {
    return new Product.Builder((Product) this);
  }
}