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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * EnumTest
 */


public class EnumTest {
  @JsonProperty("property")
  private String property = null;

  @JsonProperty("enumRef")
  private String enumRef = null;

  public EnumTest property(String property) {
    this.property = property;
    return this;
  }

   /**
   * Get property
   * @return property
  **/
  @Schema(required = true, description = "")
  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public EnumTest enumRef(String enumRef) {
    this.enumRef = enumRef;
    return this;
  }

   /**
   * Get enumRef
   * @return enumRef
  **/
  @Schema(required = true, description = "")
  public String getEnumRef() {
    return enumRef;
  }

  public void setEnumRef(String enumRef) {
    this.enumRef = enumRef;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnumTest enumTest = (EnumTest) o;
    return Objects.equals(this.property, enumTest.property) &&
        Objects.equals(this.enumRef, enumTest.enumRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, enumRef);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumTest {\n");
    
    sb.append("    property: ").append(toIndentedString(property)).append("\n");
    sb.append("    enumRef: ").append(toIndentedString(enumRef)).append("\n");
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