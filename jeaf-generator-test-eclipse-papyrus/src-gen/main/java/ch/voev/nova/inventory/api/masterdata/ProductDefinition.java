/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

import ch.voev.nova.inventory.api.booking.AccommodationSubType;
import ch.voev.nova.inventory.api.booking.AccommodationType;
import ch.voev.nova.inventory.api.booking.ComfortClass;

/**
 * Structured description of the product, its name, comfort and sales / after-sales conditions
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ProductDefinition {
  /**
   * Constant for the name of attribute "validities".
   */
  public static final String VALIDITIES = "validities";

  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "summary".
   */
  public static final String SUMMARY = "summary";

  /**
   * Constant for the name of attribute "family".
   */
  public static final String FAMILY = "family";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "conditions".
   */
  public static final String CONDITIONS = "conditions";

  /**
   * Constant for the name of attribute "accommodationType".
   */
  public static final String ACCOMMODATIONTYPE = "accommodationType";

  /**
   * Constant for the name of attribute "accommodationSubType".
   */
  public static final String ACCOMMODATIONSUBTYPE = "accommodationSubType";

  /**
   * Constant for the name of attribute "serviceClass".
   */
  public static final String SERVICECLASS = "serviceClass";

  /**
   * Constant for the name of attribute "comfortClass".
   */
  public static final String COMFORTCLASS = "comfortClass";

  /**
   * Constant for the name of attribute "tariff".
   */
  public static final String TARIFF = "tariff";

  /**
   * Constant for the name of attribute "isTrainBound".
   */
  public static final String ISTRAINBOUND = "isTrainBound";

  /**
   * Constant for the name of attribute "isReturnProduct".
   */
  public static final String ISRETURNPRODUCT = "isReturnProduct";

  /**
   * Constant for the name of attribute "fulfillmentOptions".
   */
  public static final String FULFILLMENTOPTIONS = "fulfillmentOptions";

  /**
   * 
   */
  private List<TemporalValidity> validities = new ArrayList<TemporalValidity>();

  /**
   * unique id of this product on this server.
   */
  private String id;

  /**
   * Internal product description. <br/>
   * <b>Example:</b> <code>TGV Lyria Loisir 2</code>
   */
  private String summary;

  /**
   * The name of the family the product belongs to. E.g. all "product variants" can be part of the same family.
   */
  private String family;

  /**
   * 
   */
  private ProductType type;

  /**
   * The product code expressed in the provider system (could be a mapping from an even lower-level provider). <br/>
   * <b>Example:</b> <code>PT00AD</code>
   */
  private String code;

  /**
   * 
   */
  private Text description;

  /**
   * Structured description of the sales or after-sales conditions.
   */
  private List<Condition> conditions = new ArrayList<Condition>();

  /**
   * Accommodation type according to UIC
   */
  private AccommodationType accommodationType;

  /**
   * Defines whether the product is valid for specific accommodation sub types only. Mandatory in case for reservation
   * products.
   */
  private AccommodationSubType accommodationSubType;

  /**
   * Defines whether the product is valid for a specific service classes.
   */
  private ServiceClass serviceClass;

  /**
   * 
   */
  private ComfortClass comfortClass;

  /**
   * Mapping to Tariff 42 of IRS-90918-3 (Hermes/Hosa). Helps the H2O converter in mapping offers to a requested tariff.
   * See legacyReservationParameter.tariff in OSDM offline.
   */
  private String tariff;

  /**
   * <br/>
   * <b>Default Value:</b> <code>false</code>
   */
  private boolean isTrainBound;

  /**
   * <br/>
   * <b>Default Value:</b> <code>false</code>
   */
  private boolean isReturnProduct;

  /**
   * 
   */
  private List<FulfillmentOption> fulfillmentOptions = new ArrayList<FulfillmentOption>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ProductDefinition( ) {
    isTrainBound = false;
    isReturnProduct = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductDefinition( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.validities != null) {
      validities.addAll(pBuilder.validities);
    }
    id = pBuilder.id;
    summary = pBuilder.summary;
    family = pBuilder.family;
    type = pBuilder.type;
    code = pBuilder.code;
    description = pBuilder.description;
    if (pBuilder.conditions != null) {
      conditions.addAll(pBuilder.conditions);
    }
    accommodationType = pBuilder.accommodationType;
    accommodationSubType = pBuilder.accommodationSubType;
    serviceClass = pBuilder.serviceClass;
    comfortClass = pBuilder.comfortClass;
    tariff = pBuilder.tariff;
    isTrainBound = pBuilder.isTrainBound;
    isReturnProduct = pBuilder.isReturnProduct;
    if (pBuilder.fulfillmentOptions != null) {
      fulfillmentOptions.addAll(pBuilder.fulfillmentOptions);
    }
  }

  /**
   * Class implements builder to create a new instance of class ProductDefinition. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<TemporalValidity> validities;

    /**
     * unique id of this product on this server.
     */
    private String id;

    /**
     * Internal product description.
     */
    private String summary;

    /**
     * The name of the family the product belongs to. E.g. all "product variants" can be part of the same family.
     */
    private String family;

    /**
     * 
     */
    private ProductType type;

    /**
     * The product code expressed in the provider system (could be a mapping from an even lower-level provider).
     */
    private String code;

    /**
     * 
     */
    private Text description;

    /**
     * Structured description of the sales or after-sales conditions.
     */
    private List<Condition> conditions;

    /**
     * Accommodation type according to UIC
     */
    private AccommodationType accommodationType;

    /**
     * Defines whether the product is valid for specific accommodation sub types only. Mandatory in case for reservation
     * products.
     */
    private AccommodationSubType accommodationSubType;

    /**
     * Defines whether the product is valid for a specific service classes.
     */
    private ServiceClass serviceClass;

    /**
     * 
     */
    private ComfortClass comfortClass;

    /**
     * Mapping to Tariff 42 of IRS-90918-3 (Hermes/Hosa). Helps the H2O converter in mapping offers to a requested
     * tariff. See legacyReservationParameter.tariff in OSDM offline.
     */
    private String tariff;

    /**
     * 
     */
    private boolean isTrainBound = false;

    /**
     * 
     */
    private boolean isReturnProduct = false;

    /**
     * 
     */
    private List<FulfillmentOption> fulfillmentOptions;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ProductDefinition)} instead of private constructor to create new builder.
     */
    protected Builder( ProductDefinition pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        validities = pObject.validities;
        id = pObject.id;
        summary = pObject.summary;
        family = pObject.family;
        type = pObject.type;
        code = pObject.code;
        description = pObject.description;
        conditions = pObject.conditions;
        accommodationType = pObject.accommodationType;
        accommodationSubType = pObject.accommodationSubType;
        serviceClass = pObject.serviceClass;
        comfortClass = pObject.comfortClass;
        tariff = pObject.tariff;
        isTrainBound = pObject.isTrainBound;
        isReturnProduct = pObject.isReturnProduct;
        fulfillmentOptions = pObject.fulfillmentOptions;
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
     * @return {@link Builder} New builder that can be used to create new ProductDefinition objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ProductDefinition pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "validities".
     * 
     * @param pValidities Collection with objects to which the association should be set.
     */
    public Builder setValidities( List<TemporalValidity> pValidities ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pValidities != null) {
        validities = new ArrayList<TemporalValidity>(pValidities);
      }
      else {
        validities = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "id". unique id of this product on this server.
     * 
     * @param pId Value to which the attribute "id" should be set.
     */
    public Builder setId( String pId ) {
      // Assign value to attribute
      id = pId;
      return this;
    }

    /**
     * Method sets the attribute "summary". Internal product description.
     * 
     * @param pSummary Value to which the attribute "summary" should be set.
     */
    public Builder setSummary( String pSummary ) {
      // Assign value to attribute
      summary = pSummary;
      return this;
    }

    /**
     * Method sets the attribute "family". The name of the family the product belongs to. E.g. all "product variants"
     * can be part of the same family.
     * 
     * @param pFamily Value to which the attribute "family" should be set.
     */
    public Builder setFamily( String pFamily ) {
      // Assign value to attribute
      family = pFamily;
      return this;
    }

    /**
     * Method sets the association "type".
     * 
     * @param pType ProductType to which the association "type" should be set.
     */
    public Builder setType( ProductType pType ) {
      type = pType;
      return this;
    }

    /**
     * Method sets the attribute "code". The product code expressed in the provider system (could be a mapping from an
     * even lower-level provider).
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets the association "description".
     * 
     * @param pDescription Text to which the association "description" should be set.
     */
    public Builder setDescription( Text pDescription ) {
      description = pDescription;
      return this;
    }

    /**
     * Method sets the association "conditions". Structured description of the sales or after-sales conditions.
     * 
     * @param pConditions Collection with objects to which the association should be set.
     */
    public Builder setConditions( List<Condition> pConditions ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pConditions != null) {
        conditions = new ArrayList<Condition>(pConditions);
      }
      else {
        conditions = null;
      }
      return this;
    }

    /**
     * Method sets the association "accommodationType". Accommodation type according to UIC
     * 
     * @param pAccommodationType AccommodationType to which the association "accommodationType" should be set.
     */
    public Builder setAccommodationType( AccommodationType pAccommodationType ) {
      accommodationType = pAccommodationType;
      return this;
    }

    /**
     * Method sets the association "accommodationSubType". Defines whether the product is valid for specific
     * accommodation sub types only. Mandatory in case for reservation products.
     * 
     * @param pAccommodationSubType AccommodationSubType to which the association "accommodationSubType" should be set.
     */
    public Builder setAccommodationSubType( AccommodationSubType pAccommodationSubType ) {
      accommodationSubType = pAccommodationSubType;
      return this;
    }

    /**
     * Method sets the association "serviceClass". Defines whether the product is valid for a specific service classes.
     * 
     * @param pServiceClass ServiceClass to which the association "serviceClass" should be set.
     */
    public Builder setServiceClass( ServiceClass pServiceClass ) {
      serviceClass = pServiceClass;
      return this;
    }

    /**
     * Method sets the association "comfortClass".
     * 
     * @param pComfortClass ComfortClass to which the association "comfortClass" should be set.
     */
    public Builder setComfortClass( ComfortClass pComfortClass ) {
      comfortClass = pComfortClass;
      return this;
    }

    /**
     * Method sets the attribute "tariff". Mapping to Tariff 42 of IRS-90918-3 (Hermes/Hosa). Helps the H2O converter in
     * mapping offers to a requested tariff. See legacyReservationParameter.tariff in OSDM offline.
     * 
     * @param pTariff Value to which the attribute "tariff" should be set.
     */
    public Builder setTariff( String pTariff ) {
      // Assign value to attribute
      tariff = pTariff;
      return this;
    }

    /**
     * Method sets the attribute "isTrainBound".
     * 
     * @param pIsTrainBound Value to which the attribute "isTrainBound" should be set.
     */
    public Builder setIsTrainBound( boolean pIsTrainBound ) {
      // Assign value to attribute
      isTrainBound = pIsTrainBound;
      return this;
    }

    /**
     * Method sets the attribute "isReturnProduct".
     * 
     * @param pIsReturnProduct Value to which the attribute "isReturnProduct" should be set.
     */
    public Builder setIsReturnProduct( boolean pIsReturnProduct ) {
      // Assign value to attribute
      isReturnProduct = pIsReturnProduct;
      return this;
    }

    /**
     * Method sets the association "fulfillmentOptions".
     * 
     * @param pFulfillmentOptions Collection with objects to which the association should be set.
     */
    public Builder setFulfillmentOptions( List<FulfillmentOption> pFulfillmentOptions ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pFulfillmentOptions != null) {
        fulfillmentOptions = new ArrayList<FulfillmentOption>(pFulfillmentOptions);
      }
      else {
        fulfillmentOptions = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ProductDefinition. The object will be initialized with the values of the
     * builder.
     * 
     * @return ProductDefinition Created object. The method never returns null.
     */
    public ProductDefinition build( ) {
      return new ProductDefinition(this);
    }

    /**
     * Method creates a new validated instance of class ProductDefinition. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ProductDefinition Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ProductDefinition buildValidated( ) throws ConstraintViolationException {
      ProductDefinition lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "validities".
   * 
   *
   * @return Collection All TemporalValidity objects that belong to the association "validities". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public List<TemporalValidity> getValidities( ) {
    // Return all TemporalValidity objects as unmodifiable collection.
    return Collections.unmodifiableList(validities);
  }

  /**
   * Method sets the association "validities" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pValidities Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setValidities( List<TemporalValidity> pValidities ) {
    // Check of parameter is not required.
    // Remove all objects from association "validities".
    this.clearValidities();
    // If the association is null, removing all entries is sufficient.
    if (pValidities != null) {
      validities = new ArrayList<TemporalValidity>(pValidities);
    }
  }

  /**
   * Method adds the passed TemporalValidity object to the association "validities".
   * 
   * 
   * @param pValidities Object that should be added to the association "validities". The parameter must not be null.
   */
  public void addToValidities( TemporalValidity pValidities ) {
    // Check parameter "pValidities" for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Add passed object to collection of associated TemporalValidity objects.
    validities.add(pValidities);
  }

  /**
   * Method adds all passed objects to the association "validities".
   * 
   * 
   * @param pValidities Collection with all objects that should be added to the association "validities". The parameter
   * must not be null.
   */
  public void addToValidities( Collection<TemporalValidity> pValidities ) {
    // Check parameter "pValidities" for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Add all passed objects.
    for (TemporalValidity lNextObject : pValidities) {
      this.addToValidities(lNextObject);
    }
  }

  /**
   * Method removes the passed TemporalValidity object from the association "validities".
   * 
   * 
   * @param pValidities Object that should be removed from the association "validities". The parameter must not be null.
   */
  public void removeFromValidities( TemporalValidity pValidities ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Remove passed object from collection of associated TemporalValidity objects.
    validities.remove(pValidities);
  }

  /**
   * Method removes all objects from the association "validities".
   * 
   */
  public void clearValidities( ) {
    // Remove all objects from association "validities".
    Collection<TemporalValidity> lValidities = new HashSet<TemporalValidity>(validities);
    Iterator<TemporalValidity> lIterator = lValidities.iterator();
    while (lIterator.hasNext()) {
      this.removeFromValidities(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "id". unique id of this product on this server.
   * 
   * @return String Value to which the attribute "id" is set.
   */
  public String getId( ) {
    return id;
  }

  /**
   * Method sets the attribute "id". unique id of this product on this server.
   * 
   * @param pId Value to which the attribute "id" should be set.
   */
  public void setId( String pId ) {
    // Assign value to attribute
    id = pId;
  }

  /**
   * Method returns the attribute "summary". Internal product description.
   * 
   * @return String Value to which the attribute "summary" is set.
   */
  public String getSummary( ) {
    return summary;
  }

  /**
   * Method sets the attribute "summary". Internal product description.
   * 
   * @param pSummary Value to which the attribute "summary" should be set.
   */
  public void setSummary( String pSummary ) {
    // Assign value to attribute
    summary = pSummary;
  }

  /**
   * Method returns the attribute "family". The name of the family the product belongs to. E.g. all "product variants"
   * can be part of the same family.
   * 
   * @return String Value to which the attribute "family" is set.
   */
  public String getFamily( ) {
    return family;
  }

  /**
   * Method sets the attribute "family". The name of the family the product belongs to. E.g. all "product variants" can
   * be part of the same family.
   * 
   * @param pFamily Value to which the attribute "family" should be set.
   */
  public void setFamily( String pFamily ) {
    // Assign value to attribute
    family = pFamily;
  }

  /**
   * Method returns the association "type".
   * 
   *
   * @return ProductType ProductType to which the association "type" is set.
   */
  public ProductType getType( ) {
    return type;
  }

  /**
   * Method sets the association "type".
   * 
   * 
   * @param pType ProductType to which the association "type" should be set.
   */
  public void setType( ProductType pType ) {
    type = pType;
  }

  /**
   * Method unsets the association "type".
   * 
   */
  public final void unsetType( ) {
    type = null;
  }

  /**
   * Method returns the attribute "code". The product code expressed in the provider system (could be a mapping from an
   * even lower-level provider).
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code". The product code expressed in the provider system (could be a mapping from an
   * even lower-level provider).
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( String pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns the association "description".
   * 
   *
   * @return Text Text to which the association "description" is set.
   */
  public Text getDescription( ) {
    return description;
  }

  /**
   * Method sets the association "description".
   * 
   * 
   * @param pDescription Text to which the association "description" should be set.
   */
  public void setDescription( Text pDescription ) {
    description = pDescription;
  }

  /**
   * Method unsets the association "description".
   * 
   */
  public final void unsetDescription( ) {
    description = null;
  }

  /**
   * Method returns the association "conditions". Structured description of the sales or after-sales conditions.
   *
   * @return Collection All Condition objects that belong to the association "conditions". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<Condition> getConditions( ) {
    // Return all Condition objects as unmodifiable collection.
    return Collections.unmodifiableList(conditions);
  }

  /**
   * Method sets the association "conditions" to the passed collection. All objects that formerly were part of the
   * association will be removed from it. Structured description of the sales or after-sales conditions.
   * 
   * @param pConditions Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setConditions( List<Condition> pConditions ) {
    // Check of parameter is not required.
    // Remove all objects from association "conditions".
    this.clearConditions();
    // If the association is null, removing all entries is sufficient.
    if (pConditions != null) {
      conditions = new ArrayList<Condition>(pConditions);
    }
  }

  /**
   * Method adds the passed Condition object to the association "conditions". Structured description of the sales or
   * after-sales conditions.
   * 
   * @param pConditions Object that should be added to the association "conditions". The parameter must not be null.
   */
  public void addToConditions( Condition pConditions ) {
    // Check parameter "pConditions" for invalid value null.
    Check.checkInvalidParameterNull(pConditions, "pConditions");
    // Add passed object to collection of associated Condition objects.
    conditions.add(pConditions);
  }

  /**
   * Method adds all passed objects to the association "conditions". Structured description of the sales or after-sales
   * conditions.
   * 
   * @param pConditions Collection with all objects that should be added to the association "conditions". The parameter
   * must not be null.
   */
  public void addToConditions( Collection<Condition> pConditions ) {
    // Check parameter "pConditions" for invalid value null.
    Check.checkInvalidParameterNull(pConditions, "pConditions");
    // Add all passed objects.
    for (Condition lNextObject : pConditions) {
      this.addToConditions(lNextObject);
    }
  }

  /**
   * Method removes the passed Condition object from the association "conditions". Structured description of the sales
   * or after-sales conditions.
   * 
   * @param pConditions Object that should be removed from the association "conditions". The parameter must not be null.
   */
  public void removeFromConditions( Condition pConditions ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pConditions, "pConditions");
    // Remove passed object from collection of associated Condition objects.
    conditions.remove(pConditions);
  }

  /**
   * Method removes all objects from the association "conditions". Structured description of the sales or after-sales
   * conditions.
   */
  public void clearConditions( ) {
    // Remove all objects from association "conditions".
    Collection<Condition> lConditions = new HashSet<Condition>(conditions);
    Iterator<Condition> lIterator = lConditions.iterator();
    while (lIterator.hasNext()) {
      this.removeFromConditions(lIterator.next());
    }
  }

  /**
   * Method returns the association "accommodationType". Accommodation type according to UIC
   *
   * @return AccommodationType AccommodationType to which the association "accommodationType" is set.
   */
  public AccommodationType getAccommodationType( ) {
    return accommodationType;
  }

  /**
   * Method sets the association "accommodationType". Accommodation type according to UIC
   * 
   * @param pAccommodationType AccommodationType to which the association "accommodationType" should be set.
   */
  public void setAccommodationType( AccommodationType pAccommodationType ) {
    accommodationType = pAccommodationType;
  }

  /**
   * Method unsets the association "accommodationType". Accommodation type according to UIC
   */
  public final void unsetAccommodationType( ) {
    accommodationType = null;
  }

  /**
   * Method returns the association "accommodationSubType". Defines whether the product is valid for specific
   * accommodation sub types only. Mandatory in case for reservation products.
   *
   * @return AccommodationSubType AccommodationSubType to which the association "accommodationSubType" is set.
   */
  public AccommodationSubType getAccommodationSubType( ) {
    return accommodationSubType;
  }

  /**
   * Method sets the association "accommodationSubType". Defines whether the product is valid for specific accommodation
   * sub types only. Mandatory in case for reservation products.
   * 
   * @param pAccommodationSubType AccommodationSubType to which the association "accommodationSubType" should be set.
   */
  public void setAccommodationSubType( AccommodationSubType pAccommodationSubType ) {
    accommodationSubType = pAccommodationSubType;
  }

  /**
   * Method unsets the association "accommodationSubType". Defines whether the product is valid for specific
   * accommodation sub types only. Mandatory in case for reservation products.
   */
  public final void unsetAccommodationSubType( ) {
    accommodationSubType = null;
  }

  /**
   * Method returns the association "serviceClass". Defines whether the product is valid for a specific service classes.
   *
   * @return ServiceClass ServiceClass to which the association "serviceClass" is set.
   */
  public ServiceClass getServiceClass( ) {
    return serviceClass;
  }

  /**
   * Method sets the association "serviceClass". Defines whether the product is valid for a specific service classes.
   * 
   * @param pServiceClass ServiceClass to which the association "serviceClass" should be set.
   */
  public void setServiceClass( ServiceClass pServiceClass ) {
    serviceClass = pServiceClass;
  }

  /**
   * Method unsets the association "serviceClass". Defines whether the product is valid for a specific service classes.
   */
  public final void unsetServiceClass( ) {
    serviceClass = null;
  }

  /**
   * Method returns the association "comfortClass".
   * 
   *
   * @return ComfortClass ComfortClass to which the association "comfortClass" is set.
   */
  public ComfortClass getComfortClass( ) {
    return comfortClass;
  }

  /**
   * Method sets the association "comfortClass".
   * 
   * 
   * @param pComfortClass ComfortClass to which the association "comfortClass" should be set.
   */
  public void setComfortClass( ComfortClass pComfortClass ) {
    comfortClass = pComfortClass;
  }

  /**
   * Method unsets the association "comfortClass".
   * 
   */
  public final void unsetComfortClass( ) {
    comfortClass = null;
  }

  /**
   * Method returns the attribute "tariff". Mapping to Tariff 42 of IRS-90918-3 (Hermes/Hosa). Helps the H2O converter
   * in mapping offers to a requested tariff. See legacyReservationParameter.tariff in OSDM offline.
   * 
   * @return String Value to which the attribute "tariff" is set.
   */
  public String getTariff( ) {
    return tariff;
  }

  /**
   * Method sets the attribute "tariff". Mapping to Tariff 42 of IRS-90918-3 (Hermes/Hosa). Helps the H2O converter in
   * mapping offers to a requested tariff. See legacyReservationParameter.tariff in OSDM offline.
   * 
   * @param pTariff Value to which the attribute "tariff" should be set.
   */
  public void setTariff( String pTariff ) {
    // Assign value to attribute
    tariff = pTariff;
  }

  /**
   * Method returns the attribute "isTrainBound".
   * 
   * 
   * @return Boolean Value to which the attribute "isTrainBound" is set.
   */
  public boolean getIsTrainBound( ) {
    return isTrainBound;
  }

  /**
   * Method sets the attribute "isTrainBound".
   * 
   * 
   * @param pIsTrainBound Value to which the attribute "isTrainBound" should be set.
   */
  public void setIsTrainBound( boolean pIsTrainBound ) {
    // Assign value to attribute
    isTrainBound = pIsTrainBound;
  }

  /**
   * Method returns the attribute "isReturnProduct".
   * 
   * 
   * @return Boolean Value to which the attribute "isReturnProduct" is set.
   */
  public boolean getIsReturnProduct( ) {
    return isReturnProduct;
  }

  /**
   * Method sets the attribute "isReturnProduct".
   * 
   * 
   * @param pIsReturnProduct Value to which the attribute "isReturnProduct" should be set.
   */
  public void setIsReturnProduct( boolean pIsReturnProduct ) {
    // Assign value to attribute
    isReturnProduct = pIsReturnProduct;
  }

  /**
   * Method returns the association "fulfillmentOptions".
   * 
   *
   * @return Collection All FulfillmentOption objects that belong to the association "fulfillmentOptions". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<FulfillmentOption> getFulfillmentOptions( ) {
    // Return all FulfillmentOption objects as unmodifiable collection.
    return Collections.unmodifiableList(fulfillmentOptions);
  }

  /**
   * Method sets the association "fulfillmentOptions" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pFulfillmentOptions Collection with objects to which the association should be set. The parameter must not
   * be null.
   */
  void setFulfillmentOptions( List<FulfillmentOption> pFulfillmentOptions ) {
    // Check of parameter is not required.
    // Remove all objects from association "fulfillmentOptions".
    this.clearFulfillmentOptions();
    // If the association is null, removing all entries is sufficient.
    if (pFulfillmentOptions != null) {
      fulfillmentOptions = new ArrayList<FulfillmentOption>(pFulfillmentOptions);
    }
  }

  /**
   * Method adds the passed FulfillmentOption object to the association "fulfillmentOptions".
   * 
   * 
   * @param pFulfillmentOptions Object that should be added to the association "fulfillmentOptions". The parameter must
   * not be null.
   */
  public void addToFulfillmentOptions( FulfillmentOption pFulfillmentOptions ) {
    // Check parameter "pFulfillmentOptions" for invalid value null.
    Check.checkInvalidParameterNull(pFulfillmentOptions, "pFulfillmentOptions");
    // Add passed object to collection of associated FulfillmentOption objects.
    fulfillmentOptions.add(pFulfillmentOptions);
  }

  /**
   * Method adds all passed objects to the association "fulfillmentOptions".
   * 
   * 
   * @param pFulfillmentOptions Collection with all objects that should be added to the association
   * "fulfillmentOptions". The parameter must not be null.
   */
  public void addToFulfillmentOptions( Collection<FulfillmentOption> pFulfillmentOptions ) {
    // Check parameter "pFulfillmentOptions" for invalid value null.
    Check.checkInvalidParameterNull(pFulfillmentOptions, "pFulfillmentOptions");
    // Add all passed objects.
    for (FulfillmentOption lNextObject : pFulfillmentOptions) {
      this.addToFulfillmentOptions(lNextObject);
    }
  }

  /**
   * Method removes the passed FulfillmentOption object from the association "fulfillmentOptions".
   * 
   * 
   * @param pFulfillmentOptions Object that should be removed from the association "fulfillmentOptions". The parameter
   * must not be null.
   */
  public void removeFromFulfillmentOptions( FulfillmentOption pFulfillmentOptions ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pFulfillmentOptions, "pFulfillmentOptions");
    // Remove passed object from collection of associated FulfillmentOption objects.
    fulfillmentOptions.remove(pFulfillmentOptions);
  }

  /**
   * Method removes all objects from the association "fulfillmentOptions".
   * 
   */
  public void clearFulfillmentOptions( ) {
    // Remove all objects from association "fulfillmentOptions".
    Collection<FulfillmentOption> lFulfillmentOptions = new HashSet<FulfillmentOption>(fulfillmentOptions);
    Iterator<FulfillmentOption> lIterator = lFulfillmentOptions.iterator();
    while (lIterator.hasNext()) {
      this.removeFromFulfillmentOptions(lIterator.next());
    }
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "id", "" + id));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "summary", "" + summary));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "family", "" + family));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "code", "" + code));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "tariff", "" + tariff));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "isTrainBound", "" + isTrainBound));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "isReturnProduct", "" + isReturnProduct));
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
