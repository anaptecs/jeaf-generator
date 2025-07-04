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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import openapitools.model.Partner;
import openapitools.model.PostalAddress;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * Person
 */
@JsonPropertyOrder({
  Person.JSON_PROPERTY_SURNAME,
  Person.JSON_PROPERTY_FIRST_NAME
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
@JsonIgnoreProperties(
  value = "objectType", // ignore manually set objectType, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the objectType to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)

public class Person extends Partner {
  public static final String JSON_PROPERTY_SURNAME = "surname";
  @javax.annotation.Nonnull
  private String surname;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  @javax.annotation.Nonnull
  private String firstName;

  public Person() { 
  }

  public Person surname(@javax.annotation.Nonnull String surname) {
    this.surname = surname;
    return this;
  }

  /**
   *  &lt;br&gt;&lt;br&gt; Alternate Name: Vorname 
   * @return surname
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSurname() {
    return surname;
  }


  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSurname(@javax.annotation.Nonnull String surname) {
    this.surname = surname;
  }


  public Person firstName(@javax.annotation.Nonnull String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFirstName() {
    return firstName;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstName(@javax.annotation.Nonnull String firstName) {
    this.firstName = firstName;
  }


  /**
   * Return true if this Person object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.surname, person.surname) &&
        Objects.equals(this.firstName, person.firstName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surname, firstName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
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

  static {
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<>();
    mappings.put("Person", Person.class);
    JSON.registerDiscriminator(Person.class, "objectType", mappings);
  }
}

