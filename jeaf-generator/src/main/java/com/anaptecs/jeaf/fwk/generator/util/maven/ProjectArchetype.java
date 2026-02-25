package com.anaptecs.jeaf.fwk.generator.util.maven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum ProjectArchetype {
	GENERATOR_PROJECT_PARENT_POM("Generator Project Parent POM", "Parent", "parent", new ModuleType[] {}),

	DOMAIN("Domain", "Domain", "domain", new ModuleType[] {}),

	DATA_TYPES("Data Types", "DataTypes", "datatypes", new ModuleType[] { ModuleType.BOM, ModuleType.UML_MODEL,
			ModuleType.OPEN_API, ModuleType.JAVA, ModuleType.JAVA_RUNTIME, ModuleType.JAVA_STARTER,
			ModuleType.INTEGRATION_TEST }),

	SERVICE_MODEL("Service Model", "ServiceModel", "servicemodel", new ModuleType[] { ModuleType.BOM,
			ModuleType.UML_MODEL, ModuleType.OPEN_API, ModuleType.JAVA, ModuleType.JAVA_RUNTIME, ModuleType.SERVICES,
			ModuleType.REST_CLIENT, ModuleType.REST_CLIENT_STARTER, ModuleType.REST_CONTROLLER,
			ModuleType.REST_CONTROLLER_STARTER, ModuleType.INTEGRATION_TEST }),

	MASTER_DATA("Master Data", "MasterData", "masterdata", new ModuleType[] { ModuleType.BOM, ModuleType.UML_MODEL,
			ModuleType.OPEN_API, ModuleType.JAVA, ModuleType.JAVA_RUNTIME, ModuleType.JAVA_STARTER,
			ModuleType.INTEGRATION_TEST }),

	EVENTS("Events", "Events", "events", new ModuleType[] { ModuleType.BOM, ModuleType.UML_MODEL, ModuleType.OPEN_API,
			ModuleType.JAVA, ModuleType.JAVA_RUNTIME, ModuleType.JAVA_STARTER, ModuleType.INTEGRATION_TEST }),

	IMPLEMENTATION("Implementation", "Impl", "impl", new ModuleType[] {}),

	UML_MODEL_PROJECT("UML Model Project", "", "", new ModuleType[] { ModuleType.UML_MODEL }),

	ARTIFACT("Artifact", "", "", new ModuleType[] {}),

	CUSTOM("Custom", "Custom", "custom", new ModuleType[] {});

	private final String defaultName;
	private final String defaultJavaSuffix;
	private final String defaultMavenSuffix;
	private final List<ModuleType> defaultModules;

	private ProjectArchetype(String name, String javaSuffix, String mavenSuffix, ModuleType[] pModules) {
		defaultName = name;
		defaultJavaSuffix = javaSuffix;
		defaultMavenSuffix = mavenSuffix;
		defaultModules = new ArrayList<ModuleType>();
		Collections.addAll(defaultModules, pModules);
	}

	public String getDefaultName() {
		return defaultName;
	}

	public String getDefaultJavaSuffix() {
		return defaultJavaSuffix;
	}

	public String getDefaultMavenSuffix() {
		return defaultMavenSuffix;
	}

	public static String getName(String pLiteralName) {
		return ProjectArchetype.valueOf(pLiteralName).getDefaultName();
	}

	public static String getJavaSuffix(String pLiteralName) {
		return ProjectArchetype.valueOf(pLiteralName).getDefaultJavaSuffix();
	}

	public static String getMavenSuffix(String pLiteralName) {
		return ProjectArchetype.valueOf(pLiteralName).getDefaultMavenSuffix();
	}

	public static List<String> getModuleTypeNames(String pLiteralName) {
		ProjectArchetype lArchetype = ProjectArchetype.valueOf(pLiteralName);
		List<String> lModuleNames = new ArrayList<String>();
		for (ModuleType lNext : lArchetype.defaultModules) {
			lModuleNames.add(lNext.name());
		}
		return lModuleNames;
	}
}
