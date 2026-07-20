# Package `com.anaptecs.jeaf.junit.validationgroups`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## MyContext



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| `firstProperty` | `String` | `1..1` |  |  |  |
| `clientTypes` | [`ClientType`](#clienttype) | `1..*` |  |  |  |

<br>

## MyPOJOResponse



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| `untouchedProperty` | `String` | `1..1` |  |  |  |
| :bomb: `formerMandatoryProperty` | `String` | `0..1` |  |  | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :exclamation:`deprecatedProperty` | `String` | `0..1` |  |  | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |

<br>

## MyPojoRequest



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| :bomb: `upcomingMandatoryProperty` | `String` | `1..1` |  |  | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :bomb: `propertyWithNewConstraints` | `String` | `1..1` |  |  | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :exclamation:`formerMandatoryRequestProperty` | `String` | `0..1` |  |  | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |
| `untouchedProperty` | `String` | `1..1` |  |  |  |
| `constraintChangingProperty` | `String` | `1..1` |  | `@Size(min=10, max=20)`<br> |  |
| `otherPojos` | [`OtherPojo`](#otherpojo) | `1..*` |  |  |  |
| `thePojo` | [`OtherPojo`](#otherpojo) | `1..1` |  | `@Valid`<br> |  |

<br>

## OtherPojo



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| `multiValuedProperty` | `String` | `1..*` |  |  |  |
| `decimalProperty` | `java.math.BigDecimal` | `1..1` |  | `@DecimalMax(maxValue=48, inclusive=false)`<br>`@DecimalMin(minValue=42, inclusive=false)`<br>`@Digits(integer=5, fraction=2)`<br> |  |
| `integerProperty` | `java.lang.Integer` | `1..1` |  | `@Min(minValue=333)`<br>`@Max(maxValue=666)`<br>`@Negative`<br>`@PositiveOrZero`<br> |  |
| `stringProperty` | `String` | `1..1` |  | `@Pattern(regexp=[A-Z]+)`<br> |  |
| `emailProperty` | `String` | `1..1` |  | `@Email`<br>`@NotEmpty`<br> |  |
| `booleanProperty` | `java.lang.Boolean` | `1..1` |  | `@AssertTrue`<br> |  |
| `dateTimeProperty` | `java.time.OffsetDateTime` | `1..1` |  | `@FutureOrPresent`<br>`@Past`<br> |  |

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

