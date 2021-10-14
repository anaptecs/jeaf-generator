/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Channel implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "channelType".
   */
  public static final String CHANNELTYPE = "channelType";

  /**
   * Constant for the name of attribute "channelCode".
   */
  public static final String CHANNELCODE = "channelCode";

  /**
   * 
   */
  private ChannelType channelType;

  /**
   * 
   */
  private ChannelCode channelCode;

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
  }

  /**
   * Class implements builder to create a new instance of class Channel. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ChannelType channelType;

    /**
     * 
     */
    private ChannelCode channelCode;

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
     * @return {@link Builder} New builder that can be used to create new Channel objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Channel pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "channelType".
     * 
     * @param pChannelType ChannelType to which the association "channelType" should be set.
     */
    public Builder setChannelType( ChannelType pChannelType ) {
      channelType = pChannelType;
      return this;
    }

    /**
     * Method sets the association "channelCode".
     * 
     * @param pChannelCode ChannelCode to which the association "channelCode" should be set.
     */
    public Builder setChannelCode( ChannelCode pChannelCode ) {
      channelCode = pChannelCode;
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
     * Method creates a new instance of class Channel. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Channel Created object. The method never returns null.
     */
    public Channel build( boolean pValidate ) {
      Channel lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the association "channelType".
   * 
   *
   * @return ChannelType ChannelType to which the association "channelType" is set.
   */
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets the association "channelType".
   * 
   * 
   * @param pChannelType ChannelType to which the association "channelType" should be set.
   */
  public void setChannelType( ChannelType pChannelType ) {
    channelType = pChannelType;
  }

  /**
   * Method unsets the association "channelType".
   * 
   */
  public final void unsetChannelType( ) {
    channelType = null;
  }

  /**
   * Method returns the association "channelCode".
   * 
   *
   * @return ChannelCode ChannelCode to which the association "channelCode" is set.
   */
  public ChannelCode getChannelCode( ) {
    return channelCode;
  }

  /**
   * Method sets the association "channelCode".
   * 
   * 
   * @param pChannelCode ChannelCode to which the association "channelCode" should be set.
   */
  public void setChannelCode( ChannelCode pChannelCode ) {
    channelCode = pChannelCode;
  }

  /**
   * Method unsets the association "channelCode".
   * 
   */
  public final void unsetChannelCode( ) {
    channelCode = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
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