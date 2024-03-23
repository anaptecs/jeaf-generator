---
title: "UML Modeling Guide"
subtitle: "MagicDraw XMI Export"
toc: true
menubar: uml_modeling_guide_menu
---

# MagicDraw XMI Export

Currently <a href="https://www.3ds.com/products-services/catia/products/no-magic/magicdraw" target="_blank">MagicDraw UML</a> is the recommend tool that works best with JEAF Generator for [various reason](/uml-modeling-guide/uml-modeling-tools). We assume that your MagicDraw UML project is ready to be used in combination with JEAF Generator as described in [How to setup MagicDraw UML Projects](/uml-modeling-guide/setup-magic-draw-projects).

As JEAF Generator requires an XMI Export of your UML model as input we now shortly want to describe how to do that.

<br>

## Export UML model as `Eclipse UML2 (v2.x) XMI File` to a directory

MagicDraw UML will write several files for your model to the directory that you have chosen.

![MagicDeaw UML XMI Export](/images/xmi_export.png)

<br>

## Define XMI as Input for JEAF Generator

The exported XMI files act as input for JEAF Generator. To make use of them you have the following options:

1. Package XMI files as artifacts

2. Directly works with XMI files

<br>

### Package XMI files in Maven artifact

First option is to package your model using Maven. In this case you define a 
dependency to the artifact with the XMI files using Maven.

```xml
<dependencies>
    <!-- 
         Dependency to packaged model artifact are required for code generation.
         It will not have any impact on runtime behavior as the package just contains
         XMI files but no code or resource files.
    -->
    <dependency>
        <groupId>com.anaptecs.jeaf.generator.sample</groupId>
        <artifactId>accounting-model</artifactId>
        <version>${project.version}</version>
        <type>zip</type>
        <scope>provided</scope>
    </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <groupId>com.anaptecs.jeaf.generator</groupId>
            <artifactId>jeaf-generator-maven-plugin</artifactId>
            <version>${maven.jeaf-generator-plugin.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>Generator</goal>
                    </goals>
                    <phase>generate-sources</phase>
                </execution>
            </executions>
            <configuration>
                <!-- 
                    Define where JEAF Generator will find XMI files as input. In this 
                    case here we take them from a Maven artifact. However it is also 
                    possible to directly read the files from some location on your disk.
                    For further information please refer to: 
                        https://www.jeaf-generator.io/developer-guide/general-behavior/
                -->
                <modelArtifactGroupID>com.anaptecs.jeaf.generator.sample</modelArtifactGroupID>
                <modelArtifactArtifactID>accounting-model</modelArtifactArtifactID>
                <modelArtifactXMIPath>xmi</modelArtifactXMIPath>
                <umlModelFile>JEAF_Accounting_Sample.uml</umlModelFile>
                ...
            </configuration>
        </plugin>
        ...
    </plugins>
<build>
```

<br>

### Reference XMI files directly

Another option is to store the XMI files in a resource directory of your 
project. JEAF Generator configuration will then point to that directory 
and use the files as input.

```xml
<configuration>
    <!-- Define input directory where XMI files are stored. -->
    <xmiDirectory>${project.basedir}/../jeaf-generator-test-model/xmi</xmiDirectory>
    <umlModelFile>JEAF_Test.uml</umlModelFile>
    ...
</configuration>
```

<br>

**Recommendation**

+ In any case we recommend that the XMI files are under version control, so that JEAF Generator is not only executed in local development environment but also as part of the standard build process of your CI/CD.
