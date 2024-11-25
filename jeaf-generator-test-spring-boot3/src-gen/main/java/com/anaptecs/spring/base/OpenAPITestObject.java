/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

public class OpenAPITestObject {
  /**
   * Constant for the name of attribute "readOnlyAttribute".
   */
  public static final String READONLYATTRIBUTE = "readOnlyAttribute";

  /**
   * Constant for the name of attribute "readWriteAttribute".
   */
  public static final String READWRITEATTRIBUTE = "readWriteAttribute";

  /**
   * Constant for the name of attribute "writeOnlyAttribute".
   */
  public static final String WRITEONLYATTRIBUTE = "writeOnlyAttribute";

  /**
   * Constant for the name of attribute "nullableAttribute".
   */
  public static final String NULLABLEATTRIBUTE = "nullableAttribute";

  /**
   * Constant for the name of attribute "notNullableAttribute".
   */
  public static final String NOTNULLABLEATTRIBUTE = "notNullableAttribute";

  /**
   * Constant for the name of attribute "readOnlyArray".
   */
  public static final String READONLYARRAY = "readOnlyArray";

  /**
   * Constant for the name of attribute "readWriteArray".
   */
  public static final String READWRITEARRAY = "readWriteArray";

  /**
   * Constant for the name of attribute "writeOnlyArray".
   */
  public static final String WRITEONLYARRAY = "writeOnlyArray";

  /**
   * Constant for the name of attribute "nullableArray".
   */
  public static final String NULLABLEARRAY = "nullableArray";

  /**
   * Constant for the name of attribute "notNullableArray".
   */
  public static final String NOTNULLABLEARRAY = "notNullableArray";

  private final String readOnlyAttribute;

  private final String readWriteAttribute;

  private final int writeOnlyAttribute;

  private final Boolean nullableAttribute;

  private final double notNullableAttribute;

  private final String readOnlyArray;

  private final String readWriteArray;

  private final int writeOnlyArray;

  private final double nullableArray;

  private final double notNullableArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected OpenAPITestObject( ) {
    readOnlyAttribute = null;
    readWriteAttribute = null;
    writeOnlyAttribute = 0;
    nullableAttribute = null;
    notNullableAttribute = 0;
    readOnlyArray = null;
    readWriteArray = null;
    writeOnlyArray = 0;
    nullableArray = 0;
    notNullableArray = 0;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected OpenAPITestObject( Builder pBuilder ) {
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
   * @return {@link com.anaptecs.spring.base.OpenAPITestObject}
   */
  public static OpenAPITestObject of( String pReadOnlyAttribute, String pReadWriteAttribute, int pWriteOnlyAttribute,
      Boolean pNullableAttribute, double pNotNullableAttribute, String pReadOnlyArray, String pReadWriteArray,
      int pWriteOnlyArray, double pNullableArray, double pNotNullableArray ) {
    OpenAPITestObject.Builder lBuilder = OpenAPITestObject.builder();
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
    public Builder setReadOnlyAttribute( String pReadOnlyAttribute ) {
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
    public Builder setReadWriteAttribute( String pReadWriteAttribute ) {
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
    public Builder setNullableAttribute( Boolean pNullableAttribute ) {
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
    public Builder setReadOnlyArray( String pReadOnlyArray ) {
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
    public Builder setReadWriteArray( String pReadWriteArray ) {
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
  }

  /**
   * Method returns attribute {@link #readOnlyAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #readOnlyAttribute} is set.
   */
  public String getReadOnlyAttribute( ) {
    return readOnlyAttribute;
  }

  /**
   * Method returns attribute {@link #readWriteAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #readWriteAttribute} is set.
   */
  public String getReadWriteAttribute( ) {
    return readWriteAttribute;
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
   * Method returns attribute {@link #nullableAttribute}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #nullableAttribute} is set.
   */
  public Boolean getNullableAttribute( ) {
    return nullableAttribute;
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
   * Method returns attribute {@link #readOnlyArray}.<br/>
   *
   * @return {@link String} Value to which {@link #readOnlyArray} is set.
   */
  public String getReadOnlyArray( ) {
    return readOnlyArray;
  }

  /**
   * Method returns attribute {@link #readWriteArray}.<br/>
   *
   * @return {@link String} Value to which {@link #readWriteArray} is set.
   */
  public String getReadWriteArray( ) {
    return readWriteArray;
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
   * Method returns attribute {@link #nullableArray}.<br/>
   *
   * @return double Value to which {@link #nullableArray} is set.
   */
  public double getNullableArray( ) {
    return nullableArray;
  }

  /**
   * Method returns attribute {@link #notNullableArray}.<br/>
   *
   * @return double Value to which {@link #notNullableArray} is set.
   */
  public double getNotNullableArray( ) {
    return notNullableArray;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(readOnlyAttribute);
    lResult = lPrime * lResult + Objects.hashCode(readWriteAttribute);
    lResult = lPrime * lResult + writeOnlyAttribute;
    lResult = lPrime * lResult + Objects.hashCode(nullableAttribute);
    lResult = lPrime * lResult + Double.hashCode(notNullableAttribute);
    lResult = lPrime * lResult + Objects.hashCode(readOnlyArray);
    lResult = lPrime * lResult + Objects.hashCode(readWriteArray);
    lResult = lPrime * lResult + writeOnlyArray;
    lResult = lPrime * lResult + Double.hashCode(nullableArray);
    lResult = lPrime * lResult + Double.hashCode(notNullableArray);
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
      OpenAPITestObject lOther = (OpenAPITestObject) pObject;
      lEquals = Objects.equals(readOnlyAttribute, lOther.readOnlyAttribute)
          && Objects.equals(readWriteAttribute, lOther.readWriteAttribute)
          && writeOnlyAttribute == lOther.writeOnlyAttribute
          && Objects.equals(nullableAttribute, lOther.nullableAttribute)
          && Double.compare(notNullableAttribute, lOther.notNullableAttribute) == 0
          && Objects.equals(readOnlyArray, lOther.readOnlyArray)
          && Objects.equals(readWriteArray, lOther.readWriteArray) && writeOnlyArray == lOther.writeOnlyArray
          && Double.compare(nullableArray, lOther.nullableArray) == 0
          && Double.compare(notNullableArray, lOther.notNullableArray) == 0;
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