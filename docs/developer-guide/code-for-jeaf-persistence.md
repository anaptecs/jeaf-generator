---
title: "Developer Guide"
subtitle: "Generating Code for JEAF Persistence"
toc: false
menubar: developer_guide_menu
---

## Generating Code for JEAF Persistence

Diagram below illustrates the transformation of persistent classes from the UML model (stereotype [«PersistentObject»](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/516849793 "/wiki/spaces/JEAF/pages/516849793")) into the corresponding Java code and resources.

![Code for JEAF Persistence](/images/code_for_jeaf_persistence.png)

<br>

As you can see for class `AccountPO` from the UML model the following output will be generated:<br>

- **Abstract base class with generated code** (`AccountPOBase`)  
  `AccountPOBase` is the abstract base class for the concrete implementation of our persistent class `AccountPO`. The base class contains all generated parts as they were defined in the UML model like attributes and associations to other objects. It also contains all access methods for attributes and associations. In addition also abstract methods for all business methods from the model will be generated to ensure that they will be really provided by the implementation of the persistent class (`AccountPO` in the example case).
  
  The base class must not be edited manually, thus it will be written to slot `src-gen`.  

<br>

- **Actual persistent class** (`AccountPO`)  
  Class AccountPO is the implementation of our persistent object. As all boiler blade /standard code was already generated as part of its base class it only contains the explicitly defined business methods from the UML model. As this class is the actual implementation it is intended to be edited by developers and will be written to slot `src`.
  
  JEAF Generator will never overwrite or modify this class unless it does not exist.  

<br>

- **Hibernate Mapping** (`AccountPO.hbm.xml`)  
  In addition JEAF Generator also creates a Hibernate Mapping Descriptor. This descriptor contains all the additional information that are required by Hibernate to do the object-relational-mapping at runtime. The configuration file must not be edited manually and so it will be written to slot `res-gen`.

<br>

For more information about how to model persistent classes please refer to [How to model Persistent Classes](/uml-modeling-guide/how-tos/how-to-model-jeaf-persistence)

<br>

## Generated code for persistence units

Diagram below shows the code that is generated from a persistence unit (stereotype [«PersistenceUnit»](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/529137750 "/wiki/spaces/JEAF/pages/529137750")) in the UML model.

![Code for JEAF Persistence](/images/code_for_persistence_unit.png)

<br>

As you can see for persistence unit `AccountingPersistenceUnit` the following output will be generated:<br>

- Interface for persistence unit (`AccountingPersistenceUnit`)  
  For every definition of a persistence unit inside the UML model an Java interface will be generated. This interface is actually only used as holder for an annotation (`@PersistenceUnit`) that defines the properties of the persistence unit. In addition to the properties the annotation also contains a references to all classes that belong to the persistence unit. This is done through so called mappings (see next bullet point below)  

<br>

- Mappings interface (`Mappings`)  
  For every package with persistent classes that belongs to the persistence unit an Java interface with name `Mappings` will be generated. This interface again is just a holder for an annotation (`@MappingFiles`) that defines all the persistent classes of this package.

<br>

Neither the persistence unit definition itself nor the mapping definitions must be edited by hand and so they are written to slot `src-gen`.

<br>

For further information about JEAF and Persistence please refer to [JEAF Persistence](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546209865 "https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546209865")
