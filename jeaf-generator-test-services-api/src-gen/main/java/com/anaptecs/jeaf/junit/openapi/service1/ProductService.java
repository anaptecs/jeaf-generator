/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
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

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
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
// @Something

@JEAFCustomAnnotationTest
public interface ProductService extends Service {
  /**
   * Operation returns all available product.
   *
   * @return {@link List<Product>}
   */
  @JEAFCustomAnnotationTest
  List<Product> getProducts( );

  /**
   * @param pProductID
   * @return {@link Product}
   */
  @JEAFCustomAnnotationTest
  Product getProduct( @JEAFCustomAnnotationTest @NotEmpty String pProductID );

  /**
   * @param pProduct
   * @return boolean
   */
  @JEAFCustomAnnotationTest
  boolean createProduct( @JEAFCustomAnnotationTest Product pProduct );

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @JEAFCustomAnnotationTest
  Sortiment getSortiment( @JEAFCustomAnnotationTest Context pContext );

  /**
   * @param pChannelCode
   * <p/>
   * <b>Breaking Change with 2.0:</b> Parameter will be mandatory
   * @return {@link ChannelCode}
   */
  @JEAFCustomAnnotationTest
  ChannelCode createChannelCode( @JEAFCustomAnnotationTest @NotBlank String pChannelCode );

  /**
   */
  @JEAFCustomAnnotationTest
  void ping( );

