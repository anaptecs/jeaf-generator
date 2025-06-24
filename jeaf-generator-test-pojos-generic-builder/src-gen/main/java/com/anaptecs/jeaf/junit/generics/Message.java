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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = Message.MessageBuilderImpl.class)
public class Message {
  /**
   * Constant for the name of attribute "text".
   */
  public static final String TEXT = "text";

  private final String text;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Message( MessageBuilder<?, ?> pBuilder ) {
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
  public static MessageBuilder<?, ?> builder( ) {
    return new MessageBuilderImpl();
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
    var lBuilder = Message.builder();
    lBuilder.setText(pText);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Message</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class MessageBuilder<T extends Message, B extends MessageBuilder<T, B>> {
    private String text;

    /**
     * Use {@link MessageBuilder#builder()} instead of private constructor to create new builder.
     */
    protected MessageBuilder( ) {
    }

    /**
     * Use {@link MessageBuilder#builder(Message)} instead of private constructor to create new builder.
     */
    protected MessageBuilder( Message pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setText(pObject.text);
      }
    }

    /**
     * Method sets attribute {@link #text}.<br/>
     *
     * @param pText Value to which {@link #text} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setText( String pText ) {
      // Assign value to attribute
      text = pText;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Message. The object will be initialized with the values of the builder.
     *
     * @return Message Created object. The method never returns null.
     */
    public abstract T build( );

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

  static final class MessageBuilderImpl extends MessageBuilder<Message, MessageBuilderImpl> {
    protected MessageBuilderImpl( ) {
    }

    protected MessageBuilderImpl( Message pObject ) {
      super(pObject);
    }

    @Override
    protected MessageBuilderImpl self( ) {
      return this;
    }

    @Override
    public Message build( ) {
      return new Message(this);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Message objects. The method never returns null.
   */
  public MessageBuilder<?, ?> toBuilder( ) {
    return new MessageBuilderImpl(this);
  }
}