/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
import com.anaptecs.spring.base.Product.Builder;
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
    Builder lBuilder = Product.builder();
    lBuilder.setName("Cool Product");

    List<Product> lProducts = new ArrayList<>();
    lProducts.add(lBuilder.build());

    return lProducts;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    Product lProduct;
    if (pProductID.endsWith("12345")) {
      lProduct = Product.builder().setName("Cool Product").setUri("https://products.anaptecs.de/123456789").build();
    }
    if (pProductID.endsWith("17")) {
      throw new IllegalArgumentException("Exception expected for Product 17");
    }
    else {
      lProduct = null;
    }
    return lProduct;
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    return true;
  }

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return null;
  }

  @Override
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    return ChannelCode.builder().setCode(pChannelCode).build();
  }

  @Override
  public void ping( ) {
  }

  @Override
  public void testInit( ) {
  }

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    List<CurrencyCode> lCurrencies = new ArrayList<>();
    lCurrencies.add(CurrencyCode.builder().setCode("EUR").build());
    lCurrencies.add(CurrencyCode.builder().setCode("CHF").build());
    return lCurrencies;
  }

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    List<CurrencyCode> lCurrencies = new ArrayList<>();
    lCurrencies.add(CurrencyCode.builder().setCode("EUR").build());
    lCurrencies.add(CurrencyCode.builder().setCode("CHF").build());
    lCurrencies.add(CurrencyCode.builder().setCode("USD").build());
    return lCurrencies;
  }

  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    // BigDecimal.valueOf(3.1423), 9999, Locale.GERMANY
    if (BigDecimal.valueOf(3.1423).equals(pBigDecimalHeader) && pIntCookieParam == 9999 && Locale.GERMANY.equals(
        pLocaleQueryParam)) {
      return "Hello World of REST!";
    }
    else {
      throw new IllegalArgumentException("Invalid parameters.");
    }
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
      Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {
  }

  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
  }

  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {
  }

  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
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
    return null;
  }

  @Override
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    return null;
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
    return pBeanParam.getBookingCode().getCode();
  }

  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    return pIntValues.toString();
  }

  @Override
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    return pStrings.toString();
  }

  @Override
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    return pIntegers.toString();
  }

  @Override
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    return null;
  }

  @Override
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs ) {
    return null;
  }

  @Override
  public String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean ) {
    return null;
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
    return Arrays.toString(pMultiValuedBean.getNames()) + "_" + Arrays.toString(pMultiValuedBean.getInts()) + "_"
        + Arrays.toString(pMultiValuedBean.getDoubles()) + "_"
        + lCodes + "_" + lStringCodeList;
  }

  @Override
  public String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes ) {
    return null;
  }
}
