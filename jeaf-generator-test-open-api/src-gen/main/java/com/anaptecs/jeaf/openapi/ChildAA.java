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
import com.anaptecs.jeaf.openapi.ChildA;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 *  &lt;br&gt;&lt;br&gt; Deprecated: Please do not use this class any longer. There are better alternatives but I do not tell you which ones. May be &#x60;java.lang.Nothing&#x60; (since: 0.5, removed with: 2.0) 
 */
@Schema(description = " <br><br> Deprecated: Please do not use this class any longer. There are better alternatives but I do not tell you which ones. May be `java.lang.Nothing` (since: 0.5, removed with: 2.0) ")

public class ChildAA extends ChildA {
  @JsonProperty("childAAAttribute")
  private Integer childAAAttribute = null;

  @JsonProperty("sizedArray")
  private List<Integer> sizedArray = null;

  @JsonProperty("requiredArray")
  private List<String> requiredArray = new ArrayList<>();

  @JsonProperty("bigIntegerCode")
  private Long bigIntegerCode = null;

  @JsonProperty("integerCode")
  private Integer integerCode = null;

  @JsonProperty("codes")
  private List<Integer> codes = null;

  public ChildAA childAAAttribute(Integer childAAAttribute) {
    this.childAAAttribute = childAAAttribute;
    return this;
  }

   /**
   * Multi line docs 
   * @return childAAAttribute
  **/
  @Schema(required = true, description = "Multi line docs ")
  public Integer getChildAAAttribute() {
    return childAAAttribute;
  }

  public void setChildAAAttribute(Integer childAAAttribute) {
    this.childAAAttribute = childAAAttribute;
  }

  public ChildAA sizedArray(List<Integer> sizedArray) {
    this.sizedArray = sizedArray;
    return this;
  }

  public ChildAA addSizedArrayItem(Integer sizedArrayItem) {
    if (this.sizedArray == null) {
      this.sizedArray = new ArrayList<>();
    }
    this.sizedArray.add(sizedArrayItem);
    return this;
  }

   /**
   * Get sizedArray
   * @return sizedArray
  **/
  @Schema(description = "")
  public List<Integer> getSizedArray() {
    return sizedArray;
  }

  public void setSizedArray(List<Integer> sizedArray) {
    this.sizedArray = sizedArray;
  }

  public ChildAA requiredArray(List<String> requiredArray) {
    this.requiredArray = requiredArray;
    return this;
  }

  public ChildAA addRequiredArrayItem(String requiredArrayItem) {
    this.requiredArray.add(requiredArrayItem);
    return this;
  }

   /**
   * Get requiredArray
   * @return requiredArray
  **/
  @Schema(required = true, description = "")
  public List<String> getRequiredArray() {
    return requiredArray;
  }

  public void setRequiredArray(List<String> requiredArray) {
    this.requiredArray = requiredArray;
  }

  public ChildAA bigIntegerCode(Long bigIntegerCode) {
    this.bigIntegerCode = bigIntegerCode;
    return this;
  }

   /**
   * Get bigIntegerCode
   * maximum: 4711
   * @return bigIntegerCode
  **/
  @Schema(required = true, description = "")
  public Long getBigIntegerCode() {
    return bigIntegerCode;
  }

  public void setBigIntegerCode(Long bigIntegerCode) {
    this.bigIntegerCode = bigIntegerCode;
  }

  public ChildAA integerCode(Integer integerCode) {
    this.integerCode = integerCode;
    return this;
  }

   /**
   * Get integerCode
   * @return integerCode
  **/
  @Schema(description = "")
  public Integer getIntegerCode() {
    return integerCode;
  }

  public void setIntegerCode(Integer integerCode) {
    this.integerCode = integerCode;
  }

  public ChildAA codes(List<Integer> codes) {
    this.codes = codes;
    return this;
  }

  public ChildAA addCodesItem(Integer codesItem) {
    if (this.codes == null) {
      this.codes = new ArrayList<>();
    }
    this.codes.add(codesItem);
    return this;
  }

   /**
   * Get codes
   * @return codes
  **/
  @Schema(description = "")
  public List<Integer> getCodes() {
    return codes;
  }

  public void setCodes(List<Integer> codes) {
    this.codes = codes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildAA childAA = (ChildAA) o;
    return Objects.equals(this.childAAAttribute, childAA.childAAAttribute) &&
        Objects.equals(this.sizedArray, childAA.sizedArray) &&
        Objects.equals(this.requiredArray, childAA.requiredArray) &&
        Objects.equals(this.bigIntegerCode, childAA.bigIntegerCode) &&
        Objects.equals(this.integerCode, childAA.integerCode) &&
        Objects.equals(this.codes, childAA.codes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childAAAttribute, sizedArray, requiredArray, bigIntegerCode, integerCode, codes, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildAA {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    childAAAttribute: ").append(toIndentedString(childAAAttribute)).append("\n");
    sb.append("    sizedArray: ").append(toIndentedString(sizedArray)).append("\n");
    sb.append("    requiredArray: ").append(toIndentedString(requiredArray)).append("\n");
    sb.append("    bigIntegerCode: ").append(toIndentedString(bigIntegerCode)).append("\n");
    sb.append("    integerCode: ").append(toIndentedString(integerCode)).append("\n");
    sb.append("    codes: ").append(toIndentedString(codes)).append("\n");
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
