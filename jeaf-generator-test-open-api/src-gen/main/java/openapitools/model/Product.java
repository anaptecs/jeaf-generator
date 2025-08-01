/*
 * Product Base Definitions
 * This component represents the Open API interface of the accounting service. 
 *
 * The version of the OpenAPI document: 0.0.1
 * Contact: jeaf@anaptecs.de
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package openapitools.model;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import openapitools.model.Reseller;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * Data type represents a product definition &lt;br&gt;&lt;br&gt; Alternate Name: Produkt 
 */
@JsonPropertyOrder({
  Product.JSON_PROPERTY_RESELLERS,
  Product.JSON_PROPERTY_NAME,
  Product.JSON_PROPERTY_IMAGE,
  Product.JSON_PROPERTY_LINK,
  Product.JSON_PROPERTY_PRODUCT_I_D,
  Product.JSON_PROPERTY_SUPPORTED_CURRENCIES,
  Product.JSON_PROPERTY_PRODUCT_CODES,
  Product.JSON_PROPERTY_DESCRIPTION,
  Product.JSON_PROPERTY_URI
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public class Product {
  public static final String JSON_PROPERTY_RESELLERS = "resellers";
  @javax.annotation.Nullable
  private List<Reseller> resellers = new ArrayList<>();

  public static final String JSON_PROPERTY_NAME = "name";
  @javax.annotation.Nonnull
  private String name;

  public static final String JSON_PROPERTY_IMAGE = "image";
  private JsonNullable<byte[]> image = JsonNullable.<byte[]>undefined();

  public static final String JSON_PROPERTY_LINK = "link";
  @javax.annotation.Nonnull
  private String link;

  public static final String JSON_PROPERTY_PRODUCT_I_D = "productID";
  @javax.annotation.Nonnull
  private String productID;

  public static final String JSON_PROPERTY_SUPPORTED_CURRENCIES = "supportedCurrencies";
  @javax.annotation.Nonnull
  private List<String> supportedCurrencies = new ArrayList<>();

  public static final String JSON_PROPERTY_PRODUCT_CODES = "productCodes";
  @javax.annotation.Nonnull
  private List<Integer> productCodes = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @Deprecated
  @javax.annotation.Nonnull
  private String description;

  public static final String JSON_PROPERTY_URI = "uri";
  @javax.annotation.Nonnull
  private URI uri = URI.create("https://products.anaptecs.de/123456789");

  public Product() { 
  }

  public Product resellers(@javax.annotation.Nullable List<Reseller> resellers) {
    this.resellers = resellers;
    return this;
  }

  public Product addResellersItem(Reseller resellersItem) {
    if (this.resellers == null) {
      this.resellers = new ArrayList<>();
    }
    this.resellers.add(resellersItem);
    return this;
  }

  /**
   * Get resellers
   * @return resellers
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RESELLERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reseller> getResellers() {
    return resellers;
  }


  @JsonProperty(JSON_PROPERTY_RESELLERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResellers(@javax.annotation.Nullable List<Reseller> resellers) {
    this.resellers = resellers;
  }


  public Product name(@javax.annotation.Nonnull String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(@javax.annotation.Nonnull String name) {
    this.name = name;
  }


  public Product image(@javax.annotation.Nullable byte[] image) {
    this.image = JsonNullable.<byte[]>of(image);
    return this;
  }

  /**
   * Image describing the product. 
   * @return image
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public byte[] getImage() {
        return image.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<byte[]> getImage_JsonNullable() {
    return image;
  }
  
  @JsonProperty(JSON_PROPERTY_IMAGE)
  public void setImage_JsonNullable(JsonNullable<byte[]> image) {
    this.image = image;
  }

  public void setImage(@javax.annotation.Nullable byte[] image) {
    this.image = JsonNullable.<byte[]>of(image);
  }


  public Product link(@javax.annotation.Nonnull String link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   * @return link
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLink() {
    return link;
  }


  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLink(@javax.annotation.Nonnull String link) {
    this.link = link;
  }


  public Product productID(@javax.annotation.Nonnull String productID) {
    this.productID = productID;
    return this;
  }

  /**
   * Get productID
   * @return productID
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PRODUCT_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProductID() {
    return productID;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCT_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProductID(@javax.annotation.Nonnull String productID) {
    this.productID = productID;
  }


  public Product supportedCurrencies(@javax.annotation.Nonnull List<String> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
    return this;
  }

  public Product addSupportedCurrenciesItem(String supportedCurrenciesItem) {
    if (this.supportedCurrencies == null) {
      this.supportedCurrencies = new ArrayList<>();
    }
    this.supportedCurrencies.add(supportedCurrenciesItem);
    return this;
  }

  /**
   * ISO 4217 currency code. 
   * @return supportedCurrencies
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SUPPORTED_CURRENCIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getSupportedCurrencies() {
    return supportedCurrencies;
  }


  @JsonProperty(JSON_PROPERTY_SUPPORTED_CURRENCIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSupportedCurrencies(@javax.annotation.Nonnull List<String> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
  }


  public Product productCodes(@javax.annotation.Nonnull List<Integer> productCodes) {
    this.productCodes = productCodes;
    return this;
  }

  public Product addProductCodesItem(Integer productCodesItem) {
    if (this.productCodes == null) {
      this.productCodes = new ArrayList<>();
    }
    this.productCodes.add(productCodesItem);
    return this;
  }

  /**
   * Get productCodes
   * @return productCodes
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PRODUCT_CODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Integer> getProductCodes() {
    return productCodes;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCT_CODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProductCodes(@javax.annotation.Nonnull List<Integer> productCodes) {
    this.productCodes = productCodes;
  }


  @Deprecated
  public Product description(@javax.annotation.Nonnull String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @Deprecated
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(@javax.annotation.Nonnull String description) {
    this.description = description;
  }


  public Product uri(@javax.annotation.Nonnull URI uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Get uri
   * @return uri
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public URI getUri() {
    return uri;
  }


  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUri(@javax.annotation.Nonnull URI uri) {
    this.uri = uri;
  }


  /**
   * Return true if this Product object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.resellers, product.resellers) &&
        Objects.equals(this.name, product.name) &&
        equalsNullable(this.image, product.image) &&
        Objects.equals(this.link, product.link) &&
        Objects.equals(this.productID, product.productID) &&
        Objects.equals(this.supportedCurrencies, product.supportedCurrencies) &&
        Objects.equals(this.productCodes, product.productCodes) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.uri, product.uri);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(resellers, name, hashCodeNullable(image), link, productID, supportedCurrencies, productCodes, description, uri);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    resellers: ").append(toIndentedString(resellers)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    productID: ").append(toIndentedString(productID)).append("\n");
    sb.append("    supportedCurrencies: ").append(toIndentedString(supportedCurrencies)).append("\n");
    sb.append("    productCodes: ").append(toIndentedString(productCodes)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

