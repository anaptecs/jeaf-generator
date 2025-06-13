/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Generic error response type that is used in all cases.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilderImpl.class)
public class ErrorResponse {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ErrorResponse( ErrorResponseBuilder<?, ?> pBuilder ) {
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ErrorResponse objects.
   */
  public static ErrorResponseBuilder<?, ?> builder( ) {
    return new ErrorResponseBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ErrorResponse.
   *
   *
   * @return {@link ErrorResponse}
   */
  public static ErrorResponse of( ) {
    ErrorResponseBuilder<?, ?> lBuilder = ErrorResponse.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ErrorResponse</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ErrorResponseBuilder<T extends ErrorResponse, B extends ErrorResponseBuilder<T, B>> {
    /**
     * Use {@link ErrorResponseBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ErrorResponseBuilder( ) {
    }

    /**
     * Use {@link ErrorResponseBuilder#builder(ErrorResponse)} instead of private constructor to create new builder.
     */
    protected ErrorResponseBuilder( ErrorResponse pObject ) {
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ErrorResponse. The object will be initialized with the values of the
     * builder.
     *
     * @return ErrorResponse Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ErrorResponseBuilderImpl extends ErrorResponseBuilder<ErrorResponse, ErrorResponseBuilderImpl> {
    protected ErrorResponseBuilderImpl( ) {
    }

    protected ErrorResponseBuilderImpl( ErrorResponse pObject ) {
      super(pObject);
    }

    @Override
    protected ErrorResponseBuilderImpl self( ) {
      return this;
    }

    @Override
    public ErrorResponse build( ) {
      ErrorResponse lObject = new ErrorResponse(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return 1;
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
      lEquals = true;
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
   * @return {@link Builder} New builder that can be used to create new ErrorResponse objects. The method never returns
   * null.
   */
  public ErrorResponseBuilder<?, ?> toBuilder( ) {
    return new ErrorResponseBuilderImpl(this);
  }
}