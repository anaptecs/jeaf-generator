/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;
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
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyServiceParam;
import com.anaptecs.annotations.MyNotNullServiceParam;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCodeType;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.composite.ComplexBookingID;

public interface RESTProductService {
  /**
   * Operation returns all available product.
   * <p/>
   * <b>Authorized Roles:</b> <code>`Customer`, `Sales Agent`</code>
   *
   * @param pMaxResultSize
   * @return {@link List<Product>} My default comment
   */
  @Size(min = 0, groups = { V7.class })
  List<Product> getProducts( int pMaxResultSize );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @NotNull
  @MyNotNullServiceParam
  Product getProduct( @NotEmpty @NotNull @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pProduct My default comment
   * @return boolean
   */
  boolean createProduct( @NotNull @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @NotNull
  @MyNotNullServiceParam
  Sortiment getSortiment( @NotNull @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @NotNull
  @MyNotNullServiceParam
  ChannelCode createChannelCode( @NotBlank @NotNull @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Customer`, `Sales Agent`</code>
   */
  @NotNull
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   */
  @NotNull
  void testInit( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 0, groups = { V7.class })
  List<CurrencyCode> getSupportedCurrencies( @NotNull @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 0, groups = { V7.class })
  List<CurrencyCode> getSupportedCurrenciesAsync( @NotNull @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testParams( @NotNull @MyNotNullServiceParam BigDecimal pBigDecimalHeader, int pIntCookieParam,
      @NotNull @MyNotNullServiceParam Locale pLocaleQueryParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @NotNull
  void testEnumParams( @NotNull @MyNotNullServiceParam ChannelType pChannelType,
      @NotNull @MyNotNullServiceParam TimeUnit pTimeUnit,
      @NotNull @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @NotNull
  void testEnumHeaderParams( @NotNull @MyNotNullServiceParam ChannelType pChannelType,
      @NotNull @MyNotNullServiceParam TimeUnit pTimeUnit,
      @NotNull @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
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
   * @param pCalendars
   */
  @NotNull
  void testDateQueryParams( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam OffsetDateTime pStartTimestamp,
      @NotNull @MyNotNullServiceParam OffsetTime pStartTime,
      @NotNull @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp,
      @NotNull @MyNotNullServiceParam LocalTime pLocalStartTime,
      @NotNull @MyNotNullServiceParam LocalDate pLocalStartDate, @NotNull @MyNotNullServiceParam Calendar pCalendar,
      @NotNull @MyNotNullServiceParam java.util.Date pUtilDate, @NotNull @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @NotNull @MyNotNullServiceParam Time pSQLTime, @NotNull @MyNotNullServiceParam Date pSQLDate,
      @Size(min = 0, groups = { V7.class }) Set<Calendar> pCalendars );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pPath
   * @param pQueryParams
   */
  @NotNull
  void testDateQueryParamsBean( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pPath
   * @param pOffsetDateTime
   * @param pOffsetTime
   * @param pLocalDateTime
   * @param pLocalTime
   * @param pLocalDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   * @param pUtilDates
   */
  @NotNull
  void testDateHeaderParams( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam OffsetDateTime pOffsetDateTime,
      @NotNull @MyNotNullServiceParam OffsetTime pOffsetTime,
      @NotNull @MyNotNullServiceParam LocalDateTime pLocalDateTime,
      @NotNull @MyNotNullServiceParam LocalTime pLocalTime, @NotNull @MyNotNullServiceParam LocalDate pLocalDate,
      @NotNull @MyNotNullServiceParam Calendar pCalendar, @NotNull @MyNotNullServiceParam java.util.Date pUtilDate,
      @NotNull @MyNotNullServiceParam Timestamp pSQLTimestamp, @NotNull @MyNotNullServiceParam Time pSQLTime,
      @NotNull @MyNotNullServiceParam Date pSQLDate,
      @Size(min = 0, groups = { V7.class }) Set<java.util.Date> pUtilDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pPath
   * @param pHeaderParams
   */
  @NotNull
  void testDateHeaderParamsBean( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelTypeParam
   * @param pContext
   */
  @NotNull
  void testCookieParams( @NotNull @MyNotNullServiceParam ChannelType pChannelTypeParam,
      @NotNull @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testOptionalQueryParams( @NotNull(groups = { V7.class }) String query1, int query2 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pComplextBookingID
   * @return boolean
   */
  boolean processComplexBookingID( @NotNull @MyNotNullServiceParam ComplexBookingID pComplextBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testDataTypesAsHeaderParam( @NotNull(groups = { V7.class }) BookingID pBookingID,
      @NotNull(groups = { V7.class }) BookingCode pBookingCode,
      @NotNull(groups = { V7.class }) DoubleCodeType pDoubleCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testDataTypesAsHeaderBeanParam( @NotNull @MyNotNullServiceParam AdvancedHeader pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntegerArray
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testPrimitiveArrays( @Size(min = 0, groups = { V7.class }) int[] pIntegerArray );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingCode
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testDataTypeAsQueryParam( @NotNull @MyNotNullServiceParam BookingCode pBookingCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testDataTypeAsBeanQueryParam( @NotNull @MyNotNullServiceParam QueryBeanParam pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntValues
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testPrimitiveArrayAsQueryParam( @Size(min = 0, groups = { V7.class }) int[] pIntValues );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pStrings
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testSimpleTypesAsQueryParams( @Size(min = 0, groups = { V7.class }) List<String> pStrings );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntegers
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testPrimitiveWrapperArrayAsQueryParam( @Size(min = 1) @MyNotEmptyServiceParam Set<Integer> pIntegers );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBean
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testMultivaluedQueryParamsBean( @NotNull @MyNotNullServiceParam MultivaluedQueryParamsBean pBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @param pTimestamps
   * @param pLocalDates
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testMulitvaluedDataTypeAsQueryParam( @Size(min = 0, groups = { V7.class }) List<IntegerCodeType> pCodes,
      @Size(min = 1) @MyNotEmptyServiceParam Set<LongCode> pLongCodes,
      @Size(min = 0, groups = { V7.class }) List<BookingID> pBookingIDs,
      @Size(min = 0, groups = { V7.class }) List<OffsetDateTime> pTimestamps,
      @Size(min = 0, groups = { V7.class }) SortedSet<LocalDate> pLocalDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pQueryBean
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testMulitvaluedDataTypeAsBeanQueryParam( @NotNull @MyNotNullServiceParam DataTypesQueryBean pQueryBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testMultiValuedHeaderFieldsInBeanParam(
      @NotNull @MyNotNullServiceParam MultiValuedHeaderBeanParam pMultiValuedBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pNames
   * @param pInts
   * @param pDoubles
   * @param pCodes
   * @param pStartDate
   * @param pTimestamps
   * @param pTimes
   * @param pBase64
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testMultiValuedHeaderFields( @Size(min = 0, groups = { V7.class }) Set<String> pNames,
      @Size(min = 1) @MyNotEmptyServiceParam int[] pInts, @Size(min = 0, groups = { V7.class }) Set<Double> pDoubles,
      @Size(min = 0, groups = { V7.class }) Set<StringCode> pCodes,
      @NotNull(groups = { V7.class }) OffsetDateTime pStartDate,
      @Size(min = 0, groups = { V7.class }) Set<OffsetDateTime> pTimestamps,
      @Size(min = 0, groups = { V7.class }) Set<OffsetTime> pTimes,
      @Size(min = 0, groups = { V7.class }) byte[] pBase64 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   */
  @NotNull
  void testBookingIDAsPathParam( @NotNull @MyNotNullServiceParam BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   */
  @NotNull
  void testBookingIDAsHeaderParam( @NotNull(groups = { V7.class }) BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testContextWithPrimitives( @NotNull @MyNotNullServiceParam ContextWithPrimitives pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pAnInt
   * @param pAnInteger
   * @param pABoolean
   * @param pBooleanWrapper
   * @param pALong
   * @param pVeryLong
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testPrimitivesAsParams( int pAnInt, @NotNull @MyNotNullServiceParam Integer pAnInteger, boolean pABoolean,
      @NotNull @MyNotNullServiceParam Boolean pBooleanWrapper, long pALong,
      @NotNull @MyNotNullServiceParam Long pVeryLong );
}