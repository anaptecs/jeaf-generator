# My Java Deprecation Report

<br>

## Deprecated Services

<br>

| Service Name   | Description   | Deprecated since   | Planned to be removed   |
|----------------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.BusinessObjectTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.core.DeprecatedTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.core.JEAFTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.service1.ProductService` |  |  |  |
| `com.anaptecs.jeaf.junit.rest.DeprecatedRESTService` |  |  |  |
| `com.anaptecs.jeaf.junit.rest.RESTTestService` |  |  |  |

<br>


### `com.anaptecs.jeaf.junit.core.BusinessObjectTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprectedOperation()` | |  |  |  |

<br>




### `com.anaptecs.jeaf.junit.core.JEAFTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `checkRequiredService_2()` | |  |  |  |

<br>



### `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `createSomething()` | | Resources can no longer be explicitly be created. | 0.9 | 1.2.3 |
| `createSomething(JustAType, String, String, BeanParamWithDeprecations)` | |  |  |  |
|   | `String pHeader` | Please do not use this header any longer. No matter what you pass here it will be ignored. |  |  |
|   | `String pQueryParam` |  |  |  |

<br>



### `com.anaptecs.jeaf.junit.openapi.service1.ProductService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprecatedBody(String)` | |  |  |  |
|   | `String pBody` |  |  |  |
| `deprecatedComplexReturn()` | |  |  |  |
|   | `Product ` |  |  |  |
| `deprecatedOperation()` | |  |  |  |
| `deprecatedParams(int)` | |  |  |  |
|   | `int pParam1` |  |  |  |
|   | `String ` |  |  |  |
| `deprectedComplexRequestBody(Product)` | |  |  |  |
|   | `Product pProduct` |  |  |  |

<br>




### `com.anaptecs.jeaf.junit.rest.RESTTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprecatedAsync(int)` | |  |  |  |
| `deprecatedAsyncParam(int)` | |  |  |  |
|   | `int pParam1` |  |  |  |
|   | `String ` |  |  |  |
| `deprecatedOperation()` | | Please use something else.<br><br>This is not the right operation any longer.<br><br>Sorry!!! | a very long time | 2023-12-13 |
| `deprecatedParameter(int, int)` | |  |  |  |
|   | `int pParam2` |  |  |  |
| `deprectaedReturnValue(int)` | |  |  |  |
|   | `int ` |  |  |  |

<br>




## Deprecated Classes

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.DeprecatedServiceObject` | |  |  |  |
| `com.anaptecs.jeaf.junit.core.PartiallyDeprecatedServiceObject` | |  |  |  |
|   | `outdated` |  |  |  |
|   | `deprecatedRef` |  |  |  |
|   | `deprecatedRefs` |  |  |  |
| `com.anaptecs.jeaf.junit.deprecation.BeanParamWithDeprecations` | |  |  |  |
|   | `deprecatedHeader` | this header param is no longer supported. Please use "xxx" instead. | 1.2.3 | PI.2.3 |
| `com.anaptecs.jeaf.junit.deprecation.JustAType` | |  |  |  |
|   | `legacy` | Hello |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.DeprecatedDomainObject` | |  |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.Price` | |  |  |  |
|   | `price` |  |  |  |
|   | `reiseweg` |  |  |  |
|   | `verbindungspunkte` |  |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.Reiseweg` | |  |  |  |
| `com.anaptecs.jeaf.junit.impl.domain.DeprecatedPO` | |  |  |  |
|   | `deprecated` |  |  |  |
|   | `publicClass` |  |  |  |
|   | `baseClasses` |  |  |  |
| `com.anaptecs.jeaf.junit.impl.domain.PublicClassBO` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.BeanParameter` | |  |  |  |
|   | `oldStyle` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.Campaign` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `moreLinks` |  |  |  |
|   | `discountOffers` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ChildAA` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ChildBB` | |  |  |  |
|   | `deprecatedAttribute` |  |  |  |
|   | `deprecatedBs` |  |  |  |
|   | `deprecatedParent` |  |  |  |
|   | `deprecatedArray` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.DiscountOffer` | |  |  |  |
|   | `campaigns` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.POI` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `evenMoreLinks` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ParentClass` | |  |  |  |
|   | `theBankAccount` |  |  |  |
|   | `legacyBankAccounts` |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.BChildPOJO` | |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO` | |  |  |  |
|   | `deprecatedRefs` |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.ParentPOJO` | |  |  |  |
|   | `weirdAttribute` |  |  |  |

<br>


## Deprecated Enumerations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.Color` | |  |  |  |
|   | `LightGreen` |  |  |  |
| `com.anaptecs.jeaf.junit.core.Farbe` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ChannelType` | |  |  |  |
|   | `LEGACY_POS` |  |  |  |

<br>

