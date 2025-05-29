# Package `com.anaptecs.jeaf.accounting.impl.pojo`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## Account



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `iban` | `int` | `1..1` |  |  |
| `currency` | `java.util.Currency` | `1..1` |  |  |

<br>

## Booking



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `sourceAccount` | [`Account`](#account) | `1..1` |  |  |
| `targetAccount` | [`Account`](#account) | `1..1` |  |  |
| `amount` | `java.math.BigDecimal` | `1..1` |  |  |
| `currency` | `java.util.Currency` | `1..1` |  |  |
| `executionTimestamp` | `java.util.Calendar` | `1..1` |  |  |

<br>

## Customer


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`Partner`](#partner) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `name` | `java.lang.String` | `1..1` | `@NotBlank`<br> |  |
| `firstName` | `java.lang.String` | `1..1` | `@NotBlank`<br> |  |
| `email` | `java.lang.String` | `1..1` | `@Email`<br> |  |
| `accounts` | [`Account`](#account) | `0..*` |  |  |

<br>

## Partner


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Abstract | `true` |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|

<br>




