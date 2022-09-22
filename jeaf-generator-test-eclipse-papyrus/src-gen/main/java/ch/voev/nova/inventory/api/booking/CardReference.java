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
public class CardReference {
  /**
   * Constant for the name of attribute "types".
   */
  public static final String TYPES = "types";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "number".
   */
  public static final String NUMBER = "number";

  /**
   * Constant for the name of attribute "issuer".
   */
  public static final String ISSUER = "issuer";

  /**
   * Types of card. One card can have multiple roles, such as loyalty and reduction
   */
  private List<CardType> types;

  /**
   * Code of the card type according to issuer.
   */
  @NotNull
  private String code;

  /**
   * Card name for printing on fulfillments.
   */
  private String name;

  /**
   * Unique number identifying the card.
   */
  private String number;

  /**
   * 
   */
  private Company issuer;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected CardReference( ) {
    types = new ArrayList<CardType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CardReference( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.types != null) {
      types = pBuilder.types;
    }
    else {
      types = new ArrayList<CardType>();
    }
    code = pBuilder.code;
    name = pBuilder.name;
    number = pBuilder.number;
    issuer = pBuilder.issuer;
  }

  /**
   * Class implements builder to create a new instance of class CardReference. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Types of card. One card can have multiple roles, such as loyalty and reduction
     */
    private List<CardType> types;

    /**
     * Code of the card type according to issuer.
     */
    @NotNull
    private String code;

    /**
     * Card name for printing on fulfillments.
     */
    private String name;

    /**
     * Unique number identifying the card.
     */
    private String number;

    /**
     * 
     */
    private Company issuer;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(CardReference)} instead of private constructor to create new builder.
     */
    protected Builder( CardReference pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        types = pObject.types;
        code = pObject.code;
        name = pObject.name;
        number = pObject.number;
        issuer = pObject.issuer;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new CardReference objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new CardReference objects. The method never
     * returns null.
     */
    public static Builder newBuilder( CardReference pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "types". Types of card. One card can have multiple roles, such as loyalty and
     * reduction
     * 
     * @param pTypes Collection with objects to which the association should be set.
     */
    public Builder setTypes( List<CardType> pTypes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTypes != null) {
        types = new ArrayList<CardType>(pTypes);
      }
      else {
        types = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "code". Code of the card type according to issuer.
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets the attribute "name". Card name for printing on fulfillments.
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "number". Unique number identifying the card.
     * 
     * @param pNumber Value to which the attribute "number" should be set.
     */
    public Builder setNumber( String pNumber ) {
      // Assign value to attribute
      number = pNumber;
      return this;
    }

    /**
     * Method sets the association "issuer".
     * 
     * @param pIssuer Company to which the association "issuer" should be set.
     */
    public Builder setIssuer( Company pIssuer ) {
      issuer = pIssuer;
      return this;
    }

    /**
     * Method creates a new instance of class CardReference. The object will be initialized with the values of the
     * builder.
     * 
     * @return CardReference Created object. The method never returns null.
     */
    public CardReference build( ) {
      return new CardReference(this);
    }

    /**
     * Method creates a new validated instance of class CardReference. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return CardReference Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CardReference buildValidated( ) throws ConstraintViolationException {
      CardReference lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "types". Types of card. One card can have multiple roles, such as loyalty and
   * reduction
   *
   * @return Collection All CardType objects that belong to the association "types". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<CardType> getTypes( ) {
    // Return all CardType objects as unmodifiable collection.
    return Collections.unmodifiableList(types);
  }

  /**
   * Method adds the passed CardType object to the association "types". Types of card. One card can have multiple roles,
   * such as loyalty and reduction
   * 
   * @param pTypes Object that should be added to the association "types". The parameter must not be null.
   */
  public void addToTypes( CardType pTypes ) {
    // Check parameter "pTypes" for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Add passed object to collection of associated CardType objects.
    types.add(pTypes);
  }

  /**
   * Method adds all passed objects to the association "types". Types of card. One card can have multiple roles, such as
   * loyalty and reduction
   * 
   * @param pTypes Collection with all objects that should be added to the association "types". The parameter must not
   * be null.
   */
  public void addToTypes( Collection<CardType> pTypes ) {
    // Check parameter "pTypes" for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Add all passed objects.
    for (CardType lNextObject : pTypes) {
      this.addToTypes(lNextObject);
    }
  }

  /**
   * Method removes the passed CardType object from the association "types". Types of card. One card can have multiple
   * roles, such as loyalty and reduction
   * 
   * @param pTypes Object that should be removed from the association "types". The parameter must not be null.
   */
  public void removeFromTypes( CardType pTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Remove passed object from collection of associated CardType objects.
    types.remove(pTypes);
  }

  /**
   * Method removes all objects from the association "types". Types of card. One card can have multiple roles, such as
   * loyalty and reduction
   */
  public void clearTypes( ) {
    // Remove all objects from association "types".
    Collection<CardType> lTypes = new HashSet<CardType>(types);
    Iterator<CardType> lIterator = lTypes.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTypes(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "code". Code of the card type according to issuer.
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code". Code of the card type according to issuer.
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( String pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns the attribute "name". Card name for printing on fulfillments.
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name". Card name for printing on fulfillments.
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "number". Unique number identifying the card.
   * 
   * @return String Value to which the attribute "number" is set.
   */
  public String getNumber( ) {
    return number;
  }

  /**
   * Method sets the attribute "number". Unique number identifying the card.
   * 
   * @param pNumber Value to which the attribute "number" should be set.
   */
  public void setNumber( String pNumber ) {
    // Assign value to attribute
    number = pNumber;
  }

  /**
   * Method returns the association "issuer".
   * 
   *
   * @return Company Company to which the association "issuer" is set.
   */
  public Company getIssuer( ) {
    return issuer;
  }

  /**
   * Method sets the association "issuer".
   * 
   * 
   * @param pIssuer Company to which the association "issuer" should be set.
   */
  public void setIssuer( Company pIssuer ) {
    issuer = pIssuer;
  }

  /**
   * Method unsets the association "issuer".
   * 
   */
  public final void unsetIssuer( ) {
    issuer = null;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "number", "" + number));
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
