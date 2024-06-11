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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
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

import com.anaptecs.jeaf.fwk.generator.util.EnterpriseJavaType;
import com.anaptecs.jeaf.fwk.generator.util.ModelingTool;
import com.anaptecs.jeaf.fwk.generator.util.OpenAPIVersion;
import com.anaptecs.jeaf.fwk.generator.util.RESTLibrary;
import com.anaptecs.jeaf.fwk.generator.util.ReportFormat;
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

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

@Mojo(
    name = "Generator",
    defaultPhase = LifecyclePhase.NONE,
    threadSafe = true,
    requiresDependencyResolution = ResolutionScope.TEST)

public class GeneratorMojo extends AbstractMojo {
  private static final String DEFAULT_CUSTOM_ROOT = "CustomRoot::Root";

  /**
   * Reference to Maven project. Reference will be injected by Maven and can not be configured via POM.
   */
  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject mavenProject;

  @Parameter(defaultValue = "${session}", readonly = true)
  private MavenSession mavenSession;

  /**
   * UML Modeling Tool that was used to create the UML Model. By default it is assumed that MagicDraw UML was used.
   * 
   * Supported values are (case sensitive): MAGIC_DRAW, ECLIPSE_PAPYRUS, OTHER
   */
  @Parameter(required = false, defaultValue = "MAGIC_DRAW")
  private ModelingTool umlModelingTool;

  /**
   * Parameter defines the type of Enterprise Java that should be used for code generation. By default JavaEE (aka JEE)
   * is used.
   * 
   * Supported values are: JAVA_EE, JAKARTA_EE
   */
  @Parameter(required = false, defaultValue = "JAVA_EE")
  private EnterpriseJavaType enterpriseJavaType;

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
   * Name of the file that contains the JEAF Generator Metamodel (JMM). Usually the default value "JMM.profile.uml" can
   * be used. Only the name of the file has to be provided as we assume that the file is located in the XMI directory.
   */
  @Parameter(required = false, defaultValue = "JMM.profile.uml")
  private String jmmProfileFile;

  /**
   * In addition to standard profile of JEAF Generator it is also possible to add a custom profile that contains your
   * own stereotypes.
   */
  @Parameter(required = false)
  private String customProfileFile;

  /**
   * Name of the root template for customer specific extensions
   */
  @Parameter(required = false, defaultValue = DEFAULT_CUSTOM_ROOT)
  private String customRootTemplate;

  /**
   * Element can be used to pass parameters to custom templates as key value pairs. The parameters are available for the
   * template as system properties.
   */
  @Parameter(required = false)
  private Map<String, String> customTemplateParameters;

  /**
   * By default custom templates are only executed in case that also default templates are executed. Using this switch
   * is it also possible to only execute custom templates.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean enforceCustomTemplateExecution;

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
   * Directory where all files that belong to the "src-test" directory will be written to.
   */
  @Parameter(required = false)
  private String sourceTestDirectory;

  /**
   * Directory where all files that belong to the "src-test-gen" directory will be written to.
   */
  @Parameter(required = false)
  private String sourceTestGenDirectory;

  /**
   * Parameter defines if src-test-gen directory should be cleaned before the generator runs. Cleaning means that all
   * existing files will be deleted. Cleaning src-gen directory is the proposed way to go.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean cleanSourceTestGen;

  /**
   * Directory where all files that belong to the "res-test" directory will be written to.
   */
  @Parameter(required = false)
  private String resourceTestDirectory;

  /**
   * Directory where all files that belong to the "res-test-gen" directory will be written to.
   */
  @Parameter(required = false)
  private String resourceTestGenDirectory;

  /**
   * Parameter defines if res-test-gen directory should be cleaned before the generator runs. Cleaning means that all
   * existing files will be deleted. Cleaning res-gen directory is the proposed way to go.
   */
  @Parameter(required = false, defaultValue = "false")
  private boolean cleanResourceTestGen;

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
   * Switch defines if target runtime specific security annotations (e.g. @RolesAllowed from JSR-250 or @PreAuthorize
   * from Spring Security) should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateSecurityAnnotation;

  /**
   * Switch defines if in case of Spring deprecated @Secured annotation should be used instead of
   * recommended @PreAuthorize.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean useDeprecatedSpringSecuredAnnotation;

  /**
   * Switch defines if request validation for REST Resources / Controllers or REST Clients (aka REST Service Proxies)
   * should be generated. If it is enabled then the generated code will have a dependency on one of the following
   * artifacts:
   * <p/>
   * <b>Spring Boot:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-spring&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * <b>JEAF:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-service-provider&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * Depending on the implementation of class <code>com.anaptecs.jeaf.validation.api.ValidationExecutor</code> if might
   * still be possible to disable / enable request validation without changing the code.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTRequestValidation;

  /**
   * Switch defines if request validation for REST Resources / Controllers or REST Clients (aka REST Service Proxies)
   * should be generated. If it is enabled then the generated code will have a dependency on one of the following
   * artifacts:
   * <p/>
   * <b>Spring Boot:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-spring&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * <b>JEAF:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-service-provider&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * Depending on the implementation of class <code>com.anaptecs.jeaf.validation.api.ValidationExecutor</code> if might
   * still be possible to disable / enable response validation without changing the code.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTResponseValidation;

  /**
   * Switch defines whether custom headers of a REST resource should be filtered or not. Default is <code>true</code>.
   * If custom header filtering is defined then a {@link com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter} has to
   * be provided via configuration.
   * 
   * It's strongly recommended to not use custom headers at all. However, if needed then at least they should be
   * filtered.
   */
  @Parameter(required = false, defaultValue = "true")
  private Boolean filterCustomHeaders = Boolean.TRUE;

  /**
   * Parameter defines the prefix that should be used for REST paths of generated REST resources / controllers. The
   * value provided here will be used as prefix. To be a valid path it has to start with '/' and must not end with '/'.
   */
  @Parameter(required = false)
  private String restPathPrefix = "";

  /**
   * Switch defines whether REST service proxies should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTServiceProxies;

  /**
   * Switch defines whether a default config file for REST service proxies should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTServiceProxyConfigFile;

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
   * Switch defines if <code>equals()</code> and <code>hashCode()</code> should be generated for all kinds of POJOs and
   * ServiceObjects.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateEqualsAndHashCode;

  /**
   * Switch defines if <code>equals()</code> and <code>hashCode()</code> should be generated for "normal" POJOs and
   * ServiceObjects.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateEqualsAndHashCodeForStandardClasses;

  /**
   * Switch defines if <code>equals()</code> and <code>hashCode()</code> should be generated for composite data type
   * POJOs and ServiceObjects.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateEqualsAndHashCodeForCompositeDataTypes;

  /**
   * Switch defines if <code>equals()</code> and <code>hashCode()</code> should be generated for OpenAPI data type POJOs
   * and ServiceObjects.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateEqualsAndHashCodeForOpenAPIDataTypes;

  /**
   * Switch defines whether POJO's should be serializable or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean makePOJOsSerializable;

  /**
   * Switch defines whether generated POJO's and / or ServiceObjects should be immutable. This switch is set to true
   * then it will overrule settings from the UML model.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateImmutableClasses;

  /**
   * Switch defines if extensible enums should be generated in light-weight or heavy-weight style.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateHeavyExtensibleEnums;

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
   * Switch enables the generation of a model types report about the model parts which are configured to be processed.
   * Types report is based an model elements that are tagged with the configured stereotypes
   * {@link #typesReportStereotypes}.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateTypesReport;

  /**
   * Title of the types report.
   */
  @Parameter(required = false, defaultValue = "Model Types")
  private String typesReportName;

