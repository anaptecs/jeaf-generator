/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import static org.twdata.maven.mojoexecutor.MojoExecutor.configuration;
import static org.twdata.maven.mojoexecutor.MojoExecutor.element;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.MojoExecutor.goal;
import static org.twdata.maven.mojoexecutor.MojoExecutor.plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.twdata.maven.mojoexecutor.MojoExecutor;
import org.twdata.maven.mojoexecutor.MojoExecutor.Element;
import org.twdata.maven.mojoexecutor.MojoExecutor.ExecutionEnvironment;

import com.anaptecs.jeaf.fwk.generator.util.TargetRuntime;
import com.anaptecs.jeaf.fwk.tools.message.generator.ConversionResult;
import com.anaptecs.jeaf.fwk.tools.message.generator.ExcelToMessageResourceConverter;
import com.anaptecs.jeaf.fwk.tools.message.generator.MessageConstantsGenerator;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.file.FileTools;
import com.anaptecs.jeaf.tools.api.performance.Stopwatch;
import com.anaptecs.jeaf.tools.api.performance.TimePrecision;
import com.anaptecs.jeaf.tools.api.string.StringTools;
import com.anaptecs.jeaf.tools.api.xml.DocumentProperties;
import com.anaptecs.jeaf.tools.api.xml.DocumentProperties.Builder;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.VerificationResult;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

@Mojo(
    name = "Generator",
    defaultPhase = LifecyclePhase.NONE,
    threadSafe = true,
    requiresDependencyResolution = ResolutionScope.TEST)

public class GeneratorMojo extends AbstractMojo {
  /**
   * Reference to Maven project. Reference will be injected by Maven and can not be configured via POM.
   */
  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject project;

  /**
   * UML Modeling Tool that was used to create the UML Model. By default it is assumed that MagicDraw UML was used.
   * 
   * Supported values are (case sensitive): MAGIC_DRAW, ECLIPSE_PAPYRUS, OTHER
   */
  @Parameter(required = false, defaultValue = "MAGIC_DRAW")
  private ModelingTool umlModellingTool;

  /**
   * Directory which contains all XMI files. The files have to be exported from MagicDraw UML using its Eclipse UML2
   * Export v2.x (File - Export To - Eclipse UML2 (v2.0x) XMI File)
   */
  @Parameter(required = false)
  private String xmiDirectory;

  /**
   * Group ID of the artifact that contains the XMI files of the UML model.
   * 
   * The UML model can either be defined by pointing to the directory where the XMI files are located directly or by
   * referencing an artifact that contains the XMI files.
   */
  @Parameter(required = false)
  private String modelArtifactGroupID;

  /**
   * Artifact ID of the artifact that contains the XMI files of the UML model.
   * 
   * The UML model can either be defined by pointing to the directory where the XMI files are located directly or by
   * referencing an artifact that contains the XMI files.
   */
  @Parameter(required = false)
  private String modelArtifactArtifactID;

  /**
   * XMI Path inside the artifact that contains the XMI files of the UML model.
   */
  @Parameter(required = false)
  private String modelArtifactXMIPath;

  /**
   * Name of the model file that should be used. Usually it has the same name as the MagicDraw UML project. Only the
   * name of the file has to be provided as we assume that the file is located in the XMI directory.
   */
  @Parameter(required = false)
  private String umlModelFile;

  /**
   * Name of the file that contains the JEAF Metamodel (JMM). Usually the default value "JMM.profile.uml" can be used.
   * Only the name of the file has to be provided as we assume that the file is located in the XMI directory.
   */
  @Parameter(required = false, defaultValue = "JMM.profile.uml")
  private String umlProfileFile;

  /**
   * Name of the root template for customer specific extensions
   */
  @Parameter(required = false, defaultValue = "CustomRoot::Root")
  private String customRootTemplate;

  /**
   * List of custom check files that will be used to run customer specific checks of the UML model.
   */
  @Parameter(required = false, defaultValue = " ")
  private List<String> customCheckFiles;

  /**
   * Directory where all files that belong to the "src" directory will be written to.
   */
  @Parameter(required = false)
  private String sourceDirectory;

  /**
   * Directory where all files that belong to the "src-gen" directory will be written to.
   */
  @Parameter(required = false)
  private String sourceGenDirectory;

  /**
   * Parameter defines if src-gen directory should be cleaned before the generator runs. Cleaning means that all
   * existing files will be deleted. Cleaning src-gen directory is the proposed way to go.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean cleanSourceGen;

  /**
   * Directory where all files that belong to the "res" directory will be written to.
   */
  @Parameter(required = false)
  private String resourceDirectory;

  /**
   * Directory where all files that belong to the "res-gen" directory will be written to.
   */
  @Parameter(required = false)
  private String resourceGenDirectory;

  /**
   * Parameter defines if res-gen directory should be cleaned before the generator runs. Cleaning means that all
   * existing files will be deleted. Cleaning res-gen directory is the proposed way to go.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean cleanResourceGen;

  /**
   * Whitelist of packages for the JEAF Generator. Model elements of all packages that match with the white list will be
   * handled by JEAF Generator.
   */
  @Parameter(required = false, defaultValue = " ")
  private List<String> packages;

  /**
   * List of resource files that should be ignored when generating message constants classes from resource files.
   */
  @Parameter(required = false, defaultValue = " ")
  private List<String> ignoredResourceFiles;

