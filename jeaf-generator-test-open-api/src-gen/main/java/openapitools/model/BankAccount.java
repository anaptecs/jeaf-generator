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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * BankAccount
 */
@JsonPropertyOrder({
  BankAccount.JSON_PROPERTY_IBAN
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BankAccount {
  public static final String JSON_PROPERTY_IBAN = "iban";
  private String iban;

  public BankAccount() { 
  }

  public BankAccount iban(String iban) {
    this.iban = iban;
    return this;
  }

   /**
   * Get iban
   * @return iban
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IBAN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIban() {
    return iban;
  }


  @JsonProperty(JSON_PROPERTY_IBAN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIban(String iban) {
    this.iban = iban;
  }


  /**
   * Return true if this BankAccount object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.iban, bankAccount.iban);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccount {\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
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
