/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
public class ReservationOffer {
  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "productCode".
   */
  public static final String PRODUCTCODE = "productCode";

  /**
   * Constant for the name of attribute "price".
   */
  public static final String PRICE = "price";

  /**
   * Constant for the name of attribute "availableFulfillmentTypes".
   */
  public static final String AVAILABLEFULFILLMENTTYPES = "availableFulfillmentTypes";

  /**
   * Constant for the name of attribute "placeAvailabilityId".
   */
  public static final String PLACEAVAILABILITYID = "placeAvailabilityId";

  /**
   * 
   */
  @NotNull
  private String id;

  /**
   * The product code expressed in the provider system (could be a mapping from an even lower-level provider). <br/>
   * <b>Example:</b> <code>Reservierungsentgelt</code>
   */
  @NotNull
  private String productCode;

  /**
   * 
   */
  private Price price;

  /**
   * 
   */
  private List<FulfillmentType> availableFulfillmentTypes;

  /**
   * 
   */
  @NotNull
  private String placeAvailabilityId;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ReservationOffer( ) {
    availableFulfillmentTypes = new ArrayList<FulfillmentType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReservationOffer( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    id = pBuilder.id;
    productCode = pBuilder.productCode;
    price = pBuilder.price;
    if (pBuilder.availableFulfillmentTypes != null) {
      availableFulfillmentTypes = pBuilder.availableFulfillmentTypes;
    }
    else {
      availableFulfillmentTypes = new ArrayList<FulfillmentType>();
    }
    placeAvailabilityId = pBuilder.placeAvailabilityId;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ReservationOffer objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ReservationOffer objects. The method never
   * returns null.
   */
  public static Builder builder( ReservationOffer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ReservationOffer. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotNull
    private String id;

    /**
     * The product code expressed in the provider system (could be a mapping from an even lower-level provider).
     */
    @NotNull
    private String productCode;

    /**
     * 
     */
    private Price price;

    /**
     * 
     */
    private List<FulfillmentType> availableFulfillmentTypes;

    /**
     * 
     */
    @NotNull
    private String placeAvailabilityId;

    /**
     * Use {@link ReservationOffer#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReservationOffer#builder(ReservationOffer)} instead of private constructor to create new builder.
     */
    protected Builder( ReservationOffer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        id = pObject.id;
        productCode = pObject.productCode;
        price = pObject.price;
        availableFulfillmentTypes = pObject.availableFulfillmentTypes;
        placeAvailabilityId = pObject.placeAvailabilityId;
      }
    }

    /**
     * Method sets the attribute "id".
     * 
     * @param pId Value to which the attribute "id" should be set.
     */
    public Builder setId( String pId ) {
      // Assign value to attribute
      id = pId;
      return this;
    }

    /**
     * Method sets the attribute "productCode". The product code expressed in the provider system (could be a mapping
     * from an even lower-level provider).
     * 
     * @param pProductCode Value to which the attribute "productCode" should be set.
     */
    public Builder setProductCode( String pProductCode ) {
      // Assign value to attribute
      productCode = pProductCode;
      return this;
    }

    /**
     * Method sets the association "price".
     * 
     * @param pPrice Price to which the association "price" should be set.
     */
    public Builder setPrice( Price pPrice ) {
      price = pPrice;
      return this;
    }

    /**
     * Method sets the association "availableFulfillmentTypes".
     * 
     * @param pAvailableFulfillmentTypes Collection with objects to which the association should be set.
     */
    public Builder setAvailableFulfillmentTypes( List<FulfillmentType> pAvailableFulfillmentTypes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAvailableFulfillmentTypes != null) {
        availableFulfillmentTypes = new ArrayList<FulfillmentType>(pAvailableFulfillmentTypes);
      }
      else {
        availableFulfillmentTypes = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "placeAvailabilityId".
     * 
     * @param pPlaceAvailabilityId Value to which the attribute "placeAvailabilityId" should be set.
     */
    public Builder setPlaceAvailabilityId( String pPlaceAvailabilityId ) {
      // Assign value to attribute
      placeAvailabilityId = pPlaceAvailabilityId;
      return this;
    }

    /**
     * Method creates a new instance of class ReservationOffer. The object will be initialized with the values of the
     * builder.
     * 
     * @return ReservationOffer Created object. The method never returns null.
     */
    public ReservationOffer build( ) {
      return new ReservationOffer(this);
    }

    /**
     * Method creates a new validated instance of class ReservationOffer. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return ReservationOffer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReservationOffer buildValidated( ) throws ConstraintViolationException {
      ReservationOffer lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "id".
   * 
   * 
   * @return String Value to which the attribute "id" is set.
   */
  public String getId( ) {
    return id;
  }

  /**
   * Method sets the attribute "id".
   * 
   * 
   * @param pId Value to which the attribute "id" should be set.
   */
  public void setId( String pId ) {
    // Assign value to attribute
    id = pId;
  }

  /**
   * Method returns the attribute "productCode". The product code expressed in the provider system (could be a mapping
   * from an even lower-level provider).
   * 
   * @return String Value to which the attribute "productCode" is set.
   */
  public String getProductCode( ) {
    return productCode;
  }

  /**
   * Method sets the attribute "productCode". The product code expressed in the provider system (could be a mapping from
   * an even lower-level provider).
   * 
   * @param pProductCode Value to which the attribute "productCode" should be set.
   */
  public void setProductCode( String pProductCode ) {
    // Assign value to attribute
    productCode = pProductCode;
  }

  /**
   * Method returns the association "price".
   * 
   *
   * @return Price Price to which the association "price" is set.
   */
  public Price getPrice( ) {
    return price;
  }

  /**
   * Method sets the association "price".
   * 
   * 
   * @param pPrice Price to which the association "price" should be set.
   */
  public void setPrice( Price pPrice ) {
    price = pPrice;
  }

  /**
   * Method unsets the association "price".
   * 
   */
  public final void unsetPrice( ) {
    price = null;
  }

  /**
   * Method returns the association "availableFulfillmentTypes".
   * 
   *
   * @return Collection All FulfillmentType objects that belong to the association "availableFulfillmentTypes". The
   * method never returns null and the returned collection is unmodifiable.
   */
  public List<FulfillmentType> getAvailableFulfillmentTypes( ) {
    // Return all FulfillmentType objects as unmodifiable collection.
    return Collections.unmodifiableList(availableFulfillmentTypes);
  }

  /**
   * Method adds the passed FulfillmentType object to the association "availableFulfillmentTypes".
   * 
   * 
   * @param pAvailableFulfillmentTypes Object that should be added to the association "availableFulfillmentTypes". The
   * parameter must not be null.
   */
  public void addToAvailableFulfillmentTypes( FulfillmentType pAvailableFulfillmentTypes ) {
    // Check parameter "pAvailableFulfillmentTypes" for invalid value null.
    Check.checkInvalidParameterNull(pAvailableFulfillmentTypes, "pAvailableFulfillmentTypes");
    // Add passed object to collection of associated FulfillmentType objects.
    availableFulfillmentTypes.add(pAvailableFulfillmentTypes);
  }

  /**
   * Method adds all passed objects to the association "availableFulfillmentTypes".
   * 
   * 
   * @param pAvailableFulfillmentTypes Collection with all objects that should be added to the association
   * "availableFulfillmentTypes". The parameter must not be null.
   */
  public void addToAvailableFulfillmentTypes( Collection<FulfillmentType> pAvailableFulfillmentTypes ) {
    // Check parameter "pAvailableFulfillmentTypes" for invalid value null.
    Check.checkInvalidParameterNull(pAvailableFulfillmentTypes, "pAvailableFulfillmentTypes");
    // Add all passed objects.
    for (FulfillmentType lNextObject : pAvailableFulfillmentTypes) {
      this.addToAvailableFulfillmentTypes(lNextObject);
    }
  }

  /**
   * Method removes the passed FulfillmentType object from the association "availableFulfillmentTypes".
   * 
   * 
   * @param pAvailableFulfillmentTypes Object that should be removed from the association "availableFulfillmentTypes".
   * The parameter must not be null.
   */
  public void removeFromAvailableFulfillmentTypes( FulfillmentType pAvailableFulfillmentTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAvailableFulfillmentTypes, "pAvailableFulfillmentTypes");
    // Remove passed object from collection of associated FulfillmentType objects.
    availableFulfillmentTypes.remove(pAvailableFulfillmentTypes);
  }

  /**
   * Method removes all objects from the association "availableFulfillmentTypes".
   * 
   */
  public void clearAvailableFulfillmentTypes( ) {
    // Remove all objects from association "availableFulfillmentTypes".
    availableFulfillmentTypes.clear();
  }

  /**
   * Method returns the attribute "placeAvailabilityId".
   * 
   * 
   * @return String Value to which the attribute "placeAvailabilityId" is set.
   */
  public String getPlaceAvailabilityId( ) {
    return placeAvailabilityId;
  }

  /**
   * Method sets the attribute "placeAvailabilityId".
   * 
   * 
   * @param pPlaceAvailabilityId Value to which the attribute "placeAvailabilityId" should be set.
   */
  public void setPlaceAvailabilityId( String pPlaceAvailabilityId ) {
    // Assign value to attribute
    placeAvailabilityId = pPlaceAvailabilityId;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "productCode", "" + productCode));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "placeAvailabilityId",
        "" + placeAvailabilityId));
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