  /**
   * Switch defines whether custom constraints should be generated.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateCustomConstraints;

  /**
   * Switch defines whether service interfaces should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateServiceInterfaces;

  /**
   * Switch defines whether service proxies should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateServiceProxies;

  /**
   * Switch defines whether service provider interfaces should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateServiceProviderInterfaces;

  /**
   * Switch defines whether service provider implementations should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateServiceProviderImpls;

  /**
   * Switch defines whether REST resources should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTResources;

  /**
   * Switch defines whether activity interfaces should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateActivityInterfaces;

  /**
   * Switch defines whether activity implementations should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateActivityImpls;

  /**
   * Switch defines whether service objects should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateServiceObjects;

  /**
   * Switch defines whether exception classes should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateExceptionClasses;

  /**
   * Switch defines whether persistent objects should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generatePersistentObjects;

  /**
   * Switch defines whether POJO's should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generatePOJOs;

  /**
   * Switch defines whether domain objects should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateDomainObjects;

  /**
   * Switch defines whether object mappers should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateObjectMappers;

  /**
   * Switch defines whether component implementation classes should be generated or not e.g. service and port
   * implementations and their bases classes.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateComponentImpls;

  /**
   * Switch defines whether component runtime classes should be generated or not e.g. components, component
   * configurations, component factories and service factories.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateComponentRuntimeClasses;

  /**
   * Switch defines whether global parts should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateGlobalParts;

  /**
   * Switch defines whether a JUnit test case for every service should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJUnitTests;

  /**
   * Switch defines whether an Open API specification should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateOpenAPISpec;

  /**
   * Switch defines whether JAX-RS annotations should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJAXRSAnnotations;

  /**
   * Switch defines whether Jackson annotations for JSON serialization should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJacksonAnnotations;

  /**
   * Switch defines if Java Validation Annotation @Valid will be generated for all generated POJO, ServiceObjects,
   * DomainObject and PersistentObjects even in cases when it is not defined in the UML model.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValidAnnotationForClasses;

  /**
   * Switch defines whether Java Validation Annotations should not only be generated for explicitly modeled annotations
   * but also from multiplicity of modeled attributes.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValidationAnnotationsForAttributesFromMultiplicity;

  /**
   * Switch defines whether Java Validation Annotations should not only be generated for explicitly modeled annotations
   * but also from multiplicity of modeled associations.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValidationAnnotationsForAssociationsFromMultiplicity;

  /**
   * Parameter defines if generated code for JSON serialization should be SemVer compliant or not.
   */
  @Parameter(required = false, defaultValue = "true")
  private Boolean enableSemVerForJSON;

  /**
   * Parameter defines if JSON serializers should be generated.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJSONSerializers;

  /**
   * Parameter can be used to suppress link to model element in generated OpenAPI specification. By default fully
   * qualified name of the type is added as comment above the type definition.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean suppressClassNameCommentInOpenAPISpec;

  /**
   * Parameter defines if constants for the name of attributes of POJOs, Service Objects, Query Objects, Domain Objects
   * or Persistent Objects should be generated or not..
   */
  @Parameter(required = false, defaultValue = "true")
  private Boolean generateConstantsForAttributeNames;

  /**
   * Parameter can be used to define a list of warning that should be suppressed in the generated code. This will lead
   * to annotation @SuppressWarnings for the defined warnings
   */
  @Parameter(required = false)
  private List<String> suppressWarnings = new ArrayList<>();

  /**
   * Parameter can be used to suppress all warnings in generated code (@SuppressWarnings("all")). It's strongly
   * recommended to not use this feature ;-)
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean suppressAllWarnings;

  /**
   * Parameter can be used to add @Generated annotation to generated code.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean addGeneratedAnnotation;

  /**
   * Parameter can be used to also add timestamp of code generation to the @Generated annotation. Parameter is only
   * relevant if <code>addGeneratorAnnotation</code> is set to <code>true</code>.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean addGenerationTimestamp;

  /**
   * Parameter can be used to also add the defined comment of code generation to the @Generated annotation. Parameter is
   * only relevant if <code>addGeneratorAnnotation</code> is set to <code>true</code>.
   */
  @Parameter(required = false)
  private String generationComment = "";

  /**
   * Parameter can be used to define the target runtime environment for which code should be generated. Currently JEAF
   * and Spring are supported. Valid values are (case-sensitive): "JEAF", "JAVA" and "SPRING"
   */
  @Parameter(required = false, defaultValue = "JEAF")
  private TargetRuntime targetRuntime;

  /**
   * Switch defines whether a message constants should be generated from resource files or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateMessageConstants;

  /**
   * Switch defines whether the generated set methods for one-to-many associations should be public or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generatePublicSettersForAssociations;

  /**
   * Switch defines whether the generated set methods for to-one associations has checks for null values of parameters.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateNullChecksForToOneAssociations;

  /**
   * Name of the row within which the OID / primary key will be stored. If the property is not set "OID" will be used as
   * default.
   */
  @Parameter(required = false, defaultValue = "OID")
  private String peristentObjectsOIDRowName;

  /**
   * Name of the row within which the version label of the object will be stored. The version label is used to determine
   * optimistic lock conflicts. If the property is not set "VERSION" will be used as default.
   */
  @Parameter(required = false, defaultValue = "VERSION")
  private String peristentObjectsVersionLabelRowName;

  /**
   * Company information for header of generated files.
   */
  @Parameter(required = false, defaultValue = "Please add organization file header")
  private String fileHeaderCompany;

  /**
   * Author information for header of generated files.
   */
  @Parameter(required = false, defaultValue = "JEAF Generator")
  private String fileHeaderAuthor;

  /**
   * Copyright information for header of generated files.
   */
  @Parameter(required = false, defaultValue = "All rights reserved.")
  private String fileHeaderCopyright;

  /**
   * Version information for header of generated files.
   */
  @Parameter(required = false, defaultValue = "1.0")
  private String fileHeaderVersion;

  /**
   * Parameter can be used to disable formatting of generated sources and resources in general.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean disableFormatting;

  /**
   * Parameter can be used to disable formatting of generated sources only.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean disableSourceFormatting;

  /**
   * Parameter can be used to disable formatting of generated resources only.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean disableResourceFormatting;

  /**
   * Reference to the file that contains the code style definition for Java code. If it is not defined then the default
   * code style will be used.
   */
  @Parameter(required = false, defaultValue = "anaptecs_code_guideline.xml")
  private String javaFormatterStyleFile;

