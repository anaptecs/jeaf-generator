# Package `com.anaptecs.jeaf.junit.pojo`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## AbstractPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Abstract | `true` |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `abtractAttr` | `java.lang.String` | `1..1` |  |  |

<br>

## AdvancedPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `readonlyDefault` | `int` | `1..1` |  |  |
| `intWithDefault` | `java.lang.Integer` | `1..1` |  |  |

<br>

## BChildPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`BParentPOJO`](#bparentpojo) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `weirdAttribute` | `byte` | `1..1` |  |  |
| `childAttribute` | `java.lang.Integer` | `1..1` |  |  |

<br>

## BParentPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `parentAttribute` | `java.lang.String` | `1..1` |  |  |

<br>

## BidirectionalA



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `transientB` | [`BidirectionalB`](#bidirectionalb) | `0..1` | `transient`<br> |  |
| `transientParent` | [`BidirectionalA`](#bidirectionala) | `0..1` | `transient`<br> |  |
| `child` | [`BidirectionalA`](#bidirectionala) | `0..1` |  |  |
| `transientBs` | [`BidirectionalB`](#bidirectionalb) | `0..*` | `transient`<br> |  |

<br>

## BidirectionalB



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `as` | [`BidirectionalA`](#bidirectionala) | `0..*` |  |  |
| `theAs` | [`BidirectionalA`](#bidirectionala) | `0..*` |  |  |

<br>

## ChildPOJO
This is the first line of the first comment
2nd line

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ParentPOJO`](#parentpojo) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `childAttribute` | `java.lang.Integer` | `1..1` | `@NotNull`<br> |  |

<br>

## ComplextTypeArrayPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `plainPOJOs` | [`PlainPOJO`](#plainpojo) | `0..*` |  |  |

<br>

## CustomPrimitiveArraysObjectWithRestrictions



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `aBooleanArray` | `boolean` | `0..*` |  |  |
| `bBooleanArray` | `java.lang.Boolean` | `0..*` |  |  |
| `cBooleanArray` | `boolean` | `0..*` |  |  |
| `aByteArray` | `byte` | `0..*` | `@Size(min=0, max=32768)`<br> |  |
| `bByteArray` | `java.lang.Byte` | `0..*` |  |  |
| `aShortArray` | `short` | `0..*` |  |  |
| `bShortArray` | `java.lang.Short` | `0..*` |  |  |
| `aIntegerArray` | `int` | `0..*` |  |  |
| `bIntegerArray` | `java.lang.Integer` | `0..*` |  |  |
| `cIntegerArray` | `Integer` | `0..*` |  |  |
| `aLongArray` | `long` | `0..*` | `@NotEmpty`<br> |  |
| `bLongArray` | `java.lang.Long` | `0..*` |  |  |
| `aBigIntegerArray` | `java.math.BigInteger` | `0..*` |  |  |
| `aCharacterArray` | `char` | `0..*` |  |  |
| `bCharacterArray` | `java.lang.Character` | `0..*` |  |  |
| `aFloatArray` | `float` | `0..*` |  |  |
| `bFloatArray` | `java.lang.Float` | `0..*` |  |  |
| `aDoubleArray` | `double` | `0..*` | `@Size(min=4, max=12)`<br> |  |
| `bDoubleArray` | `java.lang.Double` | `0..*` |  |  |
| `aBigDecimalArray` | `java.math.BigDecimal` | `0..*` |  |  |
| `aStringArray` | `String` | `0..*` |  |  |
| `bStringArray` | `String` | `0..*` |  |  |

<br>

## ImmutableAssociationPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `yetAnotherAttribute` | `boolean` | `1..1` |  |  |
| `readonlyAssociation` | [`ImmutablePOJO`](#immutablepojo) | `0..*` |  |  |
| `immutableChildPOJO` | [`ImmutableChildPOJO`](#immutablechildpojo) | `0..1` |  |  |
| `deprecatedRefs` | [`ImmutableChildPOJO`](#immutablechildpojo) | `0..*` |  |  |
| `deprecatedRef` | [`ChildPOJO`](#childpojo) | `0..1` |  |  |

<br>

## ImmutableChildPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ImmutablePOJOParent`](#immutablepojoparent) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `childAttribute` | `java.lang.String` | `1..1` |  |  |
| `anotherChildAttribute` | `java.lang.Double` | `1..1` |  |  |

<br>

## ImmutablePOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `name` | `java.lang.String` | `1..1` |  |  |
| `something` | `java.lang.Integer` | `1..1` |  |  |

<br>

## ImmutablePOJOParent


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`AbstractPOJO`](#abstractpojo) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `parentAttribute` | `java.lang.String` | `1..1` |  |  |
| `anotherParentAttribute` | `java.lang.Integer` | `1..1` |  |  |

<br>

## MutableChildPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ImmutablePOJOParent`](#immutablepojoparent) |


<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `writeable` | `java.lang.Integer` | `1..1` |  |  |
| `booleanDefault` | `java.lang.Boolean` | `1..1` |  |  |

<br>

## POJOWithID



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `attr` | `java.lang.Double` | `1..1` |  |  |
| `name` | `java.lang.String` | `1..1` |  |  |
| `integerWithDefault` | `java.lang.Integer` | `1..1` |  |  |

<br>

## POJOWithIDnMethod



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `attr` | `java.lang.Double` | `1..1` |  |  |

<br>

## ParentPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `parentAttribute` | `java.lang.String` | `1..1` |  |  |
| `weirdAttribute` | `byte` | `1..1` |  |  |
| `hello` | `String` | `1..1` |  |  |

<br>

## PlainPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `hello` | `java.lang.String` | `1..1` |  |  |
| `world` | `java.lang.Integer` | `1..1` | `@PositiveOrZero`<br> |  |

<br>

## PrimitiveArraysObjectWithRestrictions



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `aBooleanArray` | `boolean` | `0..*` |  |  |
| `bBooleanArray` | `java.lang.Boolean` | `0..*` |  |  |
| `cBooleanArray` | `boolean` | `0..*` |  |  |
| `aByteArray` | `byte` | `0..*` | `@Size(min=0, max=32768)`<br> |  |
| `bByteArray` | `java.lang.Byte` | `0..*` |  |  |
| `aShortArray` | `short` | `0..*` |  |  |
| `bShortArray` | `java.lang.Short` | `0..*` |  |  |
| `aIntegerArray` | `int` | `0..*` |  |  |
| `bIntegerArray` | `java.lang.Integer` | `0..*` |  |  |
| `cIntegerArray` | `Integer` | `0..*` |  |  |
| `aLongArray` | `long` | `0..*` | `@NotEmpty`<br> |  |
| `bLongArray` | `java.lang.Long` | `0..*` |  |  |
| `aBigIntegerArray` | `java.math.BigInteger` | `0..*` |  |  |
| `aCharacterArray` | `char` | `0..*` |  |  |
| `bCharacterArray` | `java.lang.Character` | `0..*` |  |  |
| `aFloatArray` | `float` | `0..*` |  |  |
| `bFloatArray` | `java.lang.Float` | `0..*` |  |  |
| `aDoubleArray` | `double` | `0..*` | `@Size(min=4, max=12)`<br> |  |
| `bDoubleArray` | `java.lang.Double` | `0..*` |  |  |
| `aBigDecimalArray` | `java.math.BigDecimal` | `0..*` |  |  |
| `aStringArray` | `String` | `0..*` |  |  |
| `bStringArray` | `String` | `0..*` |  |  |

<br>

## PrimitiveObjectWithRestrictions



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `aBoolean` | `boolean` | `1..1` |  |  |
| `bBoolean` | `java.lang.Boolean` | `1..1` |  |  |
| `cBoolean` | `boolean` | `1..1` |  |  |
| `aByte` | `byte` | `1..1` | `@Negative`<br> |  |
| `bByte` | `java.lang.Byte` | `1..1` | `@NegativeOrZero`<br> |  |
| `aShort` | `short` | `1..1` | `@Min(minValue=-237)`<br> |  |
| `bShort` | `java.lang.Short` | `1..1` | `@Positive`<br> |  |
| `aInteger` | `int` | `1..1` | `@PositiveOrZero`<br> |  |
| `bInteger` | `java.lang.Integer` | `1..1` | `@Min(minValue=4711)`<br> |  |
| `cInteger` | `Integer` | `1..1` | `@Min(minValue=100)`<br>`@Max(maxValue=1000)`<br> |  |
| `aLong` | `long` | `1..1` |  |  |
| `bLong` | `java.lang.Long` | `1..1` | `@DecimalMax(maxValue=299792458, inclusive=false)`<br> |  |
| `aBigInteger` | `java.math.BigInteger` | `1..1` | `@DecimalMax(maxValue=3.14159265359, inclusive=true)`<br>`@DecimalMin(minValue=-3.14159265359, inclusive=true)`<br> |  |
| `aCharacter` | `char` | `1..1` |  |  |
| `bCharacter` | `java.lang.Character` | `1..1` |  |  |
| `aFloat` | `float` | `1..1` |  |  |
| `bFloat` | `java.lang.Float` | `1..1` |  |  |
| `aDouble` | `double` | `1..1` |  |  |
| `bDouble` | `java.lang.Double` | `1..1` |  |  |
| `aBigDecimal` | `java.math.BigDecimal` | `1..1` | `@DecimalMin(minValue=4711.0815, inclusive=true)`<br> |  |
| `aString` | `String` | `1..1` | `@Size(min=8, max=32)`<br> |  |
| `bString` | `String` | `1..1` | `@NotEmpty`<br>`@Size(min=0, max=128)`<br> |  |

<br>

## ReadonlyDefaultPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `readonlyDefault` | `int` | `1..1` |  |  |
| `booleanDefault` | `java.lang.Boolean` | `1..1` |  |  |

<br>




<br>

# Enumerations
## EnumWithProperties


### Literals

| Name | Description |
|------|-------------|
| `CAMPAIGN_DATA_UNIT` |  |
| `RELATION_KEY_DATA_UNIT` |  |
| `LITERAL_WITH_DEFAULTS` |  |

## ExtensibleEnumWithProperties


### Literals

| Name | Description |
|------|-------------|
| `CAMPAIGN_DATA_UNIT` |  |
| `RELATION_KEY_DATA_UNIT` |  |
| `UNKNOWN` | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## MyType


### Literals

| Name | Description |
|------|-------------|
| `ALPHA` |  |
| `BETA` |  |
| `GAMMA` |  |

