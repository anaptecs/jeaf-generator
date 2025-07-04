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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import openapitools.model.Product;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * Sortiment
 */
@JsonPropertyOrder({
  Sortiment.JSON_PROPERTY_PRODUCTS,
  Sortiment.JSON_PROPERTY_VALUE,
  Sortiment.JSON_PROPERTY_INLINE_SORTIMENT_TYPE,
  Sortiment.JSON_PROPERTY_TYPES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public class Sortiment {
  public static final String JSON_PROPERTY_PRODUCTS = "products";
  @javax.annotation.Nullable
  private List<Product> products = new ArrayList<>();

  public static final String JSON_PROPERTY_VALUE = "value";
  @javax.annotation.Nonnull
  private Integer value = 4711;

  public static final String JSON_PROPERTY_INLINE_SORTIMENT_TYPE = "inlineSortimentType";
  @javax.annotation.Nullable
  private String inlineSortimentType;

  public static final String JSON_PROPERTY_TYPES = "types";
  @Deprecated
  @javax.annotation.Nullable
  private List<String> types = new ArrayList<>();

  public Sortiment() { 
  }

  public Sortiment products(@javax.annotation.Nullable List<Product> products) {
    this.products = products;
    return this;
  }

  public Sortiment addProductsItem(Product productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Product> getProducts() {
    return products;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProducts(@javax.annotation.Nullable List<Product> products) {
    this.products = products;
  }


  public Sortiment value(@javax.annotation.Nonnull Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(@javax.annotation.Nonnull Integer value) {
    this.value = value;
  }


  public Sortiment inlineSortimentType(@javax.annotation.Nullable String inlineSortimentType) {
    this.inlineSortimentType = inlineSortimentType;
    return this;
  }

  /**
   * Get inlineSortimentType
   * @return inlineSortimentType
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INLINE_SORTIMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInlineSortimentType() {
    return inlineSortimentType;
  }


  @JsonProperty(JSON_PROPERTY_INLINE_SORTIMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInlineSortimentType(@javax.annotation.Nullable String inlineSortimentType) {
    this.inlineSortimentType = inlineSortimentType;
  }


  @Deprecated
  public Sortiment types(@javax.annotation.Nullable List<String> types) {
    this.types = types;
    return this;
  }

  public Sortiment addTypesItem(String typesItem) {
    if (this.types == null) {
      this.types = new ArrayList<>();
    }
    this.types.add(typesItem);
    return this;
  }

  /**
   * Get types
   * @return types
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTypes() {
    return types;
  }


  @Deprecated
  @JsonProperty(JSON_PROPERTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTypes(@javax.annotation.Nullable List<String> types) {
    this.types = types;
  }


  /**
   * Return true if this Sortiment object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sortiment sortiment = (Sortiment) o;
    return Objects.equals(this.products, sortiment.products) &&
        Objects.equals(this.value, sortiment.value) &&
        Objects.equals(this.inlineSortimentType, sortiment.inlineSortimentType) &&
        Objects.equals(this.types, sortiment.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, value, inlineSortimentType, types);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sortiment {\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    inlineSortimentType: ").append(toIndentedString(inlineSortimentType)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
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

