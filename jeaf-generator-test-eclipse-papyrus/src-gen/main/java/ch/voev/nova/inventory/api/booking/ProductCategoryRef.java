/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Reference to a product category. Product categories should be defined once and used uniformly in all channels (e.g.
 * NeTEx, SIRI, OJP). Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ProductCategoryRef {
  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * Reference to a product category. Product categories should be defined once and used uniformly in all channels (e.g.
   * NeTEx, SIRI, OJP). Provided by OJP. <br/>
   * <b>Example:</b> <code>urn:uic:sbc:76</code>
   */
  private String value;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ProductCategoryRef( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductCategoryRef( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ProductCategoryRef objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ProductCategoryRef objects. The method never
   * returns null.
   */
  public static Builder builder( ProductCategoryRef pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ProductCategoryRef. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Reference to a product category. Product categories should be defined once and used uniformly in all channels
     * (e.g. NeTEx, SIRI, OJP). Provided by OJP.
     */
    private String value;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ProductCategoryRef)} instead of private constructor to create new builder.
     */
    protected Builder( ProductCategoryRef pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        value = pObject.value;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ProductCategoryRef objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ProductCategoryRef objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ProductCategoryRef pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "value". Reference to a product category. Product categories should be defined once and
     * used uniformly in all channels (e.g. NeTEx, SIRI, OJP). Provided by OJP.
     * 
     * @param pValue Value to which the attribute "value" should be set.
     */
    public Builder setValue( String pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class ProductCategoryRef. The object will be initialized with the values of the
     * builder.
     * 
     * @return ProductCategoryRef Created object. The method never returns null.
     */
    public ProductCategoryRef build( ) {
      return new ProductCategoryRef(this);
    }

    /**
     * Method creates a new validated instance of class ProductCategoryRef. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ProductCategoryRef Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ProductCategoryRef buildValidated( ) throws ConstraintViolationException {
      ProductCategoryRef lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "value". Reference to a product category. Product categories should be defined once
   * and used uniformly in all channels (e.g. NeTEx, SIRI, OJP). Provided by OJP.
   * 
   * @return String Value to which the attribute "value" is set.
   */
  public String getValue( ) {
    return value;
  }

  /**
   * Method sets the attribute "value". Reference to a product category. Product categories should be defined once and
   * used uniformly in all channels (e.g. NeTEx, SIRI, OJP). Provided by OJP.
   * 
   * @param pValue Value to which the attribute "value" should be set.
   */
  public void setValue( String pValue ) {
    // Assign value to attribute
    value = pValue;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "value", "" + value));
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
