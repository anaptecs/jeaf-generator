---
title: "UML Modeling Guide"
subtitle: "How to model Security Roles"
toc_title: " "
menubar: how_to_menu
---

# How to model Security Roles

[JEAF Security](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546210729 "https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546210729") provides a role based mechanism to ensure proper authorization for 
service calls. this means that, if JEAF Security is enabled for a component, it will be checked that the current user or anonymous is authorized to call an operation of a service. In order to simplify management of access rights JEAF Security uses roles. Simply spoken roles are just a list of access rights for service operations. For even 
further simplification these roles can already be defined in the UML model and JEAF Generator will produce a configuration will that contains all the required information.

![Security Roles](/images/security_roles.png)

The diagram above shows how to model roles in the UML model. Again definition of roles is very simple. All you need is to define an actor representing the role. This actor has to be marked with stereotype `«JEAF Actor»`. In order to define which service operations are allowed to be used you can either define a dependency to a service interface or to service operations. If you model a dependency to a service interface then the role will have access to all its operations. In case that new operations will be added then authorization will be also granted to them.

For further information please also refer to:

- [«SecurityRole»](/uml-modeling-guide/jmm/SecurityRole/)

- [Generating Code for JEAF Security](/developer-guide/code-for-jeaf-security/)

- [JEAF Security](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546210729 "https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/546210729")
