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

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`abtractAttr`** : `java.lang.String`   `1..1`<br> |  |  |

<br>

## AdvancedPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`readonlyDefault`** : `int`   `1..1`<br> |  |  |
| **`intWithDefault`** : `java.lang.Integer`   `1..1`<br> |  |  |

<br>

## BChildPOJO
:exclamation:**Deprecation Notice (since: , removed with: ):**<br>

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`BParentPOJO`](#bparentpojo) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`weirdAttribute`** : `byte`   `1..1`<br> |  |  |
| **`childAttribute`** : `java.lang.Integer`   `1..1`<br> |  |  |

<br>

## BParentPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`parentAttribute`** : `java.lang.String`   `1..1`<br> |  |  |

<br>

## BidirectionalA



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`transientB`** : [`BidirectionalB`](#bidirectionalb)   `0..1`<br> |  |  |
| **`transientParent`** : [`BidirectionalA`](#bidirectionala)   `0..1`<br> |  |  |
| **`child`** : [`BidirectionalA`](#bidirectionala)   `0..1`<br> |  |  |
| **`transientBs`** : [`BidirectionalB`](#bidirectionalb)   `0..*`<br> |  |  |

<br>

## BidirectionalB



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`as`** : [`BidirectionalA`](#bidirectionala)   `0..*`<br> |  |  |
| **`theAs`** : [`BidirectionalA`](#bidirectionala)   `0..*`<br> |  |  |

<br>

## ChildPOJO
This is the first line of the first comment
2nd line

:exclamation:**Deprecation Notice (since: Big bang, removed with: Last X-Mas):**<br>We do not like this class any more.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ParentPOJO`](#parentpojo) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`childAttribute`** : `java.lang.Integer`   `1..1`<br>        `@NotNull` |  |  |

<br>

## ComplextTypeArrayPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`plainPOJOs`** : [`PlainPOJO`](#plainpojo)   `0..*`<br> |  |  |

<br>

## CustomPrimitiveArraysObjectWithRestrictions



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`aBooleanArray`** : `boolean`   `0..*`<br> |  |  |
| **`bBooleanArray`** : `java.lang.Boolean`   `0..*`<br> |  |  |
| **`cBooleanArray`** : `boolean`   `0..*`<br> |  |  |
| **`aByteArray`** : `byte`   `0..*`<br>        `@Size: min=0, max=32768` |  |  |
| **`bByteArray`** : `java.lang.Byte`   `0..*`<br> |  |  |
| **`aShortArray`** : `short`   `0..*`<br> |  |  |
| **`bShortArray`** : `java.lang.Short`   `0..*`<br> |  |  |
| **`aIntegerArray`** : `int`   `0..*`<br> |  |  |
| **`bIntegerArray`** : `java.lang.Integer`   `0..*`<br> |  |  |
| **`cIntegerArray`** : `Integer`   `0..*`<br> |  |  |
| **`aLongArray`** : `long`   `0..*`<br>        `@NotEmpty` |  |  |
| **`bLongArray`** : `java.lang.Long`   `0..*`<br> |  |  |
| **`aBigIntegerArray`** : `java.math.BigInteger`   `0..*`<br> |  |  |
| **`aCharacterArray`** : `char`   `0..*`<br> |  |  |
| **`bCharacterArray`** : `java.lang.Character`   `0..*`<br> |  |  |
| **`aFloatArray`** : `float`   `0..*`<br> |  |  |
| **`bFloatArray`** : `java.lang.Float`   `0..*`<br> |  |  |
| **`aDoubleArray`** : `double`   `0..*`<br>        `@Size: min=4, max=12` |  |  |
| **`bDoubleArray`** : `java.lang.Double`   `0..*`<br> |  |  |
| **`aBigDecimalArray`** : `java.math.BigDecimal`   `0..*`<br> |  |  |
| **`aStringArray`** : `String`   `0..*`<br> |  |  |
| **`bStringArray`** : `String`   `0..*`<br> |  |  |

<br>

## ImmutableAssociationPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`yetAnotherAttribute`** : `boolean`   `1..1`<br> |  |  |
| **`readonlyAssociation`** : [`ImmutablePOJO`](#immutablepojo)   `0..*`<br> |  |  |
| **`immutableChildPOJO`** : [`ImmutableChildPOJO`](#immutablechildpojo)   `0..1`<br> |  |  |
| *`deprecatedRefs`* : [`ImmutableChildPOJO`](#immutablechildpojo)   `0..*`<br> |  | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |
| **`deprecatedRef`** : [`ChildPOJO`](#childpojo)   `0..1`<br> |  |  |

<br>

## ImmutableChildPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ImmutablePOJOParent`](#immutablepojoparent) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`childAttribute`** : `java.lang.String`   `1..1`<br> |  |  |
| **`anotherChildAttribute`** : `java.lang.Double`   `1..1`<br> |  |  |

<br>

## ImmutablePOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`name`** : `java.lang.String`   `1..1`<br> |  |  |
| **`something`** : `java.lang.Integer`   `1..1`<br> |  |  |

<br>

## ImmutablePOJOParent


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`AbstractPOJO`](#abstractpojo) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`parentAttribute`** : `java.lang.String`   `1..1`<br> |  |  |
| **`anotherParentAttribute`** : `java.lang.Integer`   `1..1`<br> |  |  |

<br>

## MutableChildPOJO


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`ImmutablePOJOParent`](#immutablepojoparent) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`writeable`** : `java.lang.Integer`   `1..1`<br> |  |  |
| **`booleanDefault`** : `java.lang.Boolean`   `1..1`<br> |  |  |

<br>

## OptionalDataType



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`optionalCode`** : `String`   `0..1`<br> |  |  |

<br>

## POJOWithID



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`attr`** : `java.lang.Double`   `1..1`<br> |  |  |
| **`name`** : `java.lang.String`   `1..1`<br> |  |  |
| **`integerWithDefault`** : `java.lang.Integer`   `1..1`<br> |  |  |

<br>

## POJOWithIDnMethod



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`attr`** : `java.lang.Double`   `1..1`<br> |  |  |

<br>

## ParentPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`parentAttribute`** : `java.lang.String`   `1..1`<br> |  |  |
| *`weirdAttribute`* : `byte`   `1..1`<br> |  | :exclamation:**Deprecation Notice (since: , removed with: ):**<br> |
| **`hello`** : `String`   `1..1`<br> |  |  |

<br>

## PlainPOJO
:bomb: **Breaking Change Notice (since: , active with: 47.11):**<br>Announcement for the far away future


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`hello`** : `java.lang.String`   `1..1`<br> |  | <br><br>**Example(s):**<br>- `Hello`- `World!` |
| **`world`** : `java.lang.Integer`   `1..1`<br>        `@PositiveOrZero` |  |  |

<br>

## PrimitiveArraysObjectWithRestrictions



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`aBooleanArray`** : `boolean`   `0..*`<br> |  |  |
| **`bBooleanArray`** : `java.lang.Boolean`   `0..*`<br> |  |  |
| **`cBooleanArray`** : `boolean`   `0..*`<br> |  |  |
| **`aByteArray`** : `byte`   `0..*`<br>        `@Size: min=0, max=32768` |  |  |
| **`bByteArray`** : `java.lang.Byte`   `0..*`<br> |  |  |
| **`aShortArray`** : `short`   `0..*`<br> |  |  |
| **`bShortArray`** : `java.lang.Short`   `0..*`<br> |  |  |
| **`aIntegerArray`** : `int`   `0..*`<br> |  |  |
| **`bIntegerArray`** : `java.lang.Integer`   `0..*`<br> |  |  |
| **`cIntegerArray`** : `Integer`   `0..*`<br> |  |  |
| **`aLongArray`** : `long`   `0..*`<br>        `@NotEmpty` |  |  |
| **`bLongArray`** : `java.lang.Long`   `0..*`<br> |  |  |
| **`aBigIntegerArray`** : `java.math.BigInteger`   `0..*`<br> |  |  |
| **`aCharacterArray`** : `char`   `0..*`<br> |  |  |
| **`bCharacterArray`** : `java.lang.Character`   `0..*`<br> |  |  |
| **`aFloatArray`** : `float`   `0..*`<br> |  |  |
| **`bFloatArray`** : `java.lang.Float`   `0..*`<br> |  |  |
| **`aDoubleArray`** : `double`   `0..*`<br>        `@Size: min=4, max=12` |  |  |
| **`bDoubleArray`** : `java.lang.Double`   `0..*`<br> |  |  |
| **`aBigDecimalArray`** : `java.math.BigDecimal`   `0..*`<br> |  |  |
| **`aStringArray`** : `String`   `0..*`<br> |  |  |
| **`bStringArray`** : `String`   `0..*`<br> |  |  |

<br>

## PrimitiveObjectWithRestrictions



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`aBoolean`** : `boolean`   `1..1`<br> |  |  |
| **`bBoolean`** : `java.lang.Boolean`   `1..1`<br> |  |  |
| **`cBoolean`** : `boolean`   `1..1`<br> |  |  |
| **`aByte`** : `byte`   `1..1`<br>        `@Negative` |  |  |
| **`bByte`** : `java.lang.Byte`   `1..1`<br>        `@NegativeOrZero` |  |  |
| **`aShort`** : `short`   `1..1`<br>        `@Min: minValue=-237` |  |  |
| **`bShort`** : `java.lang.Short`   `1..1`<br>        `@Positive` |  |  |
| **`aInteger`** : `int`   `1..1`<br>        `@PositiveOrZero` |  |  |
| **`bInteger`** : `java.lang.Integer`   `1..1`<br>        `@Min: minValue=4711` |  |  |
| **`cInteger`** : `Integer`   `1..1`<br>        `@Min: minValue=100`<br>        `@Max: maxValue=1000` |  |  |
| **`aLong`** : `long`   `1..1`<br> |  |  |
| **`bLong`** : `java.lang.Long`   `1..1`<br>        `@DecimalMax: maxValue=299792458, inclusive=false` |  |  |
| **`aBigInteger`** : `java.math.BigInteger`   `1..1`<br>        `@DecimalMax: maxValue=3.14159265359, inclusive=true`<br>        `@DecimalMin: minValue=-3.14159265359, inclusive=true` |  |  |
| **`aCharacter`** : `char`   `1..1`<br> |  |  |
| **`bCharacter`** : `java.lang.Character`   `1..1`<br> |  |  |
| **`aFloat`** : `float`   `1..1`<br> |  |  |
| **`bFloat`** : `java.lang.Float`   `1..1`<br> |  |  |
| **`aDouble`** : `double`   `1..1`<br> |  |  |
| **`bDouble`** : `java.lang.Double`   `1..1`<br> |  |  |
| **`aBigDecimal`** : `java.math.BigDecimal`   `1..1`<br>        `@DecimalMin: minValue=4711.0815, inclusive=true` |  |  |
| **`aString`** : `String`   `1..1`<br>        `@Size: min=8, max=32` |  |  |
| **`bString`** : `String`   `1..1`<br>        `@NotEmpty`<br>        `@Size: min=0, max=128` |  |  |

<br>

## ReadonlyDefaultPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`readonlyDefault`** : `int`   `1..1`<br> |  |  |
| **`booleanDefault`** : `java.lang.Boolean`   `1..1`<br> |  |  |

<br>




<br>

# Enumerations
## EmptyEnum


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|

## EmptyExentibleEnum


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## EnumWithProperties


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `CAMPAIGN_DATA_UNIT` |   |  |
| `RELATION_KEY_DATA_UNIT` |   |  |
| `LITERAL_WITH_DEFAULTS` |   |  |

## ExtensibleEnumWithProperties


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `CAMPAIGN_DATA_UNIT` |   |  |
| `RELATION_KEY_DATA_UNIT` |   |  |
| `UNKNOWN` |  | Please be aware that this enum is an extensible enum. This means that new literals can be introduced without prior notice. |

## MyType (aka "MyFormerName")


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `ALPHA` |   |  |
| `BETA` |   |  |
| `GAMMA` |   | :bomb: **Breaking Change Notice (since: , active with: 47.11):**<br>X-mas present |

