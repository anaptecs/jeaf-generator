---
title: "Developer Guide"
subtitle: "Generating Code for JEAF Services"
toc: true
menubar: developer_guide_menu
---

# Generating Code for JEAF Services

The diagram below shows the transformation of services, service objects, query objects and load strategy objects from the UML model into Java code.

![Code for Services](/images/code_for_jeaf_services.png)

<br>

## Code for Service Interfaces

As you can see in the diagram for every service (stereotype `«JEAF Service»`) in the UML model a matching Java interface will be generated. This interface will define exactly the same operations as they are defined in the UML model. Also all comments from the model will be present in the generated code.

In addition to the Java interface also also a so called `Service Proxy` will be generated for every service interface (class `AccountingServiceProxy` in example above). The service proxy is required for JEAF Core’s communication mechanism. The service proxy will be completely generated and is only required at runtime. Thus we propose to have separate Maven modules for services / service objects on the one hand and service runtime classes on the other one. If service runtime classes should be generated or not can be configured through the JEAF Generator Maven Plugin ([Integrate JEAF Generator into Maven Build - Configuration-Parameters-for-Services](/developer-guide/maven-plugin-configuration/#configuration-parameters-for-services--rest-resources)).

<br>For further information please also refer to:

- [How to model Services APIs - How-to-model-Service-Interfaces](/uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Examples**

<details>
  <summary><code>AccountingService.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-api%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountingService.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingServiceProxy.java (JEAF Framework only)</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-api-runtime%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountingServiceProxy.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<br>

## Code for REST Services

<br>

## Code for Service Objects

JEAF Generator will generate a matching Java class for every service object (stereotype `«ServiceObject»`) from the UML model. Here we have to distinguish two cases: The service object does not define any operations or it does.

In case that the service object does not have any operations in the model then a Java class will be written to `src-gen` and thus is not intended to be edited (`Booking`). In case that the service object has at least one operation then two classes will be generated, an abstract base class that contains everything that can be generated (`UserAccountBase` in `src-gen`) and a concrete subclass that is intended to be implements manually and that will contain the implementation of the operation that is defined in the model (`UserAccount` in `src`).

No matter if the class has operations or not, every attribute and association from the model will also be added to the generated classes (please also refer to [General Behavior of JEAF Generator](../general-behavior). The generated code will also offer Builders to create new instances of the objects. Attributes and associations that are marked as final in the model can only be set using the Builder to create the object.

Depending on configuration parameter `generateJacksonAnnotations` it is also supported that JSON / Jackson annotations are generated for service objects, so that they can be serialized using Jackson Databinding.

<br>

For further information please also refer to:

- [How to model Services APIs - How-to-model-Service-Objects](../../uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Examples**

<details>
  <summary><code>Bank.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FBank.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountBase.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountBase.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>Account.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccount.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

## Code for Enumerations

Generated code for enumerations is pretty straight forward. Information from model is taken to generated a matching Java enumeration. As no further activities for the generated code are required files will be written to `src-gen`.

<br>

For further information please also refer to:

- [How to model Services APIs - How-to-model-Enumerations](../../uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Example**

<details>
  <summary><code>BankType.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FBankType.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

## Code for Exceptions

JEAF’s [concept of exception handling](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/1542426 "https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/1542426") distinguishes between two types of exceptions: application and system exceptions. Application exceptions are used to indicate problems that are connected with the business logic of the application like unfulfilled constraints etc. System exceptions are used to indicate technical problems like not available external services or other technical problems.

Depending on the defined stereotype (`«ApplicationException»` or `«SystemException»`) either an application or system exception will be generated. In any case output will be written to `src-gen` as there is no need for further manual editing of the generated code.

<br>

For further information please refer to:

- [How to model Services APIs - How-to-model-Exceptions](../../uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Examples**

<details>
  <summary><code>AccountingServiceApplicationException.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountingServiceApplicationException.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountingServiceSystemException.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountingServiceSystemException.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

## Code for Query Objects

Code generation for query objects is also straight forward. For every class that is marked with stereotype `«QueryObject»` a matching Java class will be generated. Properties and references to service objects defined in the UML model will also be present in the generated Java code (including get and set methods). As query objects are intended to be used to describes queries operations from the UML will not be considered during code generation.

<br>

For further information please also refer to:

- [How to model Services APIs - How-to-model-Query-Objects](../../uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Example**

<details>
  <summary><code>CustomerQuery.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FCustomerQuery.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

## Code for Load Strategy Objects

The Load Strategy Pattern can be used to optimize the amount of objects loaded and returned by a service. As described in modelling guide for every part of the model that should be loaded a boolean attribute has to be defined. This will end up as boolean attributes in the generated code. As no further implementation steps are required for these type of classes files will be written to `src-gen`.

<br>

For further information please also refer to:

- [How to model Services APIs - How-to-model-Load-Strategy-Objects](../../uml-modeling-guide/how-tos/how-to-model-rest-service-apis)

<br>

**Source Code Example**

<details>
  <summary><code>CustomerLoadStrategy.java</code></summary>
<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FCustomerLoadStrategy.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>