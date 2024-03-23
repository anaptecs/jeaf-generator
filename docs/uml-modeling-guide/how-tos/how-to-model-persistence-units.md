---
title: "UML Modeling Guide"
subtitle: "How to model Persistence Units"
toc_title: " "
menubar: how_to_menu
---

# How to model Persistence Units

Java Persistence API (JPA) defines so called persistence units. They are used to put a bunch of persistence objects together. All persistent classes within the same persistence unit share the same database connection and transaction.

As mentioned in section about [modelling of persistent objects](/uml-modeling-guide/how-tos/how-to-model-jeaf-persistence/) its not sufficient to only model persistent classes and their attributes and associations. In addition also persistence units have to be defined.

![Persistence Unit](/images/persistence_unit.png)

As you can see in the diagram above persistence units have to be model as components that are tagged with stereotype `«PersistenceUnit»`. In addition it is required to define which classes should belong to the persistence unit. Therefore dependencies to all packages that contain the persistent classes of the persistence unit need to be added to the model.

<br>

For further information please also refer to:

- [Generating Code for Persistence](/developer-guide/code-for-jeaf-persistence/)

- [How to model Components](/uml-modeling-guide/how-tos/how-to-model-jeaf-components/)

- [«PersistenceUnit»](/uml-modeling-guide/jmm/PersistenceUnit/)
