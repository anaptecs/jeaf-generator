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
 * Product category based on NeTEx/SIRI. A product category is a classification for vehicle journeys to express some
 * common properties of journeys for marketing and fare products. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ProductCategory {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "shortName".
   */
  public static final String SHORTNAME = "shortName";

  /**
   * Constant for the name of attribute "productCategoryRef".
   */
  public static final String PRODUCTCATEGORYREF = "productCategoryRef";

  /**
   * Full name of this product category, e.g. "TGV Lyria" in Switzerland and France. UIC: Long name of Service Brand
   * <br/>
   * <b>Example:</b> <code>TGV Lyria</code>
   */
  @NotNull
  private String name;

  /**
   * Short name or acronym of the product category, likely to be published, e.g. "TGV" UIC: Abbreviation of Service
   * Brand <br/>
   * <b>Example:</b> <code>TGV</code>
   */
  @NotNull
  private String shortName;

  /**
   * 
   */
  private ProductCategoryRef productCategoryRef;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ProductCategory( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductCategory( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    shortName = pBuilder.shortName;
    productCategoryRef = pBuilder.productCategoryRef;
  }

  /**
   * Class implements builder to create a new instance of class ProductCategory. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Full name of this product category, e.g. "TGV Lyria" in Switzerland and France. UIC: Long name of Service Brand
     */
    @NotNull
    private String name;

    /**
     * Short name or acronym of the product category, likely to be published, e.g. "TGV" UIC: Abbreviation of Service
     * Brand
     */
    @NotNull
    private String shortName;

    /**
     * 
     */
    private ProductCategoryRef productCategoryRef;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ProductCategory)} instead of private constructor to create new builder.
     */
    protected Builder( ProductCategory pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        shortName = pObject.shortName;
        productCategoryRef = pObject.productCategoryRef;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ProductCategory objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ProductCategory pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "name". Full name of this product category, e.g. "TGV Lyria" in Switzerland and France.
     * UIC: Long name of Service Brand
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "shortName". Short name or acronym of the product category, likely to be published,
     * e.g. "TGV" UIC: Abbreviation of Service Brand
     * 
     * @param pShortName Value to which the attribute "shortName" should be set.
     */
    public Builder setShortName( String pShortName ) {
      // Assign value to attribute
      shortName = pShortName;
      return this;
    }

    /**
     * Method sets the association "productCategoryRef".
     * 
     * @param pProductCategoryRef ProductCategoryRef to which the association "productCategoryRef" should be set.
     */
    public Builder setProductCategoryRef( ProductCategoryRef pProductCategoryRef ) {
      productCategoryRef = pProductCategoryRef;
      return this;
    }

    /**
     * Method creates a new instance of class ProductCategory. The object will be initialized with the values of the
     * builder.
     * 
     * @return ProductCategory Created object. The method never returns null.
     */
    public ProductCategory build( ) {
      return new ProductCategory(this);
    }

    /**
     * Method creates a new validated instance of class ProductCategory. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return ProductCategory Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ProductCategory buildValidated( ) throws ConstraintViolationException {
      ProductCategory lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "name". Full name of this product category, e.g. "TGV Lyria" in Switzerland and
   * France. UIC: Long name of Service Brand
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name". Full name of this product category, e.g. "TGV Lyria" in Switzerland and France.
   * UIC: Long name of Service Brand
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "shortName". Short name or acronym of the product category, likely to be published,
   * e.g. "TGV" UIC: Abbreviation of Service Brand
   * 
   * @return String Value to which the attribute "shortName" is set.
   */
  public String getShortName( ) {
    return shortName;
  }

  /**
   * Method sets the attribute "shortName". Short name or acronym of the product category, likely to be published, e.g.
   * "TGV" UIC: Abbreviation of Service Brand
   * 
   * @param pShortName Value to which the attribute "shortName" should be set.
   */
  public void setShortName( String pShortName ) {
    // Assign value to attribute
    shortName = pShortName;
  }

  /**
   * Method returns the association "productCategoryRef".
   * 
   *
   * @return ProductCategoryRef ProductCategoryRef to which the association "productCategoryRef" is set.
   */
  public ProductCategoryRef getProductCategoryRef( ) {
    return productCategoryRef;
  }

  /**
   * Method sets the association "productCategoryRef".
   * 
   * 
   * @param pProductCategoryRef ProductCategoryRef to which the association "productCategoryRef" should be set.
   */
  public void setProductCategoryRef( ProductCategoryRef pProductCategoryRef ) {
    productCategoryRef = pProductCategoryRef;
  }

  /**
   * Method unsets the association "productCategoryRef".
   * 
   */
  public final void unsetProductCategoryRef( ) {
    productCategoryRef = null;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "shortName", "" + shortName));
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
