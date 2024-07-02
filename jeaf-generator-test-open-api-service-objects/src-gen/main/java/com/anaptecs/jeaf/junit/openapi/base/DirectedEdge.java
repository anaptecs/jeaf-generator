/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Just a simple comment.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class DirectedEdge implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The start
   */
  private Stop start;

  /**
   * The end
   */
  @NotNull
  private Stop end;

  /**
   * Another simple comment.
   */
  @JsonProperty("previousName")
  @NotNull
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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
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
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.DirectedEdge}
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

    /**
     * Another simple comment.
     */
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
    public Builder setEnd( @MyNotNull Stop pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLink( @MyNotNull String pLink ) {
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
      return new DirectedEdge(this);
    }

    /**
     * Method creates a new validated instance of class DirectedEdge. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return DirectedEdge Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DirectedEdge buildValidated( ) throws ConstraintViolationException {
      DirectedEdge lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
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
  @MyNotNull
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets association {@link #end}.<br/>
   * The end
   *
   * @param pEnd Value to which {@link #end} should be set.
   */
  public void setEnd( @MyNotNull Stop pEnd ) {
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
   * Another simple comment.
   *
   * @return {@link String} Value to which {@link #link} is set.
   */
  @MyNotNull
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets attribute {@link #link}.<br/>
   * Another simple comment.
   *
   * @param pLink Value to which {@link #link} should be set.
   */
  public void setLink( @MyNotNull String pLink ) {
    // Assign value to attribute
    link = pLink;
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
