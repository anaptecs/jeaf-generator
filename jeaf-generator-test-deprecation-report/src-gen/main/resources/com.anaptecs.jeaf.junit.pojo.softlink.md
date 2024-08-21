# Package `com.anaptecs.jeaf.junit.pojo.softlink`


<br>

# Types
## `SoftLinkChildA`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|

<br>

## `SoftLinkChildB`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `heyBrother` | `0..1` |  |
| `softLinkPartners` | `0..*` |  |
| `oneLink` | `1..1` |  |

<br>

## `SoftLinkParent`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `partners` | `1..*` |  |
| `thePartner` | `1..1` |  |
| `readonlyPartner` | `0..1` |  |

<br>

## `SoftLinkPartner`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `theBackLink` | `0..1` |  |
| `childLinks` | `0..*` |  |
| `longLinks` | `1..*` |  |

<br>



