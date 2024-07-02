/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Channel {
  /**
   * Constant for the name of attribute "channelType".
   */
  public static final String CHANNELTYPE = "channelType";

  /**
   * Constant for the name of attribute "channelCode".
   */
  public static final String CHANNELCODE = "channelCode";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "selfServiceChannel".
   */
  @Deprecated
  public static final String SELFSERVICECHANNEL = "selfServiceChannel";

  /**
   * Constant for the name of attribute "reseller".
   */
  public static final String RESELLER = "reseller";

  /**
   * Type of the channel
   */
  private ChannelType channelType;

  /**
   * The business code of the channel
   */
  private ChannelCode channelCode;

  private final int code;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  @Deprecated
  private final boolean selfServiceChannel;

  private transient Reseller reseller;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
    // Read attribute values from builder.
    channelType = pBuilder.channelType;
    channelCode = pBuilder.channelCode;
    code = pBuilder.code;
    selfServiceChannel = pBuilder.selfServiceChannel;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Channel objects.
   */
  public static Builder builder( ) {
    return new Builder();
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
   * Class implements builder to create a new instance of class <code>Channel</code>.
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

    private int code;

    /**
     * <br/>
     * <b>Default Value:</b> <code>true</code>
     */
    @Deprecated
    private boolean selfServiceChannel = true;

    /**
     * Use {@link Channel#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Channel#builder(Channel)} instead of private constructor to create new builder.
     */
    protected Builder( Channel pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChannelType(pObject.channelType);
        this.setChannelCode(pObject.channelCode);
        this.setCode(pObject.code);
        this.setSelfServiceChannel(pObject.selfServiceChannel);
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
     * Method sets association {@link #channelType}.<br/>
     *
     * @param pChannelType Value to which {@link #channelType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChannelType( @MyNotNull ChannelType pChannelType ) {
      channelType = pChannelType;
      return this;
    }

    /**
     * Method sets association {@link #channelCode}.<br/>
     *
     * @param pChannelCode Value to which {@link #channelCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChannelCode( @MyNotNull ChannelCode pChannelCode ) {
      channelCode = pChannelCode;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( int pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets attribute {@link #selfServiceChannel}.<br/>
     *
     * @param pSelfServiceChannel Value to which {@link #selfServiceChannel} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setSelfServiceChannel( boolean pSelfServiceChannel ) {
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
      Channel lObject = new Channel(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #channelType}.<br/>
   * Type of the channel
   *
   * @return {@link ChannelType} Value to which {@link #channelType} is set.
   */
  @MyNotNull
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets association {@link #channelType}.<br/>
   * Type of the channel
   *
   * @param pChannelType Value to which {@link #channelType} should be set.
   */
  public void setChannelType( @MyNotNull ChannelType pChannelType ) {
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
  @MyNotNull
  public ChannelCode getChannelCode( ) {
    return channelCode;
  }

  /**
   * Method sets association {@link #channelCode}.<br/>
   * The business code of the channel
   *
   * @param pChannelCode Value to which {@link #channelCode} should be set.
   */
  public void setChannelCode( @MyNotNull ChannelCode pChannelCode ) {
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
  @Deprecated
  public boolean isSelfServiceChannel( ) {
    return selfServiceChannel;
  }

  /**
   * Method returns association {@link #reseller}.<br/>
   *
   * @return {@link Reseller} Value to which {@link #reseller} is set.
   */
  @MyNotNull
  public Reseller getReseller( ) {
    return reseller;
  }

  /**
   * Method sets association {@link #reseller}.<br/>
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   */
  void setReseller( @MyNotNull Reseller pReseller ) {
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
      Channel lOther = (Channel) pObject;
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
