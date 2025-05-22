/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

/**
 * Data type represents a product definition
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements IProduct {
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

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<Reseller> resellers;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean resellersBackReferenceInitialized;

  @Size(min = 12, max = Integer.MAX_VALUE)
  private String name;

  /**
   * Image describing the product.
   */
  @Size(min = 1024, max = 32768)
  private byte[] image;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>https://www.company.com/products/1345-345</code></li>
   * </ul>
   */
  private URL link;

  private final UUID productID;

  @Size(min = 7, max = 42)
  @JsonSetter(nulls = Nulls.SKIP)
  private Set<CurrencyCode> supportedCurrencies;

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<ProductCode> productCodes;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>1st line 1st comment<br/>
   * 2nd line 1st comment</code></li>
   * <li><code>1st line 2nd comment<br/>
   * 2nd line 2nd comment</code></li>
   * </ul>
   */
  @Deprecated
  private String description;

  private transient Set<Sortiment> sortiments;

  /**
   * <br/>
   * <b>Default Value:</b> <code>"https://products.anaptecs.de/123456789"</code>
   */
  private String uri;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Product( ) {
    resellers = new HashSet<>();
    // Bidirectional back reference is not yet set up correctly
    resellersBackReferenceInitialized = false;
    productID = null;
    supportedCurrencies = new HashSet<>();
    productCodes = new HashSet<>();
    sortiments = new HashSet<>();
    uri = "https://products.anaptecs.de/123456789";
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Product( Builder pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.resellers != null) {
      resellers = pBuilder.resellers;
      // As association is bidirectional we also have to set it in the other direction.
      for (Reseller lNext : resellers) {
        lNext.addToProducts((Product) this);
      }
    }
    else {
      resellers = new HashSet<>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    resellersBackReferenceInitialized = true;
    name = pBuilder.name;
    image = pBuilder.image;
    link = pBuilder.link;
    productID = pBuilder.productID;
    if (pBuilder.supportedCurrencies != null) {
      supportedCurrencies = pBuilder.supportedCurrencies;
    }
    else {
      supportedCurrencies = new HashSet<>();
    }
    if (pBuilder.productCodes != null) {
      productCodes = pBuilder.productCodes;
    }
    else {
      productCodes = new HashSet<>();
    }
    description = pBuilder.description;
    sortiments = new HashSet<>();
    uri = pBuilder.uri;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Product objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Product.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pLink Value to which {@link #link} should be set.
   *
   * @param pProductID Value to which {@link #productID} should be set.
   *
   * @param pSupportedCurrencies Value to which {@link #supportedCurrencies} should be set.
   *
   * @param pProductCodes Value to which {@link #productCodes} should be set.
   *
   * @param pDescription Value to which {@link #description} should be set.
   *
   * @param pUri Value to which {@link #uri} should be set.
   *
   * @return {@link Product}
   */
  public static Product of( String pName, URL pLink, UUID pProductID, Set<CurrencyCode> pSupportedCurrencies,
      Set<ProductCode> pProductCodes, String pDescription, String pUri ) {
    Product.Builder lBuilder = Product.builder();
    lBuilder.setName(pName);
    lBuilder.setLink(pLink);
    lBuilder.setProductID(pProductID);
    lBuilder.setSupportedCurrencies(pSupportedCurrencies);
    lBuilder.setProductCodes(pProductCodes);
    lBuilder.setDescription(pDescription);
    lBuilder.setUri(pUri);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Product</code>.
   */
  public static class Builder {
    private Set<Reseller> resellers;

    @Size(min = 12, max = Integer.MAX_VALUE)
    private String name;

    /**
     * Image describing the product.
     */
    @Size(min = 1024, max = 32768)
    private byte[] image;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>https://www.company.com/products/1345-345</code></li>
     * </ul>
     */
    private URL link;

    private UUID productID;

    private Set<CurrencyCode> supportedCurrencies;

    private Set<ProductCode> productCodes;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>1st line 1st comment<br/>
     * 2nd line 1st comment</code></li>
     * <li><code>1st line 2nd comment<br/>
     * 2nd line 2nd comment</code></li>
     * </ul>
     */
    @Deprecated
    private String description;

    /**
     * <br/>
     * <b>Default Value:</b> <code>"https://products.anaptecs.de/123456789"</code>
     */
    private String uri = "https://products.anaptecs.de/123456789";

    /**
     * Use {@link Product#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Product#builder(Product)} instead of private constructor to create new builder.
     */
    protected Builder( Product pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
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
     * Method sets association {@link #resellers}.<br/>
     *
     * @param pResellers Collection to which {@link #resellers} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setResellers( Set<Reseller> pResellers ) {
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
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToResellers( Reseller... pResellers ) {
      if (pResellers != null) {
        if (resellers == null) {
          resellers = new HashSet<Reseller>();
        }
        resellers.addAll(Arrays.asList(pResellers));
      }
      return this;
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
     * Method sets attribute {@link #image}.<br/>
     *
     * @param pImage Value to which {@link #image} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setImage( byte[] pImage ) {
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

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLink( URL pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    /**
     * Method sets attribute {@link #productID}.<br/>
     *
     * @param pProductID Value to which {@link #productID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setProductID( UUID pProductID ) {
      // Assign value to attribute
      productID = pProductID;
      return this;
    }

    /**
     * Method sets association {@link #supportedCurrencies}.<br/>
     *
     * @param pSupportedCurrencies Collection to which {@link #supportedCurrencies} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSupportedCurrencies( Set<CurrencyCode> pSupportedCurrencies ) {
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
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToSupportedCurrencies( CurrencyCode... pSupportedCurrencies ) {
      if (pSupportedCurrencies != null) {
        if (supportedCurrencies == null) {
          supportedCurrencies = new HashSet<CurrencyCode>();
        }
        supportedCurrencies.addAll(Arrays.asList(pSupportedCurrencies));
      }
      return this;
    }

    /**
     * Method sets association {@link #productCodes}.<br/>
     *
     * @param pProductCodes Collection to which {@link #productCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setProductCodes( Set<ProductCode> pProductCodes ) {
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
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToProductCodes( ProductCode... pProductCodes ) {
      if (pProductCodes != null) {
        if (productCodes == null) {
          productCodes = new HashSet<ProductCode>();
        }
        productCodes.addAll(Arrays.asList(pProductCodes));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    /**
     * Method sets attribute {@link #uri}.<br/>
     *
     * @param pUri Value to which {@link #uri} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setUri( String pUri ) {
      // Assign value to attribute
      uri = pUri;
      return this;
    }

    /**
     * Method creates a new instance of class Product. The object will be initialized with the values of the builder.
     *
     * @return Product Created object. The method never returns null.
     */
    public Product build( ) {
      return new Product(this);
    }
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

  /**
   * Method returns attribute {@link #productID}.<br/>
   *
   * @return {@link UUID} Value to which {@link #productID} is set.
   */
  public UUID getProductID( ) {
    return productID;
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
    lBuilder.append("resellers: ");
    if (resellers != null) {
      lBuilder.append(resellers.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (resellers != null) {
      for (Reseller lNext : resellers) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("image: ");
    if (image != null) {
      lBuilder.append(Arrays.toString(image));
    }
    else {
      lBuilder.append(" null");
    }
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
    lBuilder.append("supportedCurrencies: ");
    if (supportedCurrencies != null) {
      lBuilder.append(supportedCurrencies.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (supportedCurrencies != null) {
      for (CurrencyCode lNext : supportedCurrencies) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("productCodes: ");
    if (productCodes != null) {
      lBuilder.append(productCodes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (productCodes != null) {
      for (ProductCode lNext : productCodes) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}