/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Channel implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Type of the channel
   */
  @NotNull
  private ChannelType channelType;

  /**
   * The business code of the channel
   */
  @NotNull
  private ChannelCode channelCode;

  /**
   * 
   */
  private final int code;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private final boolean selfServiceChannel;

  /**
   * 
   */
  private transient Reseller reseller;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Channel( ) {
    code = 0;
    selfServiceChannel = true;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Channel( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    channelType = pBuilder.channelType;
    channelCode = pBuilder.channelCode;
    code = pBuilder.code;
    selfServiceChannel = pBuilder.selfServiceChannel;
    reseller = pBuilder.reseller;
  }

  /**
   * Class implements builder to create a new instance of class Channel. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Type of the channel
     */
    private ChannelType channelType;

    /**
     * The business code of the channel
     */
    private ChannelCode channelCode;

    /**
     * 
     */
    private int code;

    /**
     * 
     */
    private boolean selfServiceChannel = true;

    /**
     * 
     */
    private Reseller reseller;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Channel)} instead of private constructor to create new builder.
     */
    protected Builder( Channel pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        channelType = pObject.channelType;
        channelCode = pObject.channelCode;
        code = pObject.code;
        selfServiceChannel = pObject.selfServiceChannel;
        reseller = pObject.reseller;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Channel objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Channel objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Channel pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "channelType". Type of the channel
     * 
     * @param pChannelType ChannelType to which the association "channelType" should be set.
     */
    public Builder setChannelType( ChannelType pChannelType ) {
      channelType = pChannelType;
      return this;
    }

    /**
     * Method sets the association "channelCode". The business code of the channel
     * 
     * @param pChannelCode ChannelCode to which the association "channelCode" should be set.
     */
    public Builder setChannelCode( ChannelCode pChannelCode ) {
      channelCode = pChannelCode;
      return this;
    }

    /**
     * Method sets the attribute "code".
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( int pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets the attribute "selfServiceChannel".
     * 
     * @param pSelfServiceChannel Value to which the attribute "selfServiceChannel" should be set.
     */
    public Builder setSelfServiceChannel( boolean pSelfServiceChannel ) {
      // Assign value to attribute
      selfServiceChannel = pSelfServiceChannel;
      return this;
    }

    /**
     * Method sets the association "reseller".
     * 
     * @param pReseller Reseller to which the association "reseller" should be set.
     */
    public Builder setReseller( Reseller pReseller ) {
      reseller = pReseller;
      return this;
    }

    /**
     * Method creates a new instance of class Channel. The object will be initialized with the values of the builder.
     * 
     * @return Channel Created object. The method never returns null.
     */
    public Channel build( ) {
      return new Channel(this);
    }

    /**
     * Method creates a new validated instance of class Channel. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Channel Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Channel buildValidated( ) throws ConstraintViolationException {
      Channel lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "channelType". Type of the channel
   *
   * @return ChannelType ChannelType to which the association "channelType" is set.
   */
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets the association "channelType". Type of the channel
   * 
   * @param pChannelType ChannelType to which the association "channelType" should be set.
   */
  public void setChannelType( ChannelType pChannelType ) {
    channelType = pChannelType;
  }

  /**
   * Method unsets the association "channelType". Type of the channel
   */
  public final void unsetChannelType( ) {
    channelType = null;
  }

  /**
   * Method returns the association "channelCode". The business code of the channel
   *
   * @return ChannelCode ChannelCode to which the association "channelCode" is set.
   */
  public ChannelCode getChannelCode( ) {
    return channelCode;
  }

  /**
   * Method sets the association "channelCode". The business code of the channel
   * 
   * @param pChannelCode ChannelCode to which the association "channelCode" should be set.
   */
  public void setChannelCode( ChannelCode pChannelCode ) {
    channelCode = pChannelCode;
  }

  /**
   * Method unsets the association "channelCode". The business code of the channel
   */
  public final void unsetChannelCode( ) {
    channelCode = null;
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return int Value to which the attribute "code" is set.
   */
  public int getCode( ) {
    return code;
  }

  /**
   * Method returns the attribute "selfServiceChannel".
   * 
   * 
   * @return Boolean Value to which the attribute "selfServiceChannel" is set.
   */
  public boolean getSelfServiceChannel( ) {
    return selfServiceChannel;
  }

  /**
   * Method returns the association "reseller".
   * 
   *
   * @return Reseller Reseller to which the association "reseller" is set.
   */
  public Reseller getReseller( ) {
    return reseller;
  }

  /**
   * Method sets the association "reseller".
   * 
   * 
   * @param pReseller Reseller to which the association "reseller" should be set.
   */
  public void setReseller( Reseller pReseller ) {
    // Release already referenced object before setting a new association.
    if (reseller != null) {
      reseller.removeFromChannels((Channel) this);
    }
    reseller = pReseller;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pReseller != null && pReseller.getChannels().contains(this) == false) {
      pReseller.addToChannels((Channel) this);
    }
  }

  /**
   * Method unsets the association "reseller".
   * 
   */
  public final void unsetReseller( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    Reseller lReseller = reseller;
    reseller = null;
    if (lReseller != null && lReseller.getChannels().contains(this) == true) {
      lReseller.removeFromChannels((Channel) this);
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "code", "" + code));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "selfServiceChannel",
        "" + selfServiceChannel));
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
