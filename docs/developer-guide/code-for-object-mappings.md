---
title: "Developer Guide"
subtitle: "Generating Code for Object Mappings"
toc: false
menubar: developer_guide_menu
---

## Generating Code for Object Mappings

JEAF Generator offers the possibility to free developers from error-prawn and boring job of mapping objects from one into another. To do so, a so called object mapping can be defined in the UML model by defining dependencies between attributes using stereotype `«ObjectMapping»`. Object mappings distinguish between creating, updating and reading of objects.<br>

When it comes to code generation JEAF Generator will generate a converter class for every combination of two classes that have an object mapping. The generated code will be written to slot `src-gen` and is not intended for manual editing.

<br>

The generated converter class let’s you:

- create a new target object from an existing source object

- create a new source object an existing target object

- update an existing target object from an existing source object

<br>

For further information please also refer to:

- [How to model Object Mappings](/uml-modeling-guide/how-tos/how-to-model-object-mappings)

<br>

**Source Code Examples**

<details>
  <summary><code>AccountInfoToAccountDOConverter.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-object-mappers%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fdomainobjects%2Fmapper%2FAccountInfoToAccountDOConverter.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>CompanyToCompanyBOConverter.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-object-mappers%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fdomain%2Fmapper%2FCompanyToCompanyBOConverter.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
