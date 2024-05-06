/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.lang.reflect.Method;
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.spring.base.AnotherDataType;
import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;
import com.anaptecs.spring.base.TechnicalHeaderContext;
import com.anaptecs.spring.service.monitoring.MonitoringService;

/**
 * ServiceProxy class for JEAF service ProductService.
 */
public final class ProductServiceProxy extends ServiceProxy implements ProductService, MonitoringService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public ProductServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(ProductService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#getProducts}
   */
  @SuppressWarnings("unchecked")
  public List<Product> getProducts( ) {
    try {
      Command lCommand = new GetProducts_ProductService_Command();
      return (List<Product>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#getProduct}
   */
  public Product getProduct( @NotEmpty String pProductID ) {
    try {
      Command lCommand = new GetProduct_String_ProductService_Command(pProductID);
      return (Product) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#createProduct}
   */
  public boolean createProduct( Product pProduct ) {
    try {
      Command lCommand = new CreateProduct_Product_ProductService_Command(pProduct);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#getSortiment}
   */
  public Sortiment getSortiment( Context pContext ) {
    try {
      Command lCommand = new GetSortiment_Context_ProductService_Command(pContext);
      return (Sortiment) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#createChannelCode}
   */
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    try {
      Command lCommand = new CreateChannelCode_String_ProductService_Command(pChannelCode);
      return (ChannelCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#ping}
   */
  public void ping( ) {
    try {
      Command lCommand = new Ping_ProductService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#deprecatedOperation}
   */
  @Deprecated
  public String deprecatedOperation( ) {
    try {
      Command lCommand = new DeprecatedOperation_ProductService_Command();
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#deprecatedContext}
   */
  public String deprecatedContext( DeprecatedContext pContext ) {
    try {
      Command lCommand = new DeprecatedContext_DeprecatedContext_ProductService_Command(pContext);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#deprecatedBeanParam}
   */
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
    try {
      Command lCommand = new DeprecatedBeanParam_BeanParameter_ProductService_Command(pBeanParam);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#deprecatedParams}
   */
  @Deprecated
  public String deprecatedParams( @Deprecated int pParam1 ) {
    try {
      Command lCommand = new DeprecatedParams_int_ProductService_Command(pParam1);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#deprecatedBody}
   */
  public String deprecatedBody( @Deprecated String pBody ) {
    try {
      Command lCommand = new DeprecatedBody_String_ProductService_Command(pBody);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#deprectedComplexRequestBody}
   */
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    try {
      Command lCommand = new DeprectedComplexRequestBody_Product_ProductService_Command(pProduct);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#deprecatedComplexReturn}
   */
  @Deprecated
  public Product deprecatedComplexReturn( ) {
    try {
      Command lCommand = new DeprecatedComplexReturn_ProductService_Command();
      return (Product) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#loadSpecificThings}
   */
  public void loadSpecificThings( SpecialContext pContext ) {
    try {
      Command lCommand = new LoadSpecificThings_SpecialContext_ProductService_Command(pContext);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#createChannelCodeFromObject}
   */
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new CreateChannelCodeFromObject_ChannelCode_ProductService_Command(pChannelCode);
      return (ChannelCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#addCurrencies}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    try {
      Command lCommand = new AddCurrencies_CurrencyCode_ProductService_Command(pCurrencies);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#isCurrencySupported}
   */
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    try {
      Command lCommand = new IsCurrencySupported_CurrencyCode_ProductService_Command(pCurrency);
      return (CurrencyCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#testCodeTypeUsage}
   */
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    try {
      Command lCommand = new TestCodeTypeUsage_StringCodeType_ProductService_Command(pStringCode);
      return (IntegerCodeType) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#testLocalBeanParamType}
   */
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    try {
      Command lCommand = new TestLocalBeanParamType_LocalBeanParamType_ProductService_Command(pBeanParam);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#testExternalBeanParameterType}
   */
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    try {
      Command lCommand = new TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command(pParent);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#testChildBeanParameter}
   */
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    try {
      Command lCommand = new TestChildBeanParameter_ChildBeanParameterType_ProductService_Command(pChild);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#testDateQueryParams}
   */
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    try {
      Command lCommand =
          new TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
              pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar,
              pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#testDateQueryParamsBean}
   */
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    try {
      Command lCommand =
          new TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command(pPath, pQueryParams);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#testDateHeaderParams}
   */
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    try {
      Command lCommand =
          new TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
              pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate,
              pSQLTimestamp, pSQLTime, pSQLDate);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#testDateHeaderParamsBean}
   */
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    try {
      Command lCommand =
          new TestDateHeaderParamsBean_String_DateHeaderParamsBean_ProductService_Command(pPath, pHeaderParams);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderParam}
   */
  public String testTechnicalHeaderParam( String pReseller ) {
    try {
      Command lCommand = new TestTechnicalHeaderParam_String_String_ProductService_Command(pReseller);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderBean}
   */
  public String testTechnicalHeaderBean( TechnicalHeaderContext pContext ) {
    try {
      Command lCommand = new TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command(pContext);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.ProductService#processDataTypes}
   */
  public String processDataTypes( List<AnotherDataType> pCodes ) {
    try {
      Command lCommand = new ProcessDataTypes_AnotherDataType_ProductService_Command(pCodes);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link MonitoringService#getVersionInfo}
   */
  public String getVersionInfo( ) {
    try {
      Command lCommand = new GetVersionInfo_MonitoringService_Command();
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "getProducts".
 */
final class GetProducts_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("getProducts");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getProducts(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "getProducts" have to be passed as parameters to this command object.
   *
   *
   */
  GetProducts_ProductService_Command( ) {
    super(ProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getProducts();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getProduct".
 */
final class GetProduct_String_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("getProduct", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getProduct(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProductID" to the service implementation via the service channel.
   */
  private final String productID;

  /**
   * Initialize object. All parameters from method "getProduct" have to be passed as parameters to this command object.
   *
   * @param pProductID String
   */
  GetProduct_String_ProductService_Command( String pProductID ) {
    super(ProductService.class);
    productID = pProductID;
    parameters = new Object[] { productID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getProduct(productID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createProduct".
 */
final class CreateProduct_Product_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("createProduct", Product.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createProduct(Product.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProduct" to the service implementation via the service channel.
   */
  private final Product product;

  /**
   * Initialize object. All parameters from method "createProduct" have to be passed as parameters to this command
   * object.
   *
   * @param pProduct Product
   */
  CreateProduct_Product_ProductService_Command( Product pProduct ) {
    super(ProductService.class);
    product = pProduct;
    parameters = new Object[] { product };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createProduct(product);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getSortiment".
 */
final class GetSortiment_Context_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("getSortiment", Context.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getSortiment(Context.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final Context context;

  /**
   * Initialize object. All parameters from method "getSortiment" have to be passed as parameters to this command
   * object.
   *
   * @param pContext Context
   */
  GetSortiment_Context_ProductService_Command( Context pContext ) {
    super(ProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getSortiment(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createChannelCode".
 */
final class CreateChannelCode_String_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("createChannelCode", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createChannelCode(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final String channelCode;

  /**
   * Initialize object. All parameters from method "createChannelCode" have to be passed as parameters to this command
   * object.
   *
   * @param pChannelCode String
   */
  CreateChannelCode_String_ProductService_Command( String pChannelCode ) {
    super(ProductService.class);
    channelCode = pChannelCode;
    parameters = new Object[] { channelCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createChannelCode(channelCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "ping".
 */
final class Ping_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("ping");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "ping(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "ping" have to be passed as parameters to this command object.
   *
   *
   */
  Ping_ProductService_Command( ) {
    super(ProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.ping();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedOperation".
 */
final class DeprecatedOperation_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedOperation");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedOperation(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "deprecatedOperation" have to be passed as parameters to this command
   * object.
   *
   *
   */
  DeprecatedOperation_ProductService_Command( ) {
    super(ProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedOperation();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedContext".
 */
final class DeprecatedContext_DeprecatedContext_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedContext", DeprecatedContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedContext(DeprecatedContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final DeprecatedContext context;

  /**
   * Initialize object. All parameters from method "deprecatedContext" have to be passed as parameters to this command
   * object.
   *
   * @param pContext DeprecatedContext
   */
  DeprecatedContext_DeprecatedContext_ProductService_Command( DeprecatedContext pContext ) {
    super(ProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedContext(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedBeanParam".
 */
final class DeprecatedBeanParam_BeanParameter_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedBeanParam", BeanParameter.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedBeanParam(BeanParameter.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final BeanParameter beanParam;

  /**
   * Initialize object. All parameters from method "deprecatedBeanParam" have to be passed as parameters to this command
   * object.
   *
   * @param pBeanParam BeanParameter
   */
  DeprecatedBeanParam_BeanParameter_ProductService_Command( BeanParameter pBeanParam ) {
    super(ProductService.class);
    beanParam = pBeanParam;
    parameters = new Object[] { beanParam };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.deprecatedBeanParam(beanParam);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedParams".
 */
final class DeprecatedParams_int_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedParams", int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedParams(int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParam1" to the service implementation via the service channel.
   */
  private final int param1;

  /**
   * Initialize object. All parameters from method "deprecatedParams" have to be passed as parameters to this command
   * object.
   *
   * @param pParam1 int
   */
  DeprecatedParams_int_ProductService_Command( @Deprecated int pParam1 ) {
    super(ProductService.class);
    param1 = pParam1;
    parameters = new Object[] { param1 };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedParams(param1);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedBody".
 */
final class DeprecatedBody_String_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedBody", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedBody(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBody" to the service implementation via the service channel.
   */
  private final String body;

  /**
   * Initialize object. All parameters from method "deprecatedBody" have to be passed as parameters to this command
   * object.
   *
   * @param pBody String
   */
  DeprecatedBody_String_ProductService_Command( @Deprecated String pBody ) {
    super(ProductService.class);
    body = pBody;
    parameters = new Object[] { body };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedBody(body);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprectedComplexRequestBody".
 */
final class DeprectedComplexRequestBody_Product_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprectedComplexRequestBody", Product.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprectedComplexRequestBody(Product.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProduct" to the service implementation via the service channel.
   */
  private final Product product;

  /**
   * Initialize object. All parameters from method "deprectedComplexRequestBody" have to be passed as parameters to this
   * command object.
   *
   * @param pProduct Product
   */
  DeprectedComplexRequestBody_Product_ProductService_Command( @Deprecated Product pProduct ) {
    super(ProductService.class);
    product = pProduct;
    parameters = new Object[] { product };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.deprectedComplexRequestBody(product);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "deprecatedComplexReturn".
 */
final class DeprecatedComplexReturn_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedComplexReturn");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedComplexReturn(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "deprecatedComplexReturn" have to be passed as parameters to this
   * command object.
   *
   *
   */
  DeprecatedComplexReturn_ProductService_Command( ) {
    super(ProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedComplexReturn();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "loadSpecificThings".
 */
final class LoadSpecificThings_SpecialContext_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("loadSpecificThings", SpecialContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "loadSpecificThings(SpecialContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final SpecialContext context;

  /**
   * Initialize object. All parameters from method "loadSpecificThings" have to be passed as parameters to this command
   * object.
   *
   * @param pContext SpecialContext
   */
  LoadSpecificThings_SpecialContext_ProductService_Command( SpecialContext pContext ) {
    super(ProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.loadSpecificThings(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createChannelCodeFromObject".
 */
final class CreateChannelCodeFromObject_ChannelCode_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("createChannelCodeFromObject", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createChannelCodeFromObject(ChannelCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final ChannelCode channelCode;

  /**
   * Initialize object. All parameters from method "createChannelCodeFromObject" have to be passed as parameters to this
   * command object.
   *
   * @param pChannelCode ChannelCode
   */
  CreateChannelCodeFromObject_ChannelCode_ProductService_Command( ChannelCode pChannelCode ) {
    super(ProductService.class);
    channelCode = pChannelCode;
    parameters = new Object[] { channelCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createChannelCodeFromObject(channelCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "addCurrencies".
 */
final class AddCurrencies_CurrencyCode_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("addCurrencies", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "addCurrencies(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCurrencies" to the service implementation via the service channel.
   */
  private final List<CurrencyCode> currencies;

  /**
   * Initialize object. All parameters from method "addCurrencies" have to be passed as parameters to this command
   * object.
   *
   * @param pCurrencies List<CurrencyCode>
   */
  AddCurrencies_CurrencyCode_ProductService_Command( List<CurrencyCode> pCurrencies ) {
    super(ProductService.class);
    currencies = pCurrencies;
    parameters = new Object[] { currencies };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.addCurrencies(currencies);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "isCurrencySupported".
 */
final class IsCurrencySupported_CurrencyCode_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("isCurrencySupported", CurrencyCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "isCurrencySupported(CurrencyCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCurrency" to the service implementation via the service channel.
   */
  private final CurrencyCode currency;

  /**
   * Initialize object. All parameters from method "isCurrencySupported" have to be passed as parameters to this command
   * object.
   *
   * @param pCurrency CurrencyCode
   */
  IsCurrencySupported_CurrencyCode_ProductService_Command( CurrencyCode pCurrency ) {
    super(ProductService.class);
    currency = pCurrency;
    parameters = new Object[] { currency };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.isCurrencySupported(currency);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testCodeTypeUsage".
 */
final class TestCodeTypeUsage_StringCodeType_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testCodeTypeUsage", StringCodeType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testCodeTypeUsage(StringCodeType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pStringCode" to the service implementation via the service channel.
   */
  private final StringCodeType stringCode;

  /**
   * Initialize object. All parameters from method "testCodeTypeUsage" have to be passed as parameters to this command
   * object.
   *
   * @param pStringCode StringCodeType
   */
  TestCodeTypeUsage_StringCodeType_ProductService_Command( StringCodeType pStringCode ) {
    super(ProductService.class);
    stringCode = pStringCode;
    parameters = new Object[] { stringCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testCodeTypeUsage(stringCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testLocalBeanParamType".
 */
final class TestLocalBeanParamType_LocalBeanParamType_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testLocalBeanParamType", LocalBeanParamType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testLocalBeanParamType(LocalBeanParamType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final LocalBeanParamType beanParam;

  /**
   * Initialize object. All parameters from method "testLocalBeanParamType" have to be passed as parameters to this
   * command object.
   *
   * @param pBeanParam LocalBeanParamType
   */
  TestLocalBeanParamType_LocalBeanParamType_ProductService_Command( LocalBeanParamType pBeanParam ) {
    super(ProductService.class);
    beanParam = pBeanParam;
    parameters = new Object[] { beanParam };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testLocalBeanParamType(beanParam);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testExternalBeanParameterType".
 */
final class TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testExternalBeanParameterType", ParentBeanParamType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testExternalBeanParameterType(ParentBeanParamType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParent" to the service implementation via the service channel.
   */
  private final ParentBeanParamType parent;

  /**
   * Initialize object. All parameters from method "testExternalBeanParameterType" have to be passed as parameters to
   * this command object.
   *
   * @param pParent ParentBeanParamType
   */
  TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command( ParentBeanParamType pParent ) {
    super(ProductService.class);
    parent = pParent;
    parameters = new Object[] { parent };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testExternalBeanParameterType(parent);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testChildBeanParameter".
 */
final class TestChildBeanParameter_ChildBeanParameterType_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testChildBeanParameter", ChildBeanParameterType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testChildBeanParameter(ChildBeanParameterType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChild" to the service implementation via the service channel.
   */
  private final ChildBeanParameterType child;

  /**
   * Initialize object. All parameters from method "testChildBeanParameter" have to be passed as parameters to this
   * command object.
   *
   * @param pChild ChildBeanParameterType
   */
  TestChildBeanParameter_ChildBeanParameterType_ProductService_Command( ChildBeanParameterType pChild ) {
    super(ProductService.class);
    child = pChild;
    parameters = new Object[] { child };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testChildBeanParameter(child);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateQueryParams".
 */
final class TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testDateQueryParams", String.class, OffsetDateTime.class,
          OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class,
          Timestamp.class, Time.class, Date.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateQueryParams(String.class, OffsetDateTime.class, OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class, Timestamp.class, Time.class, Date.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pStartTimestamp" to the service implementation via the service channel.
   */
  private final OffsetDateTime startTimestamp;

  /**
   * Attribute transports the method parameter "pStartTime" to the service implementation via the service channel.
   */
  private final OffsetTime startTime;

  /**
   * Attribute transports the method parameter "pLocalStartTimestamp" to the service implementation via the service
   * channel.
   */
  private final LocalDateTime localStartTimestamp;

  /**
   * Attribute transports the method parameter "pLocalStartTime" to the service implementation via the service channel.
   */
  private final LocalTime localStartTime;

  /**
   * Attribute transports the method parameter "pLocalStartDate" to the service implementation via the service channel.
   */
  private final LocalDate localStartDate;

  /**
   * Attribute transports the method parameter "pCalendar" to the service implementation via the service channel.
   */
  private final Calendar calendar;

  /**
   * Attribute transports the method parameter "pUtilDate" to the service implementation via the service channel.
   */
  private final java.util.Date utilDate;

  /**
   * Attribute transports the method parameter "pSQLTimestamp" to the service implementation via the service channel.
   */
  private final Timestamp sQLTimestamp;

  /**
   * Attribute transports the method parameter "pSQLTime" to the service implementation via the service channel.
   */
  private final Time sQLTime;

  /**
   * Attribute transports the method parameter "pSQLDate" to the service implementation via the service channel.
   */
  private final Date sQLDate;

  /**
   * Initialize object. All parameters from method "testDateQueryParams" have to be passed as parameters to this command
   * object.
   *
   * @param pPath String
   * @param pStartTimestamp OffsetDateTime
   * @param pStartTime OffsetTime
   * @param pLocalStartTimestamp LocalDateTime
   * @param pLocalStartTime LocalTime
   * @param pLocalStartDate LocalDate
   * @param pCalendar Calendar
   * @param pUtilDate java.util.Date
   * @param pSQLTimestamp Timestamp
   * @param pSQLTime Time
   * @param pSQLDate Date
   */
  TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
      String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime, LocalDateTime pLocalStartTimestamp,
      LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar, java.util.Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    super(ProductService.class);
    path = pPath;
    startTimestamp = pStartTimestamp;
    startTime = pStartTime;
    localStartTimestamp = pLocalStartTimestamp;
    localStartTime = pLocalStartTime;
    localStartDate = pLocalStartDate;
    calendar = pCalendar;
    utilDate = pUtilDate;
    sQLTimestamp = pSQLTimestamp;
    sQLTime = pSQLTime;
    sQLDate = pSQLDate;
    parameters = new Object[] { path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
      calendar, utilDate, sQLTimestamp, sQLTime, sQLDate };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateQueryParams(path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
        calendar, utilDate, sQLTimestamp, sQLTime, sQLDate);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateQueryParamsBean".
 */
final class TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          ProductService.class.getMethod("testDateQueryParamsBean", String.class, DateQueryParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateQueryParamsBean(String.class, DateQueryParamsBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pQueryParams" to the service implementation via the service channel.
   */
  private final DateQueryParamsBean queryParams;

  /**
   * Initialize object. All parameters from method "testDateQueryParamsBean" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pQueryParams DateQueryParamsBean
   */
  TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command( String pPath,
      DateQueryParamsBean pQueryParams ) {
    super(ProductService.class);
    path = pPath;
    queryParams = pQueryParams;
    parameters = new Object[] { path, queryParams };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateQueryParamsBean(path, queryParams);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateHeaderParams".
 */
final class TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testDateHeaderParams", String.class, OffsetDateTime.class,
          OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class,
          Timestamp.class, Time.class, Date.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateHeaderParams(String.class, OffsetDateTime.class, OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class, Timestamp.class, Time.class, Date.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pOffsetDateTime" to the service implementation via the service channel.
   */
  private final OffsetDateTime offsetDateTime;

  /**
   * Attribute transports the method parameter "pOffsetTime" to the service implementation via the service channel.
   */
  private final OffsetTime offsetTime;

  /**
   * Attribute transports the method parameter "pLocalDateTime" to the service implementation via the service channel.
   */
  private final LocalDateTime localDateTime;

  /**
   * Attribute transports the method parameter "pLocalTime" to the service implementation via the service channel.
   */
  private final LocalTime localTime;

  /**
   * Attribute transports the method parameter "pLocalDate" to the service implementation via the service channel.
   */
  private final LocalDate localDate;

  /**
   * Attribute transports the method parameter "pCalendar" to the service implementation via the service channel.
   */
  private final Calendar calendar;

  /**
   * Attribute transports the method parameter "pUtilDate" to the service implementation via the service channel.
   */
  private final java.util.Date utilDate;

  /**
   * Attribute transports the method parameter "pSQLTimestamp" to the service implementation via the service channel.
   */
  private final Timestamp sQLTimestamp;

  /**
   * Attribute transports the method parameter "pSQLTime" to the service implementation via the service channel.
   */
  private final Time sQLTime;

  /**
   * Attribute transports the method parameter "pSQLDate" to the service implementation via the service channel.
   */
  private final Date sQLDate;

  /**
   * Initialize object. All parameters from method "testDateHeaderParams" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pOffsetDateTime OffsetDateTime
   * @param pOffsetTime OffsetTime
   * @param pLocalDateTime LocalDateTime
   * @param pLocalTime LocalTime
   * @param pLocalDate LocalDate
   * @param pCalendar Calendar
   * @param pUtilDate java.util.Date
   * @param pSQLTimestamp Timestamp
   * @param pSQLTime Time
   * @param pSQLDate Date
   */
  TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
      String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime, LocalDateTime pLocalDateTime,
      LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, java.util.Date pUtilDate, Timestamp pSQLTimestamp,
      Time pSQLTime, Date pSQLDate ) {
    super(ProductService.class);
    path = pPath;
    offsetDateTime = pOffsetDateTime;
    offsetTime = pOffsetTime;
    localDateTime = pLocalDateTime;
    localTime = pLocalTime;
    localDate = pLocalDate;
    calendar = pCalendar;
    utilDate = pUtilDate;
    sQLTimestamp = pSQLTimestamp;
    sQLTime = pSQLTime;
    sQLDate = pSQLDate;
    parameters = new Object[] { path, offsetDateTime, offsetTime, localDateTime, localTime, localDate, calendar,
      utilDate, sQLTimestamp, sQLTime, sQLDate };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateHeaderParams(path, offsetDateTime, offsetTime, localDateTime, localTime, localDate, calendar,
        utilDate, sQLTimestamp, sQLTime, sQLDate);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateHeaderParamsBean".
 */
final class TestDateHeaderParamsBean_String_DateHeaderParamsBean_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          ProductService.class.getMethod("testDateHeaderParamsBean", String.class, DateHeaderParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateHeaderParamsBean(String.class, DateHeaderParamsBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pHeaderParams" to the service implementation via the service channel.
   */
  private final DateHeaderParamsBean headerParams;

  /**
   * Initialize object. All parameters from method "testDateHeaderParamsBean" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pHeaderParams DateHeaderParamsBean
   */
  TestDateHeaderParamsBean_String_DateHeaderParamsBean_ProductService_Command( String pPath,
      DateHeaderParamsBean pHeaderParams ) {
    super(ProductService.class);
    path = pPath;
    headerParams = pHeaderParams;
    parameters = new Object[] { path, headerParams };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateHeaderParamsBean(path, headerParams);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testTechnicalHeaderParam".
 */
final class TestTechnicalHeaderParam_String_String_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testTechnicalHeaderParam", String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testTechnicalHeaderParam(String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pReseller" to the service implementation via the service channel.
   */
  private final String reseller;

  /**
   * Initialize object. All parameters from method "testTechnicalHeaderParam" have to be passed as parameters to this
   * command object.
   *
   * @param pReseller String
   * @param pAuthenticationToken String
   */
  TestTechnicalHeaderParam_String_String_ProductService_Command( String pReseller ) {
    super(ProductService.class);
    reseller = pReseller;
    parameters = new Object[] { reseller };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testTechnicalHeaderParam(reseller);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testTechnicalHeaderBean".
 */
final class TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("testTechnicalHeaderBean", TechnicalHeaderContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testTechnicalHeaderBean(TechnicalHeaderContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final TechnicalHeaderContext context;

  /**
   * Initialize object. All parameters from method "testTechnicalHeaderBean" have to be passed as parameters to this
   * command object.
   *
   * @param pContext TechnicalHeaderContext
   */
  TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command( TechnicalHeaderContext pContext ) {
    super(ProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testTechnicalHeaderBean(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "processDataTypes".
 */
final class ProcessDataTypes_AnotherDataType_ProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("processDataTypes", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "processDataTypes(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCodes" to the service implementation via the service channel.
   */
  private final List<AnotherDataType> codes;

  /**
   * Initialize object. All parameters from method "processDataTypes" have to be passed as parameters to this command
   * object.
   *
   * @param pCodes List<AnotherDataType>
   */
  ProcessDataTypes_AnotherDataType_ProductService_Command( List<AnotherDataType> pCodes ) {
    super(ProductService.class);
    codes = pCodes;
    parameters = new Object[] { codes };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.processDataTypes(codes);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getVersionInfo".
 */
final class GetVersionInfo_MonitoringService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = ProductService.class.getMethod("getVersionInfo");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getVersionInfo(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "getVersionInfo" have to be passed as parameters to this command
   * object.
   *
   *
   */
  GetVersionInfo_MonitoringService_Command( ) {
    super(ProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getVersionInfo();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}
