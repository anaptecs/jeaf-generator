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
import java.util.Arrays;
import openapitools.model.PlaceRef;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * GeoPosition
 */
@JsonPropertyOrder({
  GeoPosition.JSON_PROPERTY_LONGITUDE,
  GeoPosition.JSON_PROPERTY_LATITUDE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
@JsonIgnoreProperties(
  value = "objectType", // ignore manually set objectType, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the objectType to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SwissGeoPosition.class, name = "SwissGeoPosition"),
})

public class GeoPosition extends PlaceRef {
  public static final String JSON_PROPERTY_LONGITUDE = "longitude";
  @javax.annotation.Nonnull
  private Integer longitude;

  public static final String JSON_PROPERTY_LATITUDE = "latitude";
  @javax.annotation.Nonnull
  private Integer latitude;

  public GeoPosition() { 
  }

  public GeoPosition longitude(@javax.annotation.Nonnull Integer longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getLongitude() {
    return longitude;
  }


  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLongitude(@javax.annotation.Nonnull Integer longitude) {
    this.longitude = longitude;
  }


  public GeoPosition latitude(@javax.annotation.Nonnull Integer latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getLatitude() {
    return latitude;
  }


  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLatitude(@javax.annotation.Nonnull Integer latitude) {
    this.latitude = latitude;
  }


  /**
   * Return true if this GeoPosition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoPosition geoPosition = (GeoPosition) o;
    return Objects.equals(this.longitude, geoPosition.longitude) &&
        Objects.equals(this.latitude, geoPosition.latitude) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(longitude, latitude, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoPosition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
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
    mappings.put("SwissGeoPosition", SwissGeoPosition.class);
    mappings.put("GeoPosition", GeoPosition.class);
    JSON.registerDiscriminator(GeoPosition.class, "objectType", mappings);
  }
}

