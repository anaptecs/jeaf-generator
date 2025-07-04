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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * BusinessA
 */
@JsonPropertyOrder({
  BusinessA.JSON_PROPERTY_TECH_ATTRIBUTE,
  BusinessA.JSON_PROPERTY_BUSINESS_ATTRIBUTE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public class BusinessA {
  public static final String JSON_PROPERTY_TECH_ATTRIBUTE = "techAttribute";
  @javax.annotation.Nonnull
  private String techAttribute;

  public static final String JSON_PROPERTY_BUSINESS_ATTRIBUTE = "businessAttribute";
  @javax.annotation.Nonnull
  private Integer businessAttribute;

  public BusinessA() { 
  }

  public BusinessA techAttribute(@javax.annotation.Nonnull String techAttribute) {
    this.techAttribute = techAttribute;
    return this;
  }

  /**
   * Get techAttribute
   * @return techAttribute
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TECH_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTechAttribute() {
    return techAttribute;
  }


  @JsonProperty(JSON_PROPERTY_TECH_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTechAttribute(@javax.annotation.Nonnull String techAttribute) {
    this.techAttribute = techAttribute;
  }


  public BusinessA businessAttribute(@javax.annotation.Nonnull Integer businessAttribute) {
    this.businessAttribute = businessAttribute;
    return this;
  }

  /**
   * Get businessAttribute
   * @return businessAttribute
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BUSINESS_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getBusinessAttribute() {
    return businessAttribute;
  }


  @JsonProperty(JSON_PROPERTY_BUSINESS_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBusinessAttribute(@javax.annotation.Nonnull Integer businessAttribute) {
    this.businessAttribute = businessAttribute;
  }


  /**
   * Return true if this BusinessA object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessA businessA = (BusinessA) o;
    return Objects.equals(this.techAttribute, businessA.techAttribute) &&
        Objects.equals(this.businessAttribute, businessA.businessAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(techAttribute, businessAttribute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessA {\n");
    sb.append("    techAttribute: ").append(toIndentedString(techAttribute)).append("\n");
    sb.append("    businessAttribute: ").append(toIndentedString(businessAttribute)).append("\n");
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

