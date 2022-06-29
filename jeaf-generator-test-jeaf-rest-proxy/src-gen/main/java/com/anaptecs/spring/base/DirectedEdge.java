/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectedEdge implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

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

  /**
   * 
   */
  @JsonProperty("previousName")
  private String link;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected DirectedEdge( ) {
    // Nothing to do.
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
   * Class implements builder to create a new instance of class DirectedEdge. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
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
     * 
     */
    private String link;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(DirectedEdge)} instead of private constructor to create new builder.
     */
    protected Builder( DirectedEdge pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        start = pObject.start;
        end = pObject.end;
        link = pObject.link;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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
     * Method sets the association "start". The start
     * 
     * @param pStart Stop to which the association "start" should be set.
     */
    public Builder setStart( Stop pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets the association "end". The end
     * 
     * @param pEnd Stop to which the association "end" should be set.
     */
    public Builder setEnd( Stop pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets the attribute "link".
     * 
     * @param pLink Value to which the attribute "link" should be set.
     */
    public Builder setLink( String pLink ) {
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
      DirectedEdge lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "start". The start
   *
   * @return Stop Stop to which the association "start" is set.
   */
  public Stop getStart( ) {
    return start;
  }

  /**
   * Method sets the association "start". The start
   * 
   * @param pStart Stop to which the association "start" should be set.
   */
  public void setStart( Stop pStart ) {
    start = pStart;
  }

  /**
   * Method unsets the association "start". The start
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns the association "end". The end
   *
   * @return Stop Stop to which the association "end" is set.
   */
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets the association "end". The end
   * 
   * @param pEnd Stop to which the association "end" should be set.
   */
  public void setEnd( Stop pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets the association "end". The end
   */
  public final void unsetEnd( ) {
    end = null;
  }

  /**
   * Method returns the attribute "link".
   * 
   * 
   * @return String Value to which the attribute "link" is set.
   */
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets the attribute "link".
   * 
   * 
   * @param pLink Value to which the attribute "link" should be set.
   */
  public void setLink( String pLink ) {
    // Assign value to attribute
    link = pLink;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "link", "" + link));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
