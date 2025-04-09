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

import com.anaptecs.annotations.MyNotEmptyServiceParam;
import com.anaptecs.annotations.MyNotNullServiceParam;
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
  @MyNotNullServiceParam
  Product getProduct( @NotEmpty @MyNotNullServiceParam String pProductID );

  /**
   * @param pProduct
   * @return boolean
   */
  boolean createProduct( @MyNotNullServiceParam Product pProduct );

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @MyNotNullServiceParam
  Sortiment getSortiment( @MyNotNullServiceParam Context pContext );

  /**
   * @param pChannelCode
   * <p/>
   * <b>Breaking Change with 2.0:</b> Parameter will be mandatory
   * @return {@link ChannelCode}
   */
  @MyNotNullServiceParam
  ChannelCode createChannelCode( @NotBlank @MyNotNullServiceParam String pChannelCode );

  /**
   */
  @MyNotNullServiceParam
  void ping( );

  /**
   * @return {@link String}
   * @deprecated This request is no longer supported. (<b>since:</b> 1.1.1, <b>removed with:</b> 2024-10-20)
   */
  @Deprecated
  @MyNotNullServiceParam
  String deprecatedOperation( );

  /**
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String deprecatedContext( @MyNotNullServiceParam DeprecatedContext pContext );

  /**
   * @param pBeanParam
   */
  @MyNotNullServiceParam
  void deprecatedBeanParam( @MyNotNullServiceParam BeanParameter pBeanParam );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNullServiceParam
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String deprecatedBody( @Deprecated @MyNotNullServiceParam String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @MyNotNullServiceParam
  void deprectedComplexRequestBody( @Deprecated @MyNotNullServiceParam Product pProduct );

  /**
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNullServiceParam
  Product deprecatedComplexReturn( );

  /**
   * @param pContext
   */
  @MyNotNullServiceParam
  void loadSpecificThings( @MyNotNullServiceParam SpecialContext pContext );

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @MyNotNullServiceParam
  ChannelCode createChannelCodeFromObject( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @MyNotEmptyServiceParam
  List<CurrencyCode> addCurrencies( @MyNotEmptyServiceParam List<CurrencyCode> pCurrencies );

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @MyNotNullServiceParam
  CurrencyCode isCurrencySupported( @MyNotNullServiceParam CurrencyCode pCurrency );

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @MyNotNullServiceParam
  IntegerCodeType testCodeTypeUsage( @MyNotNullServiceParam StringCodeType pStringCode );

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testLocalBeanParamType( @MyNotNullServiceParam LocalBeanParamType pBeanParam );

  /**
   * @param pParent
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testExternalBeanParameterType( @MyNotNullServiceParam ParentBeanParamType pParent );

  /**
   * @param pChild
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testChildBeanParameter( @MyNotNullServiceParam ChildBeanParameterType pChild );

  /**
   * @param pIBAN
   * @return boolean
   */
  boolean checkIBAN( @MyNotNullServiceParam String pIBAN );

  /**
   * @param pChannelTypes
   * @return {@link List<Channel>}
   */
  List<Channel> getChannels( List<ChannelType> pChannelTypes );

  /**
   * @param pChannelType
   * @return {@link Channel}
   */
  @MyNotNullServiceParam
  Channel getDefaultChannel( @MyNotNullServiceParam ChannelType pChannelType );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrencies( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( @MyNotNullServiceParam ChannelCode pChannelCode );

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
  @MyNotNullServiceParam
  void testDateQueryParams( @MyNotNullServiceParam String pPath, @MyNotNullServiceParam OffsetDateTime pStartTimestamp,
      @MyNotNullServiceParam OffsetTime pStartTime, @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp,
      @MyNotNullServiceParam LocalTime pLocalStartTime, @MyNotNullServiceParam LocalDate pLocalStartDate,
      @MyNotNullServiceParam Calendar pCalendar, @MyNotNullServiceParam java.util.Date pUtilDate,
      @MyNotNullServiceParam Timestamp pSQLTimestamp, @MyNotNullServiceParam Time pSQLTime,
      @MyNotNullServiceParam Date pSQLDate );

  /**
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNullServiceParam
  void testDateQueryParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testOptionalQueryParams( String query1, int query2 );

  /**
   * @param authorization
   * @param pContentType
   * @param pAccept
   */
  @MyNotNullServiceParam
  void testSpecialHeaderParams( @MyNotNullServiceParam String authorization, @MyNotNullServiceParam String pContentType,
      @MyNotNullServiceParam String pAccept );

  /**
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testTechnicalHeaderBean( @MyNotNullServiceParam TechnicalHeaderContext pContext );

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testTechnicalHeaderParam( @MyNotNullServiceParam String pReseller );

  /**
   * @param pInlinedBeanParam
   */
  @MyNotNullServiceParam
  void testNotInlinedBeanParam( @MyNotNullServiceParam NotInlinedBeanParam pInlinedBeanParam );

  /**
   * @param pIntegerArray
   */
  @MyNotNullServiceParam
  void testPrimitiveArray( @MyNotEmptyServiceParam int[] pIntegerArray );

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * @param pCodes
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMultivaluedHeader( List<BigDecimalCode> pCodes );

  /**
   * @param pCodes
   * @param pEnums
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMultivaluedQueryParams( List<BigDecimalCode> pCodes, List<BooleanLiteralsEnum> pEnums );

  /**
   * @param pBeanParam
   * @param pTheEnum
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMulitValuedBeanParams( @MyNotNullServiceParam MultiValuedDataType pBeanParam,
      @MyNotNullServiceParam BooleanLiteralsEnum pTheEnum );

  /**
   * @param pHeader
   * @param pContext
   */
  @MyNotNullServiceParam
  void noReturnType( @MyNotNullServiceParam String pHeader, @MyNotNullServiceParam MultiValuedDataType pContext );

  /**
   * @param pID
   */
  @MyNotNullServiceParam
  void deleteSomething( @MyNotNullServiceParam String pID );

  /**
   * @return {@link GenericSingleValuedReponse<BusinessServiceObject>}
   */
  @MyNotNullServiceParam
  GenericSingleValuedReponse<BusinessServiceObject> genericSingleValueResponse( );

  /**
   * @return {@link GenericPageableResponse<BusinessServiceObject>}
   */
  @MyNotNullServiceParam
  GenericPageableResponse<BusinessServiceObject> genericMultiValueResponse( );

  /**
   * @param pStringCode
   * @param pShortCodes
   * @param pJustAByte
   */
  @MyNotNullServiceParam
  void testDataTypeWithRestrition( @MyNotNullServiceParam StringCode pStringCode, Set<ShortCode> pShortCodes,
      @Min(value = 32) @MyNotNullServiceParam Byte pJustAByte );

  /**
   * @param pContext
   */
  @MyNotNullServiceParam
  void testContext( @MyNotNullServiceParam Context pContext );

  /**
   * @return {@link Response<Pageable<BusinessServiceObject>>}
   */
  @MyNotNullServiceParam
  Response<Pageable<BusinessServiceObject>> testNestedGenericsResponse( );

  /**
   * @return {@link Response<List<Offer>>}
   */
  @MyNotNullServiceParam
  Response<List<Offer>> testNestedMultivaluedResponse( );

  /**
   * @return {@link Response<Offer>}
   */
  @MyNotNullServiceParam
  Response<Offer> testDuplicateGenerics1( );

  /**
   * @return {@link Response<Offer>}
   */
  @MyNotNullServiceParam
  Response<Offer> testDuplicateGenerics2( );
}