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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = DirectedEdge.DirectedEdgeBuilderImpl.class)
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
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DirectedEdge( DirectedEdgeBuilder<?, ?> pBuilder ) {
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
  public static DirectedEdgeBuilder<?, ?> builder( ) {
    return new DirectedEdgeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class DirectedEdge.
   *
   *
   * @param pEnd Value to which {@link #end} should be set.
   *
   * @param pLink Value to which {@link #link} should be set.
   *
   * @return {@link DirectedEdge}
   */
  public static DirectedEdge of( Stop pEnd, String pLink ) {
    var lBuilder = DirectedEdge.builder();
    lBuilder.setEnd(pEnd);
    lBuilder.setLink(pLink);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DirectedEdge</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DirectedEdgeBuilder<T extends DirectedEdge, B extends DirectedEdgeBuilder<T, B>> {
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
     * Use {@link DirectedEdgeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected DirectedEdgeBuilder( ) {
    }

    /**
     * Use {@link DirectedEdgeBuilder#builder(DirectedEdge)} instead of private constructor to create new builder.
     */
    protected DirectedEdgeBuilder( DirectedEdge pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setStart(pObject.start);
        this.setEnd(pObject.end);
        this.setLink(pObject.link);
      }
    }

    /**
     * Method sets association {@link #start}.<br/>
     *
     * @param pStart Value to which {@link #start} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setStart( Stop pStart ) {
      start = pStart;
      return this.self();
    }

    /**
     * Method sets association {@link #end}.<br/>
     *
     * @param pEnd Value to which {@link #end} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setEnd( @MyNotNullProperty Stop pEnd ) {
      end = pEnd;
      return this.self();
    }

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLink( @MyNotNullProperty String pLink ) {
      // Assign value to attribute
      link = pLink;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class DirectedEdge. The object will be initialized with the values of the
     * builder.
     *
     * @return DirectedEdge Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DirectedEdgeBuilderImpl extends DirectedEdgeBuilder<DirectedEdge, DirectedEdgeBuilderImpl> {
    protected DirectedEdgeBuilderImpl( ) {
    }

    protected DirectedEdgeBuilderImpl( DirectedEdge pObject ) {
      super(pObject);
    }

    @Override
    protected DirectedEdgeBuilderImpl self( ) {
      return this;
    }

    @Override
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
  public DirectedEdgeBuilder<?, ?> toBuilder( ) {
    return new DirectedEdgeBuilderImpl(this);
  }
}