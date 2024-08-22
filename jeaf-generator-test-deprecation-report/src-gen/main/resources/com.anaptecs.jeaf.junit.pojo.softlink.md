**Types / Enumerations:**
[TOC levels=2]

<br>

# Package `com.anaptecs.jeaf.junit.pojo.softlink`


<br>

# Types
## SoftLinkChildA


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent` |


<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|

<br>

## SoftLinkChildB


<br>

| Type Details | Details         | 
|--------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent` |


<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `heyBrother` | [`SoftLinkChildA`](#softlinkchilda) | `0..1` |  |  |
| `softLinkPartners` | [`SoftLinkPartner`](#softlinkpartner) | `0..*` |  |  |
| `oneLink` | [`SoftLinkPartner`](#softlinkpartner) | `1..1` |  |  |

<br>

## SoftLinkParent



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `partners` | [`SoftLinkPartner`](#softlinkpartner) | `1..*` |  |  |
| `thePartner` | [`SoftLinkPartner`](#softlinkpartner) | `1..1` |  |  |
| `readonlyPartner` | [`SoftLinkPartner`](#softlinkpartner) | `0..1` |  |  |

<br>

## SoftLinkPartner



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `theBackLink` | [`SoftLinkParent`](#softlinkparent) | `0..1` |  |  |
| `childLinks` | [`SoftLinkChildA`](#softlinkchilda) | `0..*` |  |  |
| `longLinks` | [`SoftLinkChildA`](#softlinkchilda) | `1..*` |  |  |

<br>



