/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonDeserialize(builder = OpenAPITestObject.Builder.class)
public class OpenAPITestObject {
  @NotNull
  private String readOnlyAttribute;

  @NotNull
  private String readWriteAttribute;

  private int writeOnlyAttribute;

  @NotNull
  private Boolean nullableAttribute;

  private double notNullableAttribute;

  @NotNull
  private String readOnlyArray;

  @NotNull
  private String readWriteArray;

  private int writeOnlyArray;

  private double nullableArray;

  private double notNullableArray;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected OpenAPITestObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readOnlyAttribute = pBuilder.readOnlyAttribute;
    readWriteAttribute = pBuilder.readWriteAttribute;
    writeOnlyAttribute = pBuilder.writeOnlyAttribute;
    nullableAttribute = pBuilder.nullableAttribute;
    notNullableAttribute = pBuilder.notNullableAttribute;
    readOnlyArray = pBuilder.readOnlyArray;
    readWriteArray = pBuilder.readWriteArray;
    writeOnlyArray = pBuilder.writeOnlyArray;
    nullableArray = pBuilder.nullableArray;
    notNullableArray = pBuilder.notNullableArray;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new OpenAPITestObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class OpenAPITestObject.
   *
   *
   * @param pReadOnlyAttribute Value to which {@link #readOnlyAttribute} should be set.
   *
   * @param pReadWriteAttribute Value to which {@link #readWriteAttribute} should be set.
   *
   * @param pWriteOnlyAttribute Value to which {@link #writeOnlyAttribute} should be set.
   *
   * @param pNullableAttribute Value to which {@link #nullableAttribute} should be set.
   *
   * @param pNotNullableAttribute Value to which {@link #notNullableAttribute} should be set.
   *
   * @param pReadOnlyArray Value to which {@link #readOnlyArray} should be set.
   *
   * @param pReadWriteArray Value to which {@link #readWriteArray} should be set.
   *
   * @param pWriteOnlyArray Value to which {@link #writeOnlyArray} should be set.
   *
   * @param pNullableArray Value to which {@link #nullableArray} should be set.
   *
   * @param pNotNullableArray Value to which {@link #notNullableArray} should be set.
   *
   * @return {@link OpenAPITestObject}
   */
  public static OpenAPITestObject of( String pReadOnlyAttribute, String pReadWriteAttribute, int pWriteOnlyAttribute,
      Boolean pNullableAttribute, double pNotNullableAttribute, String pReadOnlyArray, String pReadWriteArray,
      int pWriteOnlyArray, double pNullableArray, double pNotNullableArray ) {
    var lBuilder = OpenAPITestObject.builder();
    lBuilder.setReadOnlyAttribute(pReadOnlyAttribute);
    lBuilder.setReadWriteAttribute(pReadWriteAttribute);
    lBuilder.setWriteOnlyAttribute(pWriteOnlyAttribute);
    lBuilder.setNullableAttribute(pNullableAttribute);
    lBuilder.setNotNullableAttribute(pNotNullableAttribute);
    lBuilder.setReadOnlyArray(pReadOnlyArray);
    lBuilder.setReadWriteArray(pReadWriteArray);
    lBuilder.setWriteOnlyArray(pWriteOnlyArray);
    lBuilder.setNullableArray(pNullableArray);
    lBuilder.setNotNullableArray(pNotNullableArray);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>OpenAPITestObject</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String readOnlyAttribute;

    private String readWriteAttribute;

    private int writeOnlyAttribute;

    private Boolean nullableAttribute;

    private double notNullableAttribute;

    private String readOnlyArray;

    private String readWriteArray;

    private int writeOnlyArray;

    private double nullableArray;

    private double notNullableArray;

    /**
     * Use {@link OpenAPITestObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link OpenAPITestObject#builder(OpenAPITestObject)} instead of private constructor to create new builder.
     */
    protected Builder( OpenAPITestObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setReadOnlyAttribute(pObject.readOnlyAttribute);
        this.setReadWriteAttribute(pObject.readWriteAttribute);
        this.setWriteOnlyAttribute(pObject.writeOnlyAttribute);
        this.setNullableAttribute(pObject.nullableAttribute);
        this.setNotNullableAttribute(pObject.notNullableAttribute);
        this.setReadOnlyArray(pObject.readOnlyArray);
        this.setReadWriteArray(pObject.readWriteArray);
        this.setWriteOnlyArray(pObject.writeOnlyArray);
        this.setNullableArray(pObject.nullableArray);
        this.setNotNullableArray(pObject.notNullableArray);
      }
    }

    /**
     * Method sets attribute {@link #readOnlyAttribute}.<br/>
     *
     * @param pReadOnlyAttribute Value to which {@link #readOnlyAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadOnlyAttribute( @MyNotNullProperty String pReadOnlyAttribute ) {
      // Assign value to attribute
      readOnlyAttribute = pReadOnlyAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #readWriteAttribute}.<br/>
     *
     * @param pReadWriteAttribute Value to which {@link #readWriteAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadWriteAttribute( @MyNotNullProperty String pReadWriteAttribute ) {
      // Assign value to attribute
      readWriteAttribute = pReadWriteAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #writeOnlyAttribute}.<br/>
     *
     * @param pWriteOnlyAttribute Value to which {@link #writeOnlyAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setWriteOnlyAttribute( int pWriteOnlyAttribute ) {
      // Assign value to attribute
      writeOnlyAttribute = pWriteOnlyAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #nullableAttribute}.<br/>
     *
     * @param pNullableAttribute Value to which {@link #nullableAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNullableAttribute( @MyNotNullProperty Boolean pNullableAttribute ) {
      // Assign value to attribute
      nullableAttribute = pNullableAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #notNullableAttribute}.<br/>
     *
     * @param pNotNullableAttribute Value to which {@link #notNullableAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNotNullableAttribute( double pNotNullableAttribute ) {
      // Assign value to attribute
      notNullableAttribute = pNotNullableAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #readOnlyArray}.<br/>
     *
     * @param pReadOnlyArray Value to which {@link #readOnlyArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadOnlyArray( @MyNotNullProperty String pReadOnlyArray ) {
      // Assign value to attribute
      readOnlyArray = pReadOnlyArray;
      return this;
    }

    /**
     * Method sets attribute {@link #readWriteArray}.<br/>
     *
     * @param pReadWriteArray Value to which {@link #readWriteArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadWriteArray( @MyNotNullProperty String pReadWriteArray ) {
      // Assign value to attribute
      readWriteArray = pReadWriteArray;
      return this;
    }

    /**
     * Method sets attribute {@link #writeOnlyArray}.<br/>
     *
     * @param pWriteOnlyArray Value to which {@link #writeOnlyArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setWriteOnlyArray( int pWriteOnlyArray ) {
      // Assign value to attribute
      writeOnlyArray = pWriteOnlyArray;
      return this;
    }

    /**
     * Method sets attribute {@link #nullableArray}.<br/>
     *
     * @param pNullableArray Value to which {@link #nullableArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNullableArray( double pNullableArray ) {
      // Assign value to attribute
      nullableArray = pNullableArray;
      return this;
    }

    /**
     * Method sets attribute {@link #notNullableArray}.<br/>
     *
     * @param pNotNullableArray Value to which {@link #notNullableArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNotNullableArray( double pNotNullableArray ) {
      // Assign value to attribute
      notNullableArray = pNotNullableArray;
      return this;
    }

    /**
     * Method creates a new instance of class OpenAPITestObject. The object will be initialized with the values of the
     * builder.
     *
     * @return OpenAPITestObject Created object. The method never returns null.
     */
    public OpenAPITestObject build( ) {
      return new OpenAPITestObject(this);
    }

    /**
     * Method creates a new validated instance of class OpenAPITestObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return OpenAPITestObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public OpenAPITestObject buildValidated( ) throws ConstraintViolationException {
      OpenAPITestObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #readOnlyAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #readOnlyAttribute} is set.
   */
  @MyNotNullProperty
  public String getReadOnlyAttribute( ) {
    return readOnlyAttribute;
  }

  /**
   * Method sets attribute {@link #readOnlyAttribute}.<br/>
   *
   * @param pReadOnlyAttribute Value to which {@link #readOnlyAttribute} should be set.
   */
  public void setReadOnlyAttribute( @MyNotNullProperty String pReadOnlyAttribute ) {
    // Assign value to attribute
    readOnlyAttribute = pReadOnlyAttribute;
  }

  /**
   * Method returns attribute {@link #readWriteAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #readWriteAttribute} is set.
   */
  @MyNotNullProperty
  public String getReadWriteAttribute( ) {
    return readWriteAttribute;
  }

  /**
   * Method sets attribute {@link #readWriteAttribute}.<br/>
   *
   * @param pReadWriteAttribute Value to which {@link #readWriteAttribute} should be set.
   */
  public void setReadWriteAttribute( @MyNotNullProperty String pReadWriteAttribute ) {
    // Assign value to attribute
    readWriteAttribute = pReadWriteAttribute;
  }

  /**
   * Method returns attribute {@link #writeOnlyAttribute}.<br/>
   *
   * @return int Value to which {@link #writeOnlyAttribute} is set.
   */
  public int getWriteOnlyAttribute( ) {
    return writeOnlyAttribute;
  }

  /**
   * Method sets attribute {@link #writeOnlyAttribute}.<br/>
   *
   * @param pWriteOnlyAttribute Value to which {@link #writeOnlyAttribute} should be set.
   */
  public void setWriteOnlyAttribute( int pWriteOnlyAttribute ) {
    // Assign value to attribute
    writeOnlyAttribute = pWriteOnlyAttribute;
  }

  /**
   * Method returns attribute {@link #nullableAttribute}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #nullableAttribute} is set.
   */
  @MyNotNullProperty
  public Boolean getNullableAttribute( ) {
    return nullableAttribute;
  }

  /**
   * Method sets attribute {@link #nullableAttribute}.<br/>
   *
   * @param pNullableAttribute Value to which {@link #nullableAttribute} should be set.
   */
  public void setNullableAttribute( @MyNotNullProperty Boolean pNullableAttribute ) {
    // Assign value to attribute
    nullableAttribute = pNullableAttribute;
  }

  /**
   * Method returns attribute {@link #notNullableAttribute}.<br/>
   *
   * @return double Value to which {@link #notNullableAttribute} is set.
   */
  public double getNotNullableAttribute( ) {
    return notNullableAttribute;
  }

  /**
   * Method sets attribute {@link #notNullableAttribute}.<br/>
   *
   * @param pNotNullableAttribute Value to which {@link #notNullableAttribute} should be set.
   */
  public void setNotNullableAttribute( double pNotNullableAttribute ) {
    // Assign value to attribute
    notNullableAttribute = pNotNullableAttribute;
  }

  /**
   * Method returns attribute {@link #readOnlyArray}.<br/>
   *
   * @return {@link String} Value to which {@link #readOnlyArray} is set.
   */
  @MyNotNullProperty
  public String getReadOnlyArray( ) {
    return readOnlyArray;
  }

  /**
   * Method sets attribute {@link #readOnlyArray}.<br/>
   *
   * @param pReadOnlyArray Value to which {@link #readOnlyArray} should be set.
   */
  public void setReadOnlyArray( @MyNotNullProperty String pReadOnlyArray ) {
    // Assign value to attribute
    readOnlyArray = pReadOnlyArray;
  }

  /**
   * Method returns attribute {@link #readWriteArray}.<br/>
   *
   * @return {@link String} Value to which {@link #readWriteArray} is set.
   */
  @MyNotNullProperty
  public String getReadWriteArray( ) {
    return readWriteArray;
  }

  /**
   * Method sets attribute {@link #readWriteArray}.<br/>
   *
   * @param pReadWriteArray Value to which {@link #readWriteArray} should be set.
   */
  public void setReadWriteArray( @MyNotNullProperty String pReadWriteArray ) {
    // Assign value to attribute
    readWriteArray = pReadWriteArray;
  }

  /**
   * Method returns attribute {@link #writeOnlyArray}.<br/>
   *
   * @return int Value to which {@link #writeOnlyArray} is set.
   */
  public int getWriteOnlyArray( ) {
    return writeOnlyArray;
  }

  /**
   * Method sets attribute {@link #writeOnlyArray}.<br/>
   *
   * @param pWriteOnlyArray Value to which {@link #writeOnlyArray} should be set.
   */
  public void setWriteOnlyArray( int pWriteOnlyArray ) {
    // Assign value to attribute
    writeOnlyArray = pWriteOnlyArray;
  }

  /**
   * Method returns attribute {@link #nullableArray}.<br/>
   *
   * @return double Value to which {@link #nullableArray} is set.
   */
  public double getNullableArray( ) {
    return nullableArray;
  }

  /**
   * Method sets attribute {@link #nullableArray}.<br/>
   *
   * @param pNullableArray Value to which {@link #nullableArray} should be set.
   */
  public void setNullableArray( double pNullableArray ) {
    // Assign value to attribute
    nullableArray = pNullableArray;
  }

  /**
   * Method returns attribute {@link #notNullableArray}.<br/>
   *
   * @return double Value to which {@link #notNullableArray} is set.
   */
  public double getNotNullableArray( ) {
    return notNullableArray;
  }

  /**
   * Method sets attribute {@link #notNullableArray}.<br/>
   *
   * @param pNotNullableArray Value to which {@link #notNullableArray} should be set.
   */
  public void setNotNullableArray( double pNotNullableArray ) {
    // Assign value to attribute
    notNullableArray = pNotNullableArray;
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
    lBuilder.append("readOnlyAttribute: ");
    lBuilder.append(readOnlyAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readWriteAttribute: ");
    lBuilder.append(readWriteAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("writeOnlyAttribute: ");
    lBuilder.append(writeOnlyAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("nullableAttribute: ");
    lBuilder.append(nullableAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("notNullableAttribute: ");
    lBuilder.append(notNullableAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readOnlyArray: ");
    lBuilder.append(readOnlyArray);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readWriteArray: ");
    lBuilder.append(readWriteArray);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("writeOnlyArray: ");
    lBuilder.append(writeOnlyArray);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("nullableArray: ");
    lBuilder.append(nullableArray);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("notNullableArray: ");
    lBuilder.append(notNullableArray);
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
   * @return {@link Builder} New builder that can be used to create new OpenAPITestObject objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}