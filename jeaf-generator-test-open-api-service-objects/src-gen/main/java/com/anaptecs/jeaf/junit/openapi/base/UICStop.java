/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@Valid
public class UICStop extends Stop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @Size(min = 32, max = 255)
  @NotNull
  private String uicCode;

  @DecimalMax(value = "32.777", inclusive = true)
  @DecimalMin(value = "1.025", inclusive = true)
  private int priority;

  @Min(value = 1000)
  @Max(value = 9999)
  private long code;

  @Positive
  private byte index2;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected UICStop( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICStop( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    uicCode = pBuilder.uicCode;
    priority = pBuilder.priority;
    code = pBuilder.code;
    index2 = pBuilder.index2;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new UICStop objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new UICStop objects. The method never returns null.
   */
  public static Builder builder( UICStop pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>UICStop</code>.
   */
  public static class Builder extends Stop.Builder {
    @Size(min = 32, max = 255)
    private String uicCode;

    @DecimalMax(value = "32.777", inclusive = true)
    @DecimalMin(value = "1.025", inclusive = true)
    private int priority;

    @Min(value = 1000)
    @Max(value = 9999)
    private long code;

    @Positive
    private byte index2;

    /**
     * Use {@link UICStop#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link UICStop#builder(UICStop)} instead of private constructor to create new builder.
     */
    protected Builder( UICStop pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        uicCode = pObject.uicCode;
        priority = pObject.priority;
        code = pObject.code;
        index2 = pObject.index2;
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method sets attribute {@link #index}.<br/>
     *
     * @param pIndex Value to which {@link #index} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setIndex( byte pIndex ) {
      // Call super class implementation.
      super.setIndex(pIndex);
      return this;
    }

    /**
     * Method sets association {@link #theSoftLink}.<br/>
     *
     * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setTheSoftLink( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLink(pTheSoftLink);
      return this;
    }

    /**
     * Method sets attribute {@link #uicCode}.<br/>
     *
     * @param pUicCode Value to which {@link #uicCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setUicCode( String pUicCode ) {
      // Assign value to attribute
      uicCode = pUicCode;
      return this;
    }

    /**
     * Method sets attribute {@link #priority}.<br/>
     *
     * @param pPriority Value to which {@link #priority} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPriority( int pPriority ) {
      // Assign value to attribute
      priority = pPriority;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( long pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets attribute {@link #index2}.<br/>
     *
     * @param pIndex2 Value to which {@link #index2} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIndex2( byte pIndex2 ) {
      // Assign value to attribute
      index2 = pIndex2;
      return this;
    }

    /**
     * Method creates a new instance of class UICStop. The object will be initialized with the values of the builder.
     *
     * @return UICStop Created object. The method never returns null.
     */
    public UICStop build( ) {
      return new UICStop(this);
    }

    /**
     * Method creates a new validated instance of class UICStop. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return UICStop Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public UICStop buildValidated( ) throws ConstraintViolationException {
      UICStop lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #uicCode}.<br/>
   *
   * @return {@link String} Value to which {@link #uicCode} is set.
   */
  public String getUicCode( ) {
    return uicCode;
  }

  /**
   * Method sets attribute {@link #uicCode}.<br/>
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   */
  public void setUicCode( String pUicCode ) {
    // Assign value to attribute
    uicCode = pUicCode;
  }

  /**
   * Method returns attribute {@link #priority}.<br/>
   *
   * @return int Value to which {@link #priority} is set.
   */
  public int getPriority( ) {
    return priority;
  }

  /**
   * Method sets attribute {@link #priority}.<br/>
   *
   * @param pPriority Value to which {@link #priority} should be set.
   */
  public void setPriority( int pPriority ) {
    // Assign value to attribute
    priority = pPriority;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return long Value to which {@link #code} is set.
   */
  public long getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns attribute {@link #index2}.<br/>
   *
   * @return byte Value to which {@link #index2} is set.
   */
  public byte getIndex2( ) {
    return index2;
  }

  /**
   * Method sets attribute {@link #index2}.<br/>
   *
   * @param pIndex2 Value to which {@link #index2} should be set.
   */
  public void setIndex2( byte pIndex2 ) {
    // Assign value to attribute
    index2 = pIndex2;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("uicCode: ");
    lBuilder.append(uicCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("priority: ");
    lBuilder.append(priority);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("index2: ");
    lBuilder.append(index2);
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
