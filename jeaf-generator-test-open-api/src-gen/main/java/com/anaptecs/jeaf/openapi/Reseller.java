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
import com.anaptecs.jeaf.openapi.Channel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Reseller
 */


public class Reseller {
  @JsonProperty("channels")
  private List<Channel> channels = new ArrayList<>();

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("language")
  private String language = null;

  public Reseller channels(List<Channel> channels) {
    this.channels = channels;
    return this;
  }

  public Reseller addChannelsItem(Channel channelsItem) {
    this.channels.add(channelsItem);
    return this;
  }

   /**
   * Get channels
   * @return channels
  **/
  @Schema(required = true, description = "")
  public List<Channel> getChannels() {
    return channels;
  }

  public void setChannels(List<Channel> channels) {
    this.channels = channels;
  }

  public Reseller name(String name) {
    this.name = name;
    return this;
  }

   /**
   *  &lt;br&gt;&lt;br&gt; Breaking Change with 1.1: Maximum size will be increased. 
   * @return name
  **/
  @Schema(required = true, description = " <br><br> Breaking Change with 1.1: Maximum size will be increased. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Reseller language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @Schema(required = true, description = "")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reseller reseller = (Reseller) o;
    return Objects.equals(this.channels, reseller.channels) &&
        Objects.equals(this.name, reseller.name) &&
        Objects.equals(this.language, reseller.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channels, name, language);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reseller {\n");
    
    sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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
