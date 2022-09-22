/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
public class PlaceAvailability {
  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "legId".
   */
  public static final String LEGID = "legId";

  /**
   * Constant for the name of attribute "passengerIds".
   */
  public static final String PASSENGERIDS = "passengerIds";

  /**
   * Constant for the name of attribute "inventory".
   */
  public static final String INVENTORY = "inventory";

  /**
   * Constant for the name of attribute "comfortClass".
   */
  public static final String COMFORTCLASS = "comfortClass";

  /**
   * Constant for the name of attribute "accommodationType".
   */
  public static final String ACCOMMODATIONTYPE = "accommodationType";

  /**
   * Constant for the name of attribute "accommodationSubType".
   */
  public static final String ACCOMMODATIONSUBTYPE = "accommodationSubType";

  /**
   * Constant for the name of attribute "numericAvailability".
   */
  public static final String NUMERICAVAILABILITY = "numericAvailability";

  /**
   * Constant for the name of attribute "availablePlaceProperties".
   */
  public static final String AVAILABLEPLACEPROPERTIES = "availablePlaceProperties";

  /**
   * <br/>
   * <b>Example:</b> <code>id-1</code>
   */
  @NotNull
  private String id;

  /**
   * <br/>
   * <b>Example:</b> <code>leg-1</code>
   */
  @NotNull
  private String legId;

  /**
   * <br/>
   * <b>Example:</b> <code>passenger-1</code>
   */
  private String[] passengerIds;

  /**
   * 
   */
  private Inventory inventory;

  /**
   * 
   */
  private ComfortClass comfortClass;

  /**
   * 
   */
  private AccommodationType accommodationType;

  /**
   * 
   */
  private AccommodationSubType accommodationSubType;

  /**
   * number of places <br/>
   * <b>Example:</b> <code>22</code>
   */
  private int numericAvailability;

