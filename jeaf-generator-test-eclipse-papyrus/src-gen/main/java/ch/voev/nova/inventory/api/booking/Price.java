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

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Price {
  /**
   * Constant for the name of attribute "currency".
   */
  public static final String CURRENCY = "currency";

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT = "amount";

  /**
   * Constant for the name of attribute "scale".
   */
  public static final String SCALE = "scale";

  /**
   * Constant for the name of attribute "vats".
   */
  public static final String VATS = "vats";

  /**
   * 
   */
  private Currency currency;

  /**
   * amount in cents
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
  private List<VAT> vats = new ArrayList<VAT>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Price( ) {
    scale = 2;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Price( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    currency = pBuilder.currency;
    amount = pBuilder.amount;
    scale = pBuilder.scale;
    if (pBuilder.vats != null) {
      vats.addAll(pBuilder.vats);
    }
  }

  /**
   * Class implements builder to create a new instance of class Price. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Currency currency;

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
    private List<VAT> vats;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Price)} instead of private constructor to create new builder.
     */
    protected Builder( Price pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        currency = pObject.currency;
        amount = pObject.amount;
        scale = pObject.scale;
        vats = pObject.vats;
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
     * @return {@link Builder} New builder that can be used to create new Price objects. The method never returns null.
     */
    public static Builder newBuilder( Price pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "currency".
     * 
     * @param pCurrency Currency to which the association "currency" should be set.
     */
    public Builder setCurrency( Currency pCurrency ) {
      currency = pCurrency;
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
     * Method sets the association "vats".
     * 
     * @param pVats Collection with objects to which the association should be set.
     */
    public Builder setVats( List<VAT> pVats ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pVats != null) {
        vats = new ArrayList<VAT>(pVats);
      }
      else {
        vats = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Price. The object will be initialized with the values of the builder.
     * 
     * @return Price Created object. The method never returns null.
     */
    public Price build( ) {
      return new Price(this);
    }

    /**
     * Method creates a new validated instance of class Price. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Price Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Price buildValidated( ) throws ConstraintViolationException {
      Price lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "currency".
   * 
   *
   * @return Currency Currency to which the association "currency" is set.
   */
  public Currency getCurrency( ) {
    return currency;
  }

  /**
   * Method sets the association "currency".
   * 
   * 
   * @param pCurrency Currency to which the association "currency" should be set.
   */
  public void setCurrency( Currency pCurrency ) {
    currency = pCurrency;
  }

  /**
   * Method unsets the association "currency".
   * 
   */
  public final void unsetCurrency( ) {
    currency = null;
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
   * Method returns the association "vats".
   * 
   *
   * @return Collection All VAT objects that belong to the association "vats". The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<VAT> getVats( ) {
    // Return all VAT objects as unmodifiable collection.
    return Collections.unmodifiableList(vats);
  }

  /**
   * Method sets the association "vats" to the passed collection. All objects that formerly were part of the association
   * will be removed from it.
   * 
   * 
   * @param pVats Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setVats( List<VAT> pVats ) {
    // Check of parameter is not required.
    // Remove all objects from association "vats".
    this.clearVats();
    // If the association is null, removing all entries is sufficient.
    if (pVats != null) {
      vats = new ArrayList<VAT>(pVats);
    }
  }

  /**
   * Method adds the passed VAT object to the association "vats".
   * 
   * 
   * @param pVats Object that should be added to the association "vats". The parameter must not be null.
   */
  public void addToVats( VAT pVats ) {
    // Check parameter "pVats" for invalid value null.
    Check.checkInvalidParameterNull(pVats, "pVats");
    // Add passed object to collection of associated VAT objects.
    vats.add(pVats);
  }

  /**
   * Method adds all passed objects to the association "vats".
   * 
   * 
   * @param pVats Collection with all objects that should be added to the association "vats". The parameter must not be
   * null.
   */
  public void addToVats( Collection<VAT> pVats ) {
    // Check parameter "pVats" for invalid value null.
    Check.checkInvalidParameterNull(pVats, "pVats");
    // Add all passed objects.
    for (VAT lNextObject : pVats) {
      this.addToVats(lNextObject);
    }
  }

  /**
   * Method removes the passed VAT object from the association "vats".
   * 
   * 
   * @param pVats Object that should be removed from the association "vats". The parameter must not be null.
   */
  public void removeFromVats( VAT pVats ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pVats, "pVats");
    // Remove passed object from collection of associated VAT objects.
    vats.remove(pVats);
  }

  /**
   * Method removes all objects from the association "vats".
   * 
   */
  public void clearVats( ) {
    // Remove all objects from association "vats".
    Collection<VAT> lVats = new HashSet<VAT>(vats);
    Iterator<VAT> lIterator = lVats.iterator();
    while (lIterator.hasNext()) {
      this.removeFromVats(lIterator.next());
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "amount", "" + amount));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "scale", "" + scale));
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
