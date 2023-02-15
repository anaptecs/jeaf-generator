/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.InventoryType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.MultivaluedQueryParamsBean;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;

@Service
public class RESTProductServiceImpl implements RESTProductService {

  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    return null;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    return null;
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    return false;
  }

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return null;
  }

  @Override
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    return null;
  }

  @Override
  public void ping( ) {
  }

  @Override
  public void testInit( ) {
  }

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    return null;
  }

  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
  }

  @Override
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
  }

  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate, Set<Calendar> pCalendars ) {

    if (pPath.equals("2")) {
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pCalendar.getTime()));
      assertEquals("2022-03-17", pLocalStartDate.toString());
      assertEquals("2022-03-17T13:22:12.453", pLocalStartTimestamp.toString());
      assertEquals("13:22:12.453", pLocalStartTime.toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", pStartTimestamp.toString());
      assertEquals("13:22:12.453+01:00", pStartTime.toString());
      assertEquals("2022-03-17", pSQLDate.toString());
      assertEquals("13:22:12", pSQLTime.toString());
      assertEquals("2022-03-17 13:22:12.453", pSQLTimestamp.toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pUtilDate));
    }
    else {
      fail("Invalid path");
    }
  }

  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    if (pPath.equals("1")) {
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pQueryParams.getCalendar().getTime()));
      assertEquals("2022-03-17", pQueryParams.getLocalDate().toString());
      assertEquals("2022-03-17T13:22:12.453", pQueryParams.getLocalDateTime().toString());
      assertEquals("13:22:12.453", pQueryParams.getLocalTime().toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", pQueryParams.getOffsetDateTime().toString());
      assertEquals("13:22:12.453+01:00", pQueryParams.getOffsetTime().toString());
      assertEquals("2022-03-17", pQueryParams.getSqlDate().toString());
      assertEquals("13:22:12", pQueryParams.getSqlTime().toString());
      assertEquals("2022-03-17 13:22:12.453", pQueryParams.getSqlTimestamp().toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pQueryParams.getUtilDate()));
    }
    else {
      fail("Invalid path");
    }
  }

  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate, Set<Date> pUtilDates ) {
  }

  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    if (pPath.equals("1")) {
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pHeaderParams.getCalendar().getTime()));
      assertEquals("2022-03-17", pHeaderParams.getLocalDate().toString());
      assertEquals("2022-03-17T13:22:12.453", pHeaderParams.getLocalDateTime().toString());
      assertEquals("13:22:12.453", pHeaderParams.getLocalTime().toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", pHeaderParams.getOffsetDateTime().toString());
      assertEquals("13:22:12.453+01:00", pHeaderParams.getOffsetTime().toString());
      assertEquals("2022-03-17", pHeaderParams.getSqlDate().toString());
      assertEquals("13:22:12", pHeaderParams.getSqlTime().toString());
      assertEquals("2022-03-17 13:22:12.453", pHeaderParams.getSqlTimestamp().toString());
      assertEquals("2022-03-17T13:22:12.453+01:00", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(
          pHeaderParams.getUtilDate()));
    }
    else {
      fail("Invalid path");
    }
  }

  @Override
  public void testCookieParams( ChannelType pChannelType, SpecialContext pContext ) {
  }

  @Override
  public String testOptionalQueryParams( String pQuery1, int pQuery2 ) {
    return null;
  }

  @Override
  public boolean processComplexBookingID( ComplexBookingID pComplextBookingID ) {
    assertEquals(123456789, pComplextBookingID.getInternalID());
    assertEquals(ComplexBookingType.VERY_COMPLEX, pComplextBookingID.getComplexBookingType());

    BookingID lBookingID1 = pComplextBookingID.getBookingIDs().get(0);
    assertEquals("REFUND_CODE", lBookingID1.getBookingCode().getCode());
    assertEquals(InventoryType.SNCF, lBookingID1.getInventory());
    assertEquals("XXYYZZ", lBookingID1.getReferenceID());
    assertEquals("EXT_#äöß?\"§$§\"$\"%$", lBookingID1.getExternalRefID());

    BookingID lBookingID2 = pComplextBookingID.getBookingIDs().get(1);
    assertEquals("BOOKING_CODE", lBookingID2.getBookingCode().getCode());
    assertEquals(InventoryType.SBB, lBookingID2.getInventory());
    assertEquals("123456", lBookingID2.getReferenceID());
    assertEquals("EXT-0987654321", lBookingID2.getExternalRefID());
    return true;
  }

  @Override
  public String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    return pBookingID.getReferenceID() + "_" + pBookingID.getExternalRefID() + "_" + pBookingCode.getCode() + "_"
        + pDoubleCode.getCode();
  }

  @Override
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    return "Bean-Header: " + pContext.getBookingID().getReferenceID() + "_" + pContext.getBookingID()
        .getExternalRefID() + "_" + pContext.getBookingCode().getCode() + "_" + pContext.getDoubleCode().getCode();
  }

  @Override
  public String testPrimitiveArrays( int[] pIntegerArray ) {
    return null;
  }

  @Override
  public String testDataTypeAsQueryParam( BookingCode pBookingCode ) {
    return pBookingCode.getCode();
  }

  @Override
  public String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam ) {
    return "Bean: " + pBeanParam.getBookingCode().getCode();
  }

  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    return Arrays.toString(pIntValues);
  }

  @Override
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    Collections.reverse(pStrings);
    return pStrings.toString();
  }

  @Override
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    List<Integer> lSorted = new ArrayList<>(pIntegers);
    Collections.sort(lSorted);
    return lSorted.toString();
  }

  @Override
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    return Arrays.toString(pBean.getIntArray()) + "_" + Arrays.toString(pBean.getIntegers()) + "_" + Arrays.toString(
        pBean.getStrings());
  }

  @Override
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates ) {

    String lResult = "";
    for (IntegerCodeType lNext : pCodes) {
      lResult = lResult + lNext.getCode() + ".";
    }
    return lResult + pLongCodes.iterator().next().getCode();
  }

  @Override
  public String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean ) {
    String lResult = "";
    for (IntegerCodeType lNext : pQueryBean.getCodes()) {
      lResult = lResult + lNext.getCode() + ".";
    }
    for (LongCode lNext : pQueryBean.getLongCodes()) {
      lResult = lResult + lNext.getCode() + "_";
    }
    for (DoubleCode lNext : pQueryBean.getDoubleCodes()) {
      lResult = lResult + lNext.getCode() + "_";
    }
    return lResult + pQueryBean.getOffsetDateTime() + "_" + pQueryBean.getLocalDateTime() + "_" + pQueryBean
        .getLocalTime() + "_" + pQueryBean.getOffsetTime() + "_" + pQueryBean.getTimes();
  }

  @Override
  public String testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean ) {
    String lCodes = "";
    for (StringCode lNext : pMultiValuedBean.getCodes()) {
      lCodes = lCodes + "-" + lNext.getCode();
    }
    String lStringCodeList = "";
    for (StringCode lNext : pMultiValuedBean.getStringCodeList()) {
      lStringCodeList = lStringCodeList + "-" + lNext.getCode();
    }

    String lDates = "";
    if (pMultiValuedBean.getDates() != null) {
      for (LocalDate lNext : pMultiValuedBean.getDates()) {
        lDates = lDates + DateTimeFormatter.ISO_DATE.format(lNext) + ",";
      }
    }
    return Arrays.toString(pMultiValuedBean.getNames()) + "_" + Arrays.toString(pMultiValuedBean.getInts()) + "_"
        + Arrays.toString(pMultiValuedBean.getDoubles()) + "_"
        + lCodes + "_" + lStringCodeList + "_" + pMultiValuedBean.getStartDate() + "_" + lDates;
  }

  @Override
  public String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes ) {
    String lCodes = "";
    for (StringCode lNext : pCodes) {
      lCodes = lCodes + "-" + lNext.getCode();
    }

    return pNames.toString() + "_" + Arrays.toString(pInts) + "_"
        + pDoubles.toString() + "_" + lCodes + "_" + pTimestamps.toString() + "_" + pTimes.toString();
  }

  @Override
  public void testBookingIDAsPathParam( BookingID pBookingID ) {
    assertEquals("4711-0815", pBookingID.getBookingCode().getCode());
    assertEquals("EXT-123-987", pBookingID.getExternalRefID());
    assertEquals("REF-555999", pBookingID.getReferenceID());
    assertEquals(InventoryType.SBB, pBookingID.getInventory());
    assertEquals("DTQ3MTEtMDgxtUVYVC0xMjMtOTi3AVJFRi01NTU5Obk=", pBookingID.getPublicBookingID());
  }

  @Override
  public void testBookingIDAsHeaderParam( BookingID pBookingID ) {
    if (pBookingID != null) {
      assertEquals("4711-0815", pBookingID.getBookingCode().getCode());
      assertEquals("EXT-123-987", pBookingID.getExternalRefID());
      assertEquals("REF-555999", pBookingID.getReferenceID());
      assertEquals(InventoryType.SBB, pBookingID.getInventory());
      assertEquals("DTQ3MTEtMDgxtUVYVC0xMjMtOTi3AVJFRi01NTU5Obk=", pBookingID.getPublicBookingID());
    }
  }

}
