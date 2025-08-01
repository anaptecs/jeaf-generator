/*
 * Product Services
 * This component represents the OpenAPI interface of the accounting service.  Dear Developers, please be aware that multi line comments can also be used. 
 *
 * OpenAPI spec version: 1.26.6-SNAPSHOT
 * Contact: jeaf@anaptecs.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.anaptecs.jeaf.openapi;

import java.util.Objects;
import java.util.Arrays;
import com.anaptecs.jeaf.openapi.Message;
import com.anaptecs.jeaf.openapi.PagedBusinessObjects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * PagedBusinessObjectsResponse
 */


public class PagedBusinessObjectsResponse {
  @JsonProperty("messages")
  private List<Message> messages = null;

  @JsonProperty("data")
  private PagedBusinessObjects data = null;

  public PagedBusinessObjectsResponse messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public PagedBusinessObjectsResponse addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Get messages
   * @return messages
  **/
  @Schema(description = "")
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public PagedBusinessObjectsResponse data(PagedBusinessObjects data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public PagedBusinessObjects getData() {
    return data;
  }

  public void setData(PagedBusinessObjects data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagedBusinessObjectsResponse pagedBusinessObjectsResponse = (PagedBusinessObjectsResponse) o;
    return Objects.equals(this.messages, pagedBusinessObjectsResponse.messages) &&
        Objects.equals(this.data, pagedBusinessObjectsResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedBusinessObjectsResponse {\n");
    
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