  /**
   * Reference to the file that contains the code style definition for XML. If it is not defined then the default code
   * style will be used.
   */
  @Parameter(required = false, defaultValue = "anaptecs_xml_style.properties")
  private String xmlFormatterStyleFile;

  /**
   * Parameter defines the grouping and sorting of Java import statements.
   */
  @Parameter(required = false, defaultValue = "java.,javax.,org.,com.")
  private String importGroups;

  /**
   * Parameter defines the grouping and sorting of static Java import statements.
   */
  @Parameter(required = false, defaultValue = "java,*")
  private String staticImportGroups;

  /**
   * Parameter defines if unused imports in generated code should be removed or not. Except for cases when you run into
   * problems there is no reason to disable this feature.
   */
  @Parameter(required = false, defaultValue = "true")
  private boolean removeUnusedImports;

  @Component
  private MavenProject mavenProject;

  @Component
  private MavenSession mavenSession;

  @Component
  private BuildPluginManager pluginManager;

  /**
   * Initialize object
   */
  public GeneratorMojo( ) {
    // Set Log4J and Log4J2 configuration. Unfortunately some used plugins still use Log4J 1.x so we have to maintain
    // configurations for both versions.
    System.setProperty("log4j.configuration", "jeaf-generator-log4j.xml");
    System.setProperty("log4j2.configurationFile", "jeaf-generator-log4j2.xml");
  }

  /**
   * Execute this plugin.
   */
  @Override
  public void execute( ) throws MojoExecutionException, MojoFailureException {
    if (this.isGenerationRequested()) {
      // Show startup info.
      this.showStartupInfo();

      // Clean *-gen directories
      this.cleanDirectories();

      // Run message constants generator
      this.runMessageConstantsGenerator();

      // Run Generator based on UML model Successful
      boolean lSuccessful = this.runUMLGenerator();

      if (lSuccessful == true) {
        // Format generated sources and resources
        this.runFormatter();
      }
      // Error during code generation from UML model
      else {
        throw new MojoFailureException(
            "Problem occured during code generation from UML model. Please see log output for further details.");
      }
    }
    // Nothing should be generated.
    else {
      Log lLog = this.getLog();
      lLog.info("--------------------------------------------------------------------------------------");
      lLog.info("Starting JEAF Generator " + XFun.getVersionInfo().getVersionString());
      lLog.info("Skipping code generation as there is no configuration present.");
      lLog.info("--------------------------------------------------------------------------------------");
    }
  }

  private String getPackageWhitelist( ) {
    return packages.stream().collect(Collectors.joining("; "));
  }

  private String getCustomCheckFiles( ) {
    return customCheckFiles.stream().collect(Collectors.joining("; "));
  }

