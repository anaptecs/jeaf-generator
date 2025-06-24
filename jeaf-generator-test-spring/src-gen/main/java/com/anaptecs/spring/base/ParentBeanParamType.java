/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class ParentBeanParamType {
  /**
   * Constant for the name of attribute "novaKey".
   */
  public static final String NOVAKEY = "novaKey";

  /**
   * Constant for the name of attribute "tkID".
   */
  public static final String TKID = "tkID";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>4711-0815</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> <code>novaKey</code>
   */
  private String novaKey;

  private String tkID;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>BOOKING_ID_999</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> <code>code</code>
   */
  private DoubleCode code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentBeanParamType( ParentBeanParamTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    novaKey = pBuilder.novaKey;
    tkID = pBuilder.tkID;
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects.
   */
  public static ParentBeanParamTypeBuilder<?, ?> builder( ) {
    return new ParentBeanParamTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ParentBeanParamType.
   *
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link com.anaptecs.spring.base.ParentBeanParamType}
   */
  public static ParentBeanParamType of( String pNovaKey, String pTkID, DoubleCode pCode ) {
    var lBuilder = ParentBeanParamType.builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentBeanParamType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ParentBeanParamTypeBuilder<T extends ParentBeanParamType, B extends ParentBeanParamTypeBuilder<T, B>> {
    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>4711-0815</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> <code>novaKey</code>
     */
    private String novaKey;

    private String tkID;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>BOOKING_ID_999</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> <code>code</code>
     */
    private DoubleCode code;

    /**
     * Use {@link ParentBeanParamTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ParentBeanParamTypeBuilder( ) {
    }

    /**
     * Use {@link ParentBeanParamTypeBuilder#builder(ParentBeanParamType)} instead of private constructor to create new
     * builder.
     */
    protected ParentBeanParamTypeBuilder( ParentBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setNovaKey(pObject.novaKey);
        this.setTkID(pObject.tkID);
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #novaKey}.<br/>
     *
     * @param pNovaKey Value to which {@link #novaKey} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setNovaKey( @MyNotNullProperty String pNovaKey ) {
      // Assign value to attribute
      novaKey = pNovaKey;
      return this.self();
    }

    /**
     * Method sets attribute {@link #tkID}.<br/>
     *
     * @param pTkID Value to which {@link #tkID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTkID( @MyNotNullProperty String pTkID ) {
      // Assign value to attribute
      tkID = pTkID;
      return this.self();
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setCode( @MyNotNullProperty DoubleCode pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ParentBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentBeanParamType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ParentBeanParamTypeBuilderImpl
      extends ParentBeanParamTypeBuilder<ParentBeanParamType, ParentBeanParamTypeBuilderImpl> {
    protected ParentBeanParamTypeBuilderImpl( ) {
    }

    protected ParentBeanParamTypeBuilderImpl( ParentBeanParamType pObject ) {
      super(pObject);
    }

    @Override
    protected ParentBeanParamTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public ParentBeanParamType build( ) {
      ParentBeanParamType lObject = new ParentBeanParamType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #novaKey}.<br/>
   *
   * @return {@link String} Value to which {@link #novaKey} is set.
   */
  @MyNotNullProperty
  public String getNovaKey( ) {
    return novaKey;
  }

  /**
   * Method sets attribute {@link #novaKey}.<br/>
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   */
  public void setNovaKey( @MyNotNullProperty String pNovaKey ) {
    // Assign value to attribute
    novaKey = pNovaKey;
  }

  /**
   * Method returns attribute {@link #tkID}.<br/>
   *
   * @return {@link String} Value to which {@link #tkID} is set.
   */
  @MyNotNullProperty
  public String getTkID( ) {
    return tkID;
  }

  /**
   * Method sets attribute {@link #tkID}.<br/>
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   */
  public void setTkID( @MyNotNullProperty String pTkID ) {
    // Assign value to attribute
    tkID = pTkID;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link DoubleCode} Value to which {@link #code} is set.
   */
  @MyNotNullProperty
  public DoubleCode getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( @MyNotNullProperty DoubleCode pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(novaKey);
    lResult = lPrime * lResult + Objects.hashCode(tkID);
    lResult = lPrime * lResult + Objects.hashCode(code);
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
      ParentBeanParamType lOther = (ParentBeanParamType) pObject;
      lEquals = Objects.equals(novaKey, lOther.novaKey) && Objects.equals(tkID, lOther.tkID)
          && Objects.equals(code, lOther.code);
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
    lBuilder.append("novaKey: ");
    lBuilder.append(novaKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("tkID: ");
    lBuilder.append(tkID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
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
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects. The method never
   * returns null.
   */
  public ParentBeanParamTypeBuilder<?, ?> toBuilder( ) {
    return new ParentBeanParamTypeBuilderImpl(this);
  }
}