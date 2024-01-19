/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class Response<T> implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "messages".
   */
  public static final String MESSAGES = "messages";

  /**
   * Constant for the name of attribute "data".
   */
  public static final String DATA = "data";

  private List<Message> messages;

  private T data;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Response( ) {
    messages = new ArrayList<Message>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Response( Builder<T> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.messages != null) {
      messages = pBuilder.messages;
    }
    else {
      messages = new ArrayList<Message>();
    }
    data = pBuilder.data;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Response objects.
   */
  public static <T> Builder<T> builder( ) {
    return new Builder<T>();
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Response objects.
   */
  public static <T> Builder<T> builder( Class<T> pClass ) {
    return new Builder<T>();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Response objects. The method never returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static <T> Builder<T> builder( Response<T> pObject ) {
    return new Builder<T>(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>Response</code>.
   */
  public static class Builder<T> {
    private List<Message> messages;

    private T data;

    /**
     * Use {@link Response#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Response#builder(Response)} instead of private constructor to create new builder.
     */
    protected Builder( Response<T> pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMessages(pObject.messages);
        this.setData(pObject.data);
      }
    }

    /**
     * Method sets association {@link #messages}.<br/>
     *
     * @param pMessages Collection to which {@link #messages} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T> setMessages( List<Message> pMessages ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMessages != null) {
        messages = new ArrayList<Message>(pMessages);
      }
      else {
        messages = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #messages}.<br/>
     *
     * @param pMessages Array of objects that should be added to {@link #messages}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder<T> addToMessages( Message... pMessages ) {
      if (pMessages != null) {
        if (messages == null) {
          messages = new ArrayList<Message>();
        }
        messages.addAll(Arrays.asList(pMessages));
      }
      return this;
    }

    /**
     * Method sets association {@link #data}.<br/>
     *
     * @param pData Value to which {@link #data} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder<T> setData( T pData ) {
      data = pData;
      return this;
    }

    /**
     * Method creates a new instance of class Response. The object will be initialized with the values of the builder.
     *
     * @return Response Created object. The method never returns null.
     */
    public Response<T> build( ) {
      Response<T> lObject = new Response<T>(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class Response. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Response Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Response<T> buildValidated( ) throws ConstraintViolationException {
      Response<T> lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #messages}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #messages} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Message> getMessages( ) {
    // Return all Message objects as unmodifiable collection.
    return Collections.unmodifiableList(messages);
  }

  /**
   * Method adds the passed object to {@link #messages}.
   *
   * @param pMessages Object that should be added to {@link #messages}. The parameter must not be null.
   */
  public void addToMessages( Message pMessages ) {
    // Check parameter "pMessages" for invalid value null.
    Check.checkInvalidParameterNull(pMessages, "pMessages");
    // Add passed object to collection of associated Message objects.
    messages.add(pMessages);
  }

  /**
   * Method adds all passed objects to {@link #messages}.
   *
   * @param pMessages Collection with all objects that should be added to {@link #messages}. The parameter must not be
   * null.
   */
  public void addToMessages( Collection<Message> pMessages ) {
    // Check parameter "pMessages" for invalid value null.
    Check.checkInvalidParameterNull(pMessages, "pMessages");
    // Add all passed objects.
    for (Message lNextObject : pMessages) {
      this.addToMessages(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #messages}.<br/>
   *
   * @param pMessages Object that should be removed from {@link #messages}. The parameter must not be null.
   */
  public void removeFromMessages( Message pMessages ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMessages, "pMessages");
    // Remove passed object from collection of associated Message objects.
    messages.remove(pMessages);
  }

  /**
   * Method removes all objects from {@link #messages}.
   */
  public void clearMessages( ) {
    // Remove all objects from association "messages".
    messages.clear();
  }

  /**
   * Method returns association {@link #data}.<br/>
   *
   * @return {@link com.anaptecs.jeaf.junit.rest.generics.T} Value to which {@link #data} is set.
   */
  public T getData( ) {
    return data;
  }

  /**
   * Method sets association {@link #data}.<br/>
   *
   * @param pData Value to which {@link #data} should be set.
   */
  public void setData( T pData ) {
    data = pData;
  }

  /**
   * Method unsets {@link #data}.
   */
  public final void unsetData( ) {
    data = null;
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
   * @return {@link Builder} New builder that can be used to create new Response objects. The method never returns null.
   */
  public Builder<T> toBuilder( ) {
    return new Builder<T>(this);
  }
}
