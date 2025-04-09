/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

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

import com.anaptecs.jeaf.core.api.Component;
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
import com.anaptecs.jeaf.junit.openapi.service1.ChildBeanParameterType;
import com.anaptecs.jeaf.junit.openapi.service1.DateQueryParamsBean;
import com.anaptecs.jeaf.junit.openapi.service1.LocalBeanParamType;
import com.anaptecs.jeaf.junit.openapi.service1.TechnicalHeaderContext;
import com.anaptecs.jeaf.junit.rest.generics.BusinessServiceObject;
import com.anaptecs.jeaf.junit.rest.generics.GenericPageableResponse;
import com.anaptecs.jeaf.junit.rest.generics.GenericSingleValuedReponse;
import com.anaptecs.jeaf.junit.rest.generics.Offer;
import com.anaptecs.jeaf.junit.rest.generics.Pageable;
import com.anaptecs.jeaf.junit.rest.generics.Response;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of ProductService.
 */
final class ProductServiceImpl extends ProductServiceImplBase {
  /**
   * Initialize object.
   */
  ProductServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   *
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * Operation returns all available product.
   *
   * @return {@link List<Product>}
   */
  @Override
  public List<Product> getProducts( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pProductID
   * @return {@link Product}
   */
  @Override
  public Product getProduct( String pProductID ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pProduct
   * @return boolean
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pChannelCode
   * <p/>
   * <b>Breaking Change with 2.0:</b> Parameter will be mandatory
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   */
  @Override
  public void ping( ) {
  }

  /**
   * @return {@link String}
   * @deprecated This request is no longer supported. (<b>since:</b> 1.1.1, <b>removed with:</b> 2024-10-20)
   */
  @Deprecated
  @Override
  public String deprecatedOperation( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pBeanParam
   */
  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
  }

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String deprecatedParams( @Deprecated int pParam1 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @Override
  public String deprecatedBody( @Deprecated String pBody ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Override
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
  }

  /**
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public Product deprecatedComplexReturn( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pContext
   */
  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
  }

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pParent
   * @return {@link String}
   */
  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pChild
   * @return {@link String}
   */
  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pIBAN
   * @return boolean
   */
  @Override
  public boolean checkIBAN( String pIBAN ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * @param pChannelTypes
   * @return {@link List<Channel>}
   */
  @Override
  public List<Channel> getChannels( List<ChannelType> pChannelTypes ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pChannelType
   * @return {@link Channel}
   */
  @Override
  public Channel getDefaultChannel( ChannelType pChannelType ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

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
  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
  }

  /**
   * @param pPath
   * @param pQueryParams
   */
  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
  }

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @Override
  public String testOptionalQueryParams( String query1, int query2 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param authorization
   * @param pContentType
   * @param pAccept
   */
  @Override
  public void testSpecialHeaderParams( String authorization, String pContentType, String pAccept ) {
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testTechnicalHeaderBean( TechnicalHeaderContext pContext ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @Override
  public String testTechnicalHeaderParam( String pReseller ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pInlinedBeanParam
   */
  @Override
  public void testNotInlinedBeanParam( NotInlinedBeanParam pInlinedBeanParam ) {
  }

  /**
   * @param pIntegerArray
   */
  @Override
  public void testPrimitiveArray( int[] pIntegerArray ) {
  }

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pCodes
   * @return {@link String}
   */
  @Override
  public String testMultivaluedHeader( List<BigDecimalCode> pCodes ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pCodes
   * @param pEnums
   * @return {@link String}
   */
  @Override
  public String testMultivaluedQueryParams( List<BigDecimalCode> pCodes, List<BooleanLiteralsEnum> pEnums ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pBeanParam
   * @param pTheEnum
   * @return {@link String}
   */
  @Override
  public String testMulitValuedBeanParams( MultiValuedDataType pBeanParam, BooleanLiteralsEnum pTheEnum ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pHeader
   * @param pContext
   */
  @Override
  public void noReturnType( String pHeader, MultiValuedDataType pContext ) {
  }

  /**
   * @param pID
   */
  @Override
  public void deleteSomething( String pID ) {
  }

  /**
   * @return {@link GenericSingleValuedReponse<BusinessServiceObject>}
   */
  @Override
  public GenericSingleValuedReponse<BusinessServiceObject> genericSingleValueResponse( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @return {@link GenericPageableResponse<BusinessServiceObject>}
   */
  @Override
  public GenericPageableResponse<BusinessServiceObject> genericMultiValueResponse( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pStringCode
   * @param pShortCodes
   * @param pJustAByte
   */
  @Override
  public void testDataTypeWithRestrition( StringCode pStringCode, Set<ShortCode> pShortCodes, Byte pJustAByte ) {
  }

  /**
   * @param pContext
   */
  @Override
  public void testContext( Context pContext ) {
  }

  /**
   * @return {@link Response<Pageable<BusinessServiceObject>>}
   */
  @Override
  public Response<Pageable<BusinessServiceObject>> testNestedGenericsResponse( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @return {@link Response<List<Offer>>}
   */
  @Override
  public Response<List<Offer>> testNestedMultivaluedResponse( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @return {@link Response<Offer>}
   */
  @Override
  public Response<Offer> testDuplicateGenerics1( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @return {@link Response<Offer>}
   */
  @Override
  public Response<Offer> testDuplicateGenerics2( ) {
    // TODO Implement method and return real result
    return null;
  }
}