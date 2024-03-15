/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * <p/>
 * <b>Alternate Name:</b> Haltestelle
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class UICStop extends Stop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "uicCode".
   */
  public static final String UICCODE = "uicCode";

  /**
   * Constant for the name of attribute "priority".
   */
  public static final String PRIORITY = "priority";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "index2".
   */
  public static final String INDEX2 = "index2";

  @ClassPropertyDeclaration
  @Size(min = 32, max = 255)
  private String uicCode;

  private int uicCodeXYZ = 0;

  @ClassPropertyDeclaration
  @DecimalMax(value = "32.777", inclusive = true)
  @DecimalMin(value = "1.025", inclusive = true)
  private int priority;

  private int priorityXYZ = 0;

  @ClassPropertyDeclaration
  @Min(value = 1000)
  @Max(value = 9999)
  private long code;

  private int codeXYZ = 0;

  @ClassPropertyDeclaration
  @Positive
  private byte index2;

  private int index2XYZ = 0;

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
   * Class implements builder to create a new instance of class <code>UICStop</code>.
   */
  public static class Builder extends Stop.Builder {
    @BuilderPropertyDeclaration
    @Size(min = 32, max = 255)
    private String uicCode;

    private int uicCodeXYZ = 0;

    @BuilderPropertyDeclaration
    @DecimalMax(value = "32.777", inclusive = true)
    @DecimalMin(value = "1.025", inclusive = true)
    private int priority;

    private int priorityXYZ = 0;

    @BuilderPropertyDeclaration
    @Min(value = 1000)
    @Max(value = 9999)
    private long code;

    private int codeXYZ = 0;

    @BuilderPropertyDeclaration
    @Positive
    private byte index2;

    private int index2XYZ = 0;

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
        this.setUicCode(pObject.uicCode);
        this.setPriority(pObject.priority);
        this.setCode(pObject.code);
        this.setIndex2(pObject.index2);
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
     * Method adds the passed objects to association {@link #links}.<br/>
     *
     * @param pLinks Array of objects that should be added to {@link #links}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLinks( LinkObject... pLinks ) {
      // Call super class implementation.
      super.addToLinks(pLinks);
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

    public Builder setUicCodeXYZ( int value ) {
      uicCodeXYZ = value;
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

    public Builder setPriorityXYZ( int value ) {
      priorityXYZ = value;
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

    public Builder setCodeXYZ( int value ) {
      codeXYZ = value;
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

    public Builder setIndex2XYZ( int value ) {
      index2XYZ = value;
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
      UICStop lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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

  public int getUicCodeXYZ( ) {
    return uicCodeXYZ;
  }

  public void setUicCodeXYZ( int value ) {
    uicCodeXYZ = value;
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

  public int getPriorityXYZ( ) {
    return priorityXYZ;
  }

  public void setPriorityXYZ( int value ) {
    priorityXYZ = value;
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

  public int getCodeXYZ( ) {
    return codeXYZ;
  }

  public void setCodeXYZ( int value ) {
    codeXYZ = value;
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

  public int getIndex2XYZ( ) {
    return index2XYZ;
  }

  public void setIndex2XYZ( int value ) {
    index2XYZ = value;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new UICStop objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
