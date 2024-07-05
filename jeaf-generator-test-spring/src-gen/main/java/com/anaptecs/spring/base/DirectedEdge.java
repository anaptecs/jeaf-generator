/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class DirectedEdge {
  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  /**
   * Constant for the name of attribute "end".
   */
  public static final String END = "end";

  /**
   * Constant for the name of attribute "link".
   */
  public static final String LINK = "link";

  /**
   * The start
   */
  private Stop start;

  /**
   * The end
   */
  private Stop end;

  @JsonProperty("previousName")
  private String link;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DirectedEdge( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DirectedEdge( Builder pBuilder ) {
    // Read attribute values from builder.
    start = pBuilder.start;
    end = pBuilder.end;
    link = pBuilder.link;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DirectedEdge objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DirectedEdge.
   *
   *
   * @param pEnd Value to which {@link #end} should be set.
   *
   * @param pLink Value to which {@link #link} should be set.
   *
   * @return {@link com.anaptecs.spring.base.DirectedEdge}
   */
  public static DirectedEdge of( Stop pEnd, String pLink ) {
    DirectedEdge.Builder lBuilder = DirectedEdge.builder();
    lBuilder.setEnd(pEnd);
    lBuilder.setLink(pLink);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DirectedEdge</code>.
   */
  public static class Builder {
    /**
     * The start
     */
    private Stop start;

    /**
     * The end
     */
    private Stop end;

    private String link;

    /**
     * Use {@link DirectedEdge#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DirectedEdge#builder(DirectedEdge)} instead of private constructor to create new builder.
     */
    protected Builder( DirectedEdge pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStart(pObject.start);
        this.setEnd(pObject.end);
        this.setLink(pObject.link);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new DirectedEdge objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new DirectedEdge objects. The method never returns
     * null.
     */
    public static Builder newBuilder( DirectedEdge pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets association {@link #start}.<br/>
     *
     * @param pStart Value to which {@link #start} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStart( Stop pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets association {@link #end}.<br/>
     *
     * @param pEnd Value to which {@link #end} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setEnd( @MyNotNullProperty Stop pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLink( @MyNotNullProperty String pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    /**
     * Method creates a new instance of class DirectedEdge. The object will be initialized with the values of the
     * builder.
     *
     * @return DirectedEdge Created object. The method never returns null.
     */
    public DirectedEdge build( ) {
      DirectedEdge lObject = new DirectedEdge(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #start}.<br/>
   * The start
   *
   * @return {@link Stop} Value to which {@link #start} is set.
   */
  public Stop getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   * The start
   *
   * @param pStart Value to which {@link #start} should be set.
   */
  public void setStart( Stop pStart ) {
    start = pStart;
  }

  /**
   * Method unsets {@link #start}.
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns association {@link #end}.<br/>
   * The end
   *
   * @return {@link Stop} Value to which {@link #end} is set.
   */
  @MyNotNullProperty
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets association {@link #end}.<br/>
   * The end
   *
   * @param pEnd Value to which {@link #end} should be set.
   */
  public void setEnd( @MyNotNullProperty Stop pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets {@link #end}.
   */
  public final void unsetEnd( ) {
    end = null;
  }

  /**
   * Method returns attribute {@link #link}.<br/>
   *
   * @return {@link String} Value to which {@link #link} is set.
   */
  @MyNotNullProperty
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets attribute {@link #link}.<br/>
   *
   * @param pLink Value to which {@link #link} should be set.
   */
  public void setLink( @MyNotNullProperty String pLink ) {
    // Assign value to attribute
    link = pLink;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(start);
    lResult = lPrime * lResult + Objects.hashCode(end);
    lResult = lPrime * lResult + Objects.hashCode(link);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      DirectedEdge lOther = (DirectedEdge) pObject;
      lEquals =
          Objects.equals(start, lOther.start) && Objects.equals(end, lOther.end) && Objects.equals(link, lOther.link);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("start: ");
    if (start != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(start.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("end: ");
    if (end != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(end.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("link: ");
    lBuilder.append(link);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new DirectedEdge objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
