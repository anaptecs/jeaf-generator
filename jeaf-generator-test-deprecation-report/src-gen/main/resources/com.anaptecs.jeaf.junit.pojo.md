# Package `com.anaptecs.jeaf.junit.pojo`


<br>

# Types
## `AbstractPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `abtractAttr` | `1..1` |  |

<br>

## `AdvancedPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `readonlyDefault` | `1..1` |  |
| `intWithDefault` | `1..1` |  |

<br>

## `BChildPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.BParentPOJO` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `weirdAttribute` | `1..1` |  |
| `childAttribute` | `1..1` |  |

<br>

## `BParentPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `parentAttribute` | `1..1` |  |

<br>

## `BidirectionalA`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `transientB` | `0..1` |  |
| `transientParent` | `0..1` |  |
| `child` | `0..1` |  |
| `transientBs` | `0..*` |  |

<br>

## `BidirectionalB`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `as` | `0..*` |  |
| `theAs` | `0..*` |  |

<br>

## `ChildPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.ParentPOJO` |
| Description | This is the first line of the first comment<br>2nd line |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `childAttribute` | `1..1` |  |

<br>

## `ComplextTypeArrayPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `plainPOJOs` | `0..*` |  |

<br>

## `CustomPrimitiveArraysObjectWithRestrictions`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `aBooleanArray` | `0..*` |  |
| `bBooleanArray` | `0..*` |  |
| `cBooleanArray` | `0..*` |  |
| `aByteArray` | `0..*` |  |
| `bByteArray` | `0..*` |  |
| `aShortArray` | `0..*` |  |
| `bShortArray` | `0..*` |  |
| `aIntegerArray` | `0..*` |  |
| `bIntegerArray` | `0..*` |  |
| `cIntegerArray` | `0..*` |  |
| `aLongArray` | `0..*` |  |
| `bLongArray` | `0..*` |  |
| `aBigIntegerArray` | `0..*` |  |
| `aCharacterArray` | `0..*` |  |
| `bCharacterArray` | `0..*` |  |
| `aFloatArray` | `0..*` |  |
| `bFloatArray` | `0..*` |  |
| `aDoubleArray` | `0..*` |  |
| `bDoubleArray` | `0..*` |  |
| `aBigDecimalArray` | `0..*` |  |
| `aStringArray` | `0..*` |  |
| `bStringArray` | `0..*` |  |

<br>

## `ImmutableAssociationPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `yetAnotherAttribute` | `1..1` |  |
| `readonlyAssociation` | `0..*` |  |
| `immutableChildPOJO` | `0..1` |  |
| `deprecatedRefs` | `0..*` |  |
| `deprecatedRef` | `0..1` |  |

<br>

## `ImmutableChildPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.ImmutablePOJOParent` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `childAttribute` | `1..1` |  |
| `anotherChildAttribute` | `1..1` |  |

<br>

## `ImmutablePOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `name` | `1..1` |  |
| `something` | `1..1` |  |

<br>

## `ImmutablePOJOParent`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.AbstractPOJO` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `parentAttribute` | `1..1` |  |
| `anotherParentAttribute` | `1..1` |  |

<br>

## `MutableChildPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.ImmutablePOJOParent` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `writeable` | `1..1` |  |
| `booleanDefault` | `1..1` |  |

<br>

## `POJOWithID`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `attr` | `1..1` |  |
| `name` | `1..1` |  |
| `integerWithDefault` | `1..1` |  |

<br>

## `POJOWithIDnMethod`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `attr` | `1..1` |  |

<br>

## `ParentPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `parentAttribute` | `1..1` |  |
| `weirdAttribute` | `1..1` |  |
| `hello` | `1..1` |  |

<br>

## `PlainPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `hello` | `1..1` |  |
| `world` | `1..1` |  |

<br>

## `PrimitiveArraysObjectWithRestrictions`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `aBooleanArray` | `0..*` |  |
| `bBooleanArray` | `0..*` |  |
| `cBooleanArray` | `0..*` |  |
| `aByteArray` | `0..*` |  |
| `bByteArray` | `0..*` |  |
| `aShortArray` | `0..*` |  |
| `bShortArray` | `0..*` |  |
| `aIntegerArray` | `0..*` |  |
| `bIntegerArray` | `0..*` |  |
| `cIntegerArray` | `0..*` |  |
| `aLongArray` | `0..*` |  |
| `bLongArray` | `0..*` |  |
| `aBigIntegerArray` | `0..*` |  |
| `aCharacterArray` | `0..*` |  |
| `bCharacterArray` | `0..*` |  |
| `aFloatArray` | `0..*` |  |
| `bFloatArray` | `0..*` |  |
| `aDoubleArray` | `0..*` |  |
| `bDoubleArray` | `0..*` |  |
| `aBigDecimalArray` | `0..*` |  |
| `aStringArray` | `0..*` |  |
| `bStringArray` | `0..*` |  |

<br>

## `PrimitiveObjectWithRestrictions`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `aBoolean` | `1..1` |  |
| `bBoolean` | `1..1` |  |
| `cBoolean` | `1..1` |  |
| `aByte` | `1..1` |  |
| `bByte` | `1..1` |  |
| `aShort` | `1..1` |  |
| `bShort` | `1..1` |  |
| `aInteger` | `1..1` |  |
| `bInteger` | `1..1` |  |
| `cInteger` | `1..1` |  |
| `aLong` | `1..1` |  |
| `bLong` | `1..1` |  |
| `aBigInteger` | `1..1` |  |
| `aCharacter` | `1..1` |  |
| `bCharacter` | `1..1` |  |
| `aFloat` | `1..1` |  |
| `bFloat` | `1..1` |  |
| `aDouble` | `1..1` |  |
| `bDouble` | `1..1` |  |
| `aBigDecimal` | `1..1` |  |
| `aString` | `1..1` |  |
| `bString` | `1..1` |  |

<br>

## `ReadonlyDefaultPOJO`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `readonlyDefault` | `1..1` |  |
| `booleanDefault` | `1..1` |  |

<br>



