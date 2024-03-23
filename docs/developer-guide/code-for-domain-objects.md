---
title: "Developer Guide"
subtitle: "Generating Code for Domain Objects"
toc: false
menubar: developer_guide_menu
---

# Generating Code for Domain Objects

Domain objects (stereotype «DomainObject») are used to define the internal structure of a component. Domain objects are intended to be used to represent the domain model of a component.

![Code for Domain Objects](/images/code_for_domain_objects.png)
<br>

The diagram above shows the transformation of domain objects from the UML model (stereotype `«DomainObject»`) to the matching Java code. As you can see 2 files will be created:<br>

- **Domain Object Base Class** (`CustomerDOBase`)  
  This is the base class of the domain object. It contains all the attributes and associations according to the UML model. This also includes access methods for them. For operations defined on domain objects also an abstract method will be generated. The code must not be edited and thus will be written to `src-gen`.  

<br>

- **Domain Object Class** (`CustomerDO`)  
  This class is the actual domain object implementation. It does not have any attributes or associations as they are inherited from the domain object base class (`CustomerDOBase`). The generated code contains empty implementation for all modeled operations from the UML model. As those methods have to be implemented manually the class will be written to slot `src`.

<br>

For further information please refer to:

- [How to model Domain Objects](/uml-modeling-guide/how-tos/how-to-model-domain-objects)

<br>

**Source Code Examples**
<details>
  <summary><code>AccountDOBase.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-domain-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fdomainobjects%2FAccountDOBase.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountDO.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-domain-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fdomainobjects%2FAccountDO.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>