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
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import openapitools.model.ParentClass;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * ChildBAllOf
 */
@JsonPropertyOrder({
  ChildBAllOf.JSON_PROPERTY_CHILD_B_ATTRIBUTE,
  ChildBAllOf.JSON_PROPERTY_COMPOSITION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ChildBAllOf {
  public static final String JSON_PROPERTY_CHILD_B_ATTRIBUTE = "childBAttribute";
  private Boolean childBAttribute;

  public static final String JSON_PROPERTY_COMPOSITION = "composition";
  private List<ParentClass> composition = null;

  public ChildBAllOf() { 
  }

  public ChildBAllOf childBAttribute(Boolean childBAttribute) {
    this.childBAttribute = childBAttribute;
    return this;
  }

   /**
   * A child attribute
   * @return childBAttribute
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A child attribute")
  @JsonProperty(JSON_PROPERTY_CHILD_B_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getChildBAttribute() {
    return childBAttribute;
  }


  @JsonProperty(JSON_PROPERTY_CHILD_B_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setChildBAttribute(Boolean childBAttribute) {
    this.childBAttribute = childBAttribute;
  }


  public ChildBAllOf composition(List<ParentClass> composition) {
    this.composition = composition;
    return this;
  }

  public ChildBAllOf addCompositionItem(ParentClass compositionItem) {
    if (this.composition == null) {
      this.composition = new ArrayList<>();
    }
    this.composition.add(compositionItem);
    return this;
  }

   /**
   * the composition
   * @return composition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the composition")
  @JsonProperty(JSON_PROPERTY_COMPOSITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ParentClass> getComposition() {
    return composition;
  }


  @JsonProperty(JSON_PROPERTY_COMPOSITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComposition(List<ParentClass> composition) {
    this.composition = composition;
  }


  /**
   * Return true if this ChildB_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildBAllOf childBAllOf = (ChildBAllOf) o;
    return Objects.equals(this.childBAttribute, childBAllOf.childBAttribute) &&
        Objects.equals(this.composition, childBAllOf.composition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childBAttribute, composition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildBAllOf {\n");
    sb.append("    childBAttribute: ").append(toIndentedString(childBAttribute)).append("\n");
    sb.append("    composition: ").append(toIndentedString(composition)).append("\n");
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
