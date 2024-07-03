/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.annotations.MyNotEmpty;
import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
import com.anaptecs.jeaf.junit.openapi.base.MultiValuedDataType;
import com.anaptecs.jeaf.junit.openapi.base.NotInlinedBeanParam;
import com.anaptecs.jeaf.junit.openapi.base.ParentBeanParamType;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.ShortCode;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;
import com.anaptecs.jeaf.junit.openapi.base.StringCode;
import com.anaptecs.jeaf.junit.openapi.base.StringCodeType;
import com.anaptecs.jeaf.junit.rest.generics.BusinessServiceObject;
import com.anaptecs.jeaf.junit.rest.generics.GenericPageableResponse;
import com.anaptecs.jeaf.junit.rest.generics.GenericSingleValuedReponse;
import com.anaptecs.jeaf.junit.rest.generics.Offer;
import com.anaptecs.jeaf.junit.rest.generics.Pageable;
import com.anaptecs.jeaf.junit.rest.generics.Response;

public interface ProductService extends Service {
  /**
   * Operation returns all available product.
   *
   * @return {@link List<Product>}
   */
  List<Product> getProducts( );

  /**
   * @param pProductID
   * @return {@link Product}
   */
  @MyNotNull
  Product getProduct( @NotEmpty @MyNotNull String pProductID );

  /**
   * @param pProduct
   * @return boolean
   */
  boolean createProduct( @MyNotNull Product pProduct );

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @MyNotNull
  Sortiment getSortiment( @MyNotNull Context pContext );

  /**
   * @param pChannelCode
   * <p/>
   * <b>Breaking Change with 2.0:</b> Parameter will be mandatory
   * @return {@link ChannelCode}
   */
  @MyNotNull
  ChannelCode createChannelCode( @NotBlank @MyNotNull String pChannelCode );

  /**
   */
  @MyNotNull
  void ping( );

  /**
   * @return {@link String}
   * @deprecated This request is no longer supported. (<b>since:</b> 1.1.1, <b>removed with:</b> 2.3)
   */
  @Deprecated
  @MyNotNull
  String deprecatedOperation( );

