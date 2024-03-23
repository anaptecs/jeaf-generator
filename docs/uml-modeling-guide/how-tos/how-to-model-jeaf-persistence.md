---
title: "UML Modeling Guide"
subtitle: "How to model Persistent Classes"
toc_title: " "
menubar: how_to_menu
---

# How to model Persistent Classes

Persistent objects are a fundamental part of many applications. They define the domain model of a component and thus define its data structure. Persistent objects are stored in a relational database using Java Persistence API (JPA). As all required information for the object-relational-mapping are already defined in the UML model 
significantly more things have to be taken into account when modelling them compared to service or components.

![Persistent Classes](/images/persistent_classes.jpg)

The diagram above shows an extract from a domain model of a component. There you can see that in case of persistent objects some more information need to be added to the model.

<br>

All those information will be described in the following paragraphs in detail:

- How to model persistent classes
- How to model persistent attributes
- How to model associations between persistent classes
- How to model access methods for persistent classes
- How to model business methods for persistent classes

<br>

Please also be aware that when working with persistent classes in addition to the things described here also a persistence unit has to be defined:

- [How to model Persistence Units](/uml-modeling-guide/how-tos/how-to-model-persistence-units)

- [«PersistenceUnit»](/uml-modeling-guide/jmm/PersistenceUnit/)

- [Generating Code for JEAF Persistence](/developer-guide/code-for-jeaf-persistence/)

<br>

## How to model persistent classes

![Persistent Class](/images/persistent_class.png)

As for other types JEAF Generator requires that persistent classes are tagged with stereotype `«PersistentObject»` so that the suitable code for persistent classes can be generated. In addition to the stereotype itself also its tagged values have to be defined.

For further details about the mapping of classes to the database please refer to the description of stereotype `«PersistentObject»` where each of its tagged values is described in detail: [`«PersistentObject»`](/uml-modeling-guide/jmm/PersistentObject/)

<br>

## How to model persistent attributes

Persistent attributes of a persistent class must have assigned stereotype `«Field»`. It has an optional tagged value `sqlType` which can be used to define the SQL type that will be used on database side for the corresponding row. In case of standard datatypes like `String`, `Integer`, `Long` or the matching primitive types the `sqlType` is not required to be set in most cases as the default mapping should be sufficient.

In addition those simple mappings it is also possible to define mappings for attributes with complex types. Therefore so called `User Types` can be used. In this case please refer to:

- [How to model User Types](/uml-modeling-guide/how-tos/how-to-model-user-types)

- [«UserType»](/uml-modeling-guide/jmm/UserType/)

<br>

All attributes of a persistent class that do not have stereotype `«Field»` are treated as transient attributes and will not be mapped to the database. This means that they will also be part of the generated code, but they will be ignored when object-relational-mappings are done.

For further details about the mapping of attributes to the database please refer to the description of stereotype `«Field»` where each of its tagged values is described in detail: [«Field»](/uml-modeling-guide/jmm/Field/)

<br>

## How to model associations between persistent classes

The definition of associations between classes in a domain model is one of the most important tasks that needs to be done. Also it’s one of most challenging ones. In case of persistent objects this also has an direct impact on the structure of the database tables that are underneath the application.
![Persistent Associations](/images/persistent_associations.png)

As you can see in the diagram it is required to use stereotype `«Role»` to define persistence settings. It is very important that the stereotype role is defined on all navigable ends of an association as well as a role name and a multiplicity. The tagged values of the stereotype allow to define all required information that are needed for persistence.

JEAF also supports so called many-to-many associations. As they can not be mapped to the database directly it is mandatory to also define the name of a link table on one of the association ends.

For further details about the mapping of associations to the database please refer to the description of stereotype `«Role»` where each of its tagged values is described in detail: [«Role»](/uml-modeling-guide/jmm/Role/)

<br>

## How to model access methods for persistent classes

It is not required to model access methods for attributes or associations explicitly. JEAF Generator will generate them by default. For attributes there will be set and get methods. In case of associations depending on the multiplicity of the association ends there either will be get and set methods (`0..1` or `1`) or add, set, get and remove methods (`1..*` or `0..*`).

<br>

It is also important to know that there is a big difference between directed and bidirectional associations. From the model perspective the difference seems to be just a detail but when it comes to the generated code it has a big impact:

- **Bidirectional Associations**  
  If a association is modeled to be bidirectional then the generated code will ensure the consistency of that association in both directions.  
  Example:
  
  - Class `A` has a bidirectional many-to-many association with class `B`. If we now add an object of class `B` to `A` then the generated code will ensure that the association form `B` to `A` is also set accordingly.  <br>

- **Directed Associations**  
  In case of directed associations the references are only maintained into one direction as the association is not bidirectional.

<br>

## How to model business methods for persistent classes

![Business Methods](/images/business_methods.png)

Usually persistent classes not only have attributes and associations but they also have business methods. They need to be defined directly inside the UML model including their full signature. Of course for business methods JEAF Generator is not able to generate any meaningful code, so in this case only an empty method can be generated.