  /**
   * Name of the file that contains the types report. The file extension will be chosen based on the report format.
   */
  @Parameter(required = false, defaultValue = "Model_Types")
  private String typesReportFileName;

  /**
   * Name of the stereotypes that should be considered when creating types report. Multiple stereotypes have to be
   * separated using ';'.
   */
  @Parameter(required = false)
  private String typesReportStereotypes = "";

  /**
   * Switch defines if within the types report also a row for alias names should be added.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean typesReportShowAlias;

  /**
   * Switch defines the name of the alias row.
   */
  @Parameter(required = false, defaultValue = "Alias")
  private String typesReportAliasRowName;

  /**
   * Switch defines if for types report also the package of every type should be shown.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean typesReportShowPackage;

  /**
   * Switch defines if for types report also properties of every type should be added.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean typesReportShowProperties;

  /**
   * Switch defines if for types report content should be grouped by package.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean typesReportGroupByPackage;

  /**
   * Switch enables the generation of a breaking changes report about the model parts which are configured to be
   * processed. Breaking changes report is based an model elements that are tagged with stereotype "BreakingChange".
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateBreakingChangesReport;

  /**
   * Title of the breaking changes report.
   */
  @Parameter(required = false, defaultValue = "Planned Breaking Changes")
  private String breakingChangesReportName;

  /**
   * Name of the file that contains the breaking changes report. The file extension will be chosen based on the report
   * format.
   */
  @Parameter(required = false, defaultValue = "Breaking_Changes")
  private String breakingChangesReportFileName;

  /**
   * Switch defines if for breaking changes report content should be grouped by package.
   */
  @Parameter(required = false, defaultValue = "true")
  private Boolean breakingChangesReportGroupByPackage;

  /**
   * Switch enables the generation of a REST / OpenAPI deprecation report about the model parts which are configured to
   * be processed.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateRESTDeprecationReport;

  /**
   * Title of the REST deprecation report.
   */
  @Parameter(required = false, defaultValue = "REST Deprecation Report")
  private String restDeprecationReportName;

  /**
   * Name of the file that contains the REST deprecation report. The file extension will be chosen based on the report
   * format.
   */
  @Parameter(required = false, defaultValue = "REST_Deprecation_Report")
  private String restDeprecationReportFileName;

  /**
   * Switch enables the generation of a Java deprecation report about the model parts which are configured to be
   * processed.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJavaDeprecationReport;

  /**
   * Title of the Java deprecation report.
   */
  @Parameter(required = false, defaultValue = "Java Deprecation Report")
  private String javaDeprecationReportName;

  /**
   * Name of the file that contains the Java deprecation report. The file extension will be chosen based on the report
   * format.
   */
  @Parameter(required = false, defaultValue = "Java_Deprecation_Report")
  private String javaDeprecationReportFileName;

  /**
   * Parameter defines the format of the deprecation report. Supported formats are <code>MARKDOWN</code>,
   * <code>HTML</code> and <code>XML</code>.
   */
  @Parameter(required = false, defaultValue = "MARKDOWN")
  private ReportFormat deprecationReportFormat;

  /**
   * Switch enables the generation of a security roles report about the model parts which are configured to be
   * processed.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateSecurityRolesReport;

  /**
   * Title of the security roles report.
   */
  @Parameter(required = false, defaultValue = "Security Roles Report")
  private String securityRolesReportName;

  /**
   * Name of the file that contains the security roles report. The file extension will be chosen based on the report
   * format.
   */
  @Parameter(required = false, defaultValue = "Security_Roles_Report")
  private String securityRolesReportFileName;

  /**
   * Parameter defines the format of the security roles report. Supported formats are <code>MARKDOWN</code>,
   * <code>HTML</code> and <code>XML</code>.
   */
  @Parameter(required = false, defaultValue = "MARKDOWN")
  private ReportFormat securityRolesReportFormat;

  /**
   * Switch defines whether an OpenAPI specification should be generated or not.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateOpenAPISpec;

  /**
   * By default JEAF Generator runs a dependency check for OpenAPI specifications to ensure that all types that are
   * referenced from another OpenAPI spec can be resolved. If you want to disable these checks for whatever reason you
   * can set this switch to <code>true</code>.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean disableOpenAPIDependencyChecks;

  /**
   * Switch defines if a generated OpenAPI specification should be validated.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean validateOpenAPISpec;

  /**
   * Parameter defines which OpenAPI version is used when generating OpenAPI specifications. As there are breaking
   * changes between OpenAPI 3.0 and 3.1 unfortunately it is required to define that as part of the Maven build.
   * Depending on the OpenAPI version different checks on the model have to be applied. <br>
   * <br>
   * Breaking changes between OpenAPI 3.0 and 3.1 are described here:
   * <a href="https://www.openapis.org/blog/2021/02/16/migrating-from-openapi-3-0-to-3-1-0"> Migrating from OpenAPI 3.0
   * to 3.1.0</a>
   */
  @Parameter(required = false)
  private OpenAPIVersion openAPIVersion = OpenAPIVersion.OPEN_API_3_1;

  @Parameter(required = false, defaultValue = "*.yaml,*.yml")
  private List<String> openAPIExtensions = new ArrayList<>();

  @Parameter(required = false)
  private List<Dependency> openAPISpecDependencies = new ArrayList<>();

  /**
   * Switch defines whether YAML 1.1 compatibility mode for OpenAPI should be enabled. In YAML 1.1 there is a big
   * difference compared to YAML 1.2 when it comes to boolean values. In YAML 1.1 besides <code>true</code> and
   * <code>false</code> also <code>yes</code>, <code>no</code>, <code>y</code>, <code>n</code>, <code>on</code> and
   * <code>off</code> are treated as boolean values. This might lead to ugly situation when tools or applications are
   * still working with YAML 1.1 based parsers. To prevent such trouble it is possible to tell JEAF generator that in
   * such cases these values should be quoted.
   * 
   * @see <a href=
   * "https://stackoverflow.com/questions/61157594/why-does-swagger-codegen-convert-an-on-off-string-enum-to-true-false">https://stackoverflow.com/questions/61157594/why-does-swagger-codegen-convert-an-on-off-string-enum-to-true-false<a/>
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean enableYAML11Compatibility;

  /**
   * Configuration parameter allows to define the YAML multi line comment style that is used within the generated
   * OpenAPI specification. For further information about the various options please refer to:
   * <a href="https://yaml-multiline.info/">https://yaml-multiline.info/</a> <br/>
   * <br/>
   * By default <code>'|'</code> is used which means that new lines will be kept and that there will be a single new
   * line at the end of each comment.
   * 
   * @see <a href="https://yaml-multiline.info/">https://yaml-multiline.info/</a>
   */
  @Parameter(required = false, defaultValue = "|")
  private String openAPICommentStyle;

  /**
   * Switch can be used to suppress technical http headers in generated Java code.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean suppressTechnicalHeaders;

  /**
   * Configuration parameter can be used to define the OpenAPI contact name. The provided value will only be used if
   * none is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPIContactName = "";

  /**
   * Configuration parameter can be used to define the OpenAPI contact URL. The provided value will only be used if none
   * is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPIContactURL = "";

  /**
   * Configuration parameter can be used to define the OpenAPI contact email. The provided value will only be used if
   * none is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPIContactEmail = "";

  /**
   * Configuration parameter can be used to define the OpenAPI license name. The provided value will only be used if
   * none is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPILicenseName = "";

  /**
   * Configuration parameter can be used to define the OpenAPI license URL. The provided value will only be used if none
   * is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPILicenseURL = "";

  /**
   * Configuration parameter can be used to define the OpenAPI terms of use URL. The provided value will only be used if
   * none is explicitly defined in the UML model.
   */
  @Parameter(required = false)
  private String openAPITermsOfUseURL = "";

