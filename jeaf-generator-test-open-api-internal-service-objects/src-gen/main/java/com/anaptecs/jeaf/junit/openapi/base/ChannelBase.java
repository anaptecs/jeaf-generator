/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public abstract class ChannelBase implements ServiceObject {
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
  @Valid
  @NotNull
  private ChannelCode channelCode;

  private final int code;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private final boolean selfServiceChannel;

  @Valid
  private transient Reseller reseller;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChannelBase( ) {
    code = 0;
    selfServiceChannel = true;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChannelBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    channelType = pBuilder.channelType;
    channelCode = pBuilder.channelCode;
    code = pBuilder.code;
    selfServiceChannel = pBuilder.selfServiceChannel;
  }

  /**
   * Class implements builder to create a new instance of class Channel. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Type of the channel
     */
    private ChannelType channelType;

    /**
     * The business code of the channel
     */
    private ChannelCode channelCode;

    private int code;

    /**
     * <br/>
     * <b>Default Value:</b> <code>true</code>
     */
    private boolean selfServiceChannel = true;

    /**
     * Use {@link Channel.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Channel.builder(Channel)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ChannelBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        channelType = pObject.channelType;
        channelCode = pObject.channelCode;
        code = pObject.code;
        selfServiceChannel = pObject.selfServiceChannel;
      }
    }

    /**
     * Method sets association {@link #channelType}.<br/>
     *
     * @param pChannelType Value to which {@link #channelType} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setChannelType( ChannelType pChannelType ) {
      channelType = pChannelType;
      return this;
    }

    /**
     * Method sets association {@link #channelCode}.<br/>
     *
     * @param pChannelCode Value to which {@link #channelCode} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setChannelCode( ChannelCode pChannelCode ) {
      channelCode = pChannelCode;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setCode( int pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets attribute {@link #selfServiceChannel}.<br/>
     *
     * @param pSelfServiceChannel Value to which {@link #selfServiceChannel} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSelfServiceChannel( boolean pSelfServiceChannel ) {
      // Assign value to attribute
      selfServiceChannel = pSelfServiceChannel;
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
   * Method returns association {@link #channelType}.<br/>
   * Type of the channel
   *
   * @return {@link ChannelType} Value to which {@link #channelType} is set.
   */
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets association {@link #channelType}.<br/>
   * Type of the channel
   *
   * @param pChannelType Value to which {@link #channelType} should be set.
   */
  public void setChannelType( ChannelType pChannelType ) {
    channelType = pChannelType;
  }

  /**
   * Method unsets {@link #channelType}.
   */
  public final void unsetChannelType( ) {
    channelType = null;
  }

  /**
   * Method returns association {@link #channelCode}.<br/>
   * The business code of the channel
   *
   * @return {@link ChannelCode} Value to which {@link #channelCode} is set.
   */
  public ChannelCode getChannelCode( ) {
    return channelCode;
  }

  /**
   * Method sets association {@link #channelCode}.<br/>
   * The business code of the channel
   *
   * @param pChannelCode Value to which {@link #channelCode} should be set.
   */
  public void setChannelCode( ChannelCode pChannelCode ) {
    channelCode = pChannelCode;
  }

  /**
   * Method unsets {@link #channelCode}.
   */
  public final void unsetChannelCode( ) {
    channelCode = null;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return int Value to which {@link #code} is set.
   */
  public int getCode( ) {
    return code;
  }

  /**
   * Method returns attribute {@link #selfServiceChannel}.<br/>
   *
   * @return boolean Value to which {@link #selfServiceChannel} is set.
   */
  @Deprecated
  public boolean getSelfServiceChannel( ) {
    return selfServiceChannel;
  }

  /**
   * Method returns attribute {@link #selfServiceChannel}.<br/>
   *
   * @return boolean Value to which {@link #selfServiceChannel} is set.
   */
  public boolean isSelfServiceChannel( ) {
    return selfServiceChannel;
  }

  /**
   * Method returns association {@link #reseller}.<br/>
   *
   * @return {@link Reseller} Value to which {@link #reseller} is set.
   */
  public Reseller getReseller( ) {
    return reseller;
  }

  /**
   * Method sets association {@link #reseller}.<br/>
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   */
  void setReseller( Reseller pReseller ) {
    // Release already referenced object before setting a new association.
    if (reseller != null) {
      reseller.removeFromChannels((Channel) this);
    }
    reseller = pReseller;
  }

  /**
   * Method unsets {@link #reseller}.
   */
  final void unsetReseller( ) {
    reseller = null;
  }

  /**
   * Convenience method to create new instance of class Channel.
   *
   *
   * @param pChannelType Value to which {@link #channelType} should be set.
   *
   * @param pChannelCode Value to which {@link #channelCode} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @param pSelfServiceChannel Value to which {@link #selfServiceChannel} should be set.
   *
   * @return {@link Channel}
   */
  public static Channel of( ChannelType pChannelType, ChannelCode pChannelCode, int pCode,
      boolean pSelfServiceChannel ) {
    Channel.Builder lBuilder = Channel.builder();
    lBuilder.setChannelType(pChannelType);
    lBuilder.setChannelCode(pChannelCode);
    lBuilder.setCode(pCode);
    lBuilder.setSelfServiceChannel(pSelfServiceChannel);
    return lBuilder.build();
  }

  /**
   * Method returns attribute {@link #derivedSomething}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedSomething} is set.
   */
  public abstract String getDerivedSomething( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(channelType);
    lResult = lPrime * lResult + Objects.hashCode(channelCode);
    lResult = lPrime * lResult + code;
    lResult = lPrime * lResult + Boolean.hashCode(selfServiceChannel);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      ChannelBase lOther = (ChannelBase) pObject;
      lEquals = Objects.equals(channelType, lOther.channelType) && Objects.equals(channelCode, lOther.channelCode)
          && code == lOther.code && selfServiceChannel == lOther.selfServiceChannel;
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("channelType: ");
    lBuilder.append(channelType);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("channelCode: ");
    if (channelCode != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(channelCode.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("selfServiceChannel: ");
    lBuilder.append(selfServiceChannel);
    lBuilder.append(System.lineSeparator());
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
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Channel objects. The method never returns null.
   */
  public Channel.Builder toBuilder( ) {
    return new Channel.Builder((Channel) this);
  }
}