  /**
   * @return {@link String}
   * @deprecated This request is no longer supported. (<b>since:</b> 1.1.1, <b>removed with:</b> 2024-10-20)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  String deprecatedOperation( );

  /**
   * @param pContext
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String deprecatedContext( @JEAFCustomAnnotationTest DeprecatedContext pContext );

  /**
   * @param pBeanParam
   */
  @JEAFCustomAnnotationTest
  void deprecatedBeanParam( @JEAFCustomAnnotationTest BeanParameter pBeanParam );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  String deprecatedParams( @Deprecated @JEAFCustomAnnotationTest int pParam1 );

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String deprecatedBody( @Deprecated @JEAFCustomAnnotationTest String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  void deprectedComplexRequestBody( @Deprecated @JEAFCustomAnnotationTest Product pProduct );

  /**
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  Product deprecatedComplexReturn( );

  /**
   * @param pContext
   */
  @JEAFCustomAnnotationTest
  void loadSpecificThings( @JEAFCustomAnnotationTest SpecialContext pContext );

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @JEAFCustomAnnotationTest
  ChannelCode createChannelCodeFromObject( @JEAFCustomAnnotationTest ChannelCode pChannelCode );

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @JEAFCustomAnnotationTest
  List<CurrencyCode> addCurrencies( @JEAFCustomAnnotationTest List<CurrencyCode> pCurrencies );

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @JEAFCustomAnnotationTest
  CurrencyCode isCurrencySupported( @JEAFCustomAnnotationTest CurrencyCode pCurrency );

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @JEAFCustomAnnotationTest
  IntegerCodeType testCodeTypeUsage( @JEAFCustomAnnotationTest StringCodeType pStringCode );

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testLocalBeanParamType( @JEAFCustomAnnotationTest LocalBeanParamType pBeanParam );

  /**
   * @param pParent
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testExternalBeanParameterType( @JEAFCustomAnnotationTest ParentBeanParamType pParent );

  /**
   * @param pChild
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testChildBeanParameter( @JEAFCustomAnnotationTest ChildBeanParameterType pChild );

  /**
   * @param pIBAN
   * @return boolean
   */
  @JEAFCustomAnnotationTest
  boolean checkIBAN( @JEAFCustomAnnotationTest String pIBAN );

  /**
   * @param pChannelTypes
   * @return {@link List<Channel>}
   */
  @JEAFCustomAnnotationTest
  List<Channel> getChannels( @JEAFCustomAnnotationTest List<ChannelType> pChannelTypes );

  /**
   * @param pChannelType
   * @return {@link Channel}
   */
  @JEAFCustomAnnotationTest
  Channel getDefaultChannel( @JEAFCustomAnnotationTest ChannelType pChannelType );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @JEAFCustomAnnotationTest
  List<CurrencyCode> getSupportedCurrencies( @JEAFCustomAnnotationTest ChannelCode pChannelCode );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @JEAFCustomAnnotationTest
  List<CurrencyCode> getSupportedCurrenciesAsync( @JEAFCustomAnnotationTest ChannelCode pChannelCode );

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
  @JEAFCustomAnnotationTest
  void testDateQueryParams( @JEAFCustomAnnotationTest String pPath,
      @JEAFCustomAnnotationTest OffsetDateTime pStartTimestamp, @JEAFCustomAnnotationTest OffsetTime pStartTime,
      @JEAFCustomAnnotationTest LocalDateTime pLocalStartTimestamp, @JEAFCustomAnnotationTest LocalTime pLocalStartTime,
      @JEAFCustomAnnotationTest LocalDate pLocalStartDate, @JEAFCustomAnnotationTest Calendar pCalendar,
      @JEAFCustomAnnotationTest java.util.Date pUtilDate, @JEAFCustomAnnotationTest Timestamp pSQLTimestamp,
      @JEAFCustomAnnotationTest Time pSQLTime, @JEAFCustomAnnotationTest Date pSQLDate );

  /**
   * @param pPath
   * @param pQueryParams
   */
  @JEAFCustomAnnotationTest
  void testDateQueryParamsBean( @JEAFCustomAnnotationTest String pPath,
      @JEAFCustomAnnotationTest DateQueryParamsBean pQueryParams );

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testOptionalQueryParams( @JEAFCustomAnnotationTest String query1, @JEAFCustomAnnotationTest int query2 );

  /**
   * @param authorization
   * @param pContentType
   * @param pAccept
   */
  @JEAFCustomAnnotationTest
  void testSpecialHeaderParams( @JEAFCustomAnnotationTest String authorization,
      @JEAFCustomAnnotationTest String pContentType, @JEAFCustomAnnotationTest String pAccept );

  /**
   * @param pContext
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testTechnicalHeaderBean( @JEAFCustomAnnotationTest TechnicalHeaderContext pContext );

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testTechnicalHeaderParam( @JEAFCustomAnnotationTest String pReseller );

  /**
   * @param pInlinedBeanParam
   */
  @JEAFCustomAnnotationTest
  void testNotInlinedBeanParam( @JEAFCustomAnnotationTest NotInlinedBeanParam pInlinedBeanParam );

  /**
   * @param pIntegerArray
   */
  @JEAFCustomAnnotationTest
  void testPrimitiveArray( @JEAFCustomAnnotationTest int[] pIntegerArray );

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testPrimitiveArrayAsQueryParam( @JEAFCustomAnnotationTest int[] pIntValues );

  /**
   * @param pCodes
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testMultivaluedHeader( @JEAFCustomAnnotationTest List<BigDecimalCode> pCodes );

  /**
   * @param pCodes
   * @param pEnums
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testMultivaluedQueryParams( @JEAFCustomAnnotationTest List<BigDecimalCode> pCodes,
      @JEAFCustomAnnotationTest List<BooleanLiteralsEnum> pEnums );

  /**
   * @param pBeanParam
   * @param pTheEnum
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String testMulitValuedBeanParams( @JEAFCustomAnnotationTest MultiValuedDataType pBeanParam,
      @JEAFCustomAnnotationTest BooleanLiteralsEnum pTheEnum );

  /**
   * @param pHeader
   * @param pContext
   */
  @JEAFCustomAnnotationTest
  void noReturnType( @JEAFCustomAnnotationTest String pHeader, @JEAFCustomAnnotationTest MultiValuedDataType pContext );

  /**
   * @param pID
   */
  @JEAFCustomAnnotationTest
  void deleteSomething( @JEAFCustomAnnotationTest String pID );

  /**
   * @return {@link GenericSingleValuedReponse<BusinessServiceObject>}
   */
  @JEAFCustomAnnotationTest
  GenericSingleValuedReponse<BusinessServiceObject> genericSingleValueResponse( );

  /**
   * @return {@link GenericPageableResponse<BusinessServiceObject>}
   */
  @JEAFCustomAnnotationTest
  GenericPageableResponse<BusinessServiceObject> genericMultiValueResponse( );

  /**
   * @param pStringCode
   * @param pShortCodes
   * @param pJustAByte
   */
  @JEAFCustomAnnotationTest
  void testDataTypeWithRestrition( @JEAFCustomAnnotationTest StringCode pStringCode,
      @JEAFCustomAnnotationTest Set<ShortCode> pShortCodes,
      @JEAFCustomAnnotationTest @Min(value = 32) Byte pJustAByte );

  /**
   * @param pContext
   */
  @JEAFCustomAnnotationTest
  void testContext( @JEAFCustomAnnotationTest Context pContext );

  /**
   * @return {@link Response<Pageable<BusinessServiceObject>>}
   */
  @JEAFCustomAnnotationTest
  Response<Pageable<BusinessServiceObject>> testNestedGenericsResponse( );

  /**
   * @return {@link Response<List<Offer>>}
   */
  @JEAFCustomAnnotationTest
  Response<List<Offer>> testNestedMultivaluedResponse( );

  /**
   * @return {@link Response<Offer>}
   */
  @JEAFCustomAnnotationTest
  Response<Offer> testDuplicateGenerics1( );

  /**
   * @return {@link Response<Offer>}
   */
  @JEAFCustomAnnotationTest
  Response<Offer> testDuplicateGenerics2( );
}