  /**
   * OpenAPI standard defines that for whatever reason some header fields should not be mentioned in the OpenAPI
   * specification e.g. 'Authorization' header. However from an overall perspective it still might make sense to
   * explicitly show the for better documentation purposes. This can be done by setting this property to
   * <code>true</code>
   * 
   * @see <a href=
   * "https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#parameterObject">https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#parameterObject</>
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean addIgnoredHeadersToOpenAPISpec;

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
   * Switch is used to generate @JsonAutoDetect annotation directly on generated classes. This annotation is required
   * for proper JSON serialization of POJOs and ServiceObjects. However, by default it is assumed that this
   * configuration is done on the Jackson ObjectMapperFactory. If you prefer to have it directly on the generated
   * classes for whatever reason then you need to set this parameter to <code>true</code>.
   * 
   * This switch only is active in combination with {@link #generateJacksonAnnotations}.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateJSONAutoDetectAnnotationOnClass;

  /**
   * Switch defines if Java Validation Annotation @Valid will be generated for all generated POJO, ServiceObjects,
   * DomainObject and PersistentObjects even in cases when it is not defined in the UML model.
   */
  @Deprecated
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValidAnnotationForClasses;

  /**
   * Switch defines if Java Validation Annotation @Valid will be generated for all references to POJOs, ServiceObjects,
   * DomainObjects and PersistentObjects even in cases when it is not defined in the UML model.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValidAnnotationForAssociations;

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
   * Switch defines if object validation should be generated in build() operation of the class builder. If it is enabled
   * then the generated code will have a dependency on one of the following artifacts:
   * <p/>
   * <b>Spring Boot:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-spring&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * <b>JEAF:</b>
   * 
   * <pre>
   *    &#60;dependency>
   *        &#60;groupId>com.anaptecs.jeaf.validation&#60;/groupId>
   *        &#60;artifactId>jeaf-validation-api-service-provider&#60;/artifactId>
   *        &#60;version>${1.6.0 or higher}&#60;/version>
   *    &#60;/dependency><br/>
   * </pre>
   * 
   * Depending on the implementation of class <code>com.anaptecs.jeaf.validation.api.ValidationExecutor</code> if might
   * still be possible to disable / enable request validation without changing the code.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateObjectValidationInBuilder;

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
   * When working with soft links in your UML model then you can define there that a custom generic type should be used
   * for the soft link. The concrete java type (its fully qualified class name) that should be used can be defined
   * through this parameter.
   */
  @Parameter(required = false)
  private String javaGenericSoftLinkType = "";

  /**
   * When working with soft links in your UML model then you can define there that a custom generic type should be used
   * for the soft link. The concrete OpenAPI type that should be used can be defined through this parameter.
   * <p/>
   * In case that the parameter is not defined then it is assumed that the softlink is a string type in OpenAPI.
   * <p/>
   * In case that the type is defined within the same OpenAPI spec then local naming should be used. If type is defined
   * within another OpenAPI spec the standard naming for external types should be used.
   * <p/>
   * <b>Examples:</b>
   * <li><code>#/components/schemas/Softlink</code></li>
   * <li><code>../base/product-base.yml#/components/schemas/Softlink</code></li>
   */
  @Parameter(required = false)
  private String openAPIGenericSoftLinkType = "";

  /**
   * When working with soft links it might be a requirement to append a suffix to the name of a property from the UML
   * model. This can be done using this configuration parameter.
   */
  @Parameter(required = false)
  private String softLinkSuffix = "";

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
   * REST Library that is the target for code generation. Depending on the target runtime either JAX-RS (Java and JEAF)
   * or SPRING_WEB_MVC (Spring) is used as default.
   * 
   * Supported values are (case sensitive): JAX_RS, SPRING_WEB_MVC
   */
  @Parameter(required = false)
  private RESTLibrary restLibrary;

  /**
   * Parameter can be used to define the default http status code that should be used when REST requests are successful.
   * By default 200 ("OK") is used. This value will only be used if there is no explicit status code defined on the
   * RESTOperation.
   */
  @Parameter(required = false, defaultValue = "200")
  private String restDefaultSuccessStatusCode;

  /**
   * Parameter can be used to define the default http status code that should be used when REST requests are successful
   * for operations with return type void. By default 204 ("NO_CONTENT") is used. This value will only be used if there
   * is no explicit status code defined on the RESTOperation.
   */
  @Parameter(required = false, defaultValue = "204")
  private String restDefaultVoidStatusCode;

  /**
   * Switch defines if an <code>of(...)</code> operation should be generated for POJOs or ServiceObjects. This switch
   * does not have any impact on so called OpenAPI Data Type. POJOs / ServiceObjects that are also modeled to be an Data
   * Type will not have an <code>of(...)</code> operation. Instead please use configured parameter
   * {@link #generateOfOperationForOpenAPIDataType}.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateOfOperation;

  /**
   * Switch defines if an <code>of(...)</code> operation should be generated for OpenAPI Data Types. This switch does
   * not have any impact on so standard POJOs / ServiceObjects. For them no <code>of(...)</code> operation will be
   * generated. Instead please use configured parameter {@link #generateOfOperation}.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateOfOperationForOpenAPIDataType;

  /**
   * Switch defines whether for the Java representation of OpenAPI Data Types as valueOf method should be generated or
   * not.
   * 
   * If this is required depends on the framework that is used for your REST implementation. Currently (Spring Boot
   * 2.7.* and Jersey 2.35) it is only required in case of Jersey. Default Spring Boot REST implementation does not
   * require that.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateValueOfForOpenAPIDataTypes;

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
   * Switch defines if only the public view of POJO's or ServiceObjects should be generated. This will lead to generated
   * classes where some internal structures of a POJO / ServiceObject will be hidden to the outside world.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generatePublicObjectView;

  /**
   * Switch defines if arrays should only be generated for primitive types.
   * 
   * By default arrays are generated for every type if it is modeled as property and not as association.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean useArraysOnlyForPrimitives;

  /**
   * Switch defines whether generated methods dealing with any kind of collections must ensure that the internal state
   * of an object can not be modified by accident. This will lead to get method that make use of
   * Collections.unmodifiableCollection(...). Builders that receive a collection as input will copy their content. This
   * is the default behavior of JEAF Generator.
   * 
   * If this parameter is set to <code>true</code> then this means that collections returned from a get method may also
   * be modified from the outside.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean disableImmutabilityOfCollections;

  /**
   * Switch defines whether generated methods dealing with arrays must ensure that the internal state of an object can
   * not be modified by accident. This will lead to System.arraycopy(...) in get methods. Builders that receive an array
   * as input will copy their content. This is the default behavior of JEAF Generator.
   * 
   * If this parameter is set to <code>true</code> then this means that arrays return from get method can directly be
   * modified and this will also impact the state of the object were the array belongs to.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean disableImmutabilityOfArrays;

  /**
   * Switch defines whether generated methods dealing with byte arrays must ensure that the internal state of an object
   * can not be modified by accident. This will lead to System.arraycopy(...) in get methods. Builders that receive an
   * array as input will copy their content. This is the default behavior of JEAF Generator.
   * 
   * If this parameter is set to <code>true</code> then this means that arrays return from get method can directly be
   * modified and this will also impact the state of the object were the array belongs to.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean disableImmutabilityOfBinaryData;

  /**
   * Switch defines if a detailed toString() method should be generated for POJOs, ServiceObjects and DomainObjects.
   * "Detailed" here means that besides the attributes of an class also references to other objects and arrays with be
   * present in result of toString().
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean enableDetailedToStringMethod;

  /**
   * Switch enables the JEAF Generator legacy style for builder pattern in generated code. If the flag is enabled then
   * static builder methods will also be generated on the builder class itself no only on its surrounding class.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean enableLegacyBuilderStyle;

  /**
   * Switch enables that JEAF Generator generates a builder(...) method that directly contains all mandatory fields.
   */
  @Parameter(required = false, defaultValue = "false")
  private Boolean generateBuilderWithAllMandatoryFields;

