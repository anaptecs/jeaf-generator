/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
/**
 * Just a simple comment.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public class DirectedEdge extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "start".
   */
  @JEAFCustomAnnotationTest
  public static final String START = "start";

  /**
   * Constant for the name of attribute "end".
   */
  @JEAFCustomAnnotationTest
  public static final String END = "end";

  /**
   * Constant for the name of attribute "link".
   */
  @JEAFCustomAnnotationTest
  public static final String LINK = "link";

  // "com.anaptecs.jeaf.junit.openapi.base.Stop"
  @ClassPropertyDeclaration
  /**
   * The start
   */
  @JEAFCustomAnnotationTest
  private Stop start;

  // "com.anaptecs.jeaf.junit.openapi.base.Stop"
  private int startXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.Stop"
  @ClassPropertyDeclaration
  /**
   * The end
   */
  @JEAFCustomAnnotationTest
  private Stop end;

  // "com.anaptecs.jeaf.junit.openapi.base.Stop"
  private int endXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  /**
   * Another simple comment.
   */
  @JEAFCustomAnnotationTest
  private String link;

  // "String"
  private int linkXYZ = 0;

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
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    startXYZ = pBuilder.startXYZ;
    end = pBuilder.end;
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    endXYZ = pBuilder.endXYZ;
    link = pBuilder.link;
    // "String"
    linkXYZ = pBuilder.linkXYZ;
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
   * Class implements builder to create a new instance of class <code>DirectedEdge</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    /**
     * The start
     */
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Stop start;

    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    private int startXYZ = 0;

    /**
     * The end
     */
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Stop end;

    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    private int endXYZ = 0;

    /**
     * Another simple comment.
     */
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String link;

    // "String"
    private int linkXYZ = 0;

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
    @JEAFCustomAnnotationTest
    public Builder setStart( Stop pStart ) {
      start = pStart;
      return this;
    }

    public Builder setStartXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Stop"
      startXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #end}.<br/>
     *
     * @param pEnd Value to which {@link #end} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setEnd( Stop pEnd ) {
      end = pEnd;
      return this;
    }

    public Builder setEndXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Stop"
      endXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #link}.<br/>
     *
     * @param pLink Value to which {@link #link} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setLink( String pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    public Builder setLinkXYZ( int value ) {
      // "String"
      linkXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
  public Stop getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   * The start
   *
   * @param pStart Value to which {@link #start} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setStart( Stop pStart ) {
    start = pStart;
  }

  /**
   * Method unsets {@link #start}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetStart( ) {
    start = null;
  }

  public int getStartXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    return startXYZ;
  }

  public void setStartXYZ( int value ) {
    startXYZ = value;
  }

  /**
   * Method returns association {@link #end}.<br/>
   * The end
   *
   * @return {@link Stop} Value to which {@link #end} is set.
   */
  @JEAFCustomAnnotationTest
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets association {@link #end}.<br/>
   * The end
   *
   * @param pEnd Value to which {@link #end} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setEnd( Stop pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets {@link #end}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetEnd( ) {
    end = null;
  }

  public int getEndXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Stop"
    return endXYZ;
  }

  public void setEndXYZ( int value ) {
    endXYZ = value;
  }

  /**
   * Method returns attribute {@link #link}.<br/>
   * Another simple comment.
   *
   * @return {@link String} Value to which {@link #link} is set.
   */
  @JEAFCustomAnnotationTest
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets attribute {@link #link}.<br/>
   * Another simple comment.
   *
   * @param pLink Value to which {@link #link} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setLink( String pLink ) {
    // Assign value to attribute
    link = pLink;
  }

  public int getLinkXYZ( ) {
    // "String"
    return linkXYZ;
  }

  public void setLinkXYZ( int value ) {
    linkXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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