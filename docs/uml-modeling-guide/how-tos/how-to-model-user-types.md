---
title: "UML Modeling Guide"
subtitle: "How to model User Types"
toc_title: " "
menubar: how_to_menu
---

# How to model User Types

User Types are used to simplify UML modeling when the same kind of data is used in several areas. In this case of course it possible to extract the information into an independent domain object. But in many cases the data we are talking about is not really a domain object. A very good example therefore might be a period (having a start and end date). From a business perspective this is a complex data type but not a domain object. In this case we can make use of user types.

When it comes to object-relational-mapping the big difference between a persistent object and an user type is the place where the data is stored on the database. In case of a persistent object its data will be stored in an own database table. In case of an user type however the data will be stored as rows of the table in which the persistent object that uses the user type is stored.

![User Types](/images/user_type.png)

The diagram above shows how to model user types. As you can see it slightly differs form persistent objects. Similar to persistent objects also all attributes of the user type must have the stereotype [«Field»](/uml-modeling-guide/jmm/Field/). The user type class itself however does not require information about the database table where it should be written to. Instead it needs to be defined the name of the Java class that is responsible for the mapping of the user type to the database.

This user type mapping class that is defined in the stereotype has to be implemented manually. For further details about how to implement such a mapping please refer to Hibernate documentation. Also the Javadoc of classes `UserType` and `CompositeUserType` from package `org.hibernate.usertype` is a good source of information.

<br>

**Note:** Please be aware that usage of user types is not a JPA but a Hibernate feature.
![User Type Usage](/images/user_type_usage.png)

As soon as your user type is defined it is very simple to use it. You just need to model an persistent attribute of the user type and that’s it.
