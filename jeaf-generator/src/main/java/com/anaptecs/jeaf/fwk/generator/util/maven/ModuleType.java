package com.anaptecs.jeaf.fwk.generator.util.maven;

import java.util.HashMap;
import java.util.Map;

public enum ModuleType {
	POM("POM", "POM", "", "pom"),

	BOM("BOM", "BOM", "bom", "pom"),

	UML_MODEL("UML Model", "UMLModel", "uml", "zip"),

	OPEN_API("OpenAPI", "OpenAPI", "open-api", "zip"),

	JAVA("Java", "Java", "java", "jar"),

	JAVA_RUNTIME("Java Runtime", "JavaRuntime", "java-runtime", "jar"),

	JAVA_STARTER("Starter", "Starter", "starter", "jar"),

	SERVICES("Services", "Services", "services", "jar"),

	REST_CLIENT("REST Client", "RESTClient", "rest-client", "jar"),

	REST_CLIENT_STARTER("REST Client Starter", "RESTClientStarter", "rest-client-starter", "jar"),

	REST_CONTROLLER("REST Controller", "RESTController", "rest-controller", "jar"),

	REST_CONTROLLER_STARTER("REST Controller Starter", "RESTControllerStarter", "rest-controller-starter", "jar"),

	INTEGRATION_TEST("Integration Test", "IntegrationTest", "integration-test", "jar"),

	CUSTOM("Custom", "Custom", "", "");

	private static Map<String, ModuleType> targetModulTypes = new HashMap<String, ModuleType>();

	static {
		targetModulTypes.put(getKey(OPEN_API, ModuleDependencyType.OPEN_API_2_OPEN_API), OPEN_API);

		// Java
		targetModulTypes.put(getKey(JAVA, ModuleDependencyType.JAVA_2_JAVA), JAVA);
		targetModulTypes.put(getKey(JAVA_RUNTIME, ModuleDependencyType.JAVA_2_JAVA), JAVA_RUNTIME);
		targetModulTypes.put(getKey(JAVA_STARTER, ModuleDependencyType.JAVA_2_JAVA), JAVA_STARTER);

		targetModulTypes.put(getKey(SERVICES, ModuleDependencyType.SERVICES_2_JAVA), JAVA);
		targetModulTypes.put(getKey(SERVICES, ModuleDependencyType.SERVICES_2_SERVICES), SERVICES);
	}

	private final String humanReadableName;
	private final String javaSuffx;
	private final String mavenSuffix;
	private final String packagingType;

	private ModuleType(String name, String javaSuffx, String mavenSuffix, String packagingType) {
		this.humanReadableName = name;
		this.javaSuffx = javaSuffx;
		this.mavenSuffix = mavenSuffix;
		this.packagingType = packagingType;
	}

	public static String getModuleName(String pProjectName, String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectName + " " + lModuleType.humanReadableName;
	}

	public static String getJavaName(String pProjectJavaName, String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectJavaName + "-" + lModuleType.javaSuffx;
	}

	public static String getArtifactId(String pProjectArtifactId, String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectArtifactId + "-" + lModuleType.mavenSuffix;
	}

	public static String getPackagingType(String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return lModuleType.packagingType;
	}

	public static boolean hasTargetModuleTypeMapping(String pSourceModuleTypeName, String pModuleDependencyTypeName) {
		ModuleType lSourceModuleType = ModuleType.valueOf(pSourceModuleTypeName);
		ModuleDependencyType lModuleDependencyType = ModuleDependencyType.valueOf(pModuleDependencyTypeName);

		return targetModulTypes.containsKey(getKey(lSourceModuleType, lModuleDependencyType));
	}

	public static String getTargetModuleType(String pSourceModuleTypeName, String pModuleDependencyTypeName) {
		ModuleType lSourceModuleType = ModuleType.valueOf(pSourceModuleTypeName);
		ModuleDependencyType lModuleDependencyType = ModuleDependencyType.valueOf(pModuleDependencyTypeName);

		ModuleType lTargetModuleType = targetModulTypes.get(getKey(lSourceModuleType, lModuleDependencyType));
		if (lTargetModuleType != null) {
			return lTargetModuleType.name();
		} else {
			throw new IllegalArgumentException("No source to target type mapping available for '"
					+ pSourceModuleTypeName + "' and '" + pModuleDependencyTypeName + "'.");
		}
	}

	private static String getKey(ModuleType pSourceModuleType, ModuleDependencyType pModuleDependencyType) {
		return pSourceModuleType + ":" + pModuleDependencyType;
	}
}