  /**
   * 
   */
  private List<PlaceProperty> availablePlaceProperties;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PlaceAvailability( ) {
    availablePlaceProperties = new ArrayList<PlaceProperty>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PlaceAvailability( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    id = pBuilder.id;
    legId = pBuilder.legId;
    passengerIds = pBuilder.passengerIds;
    inventory = pBuilder.inventory;
    comfortClass = pBuilder.comfortClass;
    accommodationType = pBuilder.accommodationType;
    accommodationSubType = pBuilder.accommodationSubType;
    numericAvailability = pBuilder.numericAvailability;
    if (pBuilder.availablePlaceProperties != null) {
      availablePlaceProperties = pBuilder.availablePlaceProperties;
    }
    else {
      availablePlaceProperties = new ArrayList<PlaceProperty>();
    }
  }

  /**
   * Class implements builder to create a new instance of class PlaceAvailability. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotNull
    private String id;

    /**
     * 
     */
    @NotNull
    private String legId;

    /**
     * 
     */
    private String[] passengerIds;

    /**
     * 
     */
    private Inventory inventory;

    /**
     * 
     */
    private ComfortClass comfortClass;

    /**
     * 
     */
    private AccommodationType accommodationType;

    /**
     * 
     */
    private AccommodationSubType accommodationSubType;

    /**
     * number of places
     */
    private int numericAvailability;

    /**
     * 
     */
    private List<PlaceProperty> availablePlaceProperties;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PlaceAvailability)} instead of private constructor to create new builder.
     */
    protected Builder( PlaceAvailability pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        id = pObject.id;
        legId = pObject.legId;
        passengerIds = pObject.passengerIds;
        inventory = pObject.inventory;
        comfortClass = pObject.comfortClass;
        accommodationType = pObject.accommodationType;
        accommodationSubType = pObject.accommodationSubType;
        numericAvailability = pObject.numericAvailability;
        availablePlaceProperties = pObject.availablePlaceProperties;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new PlaceAvailability objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PlaceAvailability objects. The method never
     * returns null.
     */
    public static Builder newBuilder( PlaceAvailability pObject ) {
      return new Builder(pObject);
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
     * Method sets the attribute "legId".
     * 
     * @param pLegId Value to which the attribute "legId" should be set.
     */
    public Builder setLegId( String pLegId ) {
      // Assign value to attribute
      legId = pLegId;
      return this;
    }

    /**
     * Method sets the attribute "passengerIds".
     * 
     * @param pPassengerIds Value to which the attribute "passengerIds" should be set.
     */
    public Builder setPassengerIds( String[] pPassengerIds ) {
      // Assign value to attribute
      if (pPassengerIds != null) {
        passengerIds = new String[pPassengerIds.length];
        System.arraycopy(pPassengerIds, 0, passengerIds, 0, pPassengerIds.length);
      }
      else {
        passengerIds = null;
      }
      return this;
    }

    /**
     * Method sets the association "inventory".
     * 
     * @param pInventory Inventory to which the association "inventory" should be set.
     */
    public Builder setInventory( Inventory pInventory ) {
      inventory = pInventory;
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
     * Method sets the association "accommodationType".
     * 
     * @param pAccommodationType AccommodationType to which the association "accommodationType" should be set.
     */
    public Builder setAccommodationType( AccommodationType pAccommodationType ) {
      accommodationType = pAccommodationType;
      return this;
    }

    /**
     * Method sets the association "accommodationSubType".
     * 
     * @param pAccommodationSubType AccommodationSubType to which the association "accommodationSubType" should be set.
     */
    public Builder setAccommodationSubType( AccommodationSubType pAccommodationSubType ) {
      accommodationSubType = pAccommodationSubType;
      return this;
    }

    /**
     * Method sets the attribute "numericAvailability". number of places
     * 
     * @param pNumericAvailability Value to which the attribute "numericAvailability" should be set.
     */
    public Builder setNumericAvailability( int pNumericAvailability ) {
      // Assign value to attribute
      numericAvailability = pNumericAvailability;
      return this;
    }

    /**
     * Method sets the association "availablePlaceProperties".
     * 
     * @param pAvailablePlaceProperties Collection with objects to which the association should be set.
     */
    public Builder setAvailablePlaceProperties( List<PlaceProperty> pAvailablePlaceProperties ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAvailablePlaceProperties != null) {
        availablePlaceProperties = new ArrayList<PlaceProperty>(pAvailablePlaceProperties);
      }
      else {
        availablePlaceProperties = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PlaceAvailability. The object will be initialized with the values of the
     * builder.
     * 
     * @return PlaceAvailability Created object. The method never returns null.
     */
    public PlaceAvailability build( ) {
      return new PlaceAvailability(this);
    }

    /**
     * Method creates a new validated instance of class PlaceAvailability. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return PlaceAvailability Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PlaceAvailability buildValidated( ) throws ConstraintViolationException {
      PlaceAvailability lPOJO = this.build();
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
   * Method returns the attribute "legId".
   * 
   * 
   * @return String Value to which the attribute "legId" is set.
   */
  public String getLegId( ) {
    return legId;
  }

  /**
   * Method sets the attribute "legId".
   * 
   * 
   * @param pLegId Value to which the attribute "legId" should be set.
   */
  public void setLegId( String pLegId ) {
    // Assign value to attribute
    legId = pLegId;
  }

  /**
   * Method returns the attribute "passengerIds".
   * 
   * 
   * @return String Value to which the attribute "passengerIds" is set.
   */
  public String[] getPassengerIds( ) {
    String[] lReturnValue;
    if (passengerIds != null) {
      lReturnValue = new String[passengerIds.length];
      System.arraycopy(passengerIds, 0, lReturnValue, 0, passengerIds.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "passengerIds".
   * 
   * 
   * @param pPassengerIds Value to which the attribute "passengerIds" should be set.
   */
  public void setPassengerIds( String[] pPassengerIds ) {
    // Assign value to attribute
    if (pPassengerIds != null) {
      passengerIds = new String[pPassengerIds.length];
      System.arraycopy(pPassengerIds, 0, passengerIds, 0, pPassengerIds.length);
    }
    else {
      passengerIds = null;
    }
  }

  /**
   * Method returns the association "inventory".
   * 
   *
   * @return Inventory Inventory to which the association "inventory" is set.
   */
  public Inventory getInventory( ) {
    return inventory;
  }

  /**
   * Method sets the association "inventory".
   * 
   * 
   * @param pInventory Inventory to which the association "inventory" should be set.
   */
  public void setInventory( Inventory pInventory ) {
    inventory = pInventory;
  }

  /**
   * Method unsets the association "inventory".
   * 
   */
  public final void unsetInventory( ) {
    inventory = null;
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
   * Method returns the association "accommodationType".
   * 
   *
   * @return AccommodationType AccommodationType to which the association "accommodationType" is set.
   */
  public AccommodationType getAccommodationType( ) {
    return accommodationType;
  }

  /**
   * Method sets the association "accommodationType".
   * 
   * 
   * @param pAccommodationType AccommodationType to which the association "accommodationType" should be set.
   */
  public void setAccommodationType( AccommodationType pAccommodationType ) {
    accommodationType = pAccommodationType;
  }

  /**
   * Method unsets the association "accommodationType".
   * 
   */
  public final void unsetAccommodationType( ) {
    accommodationType = null;
  }

  /**
   * Method returns the association "accommodationSubType".
   * 
   *
   * @return AccommodationSubType AccommodationSubType to which the association "accommodationSubType" is set.
   */
  public AccommodationSubType getAccommodationSubType( ) {
    return accommodationSubType;
  }

  /**
   * Method sets the association "accommodationSubType".
   * 
   * 
   * @param pAccommodationSubType AccommodationSubType to which the association "accommodationSubType" should be set.
   */
  public void setAccommodationSubType( AccommodationSubType pAccommodationSubType ) {
    accommodationSubType = pAccommodationSubType;
  }

  /**
   * Method unsets the association "accommodationSubType".
   * 
   */
  public final void unsetAccommodationSubType( ) {
    accommodationSubType = null;
  }

  /**
   * Method returns the attribute "numericAvailability". number of places
   * 
   * @return int Value to which the attribute "numericAvailability" is set.
   */
  public int getNumericAvailability( ) {
    return numericAvailability;
  }

  /**
   * Method sets the attribute "numericAvailability". number of places
   * 
   * @param pNumericAvailability Value to which the attribute "numericAvailability" should be set.
   */
  public void setNumericAvailability( int pNumericAvailability ) {
    // Assign value to attribute
    numericAvailability = pNumericAvailability;
  }

  /**
   * Method returns the association "availablePlaceProperties".
   * 
   *
   * @return Collection All PlaceProperty objects that belong to the association "availablePlaceProperties". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<PlaceProperty> getAvailablePlaceProperties( ) {
    // Return all PlaceProperty objects as unmodifiable collection.
    return Collections.unmodifiableList(availablePlaceProperties);
  }

  /**
   * Method adds the passed PlaceProperty object to the association "availablePlaceProperties".
   * 
   * 
   * @param pAvailablePlaceProperties Object that should be added to the association "availablePlaceProperties". The
   * parameter must not be null.
   */
  public void addToAvailablePlaceProperties( PlaceProperty pAvailablePlaceProperties ) {
    // Check parameter "pAvailablePlaceProperties" for invalid value null.
    Check.checkInvalidParameterNull(pAvailablePlaceProperties, "pAvailablePlaceProperties");
    // Add passed object to collection of associated PlaceProperty objects.
    availablePlaceProperties.add(pAvailablePlaceProperties);
  }

  /**
   * Method adds all passed objects to the association "availablePlaceProperties".
   * 
   * 
   * @param pAvailablePlaceProperties Collection with all objects that should be added to the association
   * "availablePlaceProperties". The parameter must not be null.
   */
  public void addToAvailablePlaceProperties( Collection<PlaceProperty> pAvailablePlaceProperties ) {
    // Check parameter "pAvailablePlaceProperties" for invalid value null.
    Check.checkInvalidParameterNull(pAvailablePlaceProperties, "pAvailablePlaceProperties");
    // Add all passed objects.
    for (PlaceProperty lNextObject : pAvailablePlaceProperties) {
      this.addToAvailablePlaceProperties(lNextObject);
    }
  }

  /**
   * Method removes the passed PlaceProperty object from the association "availablePlaceProperties".
   * 
   * 
   * @param pAvailablePlaceProperties Object that should be removed from the association "availablePlaceProperties". The
   * parameter must not be null.
   */
  public void removeFromAvailablePlaceProperties( PlaceProperty pAvailablePlaceProperties ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAvailablePlaceProperties, "pAvailablePlaceProperties");
    // Remove passed object from collection of associated PlaceProperty objects.
    availablePlaceProperties.remove(pAvailablePlaceProperties);
  }

  /**
   * Method removes all objects from the association "availablePlaceProperties".
   * 
   */
  public void clearAvailablePlaceProperties( ) {
    // Remove all objects from association "availablePlaceProperties".
    Collection<PlaceProperty> lAvailablePlaceProperties = new HashSet<PlaceProperty>(availablePlaceProperties);
    Iterator<PlaceProperty> lIterator = lAvailablePlaceProperties.iterator();
    while (lIterator.hasNext()) {
      this.removeFromAvailablePlaceProperties(lIterator.next());
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "legId", "" + legId));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "numericAvailability",
        "" + numericAvailability));
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
