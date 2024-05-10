# My Roles Report
## Role `Accounting Basic Data Admin`
### Service `AccountingBasicDataService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `createResponsibilityType(ResponsibilityType)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createBank(Bank)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createEmployee(Person, ResponsibilityType, Bank)` |  |

## Role `Accounting User`
### Service `AccountingService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `createAccount(Customer, Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getAccount(ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `lockAccount(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `unlock(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createCustomer(Customer, ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getCustomer(ServiceObjectID, CustomerLoadStrategy)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createPerson(Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `searchCustomers(CustomerQuery)` |  |

## Role `Advanced User`
### Service `AccountingBasicDataService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `createAccount(Customer, Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getAccount(ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `lockAccount(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `unlock(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createCustomer(Customer, ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getCustomer(ServiceObjectID, CustomerLoadStrategy)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createPerson(Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `searchCustomers(CustomerQuery)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createResponsibilityType(ResponsibilityType)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createBank(Bank)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createEmployee(Person, ResponsibilityType, Bank)` |  |

### Service `AccountingService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `createAccount(Customer, Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getAccount(ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `lockAccount(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `unlock(Account)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createCustomer(Customer, ServiceObjectID)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getCustomer(ServiceObjectID, CustomerLoadStrategy)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createPerson(Person)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `searchCustomers(CustomerQuery)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createResponsibilityType(ResponsibilityType)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createBank(Bank)` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createEmployee(Person, ResponsibilityType, Bank)` |  |

## Role `Customer`
### Service `RESTProductService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `getProducts(int)` | `/rest-products [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `ping()` | `/rest-products [HEAD]` |

### Service `RESTProductService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `getProducts(int)` | `/rest-products [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `ping()` | `/rest-products [HEAD]` |

## Role `Sales Agent`
### Service `RESTProductService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `getProducts(int)` | `/rest-products [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getProduct(String)` | `/rest-products/{id} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createProduct(Product)` | `/rest-products [POST]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getSortiment(Context)` | `/rest-products/sortiment/{id} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `createChannelCode(String)` | `/rest-products/ChannelCode [POST]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `ping()` | `/rest-products [HEAD]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testInit()` | `/rest-products/test-init [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getSupportedCurrencies(ChannelCode)` | `/rest-products/currencies/{channelCode} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `getSupportedCurrenciesAsync(ChannelCode)` | `/rest-products/async-currencies/{channelCode} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testParams(BigDecimal, int, Locale)` | `/rest-products/test-params [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testEnumParams(ChannelType, TimeUnit, ExtensibleEnum)` | `/rest-products/test-enum-params/{channelType} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testEnumHeaderParams(ChannelType, TimeUnit, ExtensibleEnum)` | `/rest-products/test-enum-header-params [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDateQueryParams(String, OffsetDateTime, OffsetTime, LocalDateTime, LocalTime, LocalDate, Calendar, Date, Timestamp, Time, Date, Calendar)` | `/rest-products/test-date-query-params/{path} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDateQueryParamsBean(String, DateQueryParamsBean)` | `/rest-products/test-date-query-params-beans/{path} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDateHeaderParams(String, OffsetDateTime, OffsetTime, LocalDateTime, LocalTime, LocalDate, Calendar, Date, Timestamp, Time, Date, Date)` | `/rest-products/test-date-header-params/{path} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDateHeaderParamsBean(String, DateHeaderParamsBean)` | `/rest-products/test-date-header-params-beans/{path} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testCookieParams(ChannelType, SpecialContext)` | `/rest-products/cookies [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testOptionalQueryParams(String, int)` | `/rest-products/test-optional-query-params [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `processComplexBookingID(ComplexBookingID)` | `/rest-products/complex/{bookingID} [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDataTypesAsHeaderParam(BookingID, BookingCode, DoubleCode)` | `/rest-products/dataTypesInHeader [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDataTypesAsHeaderBeanParam(AdvancedHeader)` | `/rest-products/dataTypesInBeanHeader [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testPrimitiveArrays(int)` | `/rest-products/testPrimitiveArrayAsBody [POST]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDataTypeAsQueryParam(BookingCode)` | `/rest-products/testDataTypeAsQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testDataTypeAsBeanQueryParam(QueryBeanParam)` | `/rest-products/testDataTypeAsBeanQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testPrimitiveArrayAsQueryParam(int)` | `/rest-products/testPrimitiveArrayAsQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testSimpleTypesAsQueryParams(String)` | `/rest-products/testSimpleTypesAsQueryParams [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testPrimitiveWrapperArrayAsQueryParam(Integer)` | `/rest-products/testPrimitiveWrapperArrayAsQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testMultivaluedQueryParamsBean(MultivaluedQueryParamsBean)` | `/rest-products/testMultivaluedQueryParamsBean [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testMulitvaluedDataTypeAsQueryParam(IntegerCodeType, LongCode, BookingID, OffsetDateTime, LocalDate)` | `/rest-products/testMulitvaluedDataTypeAsQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testMulitvaluedDataTypeAsBeanQueryParam(DataTypesQueryBean)` | `/rest-products/testMulitvaluedDataTypeAsBeanQueryParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testMultiValuedHeaderFieldsInBeanParam(MultiValuedHeaderBeanParam)` | `/rest-products/testMultiValuedHeaderFieldsInBeanParam [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testMultiValuedHeaderFields(String, int, Double, StringCode, OffsetDateTime, OffsetDateTime, OffsetTime, byte)` | `/rest-products/testMultiValuedHeaderFields [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testBookingIDAsPathParam(BookingID)` | `/rest-products/booking-id-as-path-param/{bookingID} [PATCH]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testBookingIDAsHeaderParam(BookingID)` | `/rest-products/booking-id-as-header-param [PATCH]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testContextWithPrimitives(ContextWithPrimitives)` | `/rest-products/test-context-with-primitives [GET]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `testPrimitivesAsParams(int, Integer, Boolean, Boolean, long, Long)` | `/rest-products/test-primitives-as-params [GET]` |

## Role `Standard User`
### Service `AccountingService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentUser()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkInvalidServiceAccess()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentAnonymousUser()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `searchCustomers(CustomerQuery)` |  |

### Service `AccountingService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentUser()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkInvalidServiceAccess()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentAnonymousUser()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |

| Operation        | REST Resource Path |
|------------------|---------------|
| `searchCustomers(CustomerQuery)` |  |

### Service `JEAFSecurityTestService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentUser()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkInvalidServiceAccess()` |  |

| Operation        | REST Resource Path |
|------------------|---------------|
| `checkCurrentAnonymousUser()` |  |

## Role `Support User`
### Service `AccountingService`

| Operation        | REST Resource Path |
|------------------|---------------|
| `unlock(Account)` |  |