  private void showStartupInfo( ) {
    Log lLog = this.getLog();
    lLog.info("--------------------------------------------------------------------------------------");
    lLog.info("Starting JEAF Generator " + XFun.getVersionInfo().getVersionString());
    lLog.info("--------------------------------------------------------------------------------------");
    if (this.isUMLGenerationRequested() == true) {
      lLog.info("UML Model File:                                   " + umlModelFile);
      lLog.info("UML Profile File:                                 " + umlProfileFile);
      if (xmiDirectory != null) {
        lLog.info("XMI Path:                                         " + xmiDirectory);
      }
      if (modelArtifactGroupID != null) {
        lLog.info("Model Artifact Group-ID:                          " + modelArtifactGroupID);
      }
      if (modelArtifactArtifactID != null) {
        lLog.info("Model Artifact-ID:                                " + modelArtifactArtifactID);
      }
      if (modelArtifactXMIPath != null) {
        lLog.info("Model Artifact XMI Path:                          " + modelArtifactXMIPath);
      }
      lLog.info(" ");
    }

    lLog.info("src:                                              " + sourceDirectory);
    lLog.info("src-gen:                                          " + sourceGenDirectory);
    lLog.info("res:                                              " + resourceDirectory);
    lLog.info("res-gen:                                          " + resourceGenDirectory);
    lLog.info(" ");
    lLog.info("UML Modelling Tool:                               " + umlModellingTool.getDisplayName());
    lLog.info("Target Runtime:                                   " + targetRuntime.name());
    lLog.info(" ");
    lLog.info("Code-Style:                                       " + xmlFormatterStyleFile);
    lLog.info("Package Whitelist:                                " + this.getPackageWhitelist());
    String lIgnoredResources = Tools.getCollectionTools().toString(ignoredResourceFiles, ", ");
    if (lIgnoredResources.trim().isEmpty()) {
      lIgnoredResources = "none";
    }
    lLog.info("Ignored resource files:                           " + lIgnoredResources);
    lLog.info(" ");

    if (generateCustomConstraints) {
      lLog.info("Generate Custmom Constraints:                     " + generateCustomConstraints);
    }
    if (generateServiceObjects) {
      lLog.info("Generate Service Objects:                         " + generateServiceObjects);
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
    }
    if (generateExceptionClasses) {
      lLog.info("Generate Exception Classes:                       " + generateExceptionClasses);
    }
    if (generateServiceInterfaces) {
      lLog.info("Generate Service Interfaces:                      " + generateServiceInterfaces);
    }
    if (generateServiceProxies) {
      lLog.info("Generate Service Proxies:                         " + generateServiceProxies);
    }
    if (generateServiceProviderInterfaces) {
      lLog.info("Generate Service Provider Interfaces:             " + generateServiceProviderInterfaces);
    }
    if (generateServiceProviderImpls) {
      lLog.info("Generate Service Provider Impls:                  " + generateServiceProviderImpls);
    }
    if (generateRESTResources) {
      lLog.info("Generate REST Resources:                          " + generateRESTResources);
    }
    if (generateActivityInterfaces) {
      lLog.info("Generate Activity Interfaces:                     " + generateActivityInterfaces);
    }
    if (generateActivityImpls) {
      lLog.info("Generate Activity Impls:                          " + generateActivityImpls);
    }
    if (generatePOJOs) {
      lLog.info("Generate POJO's:                                  " + generatePOJOs);
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
    }
    if (generateDomainObjects) {
      lLog.info("Generate Domain Objects:                          " + generateDomainObjects);
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
    }
    if (generateObjectMappers) {
      lLog.info("Generate Object Mappers:                          " + generateObjectMappers);
    }
    if (generateComponentImpls) {
      lLog.info("Generate Component Impls:                         " + generateComponentImpls);
    }
    if (generateComponentRuntimeClasses) {
      lLog.info("Generate Component Runtime Classe:                " + generateComponentRuntimeClasses);
    }
    if (generateGlobalParts) {
      lLog.info("Generate Global Parts:                            " + generateGlobalParts);
    }
    if (generateJUnitTests) {
      lLog.info("Generate JUnit Test Cases:                        " + generateJUnitTests);
    }
    if (generateOpenAPISpec) {
      lLog.info("Generate Open API Specification:                  " + generateOpenAPISpec);
    }
    if (generateJAXRSAnnotations) {
      lLog.info("Generate JAX-RS annotations:                      " + generateJAXRSAnnotations);
    }
    if (generateJacksonAnnotations) {
      lLog.info("Generate Jackson annotations:                     " + generateJacksonAnnotations);
      lLog.info("Enable SemVer for JSON serialization:             " + enableSemVerForJSON);
    }

    if (generateJSONSerializers) {
      lLog.info("Generate JSON serializers:                        " + generateJSONSerializers);
    }

    if (suppressAllWarnings) {
      lLog.info("Suppress all warnings:                            " + suppressAllWarnings);
    }

    if (suppressWarnings.isEmpty() == false) {
      lLog.info("Suppress all warnings:                            "
          + suppressWarnings.stream().collect(Collectors.joining("; ")));
    }

    if (addGeneratedAnnotation) {
      lLog.info("Generate @Generated annotation:                   " + addGeneratedAnnotation);
      lLog.info("Add generation timestamp:                         " + addGenerationTimestamp);
      lLog.info("Add generation comment:                           " + generationComment);
    }

    if (generateMessageConstants) {
      lLog.info("Generate Message Constants:                       " + generateMessageConstants);
    }
    if (generateValidAnnotationForClasses) {
      lLog.info("Generate @Valid Annotations for classes:          " + generateValidAnnotationForClasses);
    }
    if (generateValidationAnnotationsForAttributesFromMultiplicity) {
      lLog.info("Generate Validation Annotations for attributes:   "
          + generateValidationAnnotationsForAttributesFromMultiplicity);
    }
    if (generateValidationAnnotationsForAssociationsFromMultiplicity) {
      lLog.info("Generate Validation Annotations for associations: "
          + generateValidationAnnotationsForAssociationsFromMultiplicity);
    }
    if (generatePersistentObjects) {
      lLog.info("Generate Persistent Objects:                      " + generatePersistentObjects);
      lLog.info(" ");
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
      lLog.info("OID Row Name:                                     " + peristentObjectsOIDRowName);
      lLog.info("Version Label Row Name:                           " + peristentObjectsVersionLabelRowName);
    }
    if (generatePublicSettersForAssociations) {
      lLog.info("Generate public setters for associations:         " + generatePublicSettersForAssociations);
    }
    if (generateNullChecksForToOneAssociations) {
      lLog.info("NULL checks for to one associations:              " + generateNullChecksForToOneAssociations);
    }
    lLog.info(" ");
    lLog.info("Javadoc Company Tag:                              " + fileHeaderCompany);
    lLog.info("Javadoc Author Tag:                               " + fileHeaderAuthor);
    lLog.info("Javadoc Copyright Tag:                            " + fileHeaderCopyright);
    lLog.info("Javadoc Version Tag:                              " + fileHeaderVersion);
    lLog.info(" ");

  }

  private void cleanDirectories( ) {
    FileTools lFileTools = Tools.getFileTools();
    if (cleanSourceGen == true) {
      this.getLog().info("Cleaning src-gen directory '" + sourceGenDirectory + "'.");
      lFileTools.tryDeleteRecursive(sourceGenDirectory, true);
      lFileTools.createDirectory(sourceGenDirectory);
    }
    if (cleanResourceGen == true) {
      this.getLog().info("Cleaning res-gen directory '" + resourceGenDirectory + "'.");
      lFileTools.tryDeleteRecursive(resourceGenDirectory, true);
      lFileTools.createDirectory(resourceGenDirectory);
    }
  }

