/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.time.LocalDate;
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
 * Minimal specification of a passenger to request offers.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PassengerSpecification {
  /**
   * Constant for the name of attribute "externalRef".
   */
  public static final String EXTERNALREF = "externalRef";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH = "dateOfBirth";

  /**
   * Constant for the name of attribute "cards".
   */
  public static final String CARDS = "cards";

  /**
   * Constant for the name of attribute "prmNeeds".
   */
  public static final String PRMNEEDS = "prmNeeds";

  /**
   * A stable reference to a passenger from other elements, or from caller system. When received in input of a
   * trip-offers-collection request, it must be echoed back in the response. <br/>
   * <b>Example:</b> <code>TK-id-12345</code>
   */
  @NotNull
  private String externalRef;

  /**
   * <br/>
   * <b>Example:</b> <code>PERSON</code>
   */
  private PassengerType type;

  /**
   * Date of birth of the passenger. Only needed for passengers of type persons, family child, PRMS and wheelchair.
   */
  private LocalDate dateOfBirth;

  /**
   * reduction or loyalty cards owned by the passenger
   */
  private List<CardReference> cards;

  /**
   * For the persons with reduced mobility (PRMs) its specific needs for support are expressed.
   */
  private List<PRMNeedType> prmNeeds;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PassengerSpecification( ) {
    cards = new ArrayList<CardReference>();
    prmNeeds = new ArrayList<PRMNeedType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PassengerSpecification( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    externalRef = pBuilder.externalRef;
    type = pBuilder.type;
    dateOfBirth = pBuilder.dateOfBirth;
    if (pBuilder.cards != null) {
      cards = pBuilder.cards;
    }
    else {
      cards = new ArrayList<CardReference>();
    }
    if (pBuilder.prmNeeds != null) {
      prmNeeds = pBuilder.prmNeeds;
    }
    else {
      prmNeeds = new ArrayList<PRMNeedType>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PassengerSpecification objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PassengerSpecification objects. The method never
   * returns null.
   */
  public static Builder builder( PassengerSpecification pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PassengerSpecification. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * A stable reference to a passenger from other elements, or from caller system. When received in input of a
     * trip-offers-collection request, it must be echoed back in the response.
     */
    @NotNull
    private String externalRef;

    /**
     * 
     */
    private PassengerType type;

    /**
     * Date of birth of the passenger. Only needed for passengers of type persons, family child, PRMS and wheelchair.
     */
    private LocalDate dateOfBirth;

    /**
     * reduction or loyalty cards owned by the passenger
     */
    private List<CardReference> cards;

    /**
     * For the persons with reduced mobility (PRMs) its specific needs for support are expressed.
     */
    private List<PRMNeedType> prmNeeds;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PassengerSpecification)} instead of private constructor to create new builder.
     */
    protected Builder( PassengerSpecification pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        externalRef = pObject.externalRef;
        type = pObject.type;
        dateOfBirth = pObject.dateOfBirth;
        cards = pObject.cards;
        prmNeeds = pObject.prmNeeds;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new PassengerSpecification objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new PassengerSpecification objects. The method
     * never returns null.
     */
    public static Builder newBuilder( PassengerSpecification pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "externalRef". A stable reference to a passenger from other elements, or from caller
     * system. When received in input of a trip-offers-collection request, it must be echoed back in the response.
     * 
     * @param pExternalRef Value to which the attribute "externalRef" should be set.
     */
    public Builder setExternalRef( String pExternalRef ) {
      // Assign value to attribute
      externalRef = pExternalRef;
      return this;
    }

    /**
     * Method sets the attribute "type".
     * 
     * @param pType Value to which the attribute "type" should be set.
     */
    public Builder setType( PassengerType pType ) {
      // Assign value to attribute
      type = pType;
      return this;
    }

    /**
     * Method sets the attribute "dateOfBirth". Date of birth of the passenger. Only needed for passengers of type
     * persons, family child, PRMS and wheelchair.
     * 
     * @param pDateOfBirth Value to which the attribute "dateOfBirth" should be set.
     */
    public Builder setDateOfBirth( LocalDate pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    /**
     * Method sets the association "cards". reduction or loyalty cards owned by the passenger
     * 
     * @param pCards Collection with objects to which the association should be set.
     */
    public Builder setCards( List<CardReference> pCards ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCards != null) {
        cards = new ArrayList<CardReference>(pCards);
      }
      else {
        cards = null;
      }
      return this;
    }

    /**
     * Method sets the association "prmNeeds". For the persons with reduced mobility (PRMs) its specific needs for
     * support are expressed.
     * 
     * @param pPrmNeeds Collection with objects to which the association should be set.
     */
    public Builder setPrmNeeds( List<PRMNeedType> pPrmNeeds ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPrmNeeds != null) {
        prmNeeds = new ArrayList<PRMNeedType>(pPrmNeeds);
      }
      else {
        prmNeeds = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PassengerSpecification. The object will be initialized with the values of
     * the builder.
     * 
     * @return PassengerSpecification Created object. The method never returns null.
     */
    public PassengerSpecification build( ) {
      return new PassengerSpecification(this);
    }

    /**
     * Method creates a new validated instance of class PassengerSpecification. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return PassengerSpecification Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PassengerSpecification buildValidated( ) throws ConstraintViolationException {
      PassengerSpecification lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "externalRef". A stable reference to a passenger from other elements, or from caller
   * system. When received in input of a trip-offers-collection request, it must be echoed back in the response.
   * 
   * @return String Value to which the attribute "externalRef" is set.
   */
  public String getExternalRef( ) {
    return externalRef;
  }

  /**
   * Method sets the attribute "externalRef". A stable reference to a passenger from other elements, or from caller
   * system. When received in input of a trip-offers-collection request, it must be echoed back in the response.
   * 
   * @param pExternalRef Value to which the attribute "externalRef" should be set.
   */
  public void setExternalRef( String pExternalRef ) {
    // Assign value to attribute
    externalRef = pExternalRef;
  }

  /**
   * Method returns the attribute "type".
   * 
   * 
   * @return PassengerType Value to which the attribute "type" is set.
   */
  public PassengerType getType( ) {
    return type;
  }

  /**
   * Method sets the attribute "type".
   * 
   * 
   * @param pType Value to which the attribute "type" should be set.
   */
  public void setType( PassengerType pType ) {
    // Assign value to attribute
    type = pType;
  }

  /**
   * Method returns the attribute "dateOfBirth". Date of birth of the passenger. Only needed for passengers of type
   * persons, family child, PRMS and wheelchair.
   * 
   * @return LocalDate Value to which the attribute "dateOfBirth" is set.
   */
  public LocalDate getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets the attribute "dateOfBirth". Date of birth of the passenger. Only needed for passengers of type
   * persons, family child, PRMS and wheelchair.
   * 
   * @param pDateOfBirth Value to which the attribute "dateOfBirth" should be set.
   */
  public void setDateOfBirth( LocalDate pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
  }

  /**
   * Method returns the association "cards". reduction or loyalty cards owned by the passenger
   *
   * @return Collection All CardReference objects that belong to the association "cards". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<CardReference> getCards( ) {
    // Return all CardReference objects as unmodifiable collection.
    return Collections.unmodifiableList(cards);
  }

  /**
   * Method adds the passed CardReference object to the association "cards". reduction or loyalty cards owned by the
   * passenger
   * 
   * @param pCards Object that should be added to the association "cards". The parameter must not be null.
   */
  public void addToCards( CardReference pCards ) {
    // Check parameter "pCards" for invalid value null.
    Check.checkInvalidParameterNull(pCards, "pCards");
    // Add passed object to collection of associated CardReference objects.
    cards.add(pCards);
  }

  /**
   * Method adds all passed objects to the association "cards". reduction or loyalty cards owned by the passenger
   * 
   * @param pCards Collection with all objects that should be added to the association "cards". The parameter must not
   * be null.
   */
  public void addToCards( Collection<CardReference> pCards ) {
    // Check parameter "pCards" for invalid value null.
    Check.checkInvalidParameterNull(pCards, "pCards");
    // Add all passed objects.
    for (CardReference lNextObject : pCards) {
      this.addToCards(lNextObject);
    }
  }

  /**
   * Method removes the passed CardReference object from the association "cards". reduction or loyalty cards owned by
   * the passenger
   * 
   * @param pCards Object that should be removed from the association "cards". The parameter must not be null.
   */
  public void removeFromCards( CardReference pCards ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCards, "pCards");
    // Remove passed object from collection of associated CardReference objects.
    cards.remove(pCards);
  }

  /**
   * Method removes all objects from the association "cards". reduction or loyalty cards owned by the passenger
   */
  public void clearCards( ) {
    // Remove all objects from association "cards".
    cards.clear();
  }

  /**
   * Method returns the association "prmNeeds". For the persons with reduced mobility (PRMs) its specific needs for
   * support are expressed.
   *
   * @return Collection All PRMNeedType objects that belong to the association "prmNeeds". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<PRMNeedType> getPrmNeeds( ) {
    // Return all PRMNeedType objects as unmodifiable collection.
    return Collections.unmodifiableList(prmNeeds);
  }

  /**
   * Method adds the passed PRMNeedType object to the association "prmNeeds". For the persons with reduced mobility
   * (PRMs) its specific needs for support are expressed.
   * 
   * @param pPrmNeeds Object that should be added to the association "prmNeeds". The parameter must not be null.
   */
  public void addToPrmNeeds( PRMNeedType pPrmNeeds ) {
    // Check parameter "pPrmNeeds" for invalid value null.
    Check.checkInvalidParameterNull(pPrmNeeds, "pPrmNeeds");
    // Add passed object to collection of associated PRMNeedType objects.
    prmNeeds.add(pPrmNeeds);
  }

  /**
   * Method adds all passed objects to the association "prmNeeds". For the persons with reduced mobility (PRMs) its
   * specific needs for support are expressed.
   * 
   * @param pPrmNeeds Collection with all objects that should be added to the association "prmNeeds". The parameter must
   * not be null.
   */
  public void addToPrmNeeds( Collection<PRMNeedType> pPrmNeeds ) {
    // Check parameter "pPrmNeeds" for invalid value null.
    Check.checkInvalidParameterNull(pPrmNeeds, "pPrmNeeds");
    // Add all passed objects.
    for (PRMNeedType lNextObject : pPrmNeeds) {
      this.addToPrmNeeds(lNextObject);
    }
  }

  /**
   * Method removes the passed PRMNeedType object from the association "prmNeeds". For the persons with reduced mobility
   * (PRMs) its specific needs for support are expressed.
   * 
   * @param pPrmNeeds Object that should be removed from the association "prmNeeds". The parameter must not be null.
   */
  public void removeFromPrmNeeds( PRMNeedType pPrmNeeds ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPrmNeeds, "pPrmNeeds");
    // Remove passed object from collection of associated PRMNeedType objects.
    prmNeeds.remove(pPrmNeeds);
  }

  /**
   * Method removes all objects from the association "prmNeeds". For the persons with reduced mobility (PRMs) its
   * specific needs for support are expressed.
   */
  public void clearPrmNeeds( ) {
    // Remove all objects from association "prmNeeds".
    prmNeeds.clear();
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
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "externalRef", "" + externalRef));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "type", "" + type));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "dateOfBirth", "" + dateOfBirth));
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
