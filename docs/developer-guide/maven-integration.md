---
title: "Developer Guide"
subtitle: "Integrate JEAF Generator into Maven Build"
toc: true
menubar: developer_guide_menu
---

# Integrate JEAF Generator into Maven Build

JEAF Generator is provided as Maven Plugin and thus can be easily integrated into your build process. This side will describe how to do that.

<br>

## Maven Build Helper Plugin

When working with JEAF Generator the standard Maven directory layout is not sufficient any longer as we have to distinguish between hand-written and generated code ([Directory Layout for generated output](../general-behavior)). This also requires that the additional locations of source code and resources are known to the build process in general. To do so we make use of [Maven Build Helper Plugin](https://www.mojohaus.org/build-helper-maven-plugin).

<br>

This means that in addition to the JEAF Generator Plugin also Maven Build Helper has to be added to your build. Depending on the structure of you Maven projects it might also be an option to add configuration Build Helper Plugin to your parent POM.

<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Fpom.xml%3Fts%3D4%23L118-L194&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>

<br>

## Configuration of JEAF Generator Maven Plugin

JEAF Generator can either read the required XMI files directly from the local file system e.g. some sub directory in your project or from a Maven artifact. 

For the example here we read the model files from an artifact. So, we need to declare a dependency in our POM for that:

<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fjeaf-generator-sample-project-1.6.30%2Faccounting-pojos%2Fpom.xml%3Fts%3D4%23L21-L31&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>

<br>

Below you can find an example how JEAF Generator can be integrated into your build. As it supports a rather large set of features it also has a big bunch of configuration parameters. For full list of configuration parameters please have a look here: [JEAF Generator Configuration Parameters](../maven-plugin-configuration)

<script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fjeaf-generator-sample-project-1.6.30%2Faccounting-pojos%2Fpom.xml%3Fts%3D4%23L36-L97&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>

<br>

## Execute JEAF Generator

As you can see in the example configuration above JEAF Generator will be executed in Maven standard phase `generate-sources` as part of your build. This means that it will be execute as part of your standard build process e.g. `mvn clean install`.

<br>

If you want to run code generation only, then you can execute goal `generate-sources` which is supported by most development environments directly via the UI.

![Eclipse Generate Sources](/images/generate_sources.png)
