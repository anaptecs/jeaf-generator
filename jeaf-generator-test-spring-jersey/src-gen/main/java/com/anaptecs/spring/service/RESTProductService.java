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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface RESTProductService {
  /**
   * Operation returns all available product.
   * 
   * 
   * @param pMaxResultSize
   * @return {@link Product}
   */
  List<Product> getProducts( int pMaxResultSize );

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  Product getProduct( @NotEmpty String pProductID );

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
  ChannelCode createChannelCode( @NotBlank String pChannelCode );

  /**
  * 
  */
  void ping( );

  /**
  * 
  */
  void testInit( );

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode );

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode );

  /**
   * 
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam );

  /**
   * 
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum );

  /**
   * 
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum );

  /**
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
  void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<Calendar> pCalendars );

  /**
   * 
   * @param pPath
   * @param pQueryParams
   */
  void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams );

  /**
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
  void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<java.util.Date> pUtilDates );

  /**
   * 
   * @param pPath
   * @param pHeaderParams
   */
  void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams );

  /**
   * 
   * @param pChannelTypeParam
   * @param pContext
   */
  void testCookieParams( ChannelType pChannelTypeParam, SpecialContext pContext );

  /**
   * 
   * @param query1
   * @param query2
   * @return {@link String}
   */
  String testOptionalQueryParams( String query1, int query2 );

  /**
   * 
   * @param pComplextBookingID
   * @return {@link Boolean}
   */
  boolean processComplexBookingID( ComplexBookingID pComplextBookingID );

  /**
   * 
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode );

  /**
   * 
   * @param pContext
   * @return {@link String}
   */
  String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext );

  /**
   * 
   * @param pIntegerArray
   * @return {@link String}
   */
  String testPrimitiveArrays( int[] pIntegerArray );

  /**
   * 
   * @param pBookingCode
   * @return {@link String}
   */
  String testDataTypeAsQueryParam( BookingCode pBookingCode );

  /**
   * 
   * @param pBeanParam
   * @return {@link String}
   */
  String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam );

  /**
   * 
   * @param pIntValues
   * @return {@link String}
   */
  String testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * 
   * @param pStrings
   * @return {@link String}
   */
  String testSimpleTypesAsQueryParams( List<String> pStrings );

  /**
   * 
   * @param pIntegers
   * @return {@link String}
   */
  String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers );

  /**
   * 
   * @param pBean
   * @return {@link String}
   */
  String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean );

  /**
   * 
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @return {@link String}
   */
  String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs );

  /**
   * 
   * @param pQueryBean
   * @return {@link String}
   */
  String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean );

  /**
   * 
   * @param pMultiValuedBean
   * @return {@link String}
   */
  String testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean );

  /**
   * 
   * @param pNames
   * @param pInts
   * @param pDoubles
   * @param pCodes
   * @param pStartDate
   * @param pTimestamps
   * @param pTimes
   * @return {@link String}
   */
  String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles, Set<StringCode> pCodes,
      OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes );
}
