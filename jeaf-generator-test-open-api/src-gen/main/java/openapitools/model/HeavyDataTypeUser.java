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
 * HeavyDataTypeUser
 */
@JsonPropertyOrder({
  HeavyDataTypeUser.JSON_PROPERTY_BOOLEAN_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_BYTE_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_SHORT_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_INTEGER_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_FLOAT_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_DOUBLE_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_BIG_INEGER_CODE,
  HeavyDataTypeUser.JSON_PROPERTY_BIG_DECIMAL_CODE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public class HeavyDataTypeUser {
  public static final String JSON_PROPERTY_BOOLEAN_CODE = "booleanCode";
  @javax.annotation.Nonnull
  private Boolean booleanCode;

  public static final String JSON_PROPERTY_BYTE_CODE = "byteCode";
  @javax.annotation.Nonnull
  private Integer byteCode;

  public static final String JSON_PROPERTY_SHORT_CODE = "shortCode";
  @javax.annotation.Nonnull
  private Integer shortCode;

  public static final String JSON_PROPERTY_INTEGER_CODE = "integerCode";
  @javax.annotation.Nonnull
  private Integer integerCode;

  public static final String JSON_PROPERTY_FLOAT_CODE = "floatCode";
  @javax.annotation.Nonnull
  private Float floatCode;

  public static final String JSON_PROPERTY_DOUBLE_CODE = "doubleCode";
  @javax.annotation.Nonnull
  private Double doubleCode;

  public static final String JSON_PROPERTY_BIG_INEGER_CODE = "bigInegerCode";
  @javax.annotation.Nonnull
  private Long bigInegerCode;

  public static final String JSON_PROPERTY_BIG_DECIMAL_CODE = "bigDecimalCode";
  @javax.annotation.Nonnull
  private Double bigDecimalCode;

  public HeavyDataTypeUser() { 
  }

  public HeavyDataTypeUser booleanCode(@javax.annotation.Nonnull Boolean booleanCode) {
    this.booleanCode = booleanCode;
    return this;
  }

  /**
   * Get booleanCode
   * @return booleanCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BOOLEAN_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getBooleanCode() {
    return booleanCode;
  }


  @JsonProperty(JSON_PROPERTY_BOOLEAN_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBooleanCode(@javax.annotation.Nonnull Boolean booleanCode) {
    this.booleanCode = booleanCode;
  }


  public HeavyDataTypeUser byteCode(@javax.annotation.Nonnull Integer byteCode) {
    this.byteCode = byteCode;
    return this;
  }

  /**
   * Get byteCode
   * @return byteCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BYTE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getByteCode() {
    return byteCode;
  }


  @JsonProperty(JSON_PROPERTY_BYTE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setByteCode(@javax.annotation.Nonnull Integer byteCode) {
    this.byteCode = byteCode;
  }


  public HeavyDataTypeUser shortCode(@javax.annotation.Nonnull Integer shortCode) {
    this.shortCode = shortCode;
    return this;
  }

  /**
   * Get shortCode
   * maximum: 4711
   * @return shortCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SHORT_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getShortCode() {
    return shortCode;
  }


  @JsonProperty(JSON_PROPERTY_SHORT_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setShortCode(@javax.annotation.Nonnull Integer shortCode) {
    this.shortCode = shortCode;
  }


  public HeavyDataTypeUser integerCode(@javax.annotation.Nonnull Integer integerCode) {
    this.integerCode = integerCode;
    return this;
  }

  /**
   * Get integerCode
   * minimum: 1234
   * @return integerCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_INTEGER_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getIntegerCode() {
    return integerCode;
  }


  @JsonProperty(JSON_PROPERTY_INTEGER_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntegerCode(@javax.annotation.Nonnull Integer integerCode) {
    this.integerCode = integerCode;
  }


  public HeavyDataTypeUser floatCode(@javax.annotation.Nonnull Float floatCode) {
    this.floatCode = floatCode;
    return this;
  }

  /**
   * Get floatCode
   * @return floatCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FLOAT_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Float getFloatCode() {
    return floatCode;
  }


  @JsonProperty(JSON_PROPERTY_FLOAT_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFloatCode(@javax.annotation.Nonnull Float floatCode) {
    this.floatCode = floatCode;
  }


  public HeavyDataTypeUser doubleCode(@javax.annotation.Nonnull Double doubleCode) {
    this.doubleCode = doubleCode;
    return this;
  }

  /**
   * Get doubleCode
   * @return doubleCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DOUBLE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getDoubleCode() {
    return doubleCode;
  }


  @JsonProperty(JSON_PROPERTY_DOUBLE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDoubleCode(@javax.annotation.Nonnull Double doubleCode) {
    this.doubleCode = doubleCode;
  }


  public HeavyDataTypeUser bigInegerCode(@javax.annotation.Nonnull Long bigInegerCode) {
    this.bigInegerCode = bigInegerCode;
    return this;
  }

  /**
   * Get bigInegerCode
   * maximum: 4711
   * @return bigInegerCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BIG_INEGER_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getBigInegerCode() {
    return bigInegerCode;
  }


  @JsonProperty(JSON_PROPERTY_BIG_INEGER_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBigInegerCode(@javax.annotation.Nonnull Long bigInegerCode) {
    this.bigInegerCode = bigInegerCode;
  }


  public HeavyDataTypeUser bigDecimalCode(@javax.annotation.Nonnull Double bigDecimalCode) {
    this.bigDecimalCode = bigDecimalCode;
    return this;
  }

  /**
   * Get bigDecimalCode
   * @return bigDecimalCode
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BIG_DECIMAL_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getBigDecimalCode() {
    return bigDecimalCode;
  }


  @JsonProperty(JSON_PROPERTY_BIG_DECIMAL_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBigDecimalCode(@javax.annotation.Nonnull Double bigDecimalCode) {
    this.bigDecimalCode = bigDecimalCode;
  }


  /**
   * Return true if this HeavyDataTypeUser object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HeavyDataTypeUser heavyDataTypeUser = (HeavyDataTypeUser) o;
    return Objects.equals(this.booleanCode, heavyDataTypeUser.booleanCode) &&
        Objects.equals(this.byteCode, heavyDataTypeUser.byteCode) &&
        Objects.equals(this.shortCode, heavyDataTypeUser.shortCode) &&
        Objects.equals(this.integerCode, heavyDataTypeUser.integerCode) &&
        Objects.equals(this.floatCode, heavyDataTypeUser.floatCode) &&
        Objects.equals(this.doubleCode, heavyDataTypeUser.doubleCode) &&
        Objects.equals(this.bigInegerCode, heavyDataTypeUser.bigInegerCode) &&
        Objects.equals(this.bigDecimalCode, heavyDataTypeUser.bigDecimalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booleanCode, byteCode, shortCode, integerCode, floatCode, doubleCode, bigInegerCode, bigDecimalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HeavyDataTypeUser {\n");
    sb.append("    booleanCode: ").append(toIndentedString(booleanCode)).append("\n");
    sb.append("    byteCode: ").append(toIndentedString(byteCode)).append("\n");
    sb.append("    shortCode: ").append(toIndentedString(shortCode)).append("\n");
    sb.append("    integerCode: ").append(toIndentedString(integerCode)).append("\n");
    sb.append("    floatCode: ").append(toIndentedString(floatCode)).append("\n");
    sb.append("    doubleCode: ").append(toIndentedString(doubleCode)).append("\n");
    sb.append("    bigInegerCode: ").append(toIndentedString(bigInegerCode)).append("\n");
    sb.append("    bigDecimalCode: ").append(toIndentedString(bigDecimalCode)).append("\n");
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

