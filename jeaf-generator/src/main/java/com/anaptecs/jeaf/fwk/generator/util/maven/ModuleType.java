package com.anaptecs.jeaf.fwk.generator.util.maven;

public enum ModuleType {
	POM("POM", "POM", ""),

	BOM("BOM", "BOM", "bom"),

	OPEN_API("OpenAPI", "OpenAPI", "open-api"),

	JAVA("Java", "Java", "java"),

	JAVA_RUNTIME("Java Runtime", "JavaRuntime", "java-runtime"),

	JAVA_STARTER("Java Starter", "JavaStarter", "java-starter"),

	SERVICES("Services", "Services", "services"),

	REST_CLIENT("REST Client", "RESTClient", "rest-client"),

	REST_CLIENT_STARTER("REST Client Starter", "RESTClientStarter",
			"rest-client-starter"),

	REST_CONTROLLER("REST Controller", "RESTController", "rest-controller"),

	REST_CONTROLLER_STARTER("REST Controller Starter", "RESTControllerStarter",
			"rest-controller-starter"),

	INTEGRATION_TEST("Integration Test", "IntegrationTest", "integration-test"),

	CUSTOM("Custom", "Custom", "");

	private final String name;
	private final String javaSuffx;
	private final String mavenSuffix;

	private ModuleType(String name, String javaSuffx, String mavenSuffix) {
		this.name = name;
		this.javaSuffx = javaSuffx;
		this.mavenSuffix = mavenSuffix;
	}

	public static String getModuleName(String pProjectName, String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectName + " " + lModuleType.name;
	}

	public static String getJavaName(String pProjectJavaName,
			String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectJavaName + "-" + lModuleType.javaSuffx;
	}

	public static String getArtifactId(String pProjectArtifactId,
			String pLiteralName) {
		ModuleType lModuleType = ModuleType.valueOf(pLiteralName);
		return pProjectArtifactId + "-" + lModuleType.mavenSuffix;
	}
}
