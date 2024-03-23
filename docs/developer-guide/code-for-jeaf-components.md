---
title: "Developer Guide"
subtitle: "Generating Code for JEAF Components"
toc: false
menubar: developer_guide_menu
---

# Generating Code for JEAF Components

Components are self-contained, reusable pieces of software. They provide their functionality as services. JEAF Generator is able to use information about components from a UML Model and generate code for JEAF as a target platform.

![Code for JEAF Components](/images/code_for_jeaf_components.png)

<br>

As you can see in the diagram above, for every component (stereotype ) JEAF Generator will create the following output:<br>

- **Service Implementation Class** (`AccountingServiceImpl`)  
  A service implementation class for every service that is implemented by the component . This class will be written to slot `src` as the operations need to be implemented manually as they contain the business logic of the service.  

<br>

- **Service Implementation Base Class** (`AccountingServiceImplBase`)  
  Every service implementation will inherit some functionality form a base class. That base class contains all the implementation that can be generated based on the information of the UML Model like dependencies on other services and access methods for configuration values of the component . As this class contains all the code that could be generated it will be written to `src-gen` and must not be edited manually.  

<br>

- **Component Configuration Class** (`AccountingComponentConfiguration`)  
  Class contains all the available configuration parameters of the component. This class is fully generated and so, it will be written to `src-gen`.  

<br>

- **Service Factory** (`AccountingServiceFactory`)  
  Factory class that is needed to create new instances of a service implementation. This class is fully generated and is only required at runtime, thus it is written to `src-gen`.  

<br>

- **Component Class** (`AccountingComponentFactory`)  
  The component class contains the implementation of all component specific things. It is also completed generated and only required at runtime. It will be written to `src-gen`.  

<br>

- **Component Factory Class** (`AccountingComponentFactory`)  
  Factory class is required to create new instances of the component. It is also completed generated and only required at runtime. It will be written to `src-gen`.  

<br>

For further information please also refer to:

- [How to model Components](/uml-modeling-guide/how-tos/how-to-model-jeaf-components)

<br>

**Source Code Examples**

<details>
  <summary><code>AccountingServiceImpl.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-impl%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2FAccountingServiceImpl.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingServiceImplBase.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-impl%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2FAccountingServiceImplBase.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingComponentConfiguration.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-impl%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2FAccountingComponentConfiguration.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingComponent.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-impl-runtime%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2FAccountingComponent.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingComponentFactory.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-impl-runtime%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2FAccountingComponentFactory.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