  /**
   * Method runs the UML generator. The UML generator is based on a library called oAW (openArchitectureWare)
   * 
   * @throws MojoFailureException
   */
  private boolean runUMLGenerator( ) throws MojoFailureException {
    // Check if UML generation should be executed.
    boolean lSuccessful;
    if (this.isUMLGenerationRequested()) {
      // Prepare XMI file
      this.prepareXMIFiles();

      // Configure all system properties for UML Generator.
      System.setProperty("maven.version", mavenProject.getVersion());
      System.setProperty("info.version", fileHeaderVersion);
      System.setProperty("info.company", fileHeaderCompany);
      System.setProperty("info.copyright", fileHeaderCopyright);
      System.setProperty("info.author", fileHeaderAuthor);

      System.setProperty("list.custom.checkfiles", this.getCustomCheckFiles());

      System.setProperty("list.pkgs.whitelist", this.getPackageWhitelist());
      System.setProperty("switch.gen.custom.constraints", generateCustomConstraints.toString());
      System.setProperty("switch.gen.global.parts", generateGlobalParts.toString());
      System.setProperty("switch.gen.services", generateServiceInterfaces.toString());
      System.setProperty("switch.gen.service.proxies", generateServiceProxies.toString());
      System.setProperty("switch.gen.service.provider.interfaces", generateServiceProviderInterfaces.toString());
      System.setProperty("switch.gen.persistent.objects", generatePersistentObjects.toString());
      System.setProperty("switch.gen.activity.interfaces", generateActivityInterfaces.toString());
      System.setProperty("switch.gen.activity.impls", generateActivityImpls.toString());
      System.setProperty("switch.gen.object.mappers", generateObjectMappers.toString());
      System.setProperty("switch.gen.component.runtime.classes", generateComponentRuntimeClasses.toString());
      System.setProperty("switch.gen.component.impls", generateComponentImpls.toString());
      System.setProperty("switch.gen.service.provider.impls", generateServiceProviderImpls.toString());
      System.setProperty("switch.gen.rest.resources", generateRESTResources.toString());
      System.setProperty("switch.gen.service.objects", generateServiceObjects.toString());
      System.setProperty("switch.gen.exception.classes", generateExceptionClasses.toString());
      System.setProperty("switch.gen.pojos", generatePOJOs.toString());
      System.setProperty("switch.gen.domain.objects", generateDomainObjects.toString());
      System.setProperty("switch.gen.junits", generateJUnitTests.toString());
      System.setProperty("switch.gen.openapispec", generateOpenAPISpec.toString());
      System.setProperty("switch.gen.jaxrs.annotations", generateJAXRSAnnotations.toString());
      System.setProperty("switch.gen.jackson.annotations", generateJacksonAnnotations.toString());
      System.setProperty("switch.gen.enable.json.semver", enableSemVerForJSON.toString());
      System.setProperty("switch.gen.json.serializers", generateJSONSerializers.toString());
      System.setProperty("switch.gen.enable.name.constants", generateConstantsForAttributeNames.toString());
      System.setProperty("switch.gen.target.runtime", targetRuntime.name());

      System.setProperty("switch.gen.suppress.warnings", suppressWarnings.stream().collect(Collectors.joining("; ")));
      System.setProperty("switch.gen.suppress.all.warnings", suppressAllWarnings.toString());
      System.setProperty("switch.gen.add.generated.annotation", addGeneratedAnnotation.toString());
      System.setProperty("switch.gen.add.generation.timestamp", addGenerationTimestamp.toString());
      System.setProperty("switch.gen.generation.comment", generationComment.toString());

      System.setProperty("switch.gen.suppress.classname.openapi", suppressClassNameCommentInOpenAPISpec.toString());

      System.setProperty("switch.gen.enable.valid.annotation.classes", generateValidAnnotationForClasses.toString());
      System.setProperty("switch.gen.enable.validation.annotation.attributes",
          generateValidationAnnotationsForAttributesFromMultiplicity.toString());
      System.setProperty("switch.gen.enable.validation.annotation.associations",
          generateValidationAnnotationsForAssociationsFromMultiplicity.toString());

      System.setProperty("switch.gen.public.setters.for.associations", generatePublicSettersForAssociations.toString());
      System.setProperty("switch.gen.null.checks.for.to.one.associations.of.service.objects",
          generateNullChecksForToOneAssociations.toString());
      System.setProperty("name.oid.row", peristentObjectsOIDRowName);
      System.setProperty("name.version.label.row", peristentObjectsVersionLabelRowName);

      String lXMIDirectory = this.getXMIDirectoryLocation();

      // Check if UML model file and profile file exist
      String lModelFilePath = lXMIDirectory + "/" + umlModelFile;
      File lModelFile = new File(lModelFilePath);
      String lProfileFilePath = lXMIDirectory + "/" + umlProfileFile;
      File lProfileFile = new File(lProfileFilePath);

      // File with UML model does not exist.
      if (lModelFile.exists() == false) {
        throw new MojoFailureException("UML Model file " + lModelFilePath
            + " does not exist. Please make sure that the path to the UML model file is correct.");
      }
      // File with UML profile does not exist.
      else if (lProfileFile.exists() == false) {
        throw new MojoFailureException("UML profile file " + lProfileFilePath
            + " does not exist. Please make sure that the path to the UML profile file is correct.");
      }
      // Model file and profile file both exist, so we can really start the generation process.
      else {
        // Build arguments for generator
        HashMap<String, String> lParams = new HashMap<>();
        lParams.put("template.root", "Root::Root");
        lParams.put("custom.root.template", customRootTemplate);
        lParams.put("output.slot", "model");
        lParams.put("model.file", lModelFilePath);
        lParams.put("profile.file", lProfileFilePath);
        lParams.put("profile.name", "JMM");
        lParams.put("path.src.gen", sourceGenDirectory);
        lParams.put("path.src", sourceDirectory);
        lParams.put("path.res.gen", resourceGenDirectory);
        lParams.put("path.res", resourceDirectory);

        // Execute oAW Workflow Runner. This will cause the UML generation to be executed.
        this.getLog().info("Starting code generation from UML model " + umlModelFile);
        WorkflowRunner lRunner = new WorkflowRunner();
        lSuccessful = lRunner.run("workflow.oaw", null, lParams, null);
      }
    }
    else {
      lSuccessful = true;
    }
    return lSuccessful;
  }

  private void prepareXMIFiles( ) throws MojoFailureException {
    Stopwatch lStopwatch = Tools.getPerformanceTools().createStopwatch("XMI file preparation", TimePrecision.MILLIS);
    lStopwatch.start();

    // Copy XMI files to working directory.
    String lXMIFiles = this.copyXMIFiles();

    // Resolve all UML files in XMI directory
    FileTools lFileTools = Tools.getFileTools();
    List<String> lExtensions = new ArrayList<>();
    lExtensions.add("*.uml");
    List<String> lUMLFiles = lFileTools.listFiles(lXMIFiles, lFileTools.createExtensionFilenameFilter(lExtensions));

    // Fix all XMI files
    if (umlModellingTool != ModelingTool.MAGIC_DRAW) {
      this.getLog().info("Preparing XMI files to be processed by JEAF Generator");
      String lCurrentFile = null;
      try {
        for (String lNextFileName : lUMLFiles) {
          lCurrentFile = lNextFileName;
          Path lNextFile = Paths.get(lNextFileName);
          Stream<String> lLines = Files.lines(lNextFile);
          List<String> lReplacement =
              lLines.map(line -> line.replaceAll("xmlns:uml=\"http://www.eclipse.org/uml2/5.0.0/UML\"",
                  "xmlns:uml=\"http://www.eclipse.org/uml2/2.0.0/UML\"")).collect(Collectors.toList());
          lReplacement = lReplacement.stream()
              .map(line -> line.replaceAll("xmlns:standard=\"http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard\"",
                  "xmlns:standard=\"http://www.eclipse.org/uml2/schemas/Standard/1\""))
              .collect(Collectors.toList());
          Files.write(lNextFile, lReplacement);
          lLines.close();
        }
      }
      catch (IOException e) {
        throw new MojoFailureException("Unable to process XMI file" + lCurrentFile, e);
      }
    }
    lStopwatch.stop();
    if (umlModellingTool != ModelingTool.MAGIC_DRAW) {
      this.getLog().info("XMI file preparation took " + lStopwatch.getResult().getDuration() + "ms");
    }
  }

