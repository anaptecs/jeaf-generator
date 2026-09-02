# Package `com.anaptecs.jeaf.junit.pojo.softlink`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## SoftLinkChildA


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`SoftLinkParent`](#softlinkparent) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|

<br>

## SoftLinkChildB


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`SoftLinkParent`](#softlinkparent) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`heyBrother`** : [`SoftLinkChildA`](#softlinkchilda)   `[0..1]`<br> |  |  |
| **`softLinkPartners`** : [`SoftLinkPartner`](#softlinkpartner)   `[0..*]`<br> |  |  |
| **`oneLink`** : [`SoftLinkPartner`](#softlinkpartner)   `[1..1]`<br> |  |  |

<br>

## SoftLinkParent



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`partners`** : [`SoftLinkPartner`](#softlinkpartner)   `[1..*]`<br> |  |  |
| **`thePartner`** : [`SoftLinkPartner`](#softlinkpartner)   `[1..1]`<br> |  |  |
| **`readonlyPartner`** : [`SoftLinkPartner`](#softlinkpartner)   `[0..1]`<br> |  |  |

<br>

## SoftLinkPartner



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`theBackLink`** : [`SoftLinkParent`](#softlinkparent)   `[0..1]`<br> |  |  |
| **`childLinks`** : [`SoftLinkChildA`](#softlinkchilda)   `[0..*]`<br> |  |  |
| **`longLinks`** : [`SoftLinkChildA`](#softlinkchilda)   `[1..*]`<br> |  |  |
| **`derivedSoftLink`** : [`SoftLinkParent`](#softlinkparent)   `[1..1]`<br> |  |  |
| **`theDerivedSoftLinks`** : [`SoftLinkParent`](#softlinkparent)   `[0..*]`<br> |  |  |
| **`javaOnlyDerivedSoftLink`** : [`SoftLinkChildA`](#softlinkchilda)   `[0..1]`<br> |  |  |
| **`dynamicSoftLink`** : [`SoftLinkChildB`](#softlinkchildb)   `[0..1]`<br> |  |  |
| **`multiValuedDynamicSoftLink`** : [`SoftLinkChildA`](#softlinkchilda)   `[0..*]`<br> |  |  |

<br>




