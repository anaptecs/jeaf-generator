/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Describes sales and after sales conditions applicable to the product. For a product to be refundable or exchangeable,
 * at least one refund or exchange (respectively) condition must be present.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Condition {
  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * 
   */
  private ConditionType type;

  /**
   * 
   */
  private Text description;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Condition( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Condition( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    type = pBuilder.type;
    description = pBuilder.description;
  }

  /**
   * Class implements builder to create a new instance of class Condition. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ConditionType type;

    /**
     * 
     */
    private Text description;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Condition)} instead of private constructor to create new builder.
     */
    protected Builder( Condition pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        type = pObject.type;
        description = pObject.description;
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
     * @return {@link Builder} New builder that can be used to create new Condition objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Condition pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "type".
     * 
     * @param pType ConditionType to which the association "type" should be set.
     */
    public Builder setType( ConditionType pType ) {
      type = pType;
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
     * Method creates a new instance of class Condition. The object will be initialized with the values of the builder.
     * 
     * @return Condition Created object. The method never returns null.
     */
    public Condition build( ) {
      return new Condition(this);
    }

    /**
     * Method creates a new validated instance of class Condition. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Condition Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Condition buildValidated( ) throws ConstraintViolationException {
      Condition lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "type".
   * 
   *
   * @return ConditionType ConditionType to which the association "type" is set.
   */
  public ConditionType getType( ) {
    return type;
  }

  /**
   * Method sets the association "type".
   * 
   * 
   * @param pType ConditionType to which the association "type" should be set.
   */
  public void setType( ConditionType pType ) {
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
