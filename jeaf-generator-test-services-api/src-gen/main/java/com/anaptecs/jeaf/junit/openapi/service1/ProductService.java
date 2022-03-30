/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;
import com.anaptecs.jeaf.junit.openapi.base.StringCodeType;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface ProductService extends Service {
  /**
   * Operation returns all available product.
   * 
   * 
   * @return {@link Product}
   */
  List<Product> getProducts( );

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  Product getProduct( @NotEmpty() String pProductID );

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */
  boolean createProduct( Product pProduct );

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */
  Sortiment getSortiment( Context pContext );

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  ChannelCode createChannelCode( @NotBlank() String pChannelCode );

  /**
  * 
  */
  void ping( );

  /**
   * 
   * @return {@link String}
   */
  @Deprecated
  String deprecatedOperation( );

  /**
   * 
   * @param pContext
   * @return {@link String}
   */
  String deprecatedContext( DeprecatedContext pContext );

  /**
   * 
   * @param pBeanParam
   */
  void deprecatedBeanParam( BeanParameter pBeanParam );

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * 
   * @param pBody
   * @return {@link String}
   */
  String deprecatedBody( @Deprecated String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * 
   * 
   * @param pProduct
   */
  void deprectedComplexRequestBody( @Deprecated Product pProduct );

  /**
   * 
   * @return {@link Product}
   */
  @Deprecated
  Product deprecatedComplexReturn( );

  /**
   * 
   * @param pContext
   */
  void loadSpecificThings( SpecialContext pContext );

  /**
   * 
   * @param pChannelCode Channel Code that should be created.
   * 
   * @return {@link ChannelCode} Created channel code
   * 
   */
  ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode );

  /**
   * 
   * @param pCurrencies
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies );

  /**
   * 
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  CurrencyCode isCurrencySupported( CurrencyCode pCurrency );

  /**
   * 
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode );
}
