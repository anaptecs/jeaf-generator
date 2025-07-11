/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Company extends Partner {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  @JEAFCustomAnnotationTest
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "code".
   */
  @JEAFCustomAnnotationTest
  public static final String CODE = "code";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String name;

  // "java.lang.String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private StringCode code;

  // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
  private int codeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Company( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Company( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    name = pBuilder.name;
    // "java.lang.String"
    nameXYZ = pBuilder.nameXYZ;
    code = pBuilder.code;
    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    codeXYZ = pBuilder.codeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Company objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Company</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder extends Partner.Builder {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String name;

    // "java.lang.String"
    private int nameXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private StringCode code;

    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    private int codeXYZ = 0;

    /**
     * Use {@link Company#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link Company#builder(Company)} instead of private constructor to create new builder.
     */
    protected Builder( Company pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public Builder setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // Call super class implementation.
      super.setPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Array of objects that should be added to {@link #postalAddresses}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder addToPostalAddresses( PostalAddress... pPostalAddresses ) {
      // Call super class implementation.
      super.addToPostalAddresses(pPostalAddresses);
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public Builder setNameXYZ( int value ) {
      // "java.lang.String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setCode( StringCode pCode ) {
      code = pCode;
      return this;
    }

    public Builder setCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
      codeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Company. The object will be initialized with the values of the builder.
     *
     * @return Company Created object. The method never returns null.
     */
    public Company build( ) {
      return new Company(this);
    }

    /**
     * Method creates a new validated instance of class Company. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Company Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Company buildValidated( ) throws ConstraintViolationException {
      Company lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  @JEAFCustomAnnotationTest
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  public int getNameXYZ( ) {
    // "java.lang.String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns association {@link #code}.<br/>
   *
   * @return {@link StringCode} Value to which {@link #code} is set.
   */
  @JEAFCustomAnnotationTest
  public StringCode getCode( ) {
    return code;
  }

  /**
   * Method sets association {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setCode( StringCode pCode ) {
    code = pCode;
  }

  /**
   * Method unsets {@link #code}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetCode( ) {
    code = null;
  }

  public int getCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.StringCode"
    return codeXYZ;
  }

  public void setCodeXYZ( int value ) {
    codeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
    lBuilder.append("name: ");
    lBuilder.append(name);
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
   * @return {@link Builder} New builder that can be used to create new Company objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}