# Package `com.anaptecs.jeaf.junit.validationgroups`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## MyContext



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`firstProperty`** : `String`   `1..1`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| **`clientTypes`** : [`ClientType`](#clienttype)   `1..*`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| *`deprecatedHeader`* : `java.lang.String`   `0..1`<br>        `@NotNull: versions=V4, V5, V6` |  | :exclamation:**Deprecation Notice (since: , removed with: 7.0, removal date: 2026-09-13):**<br> |

<br>

## MyPOJOResponse



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`untouchedProperty`** : `String`   `1..1`<br> |  |  |
| <font color="red">**`formerMandatoryProperty`**</font> : `String`   `0..1`<br>        `@NotNull: versions=V4, V5, V6` |  | :bomb: **Breaking Change Notice (since: , active with: 7.0, activation date: 2026-09-13):**<br> |
| *`deprecatedProperty`* : `String`   `0..1`<br> |  | :exclamation:**Deprecation Notice (since: , removed with: 7.0, removal date: 2026-09-13):**<br> |
| **`derivedProperty`** : `String`   `1..1`<br>        `@Optional: versions=V4, V5, V6` |  |  |

<br>

## MyPojoRequest



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| <font color="red">**`upcomingMandatoryProperty`**</font> : `String`   `1..1`<br>        `@Optional: versions=V4, V5, V6` |  | :bomb: **Breaking Change Notice (since: , active with: 7.0, activation date: 2026-09-13):**<br>Property will become mandatory in the future |
| <font color="red">**`propertyWithNewConstraints`**</font> : `String`   `1..1`<br> |  | :bomb: **Breaking Change Notice (since: , active with: , activation date: ):**<br> |
| *`formerMandatoryRequestProperty`* : `String`   `0..1`<br>        `@NotNull: versions=V4, V5, V6` |  | :exclamation:**Deprecation Notice (since: , removed with: 7.0, removal date: 2026-09-13):**<br> |
| **`untouchedProperty`** : `String`   `1..1`<br> |  |  |
| **`constraintChangingProperty`** : `String`   `1..1`<br>        `@Size: min=5, max=500, versions=V4, V5, V6`<br>        `@Size: min=10, max=20, versions=V7`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| **`otherPojos`** : [`OtherPojo`](#otherpojo)   `1..*`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| **`thePojo`** : [`OtherPojo`](#otherpojo)   `1..1`<br>        `@Optional: versions=V4, V5, V6` |  |  |

<br>

## OtherPojo



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`multiValuedProperty`** : `String`   `1..*`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| **`decimalProperty`** : `java.math.BigDecimal`   `1..1`<br>        `@DecimalMax: maxValue=49, inclusive=true, versions=V4, V5, V6`<br>        `@DecimalMax: maxValue=48, inclusive=false, versions=V7`<br>        `@DecimalMin: minValue=42, inclusive=true, versions=V4, V5, V6`<br>        `@DecimalMin: minValue=42, inclusive=false, versions=V7`<br>        `@Digits: integer=5, fraction=3, versions=V4, V5, V6`<br>        `@Digits: integer=5, fraction=2, versions=V7`<br>        `@Optional: versions=V4, V5, V6` |  |  |
| **`integerProperty`** : `java.lang.Integer`   `1..1`<br>        `@Min: minValue=300, versions=V4, V5, V6`<br>        `@Min: minValue=333, versions=V7`<br>        `@Max: maxValue=667, versions=V4, V5, V6`<br>        `@Max: maxValue=666, versions=V7` |  |  |
| **`stringProperty`** : `String`   `1..1`<br>        `@Pattern: regexp=[B-Z]+, versions=V4, V5, V6`<br>        `@Pattern: regexp=[A-Z]+, versions=V7`<br>        `@NotBlank: versions=V4, V5, V6` |  |  |
| **`emailProperty`** : `String`   `1..1`<br>        `@Email, versions=V7`<br>        `@NotEmpty: versions=V7` |  |  |
| **`booleanProperty`** : `java.lang.Boolean`   `1..1`<br>        `@AssertTrue: versions=V7`<br>        `@AssertFalse: versions=V4, V5, V6` |  |  |
| **`dateTimeProperty`** : `java.time.OffsetDateTime`   `1..1`<br>        `@FutureOrPresent: versions=V7`<br>        `@Past: versions=V7`<br>        `@Future: versions=V4, V5, V6`<br>        `@PastOrPresent: versions=V4, V5, V6` |  |  |
| **`positiveValueProperty`** : `int`   `1..1`<br>        `@PositiveOrZero: versions=V7`<br>        `@Positive: versions=V4, V5, V6` |  |  |
| **`negativeProperty`** : `int`   `1..1`<br>        `@Negative: versions=V7`<br>        `@NegativeOrZero: versions=V4, V5, V6` |  |  |
| <font color="red">**`v6Property`**</font> : `String`   `1..1`<br>        `@Size: min=0, max=32, versions=V6`<br>        `@Size: min=10, max=32, versions=V7`<br>        `@Optional: versions=V6` |  | :bomb: **Breaking Change Notice (since: , active with: 8.0, activation date: 2026-10-20):**<br>Property will become mandatory. |

<br>




<br>

# Enumerations
## ClientType


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `CLIENT_1` |   |  |
| `CLIENT_2` |   |  |
| `CLIENT_3` |   |  |

