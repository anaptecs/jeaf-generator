# My Java Deprecation Report

<br>

## Removable Deprecations

| Package | Type | Property / Operation | Description | Deprecated since | Planned to be removed |
|---------|------|----------------------|-------------|------------------|-----------------------|			
| `com.anaptecs.jeaf.junit.rest` | `RESTTestService` | `deprecatedOperation` | Please use something else.<br><br>This is not the right operation any longer.<br><br>Sorry!!! | a very long time | 2023-12-13 |   
| `com.anaptecs.jeaf.junit.openapi.base` | `base` |  |  |  | 2022-07-25 |   
| `com.anaptecs.jeaf.junit.openapi.base` | `SpecialContext` | `deprecatedHeader` |  |  | 2024-12-24 |   
| `com.anaptecs.jeaf.junit.openapi.service1` | `ProductService` | `deprecatedOperation` | This request is no longer supported. | 1.1.1 | 2024-10-20 |   
| `com.anaptecs.jeaf.junit.deprecation` | `deprecation` |  | This service does not make sense any more.<br><br>The functionality is completely wrong. | 1.0 | 2023-12-31 |   

<br>
	
## Package `com.anaptecs.jeaf.junit`

<br>

### Enumerations with Deprecations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `EnumWithDeprecatedProperty` | |  |  |  |
|   | `B` |  |  |  |

<br>

| Type | Property   | Description   | Deprecated since   | Planned to be removed   |
|------|------------|---------------|:------------------:|:-----------------------:|
| `EnumWithDeprecatedProperty` | `doNotUse` | Very outdated | 08.15 | 47.11 |

<br>

## Package `com.anaptecs.jeaf.junit.activities`

<br>

## Package `com.anaptecs.jeaf.junit.core`

<br>

### Services with Deprecations 

<br>

| Service Name   | Description   | Deprecated since   | Planned to be removed   |
|----------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedTestService` |  |  |  |

<br>

#### `BusinessObjectTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprectedOperation()` | |  |  |  |

<br>

#### `JEAFTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `checkRequiredService_2()` | |  |  |  |

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedServiceObject` | |  |  |  |
| `PartiallyDeprecatedServiceObject` | |  |  |  |
|   | `outdated` |  |  |  |
|   | `deprecatedRef` |  |  |  |
|   | `deprecatedRefs` |  |  |  |

<br>

### Enumerations with Deprecations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `Color` | |  |  |  |
|   | `LightGreen` | We do not like this color any more. |  |  |
| `Farbe` | |  |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.deprecation`

<br>

### Services with Deprecations 

<br>

| Service Name   | Description   | Deprecated since   | Planned to be removed   |
|----------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedService` | This service does not make sense any more.<br><br>The functionality is completely wrong. | 1.0 | 2023-12-31 |

<br>

#### `ServiceWithDeprecations`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `createSomething()` | | Resources can no longer be explicitly be created. | 0.9 | 1.2.3 |
| `createSomething(JustAType, String, String, BeanParamWithDeprecations)` | |  |  |  |
|   | `String pHeader` | Please do not use this header any longer. No matter what you pass here it will be ignored. |  |  |
|   | `String pQueryParam` |  |  |  |

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `BeanParamWithDeprecations` | |  |  |  |
|   | `deprecatedHeader` | this header param is no longer supported. Please use "xxx" instead. | 1.2.3 | PI.2.3 |
| `JustAType` | |  |  |  |
|   | `legacy` | Hello |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.domainObjects`

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedDomainObject` | |  |  |  |
| `Price` | |  |  |  |
|   | `price` |  |  |  |
|   | `reiseweg` |  |  |  |
|   | `verbindungspunkte` |  |  |  |
| `Reiseweg` | |  |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.impl.core`

<br>

## Package `com.anaptecs.jeaf.junit.impl.domain`

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedPO` | |  |  |  |
|   | `deprecated` |  |  |  |
|   | `publicClass` |  |  |  |
|   | `baseClasses` |  |  |  |
| `PublicClassBO` | |  |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.impl.persistence`

<br>

## Package `com.anaptecs.jeaf.junit.openapi.base`

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `BeanParameter` | |  |  |  |
|   | `oldStyle` |  |  |  |
| `Campaign` | |  |  |  |
|   | `theLink` | Please use "moreLinks" instead. | 2.3.1 | 2.4 |
|   | `moreLinks` | No good any more | 1.2 | 3.0 |
|   | `discountOffers` |  |  |  |
| `ChildAA` | | Please do not use this class any longer. There are better alternatives but I do not tell you which ones. May be `java.lang.Nothing` | 0.5 | 2.0 |
| `ChildBB` | |  |  |  |
|   | `deprecatedAttribute` | Please  keep `hands off`. |  |  |
|   | `deprecatedBs` |  |  |  |
|   | `deprecatedParent` |  |  |  |
|   | `deprecatedArray` |  |  |  |
| `DeprecatedContext` | |  |  | 2022-07-25 |
| `DeprecatedType` | |  |  |  |
| `DiscountOffer` | |  |  |  |
|   | `campaigns` |  |  |  |
| `POI` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `evenMoreLinks` |  |  |  |
| `ParentClass` | |  |  |  |
|   | `theBankAccount` |  |  |  |
|   | `legacyBankAccounts` |  |  |  |
| `SpecialContext` | |  |  |  |
|   | `deprecatedHeader` |  |  | 2024-12-24 |
| `TheReadOnlyServiceObject` | |  |  |  |
|   | `inventoryType` | Let's reproduce #65 | not too long | 99.9 |

<br>

### Enumerations with Deprecations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `ChannelType` | |  |  |  |
|   | `LEGACY_POS` | I'm `DEPRECATED`. |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.openapi.service1`

<br>

#### `ProductService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprecatedBody(String)` | |  |  |  |
|   | `String pBody` |  |  |  |
| `deprecatedComplexReturn()` | |  |  |  |
|   | `Product ` |  |  |  |
| `deprecatedOperation()` | | This request is no longer supported. | 1.1.1 | 2024-10-20 |
| `deprecatedParams(int)` | |  |  |  |
|   | `int pParam1` |  |  |  |
|   | `String ` |  |  |  |
| `deprectedComplexRequestBody(Product)` | |  |  |  |
|   | `Product pProduct` |  |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.pojo`

<br>

### Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `BChildPOJO` | |  |  |  |
| `ChildPOJO` | | We do not like this class any more. | Big bang | Last X-Mas |
| `ImmutableAssociationPOJO` | |  |  |  |
|   | `deprecatedRefs` |  |  |  |
| `ParentPOJO` | |  |  |  |
|   | `weirdAttribute` |  |  |  |

<br>

## Package `com.anaptecs.jeaf.junit.rest`

<br>

### Services with Deprecations 

<br>

| Service Name   | Description   | Deprecated since   | Planned to be removed   |
|----------------|---------------|:------------------:|:-----------------------:|
| `DeprecatedRESTService` |  |  |  |

<br>

#### `RESTTestService`

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

## Package `com.anaptecs.jeaf.junit.serviceproviders`

<br>

