package com.anaptecs.jeaf.fwk.generator.util.maven;

import java.util.HashMap;
import java.util.Map;

public class ArtifactCache {
	private static final Map<String, String> dependencyVersionCache = new HashMap<String, String>();

	public static void addArtifactVersion(String pProjectID, String pVersion) {
		dependencyVersionCache.put(pProjectID, pVersion);
	}

	public static String getArtifactVersion(String pProjectID) {
		return dependencyVersionCache.get(pProjectID);
	}
}