  /**
   * Method resolves the XMI directory from the Mojo configuration. This XMI directory can either be defined directly or
   * by naming an artifact that contains all required xmi files.
   * 
   * @return
   * @throws MojoFailureException
   */
  private String getXMIDirectoryLocation( ) throws MojoFailureException {
    // XMI directory is defined directly.
    String lExtractDirectory = project.getBuild().getDirectory() + "/uml-model";
    String lXMIDirectory;
    StringTools lTools = Tools.getStringTools();
    if (lTools.isRealString(xmiDirectory)) {
      if (umlModellingTool == ModelingTool.MAGIC_DRAW) {
        lXMIDirectory = xmiDirectory;
      }
      else {
        lXMIDirectory = lExtractDirectory;
      }
    }
    // Try to find XMI files inside artifact
    else if (lTools.isRealString(modelArtifactGroupID) && lTools.isRealString(modelArtifactArtifactID)) {
      if (lTools.isRealString(modelArtifactXMIPath)) {
        lXMIDirectory = lExtractDirectory + "/" + modelArtifactXMIPath;
      }
      else {
        lXMIDirectory = lExtractDirectory;
      }
    }
    // Neither XMI directory is defined directly nor through Maven artifact.
    else {
      throw new MojoFailureException(
          "Path to UML model (XMI) is neither defined as direct directory (config parameter 'xmiDirectory') nor through a Maven artifact (config parameters 'modelArtifactXXX'.");
    }
    return lXMIDirectory;
  }

  /**
   * Method resolves the XMI directory from the Mojo configuration. This XMI directory can either be defined directly or
   * by naming an artifact that contains all required xmi files.
   * 
   * @return
   * @throws MojoFailureException
   */
  private String copyXMIFiles( ) throws MojoFailureException {
    // XMI directory is defined directly.
    StringTools lTools = Tools.getStringTools();
    String lXMIDirectoryPath;

    if (lTools.isRealString(xmiDirectory)) {
      // Delete may be existing directory with XMI files.
      lXMIDirectoryPath = this.getXMIDirectoryLocation();

      // In case that UML Modeling Tool is not MagicDraw UML then XMI files need to be manipulated before they can be
      // processed. Thar's why we need to copy them first.
      if (umlModellingTool != ModelingTool.MAGIC_DRAW) {
        FileTools lFileTools = Tools.getFileTools();
        lFileTools.tryDeleteRecursive(lXMIDirectoryPath, true);

        File lXMIDirectory = new File(lXMIDirectoryPath);
        lFileTools.createDirectory(lXMIDirectory);

        List<String> lExtensions = new ArrayList<>();
        lExtensions.add("*.uml");
        List<String> lUMLFiles =
            lFileTools.listFiles(xmiDirectory, lFileTools.createExtensionFilenameFilter(lExtensions));

        try {
          for (String lFile : lUMLFiles) {
            File lSourceFile = new File(lFile);
            lFileTools.copyFile(lSourceFile, new File(lXMIDirectoryPath, lSourceFile.getName()));
          }
        }
        catch (IOException e) {
          throw new MojoFailureException("Unable to copy XMI files to working directory.", e);
        }
      }
    }
    // Try to find XMI files inside artifact
    else if (lTools.isRealString(modelArtifactGroupID) && lTools.isRealString(modelArtifactArtifactID)) {
      String lKey = modelArtifactGroupID + ":" + modelArtifactArtifactID;
      try {
        // Lookup maven module that contains UML model
        Artifact lModelArtifact = project.getArtifactMap().get(lKey);
        if (lModelArtifact != null) {
          Assert.assertNotNull(lModelArtifact, "Model artifact not availble.");
          String lFilePath = lModelArtifact.getFile().getCanonicalPath();
          String lExtractDirectory = project.getBuild().getDirectory() + "/uml-model";
          this.getLog().info("Extracting UML model files from Maven Artifact " + lFilePath + " to directory "
              + lExtractDirectory + ".");
          Tools.getFileTools().extractZipFile(lFilePath, lExtractDirectory, Long.MAX_VALUE);
          if (lTools.isRealString(modelArtifactXMIPath)) {
            lXMIDirectoryPath = lExtractDirectory + "/" + modelArtifactXMIPath;
          }
          else {
            lXMIDirectoryPath = lExtractDirectory;
          }
        }
        // Lookup for Maven dependency failed.
        else {
          throw new MojoFailureException("Unable to resolve XMI files from artifact " + lKey
              + ". Maven artifact is not available.Please check configuration of JEAF Generator Plugin.");
        }
      }
      catch (IOException e) {
        throw new MojoFailureException("Unable to resolve and extract XMI files from artifact " + lKey, e);
      }
    }
    // Neither XMI directory is defined directly nor through Maven artifact.
    else {
      throw new MojoFailureException(
          "Path to UML model (XMI) is neither defined as direct directory (config parameter 'xmiDirectory') nor through a Maven artifact (config parameters 'modelArtifactXXX'.");
    }
    this.getLog().debug("XMI Working Directory: " + lXMIDirectoryPath);
    return lXMIDirectoryPath;
  }

