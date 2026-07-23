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
| `firstProperty` | `String` | `1..1` |  | V4, V5, V6: `@Optional`<br> |  |
| `clientTypes` | [`ClientType`](#clienttype) | `1..*` |  | V4, V5, V6: `@Optional`<br> |  |

<br>

## MyPOJOResponse



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| `untouchedProperty` | `String` | `1..1` |  |  |  |
| :bomb: `formerMandatoryProperty` | `String` | `0..1` |  | V4, V5, V6: `@NotNull`<br> | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :exclamation:`deprecatedProperty` | `String` | `0..1` |  |  | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |
| `derivedProperty` | `String` | `1..1` |  | V4, V5, V6: `@Optional`<br>`derived` |  |

<br>

## MyPojoRequest



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| :bomb: `upcomingMandatoryProperty` | `String` | `1..1` |  | V4, V5, V6: `@Optional`<br> | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :bomb: `propertyWithNewConstraints` | `String` | `1..1` |  |  | :bomb: **Breaking Change Notice (since: , active with: ):**<br> |
| :exclamation:`formerMandatoryRequestProperty` | `String` | `0..1` |  | V4, V5, V6: `@NotNull`<br> | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |
| `untouchedProperty` | `String` | `1..1` |  |  |  |
| `constraintChangingProperty` | `String` | `1..1` |  | V4, V5, V6: `@Size(min=10, max=20)`<br>V7: @Size(min=10, max=20)<br>V4, V5, V6: `@Optional`<br> |  |
| `otherPojos` | [`OtherPojo`](#otherpojo) | `1..*` |  | V4, V5, V6: `@Optional`<br> |  |
| `thePojo` | [`OtherPojo`](#otherpojo) | `1..1` |  | V4, V5, V6: `@Optional`<br> |  |

<br>

## OtherPojo



<br>

**Properties / Associations**

| Name | Type | Multiplicity |  Legacy Name | Constraints | Description |
|------|------|:------------:|----------------------|-------------|-------------|
| `multiValuedProperty` | `String` | `1..*` |  | V4, V5, V6: `@Optional`<br> |  |
| `decimalProperty` | `java.math.BigDecimal` | `1..1` |  | V4, V5, V6: `@DecimalMax(maxValue=48, inclusive=false)`<br>V7: @DecimalMax(maxValue=48, inclusive=false)<br>V4, V5, V6: `@DecimalMin(minValue=42, inclusive=false)`<br>V7: @DecimalMin(minValue=42, inclusive=false)<br>V4, V5, V6: `@Digits(integer=5, fraction=2)`<br>V7: @Digits(integer=5, fraction=2)<br>V4, V5, V6: `@Optional`<br> |  |
| `integerProperty` | `java.lang.Integer` | `1..1` |  | V4, V5, V6: `@Min(minValue=333)`<br>V7: @Min(minValue=333)<br>V4, V5, V6: `@Max(maxValue=666)`<br>V7: @Max(maxValue=666)<br><br>V7: @Negative<br><br>V7: @PositiveOrZero<br>V4, V5, V6: `@NegativeOrZero`<br><br>V4, V5, V6: `@Positive`<br> |  |
| `stringProperty` | `String` | `1..1` |  | V4, V5, V6: `@Pattern(regexp=[A-Z]+)`<br>V7: @Pattern(regexp=[A-Z]+)<br>V4, V5, V6: `@NotBlank`<br> |  |
| `emailProperty` | `String` | `1..1` |  | <br>V7: @Email<br><br>V7: @NotEmpty |  |
| `booleanProperty` | `java.lang.Boolean` | `1..1` |  | <br>V7: @AssertTrue<br>V4, V5, V6: `@AssertFalse`<br> |  |
| `dateTimeProperty` | `java.time.OffsetDateTime` | `1..1` |  | <br>V7: @FutureOrPresent<br><br>V7: @Past<br>V4, V5, V6: `@Future`<br><br>V4, V5, V6: `@PastOrPresent`<br> |  |

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

