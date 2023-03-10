/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected OpenAPITestObject( ) {
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new OpenAPITestObject objects. The method never
   * returns null.
   */
  public static Builder builder( OpenAPITestObject pObject ) {
    return new Builder(pObject);
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
        readOnlyAttribute = pObject.readOnlyAttribute;
        readWriteAttribute = pObject.readWriteAttribute;
        writeOnlyAttribute = pObject.writeOnlyAttribute;
        nullableAttribute = pObject.nullableAttribute;
        notNullableAttribute = pObject.notNullableAttribute;
        readOnlyArray = pObject.readOnlyArray;
        readWriteArray = pObject.readWriteArray;
        writeOnlyArray = pObject.writeOnlyArray;
        nullableArray = pObject.nullableArray;
        notNullableArray = pObject.notNullableArray;
      }
    }

    /**
     * Method sets the attribute "readOnlyAttribute".
     * 
     * @param pReadOnlyAttribute Value to which the attribute "readOnlyAttribute" should be set.
     */
    public Builder setReadOnlyAttribute( String pReadOnlyAttribute ) {
      // Assign value to attribute
      readOnlyAttribute = pReadOnlyAttribute;
      return this;
    }

    /**
     * Method sets the attribute "readWriteAttribute".
     * 
     * @param pReadWriteAttribute Value to which the attribute "readWriteAttribute" should be set.
     */
    public Builder setReadWriteAttribute( String pReadWriteAttribute ) {
      // Assign value to attribute
      readWriteAttribute = pReadWriteAttribute;
      return this;
    }

    /**
     * Method sets the attribute "writeOnlyAttribute".
     * 
     * @param pWriteOnlyAttribute Value to which the attribute "writeOnlyAttribute" should be set.
     */
    public Builder setWriteOnlyAttribute( int pWriteOnlyAttribute ) {
      // Assign value to attribute
      writeOnlyAttribute = pWriteOnlyAttribute;
      return this;
    }

    /**
     * Method sets the attribute "nullableAttribute".
     * 
     * @param pNullableAttribute Value to which the attribute "nullableAttribute" should be set.
     */
    public Builder setNullableAttribute( Boolean pNullableAttribute ) {
      // Assign value to attribute
      nullableAttribute = pNullableAttribute;
      return this;
    }

    /**
     * Method sets the attribute "notNullableAttribute".
     * 
     * @param pNotNullableAttribute Value to which the attribute "notNullableAttribute" should be set.
     */
    public Builder setNotNullableAttribute( double pNotNullableAttribute ) {
      // Assign value to attribute
      notNullableAttribute = pNotNullableAttribute;
      return this;
    }

    /**
     * Method sets the attribute "readOnlyArray".
     * 
     * @param pReadOnlyArray Value to which the attribute "readOnlyArray" should be set.
     */
    public Builder setReadOnlyArray( String pReadOnlyArray ) {
      // Assign value to attribute
      readOnlyArray = pReadOnlyArray;
      return this;
    }

    /**
     * Method sets the attribute "readWriteArray".
     * 
     * @param pReadWriteArray Value to which the attribute "readWriteArray" should be set.
     */
    public Builder setReadWriteArray( String pReadWriteArray ) {
      // Assign value to attribute
      readWriteArray = pReadWriteArray;
      return this;
    }

    /**
     * Method sets the attribute "writeOnlyArray".
     * 
     * @param pWriteOnlyArray Value to which the attribute "writeOnlyArray" should be set.
     */
    public Builder setWriteOnlyArray( int pWriteOnlyArray ) {
      // Assign value to attribute
      writeOnlyArray = pWriteOnlyArray;
      return this;
    }

    /**
     * Method sets the attribute "nullableArray".
     * 
     * @param pNullableArray Value to which the attribute "nullableArray" should be set.
     */
    public Builder setNullableArray( double pNullableArray ) {
      // Assign value to attribute
      nullableArray = pNullableArray;
      return this;
    }

    /**
     * Method sets the attribute "notNullableArray".
     * 
     * @param pNotNullableArray Value to which the attribute "notNullableArray" should be set.
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
   * Method sets attribute {@link #readOnlyAttribute}.<br/>
   * 
   * @param pReadOnlyAttribute Value to which {@link #readOnlyAttribute} should be set.
   */
  public void setReadOnlyAttribute( String pReadOnlyAttribute ) {
    // Assign value to attribute
    readOnlyAttribute = pReadOnlyAttribute;
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
   * Method sets attribute {@link #readWriteAttribute}.<br/>
   * 
   * @param pReadWriteAttribute Value to which {@link #readWriteAttribute} should be set.
   */
  public void setReadWriteAttribute( String pReadWriteAttribute ) {
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
  public Boolean getNullableAttribute( ) {
    return nullableAttribute;
  }

  /**
   * Method sets attribute {@link #nullableAttribute}.<br/>
   * 
   * @param pNullableAttribute Value to which {@link #nullableAttribute} should be set.
   */
  public void setNullableAttribute( Boolean pNullableAttribute ) {
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
  public String getReadOnlyArray( ) {
    return readOnlyArray;
  }

  /**
   * Method sets attribute {@link #readOnlyArray}.<br/>
   * 
   * @param pReadOnlyArray Value to which {@link #readOnlyArray} should be set.
   */
  public void setReadOnlyArray( String pReadOnlyArray ) {
    // Assign value to attribute
    readOnlyArray = pReadOnlyArray;
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
   * Method sets attribute {@link #readWriteArray}.<br/>
   * 
   * @param pReadWriteArray Value to which {@link #readWriteArray} should be set.
   */
  public void setReadWriteArray( String pReadWriteArray ) {
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
}
