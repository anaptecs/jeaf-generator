# Package `com.anaptecs.jeaf.accounting.impl.pojo`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## Account



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`iban`** : `int`   `[1..1]`<br> |  |  |
| **`currency`** : `java.util.Currency`   `[1..1]`<br> |  |  |

<br>

## Booking



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`sourceAccount`** : [`Account`](#account)   `[1..1]`<br> |  |  |
| **`targetAccount`** : [`Account`](#account)   `[1..1]`<br> |  |  |
| **`amount`** : `java.math.BigDecimal`   `[1..1]`<br> |  |  |
| **`currency`** : `java.util.Currency`   `[1..1]`<br> |  |  |
| **`executionTimestamp`** : `java.util.Calendar`   `[1..1]`<br> |  |  |

<br>

## Customer


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`Partner`](#partner) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`name`** : `java.lang.String`   `[1..1]`<br>        `@NotBlank` |  |  |
| **`firstName`** : `java.lang.String`   `[1..1]`<br>        `@NotBlank` |  |  |
| **`email`** : `java.lang.String`   `[1..1]`<br>        `@Email` |  |  |
| **`accounts`** : [`Account`](#account)   `[0..*]`<br> |  |  |

<br>

## Partner


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Abstract | `true` |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`tags`** : `String`   `[1..1]`<br> |  |  |

<br>