  private boolean isUMLGenerationRequested( ) {
    return generateCustomConstraints | generateServiceInterfaces | generateServiceProxies
        | generateServiceProviderInterfaces | generateServiceProviderImpls | generateRESTResources
        | generateActivityInterfaces | generateActivityImpls | generateServiceObjects | generatePOJOs
        | generateDomainObjects | generateObjectMappers | generatePersistentObjects | generateComponentImpls
        | generateComponentRuntimeClasses | generateGlobalParts | generateExceptionClasses | generateJUnitTests
        | generateOpenAPISpec;
  }

  private boolean isMessageConstantsGenerationRequested( ) {
    return generateMessageConstants;
  }

  private boolean isGenerationRequested( ) {
    return this.isUMLGenerationRequested() | this.isMessageConstantsGenerationRequested();
  }

  private void runMessageConstantsGenerator( ) throws MojoFailureException {
    if (generateMessageConstants == true) {
      // First we convert existing Excel workbooks containing messages afterwards we will generate message constants.
      this.generateMessageResourceFiles();
      this.generateMessageClasses();
    }
  }

  private void generateMessageResourceFiles( ) throws MojoFailureException {
    XFun.getTrace().info("");
    XFun.getTrace().info("Transforming Excel files with message definitions to XML representation.");

    // Determine output directory and check if it is valid.
    File lOutputDirectory = new File(resourceGenDirectory);
    if (lOutputDirectory.isDirectory() == true) {
      // Resolve all input files.
      List<String> lResourceFiles = this.resolveResourceFiles(resourceDirectory, ".xlsx", ignoredResourceFiles);

      // Generate resource files.
      if (lResourceFiles.isEmpty() == false) {
        ExcelToMessageResourceConverter lConverter = new ExcelToMessageResourceConverter();
        for (String lFileName : lResourceFiles) {
          String lBaseName = Tools.getFileTools().getBaseName(new File(lFileName));

          // In order top avoid problems during generation we have to ignore temporary Excel files that also endup
          // with *.xlsx.
          if (lBaseName.startsWith("~$") == false) {
            try {
              String lOutputFileName = resourceGenDirectory + "/" + lBaseName + ".xml";
              Trace lTrace = XFun.getTrace();
              lTrace.info("Converting Excel file " + lFileName + " to XML message resource " + lOutputFileName);
              ConversionResult lResult = lConverter.generateMessageResource(lFileName);

              // Trace result of conversion.
              VerificationResult lVerificationResult = lResult.getVerificationResult();
              String lMessage = lVerificationResult.getMessage();
              if (lVerificationResult.containsErrors()) {
                lTrace.error(lMessage);
              }
              else if (lVerificationResult.containsWarnings()) {
                lTrace.warn(lMessage);
              }
              else {
                lTrace.info(lMessage);
              }

              // Generate file name for message resource.
              if (lVerificationResult.containsErrors() == false) {
                Builder lProperties = DocumentProperties.Builder.newBuilder();
                lProperties.setDoctypePublic("MessageData");
                lProperties.setDoctypeSystem("MessageData.dtd");
                try (FileOutputStream lOutputStream = new FileOutputStream(lOutputFileName, false);) {
                  Tools.getXMLTools().writeDocument(lResult.getDocument(), lProperties.build(), lOutputStream);
                }
              }
              else {
                throw new MojoFailureException("Message resource file '" + lOutputFileName
                    + "' will not be written due to the errors in the source Excel file. For further details please refer to plugin output above.");
              }
            }
            catch (IOException e) {
              e.printStackTrace();
            }
            catch (RuntimeException e) {
              e.printStackTrace();
            }
          }
          // Ignore temporary Excel file.
          else {
            // Nothing to do
          }
        }
      }
      else {
        XFun.getTrace().info("Skipping transformation of Excel files as none were found.");
      }
    }
    // sourceGenDirectory is no a valid output directory.
    else {
      String lMessage = "'" + resourceGenDirectory + "' is not a valid output directory.";
      XFun.getTrace().info(lMessage);
    }
  }

  private void generateMessageClasses( ) {
    XFun.getTrace().info("");
    XFun.getTrace().info("Generating message constants classes");

    // Determine output directory and check if it is valid.
    File lOutputDirectory = new File(sourceGenDirectory);
    if (lOutputDirectory.isDirectory() == true) {
      // Resolve all input files.

      List<String> lResourceFiles = new ArrayList<>(0);
      lResourceFiles.addAll(this.resolveResourceFiles(resourceDirectory, ".xml", ignoredResourceFiles));
      lResourceFiles.addAll(this.resolveResourceFiles(resourceGenDirectory, ".xml", ignoredResourceFiles));

      // Create new instance of message constants generator.
      MessageConstantsGenerator lGenerator = new MessageConstantsGenerator();

      // Generate all classes.
      for (String lFileName : lResourceFiles) {
        try {
          // Print status message
          lFileName = new File(lFileName).getCanonicalPath();
          XFun.getTrace().info("Generating class for message resource '" + lFileName + "'.");

          // Try to generate class
          lGenerator.generateMessageClass(lFileName, lOutputDirectory.getCanonicalPath());
        }
        // Exception during generation
        catch (IOException e) {
          XFun.getTrace().info("Exception during generation.");
          e.printStackTrace(System.out);
        }
        catch (ApplicationException e) {
          XFun.getTrace().info("Exception during generation.");
          e.printStackTrace(System.out);
        }
        finally {
          // Insert new line.
          XFun.getTrace().info("");
        }
      }
    }
    // sourceGenDirectory is no a valid output directory.
    else {
      String lMessage = "'" + sourceGenDirectory + "' is not a valid output directory.";
      XFun.getTrace().info(lMessage);
    }
  }

