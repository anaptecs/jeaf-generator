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
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class VAT {
  /**
   * Constant for the name of attribute "countryCode".
   */
  public static final String COUNTRYCODE = "countryCode";

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT = "amount";

  /**
   * Constant for the name of attribute "scale".
   */
  public static final String SCALE = "scale";

  /**
   * Constant for the name of attribute "percentage".
   */
  public static final String PERCENTAGE = "percentage";

  /**
   * Constant for the name of attribute "taxId".
   */
  public static final String TAXID = "taxId";

  /**
   * Constant for the name of attribute "scope".
   */
  public static final String SCOPE = "scope";

  /**
   * 
   */
  private CountryCode countryCode;

  /**
   * amount in cents <br/>
   * <b>Example:</b> <code>5</code>
   */
  @NotNull
  private int amount;

  /**
   * scale of the amount - the number of positions after the comma <br/>
   * <b>Default Value:</b> <code>2</code>
   */
  private int scale;

  /**
   * 
   */
  private float percentage;

  /**
   * 
   */
  private String taxId;

  /**
   * 
   */
  private VatScope scope;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected VAT( ) {
    scale = 2;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected VAT( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    countryCode = pBuilder.countryCode;
    amount = pBuilder.amount;
    scale = pBuilder.scale;
    percentage = pBuilder.percentage;
    taxId = pBuilder.taxId;
    scope = pBuilder.scope;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new VAT objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new VAT objects. The method never returns null.
   */
  public static Builder builder( VAT pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class VAT. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private CountryCode countryCode;

    /**
     * amount in cents
     */
    @NotNull
    private int amount;

    /**
     * scale of the amount - the number of positions after the comma
     */
    private int scale = 2;

    /**
     * 
     */
    private float percentage;

    /**
     * 
     */
    private String taxId;

    /**
     * 
     */
    private VatScope scope;

    /**
     * Use {@link VAT#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link VAT#builder(VAT)} instead of private constructor to create new builder.
     */
    protected Builder( VAT pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        countryCode = pObject.countryCode;
        amount = pObject.amount;
        scale = pObject.scale;
        percentage = pObject.percentage;
        taxId = pObject.taxId;
        scope = pObject.scope;
      }
    }

    /**
     * Method sets the association "countryCode".
     * 
     * @param pCountryCode CountryCode to which the association "countryCode" should be set.
     */
    public Builder setCountryCode( CountryCode pCountryCode ) {
      countryCode = pCountryCode;
      return this;
    }

    /**
     * Method sets the attribute "amount". amount in cents
     * 
     * @param pAmount Value to which the attribute "amount" should be set.
     */
    public Builder setAmount( int pAmount ) {
      // Assign value to attribute
      amount = pAmount;
      return this;
    }

    /**
     * Method sets the attribute "scale". scale of the amount - the number of positions after the comma
     * 
     * @param pScale Value to which the attribute "scale" should be set.
     */
    public Builder setScale( int pScale ) {
      // Assign value to attribute
      scale = pScale;
      return this;
    }

    /**
     * Method sets the attribute "percentage".
     * 
     * @param pPercentage Value to which the attribute "percentage" should be set.
     */
    public Builder setPercentage( float pPercentage ) {
      // Assign value to attribute
      percentage = pPercentage;
      return this;
    }

    /**
     * Method sets the attribute "taxId".
     * 
     * @param pTaxId Value to which the attribute "taxId" should be set.
     */
    public Builder setTaxId( String pTaxId ) {
      // Assign value to attribute
      taxId = pTaxId;
      return this;
    }

    /**
     * Method sets the association "scope".
     * 
     * @param pScope VatScope to which the association "scope" should be set.
     */
    public Builder setScope( VatScope pScope ) {
      scope = pScope;
      return this;
    }

    /**
     * Method creates a new instance of class VAT. The object will be initialized with the values of the builder.
     * 
     * @return VAT Created object. The method never returns null.
     */
    public VAT build( ) {
      return new VAT(this);
    }

    /**
     * Method creates a new validated instance of class VAT. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return VAT Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public VAT buildValidated( ) throws ConstraintViolationException {
      VAT lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "countryCode".
   * 
   *
   * @return CountryCode CountryCode to which the association "countryCode" is set.
   */
  public CountryCode getCountryCode( ) {
    return countryCode;
  }

  /**
   * Method sets the association "countryCode".
   * 
   * 
   * @param pCountryCode CountryCode to which the association "countryCode" should be set.
   */
  public void setCountryCode( CountryCode pCountryCode ) {
    countryCode = pCountryCode;
  }

  /**
   * Method unsets the association "countryCode".
   * 
   */
  public final void unsetCountryCode( ) {
    countryCode = null;
  }

  /**
   * Method returns the attribute "amount". amount in cents
   * 
   * @return int Value to which the attribute "amount" is set.
   */
  public int getAmount( ) {
    return amount;
  }

  /**
   * Method sets the attribute "amount". amount in cents
   * 
   * @param pAmount Value to which the attribute "amount" should be set.
   */
  public void setAmount( int pAmount ) {
    // Assign value to attribute
    amount = pAmount;
  }

  /**
   * Method returns the attribute "scale". scale of the amount - the number of positions after the comma
   * 
   * @return int Value to which the attribute "scale" is set.
   */
  public int getScale( ) {
    return scale;
  }

  /**
   * Method sets the attribute "scale". scale of the amount - the number of positions after the comma
   * 
   * @param pScale Value to which the attribute "scale" should be set.
   */
  public void setScale( int pScale ) {
    // Assign value to attribute
    scale = pScale;
  }

  /**
   * Method returns the attribute "percentage".
   * 
   * 
   * @return float Value to which the attribute "percentage" is set.
   */
  public float getPercentage( ) {
    return percentage;
  }

  /**
   * Method sets the attribute "percentage".
   * 
   * 
   * @param pPercentage Value to which the attribute "percentage" should be set.
   */
  public void setPercentage( float pPercentage ) {
    // Assign value to attribute
    percentage = pPercentage;
  }

  /**
   * Method returns the attribute "taxId".
   * 
   * 
   * @return String Value to which the attribute "taxId" is set.
   */
  public String getTaxId( ) {
    return taxId;
  }

  /**
   * Method sets the attribute "taxId".
   * 
   * 
   * @param pTaxId Value to which the attribute "taxId" should be set.
   */
  public void setTaxId( String pTaxId ) {
    // Assign value to attribute
    taxId = pTaxId;
  }

  /**
   * Method returns the association "scope".
   * 
   *
   * @return VatScope VatScope to which the association "scope" is set.
   */
  public VatScope getScope( ) {
    return scope;
  }

  /**
   * Method sets the association "scope".
   * 
   * 
   * @param pScope VatScope to which the association "scope" should be set.
   */
  public void setScope( VatScope pScope ) {
    scope = pScope;
  }

  /**
   * Method unsets the association "scope".
   * 
   */
  public final void unsetScope( ) {
    scope = null;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "amount", "" + amount));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "scale", "" + scale));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "percentage", "" + percentage));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "taxId", "" + taxId));
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