  /**
   * Switch defines if errors during code generation should break the build. This feature is mainly intended for test
   * purposes of JEAF Generator itself.
   */
  @Parameter(required = false, defaultValue = "true")
  private Boolean breakBuildOnGeneratorError;

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
      this.setDefaults();
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

        // Validate OpenAPI specification
        if (generateOpenAPISpec && validateOpenAPISpec) {
          this.validateOpenAPISpec();
        }
      }
      // Error during code generation from UML model
      else {
        if (breakBuildOnGeneratorError == true) {
          throw new MojoFailureException(
              "Problem occured during code generation from UML model. Please see log output for further details.");
        }
        else {
          this.getLog().error("");
          this.getLog().error("Error(s) during code generation. Please see log output for further details.");
          this.getLog().error(
              "For further information about how to solve them please check: https://anaptecs.atlassian.net/l/cp/5KVHFrW9");
          this.getLog().error("");
        }
      }
    }
    // Nothing should be generated.
    else {
      Log lLog = this.getLog();
      lLog.info("--------------------------------------------------------------------------------------");
      lLog.info("Starting JEAF Generator " + XFun.getVersionInfo().getVersionString());
      lLog.info("Skipping code generation. According to Maven Plugin configuration nothing should be generated.");
      lLog.info("--------------------------------------------------------------------------------------");
    }
  }

  private void setDefaults( ) {
    if (sourceTestDirectory == null) {
      sourceTestDirectory = sourceDirectory;
    }
    if (sourceTestGenDirectory == null) {
      sourceTestGenDirectory = sourceGenDirectory;
    }
    if (resourceTestDirectory == null) {
      resourceTestDirectory = resourceDirectory;
    }
    if (resourceTestGenDirectory == null) {
      resourceTestGenDirectory = resourceGenDirectory;
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
      lLog.info("UML Profile File:                                 " + jmmProfileFile);
      if (customProfileFile != null && customProfileFile.trim().isEmpty() == false) {
        lLog.info("Custom UML Profile File                           " + customProfileFile);
      }
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
    lLog.info("src-test:                                         " + sourceTestDirectory);
    lLog.info("src-test-gen:                                     " + sourceTestGenDirectory);
    lLog.info("res-test:                                         " + resourceTestDirectory);
    lLog.info("res-test-gen:                                     " + resourceTestGenDirectory);

    if (breakBuildOnGeneratorError == false) {
      lLog.warn("");
      lLog.warn(
          "Errors during code generation do not break the build. Please make sure that this is configured intentionally.");
      lLog.warn("");
    }

    if (this.isUMLGenerationRequested() == true) {
      lLog.info(" ");
      lLog.info("UML Modeling Tool:                                " + umlModelingTool.getDisplayName());
      lLog.info("Target Runtime:                                   " + targetRuntime.name());
      lLog.info("Enterprise Java Type:                             " + enterpriseJavaType.name());
    }
    if (restLibrary != null) {
      lLog.info("REST Library:                                     " + restLibrary.name());
    }

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
      lLog.info("Make ServiceObjects immutable:                    " + generateImmutableClasses);

      if (generateHeavyExtensibleEnums) {
        lLog.info("Generate heavy style extensible enums:            " + generateHeavyExtensibleEnums);
      }
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
      lLog.info("Generate of(...):                                 " + generateOfOperation);
      lLog.info("Generate of(...) for OpenAPI Data Types:          " + generateOfOperationForOpenAPIDataType);
      lLog.info("Generate valueOf(...) for OpenAPI Data Types:     " + generateValueOfForOpenAPIDataTypes);
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
      lLog.info("Generate REST Security Annotation:                " + generateSecurityAnnotation);
      if (useDeprecatedSpringSecuredAnnotation) {
        lLog.info("Use deprecated Spring @Secured annotation:        " + useDeprecatedSpringSecuredAnnotation);
      }
      lLog.info("Generate REST Request Validation:                 " + generateRESTRequestValidation);
      lLog.info("Generate REST Response Validation:                " + generateRESTResponseValidation);
    }
    if (filterCustomHeaders == false) {
      lLog.info("Filter custom headers:                            " + filterCustomHeaders);
    }
    if (restPathPrefix.length() > 0) {
      lLog.info("REST Path Prefix:                                 " + restPathPrefix);
    }
    if (generateRESTServiceProxies) {
      lLog.info("Generate REST Service Proxies:                    " + generateRESTServiceProxies);
    }
    if (generateRESTServiceProxyConfigFile) {
      lLog.info("Generate REST Service Default Config File:        " + generateRESTServiceProxyConfigFile);
    }
    if (generateActivityInterfaces) {
      lLog.info("Generate Activity Interfaces:                     " + generateActivityInterfaces);
    }
    if (generateActivityImpls) {
      lLog.info("Generate Activity Impls:                          " + generateActivityImpls);
    }
    if (generatePOJOs) {
      lLog.info("Generate POJO's:                                  " + generatePOJOs);
      lLog.info("Make POJO's serializable:                         " + makePOJOsSerializable);
      lLog.info("Make POJO's immutable:                            " + generateImmutableClasses);

      if (generateHeavyExtensibleEnums) {
        lLog.info("Generate heavy style extensible enums:            " + generateHeavyExtensibleEnums);
      }
      lLog.info("Generate Constants for Attribute Names:           " + generateConstantsForAttributeNames);
      lLog.info("Generate of(...):                                 " + generateOfOperation);
      lLog.info("Generate valueOf(...) for OpenAPI Data Types:     " + generateValueOfForOpenAPIDataTypes);
    }

    if (generateEqualsAndHashCode) {
      lLog.info("Generate equals() and hashCode():                 " + generateEqualsAndHashCode);
    }
    if (generateEqualsAndHashCodeForStandardClasses) {
      lLog.info("Generate equals() and hashCode() for 'normal'     ");
      lLog.info("classes:                                          " + generateEqualsAndHashCodeForStandardClasses);
    }
    if (generateEqualsAndHashCodeForCompositeDataTypes) {
      lLog.info("Generate equals() and hashCode() for composite");
      lLog.info("data types:                                       " + generateEqualsAndHashCodeForCompositeDataTypes);
    }
    if (generateEqualsAndHashCodeForOpenAPIDataTypes) {
      lLog.info("Generate equals() and hashCode() for OpenAPI");
      lLog.info("data types:                                       " + generateEqualsAndHashCodeForOpenAPIDataTypes);
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

    if (generateTypesReport) {
      lLog.info(" ");
      lLog.info("Generate Types Report                             " + generateTypesReport);
      lLog.info("Types Report Name                                 " + typesReportName);
      lLog.info("Types Report File Name                            " + typesReportFileName
          + deprecationReportFormat.getExtension());
      lLog.info("Types Report Stereotypes                          " + typesReportStereotypes);
      lLog.info("Types Report Show Alias                           " + typesReportShowAlias);
      lLog.info("Types Report Alias Row Name                       " + typesReportAliasRowName);
      lLog.info("Types Report Show Package                         " + typesReportShowPackage);
      lLog.info("Types Report Show Properties                      " + typesReportShowProperties);
      lLog.info("Types Report Group by Package                     " + typesReportGroupByPackage);
      lLog.info(" ");
    }

    if (generateBreakingChangesReport) {
      lLog.info("Generate Breaking Changes Report                  " + generateBreakingChangesReport);
      lLog.info("Breaking Changes Report Name                      " + breakingChangesReportName);
      lLog.info("Breaking Changes Report File Name                 " + breakingChangesReportFileName
          + deprecationReportFormat.getExtension());
      lLog.info("Breaking Changes Group by Package                 " + breakingChangesReportGroupByPackage);
      lLog.info(" ");
    }

    if (generateRESTDeprecationReport) {
      lLog.info("Generate REST Deprecation Report                  " + generateRESTDeprecationReport);
      lLog.info("REST Deprecation Report Name                      " + restDeprecationReportName);
      lLog.info("REST Deprecation Report File Name                 " + restDeprecationReportFileName
          + deprecationReportFormat.getExtension());
      lLog.info("REST Deprecation Report Format                    " + deprecationReportFormat);
      lLog.info(" ");
    }

    if (generateJavaDeprecationReport) {
      lLog.info("Generate Java Deprecation Report                  " + generateJavaDeprecationReport);
      lLog.info("Java Deprecation Report Name                      " + javaDeprecationReportName);
      lLog.info("Java Deprecation Report File Name                 " + javaDeprecationReportFileName
          + deprecationReportFormat.getExtension());
      lLog.info("Java Deprecation Report Format                    " + deprecationReportFormat);
      lLog.info(" ");
    }

    if (generateSecurityRolesReport) {
      lLog.info("Generate Security Roles Report                    " + generateSecurityRolesReport);
      lLog.info("Security Roles Report Name                        " + securityRolesReportName);
      lLog.info("Security Roles Report File Name                   " + securityRolesReportFileName
          + securityRolesReportFormat.getExtension());
      lLog.info("Security Roles Report Format                      " + securityRolesReportFormat);
    }

    if (generateOpenAPISpec) {
      lLog.info("Generate OpenAPI Specification:                   " + generateOpenAPISpec);
      lLog.info("Validate OpenAPI Specification:                   " + validateOpenAPISpec);
      lLog.info("Disable OpenAPI Dependency Checks:                " + disableOpenAPIDependencyChecks);
      lLog.info("OpenAPI Version:                                  " + openAPIVersion.name());
      lLog.info("OpenAPI Specification file extensions:            " + openAPIExtensions.toString());
      lLog.info("Enable YAML 1.1 compatibility mode:               " + enableYAML11Compatibility);
      lLog.info("OpenAPI YAML multi-line comment style:            " + openAPICommentStyle);

      if (openAPIContactName.isEmpty() == false) {
        lLog.info("OpenAPI Contact Name:                             " + openAPIContactName);
      }
      if (openAPIContactURL.isEmpty() == false) {
        lLog.info("OpenAPI Contact URL:                              " + openAPIContactURL);
      }
      if (openAPIContactEmail.isEmpty() == false) {
        lLog.info("OpenAPI Contact EMail:                            " + openAPIContactEmail);
      }
      if (openAPILicenseName.isEmpty() == false) {
        lLog.info("OpenAPI License Name:                             " + openAPILicenseName);
      }
      if (openAPILicenseURL.isEmpty() == false) {
        lLog.info("OpenAPI License URL:                              " + openAPILicenseURL);
      }
      if (openAPITermsOfUseURL.isEmpty() == false) {
        lLog.info("OpenAPI Terms of Use URL:                         " + openAPITermsOfUseURL);
      }

      lLog.info("Add ignored header fields to OpenAPI spec:        " + addIgnoredHeadersToOpenAPISpec);
    }

    if (generateOpenAPISpec || generateRESTResources || generateRESTServiceProxies)

    {
      lLog.info("REST default success status code:                 " + restDefaultSuccessStatusCode);
      lLog.info("REST default success void status code:            " + restDefaultVoidStatusCode);
    }

    if (suppressTechnicalHeaders) {
      lLog.info("Suppress technical http headers:                  " + suppressTechnicalHeaders);
    }

    if (generateJAXRSAnnotations) {
      lLog.info("Generate JAX-RS annotations:                      " + generateJAXRSAnnotations);
    }
    if (generateJacksonAnnotations) {
      lLog.info("Generate Jackson annotations:                     " + generateJacksonAnnotations);
      lLog.info("Generate @JsonAutoDetect on class:                " + generateJSONAutoDetectAnnotationOnClass);
      lLog.info("Enable SemVer for JSON serialization:             " + enableSemVerForJSON);
    }

    if (generateJSONSerializers) {
      lLog.info("Generate JSON serializers:                        " + generateJSONSerializers);
    }

    if (javaGenericSoftLinkType.isEmpty() == false) {
      lLog.info("Java generic soft link type:                      " + javaGenericSoftLinkType);
    }

    if (openAPIGenericSoftLinkType.isEmpty() == false) {
      lLog.info("OpenAPI generic soft link type:                   " + openAPIGenericSoftLinkType);
    }

    if (softLinkSuffix.isEmpty() == false) {
      lLog.info("Soft link suffix:                                 " + softLinkSuffix);
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
      lLog.info("Generate @Valid annotation  for classes:          " + generateValidAnnotationForClasses);
      lLog.warn(
          "Please remove 'generateValidAnnotationForClasses' from your configuration. This flag will not be supported in the near future as it is not really required.");
    }

    if (generateValidAnnotationForAssociations) {
      lLog.info("Generate @Valid annotation for associations:      " + generateValidAnnotationForAssociations);
    }

    if (generateValidationAnnotationsForAttributesFromMultiplicity) {
      lLog.info("Generate Validation Annotations for attributes:   "
          + generateValidationAnnotationsForAttributesFromMultiplicity);
    }
    if (generateValidationAnnotationsForAssociationsFromMultiplicity) {
      lLog.info("Generate Validation Annotations for associations: "
          + generateValidationAnnotationsForAssociationsFromMultiplicity);
    }
    if (generateObjectValidationInBuilder) {
      lLog.info("Add object validation to builders:                " + generateObjectValidationInBuilder);
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

    if (generatePublicObjectView) {
      lLog.info("Generate public view for POJO's / ServiceObjects: " + generatePublicObjectView);
    }

    if (useArraysOnlyForPrimitives) {
      lLog.info("Use arrays for primitives only:                   " + useArraysOnlyForPrimitives);
    }

    // Print information about immutability behavior
    if (disableImmutabilityOfCollections) {
      lLog.info("Disable immutability for collections:             " + disableImmutabilityOfCollections);
    }
    if (disableImmutabilityOfArrays) {
      lLog.info("Disable immutability for non-binary arrays:       " + disableImmutabilityOfArrays);
    }
    if (disableImmutabilityOfBinaryData) {
      lLog.info("Disable immutability for binary arrays:           " + disableImmutabilityOfBinaryData);
    }

    if (enableLegacyBuilderStyle) {
      lLog.info("Enable legacy builder style:                      " + enableLegacyBuilderStyle);
    }

    if (generateBuilderWithAllMandatoryFields) {
      lLog.info("Generate builder with all manadatory fields:      " + generateBuilderWithAllMandatoryFields);
    }

    if (enableDetailedToStringMethod) {
      lLog.info("Enable detailed toString():                       " + enableDetailedToStringMethod);
    }

    if (enforceCustomTemplateExecution) {
      lLog.info(" ");
      lLog.info("Enforce custom root template execution:           " + enforceCustomTemplateExecution);
    }

    if (customRootTemplate.equals(DEFAULT_CUSTOM_ROOT) == false) {
      lLog.info(" ");
      lLog.info("Custom Root Template:                             " + customRootTemplate);
      if (customTemplateParameters != null && customTemplateParameters.isEmpty() == false) {
        lLog.info("Custom Template Parameters:                       ");
        for (Entry<String, String> lNext : customTemplateParameters.entrySet()) {
          lLog.info("                                                  \"" + lNext.getKey() + "\":\"" + lNext.getValue()
              + "\"");
        }
      }
    }

    lLog.info(" ");
    lLog.info("Javadoc Company Tag:                              " + fileHeaderCompany);
    lLog.info("Javadoc Author Tag:                               " + fileHeaderAuthor);
    lLog.info("Javadoc Copyright Tag:                            " + fileHeaderCopyright);
    lLog.info("Javadoc Version Tag:                              " + fileHeaderVersion);
    lLog.info(" ");

    lLog.info("Java formatter stylesheet:                        " + javaFormatterStyleFile);
    lLog.info("XML formatter stylesheet:                         " + xmlFormatterStyleFile);
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
    if (cleanSourceTestGen == true) {
      this.getLog().info("Cleaning src-tes-gen directory '" + sourceTestGenDirectory + "'.");
      lFileTools.tryDeleteRecursive(sourceTestGenDirectory, true);
      lFileTools.createDirectory(sourceTestGenDirectory);
    }
    if (cleanResourceTestGen == true) {
      this.getLog().info("Cleaning res-test-gen directory '" + resourceTestGenDirectory + "'.");
      lFileTools.tryDeleteRecursive(resourceTestGenDirectory, true);
      lFileTools.createDirectory(resourceTestGenDirectory);
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
      System.setProperty("switch.gen.rest.security.useDeprecatedSpringSecuredAnnotation",
          useDeprecatedSpringSecuredAnnotation.toString());
      System.setProperty("switch.gen.rest.security.annotation", generateSecurityAnnotation.toString());
      System.setProperty("switch.gen.rest.validation.request", generateRESTRequestValidation.toString());
      System.setProperty("switch.gen.rest.validation.response", generateRESTResponseValidation.toString());
      System.setProperty("switch.gen.rest.filter.custom.headers", filterCustomHeaders.toString());
      System.setProperty("switch.gen.rest.path.prefix", restPathPrefix);
      System.setProperty("switch.gen.rest.service.proxy", generateRESTServiceProxies.toString());
      System.setProperty("switch.gen.rest.service.proxy.config.file", generateRESTServiceProxyConfigFile.toString());
      System.setProperty("switch.gen.service.objects", generateServiceObjects.toString());
      System.setProperty("switch.gen.exception.classes", generateExceptionClasses.toString());
      System.setProperty("switch.gen.pojos", generatePOJOs.toString());

      System.setProperty("switch.gen.equalsAndHashCode.all", generateEqualsAndHashCode.toString());
      System.setProperty("switch.gen.equalsAndHashCode.standard",
          generateEqualsAndHashCodeForStandardClasses.toString());
      System.setProperty("switch.gen.equalsAndHashCode.composite.datatype",
          generateEqualsAndHashCodeForCompositeDataTypes.toString());
      System.setProperty("switch.gen.equalsAndHashCode.openapi.datatype",
          generateEqualsAndHashCodeForOpenAPIDataTypes.toString());

      System.setProperty("switch.gen.immutable.classes", generateImmutableClasses.toString());
      System.setProperty("switch.gen.serializable.pojos", makePOJOsSerializable.toString());
      System.setProperty("switch.gen.heavy.extensible.enums", generateHeavyExtensibleEnums.toString());
      System.setProperty("switch.gen.domain.objects", generateDomainObjects.toString());
      System.setProperty("switch.gen.junits", generateJUnitTests.toString());

      System.setProperty("switch.gen.types.report", generateTypesReport.toString());
      System.setProperty("switch.gen.types.report.name", typesReportName.toString());
      System.setProperty("switch.gen.types.report.filename", typesReportFileName.toString());
      System.setProperty("switch.gen.types.report.showAlias", typesReportShowAlias.toString());
      System.setProperty("switch.gen.types.report.aliasRowName", typesReportAliasRowName);
      System.setProperty("switch.gen.types.report.showPackage", typesReportShowPackage.toString());
      System.setProperty("switch.gen.types.report.showProperties", typesReportShowProperties.toString());
      System.setProperty("switch.gen.types.report.groupByPackage", typesReportGroupByPackage.toString());
      System.setProperty("switch.gen.types.report.stereotypes", typesReportStereotypes);

      System.setProperty("switch.gen.breaking.changes.report", generateBreakingChangesReport.toString());
      System.setProperty("switch.gen.breaking.changes.report.name", breakingChangesReportName.toString());
      System.setProperty("switch.gen.breaking.changes.report.filename", breakingChangesReportFileName.toString());
      System.setProperty("switch.gen.breaking.changes.report.groupByPackage",
          breakingChangesReportGroupByPackage.toString());

      System.setProperty("switch.gen.rest.deprecation.report", generateRESTDeprecationReport.toString());
      System.setProperty("switch.gen.rest.deprecation.report.name", restDeprecationReportName.toString());
      System.setProperty("switch.gen.rest.deprecation.report.filename", restDeprecationReportFileName.toString());

      System.setProperty("switch.gen.java.deprecation.report", generateJavaDeprecationReport.toString());
      System.setProperty("switch.gen.java.deprecation.report.name", javaDeprecationReportName.toString());
      System.setProperty("switch.gen.java.deprecation.report.filename", javaDeprecationReportFileName.toString());

      System.setProperty("switch.gen.deprecation.report.format", deprecationReportFormat.name());

      System.setProperty("switch.gen.security.roles.report", generateSecurityRolesReport.toString());
      System.setProperty("switch.gen.security.roles.report.name", securityRolesReportName.toString());
      System.setProperty("switch.gen.security.roles.report.filename", securityRolesReportFileName.toString());
      System.setProperty("switch.gen.security.roles.report.format", securityRolesReportFormat.name());

      System.setProperty("switch.gen.openapispec", generateOpenAPISpec.toString());
      System.setProperty("switch.gen.openapi.checkOpenAPIDependencies",
          Boolean.toString(!disableOpenAPIDependencyChecks));
      System.setProperty("switch.gen.openapi.version", openAPIVersion.name());
      System.setProperty("switch.gen.openapi.yaml.11.comapitibility", enableYAML11Compatibility.toString());
      System.setProperty("switch.gen.openapi.openAPICommentStyle", openAPICommentStyle.toString());

      System.setProperty("switch.gen.openapi.openAPIContactName", openAPIContactName.toString());
      System.setProperty("switch.gen.openapi.openAPIContactURL", openAPIContactURL.toString());
      System.setProperty("switch.gen.openapi.openAPIContactEmail", openAPIContactEmail.toString());
      System.setProperty("switch.gen.openapi.openAPILicenseName", openAPILicenseName.toString());
      System.setProperty("switch.gen.openapi.openAPILicenseURL", openAPILicenseURL.toString());
      System.setProperty("switch.gen.openapi.openAPITermsOfUseURL", openAPITermsOfUseURL.toString());

      System.setProperty("switch.gen.rest.suppress.technical.headers", suppressTechnicalHeaders.toString());
      System.setProperty("switch.gen.openapi.addIgnoredHeadersToOpenAPISpec",
          addIgnoredHeadersToOpenAPISpec.toString());

      System.setProperty("switch.gen.jaxrs.annotations", generateJAXRSAnnotations.toString());
      System.setProperty("switch.gen.jackson.annotations", generateJacksonAnnotations.toString());
      System.setProperty("switch.gen.jackson.jsonautodetect.on.class",
          generateJSONAutoDetectAnnotationOnClass.toString());
      System.setProperty("switch.gen.enable.json.semver", enableSemVerForJSON.toString());
      System.setProperty("switch.gen.json.serializers", generateJSONSerializers.toString());
      System.setProperty("switch.gen.enable.name.constants", generateConstantsForAttributeNames.toString());
      System.setProperty("switch.gen.target.runtime", targetRuntime.name());
      System.setProperty("switch.gen.enterprise.java", enterpriseJavaType.name());
      if (restLibrary != null) {
        System.setProperty("switch.gen.target.rest.library", restLibrary.name());
      }
      if (restDefaultSuccessStatusCode.length() > 0) {
        System.setProperty("switch.gen.target.rest.success.status.code", restDefaultSuccessStatusCode.toString());
      }
      if (restDefaultVoidStatusCode.length() > 0) {
        System.setProperty("switch.gen.target.rest.void.status.code", restDefaultVoidStatusCode.toString());
      }

      System.setProperty("switch.gen.of.operation", generateOfOperation.toString());
      System.setProperty("switch.gen.of.operation.openapi.datatype", generateOfOperationForOpenAPIDataType.toString());
      System.setProperty("switch.gen.value.of.data.types", generateValueOfForOpenAPIDataTypes.toString());

      System.setProperty("switch.gen.java.generic.soft.link.type", javaGenericSoftLinkType);
      System.setProperty("switch.gen.openapi.generic.soft.link.type", openAPIGenericSoftLinkType);
      System.setProperty("switch.gen.openapi.generic.soft.link.suffix", softLinkSuffix);

      System.setProperty("switch.gen.suppress.warnings", suppressWarnings.stream().collect(Collectors.joining("; ")));
      System.setProperty("switch.gen.suppress.all.warnings", suppressAllWarnings.toString());
      System.setProperty("switch.gen.add.generated.annotation", addGeneratedAnnotation.toString());
      System.setProperty("switch.gen.add.generation.timestamp", addGenerationTimestamp.toString());
      System.setProperty("switch.gen.generation.comment", generationComment.toString());

      System.setProperty("switch.gen.suppress.classname.openapi", suppressClassNameCommentInOpenAPISpec.toString());

      System.setProperty("switch.gen.enable.valid.annotation.classes", generateValidAnnotationForClasses.toString());
      System.setProperty("switch.gen.enable.valid.annotation.associations",
          generateValidAnnotationForAssociations.toString());

      System.setProperty("switch.gen.enable.validation.annotation.attributes",
          generateValidationAnnotationsForAttributesFromMultiplicity.toString());
      System.setProperty("switch.gen.enable.validation.annotation.associations",
          generateValidationAnnotationsForAssociationsFromMultiplicity.toString());

      System.setProperty("switch.gen.enable.validation.in.builder", generateObjectValidationInBuilder.toString());

      System.setProperty("switch.gen.public.setters.for.associations", generatePublicSettersForAssociations.toString());
      System.setProperty("switch.gen.null.checks.for.to.one.associations.of.service.objects",
          generateNullChecksForToOneAssociations.toString());

      System.setProperty("switch.gen.public.object.view", generatePublicObjectView.toString());

      System.setProperty("switch.gen.arrays.for.primitives.only", useArraysOnlyForPrimitives.toString());

      System.setProperty("switch.gen.disable.collection.immutability", disableImmutabilityOfCollections.toString());
      System.setProperty("switch.gen.disable.array.immutability", disableImmutabilityOfArrays.toString());
      System.setProperty("switch.gen.disable.binary.data.immutability", disableImmutabilityOfBinaryData.toString());

      System.setProperty("switch.gen.enable.detailed.toString", enableDetailedToStringMethod.toString());
      System.setProperty("switch.gen.enable.legacy.builder.style", enableLegacyBuilderStyle.toString());
      System.setProperty("switch.gen.enable.builder.for.manadatory.fields",
          generateBuilderWithAllMandatoryFields.toString());

      System.setProperty("name.oid.row", peristentObjectsOIDRowName);
      System.setProperty("name.version.label.row", peristentObjectsVersionLabelRowName);

      // Add parameters for custom templates also as system properties.
      if (customTemplateParameters != null) {
        for (Entry<String, String> lNext : customTemplateParameters.entrySet()) {
          if (lNext.getValue() != null) {
            System.setProperty(lNext.getKey(), lNext.getValue());
          }
        }
      }

      String lXMIDirectory = this.getXMIDirectoryLocation();

      // Check if UML model file and profile file exist
      String lModelFilePath = lXMIDirectory + "/" + umlModelFile;
      File lModelFile = new File(lModelFilePath);
      String lProfileFilePath = lXMIDirectory + "/" + jmmProfileFile;
      File lProfileFile = new File(lProfileFilePath);

      File lCustomProfileFile;
      String lCustomProfileFilePath;
      if (customProfileFile != null && customProfileFile.trim().isEmpty() == false) {
        lCustomProfileFilePath = lXMIDirectory + "/" + customProfileFile;
        lCustomProfileFile = new File(lCustomProfileFilePath);
      }
      else {
        lCustomProfileFilePath = null;
        lCustomProfileFile = null;
      }

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
      // Custom profile does not exist
      if (lCustomProfileFile != null && lCustomProfileFile.exists() == false) {
        throw new MojoFailureException("Custom profile file " + lCustomProfileFilePath
            + " does not exist. Please make sure that the path to your custom UML profile file is correct.");
      }
      // Model file and profile file both exist, so we can really start the generation process.
      else {
        // Build arguments for generator
        HashMap<String, String> lParams = new HashMap<>();
        lParams.put("template.root", "Root::Root");
        lParams.put("custom.root.template", customRootTemplate);
        lParams.put("output.slot", "model");
        lParams.put("model.file", lModelFilePath);
        lParams.put("profile.name", "JMM");
        lParams.put("profile.file", lProfileFilePath);
        if (lCustomProfileFile != null) {
          lParams.put("customprofile.file", lCustomProfileFilePath);
        }
        else {
          lParams.put("customprofile.file", lProfileFilePath);
        }
        lParams.put("path.src.gen", sourceGenDirectory);
        lParams.put("path.src", sourceDirectory);
        lParams.put("path.res.gen", resourceGenDirectory);
        lParams.put("path.res", resourceDirectory);
        lParams.put("path.src.test.gen", sourceTestGenDirectory);
        lParams.put("path.src.test", sourceTestDirectory);
        lParams.put("path.res.test.gen", resourceTestGenDirectory);
        lParams.put("path.res.test", resourceTestDirectory);

        // Execute oAW Workflow Runner. This will cause the UML generation to be executed.
        this.getLog().info("Starting code generation from UML model " + umlModelFile);
        WorkflowRunner lRunner = new WorkflowRunner();
        lSuccessful = lRunner.run("workflow.oaw", null, lParams, null);
      }
    }
    else

    {
      lSuccessful = true;
    }
    return lSuccessful;
  }

  private void preCheckXMIFiles( List<String> pUMLFiles ) throws MojoFailureException {
    for (String lNextFile : pUMLFiles) {
      try {
        String lStartOfFile = FileTools.getFileTools().readLinesAsString(lNextFile, 0, 5);
        if (lStartOfFile.contains("file:/")) {
          this.getLog().warn("Warning: [9102] " + lNextFile
              + " seems to use file system references. This might lead to portabilty issues with the exported XMI files. For further details please refer to FAQ entry #2.1 on https://anaptecs.atlassian.net/l/cp/ndmtZxvX");
        }
      }
      catch (IOException e) {
        this.getLog().error(e.getMessage());
      }
    }
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

    // Do some pre checks on XMI files to avoid trouble during code generation
    this.preCheckXMIFiles(lUMLFiles);

    // Fix all XMI files
    if (umlModelingTool != ModelingTool.MAGIC_DRAW) {
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
    if (umlModelingTool != ModelingTool.MAGIC_DRAW) {
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
    String lExtractDirectory = mavenProject.getBuild().getDirectory() + "/uml-model";
    String lXMIDirectory;
    StringTools lTools = Tools.getStringTools();
    if (lTools.isRealString(xmiDirectory)) {
      if (umlModelingTool == ModelingTool.MAGIC_DRAW) {
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
      if (umlModelingTool != ModelingTool.MAGIC_DRAW) {
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
        Artifact lModelArtifact = mavenProject.getArtifactMap().get(lKey);
        if (lModelArtifact != null) {
          Assert.assertNotNull(lModelArtifact, "Model artifact not availble.");
          String lFilePath = lModelArtifact.getFile().getCanonicalPath();
          String lExtractDirectory = mavenProject.getBuild().getDirectory() + "/uml-model";
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
        | generateRESTServiceProxies | generateRESTServiceProxyConfigFile | generateActivityInterfaces
        | generateActivityImpls | generateServiceObjects | generatePOJOs | generateDomainObjects | generateObjectMappers
        | generatePersistentObjects | generateComponentImpls | generateComponentRuntimeClasses | generateGlobalParts
        | generateExceptionClasses | generateJUnitTests | generateTypesReport | generateBreakingChangesReport
        | generateRESTDeprecationReport | generateJavaDeprecationReport | generateOpenAPISpec | generateJSONSerializers
        | enforceCustomTemplateExecution;
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
      Plugin lFormatterPlugin = plugin("net.revelc.code.formatter", "formatter-maven-plugin", "2.23.0", lDependencies);
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
    Plugin lFormatterPlugin = plugin("net.revelc.code", "impsort-maven-plugin", "1.9.0");
    String lFormatterGoal = goal("sort");
    Xpp3Dom lFormatterConfiguration =
        configuration(element("groups", importGroups), element("staticGroups", staticImportGroups),
            element("removeUnused", Boolean.toString(removeUnusedImports)), this.createDirectoryElementConfiguration());

    ExecutionEnvironment lExecutionEnvironment = executionEnvironment(mavenProject, mavenSession, pluginManager);
    executeMojo(lFormatterPlugin, lFormatterGoal, lFormatterConfiguration, lExecutionEnvironment);
  }

  /**
   * Method copies all declared dependent openAPI specs to res-gen directory.
   * 
   * @throws MojoExecutionException
   */
  private void copyOpenAPISpecDependencies( ) throws MojoExecutionException {
    this.getLog().info("Copying dependent OpenAPI specs.");
    if (openAPISpecDependencies.isEmpty() == false) {
      Plugin lDependencyPlugin = plugin("org.apache.maven.plugins", "maven-dependency-plugin");
      String lUnpackGoal = goal("unpack");

      // Create elements for spec dependencies.
      List<Element> lElements = new ArrayList<>();
      for (Dependency lNext : openAPISpecDependencies) {
        lElements.add(element("artifactItem", element("groupId", lNext.getGroupId()),
            element("artifactId", lNext.getArtifactId()), element("outputDirectory", resourceGenDirectory)));
      }
      Element[] lDependencyElements = lElements.toArray(new Element[] {});

      StringJoiner lJoiner = new StringJoiner(",");
      for (String lExtension : openAPIExtensions) {
        StringBuilder lBuilder = new StringBuilder();
        lBuilder.append("**/");
        if (lExtension.startsWith("*") == false) {
          lBuilder.append("*");
        }
        lBuilder.append(lExtension);
        lJoiner.add(lBuilder.toString());
      }
      String lIncludes = lJoiner.toString();

      Xpp3Dom lConfiguration =
          configuration(element("artifactItems", lDependencyElements), element("includes", lIncludes));

      ExecutionEnvironment lExecutionEnvironment = executionEnvironment(mavenProject, mavenSession, pluginManager);
      executeMojo(lDependencyPlugin, lUnpackGoal, lConfiguration, lExecutionEnvironment);
    }
    else {
      this.getLog().info("No dependent OpenAPI specs defined.");
    }
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
          element("directories", element("directory", sourceGenDirectory), element("directory", resourceGenDirectory),
              element("directory", sourceTestGenDirectory), element("directory", resourceTestGenDirectory));
    }
    else if (disableSourceFormatting == true) {
      lElement = element("directories", element("directory", resourceGenDirectory),
          element("directory", resourceTestGenDirectory));
    }
    else if (disableResourceFormatting == true) {
      lElement = element("directories", element("directory", sourceGenDirectory),
          element("directory", sourceTestGenDirectory));
    }
    else {
      lElement = null;
      Assert.internalError("Method must not be called if formatting is disabled completely.");
    }
    return lElement;
  }

  private void validateOpenAPISpec( ) throws MojoExecutionException {
    this.getLog().info("");
    List<String> lInvalidSpecs = new ArrayList<>();
    try {
      // Copy dependent OpenAPI specs
      this.copyOpenAPISpecDependencies();

      // Run validation
      for (String lNextOpenAPISpec : this.resolveOpenAPISpecs(resourceGenDirectory)) {
        this.getLog().info("");
        this.getLog().info("Validating OpenAPI specification " + lNextOpenAPISpec);

        // Validate OpenAPI spec.
        List<String> lErrorMessages = this.validateOpenAPISpec(lNextOpenAPISpec);

        if (lErrorMessages.isEmpty() == false) {
          lInvalidSpecs.add(lNextOpenAPISpec);
        }
        else {
          this.getLog().info("No issues detected.");
        }

        // Trace error message.
        for (String lNextMessage : lErrorMessages) {
          this.getLog().error(lNextMessage);
        }
      }
    }
    catch (IOException e) {
      throw new MojoExecutionException(
          "Unable to search for OpenAPI specifications in directory " + resourceGenDirectory, e);
    }

    if (lInvalidSpecs.isEmpty() == false) {
      throw new MojoExecutionException("Validation of the following OpenAPI specification(s) failed: "
          + Arrays.toString(lInvalidSpecs.toArray()) + "\nPlease check error messages above for more details.");
    }
  }

  private List<String> validateOpenAPISpec( String pFileName ) {
    ParseOptions lOptions = new ParseOptions();
    lOptions.setResolve(true);

    // Workaround for https://github.com/OpenAPITools/openapi-generator/issues/14648
    SwaggerParseResult lResult =
        new OpenAPIParser().readLocation(pFileName.replaceAll("\\\\", "/"), (List<AuthorizationValue>) null, lOptions);

    List<String> lErrorMessages;
    if (lResult == null) {
      lErrorMessages = List.of("Parsing of OpenAPI Specification in file " + pFileName + " failed for unknown reason.");
    }
    else {
      lErrorMessages = lResult.getMessages();
    }
    return lErrorMessages;
  }

  private List<String> resolveOpenAPISpecs( String pDirectory ) throws IOException {
    FilenameFilter lFilter = FileTools.getFileTools().createExtensionFilenameFilter(List.of("*.yaml", "*.yml"), null);
    return this.resolveFiles(pDirectory, lFilter);
  }

  private List<String> resolveFiles( String pDirectory, FilenameFilter pFilter ) throws IOException {
    List<String> lFiles = FileTools.getFileTools().listFiles(pDirectory, pFilter);
    for (File lNextFile : FileTools.getFileTools().listFiles(new File(pDirectory))) {
      if (lNextFile.isDirectory()) {
        lFiles.addAll(this.resolveFiles(lNextFile.getCanonicalPath(), pFilter));
      }
    }
    return lFiles;
  }
}
