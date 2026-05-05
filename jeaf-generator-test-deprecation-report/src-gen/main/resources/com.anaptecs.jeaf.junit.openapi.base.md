# Package `com.anaptecs.jeaf.junit.openapi.base`

**Types / Enumerations:**
[TOC levels=2]



<br>

# Enumerations
## BooleanLiteralsEnum


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `YES` |   |  |
| `ON` |   |  |
| `off` |   |  |
| `y` |   |  |
| `n` |   |  |
| `YEAH` |   |  |
| `NO` |   |  |
| `True` |   |  |
| `FaLsE` |   |  |

## ChannelType (aka "Kanal")
Enumeration defines the different types of channels that are supported.

### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `COUNTER` |  `BEDIENT` | counter |
| `CALL_CENTER` |   |  |
| `MOBILE` |   |  |
| `TVM` |   |  |
| `WEB` |   | :bomb: **Breaking Change Notice (since: , active with: 1.47.11):**<br>Added new literal |
| :exclamation:`LEGACY_POS` |   | :exclamation:**Deprecation Notice (since: , removed with: ):**<br>I'm `DEPRECATED`. |

## ComplexBookingType
:bomb: **Breaking Change Notice (since: , active with: PI 17):**<br>Class was changed to an extensible enum. New literals will not be introduced before PI 17.

### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `COMPLEX` |   |  |
| `VERY_COMPLEX` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## DataUnit


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `COUPON` |   |  |
| `UNKNOWN` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## DynamicEnum
Test for enums with dynamic literals.

### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `STATIC_LITERAL` |   |  |

## DynamicExtensibleEnum


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `STATIC_LITERAL` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## Entity


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `DISCOUNT_CAMPAIGN` |   |  |
| `DISCOUNT_OFFER` |   |  |
| `UNKNOWN` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## ExtensibleEnum


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `RED` |   |  |
| `GREEN` |   |  |
| `BLUE` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## InlineSortimentType


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `B2C_SORTIMENT` |   |  |
| `EMPLOYEE_SORTIMENT` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## InlineStopType


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `REAL_STOP` |   |  |
| `VIRTUAL_STOP` |   |  |

## InventoryType


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `SBB` |   |  |
| `SNCF` |   |  |
| `DB` |   | :bomb: **Breaking Change Notice (since: , active with: 3.x):**<br>New literal will occur |

## TimeUnit (aka "Zeiteinheit")
Enumeration represents time units.
     
NOVA 14 Mapping
* nova-base.xsd.ZeitEinheit

### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `MINUTE` |   | Literal represents time unit "minutes". |
| `HOUR` |   |  |
| `DAY` |   |  |
| `WEEK` |   | Literal represents time unit "weeks".<br>This is the comments second line ;-) |
| `MONTH` |   |  |
| `YEAR` |   |  |