  /**
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String deprecatedContext( @MyNotNull DeprecatedContext pContext );

  /**
   * @param pBeanParam
   */
  @MyNotNull
  void deprecatedBeanParam( @MyNotNull BeanParameter pBeanParam );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNull
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @MyNotNull
  String deprecatedBody( @Deprecated @MyNotNull String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @MyNotNull
  void deprectedComplexRequestBody( @Deprecated @MyNotNull Product pProduct );

  /**
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNull
  Product deprecatedComplexReturn( );

  /**
   * @param pContext
   */
  @MyNotNull
  void loadSpecificThings( @MyNotNull SpecialContext pContext );

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @MyNotNull
  ChannelCode createChannelCodeFromObject( @MyNotNull ChannelCode pChannelCode );

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @MyNotEmpty
  List<CurrencyCode> addCurrencies( @MyNotEmpty List<CurrencyCode> pCurrencies );

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @MyNotNull
  CurrencyCode isCurrencySupported( @MyNotNull CurrencyCode pCurrency );

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @MyNotNull
  IntegerCodeType testCodeTypeUsage( @MyNotNull StringCodeType pStringCode );

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNull
  String testLocalBeanParamType( @MyNotNull LocalBeanParamType pBeanParam );

  /**
   * @param pParent
   * @return {@link String}
   */
  @MyNotNull
  String testExternalBeanParameterType( @MyNotNull ParentBeanParamType pParent );

  /**
   * @param pChild
   * @return {@link String}
   */
  @MyNotNull
  String testChildBeanParameter( @MyNotNull ChildBeanParameterType pChild );

  /**
   * @param pIBAN
   * @return boolean
   */
  boolean checkIBAN( @MyNotNull String pIBAN );

  /**
   * @param pChannelTypes
   * @return {@link List<Channel>}
   */
  List<Channel> getChannels( List<ChannelType> pChannelTypes );

  /**
   * @param pChannelType
   * @return {@link Channel}
   */
  @MyNotNull
  Channel getDefaultChannel( @MyNotNull ChannelType pChannelType );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrencies( @MyNotNull ChannelCode pChannelCode );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( @MyNotNull ChannelCode pChannelCode );

  /**
   * @param pPath
   * @param pStartTimestamp
   * @param pStartTime
   * @param pLocalStartTimestamp
   * @param pLocalStartTime
   * @param pLocalStartDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @MyNotNull
  void testDateQueryParams( @MyNotNull String pPath, @MyNotNull OffsetDateTime pStartTimestamp,
      @MyNotNull OffsetTime pStartTime, @MyNotNull LocalDateTime pLocalStartTimestamp,
      @MyNotNull LocalTime pLocalStartTime, @MyNotNull LocalDate pLocalStartDate, @MyNotNull Calendar pCalendar,
      @MyNotNull java.util.Date pUtilDate, @MyNotNull Timestamp pSQLTimestamp, @MyNotNull Time pSQLTime,
      @MyNotNull Date pSQLDate );

  /**
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNull
  void testDateQueryParamsBean( @MyNotNull String pPath, @MyNotNull DateQueryParamsBean pQueryParams );

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @MyNotNull
  String testOptionalQueryParams( String query1, int query2 );

  /**
   * @param authorization
   * @param pContentType
   * @param pAccept
   */
  @MyNotNull
  void testSpecialHeaderParams( @MyNotNull String authorization, @MyNotNull String pContentType,
      @MyNotNull String pAccept );

  /**
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String testTechnicalHeaderBean( @MyNotNull TechnicalHeaderContext pContext );

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @MyNotNull
  String testTechnicalHeaderParam( @MyNotNull String pReseller );

  /**
   * @param pInlinedBeanParam
   */
  @MyNotNull
  void testNotInlinedBeanParam( @MyNotNull NotInlinedBeanParam pInlinedBeanParam );

  /**
   * @param pIntegerArray
   */
  @MyNotNull
  void testPrimitiveArray( @MyNotEmpty int[] pIntegerArray );

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @MyNotNull
  String testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * @param pCodes
   * @return {@link String}
   */
  @MyNotNull
  String testMultivaluedHeader( List<BigDecimalCode> pCodes );

  /**
   * @param pCodes
   * @param pEnums
   * @return {@link String}
   */
  @MyNotNull
  String testMultivaluedQueryParams( List<BigDecimalCode> pCodes, List<BooleanLiteralsEnum> pEnums );

  /**
   * @param pBeanParam
   * @param pTheEnum
   * @return {@link String}
   */
  @MyNotNull
  String testMulitValuedBeanParams( @MyNotNull MultiValuedDataType pBeanParam,
      @MyNotNull BooleanLiteralsEnum pTheEnum );

  /**
   * @param pHeader
   * @param pContext
   */
  @MyNotNull
  void noReturnType( @MyNotNull String pHeader, @MyNotNull MultiValuedDataType pContext );

  /**
   * @param pID
   */
  @MyNotNull
  void deleteSomething( @MyNotNull String pID );

  /**
   * @return {@link GenericSingleValuedReponse<BusinessServiceObject>}
   */
  @MyNotNull
  GenericSingleValuedReponse<BusinessServiceObject> genericSingleValueResponse( );

  /**
   * @return {@link GenericPageableResponse<BusinessServiceObject>}
   */
  @MyNotNull
  GenericPageableResponse<BusinessServiceObject> genericMultiValueResponse( );

  /**
   * @param pStringCode
   * @param pShortCodes
   * @param pJustAByte
   */
  @MyNotNull
  void testDataTypeWithRestrition( @MyNotNull StringCode pStringCode, Set<ShortCode> pShortCodes,
      @Min(value = 32) @MyNotNull Byte pJustAByte );

  /**
   * @param pContext
   */
  @MyNotNull
  void testContext( @MyNotNull Context pContext );

  /**
   * @return {@link Response<Pageable<BusinessServiceObject>>}
   */
  @MyNotNull
  Response<Pageable<BusinessServiceObject>> testNestedGenericsResponse( );

  /**
   * @return {@link Response<List<Offer>>}
   */
  @MyNotNull
  Response<List<Offer>> testNestedMultivaluedResponse( );

  /**
   * @return {@link Response<Offer>}
   */
  @MyNotNull
  Response<Offer> testDuplicateGenerics1( );

  /**
   * @return {@link Response<Offer>}
   */
  @MyNotNull
  Response<Offer> testDuplicateGenerics2( );
}
