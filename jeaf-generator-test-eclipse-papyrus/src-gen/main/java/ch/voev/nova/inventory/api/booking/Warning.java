/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * This element can be used to pass non-blocking information or events, such as a price difference with the initially
 * offered price at booking time. It is inspired on the JSon problem structure.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Warning {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

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

  /**
   * 
   */
  @NotNull
  private String code;

  /**
   * An absolute URI that identifies the warning type. When dereferenced, it SHOULD provide human-readable documentation
   * for the problem type (e.g., using HTML). <br/>
   * <b>Default Value:</b> <code>"about:blank"</code> <br/>
   * <b>Example:</b> <code>https://example.com/warns/price-updated</code>
   */
  private String type;

  /**
   * A human readable explanation specific to this occurrence of the warning. <br/>
   * <b>Example:</b> <code>The price of the given offer part has been updated during the booking operation</code>
   */
  private String detail;

  /**
   * An absolute URI that identifies the specific occurrence of the warning. <br/>
   * <b>Example:</b> <code>offers/offer1234</code>
   */
  private String instance;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Warning( ) {
    type = "about:blank";
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Warning( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
    type = pBuilder.type;
    detail = pBuilder.detail;
    instance = pBuilder.instance;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Warning objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Warning objects. The method never returns null.
   */
  public static Builder builder( Warning pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Warning. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotNull
    private String code;

    /**
     * An absolute URI that identifies the warning type. When dereferenced, it SHOULD provide human-readable
     * documentation for the problem type (e.g., using HTML).
     */
    private String type = "about:blank";

    /**
     * A human readable explanation specific to this occurrence of the warning.
     */
    private String detail;

    /**
     * An absolute URI that identifies the specific occurrence of the warning.
     */
    private String instance;

    /**
     * Use {@link Warning#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Warning#builder(Warning)} instead of private constructor to create new builder.
     */
    protected Builder( Warning pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        code = pObject.code;
        type = pObject.type;
        detail = pObject.detail;
        instance = pObject.instance;
      }
    }

    /**
     * Method sets the attribute "code".
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets the attribute "type". An absolute URI that identifies the warning type. When dereferenced, it SHOULD
     * provide human-readable documentation for the problem type (e.g., using HTML).
     * 
     * @param pType Value to which the attribute "type" should be set.
     */
    public Builder setType( String pType ) {
      // Assign value to attribute
      type = pType;
      return this;
    }

    /**
     * Method sets the attribute "detail". A human readable explanation specific to this occurrence of the warning.
     * 
     * @param pDetail Value to which the attribute "detail" should be set.
     */
    public Builder setDetail( String pDetail ) {
      // Assign value to attribute
      detail = pDetail;
      return this;
    }

    /**
     * Method sets the attribute "instance". An absolute URI that identifies the specific occurrence of the warning.
     * 
     * @param pInstance Value to which the attribute "instance" should be set.
     */
    public Builder setInstance( String pInstance ) {
      // Assign value to attribute
      instance = pInstance;
      return this;
    }

    /**
     * Method creates a new instance of class Warning. The object will be initialized with the values of the builder.
     * 
     * @return Warning Created object. The method never returns null.
     */
    public Warning build( ) {
      return new Warning(this);
    }

    /**
     * Method creates a new validated instance of class Warning. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Warning Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Warning buildValidated( ) throws ConstraintViolationException {
      Warning lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code".
   * 
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( String pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns the attribute "type". An absolute URI that identifies the warning type. When dereferenced, it SHOULD
   * provide human-readable documentation for the problem type (e.g., using HTML).
   * 
   * @return String Value to which the attribute "type" is set.
   */
  public String getType( ) {
    return type;
  }

  /**
   * Method sets the attribute "type". An absolute URI that identifies the warning type. When dereferenced, it SHOULD
   * provide human-readable documentation for the problem type (e.g., using HTML).
   * 
   * @param pType Value to which the attribute "type" should be set.
   */
  public void setType( String pType ) {
    // Assign value to attribute
    type = pType;
  }

  /**
   * Method returns the attribute "detail". A human readable explanation specific to this occurrence of the warning.
   * 
   * @return String Value to which the attribute "detail" is set.
   */
  public String getDetail( ) {
    return detail;
  }

  /**
   * Method sets the attribute "detail". A human readable explanation specific to this occurrence of the warning.
   * 
   * @param pDetail Value to which the attribute "detail" should be set.
   */
  public void setDetail( String pDetail ) {
    // Assign value to attribute
    detail = pDetail;
  }

  /**
   * Method returns the attribute "instance". An absolute URI that identifies the specific occurrence of the warning.
   * 
   * @return String Value to which the attribute "instance" is set.
   */
  public String getInstance( ) {
    return instance;
  }

  /**
   * Method sets the attribute "instance". An absolute URI that identifies the specific occurrence of the warning.
   * 
   * @param pInstance Value to which the attribute "instance" should be set.
   */
  public void setInstance( String pInstance ) {
    // Assign value to attribute
    instance = pInstance;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "code", "" + code));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "type", "" + type));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "detail", "" + detail));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "instance", "" + instance));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
