/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
  /**
   * Constant for the name of attribute "text".
   */
  public static final String TEXT = "text";

  private String text;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Message( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Message( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    text = pBuilder.text;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Message objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Message objects. The method never returns null.
   */
  public static Builder builder( Message pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class Message.
   *
   *
   * @param pText Value to which {@link #text} should be set.
   *
   * @return {@link Message}
   */
  public static Message of( String pText ) {
    Message.Builder lBuilder = Message.builder();
    lBuilder.setText(pText);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Message</code>.
   */
  public static class Builder {
    private String text;

    /**
     * Use {@link Message#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Message#builder(Message)} instead of private constructor to create new builder.
     */
    protected Builder( Message pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        text = pObject.text;
      }
    }

    /**
     * Method sets attribute {@link #text}.<br/>
     *
     * @param pText Value to which {@link #text} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setText( String pText ) {
      // Assign value to attribute
      text = pText;
      return this;
    }

    /**
     * Method creates a new instance of class Message. The object will be initialized with the values of the builder.
     *
     * @return Message Created object. The method never returns null.
     */
    public Message build( ) {
      return new Message(this);
    }

    /**
     * Method creates a new validated instance of class Message. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Message Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Message buildValidated( ) throws ConstraintViolationException {
      Message lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #text}.<br/>
   *
   * @return {@link String} Value to which {@link #text} is set.
   */
  public String getText( ) {
    return text;
  }

  /**
   * Method sets attribute {@link #text}.<br/>
   *
   * @param pText Value to which {@link #text} should be set.
   */
  public void setText( String pText ) {
    // Assign value to attribute
    text = pText;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(text);
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
      Message lOther = (Message) pObject;
      lEquals = Objects.equals(text, lOther.text);
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
    lBuilder.append("text: ");
    lBuilder.append(text);
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
}
