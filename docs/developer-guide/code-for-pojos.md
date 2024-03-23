---
title: "Developer Guide"
subtitle: "Generating Code for POJOs"
toc: false
menubar: developer_guide_menu
---

# Generating Code for POJOs

Stereotype `«POJO»` can be used to model a POJO (Plain old Java object). It depends on your individual programming model what POJOs will be used for.

![Code for POJOs](/images/code_for_pojos.png)

<br>

The diagram above shows the transformation of POJOs from the UML model (stereotype `«POJO»`) to the matching Java code. As you can see 2 files will be created:<br>

- **POJO Base Class** (`AccountBase`)  
  This is the base class of the POJO. It contains all the attributes and associations according to the UML model. This also includes access methods for them. For operations defined on POJO also an abstract method will be generated. The code must not be edited and thus will be written to `src-gen`.  
  
  <br>

- **POJO Class** (`Account`)  
  This class is the actual POJO implementation. It does not have any attributes or associations as they are inherited from the POJO base class (`AccountBase`). The generated code contains empty implementation for all modeled operations from the UML model. As those methods have to be implemented manually the class will be written to slot `src`.

<br>

**Remark:**

- In case that the POJO in the UML model does not define any operations then only 1 class will be generated to slot `src-gen`.

<br>

For further information please also refer to:

- [How to model POJOs](/uml-modeling-guide/how-tos/how-to-model-pojos)

<br>

**Configuration Parameter**

- `generatePOJOs`

For further details about configuration parameters for JEAF Generator please refer to: [Maven Plugin Configuration](../maven-plugin-configuration)

<br>

**Source Code Examples**

<details>
  <summary><code>AccountBase.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-pojos%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fpojo%2FAccountBase.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>Account.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-pojos%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fpojo%2FAccount.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