  private List<String> resolveResourceFiles( String pResourceLocationPath, String pFileExtension,
      List<String> pExclusionList ) {

    // Check parameters.
    Assert.assertNotNull(pResourceLocationPath, "pResourceLocationPath");
    Assert.assertNotNull(pFileExtension, "pFileExtension");

    // Get all XML files from the directory.
    List<String> lResourceFiles;
    File lMessageResourceLocation = new File(pResourceLocationPath);
    if (lMessageResourceLocation.exists() == true) {
      if (lMessageResourceLocation.isDirectory() == true) {
        // Create FileFilter and determine resource files that should be used.
        List<String> lExtensions = new ArrayList<String>();
        lExtensions.add(pFileExtension);
        FilenameFilter lFileFilter = Tools.getFileTools().createExtensionFilenameFilter(lExtensions, pExclusionList);
        File[] lFiles = lMessageResourceLocation.listFiles(lFileFilter);

        if (lFiles != null) {
          lResourceFiles = new ArrayList<String>(lFiles.length);

          // Add absolute location of files to Collection with resource files.
          for (int i = 0; i < lFiles.length; i++) {
            lResourceFiles.add(lFiles[i].getAbsolutePath());
          }
        }
        else {
          lResourceFiles = Collections.emptyList();
        }
      }
      // Only single resource file was provided.
      else {
        lResourceFiles = new ArrayList<String>(1);
        lResourceFiles.add(pResourceLocationPath);
      }
    }
    // Resource directory does not exist. This might happen e.g. in case of Git where empty directories are not checked
    // in.
    else {
      lResourceFiles = Collections.emptyList();
    }
    return lResourceFiles;
  }

  /**
   * Method takes care that the generated source code will be formatted according to the configuration of this plugin.
   * 
   * @throws MojoExecutionException
   */
  private void runFormatter( ) throws MojoExecutionException {
    if (disableFormatting == true || (disableSourceFormatting == true && disableResourceFormatting == true)) {
      this.getLog().info(
          "Skipping formatting of generated sources and resources as it is disabled in the plugin configuration.");
    }
    else {
      this.executeImportBeautifierPlugin();
      this.executeImportSorterPlugin();
      this.executeFormatterPlugin();
    }
  }

  /**
   * Method runs the code formatter plugin
   * 
   * @throws MojoExecutionException
   */
  private void executeImportBeautifierPlugin( ) throws MojoExecutionException {
    if (disableFormatting == true || disableSourceFormatting == true) {
      this.getLog().info("Skipping beautification of imports as it is disbale in the plugin configuration.");
    }
    else {
      this.getLog().info("Beautifying imports.");

      // Execute Maven plugin to format sources.
      List<Dependency> lDependencies = MojoExecutor.dependencies(MojoExecutor.dependency("com.anaptecs.jeaf.generator",
          "jeaf-generator-maven-plugin", XFun.getVersionInfo().getVersionString()));
      Plugin lBeautifierPlugin =
          plugin("org.andromda.maven.plugins", "andromda-beautifier-plugin", "3.4", lDependencies);
      String lBeautifierGoal = goal("beautify-imports");
      Xpp3Dom lFormatterConfiguration = configuration(element("inputDirectory", sourceGenDirectory));

      ExecutionEnvironment lExecutionEnvironment = executionEnvironment(mavenProject, mavenSession, pluginManager);
      executeMojo(lBeautifierPlugin, lBeautifierGoal, lFormatterConfiguration, lExecutionEnvironment);
    }
  }

  /**
   * Method runs the code formatter plugin
   * 
   * @throws MojoExecutionException
   */
  private void executeFormatterPlugin( ) throws MojoExecutionException {
    if (disableFormatting == true || disableSourceFormatting == true) {
      this.getLog().info("Skipping formatting of generated source files as it is disbale in the plugin configuration.");
    }
    else {
      this.getLog().info("Formatting generated code.");
      // Execute Maven plugin to format sources.
      List<Dependency> lDependencies = MojoExecutor.dependencies(MojoExecutor.dependency("com.anaptecs.jeaf.generator",
          "jeaf-generator-code-styles", XFun.getVersionInfo().getVersionString()));
      Plugin lFormatterPlugin = plugin("net.revelc.code.formatter", "formatter-maven-plugin", "2.16.0", lDependencies);
      String lFormatterGoal = goal("format");
      Xpp3Dom lFormatterConfiguration = configuration(element("configFile", javaFormatterStyleFile),
          element("configXmlFile", xmlFormatterStyleFile), this.createDirectoryElementConfiguration());

      ExecutionEnvironment lExecutionEnvironment = executionEnvironment(mavenProject, mavenSession, pluginManager);
      executeMojo(lFormatterPlugin, lFormatterGoal, lFormatterConfiguration, lExecutionEnvironment);
    }
  }

  /**
   * Method executes the Maven plugin that organizes imports.
   * 
   * @throws MojoExecutionException
   */
  private void executeImportSorterPlugin( ) throws MojoExecutionException {
    this.getLog().info("Sorting imports.");
    Plugin lFormatterPlugin = plugin("net.revelc.code", "impsort-maven-plugin", "1.2.0");
    String lFormatterGoal = goal("sort");
    Xpp3Dom lFormatterConfiguration =
        configuration(element("groups", importGroups), element("staticGroups", staticImportGroups),
            element("removeUnused", Boolean.toString(removeUnusedImports)), this.createDirectoryElementConfiguration());

    ExecutionEnvironment lExecutionEnvironment = executionEnvironment(mavenProject, mavenSession, pluginManager);
    executeMojo(lFormatterPlugin, lFormatterGoal, lFormatterConfiguration, lExecutionEnvironment);
  }

  /**
   * Method creates the directory configuration for called Maven plugins depending on the configured formatter settings.
   * 
   * @return {@link Element} Configuration element for the directories that should be formatted.
   */
  private Element createDirectoryElementConfiguration( ) {
    Element lElement;
    if (disableSourceFormatting == false && disableResourceFormatting == false) {
      lElement =
          element("directories", element("directory", sourceGenDirectory), element("directory", resourceGenDirectory));
    }
    else if (disableSourceFormatting == true) {
      lElement = element("directories", element("directory", resourceGenDirectory));
    }
    else if (disableResourceFormatting == true) {
      lElement = element("directories", element("directory", sourceGenDirectory));
    }
    else {
      lElement = null;
      Assert.internalError("Method must not be called if formatting is disabled completely.");
    }
    return lElement;
  }
}
