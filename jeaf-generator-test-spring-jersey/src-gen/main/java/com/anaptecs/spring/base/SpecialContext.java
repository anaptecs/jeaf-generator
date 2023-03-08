/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Locale;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;

public class SpecialContext extends Context {
  /**
   * Constant for the name of attribute "specificHeader".
   */
  public static final String SPECIFICHEADER = "specificHeader";

  /**
   * Constant for the name of attribute "channelType".
   */
  public static final String CHANNELTYPE = "channelType";

  @HeaderParam("specificHeader")
  private String specificHeader;

  @CookieParam("Channel-Type")
  private ChannelType channelType;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public SpecialContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SpecialContext( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    specificHeader = pBuilder.specificHeader;
    channelType = pBuilder.channelType;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects. The method never returns
   * null.
   */
  public static Builder builder( SpecialContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SpecialContext. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Context.Builder {
    /**
     * 
     */
    private String specificHeader;

    /**
     * 
     */
    private ChannelType channelType;

    /**
     * Use {@link SpecialContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SpecialContext#builder(SpecialContext)} instead of private constructor to create new builder.
     */
    protected Builder( SpecialContext pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        specificHeader = pObject.specificHeader;
        channelType = pObject.channelType;
      }
    }

    /**
     * Method sets the attribute "accessToken".
     * 
     * @param pAccessToken Value to which the attribute "accessToken" should be set.
     */
    @Override
    public Builder setAccessToken( String pAccessToken ) {
      // Call super class implementation.
      super.setAccessToken(pAccessToken);
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    @Override
    public Builder setLanguage( Locale pLanguage ) {
      // Call super class implementation.
      super.setLanguage(pLanguage);
      return this;
    }

    /**
     * Method sets the attribute "resellerID".
     * 
     * @param pResellerID Value to which the attribute "resellerID" should be set.
     */
    @Override
    public Builder setResellerID( long pResellerID ) {
      // Call super class implementation.
      super.setResellerID(pResellerID);
      return this;
    }

    /**
     * Method sets the attribute "pathParam".
     * 
     * @param pPathParam Value to which the attribute "pathParam" should be set.
     */
    @Override
    public Builder setPathParam( long pPathParam ) {
      // Call super class implementation.
      super.setPathParam(pPathParam);
      return this;
    }

    /**
     * Method sets the attribute "queryParam".
     * 
     * @param pQueryParam Value to which the attribute "queryParam" should be set.
     */
    @Override
    public Builder setQueryParam( String pQueryParam ) {
      // Call super class implementation.
      super.setQueryParam(pQueryParam);
      return this;
    }

    /**
     * Method sets the attribute "lang".
     * 
     * @param pLang Value to which the attribute "lang" should be set.
     */
    @Override
    public Builder setLang( String pLang ) {
      // Call super class implementation.
      super.setLang(pLang);
      return this;
    }

    /**
     * Method sets the attribute "specificHeader".
     * 
     * @param pSpecificHeader Value to which the attribute "specificHeader" should be set.
     */
    public Builder setSpecificHeader( String pSpecificHeader ) {
      // Assign value to attribute
      specificHeader = pSpecificHeader;
      return this;
    }

    /**
     * Method sets the attribute "channelType".
     * 
     * @param pChannelType Value to which the attribute "channelType" should be set.
     */
    public Builder setChannelType( ChannelType pChannelType ) {
      // Assign value to attribute
      channelType = pChannelType;
      return this;
    }

    /**
     * Method creates a new instance of class SpecialContext. The object will be initialized with the values of the
     * builder.
     * 
     * @return SpecialContext Created object. The method never returns null.
     */
    public SpecialContext build( ) {
      return new SpecialContext(this);
    }
  }

  /**
   * Method returns attribute {@link #specificHeader}.<br/>
   * 
   * @return String Value to which the attribute "specificHeader" is set.
   */
  public String getSpecificHeader( ) {
    return specificHeader;
  }

  /**
   * Method sets the attribute "specificHeader".
   * 
   * 
   * @param pSpecificHeader Value to which the attribute "specificHeader" should be set.
   */
  public void setSpecificHeader( String pSpecificHeader ) {
    // Assign value to attribute
    specificHeader = pSpecificHeader;
  }

  /**
   * Method returns attribute {@link #channelType}.<br/>
   * 
   * @return ChannelType Value to which the attribute "channelType" is set.
   */
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets the attribute "channelType".
   * 
   * 
   * @param pChannelType Value to which the attribute "channelType" should be set.
   */
  public void setChannelType( ChannelType pChannelType ) {
    // Assign value to attribute
    channelType = pChannelType;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("specificHeader: ");
    lBuilder.append(specificHeader);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("channelType: ");
    lBuilder.append(channelType);
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
}
