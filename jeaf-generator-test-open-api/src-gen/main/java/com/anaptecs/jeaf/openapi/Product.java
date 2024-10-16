/*
 * Product Base Definitions
 * This component represents the Open API interface of the accounting service. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: jeaf@anaptecs.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.anaptecs.jeaf.openapi;

import java.util.Objects;
import java.util.Arrays;
import com.anaptecs.jeaf.openapi.Reseller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Data type represents a product definition &lt;br&gt;&lt;br&gt; Alternate Name: Produkt 
 */
@Schema(description = "Data type represents a product definition <br><br> Alternate Name: Produkt ")

public class Product {
  @JsonProperty("resellers")
  private List<Reseller> resellers = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("image")
  private byte[] image = null;

  @JsonProperty("link")
  private String link = null;

  @JsonProperty("productID")
  private String productID = null;

  @JsonProperty("supportedCurrencies")
  private List<String> supportedCurrencies = new ArrayList<>();

  @JsonProperty("productCodes")
  private List<Integer> productCodes = new ArrayList<>();

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("uri")
  private String uri = "https://products.anaptecs.de/123456789";

  public Product resellers(List<Reseller> resellers) {
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
  **/
  @Schema(description = "")
  public List<Reseller> getResellers() {
    return resellers;
  }

  public void setResellers(List<Reseller> resellers) {
    this.resellers = resellers;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(required = true, description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product image(byte[] image) {
    this.image = image;
    return this;
  }

   /**
   * Image describing the product. 
   * @return image
  **/
  @Schema(description = "Image describing the product. ")
  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public Product link(String link) {
    this.link = link;
    return this;
  }

   /**
   * Get link
   * @return link
  **/
  @Schema(example = "https://www.company.com/products/1345-345", required = true, description = "")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Product productID(String productID) {
    this.productID = productID;
    return this;
  }

   /**
   * Get productID
   * @return productID
  **/
  @Schema(required = true, description = "")
  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public Product supportedCurrencies(List<String> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
    return this;
  }

  public Product addSupportedCurrenciesItem(String supportedCurrenciesItem) {
    this.supportedCurrencies.add(supportedCurrenciesItem);
    return this;
  }

   /**
   * ISO 4217 currency code. 
   * @return supportedCurrencies
  **/
  @Schema(required = true, description = "ISO 4217 currency code. ")
  public List<String> getSupportedCurrencies() {
    return supportedCurrencies;
  }

  public void setSupportedCurrencies(List<String> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
  }

  public Product productCodes(List<Integer> productCodes) {
    this.productCodes = productCodes;
    return this;
  }

  public Product addProductCodesItem(Integer productCodesItem) {
    this.productCodes.add(productCodesItem);
    return this;
  }

   /**
   * Get productCodes
   * @return productCodes
  **/
  @Schema(required = true, description = "")
  public List<Integer> getProductCodes() {
    return productCodes;
  }

  public void setProductCodes(List<Integer> productCodes) {
    this.productCodes = productCodes;
  }

  public Product description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(required = true, description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Product uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @Schema(required = true, description = "")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.resellers, product.resellers) &&
        Objects.equals(this.name, product.name) &&
        Arrays.equals(this.image, product.image) &&
        Objects.equals(this.link, product.link) &&
        Objects.equals(this.productID, product.productID) &&
        Objects.equals(this.supportedCurrencies, product.supportedCurrencies) &&
        Objects.equals(this.productCodes, product.productCodes) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.uri, product.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resellers, name, Arrays.hashCode(image), link, productID, supportedCurrencies, productCodes, description, uri);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
