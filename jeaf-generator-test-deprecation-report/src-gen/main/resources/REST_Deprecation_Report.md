# REST Deprecation Report #

<br>

## Deprecated REST Resources ##

<br>

| Deprecated Resource   | Service Name   | Description   | Deprecated since   | Planned to be removed   |
|-----------------------|----------------|---------------|:------------------:|:-----------------------:|
| `/do/something` | `com.anaptecs.jeaf.junit.rest.DeprecatedRESTService` |  |  |  |

<br>

## REST Operations with Deprecations ##

<br>

| Path   | Type   | Deprecated Element   | Description   | Deprecated since   | Planned to be removed   |
|--------|--------|----------------------|---------------|:------------------:|:-----------------------:|
| `/api/beanParam2 [POST]` | `REST Operation` | `RESTTestService.handleBeanParam1(BeanParameter)` |  |  |  |
| `/api/dep/async [POST]` | `REST Operation` | `RESTTestService.deprecatedAsyncParam(int)` |  |  |  |
|   | `Body` | `int pParam1` |  |  |  |
|   | `Response` | `String ` |  |  |  |
| `/api/dep/async [POST]` | `REST Operation` | `RESTTestService.deprecatedAsync(int)` |  |  |  |
| `/api/deprcation/dep1 [GET]` | `REST Operation` | `RESTTestService.deprecatedOperation()` | Please use something else.<br><br>This is not the right operation any longer.<br><br>Sorry!!! | a very long time | 2023-12-13 |
| `/api/deprecation/dep2 [GET]` | `REST Operation` | `RESTTestService.deprecatedParameter(int, int)` |  |  |  |
|   | `Header Param` | `int pParam2` |  |  |  |
| `/api/deprecation/dep3 [GET]` | `REST Operation` | `RESTTestService.deprectaedReturnValue(int)` |  |  |  |
|   | `Response` | `int ` |  |  |  |
| `/products/deprecated/beanParams [POST]` | `REST Operation` | `ProductService.deprecatedBeanParam(BeanParameter)` |  |  |  |
| `/products/deprecated/body [POST]` | `REST Operation` | `ProductService.deprecatedBody(String)` |  |  |  |
|   | `Body` | `String pBody` |  |  |  |
| `/products/deprecated/complexBody [POST]` | `REST Operation` | `ProductService.deprectedComplexRequestBody(Product)` |  |  |  |
|   | `Body` | `Product pProduct` |  |  |  |
| `/products/deprecated/complexReturn [GET]` | `REST Operation` | `ProductService.deprecatedComplexReturn()` |  |  |  |
|   | `Response` | `Product ` |  |  |  |
| `/products/deprecated/operation [GET]` | `REST Operation` | `ProductService.deprecatedOperation()` |  |  |  |
| `/products/deprecated/params [POST]` | `REST Operation` | `ProductService.deprecatedParams(int)` |  |  |  |
|   | `Header Param` | `int param1` |  |  |  |
|   | `Response` | `String ` |  |  |  |
| `/with-deprecations [POST]` | `REST Operation` | `ServiceWithDeprecations.createSomething()` | Resources can no longer be explicitly be created. | 0.9 | 1.2.3 |
| `/with-deprecations [POST]` | `REST Operation` | `ServiceWithDeprecations.createSomething(JustAType, String, String, BeanParamWithDeprecations)` |  |  |  |
|   | `Header Param` | `String header-xxx` |  |  |  |
|   | `Query Param` | `String query` |  |  |  |
|   | `Header Param` | `String deprecatedHeader` | this header param is no longer supported. Please use "xxx" instead. | 1.2.3 | PI.2.3 |

<br>

## Deprecated OpenAPI Elements ##

<br>

### Deprecated OpenAPI Types ###

<br>

| Type   | Element   | Description   | Deprecated since   | Planned to be removed   |
|--------|-----------|---------------|:------------------:|:-----------------------:|
| `Campaign` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `moreLinks` |  |  |  |
|   | `discountOffers` |  |  |  |
| `ChildAA` | |  |  |  |
| `ChildBB` | |  |  |  |
|   | `deprecatedAttribute` |  |  |  |
|   | `deprecatedBs` |  |  |  |
|   | `deprecatedParent` |  |  |  |
|   | `deprecatedArray` |  |  |  |
| `DataTypeWithDeprecation` | |  |  |  |
|   | `code` | Time to say goodbye | just recently | Next version |
| `DeprecatedDataType` | |  |  |  |
| `DeprecatedType` | | This type will be replaced with .... |  |  |
| `DiscountOffer` | |  |  |  |
|   | `campaigns` |  |  |  |
| `JustAType` | |  |  |  |
|   | `legacy` | Hello |  |  |
| `POI` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `evenMoreLinks` |  |  |  |
| `ParentClass` | |  |  |  |
|   | `theBankAccount` |  |  |  |
|   | `legacyBankAccounts` |  |  |  |

<br>


### Deprecated OpenAPI Enumerations ###

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `ChannelType` | |  |  |  |
|   | `LEGACY_POS` |  |  |  |
| `DeprecatedEnum` | |  |  |  |
| `DeprecatedEnum` | |  |  |  |
| `EnumWithDeprecation` | |  |  |  |
|   | `EGG` | Eggs do not belong to apples. | 0.9 | 1.2 |

<br>

