/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Problem.ProblemBuilderImpl.class)
public class Problem {
  /**
   * Constant for the name of attribute "title".
   */
  public static final String TITLE = "title";

  /**
   * Constant for the name of attribute "status".
   */
  public static final String STATUS = "status";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "detail".
   */
  public static final String DETAIL = "detail";

  /**
   * Constant for the name of attribute "instance".
   */
  public static final String INSTANCE = "instance";

  @NotNull
  private final String title;

  @NotNull
  public final int status;

  @NotNull
  private final String type;

  private final String detail;

  private final String instance;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Problem( ProblemBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    title = pBuilder.title;
    status = pBuilder.status;
    type = pBuilder.type;
    detail = pBuilder.detail;
    instance = pBuilder.instance;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Problem objects.
   */
  public static ProblemBuilder<?, ?> builder( ) {
    return new ProblemBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Problem.
   *
   *
   * @param pTitle Value to which {@link #title} should be set.
   *
   * @param pStatus Value to which {@link #status} should be set.
   *
   * @param pType Value to which {@link #type} should be set.
   *
   * @param pDetail Value to which {@link #detail} should be set.
   *
   * @param pInstance Value to which {@link #instance} should be set.
   *
   * @return {@link Problem}
   */
  public static Problem of( String pTitle, int pStatus, String pType, String pDetail, String pInstance ) {
    ProblemBuilder<?, ?> lBuilder = Problem.builder();
    lBuilder.setTitle(pTitle);
    lBuilder.setStatus(pStatus);
    lBuilder.setType(pType);
    lBuilder.setDetail(pDetail);
    lBuilder.setInstance(pInstance);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Problem</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ProblemBuilder<T extends Problem, B extends ProblemBuilder<T, B>> {
    @NotNull
    private String title;

    @NotNull
    private int status;

    @NotNull
    private String type;

    private String detail;

    private String instance;

    /**
     * Use {@link ProblemBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ProblemBuilder( ) {
    }

    /**
     * Use {@link ProblemBuilder#builder(Problem)} instead of private constructor to create new builder.
     */
    protected ProblemBuilder( Problem pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTitle(pObject.title);
        this.setStatus(pObject.status);
        this.setType(pObject.type);
        this.setDetail(pObject.detail);
        this.setInstance(pObject.instance);
      }
    }

    /**
     * Method sets attribute {@link #title}.<br/>
     *
     * @param pTitle Value to which {@link #title} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTitle( @MyNotNullProperty String pTitle ) {
      // Assign value to attribute
      title = pTitle;
      return this.self();
    }

    /**
     * Method sets attribute {@link #status}.<br/>
     *
     * @param pStatus Value to which {@link #status} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setStatus( int pStatus ) {
      // Assign value to attribute
      status = pStatus;
      return this.self();
    }

    /**
     * Method sets attribute {@link #type}.<br/>
     *
     * @param pType Value to which {@link #type} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setType( @MyNotNullProperty String pType ) {
      // Assign value to attribute
      type = pType;
      return this.self();
    }

    /**
     * Method sets attribute {@link #detail}.<br/>
     *
     * @param pDetail Value to which {@link #detail} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setDetail( @MyNotNullProperty String pDetail ) {
      // Assign value to attribute
      detail = pDetail;
      return this.self();
    }

    /**
     * Method sets attribute {@link #instance}.<br/>
     *
     * @param pInstance Value to which {@link #instance} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setInstance( @MyNotNullProperty String pInstance ) {
      // Assign value to attribute
      instance = pInstance;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Problem. The object will be initialized with the values of the builder.
     *
     * @return Problem Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ProblemBuilderImpl extends ProblemBuilder<Problem, ProblemBuilderImpl> {
    protected ProblemBuilderImpl( ) {
    }

    protected ProblemBuilderImpl( Problem pObject ) {
      super(pObject);
    }

    @Override
    protected ProblemBuilderImpl self( ) {
      return this;
    }

    @Override
    public Problem build( ) {
      Problem lObject = new Problem(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #title}.<br/>
   *
   * @return {@link String} Value to which {@link #title} is set.
   */
  @MyNotNullProperty
  public String getTitle( ) {
    return title;
  }

  /**
   * Method returns attribute {@link #status}.<br/>
   *
   * @return int Value to which {@link #status} is set.
   */
  public int getStatus( ) {
    return status;
  }

  /**
   * Method returns attribute {@link #type}.<br/>
   *
   * @return {@link String} Value to which {@link #type} is set.
   */
  @MyNotNullProperty
  public String getType( ) {
    return type;
  }

  /**
   * Method returns attribute {@link #detail}.<br/>
   *
   * @return {@link String} Value to which {@link #detail} is set.
   */
  @MyNotNullProperty
  public String getDetail( ) {
    return detail;
  }

  /**
   * Method returns attribute {@link #instance}.<br/>
   *
   * @return {@link String} Value to which {@link #instance} is set.
   */
  @MyNotNullProperty
  public String getInstance( ) {
    return instance;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(title);
    lResult = lPrime * lResult + status;
    lResult = lPrime * lResult + Objects.hashCode(type);
    lResult = lPrime * lResult + Objects.hashCode(detail);
    lResult = lPrime * lResult + Objects.hashCode(instance);
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
      Problem lOther = (Problem) pObject;
      lEquals = Objects.equals(title, lOther.title) && status == lOther.status && Objects.equals(type, lOther.type)
          && Objects.equals(detail, lOther.detail) && Objects.equals(instance, lOther.instance);
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
    lBuilder.append("title: ");
    lBuilder.append(title);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("status: ");
    lBuilder.append(status);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("type: ");
    lBuilder.append(type);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("detail: ");
    lBuilder.append(detail);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("instance: ");
    lBuilder.append(instance);
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
   * @return {@link Builder} New builder that can be used to create new Problem objects. The method never returns null.
   */
  public ProblemBuilder<?, ?> toBuilder( ) {
    return new ProblemBuilderImpl(this);
  }
}